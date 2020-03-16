import com.lambdaworks.redis.RedisClient;
import com.lambdaworks.redis.RedisConnection;
import com.lambdaworks.redis.RedisURI;

/**
 * Simple Hello World application to test using Vault secrets from within a Codefresh pipeline
 *
 */
public class HelloWorld
{
    public static RedisConnection connectToRedis() {

        String password = System.getenv("password");
        String host = System.getProperty("server.host");

        RedisClient redisClient = new RedisClient(
                RedisURI.create("redis://" + password + "@" + host + ":6379"));
        RedisConnection<String, String> connection = redisClient.connect();

        System.out.println("Connected to Redis!");

        return connection;
    }
}
