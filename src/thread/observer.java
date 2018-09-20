package thread;

public class observer {
    public int id;

    public observer (int i) {
        this.id = i;
    }

    public void update (String str) {
        System.out.println(id+str);
    }

}
