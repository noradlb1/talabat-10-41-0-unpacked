package com.google.android.gms.internal.ads;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;

final class zzqn implements zzpy, zzpx {
    private final zzpy[] zza;
    private final IdentityHashMap<zzrn, Integer> zzb;
    private final ArrayList<zzpy> zzc = new ArrayList<>();
    @Nullable
    private zzpx zzd;
    @Nullable
    private zzch zze;
    private zzpy[] zzf;
    private zzrp zzg;
    private final zzpm zzh;

    public zzqn(zzpm zzpm, long[] jArr, zzpy[] zzpyArr, byte... bArr) {
        this.zzh = zzpm;
        this.zza = zzpyArr;
        this.zzg = new zzpl(new zzrp[0]);
        this.zzb = new IdentityHashMap<>();
        this.zzf = new zzpy[0];
        for (int i11 = 0; i11 < zzpyArr.length; i11++) {
            long j11 = jArr[i11];
            if (j11 != 0) {
                this.zza[i11] = new zzql(zzpyArr[i11], j11);
            }
        }
    }

    public final long zza(long j11, zzio zzio) {
        zzpy zzpy;
        zzpy[] zzpyArr = this.zzf;
        if (zzpyArr.length > 0) {
            zzpy = zzpyArr[0];
        } else {
            zzpy = this.zza[0];
        }
        return zzpy.zza(j11, zzio);
    }

    public final long zzb() {
        return this.zzg.zzb();
    }

    public final long zzc() {
        return this.zzg.zzc();
    }

    public final long zzd() {
        long j11 = -9223372036854775807L;
        for (zzpy zzpy : this.zzf) {
            long zzd2 = zzpy.zzd();
            if (zzd2 != C.TIME_UNSET) {
                if (j11 == C.TIME_UNSET) {
                    zzpy[] zzpyArr = this.zzf;
                    int length = zzpyArr.length;
                    int i11 = 0;
                    while (i11 < length) {
                        zzpy zzpy2 = zzpyArr[i11];
                        if (zzpy2 == zzpy) {
                            break;
                        } else if (zzpy2.zze(zzd2) == zzd2) {
                            i11++;
                        } else {
                            throw new IllegalStateException("Unexpected child seekToUs result.");
                        }
                    }
                    j11 = zzd2;
                } else if (zzd2 != j11) {
                    throw new IllegalStateException("Conflicting discontinuities.");
                }
            } else if (!(j11 == C.TIME_UNSET || zzpy.zze(j11) == j11)) {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
        return j11;
    }

    public final long zze(long j11) {
        long zze2 = this.zzf[0].zze(j11);
        int i11 = 1;
        while (true) {
            zzpy[] zzpyArr = this.zzf;
            if (i11 >= zzpyArr.length) {
                return zze2;
            }
            if (zzpyArr[i11].zze(zze2) == zze2) {
                i11++;
            } else {
                throw new IllegalStateException("Unexpected child seekToUs result.");
            }
        }
    }

    public final zzch zzf() {
        zzch zzch = this.zze;
        zzch.getClass();
        return zzch;
    }

    public final /* bridge */ /* synthetic */ void zzg(zzrp zzrp) {
        zzpy zzpy = (zzpy) zzrp;
        zzpx zzpx = this.zzd;
        zzpx.getClass();
        zzpx.zzg(this);
    }

    public final void zzh(long j11, boolean z11) {
        for (zzpy zzh2 : this.zzf) {
            zzh2.zzh(j11, false);
        }
    }

    public final void zzi(zzpy zzpy) {
        this.zzc.remove(zzpy);
        if (this.zzc.isEmpty()) {
            int i11 = 0;
            for (zzpy zzf2 : this.zza) {
                i11 += zzf2.zzf().zzc;
            }
            zzcf[] zzcfArr = new zzcf[i11];
            int i12 = 0;
            for (zzpy zzf3 : this.zza) {
                zzch zzf4 = zzf3.zzf();
                int i13 = zzf4.zzc;
                int i14 = 0;
                while (i14 < i13) {
                    zzcfArr[i12] = zzf4.zzb(i14);
                    i14++;
                    i12++;
                }
            }
            this.zze = new zzch(zzcfArr);
            zzpx zzpx = this.zzd;
            zzpx.getClass();
            zzpx.zzi(this);
        }
    }

    public final void zzj() throws IOException {
        for (zzpy zzj : this.zza) {
            zzj.zzj();
        }
    }

    public final void zzk(zzpx zzpx, long j11) {
        this.zzd = zzpx;
        Collections.addAll(this.zzc, this.zza);
        for (zzpy zzk : this.zza) {
            zzk.zzk(this, j11);
        }
    }

    public final void zzl(long j11) {
        this.zzg.zzl(j11);
    }

    public final zzpy zzm(int i11) {
        zzpy zzpy = this.zza[i11];
        if (zzpy instanceof zzql) {
            return ((zzql) zzpy).zza;
        }
        return zzpy;
    }

    public final boolean zzn(long j11) {
        if (this.zzc.isEmpty()) {
            return this.zzg.zzn(j11);
        }
        int size = this.zzc.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.zzc.get(i11).zzn(j11);
        }
        return false;
    }

    public final boolean zzo() {
        return this.zzg.zzo();
    }

    public final long zzq(zzsb[] zzsbArr, boolean[] zArr, zzrn[] zzrnArr, boolean[] zArr2, long j11) {
        int length;
        zzrn zzrn;
        zzsb zzsb;
        Integer num;
        int i11;
        zzsb[] zzsbArr2 = zzsbArr;
        zzrn[] zzrnArr2 = zzrnArr;
        int length2 = zzsbArr2.length;
        int[] iArr = new int[length2];
        int[] iArr2 = new int[length2];
        int i12 = 0;
        while (true) {
            length = zzsbArr2.length;
            if (i12 >= length) {
                break;
            }
            zzrn zzrn2 = zzrnArr2[i12];
            if (zzrn2 == null) {
                num = null;
            } else {
                num = this.zzb.get(zzrn2);
            }
            if (num == null) {
                i11 = -1;
            } else {
                i11 = num.intValue();
            }
            iArr[i12] = i11;
            iArr2[i12] = -1;
            zzsb zzsb2 = zzsbArr2[i12];
            if (zzsb2 != null) {
                zzcf zze2 = zzsb2.zze();
                int i13 = 0;
                while (true) {
                    zzpy[] zzpyArr = this.zza;
                    if (i13 >= zzpyArr.length) {
                        break;
                    } else if (zzpyArr[i13].zzf().zza(zze2) != -1) {
                        iArr2[i12] = i13;
                        break;
                    } else {
                        i13++;
                    }
                }
            }
            i12++;
        }
        this.zzb.clear();
        zzrn[] zzrnArr3 = new zzrn[length];
        zzrn[] zzrnArr4 = new zzrn[length];
        zzsb[] zzsbArr3 = new zzsb[length];
        ArrayList arrayList = new ArrayList(this.zza.length);
        long j12 = j11;
        int i14 = 0;
        while (i14 < this.zza.length) {
            for (int i15 = 0; i15 < zzsbArr2.length; i15++) {
                if (iArr[i15] == i14) {
                    zzrn = zzrnArr2[i15];
                } else {
                    zzrn = null;
                }
                zzrnArr4[i15] = zzrn;
                if (iArr2[i15] == i14) {
                    zzsb = zzsbArr2[i15];
                } else {
                    zzsb = null;
                }
                zzsbArr3[i15] = zzsb;
            }
            int i16 = i14;
            ArrayList arrayList2 = arrayList;
            zzrn[] zzrnArr5 = zzrnArr4;
            zzsb[] zzsbArr4 = zzsbArr3;
            long zzq = this.zza[i14].zzq(zzsbArr3, zArr, zzrnArr4, zArr2, j12);
            if (i16 == 0) {
                j12 = zzq;
            } else if (zzq != j12) {
                throw new IllegalStateException("Children enabled at different positions.");
            }
            boolean z11 = false;
            for (int i17 = 0; i17 < zzsbArr2.length; i17++) {
                boolean z12 = true;
                if (iArr2[i17] == i16) {
                    zzrn zzrn3 = zzrnArr5[i17];
                    zzrn3.getClass();
                    zzrnArr3[i17] = zzrn3;
                    this.zzb.put(zzrn3, Integer.valueOf(i16));
                    z11 = true;
                } else if (iArr[i17] == i16) {
                    if (zzrnArr5[i17] != null) {
                        z12 = false;
                    }
                    zzdy.zzf(z12);
                }
            }
            if (z11) {
                arrayList2.add(this.zza[i16]);
            }
            i14 = i16 + 1;
            arrayList = arrayList2;
            zzrnArr4 = zzrnArr5;
            zzsbArr3 = zzsbArr4;
        }
        System.arraycopy(zzrnArr3, 0, zzrnArr2, 0, length);
        zzpy[] zzpyArr2 = (zzpy[]) arrayList.toArray(new zzpy[0]);
        this.zzf = zzpyArr2;
        this.zzg = new zzpl(zzpyArr2);
        return j12;
    }
}
