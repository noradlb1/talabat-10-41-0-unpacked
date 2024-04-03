package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zzok extends zzoa<Map<String, zzoa<?>>> {
    private static final Map<String, zzgz> zzaug;
    private boolean zzaut = false;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("hasOwnProperty", zzja.zzark);
        zzaug = Collections.unmodifiableMap(hashMap);
    }

    public zzok(Map<String, zzoa<?>> map) {
        this.zzaud = (Map) Preconditions.checkNotNull(map);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzok) {
            return this.zzaud.entrySet().equals(((Map) ((zzok) obj).value()).entrySet());
        }
        return false;
    }

    public final boolean isImmutable() {
        return this.zzaut;
    }

    public final String toString() {
        return this.zzaud.toString();
    }

    public final /* synthetic */ Object value() {
        return this.zzaud;
    }

    public final zzoa<?> zzco(String str) {
        zzoa<?> zzco = super.zzco(str);
        if (zzco == null) {
            return zzog.zzaum;
        }
        return zzco;
    }

    public final boolean zzcp(String str) {
        return zzaug.containsKey(str);
    }

    public final zzgz zzcq(String str) {
        if (zzcp(str)) {
            return zzaug.get(str);
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 51);
        sb2.append("Native Method ");
        sb2.append(str);
        sb2.append(" is not defined for type ListWrapper.");
        throw new IllegalStateException(sb2.toString());
    }

    public final Iterator<zzoa<?>> zzmf() {
        return zzmg();
    }

    public final void zzmi() {
        this.zzaut = true;
    }
}
