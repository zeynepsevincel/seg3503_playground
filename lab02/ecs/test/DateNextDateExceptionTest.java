import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DateNextDateExceptionTest
{

  static List<Object[]> data() {
    List<Object[]> params = new LinkedList<>();
    params.add(new Object[] { 1500, 2, 31, "day must less than 28 for month February on a non leap year." });
    return params;
}

  public void assertNextDateException(Date date) {
    assertThrows(IllegalArgumentException.class, () -> {
      date.nextDate();
    });
  }
}