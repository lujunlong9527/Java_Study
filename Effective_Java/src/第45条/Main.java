package 第45条;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * <p>将局部变量的作用域最小化</p>
 *
 * @author ljl
 * @date 2018/12/18
 **/
public class Main {

    public static void main(String[] args) {
        List<Integer> c = new ArrayList<>();
        c.add(1);
        List<Integer> c2 = new ArrayList<>();
        c2.add(1);
        //不好的写法
        testBad(c, c2);
        //正确的写发
        testGood(c, c2);
    }

    private static void testBad(List<Integer> c, List<Integer> c2){
        Iterator<Integer> i = c.iterator();
        while (i.hasNext()){
            System.out.println(i.next());
        }
        Iterator<Integer> i2 = c2.iterator();
        //这里使用了i，是个BUG 复制粘贴容易出现，且很难发现
        while (i.hasNext()){
            System.out.println(i.next());
        }
    }

    private static void testGood(List<Integer> c, List<Integer> c2){
        //传统的for循坏
        for (Iterator<Integer> i = c.iterator(); i.hasNext();){
            System.out.println(i.next());
        }
        //这里如果使用i2.hasNext(),会直接报错
        for (Iterator<Integer> i = c2.iterator(); i.hasNext();){
            System.out.println(i.next());
        }

    }
}
