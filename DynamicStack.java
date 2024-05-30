public class DynamicStack<T> {
    Node top;
    int size = 0;

    class Node {
        T data;
        Node next;
        Node(T d) {
            this.data = d;
        }
    }

    public void push(T d){
        Node new_node = new Node(d);
        new_node.next = top;
        top = new_node;
        size++;
    }

    public T pop() {
        try {
            if(top==null) {
                throw new IllegalAccessException("Stack Underflow");
            }
            Node temp = top;
            T d = temp.data;
            top = temp.next;
            temp.next = null;
            size--;
            return d;
        }
        catch(IllegalAccessException e) {
            throw new IllegalStateException("Cannot pop from Stack: "+e.getMessage());
        }
    }

    public T peek() {
        try {
            if(top==null) {
                throw new IllegalAccessException("Stack Underflow");
            }
            return top.data;
        }
        catch(IllegalAccessException e) {
            throw new IllegalStateException("Cannot retrieve from Stack: "+e.getMessage());
        }
    }

    public int length() {
        return size;
    }

    @Override
    public String toString() {
        String out = "";
        Node temp = top;
        while(temp.next!=null){
            out = out + temp.data + ", ";
            temp = temp.next;
        }
        out = out + temp.data;
        return out;
    }

    public static void main(String[] args) {
        DynamicStack<Integer> stack = new DynamicStack<Integer>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        System.out.println(stack);
        System.out.println(stack.length());
        System.out.println(stack.peek());
        int d = stack.pop();
        System.out.println(d);
        d = stack.pop();
        System.out.println(d);
        System.out.println(stack);
        System.out.println(stack.length());
    }
}