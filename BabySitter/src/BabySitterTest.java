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
	
	@Test
	public void shouldGetPaid8dollarsBetweenBedTimeAndMidNight(){
		
		assertEquals(32,babySitter.betweenBedtimeAndMidnight(18,20,27));
	}
	
	@Test
	public void shouldGetPaid16dollarsafterMidNight(){
		
		assertEquals(48,babySitter.afterMidnight(18,20,27));
	}
	
	@Test
	public void totalPayForTheNight(){
		
		assertEquals("104",babySitter.paytotal(18,20,27));
	}
	
	
	
	

}
