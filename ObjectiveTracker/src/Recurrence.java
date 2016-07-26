import java.util.Date;

/**
 * @author Mark Zeagler.
 * Determines the rate at which something recurs, whether by hour, day, week, month, etc.
 */
public class Recurrence {
	
	//Useful for levels
	public final int YEAR = 6;
	public final int MONTH = 5;
	public final int WEEK = 4;
	public final int DAY = 3;
	public final int HOUR = 2;
	public final int MINUTE = 1;
	
	//Info for repetitive recurrences.
	private int skips = 0;
	private int repetitions = 0;
	
	//Arrays for selective recurrences. 
	//1 indicates a selection, 0 indicates non-selection
	private int minute[] = new int[60];
	private int hour[] = new int[60];
	private int day[] = new int[24];
	private int week[] = new int[7];
	private int month[] = new int[31];
	private int year_m[] = new int[12];
	private int year_d[] = new int[365];
	
	private Recurrence actingOn = null; //If not acting on another recurrence, it is acting on a date.
	private Date rootDate = null; //If no root date, acting on another recurrence.
	private int recurrenceLevel = 0; //For reacting recurrences, acting recurrence must have higher level than acted-upon recurrence
	
	public Recurrence() {
		
	}
	
	/**
	 * Sets the repetition starting from the provided date.
	 * @param setRootDate The "Start date" for the recurrence. This date may change as the current date passes the original start date.
	 * @param level The level of modification. e.g. Recurrence.YEAR, Recurrence.MONTH, Recurrence.WEEK, Recurrence.DAY, Recurrence.HOUR, Recuurence.MINUTE
	 * @param skips The number of units (determined by level) to be skipped. e.g. (level = 2 && skips == 1) == occurs every other day
	 * @param repetitions The number of times the event occurs in the sequence. 
	 */
	public Recurrence(Date setRootDate, int setLevel, int setSkips, int setRepetitions){
		this.rootDate = setRootDate;
		this.recurrenceLevel = setLevel;
		this.skips = setSkips;
		this.repetitions = setRepetitions; 
	}
	
	/**
	 * This sets a repetition on another recurrence. 
	 * @param recurrenceModified The recurrence being repeated.
	 * @param setLevel The level of modification. e.g. Recurrence.YEAR, Recurrence.MONTH, Recurrence.WEEK, Recurrence.DAY, Recurrence.HOUR, Recuurence.MINUTE
	 * @param setSkips The number of units (determined by level) to be skipped.  e.g. (level = 2 && skips == 1) == occurs every other day
	 * @param setRepetitions The number of times the dependent recurrence occurs in the sequence.
	 */
	public Recurrence(Recurrence recurrenceModified, int setLevel, int setSkips, int setRepetitions){
		this.actingOn = recurrenceModified;
		this.recurrenceLevel = setLevel;
		this.skips = setSkips;
		this.repetitions = setRepetitions;
	}
	
	public Recurrence(int[] recurringArray, int level){
		this.recurrenceLevel = level;
		if(level == this.YEAR){
			if(recurringArray.length > 31){
				this.year_d = recurringArray;
			} else {
				this.year_m = recurringArray;
			}
		} else if (level == this.MONTH){
			this.month = recurringArray;
		} else if (level == this.WEEK){
			this.week = recurringArray;
		} else if (level == this.DAY){
			this.day = recurringArray;
		} else if (level == this.HOUR){
			this.hour = recurringArray;
		} else if (level == this.MINUTE){
			this.minute = recurringArray;
		}
	}
	
	public Recurrence(Recurrence recurrenceModified, int[] recurringArray, int level){
		this.recurrenceLevel = level;
		this.actingOn = recurrenceModified;
		if(level == this.YEAR){
			if(recurringArray.length > 31){
				this.year_d = recurringArray;
			} else {
				this.year_m = recurringArray;
			}
		} else if (level == this.MONTH){
			this.month = recurringArray;
		} else if (level == this.WEEK){
			this.week = recurringArray;
		} else if (level == this.DAY){
			this.day = recurringArray;
		} else if (level == this.HOUR){
			this.hour = recurringArray;
		} 
	}

}
