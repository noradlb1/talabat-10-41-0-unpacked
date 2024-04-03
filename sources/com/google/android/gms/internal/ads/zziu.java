package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.os.Handler;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

public final class zziu extends zzi {
    private float zzA;
    /* access modifiers changed from: private */
    public boolean zzB;
    private List zzC;
    private boolean zzD;
    private boolean zzE;
    /* access modifiers changed from: private */
    public zzo zzF;
    /* access modifiers changed from: private */
    public zzct zzG;
    protected final zzil[] zzb;
    private final zzeb zzc;
    private final Context zzd;
    private final zzhf zze;
    private final zzir zzf;
    private final zzit zzg;
    /* access modifiers changed from: private */
    public final CopyOnWriteArraySet<zzbt> zzh;
    /* access modifiers changed from: private */
    public final zzlb zzi;
    private final zzfs zzj;
    private final zzfw zzk;
    /* access modifiers changed from: private */
    public final zzja zzl;
    private final zzjb zzm;
    private final zzjc zzn;
    /* access modifiers changed from: private */
    @Nullable
    public zzab zzo;
    /* access modifiers changed from: private */
    @Nullable
    public zzab zzp;
    @Nullable
    private AudioTrack zzq;
    /* access modifiers changed from: private */
    @Nullable
    public Object zzr;
    @Nullable
    private Surface zzs;
    private int zzt;
    private int zzu;
    private int zzv;
    /* access modifiers changed from: private */
    @Nullable
    public zzfy zzw;
    /* access modifiers changed from: private */
    @Nullable
    public zzfy zzx;
    private int zzy;
    private zzg zzz;

    public zziu(zzip zzip) {
        zziu zziu;
        Handler handler;
        zzit zzit;
        zzir zzir;
        zzhf zzhf;
        zzeb zzeb = new zzeb(zzdz.zza);
        this.zzc = zzeb;
        try {
            Context applicationContext = zzip.zza.getApplicationContext();
            this.zzd = applicationContext;
            zzlb zzj2 = zzip.zzg;
            this.zzi = zzj2;
            this.zzz = zzip.zzi;
            this.zzt = 1;
            this.zzB = false;
            zzir zzir2 = new zzir(this, (zziq) null);
            this.zzf = zzir2;
            zzit zzit2 = new zzit((zzis) null);
            this.zzg = zzit2;
            this.zzh = new CopyOnWriteArraySet<>();
            Handler handler2 = new Handler(zzip.zzh);
            zzil[] zza = zzip.zzl.zza(handler2, zzir2, zzir2, zzir2, zzir2);
            this.zzb = zza;
            this.zzA = 1.0f;
            if (zzfn.zza < 21) {
                AudioTrack audioTrack = this.zzq;
                if (!(audioTrack == null || audioTrack.getAudioSessionId() == 0)) {
                    this.zzq.release();
                    this.zzq = null;
                }
                if (this.zzq == null) {
                    this.zzq = new AudioTrack(3, 4000, 4, 2, 2, 0, 0);
                }
                this.zzy = this.zzq.getAudioSessionId();
            } else {
                this.zzy = zzk.zza(applicationContext);
            }
            this.zzC = Collections.emptyList();
            this.zzD = true;
            zzbp zzbp = new zzbp();
            int[] iArr = new int[8];
            iArr[0] = 20;
            iArr[1] = 21;
            iArr[2] = 22;
            iArr[3] = 23;
            try {
                iArr[4] = 24;
                iArr[5] = 25;
                iArr[6] = 26;
                iArr[7] = 27;
                zzbp.zzc(iArr);
                zzbr zze2 = zzbp.zze();
                zzhf zzhf2 = r1;
                handler = handler2;
                zzit = zzit2;
                zzir = zzir2;
                zzhf zzhf3 = new zzhf(zza, zzip.zzc, zzip.zzd, zzip.zze, zzip.zzf, zzj2, true, zzip.zzj, 5000, 15000, zzip.zzm, 500, false, zzip.zzb, zzip.zzh, this, zze2, (byte[]) null);
                zziu = this;
                zzhf = zzhf2;
            } catch (Throwable th2) {
                th = th2;
                zziu = this;
                zziu.zzc.zze();
                throw th;
            }
            try {
                zziu.zze = zzhf;
                zzir zzir3 = zzir;
                zzhf.zzx(zzir3);
                zzhf.zzw(zzir3);
                Handler handler3 = handler;
                zziu.zzj = new zzfs(zzip.zza, handler3, zzir3);
                zziu.zzk = new zzfw(zzip.zza, handler3, zzir3);
                zzfn.zzP((Object) null, (Object) null);
                zzja zzja = new zzja(zzip.zza, handler3, zzir3);
                zziu.zzl = zzja;
                int i11 = zziu.zzz.zzc;
                zzja.zzf(3);
                zziu.zzm = new zzjb(zzip.zza);
                zziu.zzn = new zzjc(zzip.zza);
                zziu.zzF = zzac(zzja);
                zziu.zzG = zzct.zza;
                zziu.zzae(1, 10, Integer.valueOf(zziu.zzy));
                zziu.zzae(2, 10, Integer.valueOf(zziu.zzy));
                zziu.zzae(1, 3, zziu.zzz);
                zziu.zzae(2, 4, Integer.valueOf(zziu.zzt));
                zziu.zzae(2, 5, 0);
                zziu.zzae(1, 9, Boolean.valueOf(zziu.zzB));
                zzit zzit3 = zzit;
                zziu.zzae(2, 7, zzit3);
                zziu.zzae(6, 8, zzit3);
                zzeb.zze();
            } catch (Throwable th3) {
                th = th3;
                zziu.zzc.zze();
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            zziu = this;
            zziu.zzc.zze();
            throw th;
        }
    }

    public static /* bridge */ /* synthetic */ void zzJ(zziu zziu) {
        zziu.zzi.zzt(zziu.zzB);
        Iterator<zzbt> it = zziu.zzh.iterator();
        while (it.hasNext()) {
            it.next().zzt(zziu.zzB);
        }
    }

    public static /* bridge */ /* synthetic */ void zzL(zziu zziu, SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        zziu.zzag(surface);
        zziu.zzs = surface;
    }

    public static /* synthetic */ void zzO(zziu zziu) {
        int zzr2 = zziu.zzr();
        if (zzr2 == 2 || zzr2 == 3) {
            zziu.zzai();
            zziu.zze.zzH();
            zziu.zzaa();
            zziu.zzaa();
        }
    }

    /* access modifiers changed from: private */
    public static int zzab(boolean z11, int i11) {
        return (!z11 || i11 == 1) ? 1 : 2;
    }

    /* access modifiers changed from: private */
    public static zzo zzac(zzja zzja) {
        return new zzo(0, zzja.zzb(), zzja.zza());
    }

    /* access modifiers changed from: private */
    public final void zzad(int i11, int i12) {
        if (i11 != this.zzu || i12 != this.zzv) {
            this.zzu = i11;
            this.zzv = i12;
            this.zzi.zzbk(i11, i12);
            Iterator<zzbt> it = this.zzh.iterator();
            while (it.hasNext()) {
                it.next().zzbk(i11, i12);
            }
        }
    }

    private final void zzae(int i11, int i12, @Nullable Object obj) {
        zzil[] zzilArr = this.zzb;
        int length = zzilArr.length;
        for (int i13 = 0; i13 < 2; i13++) {
            zzil zzil = zzilArr[i13];
            if (zzil.zzb() == i11) {
                zzii zzv2 = this.zze.zzv(zzil);
                zzv2.zzf(i12);
                zzv2.zze(obj);
                zzv2.zzd();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void zzaf() {
        zzae(1, 2, Float.valueOf(this.zzA * this.zzk.zza()));
    }

    /* access modifiers changed from: private */
    public final void zzag(@Nullable Object obj) {
        boolean z11;
        ArrayList<zzii> arrayList = new ArrayList<>();
        zzil[] zzilArr = this.zzb;
        int length = zzilArr.length;
        int i11 = 0;
        while (true) {
            z11 = true;
            if (i11 >= 2) {
                break;
            }
            zzil zzil = zzilArr[i11];
            if (zzil.zzb() == 2) {
                zzii zzv2 = this.zze.zzv(zzil);
                zzv2.zzf(1);
                zzv2.zze(obj);
                zzv2.zzd();
                arrayList.add(zzv2);
            }
            i11++;
        }
        Object obj2 = this.zzr;
        if (obj2 == null || obj2 == obj) {
            z11 = false;
        } else {
            try {
                for (zzii zzi2 : arrayList) {
                    zzi2.zzi(ExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
                }
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            } catch (TimeoutException unused2) {
            }
            z11 = false;
            Object obj3 = this.zzr;
            Surface surface = this.zzs;
            if (obj3 == surface) {
                surface.release();
                this.zzs = null;
            }
        }
        this.zzr = obj;
        if (z11) {
            this.zze.zzG(false, zzgg.zzd(new zzhq(3), 1003));
        }
    }

    /* access modifiers changed from: private */
    public final void zzah(boolean z11, int i11, int i12) {
        int i13 = 1;
        boolean z12 = z11 && i11 != -1;
        if (!z12 || i11 == 1) {
            i13 = 0;
        }
        this.zze.zzF(z12, i13, i12);
    }

    private final void zzai() {
        IllegalStateException illegalStateException;
        this.zzc.zzb();
        if (Thread.currentThread() != this.zze.zzu().getThread()) {
            String zzD2 = zzfn.zzD("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), this.zze.zzu().getThread().getName());
            if (!this.zzD) {
                if (this.zzE) {
                    illegalStateException = null;
                } else {
                    illegalStateException = new IllegalStateException();
                }
                zzep.zzb("SimpleExoPlayer", zzD2, illegalStateException);
                this.zzE = true;
                return;
            }
            throw new IllegalStateException(zzD2);
        }
    }

    public final void zzP(zzld zzld) {
        this.zzi.zzP(zzld);
    }

    public final void zzQ() {
        zzai();
        boolean zzaa = zzaa();
        int zzb2 = this.zzk.zzb(zzaa, 2);
        zzah(zzaa, zzb2, zzab(zzaa, zzb2));
        this.zze.zzC();
    }

    public final void zzR() {
        AudioTrack audioTrack;
        zzai();
        if (zzfn.zza < 21 && (audioTrack = this.zzq) != null) {
            audioTrack.release();
            this.zzq = null;
        }
        this.zzl.zze();
        this.zzk.zzd();
        this.zze.zzD();
        this.zzi.zzT();
        Surface surface = this.zzs;
        if (surface != null) {
            surface.release();
            this.zzs = null;
        }
        this.zzC = Collections.emptyList();
    }

    public final void zzS(zzld zzld) {
        this.zzi.zzU(zzld);
    }

    public final void zzT(zzqb zzqb) {
        zzai();
        this.zze.zzE(Collections.singletonList(zzqb), true);
    }

    public final void zzU(boolean z11) {
        zzai();
        int zzb2 = this.zzk.zzb(z11, zzr());
        zzah(z11, zzb2, zzab(z11, zzb2));
    }

    @Deprecated
    public final void zzV(boolean z11) {
        this.zzD = false;
    }

    public final void zzW(@Nullable Surface surface) {
        int i11;
        zzai();
        zzag(surface);
        if (surface == null) {
            i11 = 0;
        } else {
            i11 = -1;
        }
        zzad(i11, i11);
    }

    public final void zzX(float f11) {
        zzai();
        float zza = zzfn.zza(f11, 0.0f, 1.0f);
        if (this.zzA != zza) {
            this.zzA = zza;
            zzaf();
            this.zzi.zzbl(zza);
            Iterator<zzbt> it = this.zzh.iterator();
            while (it.hasNext()) {
                it.next().zzbl(zza);
            }
        }
    }

    @Deprecated
    public final void zzY(boolean z11) {
        zzai();
        this.zzk.zzb(zzaa(), 1);
        this.zze.zzG(false, (zzgg) null);
        this.zzC = Collections.emptyList();
    }

    public final boolean zzaa() {
        zzai();
        return this.zze.zzI();
    }

    public final int zze() {
        zzai();
        return this.zze.zze();
    }

    public final int zzf() {
        zzai();
        return this.zze.zzf();
    }

    public final int zzg() {
        zzai();
        return this.zze.zzg();
    }

    public final int zzh() {
        zzai();
        return this.zze.zzh();
    }

    public final int zzi() {
        zzai();
        return 0;
    }

    public final long zzj() {
        zzai();
        return this.zze.zzj();
    }

    public final long zzk() {
        zzai();
        return this.zze.zzk();
    }

    public final long zzl() {
        zzai();
        return this.zze.zzl();
    }

    public final zzcd zzm() {
        zzai();
        return this.zze.zzm();
    }

    public final void zzn(int i11, long j11) {
        zzai();
        this.zzi.zzR();
        this.zze.zzn(i11, j11);
    }

    public final boolean zzo() {
        zzai();
        return false;
    }

    public final boolean zzp() {
        zzai();
        return this.zze.zzp();
    }

    public final int zzr() {
        zzai();
        return this.zze.zzq();
    }

    public final int zzs() {
        zzai();
        this.zze.zzr();
        return 2;
    }

    public final long zzt() {
        zzai();
        return this.zze.zzs();
    }

    public final long zzu() {
        zzai();
        return this.zze.zzt();
    }
}
