import org.easymock.IMockBuilder;
import org.junit.jupiter.api.Test;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class TwitterTest {

    @Test
    void actual_call() {

        Twitter twitter = new Twitter();

        boolean actual;

        actual = twitter.isMentionned("me");
        assertEquals(true, actual);
    }

    @Test
    void mock_full_object() {

        Twitter twitter = createMock("twitter", Twitter.class);

        expect(twitter.loadTweet()).andReturn("hello @me");
        expect(twitter.loadTweet()).andReturn("hello @you");
        replay(twitter);

        String actual;

        actual = twitter.loadTweet();
        assertEquals("hello @me", actual);

        actual = twitter.loadTweet();
        assertEquals("hello @you", actual);
    }

    @Test
    void mock_partial_object() {

        Twitter twitter = partialMockBuilder(Twitter.class)
          .addMockedMethod("loadTweet")
          .createMock();

        expect(twitter.loadTweet()).andReturn("hello @me").times(2);
        replay(twitter);

        boolean actual;

        actual = twitter.isMentionned("me");
        assertEquals(true, actual);

        actual = twitter.isMentionned("you");
        assertEquals(false, actual);
    }

    @Test
    void isMentionned_lookForAtSymbol() {

        IMockBuilder < Object > objectIMockBuilder = partialMockBuilder(Twitter.class);
        objectIMockBuilder.addMockedMethod("loadTweet");
        Twitter twitter = objectIMockBuilder
        .createMock();

      expect(twitter.loadTweet()).andReturn("hello @me");
      replay(twitter);

      boolean hasAtSymbol = twitter.loadTweet().contains("@");
      assertEquals(hasAtSymbol, true);

    }

    @Test
    void isMentionned_dontReturnSubstringMatches() {

      Twitter twitter = partialMockBuilder(Twitter.class)
        .addMockedMethod("loadTweet")
        .createMock();

      expect(twitter.loadTweet()).andReturn("hello @meat").times(2);
      replay(twitter);

      boolean actual;
      actual = twitter.isMentionned("me");
      assertEquals(actual, false);

      actual = twitter.isMentionned("meat");
      assertEquals(actual, true);
    }

    @Test
    void isMentionned_superStringNotFound() {
  
      Twitter twitter = partialMockBuilder(Twitter.class)
        .addMockedMethod("loadTweet")
        .createMock();

      expect(twitter.loadTweet()).andReturn("hello @me").times(2);
      replay(twitter);

      boolean actual;
      actual = twitter.isMentionned("me");
      assertEquals(actual, true);

      actual = twitter.isMentionned("meat");
      assertEquals(actual, false);
    }

    @Test
    void isMentionned_handleNull() {
  
      Twitter twitter = partialMockBuilder(Twitter.class)
        .addMockedMethod("loadTweet")
        .createMock();

      expect(twitter.loadTweet()).andReturn("").times(2);
      replay(twitter);

      boolean actual;
      actual = twitter.isMentionned("me");
      assertEquals(actual, false);

      actual = twitter.isMentionned("meat");
      assertEquals(actual, false);
    }
}