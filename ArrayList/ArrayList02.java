package ArrayList;

public class ArrayList02<E> {
    private static final int DEFALT_CAPACITY = 10;//默认长度设置为10
    private Object[] elemenData;//定义核心数组
    private int size;//数组元素个数

    public ArrayList02() {
        elemenData = new Object[DEFALT_CAPACITY];
    }

    public ArrayList02(int capacity) {
        elemenData = new Object[capacity];
    }

    public static void main(String[] args) {
        ArrayList02 h1 = new ArrayList02(20);
        h1.add("aa");
        h1.add("bb");
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
        elemenData[size++] = element;
    }
}
