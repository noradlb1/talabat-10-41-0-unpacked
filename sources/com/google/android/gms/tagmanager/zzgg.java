package com.google.android.gms.tagmanager;

import com.google.android.gms.analytics.Logger;

final class zzgg implements Logger {
    public final void error(String str) {
        zzdi.zzav(str);
    }

    public final int getLogLevel() {
        int i11 = zzdi.zzyr;
        if (i11 == 2) {
            return 0;
        }
        if (i11 == 3 || i11 == 4) {
            return 1;
        }
        return i11 != 5 ? 3 : 2;
    }

    public final void info(String str) {
        zzdi.zzaw(str);
    }

    public final void setLogLevel(int i11) {
        zzdi.zzac("GA uses GTM logger. Please use TagManager.setLogLevel(int) instead.");
    }

    public final void verbose(String str) {
        zzdi.zzab(str);
    }

    public final void warn(String str) {
        zzdi.zzac(str);
    }

    public final void error(Exception exc) {
        zzdi.zza("", exc);
    }
}
