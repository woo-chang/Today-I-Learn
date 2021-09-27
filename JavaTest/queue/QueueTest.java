package JavaTest.queue;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {

    public static void main(String[] args) {
        Queue<Integer> intQueue = new LinkedList<>();
        Queue<String> strQueue = new LinkedList<>();
        intQueue.add(1);
        intQueue.add(2);
        intQueue.add(3);
        System.out.println(intQueue);
        Integer i = intQueue.poll();
        System.out.println(intQueue);
        strQueue.offer("A");
        strQueue.offer("B");
        strQueue.offer("C");
        System.out.println(strQueue);
        String s = strQueue.remove();
        System.out.println(strQueue);
    }
}