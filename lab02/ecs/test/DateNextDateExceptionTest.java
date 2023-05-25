import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DateNextDateExceptionTest
{
  public void assertNextDateException(Date date) {
    assertThrows(IllegalArgumentException.class, () -> {
      date.nextDate();
    });
  }
}