package com.instabug.apm.handler.session;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.apm.configuration.c;
import com.instabug.apm.di.a;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import java.lang.Thread;

public class b implements Thread.UncaughtExceptionHandler {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f45386a = Thread.getDefaultUncaughtExceptionHandler();

    /* renamed from: b  reason: collision with root package name */
    private c f45387b = a.c();

    /* renamed from: c  reason: collision with root package name */
    private c f45388c = a.W();

    public void uncaughtException(@NonNull Thread thread, @NonNull Throwable th2) {
        if (this.f45387b.a0()) {
            SettingsManager.getInstance().setCrashedSession(true);
            InstabugSDKLogger.d("IBG-APM", "ending APM session");
            this.f45388c.b(1);
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f45386a;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th2);
        }
    }
}
