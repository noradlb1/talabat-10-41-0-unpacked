package com.google.android.recaptcha.internal;

import java.util.Map;

final class zzhs implements Map.Entry {
    private final Map.Entry zza;

    public /* synthetic */ zzhs(Map.Entry entry, zzhr zzhr) {
        this.zza = entry;
    }

    public final Object getKey() {
        return this.zza.getKey();
    }

    public final Object getValue() {
        if (((zzhu) this.zza.getValue()) == null) {
            return null;
        }
        throw null;
    }

    public final Object setValue(Object obj) {
        if (obj instanceof zzip) {
            return ((zzhu) this.zza.getValue()).zzc((zzip) obj);
        }
        throw new IllegalArgumentException("LazyField now only used for MessageSet, and the value of MessageSet must be an instance of MessageLite");
    }

    public final zzhu zza() {
        return (zzhu) this.zza.getValue();
    }
}
