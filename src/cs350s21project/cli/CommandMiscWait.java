package cs350s21project.cli;

import cs350s21project.controller.CommandManagers;
import cs350s21project.datatype.Time;

public class CommandMiscWait extends A_Command<CommandMiscWait>{
   public CommandMiscWait(CommandManagers managers, String text, Time time){
      super(managers, text);
      this.time = time;
   }
   public void execute(){
      //Find proper syntax for commands
   }
   public Time getTime(){return this.time;}
   @Override 
   public String toString(){
      return "toString placeholder txt for CommandMiscPause";
   }
}