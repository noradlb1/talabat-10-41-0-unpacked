package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.Map;

public final class zzno {
    private final Map<String, zznx> zzats;
    private final zznx zzatt;

    private zzno(Map<String, zznx> map, zznx zznx) {
        this.zzats = Collections.unmodifiableMap(map);
        this.zzatt = zznx;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzats);
        String valueOf2 = String.valueOf(this.zzatt);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 32 + valueOf2.length());
        sb2.append("Properties: ");
        sb2.append(valueOf);
        sb2.append(" pushAfterEvaluate: ");
        sb2.append(valueOf2);
        return sb2.toString();
    }

    public final Map<String, zznx> zzlu() {
        return this.zzats;
    }
}
