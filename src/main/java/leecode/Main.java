package leecode;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws Exception {


        Class<?> aClass = Class.forName("leecode.Student");
        Method sleep = aClass.getMethod("sleep", Integer.class);
        sleep.invoke(aClass.getConstructor().newInstance(),100);

    }

}
