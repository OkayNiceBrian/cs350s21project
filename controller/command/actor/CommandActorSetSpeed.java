package cs350s21project.controller.command.actor;

import cs350s21project.controller.CommandManagers;
import cs350s21project.datatype.AgentID;
import cs350s21project.datatype.Groundspeed;

public class CommandActorSetSpeed extends A_CommandActor<CommandActorSetSpeed>{

	
	Groundspeed speed;
	
	public CommandActorSetSpeed(CommandManagers managers, String text, AgentID idActor, Groundspeed speed) {
		super(managers, text, idActor);	
			this.speed = speed; 
		
	}

	@Override
	public void execute() {
		setSpeed(speed);
	}

	
	public Groundspeed getSpeed() {
		return speed;
	}
	
	public void setSpeed(Groundspeed speed) {
		this.speed = speed;
	}
	
}
