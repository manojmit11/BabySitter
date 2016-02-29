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
		
		assertEquals("EnterStartTimegreaterThan5pm", babySitter.paytotal("01/14/2012 14:29:58","01/14/2012 21:29:58","01/14/2012 23:29:58"));
	}
	
	
	@Test
	public void ifEndTimeisAfter4amReturnEnterEndTimeLessThan4am(){
		
		assertEquals("EnterEndTimeLessThan4am",babySitter.paytotal("01/14/2012 20:29:58","01/14/2012 21:29:58","01/15/2012 05:29:58"));
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
		
		assertEquals("104",babySitter.paytotal("01/14/2012 18:00:00","01/14/2012 20:00:00","01/15/2012 03:00:00"));
	}
	
	
	@Test
	public void whenStartTimeAndBedTimeAreSame()
	{
		assertEquals("80", babySitter.paytotal("01/14/2012 20:00:00","01/14/2012 20:00:00","01/15/2012 03:00:00"));
	}
	
	@Test
	public void whenBedTimeAndEndTimeAreSameAnd()
	{
		assertEquals("24", babySitter.paytotal("01/14/2012 18:00:00","01/14/2012 20:00:00","01/14/2012 20:00:00"));
	}
	
	@Test
	public void whenStartTimeIsEqualToBedTimeIsEqualToEndTime()
	{
		assertEquals("0", babySitter.paytotal("01/14/2012 20:00:00","01/14/2012 20:00:00","01/14/2012 20:00:00"));
	}
	
	@Test
	public void whenAllTimesDifferentAfterMidnight()
	{
		assertEquals("32", babySitter.paytotal("01/14/2012 01:00:00","01/14/2012 02:00:00","01/14/2012 03:00:00"));
	}

	

}