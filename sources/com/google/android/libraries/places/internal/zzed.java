package com.google.android.libraries.places.internal;

import com.google.android.gms.tasks.CancellationTokenSource;

final class zzed extends zzei {
    private final CancellationTokenSource zza;
    private final String zzb;

    public zzed(CancellationTokenSource cancellationTokenSource, String str) {
        this.zza = cancellationTokenSource;
        if (str != null) {
            this.zzb = str;
            return;
        }
        throw new NullPointerException("Null placeId");
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzei) {
            zzei zzei = (zzei) obj;
            if (!this.zza.equals(zzei.zza()) || !this.zzb.equals(zzei.zzb())) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final int hashCode() {
        return ((this.zza.hashCode() ^ 1000003) * 1000003) ^ this.zzb.hashCode();
    }

    public final String toString() {
        String valueOf = String.valueOf(this.zza);
        String str = this.zzb;
        StringBuilder sb2 = new StringBuilder(valueOf.length() + 31 + str.length());
        sb2.append("PlaceRequest{source=");
        sb2.append(valueOf);
        sb2.append(", placeId=");
        sb2.append(str);
        sb2.append("}");
        return sb2.toString();
    }

    public final CancellationTokenSource zza() {
        return this.zza;
    }

    public final String zzb() {
        return this.zzb;
    }
}
