package lab6;

public class Plane {
    public String name;
    public int capacity;
    public int carrying_capacity;
    public int range_of_flight;
    public int fuel_consumption;
    public Plane (String nm, int cap, int car_cap, int r_of_flight, int fuel_cons){
        name = nm;
        capacity = cap;
        carrying_capacity = car_cap;
        range_of_flight = r_of_flight;
        fuel_consumption = fuel_cons;
    }
    public static int count_capacity(Plane [] x){
        int capacity_counter = 0;
        for(int i = 0; i < x.length; i++){
            capacity_counter += x[i].capacity;
        }
        return capacity_counter;
    }
    public static int count_carrying_capacity(Plane [] x){
        int carrying_capacity_counter = 0;
        for(int i = 0; i < x.length; i++){
            carrying_capacity_counter += x[i].carrying_capacity;
        }
        return carrying_capacity_counter;
    }
    public static Plane[] fuelRange(Plane[] x, int a, int b) {
        int length = 0;
        Plane [] fuel_range = new Plane[0];
        for (int i = 0; i < x.length; i++) {
            if (x[i].fuel_consumption >= a && x[i].fuel_consumption <= b) {
                fuel_range = Airline.addPlane(fuel_range, x[i], length++);
            }
        }
        if (length == 0) {
            return null;
        } else {
            return fuel_range;
        }
    }
}