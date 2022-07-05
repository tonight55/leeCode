package leecode.javaSE;

/**
 * 数据类型：1）基本数据类型8种：byte、short、int、long、float、double、char、boolean；
 * <p>
 * Java八大数据类型：
 * （1）整数类型：byte、short、int、long
 * （2）小数类型：float、double
 * （3）字符类型：char
 * （4）布尔类型：boolean
 * <p>
 * <p>
 * 1、 整数数据类型
 * <p>
 * byte：1个字节，8位，256种状态，取值范围为【-128,127】
 * short：2个字节，16位，65536种状态，取值范围为【-32768,32767】
 * int：4个字节，32位，整数类型默认是int类型，取值范围约21亿
 * long：8个字节，64位，long类型表示long类型常量，要加L或者l，建议加L
 * <p>
 * 2、 小数数据类型
 * <p>
 * float：4个字节，32位，单精度，能精确到6~7位，声明一个小数类型，要加F或者f，建议加F
 * double：8个字节，64位，双精度，能精确到15~16位，小数类型默认是double类型
 * <p>
 * 3、 字符数据类型
 * char：2个字节，16位，字符表示Unicode（万国码）编码表中的每一个符号，每个符号使用单引号引起来，其中前128个符号和ASCII表相同
 * 4、 布尔数据类型
 * boolean：占1位，有true和false2个值，一个表示真，一个表示假，一般用于表示逻辑运算
 * <p>
 * <p>基本数据类型转换:
 * byte、short、char—>int—>long—>float—>double
 * byte、short、char相互之间不转换，他们参与运算首先转换为int类型
 * <p>
 * 所有的byte、short、char类型被自动提升到int类型，再参与运算
 * 整个表达式的最终结果类型，被提升到表达式中类型最高的类型
 * 强制类型转换，也称为“显式类型转换”，就是把范围大的数据类型强制转换成范围小的数据类型。PS：一般情况下不建议使用强转，因为强转有可能损失精度以及溢出的情况
 * <p>
 * 基本数据类型与String的转换
 * 通过包装类的#Parse方法及#toString方法转化。
 * <p>
 * <p>
 * 2）引用数据类型
 * 引用数据类型分3种：类，接口，数组；
 * <p>
 * <p>
 * 引用数据类型与基本数据类型的主要区别：
 *
 *
 * 引用类型在堆里，基本类型在栈里。
 * <p>
 * 栈空间小且连续，往往会被放在缓存。引用类型cache miss率高且要多一次解引用。
 * <p>
 * 对象还要再多储存一个对象头，对基本数据类型来说空间浪费率太高
 * <p>
 * 　　* @author lee
 * 　　* @date 2022/5/31 17:14
 */
public class DataType {
    private byte aByte = Byte.MAX_VALUE;
    private byte aByte2 = Byte.MIN_VALUE;
    private short aShort = Short.MAX_VALUE;
    private int anInt = Integer.MAX_VALUE;
    private long aLong = Long.MAX_VALUE;
    private float aFloat = Float.MAX_VALUE;
    private double aDouble = Double.MAX_VALUE;
    private char aChar = 'a';
    private boolean aBoolean = true;

    public byte getaByte2() {
        return aByte2;
    }

    public void setaByte2(byte aByte2) {
        this.aByte2 = aByte2;
    }

    public DataType() {
    }

    @Override
    public String toString() {
        return "DataType{" + "\n" +
                "aByte=" + aByte + "\n" +
                "aShort=" + aShort + "\n" +
                "anInt=" + anInt + "\n" +
                "aLong=" + aLong + "\n" +
                "aFloat=" + aFloat + "\n" +
                "aDouble=" + aDouble + "\n" +
                "aChar=" + aChar + "\n" +
                "aBoolean=" + aBoolean + "\n" +
                '}';
    }

    public static void main(String[] args) {


    }



}
