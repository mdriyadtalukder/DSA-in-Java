import java.util.ArrayList;
import java.util.Collections;

public class ArrayList_ {
    public static void main(String[] args) {
        // ArrayList<String> arr1 = new ArrayList<String>();
        // ArrayList<Boolean> arr2 = new ArrayList<>();
        ArrayList<Integer> n = new ArrayList<Integer>();

        ArrayList<Integer> n2 = new ArrayList<Integer>();

        // 16 methods

        // adding or inserting
        n.add(11);
        n.add(22);
        n.add(23);
        n.add(22);
        n.add(0, 16); // it will be add in 0 index then 11,22,33 will be add

        n2.add(34);

        System.out.println(n2.addAll(n)); // after 34 ,all element of n will be add in n2..
        System.out.println(n2);

        // Retrieve and Update
        n.set(3, 44);
        System.out.println(n.get(2));
        for (int i : n) {
            System.out.println(i);
        }

        // sorting
        Collections.sort(n);
        System.out.println(n);
        Collections.sort(n, Collections.reverseOrder());
        System.out.println(n);

        // searching
        System.out.println(n.contains(16));
        System.out.println(n.indexOf(16));
        System.out.println(n.lastIndexOf(22));

        // Size and Check
        System.out.println(n.size());
        System.out.println(n.isEmpty());

        // equals
        System.out.println(n.equals(n2));

        // deleting
        System.out.println(n.remove(0));
        System.out.println(n.removeAll(n));
        n.clear();

    }
}
