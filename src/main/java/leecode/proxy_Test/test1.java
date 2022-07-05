package leecode.proxy_Test;

public class test1 {
    public static void main(String[] args) {
        System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles","true");
        UserInterface user = new User();
        UserProxy userProxy = new UserProxy();
        userProxy.setTarget(user);

        UserInterface userP = (UserInterface) userProxy.getUserProxy();
        userP.login("111", "222");
    }
}
