import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LandonTests {

	@Before
	public void setUp() throws Exception {
	}
	@Test
	public void testgetServicedMember() {
		Data database = Data.getInstance();
		database.clearSevicedMembers();
		Member mem = new Member();
		mem.setFirstName("Landon");
		mem.setLastName("Bostic");
		database.addServicedMember(mem);
		assertEquals(mem, database.getServicedMember(0));
	}

    @Test
	public void testclearSevicedMembers() {
		Data database = Data.getInstance();
		Member m = new Member();
		database.addServicedMember(m);
		database.clearSevicedMembers();
		assertTrue(database.checkServicedMembers());
	}

	@Test
	public void testgetFirstName(){
		Person me=new Person();
		me.setFirstName("Landon");
		assertEquals("Landon",me.getFirstName());
	}	

}