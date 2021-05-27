package cs350s21project.cli;

import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.command.actor.*;
import cs350s21project.datatype.AgentID;
import cs350s21project.datatype.Altitude;
import cs350s21project.datatype.AttitudePitch;
import cs350s21project.datatype.AttitudeYaw;
import cs350s21project.datatype.Course;
import cs350s21project.datatype.Groundspeed;

public class CommandSetFactory {

	public static A_CommandActor<?> getSetCommand(CommandManagers managers, String command) {
		
		String[] cmdArr = command.split(" ", 0);
		A_CommandActor<?> cmdSet = null;
		
		try {
			if (cmdArr[0].equals("set")) {
				// Check third word for Set type
				switch(cmdArr[2]) {
				case "load":{
					AgentID idActor = new AgentID(cmdArr[1]);
					AgentID idMunition = new AgentID(cmdArr[4]);
					cmdSet = new CommandActorLoadMunition(managers, command, idActor, idMunition);
					break;
				}
				case "deploy":{
					AgentID idActor = new AgentID(cmdArr[1]);
					AgentID idMunition = new AgentID(cmdArr[4]);
					if (cmdArr.length > 5) {
						AttitudeYaw az = new AttitudeYaw(Integer.parseInt(cmdArr[7]));
						AttitudePitch el = new AttitudePitch(Integer.parseInt(cmdArr[9]));
						cmdSet = new CommandActorDeployMunitionShell(managers, command, idActor, idMunition, az, el);
					} else {
						cmdSet = new CommandActorDeployMunition(managers, command, idActor, idMunition);
					}
					break;
				}
				case "course":{
					AgentID idActor = new AgentID(cmdArr[1]);
					Course course = new Course(Integer.parseInt(cmdArr[3]));
					cmdSet = new CommandActorSetCourse(managers, command, idActor, course);
					break;
				}
				case "speed":{
					AgentID idActor = new AgentID(cmdArr[1]);
					Groundspeed speed = new Groundspeed(Integer.parseInt(cmdArr[3]));
					cmdSet = new CommandActorSetSpeed(managers, command, idActor, speed);
					break;
				}
				case "altitude": case "depth":{
					AgentID idActor = new AgentID(cmdArr[1]);
					Altitude alt = new Altitude(Integer.parseInt(cmdArr[3]));
					cmdSet = new CommandActorSetAltitudeDepth(managers, command, idActor, alt);
					break;
				}
				default: throw new RuntimeException("Invalid Command");
				}
			}
		} catch (Exception e){
			throw new RuntimeException("Invalid Command");
		}
		return cmdSet;
	}
}
