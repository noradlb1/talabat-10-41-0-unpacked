package io.flutter.util;

import androidx.annotation.NonNull;
import androidx.tracing.Trace;

public final class TraceSection {
    public static void begin(@NonNull String str) {
        Trace.beginSection(cropSectionName(str));
    }

    public static void beginAsyncSection(String str, int i11) {
        Trace.beginAsyncSection(cropSectionName(str), i11);
    }

    private static String cropSectionName(@NonNull String str) {
        if (str.length() < 124) {
            return str;
        }
        return str.substring(0, 124) + "...";
    }

    public static void end() throws RuntimeException {
        Trace.endSection();
    }

    public static void endAsyncSection(String str, int i11) {
        Trace.endAsyncSection(cropSectionName(str), i11);
    }
}
