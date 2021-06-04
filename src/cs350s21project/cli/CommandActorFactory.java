package cs350s21project.cli;


import java.util.ArrayList;

import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.command.actor.*;
import cs350s21project.datatype.AgentID;
import cs350s21project.datatype.Altitude;
import cs350s21project.datatype.CoordinateWorld3D;
import cs350s21project.datatype.Course;
import cs350s21project.datatype.Groundspeed;
import cs350s21project.datatype.Latitude;
import cs350s21project.datatype.Longitude;

//TODO restrict/limit what is allowed 

public class CommandActorFactory {

	public static A_CommandActor<?> getActorCommand(CommandManagers managers, String text) {
		String cmdClean = text.replaceAll("[()]", "");	
		
		String[] cmdArr = cmdClean.split(" ");
		A_CommandActor<?> cmdActor = null;

		try {
		

			
			
			// 1.* define ship id1 with munition[s] (idn+)   munition[s] (idn+) munition[s](// idn+) ...
		    //         0     1   2    3    4          5       6           7        8          9 ...
								
									
			switch(cmdArr[0]) {
				
			
			case "define": {
					if (cmdArr[0].equals("define") && cmdArr[1].equals("ship")) {
					

									
						
						AgentID idActor = new AgentID(cmdArr[2]);
												
						AgentID idMunition = new AgentID(cmdArr[5]);
						ArrayList<AgentID> idMunitions = new ArrayList<AgentID>();
						//runs at least once I believe as we will have a weapon attached to each. 
						
						
						idMunitions.add(idMunition);
						
						
						if (cmdArr.length > 6) {
							for (int i = 6; i < cmdArr.length; i++) {
							
								cmdArr[i] = cmdArr[i].replaceAll("[()]", "");
								
								idMunition = new AgentID(cmdArr[i]);
								
								
								idMunitions.add(idMunition);
		
							}
		
						}
					
					 cmdActor = new CommandActorDefineShip(managers, text, idActor, (java.util.List<AgentID>) idMunitions);
					 break;
					}
				} //end case: ship
				
				
				
			
			 //end define
		
			// create actor *actorFamily* from *actorID* at *position* with azimuth *course* and speed speed
						// and speed *speed*
													  //<--(coordinates)----------->//
			// create actor (Ship) from (Carrier) at (latitude, longitude, altitude ) with azimuth (degree) speed (speed)
						             // coords split 0 1 2    3 4 5      6
			//   0     1      2    3    4          5         6                             7    8       9       10     11

			case "create":{			
		
			if (cmdArr[0].equals("create") && cmdArr[1].equals("actor")) {
				
						AgentID idActor = new AgentID(cmdArr[2]);
						 AgentID id = new AgentID(cmdArr[4]);
						
						
						String[] coords = cmdArr[6].split("/");  //0 is lat, 1 is lon, 2 is alt   \is escape key before  extra "    splitting on "/
					
												
						String[] coordsLat = coords[0].split("\\*|\'|\""); //split lat into individual pieces,    the       '|' is to indicate alternate split
						
						 Latitude latitude = new Latitude(Integer.valueOf(coordsLat[0]), Integer.valueOf(coordsLat[1]), Double.valueOf(coordsLat[2]));
					
						 
						 
						String[] coordsLon = coords[1].split("\\*|\'|\""); //split long into individual pieces,  the  | is to indicate alternate split
						Longitude longitude = new Longitude(Integer.valueOf(coordsLon[0]), Integer.valueOf(coordsLon[1]), Double.valueOf(coordsLon[2]));
					
						Altitude altitude = new Altitude(Double.valueOf(coords[2]));
					
						
						CoordinateWorld3D position = new CoordinateWorld3D(latitude, longitude, altitude); 
						
						
						Course course = new Course(Double.valueOf(cmdArr[9]));
						
						Groundspeed speed = new Groundspeed(Double.valueOf(cmdArr[11]));

						 cmdActor = new CommandActorCreateActor(managers, text, idActor, id, position, course, speed);
						break;
				}
			 //end create
			
			}
			default: break;
				}	
				 //end if statement 
							
		} catch (Exception e) {
			throw new RuntimeException("Invalid Command");
		}
		
		return cmdActor;
	
	}
}
