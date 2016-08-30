import java.util.ArrayList;
import java.util.Date;

/**
 * @author Mark
 *
 */
public interface RecurringTaskInterface {
	
	// Any children will need the following class variables
	// Recurrence recurrence = null;
	// Date rootDate = null;
	
	/**
	 * Returns the rootDate the recurrence is calculated off of.
	 * @return The Date the task recurrence is calculated from.
	 */
	Date getRootDate();
	
	/**
	 * Sets a new rootDate for the task.
	 * @param newRootDate The new Date object the task will be calculated off of.
	 */
	void setRootDate(Date newRootDate);
	
	/**
	 * Retrieves the recurrence for the task. NOTE: Does not return dates.
	 * @return the Recurrence Object for the task.
	 */
	Recurrence getRecurrence();
	
	/**
	 * Sets a new recurrence for the task.
	 */
	void setRecurrence(Recurrence newRecurrence);
	
	/**
	 * Need to generate the next n number of recurrences.
	 * @return An ArrayList of the next n Dates per the recurrence formula.
	 */
	ArrayList<Date> generateNextDates(int n);
	
	/**
	 * Generate the next recurrences through the provided date.
	 * @param date The date to generate recurrences through.
	 * @return An ArrayList of the dates that fit the recurrence pattern before the provided date.
	 */
	ArrayList<Date> generateThroughDate(Date date);
	
	/**
	 * Finds the date in the series closest to the provided date.
	 * @param date The target date to find to relate to the series.
	 * @return The date which is closest to the target date. 
	 */
	Date findClosestDate(Date date);
	
	/**
	 * Finds the next date in the series from a target date.
	 * @param date The target date from which to find the next date (inclusive).
	 * @return The date which is next following the target date.
	 */
	Date findNextDate(Date date);
	
	/**
	 * Generates the next n dates after the target date.
	 * @param startDate The date from which the series is generated (inclusive). 
	 * @param n The number of dates to be generated.
	 * @return An ArrayList<Date> of the next n dates in the series.
	 */
	ArrayList<Date> generateFromDateNextDates(Date startDate, int n);
	
	/**
	 * Generates the dates in the series between the startDate and he endDate.
	 * @param startDate The first date from which to generate (inclusive).
	 * @param endDate The last date to generate through (inclusive).
	 * @return An ArrayList<Date> of the dates in the series between the startDate and the endDate.
	 */
	ArrayList<Date> generateFromDateThroughDate(Date startDate, Date endDate);
	
	/**
	 * Allows the rootDate to be updated so it's not in the past. 
	 */
	void updateRootDate(); //Might not use this for history-keeping's sake. 
}
