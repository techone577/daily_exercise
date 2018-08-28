package thread;

public class VarArgs {

    public static Object t(Object... args){
        return args.length;
    }
    public static void main(String []args){
        System.out.print(VarArgs.t("a",2,'c',100.2));
    }
}
