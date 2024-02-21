//Code Modified by Joshua Abeto (991602946)

package time;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class TimeTest {

	@ParameterizedTest
	@ValueSource(strings = { "12:10:10:10", "05:05:10:10" })
	void testGetMillisecondsGood(String candidate) {
		int milliseconds = Time.getMilliseconds(candidate);
		assertTrue("The seconds were not calculated properly", milliseconds==10);
	}

	@Test
	void testGetMillisecondsBad() {
		assertThrows(StringIndexOutOfBoundsException.class, ()-> {Time.getMilliseconds("12:00:00");});
	}
	
	@ParameterizedTest
	@ValueSource(strings = { "10:00:00:59", "10:15:15:59", "10:59:59:59" })
	void testGetMillisecondsBoundary(String candidate) {
		int milliseconds = Time.getMilliseconds(candidate);
		assertEquals(59, milliseconds);
	}
	
	
//	@Test
//	public void testGetTotalSecondsGood() {
//		int seconds = Time.getTotalSeconds("05:05:05");
//		assertTrue("The seconds were not calculated properly", seconds==18305);
//	}
//	
//	@Test
//	public void testGetTotalSecondsBad() {
//		assertThrows(StringIndexOutOfBoundsException.class,
//				()-> {Time.getTotalSeconds("10:00");});
//	}

//	@Test
//	public void testGetTotalBoundary() {
//		int secondsEarliest = Time.getTotalSeconds("00:00:00");
//        assertEquals("The seconds for the earliest time were not calculated properly", 0, secondsEarliest);
//
//        int secondsMidnight = Time.getTotalSeconds("24:00:00");
//        assertEquals("The seconds for midnight were not calculated properly", 86400, secondsMidnight);
//
//        int secondsLatest = Time.getTotalSeconds("23:59:59");
//        assertEquals("The seconds for the latest time were not calculated properly", 86399, secondsLatest);
//	}
	


//	@Test
//	void testGetSeconds() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetTotalMinutes() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	void testGetTotalHours() {
//		fail("Not yet implemented");
//	}

}
