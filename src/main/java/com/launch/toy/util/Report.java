package com.launch.toy.util;

public class Report {
	
	public String getReport(Robot robot){
		Position pos = robot.getPosition();
		return pos.getX() + "," + pos.getY() + "," ;
	}

}