package com.deliveryhero.fluid.telemetry.log;

import android.util.Log;
import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JM\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u001c\u0010\r\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f0\u000eH\u0016¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/deliveryhero/fluid/telemetry/log/LogcatLogger;", "Lcom/deliveryhero/fluid/telemetry/log/Logger;", "tag", "", "minimumLevel", "Lcom/deliveryhero/fluid/telemetry/log/LogLevel;", "(Ljava/lang/String;Lcom/deliveryhero/fluid/telemetry/log/LogLevel;)V", "log", "", "level", "message", "throwable", "", "params", "", "Lkotlin/Pair;", "", "(Ljava/lang/String;Lcom/deliveryhero/fluid/telemetry/log/LogLevel;Ljava/lang/String;Ljava/lang/Throwable;[Lkotlin/Pair;)V", "core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LogcatLogger extends Logger {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LogLevel.values().length];
            iArr[LogLevel.DEBUG.ordinal()] = 1;
            iArr[LogLevel.INFO.ordinal()] = 2;
            iArr[LogLevel.WARNING.ordinal()] = 3;
            iArr[LogLevel.ERROR.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LogcatLogger(@NotNull String str, @NotNull LogLevel logLevel) {
        super(str, logLevel);
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(logLevel, "minimumLevel");
    }

    public void log(@NotNull String str, @NotNull LogLevel logLevel, @NotNull String str2, @Nullable Throwable th2, @NotNull Pair<String, ? extends Object>[] pairArr) {
        boolean z11;
        String str3;
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(logLevel, "level");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(pairArr, NativeProtocol.WEB_DIALOG_PARAMS);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str2);
        sb2.append(10);
        if (pairArr.length == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            str3 = "";
        } else {
            str3 = ArraysKt___ArraysKt.joinToString$default((Object[]) pairArr, (CharSequence) ",\n", (CharSequence) "Params {\n", (CharSequence) "\n}", 0, (CharSequence) null, (Function1) Logger$asString$1.INSTANCE, 24, (Object) null);
        }
        sb2.append(str3);
        String sb3 = sb2.toString();
        int i11 = WhenMappings.$EnumSwitchMapping$0[logLevel.ordinal()];
        if (i11 == 2) {
            Log.i(str, sb3, th2);
        } else if (i11 == 3) {
            Log.w(str, sb3, th2);
        } else if (i11 == 4) {
            Log.e(str, sb3, th2);
        }
    }
}
