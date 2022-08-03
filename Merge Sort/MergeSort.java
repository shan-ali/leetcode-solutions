public class MergeSort {

    public static void mergeSort(int[] arr) {

        int inputLength = arr.length;

        // if array is of length 1 or empty then it is sorted
        if (inputLength < 2) {
            return;
        }

        int mid = inputLength / 2;
        int leftArr[] = new int[mid];
        int rightArr[] = new int[inputLength - mid];

        // create left array
        for (int i = 0; i < mid; i++) {
            leftArr[i] = arr[i];
        }

        // create right array
        for (int i = mid; i < inputLength; i++) {
            rightArr[i - mid] = arr[i];
        }

        mergeSort(leftArr);
        mergeSort(rightArr);

        merge(arr, leftArr, rightArr);

    }

    public static void merge(int[] arr, int[] leftArr, int[] rightArr) {

        int leftLength = leftArr.length;
        int rightLength = rightArr.length;

        // for each element in each array compare them to build new input array
        // i itterates over left, j over right, k is the index to build new input array
        int i = 0, j = 0, k = 0;

        while (i < leftLength && j < rightLength) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }

            k++;
        }

        // when this while loop completes, there might still be elements in the right or
        // left arr

        while (i < leftLength) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while (j < rightLength) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 5, 1, 3, 2, 7, 4, 6, 10, 100, 60, 0, 101, 500 };
        mergeSort(arr);
        for (int a : arr) {
            System.out.print(a + ", ");
        }
    }
}
