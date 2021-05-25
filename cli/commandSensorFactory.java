package cs350s21project.cli;

import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.command.sensor.A_CommandSensor;
import cs350s21project.controller.command.sensor.CommandSensorDefineAcoustic;
import cs350s21project.controller.command.sensor.CommandSensorDefineDepth;
import cs350s21project.controller.command.sensor.CommandSensorDefineDistance;
import cs350s21project.controller.command.sensor.CommandSensorDefineRadar;
import cs350s21project.controller.command.sensor.CommandSensorDefineSonarActive;
import cs350s21project.controller.command.sensor.CommandSensorDefineSonarPassive;
import cs350s21project.controller.command.sensor.CommandSensorDefineThermal;
import cs350s21project.controller.command.sensor.CommandSensorDefineTime;
import cs350s21project.datatype.AgentID;
import cs350s21project.datatype.Altitude;
import cs350s21project.datatype.DistanceNauticalMiles;
import cs350s21project.datatype.FieldOfView;
import cs350s21project.datatype.Power;
import cs350s21project.datatype.Sensitivity;
import cs350s21project.datatype.Time;

public class commandSensorFactory {

	public static A_CommandSensor<?> getCommandSensor(CommandManagers managers, String text, AgentID idSensor){
		
		String[] cmdArr = text.split(" ", 0);
		A_CommandSensor<?> cmdSensor = null;
		
		
		//TODO munitions has AgentId id = new AgentID(cmdArr[3]); //why 3 is that munition specific? should be 2 to match position of id? maybe based on where submitted in text?
		
		
		
		if(cmdArr[0].equals("define") && cmdArr[1].equals("sensor"))	//TODO confirm that sensor is generic word -> might be radar-sensor for example
		{
			AgentID id = new AgentID(cmdArr[2]);	//sents id to id of sensor: idSensor
			FieldOfView fov; //TODO not sure that this is applicable
			Power power; //TODO not sure that this is specific enough. Maybe cast as CommandSensorFactory??
			Sensitivity sensitivity;
		
			
			
		switch (cmdArr[2]) {
		
			case "radar-sensor": {	//TODO confirm words/with hyphen is appropriate
				id = new AgentID(cmdArr[2]);	//sents id to id of sensor: idSensor
				fov = ((CommandSensorDefineRadar) cmdSensor).getFieldOfView(); //TODO not sure that this is applicable
				 power = ((CommandSensorDefineRadar) cmdSensor).getPower(); //TODO not sure that this is specific enough. Maybe cast as CommandSensorFactory??
				sensitivity = ((CommandSensorDefineRadar) cmdSensor).getSensitivity();
			
				cmdSensor = new CommandSensorDefineRadar(managers, text, id, fov, power, sensitivity); 
				break;
			}
			
			
			case "thermal-sensor": {	//TODO confirm words/with hyphen is appropriate
				id = new AgentID(cmdArr[2]);	//sents id to id of sensor: idSensor
				fov = ((CommandSensorDefineThermal) cmdSensor).getFieldOfView(); //TODO not sure that this is applicable
			
				sensitivity = ((CommandSensorDefineThermal) cmdSensor).getSensitivity();
				
				cmdSensor = new CommandSensorDefineThermal(managers, text, id, fov, sensitivity); 
				break;
			}
			
			
			case "acoustic-sensor": {	//TODO confirm words/with hyphen is appropriate
				id = new AgentID(cmdArr[2]);	//sents id to id of sensor: idSensor
						
				sensitivity = ((CommandSensorDefineAcoustic) cmdSensor).getSensitivity();
				
				cmdSensor = new CommandSensorDefineAcoustic(managers, text, id, sensitivity); 
				break;
			}
	
			
			case "active-sonar-sensor": {	//TODO confirm words/with hyphen is appropriate
				id = new AgentID(cmdArr[2]);	//sents id to id of sensor: idSensor
				power = ((CommandSensorDefineSonarActive) cmdSensor).getPower();	
				sensitivity = ((CommandSensorDefineSonarActive) cmdSensor).getSensitivity();
				
				cmdSensor = new CommandSensorDefineSonarActive(managers, text, id, power, sensitivity); 
				break;
			}
			
			
			case "passive-sonar-sensor": {	//TODO confirm words/with hyphen is appropriate
				id = new AgentID(cmdArr[2]);	//sents id to id of sensor: idSensor
				
				sensitivity = ((CommandSensorDefineSonarPassive) cmdSensor).getSensitivity();
				
				cmdSensor = new CommandSensorDefineSonarPassive(managers, text, id, sensitivity); 
				break;
			}
			
			case "depth-sensor": {	//TODO confirm words/with hyphen is appropriate
				id = new AgentID(cmdArr[2]);	//sents id to id of sensor: idSensor
				
				Altitude depth = ((CommandSensorDefineDepth) cmdSensor).getDepth();
				
				cmdSensor = new CommandSensorDefineDepth(managers, text, id, depth); 
				break;
			}
			
			case "distance-sensor": {	//TODO confirm words/with hyphen is appropriate
				id = new AgentID(cmdArr[2]);	//sents id to id of sensor: idSensor
				
				DistanceNauticalMiles distance= ((CommandSensorDefineDistance) cmdSensor).getDistance();
				
				cmdSensor = new CommandSensorDefineDistance(managers, text, id, distance); 
				break;
			}
			
			case "time-sensor": {	//TODO confirm words/with hyphen is appropriate
				id = new AgentID(cmdArr[2]);	//sents id to id of sensor: idSensor
				
				Time time = ((CommandSensorDefineTime) cmdSensor).getTime();
				
				cmdSensor = new CommandSensorDefineTime(managers, text, id, time); 
				break;
			}
			
			
			default: break;	//end switch sensor statement 
		}
		
		}
		return cmdSensor;
		
	}

}
