package com.launch.toy.test;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.launch.toy.util.Helper;
import com.launch.toy.util.ManageRobotException;
import com.launch.toy.util.Move;
import com.launch.toy.util.Position;
import com.launch.toy.util.Robot;
import com.launch.toy.util.SurfaceTable;

public class HelperTest {
	
	@Rule
    public org.junit.rules.ExpectedException thrown = ExpectedException.none();

	@Test
	public void testPlaceRobot() throws ManageRobotException {
		SurfaceTable board = new SurfaceTable();
        Robot toyRobot = new Robot();
        Helper game = new Helper(toyRobot, board);

        Assert.assertTrue(game.placeRobot(new Position(0, 1, Move.NORTH)));
        Assert.assertTrue(game.placeRobot(new Position(2, 2, Move.SOUTH)));
        Assert.assertFalse(game.placeRobot(new Position(6, 6, Move.WEST)));
        Assert.assertFalse(game.placeRobot(new Position(-1, 5, Move.EAST)));
        
        thrown.expect(ManageRobotException.class);
        game.placeRobot(null);
        thrown.expect(ManageRobotException.class);
        game.placeRobot(new Position(0, 1, null));
	}

	@Test
	public void testProcess() throws ManageRobotException {
		SurfaceTable board = new SurfaceTable();
        Robot toyRobot = new Robot();
        Helper game = new Helper(toyRobot, board);

        game.process("PLACE 0,0,NORTH");
        Assert.assertEquals("0,0,NORTH", game.process("REPORT"));

        game.process("MOVE");
        game.process("RIGHT");
        game.process("MOVE");
        Assert.assertEquals("1,1,EAST", game.process("REPORT"));

        // if it goes out of the board it ignores the command
        for (int i = 0; i < 10; i++)
            game.process("MOVE");
        Assert.assertEquals("5,1,EAST", game.process("REPORT"));

        //rotate on itself
        for (int i = 0; i < 4; i++)
            game.process("LEFT");
        Assert.assertEquals("5,1,EAST", game.process("REPORT"));

        // invalid commands
        thrown.expect(ManageRobotException.class);
        Assert.assertEquals("Invalid command", game.process("PLACE12NORTH"));
        thrown.expect(ManageRobotException.class);
        Assert.assertEquals("Invalid command", game.process("LEFFT"));
        thrown.expect(ManageRobotException.class);
        Assert.assertEquals("Invalid command", game.process("RIGHTT"));
	}

}
