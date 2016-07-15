import java.util.Date;

/**
 * @author Mark
 *
 */
public interface DurationTaskInterface {
	
	String name = "";
	String summary = "";
	String description = "";
	Date startDate = new Date();
	Date endDate = new Date();
	Character owner = null;
	Game ownerGame = null;
	
	
}
