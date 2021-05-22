package cs350s21project.cli;

import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.command.A_Command;

public class CommandMiscExit extends A_Command<CommandMiscExit>{
   
   public CommandMiscExit(CommandManagers managers, String text){
      super(managers, text);
   }
   public void execute(){
   //Find proper syntax for commands
   }
   @Override
   public String toString(){
      return "toString placeholder txt for CommandMiscExit";
   }
}