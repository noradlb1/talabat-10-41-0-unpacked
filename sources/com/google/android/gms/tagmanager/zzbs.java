package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.gtm.zza;
import com.google.android.gms.internal.gtm.zzl;
import java.util.Map;

final class zzbs extends zzdy {
    private static final String ID = zza.GREATER_EQUALS.toString();

    public zzbs() {
        super(ID);
    }

    public final boolean zza(zzgi zzgi, zzgi zzgi2, Map<String, zzl> map) {
        return zzgi.compareTo(zzgi2) >= 0;
    }
}
