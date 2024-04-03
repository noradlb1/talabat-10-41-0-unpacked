package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;

final class zzgjh extends zzgjn {
    private final byte[] zze;
    private int zzf;
    private int zzg;
    private int zzh;
    private final int zzi;
    private int zzj;
    private int zzk = Integer.MAX_VALUE;

    public /* synthetic */ zzgjh(byte[] bArr, int i11, int i12, boolean z11, zzgjg zzgjg) {
        super((zzgjm) null);
        this.zze = bArr;
        this.zzf = i12 + i11;
        this.zzh = i11;
        this.zzi = i11;
    }

    private final void zzI() {
        int i11 = this.zzf + this.zzg;
        this.zzf = i11;
        int i12 = i11 - this.zzi;
        int i13 = this.zzk;
        if (i12 > i13) {
            int i14 = i12 - i13;
            this.zzg = i14;
            this.zzf = i11 - i14;
            return;
        }
        this.zzg = 0;
    }

    public final void zzA(int i11) {
        this.zzk = i11;
        zzI();
    }

    public final void zzB(int i11) throws IOException {
        if (i11 >= 0) {
            int i12 = this.zzf;
            int i13 = this.zzh;
            if (i11 <= i12 - i13) {
                this.zzh = i13 + i11;
                return;
            }
        }
        if (i11 < 0) {
            throw zzgkx.zzf();
        }
        throw zzgkx.zzj();
    }

    public final boolean zzC() throws IOException {
        return this.zzh == this.zzf;
    }

    public final boolean zzD() throws IOException {
        return zzr() != 0;
    }

    public final boolean zzE(int i11) throws IOException {
        int zzm;
        int i12 = i11 & 7;
        int i13 = 0;
        if (i12 == 0) {
            if (this.zzf - this.zzh >= 10) {
                while (i13 < 10) {
                    byte[] bArr = this.zze;
                    int i14 = this.zzh;
                    this.zzh = i14 + 1;
                    if (bArr[i14] < 0) {
                        i13++;
                    }
                }
                throw zzgkx.zze();
            }
            while (i13 < 10) {
                if (zza() < 0) {
                    i13++;
                }
            }
            throw zzgkx.zze();
            return true;
        } else if (i12 == 1) {
            zzB(8);
            return true;
        } else if (i12 == 2) {
            zzB(zzj());
            return true;
        } else if (i12 == 3) {
            do {
                zzm = zzm();
                if (zzm == 0 || !zzE(zzm)) {
                    zzz(((i11 >>> 3) << 3) | 4);
                }
                zzm = zzm();
                break;
            } while (!zzE(zzm));
            zzz(((i11 >>> 3) << 3) | 4);
            return true;
        } else if (i12 == 4) {
            return false;
        } else {
            if (i12 == 5) {
                zzB(4);
                return true;
            }
            throw zzgkx.zza();
        }
    }

    public final byte zza() throws IOException {
        int i11 = this.zzh;
        if (i11 != this.zzf) {
            byte[] bArr = this.zze;
            this.zzh = i11 + 1;
            return bArr[i11];
        }
        throw zzgkx.zzj();
    }

    public final double zzb() throws IOException {
        return Double.longBitsToDouble(zzq());
    }

    public final float zzc() throws IOException {
        return Float.intBitsToFloat(zzi());
    }

    public final int zzd() {
        return this.zzh - this.zzi;
    }

    public final int zze(int i11) throws zzgkx {
        if (i11 >= 0) {
            int i12 = i11 + (this.zzh - this.zzi);
            if (i12 >= 0) {
                int i13 = this.zzk;
                if (i12 <= i13) {
                    this.zzk = i12;
                    zzI();
                    return i13;
                }
                throw zzgkx.zzj();
            }
            throw zzgkx.zzg();
        }
        throw zzgkx.zzf();
    }

    public final int zzf() throws IOException {
        return zzj();
    }

    public final int zzg() throws IOException {
        return zzi();
    }

    public final int zzh() throws IOException {
        return zzj();
    }

    public final int zzi() throws IOException {
        int i11 = this.zzh;
        if (this.zzf - i11 >= 4) {
            byte[] bArr = this.zze;
            this.zzh = i11 + 4;
            return ((bArr[i11 + 3] & 255) << Ascii.CAN) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << Ascii.DLE);
        }
        throw zzgkx.zzj();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0067, code lost:
        if (r2[r3] >= 0) goto L_0x0069;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzj() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.zzh
            int r1 = r5.zzf
            if (r1 != r0) goto L_0x0007
            goto L_0x006c
        L_0x0007:
            byte[] r2 = r5.zze
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r5.zzh = r3
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x006c
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0023
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0069
        L_0x0023:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0030
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002e:
            r1 = r3
            goto L_0x0069
        L_0x0030:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003e
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0069
        L_0x003e:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0069
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0069
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002e
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 < 0) goto L_0x006c
        L_0x0069:
            r5.zzh = r1
            return r0
        L_0x006c:
            long r0 = r5.zzs()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgjh.zzj():int");
    }

    public final int zzk() throws IOException {
        return zzi();
    }

    public final int zzl() throws IOException {
        return zzgjn.zzF(zzj());
    }

    public final int zzm() throws IOException {
        if (zzC()) {
            this.zzj = 0;
            return 0;
        }
        int zzj2 = zzj();
        this.zzj = zzj2;
        if ((zzj2 >>> 3) != 0) {
            return zzj2;
        }
        throw zzgkx.zzc();
    }

    public final int zzn() throws IOException {
        return zzj();
    }

    public final long zzo() throws IOException {
        return zzq();
    }

    public final long zzp() throws IOException {
        return zzr();
    }

    public final long zzq() throws IOException {
        int i11 = this.zzh;
        if (this.zzf - i11 >= 8) {
            byte[] bArr = this.zze;
            this.zzh = i11 + 8;
            return ((((long) bArr[i11 + 7]) & 255) << 56) | (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48);
        }
        throw zzgkx.zzj();
    }

    public final long zzr() throws IOException {
        long j11;
        long j12;
        long j13;
        long j14;
        byte b11;
        int i11 = this.zzh;
        int i12 = this.zzf;
        if (i12 != i11) {
            byte[] bArr = this.zze;
            int i13 = i11 + 1;
            byte b12 = bArr[i11];
            if (b12 >= 0) {
                this.zzh = i13;
                return (long) b12;
            } else if (i12 - i13 >= 9) {
                int i14 = i13 + 1;
                byte b13 = b12 ^ (bArr[i13] << 7);
                if (b13 < 0) {
                    b11 = b13 ^ Byte.MIN_VALUE;
                } else {
                    int i15 = i14 + 1;
                    byte b14 = b13 ^ (bArr[i14] << Ascii.SO);
                    if (b14 >= 0) {
                        j12 = (long) (b14 ^ 16256);
                    } else {
                        i14 = i15 + 1;
                        byte b15 = b14 ^ (bArr[i15] << Ascii.NAK);
                        if (b15 < 0) {
                            b11 = b15 ^ -2080896;
                        } else {
                            i15 = i14 + 1;
                            long j15 = (((long) bArr[i14]) << 28) ^ ((long) b15);
                            if (j15 >= 0) {
                                j14 = 266354560;
                            } else {
                                int i16 = i15 + 1;
                                long j16 = j15 ^ (((long) bArr[i15]) << 35);
                                if (j16 < 0) {
                                    j13 = -34093383808L;
                                } else {
                                    i15 = i16 + 1;
                                    j15 = j16 ^ (((long) bArr[i16]) << 42);
                                    if (j15 >= 0) {
                                        j14 = 4363953127296L;
                                    } else {
                                        i16 = i15 + 1;
                                        j16 = j15 ^ (((long) bArr[i15]) << 49);
                                        if (j16 < 0) {
                                            j13 = -558586000294016L;
                                        } else {
                                            i15 = i16 + 1;
                                            j12 = (j16 ^ (((long) bArr[i16]) << 56)) ^ 71499008037633920L;
                                            if (j12 < 0) {
                                                i16 = i15 + 1;
                                                if (((long) bArr[i15]) >= 0) {
                                                    j11 = j12;
                                                    i14 = i16;
                                                    this.zzh = i14;
                                                    return j11;
                                                }
                                            }
                                        }
                                    }
                                }
                                j11 = j13 ^ j16;
                                i14 = i16;
                                this.zzh = i14;
                                return j11;
                            }
                            j12 = j15 ^ j14;
                        }
                    }
                    i14 = i15;
                    j11 = j12;
                    this.zzh = i14;
                    return j11;
                }
                j11 = (long) b11;
                this.zzh = i14;
                return j11;
            }
        }
        return zzs();
    }

    public final long zzs() throws IOException {
        long j11 = 0;
        for (int i11 = 0; i11 < 64; i11 += 7) {
            byte zza = zza();
            j11 |= ((long) (zza & Byte.MAX_VALUE)) << i11;
            if ((zza & 128) == 0) {
                return j11;
            }
        }
        throw zzgkx.zze();
    }

    public final long zzt() throws IOException {
        return zzq();
    }

    public final long zzu() throws IOException {
        return zzgjn.zzG(zzr());
    }

    public final long zzv() throws IOException {
        return zzr();
    }

    public final zzgjf zzw() throws IOException {
        int zzj2 = zzj();
        if (zzj2 > 0) {
            int i11 = this.zzf;
            int i12 = this.zzh;
            if (zzj2 <= i11 - i12) {
                zzgjf zzw = zzgjf.zzw(this.zze, i12, zzj2);
                this.zzh += zzj2;
                return zzw;
            }
        }
        if (zzj2 == 0) {
            return zzgjf.zzb;
        }
        if (zzj2 > 0) {
            int i13 = this.zzf;
            int i14 = this.zzh;
            if (zzj2 <= i13 - i14) {
                int i15 = zzj2 + i14;
                this.zzh = i15;
                return zzgjf.zzz(Arrays.copyOfRange(this.zze, i14, i15));
            }
        }
        if (zzj2 <= 0) {
            throw zzgkx.zzf();
        }
        throw zzgkx.zzj();
    }

    public final String zzx() throws IOException {
        int zzj2 = zzj();
        if (zzj2 > 0) {
            int i11 = this.zzf;
            int i12 = this.zzh;
            if (zzj2 <= i11 - i12) {
                String str = new String(this.zze, i12, zzj2, zzgkv.zzb);
                this.zzh += zzj2;
                return str;
            }
        }
        if (zzj2 == 0) {
            return "";
        }
        if (zzj2 < 0) {
            throw zzgkx.zzf();
        }
        throw zzgkx.zzj();
    }

    public final String zzy() throws IOException {
        int zzj2 = zzj();
        if (zzj2 > 0) {
            int i11 = this.zzf;
            int i12 = this.zzh;
            if (zzj2 <= i11 - i12) {
                String zzh2 = zzgnu.zzh(this.zze, i12, zzj2);
                this.zzh += zzj2;
                return zzh2;
            }
        }
        if (zzj2 == 0) {
            return "";
        }
        if (zzj2 <= 0) {
            throw zzgkx.zzf();
        }
        throw zzgkx.zzj();
    }

    public final void zzz(int i11) throws zzgkx {
        if (this.zzj != i11) {
            throw zzgkx.zzb();
        }
    }
}
