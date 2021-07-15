import ua.goit.scollections.SimpleArrayList;

import java.util.Arrays;
import java.util.LinkedList;

class Test1 {
    @Override
    public String toString() {
        return "Test1";
    }
}
class Test2 extends Test1 {
    @Override
    public String toString() {
        return "Test2";
    }
}

public class test {
    public static void main(String[] args) {
        //ArrayList
        SimpleArrayList<Test1> arrayList = new SimpleArrayList<>();
        arrayList.add(new Test1());
        arrayList.add(new Test1());
        arrayList.add(new Test1());
        System.out.println(Arrays.toString(arrayList.toArray()));
        arrayList.remove(2);
        arrayList.remove(0);
        System.out.println(Arrays.toString(arrayList.toArray()));
        arrayList.add(new Test2());
        System.out.println(Arrays.toString(arrayList.toArray()));
        System.out.println(arrayList.size());
        System.out.println(arrayList.get(2));
        //System.out.println(arrayList.get(5));
        arrayList.clear();
        System.out.println(Arrays.toString(arrayList.toArray()));

    }
}
