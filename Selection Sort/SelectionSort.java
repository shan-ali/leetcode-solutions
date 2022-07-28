public class SelectionSort {

    public static int[] selectionSort(int[] arr) {
        boolean isSorted = false;
        while (!isSorted) {
            boolean swap = false;
            for (int i = 0; i < arr.length - 1; i++) {
                // length - 1 since we will be using i+1
                if (arr[i] > arr[i + 1]) {
                    // System.out.println(arr[i]);
                    // System.out.println(arr[i + 1]);
                    int temp = arr[i + 1];
                    arr[i + 1] = arr[i];
                    arr[i] = temp;
                    swap = true;
                }
            }
            if (swap == false) {
                isSorted = true;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = { 5, 1, 3, 2, 7, 4, 6, 10, 100, 60, 0, 101, 500 };
        int[] sorted = selectionSort(arr);
        for (int a : sorted) {
            System.out.print(a + ", ");
        }
    }
}
