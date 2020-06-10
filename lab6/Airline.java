package lab6;

import lab8.EmptyPlaneSetException;

import java.util.Comparator;
import java.util.Scanner;

public class Airline {
    public Plane[] airlines;
    public int counter;

    public void addNewPlane(Plane x) {
        this.airlines = addPlane(this.airlines, x, counter++);
    }

    public static Plane[] addPlane(Plane[] arr, Plane x, int n) {
        int i;
        Plane newarr[] = new Plane[n + 1];
        for (i = 0; i < n; i++)
            newarr[i] = arr[i];
        newarr[n] = x;
        return newarr;
    }

    public Plane[] getRange(Plane[] x) throws EmptyPlaneSetException {
        if (x.length == 0) {
            throw new EmptyPlaneSetException("Неможливо знайти діапазон оскільки даний масив пустий!");
        }
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
            } finally {
                if (!tr) {
                    if (a >= b) {
                        System.out.println("Верхня межа має бути більшою ніж нижня!!!");
                        tr = true;
                    }
                }
            }
        }
        return fuelRange(x, a, b);
    }

    public int countCapacity(Plane[] x) {

        int capacityCounter = 0;
        for (int i = 0; i < x.length; i++) {
            capacityCounter += x[i].capacity;
        }
        return capacityCounter;
    }

    public int countCarryingCapacity(Plane[] x) {
        int carrying_capacity_counter = 0;
        for (int i = 0; i < x.length; i++) {
            carrying_capacity_counter += x[i].carryingCapacity;
        }
        return carrying_capacity_counter;
    }

    public static Plane[] fuelRange(Plane[] x, int a, int b) throws EmptyPlaneSetException {
        if (x.length == 0) {
            throw new EmptyPlaneSetException("Неможливо знайти діапазон оскільки даний масив пустий!");
        }
        int length = 0;
        Plane[] fuel_range = new Plane[0];
        for (int i = 0; i < x.length; i++) {
            if (x[i].fuelConsumption >= a && x[i].fuelConsumption <= b) {
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

class sortRangeOfFlight implements Comparator<Plane> {

    @Override
    public int compare(Plane o1, Plane o2) {
        return (o2.rangeOfFlight - o1.rangeOfFlight);
    }
}
