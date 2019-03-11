package ArrayList;

public class ArrayList04<E> {
    private static final int DEFALT_CAPACITY = 10;//默认长度设置为10
    private Object[] elemenData;//定义核心数组
    private int size;//数组元素个数

    public ArrayList04() {
        elemenData = new Object[DEFALT_CAPACITY];
    }

    public ArrayList04(int capacity) {
        //判断容器的容量
        if (capacity < 0) {
            throw new RuntimeException("容器的容量不能为负数");
        } else if (capacity == 0) {
            ////若为0则创建一个容量为10的容器
            elemenData = new Object[DEFALT_CAPACITY];
        } else
            elemenData = new Object[capacity];
    }

    public static void main(String[] args) {
        ArrayList04 h1 = new ArrayList04(20);
        for (int i = 0; i < 40; i++) {
            h1.add("haha" + i);
        }
        System.out.println(h1.get(40));//调用get方法获取索引为7的内容
        h1.set("ddddd", 7);//调用set方法对索引为7的内容进行设置
        System.out.println(h1);//打印修改后的内容
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
            //原基础加上它的一半 10+10/2=15 加法的优先级大于左移 所以加括号括起来
            Object[] newArray = new Object[elemenData.length + (elemenData.length >> 1)];
            System.arraycopy(elemenData, 0, newArray, 0, elemenData.length);
            elemenData = newArray;
        }
        elemenData[size++] = element;
    }

    public E get(int index) {
        //还要判断索引问题 索引是否合法？ 在不在所涉范围之内？
        checkRange(index);
        return (E) elemenData[index];
    }

    public void set(E element, int index) {
        checkRange(index);
        elemenData[index] = element;
    }

    public void checkRange(int index) {
        //检查索引是否合法
        //索引合法判断  合法位置[0,size] 如果是10 则合法区间是0-9
        if (index < 0 || index > size - 1) {
            //不合法
            throw new RuntimeException("索引位置不合法：" + index);//手动抛出异常
        }
    }
}
