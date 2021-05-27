package cs350s21project.cli;

import cs350s21project.controller.*;
import cs350s21project.controller.command.A_Command;

public class CommandInterpreter {

	// TODO ignore preceded by //, ask about what comments look like
	public void evaluate(String command) {
		
		// Get our command manager
		CommandManagers managers = CommandManagers.getInstance();
		
		// Split commands by semicolon to handle multiple commands
		String[] commands = command.split(";", 0);
		
		for (String commandString : commands) {
			
			// Create an array of words in the command
			String[] cmdArr = commandString.split(" ", 0);
			A_Command<?> builtCommand = null;
			
			try {
				if (cmdArr[0].charAt(0) == '@') {
					// builtCommand = miscFactory.getCommandMisc(managers, command); break;
				} else {
					// Check first word in command
					switch(cmdArr[0]) {
					case "define":{
						switch(cmdArr[1]) {
						case "ship": break;
						case "munition": builtCommand = CommandMunitionFactory.getCommandMunition(managers, command); break;
						case "sensor": break;
						default: throw new RuntimeException("Invalid command input!");
						}
						break;
					}
					case "create":{
						switch(cmdArr[1]) {
						case "window": break;
						case "actor": break;
						default: throw new RuntimeException("Invalid command input!");
						}
						break;
					}
					case "delete":{
						switch(cmdArr[1]) {
						case "window": break;
						default: throw new RuntimeException("Invalid command input!");
						}
						break;
					}
					case "set": {
						// builtCommand = CommandSetFactory.getCommandSet(managers, command); break;
						break;
					}
					default: throw new RuntimeException("Invalid command input!");
					}
				}
			} catch (Exception e) {
				throw new RuntimeException("Invalid command");
			}
			
			managers.schedule(builtCommand);
		}
	}
}
