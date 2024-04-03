package com.designsystem.ds_progressive_offer;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\u001aK\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"DSTieredProgressiveOffer", "", "headline", "", "progress", "", "modifier", "Landroidx/compose/ui/Modifier;", "descriptor", "headlineIcon", "", "expirationTimestamp", "", "(Ljava/lang/String;FLandroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Long;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSTieredProgressiveOfferKt {
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0083  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:87:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DSTieredProgressiveOffer(@org.jetbrains.annotations.NotNull java.lang.String r18, float r19, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r20, @org.jetbrains.annotations.Nullable java.lang.String r21, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r22, @org.jetbrains.annotations.Nullable java.lang.Long r23, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r10 = r18
            r11 = r25
            java.lang.String r0 = "headline"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = -1419409514(0xffffffffab658796, float:-8.1545307E-13)
            r1 = r24
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            r0 = r26 & 1
            if (r0 == 0) goto L_0x0019
            r0 = r11 | 6
            goto L_0x0029
        L_0x0019:
            r0 = r11 & 14
            if (r0 != 0) goto L_0x0028
            boolean r0 = r12.changed((java.lang.Object) r10)
            if (r0 == 0) goto L_0x0025
            r0 = 4
            goto L_0x0026
        L_0x0025:
            r0 = 2
        L_0x0026:
            r0 = r0 | r11
            goto L_0x0029
        L_0x0028:
            r0 = r11
        L_0x0029:
            r1 = r26 & 2
            if (r1 == 0) goto L_0x0032
            r0 = r0 | 48
            r13 = r19
            goto L_0x0044
        L_0x0032:
            r1 = r11 & 112(0x70, float:1.57E-43)
            r13 = r19
            if (r1 != 0) goto L_0x0044
            boolean r1 = r12.changed((float) r13)
            if (r1 == 0) goto L_0x0041
            r1 = 32
            goto L_0x0043
        L_0x0041:
            r1 = 16
        L_0x0043:
            r0 = r0 | r1
        L_0x0044:
            r1 = r26 & 4
            if (r1 == 0) goto L_0x004b
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x005e
        L_0x004b:
            r2 = r11 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x005e
            r2 = r20
            boolean r3 = r12.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x005a
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x005c
        L_0x005a:
            r3 = 128(0x80, float:1.794E-43)
        L_0x005c:
            r0 = r0 | r3
            goto L_0x0060
        L_0x005e:
            r2 = r20
        L_0x0060:
            r3 = r26 & 8
            if (r3 == 0) goto L_0x0067
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x007a
        L_0x0067:
            r4 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x007a
            r4 = r21
            boolean r5 = r12.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0076
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x0078
        L_0x0076:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x0078:
            r0 = r0 | r5
            goto L_0x007c
        L_0x007a:
            r4 = r21
        L_0x007c:
            r5 = r26 & 16
            r6 = 57344(0xe000, float:8.0356E-41)
            if (r5 == 0) goto L_0x0086
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x0099
        L_0x0086:
            r7 = r11 & r6
            if (r7 != 0) goto L_0x0099
            r7 = r22
            boolean r8 = r12.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0095
            r8 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0097
        L_0x0095:
            r8 = 8192(0x2000, float:1.14794E-41)
        L_0x0097:
            r0 = r0 | r8
            goto L_0x009b
        L_0x0099:
            r7 = r22
        L_0x009b:
            r8 = r26 & 32
            r9 = 458752(0x70000, float:6.42848E-40)
            if (r8 == 0) goto L_0x00a5
            r14 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r14
            goto L_0x00b8
        L_0x00a5:
            r14 = r11 & r9
            if (r14 != 0) goto L_0x00b8
            r14 = r23
            boolean r15 = r12.changed((java.lang.Object) r14)
            if (r15 == 0) goto L_0x00b4
            r15 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b6
        L_0x00b4:
            r15 = 65536(0x10000, float:9.18355E-41)
        L_0x00b6:
            r0 = r0 | r15
            goto L_0x00ba
        L_0x00b8:
            r14 = r23
        L_0x00ba:
            r15 = 374491(0x5b6db, float:5.24774E-40)
            r15 = r15 & r0
            r16 = 74898(0x12492, float:1.04954E-40)
            r15 = r15 ^ r16
            if (r15 != 0) goto L_0x00d3
            boolean r15 = r12.getSkipping()
            if (r15 != 0) goto L_0x00cc
            goto L_0x00d3
        L_0x00cc:
            r12.skipToGroupEnd()
            r3 = r2
            r5 = r7
            r6 = r14
            goto L_0x011d
        L_0x00d3:
            if (r1 == 0) goto L_0x00d9
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            r15 = r1
            goto L_0x00da
        L_0x00d9:
            r15 = r2
        L_0x00da:
            r1 = 0
            if (r3 == 0) goto L_0x00e0
            r16 = r1
            goto L_0x00e2
        L_0x00e0:
            r16 = r4
        L_0x00e2:
            if (r5 == 0) goto L_0x00e7
            r17 = r1
            goto L_0x00e9
        L_0x00e7:
            r17 = r7
        L_0x00e9:
            if (r8 == 0) goto L_0x00ec
            r14 = r1
        L_0x00ec:
            r7 = 1
            int r1 = r0 >> 6
            r2 = r1 & 14
            r3 = 1572864(0x180000, float:2.204052E-39)
            r2 = r2 | r3
            r1 = r1 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            int r2 = r0 << 3
            r2 = r2 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r2 = r0 << 9
            r2 = r2 & 7168(0x1c00, float:1.0045E-41)
            r1 = r1 | r2
            r2 = r0 & r6
            r1 = r1 | r2
            r0 = r0 & r9
            r8 = r1 | r0
            r9 = 0
            r0 = r15
            r1 = r16
            r2 = r19
            r3 = r18
            r4 = r17
            r5 = r14
            r6 = r7
            r7 = r12
            com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt.ProgressiveOfferSurface(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r6 = r14
            r3 = r15
            r4 = r16
            r5 = r17
        L_0x011d:
            androidx.compose.runtime.ScopeUpdateScope r9 = r12.endRestartGroup()
            if (r9 != 0) goto L_0x0124
            goto L_0x0135
        L_0x0124:
            com.designsystem.ds_progressive_offer.DSTieredProgressiveOfferKt$DSTieredProgressiveOffer$1 r12 = new com.designsystem.ds_progressive_offer.DSTieredProgressiveOfferKt$DSTieredProgressiveOffer$1
            r0 = r12
            r1 = r18
            r2 = r19
            r7 = r25
            r8 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r9.updateScope(r12)
        L_0x0135:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_progressive_offer.DSTieredProgressiveOfferKt.DSTieredProgressiveOffer(java.lang.String, float, androidx.compose.ui.Modifier, java.lang.String, java.lang.Integer, java.lang.Long, androidx.compose.runtime.Composer, int, int):void");
    }
}
