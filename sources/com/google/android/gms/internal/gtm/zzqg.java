package com.google.android.gms.internal.gtm;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.util.Arrays;

final class zzqg extends zzqe {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private final boolean zzawk;
    private int zzawl;
    private int zzawm;
    private int zzawn;
    private int zzawo;

    private zzqg(byte[] bArr, int i11, int i12, boolean z11) {
        super();
        this.zzawo = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i12 + i11;
        this.pos = i11;
        this.zzawm = i11;
        this.zzawk = z11;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r2[r3] >= 0) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzoa() throws java.io.IOException {
        /*
            r5 = this;
            int r0 = r5.pos
            int r1 = r5.limit
            if (r1 == r0) goto L_0x006b
            byte[] r2 = r5.buffer
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0011
            r5.pos = r3
            return r0
        L_0x0011:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x006b
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0022
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0068
        L_0x0022:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x002f
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002d:
            r1 = r3
            goto L_0x0068
        L_0x002f:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003d
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0068
        L_0x003d:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0068
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0068
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 < 0) goto L_0x006b
        L_0x0068:
            r5.pos = r1
            return r0
        L_0x006b:
            long r0 = r5.zznx()
            int r0 = (int) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzqg.zzoa():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b0, code lost:
        if (((long) r2[r0]) >= 0) goto L_0x00b4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zzob() throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.pos
            int r1 = r11.limit
            if (r1 == r0) goto L_0x00b8
            byte[] r2 = r11.buffer
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r11.pos = r3
            long r0 = (long) r0
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x00b8
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0025
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
        L_0x0022:
            long r2 = (long) r0
            goto L_0x00b5
        L_0x0025:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0036
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            long r0 = (long) r0
            r9 = r0
            r1 = r3
            r2 = r9
            goto L_0x00b5
        L_0x0036:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0044
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0022
        L_0x0044:
            long r3 = (long) r0
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r5 = (long) r1
            r1 = 28
            long r5 = r5 << r1
            long r3 = r3 ^ r5
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x005b
            r1 = 266354560(0xfe03f80, double:1.315966377E-315)
        L_0x0057:
            long r2 = r3 ^ r1
            r1 = r0
            goto L_0x00b5
        L_0x005b:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 35
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0070
            r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
        L_0x006d:
            long r2 = r3 ^ r5
            goto L_0x00b5
        L_0x0070:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 42
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x0083
            r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            goto L_0x0057
        L_0x0083:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 49
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0096
            r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            goto L_0x006d
        L_0x0096:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 56
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x00b3
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x00b8
            goto L_0x00b4
        L_0x00b3:
            r1 = r0
        L_0x00b4:
            r2 = r3
        L_0x00b5:
            r11.pos = r1
            return r2
        L_0x00b8:
            long r0 = r11.zznx()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.gtm.zzqg.zzob():long");
    }

    private final int zzoc() throws IOException {
        int i11 = this.pos;
        if (this.limit - i11 >= 4) {
            byte[] bArr = this.buffer;
            this.pos = i11 + 4;
            return ((bArr[i11 + 3] & 255) << Ascii.CAN) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << Ascii.DLE);
        }
        throw zzrk.zzpp();
    }

    private final long zzod() throws IOException {
        int i11 = this.pos;
        if (this.limit - i11 >= 8) {
            byte[] bArr = this.buffer;
            this.pos = i11 + 8;
            return ((((long) bArr[i11 + 7]) & 255) << 56) | (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48);
        }
        throw zzrk.zzpp();
    }

    private final void zzoe() {
        int i11 = this.limit + this.zzawl;
        this.limit = i11;
        int i12 = i11 - this.zzawm;
        int i13 = this.zzawo;
        if (i12 > i13) {
            int i14 = i12 - i13;
            this.zzawl = i14;
            this.limit = i11 - i14;
            return;
        }
        this.zzawl = 0;
    }

    private final byte zzof() throws IOException {
        int i11 = this.pos;
        if (i11 != this.limit) {
            byte[] bArr = this.buffer;
            this.pos = i11 + 1;
            return bArr[i11];
        }
        throw zzrk.zzpp();
    }

    public final double readDouble() throws IOException {
        return Double.longBitsToDouble(zzod());
    }

    public final float readFloat() throws IOException {
        return Float.intBitsToFloat(zzoc());
    }

    public final String readString() throws IOException {
        int zzoa = zzoa();
        if (zzoa > 0) {
            int i11 = this.limit;
            int i12 = this.pos;
            if (zzoa <= i11 - i12) {
                String str = new String(this.buffer, i12, zzoa, zzre.UTF_8);
                this.pos += zzoa;
                return str;
            }
        }
        if (zzoa == 0) {
            return "";
        }
        if (zzoa < 0) {
            throw zzrk.zzpq();
        }
        throw zzrk.zzpp();
    }

    public final <T extends zzsk> T zza(zzsu<T> zzsu, zzqp zzqp) throws IOException {
        int zzoa = zzoa();
        if (this.zzawf < this.zzawg) {
            int zzaq = zzaq(zzoa);
            this.zzawf++;
            T t11 = (zzsk) zzsu.zza(this, zzqp);
            zzan(0);
            this.zzawf--;
            zzar(zzaq);
            return t11;
        }
        throw zzrk.zzpu();
    }

    public final void zzan(int i11) throws zzrk {
        if (this.zzawn != i11) {
            throw zzrk.zzps();
        }
    }

    public final boolean zzao(int i11) throws IOException {
        int zzni;
        int i12 = i11 & 7;
        int i13 = 0;
        if (i12 == 0) {
            if (this.limit - this.pos >= 10) {
                while (i13 < 10) {
                    byte[] bArr = this.buffer;
                    int i14 = this.pos;
                    this.pos = i14 + 1;
                    if (bArr[i14] < 0) {
                        i13++;
                    }
                }
                throw zzrk.zzpr();
            }
            while (i13 < 10) {
                if (zzof() < 0) {
                    i13++;
                }
            }
            throw zzrk.zzpr();
            return true;
        } else if (i12 == 1) {
            zzas(8);
            return true;
        } else if (i12 == 2) {
            zzas(zzoa());
            return true;
        } else if (i12 == 3) {
            do {
                zzni = zzni();
                if (zzni == 0 || !zzao(zzni)) {
                    zzan(((i11 >>> 3) << 3) | 4);
                }
                zzni = zzni();
                break;
            } while (!zzao(zzni));
            zzan(((i11 >>> 3) << 3) | 4);
            return true;
        } else if (i12 == 4) {
            return false;
        } else {
            if (i12 == 5) {
                zzas(4);
                return true;
            }
            throw zzrk.zzpt();
        }
    }

    public final int zzaq(int i11) throws zzrk {
        if (i11 >= 0) {
            int zznz = i11 + zznz();
            int i12 = this.zzawo;
            if (zznz <= i12) {
                this.zzawo = zznz;
                zzoe();
                return i12;
            }
            throw zzrk.zzpp();
        }
        throw zzrk.zzpq();
    }

    public final void zzar(int i11) {
        this.zzawo = i11;
        zzoe();
    }

    public final void zzas(int i11) throws IOException {
        if (i11 >= 0) {
            int i12 = this.limit;
            int i13 = this.pos;
            if (i11 <= i12 - i13) {
                this.pos = i13 + i11;
                return;
            }
        }
        if (i11 < 0) {
            throw zzrk.zzpq();
        }
        throw zzrk.zzpp();
    }

    public final int zzni() throws IOException {
        if (zzny()) {
            this.zzawn = 0;
            return 0;
        }
        int zzoa = zzoa();
        this.zzawn = zzoa;
        if ((zzoa >>> 3) != 0) {
            return zzoa;
        }
        throw new zzrk("Protocol message contained an invalid tag (zero).");
    }

    public final long zznj() throws IOException {
        return zzob();
    }

    public final long zznk() throws IOException {
        return zzob();
    }

    public final int zznl() throws IOException {
        return zzoa();
    }

    public final long zznm() throws IOException {
        return zzod();
    }

    public final int zznn() throws IOException {
        return zzoc();
    }

    public final boolean zzno() throws IOException {
        return zzob() != 0;
    }

    public final String zznp() throws IOException {
        int zzoa = zzoa();
        if (zzoa > 0) {
            int i11 = this.limit;
            int i12 = this.pos;
            if (zzoa <= i11 - i12) {
                String zzh = zztz.zzh(this.buffer, i12, zzoa);
                this.pos += zzoa;
                return zzh;
            }
        }
        if (zzoa == 0) {
            return "";
        }
        if (zzoa <= 0) {
            throw zzrk.zzpq();
        }
        throw zzrk.zzpp();
    }

    public final zzps zznq() throws IOException {
        byte[] bArr;
        int zzoa = zzoa();
        if (zzoa > 0) {
            int i11 = this.limit;
            int i12 = this.pos;
            if (zzoa <= i11 - i12) {
                zzps zzb = zzps.zzb(this.buffer, i12, zzoa);
                this.pos += zzoa;
                return zzb;
            }
        }
        if (zzoa == 0) {
            return zzps.zzavx;
        }
        if (zzoa > 0) {
            int i13 = this.limit;
            int i14 = this.pos;
            if (zzoa <= i13 - i14) {
                int i15 = zzoa + i14;
                this.pos = i15;
                bArr = Arrays.copyOfRange(this.buffer, i14, i15);
                return zzps.zzf(bArr);
            }
        }
        if (zzoa > 0) {
            throw zzrk.zzpp();
        } else if (zzoa == 0) {
            bArr = zzre.zzbbh;
            return zzps.zzf(bArr);
        } else {
            throw zzrk.zzpq();
        }
    }

    public final int zznr() throws IOException {
        return zzoa();
    }

    public final int zzns() throws IOException {
        return zzoa();
    }

    public final int zznt() throws IOException {
        return zzoc();
    }

    public final long zznu() throws IOException {
        return zzod();
    }

    public final int zznv() throws IOException {
        int zzoa = zzoa();
        return (-(zzoa & 1)) ^ (zzoa >>> 1);
    }

    public final long zznw() throws IOException {
        long zzob = zzob();
        return (-(zzob & 1)) ^ (zzob >>> 1);
    }

    public final long zznx() throws IOException {
        long j11 = 0;
        for (int i11 = 0; i11 < 64; i11 += 7) {
            byte zzof = zzof();
            j11 |= ((long) (zzof & Byte.MAX_VALUE)) << i11;
            if ((zzof & 128) == 0) {
                return j11;
            }
        }
        throw zzrk.zzpr();
    }

    public final boolean zzny() throws IOException {
        return this.pos == this.limit;
    }

    public final int zznz() {
        return this.pos - this.zzawm;
    }
}
