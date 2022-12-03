/*Author: Ethan Flores, Annya Evans
 *
 * A timer that triggers the main accounting procedure
 * 
 */
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
public class FridayTimer {
	public void setTimer() {
        Timer timer = new Timer();
        Calendar date = Calendar.getInstance();
        date.set(Calendar.DAY_OF_WEEK,Calendar.FRIDAY);
        date.set(Calendar.HOUR, 0);
        date.set(Calendar.MINUTE, 0);
        date.set(Calendar.SECOND, 0);
        date.set(Calendar.MILLISECOND, 0);
        // Schedule to run every Friday in midnight
        timer.schedule(new MainAccountingProcedure(),date.getTime(),1000 * 60 * 60 * 24 * 7);
	}
	public class FridayTimer.string getTime() {
		string time;
		time = 
		return time;
	}

}
