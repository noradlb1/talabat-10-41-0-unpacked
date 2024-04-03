package com.deliveryhero.fluid.telemetry.profile;

import com.deliveryhero.fluid.telemetry.log.LogLevel;
import com.deliveryhero.fluid.telemetry.log.Logger;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J)\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00060\nH\u0016¢\u0006\u0002\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/deliveryhero/fluid/telemetry/profile/SimpleClockProfiler;", "Lcom/deliveryhero/fluid/telemetry/profile/Profiler;", "logger", "Lcom/deliveryhero/fluid/telemetry/log/Logger;", "(Lcom/deliveryhero/fluid/telemetry/log/Logger;)V", "trace", "ResultT", "tag", "", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class SimpleClockProfiler implements Profiler {
    @NotNull
    private final Logger logger;

    public SimpleClockProfiler(@NotNull Logger logger2) {
        Intrinsics.checkNotNullParameter(logger2, "logger");
        this.logger = logger2;
    }

    public <ResultT> ResultT trace(@NotNull String str, @NotNull Function0<? extends ResultT> function0) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(function0, "block");
        Clock clock = Clock.INSTANCE;
        long uptimeMillis = clock.uptimeMillis();
        ResultT invoke = function0.invoke();
        long uptimeMillis2 = clock.uptimeMillis() - uptimeMillis;
        Logger logger2 = this.logger;
        LogLevel logLevel = LogLevel.INFO;
        if (logLevel.compareTo(logger2.getMinimumLevel()) >= 0) {
            String tag = logger2.getTag();
            Logger.log$default(logger2, tag, logLevel, str + " took " + uptimeMillis2 + "ms", (Throwable) null, (Pair[]) null, 24, (Object) null);
        }
        return invoke;
    }
}
