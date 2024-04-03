package com.google.android.gms.internal.ads;

import com.google.android.exoplayer2.C;
import java.io.IOException;

final class zzaek implements zzwf {
    private final zzfk zza;
    private final zzfd zzb = new zzfd();

    public /* synthetic */ zzaek(zzfk zzfk, zzaej zzaej) {
        this.zza = zzfk;
    }

    public final zzwe zza(zzwq zzwq, long j11) throws IOException {
        int zzh;
        long j12;
        long zze = zzwq.zze();
        int min = (int) Math.min(20000, zzwq.zzc() - zze);
        this.zzb.zzC(min);
        ((zzwk) zzwq).zzm(this.zzb.zzH(), 0, min, false);
        zzfd zzfd = this.zzb;
        int i11 = -1;
        int i12 = -1;
        long j13 = -9223372036854775807L;
        while (zzfd.zza() >= 4) {
            if (zzael.zzh(zzfd.zzH(), zzfd.zzc()) != 442) {
                zzfd.zzG(1);
            } else {
                zzfd.zzG(4);
                long zzc = zzaem.zzc(zzfd);
                if (zzc != C.TIME_UNSET) {
                    long zzb2 = this.zza.zzb(zzc);
                    if (zzb2 > j11) {
                        if (j13 == C.TIME_UNSET) {
                            return zzwe.zzd(zzb2, zze);
                        }
                        j12 = (long) i12;
                    } else if (100000 + zzb2 > j11) {
                        j12 = (long) zzfd.zzc();
                    } else {
                        i12 = zzfd.zzc();
                        j13 = zzb2;
                    }
                    return zzwe.zze(zze + j12);
                }
                int zzd = zzfd.zzd();
                if (zzfd.zza() >= 10) {
                    zzfd.zzG(9);
                    int zzk = zzfd.zzk() & 7;
                    if (zzfd.zza() >= zzk) {
                        zzfd.zzG(zzk);
                        if (zzfd.zza() >= 4) {
                            if (zzael.zzh(zzfd.zzH(), zzfd.zzc()) == 443) {
                                zzfd.zzG(4);
                                int zzo = zzfd.zzo();
                                if (zzfd.zza() < zzo) {
                                    zzfd.zzF(zzd);
                                } else {
                                    zzfd.zzG(zzo);
                                }
                            }
                            while (true) {
                                if (zzfd.zza() < 4 || (zzh = zzael.zzh(zzfd.zzH(), zzfd.zzc())) == 442 || zzh == 441 || (zzh >>> 8) != 1) {
                                    break;
                                }
                                zzfd.zzG(4);
                                if (zzfd.zza() < 2) {
                                    zzfd.zzF(zzd);
                                    break;
                                }
                                zzfd.zzF(Math.min(zzfd.zzd(), zzfd.zzc() + zzfd.zzo()));
                            }
                        } else {
                            zzfd.zzF(zzd);
                        }
                    } else {
                        zzfd.zzF(zzd);
                    }
                } else {
                    zzfd.zzF(zzd);
                }
                i11 = zzfd.zzc();
            }
        }
        if (j13 != C.TIME_UNSET) {
            return zzwe.zzf(j13, zze + ((long) i11));
        }
        return zzwe.zza;
    }

    public final void zzb() {
        zzfd zzfd = this.zzb;
        byte[] bArr = zzfn.zzf;
        int length = bArr.length;
        zzfd.zzD(bArr, 0);
    }
}
