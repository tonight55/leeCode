package leecode.javaSE.P;

/**
 * 　　* @author lee
 * 　　* @date 2022/6/2 17:40
 */
public class Worker extends Person{
    public Worker() {
    }

    public Worker(String name) {
        super(name);
    }

    @Override
    public void toEat() {
        System.out.println("worker to eat");
    }

    @Override
    public void toExercise() {

    }

    @Override
    public void toStudy() {

    }

}
