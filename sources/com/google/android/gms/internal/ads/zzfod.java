package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.util.Hex;
import java.io.File;
import java.util.HashSet;

public final class zzfod {
    private static final Object zza = new Object();
    private final Context zzb;
    private final SharedPreferences zzc;
    private final String zzd;
    private final zzfnk zze;
    private boolean zzf = false;

    public zzfod(@NonNull Context context, @NonNull int i11, @NonNull zzfnk zzfnk, boolean z11) {
        this.zzb = context;
        this.zzd = Integer.toString(i11 - 1);
        this.zzc = context.getSharedPreferences("pcvmspf", 0);
        this.zze = zzfnk;
        this.zzf = z11;
    }

    private final File zze(@NonNull String str) {
        return new File(new File(this.zzb.getDir("pccache", 0), this.zzd), str);
    }

    private static String zzf(@NonNull zzaof zzaof) {
        zzaoh zze2 = zzaoi.zze();
        zze2.zze(zzaof.zzd().zzk());
        zze2.zza(zzaof.zzd().zzj());
        zze2.zzb(zzaof.zzd().zza());
        zze2.zzd(zzaof.zzd().zzd());
        zze2.zzc(zzaof.zzd().zzc());
        return Hex.bytesToStringLowercase(((zzaoi) zze2.zzah()).zzao().zzE());
    }

    private final String zzg() {
        String valueOf = String.valueOf(this.zzd);
        return valueOf.length() != 0 ? "FBAMTD".concat(valueOf) : new String("FBAMTD");
    }

    private final String zzh() {
        String valueOf = String.valueOf(this.zzd);
        return valueOf.length() != 0 ? "LATMTD".concat(valueOf) : new String("LATMTD");
    }

    private final void zzi(int i11, long j11) {
        zzfnk zzfnk = this.zze;
        if (zzfnk != null) {
            zzfnk.zza(i11, j11);
        }
    }

    private final void zzj(int i11, long j11, String str) {
        zzfnk zzfnk = this.zze;
        if (zzfnk != null) {
            zzfnk.zzb(i11, j11, str);
        }
    }

    private final zzaoi zzk(int i11) {
        String str;
        zzgjx zzgjx;
        if (i11 == 1) {
            str = this.zzc.getString(zzh(), (String) null);
        } else {
            str = this.zzc.getString(zzg(), (String) null);
        }
        if (str == null) {
            return null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        try {
            zzgjf zzv = zzgjf.zzv(Hex.stringToBytes(str));
            if (this.zzf) {
                zzgjx = zzgjx.zza();
            } else {
                zzgjx = zzgjx.zzb();
            }
            return zzaoi.zzi(zzv, zzgjx);
        } catch (zzgkx unused) {
            return null;
        } catch (NullPointerException unused2) {
            zzi(2029, currentTimeMillis);
            return null;
        } catch (RuntimeException unused3) {
            zzi(2032, currentTimeMillis);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0053, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zza(@androidx.annotation.NonNull com.google.android.gms.internal.ads.zzaof r7) {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
            java.lang.Object r2 = zza
            monitor-enter(r2)
            com.google.android.gms.internal.ads.zzaoi r3 = r7.zzd()     // Catch:{ all -> 0x0054 }
            java.lang.String r3 = r3.zzk()     // Catch:{ all -> 0x0054 }
            java.io.File r3 = r6.zze(r3)     // Catch:{ all -> 0x0054 }
            java.io.File r4 = new java.io.File     // Catch:{ all -> 0x0054 }
            java.lang.String r5 = "pcbc"
            r4.<init>(r3, r5)     // Catch:{ all -> 0x0054 }
            com.google.android.gms.internal.ads.zzgjf r3 = r7.zze()     // Catch:{ all -> 0x0054 }
            byte[] r3 = r3.zzE()     // Catch:{ all -> 0x0054 }
            boolean r3 = com.google.android.gms.internal.ads.zzfnx.zze(r4, r3)     // Catch:{ all -> 0x0054 }
            if (r3 != 0) goto L_0x0030
            r7 = 4020(0xfb4, float:5.633E-42)
            r6.zzi(r7, r0)     // Catch:{ all -> 0x0054 }
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            r7 = 0
            return r7
        L_0x0030:
            java.lang.String r7 = zzf(r7)     // Catch:{ all -> 0x0054 }
            android.content.SharedPreferences r3 = r6.zzc     // Catch:{ all -> 0x0054 }
            android.content.SharedPreferences$Editor r3 = r3.edit()     // Catch:{ all -> 0x0054 }
            java.lang.String r4 = r6.zzh()     // Catch:{ all -> 0x0054 }
            r3.putString(r4, r7)     // Catch:{ all -> 0x0054 }
            boolean r7 = r3.commit()     // Catch:{ all -> 0x0054 }
            if (r7 == 0) goto L_0x004d
            r3 = 5015(0x1397, float:7.028E-42)
            r6.zzi(r3, r0)     // Catch:{ all -> 0x0054 }
            goto L_0x0052
        L_0x004d:
            r3 = 4021(0xfb5, float:5.635E-42)
            r6.zzi(r3, r0)     // Catch:{ all -> 0x0054 }
        L_0x0052:
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            return r7
        L_0x0054:
            r7 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0054 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfod.zza(com.google.android.gms.internal.ads.zzaof):boolean");
    }

    public final boolean zzb(@NonNull zzaof zzaof, @Nullable zzfoc zzfoc) {
        String str;
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            zzaoi zzk = zzk(1);
            String zzk2 = zzaof.zzd().zzk();
            if (zzk == null || !zzk.zzk().equals(zzk2)) {
                long currentTimeMillis2 = System.currentTimeMillis();
                File zze2 = zze(zzk2);
                if (zze2.exists()) {
                    String str2 = "1";
                    if (true != zze2.isDirectory()) {
                        str2 = "0";
                    }
                    String str3 = "1";
                    if (true != zze2.isFile()) {
                        str3 = "0";
                    }
                    StringBuilder sb2 = new StringBuilder(str2.length() + 5 + str3.length());
                    sb2.append("d:");
                    sb2.append(str2);
                    sb2.append(",f:");
                    sb2.append(str3);
                    zzj(4023, currentTimeMillis2, sb2.toString());
                    zzi(4015, currentTimeMillis2);
                } else if (!zze2.mkdirs()) {
                    String str4 = "1";
                    if (true != zze2.canWrite()) {
                        str4 = "0";
                    }
                    if (str4.length() != 0) {
                        str = "cw:".concat(str4);
                    } else {
                        str = new String("cw:");
                    }
                    zzj(4024, currentTimeMillis2, str);
                    zzi(4015, currentTimeMillis2);
                    return false;
                }
                File zze3 = zze(zzk2);
                File file = new File(zze3, "pcam.jar");
                File file2 = new File(zze3, "pcbc");
                if (!zzfnx.zze(file, zzaof.zzf().zzE())) {
                    zzi(4016, currentTimeMillis);
                    return false;
                } else if (!zzfnx.zze(file2, zzaof.zze().zzE())) {
                    zzi(4017, currentTimeMillis);
                    return false;
                } else if (zzfoc == null || zzfoc.zza(file)) {
                    String zzf2 = zzf(zzaof);
                    long currentTimeMillis3 = System.currentTimeMillis();
                    String string = this.zzc.getString(zzh(), (String) null);
                    SharedPreferences.Editor edit = this.zzc.edit();
                    edit.putString(zzh(), zzf2);
                    if (string != null) {
                        edit.putString(zzg(), string);
                    }
                    if (!edit.commit()) {
                        zzi(4019, currentTimeMillis3);
                        return false;
                    }
                    HashSet hashSet = new HashSet();
                    zzaoi zzk3 = zzk(1);
                    if (zzk3 != null) {
                        hashSet.add(zzk3.zzk());
                    }
                    zzaoi zzk4 = zzk(2);
                    if (zzk4 != null) {
                        hashSet.add(zzk4.zzk());
                    }
                    for (File file3 : new File(this.zzb.getDir("pccache", 0), this.zzd).listFiles()) {
                        if (!hashSet.contains(file3.getName())) {
                            zzfnx.zzd(file3);
                        }
                    }
                    zzi(5014, currentTimeMillis);
                    return true;
                } else {
                    zzi(4018, currentTimeMillis);
                    zzfnx.zzd(zze3);
                    return false;
                }
            } else {
                zzi(4014, currentTimeMillis);
                return false;
            }
        }
    }

    @Nullable
    public final zzfnv zzc(int i11) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            zzaoi zzk = zzk(1);
            if (zzk == null) {
                zzi(4022, currentTimeMillis);
                return null;
            }
            File zze2 = zze(zzk.zzk());
            File file = new File(zze2, "pcam.jar");
            if (!file.exists()) {
                file = new File(zze2, "pcam");
            }
            File file2 = new File(zze2, "pcbc");
            File file3 = new File(zze2, "pcopt");
            zzi(5016, currentTimeMillis);
            zzfnv zzfnv = new zzfnv(zzk, file, file2, file3);
            return zzfnv;
        }
    }

    public final boolean zzd(int i11) {
        long currentTimeMillis = System.currentTimeMillis();
        synchronized (zza) {
            zzaoi zzk = zzk(1);
            if (zzk == null) {
                zzi(4025, currentTimeMillis);
                return false;
            }
            File zze2 = zze(zzk.zzk());
            if (!new File(zze2, "pcam.jar").exists()) {
                zzi(4026, currentTimeMillis);
                return false;
            } else if (!new File(zze2, "pcbc").exists()) {
                zzi(4027, currentTimeMillis);
                return false;
            } else {
                zzi(5019, currentTimeMillis);
                return true;
            }
        }
    }
}
