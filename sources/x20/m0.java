package x20;

import java.util.Collections;
import java.util.Map;
import org.apiguardian.api.API;
import org.junit.jupiter.api.TestReporter;

public final /* synthetic */ class m0 {
    @API(since = "5.3", status = API.Status.STABLE)
    public static void a(TestReporter testReporter, String str) {
        testReporter.publishEntry("value", str);
    }

    public static void b(TestReporter testReporter, String str, String str2) {
        testReporter.publishEntry((Map<String, String>) Collections.singletonMap(str, str2));
    }
}
