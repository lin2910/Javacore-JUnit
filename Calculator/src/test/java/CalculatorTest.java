import org.junit.Ignore;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
    static private final Calculator calculator = Calculator.instance.get();
    static int[] a = new int[]{0, 1, 14, -90, -4, -3, 93124, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, Integer.MIN_VALUE};
    static int i;


    @AfterEach
    public void afterEach() {
        i = i == 11 ? 0 : i;
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3, 51, -2, 8, -6, 12564, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE})
    public void testPlus ( int b) {
        int exceptedResult = a[i] + b;
        int result = calculator.plus.apply(a[i], b);
        i++;

        Assertions.assertEquals(result, exceptedResult);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3, 51, -2, 8, -6, 12564, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE})
    public void testMinus (int b) {
        int exceptedResult =  a[i] - b;

        int result = calculator.minus.apply(a[i], b);
        i++;
        Assertions.assertEquals(result, exceptedResult);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3, 51, -2, 8, -6, 12564, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE})
    public void testMultiply (int b) {
        int exceptedResult = a[i]*b;

        int result = calculator.multiply.apply(a[i], b);
        i++;
        Assertions.assertEquals(result, exceptedResult);
    }

    @ParameterizedTest
    @ValueSource(ints = {7, 3, 51, -2, 8, -6, 12564, Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE})
    public void testDevice (int b){
        int exceptedResult = a[i]/b;

        int result = calculator.device.apply(a[i],b);
        i++;
        Assertions.assertEquals(result, exceptedResult);
    }

    @Test
    public void testDeviceByZero(){
        int b = 0, exceptedResult = 0;

        int result = calculator.device.apply(a[i], b);

        Assertions.assertEquals(result, exceptedResult);
    }

    @Ignore ("Function do not throw exception")
    @Test
    public void testDeviceException( ) {
        int b = 0;

        Assertions.assertThrows(ArithmeticException.class,
                () -> calculator.device.apply(a[i], b));

        //TODO
        // make calculator.device throw exception
    }

    @Test
    public void testPow() {
        int exceptedResult = (int) Math.pow(a[i],2);

        int result = calculator.pow.apply(a[i]);

        Assertions.assertEquals(result, exceptedResult);
    }

    @Test
    public void testAbs() {
        int exceptedResult = Math.abs(a[i]);

        int result = calculator.abs.apply(a[i]);

        Assertions.assertEquals(result, exceptedResult);
    }
}
