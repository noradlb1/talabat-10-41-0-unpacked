package com.uxcam.internals;

public class gq {
    /* JADX WARNING: Removed duplicated region for block: B:26:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a5 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.uxcam.video.screen.codec.codecs.h264.io.model.SliceHeader r10, com.uxcam.internals.ak r11, int r12) {
        /*
            r9 = this;
            com.uxcam.video.screen.codec.codecs.h264.io.model.SeqParameterSet r0 = r10.sps
            com.uxcam.video.screen.codec.codecs.h264.io.model.PredictionWeightTable r1 = r10.pred_weight_table
            int r2 = r1.luma_log2_weight_denom
            r3 = 1
            int r2 = r3 << r2
            int r1 = r1.chroma_log2_weight_denom
            int r1 = r3 << r1
            r4 = 0
            r5 = r4
        L_0x000f:
            com.uxcam.video.screen.codec.codecs.h264.io.model.PredictionWeightTable r6 = r10.pred_weight_table
            int[][] r7 = r6.luma_weight
            r7 = r7[r12]
            int r8 = r7.length
            if (r5 >= r8) goto L_0x00a9
            r7 = r7[r5]
            if (r7 != r2) goto L_0x0027
            int[][] r6 = r6.luma_offset
            r6 = r6[r12]
            r6 = r6[r5]
            if (r6 == 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r6 = r4
            goto L_0x0028
        L_0x0027:
            r6 = r3
        L_0x0028:
            r11.b(r6)
            if (r6 == 0) goto L_0x004b
            com.uxcam.video.screen.codec.codecs.h264.io.model.PredictionWeightTable r6 = r10.pred_weight_table
            int[][] r6 = r6.luma_weight
            r6 = r6[r12]
            r6 = r6[r5]
            int r6 = com.uxcam.internals.dv.a(r6)
            com.uxcam.internals.ar.a(r11, r6)
            com.uxcam.video.screen.codec.codecs.h264.io.model.PredictionWeightTable r6 = r10.pred_weight_table
            int[][] r6 = r6.luma_offset
            r6 = r6[r12]
            r6 = r6[r5]
            int r6 = com.uxcam.internals.dv.a(r6)
            com.uxcam.internals.ar.a(r11, r6)
        L_0x004b:
            com.uxcam.internals.bc r6 = r0.chroma_format_idc
            com.uxcam.internals.bc r7 = com.uxcam.internals.bc.MONO
            if (r6 == r7) goto L_0x00a5
            com.uxcam.video.screen.codec.codecs.h264.io.model.PredictionWeightTable r6 = r10.pred_weight_table
            int[][][] r7 = r6.chroma_weight
            r7 = r7[r12]
            r8 = r7[r4]
            r8 = r8[r5]
            if (r8 != r1) goto L_0x0076
            int[][][] r6 = r6.chroma_offset
            r6 = r6[r12]
            r8 = r6[r4]
            r8 = r8[r5]
            if (r8 != 0) goto L_0x0076
            r7 = r7[r3]
            r7 = r7[r5]
            if (r7 != r1) goto L_0x0076
            r6 = r6[r3]
            r6 = r6[r5]
            if (r6 == 0) goto L_0x0074
            goto L_0x0076
        L_0x0074:
            r6 = r4
            goto L_0x0077
        L_0x0076:
            r6 = r3
        L_0x0077:
            r11.b(r6)
            if (r6 == 0) goto L_0x00a5
            r6 = r4
        L_0x007d:
            r7 = 2
            if (r6 >= r7) goto L_0x00a5
            com.uxcam.video.screen.codec.codecs.h264.io.model.PredictionWeightTable r7 = r10.pred_weight_table
            int[][][] r7 = r7.chroma_weight
            r7 = r7[r12]
            r7 = r7[r6]
            r7 = r7[r5]
            int r7 = com.uxcam.internals.dv.a(r7)
            com.uxcam.internals.ar.a(r11, r7)
            com.uxcam.video.screen.codec.codecs.h264.io.model.PredictionWeightTable r7 = r10.pred_weight_table
            int[][][] r7 = r7.chroma_offset
            r7 = r7[r12]
            r7 = r7[r6]
            r7 = r7[r5]
            int r7 = com.uxcam.internals.dv.a(r7)
            com.uxcam.internals.ar.a(r11, r7)
            int r6 = r6 + 1
            goto L_0x007d
        L_0x00a5:
            int r5 = r5 + 1
            goto L_0x000f
        L_0x00a9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.gq.a(com.uxcam.video.screen.codec.codecs.h264.io.model.SliceHeader, com.uxcam.internals.ak, int):void");
    }

    public final void a(int[][] iArr, ak akVar) {
        if (iArr != null) {
            int i11 = 0;
            while (true) {
                int[] iArr2 = iArr[0];
                if (i11 < iArr2.length) {
                    ar.a(akVar, iArr2[i11]);
                    ar.a(akVar, iArr[1][i11]);
                    i11++;
                } else {
                    ar.a(akVar, 3);
                    return;
                }
            }
        }
    }
}
