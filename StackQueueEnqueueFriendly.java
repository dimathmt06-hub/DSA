import java.util.Stack;
public class StackQueueEnqueueFriendly {

    private Stack<Integer> inStack; 
    private Stack<Integer> outStack; 

    public StackQueueEnqueueFriendly() {
        inStack = new Stack<>();
        outStack = new Stack<>();
    }

    public void enqueue(int value) {
        inStack.push(value);
        System.out.println("Enqueued: " + value);
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty - cannot dequeue");
        }

        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }

        return outStack.pop();
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty - cannot peek");
        }

        if (outStack.isEmpty()) {
            while (!inStack.isEmpty()) {
                outStack.push(inStack.pop());
            }
        }
        return outStack.peek();
    }

    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

    public int size() {
        return inStack.size() + outStack.size();
    }

    public void display() {
        System.out.print("Queue (front -> back): [");
        Stack<Integer> temp = new Stack<>();
        while (!outStack.isEmpty()) {
            temp.push(outStack.pop());
        }
        boolean first = true;
        while (!temp.isEmpty()) {
            if (!first) System.out.print(", ");
            System.out.print(temp.pop());
            first = false;
        }
        if (!inStack.isEmpty()) {
            if (!first) System.out.print(", ");
            Stack<Integer> temp2 = new Stack<>();
            while (!inStack.isEmpty()) {
                temp2.push(inStack.pop());
            }
            first = true;
            while (!temp2.isEmpty()) {
                int v = temp2.pop();
                if (!first) System.out.print(", ");
                System.out.print(v);
                inStack.push(v);
                first = false;
            }
        }

        System.out.println("]");
    }
    public static void main(String[] args) {
        StackQueueEnqueueFriendly queue = new StackQueueEnqueueFriendly();

        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);

        queue.display();

        System.out.println("Peek:    " + queue.peek());
        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Dequeue: " + queue.dequeue());

        queue.enqueue(5);
        queue.enqueue(6);

        queue.display();

        System.out.println("Dequeue: " + queue.dequeue());
        System.out.println("Size: " + queue.size());
    }
}