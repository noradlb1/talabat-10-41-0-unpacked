package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

public final class zzfof {
    private static final HashMap<String, Class<?>> zza = new HashMap<>();
    private final Context zzb;
    private final zzfog zzc;
    private final zzfmh zzd;
    private final zzfmc zze;
    @Nullable
    private zzfnu zzf;
    private final Object zzg = new Object();

    public zzfof(@NonNull Context context, @NonNull zzfog zzfog, @NonNull zzfmh zzfmh, @NonNull zzfmc zzfmc) {
        this.zzb = context;
        this.zzc = zzfog;
        this.zzd = zzfmh;
        this.zze = zzfmc;
    }

    private final synchronized Class<?> zzd(@NonNull zzfnv zzfnv) throws zzfoe {
        String zzk = zzfnv.zza().zzk();
        HashMap<String, Class<?>> hashMap = zza;
        Class<?> cls = hashMap.get(zzk);
        if (cls != null) {
            return cls;
        }
        try {
            if (this.zze.zza(zzfnv.zzc())) {
                File zzb2 = zzfnv.zzb();
                if (!zzb2.exists()) {
                    zzb2.mkdirs();
                }
                Class<?> loadClass = new DexClassLoader(zzfnv.zzc().getAbsolutePath(), zzb2.getAbsolutePath(), (String) null, this.zzb.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                hashMap.put(zzk, loadClass);
                return loadClass;
            }
            throw new zzfoe(2026, "VM did not pass signature verification");
        } catch (GeneralSecurityException e11) {
            throw new zzfoe(2026, (Throwable) e11);
        } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e12) {
            throw new zzfoe(2008, e12);
        }
    }

    @Nullable
    public final zzfmk zza() {
        zzfnu zzfnu;
        synchronized (this.zzg) {
            zzfnu = this.zzf;
        }
        return zzfnu;
    }

    @Nullable
    public final zzfnv zzb() {
        synchronized (this.zzg) {
            zzfnu zzfnu = this.zzf;
            if (zzfnu == null) {
                return null;
            }
            zzfnv zzf2 = zzfnu.zzf();
            return zzf2;
        }
    }

    public final boolean zzc(@NonNull zzfnv zzfnv) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            Class<?> zzd2 = zzd(zzfnv);
            zzfnu zzfnu = new zzfnu(zzd2.getDeclaredConstructor(new Class[]{Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE}).newInstance(new Object[]{this.zzb, "msa-r", zzfnv.zze(), null, new Bundle(), 2}), zzfnv, this.zzc, this.zzd);
            if (zzfnu.zzh()) {
                int zze2 = zzfnu.zze();
                if (zze2 == 0) {
                    synchronized (this.zzg) {
                        zzfnu zzfnu2 = this.zzf;
                        if (zzfnu2 != null) {
                            try {
                                zzfnu2.zzg();
                            } catch (zzfoe e11) {
                                this.zzd.zzc(e11.zza(), -1, e11);
                            }
                        }
                        this.zzf = zzfnu;
                    }
                    this.zzd.zzd(3000, System.currentTimeMillis() - currentTimeMillis);
                    return true;
                }
                StringBuilder sb2 = new StringBuilder(15);
                sb2.append("ci: ");
                sb2.append(zze2);
                throw new zzfoe((int) PlaybackException.ERROR_CODE_DECODER_INIT_FAILED, sb2.toString());
            }
            throw new zzfoe(4000, "init failed");
        } catch (Exception e12) {
            throw new zzfoe((int) PlaybackException.ERROR_CODE_IO_BAD_HTTP_STATUS, (Throwable) e12);
        } catch (zzfoe e13) {
            this.zzd.zzc(e13.zza(), System.currentTimeMillis() - currentTimeMillis, e13);
            return false;
        } catch (Exception e14) {
            this.zzd.zzc(4010, System.currentTimeMillis() - currentTimeMillis, e14);
            return false;
        }
    }
}
