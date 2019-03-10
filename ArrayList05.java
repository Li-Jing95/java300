public class ArrayList05<E> {
    private static final int DEFALT_CAPACITY = 10;//默认长度设置为10
    private Object[] elemenData;//定义核心数组
    private int size;//数组元素个数

    public ArrayList05() {
        elemenData = new Object[DEFALT_CAPACITY];
    }

    public ArrayList05(int capacity) {
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
        ArrayList05 h1 = new ArrayList05(20);
        for (int i = 0; i < 40; i++) {
            h1.add("haha" + i);
        }
        System.out.println(h1.get(39));//调用get方法获取索引为7的内容
        h1.set("ddddd", 7);//调用set方法对索引为7的内容进行设置
        System.out.println(h1);//打印修改后的内容

        h1.remove(3);
        h1.remove("haha4");
        System.out.println(h1);

        System.out.println(h1.size);
        System.out.println(h1.isEmpty());
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

    public void remove(E element) {
        //element，将它和所有元素挨个比较，获得第一个比较为true的，返回。
        for (int i = 1; i < size; i++) {
            if (element.equals(get(i))) {//容器中所有的比较操作用的都是equals而不是==
                //将该元素从此处移除
                remove(i);
            }
        }
    }

    public void remove(int index) {
        //a,b,c,d,e,f,g,h
        //a,b,c,e,f,g,h
        //相当于把e,f,g,h拷贝到e的位置上
        int numMoved = elemenData.length - index - 1;//要移动的个数
        if (numMoved > 0) {
            //要拷贝的数据，从第几个开始拷贝，要拷贝的数据，拷贝到哪儿，拷贝的数量
//            src:源数组；
//            srcPos:源数组要复制的起始位置；
//            dest:目的数组；
//            destPos:目的数组放置的起始位置；
//            length:复制的长度。
//            注意：src and dest都必须是同类型或者可以进行转换类型的数组．
            System.arraycopy(elemenData, index + 1, elemenData, index, numMoved);
        }
        elemenData[size - 1] = null;
        size--;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }
}
