package lab8;

import lab6.Boeing;
import lab6.Plane;
import lab7.PlaneSet;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        try {
            new Boeing("Боінг 337-A",300, 15000, 0, 100);
            PlaneSet ps = new PlaneSet();
            System.out.print("Загальна місткість літаків: ");
            System.out.println(ps.count_capacity());
            System.out.print("Загальна вантажопідйомність літаків: ");
            System.out.println(ps.count_carrying_capacity());
            PlaneSet fuel_range = ps.get_range();
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
        }
        catch (EmptyPlaneSetException e){
            System.out.println(e.getMessage());
        }
        catch (WrongValueException e){
            System.out.println(e.getMessage());
        }
    }
}

