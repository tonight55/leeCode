package leecode.javaSE.P;

/**
 * 　　* @author lee
 * 　　* @date 2022/6/2 17:45
 */
public class MainDemo {
    public static void main(String[] args) {

    }

    public void toExam(Person person) {
        if (person instanceof Teacher || person instanceof StuderT) {
            System.out.println("ok");
        }
    }
}
