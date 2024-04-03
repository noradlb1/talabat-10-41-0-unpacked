package com.google.android.gms.internal.gtm;

import com.google.common.base.Ascii;
import java.io.IOException;

public final class zzun {
    private final byte[] buffer;
    private int zzawf;
    private int zzawg = 64;
    private int zzawh = 67108864;
    private int zzawl;
    private int zzawn;
    private int zzawo = Integer.MAX_VALUE;
    private final int zzbgu;
    private final int zzbgv;
    private int zzbgw;
    private int zzbgx;
    private zzqe zzbgy;

    private zzun(byte[] bArr, int i11, int i12) {
        this.buffer = bArr;
        this.zzbgu = i11;
        int i13 = i12 + i11;
        this.zzbgw = i13;
        this.zzbgv = i13;
        this.zzbgx = i11;
    }

    private final void zzas(int i11) throws IOException {
        if (i11 >= 0) {
            int i12 = this.zzbgx;
            int i13 = i12 + i11;
            int i14 = this.zzawo;
            if (i13 > i14) {
                zzas(i14 - i12);
                throw zzuv.zzsa();
            } else if (i11 <= this.zzbgw - i12) {
                this.zzbgx = i12 + i11;
            } else {
                throw zzuv.zzsa();
            }
        } else {
            throw zzuv.zzsb();
        }
    }

    public static zzun zzj(byte[] bArr, int i11, int i12) {
        return new zzun(bArr, 0, i12);
    }

    public static zzun zzk(byte[] bArr) {
        return zzj(bArr, 0, bArr.length);
    }

    private final void zzoe() {
        int i11 = this.zzbgw + this.zzawl;
        this.zzbgw = i11;
        int i12 = this.zzawo;
        if (i11 > i12) {
            int i13 = i11 - i12;
            this.zzawl = i13;
            this.zzbgw = i11 - i13;
            return;
        }
        this.zzawl = 0;
    }

    private final byte zzof() throws IOException {
        int i11 = this.zzbgx;
        if (i11 != this.zzbgw) {
            byte[] bArr = this.buffer;
            this.zzbgx = i11 + 1;
            return bArr[i11];
        }
        throw zzuv.zzsa();
    }

    private final zzqe zzru() throws IOException {
        if (this.zzbgy == null) {
            this.zzbgy = zzqe.zzd(this.buffer, this.zzbgu, this.zzbgv);
        }
        int zznz = this.zzbgy.zznz();
        int i11 = this.zzbgx - this.zzbgu;
        if (zznz <= i11) {
            this.zzbgy.zzas(i11 - zznz);
            this.zzbgy.zzap(this.zzawg - this.zzawf);
            return this.zzbgy;
        }
        throw new IOException(String.format("CodedInputStream read ahead of CodedInputByteBufferNano: %s > %s", new Object[]{Integer.valueOf(zznz), Integer.valueOf(i11)}));
    }

    public final int getPosition() {
        return this.zzbgx - this.zzbgu;
    }

    public final String readString() throws IOException {
        int zzoa = zzoa();
        if (zzoa >= 0) {
            int i11 = this.zzbgw;
            int i12 = this.zzbgx;
            if (zzoa <= i11 - i12) {
                String str = new String(this.buffer, i12, zzoa, zzuu.UTF_8);
                this.zzbgx += zzoa;
                return str;
            }
            throw zzuv.zzsa();
        }
        throw zzuv.zzsb();
    }

    public final void zza(zzuw zzuw, int i11) throws IOException {
        int i12 = this.zzawf;
        if (i12 < this.zzawg) {
            this.zzawf = i12 + 1;
            zzuw.zza(this);
            zzan((i11 << 3) | 4);
            this.zzawf--;
            return;
        }
        throw zzuv.zzsd();
    }

    public final void zzan(int i11) throws zzuv {
        if (this.zzawn != i11) {
            throw new zzuv("Protocol message end-group tag did not match expected tag.");
        }
    }

    public final boolean zzao(int i11) throws IOException {
        int zzni;
        int i12 = i11 & 7;
        if (i12 == 0) {
            zzoa();
            return true;
        } else if (i12 == 1) {
            zzof();
            zzof();
            zzof();
            zzof();
            zzof();
            zzof();
            zzof();
            zzof();
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
                zzoc();
                return true;
            }
            throw new zzuv("Protocol message tag had invalid wire type.");
        }
    }

    public final int zzaq(int i11) throws zzuv {
        if (i11 >= 0) {
            int i12 = i11 + this.zzbgx;
            int i13 = this.zzawo;
            if (i12 <= i13) {
                this.zzawo = i12;
                zzoe();
                return i13;
            }
            throw zzuv.zzsa();
        }
        throw zzuv.zzsb();
    }

    public final void zzar(int i11) {
        this.zzawo = i11;
        zzoe();
    }

    public final void zzbz(int i11) {
        zzu(i11, this.zzawn);
    }

    public final int zzni() throws IOException {
        if (this.zzbgx == this.zzbgw) {
            this.zzawn = 0;
            return 0;
        }
        int zzoa = zzoa();
        this.zzawn = zzoa;
        if (zzoa != 0) {
            return zzoa;
        }
        throw new zzuv("Protocol message contained an invalid tag (zero).");
    }

    public final boolean zzno() throws IOException {
        return zzoa() != 0;
    }

    public final int zzoa() throws IOException {
        int i11;
        byte zzof = zzof();
        if (zzof >= 0) {
            return zzof;
        }
        byte b11 = zzof & Byte.MAX_VALUE;
        byte zzof2 = zzof();
        if (zzof2 >= 0) {
            i11 = zzof2 << 7;
        } else {
            b11 |= (zzof2 & Byte.MAX_VALUE) << 7;
            byte zzof3 = zzof();
            if (zzof3 >= 0) {
                i11 = zzof3 << Ascii.SO;
            } else {
                b11 |= (zzof3 & Byte.MAX_VALUE) << Ascii.SO;
                byte zzof4 = zzof();
                if (zzof4 >= 0) {
                    i11 = zzof4 << Ascii.NAK;
                } else {
                    byte b12 = b11 | ((zzof4 & Byte.MAX_VALUE) << Ascii.NAK);
                    byte zzof5 = zzof();
                    byte b13 = b12 | (zzof5 << Ascii.FS);
                    if (zzof5 >= 0) {
                        return b13;
                    }
                    for (int i12 = 0; i12 < 5; i12++) {
                        if (zzof() >= 0) {
                            return b13;
                        }
                    }
                    throw zzuv.zzsc();
                }
            }
        }
        return b11 | i11;
    }

    public final long zzob() throws IOException {
        long j11 = 0;
        for (int i11 = 0; i11 < 64; i11 += 7) {
            byte zzof = zzof();
            j11 |= ((long) (zzof & Byte.MAX_VALUE)) << i11;
            if ((zzof & 128) == 0) {
                return j11;
            }
        }
        throw zzuv.zzsc();
    }

    public final int zzoc() throws IOException {
        return (zzof() & 255) | ((zzof() & 255) << 8) | ((zzof() & 255) << Ascii.DLE) | ((zzof() & 255) << Ascii.CAN);
    }

    public final int zzrv() {
        int i11 = this.zzawo;
        if (i11 == Integer.MAX_VALUE) {
            return -1;
        }
        return i11 - this.zzbgx;
    }

    public final byte[] zzt(int i11, int i12) {
        if (i12 == 0) {
            return zzuz.zzbhw;
        }
        byte[] bArr = new byte[i12];
        System.arraycopy(this.buffer, this.zzbgu + i11, bArr, 0, i12);
        return bArr;
    }

    public final void zzu(int i11, int i12) {
        int i13 = this.zzbgx;
        int i14 = this.zzbgu;
        if (i11 > i13 - i14) {
            int i15 = this.zzbgx - this.zzbgu;
            StringBuilder sb2 = new StringBuilder(50);
            sb2.append("Position ");
            sb2.append(i11);
            sb2.append(" is beyond current ");
            sb2.append(i15);
            throw new IllegalArgumentException(sb2.toString());
        } else if (i11 >= 0) {
            this.zzbgx = i14 + i11;
            this.zzawn = i12;
        } else {
            StringBuilder sb3 = new StringBuilder(24);
            sb3.append("Bad position ");
            sb3.append(i11);
            throw new IllegalArgumentException(sb3.toString());
        }
    }

    public final void zza(zzuw zzuw) throws IOException {
        int zzoa = zzoa();
        if (this.zzawf < this.zzawg) {
            int zzaq = zzaq(zzoa);
            this.zzawf++;
            zzuw.zza(this);
            zzan(0);
            this.zzawf--;
            zzar(zzaq);
            return;
        }
        throw zzuv.zzsd();
    }

    public final <T extends zzrc<T, ?>> T zza(zzsu<T> zzsu) throws IOException {
        try {
            T t11 = (zzrc) zzru().zza(zzsu, zzqp.zzor());
            zzao(this.zzawn);
            return t11;
        } catch (zzrk e11) {
            throw new zzuv("", e11);
        }
    }
}
