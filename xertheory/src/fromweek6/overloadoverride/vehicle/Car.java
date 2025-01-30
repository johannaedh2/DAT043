package fromweek6.overloadoverride.vehicle;

// See TestVehicle
public class Car extends Vehicle {
    private final int numbSeats;

    public Car(int licNumb, int numbSeats) {
        super(licNumb);
        this.numbSeats = numbSeats;
    }

    public boolean equals(Car c) {
        if (this == c) {
            return true;
        } else if (!super.equals(c)) {
            return false;
        } else if (getClass() != c.getClass()) {
            return false;
        }
        final Car other = (Car) c;
        return numbSeats == other.numbSeats;
    }
}
