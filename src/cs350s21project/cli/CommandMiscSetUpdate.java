package cs350s21project.cli;

import cs350s21project.controller.CommandManagers;
import cs350s21project.datatype.Time;

public class CommandMiscSetUpdate extends A_Command<CommandMiscSetUpdate>{
   public CommandMiscSetUpdate(CommandManagers managers, String text, Time time){
      super(managers, text);
      this.time = time;
   }
   public void execute(){
      //Find proper syntax for commands
   }
   public Time getTime(){return this.Time;}
   @Override 
   public String toString(){
      return "toString placeholder txt for CommandMiscResume";
   }
}