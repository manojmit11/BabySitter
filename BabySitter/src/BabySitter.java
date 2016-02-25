
public class BabySitter {

	private static final int MIDNIGHT = 24;
	private static final int AFTER_MIDNIGHT_PAY = 16;
	private static final int START_TIME_TO_BED_TIME_PAY = 12;
	private static final int BED_TIME_TO_MIDNIGHT_PAY = 8;

	
	public String paytotal(Integer starttime, Integer bedtime, Integer endtime) {
		
		Integer total=0;
		if (starttime<17)
		return "EnterStartTimegreaterThan5pm";
		
		if(endtime>28)
		return"EnterEndTimeLessThan4am";
		
		total+=beforebedtime( starttime,  bedtime,  endtime);
		total+=betweenBedtimeAndMidnight( starttime,  bedtime,  endtime);
		total+=afterMidnight( starttime,  bedtime,  endtime);
		
		return total.toString();
		
	}

	public int beforebedtime(Integer starttime, Integer bedtime, Integer endtime) {
		
		if((starttime <= bedtime) && (starttime <= MIDNIGHT))
		{
			return (Math.min(Math.min(bedtime, MIDNIGHT),endtime)-starttime)*START_TIME_TO_BED_TIME_PAY;
		}
		return 0;
	}

	public int betweenBedtimeAndMidnight(Integer starttime, Integer bedtime, Integer endtime) {
		if((endtime>=bedtime)&&(bedtime<=MIDNIGHT))
		{
		
		return (Math.min(MIDNIGHT,endtime) - Math.max(starttime,bedtime))*BED_TIME_TO_MIDNIGHT_PAY;
		}
		return 0;
	}

	public int afterMidnight(Integer starttime, Integer bedtime, Integer endtime) {
		if((endtime >= MIDNIGHT))
		{
			Integer pay=0;
			pay= (endtime-Math.max(starttime, MIDNIGHT))*AFTER_MIDNIGHT_PAY;
			return pay;
		}
		return 0;
	}

		
	

}
