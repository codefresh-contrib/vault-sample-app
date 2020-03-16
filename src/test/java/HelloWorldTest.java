import com.lambdaworks.redis.RedisConnection;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for HelloWorld app that tests if we can write KV pairs to the Redis database.
 */
public class HelloWorldTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public HelloWorldTest(String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( HelloWorldTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        HelloWorld demoApp = new HelloWorld();
        RedisConnection connection = demoApp.connectToRedis();
        connection.set("key1", "value1");
        assertTrue(connection.get("key1").equals("value1"));
        connection.close();
    }
}
