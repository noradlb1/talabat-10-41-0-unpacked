package com.apptimize;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

public class gc {

    /* renamed from: n  reason: collision with root package name */
    private static final List<Integer> f42488n = Arrays.asList(new Integer[]{0, 1, 2, 8, 9, 10});

    /* renamed from: o  reason: collision with root package name */
    private static final List<Integer> f42489o = Arrays.asList(new Integer[]{0, 1, 2});

    /* renamed from: a  reason: collision with root package name */
    private bj f42490a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f42491b = true;

    /* renamed from: c  reason: collision with root package name */
    private int f42492c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f42493d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f42494e;

    /* renamed from: f  reason: collision with root package name */
    private int f42495f;

    /* renamed from: g  reason: collision with root package name */
    private int f42496g;

    /* renamed from: h  reason: collision with root package name */
    private int f42497h;

    /* renamed from: i  reason: collision with root package name */
    private int f42498i;

    /* renamed from: j  reason: collision with root package name */
    private byte[] f42499j = new byte[0];

    /* renamed from: k  reason: collision with root package name */
    private byte[] f42500k = new byte[0];

    /* renamed from: l  reason: collision with root package name */
    private boolean f42501l = false;

    /* renamed from: m  reason: collision with root package name */
    private ByteArrayOutputStream f42502m = new ByteArrayOutputStream();

    public static class a extends DataInputStream {
        public a(InputStream inputStream) {
            super(inputStream);
        }

        public byte[] a(int i11) throws IOException {
            byte[] bArr = new byte[i11];
            int i12 = 0;
            while (i12 < i11) {
                int read = read(bArr, i12, i11 - i12);
                if (read == -1) {
                    break;
                }
                i12 += read;
            }
            if (i12 == i11) {
                return bArr;
            }
            throw new IOException(String.format("Read wrong number of bytes. Got: %s, Expected: %s.", new Object[]{Integer.valueOf(i12), Integer.valueOf(i11)}));
        }
    }

    public static class b extends IOException {
        public b(String str) {
            super(str);
        }
    }

    public gc(bj bjVar) {
        this.f42490a = bjVar;
    }

    private static byte[] a(byte[] bArr, byte[] bArr2, int i11) {
        if (bArr2.length == 0) {
            return bArr;
        }
        for (int i12 = 0; i12 < bArr.length - i11; i12++) {
            int i13 = i11 + i12;
            bArr[i13] = (byte) (bArr[i13] ^ bArr2[i12 % 4]);
        }
        return bArr;
    }

    private void b(byte b11) {
        boolean z11 = (b11 & 128) == 128;
        this.f42494e = z11;
        byte b12 = b11 & Byte.MAX_VALUE;
        this.f42497h = b12;
        if (b12 < 0 || b12 > 125) {
            this.f42496g = b12 == 126 ? 2 : 8;
            this.f42492c = 2;
            return;
        }
        this.f42492c = z11 ? 3 : 4;
    }

    private String c(byte[] bArr) {
        try {
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException(e11);
        }
    }

    private int d(byte[] bArr) throws b {
        long c11 = c(bArr, 0, bArr.length);
        if (c11 >= 0 && c11 <= 2147483647L) {
            return (int) c11;
        }
        throw new b("Bad integer: " + c11);
    }

    private static long c(byte[] bArr, int i11, int i12) {
        if (bArr.length >= i12) {
            long j11 = 0;
            for (int i13 = 0; i13 < i12; i13++) {
                j11 += (long) ((bArr[i13 + i11] & 255) << (((i12 - 1) - i13) * 8));
            }
            return j11;
        }
        throw new IllegalArgumentException("length must be less than or equal to b.length");
    }

    public void a(a aVar) throws IOException {
        while (aVar.available() != -1) {
            int i11 = this.f42492c;
            if (i11 == 0) {
                a(aVar.readByte());
            } else if (i11 == 1) {
                b(aVar.readByte());
            } else if (i11 == 2) {
                b(aVar.a(this.f42496g));
            } else if (i11 == 3) {
                this.f42499j = aVar.a(4);
                this.f42492c = 4;
            } else if (i11 == 4) {
                this.f42500k = aVar.a(this.f42497h);
                a();
                this.f42492c = 0;
            }
        }
        this.f42490a.a().a(0, "EOF");
    }

    private void b(byte[] bArr) throws b {
        this.f42497h = d(bArr);
        this.f42492c = this.f42494e ? 3 : 4;
    }

    private void b() {
        this.f42498i = 0;
        this.f42502m.reset();
    }

    private static byte[] b(byte[] bArr, int i11, int i12) {
        if (i11 <= i12) {
            int length = bArr.length;
            if (i11 < 0 || i11 > length) {
                throw new ArrayIndexOutOfBoundsException();
            }
            int i13 = i12 - i11;
            int min = Math.min(i13, length - i11);
            byte[] bArr2 = new byte[i13];
            System.arraycopy(bArr, i11, bArr2, 0, min);
            return bArr2;
        }
        throw new IllegalArgumentException();
    }

    private void a(byte b11) throws b {
        boolean z11 = (b11 & SignedBytes.MAX_POWER_OF_TWO) == 64;
        boolean z12 = (b11 & 32) == 32;
        boolean z13 = (b11 & Ascii.DLE) == 16;
        if (z11 || z12 || z13) {
            throw new b("RSV not zero");
        }
        this.f42493d = (b11 & 128) == 128;
        byte b12 = b11 & Ascii.SI;
        this.f42495f = b12;
        this.f42499j = new byte[0];
        this.f42500k = new byte[0];
        if (!f42488n.contains(Integer.valueOf(b12))) {
            throw new b("Bad opcode");
        } else if (f42489o.contains(Integer.valueOf(this.f42495f)) || this.f42493d) {
            this.f42492c = 1;
        } else {
            throw new b("Expected non-final packet");
        }
    }

    public byte[] a(byte[] bArr) {
        return a(bArr, 2, -1);
    }

    private byte[] a(byte[] bArr, int i11, int i12) {
        return a((Object) bArr, i11, i12);
    }

    /* JADX WARNING: Removed duplicated region for block: B:33:0x0107  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0126  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] a(java.lang.Object r18, int r19, int r20) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r20
            boolean r3 = r0.f42501l
            if (r3 == 0) goto L_0x000c
            r1 = 0
            return r1
        L_0x000c:
            boolean r3 = r1 instanceof java.lang.String
            if (r3 == 0) goto L_0x0017
            java.lang.String r1 = (java.lang.String) r1
            byte[] r1 = r0.a((java.lang.String) r1)
            goto L_0x0019
        L_0x0017:
            byte[] r1 = (byte[]) r1
        L_0x0019:
            r3 = 2
            r4 = 0
            if (r2 <= 0) goto L_0x001f
            r5 = r3
            goto L_0x0020
        L_0x001f:
            r5 = r4
        L_0x0020:
            int r6 = r1.length
            int r6 = r6 + r5
            r7 = 65535(0xffff, float:9.1834E-41)
            r8 = 125(0x7d, float:1.75E-43)
            if (r6 > r8) goto L_0x002b
            r10 = r3
            goto L_0x0031
        L_0x002b:
            if (r6 > r7) goto L_0x002f
            r10 = 4
            goto L_0x0031
        L_0x002f:
            r10 = 10
        L_0x0031:
            boolean r11 = r0.f42491b
            if (r11 == 0) goto L_0x0037
            r12 = 4
            goto L_0x0038
        L_0x0037:
            r12 = r4
        L_0x0038:
            int r12 = r12 + r10
            if (r11 == 0) goto L_0x003e
            r11 = 128(0x80, float:1.794E-43)
            goto L_0x003f
        L_0x003e:
            r11 = r4
        L_0x003f:
            int r13 = r6 + r12
            byte[] r13 = new byte[r13]
            r14 = r19
            byte r14 = (byte) r14
            r14 = r14 | -128(0xffffffffffffff80, float:NaN)
            byte r14 = (byte) r14
            r13[r4] = r14
            r14 = 3
            r15 = 1
            if (r6 > r8) goto L_0x0058
            r6 = r6 | r11
            byte r6 = (byte) r6
            r13[r15] = r6
        L_0x0053:
            r11 = r5
            r16 = r10
            goto L_0x0105
        L_0x0058:
            if (r6 > r7) goto L_0x0070
            r7 = r11 | 126(0x7e, float:1.77E-43)
            byte r7 = (byte) r7
            r13[r15] = r7
            int r7 = r6 / 256
            double r7 = (double) r7
            double r7 = java.lang.Math.floor(r7)
            int r7 = (int) r7
            byte r7 = (byte) r7
            r13[r3] = r7
            r6 = r6 & 255(0xff, float:3.57E-43)
            byte r6 = (byte) r6
            r13[r14] = r6
            goto L_0x0053
        L_0x0070:
            r7 = r11 | 127(0x7f, float:1.78E-43)
            byte r7 = (byte) r7
            r13[r15] = r7
            double r7 = (double) r6
            r11 = r5
            r4 = 4633078116657397760(0x404c000000000000, double:56.0)
            r16 = r10
            r9 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r4 = java.lang.Math.pow(r9, r4)
            double r4 = r7 / r4
            double r4 = java.lang.Math.floor(r4)
            int r4 = (int) r4
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            r13[r3] = r4
            r4 = 4631952216750555136(0x4048000000000000, double:48.0)
            double r4 = java.lang.Math.pow(r9, r4)
            double r4 = r7 / r4
            double r4 = java.lang.Math.floor(r4)
            int r4 = (int) r4
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            r13[r14] = r4
            r4 = 4630826316843712512(0x4044000000000000, double:40.0)
            double r4 = java.lang.Math.pow(r9, r4)
            double r4 = r7 / r4
            double r4 = java.lang.Math.floor(r4)
            int r4 = (int) r4
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            r5 = 4
            r13[r5] = r4
            r4 = 4629700416936869888(0x4040000000000000, double:32.0)
            double r4 = java.lang.Math.pow(r9, r4)
            double r4 = r7 / r4
            double r4 = java.lang.Math.floor(r4)
            int r4 = (int) r4
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            r5 = 5
            r13[r5] = r4
            r4 = 4627448617123184640(0x4038000000000000, double:24.0)
            double r4 = java.lang.Math.pow(r9, r4)
            double r4 = r7 / r4
            double r4 = java.lang.Math.floor(r4)
            int r4 = (int) r4
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            r5 = 6
            r13[r5] = r4
            r4 = 4625196817309499392(0x4030000000000000, double:16.0)
            double r4 = java.lang.Math.pow(r9, r4)
            double r4 = r7 / r4
            double r4 = java.lang.Math.floor(r4)
            int r4 = (int) r4
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            r5 = 7
            r13[r5] = r4
            r4 = 4620693217682128896(0x4020000000000000, double:8.0)
            double r4 = java.lang.Math.pow(r9, r4)
            double r7 = r7 / r4
            double r4 = java.lang.Math.floor(r7)
            int r4 = (int) r4
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            r5 = 8
            r13[r5] = r4
            r4 = r6 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            r5 = 9
            r13[r5] = r4
        L_0x0105:
            if (r2 <= 0) goto L_0x011b
            int r4 = r2 / 256
            double r4 = (double) r4
            double r4 = java.lang.Math.floor(r4)
            int r4 = (int) r4
            r4 = r4 & 255(0xff, float:3.57E-43)
            byte r4 = (byte) r4
            r13[r12] = r4
            int r4 = r12 + 1
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r2 = (byte) r2
            r13[r4] = r2
        L_0x011b:
            int r5 = r12 + r11
            int r2 = r1.length
            r4 = 0
            java.lang.System.arraycopy(r1, r4, r13, r5, r2)
            boolean r1 = r0.f42491b
            if (r1 == 0) goto L_0x0169
            r1 = 4
            byte[] r2 = new byte[r1]
            double r5 = java.lang.Math.random()
            r7 = 4643211215818981376(0x4070000000000000, double:256.0)
            double r5 = r5 * r7
            double r5 = java.lang.Math.floor(r5)
            int r1 = (int) r5
            byte r1 = (byte) r1
            r2[r4] = r1
            double r4 = java.lang.Math.random()
            double r4 = r4 * r7
            double r4 = java.lang.Math.floor(r4)
            int r1 = (int) r4
            byte r1 = (byte) r1
            r2[r15] = r1
            double r4 = java.lang.Math.random()
            double r4 = r4 * r7
            double r4 = java.lang.Math.floor(r4)
            int r1 = (int) r4
            byte r1 = (byte) r1
            r2[r3] = r1
            double r3 = java.lang.Math.random()
            double r3 = r3 * r7
            double r3 = java.lang.Math.floor(r3)
            int r1 = (int) r3
            byte r1 = (byte) r1
            r2[r14] = r1
            r3 = r16
            r1 = 4
            r4 = 0
            java.lang.System.arraycopy(r2, r4, r13, r3, r1)
            a((byte[]) r13, (byte[]) r2, (int) r12)
        L_0x0169:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.apptimize.gc.a(java.lang.Object, int, int):byte[]");
    }

    private void a() throws IOException {
        int i11 = 0;
        byte[] a11 = a(this.f42500k, this.f42499j, 0);
        int i12 = this.f42495f;
        if (i12 == 0) {
            if (this.f42498i != 0) {
                this.f42502m.write(a11);
                if (this.f42493d) {
                    byte[] byteArray = this.f42502m.toByteArray();
                    if (this.f42498i == 1) {
                        this.f42490a.a().a(c(byteArray));
                    } else {
                        this.f42490a.a().a(byteArray);
                    }
                    b();
                    return;
                }
                return;
            }
            throw new b("Mode was not set.");
        } else if (i12 == 1) {
            if (this.f42493d) {
                this.f42490a.a().a(c(a11));
                return;
            }
            this.f42498i = 1;
            this.f42502m.write(a11);
        } else if (i12 == 2) {
            if (this.f42493d) {
                this.f42490a.a().a(a11);
                return;
            }
            this.f42498i = 2;
            this.f42502m.write(a11);
        } else if (i12 == 8) {
            if (a11.length >= 2) {
                i11 = a11[1] + (a11[0] * 256);
            }
            this.f42490a.a().a(i11, a11.length > 2 ? c(a(a11, 2)) : null);
        } else if (i12 != 9) {
        } else {
            if (a11.length <= 125) {
                this.f42490a.b(a(a11, 10, -1));
                return;
            }
            throw new b("Ping payload too large");
        }
    }

    private byte[] a(String str) {
        try {
            return str.getBytes("UTF-8");
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException(e11);
        }
    }

    private byte[] a(byte[] bArr, int i11) {
        return b(bArr, i11, bArr.length);
    }
}
