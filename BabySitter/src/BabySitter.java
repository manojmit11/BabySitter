
public class BabySitter {

	public String paytotal(Integer starttime, Integer bedtime, Integer endtime) {
		
		if (starttime<17)
		return "EnterStartTimegreaterThan5pm";
		
		if(endtime>28)
		return"EnterEndTimeLessThan4am";
		
		return null;
	}

	public int beforebedtime(Integer starttime, Integer bedtime, Integer endtime) {
		
		if((starttime <= bedtime) && (starttime <= 24))
		{
			return (Math.min(Math.min(bedtime, 24),endtime)-starttime)*12;
		}
		return 0;
	}

	public int betweenBedtimeAndMidnight(Integer starttime, Integer bedtime, Integer endtime) {
		if((endtime>=bedtime)&&(bedtime<=24))
		{
		
		return (Math.min(24,endtime) - Math.max(starttime,bedtime))*8;
		}
		return 0;
	}

		
	

}
