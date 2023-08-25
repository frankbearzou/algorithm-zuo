package p3;

public class RingQueue {
    private int pushIndex;
    private int pollIndex;
    private int size;
    private int limit;
    private int[] arr;

    public RingQueue(int limit) {
        this.limit = limit;
        arr = new int[limit];
    }

    public void push(int value) {
        if (size == limit) {
            throw new RuntimeException("the queue is full");
        }
        arr[pushIndex] = value;
        pushIndex = nextIndex(pushIndex);
        size++;
    }

    public int pop() {
        if (size == 0) {
            throw new RuntimeException("the queue is empty");
        }
        int value = arr[pollIndex];
        pollIndex = nextIndex(pollIndex);
        size--;
        return value;
    }

    private int nextIndex(int i) {
        return i + 1 == limit ? 0 : i + 1;
    }
}
