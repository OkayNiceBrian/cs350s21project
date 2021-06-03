package cs350s21project.cli;

import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.command.A_Command;
import cs350s21project.controller.command.actor.CommandActorSetState;
import cs350s21project.controller.command.misc.CommandMiscExit;
import cs350s21project.controller.command.misc.CommandMiscLoad;
import cs350s21project.controller.command.misc.CommandMiscPause;
import cs350s21project.controller.command.misc.CommandMiscResume;
import cs350s21project.controller.command.misc.CommandMiscSetUpdate;
import cs350s21project.controller.command.misc.CommandMiscWait;
import cs350s21project.controller.command.view.CommandViewCreateWindowTop;
import cs350s21project.controller.command.view.CommandViewDeleteWindow;
import cs350s21project.datatype.AgentID;
import cs350s21project.datatype.Altitude;
import cs350s21project.datatype.CoordinateWorld3D;
import cs350s21project.datatype.Course;
import cs350s21project.datatype.Groundspeed;
import cs350s21project.datatype.Latitude;
import cs350s21project.datatype.Longitude;
import cs350s21project.datatype.Time;


public class MiscCmdFactory {
	public static A_Command<?> buildMiscCmd(CommandManagers managers, String cliIn) {
		String[] command = cliIn.split(" ");
		switch(command[0]) {
			case "@load":
				CommandMiscLoad loadCmd = new CommandMiscLoad(managers, cliIn, command[1].trim());
				return loadCmd;
			case "@pause":
				return pauseCmd(managers, cliIn);
			case "@resume":
				CommandMiscResume resumeCmd = new CommandMiscResume(managers, cliIn);
				return resumeCmd;
			case "@set":
				return setUpdateCmd(managers, cliIn);
			case "@wait":
				return waitCmd(managers, cliIn);
			case "@force":
				return forceCmd(managers, cliIn);
			case "create":
				AgentID createID = new AgentID(command[2]);
				int size = Integer.valueOf(command[5]);
				
				String[] lat1Str = command[6].split("'/*");//lat1
					int lat1hr = Integer.valueOf(lat1Str[0]); 
					int lat1min = Integer.valueOf(lat1Str[1]);
					int lat1sec = Integer.valueOf(lat1Str[2]);
				String[] lat2Str = command[7].split("'/*");//lat2
					int lat2hr = Integer.valueOf(lat2Str[0]); 
					int lat2min = Integer.valueOf(lat2Str[1]);
					int lat2sec = Integer.valueOf(lat2Str[2]);
				String[] lat3Str = command[8].split("'/*");//lat3
					int lat3hr = Integer.valueOf(lat3Str[0]); 
					int lat3min = Integer.valueOf(lat3Str[1]);
					int lat3sec = Integer.valueOf(lat3Str[2]);
				String[] lon1Str = command[9].split("'/*");//lon1
					int lon1hr = Integer.valueOf(lon1Str[0]); 
					int lon1min = Integer.valueOf(lon1Str[1]);
					int lon1sec = Integer.valueOf(lon1Str[2]);
				String[] lon2Str = command[10].split("'/*");//lon2
					int lon2hr = Integer.valueOf(lon2Str[0]); 
					int lon2min = Integer.valueOf(lon2Str[1]);
					int lon2sec = Integer.valueOf(lon2Str[2]);
				String[] lon3Str = command[11].split("'/*");//lon3
				int lon3hr = Integer.valueOf(lon3Str[0]); 
				int lon3min = Integer.valueOf(lon3Str[1]);
				int lon3sec = Integer.valueOf(lon3Str[2]);
				Latitude lat1 = new Latitude(lat1hr, lat1min ,lat1sec);//command[6]
				Latitude lat2 = new Latitude(lat2hr, lat2min ,lat2sec);//command[7]
				Latitude lat3 = new Latitude(lat3hr, lat3min ,lat3sec);//command[8]
				Longitude lon1 = new Longitude(lon1hr, lon1min ,lon1sec);//command[9]
				Longitude lon2 = new Longitude(lon2hr, lon2min ,lon2sec);//command[10]
				Longitude lon3 = new Longitude(lon3hr, lon3min ,lon3sec);//command[11]
				
				CommandViewCreateWindowTop topView = new CommandViewCreateWindowTop(managers, cliIn, createID, size, lat1, lat2, lat3, lon1, lon2, lon3);
				return topView;
			case "delete":
				AgentID delID = new AgentID(command[2]);
				CommandViewDeleteWindow deleteCmd = new CommandViewDeleteWindow(managers, cliIn, delID);
				return deleteCmd;
			case "@exit":
				CommandMiscExit exitCmd = new CommandMiscExit(managers, cliIn.trim());
				return exitCmd;
			default: break;
		}
		return null;
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
