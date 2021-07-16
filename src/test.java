import ua.goit.scollections.SimpleArrayList;
import ua.goit.scollections.SimpleLinkedList;

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
        /*//ArrayList
        SimpleArrayList<Test1> arrayList = new SimpleArrayList<>();
        arrayList.add(new Test1());
        arrayList.add(new Test1());
        arrayList.add(new Test1());
        System.out.println(arrayList.toString());
        arrayList.remove(2);
        //arrayList.remove(0);
        System.out.println(arrayList.toString());
        arrayList.add(new Test2());
        arrayList.remove(0);
        System.out.println(arrayList.toString());
        System.out.println(arrayList.size());
        //System.out.println(arrayList.get(2));
        //System.out.println(arrayList.get(5));
        arrayList.clear();
        System.out.println(arrayList.toString());*/

        /*SimpleLinkedList<Test1> linkedList = new SimpleLinkedList<Test1>();
        System.out.println(linkedList.toString());
        System.out.println(linkedList.size());
        linkedList.add(new Test1());
        linkedList.add(new Test2());
        linkedList.add(new Test1());
        linkedList.add(new Test1());
        System.out.println(linkedList.size());
        System.out.println(linkedList.toString());
        System.out.println(linkedList.get(1).toString());
        linkedList.remove(3);
        System.out.println(linkedList.size());
        System.out.println(linkedList.toString());*/

        SimpleLinkedList<Integer> linkedList = new SimpleLinkedList<Integer>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        System.out.println(linkedList.size());
        System.out.println(linkedList.toString());
        linkedList.remove(2);
        System.out.println(linkedList.size());
        System.out.println(linkedList.toString());
        linkedList.add(7);
        System.out.println(linkedList.size());
        System.out.println(linkedList.toString());

    }
}
