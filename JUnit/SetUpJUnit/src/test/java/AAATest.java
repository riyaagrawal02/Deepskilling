import org.junit.After;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class AAATest {

    private Calculator calculator;

    @Before
    public void setUp() {
        System.out.println("Setup: Creating Calculator Object");
        calculator = new Calculator();
    }

    @After
    public void tearDown() {
        System.out.println("Teardown: Cleaning Resources");
        calculator = null;
    }

    @Test
    public void testAddition() {

        int num1 = 10;
        int num2 = 20;

        int result = calculator.add(num1, num2);

        assertEquals(30, result);
    }
}