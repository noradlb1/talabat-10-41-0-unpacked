package com.talabat.gem.ports.logging;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001H\u0014J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0014J\u0016\u0010\n\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0001J\u000e\u0010\u000b\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007¨\u0006\u000e"}, d2 = {"Lcom/talabat/gem/ports/logging/LoggerPort;", "", "", "tag", "message", "", "b", "", "throwable", "a", "logMessage", "logError", "<init>", "()V", "com_talabat_Components_gem-core_gem-core"}, k = 1, mv = {1, 6, 0})
public abstract class LoggerPort {
    public void a(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        th2.printStackTrace();
    }

    public void b(@NotNull String str, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(obj, "message");
        System.out.println(str + " | " + obj);
    }

    public final void logError(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        try {
            a(th2);
        } catch (Throwable th3) {
            th3.printStackTrace();
        }
    }

    public final void logMessage(@NotNull String str, @NotNull Object obj) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(obj, "message");
        try {
            b(str, obj);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }
}
