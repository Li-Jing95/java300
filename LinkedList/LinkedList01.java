package LinkedList;

/**
 * 自定义一个链表
 */
public class LinkedList01<E> {
    private Node first;//第一个节点
    private Node last;//最后一个节点
    private int size;

    public static void main(String[] args) {
        LinkedList01 l = new LinkedList01();
        l.add("a");
        l.add("b");
        l.add("c");
        System.out.println(l);
    }

    //现在是[]
    //把a加进去  -->  ["a"]
    //把a,b,c加进去  -->  ["a","b","c"]
    public void add(E obj) {
        Node node = new Node(obj);//建立一个节点
        //第一次放数据时：
        if (first == null) {
            node.previous = null;
            node.next = null;
            first = node;
            last = node;
        } else {
            node.previous = last;
            node.next = null;
            last.next = node;
            last = node;
        }
    }

    public int size() {
        return size();
    }

    public String toString() {
        //[a,b,c] first=a,last=c
        StringBuilder sb = new StringBuilder("[");
        Node temp = first;
        while (temp != null) {
            sb.append(temp.element + ",");
            temp = temp.next;
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }
}
