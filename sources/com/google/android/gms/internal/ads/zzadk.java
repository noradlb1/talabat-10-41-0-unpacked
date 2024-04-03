package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;

public final class zzadk implements zzadr {
    private final zzfc zza;
    private final zzfd zzb;
    @Nullable
    private final String zzc;
    private String zzd;
    private zzxt zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private boolean zzi;
    private long zzj;
    private zzab zzk;
    private int zzl;
    private long zzm;

    public zzadk() {
        this((String) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0107, code lost:
        r0 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(com.google.android.gms.internal.ads.zzfd r11) {
        /*
            r10 = this;
            com.google.android.gms.internal.ads.zzxt r0 = r10.zze
            com.google.android.gms.internal.ads.zzdy.zzb(r0)
        L_0x0005:
            int r0 = r11.zza()
            if (r0 <= 0) goto L_0x0128
            int r0 = r10.zzf
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 == 0) goto L_0x00d7
            if (r0 == r3) goto L_0x004c
            int r0 = r11.zza()
            int r1 = r10.zzl
            int r3 = r10.zzg
            int r1 = r1 - r3
            int r0 = java.lang.Math.min(r0, r1)
            com.google.android.gms.internal.ads.zzxt r1 = r10.zze
            com.google.android.gms.internal.ads.zzxr.zzb(r1, r11, r0)
            int r1 = r10.zzg
            int r1 = r1 + r0
            r10.zzg = r1
            int r7 = r10.zzl
            if (r1 != r7) goto L_0x0005
            long r4 = r10.zzm
            r0 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x0049
            com.google.android.gms.internal.ads.zzxt r3 = r10.zze
            r6 = 1
            r8 = 0
            r9 = 0
            r3.zzs(r4, r6, r7, r8, r9)
            long r0 = r10.zzm
            long r3 = r10.zzj
            long r0 = r0 + r3
            r10.zzm = r0
        L_0x0049:
            r10.zzf = r2
            goto L_0x0005
        L_0x004c:
            com.google.android.gms.internal.ads.zzfd r0 = r10.zzb
            byte[] r0 = r0.zzH()
            int r3 = r11.zza()
            int r4 = r10.zzg
            r5 = 16
            int r4 = 16 - r4
            int r3 = java.lang.Math.min(r3, r4)
            int r4 = r10.zzg
            r11.zzB(r0, r4, r3)
            int r0 = r10.zzg
            int r0 = r0 + r3
            r10.zzg = r0
            if (r0 != r5) goto L_0x0005
            com.google.android.gms.internal.ads.zzfc r0 = r10.zza
            r0.zzh(r2)
            com.google.android.gms.internal.ads.zzfc r0 = r10.zza
            com.google.android.gms.internal.ads.zzvx r0 = com.google.android.gms.internal.ads.zzvy.zza(r0)
            com.google.android.gms.internal.ads.zzab r3 = r10.zzk
            java.lang.String r4 = "audio/ac4"
            if (r3 == 0) goto L_0x008f
            int r6 = r3.zzz
            if (r6 != r1) goto L_0x008f
            int r6 = r0.zza
            int r7 = r3.zzA
            if (r6 != r7) goto L_0x008f
            java.lang.String r3 = r3.zzm
            boolean r3 = r4.equals(r3)
            if (r3 != 0) goto L_0x00b4
        L_0x008f:
            com.google.android.gms.internal.ads.zzz r3 = new com.google.android.gms.internal.ads.zzz
            r3.<init>()
            java.lang.String r6 = r10.zzd
            r3.zzH(r6)
            r3.zzS(r4)
            r3.zzw(r1)
            int r4 = r0.zza
            r3.zzT(r4)
            java.lang.String r4 = r10.zzc
            r3.zzK(r4)
            com.google.android.gms.internal.ads.zzab r3 = r3.zzY()
            r10.zzk = r3
            com.google.android.gms.internal.ads.zzxt r4 = r10.zze
            r4.zzk(r3)
        L_0x00b4:
            int r3 = r0.zzb
            r10.zzl = r3
            int r0 = r0.zzc
            long r3 = (long) r0
            r6 = 1000000(0xf4240, double:4.940656E-318)
            long r3 = r3 * r6
            com.google.android.gms.internal.ads.zzab r0 = r10.zzk
            int r0 = r0.zzA
            long r6 = (long) r0
            long r3 = r3 / r6
            r10.zzj = r3
            com.google.android.gms.internal.ads.zzfd r0 = r10.zzb
            r0.zzF(r2)
            com.google.android.gms.internal.ads.zzxt r0 = r10.zze
            com.google.android.gms.internal.ads.zzfd r2 = r10.zzb
            com.google.android.gms.internal.ads.zzxr.zzb(r0, r2, r5)
            r10.zzf = r1
            goto L_0x0005
        L_0x00d7:
            int r0 = r11.zza()
            if (r0 <= 0) goto L_0x0005
            boolean r0 = r10.zzh
            r4 = 172(0xac, float:2.41E-43)
            if (r0 != 0) goto L_0x00ef
            int r0 = r11.zzk()
            if (r0 != r4) goto L_0x00eb
            r0 = r3
            goto L_0x00ec
        L_0x00eb:
            r0 = r2
        L_0x00ec:
            r10.zzh = r0
            goto L_0x00d7
        L_0x00ef:
            int r0 = r11.zzk()
            if (r0 != r4) goto L_0x00f7
            r4 = r3
            goto L_0x00f8
        L_0x00f7:
            r4 = r2
        L_0x00f8:
            r10.zzh = r4
            r4 = 64
            r5 = 65
            if (r0 == r4) goto L_0x0103
            if (r0 != r5) goto L_0x00d7
            goto L_0x0107
        L_0x0103:
            if (r0 == r5) goto L_0x0107
            r0 = r2
            goto L_0x0108
        L_0x0107:
            r0 = r3
        L_0x0108:
            r10.zzi = r0
            r10.zzf = r3
            com.google.android.gms.internal.ads.zzfd r0 = r10.zzb
            byte[] r0 = r0.zzH()
            r6 = -84
            r0[r2] = r6
            com.google.android.gms.internal.ads.zzfd r0 = r10.zzb
            byte[] r0 = r0.zzH()
            boolean r2 = r10.zzi
            if (r3 == r2) goto L_0x0121
            goto L_0x0122
        L_0x0121:
            r4 = r5
        L_0x0122:
            r0[r3] = r4
            r10.zzg = r1
            goto L_0x0005
        L_0x0128:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzadk.zza(com.google.android.gms.internal.ads.zzfd):void");
    }

    public final void zzb(zzws zzws, zzafd zzafd) {
        zzafd.zzc();
        this.zzd = zzafd.zzb();
        this.zze = zzws.zzv(zzafd.zza(), 1);
    }

    public final void zzc() {
    }

    public final void zzd(long j11, int i11) {
        if (j11 != C.TIME_UNSET) {
            this.zzm = j11;
        }
    }

    public final void zze() {
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = false;
        this.zzi = false;
        this.zzm = C.TIME_UNSET;
    }

    public zzadk(@Nullable String str) {
        zzfc zzfc = new zzfc(new byte[16], 16);
        this.zza = zzfc;
        this.zzb = new zzfd(zzfc.zza);
        this.zzf = 0;
        this.zzg = 0;
        this.zzh = false;
        this.zzi = false;
        this.zzm = C.TIME_UNSET;
        this.zzc = str;
    }
}
