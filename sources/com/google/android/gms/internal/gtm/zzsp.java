package com.google.android.gms.internal.gtm;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

final class zzsp<T> implements zzsz<T> {
    private final zzsk zzbdc;
    private final boolean zzbdd;
    private final zztr<?, ?> zzbdm;
    private final zzqq<?> zzbdn;

    private zzsp(zztr<?, ?> zztr, zzqq<?> zzqq, zzsk zzsk) {
        this.zzbdm = zztr;
        this.zzbdd = zzqq.zze(zzsk);
        this.zzbdn = zzqq;
        this.zzbdc = zzsk;
    }

    public static <T> zzsp<T> zza(zztr<?, ?> zztr, zzqq<?> zzqq, zzsk zzsk) {
        return new zzsp<>(zztr, zzqq, zzsk);
    }

    public final boolean equals(T t11, T t12) {
        if (!this.zzbdm.zzag(t11).equals(this.zzbdm.zzag(t12))) {
            return false;
        }
        if (this.zzbdd) {
            return this.zzbdn.zzr(t11).equals(this.zzbdn.zzr(t12));
        }
        return true;
    }

    public final int hashCode(T t11) {
        int hashCode = this.zzbdm.zzag(t11).hashCode();
        if (this.zzbdd) {
            return (hashCode * 53) + this.zzbdn.zzr(t11).hashCode();
        }
        return hashCode;
    }

    public final T newInstance() {
        return this.zzbdc.zzph().zzpl();
    }

    public final int zzad(T t11) {
        zztr<?, ?> zztr = this.zzbdm;
        int zzai = zztr.zzai(zztr.zzag(t11)) + 0;
        if (this.zzbdd) {
            return zzai + this.zzbdn.zzr(t11).zzow();
        }
        return zzai;
    }

    public final boolean zzae(T t11) {
        return this.zzbdn.zzr(t11).isInitialized();
    }

    public final void zzd(T t11, T t12) {
        zztb.zza(this.zzbdm, t11, t12);
        if (this.zzbdd) {
            zztb.zza(this.zzbdn, t11, t12);
        }
    }

    public final void zzt(T t11) {
        this.zzbdm.zzt(t11);
        this.zzbdn.zzt(t11);
    }

    public final void zza(T t11, zzum zzum) throws IOException {
        Iterator<Map.Entry<?, Object>> it = this.zzbdn.zzr(t11).iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            zzqv zzqv = (zzqv) next.getKey();
            if (zzqv.zzoy() != zzul.MESSAGE || zzqv.zzoz() || zzqv.zzpa()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            } else if (next instanceof zzrp) {
                zzum.zza(zzqv.zzc(), (Object) ((zzrp) next).zzpz().zzmv());
            } else {
                zzum.zza(zzqv.zzc(), next.getValue());
            }
        }
        zztr<?, ?> zztr = this.zzbdm;
        zztr.zzc(zztr.zzag(t11), zzum);
    }

    public final void zza(T t11, zzsy zzsy, zzqp zzqp) throws IOException {
        boolean z11;
        zztr<?, ?> zztr = this.zzbdm;
        zzqq<?> zzqq = this.zzbdn;
        Object zzah = zztr.zzah(t11);
        zzqt<?> zzs = zzqq.zzs(t11);
        do {
            try {
                if (zzsy.zzog() == Integer.MAX_VALUE) {
                    zztr.zzg(t11, zzah);
                    return;
                }
                int tag = zzsy.getTag();
                if (tag == 11) {
                    Object obj = null;
                    int i11 = 0;
                    zzps zzps = null;
                    while (zzsy.zzog() != Integer.MAX_VALUE) {
                        int tag2 = zzsy.getTag();
                        if (tag2 == 16) {
                            i11 = zzsy.zznr();
                            obj = zzqq.zza(zzqp, this.zzbdc, i11);
                        } else if (tag2 == 26) {
                            if (obj != null) {
                                zzqq.zza(zzsy, obj, zzqp, zzs);
                            } else {
                                zzps = zzsy.zznq();
                            }
                        } else if (!zzsy.zzoh()) {
                            break;
                        }
                    }
                    if (zzsy.getTag() != 12) {
                        throw zzrk.zzps();
                    } else if (zzps != null) {
                        if (obj != null) {
                            zzqq.zza(zzps, obj, zzqp, zzs);
                        } else {
                            zztr.zza(zzah, i11, zzps);
                        }
                    }
                } else if ((tag & 7) == 2) {
                    Object zza = zzqq.zza(zzqp, this.zzbdc, tag >>> 3);
                    if (zza != null) {
                        zzqq.zza(zzsy, zza, zzqp, zzs);
                    } else {
                        z11 = zztr.zza(zzah, zzsy);
                        continue;
                    }
                } else {
                    z11 = zzsy.zzoh();
                    continue;
                }
                z11 = true;
                continue;
            } finally {
                zztr.zzg(t11, zzah);
            }
        } while (z11);
    }
}
