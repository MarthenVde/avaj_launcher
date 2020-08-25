package weather;

import aircraft.Flyable;
import java.util.ArrayList;
import java.util.List;

public class Tower {
    private List<Flyable> observers =  new ArrayList<>();

    public void register(Flyable flyable) {
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        observers.remove(flyable);
    }

    protected void conditiondsChanged() {
        for (int i = 0; i < observers.size(); i++) {
            observers.get(i).updateConditions();
        }
    }
}