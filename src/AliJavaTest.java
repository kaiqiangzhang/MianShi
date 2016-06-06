/**
 *
 * 有一点其他地方都没说的但很重要的一点我要先强调：类属性初始化时虚拟机是不会声明属性的同时赋值的，它会把所有属性和方法全部声明完了再从头按代码顺序赋值。如果你有一定水平的话你会发现在new T("t1")的时候会执行print("构造快")而print()方法中用到了还没初始化的i和n，并且值都为0。所以属性是全部声明完之后再按照顺序初始化的。

 　　我给你一个最全的顺序，按这个顺序去分析：
    类加载过程（静态属性、静态方法声明-----静态属性赋值、静态块）注意先父类后子类
    实例化过程（普通属性、普通方法声明-----普通属性赋值、构造块----构造方法中的代码）也是先父类后子类
    如果在类加载过程中调用了实例化过程（如new了本类对象），则会暂停类加载过程先执行实例化过程，执行完毕再回到类加载过程
 */

public class AliJavaTest  implements Cloneable {
    public static int k = 0;
    public static AliJavaTest t1 = new AliJavaTest("t1");
    public static AliJavaTest t2 = new AliJavaTest("t2");
    public static int i = print("i");
    public static int n = 99;

    public int j = print("j");

    {
        print("构造快");
    }

    static {
        print("静态块");
    }

    public AliJavaTest(String str) {
        System.out.println((++k) + ":" + str + "    i=" + i + "  n=" + n);
        ++n;
        ++i;
    }

    public static int print(String str) {
        System.out.println((++k) + ":" + str + "   i=" + i + "   n=" + n);
        ++n;
        return ++i;
    }

    public static void main(String[] args) {

    }
}