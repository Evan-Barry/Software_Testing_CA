import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)

public class LoanParamTest {

    private double expected;
    private int amount;
    private int period;

    public LoanParamTest(int amount, int period, double expected)
    {
        this.amount = amount;
        this.period = period;
        this.expected = expected;
    }

    @Parameterized.Parameters (name="{index}: getRate({0}, {1}) = {2}")
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][] {
                {600, 2, 10},//Test Case 1
                {500, 1, 10},//Test Case 2
                {10000,5,5},//Test Case 3
                {2000, 4, 6},//Test Case 11
                {7000, 2, 8},//Test Case 12
        });
    }

    @Test
    public void testCheckRateAll()
    {
        Loan l = new Loan(amount, period);
        assertEquals(expected, l.getRate(),1);
    }

}