import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class TicTest {

	private Tic tic;
	@Before
	public void setUp() {
		tic = new Tic(3, 3);
	}
	@Test
	public void testObjectCreation() {
		/*
		This test checks if the Tic object is created correctly.
		It asserts that the object is not null, the turn is set to "X",
		and the rows and columns are set to 3.
		 */
		assertNotNull(tic);
		assertEquals("X", tic.turn);
		assertEquals(3, tic.rows);
		assertEquals(3, tic.cols);
	}
	@Test
	public void testInitialBoardState() {
		for(int i = 0; i < tic.rows; i++) {
			for(int j = 0; j < tic.cols; j++) {
				assertEquals("_", tic.board[i][j]);
			}
		}
	}
	@Test
	public void testTurnChange() {
		tic.turn = "O";
		assertEquals("X", tic.turn); // This will fail
		// assertEquals("O", tic.turn); // Uncomment this line and comment the previous one to make the test pass
	}
}


