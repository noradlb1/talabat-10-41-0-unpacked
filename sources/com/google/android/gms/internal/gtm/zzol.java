package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.internal.Preconditions;
import java.util.List;

public final class zzol extends zzoa<String> {
    private final String zzauu;
    private final List<zzoa<?>> zzauv;

    public zzol(String str, List<zzoa<?>> list) {
        Preconditions.checkNotNull(str, "Instruction name must be a string.");
        Preconditions.checkNotNull(list);
        this.zzauu = str;
        this.zzauv = list;
    }

    public final String toString() {
        String str = this.zzauu;
        String obj = this.zzauv.toString();
        StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(obj).length());
        sb2.append("*");
        sb2.append(str);
        sb2.append(": ");
        sb2.append(obj);
        return sb2.toString();
    }

    public final /* synthetic */ Object value() {
        return toString();
    }

    public final String zzmj() {
        return this.zzauu;
    }

    public final List<zzoa<?>> zzmk() {
        return this.zzauv;
    }
}
