package androidx.test.internal.platform.util;

import androidx.test.internal.util.Checks;
import androidx.test.platform.app.InstrumentationRegistry;
import java.util.concurrent.TimeUnit;

public class InstrumentationParameterUtil {
    public static long getTimeoutMillis(String str, long j11) {
        boolean z11;
        if (j11 != 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Checks.checkArgument(z11, "default timeout value cannot be zero");
        long parseLong = Long.parseLong(InstrumentationRegistry.getArguments().getString(str, "0"));
        if (parseLong != 0) {
            j11 = parseLong;
        }
        if (j11 < 0) {
            return TimeUnit.DAYS.toMillis(1);
        }
        return j11;
    }
}
