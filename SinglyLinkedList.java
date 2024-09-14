public class SinglyLinkedList<T> {
    Node head;

    class Node {
        T data;
        Node next;

        Node(T d) {
            this.data = d;
            this.next = null;
        }
    }

    public void push(T d) {
        Node new_node = new Node(d);
        new_node.next = this.head;
        this.head = new_node;
    }

    public void insert(Node prev_node, T d) {
        Node new_node = new Node(d);
        new_node.next = prev_node.next;
        prev_node.next = new_node;
    }

    public void append(T d) {
        Node new_node = new Node(d);
        if(this.head==null) {
            this.head = new_node;
            return;
        }
        new_node.next = null;
        Node last = this.head;
        while(last.next!=null) {
            last = last.next;
        }
        last.next = new_node;
        return;
    }

    public T deleteNode(int pos) {
        if(this.head==null) {
            return null;
        }
        Node temp = this.head;
        T d;
        if(pos==0){
            d = this.head.data;
            this.head = temp.next;
            return d;
        }
        for(int i = 1;i<pos && temp!=null;i++){
            temp = temp.next;
        }
        if (temp==null||temp.next==null) {
            return null;
        }
        d = temp.next.data;
        Node next_node = temp.next.next;
        temp.next = next_node;
        return d;
    }

    public T get(int pos) {
        try{
            if(this.length()==0){
                throw new IllegalArgumentException("Empty Linked List");
            }
            if(pos<0 || pos>this.length()-1){
                throw new IndexOutOfBoundsException("Index out of range of Linked List");
            }
            Node temp = this.head;
            T d = null;
            for(int i = 0;i<this.length();i++){
                if(pos==i){
                    d = temp.data;
                    return d;
                }
                temp = temp.next;
            }
            return d;
        }
        catch (IllegalArgumentException e){
            System.out.println("Illegal Argument: "+e.getMessage());
            throw new IllegalStateException("Cannot retrieve element: " + e.getMessage());
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Index out of bounds: "+e.getMessage());
            throw new IllegalStateException("Cannot retrieve element: " + e.getMessage());
        }
    }

    public T getFromEnd(int pos) {
        try{
            if(this.length()==0){
                throw new IllegalArgumentException("Empty Linked List");
            }
            if(pos<=0 || pos>this.length()){
                throw new IndexOutOfBoundsException("Index out of range of Linked List");
            }
            T d = this.get(this.length()-pos);
            return d;
        }
        catch (IllegalArgumentException e){
            System.out.println("Illegal Argument: "+e.getMessage());
            throw new IllegalStateException("Cannot retrieve element: " + e.getMessage());
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Index out of bounds: "+e.getMessage());
            throw new IllegalStateException("Cannot retrieve element: " + e.getMessage());
        }
    }

    public int length(){
        int l = 0;
        Node temp = this.head;
        while(temp!=null){
            l++;
            temp = temp.next;
        }
        return l;
    }

    public int search(T d) {
        int pos = 0;
        Node temp = this.head;
        while(temp!=null){
            if(temp.data.equals(d)){
                return pos;
            }
            pos++;
            temp = temp.next;
        }
        return -1;
    }

    public boolean isIdentical(SinglyLinkedList<T> llb) {
        Node ta = this.head;
        Node tb = llb.head;
        while(ta!=null && tb!=null){
            if(!(ta.data.equals(tb.data))){
                return false;
            }
            ta = ta.next;
            tb = tb.next;
        }
        if(ta!=null || tb!=null){
            return false;
        }
        return true;
    }

    @Override
    public String toString(){
        String out = "";
        Node tnode = head;
        while (tnode.next != null) {
            out = out+tnode.data+" --> ";
            tnode = tnode.next;
        }
        out = out+tnode.data;
        return out;
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> lla = new SinglyLinkedList<Integer>();
        lla.append(1);
        lla.append(2);
        lla.append(3);
        lla.append(4);
        lla.append(5);
        lla.deleteNode(4);
        System.out.println(lla);
    }

}
