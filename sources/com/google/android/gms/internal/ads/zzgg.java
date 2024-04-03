package com.google.android.gms.internal.ads;

import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import java.io.IOException;

public final class zzgg extends zzbl {
    public static final zzj<zzgg> zzd = zzgf.zza;
    public final int zze;
    @Nullable
    public final String zzf;
    public final int zzg;
    @Nullable
    public final zzab zzh;
    public final int zzi;
    @Nullable
    public final zzbf zzj;
    final boolean zzk;

    private zzgg(int i11, Throwable th2, int i12) {
        this(i11, th2, (String) null, i12, (String) null, -1, (zzab) null, 4, false);
    }

    public static zzgg zzb(Throwable th2, String str, int i11, @Nullable zzab zzab, int i12, boolean z11, int i13) {
        return new zzgg(1, th2, (String) null, i13, str, i11, zzab, zzab == null ? 4 : i12, z11);
    }

    public static zzgg zzc(IOException iOException, int i11) {
        return new zzgg(0, iOException, i11);
    }

    public static zzgg zzd(RuntimeException runtimeException, int i11) {
        return new zzgg(2, runtimeException, i11);
    }

    @CheckResult
    public final zzgg zza(@Nullable zzbf zzbf) {
        String message = getMessage();
        int i11 = zzfn.zza;
        return new zzgg(message, getCause(), this.zzb, this.zze, this.zzf, this.zzg, this.zzh, this.zzi, zzbf, this.zzc, this.zzk);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private zzgg(int r14, @androidx.annotation.Nullable java.lang.Throwable r15, @androidx.annotation.Nullable java.lang.String r16, int r17, @androidx.annotation.Nullable java.lang.String r18, int r19, @androidx.annotation.Nullable com.google.android.gms.internal.ads.zzab r20, int r21, boolean r22) {
        /*
            r13 = this;
            r4 = r14
            if (r4 == 0) goto L_0x0052
            r0 = 1
            if (r4 == r0) goto L_0x000d
            java.lang.String r0 = "Unexpected runtime error"
            r6 = r18
            r7 = r19
            goto L_0x0058
        L_0x000d:
            java.lang.String r0 = java.lang.String.valueOf(r20)
            java.lang.String r1 = com.google.android.gms.internal.ads.zzk.zze(r21)
            java.lang.String r2 = java.lang.String.valueOf(r18)
            int r2 = r2.length()
            int r3 = r0.length()
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            int r2 = r2 + 53
            int r2 = r2 + r3
            int r3 = r1.length()
            int r2 = r2 + r3
            r5.<init>(r2)
            r6 = r18
            r5.append(r6)
            java.lang.String r2 = " error, index="
            r5.append(r2)
            r7 = r19
            r5.append(r7)
            java.lang.String r2 = ", format="
            r5.append(r2)
            r5.append(r0)
            java.lang.String r0 = ", format_supported="
            r5.append(r0)
            r5.append(r1)
            java.lang.String r0 = r5.toString()
            goto L_0x0058
        L_0x0052:
            r6 = r18
            r7 = r19
            java.lang.String r0 = "Source error"
        L_0x0058:
            r1 = 0
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x0065
            java.lang.String r1 = ": null"
            java.lang.String r0 = r0.concat(r1)
        L_0x0065:
            r1 = r0
            r9 = 0
            long r10 = android.os.SystemClock.elapsedRealtime()
            r0 = r13
            r2 = r15
            r3 = r17
            r4 = r14
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            r12 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgg.<init>(int, java.lang.Throwable, java.lang.String, int, java.lang.String, int, com.google.android.gms.internal.ads.zzab, int, boolean):void");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzgg(String str, @Nullable Throwable th2, int i11, int i12, @Nullable String str2, int i13, @Nullable zzab zzab, int i14, @Nullable zzbf zzbf, long j11, boolean z11) {
        super(str, th2, i11, j11);
        boolean z12;
        int i15;
        boolean z13 = z11;
        boolean z14 = false;
        if (z13) {
            i15 = i12;
            if (i15 == 1) {
                i15 = 1;
                z12 = true;
            } else {
                z12 = false;
            }
        } else {
            i15 = i12;
            z12 = true;
        }
        zzdy.zzd(z12);
        zzdy.zzd(th2 != null ? true : z14);
        this.zze = i15;
        this.zzf = str2;
        this.zzg = i13;
        this.zzh = zzab;
        this.zzi = i14;
        this.zzj = zzbf;
        this.zzk = z13;
    }
}
