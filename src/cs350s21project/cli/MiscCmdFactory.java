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
				int size = Integer.valueOf(command[6]);
				String cliInClean = cliIn.replaceAll("[()]", "");
				String[] commandClean = cliInClean.split(" ");
				//command[] 7,8,9,10,11,12 are not broken into individual strings each containing a lat or lon.
				
				int lat1hr =0, lat1min =0;
				int lat2hr =0, lat2min =0;
				int lat3hr =0, lat3min =0;
				int lon1hr =0, lon1min =0;
				int lon2hr=0, lon2min =0;
				int lon3hr=0, lon3min=0;
				double lat1sec=0, lat2sec=0, lat3sec=0, lon1sec=0, lon2sec=0, lon3sec=0;
				
				/////////////////LATITUDE 1//////////////////////////
				String[] lat1StrHr = commandClean[7].split("\\*");
				String[] lat1StrMin = lat1StrHr[1].split("\'");
				String[] lat1StrSec = lat1StrMin[1].split("\"");
				
				lat1hr = Integer.parseInt(lat1StrHr[0]);
				lat1min = Integer.parseInt(lat1StrMin[0]);
				lat1sec = Integer.parseInt(lat1StrSec[0]);
				////////////////////////////////////////////////////
				/////////////////LATITUDE 2/////////////////////////
				String[] lat2StrHr = commandClean[8].split("\\*");
				String[] lat2StrMin = lat2StrHr[1].split("\'");
				String[] lat2StrSec = lat2StrMin[1].split("\"");
				
				lat2hr = Integer.parseInt(lat2StrHr[0]);
				lat2min = Integer.parseInt(lat2StrMin[0]);
				lat2sec = Integer.parseInt(lat2StrSec[0]);
				////////////////////////////////////////////////////
				/////////////////LATITUDE 3/////////////////////////
				String[] lat3StrHr = commandClean[9].split("\\*");
				String[] lat3StrMin = lat3StrHr[1].split("\'");
				String[] lat3StrSec = lat3StrMin[1].split("\"");
				
				lat3hr = Integer.parseInt(lat3StrHr[0]);
				lat3min = Integer.parseInt(lat3StrMin[0]);
				lat3sec = Integer.parseInt(lat3StrSec[0]);
				////////////////////////////////////////////////////
				/////////////////LONGITUDE 1////////////////////////
				String[] lon1StrHr = commandClean[10].split("\\*");
				String[] lon1StrMin = lon1StrHr[1].split("\'");
				String[] lon1StrSec = lon1StrMin[1].split("\"");
				
				lon1hr = Integer.parseInt(lon1StrHr[0]);
				lon1min = Integer.parseInt(lon1StrMin[0]);
				lon1sec = Integer.parseInt(lon1StrSec[0]);
				////////////////////////////////////////////////////
				/////////////////LONGITUDE 2////////////////////////
				String[] lon2StrHr = commandClean[11].split("\\*");
				String[] lon2StrMin = lon2StrHr[1].split("\'");
				String[] lon2StrSec = lon2StrMin[1].split("\"");
				
				lon2hr = Integer.parseInt(lon2StrHr[0]);
				lon2min = Integer.parseInt(lon2StrMin[0]);
				lon2sec = Integer.parseInt(lon2StrSec[0]);
				////////////////////////////////////////////////////
				/////////////////LONGITUDE 3////////////////////////
				String[] lon3StrHr = commandClean[12].split("\\*");
				String[] lon3StrMin = lat1StrHr[1].split("\'");
				String[] lon3StrSec = lat1StrMin[1].split("\"");
				
				lon3hr = Integer.parseInt(lon3StrHr[0]);
				lon3min = Integer.parseInt(lon3StrMin[0]);
				lon3sec = Integer.parseInt(lon3StrSec[0]);
				////////////////////////////////////////////////////
				
				
				Latitude lat1 = new Latitude(lat1hr, lat1min ,lat1sec);//command[7]
				Latitude lat2 = new Latitude(lat2hr, lat2min ,lat2sec);//command[8]
				Latitude lat3 = new Latitude(lat3hr, lat3min ,lat3sec);//command[9]
				Longitude lon1 = new Longitude(lon1hr, lon1min ,lon1sec);//command[10]
				Longitude lon2 = new Longitude(lon2hr, lon2min ,lon2sec);//command[11]
				Longitude lon3 = new Longitude(lon3hr, lon3min ,lon3sec);//command[12]
				
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
		
		//System.out.println(cliIn);//TEST

		int lat1hr = 0, lat1min = 0; //Latitude variables
		int lon1hr = 0, lon1min = 0;//Longitude variables
		double lat1sec = 0, lon1sec = 0;//Lat & lon variables for seconds

		String[] coords = command[4].split("/"); //Need data at index 0;
		
		String[] lat1StrHr = coords[0].split("\\*"); //Need data at index 0;
		String[] lat1StrMin = lat1StrHr[1].split("\'"); //Need data at index 0;
		String[] lat1StrSec = lat1StrMin[1].split("\"");//Need data at index 0;
		
		lat1hr = Integer.parseInt(lat1StrHr[0]);
		lat1min = Integer.parseInt(lat1StrMin[0]);
		lat1sec = Integer.parseInt(lat1StrSec[0]);
		
		String[] lon1StrHr = coords[1].split("\\*"); //Need data at index 0;
		String[] lon1StrMin = lon1StrHr[1].split("\'"); //Need data at index 0;
		String[] lon1StrSec = lon1StrMin[1].split("\"");//Need data at index 0;
		
		lon1hr = Integer.parseInt(lon1StrHr[0]);
		lon1min = Integer.parseInt(lon1StrMin[0]);
		lon1sec = Integer.parseInt(lon1StrSec[0]);
		
		
		Latitude lat1 = new Latitude(lat1hr, lat1min ,lat1sec);
		Longitude lon1 = new Longitude(lon1hr, lon1min, lon1sec);
		Altitude alt1 = new Altitude(Double.valueOf(coords[2]));
		CoordinateWorld3D position = new CoordinateWorld3D(lat1, lon1, alt1);
		
		AgentID id = new AgentID(command[1]);
		Course course = new Course(Double.valueOf(command[7]));
		Groundspeed speed = new Groundspeed(Double.valueOf(command[9]));
		CommandActorSetState forceCmd = new CommandActorSetState(managers, cliIn, id, position, course, speed);
		return forceCmd;
	}	
}
