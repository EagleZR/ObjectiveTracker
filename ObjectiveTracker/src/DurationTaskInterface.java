import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Mark
 * 
 */
public interface DurationTaskInterface {
	
	// Any children will need the following class variables
	// Date startDate = new Date();
	// Date endDate = new Date();

	/**
	 * Retrieves the stored startDate for the Task.
	 * @return Returns the startDate object for the task.
	 */
	Date getStartDate();
	
	/**
	 * Sets a new startDate for the Task.
	 * @param newStartDate The new startDate to be stored for the Task.
	 */
	void setStartDate(Date newStartDate);
	
	/**
	 * Retrieves the current endDate for the Task.
	 * @return Returns the stored endDate.
	 */
	Date getEndDate();
	
	/**
	 * Establishes a new endDate for the task.
	 * @param newEndDate The new endDate the task will use.
	 */
	void setEndDate(Date newEndDate);
	
	/**
	 * http://stackoverflow.com/questions/1555262/calculating-the-difference-between-two-java-date-instances
	 * Calculate the amount of time between the startDate and the endDate based on the given units (usually will be minutes or seconds).
	 * @param timeUnit Will either be TimeUnit.SECONDS or TimeUnit.MINUTES usually.
	 * @return The long representation of the difference between endDate and startDate.
	 */
	long getDuration(TimeUnit timeUnit);
	
	/**
	 * http://stackoverflow.com/questions/1555262/calculating-the-difference-between-two-java-date-instances
	 * Calculate the amount of time between the current Date and the startDate based off of the given units.
	 * @return The long representation of the difference between new Date() and startDate.
	 */
	long getTimeRemainingToStart(TimeUnit timeUnit);
	
	/**
	 * http://stackoverflow.com/questions/1555262/calculating-the-difference-between-two-java-date-instances
	 * Calculate the amount of time between the current Date and the endDate based off of the given units.
	 * @return The long representation of the difference between new Date() and endDate.
	 */
	long getTimeRemainingToEnd(TimeUnit timeUnit);
}
