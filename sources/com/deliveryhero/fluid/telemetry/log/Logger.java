package com.deliveryhero.fluid.telemetry.log;

import com.facebook.internal.NativeProtocol;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\f\b\u0016\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0012\u001a\u00020\u0004¢\u0006\u0004\b\u0016\u0010\u0017JS\u0010\r\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\u001e\b\u0002\u0010\u000b\u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010\n0\tH\u0016¢\u0006\u0004\b\r\u0010\u000eR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0012\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/deliveryhero/fluid/telemetry/log/Logger;", "", "", "tag", "Lcom/deliveryhero/fluid/telemetry/log/LogLevel;", "level", "message", "", "throwable", "", "Lkotlin/Pair;", "params", "", "log", "(Ljava/lang/String;Lcom/deliveryhero/fluid/telemetry/log/LogLevel;Ljava/lang/String;Ljava/lang/Throwable;[Lkotlin/Pair;)V", "Ljava/lang/String;", "getTag", "()Ljava/lang/String;", "minimumLevel", "Lcom/deliveryhero/fluid/telemetry/log/LogLevel;", "getMinimumLevel", "()Lcom/deliveryhero/fluid/telemetry/log/LogLevel;", "<init>", "(Ljava/lang/String;Lcom/deliveryhero/fluid/telemetry/log/LogLevel;)V", "core_release"}, k = 1, mv = {1, 6, 0})
public class Logger {
    @NotNull
    private final LogLevel minimumLevel;
    @NotNull
    private final String tag;

    public Logger(@NotNull String str, @NotNull LogLevel logLevel) {
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(logLevel, "minimumLevel");
        this.tag = str;
        this.minimumLevel = logLevel;
    }

    public static /* synthetic */ void log$default(Logger logger, String str, LogLevel logLevel, String str2, Throwable th2, Pair[] pairArr, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 8) != 0) {
                th2 = null;
            }
            Throwable th3 = th2;
            if ((i11 & 16) != 0) {
                pairArr = new Pair[0];
            }
            logger.log(str, logLevel, str2, th3, pairArr);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: log");
    }

    @NotNull
    public final LogLevel getMinimumLevel() {
        return this.minimumLevel;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    public void log(@NotNull String str, @NotNull LogLevel logLevel, @NotNull String str2, @Nullable Throwable th2, @NotNull Pair<String, ? extends Object>[] pairArr) {
        boolean z11;
        String str3;
        Intrinsics.checkNotNullParameter(str, "tag");
        Intrinsics.checkNotNullParameter(logLevel, "level");
        Intrinsics.checkNotNullParameter(str2, "message");
        Intrinsics.checkNotNullParameter(pairArr, NativeProtocol.WEB_DIALOG_PARAMS);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append('/');
        sb2.append(logLevel);
        sb2.append(": ");
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
        sb2.append(10);
        sb2.append(th2);
        System.out.println(sb2.toString());
    }
}
