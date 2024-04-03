package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.IdentityHashMap;

final class zzaup implements zzaum, zzaul {
    public final zzaum[] zza;
    private final IdentityHashMap<zzauy, Integer> zzb = new IdentityHashMap<>();
    private zzaul zzc;
    private int zzd;
    private zzavd zze;
    private zzaum[] zzf;
    private zzava zzg;

    public zzaup(zzaum... zzaumArr) {
        this.zza = zzaumArr;
    }

    public final long zzB(zzavh[] zzavhArr, boolean[] zArr, zzauy[] zzauyArr, boolean[] zArr2, long j11) {
        int length;
        boolean z11;
        zzauy zzauy;
        int i11;
        zzavh[] zzavhArr2 = zzavhArr;
        zzauy[] zzauyArr2 = zzauyArr;
        int length2 = zzavhArr2.length;
        int[] iArr = new int[length2];
        int[] iArr2 = new int[length2];
        int i12 = 0;
        while (true) {
            length = zzavhArr2.length;
            if (i12 >= length) {
                break;
            }
            zzauy zzauy2 = zzauyArr2[i12];
            if (zzauy2 == null) {
                i11 = -1;
            } else {
                i11 = this.zzb.get(zzauy2).intValue();
            }
            iArr[i12] = i11;
            iArr2[i12] = -1;
            zzavh zzavh = zzavhArr2[i12];
            if (zzavh != null) {
                zzavc zzd2 = zzavh.zzd();
                int i13 = 0;
                while (true) {
                    zzaum[] zzaumArr = this.zza;
                    if (i13 >= zzaumArr.length) {
                        break;
                    } else if (zzaumArr[i13].zzn().zza(zzd2) != -1) {
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
        zzauy[] zzauyArr3 = new zzauy[length];
        zzauy[] zzauyArr4 = new zzauy[length];
        zzavh[] zzavhArr3 = new zzavh[length];
        ArrayList arrayList = new ArrayList(this.zza.length);
        long j12 = j11;
        int i14 = 0;
        while (i14 < this.zza.length) {
            for (int i15 = 0; i15 < zzavhArr2.length; i15++) {
                zzavh zzavh2 = null;
                if (iArr[i15] == i14) {
                    zzauy = zzauyArr2[i15];
                } else {
                    zzauy = null;
                }
                zzauyArr4[i15] = zzauy;
                if (iArr2[i15] == i14) {
                    zzavh2 = zzavhArr2[i15];
                }
                zzavhArr3[i15] = zzavh2;
            }
            int i16 = i14;
            zzavh[] zzavhArr4 = zzavhArr3;
            ArrayList arrayList2 = arrayList;
            long zzB = this.zza[i14].zzB(zzavhArr3, zArr, zzauyArr4, zArr2, j12);
            if (i16 == 0) {
                j12 = zzB;
            } else if (zzB != j12) {
                throw new IllegalStateException("Children enabled at different positions");
            }
            boolean z12 = false;
            for (int i17 = 0; i17 < zzavhArr2.length; i17++) {
                boolean z13 = true;
                if (iArr2[i17] == i16) {
                    if (zzauyArr4[i17] != null) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    zzawm.zze(z11);
                    zzauy zzauy3 = zzauyArr4[i17];
                    zzauyArr3[i17] = zzauy3;
                    this.zzb.put(zzauy3, Integer.valueOf(i16));
                    z12 = true;
                } else if (iArr[i17] == i16) {
                    if (zzauyArr4[i17] != null) {
                        z13 = false;
                    }
                    zzawm.zze(z13);
                }
            }
            if (z12) {
                arrayList2.add(this.zza[i16]);
            }
            i14 = i16 + 1;
            arrayList = arrayList2;
            zzavhArr3 = zzavhArr4;
            zzauyArr2 = zzauyArr;
        }
        zzauy[] zzauyArr5 = zzauyArr2;
        ArrayList arrayList3 = arrayList;
        System.arraycopy(zzauyArr3, 0, zzauyArr5, 0, length);
        zzaum[] zzaumArr2 = new zzaum[arrayList3.size()];
        this.zzf = zzaumArr2;
        arrayList3.toArray(zzaumArr2);
        this.zzg = new zzaua(this.zzf);
        return j12;
    }

    public final long zza() {
        return this.zzg.zza();
    }

    public final boolean zzbr(long j11) {
        return this.zzg.zzbr(j11);
    }

    public final /* bridge */ /* synthetic */ void zzc(zzava zzava) {
        zzaum zzaum = (zzaum) zzava;
        if (this.zze != null) {
            this.zzc.zzc(this);
        }
    }

    public final void zzd(zzaum zzaum) {
        int i11 = this.zzd - 1;
        this.zzd = i11;
        if (i11 <= 0) {
            int i12 = 0;
            for (zzaum zzn : this.zza) {
                i12 += zzn.zzn().zzb;
            }
            zzavc[] zzavcArr = new zzavc[i12];
            int i13 = 0;
            for (zzaum zzn2 : this.zza) {
                zzavd zzn3 = zzn2.zzn();
                int i14 = zzn3.zzb;
                int i15 = 0;
                while (i15 < i14) {
                    zzavcArr[i13] = zzn3.zzb(i15);
                    i15++;
                    i13++;
                }
            }
            this.zze = new zzavd(zzavcArr);
            this.zzc.zzd(this);
        }
    }

    public final long zzg() {
        long j11 = Long.MAX_VALUE;
        for (zzaum zzg2 : this.zzf) {
            long zzg3 = zzg2.zzg();
            if (zzg3 != Long.MIN_VALUE) {
                j11 = Math.min(j11, zzg3);
            }
        }
        if (j11 == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j11;
    }

    public final long zzh() {
        long zzh = this.zza[0].zzh();
        int i11 = 1;
        while (true) {
            zzaum[] zzaumArr = this.zza;
            if (i11 >= zzaumArr.length) {
                if (zzh != C.TIME_UNSET) {
                    zzaum[] zzaumArr2 = this.zzf;
                    int length = zzaumArr2.length;
                    int i12 = 0;
                    while (i12 < length) {
                        zzaum zzaum = zzaumArr2[i12];
                        if (zzaum == this.zza[0] || zzaum.zzi(zzh) == zzh) {
                            i12++;
                        } else {
                            throw new IllegalStateException("Children seeked to different positions");
                        }
                    }
                }
                return zzh;
            } else if (zzaumArr[i11].zzh() == C.TIME_UNSET) {
                i11++;
            } else {
                throw new IllegalStateException("Child reported discontinuity");
            }
        }
    }

    public final long zzi(long j11) {
        long zzi = this.zzf[0].zzi(j11);
        int i11 = 1;
        while (true) {
            zzaum[] zzaumArr = this.zzf;
            if (i11 >= zzaumArr.length) {
                return zzi;
            }
            if (zzaumArr[i11].zzi(zzi) == zzi) {
                i11++;
            } else {
                throw new IllegalStateException("Children seeked to different positions");
            }
        }
    }

    public final zzavd zzn() {
        return this.zze;
    }

    public final void zzq(long j11) {
        for (zzaum zzq : this.zzf) {
            zzq.zzq(j11);
        }
    }

    public final void zzs() throws IOException {
        for (zzaum zzs : this.zza) {
            zzs.zzs();
        }
    }

    public final void zzw(zzaul zzaul, long j11) {
        this.zzc = zzaul;
        this.zzd = r0;
        for (zzaum zzw : this.zza) {
            zzw.zzw(this, j11);
        }
    }
}
