import java.util.Scanner;

public class Count_sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size: ");
        int size = sc.nextInt();
        int ar[] = new int[size + 1];
        ar[0] = 0;
        for (int i = 1; i < size + 1; i++) {
            ar[i] = sc.nextInt();
        }
        //Since count sort puts the sorted array in a new array we can have a return type, in the same array;
        ar = countSort(ar);
        display(ar);
    }

    public static int maximum(int[] ar, int index) {
        //method to find maximum in the array from a specific index
        int max = ar[index];
        for (int i = 1; i < ar.length; i++) {
            if (ar[i] >= max) {
                max = ar[i];
            }
        }
        return max;
    }

    public static int[] countSort(int ar[]) {
        int tempSize = maximum(ar, 1);
        System.out.println(ar.length);
        int sortedAr[] = new int[ar.length];
        sortedAr[0] = 0;
        int[] tempAr = new int[tempSize + 1]; //tempSize is an element so it should be in the tempAr, so tempSize+1

        for (int i = 1; i < ar.length; i++) {
            tempAr[ar[i]] = tempAr[ar[i]] + 1; //storing the frequency of every number
        }


        for (int i = 1; i <= tempSize; i++) {
            tempAr[i] = tempAr[i - 1] + tempAr[i]; //find the number of elements less than or equal to i
        }

        for (int i = ar.length - 1; i >= 1; i--) {
            sortedAr[tempAr[ar[i]]] = ar[i]; //putting the i in its correct position
            tempAr[ar[i]]--;
        }

        return sortedAr;
    }

    public static void display(int[] ar) {
        for (int i = 1; i < ar.length; i++) {
            System.out.print(ar[i] + " ");
        }
    }

}


