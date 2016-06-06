/**
 * Created by kriszhang on 16/6/6.
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