
 import static org.junit.Assert.*;
 import org.junit.After;
 import org.junit.Before;
 import org.junit.Test;

public class NateTests {
    static Terminal terminal = new Terminal();
    static Program program = new Program();
    Provider provider = new Provider();
    Service service = new Service();


    @Before
    public void setUp(){
        service.setName("test");
        service.setPrice(1);
        provider.addService(service);

    }
	

	@Test
	public void testGetTotalFee() {
        ProviderReport proReport = new ProviderReport(provider, provider.getServicesProvided(), "12/22/2002");
        int balance = proReport.getTotalFee();
		assertEquals(1, balance);
	}

    public void testGetTotalConsults() {
        //ProviderReport 
    }

    @After
    public void tearDown(){
        terminal.prompt("Test Passed!");
    }

}