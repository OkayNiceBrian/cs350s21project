package cs350s21project.cli;

import cs350s21project.controller.CommandManagers;

public class CommandMiscPause extends A_Command<CommandMiscPause>{
   public CommandMiscPause(CommandManagers managers, String text){
      super(managers, text);
   }
   public void execute(){
   //Find proper syntax for commands
   }
   @Override 
   public String toString(){
      return "toString placeholder txt for CommandMiscPause";
   }
}