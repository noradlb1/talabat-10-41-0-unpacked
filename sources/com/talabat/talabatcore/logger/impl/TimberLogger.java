package com.talabat.talabatcore.logger.impl;

import com.talabat.talabatcore.logger.Logger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import timber.log.Timber;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u001a\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatcore/logger/impl/TimberLogger;", "Lcom/talabat/talabatcore/logger/Logger;", "()V", "debug", "", "message", "", "error", "throwable", "", "info", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TimberLogger implements Logger {
    @NotNull
    public static final TimberLogger INSTANCE = new TimberLogger();

    private TimberLogger() {
    }

    public void debug(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Timber.d(str, new Object[0]);
    }

    public void error(@Nullable Throwable th2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Timber.e(th2, str, new Object[0]);
    }

    public void info(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        Timber.i(str, new Object[0]);
    }
}
