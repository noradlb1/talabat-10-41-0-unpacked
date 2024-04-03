package com.google.android.gms.internal.vision;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;

final class zzfg extends zzfe {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private int tag;
    private final boolean zzru = true;
    private final int zzrv;
    private int zzrw;

    public zzfg(ByteBuffer byteBuffer, boolean z11) {
        super((zzfd) null);
        this.buffer = byteBuffer.array();
        int arrayOffset = byteBuffer.arrayOffset() + byteBuffer.position();
        this.pos = arrayOffset;
        this.zzrv = arrayOffset;
        this.limit = byteBuffer.arrayOffset() + byteBuffer.limit();
    }

    private final byte readByte() throws IOException {
        int i11 = this.pos;
        if (i11 != this.limit) {
            byte[] bArr = this.buffer;
            this.pos = i11 + 1;
            return bArr[i11];
        }
        throw zzhc.zzgm();
    }

    private final void zzah(int i11) throws IOException {
        zzai(i11);
        this.pos += i11;
    }

    private final void zzai(int i11) throws IOException {
        if (i11 < 0 || i11 > this.limit - this.pos) {
            throw zzhc.zzgm();
        }
    }

    private final void zzaj(int i11) throws IOException {
        if ((this.tag & 7) != i11) {
            throw zzhc.zzgr();
        }
    }

    private final void zzak(int i11) throws IOException {
        zzai(i11);
        if ((i11 & 7) != 0) {
            throw zzhc.zzgs();
        }
    }

    private final void zzal(int i11) throws IOException {
        zzai(i11);
        if ((i11 & 3) != 0) {
            throw zzhc.zzgs();
        }
    }

    private final void zzam(int i11) throws IOException {
        if (this.pos != i11) {
            throw zzhc.zzgm();
        }
    }

    private final <T> T zzb(zzir<T> zzir, zzgd zzgd) throws IOException {
        int zzek = zzek();
        zzai(zzek);
        int i11 = this.limit;
        int i12 = this.pos + zzek;
        this.limit = i12;
        try {
            T newInstance = zzir.newInstance();
            zzir.zza(newInstance, this, zzgd);
            zzir.zzg(newInstance);
            if (this.pos == i12) {
                return newInstance;
            }
            throw zzhc.zzgs();
        } finally {
            this.limit = i11;
        }
    }

    private final <T> T zzd(zzir<T> zzir, zzgd zzgd) throws IOException {
        int i11 = this.zzrw;
        this.zzrw = ((this.tag >>> 3) << 3) | 4;
        try {
            T newInstance = zzir.newInstance();
            zzir.zza(newInstance, this, zzgd);
            zzir.zzg(newInstance);
            if (this.tag == this.zzrw) {
                return newInstance;
            }
            throw zzhc.zzgs();
        } finally {
            this.zzrw = i11;
        }
    }

    private final boolean zzdt() {
        return this.pos == this.limit;
    }

    private final int zzek() throws IOException {
        byte b11;
        int i11 = this.pos;
        int i12 = this.limit;
        if (i12 != i11) {
            byte[] bArr = this.buffer;
            int i13 = i11 + 1;
            byte b12 = bArr[i11];
            if (b12 >= 0) {
                this.pos = i13;
                return b12;
            } else if (i12 - i13 < 9) {
                return (int) zzem();
            } else {
                int i14 = i13 + 1;
                byte b13 = b12 ^ (bArr[i13] << 7);
                if (b13 < 0) {
                    b11 = b13 ^ Byte.MIN_VALUE;
                } else {
                    int i15 = i14 + 1;
                    byte b14 = b13 ^ (bArr[i14] << Ascii.SO);
                    if (b14 >= 0) {
                        b11 = b14 ^ 16256;
                    } else {
                        i14 = i15 + 1;
                        byte b15 = b14 ^ (bArr[i15] << Ascii.NAK);
                        if (b15 < 0) {
                            b11 = b15 ^ -2080896;
                        } else {
                            i15 = i14 + 1;
                            byte b16 = bArr[i14];
                            b11 = (b15 ^ (b16 << Ascii.FS)) ^ 266354560;
                            if (b16 < 0) {
                                i14 = i15 + 1;
                                if (bArr[i15] < 0) {
                                    i15 = i14 + 1;
                                    if (bArr[i14] < 0) {
                                        i14 = i15 + 1;
                                        if (bArr[i15] < 0) {
                                            i15 = i14 + 1;
                                            if (bArr[i14] < 0) {
                                                i14 = i15 + 1;
                                                if (bArr[i15] < 0) {
                                                    throw zzhc.zzgo();
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                    i14 = i15;
                }
                this.pos = i14;
                return b11;
            }
        } else {
            throw zzhc.zzgm();
        }
    }

    private final long zzel() throws IOException {
        long j11;
        int i11;
        long j12;
        long j13;
        byte b11;
        int i12 = this.pos;
        int i13 = this.limit;
        if (i13 != i12) {
            byte[] bArr = this.buffer;
            int i14 = i12 + 1;
            byte b12 = bArr[i12];
            if (b12 >= 0) {
                this.pos = i14;
                return (long) b12;
            } else if (i13 - i14 < 9) {
                return zzem();
            } else {
                int i15 = i14 + 1;
                byte b13 = b12 ^ (bArr[i14] << 7);
                if (b13 < 0) {
                    b11 = b13 ^ Byte.MIN_VALUE;
                } else {
                    int i16 = i15 + 1;
                    byte b14 = b13 ^ (bArr[i15] << Ascii.SO);
                    if (b14 >= 0) {
                        i11 = i16;
                        j11 = (long) (b14 ^ 16256);
                    } else {
                        i15 = i16 + 1;
                        byte b15 = b14 ^ (bArr[i16] << Ascii.NAK);
                        if (b15 < 0) {
                            b11 = b15 ^ -2080896;
                        } else {
                            long j14 = (long) b15;
                            int i17 = i15 + 1;
                            long j15 = j14 ^ (((long) bArr[i15]) << 28);
                            if (j15 >= 0) {
                                j13 = 266354560;
                            } else {
                                int i18 = i17 + 1;
                                long j16 = j15 ^ (((long) bArr[i17]) << 35);
                                if (j16 < 0) {
                                    j12 = -34093383808L;
                                } else {
                                    i17 = i18 + 1;
                                    j15 = j16 ^ (((long) bArr[i18]) << 42);
                                    if (j15 >= 0) {
                                        j13 = 4363953127296L;
                                    } else {
                                        i18 = i17 + 1;
                                        j16 = j15 ^ (((long) bArr[i17]) << 49);
                                        if (j16 < 0) {
                                            j12 = -558586000294016L;
                                        } else {
                                            int i19 = i18 + 1;
                                            long j17 = (j16 ^ (((long) bArr[i18]) << 56)) ^ 71499008037633920L;
                                            if (j17 < 0) {
                                                i11 = i19 + 1;
                                                if (((long) bArr[i19]) < 0) {
                                                    throw zzhc.zzgo();
                                                }
                                            } else {
                                                i11 = i19;
                                            }
                                            j11 = j17;
                                        }
                                    }
                                }
                                j11 = j16 ^ j12;
                            }
                            j11 = j15 ^ j13;
                            i11 = i17;
                        }
                    }
                    this.pos = i11;
                    return j11;
                }
                j11 = (long) b11;
                this.pos = i11;
                return j11;
            }
        } else {
            throw zzhc.zzgm();
        }
    }

    private final long zzem() throws IOException {
        long j11 = 0;
        for (int i11 = 0; i11 < 64; i11 += 7) {
            byte readByte = readByte();
            j11 |= ((long) (readByte & Byte.MAX_VALUE)) << i11;
            if ((readByte & 128) == 0) {
                return j11;
            }
        }
        throw zzhc.zzgo();
    }

    private final int zzen() throws IOException {
        zzai(4);
        return zzep();
    }

    private final long zzeo() throws IOException {
        zzai(8);
        return zzeq();
    }

    private final int zzep() {
        int i11 = this.pos;
        byte[] bArr = this.buffer;
        this.pos = i11 + 4;
        return ((bArr[i11 + 3] & 255) << Ascii.CAN) | (bArr[i11] & 255) | ((bArr[i11 + 1] & 255) << 8) | ((bArr[i11 + 2] & 255) << Ascii.DLE);
    }

    private final long zzeq() {
        int i11 = this.pos;
        byte[] bArr = this.buffer;
        this.pos = i11 + 8;
        return ((((long) bArr[i11 + 7]) & 255) << 56) | (((long) bArr[i11]) & 255) | ((((long) bArr[i11 + 1]) & 255) << 8) | ((((long) bArr[i11 + 2]) & 255) << 16) | ((((long) bArr[i11 + 3]) & 255) << 24) | ((((long) bArr[i11 + 4]) & 255) << 32) | ((((long) bArr[i11 + 5]) & 255) << 40) | ((((long) bArr[i11 + 6]) & 255) << 48);
    }

    private final String zzj(boolean z11) throws IOException {
        zzaj(2);
        int zzek = zzek();
        if (zzek == 0) {
            return "";
        }
        zzai(zzek);
        if (z11) {
            byte[] bArr = this.buffer;
            int i11 = this.pos;
            if (!zzjs.zzf(bArr, i11, i11 + zzek)) {
                throw zzhc.zzgt();
            }
        }
        String str = new String(this.buffer, this.pos, zzek, zzgt.UTF_8);
        this.pos += zzek;
        return str;
    }

    public final int getTag() {
        return this.tag;
    }

    public final double readDouble() throws IOException {
        zzaj(1);
        return Double.longBitsToDouble(zzeo());
    }

    public final float readFloat() throws IOException {
        zzaj(5);
        return Float.intBitsToFloat(zzen());
    }

    public final String readString() throws IOException {
        return zzj(false);
    }

    public final void readStringList(List<String> list) throws IOException {
        zza(list, false);
    }

    public final <T> T zza(Class<T> cls, zzgd zzgd) throws IOException {
        zzaj(2);
        return zzb(zzin.zzho().zzf(cls), zzgd);
    }

    public final <T> T zzc(zzir<T> zzir, zzgd zzgd) throws IOException {
        zzaj(3);
        return zzd(zzir, zzgd);
    }

    public final int zzdu() throws IOException {
        if (zzdt()) {
            return Integer.MAX_VALUE;
        }
        int zzek = zzek();
        this.tag = zzek;
        if (zzek == this.zzrw) {
            return Integer.MAX_VALUE;
        }
        return zzek >>> 3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x002e A[LOOP:0: B:18:0x002e->B:21:0x003b, LOOP_START] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzdv() throws java.io.IOException {
        /*
            r7 = this;
            boolean r0 = r7.zzdt()
            r1 = 0
            if (r0 != 0) goto L_0x0085
            int r0 = r7.tag
            int r2 = r7.zzrw
            if (r0 != r2) goto L_0x000f
            goto L_0x0085
        L_0x000f:
            r3 = r0 & 7
            r4 = 1
            if (r3 == 0) goto L_0x0059
            if (r3 == r4) goto L_0x0053
            r1 = 2
            if (r3 == r1) goto L_0x004b
            r1 = 4
            r5 = 3
            if (r3 == r5) goto L_0x0029
            r0 = 5
            if (r3 != r0) goto L_0x0024
            r7.zzah(r1)
            return r4
        L_0x0024:
            com.google.android.gms.internal.vision.zzhb r0 = com.google.android.gms.internal.vision.zzhc.zzgr()
            throw r0
        L_0x0029:
            int r0 = r0 >>> r5
            int r0 = r0 << r5
            r0 = r0 | r1
            r7.zzrw = r0
        L_0x002e:
            int r0 = r7.zzdu()
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r1) goto L_0x003d
            boolean r0 = r7.zzdv()
            if (r0 != 0) goto L_0x002e
        L_0x003d:
            int r0 = r7.tag
            int r1 = r7.zzrw
            if (r0 != r1) goto L_0x0046
            r7.zzrw = r2
            return r4
        L_0x0046:
            com.google.android.gms.internal.vision.zzhc r0 = com.google.android.gms.internal.vision.zzhc.zzgs()
            throw r0
        L_0x004b:
            int r0 = r7.zzek()
            r7.zzah(r0)
            return r4
        L_0x0053:
            r0 = 8
            r7.zzah(r0)
            return r4
        L_0x0059:
            int r0 = r7.limit
            int r2 = r7.pos
            int r0 = r0 - r2
            r3 = 10
            if (r0 < r3) goto L_0x0074
            byte[] r0 = r7.buffer
            r5 = r1
        L_0x0065:
            if (r5 >= r3) goto L_0x0074
            int r6 = r2 + 1
            byte r2 = r0[r2]
            if (r2 < 0) goto L_0x0070
            r7.pos = r6
            goto L_0x007f
        L_0x0070:
            int r5 = r5 + 1
            r2 = r6
            goto L_0x0065
        L_0x0074:
            if (r1 >= r3) goto L_0x0080
            byte r0 = r7.readByte()
            if (r0 >= 0) goto L_0x007f
            int r1 = r1 + 1
            goto L_0x0074
        L_0x007f:
            return r4
        L_0x0080:
            com.google.android.gms.internal.vision.zzhc r0 = com.google.android.gms.internal.vision.zzhc.zzgo()
            throw r0
        L_0x0085:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfg.zzdv():boolean");
    }

    public final long zzdw() throws IOException {
        zzaj(0);
        return zzel();
    }

    public final long zzdx() throws IOException {
        zzaj(0);
        return zzel();
    }

    public final int zzdy() throws IOException {
        zzaj(0);
        return zzek();
    }

    public final long zzdz() throws IOException {
        zzaj(1);
        return zzeo();
    }

    public final void zze(List<Integer> list) throws IOException {
        int i11;
        int i12;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i13 = this.tag & 7;
            if (i13 == 0) {
                do {
                    zzgu.zzbl(zzdy());
                    if (!zzdt()) {
                        i12 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i12;
            } else if (i13 == 2) {
                int zzek = this.pos + zzek();
                while (this.pos < zzek) {
                    zzgu.zzbl(zzek());
                }
                zzam(zzek);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i14 = this.tag & 7;
            if (i14 == 0) {
                do {
                    list.add(Integer.valueOf(zzdy()));
                    if (!zzdt()) {
                        i11 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i11;
            } else if (i14 == 2) {
                int zzek2 = this.pos + zzek();
                while (this.pos < zzek2) {
                    list.add(Integer.valueOf(zzek()));
                }
                zzam(zzek2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final int zzea() throws IOException {
        zzaj(5);
        return zzen();
    }

    public final boolean zzeb() throws IOException {
        zzaj(0);
        if (zzek() != 0) {
            return true;
        }
        return false;
    }

    public final String zzec() throws IOException {
        return zzj(true);
    }

    public final zzfh zzed() throws IOException {
        zzfh zzfh;
        zzaj(2);
        int zzek = zzek();
        if (zzek == 0) {
            return zzfh.zzrx;
        }
        zzai(zzek);
        if (this.zzru) {
            zzfh = zzfh.zzb(this.buffer, this.pos, zzek);
        } else {
            zzfh = zzfh.zza(this.buffer, this.pos, zzek);
        }
        this.pos += zzek;
        return zzfh;
    }

    public final int zzee() throws IOException {
        zzaj(0);
        return zzek();
    }

    public final int zzef() throws IOException {
        zzaj(0);
        return zzek();
    }

    public final int zzeg() throws IOException {
        zzaj(5);
        return zzen();
    }

    public final long zzeh() throws IOException {
        zzaj(1);
        return zzeo();
    }

    public final int zzei() throws IOException {
        zzaj(0);
        return zzft.zzau(zzek());
    }

    public final long zzej() throws IOException {
        zzaj(0);
        return zzft.zzr(zzel());
    }

    public final void zzf(List<Long> list) throws IOException {
        int i11;
        int i12;
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            int i13 = this.tag & 7;
            if (i13 == 1) {
                do {
                    zzhq.zzac(zzdz());
                    if (!zzdt()) {
                        i12 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i12;
            } else if (i13 == 2) {
                int zzek = zzek();
                zzak(zzek);
                int i14 = this.pos + zzek;
                while (this.pos < i14) {
                    zzhq.zzac(zzeq());
                }
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i15 = this.tag & 7;
            if (i15 == 1) {
                do {
                    list.add(Long.valueOf(zzdz()));
                    if (!zzdt()) {
                        i11 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i11;
            } else if (i15 == 2) {
                int zzek2 = zzek();
                zzak(zzek2);
                int i16 = this.pos + zzek2;
                while (this.pos < i16) {
                    list.add(Long.valueOf(zzeq()));
                }
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzg(List<Integer> list) throws IOException {
        int i11;
        int i12;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i13 = this.tag & 7;
            if (i13 == 2) {
                int zzek = zzek();
                zzal(zzek);
                int i14 = this.pos + zzek;
                while (this.pos < i14) {
                    zzgu.zzbl(zzep());
                }
            } else if (i13 == 5) {
                do {
                    zzgu.zzbl(zzea());
                    if (!zzdt()) {
                        i12 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i12;
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i15 = this.tag & 7;
            if (i15 == 2) {
                int zzek2 = zzek();
                zzal(zzek2);
                int i16 = this.pos + zzek2;
                while (this.pos < i16) {
                    list.add(Integer.valueOf(zzep()));
                }
            } else if (i15 == 5) {
                do {
                    list.add(Integer.valueOf(zzea()));
                    if (!zzdt()) {
                        i11 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i11;
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzh(List<Boolean> list) throws IOException {
        int i11;
        boolean z11;
        int i12;
        boolean z12;
        if (list instanceof zzff) {
            zzff zzff = (zzff) list;
            int i13 = this.tag & 7;
            if (i13 == 0) {
                do {
                    zzff.addBoolean(zzeb());
                    if (!zzdt()) {
                        i12 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i12;
            } else if (i13 == 2) {
                int zzek = this.pos + zzek();
                while (this.pos < zzek) {
                    if (zzek() != 0) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    zzff.addBoolean(z12);
                }
                zzam(zzek);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i14 = this.tag & 7;
            if (i14 == 0) {
                do {
                    list.add(Boolean.valueOf(zzeb()));
                    if (!zzdt()) {
                        i11 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i11;
            } else if (i14 == 2) {
                int zzek2 = this.pos + zzek();
                while (this.pos < zzek2) {
                    if (zzek() != 0) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    list.add(Boolean.valueOf(z11));
                }
                zzam(zzek2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzi(List<String> list) throws IOException {
        zza(list, true);
    }

    public final void zzk(List<Integer> list) throws IOException {
        int i11;
        int i12;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i13 = this.tag & 7;
            if (i13 == 0) {
                do {
                    zzgu.zzbl(zzee());
                    if (!zzdt()) {
                        i12 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i12;
            } else if (i13 == 2) {
                int zzek = this.pos + zzek();
                while (this.pos < zzek) {
                    zzgu.zzbl(zzek());
                }
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i14 = this.tag & 7;
            if (i14 == 0) {
                do {
                    list.add(Integer.valueOf(zzee()));
                    if (!zzdt()) {
                        i11 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i11;
            } else if (i14 == 2) {
                int zzek2 = this.pos + zzek();
                while (this.pos < zzek2) {
                    list.add(Integer.valueOf(zzek()));
                }
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzl(List<Integer> list) throws IOException {
        int i11;
        int i12;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i13 = this.tag & 7;
            if (i13 == 0) {
                do {
                    zzgu.zzbl(zzef());
                    if (!zzdt()) {
                        i12 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i12;
            } else if (i13 == 2) {
                int zzek = this.pos + zzek();
                while (this.pos < zzek) {
                    zzgu.zzbl(zzek());
                }
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i14 = this.tag & 7;
            if (i14 == 0) {
                do {
                    list.add(Integer.valueOf(zzef()));
                    if (!zzdt()) {
                        i11 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i11;
            } else if (i14 == 2) {
                int zzek2 = this.pos + zzek();
                while (this.pos < zzek2) {
                    list.add(Integer.valueOf(zzek()));
                }
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzm(List<Integer> list) throws IOException {
        int i11;
        int i12;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i13 = this.tag & 7;
            if (i13 == 2) {
                int zzek = zzek();
                zzal(zzek);
                int i14 = this.pos + zzek;
                while (this.pos < i14) {
                    zzgu.zzbl(zzep());
                }
            } else if (i13 == 5) {
                do {
                    zzgu.zzbl(zzeg());
                    if (!zzdt()) {
                        i12 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i12;
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i15 = this.tag & 7;
            if (i15 == 2) {
                int zzek2 = zzek();
                zzal(zzek2);
                int i16 = this.pos + zzek2;
                while (this.pos < i16) {
                    list.add(Integer.valueOf(zzep()));
                }
            } else if (i15 == 5) {
                do {
                    list.add(Integer.valueOf(zzeg()));
                    if (!zzdt()) {
                        i11 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i11;
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzn(List<Long> list) throws IOException {
        int i11;
        int i12;
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            int i13 = this.tag & 7;
            if (i13 == 1) {
                do {
                    zzhq.zzac(zzeh());
                    if (!zzdt()) {
                        i12 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i12;
            } else if (i13 == 2) {
                int zzek = zzek();
                zzak(zzek);
                int i14 = this.pos + zzek;
                while (this.pos < i14) {
                    zzhq.zzac(zzeq());
                }
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i15 = this.tag & 7;
            if (i15 == 1) {
                do {
                    list.add(Long.valueOf(zzeh()));
                    if (!zzdt()) {
                        i11 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i11;
            } else if (i15 == 2) {
                int zzek2 = zzek();
                zzak(zzek2);
                int i16 = this.pos + zzek2;
                while (this.pos < i16) {
                    list.add(Long.valueOf(zzeq()));
                }
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzo(List<Integer> list) throws IOException {
        int i11;
        int i12;
        if (list instanceof zzgu) {
            zzgu zzgu = (zzgu) list;
            int i13 = this.tag & 7;
            if (i13 == 0) {
                do {
                    zzgu.zzbl(zzei());
                    if (!zzdt()) {
                        i12 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i12;
            } else if (i13 == 2) {
                int zzek = this.pos + zzek();
                while (this.pos < zzek) {
                    zzgu.zzbl(zzft.zzau(zzek()));
                }
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i14 = this.tag & 7;
            if (i14 == 0) {
                do {
                    list.add(Integer.valueOf(zzei()));
                    if (!zzdt()) {
                        i11 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i11;
            } else if (i14 == 2) {
                int zzek2 = this.pos + zzek();
                while (this.pos < zzek2) {
                    list.add(Integer.valueOf(zzft.zzau(zzek())));
                }
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzp(List<Long> list) throws IOException {
        int i11;
        int i12;
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            int i13 = this.tag & 7;
            if (i13 == 0) {
                do {
                    zzhq.zzac(zzej());
                    if (!zzdt()) {
                        i12 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i12;
            } else if (i13 == 2) {
                int zzek = this.pos + zzek();
                while (this.pos < zzek) {
                    zzhq.zzac(zzft.zzr(zzel()));
                }
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i14 = this.tag & 7;
            if (i14 == 0) {
                do {
                    list.add(Long.valueOf(zzej()));
                    if (!zzdt()) {
                        i11 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i11;
            } else if (i14 == 2) {
                int zzek2 = this.pos + zzek();
                while (this.pos < zzek2) {
                    list.add(Long.valueOf(zzft.zzr(zzel())));
                }
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final <T> T zza(zzir<T> zzir, zzgd zzgd) throws IOException {
        zzaj(2);
        return zzb(zzir, zzgd);
    }

    public final void zzc(List<Long> list) throws IOException {
        int i11;
        int i12;
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            int i13 = this.tag & 7;
            if (i13 == 0) {
                do {
                    zzhq.zzac(zzdw());
                    if (!zzdt()) {
                        i12 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i12;
            } else if (i13 == 2) {
                int zzek = this.pos + zzek();
                while (this.pos < zzek) {
                    zzhq.zzac(zzel());
                }
                zzam(zzek);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i14 = this.tag & 7;
            if (i14 == 0) {
                do {
                    list.add(Long.valueOf(zzdw()));
                    if (!zzdt()) {
                        i11 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i11;
            } else if (i14 == 2) {
                int zzek2 = this.pos + zzek();
                while (this.pos < zzek2) {
                    list.add(Long.valueOf(zzel()));
                }
                zzam(zzek2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zza(List<Double> list) throws IOException {
        int i11;
        int i12;
        if (list instanceof zzgb) {
            zzgb zzgb = (zzgb) list;
            int i13 = this.tag & 7;
            if (i13 == 1) {
                do {
                    zzgb.zzc(readDouble());
                    if (!zzdt()) {
                        i12 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i12;
            } else if (i13 == 2) {
                int zzek = zzek();
                zzak(zzek);
                int i14 = this.pos + zzek;
                while (this.pos < i14) {
                    zzgb.zzc(Double.longBitsToDouble(zzeq()));
                }
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i15 = this.tag & 7;
            if (i15 == 1) {
                do {
                    list.add(Double.valueOf(readDouble()));
                    if (!zzdt()) {
                        i11 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i11;
            } else if (i15 == 2) {
                int zzek2 = zzek();
                zzak(zzek2);
                int i16 = this.pos + zzek2;
                while (this.pos < i16) {
                    list.add(Double.valueOf(Double.longBitsToDouble(zzeq())));
                }
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final void zzj(List<zzfh> list) throws IOException {
        int i11;
        if ((this.tag & 7) == 2) {
            do {
                list.add(zzed());
                if (!zzdt()) {
                    i11 = this.pos;
                } else {
                    return;
                }
            } while (zzek() == this.tag);
            this.pos = i11;
            return;
        }
        throw zzhc.zzgr();
    }

    public final void zzd(List<Long> list) throws IOException {
        int i11;
        int i12;
        if (list instanceof zzhq) {
            zzhq zzhq = (zzhq) list;
            int i13 = this.tag & 7;
            if (i13 == 0) {
                do {
                    zzhq.zzac(zzdx());
                    if (!zzdt()) {
                        i12 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i12;
            } else if (i13 == 2) {
                int zzek = this.pos + zzek();
                while (this.pos < zzek) {
                    zzhq.zzac(zzel());
                }
                zzam(zzek);
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i14 = this.tag & 7;
            if (i14 == 0) {
                do {
                    list.add(Long.valueOf(zzdx()));
                    if (!zzdt()) {
                        i11 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i11;
            } else if (i14 == 2) {
                int zzek2 = this.pos + zzek();
                while (this.pos < zzek2) {
                    list.add(Long.valueOf(zzel()));
                }
                zzam(zzek2);
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    public final <T> T zzb(Class<T> cls, zzgd zzgd) throws IOException {
        zzaj(3);
        return zzd(zzin.zzho().zzf(cls), zzgd);
    }

    public final void zzb(List<Float> list) throws IOException {
        int i11;
        int i12;
        if (list instanceof zzgo) {
            zzgo zzgo = (zzgo) list;
            int i13 = this.tag & 7;
            if (i13 == 2) {
                int zzek = zzek();
                zzal(zzek);
                int i14 = this.pos + zzek;
                while (this.pos < i14) {
                    zzgo.zzu(Float.intBitsToFloat(zzep()));
                }
            } else if (i13 == 5) {
                do {
                    zzgo.zzu(readFloat());
                    if (!zzdt()) {
                        i12 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i12;
            } else {
                throw zzhc.zzgr();
            }
        } else {
            int i15 = this.tag & 7;
            if (i15 == 2) {
                int zzek2 = zzek();
                zzal(zzek2);
                int i16 = this.pos + zzek2;
                while (this.pos < i16) {
                    list.add(Float.valueOf(Float.intBitsToFloat(zzep())));
                }
            } else if (i15 == 5) {
                do {
                    list.add(Float.valueOf(readFloat()));
                    if (!zzdt()) {
                        i11 = this.pos;
                    } else {
                        return;
                    }
                } while (zzek() == this.tag);
                this.pos = i11;
            } else {
                throw zzhc.zzgr();
            }
        }
    }

    private final void zza(List<String> list, boolean z11) throws IOException {
        int i11;
        int i12;
        if ((this.tag & 7) != 2) {
            throw zzhc.zzgr();
        } else if (!(list instanceof zzhj) || z11) {
            do {
                list.add(zzj(z11));
                if (!zzdt()) {
                    i11 = this.pos;
                } else {
                    return;
                }
            } while (zzek() == this.tag);
            this.pos = i11;
        } else {
            zzhj zzhj = (zzhj) list;
            do {
                zzhj.zzc(zzed());
                if (!zzdt()) {
                    i12 = this.pos;
                } else {
                    return;
                }
            } while (zzek() == this.tag);
            this.pos = i12;
        }
    }

    public final <T> void zzb(List<T> list, zzir<T> zzir, zzgd zzgd) throws IOException {
        int i11;
        int i12 = this.tag;
        if ((i12 & 7) == 3) {
            do {
                list.add(zzd(zzir, zzgd));
                if (!zzdt()) {
                    i11 = this.pos;
                } else {
                    return;
                }
            } while (zzek() == i12);
            this.pos = i11;
            return;
        }
        throw zzhc.zzgr();
    }

    public final <T> void zza(List<T> list, zzir<T> zzir, zzgd zzgd) throws IOException {
        int i11;
        int i12 = this.tag;
        if ((i12 & 7) == 2) {
            do {
                list.add(zzb(zzir, zzgd));
                if (!zzdt()) {
                    i11 = this.pos;
                } else {
                    return;
                }
            } while (zzek() == i12);
            this.pos = i11;
            return;
        }
        throw zzhc.zzgr();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:17|18|(2:20|36)(3:31|21|22)) */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004c, code lost:
        if (zzdv() != false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0054, code lost:
        throw new com.google.android.gms.internal.vision.zzhc("Unable to parse map entry.");
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0048 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final <K, V> void zza(java.util.Map<K, V> r8, com.google.android.gms.internal.vision.zzht<K, V> r9, com.google.android.gms.internal.vision.zzgd r10) throws java.io.IOException {
        /*
            r7 = this;
            r0 = 2
            r7.zzaj(r0)
            int r1 = r7.zzek()
            r7.zzai(r1)
            int r2 = r7.limit
            int r3 = r7.pos
            int r3 = r3 + r1
            r7.limit = r3
            K r1 = r9.zzyn     // Catch:{ all -> 0x005b }
            V r3 = r9.zzgc     // Catch:{ all -> 0x005b }
        L_0x0016:
            int r4 = r7.zzdu()     // Catch:{ all -> 0x005b }
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r4 == r5) goto L_0x0055
            r5 = 1
            java.lang.String r6 = "Unable to parse map entry."
            if (r4 == r5) goto L_0x0040
            if (r4 == r0) goto L_0x0033
            boolean r4 = r7.zzdv()     // Catch:{ zzhb -> 0x0048 }
            if (r4 == 0) goto L_0x002d
            goto L_0x0016
        L_0x002d:
            com.google.android.gms.internal.vision.zzhc r4 = new com.google.android.gms.internal.vision.zzhc     // Catch:{ zzhb -> 0x0048 }
            r4.<init>(r6)     // Catch:{ zzhb -> 0x0048 }
            throw r4     // Catch:{ zzhb -> 0x0048 }
        L_0x0033:
            com.google.android.gms.internal.vision.zzka r4 = r9.zzyo     // Catch:{ zzhb -> 0x0048 }
            V r5 = r9.zzgc     // Catch:{ zzhb -> 0x0048 }
            java.lang.Class r5 = r5.getClass()     // Catch:{ zzhb -> 0x0048 }
            java.lang.Object r3 = r7.zza((com.google.android.gms.internal.vision.zzka) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.vision.zzgd) r10)     // Catch:{ zzhb -> 0x0048 }
            goto L_0x0016
        L_0x0040:
            com.google.android.gms.internal.vision.zzka r4 = r9.zzym     // Catch:{ zzhb -> 0x0048 }
            r5 = 0
            java.lang.Object r1 = r7.zza((com.google.android.gms.internal.vision.zzka) r4, (java.lang.Class<?>) r5, (com.google.android.gms.internal.vision.zzgd) r5)     // Catch:{ zzhb -> 0x0048 }
            goto L_0x0016
        L_0x0048:
            boolean r4 = r7.zzdv()     // Catch:{ all -> 0x005b }
            if (r4 == 0) goto L_0x004f
            goto L_0x0016
        L_0x004f:
            com.google.android.gms.internal.vision.zzhc r8 = new com.google.android.gms.internal.vision.zzhc     // Catch:{ all -> 0x005b }
            r8.<init>(r6)     // Catch:{ all -> 0x005b }
            throw r8     // Catch:{ all -> 0x005b }
        L_0x0055:
            r8.put(r1, r3)     // Catch:{ all -> 0x005b }
            r7.limit = r2
            return
        L_0x005b:
            r8 = move-exception
            r7.limit = r2
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.vision.zzfg.zza(java.util.Map, com.google.android.gms.internal.vision.zzht, com.google.android.gms.internal.vision.zzgd):void");
    }

    private final Object zza(zzka zzka, Class<?> cls, zzgd zzgd) throws IOException {
        switch (zzfd.zzrr[zzka.ordinal()]) {
            case 1:
                return Boolean.valueOf(zzeb());
            case 2:
                return zzed();
            case 3:
                return Double.valueOf(readDouble());
            case 4:
                return Integer.valueOf(zzef());
            case 5:
                return Integer.valueOf(zzea());
            case 6:
                return Long.valueOf(zzdz());
            case 7:
                return Float.valueOf(readFloat());
            case 8:
                return Integer.valueOf(zzdy());
            case 9:
                return Long.valueOf(zzdx());
            case 10:
                return zza(cls, zzgd);
            case 11:
                return Integer.valueOf(zzeg());
            case 12:
                return Long.valueOf(zzeh());
            case 13:
                return Integer.valueOf(zzei());
            case 14:
                return Long.valueOf(zzej());
            case 15:
                return zzj(true);
            case 16:
                return Integer.valueOf(zzee());
            case 17:
                return Long.valueOf(zzdw());
            default:
                throw new RuntimeException("unsupported field type.");
        }
    }
}
