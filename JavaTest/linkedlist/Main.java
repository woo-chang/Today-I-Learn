package JavaTest.linkedlist;

public class Main {
    public static void main(String[] args) {
        // Node<Integer> node1 = new Node<>(1);
        // Node<Integer> node2 = new Node<>(2);

        // node1.next = node2;
        // System.out.println(node1.next.data);

        SingleLinkedList<Integer> MyLinkedList = new SingleLinkedList<>();
        MyLinkedList.addNode(1);
        MyLinkedList.addNode(2);
        MyLinkedList.addNode(3);

        MyLinkedList.addNodeInside(5, 2);
        MyLinkedList.addNodeInside(7, 10);

        MyLinkedList.printAll();
    }
}
