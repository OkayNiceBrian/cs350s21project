package cs350s21project.cli;

import cs350s21project.controller.*;
import cs350s21project.controller.command.A_Command;

public class CommandInterpreter {

	// TODO Handle multiple commands separated by ';'
	// TODO ignore preceded by //
	public void evaluate(String command) {
		
		// Get our command manager
		CommandManagers managers = CommandManagers.getInstance();
		
		// switch to parse string
		String[] cmdArr = command.split(" ", 0);
		A_Command<?> builtCommand = null;
		
		// Check first word in command
		switch(cmdArr[0]) {
		case "define":
		case "create":
		case "delete":
		case "set": 
		case "@load": // Handle spaces in file name
		case "@pause":
		case "@resume":
		case "@set":
		case "@wait":
		case "@force":
		case "@exit":
		default: break;
		}
		
		managers.schedule(builtCommand);
	}
}
