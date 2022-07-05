package leecode.javaSE.P;

/**
 * 　　* @author lee
 * 　　* @date 2022/6/2 17:36
 */
public abstract class Person {
    private String name;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract void toEat();
    public abstract void toExercise();
    public abstract void toStudy();
}
