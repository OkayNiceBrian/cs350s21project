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
		
		cli.evaluate("define sensor radar FUZE_RADAR1 with field of view 30 power 50 sensitivity 10");
		cli.evaluate("define sensor thermal FUZE_THERMAL1 with field of view 35 sensitivity 15");
		cli.evaluate("define sensor acoustic FUZE_ACOUSTIC1 with sensitivity 10");
		cli.evaluate("define sensor acoustic FUZE_ACOUSTIC2 with sensitivity 10");
		cli.evaluate("define sensor sonar active FUZE_SONAR_ACTIVE1 with power 15 sensitivity 15");
		cli.evaluate("define sensor sonar passive FUZE_SONAR_PASSIVE1 with sensitivity 10");
		cli.evaluate("define sensor depth FUZE_DEPTH1 with trigger depth 10");
		cli.evaluate("define sensor depth FUZE_DEPTH2 with trigger depth -10");
		cli.evaluate("define sensor distance FUZE_DISTANCE1 with trigger distance 50");
		cli.evaluate("define sensor time FUZE_TIME1 with trigger time 13.5");
		
		
		cli.evaluate("define ship ACTOR_SHIP1 with munition (MUNITION_MISSILE1) (MUNITION_MISSILE2) (MUNITION_MISSILE3)"); 
		cli.evaluate("create actor MY_SHIP1 from ACTOR_SHIP1 at 45*30\'15\"/110*30\'10\"/200 with course 270 speed 0");
		
		cli.evaluate("create window 1234 top view with 300 (45*30\'15\"/40*20\'10\" 45*30\'15\"/40*20\'10\" 45*30\'15\"/40*20\'10\") (45*30\'15\"/40*20\'10\" 45*30\'15\"/40*20\'10\" 45*30\'15\"/40*20\'10\")");
		cli.evaluate("delete window 123");
		cli.evaluate("@load fileName");
		cli.evaluate("@pause");
		cli.evaluate("@resume");
		cli.evaluate("@set update 10.95");
		cli.evaluate("@wait 15.2");
		cli.evaluate("@force 54321 state to 45*30\'15\"/40*20\'10\"/300 with course 35 speed 100");
		cli.evaluate("@exit");
	}
}
