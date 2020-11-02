import java.util.EmptyStackException;

public class SimpleStack {

    private int size;
    private int capacity;
    private String[] data;
    
    public SimpleStack() {
        this.size = 0;
        this.capacity = 0;
        this.data = new String[0];
    }
    
    public boolean empty() {
        return size == 0;
    }
    
    public String peek() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        
        return data[size - 1];
    }
    
    public String pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        
        String s = data[--size];
        data[size] = null;
        trimToSize();
        
        return s;
    }
    
    public String push(String s) {
        if (size == capacity) {
            increaseCapacity();
        }
        
        data[size++] = s;
        
        return s;
    }
    
    public int search(String s) {
        for (int i = size - 1, j = 1; i >= 0; i--, j++) {
            if (data[i].equals(s)) {
                return j;
            }
        }
        
        return -1;
    }
    
    @Override
    public String toString() {
        String s = "[";
        
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                s = s + data[i];
            } else {
                s = s + data[i] + ", ";
            }
        }
        
        return s + "]";
    }
    
    private void trimToSize() {      
        capacity = size;
        
        String[] data = this.data;
        this.data = new String[size];
        
        for (int i = 0; i < size; i++) {
            this.data[i] = data[i];
        }       
    }
    
    private void increaseCapacity() {
        String[] data = new String[capacity + 1];
        
        for (int i = 0; i < size; i++) {
            data[i] = this.data[i];
        }
        
        this.data = data;
        capacity = data.length;
    }
}
