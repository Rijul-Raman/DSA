public class MaxPriorityQueue{
    Integer[] heap;
    int n;
    
    
    public MaxPriorityQueue(int capacity) {
        heap = new Integer[capacity+1];
        n = 0;
    }

    public MaxPriorityQueue() {
        this(10);
        n = 0;
    }

    public int size() {
        return n;
    }

    public boolean isEmpty() {
        return n==0;
    }

    private void resize(int capacity) {
        Integer[] temp_heap = new Integer[capacity];
        for(int i = 0;i<heap.length;i++) {
            temp_heap[i] = heap[i];
        }
        heap = temp_heap;
    }

    public void insert(int d) {
        if(n==(heap.length-1)) {
            resize(2*heap.length);
        }
        n++;
        heap[n] = d;
        swim(n);
    }

    private void swim(int k) {
        while(k>1 && heap[k/2]<heap[k]) {
            int temp = heap[k];
            heap[k] = heap[k/2];
            heap[k/2] = temp;
            k = k/2;
        }
    }

    public int getMax() {
        return heap[1];
    }

    public int deleteMax() {
        int max = heap[1];
        swap(1, n);
        n--;
        sink(1);
        heap[n+1] = null;
        if(n>0 && n==(heap.length-1)/4) {
            resize(heap.length/2);
        }
        return max;
    }

    private void sink(int k) {
        while(2*k<=n) {
            int j = 2*k;
            if(j<n && heap[j]<heap[j+1]) {
                j++;
            }
            if(heap[k]>=heap[j]) {
                break;
            }
            swap(k, j);
            k = j;
        }
    }

    private void swap(int a, int b) {
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }

    @Override
    public String toString() {
        try{
            if(n==0) {
                throw new RuntimeException("Empty Priority Queue");
            }
            String out = "";
            for(int i = 1;i<=n;i++) {
                out = out+heap[i]+" ";
            }
            return out;
        }
        catch(RuntimeException e) {
            throw new IllegalStateException("Cannot print Stack: "+e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        MaxPriorityQueue pq = new MaxPriorityQueue(5);
        pq.insert(3);
        pq.insert(1);
        pq.insert(7);
        pq.insert(4);
        pq.insert(8);
        pq.insert(9);
        pq.insert(0);
        pq.insert(2);
        System.out.println(pq);
        System.out.println(pq.getMax());
        System.out.println(pq.deleteMax());
        System.out.println(pq);
        System.out.println(pq.deleteMax());
        System.out.println(pq);
        System.out.println(pq.deleteMax());
        System.out.println(pq);
    }
}
