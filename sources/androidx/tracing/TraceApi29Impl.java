package androidx.tracing;

import android.os.Trace;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(29)
final class TraceApi29Impl {
    private TraceApi29Impl() {
    }

    public static void beginAsyncSection(@NonNull String str, int i11) {
        Trace.beginAsyncSection(str, i11);
    }

    public static void endAsyncSection(@NonNull String str, int i11) {
        Trace.endAsyncSection(str, i11);
    }

    @DoNotInline
    public static boolean isEnabled() {
        return Trace.isEnabled();
    }

    public static void setCounter(@NonNull String str, int i11) {
        Trace.setCounter(str, (long) i11);
    }
}
