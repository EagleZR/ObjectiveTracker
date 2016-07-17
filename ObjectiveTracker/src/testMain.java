import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class testMain {

	public testMain() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		ObjectiveTracker tracker = new ObjectiveTracker();
		
		Game swtor = new Game("SWTOR");
		Game wow = new Game("WOW");
		
		Character sol = new Character("Solinara", swtor);
		Character laur = new Character("Laurelaie", swtor);
		
		Task task1 = new Task();
		Task task2 = new Task();
		Task task3 = new Task();
		
		sol.addTask(task1);
		sol.addTask(task2);
		laur.addTask(task3);
		
		tracker.addGame(wow);
		tracker.addGame(swtor);
		tracker.addCharacter(sol);
		tracker.addCharacter(laur);
		tracker.printCharacters();
		tracker.printGames();
	}

}
