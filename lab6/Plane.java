package lab6;

import lab8.WrongValueException;

public class Plane {
    public String name;
    public int capacity;
    public int carryingCapacity;
    public int rangeOfFlight;
    public int fuelConsumption;

    public Plane(String nm, int cap, int carCap, int rOfFlight, int fuelCons) throws WrongValueException {
        if (cap <= 0 | carCap <= 0 | rOfFlight <= 0 | fuelCons <= 0) {
            throw new WrongValueException("Один або більше параметрів було задано не коректно!");
        }
        name = nm;
        capacity = cap;
        carryingCapacity = carCap;
        rangeOfFlight = rOfFlight;
        fuelConsumption = fuelCons;
    }

    @Override
    public String toString() {
        return name;
    }
}