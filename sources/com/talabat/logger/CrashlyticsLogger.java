package com.talabat.logger;

import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.talabat.talabatcore.logger.remote.RemoteLogger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/logger/CrashlyticsLogger;", "Lcom/talabat/talabatcore/logger/remote/RemoteLogger;", "()V", "logException", "", "throwable", "", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CrashlyticsLogger implements RemoteLogger {
    public void logException(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        FirebaseCrashlytics.getInstance().recordException(th2);
    }
}
