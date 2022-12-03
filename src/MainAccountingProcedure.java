/*Author: Ethan Flores
 *
 * Writes this week's member reports
 * 
 
import java.util.TimerTask;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  
import java.util.Date;  
import java.util.Calendar;  
import java.util.ArrayList;
class MainAccountingProcedure extends TimerTask{
	ArrayList<MemberReport> WeekList = new ArrayList<MemberReport>();
	private Data database = Data.getInstance();
	public void run(){
        Date date = Calendar.getInstance().getTime();  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss");  
        String strDate = dateFormat.format(date);  
		for(int i=0; i<database.numServiced();i++) {
			WeekList.add(new MemberReport(database.getServicedMember(i),database.getServicedMember(i).getServices(), strDate));
			WeekList.get(i).writeFile();
		}
		database.clearSevicedMembers();
		WeekList.clear();
	}
	void updateRecords(){
		
	}
}*/