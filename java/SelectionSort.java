import java.util.*;

public class SelectionSort {

    // Selection Sort Function
    static void selectionSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;

            // Find minimum element
            for (int j = i + 1; j < n; j++) {

                if (arr[j] < arr[minIndex]) {

                    minIndex = j;
                }
            }

            // Swap elements
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of the array: ");

        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {

            arr[i] = sc.nextInt();
        }

        System.out.println(
                "\nArray before Selection Sort:"
        );

        for (int num : arr) {

            System.out.print(num + " ");
        }

        System.out.println();

        // Call Selection Sort
        selectionSort(arr);

        System.out.println(
                "\nArray after Selection Sort:"
        );

        for (int num : arr) {

            System.out.print(num + " ");
        }

        sc.close();
    }
}