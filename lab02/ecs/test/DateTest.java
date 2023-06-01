import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DateTest {
  private DateNextDateOkTest a = new DateNextDateOkTest();
  private DateNextDateExceptionTest b = new DateNextDateExceptionTest();

  @Test
  void nextDate_sample() {
    Date d = new Date(2020,5,3);
    assertEquals(new Date(2020,5,4), d.nextDate());
  }

  @Test
  void testDate1() {
    Date d = new Date(1700, 6, 20);
    a.assertNextDate(d, new Date(1700, 6, 21));
  }
  @Test
  void testDate2() {
    Date d = new Date(2005, 4, 15);
    a.assertNextDate(d, new Date(2005, 4, 16));
  }
  @Test
  void testDate3() {
    Date d = new Date(1901, 7, 20);
    a.assertNextDate(d, new Date(1901, 7, 21));
  }
  @Test
  void testDate4() {
    Date d = new Date(3456, 3, 27);
    a.assertNextDate(d, new Date(3456, 3, 28));
  }
  @Test
  void testDate5() {
    Date d = new Date(1500, 2, 17);
    a.assertNextDate(d, new Date(1500, 2, 18));
  }
  @Test
  void testDate6() {
    Date d = new Date(1700, 6, 29);
    a.assertNextDate(d, new Date(1700, 6, 30));
  }
  @Test
  void testDate7() {
    Date d = new Date(1800, 11, 29);
    a.assertNextDate(d, new Date(1800, 11, 30));
  }
  @Test
  void testDate8() {
    Date d = new Date(3453, 1, 29);
    a.assertNextDate(d, new Date(3453, 1, 30));
  }
  @Test
  void testDate9() {
    Date d = new Date(444, 2, 29);
    a.assertNextDate(d, new Date(444, 3, 1));
  }
  @Test
  void testDate10() {
    Date d = new Date(2005, 4, 30);
    a.assertNextDate(d, new Date(2005, 5, 1));
  }
  @Test
  void testDate11() {
    Date d = new Date(3453, 1, 30);
    a.assertNextDate(d, new Date(3453, 1, 31));
  }
  @Test
  void testDate12() {
    Date d = new Date(3456, 3, 30);
    a.assertNextDate(d, new Date(3456, 3, 31));
  }
  @Test
  void testDate13() {
    Date d = new Date(1901, 7, 31);
    a.assertNextDate(d, new Date(1901, 8, 1));
  }
  @Test
  void testDate14() {
    Date d = new Date(3453, 1, 31);
    a.assertNextDate(d, new Date(3453, 2, 1));
  }
  @Test
  void testDate15() {
    Date d = new Date(3456, 12, 31);
    a.assertNextDate(d, new Date(3457, 1, 1));
  }
  @Test
  private void testDate16() {
    b.assertNextDateException(new Date(1500, 02, 31));
  }
  @Test
  private void testDate17() {
    b.assertNextDateException(new Date(1500, 02, 29));
  }
  @Test
  private void testDate18() {
    b.assertNextDateException(new Date(-1, 10, 20));
  }
  @Test
  private void testDate19() {
    b.assertNextDateException(new Date(1458, 15, 12));
  }
  @Test
  private void testDate20() {
    b.assertNextDateException(new Date(1975, 6, -50));
  }
}