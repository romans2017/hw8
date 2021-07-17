import ua.goit.scollections.SimpleArrayList;
import ua.goit.scollections.SimpleLinkedList;
import ua.goit.scollections.SimpleQueue;
import ua.goit.scollections.SimpleStack;

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

class Test3 extends Test1 {
    @Override
    public String toString() {
        return "Test3";
    }
}

public class test {

    static void testArraylist() {
        SimpleArrayList<Test1> arrayList = new SimpleArrayList<>();
        arrayList.add(new Test1());
        arrayList.add(new Test2());
        arrayList.add(new Test3());
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
        System.out.println(arrayList.toString());
    }

    static void testLinkedList() {
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

    static void testQueue() {
        SimpleQueue<Integer> queue = new SimpleQueue<>();
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        queue.add(1);
        queue.add(3);
        queue.add(5);
        queue.add(4);
        System.out.println(queue.toString());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
    }

    static void testStack() {
        SimpleStack<Integer> stack = new SimpleStack<>();
        System.out.println(stack.pop());
        System.out.println(stack.peek());
        stack.push(1);
        stack.add(3);
        stack.add(5);
        stack.add(4);
        System.out.println(stack.toString());
        System.out.println(stack.pop());
        System.out.println(stack.peek());
    }

    public static void main(String[] args) {

        //testArraylist();
        //testLinkedList();
        //testQueue();
        testStack();
    }
}
