package com.google.android.gms.internal.icing;

import com.google.android.gms.internal.icing.zzct;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

final class zzcu<T extends zzct<T>> {
    private static final zzcu zzd = new zzcu(true);
    final zzez<T, Object> zza = new zzes(16);
    private boolean zzb;
    private boolean zzc;

    private zzcu() {
    }

    public static <T extends zzct<T>> zzcu<T> zza() {
        throw null;
    }

    private static final void zzd(T t11, Object obj) {
        boolean z11;
        zzfs zzb2 = t11.zzb();
        zzdh.zza(obj);
        zzfs zzfs = zzfs.DOUBLE;
        zzft zzft = zzft.INT;
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
                if ((obj instanceof zzcf) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzde)) {
                    return;
                }
            case 8:
                if ((obj instanceof zzee) || (obj instanceof zzdl)) {
                    return;
                }
        }
        if (z11) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(t11.zza()), t11.zzb().zza(), obj.getClass().getName()}));
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzcu zzcu = new zzcu();
        for (int i11 = 0; i11 < this.zza.zzc(); i11++) {
            Map.Entry<T, Object> zzd2 = this.zza.zzd(i11);
            zzcu.zzc((zzct) zzd2.getKey(), zzd2.getValue());
        }
        for (Map.Entry next : this.zza.zze()) {
            zzcu.zzc((zzct) next.getKey(), next.getValue());
        }
        zzcu.zzc = this.zzc;
        return zzcu;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzcu)) {
            return false;
        }
        return this.zza.equals(((zzcu) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzb) {
            this.zza.zza();
            this.zzb = true;
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
        if (obj instanceof zzdl) {
            this.zzc = true;
        }
        this.zza.put(t11, obj);
    }

    private zzcu(boolean z11) {
        zzb();
        zzb();
    }
}
