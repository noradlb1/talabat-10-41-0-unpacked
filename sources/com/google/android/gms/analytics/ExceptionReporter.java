package com.google.android.gms.analytics;

import android.content.Context;
import com.google.android.gms.analytics.HitBuilders;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.gtm.zzch;
import java.lang.Thread;
import java.util.ArrayList;

@VisibleForTesting
public class ExceptionReporter implements Thread.UncaughtExceptionHandler {
    private final Thread.UncaughtExceptionHandler zzrk;
    private final Tracker zzrl;
    private final Context zzrm;
    private ExceptionParser zzrn;
    private GoogleAnalytics zzro;

    public ExceptionReporter(Tracker tracker, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, Context context) {
        String str;
        String str2;
        if (tracker == null) {
            throw new NullPointerException("tracker cannot be null");
        } else if (context != null) {
            this.zzrk = uncaughtExceptionHandler;
            this.zzrl = tracker;
            this.zzrn = new StandardExceptionParser(context, new ArrayList());
            this.zzrm = context.getApplicationContext();
            if (uncaughtExceptionHandler == null) {
                str = "null";
            } else {
                str = uncaughtExceptionHandler.getClass().getName();
            }
            if (str.length() != 0) {
                str2 = "ExceptionReporter created, original handler is ".concat(str);
            } else {
                str2 = new String("ExceptionReporter created, original handler is ");
            }
            zzch.zzab(str2);
        } else {
            throw new NullPointerException("context cannot be null");
        }
    }

    public ExceptionParser getExceptionParser() {
        return this.zzrn;
    }

    public void setExceptionParser(ExceptionParser exceptionParser) {
        this.zzrn = exceptionParser;
    }

    public void uncaughtException(Thread thread, Throwable th2) {
        String str;
        String str2;
        String str3;
        if (this.zzrn != null) {
            if (thread != null) {
                str3 = thread.getName();
            } else {
                str3 = null;
            }
            str = this.zzrn.getDescription(str3, th2);
        } else {
            str = "UncaughtException";
        }
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "Reporting uncaught exception: ".concat(valueOf);
        } else {
            str2 = new String("Reporting uncaught exception: ");
        }
        zzch.zzab(str2);
        this.zzrl.send(new HitBuilders.ExceptionBuilder().setDescription(str).setFatal(true).build());
        if (this.zzro == null) {
            this.zzro = GoogleAnalytics.getInstance(this.zzrm);
        }
        GoogleAnalytics googleAnalytics = this.zzro;
        googleAnalytics.dispatchLocalHits();
        googleAnalytics.zzab().zzcs().zzcj();
        if (this.zzrk != null) {
            zzch.zzab("Passing exception to the original handler");
            this.zzrk.uncaughtException(thread, th2);
        }
    }

    public final Thread.UncaughtExceptionHandler zzaf() {
        return this.zzrk;
    }
}
