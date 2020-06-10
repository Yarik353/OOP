package lab6;

import lab8.WrongValueException;

public class PrivatePlane extends Plane {

    public PrivatePlane(String nm, int cap, int carCap, int rOfFlight, int fuelCons) throws WrongValueException {
        super(nm, cap, carCap, rOfFlight, fuelCons);
    }
}
