package leecode.proxy_Test;

public class User implements UserInterface{
    public User() {
    }

    private final String username="lee";
    private final String password="111";

    public void login(String username,String password){
        if (username==this.username&&password==this.password){
            System.out.println("登录验证成功！");
        }else {
            System.out.println("失败！");
        }
    }





    public String getUsername() {
        return username;
    }



    public String getPassword() {
        return password;
    }


}
