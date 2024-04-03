package com.google.android.gms.internal.ads;

import android.content.Context;
import android.media.MediaFormat;
import android.os.Handler;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.util.MimeTypes;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class zzmv extends zzoj implements zzht {
    private final Context zzb;
    /* access modifiers changed from: private */
    public final zzls zzc;
    private final zzlz zzd;
    private int zze;
    private boolean zzf;
    @Nullable
    private zzab zzg;
    private long zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;
    /* access modifiers changed from: private */
    @Nullable
    public zzik zzl;

    public zzmv(Context context, zzoe zzoe, zzol zzol, boolean z11, @Nullable Handler handler, @Nullable zzlt zzlt, zzlz zzlz) {
        super(1, zzoe, zzol, false, 44100.0f);
        this.zzb = context.getApplicationContext();
        this.zzd = zzlz;
        this.zzc = new zzls(handler, zzlt);
        zzlz.zzn(new zzmu(this, (zzmt) null));
    }

    private final int zzav(zzoh zzoh, zzab zzab) {
        int i11;
        if (!"OMX.google.raw.decoder".equals(zzoh.zza) || (i11 = zzfn.zza) >= 24 || (i11 == 23 && zzfn.zzT(this.zzb))) {
            return zzab.zzn;
        }
        return -1;
    }

    private final void zzaw() {
        long zzb2 = this.zzd.zzb(zzL());
        if (zzb2 != Long.MIN_VALUE) {
            if (!this.zzj) {
                zzb2 = Math.max(this.zzh, zzb2);
            }
            this.zzh = zzb2;
            this.zzj = false;
        }
    }

    public final String zzJ() {
        return "MediaCodecAudioRenderer";
    }

    public final boolean zzL() {
        return super.zzL() && this.zzd.zzt();
    }

    public final boolean zzM() {
        return this.zzd.zzs() || super.zzM();
    }

    public final float zzO(float f11, zzab zzab, zzab[] zzabArr) {
        int i11 = -1;
        for (zzab zzab2 : zzabArr) {
            int i12 = zzab2.zzA;
            if (i12 != -1) {
                i11 = Math.max(i11, i12);
            }
        }
        if (i11 == -1) {
            return -1.0f;
        }
        return ((float) i11) * f11;
    }

    public final int zzP(zzol zzol, zzab zzab) throws zzos {
        int i11;
        int i12;
        if (!zzbi.zzg(zzab.zzm)) {
            return 0;
        }
        if (zzfn.zza >= 21) {
            i11 = 32;
        } else {
            i11 = 0;
        }
        int i13 = zzab.zzF;
        boolean zzau = zzoj.zzau(zzab);
        if (zzau && this.zzd.zzu(zzab) && (i13 == 0 || zzoy.zzd() != null)) {
            return i11 | 12;
        }
        if ((MimeTypes.AUDIO_RAW.equals(zzab.zzm) && !this.zzd.zzu(zzab)) || !this.zzd.zzu(zzfn.zzB(2, zzab.zzz, zzab.zzA))) {
            return 1;
        }
        List<zzoh> zzV = zzV(zzol, zzab, false);
        if (zzV.isEmpty()) {
            return 1;
        }
        if (!zzau) {
            return 2;
        }
        zzoh zzoh = zzV.get(0);
        boolean zzd2 = zzoh.zzd(zzab);
        int i14 = 8;
        if (zzd2 && zzoh.zze(zzab)) {
            i14 = 16;
        }
        if (true != zzd2) {
            i12 = 3;
        } else {
            i12 = 4;
        }
        return i12 | i14 | i11;
    }

    public final zzfz zzQ(zzoh zzoh, zzab zzab, zzab zzab2) {
        int i11;
        int i12;
        zzfz zzb2 = zzoh.zzb(zzab, zzab2);
        int i13 = zzb2.zze;
        if (zzav(zzoh, zzab2) > this.zze) {
            i13 |= 64;
        }
        String str = zzoh.zza;
        if (i13 != 0) {
            i12 = 0;
            i11 = i13;
        } else {
            i11 = 0;
            i12 = zzb2.zzd;
        }
        return new zzfz(str, zzab, zzab2, i12, i11);
    }

    @Nullable
    public final zzfz zzR(zzhr zzhr) throws zzgg {
        zzfz zzR = super.zzR(zzhr);
        this.zzc.zzg(zzhr.zza, zzR);
        return zzR;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00a8, code lost:
        if ("AXON 7 mini".equals(r10) == false) goto L_0x00aa;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ee  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00f0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.internal.ads.zzod zzU(com.google.android.gms.internal.ads.zzoh r8, com.google.android.gms.internal.ads.zzab r9, @androidx.annotation.Nullable android.media.MediaCrypto r10, float r11) {
        /*
            r7 = this;
            com.google.android.gms.internal.ads.zzab[] r10 = r7.zzI()
            int r0 = r7.zzav(r8, r9)
            int r1 = r10.length
            r2 = 0
            r3 = 1
            if (r1 != r3) goto L_0x000e
            goto L_0x0026
        L_0x000e:
            r4 = r2
        L_0x000f:
            if (r4 >= r1) goto L_0x0026
            r5 = r10[r4]
            com.google.android.gms.internal.ads.zzfz r6 = r8.zzb(r9, r5)
            int r6 = r6.zzd
            if (r6 == 0) goto L_0x0023
            int r5 = r7.zzav(r8, r5)
            int r0 = java.lang.Math.max(r0, r5)
        L_0x0023:
            int r4 = r4 + 1
            goto L_0x000f
        L_0x0026:
            r7.zze = r0
            java.lang.String r10 = r8.zza
            int r0 = com.google.android.gms.internal.ads.zzfn.zza
            r1 = 24
            if (r0 >= r1) goto L_0x005e
            java.lang.String r4 = "OMX.SEC.aac.dec"
            boolean r10 = r4.equals(r10)
            if (r10 == 0) goto L_0x005e
            java.lang.String r10 = "samsung"
            java.lang.String r4 = com.google.android.gms.internal.ads.zzfn.zzc
            boolean r10 = r10.equals(r4)
            if (r10 == 0) goto L_0x005e
            java.lang.String r10 = com.google.android.gms.internal.ads.zzfn.zzb
            java.lang.String r4 = "zeroflte"
            boolean r4 = r10.startsWith(r4)
            if (r4 != 0) goto L_0x005c
            java.lang.String r4 = "herolte"
            boolean r4 = r10.startsWith(r4)
            if (r4 != 0) goto L_0x005c
            java.lang.String r4 = "heroqlte"
            boolean r10 = r10.startsWith(r4)
            if (r10 == 0) goto L_0x005e
        L_0x005c:
            r10 = r3
            goto L_0x005f
        L_0x005e:
            r10 = r2
        L_0x005f:
            r7.zzf = r10
            java.lang.String r10 = r8.zzc
            int r4 = r7.zze
            android.media.MediaFormat r5 = new android.media.MediaFormat
            r5.<init>()
            java.lang.String r6 = "mime"
            r5.setString(r6, r10)
            int r10 = r9.zzz
            java.lang.String r6 = "channel-count"
            r5.setInteger(r6, r10)
            java.lang.String r10 = "sample-rate"
            int r6 = r9.zzA
            r5.setInteger(r10, r6)
            java.util.List<byte[]> r10 = r9.zzo
            com.google.android.gms.internal.ads.zzer.zzb(r5, r10)
            java.lang.String r10 = "max-input-size"
            com.google.android.gms.internal.ads.zzer.zza(r5, r10, r4)
            r10 = 23
            if (r0 < r10) goto L_0x00af
            java.lang.String r4 = "priority"
            r5.setInteger(r4, r2)
            r2 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r2 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
            if (r2 == 0) goto L_0x00af
            if (r0 != r10) goto L_0x00aa
            java.lang.String r10 = com.google.android.gms.internal.ads.zzfn.zzd
            java.lang.String r2 = "ZTE B2017G"
            boolean r2 = r2.equals(r10)
            if (r2 != 0) goto L_0x00af
            java.lang.String r2 = "AXON 7 mini"
            boolean r10 = r2.equals(r10)
            if (r10 != 0) goto L_0x00af
        L_0x00aa:
            java.lang.String r10 = "operating-rate"
            r5.setFloat(r10, r11)
        L_0x00af:
            r10 = 28
            if (r0 > r10) goto L_0x00c2
            java.lang.String r10 = "audio/ac4"
            java.lang.String r11 = r9.zzm
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x00c2
            java.lang.String r10 = "ac4-is-sync"
            r5.setInteger(r10, r3)
        L_0x00c2:
            if (r0 < r1) goto L_0x00db
            com.google.android.gms.internal.ads.zzlz r10 = r7.zzd
            int r11 = r9.zzz
            int r0 = r9.zzA
            r1 = 4
            com.google.android.gms.internal.ads.zzab r11 = com.google.android.gms.internal.ads.zzfn.zzB(r1, r11, r0)
            int r10 = r10.zza(r11)
            r11 = 2
            if (r10 != r11) goto L_0x00db
            java.lang.String r10 = "pcm-encoding"
            r5.setInteger(r10, r1)
        L_0x00db:
            java.lang.String r10 = r8.zzb
            java.lang.String r11 = "audio/raw"
            boolean r10 = r11.equals(r10)
            r0 = 0
            if (r10 == 0) goto L_0x00f0
            java.lang.String r10 = r9.zzm
            boolean r10 = r11.equals(r10)
            if (r10 != 0) goto L_0x00f0
            r10 = r9
            goto L_0x00f1
        L_0x00f0:
            r10 = r0
        L_0x00f1:
            r7.zzg = r10
            com.google.android.gms.internal.ads.zzod r8 = com.google.android.gms.internal.ads.zzod.zza(r8, r5, r9, r0)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzmv.zzU(com.google.android.gms.internal.ads.zzoh, com.google.android.gms.internal.ads.zzab, android.media.MediaCrypto, float):com.google.android.gms.internal.ads.zzod");
    }

    public final List<zzoh> zzV(zzol zzol, zzab zzab, boolean z11) throws zzos {
        zzoh zzd2;
        String str = zzab.zzm;
        if (str == null) {
            return Collections.emptyList();
        }
        if (this.zzd.zzu(zzab) && (zzd2 = zzoy.zzd()) != null) {
            return Collections.singletonList(zzd2);
        }
        List<zzoh> zzf2 = zzoy.zzf(zzoy.zze(str, false, false), zzab);
        if (MimeTypes.AUDIO_E_AC3_JOC.equals(str)) {
            ArrayList arrayList = new ArrayList(zzf2);
            arrayList.addAll(zzoy.zze(MimeTypes.AUDIO_E_AC3, false, false));
            zzf2 = arrayList;
        }
        return Collections.unmodifiableList(zzf2);
    }

    public final void zzW(Exception exc) {
        zzep.zza("MediaCodecAudioRenderer", "Audio codec error", exc);
        this.zzc.zza(exc);
    }

    public final void zzX(String str, long j11, long j12) {
        this.zzc.zzc(str, j11, j12);
    }

    public final void zzY(String str) {
        this.zzc.zzd(str);
    }

    public final void zzZ(zzab zzab, @Nullable MediaFormat mediaFormat) throws zzgg {
        int i11;
        int i12;
        zzab zzab2 = this.zzg;
        int[] iArr = null;
        if (zzab2 != null) {
            zzab = zzab2;
        } else if (zzai() != null) {
            if (MimeTypes.AUDIO_RAW.equals(zzab.zzm)) {
                i11 = zzab.zzB;
            } else if (zzfn.zza >= 24 && mediaFormat.containsKey("pcm-encoding")) {
                i11 = mediaFormat.getInteger("pcm-encoding");
            } else if (mediaFormat.containsKey("v-bits-per-sample")) {
                i11 = zzfn.zzl(mediaFormat.getInteger("v-bits-per-sample"));
            } else if (MimeTypes.AUDIO_RAW.equals(zzab.zzm)) {
                i11 = zzab.zzB;
            } else {
                i11 = 2;
            }
            zzz zzz = new zzz();
            zzz.zzS(MimeTypes.AUDIO_RAW);
            zzz.zzN(i11);
            zzz.zzC(zzab.zzC);
            zzz.zzD(zzab.zzD);
            zzz.zzw(mediaFormat.getInteger("channel-count"));
            zzz.zzT(mediaFormat.getInteger("sample-rate"));
            zzab zzY = zzz.zzY();
            if (this.zzf && zzY.zzz == 6 && (i12 = zzab.zzz) < 6) {
                iArr = new int[i12];
                for (int i13 = 0; i13 < zzab.zzz; i13++) {
                    iArr[i13] = i13;
                }
            }
            zzab = zzY;
        }
        try {
            this.zzd.zzd(zzab, 0, iArr);
        } catch (zzlu e11) {
            throw zzbo(e11, e11.zza, false, PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED);
        }
    }

    public final long zza() {
        if (zzbm() == 2) {
            zzaw();
        }
        return this.zzh;
    }

    @CallSuper
    public final void zzaa() {
        this.zzj = true;
    }

    public final void zzab() {
        this.zzd.zzf();
    }

    public final void zzac(zzda zzda) {
        if (this.zzi && !zzda.zzf()) {
            if (Math.abs(zzda.zzd - this.zzh) > 500000) {
                this.zzh = zzda.zzd;
            }
            this.zzi = false;
        }
    }

    public final void zzad() throws zzgg {
        try {
            this.zzd.zzi();
        } catch (zzly e11) {
            throw zzbo(e11, e11.zzb, e11.zza, PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED);
        }
    }

    public final boolean zzae(long j11, long j12, @Nullable zzof zzof, @Nullable ByteBuffer byteBuffer, int i11, int i12, int i13, long j13, boolean z11, boolean z12, zzab zzab) throws zzgg {
        byteBuffer.getClass();
        if (this.zzg != null && (i12 & 2) != 0) {
            zzof.getClass();
            zzof.zzn(i11, false);
            return true;
        } else if (z11) {
            if (zzof != null) {
                zzof.zzn(i11, false);
            }
            this.zza.zzf += i13;
            this.zzd.zzf();
            return true;
        } else {
            try {
                if (!this.zzd.zzr(byteBuffer, j13, i13)) {
                    return false;
                }
                if (zzof != null) {
                    zzof.zzn(i11, false);
                }
                this.zza.zze += i13;
                return true;
            } catch (zzlv e11) {
                throw zzbo(e11, e11.zzb, false, PlaybackException.ERROR_CODE_AUDIO_TRACK_INIT_FAILED);
            } catch (zzly e12) {
                throw zzbo(e12, zzab, e12.zza, PlaybackException.ERROR_CODE_AUDIO_TRACK_WRITE_FAILED);
            }
        }
    }

    public final boolean zzaf(zzab zzab) {
        return this.zzd.zzu(zzab);
    }

    public final zzbn zzc() {
        return this.zzd.zzc();
    }

    public final void zzg(zzbn zzbn) {
        this.zzd.zzo(zzbn);
    }

    @Nullable
    public final zzht zzi() {
        return this;
    }

    public final void zzo(int i11, @Nullable Object obj) throws zzgg {
        if (i11 == 2) {
            this.zzd.zzq(((Float) obj).floatValue());
        } else if (i11 == 3) {
            this.zzd.zzk((zzg) obj);
        } else if (i11 != 6) {
            switch (i11) {
                case 9:
                    this.zzd.zzp(((Boolean) obj).booleanValue());
                    return;
                case 10:
                    this.zzd.zzl(((Integer) obj).intValue());
                    return;
                case 11:
                    this.zzl = (zzik) obj;
                    return;
                default:
                    return;
            }
        } else {
            this.zzd.zzm((zzh) obj);
        }
    }

    public final void zzq() {
        this.zzk = true;
        try {
            this.zzd.zze();
            try {
                super.zzq();
            } finally {
                this.zzc.zze(this.zza);
            }
        } catch (Throwable th2) {
            super.zzq();
            throw th2;
        } finally {
            this.zzc.zze(this.zza);
        }
    }

    public final void zzr(boolean z11, boolean z12) throws zzgg {
        super.zzr(z11, z12);
        this.zzc.zzf(this.zza);
        zzk();
    }

    public final void zzs(long j11, boolean z11) throws zzgg {
        super.zzs(j11, z11);
        this.zzd.zze();
        this.zzh = j11;
        this.zzi = true;
        this.zzj = true;
    }

    public final void zzt() {
        try {
            super.zzt();
            if (this.zzk) {
                this.zzk = false;
                this.zzd.zzj();
            }
        } catch (Throwable th2) {
            if (this.zzk) {
                this.zzk = false;
                this.zzd.zzj();
            }
            throw th2;
        }
    }

    public final void zzu() {
        this.zzd.zzh();
    }

    public final void zzv() {
        zzaw();
        this.zzd.zzg();
    }
}
