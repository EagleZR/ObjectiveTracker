import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Mark
 *
 */
public class ObjectiveTracker implements Serializable {

	private static final long serialVersionUID = -4302153082325817592L;
	
	private ArrayList<Task> taskList = new ArrayList<Task>();
	private ArrayList<Character> charactersList = new ArrayList<Character>();
	private ArrayList<Game> gamesList = new ArrayList<Game>();
	private ArrayList<Task> personalTasks = new ArrayList<Task>();
	

	public ObjectiveTracker(){
		
	}
	
	public ObjectiveTracker(ArrayList<Task> savedTasks, ArrayList<Character> savedCharacters, ArrayList<Game> savedGames, ArrayList<Task> savedPersonalTasks){
		this.taskList = savedTasks;
		this.charactersList = savedCharacters;
		this.gamesList = savedGames;
		this.personalTasks = savedPersonalTasks;
	}
	
	public void addGame(Game newGame){
		this.gamesList.add(newGame);
	}

	public void addGames(ArrayList<Game> newGames){
		this.gamesList.addAll(newGames);
	}
	
	public void addCharacter(Character newCharacter){
		newCharacter.getGame().addCharacter(newCharacter);
	}
	
	public void addCharacters(ArrayList<Character> newCharacters){
		while(!newCharacters.isEmpty()){
			Character currCharacter = newCharacters.remove(0);
			currCharacter.getGame().addCharacter(currCharacter);
		}
	}
	
	public void addTask(Task newTask){
		newTask.getOwner().addTask(newTask);
	}
	
	public void addTasks(ArrayList<Task> newTasks){
		while(!newTasks.isEmpty()){
			Task currTask = newTasks.get(0);
			currTask.getOwner().addTask(currTask);
		}
	}
	
	//TODO add findTask(String keyword) that searches for a keyword in the Summary or Description
	
	public Character findCharacter(String characterName){
		getCharacters();
		for(int i = 0; i < this.charactersList.size(); i++){
			if(this.charactersList.get(i).getName().contains(characterName)){
				return this.charactersList.get(i);
			}
		}
		return null;
	}
	
	public Game findGame(String gameName){
		for(int i = 0; i < this.gamesList.size(); i++){
			if(this.gamesList.get(i).getName().contains(gameName))
				return this.gamesList.get(i);
		}
		return null;
	}
	
 	public ArrayList<Task> getTasks(){
		this.taskList.clear();
		for(int i = 0; i < this.gamesList.size(); i++){
			this.taskList.addAll(this.gamesList.get(i).getTasks());
		}
		return this.taskList;
	}
	
	public void setTasks(ArrayList<Task> newTasks){
		this.taskList = newTasks;
	}

	public ArrayList<Character> getCharacters(){
		this.charactersList.clear();
		for(int i = 0; i < this.gamesList.size(); i++){
			this.charactersList.addAll(this.gamesList.get(i).getCharacters());
		}
		return this.charactersList;
	}
	
	public void setCharacters(ArrayList<Character> newCharacters){
		this.charactersList = newCharacters;
	}
	
	public ArrayList<Game> getGames(){
		return this.gamesList;
	}
	
	public void setGames(ArrayList<Game> newGames){
		this.gamesList = newGames;
	}

	public void printTasks(){ //TODO Need to find a way to make this orthogonal to the different Task types.
		System.out.println("All Tasks: \nName \tSummary \tTask Summary");
		getTasks();
		for(int i = 0; i < this.taskList.size(); i++){
			Task currTask = this.taskList.get(i);
			System.out.println(currTask.getName() + " , " + currTask.getSummary());
			System.out.printf("\t%15s\t%30s", currTask.getName(), currTask.getSummary());
		}
		System.out.println();
	}
	
	public void printCharacters(){
		System.out.printf("%-15s\t\t%-15s\t\t%-15s\t\t%-15s\n", "All Characters:", "Character name", "Character game", "Number of Tasks"); //TODO printf
		getCharacters();
		for(int i = 0; i < this.charactersList.size(); i++){
			Character currChar = this.charactersList.get(i);
//			System.out.println(currChar.getName() + " , " + currChar.getGame());
			System.out.printf("%-15s\t\t%-15s\t\t%-15s\t\t%d\n", "", currChar.getName(), currChar.getGame().getName(), currChar.getTasks().size());
		}
		System.out.println();
	}
	
	public void printGames(){
		System.out.printf("%-15s\t\t%-15s\t\t%-20s\t\t%-15s\n", "All Games:", "Game name", "Number of Characters", "Number of Tasks");
//		System.out.println("All Games: \nName"); //TODO printf
		for(int i = 0; i < this.gamesList.size(); i++){
			Game curr = this.gamesList.get(i);
			System.out.printf("%-15s\t\t%-15s\t\t%-20d\t\t%-15d\n", "", curr.getName(), curr.getCharacters().size(), curr.getTasks().size());
//			System.out.println(this.gamesList.get(i).getName());
		}
		System.out.println();
	}
	
	//TODO Add personal task functionality.
}
