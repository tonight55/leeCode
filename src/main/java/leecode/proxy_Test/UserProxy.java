package leecode.proxy_Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserProxy implements InvocationHandler {
    Object target;

    public void setTarget(Object object){
        this.target=object;
    }
    public Object getTarget(){
        return this.target;
    }
    public Object getUserProxy(){
        return Proxy.newProxyInstance(this.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object object = method.invoke(target, args);
        After();
        return object;
    }
    static int i=0;
    public void before(){
        i++;
        System.out.println("被代理类的方法执行之前的增强方法"+i);
    }
    public void After(){
        System.out.println("被代理类的方法执行之后的增强方法");
    }
}
