import java.io.Serializable;

/**
 * @author Mark Zeagler.
 * Determines the rate at which something recurs, whether by hour, day, week, month, etc.
 */
public class Recurrence implements Serializable {
	
	private static final long serialVersionUID = 5754868922670871930L;
	
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
	private boolean year_m_used = false;
	private boolean year_d_used = false; //redundant
	
	private Recurrence actingOn = null; //If not acting on another recurrence, it is acting on a date.
	private int recurrenceLevel = 0; //For reacting recurrences, acting recurrence must have higher level than acted-upon recurrence
	
	/**
	 * Empty constructor. Only use as a place-holder.
	 */
	public Recurrence() {
		
	}
	
	/**
	 * Sets the repetition starting from the provided date.
	 * @param setRootDate The "Start date" for the recurrence. This date may change as the current date passes the original start date.
	 * @param level The level of modification. e.g. Recurrence.YEAR, Recurrence.MONTH, Recurrence.WEEK, Recurrence.DAY, Recurrence.HOUR, Recuurence.MINUTE
	 * @param skips The number of units (determined by level) to be skipped. e.g. (level = 2 && skips == 1) == occurs every other day
	 * @param repetitions The number of times the event occurs in the sequence. 
	 */
	public Recurrence(int setLevel, int setSkips, int setRepetitions){
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
	
	/**
	 * Defines a recurrence based on the submitted selection array.
	 * @param setSelection The selection of what is to recur. A Monday, Wednesday, Friday recurrence would be passed as an array of {0,1,0,1,0,1,0}.
	 * @param level The level being modified. e.g. If the selection is a recurring day of the week, the level would be Recurrence.DAY.
	 */
	public Recurrence(int[] setSelection, int level){
		this.recurrenceLevel = level;
		if(level == this.YEAR){
			if(setSelection.length > 31){
				this.year_d = setSelection;
				this.year_d_used = true;
			} else {
				this.year_m = setSelection;
				this.year_m_used = true;
			}
		} else if (level == this.MONTH){
			this.month = setSelection;
		} else if (level == this.WEEK){
			this.week = setSelection;
		} else if (level == this.DAY){
			this.day = setSelection;
		} else if (level == this.HOUR){
			this.hour = setSelection;
		} else if (level == this.MINUTE){
			this.minute = setSelection;
		}
	}
	
	/**
	 * Defines a selection recurrence which is acting on another recurrence. 
	 * @param recurrenceModified The other recurrence this one is acting on.
	 * @param setSelection The selection of what is to recur. A Monday, Wednesday, Friday recurrence would be passed as an array of {0,1,0,1,0,1,0}. 
	 * @param level The level being modified. e.g. If the selection is a recurring day of the week, the level would be Recurrence.DAY.
	 */
	public Recurrence(Recurrence recurrenceModified, int[] setSelection, int level){
		this.recurrenceLevel = level;
		this.actingOn = recurrenceModified;
		if(level == this.YEAR){
			if(setSelection.length > 31){
				this.year_d = setSelection;
				this.year_d_used = true;
			} else {
				this.year_m = setSelection;
				this.year_m_used = true;
			}
		} else if (level == this.MONTH){
			this.month = setSelection;
		} else if (level == this.WEEK){
			this.week = setSelection;
		} else if (level == this.DAY){
			this.day = setSelection;
		} else if (level == this.HOUR){
			this.hour = setSelection;
		} 
	}

	/**
	 * Sets the new skip pattern based on the given int.
	 * @param setSkips The amount of units to be skipped at this level before a repetition.
	 */
	public void setSkips(int setSkips){
		this.skips = setSkips;
	}
	
	/**
	 * Returns the skip pattern at this level.
	 * @return The int that defines how many units are skipped at this level.
	 */
	public int getSkips(){
		return this.skips;
	}
	
	/**
	 * Sets the new repetitions pattern for this level.
	 * @param setRepetitions The int value that indicates how many times this pattern is to be repeated. 
	 */
	public void setRepetitions(int setRepetitions){
		this.repetitions = setRepetitions;
	}
	
	/**
	 * Returns the number of times this pattern is to be repeated at this level. 
	 * @return The int value that determines how many times this level's pattern is repeated. 
	 */
	public int getRepetitions(){
		return this.repetitions;
	}
	
	/**
	 * Sets a new selection for this level.
	 * @param setSelection The new selection for this level. Be sure it matches the formatting the level currently uses.
	 */
	public void setSelection(int[] setSelection){
		if(this.recurrenceLevel == this.YEAR){
			if(this.year_d_used){
				this.year_d = setSelection;
			} else if (this.year_m_used){
				this.year_m = setSelection;
			}
		} else if (this.recurrenceLevel == this.MONTH){
			this.month = setSelection;
		} else if (this.recurrenceLevel == this.WEEK){
			this.week = setSelection;
		} else if (this.recurrenceLevel == this.DAY){
			this.day = setSelection;
		} else if (this.recurrenceLevel == this.HOUR){
			this.hour = setSelection;
		} else if (this.recurrenceLevel == this.MINUTE){
			this.minute = setSelection;
		}
	}
	
	/**
	 * Returns the selection that is being used at this level of recurrence. 
	 * @return An int[] containing the selection being used at this level.
	 */
	public int[] getSelection(){
		if(this.recurrenceLevel == this.YEAR){
			if(this.year_d_used){
				return this.year_d;
			} else if (this.year_m_used){
				return this.year_m;
			}
		} else if (this.recurrenceLevel == this.MONTH){
			return this.month;
		} else if (this.recurrenceLevel == this.WEEK){
			return this.week;
		} else if (this.recurrenceLevel == this.DAY){
			return this.day;
		} else if (this.recurrenceLevel == this.HOUR){
			return this.hour;
		} else if (this.recurrenceLevel == this.MINUTE){
			return this.minute;
		}
			return null;
	}

	/**
	 * Returns the recurrence this one is acting on.
	 * @return The recurrence object this recurrence is modifying.
	 */
	public Recurrence getActingOn(){
		return this.actingOn;
	}
	
	/**
	 * Returns whether or not this recurrence is modifying another recurrence object.
	 * @return True if this is modifying another recurrence object.
	 */
	public boolean isActingOn(){
		return !this.actingOn.equals(null);
	}

}
