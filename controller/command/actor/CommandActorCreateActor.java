package cs350s21project.controller.command.actor;

import cs350s21project.controller.command.A_Command;
import cs350s21project.controller.command.actor.A_CommandActor;
import cs350s21project.datatype.AgentID;				//TODO confirm that these imports are ok and shouldn't be pulling in from elsewhere
import cs350s21project.datatype.CoordinateWorld3D;
import cs350s21project.datatype.Course;
import cs350s21project.datatype.Groundspeed;
import cs350s21project.controller.CommandManagers;

//Creates an instance of actor family id2 called actor id1 at coordinates with azimuth course and speed speed.
public abstract class CommandActorCreateActor extends A_CommandActor<CommandActorCreateActor> {

	//new pieces that are added to our actors. Managers, text, idActor are all provided from A_CommandActor
	AgentID idFamily;
	CoordinateWorld3D position;
    Course course;
	Groundspeed speed;
		
	
	public CommandActorCreateActor(CommandManagers managers, String text, 
			AgentID idActor, AgentID idFamily, CoordinateWorld3D position, Course course, Groundspeed speed) {
		super(managers, text, idActor);
		this.idFamily = idFamily;
		this.position = position; 
		this.course = course;
		this.speed = speed;
		
	}

	
	public void execute() {
		//TODO add to this function
	}
	
	public Course getCourse() {
		return this.course;
	}
	
	public AgentID getFamilyID() {
		return this.idFamily;
	}
	
	public CoordinateWorld3D getPosition() {
		return this.position;
	}
	
	public Groundspeed getSpeed() {
		return this.speed;
	}
	
}
