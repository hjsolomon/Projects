import org.junit.Test;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.LinkedList;

import static org.junit.Assert.*;

public class Examples {
    TodaysRatings tr = new TodaysRatings((new GregorianCalendar(2022, 11, 7)), (new LinkedList<Integer>()), (new LinkedList<Integer>()));
    Survey s1 = new Survey(3, 2);
    Survey s2 = new Survey(2, 0);
    Survey s3 = new Survey(1, 40);

    @Test
    public void testSameMonthSameYear(){
        assertTrue(tr.sameMonth(11, 2022));
    }

    @Test
    public void testSameMonthDifYear(){
        assertFalse(tr.sameMonth(12, 2021));
    }

    @Test
    public void testDifMonthSameYear(){
        assertFalse(tr.sameMonth(10, 2022));
    }

    @Test public void testDifMonthDifYear(){
        assertFalse(tr.sameMonth(10, 2021));
    }
}
