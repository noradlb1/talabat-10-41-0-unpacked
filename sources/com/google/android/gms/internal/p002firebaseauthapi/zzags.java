package com.google.android.gms.internal.p002firebaseauthapi;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzags  reason: invalid package */
final class zzags {
    private static final zzags zzb = new zzags(true);
    final zzaje zza = new zzaiu(16);
    private boolean zzc;
    private boolean zzd;

    private zzags() {
    }

    public static zzags zza() {
        throw null;
    }

    private static final void zzd(zzagr zzagr, Object obj) {
        boolean z11;
        zzakb zzb2 = zzagr.zzb();
        byte[] bArr = zzahg.zzd;
        obj.getClass();
        zzakb zzakb = zzakb.DOUBLE;
        zzakc zzakc = zzakc.INT;
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
                if ((obj instanceof zzafv) || (obj instanceof byte[])) {
                    return;
                }
            case 7:
                if ((obj instanceof Integer) || (obj instanceof zzahc)) {
                    return;
                }
            case 8:
                if ((obj instanceof zzaif) || (obj instanceof zzahk)) {
                    return;
                }
        }
        if (z11) {
            return;
        }
        throw new IllegalArgumentException(String.format("Wrong object type used with protocol message reflection.\nField number: %d, field java type: %s, value type: %s\n", new Object[]{Integer.valueOf(zzagr.zza()), zzagr.zzb().zza(), obj.getClass().getName()}));
    }

    public final /* bridge */ /* synthetic */ Object clone() throws CloneNotSupportedException {
        zzags zzags = new zzags();
        for (int i11 = 0; i11 < this.zza.zzb(); i11++) {
            Map.Entry zzg = this.zza.zzg(i11);
            zzags.zzc((zzagr) zzg.getKey(), zzg.getValue());
        }
        for (Map.Entry entry : this.zza.zzc()) {
            zzags.zzc((zzagr) entry.getKey(), entry.getValue());
        }
        zzags.zzd = this.zzd;
        return zzags;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzags)) {
            return false;
        }
        return this.zza.equals(((zzags) obj).zza);
    }

    public final int hashCode() {
        return this.zza.hashCode();
    }

    public final void zzb() {
        if (!this.zzc) {
            for (int i11 = 0; i11 < this.zza.zzb(); i11++) {
                Map.Entry zzg = this.zza.zzg(i11);
                if (zzg.getValue() instanceof zzaha) {
                    ((zzaha) zzg.getValue()).zzF();
                }
            }
            this.zza.zza();
            this.zzc = true;
        }
    }

    public final void zzc(zzagr zzagr, Object obj) {
        if (!zzagr.zzc()) {
            zzd(zzagr, obj);
        } else if (obj instanceof List) {
            ArrayList arrayList = new ArrayList();
            arrayList.addAll((List) obj);
            int size = arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                zzd(zzagr, arrayList.get(i11));
            }
            obj = arrayList;
        } else {
            throw new IllegalArgumentException("Wrong object type used with protocol message reflection.");
        }
        if (obj instanceof zzahk) {
            this.zzd = true;
        }
        this.zza.put(zzagr, obj);
    }

    private zzags(boolean z11) {
        zzb();
        zzb();
    }
}
