import java.util.Scanner;
import java.util.stream.IntStream;
/*
Writing the algorithm
create an array c[0...k], where k is the maximum element in original element
for i from 0 to k:
    c[i] = 0
for i from 1 to ar.length:
    c[ar[i]] = c[ar[i]] + 1
for j from 1 to k:
    c[i] = c[i-1] + c[i]
for i from 0 to ar.length:
    b[c[ar[i]]] = ar[i]
    c[ar[i]] = c[ar[i]] - 1
b[c[ar[i]] is the sorted array
 */

public class Count_sort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size: ");
        int size = sc.nextInt();
        int ar[] = new int[size];
        //ar[0] = 0;
        for (int i = 0; i < size ; i++) {
            ar[i] = sc.nextInt();
        }
        //Since count sort puts the sorted array in a new array we can have a return type, in the same array;
        ar = countSort(ar);

        display(ar);
    }

    public static int maximum(int[] ar, int index) {
        //method to find maximum in the array from a specific index
        int max = ar[index];
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] >= max) {
                max = ar[i];
            }
        }
        return max;
    }

    public static int[] countSort(int ar[]) {
        int tempSize = maximum(ar, 0);

        int sortedAr[] = new int[ar.length];

        int[] tempAr = new int[tempSize + 1]; //tempSize is an element so it should be in the tempAr, so tempSize+1

        for (int i = 0; i < ar.length; i++) {
            tempAr[ar[i]] = tempAr[ar[i]] + 1; //storing the frequency of every number
        }


        for (int i = 1; i <= tempSize; i++) {
            tempAr[i] = tempAr[i - 1] + tempAr[i]; //find the number of elements less than or equal to i
        }

        for (int i = 0; i <=ar.length-1; i++) {
            sortedAr[tempAr[ar[i]]-1] = ar[i]; //putting the i in its correct position
            tempAr[ar[i]]--;
        }

        return sortedAr;
        /*return IntStream.range(0, sortedAr.length) //this is done to remove the zeroth index from sorted array
                .filter(i -> i != 0)
                .map(i -> sortedAr[i])
                .toArray();*/
    }

    public static void display(int[] ar) {
        for (int i = 0; i < ar.length; i++) {
            System.out.print(ar[i] + " ");
        }
    }

}


