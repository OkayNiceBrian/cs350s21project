package cs350s21project.cli;

import java.awt.List;


import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.command.actor.*;
import cs350s21project.datatype.AgentID;


//TODO restrict/limit what is allowed 

public class CommandActorFactory {

	public static A_CommandActor<?> getCommandActor(CommandManagers managers, String command){
	
		String[] cmdArr = command.split(" ", 0);
		A_CommandActor<?> cmdActor = null;
	
		
		if(cmdArr[0].equals("define") && cmdArr[1].equals("ship"))
		{
			AgentID idActor = new AgentID(cmdArr[2]);	//sets ID to that of a ship (assigns) 
			
			List idMunitions = new List();
			
		
	}

	
	return cmdActor;
	
	}
}
