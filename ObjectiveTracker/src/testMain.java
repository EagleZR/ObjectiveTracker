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
		Game swtor = new Game("Star War: The Old Republic");
		Game wow = new Game("World of Warcraft");
		Character sol = new Character("Solinara", swtor);
		Character laur = new Character("Laurelaie", swtor);
		tracker.addGame(wow);
		tracker.addGame(swtor);
		tracker.addCharacter(sol);
		tracker.addCharacter(laur);
		tracker.printCharacters();
		tracker.printGames();
	}

}
