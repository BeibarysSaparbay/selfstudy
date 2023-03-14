public class PowerOfTwoMaxHeap {

    private int arity;
    private int[] heap;
    private int size;

    public PowerOfTwoMaxHeap(int arity) {
        this.arity = arity;
        this.heap = new int[1];
        this.size = 0;
    }

    public void insert(int value) {
        if (size >= heap.length) {
            // double the size of the array if it's full
            int[] newHeap = new int[heap.length * 2];
            System.arraycopy(heap, 0, newHeap, 0, heap.length);
            heap = newHeap;
        }

        heap[size] = value;
        size++;

        // bubble up the new element until it satisfies the heap property
        int index = size - 1;
        int parentIndex = (index - 1) / arity;
        while (index > 0 && heap[index] > heap[parentIndex]) {
            int temp = heap[index];
            heap[index] = heap[parentIndex];
            heap[parentIndex] = temp;

            index = parentIndex;
            parentIndex = (index - 1) / arity;
        }
    }

    public int popMax() {
        if (size == 0) {
            throw new NoSuchElementException("Heap is empty");
        }

        int maxValue = heap[0];
        size--;

        if (size > 0) {
            heap[0] = heap[size];

            // bubble down the new root node until it satisfies the heap property
            int index = 0;
            int maxChildIndex = getMaxChildIndex(index);
            while (maxChildIndex != -1 && heap[index] < heap[maxChildIndex]) {
                int temp = heap[index];
                heap[index] = heap[maxChildIndex];
                heap[maxChildIndex] = temp;

                index = maxChildIndex;
                maxChildIndex = getMaxChildIndex(index);
            }
        }

        return maxValue;
    }

    private int getMaxChildIndex(int parentIndex) {
        int firstChildIndex = parentIndex * arity + 1;
        if (firstChildIndex >= size) {
            return -1;
        }

        int maxChildIndex = firstChildIndex;
        for (int i = 1; i < arity && i + firstChildIndex < size; i++) {
            if (heap[i + firstChildIndex] > heap[maxChildIndex]) {
                maxChildIndex = i + firstChildIndex;
            }
        }

        return maxChildIndex;
    }

}
