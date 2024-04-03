package com.google.android.recaptcha.internal;

import com.talabat.configuration.discovery.RealDiscoveryConfigurationRepository;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.annotation.Nullable;
import org.threeten.bp.Year;

public final class zzkr {
    public static final zzju zza;
    public static final zzju zzb;
    public static final zzju zzc;
    private static final ThreadLocal zzd = new zzkq();
    @Nullable
    private static final Method zze = zzd("now");
    @Nullable
    private static final Method zzf = zzd("getEpochSecond");
    @Nullable
    private static final Method zzg = zzd("getNano");

    static {
        zzjt zzi = zzju.zzi();
        zzi.zze(-62135596800L);
        zzi.zzd(0);
        zza = (zzju) zzi.zzj();
        zzjt zzi2 = zzju.zzi();
        zzi2.zze(253402300799L);
        zzi2.zzd(Year.MAX_VALUE);
        zzb = (zzju) zzi2.zzj();
        zzjt zzi3 = zzju.zzi();
        zzi3.zze(0);
        zzi3.zzd(0);
        zzc = (zzju) zzi3.zzj();
    }

    public static zzju zza(zzju zzju) {
        long zzg2 = zzju.zzg();
        int i11 = (zzg2 > -62135596800L ? 1 : (zzg2 == -62135596800L ? 0 : -1));
        int zzf2 = zzju.zzf();
        if (i11 >= 0 && zzg2 <= 253402300799L && zzf2 >= 0 && zzf2 < 1000000000) {
            return zzju;
        }
        throw new IllegalArgumentException(String.format("Timestamp is not valid. See proto definition for valid values. Seconds (%s) must be in range [-62,135,596,800, +253,402,300,799]. Nanos (%s) must be in range [0, +999,999,999].", new Object[]{Long.valueOf(zzg2), Integer.valueOf(zzf2)}));
    }

    public static zzju zzb(long j11) {
        int i11 = (int) ((j11 % 1000) * 1000000);
        long j12 = j11 / 1000;
        if (i11 <= -1000000000 || i11 >= 1000000000) {
            j12 = zzen.zza(j12, (long) (i11 / 1000000000));
            i11 %= 1000000000;
        }
        if (i11 < 0) {
            i11 += 1000000000;
            j12 = zzen.zzb(j12, 1);
        }
        zzjt zzi = zzju.zzi();
        zzi.zze(j12);
        zzi.zzd(i11);
        zzju zzju = (zzju) zzi.zzj();
        zza(zzju);
        return zzju;
    }

    public static String zzc(zzju zzju) {
        String str;
        zza(zzju);
        long zzg2 = zzju.zzg();
        int zzf2 = zzju.zzf();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(((SimpleDateFormat) zzd.get()).format(new Date(zzg2 * 1000)));
        if (zzf2 != 0) {
            sb2.append(RealDiscoveryConfigurationRepository.VERSION_DELIMETER);
            if (zzf2 % 1000000 == 0) {
                str = String.format(Locale.ENGLISH, "%1$03d", new Object[]{Integer.valueOf(zzf2 / 1000000)});
            } else if (zzf2 % 1000 == 0) {
                str = String.format(Locale.ENGLISH, "%1$06d", new Object[]{Integer.valueOf(zzf2 / 1000)});
            } else {
                str = String.format(Locale.ENGLISH, "%1$09d", new Object[]{Integer.valueOf(zzf2)});
            }
            sb2.append(str);
        }
        sb2.append("Z");
        return sb2.toString();
    }

    @Nullable
    private static Method zzd(String str) {
        try {
            return Class.forName("java.time.Instant").getMethod(str, new Class[0]);
        } catch (Exception unused) {
            return null;
        }
    }
}
