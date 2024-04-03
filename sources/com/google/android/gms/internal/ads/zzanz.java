package com.google.android.gms.internal.ads;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Method;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public final class zzanz {
    protected static final String zza = "zzanz";
    private final zzams zzb;
    private final String zzc;
    private final String zzd;
    private volatile Method zze = null;
    private final Class<?>[] zzf;
    private final CountDownLatch zzg = new CountDownLatch(1);

    public zzanz(zzams zzams, String str, String str2, Class<?>... clsArr) {
        this.zzb = zzams;
        this.zzc = str;
        this.zzd = str2;
        this.zzf = clsArr;
        zzams.zzk().submit(new zzany(this));
    }

    public static /* bridge */ /* synthetic */ void zzb(zzanz zzanz) {
        CountDownLatch countDownLatch;
        try {
            Class<?> loadClass = zzanz.zzb.zzi().loadClass(zzanz.zzc(zzanz.zzb.zzu(), zzanz.zzc));
            if (loadClass == null) {
                countDownLatch = zzanz.zzg;
            } else {
                zzanz.zze = loadClass.getMethod(zzanz.zzc(zzanz.zzb.zzu(), zzanz.zzd), zzanz.zzf);
                if (zzanz.zze == null) {
                    countDownLatch = zzanz.zzg;
                }
                countDownLatch = zzanz.zzg;
            }
        } catch (zzalx | UnsupportedEncodingException | ClassNotFoundException | NoSuchMethodException unused) {
        } catch (NullPointerException unused2) {
            countDownLatch = zzanz.zzg;
        } catch (Throwable th2) {
            zzanz.zzg.countDown();
            throw th2;
        }
        countDownLatch.countDown();
    }

    private final String zzc(byte[] bArr, String str) throws zzalx, UnsupportedEncodingException {
        return new String(this.zzb.zze().zzb(bArr, str), "UTF-8");
    }

    public final Method zza() {
        if (this.zze != null) {
            return this.zze;
        }
        try {
            if (!this.zzg.await(2, TimeUnit.SECONDS)) {
                return null;
            }
            return this.zze;
        } catch (InterruptedException unused) {
            return null;
        }
    }
}
