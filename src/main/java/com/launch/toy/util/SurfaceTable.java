package com.launch.toy.util;

public class SurfaceTable {
	
	int row = 5;
    int column = 5;
	
	public boolean validatePosition(Position position) {
		
		if(position.getX() > this.column || position.getX() < 0 ||
	            position.getY() > this.row || position.getY() < 0)
			return false;
		else 
			return true;
    }

}
