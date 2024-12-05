import java.util.*;

@SuppressWarnings("null")

public class IntArray implements Iterable<Integer> {
    private static final int DEFAULT_CAP = 1 << 3;
    public int[] arr;
    private int len = 0;
    private int capacity = 0;

    public IntArray() {
        this(DEFAULT_CAP);
    }

    public IntArray(int capacity) {
        if (capacity == 0) {
            throw new IllegalArgumentException("Illegal argument: " + capacity);
        }
        this.capacity = capacity;
        arr = new int[capacity];
    }

    public IntArray(int[] array) {
        if (array == null) {
            throw new IllegalArgumentException("Array can not be null");
        }
        arr = java.util.Arrays.copyOf(array, array.length);
        capacity = len = array.length;
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

    // public void add(int elem) {
    // if (len + 1 >= capacity) {
    // if (capacity == 0) {
    // capacity = 1;
    // } else {
    // capacity *= 2;
    // }
    // int[] new_arr = new int[capacity];
    // for (int i = 0; i < len; i++) {
    // new_arr[i] = arr[i];
    // }
    // arr = new_arr;

    // }
    // arr[len++] = elem;

    // }

    public void add(int elem) {
        if (len + 1 > capacity) {
            if (capacity == 0) {
                capacity = 1;
            } else {
                capacity *= 2;
            }
            arr = java.util.Arrays.copyOf(arr, capacity);
        }
        arr[len++] = elem;

    }

    // public int removeAt(int index) {
    // if (index >= len && index < 0) {
    // throw new IndexOutOfBoundsException();
    // } else {
    // int data = arr[index];
    // int[] new_arr = new int[len - 1];
    // for (int i = 0, j = 0; i < len; i++, j++) {
    // if (i == index)
    // j--;
    // else {
    // new_arr[i] = arr[i];
    // }
    // }
    // arr = new_arr;
    // capacity = --len;
    // return data;
    // }
    // }

    public void removeAt(int rm_index) {
        System.arraycopy(arr, rm_index + 1, arr, rm_index, len - rm_index - 1);
        --len;
        --capacity;
    }

    public boolean remove(int eleme) {
        for (int i = 0; i < len; i++) {
            if (arr[i] == eleme) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }

    public void sort() {
        java.util.Arrays.sort(arr, 0, len);
    }

    public void reverse() {
        for (int i = 0; i < len / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[len - i - 1]; // 1st elem go to last according to slot
            arr[len - i - 1] = temp; // last elem go to 1st according to slot
        } // in this loop every time..2 values position will be changed..so it will work
          // len/2 times;
    }

    public int binarySearch(int key) {
        int index = java.util.Arrays.binarySearch(arr, 0, len, key);
        // if (index < 0) index = -index - 1; // If not found this will tell you where
        // to insert
        return index;
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

            public void remove() {
                throw new UnsupportedOperationException();
            }

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
        ar.add(1);
        ar.add(2);
        ar.add(3);
        ar.add(4);
        ar.set(3, 5);
        ar.reverse();
        System.out.println(ar.binarySearch(3));
        // ar.removeAt(1);
        System.out.println(ar);

        Iterator<Integer> it1 = ar.iterator();
        // it1.remove();
        System.out.println(it1.hasNext());

    }

}