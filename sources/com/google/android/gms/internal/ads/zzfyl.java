package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class zzfyl {
    private static final CopyOnWriteArrayList<zzfyk> zza = new CopyOnWriteArrayList<>();

    public static zzfyk zza(String str) throws GeneralSecurityException {
        String str2;
        Iterator<zzfyk> it = zza.iterator();
        while (it.hasNext()) {
            zzfyk next = it.next();
            if (next.zza()) {
                return next;
            }
        }
        String valueOf = String.valueOf(str);
        if (valueOf.length() != 0) {
            str2 = "No KMS client does support: ".concat(valueOf);
        } else {
            str2 = new String("No KMS client does support: ");
        }
        throw new GeneralSecurityException(str2);
    }
}
