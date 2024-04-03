package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@VisibleForTesting
public final class zzov {
    private final String version;
    private final List<zzox> zzatq;
    private final Map<String, List<zzot>> zzatr;
    private final int zzpw;

    private zzov(List<zzox> list, Map<String, List<zzot>> map, String str, int i11) {
        this.zzatq = Collections.unmodifiableList(list);
        this.zzatr = Collections.unmodifiableMap(map);
        this.version = str;
        this.zzpw = i11;
    }

    public static zzow zzmn() {
        return new zzow();
    }

    public final String getVersion() {
        return this.version;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzatq);
        String valueOf2 = String.valueOf(this.zzatr);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 17 + valueOf2.length());
        sb2.append("Rules: ");
        sb2.append(valueOf);
        sb2.append("  Macros: ");
        sb2.append(valueOf2);
        return sb2.toString();
    }

    public final List<zzox> zzls() {
        return this.zzatq;
    }

    public final Map<String, List<zzot>> zzmo() {
        return this.zzatr;
    }
}
