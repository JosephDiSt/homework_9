public class SortComparison {

    // BubbleSort Implementation
    public static void bubbleSort(int[] array) {
        boolean swapped;
        do {
            swapped = false;
            for (int i = 0; i < array.length - 1; i++) {
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                    swapped = true;
                }
            }
        } while (swapped);
    }

    // MergeSort Implementation
    public static void mergeSort(int[] array) {
        if (array.length <= 1) {
            return;
        }

        int mid = array.length / 2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid];

        System.arraycopy(array, 0, left, 0, mid);
        System.arraycopy(array, mid, right, 0, array.length - mid);

        mergeSort(left);
        mergeSort(right);

        merge(array, left, right);
    }

    private static void merge(int[] result, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        while (i < left.length) {
            result[k++] = left[i++];
        }

        while (j < right.length) {
            result[k++] = right[j++];
        }
    }

    // Main method to compare performance of BubbleSort and MergeSort
    public static void main(String[] args) {
        int[] array1 = {64, 34, 25, 12, 22, 11, 90};
        int[] array2 = array1.clone();

        // Timing BubbleSort
        long startTime = System.nanoTime();
        bubbleSort(array1);
        long endTime = System.nanoTime();
        long bubbleSortTime = endTime - startTime;

        // Timing MergeSort
        startTime = System.nanoTime();
        mergeSort(array2);
        endTime = System.nanoTime();
        long mergeSortTime = endTime - startTime;

        // Output the time taken by each algorithm
        System.out.println("BubbleSort took: " + bubbleSortTime + " ns");
        System.out.println("MergeSort took: " + mergeSortTime + " ns");
    }
}

