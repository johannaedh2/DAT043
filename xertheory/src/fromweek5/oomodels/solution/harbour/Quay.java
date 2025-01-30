package fromweek5.oomodels.solution.harbour;

import java.util.ArrayList;
import java.util.List;

public class Quay {
    List<QuayPlace> places = new ArrayList<>();

    public boolean berth(Ship ship) {
        for (QuayPlace p : places) {
            if (!p.isOccupied() && p.getDepth() > ship.getDepth()
                    && p.getLength() > ship.getLength()) {
                p.setShip(ship);
                return true;
            }
        }
        return false;
    }

}