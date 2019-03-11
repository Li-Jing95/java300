package LinkedList;

public class Node<E> {
    Node previous;//上一个节点
    Node next;//下一个节点
    E element;//保存的元素数据

    //构造方法
    public Node(Node previous, Node next, E element) {
        super();
        this.previous = previous;
        this.next = next;
        this.element = element;
    }

    public Node(E element) {
        super();
        this.element = element;
    }
}
