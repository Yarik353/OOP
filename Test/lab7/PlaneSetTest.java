package lab7;

import lab6.Boeing;
import lab6.Plane;
import lab6.PrivatePlane;
import org.junit.Assert;
import org.junit.Test;

public class PlaneSetTest {

    @Test
    public void count_capacity() {
        int expected_capacity = 700;
        Boeing boeing1 = new Boeing("Боінг 337-A",300, 15000, 3000, 100);
        Boeing boeing2 = new Boeing("Боінг 338-A",400, 10000, 3020, 120);
        PlaneSet ps1 = new PlaneSet(boeing1);
        ps1.add(boeing2);
        Assert.assertEquals(expected_capacity, ps1.countCapacity());
    }

    @Test
    public void count_carrying_capacity() {
        int expected_carrying_capacity = 25000;
        Boeing boeing1 = new Boeing("Боінг 337-A",300, 15000, 3000, 100);
        Boeing boeing2 = new Boeing("Боінг 338-A",400, 10000, 3020, 120);
        PlaneSet ps1 = new PlaneSet(boeing1);
        ps1.add(boeing2);
        Assert.assertEquals(expected_carrying_capacity, ps1.countCarryingCapacity());
    }

    @Test
    public void fuelRange() {
        Boeing boeing1 = new Boeing("Боінг 337-A",300, 15000, 3000, 100);
        Boeing boeing2 = new Boeing("Боінг 338-A",400, 10000, 3020, 120);
        PrivatePlane private_plane = new PrivatePlane("Боінг 339-A",500, 10000, 3020, 120);
        PlaneSet ps1 = new PlaneSet(boeing1);
        ps1.add(boeing2);
        ps1.add(private_plane);
        PlaneSet fuel_range = ps1.fuelRange(0, 400);
        PlaneSet expected_range = new PlaneSet(boeing1);
        expected_range.add(boeing2);
        Assert.assertEquals(expected_range, fuel_range);
    }

    @Test
    public void sort_rf() {
        Boeing boeing1 = new Boeing("Боінг 337-A",300, 15000, 3000, 100);
        Boeing boeing2 = new Boeing("Боінг 338-A",400, 10000, 3020, 120);;
        PlaneSet ps1 = new PlaneSet(boeing1);
        ps1.add(boeing2);
        ps1.sort_rf();
        PlaneSet ps2 = new PlaneSet(boeing2);
        ps1.add(boeing1);
        Assert.assertTrue(ps1.equals(ps2));
    }

    @Test
    public void add() {
        Boeing boeing = new Boeing("Боінг 337-A",300, 15000, 3000, 100);
        PlaneSet ps = new PlaneSet();
        ps.add(boeing);
        Assert.assertEquals(1, ps.size());
        Assert.assertTrue(ps.contains(boeing));
    }

    @Test
    public void addAll() {
        Boeing boeing1 = new Boeing("Боінг 337-A",300, 15000, 3000, 100);
        Boeing boeing2 = new Boeing("Боінг 338-A",400, 10000, 3020, 120);
        PlaneSet ps1 = new PlaneSet();
        ps1.add(boeing1);
        ps1.add(boeing2);
        PlaneSet ps2 = new PlaneSet();
        ps2.addAll(ps1);
        Assert.assertTrue(ps2.equals(ps1));
    }

    @Test
    public void clear() {
        Boeing boeing1 = new Boeing("Боінг 337-A",300, 15000, 3000, 100);
        Boeing boeing2 = new Boeing("Боінг 338-A",400, 10000, 3020, 120);
        PlaneSet ps1 = new PlaneSet();
        ps1.add(boeing1);
        ps1.add(boeing2);
        PlaneSet empty_ps = new PlaneSet();
        ps1.clear();
        Assert.assertTrue(ps1.equals(empty_ps));
    }

    @Test
    public void contains() {
        Boeing boeing1 = new Boeing("Боінг 338-A",400, 10000, 3020, 120);
        PlaneSet ps1 = new PlaneSet();
        ps1.add(boeing1);
        Assert.assertTrue(ps1.contains(boeing1));
    }

    @Test
    public void containsAll() {
        Boeing boeing1 = new Boeing("Боінг 337-A",300, 15000, 3000, 100);
        Boeing boeing2 = new Boeing("Боінг 338-A",400, 10000, 3020, 120);
        PlaneSet ps1 = new PlaneSet(boeing1);
        ps1.add(boeing2);
        PlaneSet ps2 = new PlaneSet(ps1);
        Assert.assertTrue(ps2.containsAll(ps1));
    }

    @Test
    public void isEmpty() {
        Boeing boeing1 = new Boeing("Боінг 337-A",300, 15000, 3000, 100);
        PlaneSet ps1 = new PlaneSet(boeing1);
        Assert.assertFalse(ps1.isEmpty());
    }

    @Test
    public void remove() {
        Boeing boeing1 = new Boeing("Боінг 337-A",300, 15000, 3000, 100);
        PlaneSet ps1 = new PlaneSet(boeing1);
        ps1.remove(boeing1);
        Assert.assertEquals(0, ps1.size());
        Assert.assertFalse(ps1.contains(boeing1));
    }

    @Test
    public void removeAll() {
        Boeing boeing1 = new Boeing("Боінг 337-A",300, 15000, 3000, 100);
        Boeing boeing2 = new Boeing("Боінг 338-A",400, 10000, 3020, 120);
        PrivatePlane private_plane = new PrivatePlane("Боінг 339-A",500, 10000, 3020, 120);
        PlaneSet ps1 = new PlaneSet(boeing1);
        ps1.add(boeing2);
        ps1.add(private_plane);
        PlaneSet ps2 = new PlaneSet(boeing1);
        ps2.add(boeing2);
        ps1.removeAll(ps2);
        PlaneSet removed_all = new PlaneSet(private_plane);
        Assert.assertTrue(ps1.equals(removed_all));
    }

    @Test
    public void retainAll() {
        Boeing boeing1 = new Boeing("Боінг 337-A",300, 15000, 3000, 100);
        Boeing boeing2 = new Boeing("Боінг 338-A",400, 10000, 3020, 120);
        PrivatePlane private_plane = new PrivatePlane("Боінг 339-A",500, 10000, 3020, 120);
        PlaneSet ps1 = new PlaneSet(boeing1);
        ps1.add(boeing2);
        ps1.add(private_plane);
        PlaneSet ps2 = new PlaneSet(boeing2);
        ps2.add(private_plane);
        ps1.retainAll(ps2);
        Assert.assertTrue(ps1.equals(ps2));
    }

    @Test
    public void size() {
        Boeing boeing1 = new Boeing("Боінг 337-A",300, 15000, 3000, 100);
        PlaneSet ps1 = new PlaneSet(boeing1);
        Assert.assertEquals(1, ps1.size());
    }

    @Test
    public void toArray() {
        Boeing boeing1 = new Boeing("Боінг 337-A",300, 15000, 3000, 100);
        PlaneSet ps1 = new PlaneSet(boeing1);
        Plane[] planes = {boeing1};
        Assert.assertArrayEquals(planes, ps1.toArray());
    }


}