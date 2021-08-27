import java.util.Arrays;

public class DesignCircularQueue {
    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 크기를 5로 지정
        circularQueue.enQueue(1); // true 리턴
        circularQueue.enQueue(2); // true 리턴
        circularQueue.enQueue(3); // true 리턴
        circularQueue.enQueue(4); // true 리턴
        circularQueue.Rear(); // 40 리턴
        circularQueue.isFull(); // false 리턴
        circularQueue.deQueue(); // true 리턴
        circularQueue.enQueue(4); // true 리턴
        circularQueue.Rear(); // 60
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */

class MyCircularQueue {

    private int length;
    private int size;
    private int[] elements;

    public MyCircularQueue(int k) {
        length = k;
        size = 0;
        elements = new int[length];
    }

    public boolean enQueue(int value) {
        if(length == size) return false;
        elements[size] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if(size == 0) return false;
        if(size == 1) {
            elements[0] = -1;
            size--;
            return true;
        }
        for(int i = 0; i < size; i++){
            if(i == size -1) elements[i] = 0;
            else elements[i] = elements[i+1];
        }
        size--;
        return true;
    }

    public int Front() {
        return elements[0];
    }

    public int Rear() {
        if(size == 0) return -1;
        return elements[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return elements.length == size;
    }
}
