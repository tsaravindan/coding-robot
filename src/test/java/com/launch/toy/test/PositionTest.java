package com.launch.toy.test;

import org.junit.Assert;
import org.junit.Test;

import com.launch.toy.util.ManageRobotException;
import com.launch.toy.util.Move;
import com.launch.toy.util.Position;

public class PositionTest {

	@Test
	public void testGetNextPosition() throws ManageRobotException {
		Position position = new Position(0, 0, Move.EAST);

        Position newPosition = position.getNextPosition();
        Assert.assertEquals(newPosition.getX(), 1);
        Assert.assertEquals(newPosition.getY(), 0);
        Assert.assertEquals(newPosition.getDirection(), Move.EAST);

        newPosition = newPosition.getNextPosition();
        Assert.assertNotEquals(newPosition.getX(), 1);
        Assert.assertEquals(newPosition.getY(), 0);
        Assert.assertEquals(newPosition.getDirection(), Move.EAST);

        newPosition.setDirection(Move.NORTH);
        newPosition = newPosition.getNextPosition();
        Assert.assertNotEquals(newPosition.getX(), 1);
        Assert.assertEquals(newPosition.getY(), 1);
        Assert.assertNotEquals(newPosition.getDirection(), Move.EAST);
	}

}
