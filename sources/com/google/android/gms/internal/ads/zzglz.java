package com.google.android.gms.internal.ads;

import java.io.IOException;

final class zzglz<T> implements zzgmo<T> {
    private final zzglv zza;
    private final zzgnf<?, ?> zzb;
    private final boolean zzc;
    private final zzgjy<?> zzd;

    private zzglz(zzgnf<?, ?> zzgnf, zzgjy<?> zzgjy, zzglv zzglv) {
        this.zzb = zzgnf;
        this.zzc = zzgjy.zzh(zzglv);
        this.zzd = zzgjy;
        this.zza = zzglv;
    }

    public static <T> zzglz<T> zzc(zzgnf<?, ?> zzgnf, zzgjy<?> zzgjy, zzglv zzglv) {
        return new zzglz<>(zzgnf, zzgjy, zzglv);
    }

    public final int zza(T t11) {
        zzgnf<?, ?> zzgnf = this.zzb;
        int zzb2 = zzgnf.zzb(zzgnf.zzd(t11));
        if (!this.zzc) {
            return zzb2;
        }
        this.zzd.zza(t11);
        throw null;
    }

    public final int zzb(T t11) {
        int hashCode = this.zzb.zzd(t11).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(t11);
        throw null;
    }

    public final T zze() {
        return this.zza.zzaG().zzaj();
    }

    public final void zzf(T t11) {
        this.zzb.zzm(t11);
        this.zzd.zze(t11);
    }

    public final void zzg(T t11, T t12) {
        zzgmq.zzF(this.zzb, t11, t12);
        if (this.zzc) {
            zzgmq.zzE(this.zzd, t11, t12);
        }
    }

    public final void zzh(T t11, zzgmg zzgmg, zzgjx zzgjx) throws IOException {
        boolean z11;
        zzgnf<?, ?> zzgnf = this.zzb;
        zzgjy<?> zzgjy = this.zzd;
        Object zzc2 = zzgnf.zzc(t11);
        zzgkc<?> zzb2 = zzgjy.zzb(t11);
        while (zzgmg.zzc() != Integer.MAX_VALUE) {
            int zzd2 = zzgmg.zzd();
            if (zzd2 != 11) {
                if ((zzd2 & 7) == 2) {
                    Object zzc3 = zzgjy.zzc(zzgjx, this.zza, zzd2 >>> 3);
                    if (zzc3 != null) {
                        zzgjy.zzf(zzgmg, zzc3, zzgjx, zzb2);
                    } else {
                        z11 = zzgnf.zzp(zzc2, zzgmg);
                    }
                } else {
                    z11 = zzgmg.zzO();
                }
                if (!z11) {
                    zzgnf.zzn(t11, zzc2);
                    return;
                }
            } else {
                Object obj = null;
                int i11 = 0;
                zzgjf zzgjf = null;
                while (true) {
                    try {
                        if (zzgmg.zzc() == Integer.MAX_VALUE) {
                            break;
                        }
                        int zzd3 = zzgmg.zzd();
                        if (zzd3 == 16) {
                            i11 = zzgmg.zzj();
                            obj = zzgjy.zzc(zzgjx, this.zza, i11);
                        } else if (zzd3 == 26) {
                            if (obj != null) {
                                zzgjy.zzf(zzgmg, obj, zzgjx, zzb2);
                            } else {
                                zzgjf = zzgmg.zzp();
                            }
                        } else if (!zzgmg.zzO()) {
                            break;
                        }
                    } catch (Throwable th2) {
                        zzgnf.zzn(t11, zzc2);
                        throw th2;
                    }
                }
                if (zzgmg.zzd() != 12) {
                    throw zzgkx.zzb();
                } else if (zzgjf != null) {
                    if (obj != null) {
                        zzgjy.zzg(zzgjf, obj, zzgjx, zzb2);
                    } else {
                        zzgnf.zzk(zzc2, i11, zzgjf);
                    }
                }
            }
        }
        zzgnf.zzn(t11, zzc2);
    }

    public final void zzi(T t11, byte[] bArr, int i11, int i12, zzgiq zzgiq) throws IOException {
        zzgkl zzgkl = (zzgkl) t11;
        if (zzgkl.zzc == zzgng.zzc()) {
            zzgkl.zzc = zzgng.zze();
        }
        zzgki zzgki = (zzgki) t11;
        throw null;
    }

    public final boolean zzj(T t11, T t12) {
        if (!this.zzb.zzd(t11).equals(this.zzb.zzd(t12))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(t11);
        this.zzd.zza(t12);
        throw null;
    }

    public final boolean zzk(T t11) {
        this.zzd.zza(t11);
        throw null;
    }

    public final void zzn(T t11, zzgjt zzgjt) throws IOException {
        this.zzd.zza(t11);
        throw null;
    }
}
