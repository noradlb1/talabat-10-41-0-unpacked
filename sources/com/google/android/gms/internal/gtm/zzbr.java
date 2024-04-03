package com.google.android.gms.internal.gtm;

import android.util.Log;
import com.google.android.gms.analytics.Logger;

final class zzbr implements Logger {
    private boolean zzrv;
    private int zzyr = 2;

    public final void error(Exception exc) {
    }

    public final void error(String str) {
    }

    public final int getLogLevel() {
        return this.zzyr;
    }

    public final void info(String str) {
    }

    public final void setLogLevel(int i11) {
        this.zzyr = i11;
        if (!this.zzrv) {
            String str = zzby.zzzb.get();
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 91);
            sb2.append("Logger is deprecated. To enable debug logging, please run:\nadb shell setprop log.tag.");
            sb2.append(str);
            sb2.append(" DEBUG");
            Log.i(zzby.zzzb.get(), sb2.toString());
            this.zzrv = true;
        }
    }

    public final void verbose(String str) {
    }

    public final void warn(String str) {
    }
}
