package cs350s21project.cli;

import cs350s21project.controller.CommandManagers;
import cs350s21project.datatype.AgentID;
import cs350s21project.datatype.Latitude;
import cs350s21project.datatype.Longitude;

public class CommandViewDeleteWindow extends A_CommandView<CommandViewDeleteWindow>{
   public CommandViewDeleteWindow(CommandManagers managers, String text, AgentID idWindow){
      super(managers, text, idWindow);
   }
   public void execute(){
      //Find proper syntax for commands
   }
   @Override
   public String toString(){
      return "toString placeholder txt for CommandViewDeleteWindow";
   }
}