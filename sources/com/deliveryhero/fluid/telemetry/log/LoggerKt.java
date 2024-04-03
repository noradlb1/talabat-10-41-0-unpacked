package com.deliveryhero.fluid.telemetry.log;

import com.facebook.internal.NativeProtocol;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\bø\u0001\u0000\u001a2\u0010\u0006\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0016\b\u0002\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\r0\f\u001a\u001e\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\bø\u0001\u0000\u001a\u001e\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\bø\u0001\u0000\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0010"}, d2 = {"debug", "", "Lcom/deliveryhero/fluid/telemetry/log/Logger;", "message", "Lkotlin/Function0;", "", "error", "throwable", "", "type", "Lcom/deliveryhero/fluid/telemetry/log/ErrorTypes;", "params", "", "", "info", "warn", "core_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LoggerKt {
    public static final void debug(@NotNull Logger logger, @NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(logger, "<this>");
        Intrinsics.checkNotNullParameter(function0, "message");
        LogLevel logLevel = LogLevel.DEBUG;
        if (logLevel.compareTo(logger.getMinimumLevel()) >= 0) {
            Logger.log$default(logger, logger.getTag(), logLevel, function0.invoke(), (Throwable) null, (Pair[]) null, 24, (Object) null);
        }
    }

    public static final void error(@NotNull Logger logger, @NotNull Throwable th2, @NotNull ErrorTypes errorTypes, @NotNull Map<String, ? extends Object> map) {
        Intrinsics.checkNotNullParameter(logger, "<this>");
        Intrinsics.checkNotNullParameter(th2, "throwable");
        Intrinsics.checkNotNullParameter(errorTypes, "type");
        Intrinsics.checkNotNullParameter(map, NativeProtocol.WEB_DIALOG_PARAMS);
        LogLevel logLevel = LogLevel.ERROR;
        if (logLevel.compareTo(logger.getMinimumLevel()) >= 0) {
            String str = "errorCode: " + errorTypes.getCode() + "\nmessage: " + errorTypes.getMessage();
            String tag = logger.getTag();
            Object[] array = MapsKt___MapsKt.toList(map).toArray(new Pair[0]);
            if (array != null) {
                logger.log(tag, logLevel, str, th2, (Pair[]) array);
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
    }

    public static /* synthetic */ void error$default(Logger logger, Throwable th2, ErrorTypes errorTypes, Map map, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            map = MapsKt__MapsKt.emptyMap();
        }
        error(logger, th2, errorTypes, map);
    }

    public static final void info(@NotNull Logger logger, @NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(logger, "<this>");
        Intrinsics.checkNotNullParameter(function0, "message");
        LogLevel logLevel = LogLevel.INFO;
        if (logLevel.compareTo(logger.getMinimumLevel()) >= 0) {
            Logger.log$default(logger, logger.getTag(), logLevel, function0.invoke(), (Throwable) null, (Pair[]) null, 24, (Object) null);
        }
    }

    public static final void warn(@NotNull Logger logger, @NotNull Function0<String> function0) {
        Intrinsics.checkNotNullParameter(logger, "<this>");
        Intrinsics.checkNotNullParameter(function0, "message");
        LogLevel logLevel = LogLevel.WARNING;
        if (logLevel.compareTo(logger.getMinimumLevel()) >= 0) {
            Logger.log$default(logger, logger.getTag(), logLevel, function0.invoke(), (Throwable) null, (Pair[]) null, 24, (Object) null);
        }
    }
}
