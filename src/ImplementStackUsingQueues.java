import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackUsingQueues {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(1);
        stack.push(2);
        stack.top(); // 2 리턴
        stack.pop(); // 2 리턴
        stack.empty(); // false 리턴
    }
}

class MyStack {

    private int size;
    private int[]  elements;
    private int top;

    public void resize(int length){
        int[] arr = new int[length];
        for(int i = 0; i < elements.length; i++) {
            arr[i] = elements[i];
        }
        this.elements = arr;
    }

    /** Initialize your data structure here. */
    public MyStack() {
        this.elements = new int[1];
        this.size = 0;
        this.top = -1;
    }

    /** Push element x onto stack. */
    public void push(int x) {
        size++;
        if(size > elements.length) resize(elements.length*2);
        this.top = elements[size-1] = x;
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        size--;
        int tmp = top;
        if(size > 0) {
            this.top = elements[size-1];
        } else {
            this.top = -1;
        }
        return tmp;
    }

    /** Get the top element. */
    public int top() {
        return this.top;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return size == 0 && top == -1;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */