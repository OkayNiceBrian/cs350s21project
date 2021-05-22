package cs350s21project.cli;

import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.command.A_Command;

/*Defines the command to load a file of commands*/
public class CommandMiscLoad extends A_Command<CommandMiscPause>{
   String filename;

   public CommandMiscLoad(CommandManagers managers, String text, String filename){
      super(managers, text);
      this.filename = filename;
   }
   public String getFilename(){
      return this.filename;
   }
   public void execute(){

   }
   @Override
   public String toString(){
    return "toString placeholder txt for CommandMiscLoad";
   }
}