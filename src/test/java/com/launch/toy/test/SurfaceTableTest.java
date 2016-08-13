package com.launch.toy.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;

import com.launch.toy.util.Position;
import com.launch.toy.util.SurfaceTable;

public class SurfaceTableTest {

	@Test
	public void testValidatePosition() {
		 Position mockPosition = mock(Position.class);
	        when(mockPosition.getX()).thenReturn(6);
	        when(mockPosition.getY()).thenReturn(7);

	        SurfaceTable board = new SurfaceTable();
	        Assert.assertFalse(board.validatePosition(mockPosition));


	        when(mockPosition.getX()).thenReturn(1);
	        when(mockPosition.getY()).thenReturn(1);
	        Assert.assertTrue(board.validatePosition(mockPosition));


	        when(mockPosition.getX()).thenReturn(-1);
	        when(mockPosition.getY()).thenReturn(-1);
	        Assert.assertFalse(board.validatePosition(mockPosition));
	}

}
