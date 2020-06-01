package lab7;
import lab6.Plane;

import java.lang.reflect.Array;
import java.util.*;

public class PlaneSet implements Set<Plane> {
    private int size = 0;
    private List list = new List();
    public PlaneSet(){

    }
    public PlaneSet(Plane o){
        add(o);
    }
    public PlaneSet(Collection<Plane> collection) {
        addAll(collection);
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size==0;
    }

    @Override
    public boolean contains(Object o) {
        Iterator<Plane> iterator = iterator();
        while (iterator.hasNext()) {
            if (o.equals(iterator.next())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Plane> iterator() {
        return new Iterator<Plane>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Plane next() {
                return list.next();
            }
        };
    }

    @Override
    public Object[] toArray() {
        Plane[] arr = new Plane[size];
        for(int i =0; i<size; i++){
            arr[i] = list.next();
        }
        return arr;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    /**
     *
     * @param Plane музична композиція для додавання в колекцію
     * @return чи змінилася колекція
     * @throws WrongТривалістьValueException коли композиція коротша за 10 секунд
     */
    @Override
    public boolean add(Plane o) {
        if (Plane.віддайТривалість() < MIN_TRACK_TIME_LENGTH) {
            throw new WrongТривалістьValueException("Проблема в тому, що тривалість композиції < 10, і не можна " +
                    "додати у альбом такий трек");
        }
        list.add(o);
        size++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Plane> c) {
        /*Iterator<? extends Plane> iterator = c.iterator();
        while (iterator.hasNext()) {
            add(iterator.next());
        }*/
        for (Plane Plane : c) {
            add(Plane);
        }
        //todo fix return value
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
