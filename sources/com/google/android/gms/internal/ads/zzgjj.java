package com.google.android.gms.internal.ads;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;

final class zzgjj extends zzgjn {
    private final Iterable<ByteBuffer> zze;
    private final Iterator<ByteBuffer> zzf;
    private ByteBuffer zzg;
    private int zzh;
    private int zzi;
    private int zzj = Integer.MAX_VALUE;
    private int zzk;
    private int zzl;
    private long zzm;
    private long zzn;
    private long zzo;

    public /* synthetic */ zzgjj(Iterable iterable, int i11, boolean z11, zzgji zzgji) {
        super((zzgjm) null);
        this.zzh = i11;
        this.zze = iterable;
        this.zzf = iterable.iterator();
        this.zzl = 0;
        if (i11 == 0) {
            this.zzg = zzgkv.zze;
            this.zzm = 0;
            this.zzn = 0;
            this.zzo = 0;
            return;
        }
        zzM();
    }

    private final int zzI() {
        return (int) ((((long) (this.zzh - this.zzl)) - this.zzm) + this.zzn);
    }

    private final void zzJ() throws zzgkx {
        if (this.zzf.hasNext()) {
            zzM();
            return;
        }
        throw zzgkx.zzj();
    }

    private final void zzK(byte[] bArr, int i11, int i12) throws IOException {
        if (i12 <= zzI()) {
            int i13 = i12;
            while (i13 > 0) {
                if (this.zzo - this.zzm == 0) {
                    zzJ();
                }
                int min = Math.min(i13, (int) (this.zzo - this.zzm));
                long j11 = (long) min;
                zzgnp.zzo(this.zzm, bArr, (long) (i12 - i13), j11);
                i13 -= min;
                this.zzm += j11;
            }
        } else if (i12 > 0) {
            throw zzgkx.zzj();
        }
    }

    private final void zzL() {
        int i11 = this.zzh + this.zzi;
        this.zzh = i11;
        int i12 = this.zzj;
        if (i11 > i12) {
            int i13 = i11 - i12;
            this.zzi = i13;
            this.zzh = i11 - i13;
            return;
        }
        this.zzi = 0;
    }

    private final void zzM() {
        ByteBuffer next = this.zzf.next();
        this.zzg = next;
        this.zzl += (int) (this.zzm - this.zzn);
        long position = (long) next.position();
        this.zzm = position;
        this.zzn = position;
        this.zzo = (long) this.zzg.limit();
        long zze2 = zzgnp.zze(this.zzg);
        this.zzm += zze2;
        this.zzn += zze2;
        this.zzo += zze2;
    }

    public final void zzA(int i11) {
        this.zzj = i11;
        zzL();
    }

    public final void zzB(int i11) throws IOException {
        if (i11 >= 0 && ((long) i11) <= (((long) (this.zzh - this.zzl)) - this.zzm) + this.zzn) {
            while (i11 > 0) {
                if (this.zzo - this.zzm == 0) {
                    zzJ();
                }
                int min = Math.min(i11, (int) (this.zzo - this.zzm));
                i11 -= min;
                this.zzm += (long) min;
            }
        } else if (i11 < 0) {
            throw zzgkx.zzf();
        } else {
            throw zzgkx.zzj();
        }
    }

    public final boolean zzC() throws IOException {
        return (((long) this.zzl) + this.zzm) - this.zzn == ((long) this.zzh);
    }

    public final boolean zzD() throws IOException {
        return zzr() != 0;
    }

    public final boolean zzE(int i11) throws IOException {
        int zzm2;
        int i12 = i11 & 7;
        if (i12 == 0) {
            for (int i13 = 0; i13 < 10; i13++) {
                if (zza() >= 0) {
                    return true;
                }
            }
            throw zzgkx.zze();
        } else if (i12 == 1) {
            zzB(8);
            return true;
        } else if (i12 == 2) {
            zzB(zzj());
            return true;
        } else if (i12 == 3) {
            do {
                zzm2 = zzm();
                if (zzm2 == 0 || !zzE(zzm2)) {
                    zzz(((i11 >>> 3) << 3) | 4);
                }
                zzm2 = zzm();
                break;
            } while (!zzE(zzm2));
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
        if (this.zzo - this.zzm == 0) {
            zzJ();
        }
        long j11 = this.zzm;
        this.zzm = 1 + j11;
        return zzgnp.zza(j11);
    }

    public final double zzb() throws IOException {
        return Double.longBitsToDouble(zzq());
    }

    public final float zzc() throws IOException {
        return Float.intBitsToFloat(zzi());
    }

    public final int zzd() {
        return (int) ((((long) this.zzl) + this.zzm) - this.zzn);
    }

    public final int zze(int i11) throws zzgkx {
        if (i11 >= 0) {
            int zzd = i11 + zzd();
            int i12 = this.zzj;
            if (zzd <= i12) {
                this.zzj = zzd;
                zzL();
                return i12;
            }
            throw zzgkx.zzj();
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
        byte zza;
        byte zza2;
        long j11 = this.zzo;
        long j12 = this.zzm;
        if (j11 - j12 >= 4) {
            this.zzm = 4 + j12;
            zza = (zzgnp.zza(j12) & 255) | ((zzgnp.zza(1 + j12) & 255) << 8) | ((zzgnp.zza(2 + j12) & 255) << Ascii.DLE);
            zza2 = zzgnp.zza(j12 + 3);
        } else {
            zza = (zza() & 255) | ((zza() & 255) << 8) | ((zza() & 255) << Ascii.DLE);
            zza2 = zza();
        }
        return zza | ((zza2 & 255) << Ascii.CAN);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0087, code lost:
        if (com.google.android.gms.internal.ads.zzgnp.zza(r4) >= 0) goto L_0x0089;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzj() throws java.io.IOException {
        /*
            r10 = this;
            long r0 = r10.zzm
            long r2 = r10.zzo
            int r2 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r2 != 0) goto L_0x000a
            goto L_0x008c
        L_0x000a:
            r2 = 1
            long r4 = r0 + r2
            byte r0 = com.google.android.gms.internal.ads.zzgnp.zza(r0)
            if (r0 < 0) goto L_0x001a
            long r4 = r10.zzm
            long r4 = r4 + r2
            r10.zzm = r4
            return r0
        L_0x001a:
            long r6 = r10.zzo
            long r8 = r10.zzm
            long r6 = r6 - r8
            r8 = 10
            int r1 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r1 < 0) goto L_0x008c
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgnp.zza(r4)
            int r1 = r1 << 7
            r0 = r0 ^ r1
            if (r0 >= 0) goto L_0x0033
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0089
        L_0x0033:
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgnp.zza(r6)
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0042
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x0040:
            r6 = r4
            goto L_0x0089
        L_0x0042:
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgnp.zza(r4)
            int r1 = r1 << 21
            r0 = r0 ^ r1
            if (r0 >= 0) goto L_0x0052
            r1 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r1
            goto L_0x0089
        L_0x0052:
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgnp.zza(r6)
            int r6 = r1 << 28
            r0 = r0 ^ r6
            r6 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r6
            if (r1 >= 0) goto L_0x0040
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgnp.zza(r4)
            if (r1 >= 0) goto L_0x0089
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgnp.zza(r6)
            if (r1 >= 0) goto L_0x0040
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgnp.zza(r4)
            if (r1 >= 0) goto L_0x0089
            long r4 = r6 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgnp.zza(r6)
            if (r1 >= 0) goto L_0x0040
            long r6 = r4 + r2
            byte r1 = com.google.android.gms.internal.ads.zzgnp.zza(r4)
            if (r1 < 0) goto L_0x008c
        L_0x0089:
            r10.zzm = r6
            return r0
        L_0x008c:
            long r0 = r10.zzs()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzgjj.zzj():int");
    }

    public final int zzk() throws IOException {
        return zzi();
    }

    public final int zzl() throws IOException {
        return zzgjn.zzF(zzj());
    }

    public final int zzm() throws IOException {
        if (zzC()) {
            this.zzk = 0;
            return 0;
        }
        int zzj2 = zzj();
        this.zzk = zzj2;
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
        long j11 = this.zzo;
        long j12 = this.zzm;
        if (j11 - j12 >= 8) {
            this.zzm = 8 + j12;
            return ((((long) zzgnp.zza(j12 + 7)) & 255) << 56) | (((long) zzgnp.zza(j12)) & 255) | ((((long) zzgnp.zza(1 + j12)) & 255) << 8) | ((((long) zzgnp.zza(2 + j12)) & 255) << 16) | ((((long) zzgnp.zza(3 + j12)) & 255) << 24) | ((((long) zzgnp.zza(4 + j12)) & 255) << 32) | ((((long) zzgnp.zza(5 + j12)) & 255) << 40) | ((((long) zzgnp.zza(6 + j12)) & 255) << 48);
        }
        return ((((long) zza()) & 255) << 56) | (((long) zza()) & 255) | ((((long) zza()) & 255) << 8) | ((((long) zza()) & 255) << 16) | ((((long) zza()) & 255) << 24) | ((((long) zza()) & 255) << 32) | ((((long) zza()) & 255) << 40) | ((((long) zza()) & 255) << 48);
    }

    public final long zzr() throws IOException {
        long j11;
        long j12;
        long j13;
        byte b11;
        long j14 = this.zzm;
        if (this.zzo != j14) {
            long j15 = j14 + 1;
            byte zza = zzgnp.zza(j14);
            if (zza >= 0) {
                this.zzm++;
                return (long) zza;
            } else if (this.zzo - this.zzm >= 10) {
                long j16 = j15 + 1;
                byte zza2 = zza ^ (zzgnp.zza(j15) << 7);
                if (zza2 < 0) {
                    b11 = zza2 ^ Byte.MIN_VALUE;
                } else {
                    long j17 = j16 + 1;
                    byte zza3 = zza2 ^ (zzgnp.zza(j16) << Ascii.SO);
                    if (zza3 >= 0) {
                        j11 = (long) (zza3 ^ 16256);
                    } else {
                        j16 = j17 + 1;
                        byte zza4 = zza3 ^ (zzgnp.zza(j17) << Ascii.NAK);
                        if (zza4 < 0) {
                            b11 = zza4 ^ -2080896;
                        } else {
                            j17 = j16 + 1;
                            long zza5 = ((long) zza4) ^ (((long) zzgnp.zza(j16)) << 28);
                            if (zza5 >= 0) {
                                j13 = 266354560;
                            } else {
                                long j18 = j17 + 1;
                                long zza6 = zza5 ^ (((long) zzgnp.zza(j17)) << 35);
                                if (zza6 < 0) {
                                    j12 = -34093383808L;
                                } else {
                                    j17 = j18 + 1;
                                    zza5 = zza6 ^ (((long) zzgnp.zza(j18)) << 42);
                                    if (zza5 >= 0) {
                                        j13 = 4363953127296L;
                                    } else {
                                        j18 = j17 + 1;
                                        zza6 = zza5 ^ (((long) zzgnp.zza(j17)) << 49);
                                        if (zza6 < 0) {
                                            j12 = -558586000294016L;
                                        } else {
                                            j17 = j18 + 1;
                                            j11 = (zza6 ^ (((long) zzgnp.zza(j18)) << 56)) ^ 71499008037633920L;
                                            if (j11 < 0) {
                                                long j19 = 1 + j17;
                                                if (((long) zzgnp.zza(j17)) >= 0) {
                                                    j16 = j19;
                                                    this.zzm = j16;
                                                    return j11;
                                                }
                                            }
                                        }
                                    }
                                }
                                j11 = zza6 ^ j12;
                                j16 = j18;
                                this.zzm = j16;
                                return j11;
                            }
                            j11 = zza5 ^ j13;
                        }
                    }
                    j16 = j17;
                    this.zzm = j16;
                    return j11;
                }
                j11 = (long) b11;
                this.zzm = j16;
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
            long j11 = (long) zzj2;
            long j12 = this.zzo;
            long j13 = this.zzm;
            if (j11 <= j12 - j13) {
                byte[] bArr = new byte[zzj2];
                zzgnp.zzo(j13, bArr, 0, j11);
                this.zzm += j11;
                return zzgjf.zzz(bArr);
            }
        }
        if (zzj2 > 0 && zzj2 <= zzI()) {
            byte[] bArr2 = new byte[zzj2];
            zzK(bArr2, 0, zzj2);
            return zzgjf.zzz(bArr2);
        } else if (zzj2 == 0) {
            return zzgjf.zzb;
        } else {
            if (zzj2 < 0) {
                throw zzgkx.zzf();
            }
            throw zzgkx.zzj();
        }
    }

    public final String zzx() throws IOException {
        int zzj2 = zzj();
        if (zzj2 > 0) {
            long j11 = (long) zzj2;
            long j12 = this.zzo;
            long j13 = this.zzm;
            if (j11 <= j12 - j13) {
                byte[] bArr = new byte[zzj2];
                zzgnp.zzo(j13, bArr, 0, j11);
                String str = new String(bArr, zzgkv.zzb);
                this.zzm += j11;
                return str;
            }
        }
        if (zzj2 > 0 && zzj2 <= zzI()) {
            byte[] bArr2 = new byte[zzj2];
            zzK(bArr2, 0, zzj2);
            return new String(bArr2, zzgkv.zzb);
        } else if (zzj2 == 0) {
            return "";
        } else {
            if (zzj2 < 0) {
                throw zzgkx.zzf();
            }
            throw zzgkx.zzj();
        }
    }

    public final String zzy() throws IOException {
        int zzj2 = zzj();
        if (zzj2 > 0) {
            long j11 = (long) zzj2;
            long j12 = this.zzo;
            long j13 = this.zzm;
            if (j11 <= j12 - j13) {
                String zzg2 = zzgnu.zzg(this.zzg, (int) (j13 - this.zzn), zzj2);
                this.zzm += j11;
                return zzg2;
            }
        }
        if (zzj2 >= 0 && zzj2 <= zzI()) {
            byte[] bArr = new byte[zzj2];
            zzK(bArr, 0, zzj2);
            return zzgnu.zzh(bArr, 0, zzj2);
        } else if (zzj2 == 0) {
            return "";
        } else {
            if (zzj2 <= 0) {
                throw zzgkx.zzf();
            }
            throw zzgkx.zzj();
        }
    }

    public final void zzz(int i11) throws zzgkx {
        if (this.zzk != i11) {
            throw zzgkx.zzb();
        }
    }
}
