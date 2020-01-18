import java.util.Scanner;

public class QuickSort {
    public static void display(int[] ar, int r) {
        for (int i = 0; i < r; i++) {
            System.out.print(ar[i] + " ");
        }
    }

    public static void quicksort(int[] ar, int p, int r) {

        if (p < r) {
            int q = partition(ar, p, r);
            quicksort(ar, p, q-1);
            quicksort(ar, q + 1, r );

        }
    }

    public static int partition(int[] ar, int p, int r) {
        int x = ar[r];
        int i = p - 1;
        for (int j = p; j < r; j++) {
            if (ar[j] <= x) {
                i = i + 1;
                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
            }
        }
        int temp = ar[i + 1];
        ar[i + 1] = ar[r];
        ar[r] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size: ");
        int r = sc.nextInt();
        int[] ar = new int[r];
        for (int i = 0; i < r; i++) {
            ar[i] = sc.nextInt();
        }
        quicksort(ar, 0, r-1);
        display(ar, r);

    }
}
