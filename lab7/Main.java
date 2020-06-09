package lab7;

import lab6.An_225_Mria;
import lab6.Boeing;
import lab6.Plane;
import lab6.Private_plane;



import java.util.Iterator;
public class Main {

    public static void main(String[] args) {
        Boeing boeing = new Boeing("Боінг 337-A",300, 15000, 3000, 100);
        Boeing other_boeing = new Boeing("Боінг B-389",320, 17000, 3100, 110);
        PlaneSet ps = new PlaneSet();
        ps.add(boeing);
        ps.add(other_boeing);
        ps.remove(other_boeing);
        PlaneSet ps2 = new PlaneSet(ps);
        ps2.add(boeing);
        ps2.add(new An_225_Mria( "Mрія",20, 200000, 2000, 300));
        ps2.add(boeing);
        ps2.add(new Private_plane("Приватний літак MZ-390",10, 2000, 4000, 50));
        System.out.println("Літаки:");
        Iterator iterator = ps2.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        PlaneSet fuel_range = ps2.get_range();
        System.out.println("Літаки у компанії, що відповідають заданому діапазону споживання пального.");
        if (fuel_range==null){
            System.out.println("Таких літаків немає!");
        }
        else{
            Iterator iter = fuel_range.iterator();
            while(iter.hasNext()){
                Plane pl = (Plane) iter.next();
                System.out.println(pl+ " діапазон споживання пального: " + pl.fuel_consumption);
            }}
        System.out.print("Загальна місткість літаків: ");
        System.out.println(ps2.count_capacity());
        System.out.print("Загальна вантажопідйомність літаків: ");
        System.out.println(ps2.count_carrying_capacity());
        System.out.println("Літаки, сортовані за дальністю польоту:");
        Plane [] sorted_by_rf = ps2.sort_rf();
        for(Plane obj : sorted_by_rf){
            System.out.println(obj + " дальність польоту: " + obj.range_of_flight);
        }

    }
}
