package leecode.javaSE;

import java.util.Date;

/**
 * 基础概念/语法：
 * 面向对象（继承、封装、多态）基础、extend\private\重写与重载
 * 包、package\import
 * 类、class
 * 接口、interface(implement)
 * 方法、
 * 对象、new
 * 属性、get\set
 * <p>
 * 　　* @author lee
 * 　　* @date 2022/5/31 17:03
 * * @describe
 */
public class BasicConcept {
    private static JavaApplication javaApplication;

    public static void main(String[] args) {
        javaApplication = new JavaApplication("lee", new Date());
        System.out.println(javaApplication.toString());
    }
}

class JavaApplication {
    private String name;
    private Date date;

    public JavaApplication() {
    }

    public JavaApplication(String name, Date date) {
        this.name = name;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "JavaApplication{" +
                "name='" + name + '\'' +
                ", date=" + date +
                '}';
    }
}
