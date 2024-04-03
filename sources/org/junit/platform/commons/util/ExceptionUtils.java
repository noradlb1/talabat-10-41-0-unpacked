package org.junit.platform.commons.util;

import java.io.PrintWriter;
import java.io.StringWriter;
import org.apiguardian.api.API;

@API(since = "1.0", status = API.Status.INTERNAL)
public final class ExceptionUtils {
    private ExceptionUtils() {
    }

    public static String readStackTrace(Throwable th2) {
        Preconditions.notNull(th2, "Throwable must not be null");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        try {
            th2.printStackTrace(printWriter);
            printWriter.close();
            return stringWriter.toString();
        } catch (Throwable th3) {
            th.addSuppressed(th3);
        }
        throw th;
    }

    private static <T extends Throwable> void throwAs(Throwable th2) throws Throwable {
        throw th2;
    }

    public static RuntimeException throwAsUncheckedException(Throwable th2) {
        Preconditions.notNull(th2, "Throwable must not be null");
        throwAs(th2);
        return null;
    }
}
