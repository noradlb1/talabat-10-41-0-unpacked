package com.google.android.gms.internal.vision;

import com.google.android.gms.vision.L;
import java.util.HashMap;

public final class zzm {
    private static final Object sLock = new Object();
    private static final HashMap<String, Integer> zzbx = new HashMap<>();

    public static boolean zza(String str, String str2) {
        String str3;
        int i11;
        synchronized (sLock) {
            String valueOf = String.valueOf(str);
            String valueOf2 = String.valueOf(str2);
            if (valueOf2.length() != 0) {
                str3 = valueOf.concat(valueOf2);
            } else {
                str3 = new String(valueOf);
            }
            HashMap<String, Integer> hashMap = zzbx;
            if (hashMap.containsKey(str3)) {
                i11 = hashMap.get(str3).intValue();
            } else {
                i11 = 0;
            }
            if ((i11 & 1) != 0) {
                return true;
            }
            try {
                System.loadLibrary(str2);
                hashMap.put(str3, Integer.valueOf(i11 | 1));
                return true;
            } catch (UnsatisfiedLinkError e11) {
                if ((i11 & 4) == 0) {
                    L.e(e11, "System.loadLibrary failed: %s", str2);
                    zzbx.put(str3, Integer.valueOf(i11 | 4));
                }
                return false;
            }
        }
    }
}
