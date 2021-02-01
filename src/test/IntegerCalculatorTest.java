package test;


import com.pvt.helloworld.BadAException;
import com.pvt.helloworld.IntegerCalculator;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.Assert.assertEquals;

public class IntegerCalculatorTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private IntegerCalculator ic;

    @Before
    public void init() {
        ic = new IntegerCalculator(5);
    }

    @Test()
    public void testAdd() {
        ic.add(3);
    }

    @Test()
    public void testStrangeMethod() throws BadAException {
        expectedException.expect(BadAException.class);
        ic.setA(-1);
        ic.strangeMethod(-1);
    }

    @Test(expected = BadAException.class)
    public void testStrangeMethodExpected() throws BadAException {
        ic.setA(-1);
        ic.strangeMethod(-1);
    }

    @Test(expected = BadAException.class)
    public void testStrangeMethod2() throws BadAException {
        ic.setA(-1);
        ic.strangeMethod(-1);
//        assertThat(ic.strangeMethod(-1));
    }

    public void testStrangeMethodExpectedAJ() {
        ic.setA(-1);
        assertThatThrownBy(() -> ic.strangeMethod(-1)).isInstanceOf(BadAException.class);
    }


    @Test
    public void testStrangeBounds() throws BadAException {
        ic.setA(895);
//        ic.strangeMethod(100);
        assertEquals(ic.strangeMethod(100), 89500);
        ic.setA(896);
        assertEquals(ic.strangeMethod(100), -1);
        ic.setA(4);
        assertEquals(ic.strangeMethod(100), -1);
        ic.setA(5);
        assertEquals(ic.strangeMethod(100), 500);
    }

    @Test
    public void strangeIntervals() throws BadAException {
        ic.setA(200);
        assertEquals(ic.strangeMethod(-100), 300);
    }


    @After
    public void info() {
        System.out.println("Test complite");
    }

}
