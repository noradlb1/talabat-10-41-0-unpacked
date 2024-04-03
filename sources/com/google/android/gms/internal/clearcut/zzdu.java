package com.google.android.gms.internal.clearcut;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class zzdu<T> implements zzef<T> {
    private final zzdo zzmn;
    private final boolean zzmo;
    private final zzex<?, ?> zzmx;
    private final zzbu<?> zzmy;

    private zzdu(zzex<?, ?> zzex, zzbu<?> zzbu, zzdo zzdo) {
        this.zzmx = zzex;
        this.zzmo = zzbu.zze(zzdo);
        this.zzmy = zzbu;
        this.zzmn = zzdo;
    }

    public static <T> zzdu<T> zza(zzex<?, ?> zzex, zzbu<?> zzbu, zzdo zzdo) {
        return new zzdu<>(zzex, zzbu, zzdo);
    }

    public final boolean equals(T t11, T t12) {
        if (!this.zzmx.zzq(t11).equals(this.zzmx.zzq(t12))) {
            return false;
        }
        if (this.zzmo) {
            return this.zzmy.zza((Object) t11).equals(this.zzmy.zza((Object) t12));
        }
        return true;
    }

    public final int hashCode(T t11) {
        int hashCode = this.zzmx.zzq(t11).hashCode();
        return this.zzmo ? (hashCode * 53) + this.zzmy.zza((Object) t11).hashCode() : hashCode;
    }

    public final T newInstance() {
        return this.zzmn.zzbd().zzbi();
    }

    public final void zza(T t11, zzfr zzfr) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zzmy.zza((Object) t11).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzca zzca = (zzca) next.getKey();
            if (zzca.zzav() != zzfq.MESSAGE || zzca.zzaw() || zzca.zzax()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            zzfr.zza(zzca.zzc(), next instanceof zzct ? ((zzct) next).zzbs().zzr() : next.getValue());
        }
        zzex<?, ?> zzex = this.zzmx;
        zzex.zzc(zzex.zzq(t11), zzfr);
    }

    public final void zza(T t11, byte[] bArr, int i11, int i12, zzay zzay) throws IOException {
        zzcg zzcg = (zzcg) t11;
        zzey zzey = zzcg.zzjp;
        if (zzey == zzey.zzea()) {
            zzey = zzey.zzeb();
            zzcg.zzjp = zzey;
        }
        zzey zzey2 = zzey;
        while (i11 < i12) {
            int zza = zzax.zza(bArr, i11, zzay);
            int i13 = zzay.zzfd;
            if (i13 != 11) {
                i11 = (i13 & 7) == 2 ? zzax.zza(i13, bArr, zza, i12, zzey2, zzay) : zzax.zza(i13, bArr, zza, i12, zzay);
            } else {
                int i14 = 0;
                zzbb zzbb = null;
                while (zza < i12) {
                    zza = zzax.zza(bArr, zza, zzay);
                    int i15 = zzay.zzfd;
                    int i16 = i15 >>> 3;
                    int i17 = i15 & 7;
                    if (i16 != 2) {
                        if (i16 == 3 && i17 == 2) {
                            zza = zzax.zze(bArr, zza, zzay);
                            zzbb = (zzbb) zzay.zzff;
                        }
                    } else if (i17 == 0) {
                        zza = zzax.zza(bArr, zza, zzay);
                        i14 = zzay.zzfd;
                    }
                    if (i15 == 12) {
                        break;
                    }
                    zza = zzax.zza(i15, bArr, zza, i12, zzay);
                }
                if (zzbb != null) {
                    zzey2.zzb((i14 << 3) | 2, zzbb);
                }
                i11 = zza;
            }
        }
        if (i11 != i12) {
            throw zzco.zzbo();
        }
    }

    public final void zzc(T t11) {
        this.zzmx.zzc(t11);
        this.zzmy.zzc(t11);
    }

    public final void zzc(T t11, T t12) {
        zzeh.zza(this.zzmx, t11, t12);
        if (this.zzmo) {
            zzeh.zza(this.zzmy, t11, t12);
        }
    }

    public final int zzm(T t11) {
        zzex<?, ?> zzex = this.zzmx;
        int zzr = zzex.zzr(zzex.zzq(t11)) + 0;
        return this.zzmo ? zzr + this.zzmy.zza((Object) t11).zzat() : zzr;
    }

    public final boolean zzo(T t11) {
        return this.zzmy.zza((Object) t11).isInitialized();
    }
}
