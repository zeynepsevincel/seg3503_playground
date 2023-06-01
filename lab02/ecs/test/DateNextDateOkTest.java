import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DateNextDateOkTest
{
  public void assertNextDate(Date date, Date expectedNewDate) {
    assertEquals(date.nextDate(), expectedNewDate);
  }
}