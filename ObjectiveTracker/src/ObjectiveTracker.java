import java.util.ArrayList;

/**
 * @author Mark
 *
 */
public class ObjectiveTracker {

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

	public void printTasks(){
		getTasks();
		for(int i = 0; i < this.taskList.size(); i++){
			System.out.println("All Tasks: \nName \tSummary \tTask Summary"); //TODO printf
			Task currTask = this.taskList.get(i);
			System.out.println(currTask.getName() + " , " + currTask.getSummary() + " , " + currTask.getDate());
		}
		System.out.println();
	}
	
	public void printCharacters(){
		System.out.println("All Characters: \nName \tParent Game"); //TODO printf
		getCharacters();
		for(int i = 0; i < this.charactersList.size(); i++){
			Character currChar = this.charactersList.get(i);
			System.out.println(currChar.getName() + " , " + currChar.getGame());
		}
		System.out.println();
	}
	
	public void printGames(){
		System.out.println("All Games: \nName"); //TODO printf
		for(int i = 0; i < this.gamesList.size(); i++){
			System.out.println(this.gamesList.get(i).getName());
		}
		System.out.println();
	}
	
	
}
