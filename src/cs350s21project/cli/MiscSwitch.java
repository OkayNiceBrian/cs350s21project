package cs350s21project.cli;

public class MiscSwitch {

	public void getCommand(String userIn) {
		String[] command = userIn.split(" ");
		switch(command[0]) {
			case "@load":
			case "@pause":
			case "@resume":
			case "@set":
			case "@wait":
			case "@force":
			case "@exit":
			default: break;
		}
	}
}
