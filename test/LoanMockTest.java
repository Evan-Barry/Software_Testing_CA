import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.easymock.EasyMock.expect;
import static org.junit.Assert.*;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Loan.class)
public class LoanMockTest {
    @Test
    public void testCustomer() throws Exception
    {
        System.out.println("In Test");
        Loan l = new Loan(5000,5);

        Customer mockCustomer = EasyMock.createMock(Customer.class);

        PowerMock.expectNew(Customer.class, "Tom Murphy").andReturn(mockCustomer);

        expect(mockCustomer.getMonthlypayments()).andReturn(96.66401);

        PowerMock.replay(mockCustomer, Customer.class);

        double expResult = 96.66401;
        double result = l.getMonthlyPayment();
        assertEquals(expResult, result, 0.05);

        //PowerMock.verify(mockCustomer, Customer.class);
    }
}