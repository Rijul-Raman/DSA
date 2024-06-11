public class Queue<T> {
    Node front;
    Node rear;
    int size;

    class Node {
        T data;
        Node next;
        Node(T d) {
            this.data = d;
        }
    }

    public void enqueue(T d) {
        Node new_node = new Node(d);
        if(front == null) {
            front = new_node;
        }
        else {
            rear.next = new_node;
        }
        rear = new_node;
        size++;
    }

    public T dequeue() {
        try {
            if(front==null) {
                throw new RuntimeException("Queue Underflow");
            }
            Node temp = front;
            if(front==rear) {
                rear = null;
            }
            front = front.next;
            temp.next = null;
            size--;
            return temp.data;
        }
        catch(RuntimeException e) {
            throw new IllegalStateException("Cannot dequeue: "+e.getMessage());
        }        
    }

    public T peek() {
        return front.data;
    }

    public int length() {
        return size;
    }

    @Override
    public String toString() {
        try {
            if(front==null) {
                throw new RuntimeException("Queue Underflow");
            }
            Node temp = front;
            String out = "";
            while(temp.next!=null) {
                out = out + temp.data + ", ";
                temp = temp.next;
            }
            out = out + temp.data;
            return out;
        }
        catch(RuntimeException e) {
            throw new IllegalStateException("Cannot dequeue: "+e.getMessage());
        }       
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<>();
        queue.enqueue(5);
        queue.enqueue(15);
        queue.enqueue(25);
        queue.enqueue(35);
        queue.enqueue(45);
        System.out.println(queue);
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue);
    }
}
