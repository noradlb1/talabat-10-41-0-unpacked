package com.google.android.gms.internal.gtm;

import com.google.android.gms.analytics.Logger;

final class zzgv implements Logger {
    public final void error(String str) {
        zzev.zzav(str);
    }

    public final int getLogLevel() {
        zzev.getLogLevel();
        return 3;
    }

    public final void info(String str) {
        zzev.zzaw(str);
    }

    public final void setLogLevel(int i11) {
        zzev.zzac("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
    }

    public final void verbose(String str) {
        zzev.zzab(str);
    }

    public final void warn(String str) {
        zzev.zzac(str);
    }

    public final void error(Exception exc) {
        zzev.zza("", exc);
    }
}
