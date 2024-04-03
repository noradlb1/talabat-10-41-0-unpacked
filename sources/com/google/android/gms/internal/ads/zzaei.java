package com.google.android.gms.internal.ads;

import android.util.Log;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;

public final class zzaei implements zzafe {
    private final zzadr zza;
    private final zzfc zzb = new zzfc(new byte[10], 10);
    private int zzc = 0;
    private int zzd;
    private zzfk zze;
    private boolean zzf;
    private boolean zzg;
    private boolean zzh;
    private int zzi;
    private int zzj;
    private boolean zzk;

    public zzaei(zzadr zzadr) {
        this.zza = zzadr;
    }

    private final void zzd(int i11) {
        this.zzc = i11;
        this.zzd = 0;
    }

    private final boolean zze(zzfd zzfd, @Nullable byte[] bArr, int i11) {
        int min = Math.min(zzfd.zza(), i11 - this.zzd);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            zzfd.zzG(min);
        } else {
            zzfd.zzB(bArr, this.zzd, min);
        }
        int i12 = this.zzd + min;
        this.zzd = i12;
        if (i12 == i11) {
            return true;
        }
        return false;
    }

    public final void zza(zzfd zzfd, int i11) throws zzbj {
        int i12;
        long j11;
        int i13;
        zzfd zzfd2 = zzfd;
        zzdy.zzb(this.zze);
        int i14 = -1;
        int i15 = 2;
        if ((i11 & 1) != 0) {
            int i16 = this.zzc;
            if (!(i16 == 0 || i16 == 1)) {
                if (i16 != 2) {
                    int i17 = this.zzj;
                    if (i17 != -1) {
                        StringBuilder sb2 = new StringBuilder(59);
                        sb2.append("Unexpected start indicator: expected ");
                        sb2.append(i17);
                        sb2.append(" more bytes");
                        Log.w("PesReader", sb2.toString());
                    }
                    this.zza.zzc();
                } else {
                    Log.w("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            zzd(1);
        }
        int i18 = i11;
        while (zzfd.zza() > 0) {
            int i19 = this.zzc;
            if (i19 != 0) {
                int i21 = 0;
                if (i19 != 1) {
                    if (i19 != i15) {
                        int zza2 = zzfd.zza();
                        int i22 = this.zzj;
                        if (i22 != i14) {
                            i21 = zza2 - i22;
                        }
                        if (i21 > 0) {
                            zza2 -= i21;
                            zzfd2.zzE(zzfd.zzc() + zza2);
                        }
                        this.zza.zza(zzfd2);
                        int i23 = this.zzj;
                        if (i23 != i14) {
                            int i24 = i23 - zza2;
                            this.zzj = i24;
                            if (i24 == 0) {
                                this.zza.zzc();
                                zzd(1);
                            }
                        }
                    } else {
                        if (zze(zzfd2, this.zzb.zza, Math.min(10, this.zzi)) && zze(zzfd2, (byte[]) null, this.zzi)) {
                            this.zzb.zzh(0);
                            if (this.zzf) {
                                this.zzb.zzj(4);
                                int zzc2 = this.zzb.zzc(3);
                                this.zzb.zzj(1);
                                int zzc3 = this.zzb.zzc(15);
                                this.zzb.zzj(1);
                                long zzc4 = ((long) (zzc3 << 15)) | (((long) zzc2) << 30) | ((long) this.zzb.zzc(15));
                                this.zzb.zzj(1);
                                if (!this.zzh && this.zzg) {
                                    this.zzb.zzj(4);
                                    int zzc5 = this.zzb.zzc(3);
                                    this.zzb.zzj(1);
                                    int zzc6 = this.zzb.zzc(15);
                                    this.zzb.zzj(1);
                                    int zzc7 = this.zzb.zzc(15);
                                    this.zzb.zzj(1);
                                    this.zze.zzb((((long) zzc5) << 30) | ((long) (zzc6 << 15)) | ((long) zzc7));
                                    this.zzh = true;
                                }
                                j11 = this.zze.zzb(zzc4);
                            } else {
                                j11 = C.TIME_UNSET;
                            }
                            if (true != this.zzk) {
                                i13 = 0;
                            } else {
                                i13 = 4;
                            }
                            i18 |= i13;
                            this.zza.zzd(j11, i18);
                            zzd(3);
                            i14 = -1;
                            i15 = 2;
                        }
                    }
                    i12 = i15;
                } else if (zze(zzfd2, this.zzb.zza, 9)) {
                    int i25 = 0;
                    this.zzb.zzh(0);
                    int zzc8 = this.zzb.zzc(24);
                    if (zzc8 != 1) {
                        StringBuilder sb3 = new StringBuilder(41);
                        sb3.append("Unexpected start code prefix: ");
                        sb3.append(zzc8);
                        Log.w("PesReader", sb3.toString());
                        i14 = -1;
                        this.zzj = -1;
                        i12 = 2;
                    } else {
                        this.zzb.zzj(8);
                        int zzc9 = this.zzb.zzc(16);
                        this.zzb.zzj(5);
                        this.zzk = this.zzb.zzl();
                        i12 = 2;
                        this.zzb.zzj(2);
                        this.zzf = this.zzb.zzl();
                        this.zzg = this.zzb.zzl();
                        this.zzb.zzj(6);
                        int zzc10 = this.zzb.zzc(8);
                        this.zzi = zzc10;
                        if (zzc9 == 0) {
                            this.zzj = -1;
                            i14 = -1;
                        } else {
                            int i26 = (zzc9 - 3) - zzc10;
                            this.zzj = i26;
                            if (i26 < 0) {
                                StringBuilder sb4 = new StringBuilder(47);
                                sb4.append("Found negative packet payload size: ");
                                sb4.append(i26);
                                Log.w("PesReader", sb4.toString());
                                i14 = -1;
                                this.zzj = -1;
                            } else {
                                i14 = -1;
                            }
                        }
                        i25 = 2;
                    }
                    zzd(i25);
                } else {
                    i14 = -1;
                    i12 = 2;
                }
            } else {
                i12 = i15;
                zzfd2.zzG(zzfd.zza());
            }
            i15 = i12;
        }
    }

    public final void zzb(zzfk zzfk, zzws zzws, zzafd zzafd) {
        this.zze = zzfk;
        this.zza.zzb(zzws, zzafd);
    }

    public final void zzc() {
        this.zzc = 0;
        this.zzd = 0;
        this.zzh = false;
        this.zza.zze();
    }
}
