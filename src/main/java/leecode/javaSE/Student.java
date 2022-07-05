package leecode.javaSE;

/**
 * 　　* @author lee
 * 　　* @date 2022/6/2 16:24
 */
public class Student {
    public String name;
    public Integer age;
    private Integer id;

    public Student() {
    }

    public Student(String name, Integer age, Integer id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public void toStudy() {
        System.out.println(getName() + ": toStudy");

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
