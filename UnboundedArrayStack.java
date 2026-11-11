public class UnboundedArrayStack {

    private int[] arr;
    private int top; 
    private int capacity;

    private static final int DEFAULT_CAPACITY = 2;

    public UnboundedArrayStack() {
        capacity = DEFAULT_CAPACITY;
        arr = new int[capacity];
        top = -1;
    }

    public void push(int value) {
        if (isFull()) {
            resize(capacity * 2);
        }
        arr[++top] = value;
        System.out.println("Pushed: " + value + " (size=" + size() + ", cap=" + capacity + ")");
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty - cannot pop");
        }

        int value = arr[top];
        arr[top] = 0;
        top--;

        if (capacity > DEFAULT_CAPACITY && size() <= capacity / 4) {
            resize(capacity / 2);
        }

        return value;
    }

    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty - cannot peek");
        }
        return arr[top];
    }

    private void resize(int newCapacity) {
        System.out.println("  [resize: " + capacity + " -> " + newCapacity + "]");
        int[] newArr = new int[newCapacity];
        for (int i = 0; i <= top; i++) {
            newArr[i] = arr[i];
        }
        arr = newArr;
        capacity = newCapacity;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    private boolean isFull() {
        return top + 1 == capacity;
    }

    public int size() {
        return top + 1;
    }

    public void display() {
        System.out.print("Stack (top -> bottom): [");
        for (int i = top; i >= 0; i--) {
            System.out.print(arr[i]);
            if (i > 0) System.out.print(", ");
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        UnboundedArrayStack stack = new UnboundedArrayStack();

        for (int i = 1; i <= 10; i++) {
            stack.push(i * 10);
        }
        stack.display();

        for (int i = 0; i < 8; i++) {
            System.out.println("Pop: " + stack.pop() + " (size=" + stack.size() + ", cap=" + stack.capacity + ")");
        }

        stack.display();
        System.out.println("Peek: " + stack.peek());
    }
}