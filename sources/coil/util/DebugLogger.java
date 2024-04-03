package coil.util;

import android.util.Log;
import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u0003H\u0002J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\b\u0010\u000f\u001a\u0004\u0018\u00010\r2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004¨\u0006\u0012"}, d2 = {"Lcoil/util/DebugLogger;", "Lcoil/util/Logger;", "level", "", "(I)V", "value", "getLevel", "()I", "setLevel", "assertValidLevel", "", "log", "tag", "", "priority", "message", "throwable", "", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class DebugLogger implements Logger {
    private int level;

    @JvmOverloads
    public DebugLogger() {
        this(0, 1, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public DebugLogger(int i11) {
        this.level = i11;
        assertValidLevel(i11);
    }

    private final void assertValidLevel(int i11) {
        boolean z11 = false;
        if (2 <= i11 && i11 <= 7) {
            z11 = true;
        }
        if (!z11) {
            throw new IllegalArgumentException(Intrinsics.stringPlus("Invalid log level: ", Integer.valueOf(i11)).toString());
        }
    }

    public int getLevel() {
        return this.level;
    }

    public void log(@NotNull String str, int i11, @Nullable String str2, @Nullable Throwable th2) {
        Intrinsics.checkNotNullParameter(str, "tag");
        if (str2 != null) {
            Log.println(i11, str, str2);
        }
        if (th2 != null) {
            StringWriter stringWriter = new StringWriter();
            th2.printStackTrace(new PrintWriter(stringWriter));
            Log.println(i11, str, stringWriter.toString());
        }
    }

    public void setLevel(int i11) {
        assertValidLevel(i11);
        this.level = i11;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DebugLogger(int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? 3 : i11);
    }
}
