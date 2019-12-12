import java.util.Arrays;

public class LinearSearch {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int k = 6;

        int newLength = array.length + 1;
        int[] aCopy = new int[newLength];
        System.arraycopy(array, 0, aCopy, 0, newLength - 1);
        aCopy[newLength - 1] = k;

        //System.out.println(Arrays.toString(aCopy));

        int i = 0;
        while (aCopy[i] != k) {
            i++;
        }
        int x = (i == newLength - 1) ? -1 : i;
        System.out.println(x);
    }
}
