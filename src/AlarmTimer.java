import sun.awt.resources.awt;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class AlarmTimer {
    public static void main(String[] args) {
        Alarm obj = new Alarm();
        obj.greet();

        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String[] command = sc.nextLine().split(" ");
            switch (command[0]) {
                case "a":
                    try {
                        obj.checkAlarmArguments(command);
                        obj.setAlarm(command[1]);
                    } catch (Exception e) {
                        obj.greet();
                        e.printStackTrace();
                    }
                    break;
                case "t":
                    try {
                        obj.setTimer(command[1]);
                    } catch (Exception e) {
                        obj.greet();
                    }
                    break;
                case "q":
                    System.exit(0);
                default:
                    obj.greet();
            }
        }
    }

}
class Alarm {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("H:m");
    void checkAlarmArguments(String[] command) {

    }
    void setAlarm(String alarm) {

        LocalTime time = LocalTime.parse(alarm, formatter);
        Duration duration = Duration.between(LocalTime.now(), time);
        if (duration.isNegative()) {
            duration = duration.plusHours(24);
        }
        System.out.println("Будильник установлен на " + alarm);

        try {
            TimeUnit.MINUTES.sleep(duration.toMinutes());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Будильник!!!");
        beep();
    }

    void setTimer(String minutes) {

        LocalTime time = LocalTime.parse(minutes, formatter);
        int waitingTime = time.getMinute();
        System.out.println("Таймер сработает через: " + waitingTime + " минут");
        try {
            TimeUnit.MINUTES.sleep(waitingTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("TIMER!!!");
        beep();
    }

    private LocalTime localTimeNow() {
        return LocalTime.now();
    }

    void greet() {
        System.out.println("Время: " + localTimeNow().format(formatter));
        System.out.println("Чтобы установить будильник: a HH:mm");
        System.out.println("Чтобы устанвить таймер: t HH:mm");
    }

    void beep() {

        Desktop d = Desktop.getDesktop();
        try {
            d.browse(new URI("https://www.youtube.com/watch?v=9knYNjp95bs"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        Toolkit.getDefaultToolkit().beep();
    }
}
