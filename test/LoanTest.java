import org.junit.Test;

import static org.junit.Assert.*;

public class LoanTest {

    Loan l = new Loan();//Testing blank constructor

    Loan L = new Loan(2000, 3);//Testing multi-argument constructor

    @Test
    public void testGetAmount()
    {
        assertEquals(2000, L.getAmount(), 0);
    }

    @Test
    public void testGetPeriod()
    {
        assertEquals(3, L.getPeriod());
    }

    @Test
    public void testGetRate()
    {
        assertEquals(10, L.getRate(), 0);
    }

    @Test
    public void testGetMonthlyPayment()
    {
        assertEquals(64.55824, L.getMonthlyPayment(), 1);
    }

    @Test
    public void testGetTotalPayment()
    {
        assertEquals(2324.10, L.getTotalPayment(), 1);
    }


}