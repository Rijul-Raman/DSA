public class StaticStack<T> {
    T[] arr;
    int size;
    int top;

    @SuppressWarnings("unchecked")
    StaticStack(int s) {
        size = s;
        arr = (T[]) new Object[size];
        top = -1;
    }

    StaticStack() {
        this(10);
    }

    public void push(T d) {
        try {
            if(top+1==size) {
                throw new RuntimeException("Stack Overflow");
            }
            arr[++top] = d;
        }
        catch(RuntimeException e) {
            throw new IllegalStateException("Cannot push data: "+e.getMessage());
        }
    }

    public T pop() {
        try {
            if(top==-1) {
                throw new RuntimeException("Stack Underflow");
            }
            T d = arr[top];
            arr[top--] = null;
            return d;
        }
        catch(RuntimeException e) {
            throw new IllegalStateException("Cannot pop from Stack: "+e.getMessage());
        }
    }

    public T peek() {
        try {
            if(top==-1) {
                throw new RuntimeException("Stack Underflow");
            }
            T d = arr[top];
            return d;
        }
        catch(RuntimeException e) {
            throw new IllegalStateException("Cannot retrieve from Stack: "+e.getMessage());
        }
    }

    @Override
    public String toString() {
        try{
            if(top==-1){
                throw new IllegalAccessException("Stack Underflow");
            }
            String out = "";
            for(int i = top;i>0;i--) {
                out = out + arr[i] + ", ";
            }
            out = out + arr[0];
            return out;
        }
        catch(IllegalAccessException e) {
            throw new IllegalStateException("Cannot print Stack: "+e.getMessage());
        }
    }

    public static void main(String[] args) {
        StaticStack<Integer> stack = new StaticStack<Integer>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        System.out.println(stack);
        System.out.println(stack.peek());
        stack.pop();
        stack.pop();
        int d = stack.pop();
        System.out.println(d);
        System.out.println(stack);
    }
}
