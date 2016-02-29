import java.text.SimpleDateFormat;
import java.util.Date;

import org.joda.time.DateTime;




public class BabySitter {

	private static final int MIDNIGHT = 24;
	private static final int AFTER_MIDNIGHT_PAY = 16;
	private static final int START_TIME_TO_BED_TIME_PAY = 12;
	private static final int BED_TIME_TO_MIDNIGHT_PAY = 8;
	
	
	public String paytotal(String starttime, String bedtime, String endtime) {
		
		SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");		
		Date d1 = null;
		Date d2 = null;
		Date d3 = null;
		int start=0;
		int bed=0;
		int end=0;

		try {
			d1 = format.parse(starttime);
			d2 = format.parse(bedtime);
			d3 = format.parse(endtime);

			DateTime dt1 = new DateTime(d1);
			DateTime dt2 = new DateTime(d2);
			DateTime dt3 = new DateTime(d3);
			
			start=dt1.getHourOfDay();
			

			if (dt1.getDayOfMonth()==dt2.getDayOfMonth()){
				 bed= dt2.getHourOfDay();	
			}
			else{
				 bed=24+dt2.getHourOfDay();
				 
			}
			 System.out.println(bed);
			
			if(dt1.getDayOfMonth()==dt3.getDayOfMonth()){
				end=dt3.getHourOfDay();
			}else{
				 end=24+dt3.getHourOfDay();
			}
			if(start<5){
				 start=start+24;
				 bed=bed+24;
				 end=end+24;
			 }

		 } catch (Exception e) {
			e.printStackTrace();
		 }
		
				
		Integer total=0;
		
		//Checking if the time start-time is after 5am
		if (start<17)
		return "EnterStartTimegreaterThan5pm";
		
		//Checking if the end-time is before 4am
		if(end>28)
		return"EnterEndTimeLessThan4am";
		
		total+=beforebedtime( start,  bed,  end);
		total+=betweenBedtimeAndMidnight( start,  bed,  end);
		total+=afterMidnight( start,  bed,  end);
		
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