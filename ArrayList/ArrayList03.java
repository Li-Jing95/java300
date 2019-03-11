package ArrayList;

public class ArrayList03<E> {
    private static final int DEFALT_CAPACITY = 10;//默认长度设置为10
    private Object[] elemenData;//定义核心数组
    private int size;//数组元素个数

    public ArrayList03() {
        elemenData = new Object[DEFALT_CAPACITY];
    }

    public ArrayList03(int capacity) {
        elemenData = new Object[capacity];
    }

    public static void main(String[] args) {
        ArrayList03 h1 = new ArrayList03(20);
        for (int i=0;i<40;i++){
            h1.add("haha"+i);
        }
            System.out.println(h1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elemenData[i] + ",");
        }
        sb.setCharAt(sb.length() - 1, ']');
        return sb.toString();
    }

    public void add(E element) {
        //什么时候扩容？
        if (size == elemenData.length) {
            //怎么扩容？扩容操作
            Object[] newArray = new Object[elemenData.length + (elemenData.length >> 1)];//原基础加上它的一半 10+10/2=15 加法的优先级大于左移 所以加括号括起来
            System.arraycopy(elemenData, 0, newArray, 0, elemenData.length);
            elemenData = newArray;
        }
        elemenData[size++] = element;
    }
}
