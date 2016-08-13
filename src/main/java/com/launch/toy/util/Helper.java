package com.launch.toy.util;

public class Helper {
	
	Robot robot;
	SurfaceTable surface;
	
	public Helper (Robot robot, SurfaceTable surface){
		this.robot = robot;
		this.surface = surface;
	}
	
	public boolean placeRobot(Position position) 
			throws ManageRobotException {

        if (surface == null)
            throw new ManageRobotException("Invalid surface ");

        if (position == null)
            throw new ManageRobotException("Invalid position");

        if (position.getDirection() == null)
            throw new ManageRobotException("Invalid direction");

        // validate the position
        if (!surface.validatePosition(position))
            return false;

        // if position is valid then assign values to fields
        robot.setPosition(position);
        return true;
    }
	
	public InputParam validateInput(String input) throws ManageRobotException{
		String[] args = input.split(" ");
		InputParam command;
		
		try {
            command = InputParam.valueOf(args[0]);
        } catch (IllegalArgumentException e) {
            throw new ManageRobotException("Invalid command");
        }
		
		if("PLACE".equals(command) ){
			if(args.length < 2 ){
				throw new ManageRobotException("Invalid Command");
			}
		}		
		return command;
	}
	
	public String process(String input) throws ManageRobotException {
		
        String output;
        
        InputParam command;
        String[] args = input.split(" ");

        try {
            command = InputParam.valueOf(args[0]);
        } catch (IllegalArgumentException e) {
            throw new ManageRobotException("Invalid command");
        }
        if (command == InputParam.PLACE && args.length < 2) {
            throw new ManageRobotException("Invalid command");
        }

        // validate PLACE params
        String[] params;
        int x = 0;
        int y = 0;
        Move commandDirection = null;
        if (command == InputParam.PLACE) {
            params = args[1].split(",");
            try {
                x = Integer.parseInt(params[0]);
                y = Integer.parseInt(params[1]);
                commandDirection = Move.valueOf(params[2]);
            } catch (Exception e) {
                throw new ManageRobotException("Invalid command");
            }
        }
        
        switch (command) {
            case PLACE:
                output = String.valueOf(placeRobot(new Position(x, y, commandDirection)));
                break;
            case MOVE:
                Position newPosition = robot.getPosition().getNextPosition();
                if (!surface.validatePosition(newPosition))
                    output = String.valueOf(false);
                else
                    output = String.valueOf(robot.move(newPosition));
                break;
            case LEFT:
                output = String.valueOf(robot.rotateLeft());
                break;
            case RIGHT:
                output = String.valueOf(robot.rotateRight());
                break;
            case REPORT:
                output = report();
                break;
            default:
                throw new ManageRobotException("Invalid command");
        }

        return processOutput(output);
    }
	
	public String processOutput(String output){
		if(output == null){
			return "Place not set. Try again!";
		} else if ("true".equals(output)){
			return "Next command:";
		} else {
			return output;
		}
	}

	
	public String report() {
        if (robot.getPosition() == null)
            return null;

        return robot.getPosition().getX() + "," + robot.getPosition().getY() + "," + robot.getPosition().getDirection().toString();
    }
}
