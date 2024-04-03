package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.PlaybackException;
import com.google.common.base.Ascii;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.compress.archivers.tar.TarConstants;

public abstract class zzoj extends zzfx {
    private static final byte[] zzb = {0, 0, 1, TarConstants.LF_PAX_GLOBAL_EXTENDED_HEADER, 66, -64, 11, -38, 37, -112, 0, 0, 1, 104, -50, Ascii.SI, 19, 32, 0, 0, 1, 101, -120, -124, Ascii.CR, -50, 113, Ascii.CAN, -96, 0, 47, -65, Ascii.FS, TarConstants.LF_LINK, -61, 39, 93, TarConstants.LF_PAX_EXTENDED_HEADER_LC};
    private float zzA;
    @Nullable
    private ArrayDeque<zzoh> zzB;
    @Nullable
    private zzoi zzC;
    @Nullable
    private zzoh zzD;
    private int zzE;
    private boolean zzF;
    private boolean zzG;
    private boolean zzH;
    private boolean zzI;
    private boolean zzJ;
    private boolean zzK;
    private boolean zzL;
    private boolean zzM;
    private boolean zzN;
    private boolean zzO;
    @Nullable
    private zzoa zzP;
    private long zzQ;
    private int zzR;
    private int zzS;
    @Nullable
    private ByteBuffer zzT;
    private boolean zzU;
    private boolean zzV;
    private boolean zzW;
    private boolean zzX;
    private boolean zzY;
    private boolean zzZ;
    protected zzfy zza;
    private int zzaa;
    private int zzab;
    private int zzac;
    private boolean zzad;
    private boolean zzae;
    private boolean zzaf;
    private long zzag;
    private long zzah;
    private boolean zzai;
    private boolean zzaj;
    private boolean zzak;
    private long zzal;
    private long zzam;
    private int zzan;
    @Nullable
    private zznl zzao;
    @Nullable
    private zznl zzap;
    private final zzoe zzc;
    private final zzol zzd;
    private final float zze;
    private final zzda zzf = new zzda(0, 0);
    private final zzda zzg = new zzda(0, 0);
    private final zzda zzh = new zzda(2, 0);
    private final zznz zzi;
    private final zzfj<zzab> zzj;
    private final ArrayList<Long> zzk;
    private final MediaCodec.BufferInfo zzl;
    private final long[] zzm;
    private final long[] zzn;
    private final long[] zzo;
    @Nullable
    private zzab zzp;
    @Nullable
    private zzab zzq;
    @Nullable
    private MediaCrypto zzr;
    private boolean zzs;
    private long zzt;
    private float zzu;
    private float zzv;
    @Nullable
    private zzof zzw;
    @Nullable
    private zzab zzx;
    @Nullable
    private MediaFormat zzy;
    private boolean zzz;

    public zzoj(int i11, zzoe zzoe, zzol zzol, boolean z11, float f11) {
        super(i11);
        this.zzc = zzoe;
        zzol.getClass();
        this.zzd = zzol;
        this.zze = f11;
        zznz zznz = new zznz();
        this.zzi = zznz;
        this.zzj = new zzfj<>(10);
        this.zzk = new ArrayList<>();
        this.zzl = new MediaCodec.BufferInfo();
        this.zzu = 1.0f;
        this.zzv = 1.0f;
        this.zzt = C.TIME_UNSET;
        this.zzm = new long[10];
        this.zzn = new long[10];
        this.zzo = new long[10];
        this.zzal = C.TIME_UNSET;
        this.zzam = C.TIME_UNSET;
        zznz.zzi(0);
        zznz.zzb.order(ByteOrder.nativeOrder());
        this.zzA = -1.0f;
        this.zzE = 0;
        this.zzaa = 0;
        this.zzR = -1;
        this.zzS = -1;
        this.zzQ = C.TIME_UNSET;
        this.zzag = C.TIME_UNSET;
        this.zzah = C.TIME_UNSET;
        this.zzab = 0;
        this.zzac = 0;
    }

    private final void zzS() {
        this.zzY = false;
        this.zzi.zzb();
        this.zzh.zzb();
        this.zzX = false;
        this.zzW = false;
    }

    private final void zzT() throws zzgg {
        if (this.zzad) {
            this.zzab = 1;
            this.zzac = 3;
            return;
        }
        zzao();
        zzam();
    }

    private final boolean zzaA() throws zzgg {
        zzof zzof = this.zzw;
        if (zzof == null || this.zzab == 2 || this.zzai) {
            return false;
        }
        if (this.zzR < 0) {
            int zza2 = zzof.zza();
            this.zzR = zza2;
            if (zza2 < 0) {
                return false;
            }
            this.zzg.zzb = this.zzw.zzf(zza2);
            this.zzg.zzb();
        }
        if (this.zzab == 1) {
            if (!this.zzO) {
                this.zzae = true;
                this.zzw.zzj(this.zzR, 0, 0, 0, 4);
                zzaw();
            }
            this.zzab = 2;
            return false;
        } else if (this.zzM) {
            this.zzM = false;
            this.zzg.zzb.put(zzb);
            this.zzw.zzj(this.zzR, 0, 38, 0, 0);
            zzaw();
            this.zzad = true;
            return true;
        } else {
            if (this.zzaa == 1) {
                for (int i11 = 0; i11 < this.zzx.zzo.size(); i11++) {
                    this.zzg.zzb.put(this.zzx.zzo.get(i11));
                }
                this.zzaa = 2;
            }
            int position = this.zzg.zzb.position();
            zzhr zzh2 = zzh();
            try {
                int zzbn = zzbn(zzh2, this.zzg, 0);
                if (zzF()) {
                    this.zzah = this.zzag;
                }
                if (zzbn == -3) {
                    return false;
                }
                if (zzbn == -5) {
                    if (this.zzaa == 2) {
                        this.zzg.zzb();
                        this.zzaa = 1;
                    }
                    zzR(zzh2);
                    return true;
                } else if (this.zzg.zzg()) {
                    if (this.zzaa == 2) {
                        this.zzg.zzb();
                        this.zzaa = 1;
                    }
                    this.zzai = true;
                    if (!this.zzad) {
                        zzav();
                        return false;
                    }
                    try {
                        if (!this.zzO) {
                            this.zzae = true;
                            this.zzw.zzj(this.zzR, 0, 0, 0, 4);
                            zzaw();
                        }
                        return false;
                    } catch (MediaCodec.CryptoException e11) {
                        throw zzbo(e11, this.zzp, false, zzk.zzb(e11.getErrorCode()));
                    }
                } else if (this.zzad || this.zzg.zzh()) {
                    boolean zzk2 = this.zzg.zzk();
                    if (zzk2) {
                        this.zzg.zza.zzb(position);
                    }
                    if (this.zzF && !zzk2) {
                        ByteBuffer byteBuffer = this.zzg.zzb;
                        byte[] bArr = zzeu.zza;
                        int position2 = byteBuffer.position();
                        int i12 = 0;
                        int i13 = 0;
                        while (true) {
                            int i14 = i12 + 1;
                            if (i14 >= position2) {
                                byteBuffer.clear();
                                break;
                            }
                            byte b11 = byteBuffer.get(i12) & 255;
                            if (i13 == 3) {
                                if (b11 == 1) {
                                    if ((byteBuffer.get(i14) & Ascii.US) == 7) {
                                        ByteBuffer duplicate = byteBuffer.duplicate();
                                        duplicate.position(i12 - 3);
                                        duplicate.limit(position2);
                                        byteBuffer.position(0);
                                        byteBuffer.put(duplicate);
                                        break;
                                    }
                                    b11 = 1;
                                }
                            } else if (b11 == 0) {
                                i13++;
                            }
                            if (b11 != 0) {
                                i13 = 0;
                            }
                            i12 = i14;
                        }
                        if (this.zzg.zzb.position() == 0) {
                            return true;
                        }
                        this.zzF = false;
                    }
                    zzda zzda = this.zzg;
                    long j11 = zzda.zzd;
                    zzoa zzoa = this.zzP;
                    if (zzoa != null) {
                        j11 = zzoa.zzb(this.zzp, zzda);
                        this.zzag = Math.max(this.zzag, this.zzP.zza(this.zzp));
                    }
                    long j12 = j11;
                    if (this.zzg.zzf()) {
                        this.zzk.add(Long.valueOf(j12));
                    }
                    if (this.zzak) {
                        this.zzj.zzd(j12, this.zzp);
                        this.zzak = false;
                    }
                    this.zzag = Math.max(this.zzag, j12);
                    this.zzg.zzj();
                    if (this.zzg.zze()) {
                        zzal(this.zzg);
                    }
                    zzac(this.zzg);
                    if (zzk2) {
                        try {
                            this.zzw.zzk(this.zzR, 0, this.zzg.zza, j12, 0);
                        } catch (MediaCodec.CryptoException e12) {
                            throw zzbo(e12, this.zzp, false, zzk.zzb(e12.getErrorCode()));
                        }
                    } else {
                        this.zzw.zzj(this.zzR, 0, this.zzg.zzb.limit(), j12, 0);
                    }
                    zzaw();
                    this.zzad = true;
                    this.zzaa = 0;
                    this.zza.zzc++;
                    return true;
                } else {
                    this.zzg.zzb();
                    if (this.zzaa == 2) {
                        this.zzaa = 1;
                    }
                    return true;
                }
            } catch (zzcz e13) {
                zzW(e13);
                zzaC(0);
                zzaa();
                return true;
            }
        }
    }

    private final boolean zzaB() {
        return this.zzS >= 0;
    }

    private final boolean zzaC(int i11) throws zzgg {
        zzhr zzh2 = zzh();
        this.zzf.zzb();
        int zzbn = zzbn(zzh2, this.zzf, i11 | 4);
        if (zzbn == -5) {
            zzR(zzh2);
            return true;
        } else if (zzbn != -4 || !this.zzf.zzg()) {
            return false;
        } else {
            this.zzai = true;
            zzav();
            return false;
        }
    }

    private final boolean zzaD(long j11) {
        return this.zzt == C.TIME_UNSET || SystemClock.elapsedRealtime() - j11 < this.zzt;
    }

    private final boolean zzaE(zzab zzab2) throws zzgg {
        if (!(zzfn.zza < 23 || this.zzw == null || this.zzac == 3 || zzbm() == 0)) {
            float zzO2 = zzO(this.zzv, zzab2, zzI());
            float f11 = this.zzA;
            if (f11 == zzO2) {
                return true;
            }
            if (zzO2 == -1.0f) {
                zzT();
                return false;
            } else if (f11 == -1.0f && zzO2 <= this.zze) {
                return true;
            } else {
                Bundle bundle = new Bundle();
                bundle.putFloat("operating-rate", zzO2);
                this.zzw.zzp(bundle);
                this.zzA = zzO2;
            }
        }
        return true;
    }

    private final void zzaa() {
        try {
            this.zzw.zzi();
        } finally {
            zzap();
        }
    }

    public static boolean zzau(zzab zzab2) {
        return zzab2.zzF == 0;
    }

    @TargetApi(23)
    private final void zzav() throws zzgg {
        int i11 = this.zzac;
        if (i11 == 1) {
            zzaa();
        } else if (i11 == 2) {
            zzaa();
            zzay();
        } else if (i11 != 3) {
            this.zzaj = true;
            zzad();
        } else {
            zzao();
            zzam();
        }
    }

    private final void zzaw() {
        this.zzR = -1;
        this.zzg.zzb = null;
    }

    private final void zzax() {
        this.zzS = -1;
        this.zzT = null;
    }

    @RequiresApi(23)
    private final void zzay() throws zzgg {
        try {
            throw null;
        } catch (MediaCryptoException e11) {
            throw zzbo(e11, this.zzp, false, 6006);
        }
    }

    @TargetApi(23)
    private final boolean zzaz() throws zzgg {
        if (this.zzad) {
            this.zzab = 1;
            if (this.zzG || this.zzI) {
                this.zzac = 3;
                return false;
            }
            this.zzac = 2;
        } else {
            zzay();
        }
        return true;
    }

    public void zzC(float f11, float f12) throws zzgg {
        this.zzu = f11;
        this.zzv = f12;
        zzaE(this.zzx);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v11, resolved type: com.google.android.gms.internal.ads.zzoj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v6, resolved type: com.google.android.gms.internal.ads.zzoj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: com.google.android.gms.internal.ads.zzof} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v26, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v27, resolved type: com.google.android.gms.internal.ads.zzoj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v28, resolved type: android.media.MediaFormat} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v29, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v34, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v14, resolved type: com.google.android.gms.internal.ads.zzoj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v25, resolved type: com.google.android.gms.internal.ads.zzab} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v84, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v85, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v87, resolved type: com.google.android.gms.internal.ads.zzoj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v88, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v89, resolved type: com.google.android.gms.internal.ads.zzoj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v91, resolved type: com.google.android.gms.internal.ads.zzoj} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v92, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v93, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v94, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v95, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v96, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v34, resolved type: com.google.android.gms.internal.ads.zzab} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v35, resolved type: com.google.android.gms.internal.ads.zzoj} */
    /* JADX WARNING: type inference failed for: r19v0 */
    /* JADX WARNING: type inference failed for: r19v1 */
    /* JADX WARNING: type inference failed for: r19v3 */
    /* JADX WARNING: type inference failed for: r19v6 */
    /* JADX WARNING: type inference failed for: r19v16 */
    /* JADX WARNING: type inference failed for: r19v19 */
    /* JADX WARNING: type inference failed for: r19v20 */
    /* JADX WARNING: Can't wrap try/catch for region: R(7:178|179|180|181|182|(1:184)|185) */
    /* JADX WARNING: Can't wrap try/catch for region: R(9:94|95|(1:97)(0)|98|271|(1:206)|210|221|222) */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x0278, code lost:
        if (r15.zzq != null) goto L_0x027a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x02c4, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:?, code lost:
        zzav();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x02c7, code lost:
        r15 = r23;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x02c9, code lost:
        r19 = r19;
        r1 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x02cb, code lost:
        if (r15.zzaj != false) goto L_0x02cd;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x02cd, code lost:
        zzao();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x02d0, code lost:
        r1 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:187:0x02d4, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x02d5, code lost:
        r2 = true;
        r19 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x0342, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x0343, code lost:
        r1 = r15;
        r19 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x038d, code lost:
        r1.zzW(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0390, code lost:
        if (r3 < 21) goto L_0x03a1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x039f, code lost:
        r14 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x03a1, code lost:
        r14 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x03a3, code lost:
        if (r14 != false) goto L_0x03a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x03a5, code lost:
        zzao();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x03b6, code lost:
        throw r1.zzbo(r1.zzaj(r0, r1.zzD), r1.zzp, r14, com.google.android.exoplayer2.PlaybackException.ERROR_CODE_DECODING_FAILED);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0083, code lost:
        r14 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0084, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        r15.zzaj = true;
        r13 = false;
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x0130, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0131, code lost:
        r2 = true;
        r1 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x015f, code lost:
        r15 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:?, code lost:
        zzav();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x0164, code lost:
        if (r15.zzaj != false) goto L_0x0166;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x0166, code lost:
        zzao();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0169, code lost:
        r2 = r9;
        r19 = r13;
        r1 = r15;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:178:0x02c4 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:94:0x015f */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x0179 A[Catch:{ IllegalStateException -> 0x0368 }] */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x01bb A[Catch:{ IllegalStateException -> 0x0368 }] */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0300  */
    /* JADX WARNING: Removed duplicated region for block: B:204:0x0321 A[Catch:{ IllegalStateException -> 0x0365 }, LOOP:2: B:85:0x0148->B:204:0x0321, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:206:0x032d A[Catch:{ IllegalStateException -> 0x0365 }, LOOP:4: B:206:0x032d->B:209:0x0337, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:263:0x0320 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x032a A[SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzK(long r24, long r26) throws com.google.android.gms.internal.ads.zzgg {
        /*
            r23 = this;
            r15 = r23
            r14 = 1
            r13 = 0
            boolean r0 = r15.zzaj     // Catch:{ IllegalStateException -> 0x0368 }
            if (r0 == 0) goto L_0x000c
            r23.zzad()     // Catch:{ IllegalStateException -> 0x0368 }
            return
        L_0x000c:
            com.google.android.gms.internal.ads.zzab r0 = r15.zzp     // Catch:{ IllegalStateException -> 0x0368 }
            r11 = 2
            if (r0 != 0) goto L_0x0019
            boolean r0 = r15.zzaC(r11)     // Catch:{ IllegalStateException -> 0x0368 }
            if (r0 == 0) goto L_0x0018
            goto L_0x0019
        L_0x0018:
            return
        L_0x0019:
            r23.zzam()     // Catch:{ IllegalStateException -> 0x0368 }
            boolean r0 = r15.zzW     // Catch:{ IllegalStateException -> 0x0368 }
            if (r0 == 0) goto L_0x013b
            java.lang.String r0 = "bypassRender"
            com.google.android.gms.internal.ads.zzfl.zza(r0)     // Catch:{ IllegalStateException -> 0x0368 }
        L_0x0025:
            boolean r0 = r15.zzaj     // Catch:{ IllegalStateException -> 0x0368 }
            r0 = r0 ^ r14
            com.google.android.gms.internal.ads.zzdy.zzf(r0)     // Catch:{ IllegalStateException -> 0x0368 }
            com.google.android.gms.internal.ads.zznz r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0368 }
            boolean r0 = r0.zzp()     // Catch:{ IllegalStateException -> 0x0368 }
            if (r0 == 0) goto L_0x007f
            com.google.android.gms.internal.ads.zznz r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0368 }
            java.nio.ByteBuffer r7 = r0.zzb     // Catch:{ IllegalStateException -> 0x0368 }
            int r8 = r15.zzS     // Catch:{ IllegalStateException -> 0x0368 }
            int r10 = r0.zzl()     // Catch:{ IllegalStateException -> 0x0368 }
            com.google.android.gms.internal.ads.zznz r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0368 }
            long r11 = r0.zzd     // Catch:{ IllegalStateException -> 0x0368 }
            r6 = 0
            r9 = 0
            boolean r0 = r0.zzf()     // Catch:{ IllegalStateException -> 0x0368 }
            com.google.android.gms.internal.ads.zznz r1 = r15.zzi     // Catch:{ IllegalStateException -> 0x0368 }
            boolean r16 = r1.zzg()     // Catch:{ IllegalStateException -> 0x0368 }
            com.google.android.gms.internal.ads.zzab r4 = r15.zzq     // Catch:{ IllegalStateException -> 0x0368 }
            r1 = r23
            r2 = r24
            r17 = r4
            r4 = r26
            r13 = r0
            r14 = r16
            r15 = r17
            boolean r0 = r1.zzae(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ IllegalStateException -> 0x0079 }
            if (r0 == 0) goto L_0x0073
            r15 = r23
            com.google.android.gms.internal.ads.zznz r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0134 }
            long r0 = r0.zzm()     // Catch:{ IllegalStateException -> 0x0134 }
            r15.zzan(r0)     // Catch:{ IllegalStateException -> 0x0134 }
            com.google.android.gms.internal.ads.zznz r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0134 }
            r0.zzb()     // Catch:{ IllegalStateException -> 0x0134 }
            goto L_0x007f
        L_0x0073:
            r15 = r23
            r13 = 0
            r14 = 1
            goto L_0x0127
        L_0x0079:
            r0 = move-exception
            r2 = 1
            r19 = 0
            goto L_0x02d6
        L_0x007f:
            boolean r0 = r15.zzai     // Catch:{ IllegalStateException -> 0x0134 }
            if (r0 == 0) goto L_0x0089
            r14 = 1
            r15.zzaj = r14     // Catch:{ IllegalStateException -> 0x0130 }
            r13 = 0
            goto L_0x0127
        L_0x0089:
            r14 = 1
            boolean r0 = r15.zzX     // Catch:{ IllegalStateException -> 0x0130 }
            if (r0 == 0) goto L_0x009d
            com.google.android.gms.internal.ads.zznz r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0130 }
            com.google.android.gms.internal.ads.zzda r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x0130 }
            boolean r0 = r0.zzo(r1)     // Catch:{ IllegalStateException -> 0x0130 }
            com.google.android.gms.internal.ads.zzdy.zzf(r0)     // Catch:{ IllegalStateException -> 0x0130 }
            r13 = 0
            r15.zzX = r13     // Catch:{ IllegalStateException -> 0x0368 }
            goto L_0x009e
        L_0x009d:
            r13 = 0
        L_0x009e:
            boolean r0 = r15.zzY     // Catch:{ IllegalStateException -> 0x0368 }
            if (r0 == 0) goto L_0x00b6
            com.google.android.gms.internal.ads.zznz r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0368 }
            boolean r0 = r0.zzp()     // Catch:{ IllegalStateException -> 0x0368 }
            if (r0 != 0) goto L_0x0025
            r23.zzS()     // Catch:{ IllegalStateException -> 0x0368 }
            r15.zzY = r13     // Catch:{ IllegalStateException -> 0x0368 }
            r23.zzam()     // Catch:{ IllegalStateException -> 0x0368 }
            boolean r0 = r15.zzW     // Catch:{ IllegalStateException -> 0x0368 }
            if (r0 == 0) goto L_0x0127
        L_0x00b6:
            boolean r0 = r15.zzai     // Catch:{ IllegalStateException -> 0x0368 }
            r0 = r0 ^ r14
            com.google.android.gms.internal.ads.zzdy.zzf(r0)     // Catch:{ IllegalStateException -> 0x0368 }
            com.google.android.gms.internal.ads.zzhr r0 = r23.zzh()     // Catch:{ IllegalStateException -> 0x0368 }
            com.google.android.gms.internal.ads.zzda r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x0368 }
            r1.zzb()     // Catch:{ IllegalStateException -> 0x0368 }
        L_0x00c5:
            com.google.android.gms.internal.ads.zzda r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x0368 }
            r1.zzb()     // Catch:{ IllegalStateException -> 0x0368 }
            com.google.android.gms.internal.ads.zzda r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x0368 }
            int r1 = r15.zzbn(r0, r1, r13)     // Catch:{ IllegalStateException -> 0x0368 }
            r2 = -5
            if (r1 == r2) goto L_0x0105
            r2 = -4
            if (r1 == r2) goto L_0x00d7
            goto L_0x0108
        L_0x00d7:
            com.google.android.gms.internal.ads.zzda r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x0368 }
            boolean r1 = r1.zzg()     // Catch:{ IllegalStateException -> 0x0368 }
            if (r1 == 0) goto L_0x00e2
            r15.zzai = r14     // Catch:{ IllegalStateException -> 0x0368 }
            goto L_0x0108
        L_0x00e2:
            boolean r1 = r15.zzak     // Catch:{ IllegalStateException -> 0x0368 }
            if (r1 == 0) goto L_0x00f3
            com.google.android.gms.internal.ads.zzab r1 = r15.zzp     // Catch:{ IllegalStateException -> 0x0368 }
            r1.getClass()
            r15.zzq = r1     // Catch:{ IllegalStateException -> 0x0368 }
            r2 = 0
            r15.zzZ(r1, r2)     // Catch:{ IllegalStateException -> 0x0368 }
            r15.zzak = r13     // Catch:{ IllegalStateException -> 0x0368 }
        L_0x00f3:
            com.google.android.gms.internal.ads.zzda r1 = r15.zzh     // Catch:{ IllegalStateException -> 0x0368 }
            r1.zzj()     // Catch:{ IllegalStateException -> 0x0368 }
            com.google.android.gms.internal.ads.zznz r1 = r15.zzi     // Catch:{ IllegalStateException -> 0x0368 }
            com.google.android.gms.internal.ads.zzda r2 = r15.zzh     // Catch:{ IllegalStateException -> 0x0368 }
            boolean r1 = r1.zzo(r2)     // Catch:{ IllegalStateException -> 0x0368 }
            if (r1 != 0) goto L_0x00c5
            r15.zzX = r14     // Catch:{ IllegalStateException -> 0x0368 }
            goto L_0x0108
        L_0x0105:
            r15.zzR(r0)     // Catch:{ IllegalStateException -> 0x0368 }
        L_0x0108:
            com.google.android.gms.internal.ads.zznz r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0368 }
            boolean r0 = r0.zzp()     // Catch:{ IllegalStateException -> 0x0368 }
            if (r0 == 0) goto L_0x0115
            com.google.android.gms.internal.ads.zznz r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0368 }
            r0.zzj()     // Catch:{ IllegalStateException -> 0x0368 }
        L_0x0115:
            com.google.android.gms.internal.ads.zznz r0 = r15.zzi     // Catch:{ IllegalStateException -> 0x0368 }
            boolean r0 = r0.zzp()     // Catch:{ IllegalStateException -> 0x0368 }
            if (r0 != 0) goto L_0x0025
            boolean r0 = r15.zzai     // Catch:{ IllegalStateException -> 0x0368 }
            if (r0 != 0) goto L_0x0025
            boolean r0 = r15.zzY     // Catch:{ IllegalStateException -> 0x0368 }
            if (r0 == 0) goto L_0x0127
            goto L_0x0025
        L_0x0127:
            com.google.android.gms.internal.ads.zzfl.zzb()     // Catch:{ IllegalStateException -> 0x0368 }
            r19 = r13
            r2 = r14
            r1 = r15
            goto L_0x035d
        L_0x0130:
            r0 = move-exception
            r2 = r14
            r1 = r15
            goto L_0x0137
        L_0x0134:
            r0 = move-exception
            r1 = r15
            r2 = 1
        L_0x0137:
            r19 = 0
            goto L_0x036d
        L_0x013b:
            com.google.android.gms.internal.ads.zzof r0 = r15.zzw     // Catch:{ IllegalStateException -> 0x0368 }
            if (r0 == 0) goto L_0x034b
            long r9 = android.os.SystemClock.elapsedRealtime()     // Catch:{ IllegalStateException -> 0x0345 }
            java.lang.String r0 = "drainAndFeed"
            com.google.android.gms.internal.ads.zzfl.zza(r0)     // Catch:{ IllegalStateException -> 0x0345 }
        L_0x0148:
            boolean r0 = r23.zzaB()     // Catch:{ IllegalStateException -> 0x0345 }
            if (r0 != 0) goto L_0x0283
            boolean r0 = r15.zzJ     // Catch:{ IllegalStateException -> 0x0368 }
            if (r0 == 0) goto L_0x016f
            boolean r0 = r15.zzae     // Catch:{ IllegalStateException -> 0x0368 }
            if (r0 == 0) goto L_0x016f
            com.google.android.gms.internal.ads.zzof r0 = r15.zzw     // Catch:{ IllegalStateException -> 0x015f }
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x015f }
            int r0 = r0.zzb(r1)     // Catch:{ IllegalStateException -> 0x015f }
            goto L_0x0177
        L_0x015f:
            r23.zzav()     // Catch:{ IllegalStateException -> 0x0368 }
            boolean r0 = r15.zzaj     // Catch:{ IllegalStateException -> 0x0368 }
            if (r0 == 0) goto L_0x0169
            r23.zzao()     // Catch:{ IllegalStateException -> 0x0368 }
        L_0x0169:
            r2 = r9
            r19 = r13
            r1 = r15
            goto L_0x032d
        L_0x016f:
            com.google.android.gms.internal.ads.zzof r0 = r15.zzw     // Catch:{ IllegalStateException -> 0x0368 }
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x0368 }
            int r0 = r0.zzb(r1)     // Catch:{ IllegalStateException -> 0x0368 }
        L_0x0177:
            if (r0 >= 0) goto L_0x01bb
            r1 = -2
            if (r0 != r1) goto L_0x01ab
            r15.zzaf = r14     // Catch:{ IllegalStateException -> 0x0368 }
            com.google.android.gms.internal.ads.zzof r0 = r15.zzw     // Catch:{ IllegalStateException -> 0x0368 }
            android.media.MediaFormat r0 = r0.zzc()     // Catch:{ IllegalStateException -> 0x0368 }
            int r1 = r15.zzE     // Catch:{ IllegalStateException -> 0x0368 }
            if (r1 == 0) goto L_0x019d
            java.lang.String r1 = "width"
            int r1 = r0.getInteger(r1)     // Catch:{ IllegalStateException -> 0x0368 }
            r2 = 32
            if (r1 != r2) goto L_0x019d
            java.lang.String r1 = "height"
            int r1 = r0.getInteger(r1)     // Catch:{ IllegalStateException -> 0x0368 }
            if (r1 != r2) goto L_0x019d
            r15.zzN = r14     // Catch:{ IllegalStateException -> 0x0368 }
            goto L_0x01c6
        L_0x019d:
            boolean r1 = r15.zzL     // Catch:{ IllegalStateException -> 0x0368 }
            if (r1 == 0) goto L_0x01a6
            java.lang.String r1 = "channel-count"
            r0.setInteger(r1, r14)     // Catch:{ IllegalStateException -> 0x0368 }
        L_0x01a6:
            r15.zzy = r0     // Catch:{ IllegalStateException -> 0x0368 }
            r15.zzz = r14     // Catch:{ IllegalStateException -> 0x0368 }
            goto L_0x01c6
        L_0x01ab:
            boolean r0 = r15.zzO     // Catch:{ IllegalStateException -> 0x0368 }
            if (r0 == 0) goto L_0x0169
            boolean r0 = r15.zzai     // Catch:{ IllegalStateException -> 0x0368 }
            if (r0 != 0) goto L_0x01b7
            int r0 = r15.zzab     // Catch:{ IllegalStateException -> 0x0368 }
            if (r0 != r11) goto L_0x0169
        L_0x01b7:
            r23.zzav()     // Catch:{ IllegalStateException -> 0x0368 }
            goto L_0x0169
        L_0x01bb:
            boolean r1 = r15.zzN     // Catch:{ IllegalStateException -> 0x0368 }
            if (r1 == 0) goto L_0x01ce
            r15.zzN = r13     // Catch:{ IllegalStateException -> 0x0368 }
            com.google.android.gms.internal.ads.zzof r1 = r15.zzw     // Catch:{ IllegalStateException -> 0x0368 }
            r1.zzn(r0, r13)     // Catch:{ IllegalStateException -> 0x0368 }
        L_0x01c6:
            r2 = r9
            r16 = r11
            r19 = r13
            r1 = r15
            goto L_0x031a
        L_0x01ce:
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x0368 }
            int r2 = r1.size     // Catch:{ IllegalStateException -> 0x0368 }
            if (r2 != 0) goto L_0x01de
            int r1 = r1.flags     // Catch:{ IllegalStateException -> 0x0368 }
            r1 = r1 & 4
            if (r1 == 0) goto L_0x01de
            r23.zzav()     // Catch:{ IllegalStateException -> 0x0368 }
            goto L_0x0169
        L_0x01de:
            r15.zzS = r0     // Catch:{ IllegalStateException -> 0x0368 }
            com.google.android.gms.internal.ads.zzof r1 = r15.zzw     // Catch:{ IllegalStateException -> 0x0368 }
            java.nio.ByteBuffer r0 = r1.zzg(r0)     // Catch:{ IllegalStateException -> 0x0368 }
            r15.zzT = r0     // Catch:{ IllegalStateException -> 0x0368 }
            if (r0 == 0) goto L_0x01fd
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x0368 }
            int r1 = r1.offset     // Catch:{ IllegalStateException -> 0x0368 }
            r0.position(r1)     // Catch:{ IllegalStateException -> 0x0368 }
            java.nio.ByteBuffer r0 = r15.zzT     // Catch:{ IllegalStateException -> 0x0368 }
            android.media.MediaCodec$BufferInfo r1 = r15.zzl     // Catch:{ IllegalStateException -> 0x0368 }
            int r2 = r1.offset     // Catch:{ IllegalStateException -> 0x0368 }
            int r1 = r1.size     // Catch:{ IllegalStateException -> 0x0368 }
            int r2 = r2 + r1
            r0.limit(r2)     // Catch:{ IllegalStateException -> 0x0368 }
        L_0x01fd:
            boolean r0 = r15.zzK     // Catch:{ IllegalStateException -> 0x0368 }
            if (r0 == 0) goto L_0x021e
            android.media.MediaCodec$BufferInfo r0 = r15.zzl     // Catch:{ IllegalStateException -> 0x0368 }
            long r1 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0368 }
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x021e
            int r1 = r0.flags     // Catch:{ IllegalStateException -> 0x0368 }
            r1 = r1 & 4
            if (r1 == 0) goto L_0x021e
            long r1 = r15.zzag     // Catch:{ IllegalStateException -> 0x0368 }
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x021e
            r0.presentationTimeUs = r1     // Catch:{ IllegalStateException -> 0x0368 }
        L_0x021e:
            android.media.MediaCodec$BufferInfo r0 = r15.zzl     // Catch:{ IllegalStateException -> 0x0368 }
            long r0 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0368 }
            java.util.ArrayList<java.lang.Long> r2 = r15.zzk     // Catch:{ IllegalStateException -> 0x0368 }
            int r2 = r2.size()     // Catch:{ IllegalStateException -> 0x0368 }
            r3 = r13
        L_0x0229:
            if (r3 >= r2) goto L_0x0245
            java.util.ArrayList<java.lang.Long> r4 = r15.zzk     // Catch:{ IllegalStateException -> 0x0368 }
            java.lang.Object r4 = r4.get(r3)     // Catch:{ IllegalStateException -> 0x0368 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ IllegalStateException -> 0x0368 }
            long r4 = r4.longValue()     // Catch:{ IllegalStateException -> 0x0368 }
            int r4 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r4 != 0) goto L_0x0242
            java.util.ArrayList<java.lang.Long> r0 = r15.zzk     // Catch:{ IllegalStateException -> 0x0368 }
            r0.remove(r3)     // Catch:{ IllegalStateException -> 0x0368 }
            r0 = r14
            goto L_0x0246
        L_0x0242:
            int r3 = r3 + 1
            goto L_0x0229
        L_0x0245:
            r0 = r13
        L_0x0246:
            r15.zzU = r0     // Catch:{ IllegalStateException -> 0x0368 }
            long r0 = r15.zzah     // Catch:{ IllegalStateException -> 0x0368 }
            android.media.MediaCodec$BufferInfo r2 = r15.zzl     // Catch:{ IllegalStateException -> 0x0368 }
            long r2 = r2.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0368 }
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L_0x0254
            r0 = r14
            goto L_0x0255
        L_0x0254:
            r0 = r13
        L_0x0255:
            r15.zzV = r0     // Catch:{ IllegalStateException -> 0x0368 }
            com.google.android.gms.internal.ads.zzfj<com.google.android.gms.internal.ads.zzab> r0 = r15.zzj     // Catch:{ IllegalStateException -> 0x0368 }
            java.lang.Object r0 = r0.zzc(r2)     // Catch:{ IllegalStateException -> 0x0368 }
            com.google.android.gms.internal.ads.zzab r0 = (com.google.android.gms.internal.ads.zzab) r0     // Catch:{ IllegalStateException -> 0x0368 }
            if (r0 != 0) goto L_0x026d
            boolean r1 = r15.zzz     // Catch:{ IllegalStateException -> 0x0368 }
            if (r1 == 0) goto L_0x026d
            com.google.android.gms.internal.ads.zzfj<com.google.android.gms.internal.ads.zzab> r0 = r15.zzj     // Catch:{ IllegalStateException -> 0x0368 }
            java.lang.Object r0 = r0.zzb()     // Catch:{ IllegalStateException -> 0x0368 }
            com.google.android.gms.internal.ads.zzab r0 = (com.google.android.gms.internal.ads.zzab) r0     // Catch:{ IllegalStateException -> 0x0368 }
        L_0x026d:
            if (r0 == 0) goto L_0x0272
            r15.zzq = r0     // Catch:{ IllegalStateException -> 0x0368 }
            goto L_0x027a
        L_0x0272:
            boolean r0 = r15.zzz     // Catch:{ IllegalStateException -> 0x0368 }
            if (r0 == 0) goto L_0x0283
            com.google.android.gms.internal.ads.zzab r0 = r15.zzq     // Catch:{ IllegalStateException -> 0x0368 }
            if (r0 == 0) goto L_0x0283
        L_0x027a:
            com.google.android.gms.internal.ads.zzab r0 = r15.zzq     // Catch:{ IllegalStateException -> 0x0368 }
            android.media.MediaFormat r1 = r15.zzy     // Catch:{ IllegalStateException -> 0x0368 }
            r15.zzZ(r0, r1)     // Catch:{ IllegalStateException -> 0x0368 }
            r15.zzz = r13     // Catch:{ IllegalStateException -> 0x0368 }
        L_0x0283:
            boolean r0 = r15.zzJ     // Catch:{ IllegalStateException -> 0x0345 }
            if (r0 == 0) goto L_0x02da
            boolean r0 = r15.zzae     // Catch:{ IllegalStateException -> 0x0368 }
            if (r0 == 0) goto L_0x02da
            com.google.android.gms.internal.ads.zzof r6 = r15.zzw     // Catch:{ IllegalStateException -> 0x02c0 }
            java.nio.ByteBuffer r7 = r15.zzT     // Catch:{ IllegalStateException -> 0x02c0 }
            int r8 = r15.zzS     // Catch:{ IllegalStateException -> 0x02c0 }
            android.media.MediaCodec$BufferInfo r0 = r15.zzl     // Catch:{ IllegalStateException -> 0x02c0 }
            int r12 = r0.flags     // Catch:{ IllegalStateException -> 0x02c0 }
            r16 = 1
            long r4 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x02c0 }
            boolean r0 = r15.zzU     // Catch:{ IllegalStateException -> 0x02c0 }
            boolean r2 = r15.zzV     // Catch:{ IllegalStateException -> 0x02c0 }
            com.google.android.gms.internal.ads.zzab r3 = r15.zzq     // Catch:{ IllegalStateException -> 0x02c0 }
            r1 = r23
            r17 = r2
            r18 = r3
            r2 = r24
            r19 = r4
            r4 = r26
            r21 = r9
            r9 = r12
            r10 = r16
            r16 = r11
            r11 = r19
            r19 = r13
            r13 = r0
            r14 = r17
            r15 = r18
            boolean r0 = r1.zzae(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ IllegalStateException -> 0x02c4 }
            goto L_0x02fe
        L_0x02c0:
            r21 = r9
            r19 = r13
        L_0x02c4:
            r23.zzav()     // Catch:{ IllegalStateException -> 0x02d4 }
            r15 = r23
            boolean r0 = r15.zzaj     // Catch:{ IllegalStateException -> 0x0342 }
            if (r0 == 0) goto L_0x02d0
            r23.zzao()     // Catch:{ IllegalStateException -> 0x0342 }
        L_0x02d0:
            r1 = r15
        L_0x02d1:
            r2 = r21
            goto L_0x032d
        L_0x02d4:
            r0 = move-exception
            r2 = 1
        L_0x02d6:
            r1 = r23
            goto L_0x036d
        L_0x02da:
            r21 = r9
            r16 = r11
            r19 = r13
            com.google.android.gms.internal.ads.zzof r6 = r15.zzw     // Catch:{ IllegalStateException -> 0x0342 }
            java.nio.ByteBuffer r7 = r15.zzT     // Catch:{ IllegalStateException -> 0x0342 }
            int r8 = r15.zzS     // Catch:{ IllegalStateException -> 0x0342 }
            android.media.MediaCodec$BufferInfo r0 = r15.zzl     // Catch:{ IllegalStateException -> 0x0342 }
            int r9 = r0.flags     // Catch:{ IllegalStateException -> 0x0342 }
            r10 = 1
            long r11 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0342 }
            boolean r13 = r15.zzU     // Catch:{ IllegalStateException -> 0x0342 }
            boolean r14 = r15.zzV     // Catch:{ IllegalStateException -> 0x0342 }
            com.google.android.gms.internal.ads.zzab r0 = r15.zzq     // Catch:{ IllegalStateException -> 0x0342 }
            r1 = r23
            r2 = r24
            r4 = r26
            r15 = r0
            boolean r0 = r1.zzae(r2, r4, r6, r7, r8, r9, r10, r11, r13, r14, r15)     // Catch:{ IllegalStateException -> 0x033e }
        L_0x02fe:
            if (r0 == 0) goto L_0x032a
            r1 = r23
            android.media.MediaCodec$BufferInfo r0 = r1.zzl     // Catch:{ IllegalStateException -> 0x0365 }
            long r2 = r0.presentationTimeUs     // Catch:{ IllegalStateException -> 0x0365 }
            r1.zzan(r2)     // Catch:{ IllegalStateException -> 0x0365 }
            android.media.MediaCodec$BufferInfo r0 = r1.zzl     // Catch:{ IllegalStateException -> 0x0365 }
            int r0 = r0.flags     // Catch:{ IllegalStateException -> 0x0365 }
            r23.zzax()     // Catch:{ IllegalStateException -> 0x0365 }
            r0 = r0 & 4
            if (r0 == 0) goto L_0x0318
            r23.zzav()     // Catch:{ IllegalStateException -> 0x0365 }
            goto L_0x02d1
        L_0x0318:
            r2 = r21
        L_0x031a:
            boolean r0 = r1.zzaD(r2)     // Catch:{ IllegalStateException -> 0x0365 }
            if (r0 != 0) goto L_0x0321
            goto L_0x032d
        L_0x0321:
            r15 = r1
            r9 = r2
            r11 = r16
            r13 = r19
            r14 = 1
            goto L_0x0148
        L_0x032a:
            r1 = r23
            goto L_0x02d1
        L_0x032d:
            boolean r0 = r23.zzaA()     // Catch:{ IllegalStateException -> 0x0365 }
            if (r0 == 0) goto L_0x0339
            boolean r0 = r1.zzaD(r2)     // Catch:{ IllegalStateException -> 0x0365 }
            if (r0 != 0) goto L_0x032d
        L_0x0339:
            com.google.android.gms.internal.ads.zzfl.zzb()     // Catch:{ IllegalStateException -> 0x0365 }
            r2 = 1
            goto L_0x035d
        L_0x033e:
            r0 = move-exception
            r1 = r23
            goto L_0x0366
        L_0x0342:
            r0 = move-exception
            r1 = r15
            goto L_0x0366
        L_0x0345:
            r0 = move-exception
            r19 = r13
            r1 = r15
            r2 = r14
            goto L_0x036d
        L_0x034b:
            r19 = r13
            r1 = r15
            com.google.android.gms.internal.ads.zzfy r0 = r1.zza     // Catch:{ IllegalStateException -> 0x0365 }
            int r2 = r0.zzd     // Catch:{ IllegalStateException -> 0x0365 }
            int r3 = r23.zzd(r24)     // Catch:{ IllegalStateException -> 0x0365 }
            int r2 = r2 + r3
            r0.zzd = r2     // Catch:{ IllegalStateException -> 0x0365 }
            r2 = 1
            r1.zzaC(r2)     // Catch:{ IllegalStateException -> 0x0363 }
        L_0x035d:
            com.google.android.gms.internal.ads.zzfy r0 = r1.zza     // Catch:{ IllegalStateException -> 0x0363 }
            r0.zza()     // Catch:{ IllegalStateException -> 0x0363 }
            return
        L_0x0363:
            r0 = move-exception
            goto L_0x036d
        L_0x0365:
            r0 = move-exception
        L_0x0366:
            r2 = 1
            goto L_0x036d
        L_0x0368:
            r0 = move-exception
            r19 = r13
            r2 = r14
            r1 = r15
        L_0x036d:
            int r3 = com.google.android.gms.internal.ads.zzfn.zza
            r4 = 21
            if (r3 < r4) goto L_0x0378
            boolean r5 = r0 instanceof android.media.MediaCodec.CodecException
            if (r5 == 0) goto L_0x0378
            goto L_0x038d
        L_0x0378:
            java.lang.StackTraceElement[] r5 = r0.getStackTrace()
            int r6 = r5.length
            if (r6 <= 0) goto L_0x03b7
            r5 = r5[r19]
            java.lang.String r5 = r5.getClassName()
            java.lang.String r6 = "android.media.MediaCodec"
            boolean r5 = r5.equals(r6)
            if (r5 == 0) goto L_0x03b7
        L_0x038d:
            r1.zzW(r0)
            if (r3 < r4) goto L_0x03a1
            boolean r3 = r0 instanceof android.media.MediaCodec.CodecException
            if (r3 == 0) goto L_0x03a1
            r3 = r0
            android.media.MediaCodec$CodecException r3 = (android.media.MediaCodec.CodecException) r3
            boolean r3 = r3.isRecoverable()
            if (r3 == 0) goto L_0x03a1
            r14 = r2
            goto L_0x03a3
        L_0x03a1:
            r14 = r19
        L_0x03a3:
            if (r14 == 0) goto L_0x03a8
            r23.zzao()
        L_0x03a8:
            com.google.android.gms.internal.ads.zzoh r2 = r1.zzD
            com.google.android.gms.internal.ads.zzog r0 = r1.zzaj(r0, r2)
            com.google.android.gms.internal.ads.zzab r2 = r1.zzp
            r3 = 4003(0xfa3, float:5.61E-42)
            com.google.android.gms.internal.ads.zzgg r0 = r1.zzbo(r0, r2, r14, r3)
            throw r0
        L_0x03b7:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoj.zzK(long, long):void");
    }

    public boolean zzL() {
        return this.zzaj;
    }

    public boolean zzM() {
        if (this.zzp == null) {
            return false;
        }
        if (zzH() || zzaB()) {
            return true;
        }
        if (this.zzQ == C.TIME_UNSET || SystemClock.elapsedRealtime() >= this.zzQ) {
            return false;
        }
        return true;
    }

    public final int zzN(zzab zzab2) throws zzgg {
        try {
            return zzP(this.zzd, zzab2);
        } catch (zzos e11) {
            throw zzbo(e11, zzab2, false, PlaybackException.ERROR_CODE_DECODER_QUERY_FAILED);
        }
    }

    public float zzO(float f11, zzab zzab2, zzab[] zzabArr) {
        throw null;
    }

    public abstract int zzP(zzol zzol, zzab zzab2) throws zzos;

    public zzfz zzQ(zzoh zzoh, zzab zzab2, zzab zzab3) {
        throw null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005b, code lost:
        if (zzaz() == false) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0087, code lost:
        if (zzaz() == false) goto L_0x009c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x009a, code lost:
        if (zzaz() == false) goto L_0x009c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c3  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cf A[RETURN] */
    @androidx.annotation.CallSuper
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.android.gms.internal.ads.zzfz zzR(com.google.android.gms.internal.ads.zzhr r13) throws com.google.android.gms.internal.ads.zzgg {
        /*
            r12 = this;
            r0 = 1
            r12.zzak = r0
            com.google.android.gms.internal.ads.zzab r4 = r13.zza
            r4.getClass()
            java.lang.String r1 = r4.zzm
            r2 = 0
            if (r1 == 0) goto L_0x00f7
            com.google.android.gms.internal.ads.zznl r13 = r13.zzb
            r12.zzap = r13
            r12.zzp = r4
            boolean r1 = r12.zzW
            r3 = 0
            if (r1 == 0) goto L_0x001b
            r12.zzY = r0
            return r3
        L_0x001b:
            com.google.android.gms.internal.ads.zzof r1 = r12.zzw
            if (r1 != 0) goto L_0x0025
            r12.zzB = r3
            r12.zzam()
            return r3
        L_0x0025:
            com.google.android.gms.internal.ads.zzoh r3 = r12.zzD
            com.google.android.gms.internal.ads.zzab r5 = r12.zzx
            com.google.android.gms.internal.ads.zznl r6 = r12.zzao
            r7 = 23
            if (r6 != r13) goto L_0x00d0
            if (r13 == r6) goto L_0x0038
            int r8 = com.google.android.gms.internal.ads.zzfn.zza
            if (r8 < r7) goto L_0x0036
            goto L_0x0038
        L_0x0036:
            r7 = r2
            goto L_0x0039
        L_0x0038:
            r7 = r0
        L_0x0039:
            com.google.android.gms.internal.ads.zzdy.zzf(r7)
            com.google.android.gms.internal.ads.zzfz r7 = r12.zzQ(r3, r5, r4)
            int r8 = r7.zzd
            r9 = 3
            if (r8 == 0) goto L_0x00b3
            r10 = 16
            r11 = 2
            if (r8 == r0) goto L_0x008a
            if (r8 == r11) goto L_0x005e
            boolean r0 = r12.zzaE(r4)
            if (r0 != 0) goto L_0x0053
            goto L_0x0090
        L_0x0053:
            r12.zzx = r4
            if (r13 == r6) goto L_0x00b6
            boolean r13 = r12.zzaz()
            if (r13 != 0) goto L_0x00b6
            goto L_0x009c
        L_0x005e:
            boolean r8 = r12.zzaE(r4)
            if (r8 != 0) goto L_0x0065
            goto L_0x0090
        L_0x0065:
            r12.zzZ = r0
            r12.zzaa = r0
            int r8 = r12.zzE
            if (r8 == r11) goto L_0x007d
            if (r8 != r0) goto L_0x007c
            int r8 = r4.zzr
            int r10 = r5.zzr
            if (r8 != r10) goto L_0x007c
            int r8 = r4.zzs
            int r10 = r5.zzs
            if (r8 != r10) goto L_0x007c
            goto L_0x007d
        L_0x007c:
            r0 = r2
        L_0x007d:
            r12.zzM = r0
            r12.zzx = r4
            if (r13 == r6) goto L_0x00b6
            boolean r13 = r12.zzaz()
            if (r13 != 0) goto L_0x00b6
            goto L_0x009c
        L_0x008a:
            boolean r8 = r12.zzaE(r4)
            if (r8 != 0) goto L_0x0092
        L_0x0090:
            r6 = r10
            goto L_0x00b7
        L_0x0092:
            r12.zzx = r4
            if (r13 == r6) goto L_0x009e
            boolean r13 = r12.zzaz()
            if (r13 != 0) goto L_0x00b6
        L_0x009c:
            r6 = r11
            goto L_0x00b7
        L_0x009e:
            boolean r13 = r12.zzad
            if (r13 == 0) goto L_0x00b6
            r12.zzab = r0
            boolean r13 = r12.zzG
            if (r13 != 0) goto L_0x00b0
            boolean r13 = r12.zzI
            if (r13 == 0) goto L_0x00ad
            goto L_0x00b0
        L_0x00ad:
            r12.zzac = r0
            goto L_0x00b6
        L_0x00b0:
            r12.zzac = r9
            goto L_0x009c
        L_0x00b3:
            r12.zzT()
        L_0x00b6:
            r6 = r2
        L_0x00b7:
            int r13 = r7.zzd
            if (r13 == 0) goto L_0x00cf
            com.google.android.gms.internal.ads.zzof r13 = r12.zzw
            if (r13 != r1) goto L_0x00c3
            int r13 = r12.zzac
            if (r13 != r9) goto L_0x00cf
        L_0x00c3:
            com.google.android.gms.internal.ads.zzfz r13 = new com.google.android.gms.internal.ads.zzfz
            java.lang.String r2 = r3.zza
            r0 = 0
            r1 = r13
            r3 = r5
            r5 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            return r13
        L_0x00cf:
            return r7
        L_0x00d0:
            if (r13 == 0) goto L_0x00e6
            if (r6 != 0) goto L_0x00d5
            goto L_0x00e6
        L_0x00d5:
            int r13 = com.google.android.gms.internal.ads.zzfn.zza
            if (r13 < r7) goto L_0x00e6
            java.util.UUID r13 = com.google.android.gms.internal.ads.zzk.zze
            java.util.UUID r0 = com.google.android.gms.internal.ads.zzk.zza
            boolean r1 = r13.equals(r0)
            if (r1 != 0) goto L_0x00e6
            r13.equals(r0)
        L_0x00e6:
            r12.zzT()
            com.google.android.gms.internal.ads.zzfz r13 = new com.google.android.gms.internal.ads.zzfz
            java.lang.String r2 = r3.zza
            r0 = 0
            r6 = 128(0x80, float:1.794E-43)
            r1 = r13
            r3 = r5
            r5 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            return r13
        L_0x00f7:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            r13.<init>()
            r0 = 4005(0xfa5, float:5.612E-42)
            com.google.android.gms.internal.ads.zzgg r13 = r12.zzbo(r13, r4, r2, r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoj.zzR(com.google.android.gms.internal.ads.zzhr):com.google.android.gms.internal.ads.zzfz");
    }

    public abstract zzod zzU(zzoh zzoh, zzab zzab2, @Nullable MediaCrypto mediaCrypto, float f11);

    public abstract List<zzoh> zzV(zzol zzol, zzab zzab2, boolean z11) throws zzos;

    public void zzW(Exception exc) {
        throw null;
    }

    public void zzX(String str, long j11, long j12) {
        throw null;
    }

    public void zzY(String str) {
        throw null;
    }

    public void zzZ(zzab zzab2, @Nullable MediaFormat mediaFormat) throws zzgg {
        throw null;
    }

    public void zzab() {
    }

    public void zzac(zzda zzda) throws zzgg {
        throw null;
    }

    public void zzad() throws zzgg {
    }

    public abstract boolean zzae(long j11, long j12, @Nullable zzof zzof, @Nullable ByteBuffer byteBuffer, int i11, int i12, int i13, long j13, boolean z11, boolean z12, zzab zzab2) throws zzgg;

    public boolean zzaf(zzab zzab2) {
        return false;
    }

    public final float zzag() {
        return this.zzu;
    }

    public final long zzah() {
        return this.zzam;
    }

    @Nullable
    public final zzof zzai() {
        return this.zzw;
    }

    public zzog zzaj(Throwable th2, @Nullable zzoh zzoh) {
        return new zzog(th2, zzoh);
    }

    @Nullable
    public final zzoh zzak() {
        return this.zzD;
    }

    public void zzal(zzda zzda) throws zzgg {
    }

    /* JADX WARNING: type inference failed for: r10v0 */
    /* JADX WARNING: type inference failed for: r10v1, types: [com.google.android.gms.internal.ads.zzoz, android.view.Surface, android.media.MediaCrypto] */
    /* JADX WARNING: type inference failed for: r10v2 */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0201 A[Catch:{ Exception -> 0x0382, zzos -> 0x0090, zzoi -> 0x03cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0203 A[Catch:{ Exception -> 0x0382, zzos -> 0x0090, zzoi -> 0x03cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0232 A[Catch:{ Exception -> 0x0382, zzos -> 0x0090, zzoi -> 0x03cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x024a A[Catch:{ Exception -> 0x0382, zzos -> 0x0090, zzoi -> 0x03cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x024c A[Catch:{ Exception -> 0x0382, zzos -> 0x0090, zzoi -> 0x03cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x0251 A[Catch:{ Exception -> 0x0382, zzos -> 0x0090, zzoi -> 0x03cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x025e A[Catch:{ Exception -> 0x0382, zzos -> 0x0090, zzoi -> 0x03cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x028e A[Catch:{ Exception -> 0x0382, zzos -> 0x0090, zzoi -> 0x03cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0290 A[Catch:{ Exception -> 0x0382, zzos -> 0x0090, zzoi -> 0x03cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:192:0x02ee A[Catch:{ Exception -> 0x0382, zzos -> 0x0090, zzoi -> 0x03cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:193:0x02f0 A[Catch:{ Exception -> 0x0382, zzos -> 0x0090, zzoi -> 0x03cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:196:0x02f9 A[Catch:{ Exception -> 0x0382, zzos -> 0x0090, zzoi -> 0x03cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:215:0x033a A[Catch:{ Exception -> 0x0382, zzos -> 0x0090, zzoi -> 0x03cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:216:0x033b A[Catch:{ Exception -> 0x0382, zzos -> 0x0090, zzoi -> 0x03cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:219:0x034d A[Catch:{ Exception -> 0x0382, zzos -> 0x0090, zzoi -> 0x03cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:222:0x035b A[Catch:{ Exception -> 0x0382, zzos -> 0x0090, zzoi -> 0x03cf }] */
    /* JADX WARNING: Removed duplicated region for block: B:233:0x037e A[Catch:{ Exception -> 0x0382, zzos -> 0x0090, zzoi -> 0x03cf }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzam() throws com.google.android.gms.internal.ads.zzgg {
        /*
            r17 = this;
            r7 = r17
            com.google.android.gms.internal.ads.zzof r0 = r7.zzw
            if (r0 != 0) goto L_0x03da
            boolean r0 = r7.zzW
            if (r0 != 0) goto L_0x03da
            com.google.android.gms.internal.ads.zzab r0 = r7.zzp
            if (r0 != 0) goto L_0x0010
            goto L_0x03da
        L_0x0010:
            com.google.android.gms.internal.ads.zznl r1 = r7.zzap
            r8 = 1
            if (r1 != 0) goto L_0x004a
            boolean r0 = r7.zzaf(r0)
            if (r0 == 0) goto L_0x004a
            com.google.android.gms.internal.ads.zzab r0 = r7.zzp
            r17.zzS()
            java.lang.String r0 = r0.zzm
            java.lang.String r1 = "audio/mp4a-latm"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0040
            java.lang.String r1 = "audio/mpeg"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L_0x0040
            java.lang.String r1 = "audio/opus"
            boolean r0 = r1.equals(r0)
            if (r0 != 0) goto L_0x0040
            com.google.android.gms.internal.ads.zznz r0 = r7.zzi
            r0.zzn(r8)
            goto L_0x0047
        L_0x0040:
            com.google.android.gms.internal.ads.zznz r0 = r7.zzi
            r1 = 32
            r0.zzn(r1)
        L_0x0047:
            r7.zzW = r8
            return
        L_0x004a:
            com.google.android.gms.internal.ads.zznl r0 = r7.zzap
            r7.zzao = r0
            com.google.android.gms.internal.ads.zzab r1 = r7.zzp
            java.lang.String r2 = r1.zzm
            r9 = 0
            if (r0 == 0) goto L_0x0067
            boolean r2 = com.google.android.gms.internal.ads.zznm.zza
            if (r2 != 0) goto L_0x005a
            goto L_0x0067
        L_0x005a:
            com.google.android.gms.internal.ads.zznc r0 = r0.zza()
            com.google.android.gms.internal.ads.zzab r1 = r7.zzp
            int r2 = r0.zza
            com.google.android.gms.internal.ads.zzgg r0 = r7.zzbo(r0, r1, r9, r2)
            throw r0
        L_0x0067:
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzoh> r0 = r7.zzB     // Catch:{ zzoi -> 0x03cf }
            r10 = 0
            if (r0 != 0) goto L_0x009c
            com.google.android.gms.internal.ads.zzol r0 = r7.zzd     // Catch:{ zzos -> 0x0090 }
            java.util.List r0 = r7.zzV(r0, r1, r9)     // Catch:{ zzos -> 0x0090 }
            r0.isEmpty()     // Catch:{ zzos -> 0x0090 }
            java.util.ArrayDeque r1 = new java.util.ArrayDeque     // Catch:{ zzos -> 0x0090 }
            r1.<init>()     // Catch:{ zzos -> 0x0090 }
            r7.zzB = r1     // Catch:{ zzos -> 0x0090 }
            boolean r1 = r0.isEmpty()     // Catch:{ zzos -> 0x0090 }
            if (r1 != 0) goto L_0x008d
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzoh> r1 = r7.zzB     // Catch:{ zzos -> 0x0090 }
            java.lang.Object r0 = r0.get(r9)     // Catch:{ zzos -> 0x0090 }
            com.google.android.gms.internal.ads.zzoh r0 = (com.google.android.gms.internal.ads.zzoh) r0     // Catch:{ zzos -> 0x0090 }
            r1.add(r0)     // Catch:{ zzos -> 0x0090 }
        L_0x008d:
            r7.zzC = r10     // Catch:{ zzos -> 0x0090 }
            goto L_0x009c
        L_0x0090:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzoi r1 = new com.google.android.gms.internal.ads.zzoi     // Catch:{ zzoi -> 0x03cf }
            com.google.android.gms.internal.ads.zzab r2 = r7.zzp     // Catch:{ zzoi -> 0x03cf }
            r3 = -49998(0xffffffffffff3cb2, float:NaN)
            r1.<init>((com.google.android.gms.internal.ads.zzab) r2, (java.lang.Throwable) r0, (boolean) r9, (int) r3)     // Catch:{ zzoi -> 0x03cf }
            throw r1     // Catch:{ zzoi -> 0x03cf }
        L_0x009c:
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzoh> r0 = r7.zzB     // Catch:{ zzoi -> 0x03cf }
            boolean r0 = r0.isEmpty()     // Catch:{ zzoi -> 0x03cf }
            if (r0 != 0) goto L_0x03c2
        L_0x00a4:
            com.google.android.gms.internal.ads.zzof r0 = r7.zzw     // Catch:{ zzoi -> 0x03cf }
            if (r0 != 0) goto L_0x03be
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzoh> r0 = r7.zzB     // Catch:{ zzoi -> 0x03cf }
            java.lang.Object r0 = r0.peekFirst()     // Catch:{ zzoi -> 0x03cf }
            r11 = r0
            com.google.android.gms.internal.ads.zzoh r11 = (com.google.android.gms.internal.ads.zzoh) r11     // Catch:{ zzoi -> 0x03cf }
            boolean r0 = r7.zzat(r11)     // Catch:{ zzoi -> 0x03cf }
            if (r0 != 0) goto L_0x00b8
            return
        L_0x00b8:
            java.lang.String r2 = r11.zza     // Catch:{ Exception -> 0x0382 }
            int r0 = com.google.android.gms.internal.ads.zzfn.zza     // Catch:{ Exception -> 0x0382 }
            r1 = -1082130432(0xffffffffbf800000, float:-1.0)
            r3 = 23
            if (r0 >= r3) goto L_0x00c4
            r4 = r1
            goto L_0x00d0
        L_0x00c4:
            float r4 = r7.zzv     // Catch:{ Exception -> 0x0382 }
            com.google.android.gms.internal.ads.zzab r5 = r7.zzp     // Catch:{ Exception -> 0x0382 }
            com.google.android.gms.internal.ads.zzab[] r6 = r17.zzI()     // Catch:{ Exception -> 0x0382 }
            float r4 = r7.zzO(r4, r5, r6)     // Catch:{ Exception -> 0x0382 }
        L_0x00d0:
            float r5 = r7.zze     // Catch:{ Exception -> 0x0382 }
            int r5 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r5 > 0) goto L_0x00d7
            goto L_0x00d8
        L_0x00d7:
            r1 = r4
        L_0x00d8:
            long r4 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0382 }
            java.lang.String r6 = java.lang.String.valueOf(r2)     // Catch:{ Exception -> 0x0382 }
            int r12 = r6.length()     // Catch:{ Exception -> 0x0382 }
            java.lang.String r13 = "createCodec:"
            if (r12 == 0) goto L_0x00ed
            java.lang.String r6 = r13.concat(r6)     // Catch:{ Exception -> 0x0382 }
            goto L_0x00f2
        L_0x00ed:
            java.lang.String r6 = new java.lang.String     // Catch:{ Exception -> 0x0382 }
            r6.<init>(r13)     // Catch:{ Exception -> 0x0382 }
        L_0x00f2:
            com.google.android.gms.internal.ads.zzfl.zza(r6)     // Catch:{ Exception -> 0x0382 }
            com.google.android.gms.internal.ads.zzab r6 = r7.zzp     // Catch:{ Exception -> 0x0382 }
            com.google.android.gms.internal.ads.zzod r6 = r7.zzU(r11, r6, r10, r1)     // Catch:{ Exception -> 0x0382 }
            r12 = 31
            if (r0 < r12) goto L_0x012d
            com.google.android.gms.internal.ads.zzab r12 = r6.zzc     // Catch:{ Exception -> 0x0382 }
            java.lang.String r12 = r12.zzm     // Catch:{ Exception -> 0x0382 }
            int r12 = com.google.android.gms.internal.ads.zzbi.zza(r12)     // Catch:{ Exception -> 0x0382 }
            java.lang.String r13 = "DefaultMediaCodecAdapterFactory"
            java.lang.String r14 = "Creating an asynchronous MediaCodec adapter for track type "
            java.lang.String r15 = com.google.android.gms.internal.ads.zzfn.zzJ(r12)     // Catch:{ Exception -> 0x0382 }
            int r16 = r15.length()     // Catch:{ Exception -> 0x0382 }
            if (r16 == 0) goto L_0x011a
            java.lang.String r14 = r14.concat(r15)     // Catch:{ Exception -> 0x0382 }
            goto L_0x0120
        L_0x011a:
            java.lang.String r15 = new java.lang.String     // Catch:{ Exception -> 0x0382 }
            r15.<init>(r14)     // Catch:{ Exception -> 0x0382 }
            r14 = r15
        L_0x0120:
            android.util.Log.i(r13, r14)     // Catch:{ Exception -> 0x0382 }
            com.google.android.gms.internal.ads.zznr r13 = new com.google.android.gms.internal.ads.zznr     // Catch:{ Exception -> 0x0382 }
            r13.<init>(r12, r9)     // Catch:{ Exception -> 0x0382 }
            com.google.android.gms.internal.ads.zznt r6 = r13.zzc(r6)     // Catch:{ Exception -> 0x0382 }
            goto L_0x0172
        L_0x012d:
            com.google.android.gms.internal.ads.zzoh r12 = r6.zza     // Catch:{ IOException -> 0x037a, RuntimeException -> 0x0378 }
            r12.getClass()
            java.lang.String r12 = r12.zza     // Catch:{ IOException -> 0x037a, RuntimeException -> 0x0378 }
            java.lang.String r14 = java.lang.String.valueOf(r12)     // Catch:{ IOException -> 0x037a, RuntimeException -> 0x0378 }
            int r15 = r14.length()     // Catch:{ IOException -> 0x037a, RuntimeException -> 0x0378 }
            if (r15 == 0) goto L_0x0143
            java.lang.String r13 = r13.concat(r14)     // Catch:{ IOException -> 0x037a, RuntimeException -> 0x0378 }
            goto L_0x0149
        L_0x0143:
            java.lang.String r14 = new java.lang.String     // Catch:{ IOException -> 0x037a, RuntimeException -> 0x0378 }
            r14.<init>(r13)     // Catch:{ IOException -> 0x037a, RuntimeException -> 0x0378 }
            r13 = r14
        L_0x0149:
            com.google.android.gms.internal.ads.zzfl.zza(r13)     // Catch:{ IOException -> 0x037a, RuntimeException -> 0x0378 }
            android.media.MediaCodec r12 = android.media.MediaCodec.createByCodecName(r12)     // Catch:{ IOException -> 0x037a, RuntimeException -> 0x0378 }
            com.google.android.gms.internal.ads.zzfl.zzb()     // Catch:{ IOException -> 0x037a, RuntimeException -> 0x0378 }
            java.lang.String r13 = "configureCodec"
            com.google.android.gms.internal.ads.zzfl.zza(r13)     // Catch:{ IOException -> 0x0376, RuntimeException -> 0x0374 }
            android.media.MediaFormat r13 = r6.zzb     // Catch:{ IOException -> 0x0376, RuntimeException -> 0x0374 }
            android.view.Surface r6 = r6.zzd     // Catch:{ IOException -> 0x0376, RuntimeException -> 0x0374 }
            r12.configure(r13, r6, r10, r9)     // Catch:{ IOException -> 0x0376, RuntimeException -> 0x0374 }
            com.google.android.gms.internal.ads.zzfl.zzb()     // Catch:{ IOException -> 0x0376, RuntimeException -> 0x0374 }
            java.lang.String r6 = "startCodec"
            com.google.android.gms.internal.ads.zzfl.zza(r6)     // Catch:{ IOException -> 0x0376, RuntimeException -> 0x0374 }
            r12.start()     // Catch:{ IOException -> 0x0376, RuntimeException -> 0x0374 }
            com.google.android.gms.internal.ads.zzfl.zzb()     // Catch:{ IOException -> 0x0376, RuntimeException -> 0x0374 }
            com.google.android.gms.internal.ads.zzpa r6 = new com.google.android.gms.internal.ads.zzpa     // Catch:{ IOException -> 0x0376, RuntimeException -> 0x0374 }
            r6.<init>(r12, r10, r10)     // Catch:{ IOException -> 0x0376, RuntimeException -> 0x0374 }
        L_0x0172:
            r7.zzw = r6     // Catch:{ Exception -> 0x0382 }
            long r12 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0382 }
            r7.zzD = r11     // Catch:{ Exception -> 0x0382 }
            r7.zzA = r1     // Catch:{ Exception -> 0x0382 }
            com.google.android.gms.internal.ads.zzab r1 = r7.zzp     // Catch:{ Exception -> 0x0382 }
            r7.zzx = r1     // Catch:{ Exception -> 0x0382 }
            java.lang.String r1 = "OMX.Exynos.avc.dec.secure"
            r6 = 25
            if (r0 > r6) goto L_0x01b0
            boolean r15 = r1.equals(r2)     // Catch:{ Exception -> 0x0382 }
            if (r15 == 0) goto L_0x01b0
            java.lang.String r15 = com.google.android.gms.internal.ads.zzfn.zzd     // Catch:{ Exception -> 0x0382 }
            java.lang.String r10 = "SM-T585"
            boolean r10 = r15.startsWith(r10)     // Catch:{ Exception -> 0x0382 }
            if (r10 != 0) goto L_0x01ae
            java.lang.String r10 = "SM-A510"
            boolean r10 = r15.startsWith(r10)     // Catch:{ Exception -> 0x0382 }
            if (r10 != 0) goto L_0x01ae
            java.lang.String r10 = "SM-A520"
            boolean r10 = r15.startsWith(r10)     // Catch:{ Exception -> 0x0382 }
            if (r10 != 0) goto L_0x01ae
            java.lang.String r10 = "SM-J700"
            boolean r10 = r15.startsWith(r10)     // Catch:{ Exception -> 0x0382 }
            if (r10 == 0) goto L_0x01b0
        L_0x01ae:
            r10 = 2
            goto L_0x01e9
        L_0x01b0:
            r10 = 24
            if (r0 >= r10) goto L_0x01e8
            java.lang.String r10 = "OMX.Nvidia.h264.decode"
            boolean r10 = r10.equals(r2)     // Catch:{ Exception -> 0x0382 }
            if (r10 != 0) goto L_0x01c4
            java.lang.String r10 = "OMX.Nvidia.h264.decode.secure"
            boolean r10 = r10.equals(r2)     // Catch:{ Exception -> 0x0382 }
            if (r10 == 0) goto L_0x01e8
        L_0x01c4:
            java.lang.String r10 = "flounder"
            java.lang.String r15 = com.google.android.gms.internal.ads.zzfn.zzb     // Catch:{ Exception -> 0x0382 }
            boolean r10 = r10.equals(r15)     // Catch:{ Exception -> 0x0382 }
            if (r10 != 0) goto L_0x01e6
            java.lang.String r10 = "flounder_lte"
            boolean r10 = r10.equals(r15)     // Catch:{ Exception -> 0x0382 }
            if (r10 != 0) goto L_0x01e6
            java.lang.String r10 = "grouper"
            boolean r10 = r10.equals(r15)     // Catch:{ Exception -> 0x0382 }
            if (r10 != 0) goto L_0x01e6
            java.lang.String r10 = "tilapia"
            boolean r10 = r10.equals(r15)     // Catch:{ Exception -> 0x0382 }
            if (r10 == 0) goto L_0x01e8
        L_0x01e6:
            r10 = r8
            goto L_0x01e9
        L_0x01e8:
            r10 = r9
        L_0x01e9:
            r7.zzE = r10     // Catch:{ Exception -> 0x0382 }
            com.google.android.gms.internal.ads.zzab r10 = r7.zzx     // Catch:{ Exception -> 0x0382 }
            r15 = 21
            if (r0 >= r15) goto L_0x0203
            java.util.List<byte[]> r10 = r10.zzo     // Catch:{ Exception -> 0x0382 }
            boolean r10 = r10.isEmpty()     // Catch:{ Exception -> 0x0382 }
            if (r10 == 0) goto L_0x0203
            java.lang.String r10 = "OMX.MTK.VIDEO.DECODER.AVC"
            boolean r10 = r10.equals(r2)     // Catch:{ Exception -> 0x0382 }
            if (r10 == 0) goto L_0x0203
            r10 = r8
            goto L_0x0204
        L_0x0203:
            r10 = r9
        L_0x0204:
            r7.zzF = r10     // Catch:{ Exception -> 0x0382 }
            r10 = 19
            r9 = 18
            if (r0 < r9) goto L_0x023b
            if (r0 != r9) goto L_0x021e
            java.lang.String r14 = "OMX.SEC.avc.dec"
            boolean r14 = r14.equals(r2)     // Catch:{ Exception -> 0x0382 }
            if (r14 != 0) goto L_0x023b
            java.lang.String r14 = "OMX.SEC.avc.dec.secure"
            boolean r14 = r14.equals(r2)     // Catch:{ Exception -> 0x0382 }
            if (r14 != 0) goto L_0x023b
        L_0x021e:
            if (r0 != r10) goto L_0x0239
            java.lang.String r14 = com.google.android.gms.internal.ads.zzfn.zzd     // Catch:{ Exception -> 0x0382 }
            java.lang.String r6 = "SM-G800"
            boolean r6 = r14.startsWith(r6)     // Catch:{ Exception -> 0x0382 }
            if (r6 == 0) goto L_0x0239
            java.lang.String r6 = "OMX.Exynos.avc.dec"
            boolean r6 = r6.equals(r2)     // Catch:{ Exception -> 0x0382 }
            if (r6 != 0) goto L_0x023b
            boolean r1 = r1.equals(r2)     // Catch:{ Exception -> 0x0382 }
            if (r1 == 0) goto L_0x0239
            goto L_0x023b
        L_0x0239:
            r1 = 0
            goto L_0x023c
        L_0x023b:
            r1 = r8
        L_0x023c:
            r7.zzG = r1     // Catch:{ Exception -> 0x0382 }
            r1 = 29
            if (r0 != r1) goto L_0x024c
            java.lang.String r6 = "c2.android.aac.decoder"
            boolean r6 = r6.equals(r2)     // Catch:{ Exception -> 0x0382 }
            if (r6 == 0) goto L_0x024c
            r6 = r8
            goto L_0x024d
        L_0x024c:
            r6 = 0
        L_0x024d:
            r7.zzH = r6     // Catch:{ Exception -> 0x0382 }
            if (r0 > r3) goto L_0x025c
            java.lang.String r3 = "OMX.google.vorbis.decoder"
            boolean r3 = r3.equals(r2)     // Catch:{ Exception -> 0x0382 }
            if (r3 != 0) goto L_0x025a
            goto L_0x025c
        L_0x025a:
            r3 = r8
            goto L_0x0282
        L_0x025c:
            if (r0 > r10) goto L_0x0281
            java.lang.String r3 = "hb2000"
            java.lang.String r6 = com.google.android.gms.internal.ads.zzfn.zzb     // Catch:{ Exception -> 0x0382 }
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0382 }
            if (r3 != 0) goto L_0x0270
            java.lang.String r3 = "stvm8"
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0382 }
            if (r3 == 0) goto L_0x0281
        L_0x0270:
            java.lang.String r3 = "OMX.amlogic.avc.decoder.awesome"
            boolean r3 = r3.equals(r2)     // Catch:{ Exception -> 0x0382 }
            if (r3 != 0) goto L_0x025a
            java.lang.String r3 = "OMX.amlogic.avc.decoder.awesome.secure"
            boolean r3 = r3.equals(r2)     // Catch:{ Exception -> 0x0382 }
            if (r3 == 0) goto L_0x0281
            goto L_0x025a
        L_0x0281:
            r3 = 0
        L_0x0282:
            r7.zzI = r3     // Catch:{ Exception -> 0x0382 }
            if (r0 != r15) goto L_0x0290
            java.lang.String r3 = "OMX.google.aac.decoder"
            boolean r3 = r3.equals(r2)     // Catch:{ Exception -> 0x0382 }
            if (r3 == 0) goto L_0x0290
            r3 = r8
            goto L_0x0291
        L_0x0290:
            r3 = 0
        L_0x0291:
            r7.zzJ = r3     // Catch:{ Exception -> 0x0382 }
            if (r0 >= r15) goto L_0x02db
            java.lang.String r3 = "OMX.SEC.mp3.dec"
            boolean r3 = r3.equals(r2)     // Catch:{ Exception -> 0x0382 }
            if (r3 == 0) goto L_0x02db
            java.lang.String r3 = "samsung"
            java.lang.String r6 = com.google.android.gms.internal.ads.zzfn.zzc     // Catch:{ Exception -> 0x0382 }
            boolean r3 = r3.equals(r6)     // Catch:{ Exception -> 0x0382 }
            if (r3 == 0) goto L_0x02db
            java.lang.String r3 = com.google.android.gms.internal.ads.zzfn.zzb     // Catch:{ Exception -> 0x0382 }
            java.lang.String r6 = "baffin"
            boolean r6 = r3.startsWith(r6)     // Catch:{ Exception -> 0x0382 }
            if (r6 != 0) goto L_0x02d9
            java.lang.String r6 = "grand"
            boolean r6 = r3.startsWith(r6)     // Catch:{ Exception -> 0x0382 }
            if (r6 != 0) goto L_0x02d9
            java.lang.String r6 = "fortuna"
            boolean r6 = r3.startsWith(r6)     // Catch:{ Exception -> 0x0382 }
            if (r6 != 0) goto L_0x02d9
            java.lang.String r6 = "gprimelte"
            boolean r6 = r3.startsWith(r6)     // Catch:{ Exception -> 0x0382 }
            if (r6 != 0) goto L_0x02d9
            java.lang.String r6 = "j2y18lte"
            boolean r6 = r3.startsWith(r6)     // Catch:{ Exception -> 0x0382 }
            if (r6 != 0) goto L_0x02d9
            java.lang.String r6 = "ms01"
            boolean r3 = r3.startsWith(r6)     // Catch:{ Exception -> 0x0382 }
            if (r3 == 0) goto L_0x02db
        L_0x02d9:
            r3 = r8
            goto L_0x02dc
        L_0x02db:
            r3 = 0
        L_0x02dc:
            r7.zzK = r3     // Catch:{ Exception -> 0x0382 }
            com.google.android.gms.internal.ads.zzab r3 = r7.zzx     // Catch:{ Exception -> 0x0382 }
            if (r0 > r9) goto L_0x02f0
            int r3 = r3.zzz     // Catch:{ Exception -> 0x0382 }
            if (r3 != r8) goto L_0x02f0
            java.lang.String r3 = "OMX.MTK.AUDIO.DECODER.MP3"
            boolean r3 = r3.equals(r2)     // Catch:{ Exception -> 0x0382 }
            if (r3 == 0) goto L_0x02f0
            r3 = r8
            goto L_0x02f1
        L_0x02f0:
            r3 = 0
        L_0x02f1:
            r7.zzL = r3     // Catch:{ Exception -> 0x0382 }
            java.lang.String r3 = r11.zza     // Catch:{ Exception -> 0x0382 }
            r6 = 25
            if (r0 > r6) goto L_0x0304
            java.lang.String r6 = "OMX.rk.video_decoder.avc"
            boolean r6 = r6.equals(r3)     // Catch:{ Exception -> 0x0382 }
            if (r6 != 0) goto L_0x0302
            goto L_0x0304
        L_0x0302:
            r0 = r8
            goto L_0x033c
        L_0x0304:
            r6 = 17
            if (r0 > r6) goto L_0x0310
            java.lang.String r6 = "OMX.allwinner.video.decoder.avc"
            boolean r6 = r6.equals(r3)     // Catch:{ Exception -> 0x0382 }
            if (r6 != 0) goto L_0x0302
        L_0x0310:
            if (r0 > r1) goto L_0x0322
            java.lang.String r0 = "OMX.broadcom.video_decoder.tunnel"
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x0382 }
            if (r0 != 0) goto L_0x0302
            java.lang.String r0 = "OMX.broadcom.video_decoder.tunnel.secure"
            boolean r0 = r0.equals(r3)     // Catch:{ Exception -> 0x0382 }
            if (r0 != 0) goto L_0x0302
        L_0x0322:
            java.lang.String r0 = "Amazon"
            java.lang.String r1 = com.google.android.gms.internal.ads.zzfn.zzc     // Catch:{ Exception -> 0x0382 }
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x0382 }
            if (r0 == 0) goto L_0x033b
            java.lang.String r0 = "AFTS"
            java.lang.String r1 = com.google.android.gms.internal.ads.zzfn.zzd     // Catch:{ Exception -> 0x0382 }
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x0382 }
            if (r0 == 0) goto L_0x033b
            boolean r0 = r11.zzf     // Catch:{ Exception -> 0x0382 }
            if (r0 == 0) goto L_0x033b
            goto L_0x0302
        L_0x033b:
            r0 = 0
        L_0x033c:
            r7.zzO = r0     // Catch:{ Exception -> 0x0382 }
            com.google.android.gms.internal.ads.zzof r0 = r7.zzw     // Catch:{ Exception -> 0x0382 }
            r0.zzr()     // Catch:{ Exception -> 0x0382 }
            java.lang.String r0 = "c2.android.mp3.decoder"
            java.lang.String r1 = r11.zza     // Catch:{ Exception -> 0x0382 }
            boolean r0 = r0.equals(r1)     // Catch:{ Exception -> 0x0382 }
            if (r0 == 0) goto L_0x0354
            com.google.android.gms.internal.ads.zzoa r0 = new com.google.android.gms.internal.ads.zzoa     // Catch:{ Exception -> 0x0382 }
            r0.<init>()     // Catch:{ Exception -> 0x0382 }
            r7.zzP = r0     // Catch:{ Exception -> 0x0382 }
        L_0x0354:
            int r0 = r17.zzbm()     // Catch:{ Exception -> 0x0382 }
            r1 = 2
            if (r0 != r1) goto L_0x0364
            long r0 = android.os.SystemClock.elapsedRealtime()     // Catch:{ Exception -> 0x0382 }
            r9 = 1000(0x3e8, double:4.94E-321)
            long r0 = r0 + r9
            r7.zzQ = r0     // Catch:{ Exception -> 0x0382 }
        L_0x0364:
            com.google.android.gms.internal.ads.zzfy r0 = r7.zza     // Catch:{ Exception -> 0x0382 }
            int r1 = r0.zza     // Catch:{ Exception -> 0x0382 }
            int r1 = r1 + r8
            r0.zza = r1     // Catch:{ Exception -> 0x0382 }
            long r5 = r12 - r4
            r1 = r17
            r3 = r12
            r1.zzX(r2, r3, r5)     // Catch:{ Exception -> 0x0382 }
            goto L_0x03b7
        L_0x0374:
            r0 = move-exception
            goto L_0x037c
        L_0x0376:
            r0 = move-exception
            goto L_0x037c
        L_0x0378:
            r0 = move-exception
            goto L_0x037b
        L_0x037a:
            r0 = move-exception
        L_0x037b:
            r12 = 0
        L_0x037c:
            if (r12 == 0) goto L_0x0381
            r12.release()     // Catch:{ Exception -> 0x0382 }
        L_0x0381:
            throw r0     // Catch:{ Exception -> 0x0382 }
        L_0x0382:
            r0 = move-exception
            java.lang.String r1 = java.lang.String.valueOf(r11)     // Catch:{ zzoi -> 0x03cf }
            java.lang.String r2 = "MediaCodecRenderer"
            java.lang.String r3 = "Failed to initialize decoder: "
            java.lang.String r1 = r3.concat(r1)     // Catch:{ zzoi -> 0x03cf }
            com.google.android.gms.internal.ads.zzep.zzb(r2, r1, r0)     // Catch:{ zzoi -> 0x03cf }
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzoh> r1 = r7.zzB     // Catch:{ zzoi -> 0x03cf }
            r1.removeFirst()     // Catch:{ zzoi -> 0x03cf }
            com.google.android.gms.internal.ads.zzoi r1 = new com.google.android.gms.internal.ads.zzoi     // Catch:{ zzoi -> 0x03cf }
            com.google.android.gms.internal.ads.zzab r2 = r7.zzp     // Catch:{ zzoi -> 0x03cf }
            r3 = 0
            r1.<init>((com.google.android.gms.internal.ads.zzab) r2, (java.lang.Throwable) r0, (boolean) r3, (com.google.android.gms.internal.ads.zzoh) r11)     // Catch:{ zzoi -> 0x03cf }
            r7.zzW(r1)     // Catch:{ zzoi -> 0x03cf }
            com.google.android.gms.internal.ads.zzoi r0 = r7.zzC     // Catch:{ zzoi -> 0x03cf }
            if (r0 != 0) goto L_0x03a9
            r7.zzC = r1     // Catch:{ zzoi -> 0x03cf }
            goto L_0x03af
        L_0x03a9:
            com.google.android.gms.internal.ads.zzoi r0 = com.google.android.gms.internal.ads.zzoi.zza(r0, r1)     // Catch:{ zzoi -> 0x03cf }
            r7.zzC = r0     // Catch:{ zzoi -> 0x03cf }
        L_0x03af:
            java.util.ArrayDeque<com.google.android.gms.internal.ads.zzoh> r0 = r7.zzB     // Catch:{ zzoi -> 0x03cf }
            boolean r0 = r0.isEmpty()     // Catch:{ zzoi -> 0x03cf }
            if (r0 != 0) goto L_0x03bb
        L_0x03b7:
            r9 = 0
            r10 = 0
            goto L_0x00a4
        L_0x03bb:
            com.google.android.gms.internal.ads.zzoi r0 = r7.zzC     // Catch:{ zzoi -> 0x03cf }
            throw r0     // Catch:{ zzoi -> 0x03cf }
        L_0x03be:
            r1 = r10
            r7.zzB = r1     // Catch:{ zzoi -> 0x03cf }
            return
        L_0x03c2:
            com.google.android.gms.internal.ads.zzoi r0 = new com.google.android.gms.internal.ads.zzoi     // Catch:{ zzoi -> 0x03cf }
            com.google.android.gms.internal.ads.zzab r1 = r7.zzp     // Catch:{ zzoi -> 0x03cf }
            r2 = -49999(0xffffffffffff3cb1, float:NaN)
            r3 = 0
            r4 = 0
            r0.<init>((com.google.android.gms.internal.ads.zzab) r1, (java.lang.Throwable) r3, (boolean) r4, (int) r2)     // Catch:{ zzoi -> 0x03cf }
            throw r0     // Catch:{ zzoi -> 0x03cf }
        L_0x03cf:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzab r1 = r7.zzp
            r2 = 4001(0xfa1, float:5.607E-42)
            r3 = 0
            com.google.android.gms.internal.ads.zzgg r0 = r7.zzbo(r0, r1, r3, r2)
            throw r0
        L_0x03da:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzoj.zzam():void");
    }

    @CallSuper
    public void zzan(long j11) {
        while (true) {
            int i11 = this.zzan;
            if (i11 != 0 && j11 >= this.zzo[0]) {
                long[] jArr = this.zzm;
                this.zzal = jArr[0];
                this.zzam = this.zzn[0];
                int i12 = i11 - 1;
                this.zzan = i12;
                System.arraycopy(jArr, 1, jArr, 0, i12);
                long[] jArr2 = this.zzn;
                System.arraycopy(jArr2, 1, jArr2, 0, this.zzan);
                long[] jArr3 = this.zzo;
                System.arraycopy(jArr3, 1, jArr3, 0, this.zzan);
                zzab();
            } else {
                return;
            }
        }
    }

    public final void zzao() {
        try {
            zzof zzof = this.zzw;
            if (zzof != null) {
                zzof.zzl();
                this.zza.zzb++;
                zzY(this.zzD.zza);
            }
        } finally {
            this.zzw = null;
            this.zzr = null;
            this.zzao = null;
            zzaq();
        }
    }

    @CallSuper
    public void zzap() {
        zzaw();
        zzax();
        this.zzQ = C.TIME_UNSET;
        this.zzae = false;
        this.zzad = false;
        this.zzM = false;
        this.zzN = false;
        this.zzU = false;
        this.zzV = false;
        this.zzk.clear();
        this.zzag = C.TIME_UNSET;
        this.zzah = C.TIME_UNSET;
        zzoa zzoa = this.zzP;
        if (zzoa != null) {
            zzoa.zzc();
        }
        this.zzab = 0;
        this.zzac = 0;
        this.zzaa = this.zzZ ? 1 : 0;
    }

    @CallSuper
    public final void zzaq() {
        zzap();
        this.zzP = null;
        this.zzB = null;
        this.zzD = null;
        this.zzx = null;
        this.zzy = null;
        this.zzz = false;
        this.zzaf = false;
        this.zzA = -1.0f;
        this.zzE = 0;
        this.zzF = false;
        this.zzG = false;
        this.zzH = false;
        this.zzI = false;
        this.zzJ = false;
        this.zzK = false;
        this.zzL = false;
        this.zzO = false;
        this.zzZ = false;
        this.zzaa = 0;
        this.zzs = false;
    }

    public final boolean zzar() throws zzgg {
        boolean zzas = zzas();
        if (zzas) {
            zzam();
        }
        return zzas;
    }

    public final boolean zzas() {
        if (this.zzw == null) {
            return false;
        }
        if (this.zzac == 3 || this.zzG || ((this.zzH && !this.zzaf) || (this.zzI && this.zzae))) {
            zzao();
            return true;
        }
        zzaa();
        return false;
    }

    public boolean zzat(zzoh zzoh) {
        return true;
    }

    public final int zze() {
        return 8;
    }

    public void zzq() {
        this.zzp = null;
        this.zzal = C.TIME_UNSET;
        this.zzam = C.TIME_UNSET;
        this.zzan = 0;
        zzas();
    }

    public void zzr(boolean z11, boolean z12) throws zzgg {
        this.zza = new zzfy();
    }

    public void zzs(long j11, boolean z11) throws zzgg {
        this.zzai = false;
        this.zzaj = false;
        if (this.zzW) {
            this.zzi.zzb();
            this.zzh.zzb();
            this.zzX = false;
        } else {
            zzar();
        }
        if (this.zzj.zza() > 0) {
            this.zzak = true;
        }
        this.zzj.zze();
        int i11 = this.zzan;
        if (i11 != 0) {
            int i12 = i11 - 1;
            this.zzam = this.zzn[i12];
            this.zzal = this.zzm[i12];
            this.zzan = 0;
        }
    }

    public void zzt() {
        try {
            zzS();
            zzao();
        } finally {
            this.zzap = null;
        }
    }

    public final void zzw(zzab[] zzabArr, long j11, long j12) throws zzgg {
        boolean z11 = true;
        if (this.zzam == C.TIME_UNSET) {
            if (this.zzal != C.TIME_UNSET) {
                z11 = false;
            }
            zzdy.zzf(z11);
            this.zzal = j11;
            this.zzam = j12;
            return;
        }
        int i11 = this.zzan;
        if (i11 == 10) {
            long j13 = this.zzn[9];
            StringBuilder sb2 = new StringBuilder(65);
            sb2.append("Too many stream changes, so dropping offset: ");
            sb2.append(j13);
            Log.w("MediaCodecRenderer", sb2.toString());
        } else {
            this.zzan = i11 + 1;
        }
        long[] jArr = this.zzm;
        int i12 = this.zzan - 1;
        jArr[i12] = j11;
        this.zzn[i12] = j12;
        this.zzo[i12] = this.zzag;
    }
}
