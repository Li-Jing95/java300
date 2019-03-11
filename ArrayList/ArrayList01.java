package ArrayList;

public class ArrayList01 {
    private static final int DEFALT_CAPACITY = 10;//默认长度设置为10
    private Object[] elemenData;//定义核心数组
    private int size;//数组元素个数

    public ArrayList01() {
        elemenData = new Object[DEFALT_CAPACITY];
    }

    public ArrayList01(int capacity) {
        elemenData = new Object[capacity];
    }

    public static void main(String[] args) {
        ArrayList01 h1 = new ArrayList01(20);
        h1.add("aa");
        h1.add("bb");
        System.out.println(h1);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
//        for (Object obj : elemenData) {
//            sb.append(obj + ",");
//        }
//        sb.append("]");
        for (int i=0;i<size;i++){
            sb.append(elemenData[i]+",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public void add(Object obj) {
        elemenData[size++] = obj;
    }

}
