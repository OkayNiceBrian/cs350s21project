package cs350s21project.cli;

import cs350s21project.controller.*;
import cs350s21project.controller.command.A_Command;

public class CommandInterpreter {

	public void evaluate(String command) {
		
		// Get our command manager
		CommandManagers managers = CommandManagers.getInstance();
		
		// Split commands by semicolon to handle multiple commands
		String[] commands = command.split(";", 0);
		
		for (String commandString : commands) {
			commandString = commandString.trim();
			
			// Handle comments
			for (int i = 0; i < commandString.length(); i++) {
				if (commandString.charAt(i) == '/' && i < commandString.length() - 1 && commandString.charAt(i + 1) == '/') {
					commandString = commandString.substring(0, i) + commandString.substring(commandString.lastIndexOf("\n"), commandString.length() - 1);
				}
			}
			
			commandString = commandString.trim();
			
			// Create an array of words in the command
			String[] cmdArr = commandString.split(" ", 0);
			A_Command<?> builtCommand = null;
			
			try {
				if (cmdArr[0].charAt(0) == '@') {
					builtCommand = MiscCmdFactory.buildMiscCmd(managers, commandString); break;
				} else {
					// Check first word in command
					switch(cmdArr[0]) {
					case "define":{
						switch(cmdArr[1]) {
						case "ship": break;
						case "munition": builtCommand = CommandMunitionFactory.getCommandMunition(managers, commandString); break;
						case "sensor": break;
						default: throw new RuntimeException("Invalid command input!");
						}
						break;
					}
					case "create":{
						switch(cmdArr[1]) {
						case "window": builtCommand = MiscCmdFactory.buildMiscCmd(managers, commandString); break;
						case "actor": break;
						default: throw new RuntimeException("Invalid command input!");
						}
						break;
					}
					case "delete":{
						switch(cmdArr[1]) {
						case "window": builtCommand = MiscCmdFactory.buildMiscCmd(managers, commandString); break;
						default: throw new RuntimeException("Invalid command input!");
						}
						break;
					}
					case "set": {
						builtCommand = CommandSetFactory.getSetCommand(managers, commandString); break;
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
