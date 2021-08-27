import java.util.Stack;

public class ImplementQueueUsingStacks {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1); // queue is: [1]
        myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
        myQueue.peek(); // return 1
        myQueue.pop(); // return 1, queue is [2]
        myQueue.empty(); // return false
    }
}


class MyQueue {

    private Stack<Integer> stack;

    /** Initialize your data structure here. */
    public MyQueue() {
        this.stack = new Stack();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        Stack<Integer> tmp = new Stack();
        while(!stack.isEmpty()) {
            tmp.push(stack.pop());
        }
        stack.push(x);
        while(!tmp.isEmpty()){
            stack.push(tmp.pop());
        }
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */