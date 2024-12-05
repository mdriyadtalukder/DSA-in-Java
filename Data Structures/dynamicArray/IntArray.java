@SuppressWarnings("null")
public class IntArray implements Iterable<Integer> {
    public int[] arr;
    private int len = 0;
    private int capacity = 0;

    public IntArray() {
        this(16);
    }

    public IntArray(int capacity) {
        if (capacity == 0) {
            throw new IllegalArgumentException("Illegal argument: " + capacity);
        }
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public int size() {
        return len;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public int get(int index) {
        return arr[index];
    }

    public void set(int index, int elem) {
        arr[index] = elem;
    }

    public void clear() {
        for (int i = 0; i < capacity; i++) {
            arr[i] = (Integer) null;
        }
        len = 0;
    }

    public int indexOf(int elem) {
        for (int i = 0; i < len; i++) {
            if (arr[i] == elem) {
                return i;
            }
        }
        return -1;
    }

    public boolean contains(int elem) {
        return indexOf(elem) != -1;

    }

    public java.util.Iterator<Integer> iterator() {
        return new java.util.Iterator<Integer>() {
            int index = 0;

            public boolean hasNext() {
                return index < len;
            };

            public Integer next() {
                return arr[index++];
            };

        };
    }

    public String toString() {
        if (len == 0) {
            return "[]";
        } else {
            StringBuilder sb = new StringBuilder(len).append("[");
            for (int i = 0; i < len - 1; i++) {
                sb.append(arr[i] + ",");
            }
            return sb.append(arr[len - 1] + "]").toString();
        }
    }

    public static void main(String[] args) {
        IntArray ar = new IntArray(14);
    }

}