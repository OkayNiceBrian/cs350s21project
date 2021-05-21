package cs350s21project.controller.command.actor;

import cs350s21project.controller.CommandManagers;
import cs350s21project.datatype.AgentID;
import cs350s21project.datatype.Altitude;


public class CommandActorSetAltitudeDepth extends A_CommandActor<CommandActorSetSpeed>{

	Altitude altitude;
	
	public CommandActorSetAltitudeDepth(CommandManagers managers, String text, AgentID idActor, Altitude altitude) {
		super(managers, text, idActor);
			this.altitude = altitude;
	
	}


	@Override
	public void execute() {
		setAltitude(altitude);
	}

	
	public Altitude getAltitude() {
		return altitude;
	}
	
	public void setAltitude(Altitude altitude) {
		this.altitude = altitude;
	}
	
}
