package com.uxcam.internals;

import com.uxcam.video.screen.codec.codecs.h264.io.model.MBType;
import com.uxcam.video.screen.codec.codecs.h264.io.model.SeqParameterSet;

public class ap {

    /* renamed from: a  reason: collision with root package name */
    public final bc f13006a;

    /* renamed from: b  reason: collision with root package name */
    public final Cif f13007b = a();

    /* renamed from: c  reason: collision with root package name */
    public final int[] f13008c;

    /* renamed from: d  reason: collision with root package name */
    public final int[] f13009d;

    /* renamed from: e  reason: collision with root package name */
    public final int f13010e;

    public ap(SeqParameterSet seqParameterSet, int i11, int i12) {
        this.f13006a = seqParameterSet.chroma_format_idc;
        this.f13010e = (1 << i12) - 1;
        this.f13008c = new int[4];
        this.f13009d = new int[((seqParameterSet.pic_width_in_mbs_minus1 + 1) << i11)];
    }

    public static final int a(int i11, int i12) {
        return (i11 << 4) | i12;
    }

    /* JADX WARNING: Removed duplicated region for block: B:54:0x00c8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int a(com.uxcam.internals.ak r19, int[] r20, com.uxcam.internals.Cif[] r21, int r22, int r23, int[] r24, com.uxcam.internals.Cif r25) {
        /*
            r18 = this;
            r0 = r19
            r1 = r23
            int[] r2 = new int[r1]
            int[] r3 = new int[r1]
            r4 = 0
            r5 = r4
            r6 = r5
            r7 = r6
        L_0x000c:
            r8 = 1
            if (r5 >= r1) goto L_0x0027
            int r9 = r5 + r22
            r9 = r24[r9]
            r9 = r20[r9]
            if (r9 != 0) goto L_0x001f
            r9 = r2[r6]
            int r9 = r9 + r8
            r2[r6] = r9
            int r7 = r7 + 1
            goto L_0x0024
        L_0x001f:
            int r8 = r6 + 1
            r3[r6] = r9
            r6 = r8
        L_0x0024:
            int r5 = r5 + 1
            goto L_0x000c
        L_0x0027:
            if (r6 >= r1) goto L_0x002c
            r5 = r2[r6]
            int r7 = r7 - r5
        L_0x002c:
            r5 = r4
        L_0x002d:
            r9 = 3
            if (r5 >= r6) goto L_0x0040
            if (r5 >= r9) goto L_0x0040
            int r10 = r6 - r5
            int r10 = r10 - r8
            r10 = r3[r10]
            int r10 = java.lang.Math.abs(r10)
            if (r10 != r8) goto L_0x0040
            int r5 = r5 + 1
            goto L_0x002d
        L_0x0040:
            int r10 = a(r6, r5)
            r11 = r25
            r11.a(r0, r10)
            if (r6 <= 0) goto L_0x0102
            int r11 = r6 + -1
            r12 = r11
        L_0x004e:
            int r13 = r6 - r5
            if (r12 < r13) goto L_0x005c
            r13 = r3[r12]
            int r13 = r13 >>> 31
            r0.b(r13)
            int r12 = r12 + -1
            goto L_0x004e
        L_0x005c:
            r12 = 10
            if (r6 <= r12) goto L_0x0063
            if (r5 >= r9) goto L_0x0063
            r4 = r8
        L_0x0063:
            int r13 = r13 - r8
            r12 = r13
        L_0x0065:
            if (r12 < 0) goto L_0x00e1
            r15 = r3[r12]
            int r16 = r15 >>> 31
            int r17 = r15 >> 31
            r15 = r15 ^ r17
            int r15 = r15 - r17
            int r15 = r15 << r8
            int r15 = r15 + r16
            int r15 = r15 + -2
            if (r12 != r13) goto L_0x007c
            if (r5 >= r9) goto L_0x007c
            int r15 = r15 + -2
        L_0x007c:
            int r14 = r15 >> r4
            if (r4 != 0) goto L_0x0084
            r9 = 14
            if (r14 < r9) goto L_0x008a
        L_0x0084:
            r9 = 15
            if (r4 <= 0) goto L_0x0095
            if (r14 >= r9) goto L_0x0095
        L_0x008a:
            int r14 = r14 + 1
            r0.a(r8, r14)
            r0.a(r15, r4)
        L_0x0092:
            r16 = r5
            goto L_0x00c6
        L_0x0095:
            if (r4 != 0) goto L_0x00a5
            r14 = 30
            if (r15 >= r14) goto L_0x00a5
            r0.a(r8, r9)
            int r15 = r15 + -14
            r9 = 4
            r0.a(r15, r9)
            goto L_0x0092
        L_0x00a5:
            if (r4 != 0) goto L_0x00a9
            int r15 = r15 + -15
        L_0x00a9:
            r9 = 12
        L_0x00ab:
            int r14 = r9 + 3
            int r14 = r14 << r4
            int r14 = r15 - r14
            r16 = r5
            int r5 = r8 << r9
            int r14 = r14 - r5
            int r14 = r14 + 4096
            if (r14 < r5) goto L_0x00be
            int r9 = r9 + 1
            r5 = r16
            goto L_0x00ab
        L_0x00be:
            int r5 = r9 + 4
            r0.a(r8, r5)
            r0.a(r14, r9)
        L_0x00c6:
            if (r4 != 0) goto L_0x00c9
            r4 = r8
        L_0x00c9:
            r5 = r3[r12]
            int r9 = r5 >> 31
            r5 = r5 ^ r9
            int r5 = r5 - r9
            int r9 = r4 + -1
            r14 = 3
            int r9 = r14 << r9
            if (r5 <= r9) goto L_0x00db
            r5 = 6
            if (r4 >= r5) goto L_0x00db
            int r4 = r4 + 1
        L_0x00db:
            int r12 = r12 + -1
            r9 = r14
            r5 = r16
            goto L_0x0065
        L_0x00e1:
            if (r6 >= r1) goto L_0x0102
            r1 = r21[r11]
            r1.a(r0, r7)
        L_0x00e8:
            if (r11 <= 0) goto L_0x0102
            if (r7 <= 0) goto L_0x0102
            com.uxcam.internals.if[] r1 = com.uxcam.internals.cw.f13168d
            int r3 = r7 + -1
            r4 = 6
            int r3 = java.lang.Math.min(r4, r3)
            r1 = r1[r3]
            r3 = r2[r11]
            r1.a(r0, r3)
            r1 = r2[r11]
            int r7 = r7 - r1
            int r11 = r11 + -1
            goto L_0x00e8
        L_0x0102:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.ap.a(com.uxcam.internals.ak, int[], com.uxcam.internals.if[], int, int, int[], com.uxcam.internals.if):int");
    }

    public Cif a(boolean z11, MBType mBType, int i11, boolean z12, MBType mBType2, int i12) {
        int i13 = 0;
        int i14 = mBType == null ? 0 : i11 >> 4;
        int i15 = mBType2 == null ? 0 : i12 >> 4;
        if (z11 && z12) {
            i13 = ((i14 + i15) + 1) >> 1;
        } else if (z11) {
            i13 = i14;
        } else if (z12) {
            i13 = i15;
        }
        return cw.f13165a[Math.min(i13, 8)];
    }

    public Cif a() {
        bc bcVar = this.f13006a;
        if (bcVar == bc.YUV420) {
            return cw.f13166b;
        }
        if (bcVar == bc.YUV422) {
            return cw.f13167c;
        }
        if (bcVar == bc.YUV444) {
            return cw.f13165a[0];
        }
        return null;
    }
}
