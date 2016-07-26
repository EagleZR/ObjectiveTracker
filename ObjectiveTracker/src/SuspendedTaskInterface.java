import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Mark
 *
 */
public interface SuspendedTaskInterface {
	
	Date suspense = new Date();
	
	/**
	 * Sets a new suspense off of the given Date.
	 * @param setSuspense The new suspense to be stored.
	 */
	void setSuspense(Date setSuspense);
	
	/**
	 * Retrieves the stored suspense.
	 * @return The Date object of the current suspense. 
	 */
	Date getSuspense();
	
	/**
	 * http://stackoverflow.com/questions/1555262/calculating-the-difference-between-two-java-date-instances
	 * Calculate the amount of time between the current Date and the startDate based off of the given units.
	 * @return The long representation of the difference between new Date() and startDate.
	 */
	long getTimeRemainingToStart(TimeUnit timeUnit);
}
