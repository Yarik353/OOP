package lab7;

import lab6.Plane;
import lab8.EmptyPlaneSetException;

import java.util.*;

public class PlaneSet implements Set<Plane> {

    private List s = new List();
    private int size = 0;

    public PlaneSet() {
    }

    public PlaneSet(Plane stn) {
        add(stn);
    }

    public PlaneSet(Collection<? extends Plane> stn) {
        addAll(stn);
    }

    @Override
    public boolean add(Plane stn) {
        boolean flag = true;
        Node t = s.getHead();
        while (t != null) {
            if (t.data == stn) {
                flag = false;
                break;
            }
            t = t.next;
        }
        if (flag) {
            s.addBack(stn);
            size++;
        }
        return flag;
    }

    @Override
    public boolean addAll(Collection<? extends Plane> c) {
        Iterator<? extends Plane> iterator = c.iterator();
        boolean flag = true;
        while (iterator.hasNext()) {
            flag &= add((Plane) iterator.next());
        }
        return flag;
    }

    @Override
    public void clear() {
        size = 0;
        s = new List();
    }

    @Override
    public boolean contains(Object o) {
        boolean flag = add((Plane) o);
        if (flag) {
            s.delEl((Plane) o);
        }
        return !flag;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        boolean flag = true;
        Iterator<Plane> iterator = (Iterator<Plane>) c.iterator();
        while (iterator.hasNext()) {
            flag = contains((Plane) iterator.next());
            if (flag == false) {
                break;
            }
        }
        return flag;
    }

    @Override
    public boolean isEmpty() {
        return s.getHead() == null;
    }

    @Override
    public Iterator<Plane> iterator() {
        return new PlaneIterator();
    }

    @Override
    public boolean remove(Object o) {
        if (contains(o)) {
            s.delEl((Plane) o);
            size--;
            return true;

        } else {
            return false;
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {

        boolean flag = false;
        for (Object object : c) {
            flag = remove(object);
        }
        return flag;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean flag = true;
        Iterator<Plane> iterator = iterator();
        while (iterator.hasNext()) {
            Plane Plane = (Plane) iterator.next();
            flag = c.contains(Plane);
            if (flag == false)
                remove(Plane);
        }
        return flag == false;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] toArray() {
        int i = 0;
        Plane[] mas = new Plane[size];
        Iterator<Plane> iterator = iterator();
        while (iterator.hasNext()) {
            mas[i] = iterator.next();
            i++;

        }
        return mas;
    }

    @Override
    public <T> T[] toArray(T[] array) {
        return null;
    }

    class PlaneIterator implements Iterator {
        private Node thisElement = s.getHead();

        @Override
        public boolean hasNext() {
            return thisElement != null;
        }

        @Override
        public Plane next() {
            Plane s = thisElement.data;
            thisElement = thisElement.next;
            return s;
        }

        @Override
        public void remove() {
            s.delEl(thisElement.data);
        }
    }


    public PlaneSet get_range() throws EmptyPlaneSetException {
        if (size==0){
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
        return fuelRange(a, b);
    }
    public  int countCapacity() {
        int capacity_counter = 0;
        Iterator iterator = iterator();
        while (iterator.hasNext()){
            Plane nxt = (Plane) iterator.next();
            capacity_counter += nxt.capacity;
        }
        return capacity_counter;
    }

    public  int countCarryingCapacity() {
        int carrying_capacity_counter = 0;
        Iterator iterator = iterator();
        while (iterator.hasNext()){
            Plane nxt = (Plane) iterator.next();
            carrying_capacity_counter += nxt.carryingCapacity;
        }
        return carrying_capacity_counter;
    }
    public PlaneSet fuelRange(int a, int b) throws EmptyPlaneSetException {
        if (size==0){
            throw new EmptyPlaneSetException("Неможливо знайти діапазон оскільки даний масив пустий!");
        }
        Plane[] x = (Plane[]) toArray();
        int length = 0;
        PlaneSet fuel_range = new PlaneSet();
       for (int i = 0; i < x.length; i++) {
            if (x[i].fuelConsumption >= a && x[i].fuelConsumption <= b) {
                fuel_range.add(x[i]);
                length++;
            }
        }
        if (length == 0) {
            return null;
        } else {
            return fuel_range;
        }
    }
    public Plane [] sort_rf (){
        Plane[] x = (Plane[]) toArray();
        Arrays.sort(x, new sortRangeOfFlight());
        return x;
    }
}
class sortRangeOfFlight implements Comparator<Plane>{
    @Override
    public int compare( Plane o1, Plane o2){return (o2.rangeOfFlight - o1.rangeOfFlight);}
}
