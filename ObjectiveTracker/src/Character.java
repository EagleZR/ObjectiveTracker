import java.util.ArrayList;

/**
 * @author Mark
 *
 */
public class Character {

	private String name = "";
	private Game game;
	private ArrayList<Task> taskList = new ArrayList<Task>();
	/**
	 * 
	 */
	public Character() {
		
	}
	
	public Character(String charName, Game charGame){
		this.name = charName;
		this.game = charGame;
	}
	
	public void changeName(String newName){
		this.name = newName;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void changeGame(Game newGame){
		this.game = newGame;
	}
	
	public Game getGame(){
		return this.game;
	}
	
	public void addTask(Task newTask){
		taskList.add(newTask);
	}
	
	public void removeTask(Task delTask){
		taskList.remove(delTask);
	}
	
	public ArrayList<Task> getTasks(){
		return this.taskList;
	}
	
	public String toString(){
		return this.name;
	}

}
