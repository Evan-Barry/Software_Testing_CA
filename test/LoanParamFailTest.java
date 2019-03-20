import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(value = Parameterized.class)

public class LoanParamFailTest  {

    private IllegalArgumentException expected;
    private int amount;
    private int period;

    public LoanParamFailTest(int amount, int period, IllegalArgumentException expected)
    {
        this.amount = amount;
        this.period = period;
        this.expected = expected;
    }

    @Parameterized.Parameters (name="{index}: getRate({0}, {1}) = {2}")
    public static Collection<Object[]> getTestParameters() {
        return Arrays.asList(new Object[][] {
                {400, 0, new IllegalArgumentException()},//Test Case 4
                {20000, 6, new IllegalArgumentException()},//Test Case 5
                {499, 1, new IllegalArgumentException()},//Test Case 8
                {10001, 5, new IllegalArgumentException()},//Test Case 9
                {-1, 1, new IllegalArgumentException()},//Test Case 10
        });
    }

    @Test (expected = IllegalArgumentException.class)
    public void testCheckRateFail()
    {
        Loan l = new Loan(amount, period);
        assertEquals(expected, l.getRate());
    }

}