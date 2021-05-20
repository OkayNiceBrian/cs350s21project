package cs350s21project.cli;

import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.command.actor.*;
import cs350s21project.datatype.AgentID;

public class CommandSetFactory {

	public static A_CommandActor<?> getSetCommand(CommandManagers managers, String command) {
		
		String[] cmdArr = command.split(" ", 0);
		A_CommandActor<?> cmdSet = null;
		
		if (cmdArr[0].equals("set")) {
			switch(cmdArr[2] + " " + cmdArr[3]) {
			case "load munition":{
				AgentID idActor = new AgentID(cmdArr[1]);
				AgentID idMunition = new AgentID(cmdArr[4]);
				cmdSet = new CommandActorLoadMunition(managers, command, idActor, idMunition);
				break;
			}
			case "deploy munition":{
				break;
			}
			default: break;
			}
		}
		
		return cmdSet;
	}
}
