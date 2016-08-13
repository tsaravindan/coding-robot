package com.launch.toy;

import java.io.Console;

import com.launch.toy.util.Helper;
import com.launch.toy.util.ManageRobotException;
import com.launch.toy.util.Robot;
import com.launch.toy.util.SurfaceTable;

public class Main {
	public static void main(String[] args) throws Exception {
		System.out.println("Input Commands in the following order :");
		System.out.println("PLACE X,Y,F {F -> NORTH|SOUTH|EAST|WEST}");
		System.out.println("MOVE|LEFT|RIGHT|REPORT");
		System.out.println("EXIT to Quit");
		Console console = System.console();
		Helper help = new Helper(new Robot(), new SurfaceTable());
		while(true){
            String input = console.readLine();
            if("exit".equalsIgnoreCase(input)){
            	break;
            }
            try {
                String output = help.process(input);
                System.out.println(output);
            } catch (ManageRobotException e) {
                System.out.println(e.getMessage());
            }
			
		}
	}
}
