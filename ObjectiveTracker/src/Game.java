import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Mark
 *
 */
public class Game implements Serializable {

	private static final long serialVersionUID = -900082779300756640L;
	
	private ArrayList<Character> charactersList = new ArrayList<Character>();
	private String name = "";

	public Game() {
		
	}
	
	public Game(String gameName){
		this.name = gameName;
	}
	
	public void changeName(String newName){
		this.name = newName;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void addCharacter(Character newCharacter){
		this.charactersList.add(newCharacter);
	}
	
	public void removeCharacter(Character delCharacter){
		this.charactersList.remove(delCharacter);
	}
	
	public Character getCharacter(int position){
		return this.charactersList.get(position);
	}
	
	public ArrayList<Character> getCharacters(){
		return this.charactersList;
	}
	
	/**
	 * Extracts the tasks of each of this game's children Characters.
	 * @return an ArrayList<Task> of all of the @Task objects of each of this game's @Character objects.
	 */
	public ArrayList<Task> getTasks(){
		ArrayList<Task> returnTasks = new ArrayList<Task>();
		int listSize = this.charactersList.size();
		for(int i = 0; i < listSize; i++){
			returnTasks.addAll(this.charactersList.get(i).getTasks());
		}
		return returnTasks;
	}
	
	public String toString(){
		return this.name;
	}

}
