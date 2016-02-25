
public class BabySitter {

	public String paytotal(Integer starttime, Integer bedtime, Integer endtime) {
		
		if (starttime<17)
		return "EnterStartTimegreaterThan5pm";
		
		if(endtime>28)
		return"EnterEndTimeLessThan4am";
		
		return null;
	}

}
