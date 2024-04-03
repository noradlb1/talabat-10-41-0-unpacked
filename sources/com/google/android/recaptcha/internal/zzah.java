package com.google.android.recaptcha.internal;

import android.content.Context;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class zzah {
    @NotNull
    public static final zzag zza = new zzag((DefaultConstructorMarker) null);
    @Nullable
    private static zzkx zzb;
    @NotNull
    private final String zzc;
    @NotNull
    private final zzr zzd;
    @NotNull
    private final zzll zze;
    private final long zzf = System.currentTimeMillis();

    public zzah(@NotNull zzaf zzaf, @NotNull String str, @NotNull zzr zzr) {
        this.zzc = str;
        this.zzd = zzr;
        zzll zzi = zzlo.zzi();
        this.zze = zzi;
        zzi.zzq(zzaf.zza());
        zzi.zze(zzaf.zzb());
        zzi.zzs(zzaf.zzc());
        zzi.zzv(zzaf.zzd());
        zzi.zzu(zzkr.zzc(zzkr.zzb(System.currentTimeMillis())));
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x004c A[Catch:{ NameNotFoundException -> 0x0093 }] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067 A[Catch:{ NameNotFoundException -> 0x0093 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final com.google.android.recaptcha.internal.zzkx zzd(android.content.Context r8) {
        /*
            java.lang.String r0 = "unknown"
            r1 = 33
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ NameNotFoundException -> 0x0047 }
            java.lang.String r3 = "com.google.android.gms.version"
            r4 = -1
            if (r2 < r1) goto L_0x002b
            android.content.pm.PackageManager r2 = r8.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0047 }
            java.lang.String r5 = r8.getPackageName()     // Catch:{ NameNotFoundException -> 0x0047 }
            r6 = 128(0x80, double:6.32E-322)
            android.content.pm.PackageManager$ApplicationInfoFlags r6 = android.content.pm.PackageManager.ApplicationInfoFlags.of(r6)     // Catch:{ NameNotFoundException -> 0x0047 }
            android.content.pm.ApplicationInfo r2 = r2.getApplicationInfo(r5, r6)     // Catch:{ NameNotFoundException -> 0x0047 }
            android.os.Bundle r2 = r2.metaData     // Catch:{ NameNotFoundException -> 0x0047 }
            int r2 = r2.getInt(r3, r4)     // Catch:{ NameNotFoundException -> 0x0047 }
            if (r2 != r4) goto L_0x0026
            goto L_0x0047
        L_0x0026:
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ NameNotFoundException -> 0x0047 }
            goto L_0x0048
        L_0x002b:
            android.content.pm.PackageManager r2 = r8.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0047 }
            java.lang.String r5 = r8.getPackageName()     // Catch:{ NameNotFoundException -> 0x0047 }
            r6 = 128(0x80, float:1.794E-43)
            android.content.pm.ApplicationInfo r2 = r2.getApplicationInfo(r5, r6)     // Catch:{ NameNotFoundException -> 0x0047 }
            android.os.Bundle r2 = r2.metaData     // Catch:{ NameNotFoundException -> 0x0047 }
            int r2 = r2.getInt(r3, r4)     // Catch:{ NameNotFoundException -> 0x0047 }
            if (r2 != r4) goto L_0x0042
            goto L_0x0047
        L_0x0042:
            java.lang.String r2 = java.lang.String.valueOf(r2)     // Catch:{ NameNotFoundException -> 0x0047 }
            goto L_0x0048
        L_0x0047:
            r2 = r0
        L_0x0048:
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ NameNotFoundException -> 0x0093 }
            if (r3 < r1) goto L_0x0067
            android.content.pm.PackageManager r1 = r8.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0093 }
            java.lang.String r8 = r8.getPackageName()     // Catch:{ NameNotFoundException -> 0x0093 }
            r3 = 0
            android.content.pm.PackageManager$PackageInfoFlags r3 = android.content.pm.PackageManager.PackageInfoFlags.of(r3)     // Catch:{ NameNotFoundException -> 0x0093 }
            android.content.pm.PackageInfo r8 = r1.getPackageInfo(r8, r3)     // Catch:{ NameNotFoundException -> 0x0093 }
            long r3 = r8.getLongVersionCode()     // Catch:{ NameNotFoundException -> 0x0093 }
            java.lang.String r0 = java.lang.String.valueOf(r3)     // Catch:{ NameNotFoundException -> 0x0093 }
            goto L_0x0093
        L_0x0067:
            r1 = 28
            r4 = 0
            if (r3 < r1) goto L_0x0081
            android.content.pm.PackageManager r1 = r8.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0093 }
            java.lang.String r8 = r8.getPackageName()     // Catch:{ NameNotFoundException -> 0x0093 }
            android.content.pm.PackageInfo r8 = r1.getPackageInfo(r8, r4)     // Catch:{ NameNotFoundException -> 0x0093 }
            long r3 = r8.getLongVersionCode()     // Catch:{ NameNotFoundException -> 0x0093 }
            java.lang.String r0 = java.lang.String.valueOf(r3)     // Catch:{ NameNotFoundException -> 0x0093 }
            goto L_0x0093
        L_0x0081:
            android.content.pm.PackageManager r1 = r8.getPackageManager()     // Catch:{ NameNotFoundException -> 0x0093 }
            java.lang.String r8 = r8.getPackageName()     // Catch:{ NameNotFoundException -> 0x0093 }
            android.content.pm.PackageInfo r8 = r1.getPackageInfo(r8, r4)     // Catch:{ NameNotFoundException -> 0x0093 }
            int r8 = r8.versionCode     // Catch:{ NameNotFoundException -> 0x0093 }
            java.lang.String r0 = java.lang.String.valueOf(r8)     // Catch:{ NameNotFoundException -> 0x0093 }
        L_0x0093:
            com.google.android.recaptcha.internal.zzkw r8 = com.google.android.recaptcha.internal.zzkx.zzf()
            int r1 = android.os.Build.VERSION.SDK_INT
            r8.zzd(r1)
            r8.zzq(r2)
            java.lang.String r1 = "18.2.1"
            r8.zzs(r1)
            java.lang.String r1 = android.os.Build.MODEL
            r8.zzp(r1)
            java.lang.String r1 = android.os.Build.MANUFACTURER
            r8.zzr(r1)
            r8.zze(r0)
            com.google.android.recaptcha.internal.zzhf r8 = r8.zzj()
            com.google.android.recaptcha.internal.zzkx r8 = (com.google.android.recaptcha.internal.zzkx) r8
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzah.zzd(android.content.Context):com.google.android.recaptcha.internal.zzkx");
    }

    public final long zza() {
        return this.zzf;
    }

    @NotNull
    public final zzll zzb() {
        return this.zze;
    }

    @NotNull
    public final zzlo zzc(@NotNull int i11, @Nullable zzla zzla, @NotNull Context context) {
        zzll zzll = this.zze;
        zzll.zzp(System.currentTimeMillis() - this.zzf);
        zzll.zzw(i11);
        if (zzla != null) {
            this.zze.zzr(zzla);
        }
        if (zzb == null) {
            zzb = zzd(context);
        }
        zzll zzll2 = this.zze;
        zzlz zzf2 = zzma.zzf();
        zzf2.zzq(this.zzc);
        zzkx zzkx = zzb;
        if (zzkx == null) {
            zzkx = zzd(context);
        }
        zzf2.zzd(zzkx);
        zzf2.zzp(Locale.getDefault().getISO3Language());
        zzf2.zze(Locale.getDefault().getISO3Country());
        zzll2.zzt((zzma) zzf2.zzj());
        return (zzlo) this.zze.zzj();
    }
}
