


public class BabySitter {

	private static final int MIDNIGHT = 24;
	private static final int AFTER_MIDNIGHT_PAY = 16;
	private static final int START_TIME_TO_BED_TIME_PAY = 12;
	private static final int BED_TIME_TO_MIDNIGHT_PAY = 8;
	
	
	public String paytotal(Integer starttime, Integer bedtime, Integer endtime) {
		
				
		Integer total=0;
		
		//Checking if the time start-time is after 5am
		if (starttime<17)
		return "EnterStartTimegreaterThan5pm";
		
		//Checking if the end-time is before 4am
		if(endtime>28)
		return"EnterEndTimeLessThan4am";
		
		total+=beforebedtime( starttime,  bedtime,  endtime);
		total+=betweenBedtimeAndMidnight( starttime,  bedtime,  endtime);
		total+=afterMidnight( starttime,  bedtime,  endtime);
		
		return total.toString();
		
	}

	// Calculating the amount to be paid for start-time to bed-time
	public int beforebedtime(int start, int bed, int end) {
		
		if((start <= bed) && (start <= MIDNIGHT))
		{
			return (Math.min(Math.min(bed, MIDNIGHT),end)-start)*START_TIME_TO_BED_TIME_PAY;
		}
		return 0;
	}

	// Calculating the amount to be paid for bed-time to Midnight
	public int betweenBedtimeAndMidnight(int start, int bed, int end) {
		
		if((MIDNIGHT >= bed) && (end >= bed))
			return (Math.min(MIDNIGHT,end) - Math.max(start,bed))*BED_TIME_TO_MIDNIGHT_PAY;


		return 0;

	}
  
	//Calculating the amount to be paid for the time from Midnight to End-time
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