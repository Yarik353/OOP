package lab6;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Airline airline = new Airline();
        airline.add_new_plane(new Boeing("Боінг 337-A",300, 15000, 3000, 100));
        airline.add_new_plane(new An_225_Mria( "Mрія",20, 200000, 2000, 300));
        airline.add_new_plane(new Private_plane("Приватний літак MZ-390",10, 2000, 4000, 50));
        Plane [] fuel_range = airline.get_range(airline.airlines);
        System.out.println("Літаки у компанії, що відповідають заданому діапазону споживання пального.");
        for(int i = 0; i < fuel_range.length; i++){
            System.out.println(fuel_range[i].name);
        }
        System.out.print("Загальна місткість авіакомпані: ");
        System.out.println(Plane.count_capacity(airline.airlines));
        System.out.print("Загальна вантажопідйомність авіакомпані: ");
        System.out.println(Plane.count_carrying_capacity(airline.airlines));
        System.out.println("Літаки компанії, сортовані за дальністю польоту:");
        Arrays.sort(airline.airlines, new sort_range_of_flight());
        for(int i = 0; i < airline.airlines.length; i++){
            System.out.println(airline.airlines[i].name);
        }
    }
}
