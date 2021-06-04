package cs350s21project.cli;

import java.awt.List;

import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.command.actor.*;
import cs350s21project.controller.command.munition.A_CommandMunition;
import cs350s21project.datatype.AgentID;
import cs350s21project.datatype.Altitude;
import cs350s21project.datatype.CoordinateWorld3D;
import cs350s21project.datatype.Course;
import cs350s21project.datatype.Groundspeed;
import cs350s21project.datatype.Latitude;
import cs350s21project.datatype.Longitude;

//TODO restrict/limit what is allowed 

public class CommandActorFactory {

	public static A_CommandActor<?> getActorCommand(CommandManagers managers, String text, AgentID idActor) {

		String[] cmdArr = text.split(" ");
		A_CommandActor<?> cmdActor = null;

		try {

			// 1.* define ship id1 with munition[s] (idn+)   munition[s] (idn+) munition[s](// idn+) ...
		    //         0     1   2    3    4          5       6           7        8          9 ...
			if (cmdArr[0].equals("define") && cmdArr[1].equals("ship")) {
			
					 idActor = new AgentID(cmdArr[2]);
					
					
					// TODO this may already be covered but, allow for multiple additions (for or while loop until ; ) as long as the getCommandMunition is functioning and catches the outliers, we shouldn't have a problem. 
	
					// Below should account for each of these
					// AgentID type of munition
					// AgentID fuzeID
					// Time armingTime
	
					List idMunitions = new List();
					//runs at least once I believe as we will have a weapon attached to each. 
					A_CommandMunition<?> cmdMunition = CommandMunitionFactory.getCommandMunition(managers, text);
						//TODO ? munitions array index 2  name of munition (bomb) and index 3 for munition id  
					idMunitions.add(String.valueOf(cmdMunition));
					//AgentID id = new AgentID(cmdArr[5]);
					
					if (cmdArr.length > 5) {
						for (int i = 0; i < cmdArr.length; i++) {
							
							cmdMunition = CommandMunitionFactory.getCommandMunition(managers, text);
	
							 
							idMunitions.add(String.valueOf(cmdMunition));
	
						}
	
					}
				
				cmdActor = new CommandActorDefineShip(managers, text, idActor, (java.util.List<AgentID>) idMunitions);

			}

			// create actor *actorFamily* from *actorID* at *position* with azimuth *course*
			// and speed *speed*
										  //<--(coordinates)----------->//
// create actor (Ship) from (Carrier) at (latitude, longitude, altitude ) with azimuth (degree), and speed (speed)
			             // coords split 0 1 2    3 4 5      6
//   0     1      2    3    4      5    6         7             8       9     10      11      12   13    14

			else if (cmdArr[0].equals("create") && cmdArr[1].equals("actor")) {
				
				 idActor = new AgentID(cmdArr[2]);
				 AgentID id = new AgentID(cmdArr[4]);
				String[] coords = cmdArr[6].split("*'/");
				Latitude latitude = new Latitude(Integer.valueOf(coords[0]), Integer.valueOf(coords[1]), Double.valueOf(coords[2]));
				
				Longitude longitude = new Longitude(Integer.valueOf(coords[3]), Integer.valueOf(coords[4]), Double.valueOf(coords[5]));
				
				Altitude altitude = new Altitude(Double.valueOf(coords[6]));

				CoordinateWorld3D position = new CoordinateWorld3D(latitude, longitude, altitude); 
				
				//TODO do i need to limit course to 360 degrees = 0?
				Course course = new Course(Double.valueOf(cmdArr[11]));
				
				Groundspeed speed = new Groundspeed(Double.valueOf(cmdArr[14]));

				cmdActor = new CommandActorCreateActor(managers, text, idActor, id, position, course, speed);
			}

		} catch (Exception e) {
			throw new RuntimeException("Invalid Command");
		}

		return cmdActor;
	}
}
