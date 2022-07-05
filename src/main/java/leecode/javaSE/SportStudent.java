package leecode.javaSE;

/**
 * 　　* @author lee
 * 　　* @date 2022/6/2 16:29
 */
public class SportStudent extends Student {

    public SportStudent() {
    }

    public SportStudent(String name, Integer age, Integer id) {
        super(name, age, id);
    }

    @Override
    public void toStudy() {
        System.out.println(getName() + ": toRunning");
    }
}
