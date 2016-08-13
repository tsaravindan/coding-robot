package com.launch.toy.test;

import org.junit.Assert;
import org.junit.Test;

import com.launch.toy.util.ManageRobotException;
import com.launch.toy.util.Move;
import com.launch.toy.util.Position;
import com.launch.toy.util.Robot;

public class RobotTest {

	@Test
	public void testMove() throws ManageRobotException {
		Robot robot = new Robot(new Position(0, 0, Move.NORTH));

        Assert.assertTrue(robot.move());
        Assert.assertEquals(0, robot.getPosition().getX());
        Assert.assertEquals(1, robot.getPosition().getY());
        Assert.assertEquals(Move.NORTH, robot.getPosition().getDirection());


        robot.setPosition(new Position(1, 2, Move.EAST));
        robot.move();
        robot.move();
        robot.rotateLeft();
        robot.move();

        Assert.assertEquals(3, robot.getPosition().getX());
        Assert.assertEquals(3, robot.getPosition().getY());
        Assert.assertEquals(Move.NORTH, robot.getPosition().getDirection());

        robot.setPosition(new Position(0, 0, Move.NORTH));
        robot.rotateRight();
        Assert.assertEquals(Move.EAST, robot.getPosition().getDirection());
        robot.rotateRight();
        Assert.assertEquals(Move.SOUTH, robot.getPosition().getDirection());
        robot.rotateRight();
        Assert.assertEquals(Move.WEST, robot.getPosition().getDirection());
        robot.rotateRight();
        Assert.assertEquals(Move.NORTH, robot.getPosition().getDirection());
        robot.rotateRight();
        Assert.assertEquals(Move.EAST, robot.getPosition().getDirection());
	}

}
