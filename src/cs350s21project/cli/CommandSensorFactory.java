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
import cs350s21project.datatype.AngleNavigational;
import cs350s21project.datatype.DistanceNauticalMiles;
import cs350s21project.datatype.FieldOfView;
import cs350s21project.datatype.Power;
import cs350s21project.datatype.Sensitivity;
import cs350s21project.datatype.Time;

public class CommandSensorFactory {

	public static A_CommandSensor<?> getCommandSensor(CommandManagers managers, String text, AgentID idSensor){
		
		String[] cmdArr = text.split(" ", 0);
		A_CommandSensor<?> cmdSensor = null;
		
		
		
		try {
		
		if(cmdArr[0].equals("define") && cmdArr[1].equals("sensor"))	
		{
				//sents id to id of sensor: idSensor
			

			switch (cmdArr[2]) {
		
			//1.* define sensor radar id with field of view fov power power sensitivity sensitivity
			//      0      1      2    3  4     5    6   7   8   9      10     11         12           
				case "radar": {	

					idSensor = new AgentID(cmdArr[3]);
					 
					 
					 
					FieldOfView fov = new FieldOfView(new AngleNavigational(Integer.parseInt(cmdArr[8]))); 
					Power power = new Power(Double.parseDouble(cmdArr[10]));
					Sensitivity	sensitivity = new Sensitivity(Double.parseDouble(cmdArr[12]));
				
					cmdSensor = new CommandSensorDefineRadar(managers, text, idSensor, fov, power, sensitivity); 
					break;
				}
				
				
				//2. define sensor thermal id with field of view fov sensitivity sensitivity
				 //     0      1    2      3    4   5    6  7    8       9         10
				case "thermal": {	
					 idSensor = new AgentID(cmdArr[3]);	
					FieldOfView fov = new FieldOfView(new AngleNavigational(Integer.parseInt(cmdArr[8]))); 
				
					Sensitivity	sensitivity = new Sensitivity(Double.parseDouble(cmdArr[10]));
					
					cmdSensor = new CommandSensorDefineThermal(managers, text, idSensor, fov, sensitivity); 
					break;
				}
				
				
				
				//3. define sensor acoustic id with sensitivity sensitivity
				//       0      1       2    3    4       5          6
				case "acoustic": {	
					 idSensor = new AgentID(cmdArr[3]);	
							
					Sensitivity sensitivity = new Sensitivity(Double.parseDouble(cmdArr[6]));
					
					cmdSensor = new CommandSensorDefineAcoustic(managers, text, idSensor, sensitivity); 
					break;
				}
		
				
				//4/5    define sensor sonar  passive/active                varies based on passive or active. see below
				//       0        1      2          3                    4   5     6     7        8           9
				case "sonar": {
				
					
					switch(cmdArr[3]) {
					
					
					//4.* define sensor sonar active id with power power sensitivity sensitivity
					//       0     1      2      3    4   5     6     7        8           9
					
						case "active":{
							 idSensor = new AgentID(cmdArr[4]);	//sents id to id of sensor: idSensor
							Power power = new Power(Double.parseDouble(cmdArr[7]));
							Sensitivity sensitivity = new Sensitivity(Double.parseDouble(cmdArr[9]));
							
							cmdSensor = new CommandSensorDefineSonarActive(managers, text, idSensor, power, sensitivity); 
							break;
						}
					
					//	5. define sensor sonar passive id with sensitivity sensitivity		
//				             0     1      2      3    4    5     6             7        
						
						case "passive": {	
							
							 idSensor = new AgentID(cmdArr[4]);	//sents id to id of sensor: idSensor
							Sensitivity sensitivity = new Sensitivity(Double.parseDouble(cmdArr[7]));
							
							cmdSensor = new CommandSensorDefineSonarPassive(managers, text, idSensor, sensitivity); 
							break;
						}
					} //end switch of sonar
					
					
				}
				
				//6. define sensor depth id with trigger depth altitude
				//     0     1       2    3  4       5     6       7
				case "depth": {	
				 idSensor = new AgentID(cmdArr[3]);	//sents id to id of sensor: idSensor
					
					Altitude depth = new Altitude(Double.parseDouble(cmdArr[7]));
					
					cmdSensor = new CommandSensorDefineDepth(managers, text, idSensor, depth); 
					break;
				}
				
			//	7.* define sensor distance id with trigger distance distance
			//		   0    1          2    3   4    5        6        7
				
				case "distance": {	
					 idSensor = new AgentID(cmdArr[3]);	//sents id to id of sensor: idSensor
					
					DistanceNauticalMiles distance= new DistanceNauticalMiles(Double.parseDouble(cmdArr[7]));
					
					cmdSensor = new CommandSensorDefineDistance(managers, text, idSensor, distance); 
					break;
				}
				
				//8. define sensor time id with trigger time time
				//      0      1     2   3  4     5       6   7
				
				case "time": {	
					 idSensor = new AgentID(cmdArr[3]);	//sents id to id of sensor: idSensor
					
					Time time = new Time(Double.parseDouble(cmdArr[7]));
					
					cmdSensor = new CommandSensorDefineTime(managers, text, idSensor, time); 
					break;
				}
				
			
			default: break;	//end switch sensor statement 
			}
		}
	}catch (Exception e) {
			throw new RuntimeException("Invalid Command");
			
	}
	return cmdSensor;
		
	
		
	}
}
