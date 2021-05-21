package cs350s21project.controller.command.actor;

import cs350s21project.controller.CommandManagers;
import cs350s21project.datatype.AgentID;
import cs350s21project.datatype.Course;	//importing of data types


public class CommandActorSetCourse extends A_CommandActor<CommandActorSetCourse>{

	
    Course course;
	
		
	
	public CommandActorSetCourse(CommandManagers managers, String text, AgentID idActor, Course course) {
		super(managers, text, idActor);	
			this.course = course;
			
	}

	@Override
	public void execute() {
		// TODO Auto-generated method stub, 
		setCourse(course);
	}

	
	public Course getCourse() {
		return this.course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
}
