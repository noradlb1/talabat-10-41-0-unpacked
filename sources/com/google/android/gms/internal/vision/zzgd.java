package com.google.android.gms.internal.vision;

import com.google.android.gms.internal.vision.zzgs;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class zzgd {
    private static volatile boolean zzsv = false;
    private static boolean zzsw = true;
    private static volatile zzgd zzsx;
    private static volatile zzgd zzsy;
    private static final zzgd zzsz = new zzgd(true);
    private final Map<zza, zzgs.zzg<?, ?>> zzta;

    public static final class zza {
        private final int number;
        private final Object object;

        public zza(Object obj, int i11) {
            this.object = obj;
            this.number = i11;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof zza)) {
                return false;
            }
            zza zza = (zza) obj;
            if (this.object == zza.object && this.number == zza.number) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (System.identityHashCode(this.object) * 65535) + this.number;
        }
    }

    public zzgd() {
        this.zzta = new HashMap();
    }

    public static zzgd zzfk() {
        return new zzgd();
    }

    public static zzgd zzfl() {
        zzgd zzgd = zzsx;
        if (zzgd == null) {
            synchronized (zzgd.class) {
                zzgd = zzsx;
                if (zzgd == null) {
                    zzgd = zzsz;
                    zzsx = zzgd;
                }
            }
        }
        return zzgd;
    }

    public static zzgd zzfm() {
        zzgd zzgd = zzsy;
        if (zzgd == null) {
            synchronized (zzgd.class) {
                zzgd = zzsy;
                if (zzgd == null) {
                    zzgd = zzgr.zzc(zzgd.class);
                    zzsy = zzgd;
                }
            }
        }
        return zzgd;
    }

    public final <ContainingType extends zzic> zzgs.zzg<ContainingType, ?> zza(ContainingType containingtype, int i11) {
        return this.zzta.get(new zza(containingtype, i11));
    }

    private zzgd(boolean z11) {
        this.zzta = Collections.emptyMap();
    }

    public final void zza(zzgs.zzg<?, ?> zzg) {
        this.zzta.put(new zza(zzg.zzwz, zzg.zzxb.number), zzg);
    }
}
