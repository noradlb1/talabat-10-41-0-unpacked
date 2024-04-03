package com.google.android.gms.internal.p002firebaseauthapi;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

/* renamed from: com.google.android.gms.internal.firebase-auth-api.zzby  reason: invalid package */
public final class zzby {
    private final zztk zza;
    private final List zzb;
    private final zzoh zzc = zzoh.zza;

    private zzby(zztk zztk, List list) {
        this.zza = zztk;
        this.zzb = list;
    }

    public static final zzby zza(zztk zztk) throws GeneralSecurityException {
        zzl(zztk);
        return new zzby(zztk, zzk(zztk));
    }

    public static final zzby zzh(zzbe zzbe, zzbd zzbd) throws GeneralSecurityException, IOException {
        byte[] bArr = new byte[0];
        zzrt zza2 = zzbe.zza();
        if (zza2 == null || zza2.zzd().zzd() == 0) {
            throw new GeneralSecurityException("empty keyset");
        }
        try {
            zztk zzg = zztk.zzg(zzbd.zza(zza2.zzd().zzq(), bArr), zzagn.zza());
            zzl(zzg);
            return zza(zzg);
        } catch (zzahi unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    private static zzlt zzi(zztj zztj) {
        Integer num;
        int zza2 = zztj.zza();
        if (zztj.zze() == zzud.RAW) {
            num = null;
        } else {
            num = Integer.valueOf(zza2);
        }
        try {
            return zzlt.zza(zztj.zzb().zzf(), zztj.zzb().zze(), zztj.zzb().zzb(), zztj.zze(), num);
        } catch (GeneralSecurityException e11) {
            throw new zzmf("Creating a protokey serialization failed", e11);
        }
    }

    @Nullable
    private static Object zzj(zzka zzka, zztj zztj, Class cls) throws GeneralSecurityException {
        try {
            zzsx zzb2 = zztj.zzb();
            int i11 = zzcq.zza;
            return zzcq.zzd(zzb2.zzf(), zzb2.zze(), cls);
        } catch (GeneralSecurityException e11) {
            if (e11.getMessage().contains("No key manager found for key type ") || e11.getMessage().contains(" not supported by key manager of type ")) {
                return null;
            }
            throw e11;
        } catch (UnsupportedOperationException unused) {
            return null;
        }
    }

    private static List zzk(zztk zztk) {
        zzbt zzbt;
        boolean z11;
        ArrayList arrayList = new ArrayList(zztk.zza());
        for (zztj zztj : zztk.zzh()) {
            int zza2 = zztj.zza();
            try {
                zzbm zza3 = zzky.zzc().zza(zzi(zztj), zzcr.zza());
                int zzk = zztj.zzk() - 2;
                if (zzk == 1) {
                    zzbt = zzbt.zza;
                } else if (zzk == 2) {
                    zzbt = zzbt.zzb;
                } else if (zzk == 3) {
                    zzbt = zzbt.zzc;
                } else {
                    throw new GeneralSecurityException("Unknown key status");
                }
                zzbt zzbt2 = zzbt;
                if (zza2 == zztk.zzb()) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                arrayList.add(new zzbx(zza3, zzbt2, zza2, z11, (zzbw) null));
            } catch (GeneralSecurityException unused) {
                arrayList.add((Object) null);
            }
        }
        return Collections.unmodifiableList(arrayList);
    }

    private static void zzl(zztk zztk) throws GeneralSecurityException {
        if (zztk == null || zztk.zza() <= 0) {
            throw new GeneralSecurityException("empty keyset");
        }
    }

    @Nullable
    private static final Object zzm(zzka zzka, zzbm zzbm, Class cls) throws GeneralSecurityException {
        try {
            return zzkv.zza().zzc(zzbm, cls);
        } catch (GeneralSecurityException unused) {
            return null;
        }
    }

    public final String toString() {
        return zzcs.zza(this.zza).toString();
    }

    public final zzby zzb() throws GeneralSecurityException {
        if (this.zza != null) {
            zzth zzc2 = zztk.zzc();
            for (zztj zztj : this.zza.zzh()) {
                zzsx zzb2 = zztj.zzb();
                if (zzb2.zzb() == zzsw.ASYMMETRIC_PRIVATE) {
                    String zzf = zzb2.zzf();
                    zzafv zze = zzb2.zze();
                    zzbn zza2 = zzcq.zza(zzf);
                    if (zza2 instanceof zzcn) {
                        zzsx zzd = ((zzcn) zza2).zzd(zze);
                        String zzf2 = zzd.zzf();
                        zzcq.zza(zzf2).zzb(zzd.zze());
                        zzti zzti = (zzti) zztj.zzu();
                        zzti.zza(zzd);
                        zzc2.zzb((zztj) zzti.zzi());
                    } else {
                        throw new GeneralSecurityException("manager for key type " + zzf + " is not a PrivateKeyManager");
                    }
                } else {
                    throw new GeneralSecurityException("The keyset contains a non-private key");
                }
            }
            zzc2.zzc(this.zza.zzb());
            return zza((zztk) zzc2.zzi());
        }
        throw new GeneralSecurityException("cleartext keyset is not available");
    }

    public final zztk zzc() {
        return this.zza;
    }

    public final zztp zzd() {
        return zzcs.zza(this.zza);
    }

    public final Object zze(zzbh zzbh, Class cls) throws GeneralSecurityException {
        Object obj;
        boolean z11;
        Class zzc2 = zzcq.zzc(cls);
        if (zzc2 != null) {
            zztk zztk = this.zza;
            Charset charset = zzcs.zza;
            int zzb2 = zztk.zzb();
            int i11 = 0;
            boolean z12 = false;
            boolean z13 = true;
            for (zztj zztj : zztk.zzh()) {
                if (zztj.zzk() == 3) {
                    if (!zztj.zzi()) {
                        throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(zztj.zza())}));
                    } else if (zztj.zze() == zzud.UNKNOWN_PREFIX) {
                        throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(zztj.zza())}));
                    } else if (zztj.zzk() != 2) {
                        if (zztj.zza() == zzb2) {
                            if (!z12) {
                                z12 = true;
                            } else {
                                throw new GeneralSecurityException("keyset contains multiple primary keys");
                            }
                        }
                        if (zztj.zzb().zzb() != zzsw.ASYMMETRIC_PUBLIC) {
                            z11 = false;
                        } else {
                            z11 = true;
                        }
                        z13 &= z11;
                        i11++;
                    } else {
                        throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(zztj.zza())}));
                    }
                }
            }
            if (i11 == 0) {
                throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
            } else if (z12 || z13) {
                zzcg zzcg = new zzcg(zzc2, (zzcf) null);
                zzcg.zzc(this.zzc);
                for (int i12 = 0; i12 < this.zza.zza(); i12++) {
                    zztj zzd = this.zza.zzd(i12);
                    if (zzd.zzk() == 3) {
                        zzka zzka = (zzka) zzbh;
                        Object zzj = zzj(zzka, zzd, zzc2);
                        if (this.zzb.get(i12) != null) {
                            obj = zzm(zzka, ((zzbx) this.zzb.get(i12)).zza(), zzc2);
                        } else {
                            obj = null;
                        }
                        if (obj == null && zzj == null) {
                            throw new GeneralSecurityException("Unable to get primitive " + zzc2.toString() + " for key of type " + zzd.zzb().zzf());
                        } else if (zzd.zza() == this.zza.zzb()) {
                            zzcg.zzb(obj, zzj, zzd);
                        } else {
                            zzcg.zza(obj, zzj, zzd);
                        }
                    }
                }
                return zzkv.zza().zzd(zzcg.zzd(), cls);
            } else {
                throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
            }
        } else {
            throw new GeneralSecurityException("No wrapper found for ".concat(cls.getName()));
        }
    }

    public final void zzf(zzca zzca, zzbd zzbd) throws GeneralSecurityException, IOException {
        byte[] bArr = new byte[0];
        zztk zztk = this.zza;
        byte[] zzb2 = zzbd.zzb(zztk.zzq(), bArr);
        try {
            if (zztk.zzg(zzbd.zza(zzb2, bArr), zzagn.zza()).equals(zztk)) {
                int length = zzb2.length;
                zzrs zza2 = zzrt.zza();
                zza2.zza(zzafv.zzn(zzb2, 0, length));
                zza2.zzb(zzcs.zza(zztk));
                zzca.zzb((zzrt) zza2.zzi());
                return;
            }
            throw new GeneralSecurityException("cannot encrypt keyset");
        } catch (zzahi unused) {
            throw new GeneralSecurityException("invalid keyset, corrupted key material");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x0010  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzg(com.google.android.gms.internal.p002firebaseauthapi.zzca r5) throws java.security.GeneralSecurityException, java.io.IOException {
        /*
            r4 = this;
            com.google.android.gms.internal.firebase-auth-api.zztk r0 = r4.zza
            java.util.List r0 = r0.zzh()
            java.util.Iterator r0 = r0.iterator()
        L_0x000a:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0064
            java.lang.Object r1 = r0.next()
            com.google.android.gms.internal.firebase-auth-api.zztj r1 = (com.google.android.gms.internal.p002firebaseauthapi.zztj) r1
            com.google.android.gms.internal.firebase-auth-api.zzsx r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzsw r2 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzsw r3 = com.google.android.gms.internal.p002firebaseauthapi.zzsw.UNKNOWN_KEYMATERIAL
            if (r2 == r3) goto L_0x003b
            com.google.android.gms.internal.firebase-auth-api.zzsx r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzsw r2 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzsw r3 = com.google.android.gms.internal.p002firebaseauthapi.zzsw.SYMMETRIC
            if (r2 == r3) goto L_0x003b
            com.google.android.gms.internal.firebase-auth-api.zzsx r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzsw r2 = r2.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzsw r3 = com.google.android.gms.internal.p002firebaseauthapi.zzsw.ASYMMETRIC_PRIVATE
            if (r2 == r3) goto L_0x003b
            goto L_0x000a
        L_0x003b:
            java.security.GeneralSecurityException r5 = new java.security.GeneralSecurityException
            r0 = 2
            java.lang.Object[] r0 = new java.lang.Object[r0]
            com.google.android.gms.internal.firebase-auth-api.zzsx r2 = r1.zzb()
            com.google.android.gms.internal.firebase-auth-api.zzsw r2 = r2.zzb()
            java.lang.String r2 = r2.name()
            r3 = 0
            r0[r3] = r2
            com.google.android.gms.internal.firebase-auth-api.zzsx r1 = r1.zzb()
            java.lang.String r1 = r1.zzf()
            r2 = 1
            r0[r2] = r1
            java.lang.String r1 = "keyset contains key material of type %s for type url %s"
            java.lang.String r0 = java.lang.String.format(r1, r0)
            r5.<init>(r0)
            throw r5
        L_0x0064:
            com.google.android.gms.internal.firebase-auth-api.zztk r0 = r4.zza
            r5.zzc(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.p002firebaseauthapi.zzby.zzg(com.google.android.gms.internal.firebase-auth-api.zzca):void");
    }
}
