import java.util.Scanner;

/*
This sorting technique is more efficient then the earlier one, as in this we move from both the sides
hence we move three steps in one go.
 */

public class Hoare_quicksort {

    public static void display(int[] ar, int r) {
        for (int i = 0; i < r; i++) {
            System.out.print(ar[i] + " ");
        }
    }

    public static void quicksort(int[] ar, int p, int r) {

        if (p < r) {
            int q = hoare_partition(ar, p, r);
            quicksort(ar, p, q);
            quicksort(ar, q + 1, r);

        }
    }

    public static int hoare_partition(int[] ar, int p, int r) {
        int x = ar[p];
        int i = p - 1;
        int j = r + 1;
        while (true) {
            do {
                j = j - 1;
            } while (ar[j] > x); //change here for descending order
            do {
                i = i + 1;
            } while (ar[i] < x); //change here too for descending order
            if (i < j) {
                int temp = ar[i];
                ar[i] = ar[j];
                ar[j] = temp;
            } else {
                return j;
            }
        }

    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size: ");
        int r = sc.nextInt();
        int[] ar = new int[r];
        for (int i = 0; i < r; i++) {
            ar[i] = sc.nextInt();
        }
        quicksort(ar, 0, r - 1);
        display(ar, r);
        //exchange();
    }
}

/*
Note : If we change Hoare’s partition to pick last element as pivot, then the Hoare’s partition
 may cause QuickSort to go into in an infinite recursion. For example, {10, 5, 6, 20} and pivot is arr[high],
then returned index will always be high and call to same QuickSort will be made. To handle a random pivot,
we cam always swap that random element with the first element and simply follow the above algorithm.
 */
