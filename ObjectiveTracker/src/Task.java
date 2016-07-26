import java.util.Date;
import java.sql.Time;

public class Task {

	private String name = "";
	private String summary = "";
	private String description = "";
	private Date startDate = new Date();
	private Character owner;
	private Game ownerGame;
	
	public Task() {
		
	}
	
	public Task(String taskName, String setSummary, String setDescription, Date setDate, Character setOwner, Game setGame){
		this.name = taskName;
		this.summary = setSummary;
		this.description = setDescription;
		this.startDate = setDate;
		this.owner = setOwner;
		this.ownerGame = setGame;
	}
	
	public String getName(){
		return this.name;
	}
	
	public void setName(String setName){
		this.name = setName;
	}
	
	public String getSummary(){
		return this.summary;
	}
	
	public void setSummary(String setSummary){
		this.summary = setSummary;
	}
	
	public String getDescription(){
		return this.description;
	}
	
	public void setDescription(String setDescription){
		this.description = setDescription;
	}
	
	public Date getDate(){
		return this.startDate;
	}
	
	public void setDate(Date setDate){
		this.startDate = setDate;
	}
	
	public Character getOwner(){
		return this.owner;
	}
	
	public void setOwner(Character newOwner){
		this.owner = newOwner;
	}
	
	public Game getGame(){
		return this.ownerGame;
	}
	
	public void setGame(Game setGame){
		this.ownerGame = setGame;
	}

}
