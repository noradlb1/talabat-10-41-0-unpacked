package com.talabat.talabatcore.logger;

import com.talabat.talabatcore.logger.impl.TimberLogger;
import com.talabat.talabatcore.logger.remote.RemoteLogger;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u001e\u0010\u000b\u001a\u00020\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0007J\u0010\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/talabatcore/logger/LogManager;", "", "()V", "logger", "Lcom/talabat/talabatcore/logger/Logger;", "remoteLogger", "Lcom/talabat/talabatcore/logger/remote/RemoteLogger;", "debug", "", "message", "", "error", "throwable", "", "info", "logException", "setLogger", "setRemoteLogger", "com_talabat_NewArchi_TalabatCore_TalabatCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LogManager {
    @NotNull
    public static final LogManager INSTANCE = new LogManager();
    @NotNull
    private static Logger logger = TimberLogger.INSTANCE;
    @Nullable
    private static RemoteLogger remoteLogger;

    private LogManager() {
    }

    @JvmStatic
    public static final void debug(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        logger.debug(str);
    }

    @JvmStatic
    public static final void error(@Nullable Throwable th2, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        logger.error(th2, str);
    }

    public static /* synthetic */ void error$default(Throwable th2, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            th2 = null;
        }
        if ((i11 & 2) != 0) {
            str = "";
        }
        error(th2, str);
    }

    @JvmStatic
    public static final void info(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        logger.info(str);
    }

    @JvmStatic
    public static final void logException(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "throwable");
        error$default(th2, (String) null, 2, (Object) null);
        RemoteLogger remoteLogger2 = remoteLogger;
        if (remoteLogger2 == null) {
            info("Please set the remote logger before you log!");
        } else if (remoteLogger2 != null) {
            remoteLogger2.logException(th2);
        }
    }

    @JvmStatic
    public static final void setLogger(@NotNull Logger logger2) {
        Intrinsics.checkNotNullParameter(logger2, "logger");
        logger = logger2;
    }

    @JvmStatic
    public static final void setRemoteLogger(@NotNull RemoteLogger remoteLogger2) {
        Intrinsics.checkNotNullParameter(remoteLogger2, "remoteLogger");
        remoteLogger = remoteLogger2;
    }
}
