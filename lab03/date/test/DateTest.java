import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateTest {

  @Test
  void nextDate_tc01() {
    Date today = new Date(1700, 6, 20);
    Date expectedTomorrow = new Date(1700, 6, 21);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc02() {
    Date today = new Date(2005, 4, 15);
    Date expectedTomorrow = new Date(2005, 4, 16);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc03() {
    Date today = new Date(1901, 7, 20);
    Date expectedTomorrow = new Date(1901, 7, 21);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc04() {
    Date today = new Date(3456, 3, 27);
    Date expectedTomorrow = new Date(3456, 3, 28);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc05() {
    Date today = new Date(1500, 2, 17);
    Date expectedTomorrow = new Date(1500, 2, 18);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc06() {
    Date today = new Date(1700, 6, 29);
    Date expectedTomorrow = new Date(1700, 6, 30);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc07() {
    Date today = new Date(1800, 11, 29);
    Date expectedTomorrow = new Date(1800, 11, 30);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc08() {
    Date today = new Date(3453, 1, 29);
    Date expectedTomorrow = new Date(3453, 1, 30);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc09() {
    Date today = new Date(444, 2, 29);
    Date expectedTomorrow = new Date(444, 3, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc10() {
    Date today = new Date(2005, 4, 30);
    Date expectedTomorrow = new Date(2005, 5, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc11() {
    Date today = new Date(3453, 1, 30);
    Date expectedTomorrow = new Date(3453, 1, 31);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc12() {
    Date today = new Date(3456, 3, 30);
    Date expectedTomorrow = new Date(3456, 3, 31);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc13() {
    Date today = new Date(1901, 7, 31);
    Date expectedTomorrow = new Date(1901, 8, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc14() {
    Date today = new Date(3453, 1, 31);
    Date expectedTomorrow = new Date(3453, 2, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_tc15() {
    Date today = new Date(3456, 12, 31);
    Date expectedTomorrow = new Date(3457, 1, 1);
    assertEquals(expectedTomorrow, today.nextDate());
  }

  @Test
  void nextDate_invalid_tc16() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(1500, 2, 31)
    );
  }

  @Test
  void nextDate_invalid_tc17() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(1500, 2, 29)
    );
  }

  @Test
  void nextDate_invalid_tc18() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(-1, 10, 20)
    );
  }

  @Test
  void nextDate_invalid_tc19() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(1458, 15, 12)
    );
  }

  @Test
  void nextDate_invalid_tc20() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(1975, 6, -50)
    );
  }

  @Test
  void day_invalid_tc21() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(2021, 5, 32)
    );
  }

  @Test
  void day_invalid_tc22() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(2021, 4, 31)
    );
  }

  @Test
  void day_invalid_tc23() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(2000, 2, 30)
    );
  }

  @Test
  void toString_tc24() {
    Date d = new Date(2021, 4, 13);
    assertEquals(d.toString(), "2021/April/13");
  }

  @Test
  void endOfMonth_tc25() {
    Date d = new Date(2021, 2, 28);
    assertEquals(d.nextDate(), new Date(2021, 3, 1));
  }

  @Test
  void endOfMonth_tc26() {
    Date d = new Date(2021, 4, 30);
    assertEquals(d.nextDate(), new Date(2021, 5, 1));
  }

  @Test
  void endOfMonth_tc27() {
    Date d = new Date(2021, 6, 30);
    assertEquals(d.nextDate(), new Date(2021, 7, 1));
  }

  @Test
  void endOfMonth_tc28() {
    Date d = new Date(2021, 9, 30);
    assertEquals(d.nextDate(), new Date(2021, 10, 1));
  }

  @Test
  void endOfMonth_tc29() {
    Date d = new Date(2021, 11, 30);
    assertEquals(d.nextDate(), new Date(2021, 12, 1));
  }

  @Test
  void endOfMonth_tc30() {
    Date d = new Date(2020, 2, 29);
    assertEquals(d.nextDate(), new Date(2020, 3, 1));
  }

  @Test
  void endOfMonth_tc31() {
    Date d = new Date(2020, 2, 28);
    assertEquals(d.nextDate(), new Date(2020, 2, 29));
  }

  @Test
  void equals_tc32() {
    Date d = new Date(2021, 5, 4);
    assertEquals(false, d.equals(1));
  }

  @Test
  void equals_tc33() {
    Date d1 = new Date(2021, 5, 4);
    Date d2 = new Date(2021, 5, 5);
    assertEquals(false, d1.equals(d2));
  }

  @Test
  void equals_tc34() {
    Date d1 = new Date(2021, 5, 4);
    Date d2 = new Date(2021, 6, 4);
    assertEquals(false, d1.equals(d2));
  }

  @Test
  void equals_tc35() {
    Date d1 = new Date(2021, 5, 4);
    Date d2 = new Date(2022, 5, 4);
    assertEquals(false, d1.equals(d2));
  }

  @Test
  void month_invalid_tc36() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(1975, 13, 10)
    );
  }

  @Test
  void month_invalid_tc37() {
    assertThrows(
      IllegalArgumentException.class,
      () -> new Date(1975, -4, 10)
    );
  }
}