package com.launch.toy.test;

import org.junit.Assert;
import org.junit.Test;

import com.launch.toy.util.Move;

public class MoveTest {

	@Test
	public void testMove() {
		Move direction = Move.EAST;

        direction = direction.leftDirection();
        Assert.assertEquals(direction, Move.NORTH);

        direction = direction.leftDirection();
        Assert.assertEquals(direction, Move.WEST);

        direction = direction.leftDirection();
        Assert.assertEquals(direction, Move.SOUTH);

        direction = direction.leftDirection();
        Assert.assertEquals(direction, Move.EAST);

        direction = direction.leftDirection();
        Assert.assertEquals(direction, Move.NORTH);

        direction = direction.rightDirection();
        Assert.assertEquals(direction, Move.EAST);

        direction = direction.rightDirection();
        Assert.assertEquals(direction, Move.SOUTH);

        direction = direction.rightDirection();
        Assert.assertEquals(direction, Move.WEST);

        direction = direction.rightDirection();
        Assert.assertEquals(direction, Move.NORTH);

        direction = direction.rightDirection();
        Assert.assertEquals(direction, Move.EAST);
	}


}
