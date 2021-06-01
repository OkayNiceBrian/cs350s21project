package cs350s21project.cli;

import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.command.A_Command;
import cs350s21project.controller.command.actor.A_CommandActor;
import cs350s21project.datatype.AgentID;
import cs350s21project.datatype.Altitude;
import cs350s21project.datatype.CoordinateWorld3D;
import cs350s21project.datatype.Course;
import cs350s21project.datatype.Groundspeed;
import cs350s21project.datatype.Latitude;
import cs350s21project.datatype.Longitude;
import cs350s21project.datatype.Time;
import cs350s21project.datatype.AngleNavigational;
import cs350s21project.datatype.CoordinateWorld;

public class MiscCmdFactory {
	public static A_Command<?> buildMiscCmd(CommandManagers managers, String cliIn) {
		String[] command = cliIn.split(" ");
		switch(command[0]) {
			case "@load":
				CommandMiscLoad loadCmd = new CommandMiscLoad(managers, cliIn, command[1].trim());
				return loadCmd;
			case "@pause":
				pauseCmd(managers, cliIn);
				break;
			case "@resume":
				CommandMiscResume resumeCmd = new CommandMiscResume(managers, cliIn);
				return resumeCmd;
			case "@set":
				setUpdateCmd(managers, cliIn);
				break;
			case "@wait":
				waitCmd(managers, cliIn);
				break;
			case "@force":
				forceCmd(managers, cliIn);
				break;
			case "@exit":
				CommandMiscExit exitCmd = new CommandMiscExit(managers, cliIn.trim());
				return exitCmd;
			default: break;
		}
	}
	public static CommandMiscPause pauseCmd(CommandManagers managers, String cliIn) {
		CommandMiscPause pauseCmd = new CommandMiscPause(managers, cliIn);
		return pauseCmd;
	}
	public static CommandMiscSetUpdate setUpdateCmd(CommandManagers managers, String cliIn) {
		String[] command = cliIn.split(" ");
		Time timeSet = new Time(Double.valueOf(command[2]));
		CommandMiscSetUpdate setUpdateCmd = new CommandMiscSetUpdate(managers, cliIn, timeSet);
		return setUpdateCmd;
	}
	public static CommandMiscWait waitCmd(CommandManagers managers, String cliIn) {
		String[] command = cliIn.split(" ");
		Time timeWait = new Time(Double.valueOf(command[1]));
		CommandMiscWait waitCmd = new CommandMiscWait(managers, cliIn, timeWait);
		return waitCmd;
	}
	public static CommandActorSetState forceCmd(CommandManagers managers, String cliIn) {
		String[] command = cliIn.split(" ");
		
		AgentID id = new AgentID(command[1]);
		
		String[] coords = command[4].split("*'/");
			Latitude lat = new Latitude(Integer.valueOf(coords[0]),Integer.valueOf(coords[1]),Double.valueOf(coords[2]));
			Longitude lon = new Longitude(Integer.valueOf(coords[3]),Integer.valueOf(coords[4]),Double.valueOf(coords[5]));
			Altitude alt = new Altitude(Double.valueOf(coords[6]));
			
		CoordinateWorld3D position = new CoordinateWorld3D(lat, lon, alt);
		Course course = new Course(Double.valueOf(command[8]));
		Groundspeed speed = new Groundspeed(Double.valueOf(command[9]));
		CommandActorSetState forceCmd = new CommandActorSetState(managers, cliIn, id, position, course, speed);
		return forceCmd;
	}	
}
