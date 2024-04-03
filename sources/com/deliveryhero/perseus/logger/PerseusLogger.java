package com.deliveryhero.perseus.logger;

import android.util.Log;
import com.deliveryhero.perseus.PerseusApp;
import com.deliveryhero.perseus.di.CoreModule;
import com.deliveryhero.perseus.di.PerseusAppComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tJ\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tJ\b\u0010\f\u001a\u00020\rH\u0002J\u001a\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0003\u001a\u00020\u0004XD¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/deliveryhero/perseus/logger/PerseusLogger;", "", "()V", "logTag", "", "e", "", "message", "throwable", "", "enrichMessage", "i", "isDebuggable", "", "w", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PerseusLogger {
    @NotNull
    private final String logTag = "Perseus";

    public static /* synthetic */ void e$default(PerseusLogger perseusLogger, String str, Throwable th2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            th2 = null;
        }
        perseusLogger.e(str, th2);
    }

    private final String enrichMessage(String str) {
        if (!PerseusAppComponent.INSTANCE.isInitialized()) {
            return str;
        }
        CoreModule coreModule = CoreModule.INSTANCE;
        String clientId = coreModule.getClientIdProvider().getClientId();
        String userSessionId = coreModule.getAppSessionManager().getUserSessionId();
        return str + ", clientId: " + clientId + ", sessionId: " + userSessionId;
    }

    public static /* synthetic */ void i$default(PerseusLogger perseusLogger, String str, Throwable th2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            th2 = null;
        }
        perseusLogger.i(str, th2);
    }

    private final boolean isDebuggable() {
        if (PerseusAppComponent.INSTANCE.isInitialized()) {
            return CoreModule.INSTANCE.getPerseusConfigProvider().provideConfig().getDebuggable();
        }
        return true;
    }

    public static /* synthetic */ void w$default(PerseusLogger perseusLogger, String str, Throwable th2, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            th2 = null;
        }
        perseusLogger.w(str, th2);
    }

    public final void e(@NotNull String str, @Nullable Throwable th2) {
        Intrinsics.checkNotNullParameter(str, "message");
        String enrichMessage = enrichMessage(str);
        Function3<String, Throwable, Integer, Unit> logPrintListener$perseus_release = PerseusApp.INSTANCE.getLogPrintListener$perseus_release();
        if (logPrintListener$perseus_release != null) {
            logPrintListener$perseus_release.invoke(enrichMessage, th2, 6);
        }
        if (isDebuggable()) {
            Log.e(this.logTag, enrichMessage, th2);
        }
    }

    public final void i(@NotNull String str, @Nullable Throwable th2) {
        Intrinsics.checkNotNullParameter(str, "message");
        String enrichMessage = enrichMessage(str);
        Function3<String, Throwable, Integer, Unit> logPrintListener$perseus_release = PerseusApp.INSTANCE.getLogPrintListener$perseus_release();
        if (logPrintListener$perseus_release != null) {
            logPrintListener$perseus_release.invoke(enrichMessage, th2, 4);
        }
        if (isDebuggable()) {
            Log.i(this.logTag, enrichMessage, th2);
        }
    }

    public final void w(@NotNull String str, @Nullable Throwable th2) {
        Intrinsics.checkNotNullParameter(str, "message");
        String enrichMessage = enrichMessage(str);
        Function3<String, Throwable, Integer, Unit> logPrintListener$perseus_release = PerseusApp.INSTANCE.getLogPrintListener$perseus_release();
        if (logPrintListener$perseus_release != null) {
            logPrintListener$perseus_release.invoke(enrichMessage, th2, 5);
        }
        if (isDebuggable()) {
            Log.w(this.logTag, enrichMessage, th2);
        }
    }
}
