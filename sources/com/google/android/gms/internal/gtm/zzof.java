package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zzof extends zzoa<zzgz> {
    private static final Map<String, zzgz> zzaug;
    private zzgz zzaui;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("hasOwnProperty", zzja.zzark);
        zzaug = Collections.unmodifiableMap(hashMap);
    }

    public zzof(zzgz zzgz) {
        this.zzaui = zzgz;
    }

    public final String toString() {
        return this.zzaui.toString();
    }

    public final /* synthetic */ Object value() {
        return this.zzaui;
    }

    public final boolean zzcp(String str) {
        return zzaug.containsKey(str);
    }

    public final zzgz zzcq(String str) {
        if (zzcp(str)) {
            return zzaug.get(str);
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 60);
        sb2.append("Native Method ");
        sb2.append(str);
        sb2.append(" is not defined for type InstructionReference.");
        throw new IllegalStateException(sb2.toString());
    }

    public final Iterator<zzoa<?>> zzmf() {
        return zzmg();
    }
}
