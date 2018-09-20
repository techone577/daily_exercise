package thread;

import java.util.ArrayList;
import java.util.List;

public class Teacher {
    List<observer> list = new ArrayList<>();

    public void addObserver (observer o) {
        list.add(o);
    }

    public void remove (observer o) {
        for (observer observer : list) {
            if (observer == o)
                list.remove(o);
        }
    }

    public void notifyObs (String str) {
        for (observer observer : list)
            observer.update(str);
    }

    public static void main (String []args) {
        Teacher teacher = new Teacher();
        observer o1 = new observer(1);
        observer o2 = new observer(2);
        teacher.addObserver(o1);
        teacher.addObserver(o2);
        teacher.notifyObs("homework");
    }
}
