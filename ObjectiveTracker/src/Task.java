import java.io.Serializable;

/**
 * 
 * @author Mark Zeagler
 * This is the base class from which all other Task type objects will be extended, 
 * including Recurring, Non-Recurring, Suspended, and Duration task derivatives. 
 */

public class Task implements Serializable {

	private static final long serialVersionUID = 6965625528849921957L;
	
	private String name = ""; //TODO: Limit to 15 characters. Probably need to do in main/GUI.
	private String summary = ""; //TODO Limit to 30(?) characters. Probably need to do in main/GUI.
	private String description = ""; //TODO Limit to 120 characters. Probably need to do in main/GUI.
	private Character owner;
	private Game ownerGame;
	
	/**
	 * An empty constructor for the use of place-holding.
	 */
	public Task() {
		
	}
	
	/**
	 * The main Constructor for the base Task Type. Should not be used outside of testing. 
	 * The extended Tasks will be used instead.
	 * @param taskName The String name for the Task. TODO: Limit to 15 Characters. Probably need to do in main/GUI.
	 * @param setSummary A String summary for the Task. TODO: Limit to 30(?) Characters. Probably need to do in main/GUI.
	 * @param setDescription A String Description for the Task. TODO: Limit to 120 Characters. Probably need to do in main/GUI.
	 * @param setOwner Sets the Character owner of the Task.
	 * @param setGame Sets the Game to which the Character owner belongs.
	 */
	public Task(String taskName, String setSummary, String setDescription, Character setOwner, Game setGame){
		this.name = taskName;
		this.summary = setSummary;
		this.description = setDescription;
		this.owner = setOwner;
		this.ownerGame = setGame;
	}
	
	/**
	 * Retrieves the Task's name.
	 * @return A String containing the name of the Task.
	 */
	public String getName(){
		return this.name;
	}
	
	/**
	 * The name for the Task. e.g. "Dorian's lvl. 45 grind".
	 * @param setName The new name for the Task.
	 */
	public void setName(String setName){
		this.name = setName;
	}
	
	/**
	 * Retrieves the summary for this Task.
	 * @return A String of the Task's summary.
	 */
	public String getSummary(){
		return this.summary;
	}
	
	/**
	 * Sets a summary for the app to be displayed in-app.
	 * @param setSummary A String summarizing the task for in-app use.
	 */
	public void setSummary(String setSummary){
		this.summary = setSummary;
	}
	
	/**
	 * Retrieves this Task's description. 
	 * @return A String containing this Task's description.
	 */
	public String getDescription(){
		return this.description;
	}
	
	/**
	 * Sets the Task's description to be displayed in-app.
	 * @param setDescription The description to be displayed in-app.
	 */
	public void setDescription(String setDescription){
		this.description = setDescription;
	}
	
	/**
	 * Retrieves the Character object to which this belongs.
	 * @return The Character object to which this belongs. 
	 */
	public Character getOwner(){
		return this.owner;
	}
	
	/**
	 * Sets a new owner for this task. 
	 * @param newOwner This is the Character object to which this will furthermore be dependent.
	 */
	public void setOwner(Character newOwner){
		this.owner = newOwner;
	}
	
	/**
	 * Retrieves the game that this task is subject to.
	 * @return The Game object that this task belongs to. 
	 */
	public Game getGame(){
		return this.ownerGame;
	}
	
	/**
	 * Sets the parent game for this task. Useful for switching the task from one character to another.
	 * @param setGame The game for which this task is set.
	 */
	public void setGame(Game setGame){
		this.ownerGame = setGame;
	}

}
