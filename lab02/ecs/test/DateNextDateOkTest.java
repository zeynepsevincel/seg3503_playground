import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DateNextDateOkTest
{

  static List<Object[]> data() {
    List<Object[]> params = new LinkedList<>();
    params.add(new Object[] { 1700, 6, 20, "1700/June/21" });
    params.add(new Object[] { 2005, 4, 15, "2005/April/16" });
    params.add(new Object[] { 1901, 7, 20, "1901/July/21" });
    params.add(new Object[] { 3456, 3, 27, "3456/March/28" });
    params.add(new Object[] { 1500, 2, 17, "1500/February/18" });
    params.add(new Object[] { 1700, 6, 29, "1700/June/30" });
    params.add(new Object[] { 1800, 11, 29, "1800/November/30" });
    params.add(new Object[] { 3453, 1, 29, "3453/January/30" });
    params.add(new Object[] { 444, 2, 29, "444/March/1" });
    params.add(new Object[] { 2005, 4, 30, "2005/May/1" });
    params.add(new Object[] { 3453, 1, 30, "3453/January/31" });
    params.add(new Object[] { 3456, 3, 30, "3456/March/31" });
    params.add(new Object[] { 1901, 7, 31, "1901/August/1" });
    params.add(new Object[] { 3453, 1, 31, "3453/February/1" });
    params.add(new Object[] { 3456, 12, 31, "3457/January/1" });
    return params;
}

  public void assertNextDate(Date date, Date expectedNewDate) {
    assertEquals(date.nextDate(), expectedNewDate);
  }
}