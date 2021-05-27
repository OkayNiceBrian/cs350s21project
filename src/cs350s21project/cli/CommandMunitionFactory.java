package cs350s21project.cli;

import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.command.munition.*;
import cs350s21project.datatype.AgentID;
import cs350s21project.datatype.DistanceNauticalMiles;
import cs350s21project.datatype.Time;

public class CommandMunitionFactory {
	
	public static A_CommandMunition<?> getCommandMunition(CommandManagers managers, String command) {
		
		String[] cmdArr = command.split(" ", 0);
		A_CommandMunition<?> cmdMunition = null;
		
		try {
			if (cmdArr[0].equals("define") && cmdArr[1].equals("munition")) {
				AgentID id = new AgentID(cmdArr[3]);
				switch (cmdArr[2]) {
				case "bomb": {
					cmdMunition = new CommandMunitionDefineBomb(managers, command, id); 
					break;
				}
				case "shell": {
					cmdMunition = new CommandMunitionDefineShell(managers, command, id); 
					break;
				}
				case "depth_charge": {
					AgentID fuzeId = new AgentID(cmdArr[6]);
					cmdMunition = new CommandMunitionDefineDepthCharge(managers, command, id, fuzeId); 
					break;
				}
				case "torpedo": {
					AgentID sensorId = new AgentID(cmdArr[6]);
					AgentID fuzeId = new AgentID(cmdArr[8]);
					Time armingTime = new Time(Double.parseDouble(cmdArr[11]));
					cmdMunition = new CommandMunitionDefineTorpedo(managers, command, id, sensorId, fuzeId, armingTime); 
					break;
				}
				case "missile": {
					AgentID sensorId = new AgentID(cmdArr[6]);
					AgentID fuzeId = new AgentID(cmdArr[8]);
					DistanceNauticalMiles armingDist = new DistanceNauticalMiles(Double.parseDouble(cmdArr[11]));
					cmdMunition = new CommandMunitionDefineMissile(managers, command, id, sensorId, fuzeId, armingDist); 
					break;
				}
				default: throw new RuntimeException("Invalid Command");
				}
			}
		
		} catch (Exception e){
			throw new RuntimeException("Invalid Command");
		}
		
		return cmdMunition;
	}
}
