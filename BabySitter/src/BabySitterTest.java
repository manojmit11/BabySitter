import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class BabySitterTest {

	BabySitter babySitter;
	
	@Before
	public void setUp(){
		babySitter=new BabySitter();
	}
	
	@Test
	public void ifStartTimeisBeforefiveReturnEnterStartTimegreaterThan5pm() {
		BabySitter babySitter=new BabySitter();
		assertEquals("EnterStartTimegreaterThan5pm", babySitter.paytotal(16,20,25));
	}
	
	

}
