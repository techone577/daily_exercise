package Cglibproxy;

public class test {

    public static void main(String []args){
        User user = new User();
        UserCglib userCglib = new UserCglib();
        User proxy = (User)userCglib.getInstance(user);
        System.out.print(proxy.getName("hello"));
    }
}
