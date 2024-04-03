package com.talabat.fluid;

import com.deliveryhero.fluid.telemetry.log.LogLevel;
import com.deliveryhero.fluid.telemetry.log.Logger;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B-\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0001\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJM\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u001c\u0010\u0010\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00130\u00120\u0011H\u0016¢\u0006\u0002\u0010\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/fluid/LoggerDecorator;", "Lcom/deliveryhero/fluid/telemetry/log/Logger;", "tag", "", "minimumLevel", "Lcom/deliveryhero/fluid/telemetry/log/LogLevel;", "logger", "enabled", "", "(Ljava/lang/String;Lcom/deliveryhero/fluid/telemetry/log/LogLevel;Lcom/deliveryhero/fluid/telemetry/log/Logger;Z)V", "log", "", "level", "message", "throwable", "", "params", "", "Lkotlin/Pair;", "", "(Ljava/lang/String;Lcom/deliveryhero/fluid/telemetry/log/LogLevel;Ljava/lang/String;Ljava/lang/Throwable;[Lkotlin/Pair;)V", "com_talabat_ThirdPartyLibs_Fluid_Fluid"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoggerDecorator extends Logger {
    private final boolean enabled;
    @NotNull
    private final Logger logger;

    public LoggerDecorator() {
        this((String) null, (LogLevel) null, (Logger) null, false, 15, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ LoggerDecorator(java.lang.String r1, com.deliveryhero.fluid.telemetry.log.LogLevel r2, com.deliveryhero.fluid.telemetry.log.Logger r3, boolean r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r0 = this;
            r6 = r5 & 1
            if (r6 == 0) goto L_0x0006
            java.lang.String r1 = "TalabatFluid"
        L_0x0006:
            r6 = r5 & 2
            if (r6 == 0) goto L_0x000c
            com.deliveryhero.fluid.telemetry.log.LogLevel r2 = com.deliveryhero.fluid.telemetry.log.LogLevel.DEBUG
        L_0x000c:
            r6 = r5 & 4
            if (r6 == 0) goto L_0x0015
            com.deliveryhero.fluid.telemetry.log.LogcatLogger r3 = new com.deliveryhero.fluid.telemetry.log.LogcatLogger
            r3.<init>(r1, r2)
        L_0x0015:
            r5 = r5 & 8
            if (r5 == 0) goto L_0x001a
            r4 = 1
        L_0x001a:
            r0.<init>(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.fluid.LoggerDecorator.<init>(java.lang.String, com.deliveryhero.fluid.telemetry.log.LogLevel, com.deliveryhero.fluid.telemetry.log.Logger, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public void log(@NotNull String str, @NotNull LogLevel logLevel, @NotNull String str2, @Nullable Throwable th2, @NotNull Pair<String, ? extends Object>[] pairArr) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(logLevel, "level");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(pairArr, NativeProtocol.WEB_DIALOG_PARAMS);
        if (this.enabled) {
            this.logger.log(str, logLevel, str2, th2, pairArr);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoggerDecorator(@NotNull String str, @NotNull LogLevel logLevel, @NotNull Logger logger2, boolean z11) {
        super(str, logLevel);
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(logLevel, "minimumLevel");
        Intrinsics.checkNotNullParameter(logger2, "logger");
        this.logger = logger2;
        this.enabled = z11;
    }
}
