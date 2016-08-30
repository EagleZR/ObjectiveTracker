import java.util.ArrayList;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Mark
 *
 */
public class RecurringDurationTask extends Task implements DurationTaskInterface, RecurringTaskInterface {

	private static final long serialVersionUID = 8051400611745247486L;

	private Date startDate = null;
	private Date endDate = null;
	private Date rootDate = null;
	private Recurrence recurrence = null;

	/**
	 * Default constructor. Does nothing except initialize the class variables.
	 */
	public RecurringDurationTask() {
		super();
	}

	/**
	 * Constructor inherited from the parent class. Useful for converting a
	 * basic Task into a RecurringDurationTask
	 * 
	 * @param taskName
	 * @param setSummary
	 * @param setDescription
	 * @param setOwner
	 * @param setGame
	 */
	public RecurringDurationTask(String taskName, String setSummary, String setDescription, Character setOwner,
			Game setGame) {
		super(taskName, setSummary, setDescription, setOwner, setGame);
	}
	
	/**
	 * Conversion Constructor. Used with a seed Task to create a new RecurringDurationTask. 
	 * @param seedTask
	 */
	public RecurringDurationTask(Task seedTask){
		super(seedTask.getName(), seedTask.getSummary(), seedTask.getDescription(), seedTask.getOwner(), seedTask.getGame());
	}
	
	/**
	 * Constructor. 
	 * @param taskName
	 * @param setSummary
	 * @param setDescription
	 * @param setOwner
	 * @param setGame
	 * @param setStartDate
	 * @param setEndDate
	 * @param setRootDate
	 * @param setRecurrence
	 */
	public RecurringDurationTask(String taskName, String setSummary, String setDescription, Character setOwner,
			Game setGame, Date setStartDate, Date setEndDate, Date setRootDate, Recurrence setRecurrence){
		super(taskName, setSummary, setDescription, setOwner, setGame);
		this.startDate = setStartDate;
		this.endDate = setEndDate;
		this.rootDate = setRootDate;
		this.recurrence = setRecurrence;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see RecurringTaskInterface#getRootDate()
	 */
	@Override
	public Date getRootDate() {
		return this.rootDate;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see RecurringTaskInterface#setRootDate(java.util.Date)
	 */
	@Override
	public void setRootDate(Date newRootDate) {
		this.rootDate = newRootDate;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see RecurringTaskInterface#getRecurrence()
	 */
	@Override
	public Recurrence getRecurrence() {
		return this.recurrence;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see RecurringTaskInterface#setRecurrence(Recurrence)
	 */
	@Override
	public void setRecurrence(Recurrence newRecurrence) {
		this.recurrence = newRecurrence;

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see RecurringTaskInterface#generateNextDates(int)
	 */
	@Override
	public ArrayList<Date> generateNextDates(int n) {
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see RecurringTaskInterface#generateThroughDate(java.util.Date)
	 */
	@Override
	public ArrayList<Date> generateThroughDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see RecurringTaskInterface#findClosestDate(java.util.Date)
	 */
	@Override
	public Date findClosestDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see RecurringTaskInterface#findNextDate(java.util.Date)
	 */
	@Override
	public Date findNextDate(Date date) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see RecurringTaskInterface#generateFromDateNextDates(java.util.Date,
	 * int)
	 */
	@Override
	public ArrayList<Date> generateFromDateNextDates(Date startDate, int n) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see RecurringTaskInterface#generateFromDateThroughDate(java.util.Date,
	 * java.util.Date)
	 */
	@Override
	public ArrayList<Date> generateFromDateThroughDate(Date startDate, Date endDate) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see RecurringTaskInterface#updateRootDate()
	 */
	@Override
	public void updateRootDate() {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DurationTaskInterface#getStartDate()
	 */
	@Override
	public Date getStartDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DurationTaskInterface#setStartDate(java.util.Date)
	 */
	@Override
	public void setStartDate(Date newStartDate) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DurationTaskInterface#getEndDate()
	 */
	@Override
	public Date getEndDate() {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DurationTaskInterface#setEndDate(java.util.Date)
	 */
	@Override
	public void setEndDate(Date newEndDate) {
		// TODO Auto-generated method stub

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DurationTaskInterface#getDuration(java.util.concurrent.TimeUnit)
	 */
	@Override
	public long getDuration(TimeUnit timeUnit) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DurationTaskInterface#getTimeRemainingToStart(java.util.concurrent.
	 * TimeUnit)
	 */
	@Override
	public long getTimeRemainingToStart(TimeUnit timeUnit) {
		// TODO Auto-generated method stub
		return 0;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see DurationTaskInterface#getTimeRemainingToEnd(java.util.concurrent.
	 * TimeUnit)
	 */
	@Override
	public long getTimeRemainingToEnd(TimeUnit timeUnit) {
		// TODO Auto-generated method stub
		return 0;
	}

}
