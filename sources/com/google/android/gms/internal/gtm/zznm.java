package com.google.android.gms.internal.gtm;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class zznm {
    private String version;
    private final List<zznr> zzatq;
    private final Map<String, zzno> zzatr;
    private int zzpw = 0;

    public zznm(List<zznr> list, Map<String, zzno> map, String str, int i11) {
        this.zzatq = Collections.unmodifiableList(list);
        this.zzatr = Collections.unmodifiableMap(map);
        this.version = str;
    }

    public final String getVersion() {
        return this.version;
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zzatq);
        String valueOf2 = String.valueOf(this.zzatr);
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 18 + valueOf2.length());
        sb2.append("Rules: ");
        sb2.append(valueOf);
        sb2.append("\n  Macros: ");
        sb2.append(valueOf2);
        return sb2.toString();
    }

    public final zzno zzck(String str) {
        return this.zzatr.get(str);
    }

    public final List<zznr> zzls() {
        return this.zzatq;
    }
}
