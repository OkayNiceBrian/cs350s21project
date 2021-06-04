package cs350s21project.cli;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CommandInterpreter cli = new CommandInterpreter();
		cli.evaluate("define munition bomb b1; // comment \ndelete window win; // comment again \n");
		cli.evaluate("delete window win");
		cli.evaluate("define munition missile id1 with sensor id2 fuze id3 arming distance 20.0");
		cli.evaluate("set id1 deploy munition id2 at azimuth 20 elevation 20");
		cli.evaluate("@wait 20");
	}
}
