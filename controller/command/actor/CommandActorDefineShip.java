package cs350s21project.controller.command.actor;

import java.util.List;

import cs350s21project.controller.CommandManagers;
import cs350s21project.controller.carrier.CarrierActorShip;
import cs350s21project.datatype.AgentID;

public class CommandActorDefineShip extends A_CommandActorDefine<CommandActorDefineShip>{

		//TODO ensure that all aspects of the ship are defined
	/*creates Command: 
	 * parameters:
	 * managers - - the collection of managers for actors, munitions, and sensors
	text - - the text that originated this command
	idActor - - the actor identifier
	idMunitions - - the identifiers of the munitions on board*/
	public CommandActorDefineShip(CommandManagers managers, String text, AgentID idActor, List<AgentID> idMunitions) {
		super(managers, text, idActor, idMunitions);
		// TODO Auto-generated constructor stub ensure all parameters required are set and functioning
	}
	
	
	//Creates the carrier for this command.
	//TODO fill out/confirm all aspects of Carrier 
	@Override
	public CarrierActorShip createCarrier() {
		
				//TODO giving error when I enter a munitionsID 	
		CarrierActorShip carrier = new CarrierActorShip(_text, _idActor, null); //null is placeholder for munitiions ID //TODO currently isn't taking _idMunitions
		
		return carrier;
		
	}
	
	
	
}
