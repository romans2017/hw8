import ua.goit.scollections.*;

class Test1 {
    @Override
    public String toString() {
        return "Test1" + hashCode();
    }
}

class Test2 extends Test1 {
    @Override
    public String toString() {
        return "Test2" + hashCode();
    }
}

class Test3 extends Test1 {
    @Override
    public String toString() {
        return "Test3" + hashCode();
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
        System.out.println(arrayList.toString());
        arrayList.add(new Test2());
        arrayList.remove(0);
        System.out.println(arrayList.toString());
        System.out.println(arrayList.size());
        arrayList.clear();
        System.out.println(arrayList.toString());
    }

    static void testLinkedList() {
        SimpleLinkedList<Integer> linkedList = new SimpleLinkedList<>();
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

    static void testHashMap() {
        SimpleHashMap<Test1, String> hashMap = new SimpleHashMap<>(8);
        Test1 test1 = new Test1();
        Test1 test2 = new Test2();
        Test1 test3 = new Test3();
        Test1 test4 = new Test3();
        hashMap.put(test1, "NULLL");
        hashMap.put(test2, "100");
        hashMap.put(test3, "poiuyt");
        hashMap.put(test4, "789");
        System.out.println(hashMap);
        System.out.println(hashMap.size());
        System.out.println(hashMap.get(test1));
        hashMap.remove(test2);
        System.out.println(hashMap);
        System.out.println(hashMap.size());
        hashMap.put(test3, "qwerty");
        System.out.println(hashMap);
        System.out.println(hashMap.size());
        hashMap.clear();
        System.out.println(hashMap);
        System.out.println(hashMap.size());
    }

    public static void main(String[] args) {

        testArraylist();
        testLinkedList();
        testQueue();
        testStack();
        testHashMap();
    }
}
