package lab6;

import lab8.WrongValueException;

public class Plane {
    public String name;
    public int capacity;
    public int carrying_capacity;
    public int range_of_flight;
    public int fuel_consumption;
    public Plane (String nm, int cap, int car_cap, int r_of_flight, int fuel_cons)throws WrongValueException {
        if (cap<=0 | car_cap<=0 | r_of_flight<=0|fuel_cons<=0){
            throw new WrongValueException("Один або більше параметрів було задано не коректно!");
        }

        name = nm;
        capacity = cap;
        carrying_capacity = car_cap;
        range_of_flight = r_of_flight;
        fuel_consumption = fuel_cons;
    }


    @Override
    public String toString() {
        return name;
    }
}