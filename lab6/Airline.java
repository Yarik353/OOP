package lab6;

import java.util.Comparator;
import java.util.Scanner;

public class Airline {
    public Plane [] airlines;
    public int counter;

    public void add_new_plane(Plane x){
        this.airlines = addPlane(this.airlines, x, counter++);
    }
    public static Plane [] addPlane(Plane[] arr, Plane x, int n){
        int i;
        Plane newarr[] = new Plane[n + 1];
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];
        newarr[n] = x;
        return  newarr;
    }
    public  Plane[] get_range(Plane [] x){
        boolean tr = true;
        int a = 0;
        int b = 0;
        System.out.println("Знайдемо літак у компанії, що відповідає заданому діапазону споживання пального.");
        while (tr) {
            try {
                System.out.println("Введіть нижню межу діапазону(від):");
                Scanner scan = new Scanner(System.in);
                String scan_a = scan.nextLine();
                a = Integer.parseInt(scan_a);
                tr = false;
            } catch (NumberFormatException e) {
                System.out.println("Введіть число!!!");
                tr = true;
            }
        }
        tr = true;
        while (tr) {
            try {
                System.out.println("Введіть верхню межу діапазону(до):");
                Scanner scan = new Scanner(System.in);
                String scan_b = scan.nextLine();
                b = Integer.parseInt(scan_b);
                tr = false;
            } catch (NumberFormatException e) {
                System.out.println("Введіть число!!!");
                tr = true;
            }finally {
                if (!tr) {
                    if (a>=b) {
                        System.out.println("Верхня межа має бути більшою ніж нижня!!!");
                        tr = true;
                    }
                }
            }
        }
        return Plane.fuelRange(x, a, b);
    }
}
class sort_range_of_flight implements Comparator<Plane>{
    @Override
    public int compare( Plane o1, Plane o2){return (o2.range_of_flight - o1.range_of_flight);}
}
