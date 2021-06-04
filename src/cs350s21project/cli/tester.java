package cs350s21project.cli;

public class tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CommandInterpreter cli = new CommandInterpreter();
		cli.evaluate("set id course 090");
		cli.evaluate("set id speed 25");
		cli.evaluate("set id altitude 1500");
		cli.evaluate("set id depth 1500");
		cli.evaluate("define munition bomb b1;");
		cli.evaluate("define munition shell id");
		cli.evaluate("define munition depth_charge id1 with fuze id2");
		cli.evaluate("define munition torpedo id1 with sensor id2 fuze id3 arming time 10.8");
		cli.evaluate("define munition missile id1 with sensor id2 fuze id3 arming distance 25.3");
		cli.evaluate("set id1 load munition id2");
		cli.evaluate("set id1 deploy munition id2");
		cli.evaluate("set id1 deploy munition id2 at azimuth 10 elevation 25");
		
		cli.evaluate("set id course 090;set id speed 25;set id altitude 1500; // hello\nset id depth 1500;define munition bomb b1;define munition shell id;"
				+ ";define munition missile id1 with sensor id2 fuze id3 arming distance 25.3;set id1 deploy munition id2;//yoyoyoy\n");
	}
}
