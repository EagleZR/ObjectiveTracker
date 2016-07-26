import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Mark
 *
 */
public class RecurringDurationTask extends Task implements DurationTaskInterface, RecurringTaskInterface {

	private static final long serialVersionUID = 8051400611745247486L;

	public RecurringDurationTask() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param taskName
	 * @param setSummary
	 * @param setDescription
	 * @param setOwner
	 * @param setGame
	 */
	public RecurringDurationTask(String taskName, String setSummary, String setDescription, Character setOwner,
			Game setGame) {
		super(taskName, setSummary, setDescription, setOwner, setGame);
		// TODO Auto-generated constructor stub
	}
	
	

	/* (non-Javadoc)
	 * @see RecurringTaskInterface#getRootDate()
	 */
	@Override
	public Date getRootDate() {
		// TODO Auto-generated method stub
		return super;
	}

	/* (non-Javadoc)
	 * @see RecurringTaskInterface#setRootDate(java.util.Date)
	 */
	@Override
	public void setRootDate(Date newRootDate) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see RecurringTaskInterface#getRecurrence()
	 */
	@Override
	public Recurrence getRecurrence() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see RecurringTaskInterface#setRecurrence(Recurrence)
	 */
	@Override
	public void setRecurrence(Recurrence newRecurrence) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see RecurringTaskInterface#generateNextDates(int)
	 */
	@Override
	public ArrayList<Date> generateNextDates(int n) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see RecurringTaskInterface#generateThroughDate(java.util.Date)
	 */
	@Override
	public ArrayList<Date> generateThroughDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see RecurringTaskInterface#findClosestDate(java.util.Date)
	 */
	@Override
	public Date findClosestDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see RecurringTaskInterface#findNextDate(java.util.Date)
	 */
	@Override
	public Date findNextDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see RecurringTaskInterface#generateFromDateNextDates(java.util.Date, int)
	 */
	@Override
	public ArrayList<Date> generateFromDateNextDates(Date startDate, int n) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see RecurringTaskInterface#generateFromDateThroughDate(java.util.Date, java.util.Date)
	 */
	@Override
	public ArrayList<Date> generateFromDateThroughDate(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see RecurringTaskInterface#updateRootDate()
	 */
	@Override
	public void updateRootDate() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see DurationTaskInterface#getStartDate()
	 */
	@Override
	public Date getStartDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see DurationTaskInterface#setStartDate(java.util.Date)
	 */
	@Override
	public void setStartDate(Date newStartDate) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see DurationTaskInterface#getEndDate()
	 */
	@Override
	public Date getEndDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see DurationTaskInterface#setEndDate(java.util.Date)
	 */
	@Override
	public void setEndDate(Date newEndDate) {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see DurationTaskInterface#getDuration(java.util.concurrent.TimeUnit)
	 */
	@Override
	public long getDuration(TimeUnit timeUnit) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see DurationTaskInterface#getTimeRemainingToStart(java.util.concurrent.TimeUnit)
	 */
	@Override
	public long getTimeRemainingToStart(TimeUnit timeUnit) {
		// TODO Auto-generated method stub
		return 0;
	}

	/* (non-Javadoc)
	 * @see DurationTaskInterface#getTimeRemainingToEnd(java.util.concurrent.TimeUnit)
	 */
	@Override
	public long getTimeRemainingToEnd(TimeUnit timeUnit) {
		// TODO Auto-generated method stub
		return 0;
	}

}
