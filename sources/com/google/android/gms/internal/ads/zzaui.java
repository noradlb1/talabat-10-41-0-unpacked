package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;
import android.util.SparseArray;
import com.google.android.exoplayer2.C;
import java.io.IOException;

final class zzaui implements zzaum, zzark, zzawg, zzauw {
    private long zzA;
    private long zzB;
    private long zzC;
    private int zzD;
    private boolean zzE;
    /* access modifiers changed from: private */
    public boolean zzF;
    private final zzavz zzG;
    private final Uri zza;
    private final zzavw zzb;
    private final int zzc;
    private final Handler zzd;
    /* access modifiers changed from: private */
    public final zzauj zze;
    private final zzaun zzf;
    /* access modifiers changed from: private */
    public final long zzg;
    private final zzawk zzh = new zzawk("Loader:ExtractorMediaPeriod");
    private final zzaug zzi;
    private final zzawo zzj;
    private final Runnable zzk;
    /* access modifiers changed from: private */
    public final Runnable zzl;
    /* access modifiers changed from: private */
    public final Handler zzm;
    /* access modifiers changed from: private */
    public final SparseArray<zzaux> zzn;
    /* access modifiers changed from: private */
    public zzaul zzo;
    private zzarq zzp;
    private boolean zzq;
    private boolean zzr;
    private boolean zzs;
    private boolean zzt;
    private int zzu;
    private zzavd zzv;
    private long zzw;
    private boolean[] zzx;
    private boolean[] zzy;
    private boolean zzz;

    public zzaui(Uri uri, zzavw zzavw, zzarj[] zzarjArr, int i11, Handler handler, zzauj zzauj, zzaun zzaun, zzavz zzavz, String str, int i12, byte[] bArr) {
        this.zza = uri;
        this.zzb = zzavw;
        this.zzc = i11;
        this.zzd = handler;
        this.zze = zzauj;
        this.zzf = zzaun;
        this.zzG = zzavz;
        this.zzg = (long) i12;
        this.zzi = new zzaug(zzarjArr, this);
        this.zzj = new zzawo();
        this.zzk = new zzaub(this);
        this.zzl = new zzauc(this);
        this.zzm = new Handler();
        this.zzC = C.TIME_UNSET;
        this.zzn = new SparseArray<>();
        this.zzA = -1;
    }

    private final int zzC() {
        int size = this.zzn.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += this.zzn.valueAt(i12).zze();
        }
        return i11;
    }

    private final long zzD() {
        int size = this.zzn.size();
        long j11 = Long.MIN_VALUE;
        for (int i11 = 0; i11 < size; i11++) {
            j11 = Math.max(j11, this.zzn.valueAt(i11).zzg());
        }
        return j11;
    }

    private final void zzE(zzauf zzauf) {
        if (this.zzA == -1) {
            this.zzA = zzauf.zzj;
        }
    }

    private final void zzF() {
        zzarq zzarq;
        zzauf zzauf = new zzauf(this, this.zza, this.zzb, this.zzi, this.zzj);
        if (this.zzr) {
            zzawm.zze(zzG());
            long j11 = this.zzw;
            if (j11 == C.TIME_UNSET || this.zzC < j11) {
                zzauf.zzd(this.zzp.zzb(this.zzC), this.zzC);
                this.zzC = C.TIME_UNSET;
            } else {
                this.zzE = true;
                this.zzC = C.TIME_UNSET;
                return;
            }
        }
        this.zzD = zzC();
        int i11 = this.zzc;
        if (i11 == -1) {
            if (this.zzr && this.zzA == -1 && ((zzarq = this.zzp) == null || zzarq.zza() == C.TIME_UNSET)) {
                i11 = 6;
            } else {
                i11 = 3;
            }
        }
        this.zzh.zza(zzauf, this, i11);
    }

    private final boolean zzG() {
        return this.zzC != C.TIME_UNSET;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: InitCodeVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Several immutable types in one variable: [int, boolean], vars: [r4v0 ?, r4v3 ?, r4v5 ?]
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVarType(InitCodeVariables.java:102)
        	at jadx.core.dex.visitors.InitCodeVariables.setCodeVar(InitCodeVariables.java:78)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVar(InitCodeVariables.java:69)
        	at jadx.core.dex.visitors.InitCodeVariables.initCodeVars(InitCodeVariables.java:51)
        	at jadx.core.dex.visitors.InitCodeVariables.visit(InitCodeVariables.java:32)
        */
    public static /* bridge */ /* synthetic */ void zzp(com.google.android.gms.internal.ads.zzaui r8) {
        /*
            boolean r0 = r8.zzF
            if (r0 != 0) goto L_0x009c
            boolean r0 = r8.zzr
            if (r0 != 0) goto L_0x009c
            com.google.android.gms.internal.ads.zzarq r0 = r8.zzp
            if (r0 == 0) goto L_0x009c
            boolean r0 = r8.zzq
            if (r0 != 0) goto L_0x0012
            goto L_0x009c
        L_0x0012:
            android.util.SparseArray<com.google.android.gms.internal.ads.zzaux> r0 = r8.zzn
            int r0 = r0.size()
            r1 = 0
            r2 = r1
        L_0x001a:
            if (r2 >= r0) goto L_0x002d
            android.util.SparseArray<com.google.android.gms.internal.ads.zzaux> r3 = r8.zzn
            java.lang.Object r3 = r3.valueAt(r2)
            com.google.android.gms.internal.ads.zzaux r3 = (com.google.android.gms.internal.ads.zzaux) r3
            com.google.android.gms.internal.ads.zzapg r3 = r3.zzh()
            if (r3 == 0) goto L_0x009c
            int r2 = r2 + 1
            goto L_0x001a
        L_0x002d:
            com.google.android.gms.internal.ads.zzawo r2 = r8.zzj
            r2.zzb()
            com.google.android.gms.internal.ads.zzavc[] r2 = new com.google.android.gms.internal.ads.zzavc[r0]
            boolean[] r3 = new boolean[r0]
            r8.zzy = r3
            boolean[] r3 = new boolean[r0]
            r8.zzx = r3
            com.google.android.gms.internal.ads.zzarq r3 = r8.zzp
            long r3 = r3.zza()
            r8.zzw = r3
            r3 = r1
        L_0x0045:
            r4 = 1
            if (r3 >= r0) goto L_0x007b
            android.util.SparseArray<com.google.android.gms.internal.ads.zzaux> r5 = r8.zzn
            java.lang.Object r5 = r5.valueAt(r3)
            com.google.android.gms.internal.ads.zzaux r5 = (com.google.android.gms.internal.ads.zzaux) r5
            com.google.android.gms.internal.ads.zzapg r5 = r5.zzh()
            com.google.android.gms.internal.ads.zzavc r6 = new com.google.android.gms.internal.ads.zzavc
            com.google.android.gms.internal.ads.zzapg[] r7 = new com.google.android.gms.internal.ads.zzapg[r4]
            r7[r1] = r5
            r6.<init>(r7)
            r2[r3] = r6
            java.lang.String r5 = r5.zzf
            boolean r6 = com.google.android.gms.internal.ads.zzawr.zzb(r5)
            if (r6 != 0) goto L_0x006f
            boolean r5 = com.google.android.gms.internal.ads.zzawr.zza(r5)
            if (r5 == 0) goto L_0x006e
            goto L_0x006f
        L_0x006e:
            r4 = r1
        L_0x006f:
            boolean[] r5 = r8.zzy
            r5[r3] = r4
            boolean r5 = r8.zzz
            r4 = r4 | r5
            r8.zzz = r4
            int r3 = r3 + 1
            goto L_0x0045
        L_0x007b:
            com.google.android.gms.internal.ads.zzavd r0 = new com.google.android.gms.internal.ads.zzavd
            r0.<init>(r2)
            r8.zzv = r0
            r8.zzr = r4
            com.google.android.gms.internal.ads.zzaun r0 = r8.zzf
            com.google.android.gms.internal.ads.zzavb r1 = new com.google.android.gms.internal.ads.zzavb
            long r2 = r8.zzw
            com.google.android.gms.internal.ads.zzarq r4 = r8.zzp
            boolean r4 = r4.zzc()
            r1.<init>(r2, r4)
            r2 = 0
            r0.zze(r1, r2)
            com.google.android.gms.internal.ads.zzaul r0 = r8.zzo
            r0.zzd(r8)
        L_0x009c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaui.zzp(com.google.android.gms.internal.ads.zzaui):void");
    }

    public final boolean zzA(int i11) {
        if (this.zzE) {
            return true;
        }
        if (!zzG()) {
            return this.zzn.valueAt(i11).zzm();
        }
        return false;
    }

    public final long zzB(zzavh[] zzavhArr, boolean[] zArr, zzauy[] zzauyArr, boolean[] zArr2, long j11) {
        zzavh zzavh;
        boolean z11;
        zzawm.zze(this.zzr);
        for (int i11 = 0; i11 < zzavhArr.length; i11++) {
            zzauh zzauh = zzauyArr[i11];
            if (zzauh != null && (zzavhArr[i11] == null || !zArr[i11])) {
                int zza2 = zzauh.zzb;
                zzawm.zze(this.zzx[zza2]);
                this.zzu--;
                this.zzx[zza2] = false;
                this.zzn.valueAt(zza2).zzi();
                zzauyArr[i11] = null;
            }
        }
        boolean z12 = false;
        for (int i12 = 0; i12 < zzavhArr.length; i12++) {
            if (zzauyArr[i12] == null && (zzavh = zzavhArr[i12]) != null) {
                zzavh.zzb();
                if (zzavh.zza(0) == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                zzawm.zze(z11);
                int zza3 = this.zzv.zza(zzavh.zzd());
                zzawm.zze(!this.zzx[zza3]);
                this.zzu++;
                this.zzx[zza3] = true;
                zzauyArr[i12] = new zzauh(this, zza3);
                zArr2[i12] = true;
                z12 = true;
            }
        }
        if (!this.zzs) {
            int size = this.zzn.size();
            for (int i13 = 0; i13 < size; i13++) {
                if (!this.zzx[i13]) {
                    this.zzn.valueAt(i13).zzi();
                }
            }
        }
        if (this.zzu == 0) {
            this.zzt = false;
            if (this.zzh.zzi()) {
                this.zzh.zzf();
            }
        } else if (!this.zzs ? j11 != 0 : z12) {
            j11 = zzi(j11);
            for (int i14 = 0; i14 < zzauyArr.length; i14++) {
                if (zzauyArr[i14] != null) {
                    zArr2[i14] = true;
                }
            }
        }
        this.zzs = true;
        return j11;
    }

    public final long zza() {
        if (this.zzu == 0) {
            return Long.MIN_VALUE;
        }
        return zzg();
    }

    public final void zzb() {
        this.zzq = true;
        this.zzm.post(this.zzk);
    }

    public final zzars zzbq(int i11, int i12) {
        zzaux zzaux = this.zzn.get(i11);
        if (zzaux != null) {
            return zzaux;
        }
        zzaux zzaux2 = new zzaux(this.zzG, (byte[]) null);
        zzaux2.zzk(this);
        this.zzn.put(i11, zzaux2);
        return zzaux2;
    }

    public final boolean zzbr(long j11) {
        if (this.zzE) {
            return false;
        }
        if (this.zzr && this.zzu == 0) {
            return false;
        }
        boolean zzc2 = this.zzj.zzc();
        if (this.zzh.zzi()) {
            return zzc2;
        }
        zzF();
        return true;
    }

    public final void zzc(zzarq zzarq) {
        this.zzp = zzarq;
        this.zzm.post(this.zzk);
    }

    public final /* bridge */ /* synthetic */ int zzd(zzawi zzawi, long j11, long j12, IOException iOException) {
        zzarq zzarq;
        boolean z11;
        zzauf zzauf = (zzauf) zzawi;
        zzE(zzauf);
        Handler handler = this.zzd;
        if (handler != null) {
            handler.post(new zzaue(this, iOException));
        }
        if (iOException instanceof zzave) {
            return 3;
        }
        int zzC2 = zzC();
        int i11 = this.zzD;
        if (this.zzA == -1 && ((zzarq = this.zzp) == null || zzarq.zza() == C.TIME_UNSET)) {
            this.zzB = 0;
            this.zzt = this.zzr;
            int size = this.zzn.size();
            for (int i12 = 0; i12 < size; i12++) {
                zzaux valueAt = this.zzn.valueAt(i12);
                if (!this.zzr || this.zzx[i12]) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                valueAt.zzj(z11);
            }
            zzauf.zzd(0, 0);
        }
        this.zzD = zzC();
        if (zzC2 <= i11) {
            return 0;
        }
        return 1;
    }

    public final int zze(int i11, zzaph zzaph, zzarb zzarb, boolean z11) {
        if (this.zzt || zzG()) {
            return -3;
        }
        return this.zzn.valueAt(i11).zzf(zzaph, zzarb, z11, this.zzE, this.zzB);
    }

    public final long zzg() {
        long j11;
        if (this.zzE) {
            return Long.MIN_VALUE;
        }
        if (zzG()) {
            return this.zzC;
        }
        if (this.zzz) {
            int size = this.zzn.size();
            j11 = Long.MAX_VALUE;
            for (int i11 = 0; i11 < size; i11++) {
                if (this.zzy[i11]) {
                    j11 = Math.min(j11, this.zzn.valueAt(i11).zzg());
                }
            }
        } else {
            j11 = zzD();
        }
        if (j11 == Long.MIN_VALUE) {
            return this.zzB;
        }
        return j11;
    }

    public final long zzh() {
        if (!this.zzt) {
            return C.TIME_UNSET;
        }
        this.zzt = false;
        return this.zzB;
    }

    public final long zzi(long j11) {
        if (true != this.zzp.zzc()) {
            j11 = 0;
        }
        this.zzB = j11;
        int size = this.zzn.size();
        boolean zzG2 = true ^ zzG();
        int i11 = 0;
        while (true) {
            if (zzG2) {
                if (i11 >= size) {
                    break;
                }
                if (this.zzx[i11]) {
                    zzG2 = this.zzn.valueAt(i11).zzn(j11, false);
                }
                i11++;
            } else {
                this.zzC = j11;
                this.zzE = false;
                if (this.zzh.zzi()) {
                    this.zzh.zzf();
                } else {
                    for (int i12 = 0; i12 < size; i12++) {
                        this.zzn.valueAt(i12).zzj(this.zzx[i12]);
                    }
                }
            }
        }
        this.zzt = false;
        return j11;
    }

    public final zzavd zzn() {
        return this.zzv;
    }

    public final void zzq(long j11) {
    }

    public final void zzr() throws IOException {
        this.zzh.zzg(Integer.MIN_VALUE);
    }

    public final void zzs() throws IOException {
        this.zzh.zzg(Integer.MIN_VALUE);
    }

    public final /* bridge */ /* synthetic */ void zzt(zzawi zzawi, long j11, long j12, boolean z11) {
        zzE((zzauf) zzawi);
        if (!z11 && this.zzu > 0) {
            int size = this.zzn.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.zzn.valueAt(i11).zzj(this.zzx[i11]);
            }
            this.zzo.zzc(this);
        }
    }

    public final /* bridge */ /* synthetic */ void zzu(zzawi zzawi, long j11, long j12) {
        long j13;
        zzE((zzauf) zzawi);
        this.zzE = true;
        if (this.zzw == C.TIME_UNSET) {
            long zzD2 = zzD();
            if (zzD2 == Long.MIN_VALUE) {
                j13 = 0;
            } else {
                j13 = zzD2 + 10000;
            }
            this.zzw = j13;
            this.zzf.zze(new zzavb(j13, this.zzp.zzc()), (Object) null);
        }
        this.zzo.zzc(this);
    }

    public final void zzv(zzapg zzapg) {
        this.zzm.post(this.zzk);
    }

    public final void zzw(zzaul zzaul, long j11) {
        this.zzo = zzaul;
        this.zzj.zzc();
        zzF();
    }

    public final void zzx() {
        this.zzh.zzh(new zzaud(this, this.zzi));
        this.zzm.removeCallbacksAndMessages((Object) null);
        this.zzF = true;
    }

    public final void zzy(int i11, long j11) {
        zzaux valueAt = this.zzn.valueAt(i11);
        if (!this.zzE || j11 <= valueAt.zzg()) {
            valueAt.zzn(j11, true);
        } else {
            valueAt.zzl();
        }
    }
}
