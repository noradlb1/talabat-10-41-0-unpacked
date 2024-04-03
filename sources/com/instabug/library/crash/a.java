package com.instabug.library.crash;

import androidx.annotation.Nullable;
import com.instabug.library.Instabug;
import com.instabug.library.internal.video.InternalAutoScreenRecorderHelper;
import com.instabug.library.model.v3Session.r;
import com.instabug.library.r0;
import com.instabug.library.session.h;
import com.instabug.library.sessionV3.di.c;
import com.instabug.library.sessionV3.manager.i;
import com.instabug.library.sessionV3.sync.SessionBatchingFilterKt;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;

public class a implements Thread.UncaughtExceptionHandler {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f34215a = Thread.getDefaultUncaughtExceptionHandler();

    private String a(Throwable th2) {
        StringWriter stringWriter = new StringWriter();
        th2.printStackTrace(new PrintWriter(stringWriter, true));
        return stringWriter.getBuffer().toString();
    }

    public void uncaughtException(Thread thread, Throwable th2) {
        InstabugSDKLogger.e("IBG-Core", "Instabug Caught an Unhandled Exception: " + th2.getClass().getCanonicalName(), th2);
        try {
            if (InternalAutoScreenRecorderHelper.getInstance().isEnabled()) {
                InternalAutoScreenRecorderHelper.getInstance().setCrashOccurred(true);
            }
            SettingsManager.getInstance().setCrashedSession(true);
            if (Instabug.getApplicationContext() != null) {
                new h().a();
                c.b().a(SessionBatchingFilterKt.getNoneFilter());
            }
            if (!a(a(th2))) {
                r0.e().b();
                i.f51800a.a(new r(), true);
            }
        } catch (Exception | OutOfMemoryError e11) {
            InstabugSDKLogger.e("IBG-Core", "Uncaught exception failed to execute due to an exception", e11);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f34215a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th2);
        }
    }

    private boolean a(String str) {
        return str.contains("com.facebook.react.modules");
    }
}
