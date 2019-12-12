public class CyclicShift {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3};
        int shift = -7;

        int arrLength = arr.length;
        int[] arrCopy = new int[arrLength];
        for (int i = 0; i < arrLength; i++) {
            int x = i + shift;

            x = (x < 0) ? x % arrLength + arrLength : x; //проверка для сдвига вправо
            x = (x >= arrLength) ? x % arrLength : x; //проверка для сдвига влево
            arrCopy[i] = arr[x];
        }

        for (int i :
                arrCopy) {
            System.out.print(i + " ");
        }
    }
}

