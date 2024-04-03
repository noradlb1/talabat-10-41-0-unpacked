package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzgkb;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class zzgkc<T extends zzgkb<T>> {
    private static final zzgkc zzb = new zzgkc(true);
    final zzgnb<T, Object> zza = new zzgmr(16);
    private boolean zzc;
    private boolean zzd;

    private zzgkc() {
    }

    public static <T extends zzgkb<T>> zzgkc<T> zza() {
        throw null;
    }

    private static final void zzd(T t11, Object obj) {
        boolean z11;
        zzgnv zzb2 = t11.zzb();
        zzgkv.zze(obj);
        zzgnv zzgnv = zzgnv.DOUBLE;
        zzgnw zzgnw = zzgnw.INT;
        switch (zzb2.zza().ordinal()) {
            case 0:
                z11 = obj instanceof Integer;
                break;
            case 1:
                z11 = obj instanceof Long;
                break;
            case 2:
                z11 = obj instanceof Float;
                break;
            case 3:
                z11 = obj instanceof Double;
                break;
            case 4:
                z11 = obj instanceof Boolean;
                break;
            case 5:
                z11 = obj instanceof String;
                break;
            case 6:
                if ((obj instanceof zzgjf) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzgkn)) {
                    return;
                }
            case 8:
                if ((obj instanceof zzglv) || (obj instanceof zzgla)) {
                    return;
                }
        }
        if (z11) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(t11.zza()), t11.zzb().zza(), obj.getClass().getName()}));
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzgkc zzgkc = new zzgkc();
        for (int i11 = 0; i11 < this.zza.zzb(); i11++) {
            Map.Entry<T, Object> zzg = this.zza.zzg(i11);
            zzgkc.zzc((zzgkb) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry next : this.zza.zzc()) {
            zzgkc.zzc((zzgkb) next.getKey(), next.getValue());
        }
        zzgkc.zzd = this.zzd;
        return zzgkc;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgkc)) {
            return false;
        }
        return this.zza.equals(((zzgkc) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzc) {
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzc(T t11, Object obj) {
        if (!t11.zzc()) {
            zzd(t11, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                zzd(t11, arrayList.get(i11));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzgla) {
            this.zzd = true;
        }
        this.zza.put(t11, obj);
    }

    private zzgkc(boolean z11) {
        zzb();
        zzb();
    }
}
