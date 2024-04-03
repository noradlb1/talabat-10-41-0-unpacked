package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzaij  reason: invalid package */
final class zzaij implements zzair {
    private final zzaif zza;
    private final zzajl zzb;
    private final boolean zzc;
    private final zzago zzd;

    private zzaij(zzajl zzajl, zzago zzago, zzaif zzaif) {
        this.zzb = zzajl;
        this.zzc = zzago.zzh(zzaif);
        this.zzd = zzago;
        this.zza = zzaif;
    }

    public static zzaij zzc(zzajl zzajl, zzago zzago, zzaif zzaif) {
        return new zzaij(zzajl, zzago, zzaif);
    }

    public final int zza(Object obj) {
        zzajl zzajl = this.zzb;
        int zzb2 = zzajl.zzb(zzajl.zzd(obj));
        if (!this.zzc) {
            return zzb2;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final int zzb(Object obj) {
        int hashCode = this.zzb.zzd(obj).hashCode();
        if (!this.zzc) {
            return hashCode;
        }
        this.zzd.zza(obj);
        throw null;
    }

    public final Object zze() {
        zzaif zzaif = this.zza;
        if (zzaif instanceof zzaha) {
            return ((zzaha) zzaif).zzw();
        }
        return zzaif.zzC().zzk();
    }

    public final void zzf(Object obj) {
        this.zzb.zzm(obj);
        this.zzd.zze(obj);
    }

    public final void zzg(Object obj, Object obj2) {
        zzait.zzq(this.zzb, obj, obj2);
        if (this.zzc) {
            this.zzd.zza(obj2);
            throw null;
        }
    }

    public final void zzh(Object obj, zzaiq zzaiq, zzagn zzagn) throws IOException {
        boolean z11;
        zzajl zzajl = this.zzb;
        zzago zzago = this.zzd;
        Object zzc2 = zzajl.zzc(obj);
        zzags zzb2 = zzago.zzb(obj);
        while (zzaiq.zzc() != Integer.MAX_VALUE) {
            int zzd2 = zzaiq.zzd();
            if (zzd2 != 11) {
                if ((zzd2 & 7) == 2) {
                    Object zzc3 = zzago.zzc(zzagn, this.zza, zzd2 >>> 3);
                    if (zzc3 != null) {
                        zzago.zzf(zzaiq, zzc3, zzagn, zzb2);
                    } else {
                        z11 = zzajl.zzp(zzc2, zzaiq);
                    }
                } else {
                    z11 = zzaiq.zzO();
                }
                if (!z11) {
                    zzajl.zzn(obj, zzc2);
                    return;
                }
            } else {
                Object obj2 = null;
                int i11 = 0;
                zzafv zzafv = null;
                while (true) {
                    try {
                        if (zzaiq.zzc() == Integer.MAX_VALUE) {
                            break;
                        }
                        int zzd3 = zzaiq.zzd();
                        if (zzd3 == 16) {
                            i11 = zzaiq.zzj();
                            obj2 = zzago.zzc(zzagn, this.zza, i11);
                        } else if (zzd3 == 26) {
                            if (obj2 != null) {
                                zzago.zzf(zzaiq, obj2, zzagn, zzb2);
                            } else {
                                zzafv = zzaiq.zzp();
                            }
                        } else if (!zzaiq.zzO()) {
                            break;
                        }
                    } catch (Throwable th2) {
                        zzajl.zzn(obj, zzc2);
                        throw th2;
                    }
                }
                if (zzaiq.zzd() != 12) {
                    throw zzahi.zzb();
                } else if (zzafv != null) {
                    if (obj2 != null) {
                        zzago.zzg(zzafv, obj2, zzagn, zzb2);
                    } else {
                        zzajl.zzk(zzc2, i11, zzafv);
                    }
                }
            }
        }
        zzajl.zzn(obj, zzc2);
    }

    public final void zzi(Object obj, byte[] bArr, int i11, int i12, zzafi zzafi) throws IOException {
        zzaha zzaha = (zzaha) obj;
        if (zzaha.zzc == zzajm.zzc()) {
            zzaha.zzc = zzajm.zzf();
        }
        zzagx zzagx = (zzagx) obj;
        throw null;
    }

    public final boolean zzj(Object obj, Object obj2) {
        if (!this.zzb.zzd(obj).equals(this.zzb.zzd(obj2))) {
            return false;
        }
        if (!this.zzc) {
            return true;
        }
        this.zzd.zza(obj);
        this.zzd.zza(obj2);
        throw null;
    }

    public final boolean zzk(Object obj) {
        this.zzd.zza(obj);
        throw null;
    }

    public final void zzm(Object obj, zzagj zzagj) throws IOException {
        this.zzd.zza(obj);
        throw null;
    }
}
