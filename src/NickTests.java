/*
 * Author: Nicholas Warren
 * 
 * Runs tests on certain parts of the code 
 *
 */

 import static org.junit.Assert.*;
 import org.junit.After;
 import org.junit.Before;
 import org.junit.Test;

public class NickTests {
    static Data database = Data.getInstance();
    static Terminal terminal = new Terminal();
    static Program program = new Program();
    @Before
    public void setUp(){
        terminal.prompt("---------------------------------");
    }
    @Test
    public void test1(){ //tests password protection, made by Nick.
        Provider provider = new Provider();
        String user, pass;
        int errors = 0;
        user = "apple";
        pass = "orange";
        provider.setUser(user);
        provider.setPassword(pass);
        if(provider.verifyProvider(user,pass)){ //attempt with correct user name/ pass word

        } else {
            errors++;
            //terminal.prompt("Correct Sign in error!");
        }
        if(!provider.verifyProvider("banana", "orange")){//attempt with incorrect username/password.

        } else {
            errors++;
            //terminal.prompt("Incorrect signin worked!");
        }
        assertEquals(errors, 0);
    }
    @Test
    public void test2(){ //Nick's Test
        int errors = 0;
        //initialized objects
        Member member = new Member();
        Provider provider = new Provider();
        Manager manager = new Manager();
        Operator operator = new Operator();
        Data database2 = Data.getInstance();
        //sets all with default names
        member.setFirstName("Bob");
        member.setLastName("Burton");

        manager.setFirstName("Joe");
        manager.setLastName("Johnson");

        provider.setFirstName("Charlie");
        provider.setLastName("Chaplin");

        operator.setFirstName("Stacy");
        operator.setLastName("Stark");
        //add to database
        database.addManager(manager);
        database.addMember(member);
        database.addOperator(operator);
        database.addProvider(provider);
        //test data is shared
        if(database2.getManager(0) != database.getManager(0)) errors++;
        if(database2.getMember(0) != database.getMember(0)) errors++;
        if(errors == 0); //terminal.prompt("Error in database");
        //test search functions
        String correctName, incorrentName;
        correctName = "Bob Burton";
        incorrentName = "Ethan Ezikial";
        if(database.findMember(correctName) == null) errors++;
        if(database.findManager(incorrentName) != null) errors++;

        assertEquals(errors, 0);
    }
    @Test
    public void test3(){ //Test by Nick
        int errors = 0;
        Provider provider = new Provider();
        Member member = new Member();
        Service service = new Service();

        service.setName("Knee Surgery");
        service.setCode(12345);
        service.setPrice(100);

        provider.setFirstName("Jorge");
        provider.setLastName("Smith");

        member.setFirstName("Nick");
        member.setLastName("Warren");

        database.addMember(member);
        database.addProvider(provider);
        database.addService(service);

        if(database.numMembers() != 2) errors++;
        if(database.numProviders() != 2) errors++;
        if(database.numServices() != 1) errors++;
        if(database.numManagers() != 1) errors++;
        if(database.numOperators() != 1) errors++;

        assertEquals(errors, 0);
    }
    @After
    public void tearDown(){
        terminal.prompt("Test Passed!");
    }
}
