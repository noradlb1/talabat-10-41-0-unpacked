package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class zzod extends zzoa<Boolean> {
    private static final Map<String, zzgz> zzaug;
    private final Boolean zzauf;

    static {
        HashMap hashMap = new HashMap();
        hashMap.put("hasOwnProperty", zzja.zzark);
        hashMap.put("toString", new zzkc());
        zzaug = Collections.unmodifiableMap(hashMap);
    }

    public zzod(Boolean bool) {
        Preconditions.checkNotNull(bool);
        this.zzauf = bool;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzod) || ((Boolean) ((zzod) obj).value()) != this.zzauf) {
            return false;
        }
        return true;
    }

    public final String toString() {
        return this.zzauf.toString();
    }

    public final /* synthetic */ Object value() {
        return this.zzauf;
    }

    public final boolean zzcp(String str) {
        return zzaug.containsKey(str);
    }

    public final zzgz zzcq(String str) {
        if (zzcp(str)) {
            return zzaug.get(str);
        }
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 54);
        sb2.append("Native Method ");
        sb2.append(str);
        sb2.append(" is not defined for type BooleanWrapper.");
        throw new IllegalStateException(sb2.toString());
    }
}
