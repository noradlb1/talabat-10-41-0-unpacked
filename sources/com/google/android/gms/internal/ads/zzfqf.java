package com.google.android.gms.internal.ads;

import java.util.logging.Logger;
import javax.annotation.CheckForNull;

final class zzfqf {
    private static final Logger zza = Logger.getLogger(zzfqf.class.getName());
    private static final zzfqe zzb = new zzfqe((zzfqd) null);

    private zzfqf() {
    }

    public static String zza(@CheckForNull String str) {
        return str == null ? "" : str;
    }

    public static boolean zzb(@CheckForNull String str) {
        return str == null || str.isEmpty();
    }
}
