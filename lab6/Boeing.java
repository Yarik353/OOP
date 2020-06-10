package lab6;

import lab8.WrongValueException;

public class Boeing extends Plane {

    public Boeing(String nm, int cap, int carCap, int rOfFlight, int fuelCons) throws WrongValueException {
        super(nm, cap, carCap, rOfFlight, fuelCons);
    }
}

