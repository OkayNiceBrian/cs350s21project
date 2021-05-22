package cs350s21project.cli;

import cs350s21project.controller.CommandManagers;
import cs350s21project.datatype.AgentID;
import cs350s21project.datatype.Latitude;
import cs350s21project.datatype.Longitude;

/*Creates a square window called id of size pixels with a top-down view anchored in the center at latitude1 with
vertical extent latitude2 and grid spacing latitude3, and at longitude1 with horizontal extent longitude2 and
grid spacing longitude3.*/

public class CommandViewCreateWindowTop extends A_CommandViewCreate<CommandViewCreateWindowTop>{
      //CommandManagers field provided in A_Command<_COMMAND_> superclass
      //Size field provided in 
      //AgentID field provided in A_CommandView<_VIEW_ extends A_CommandView<?>> superclass
      //Text field provided in A_CommandViewCreate<_VIEW_ extends A_CommandViewCreate<?>>
      Latitude latitudeOrigin;
      Latitude latitudeExtent;
      Latitude latitudeInterval;
      Longitude longitudeOrigin;
      Longitude longitudeExtent;
      Longitude longitudeInterval;
   
   public CommandViewCreateWindowTop(CommandManagers managers, String text, AgentID idWindow, int size, Latitude latitudeOrigin, Latitude latitudeExtent, Latitude latitudeInterval, Longitude longitudeOrigin, Longitude longitudeExtent, Longitude longitudeInterval){
      super(managers, size, idWindow, text);
      this.latitudeOrigin = latitudeOrigin;
      this.latitudeExtent = latitudeExtent;
      this.latitudeInterval = latitudeInterval;
      this.longitudeOrigin = longitudeOrigin;
      this.longitudeExtent = longitudeExtent;
      this.longitudeInterval = longitudeInterval;
   }
   public void execute(){
      //Find proper syntax for sending command
   }
   public Latitude getLatitudeExtent(){return this.latitudeExtent;}
   public Latitude getLatitudeInterval(){return this.latitudeInterval;}
   public Latitude getLatitudeOrigin(){return this.latitudeOrigin;}
   public Longitude getLongitudeExtent(){return this.longitudeExtent;}
   public Longitude getLongitudeInterval(){return this.longitudeInterval;}
   public Longitude getLongitudeOrigin(){return this.longitudeOrigin;}
   
   @Override
   public String toString(){//// Find out what string this is supposed to return;
      return "toString placeholder txt for CommandViewCreateWindowTop";
   }
   //Inherited Methods//
   /////////////////////
   //getSsize() 
   //getWindowID()
   //createCarrier()
   //getCommandText()
   //getCommandManagers()
      
}