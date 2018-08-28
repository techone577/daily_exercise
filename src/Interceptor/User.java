package Interceptor;

public class User implements IUser {
    private String name;

    public User(String name){
        this.name=name;
    }
    @Override
    public String getName () {
        return name;
    }
}
