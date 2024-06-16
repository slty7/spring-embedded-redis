package tools;

import redis.embedded.core.ExecutableProvider;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import static redis.embedded.RedisServer.newRedisServer;
import static redis.embedded.core.ExecutableProvider.*;

public enum DownloadUriTest {;

    public static void main(final String... args) throws IOException {
        final Path cacheLocation = Paths.get(System.getProperty("java.io.tmpdir"), "redis-binary");
        newRedisServer()
            .executableProvider(newCachedUrlProvider(cacheLocation, REDIS_7_2_WINDOWS_X86_64))
            .build()
            .start();
    }

}
