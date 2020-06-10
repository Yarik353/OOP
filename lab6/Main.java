package lab6;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Airline airline = new Airline();
        airline.addNewPlane(new Boeing("Боінг 337-A",300, 15000, 3000, 100));
        airline.addNewPlane(new An225Mria( "Mрія",20, 200000, 2000, 300));
        airline.addNewPlane(new PrivatePlane("Приватний літак MZ-390",10, 2000, 4000, 50));
        Plane [] fuel_range = airline.getRange(airline.airlines);
        System.out.println("Літаки у компанії, що відповідають заданому діапазону споживання пального.");
        if (fuel_range==null){
            System.out.println("Таких літаків немає!");
        }
        else{
        for(int i = 0; i < fuel_range.length; i++){
            System.out.println(fuel_range[i].name);
        }}

        System.out.print("Загальна місткість авіакомпані: ");
        System.out.println(airline.countCapacity(airline.airlines));
        System.out.print("Загальна вантажопідйомність авіакомпані: ");
        System.out.println(airline.countCarryingCapacity(airline.airlines));
        System.out.println("Літаки компанії, сортовані за дальністю польоту:");
        Arrays.sort(airline.airlines, new sortRangeOfFlight());
        for(int i = 0; i < airline.airlines.length; i++){
            System.out.println(airline.airlines[i].name);
        }
    }
}
