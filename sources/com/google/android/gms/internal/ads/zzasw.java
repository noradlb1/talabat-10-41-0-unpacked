package com.google.android.gms.internal.ads;

import android.support.v4.media.session.PlaybackStateCompat;
import com.google.android.exoplayer2.C;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

public final class zzasw implements zzarj, zzarq {
    public static final zzarl zza = new zzasu();
    private static final int zzb = zzaxb.zzg("qt  ");
    private final zzawu zzc = new zzawu(zzaws.zza);
    private final zzawu zzd = new zzawu(4);
    private final zzawu zze = new zzawu(16);
    private final Stack<zzase> zzf = new Stack<>();
    private int zzg;
    private int zzh;
    private long zzi;
    private int zzj;
    private zzawu zzk;
    private int zzl;
    private int zzm;
    private zzark zzn;
    private zzasv[] zzo;
    private long zzp;
    private boolean zzq;

    private final void zzh() {
        this.zzg = 0;
        this.zzj = 0;
    }

    private final void zzi(long j11) throws zzapj {
        zzatr zzatr;
        zzatr zzatr2;
        zzarn zzarn;
        zzasy zza2;
        while (!this.zzf.isEmpty() && this.zzf.peek().zza == j11) {
            zzase pop = this.zzf.pop();
            if (pop.zzaR == zzasg.zzE) {
                ArrayList arrayList = new ArrayList();
                zzarn zzarn2 = new zzarn();
                zzasf zzb2 = pop.zzb(zzasg.zzaC);
                if (zzb2 != null) {
                    zzatr = zzasn.zzc(zzb2, this.zzq);
                    if (zzatr != null) {
                        zzarn2.zzb(zzatr);
                    }
                } else {
                    zzatr = null;
                }
                long j12 = C.TIME_UNSET;
                long j13 = Long.MAX_VALUE;
                int i11 = 0;
                while (i11 < pop.zzc.size()) {
                    zzase zzase = pop.zzc.get(i11);
                    if (zzase.zzaR == zzasg.zzG && (zza2 = zzasn.zza(zzase, pop.zzb(zzasg.zzF), C.TIME_UNSET, (zzarf) null, this.zzq)) != null) {
                        zzatb zzb3 = zzasn.zzb(zza2, zzase.zza(zzasg.zzH).zza(zzasg.zzI).zza(zzasg.zzJ), zzarn2);
                        if (zzb3.zza != 0) {
                            zzasv zzasv = new zzasv(zza2, zzb3, this.zzn.zzbq(i11, zza2.zzb));
                            zzapg zze2 = zza2.zzf.zze(zzb3.zzd + 30);
                            if (zza2.zzb == 1) {
                                if (zzarn2.zza()) {
                                    zze2 = zze2.zzd(zzarn2.zzb, zzarn2.zzc);
                                }
                                if (zzatr != null) {
                                    zze2 = zze2.zzf(zzatr);
                                }
                            }
                            zzasv.zzc.zza(zze2);
                            zzarn = zzarn2;
                            zzatr2 = zzatr;
                            long max = Math.max(j12, zza2.zze);
                            arrayList.add(zzasv);
                            long j14 = zzb3.zzb[0];
                            if (j14 < j13) {
                                j12 = max;
                                j13 = j14;
                            } else {
                                j12 = max;
                            }
                            i11++;
                            zzarn2 = zzarn;
                            zzatr = zzatr2;
                        }
                    }
                    zzarn = zzarn2;
                    zzatr2 = zzatr;
                    i11++;
                    zzarn2 = zzarn;
                    zzatr = zzatr2;
                }
                this.zzp = j12;
                this.zzo = (zzasv[]) arrayList.toArray(new zzasv[arrayList.size()]);
                this.zzn.zzb();
                this.zzn.zzc(this);
                this.zzf.clear();
                this.zzg = 2;
            } else if (!this.zzf.isEmpty()) {
                this.zzf.peek().zzc(pop);
            }
        }
        if (this.zzg != 2) {
            zzh();
        }
    }

    public final long zza() {
        return this.zzp;
    }

    public final long zzb(long j11) {
        long j12 = Long.MAX_VALUE;
        for (zzasv zzasv : this.zzo) {
            zzatb zzatb = zzasv.zzb;
            int zza2 = zzatb.zza(j11);
            if (zza2 == -1) {
                zza2 = zzatb.zzb(j11);
            }
            long j13 = zzatb.zzb[zza2];
            if (j13 < j12) {
                j12 = j13;
            }
        }
        return j12;
    }

    public final boolean zzc() {
        return true;
    }

    public final void zzd(zzark zzark) {
        this.zzn = zzark;
    }

    public final void zze(long j11, long j12) {
        this.zzf.clear();
        this.zzj = 0;
        this.zzl = 0;
        this.zzm = 0;
        if (j11 == 0) {
            zzh();
            return;
        }
        zzasv[] zzasvArr = this.zzo;
        if (zzasvArr != null) {
            for (zzasv zzasv : zzasvArr) {
                zzatb zzatb = zzasv.zzb;
                int zza2 = zzatb.zza(j12);
                if (zza2 == -1) {
                    zza2 = zzatb.zzb(j12);
                }
                zzasv.zzd = zza2;
            }
        }
    }

    public final int zzf(zzari zzari, zzaro zzaro) throws IOException, InterruptedException {
        boolean z11;
        boolean z12;
        zzasv[] zzasvArr;
        boolean z13;
        boolean z14;
        zzari zzari2 = zzari;
        zzaro zzaro2 = zzaro;
        while (true) {
            int i11 = this.zzg;
            if (i11 == 0) {
                if (this.zzj == 0) {
                    if (!zzari2.zzh(this.zze.zza, 0, 8, true)) {
                        return -1;
                    }
                    this.zzj = 8;
                    this.zze.zzv(0);
                    this.zzi = this.zze.zzm();
                    this.zzh = this.zze.zze();
                }
                if (this.zzi == 1) {
                    zzari2.zzh(this.zze.zza, 8, 8, false);
                    this.zzj += 8;
                    this.zzi = this.zze.zzn();
                }
                int i12 = this.zzh;
                if (i12 == zzasg.zzE || i12 == zzasg.zzG || i12 == zzasg.zzH || i12 == zzasg.zzI || i12 == zzasg.zzJ || i12 == zzasg.zzS) {
                    long zzd2 = (zzari.zzd() + this.zzi) - ((long) this.zzj);
                    this.zzf.add(new zzase(this.zzh, zzd2));
                    if (this.zzi == ((long) this.zzj)) {
                        zzi(zzd2);
                    } else {
                        zzh();
                    }
                } else {
                    if (i12 == zzasg.zzU || i12 == zzasg.zzF || i12 == zzasg.zzV || i12 == zzasg.zzW || i12 == zzasg.zzao || i12 == zzasg.zzap || i12 == zzasg.zzaq || i12 == zzasg.zzT || i12 == zzasg.zzar || i12 == zzasg.zzas || i12 == zzasg.zzat || i12 == zzasg.zzau || i12 == zzasg.zzav || i12 == zzasg.zzR || i12 == zzasg.zzd || i12 == zzasg.zzaC) {
                        if (this.zzj == 8) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        zzawm.zze(z11);
                        if (this.zzi <= 2147483647L) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        zzawm.zze(z12);
                        zzawu zzawu = new zzawu((int) this.zzi);
                        this.zzk = zzawu;
                        System.arraycopy(this.zze.zza, 0, zzawu.zza, 0, 8);
                    } else {
                        this.zzk = null;
                    }
                    this.zzg = 1;
                }
            } else if (i11 != 1) {
                long j11 = Long.MAX_VALUE;
                int i13 = -1;
                int i14 = 0;
                while (true) {
                    zzasvArr = this.zzo;
                    if (i14 >= zzasvArr.length) {
                        break;
                    }
                    zzasv zzasv = zzasvArr[i14];
                    int i15 = zzasv.zzd;
                    zzatb zzatb = zzasv.zzb;
                    if (i15 != zzatb.zza) {
                        long j12 = zzatb.zzb[i15];
                        if (j12 < j11) {
                            i13 = i14;
                            j11 = j12;
                        }
                    }
                    i14++;
                }
                if (i13 == -1) {
                    return -1;
                }
                zzasv zzasv2 = zzasvArr[i13];
                zzars zzars = zzasv2.zzc;
                int i16 = zzasv2.zzd;
                zzatb zzatb2 = zzasv2.zzb;
                long j13 = zzatb2.zzb[i16];
                int i17 = zzatb2.zzc[i16];
                if (zzasv2.zza.zzg == 1) {
                    j13 += 8;
                    i17 -= 8;
                }
                long zzd3 = (j13 - zzari.zzd()) + ((long) this.zzl);
                if (zzd3 < 0 || zzd3 >= PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                    zzaro2.zza = j13;
                    return 1;
                }
                int i18 = (int) zzd3;
                boolean z15 = false;
                zzari2.zzi(i18, false);
                int i19 = zzasv2.zza.zzk;
                if (i19 == 0) {
                    while (true) {
                        int i21 = this.zzl;
                        if (i21 >= i17) {
                            break;
                        }
                        int zzd4 = zzars.zzd(zzari2, i17 - i21, false);
                        this.zzl += zzd4;
                        this.zzm -= zzd4;
                    }
                } else {
                    byte[] bArr = this.zzd.zza;
                    bArr[0] = 0;
                    bArr[1] = 0;
                    bArr[2] = 0;
                    int i22 = 4 - i19;
                    while (this.zzl < i17) {
                        int i23 = this.zzm;
                        if (i23 == 0) {
                            zzari2.zzh(this.zzd.zza, i22, i19, z15);
                            this.zzd.zzv(z15 ? 1 : 0);
                            this.zzm = this.zzd.zzi();
                            this.zzc.zzv(z15);
                            zzars.zzb(this.zzc, 4);
                            this.zzl += 4;
                            i17 += i22;
                        } else {
                            int zzd5 = zzars.zzd(zzari2, i23, z15);
                            this.zzl += zzd5;
                            this.zzm -= zzd5;
                            z15 = false;
                        }
                    }
                }
                int i24 = i17;
                zzatb zzatb3 = zzasv2.zzb;
                zzars.zzc(zzatb3.zze[i16], zzatb3.zzf[i16], i24, 0, (zzarr) null);
                zzasv2.zzd++;
                this.zzl = 0;
                this.zzm = 0;
                return 0;
            } else {
                long j14 = this.zzi - ((long) this.zzj);
                long zzd6 = zzari.zzd() + j14;
                zzawu zzawu2 = this.zzk;
                if (zzawu2 != null) {
                    zzari2.zzh(zzawu2.zza, this.zzj, (int) j14, false);
                    if (this.zzh == zzasg.zzd) {
                        zzawu zzawu3 = this.zzk;
                        zzawu3.zzv(8);
                        if (zzawu3.zze() == zzb) {
                            z14 = true;
                        } else {
                            zzawu3.zzw(4);
                            while (true) {
                                if (zzawu3.zza() > 0) {
                                    if (zzawu3.zze() == zzb) {
                                        break;
                                    }
                                } else {
                                    z14 = false;
                                    break;
                                }
                            }
                            z14 = true;
                        }
                        this.zzq = z14;
                    } else if (!this.zzf.isEmpty()) {
                        this.zzf.peek().zzd(new zzasf(this.zzh, this.zzk));
                    }
                } else if (j14 < PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
                    zzari2.zzi((int) j14, false);
                } else {
                    zzaro2.zza = zzari.zzd() + j14;
                    z13 = true;
                    zzi(zzd6);
                    if (z13 && this.zzg != 2) {
                        return 1;
                    }
                }
                z13 = false;
                zzi(zzd6);
                return 1;
            }
        }
    }

    public final boolean zzg(zzari zzari) throws IOException, InterruptedException {
        return zzasx.zzb(zzari);
    }
}
