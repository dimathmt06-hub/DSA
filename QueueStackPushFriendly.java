import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPushFriendly {
    private Queue<Integer> q1;
    private Queue<Integer> q2;

    public QueueStackPushFriendly() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }

    public void push(int value) {
        q1.offer(value); // enqueue
        System.out.println("Pushed: " + value);
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty - cannot pop");
        }

        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        int top = q1.poll();

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }


    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty - cannot peek");
        }

        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        int top = q1.poll();
        q2.offer(top);
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public int size() {
        return q1.size();
    }

    public void display() {
        System.out.println("Stack (top -> bottom): " + q1);
    }

    public static void main(String[] args) {
        QueueStackPushFriendly stack = new QueueStackPushFriendly();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        stack.display();

        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop:  " + stack.pop());
        System.out.println("Pop:  " + stack.pop());

        stack.display();

        stack.push(50);
        System.out.println("Peek after push: " + stack.peek());
        System.out.println("Size: " + stack.size());
    }
}