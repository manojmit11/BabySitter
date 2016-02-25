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
		
		assertEquals("EnterStartTimegreaterThan5pm", babySitter.paytotal(16,20,25));
	}
	
	@Test
	public void ifEndTimeisAfter4amReturnEnterEndTimeLessThan4am(){
		
		assertEquals("EnterEndTimeLessThan4am",babySitter.paytotal(19,20,29));
	}
	
	@Test
	public void shouldGetPaid12dollarsBeforeBedTime(){
		
		assertEquals(24,babySitter.beforebedtime(18,20,27));
	}
	
	

}
