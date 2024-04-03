package com.designsystem.ds_progressive_offer;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"DSProgressiveOffer", "", "descriptor", "", "progress", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;FLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSProgressiveOfferKt {
    /* JADX WARNING: Removed duplicated region for block: B:36:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DSProgressiveOffer(@org.jetbrains.annotations.NotNull java.lang.String r15, float r16, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r17, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r18, int r19, int r20) {
        /*
            r10 = r15
            r11 = r19
            java.lang.String r0 = "descriptor"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = -288947958(0xffffffffeec7010a, float:-3.0794387E28)
            r1 = r18
            androidx.compose.runtime.Composer r12 = r1.startRestartGroup(r0)
            r0 = r20 & 1
            if (r0 == 0) goto L_0x0018
            r0 = r11 | 6
            goto L_0x0028
        L_0x0018:
            r0 = r11 & 14
            if (r0 != 0) goto L_0x0027
            boolean r0 = r12.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x0024
            r0 = 4
            goto L_0x0025
        L_0x0024:
            r0 = 2
        L_0x0025:
            r0 = r0 | r11
            goto L_0x0028
        L_0x0027:
            r0 = r11
        L_0x0028:
            r1 = r20 & 2
            if (r1 == 0) goto L_0x0031
            r0 = r0 | 48
            r13 = r16
            goto L_0x0043
        L_0x0031:
            r1 = r11 & 112(0x70, float:1.57E-43)
            r13 = r16
            if (r1 != 0) goto L_0x0043
            boolean r1 = r12.changed((float) r13)
            if (r1 == 0) goto L_0x0040
            r1 = 32
            goto L_0x0042
        L_0x0040:
            r1 = 16
        L_0x0042:
            r0 = r0 | r1
        L_0x0043:
            r1 = r20 & 4
            if (r1 == 0) goto L_0x004a
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x005d
        L_0x004a:
            r2 = r11 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x005d
            r2 = r17
            boolean r3 = r12.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0059
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x005b
        L_0x0059:
            r3 = 128(0x80, float:1.794E-43)
        L_0x005b:
            r0 = r0 | r3
            goto L_0x005f
        L_0x005d:
            r2 = r17
        L_0x005f:
            r3 = r0 & 731(0x2db, float:1.024E-42)
            r3 = r3 ^ 146(0x92, float:2.05E-43)
            if (r3 != 0) goto L_0x0071
            boolean r3 = r12.getSkipping()
            if (r3 != 0) goto L_0x006c
            goto L_0x0071
        L_0x006c:
            r12.skipToGroupEnd()
            r3 = r2
            goto L_0x0097
        L_0x0071:
            if (r1 == 0) goto L_0x0077
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            r14 = r1
            goto L_0x0078
        L_0x0077:
            r14 = r2
        L_0x0078:
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            int r1 = r0 >> 6
            r1 = r1 & 14
            r2 = 1572864(0x180000, float:2.204052E-39)
            r1 = r1 | r2
            int r0 = r0 << 3
            r2 = r0 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r0 = r0 & 896(0x380, float:1.256E-42)
            r8 = r1 | r0
            r9 = 56
            r0 = r14
            r1 = r15
            r2 = r16
            r7 = r12
            com.designsystem.ds_progressive_offer.ProgressiveOfferComposablesKt.ProgressiveOfferSurface(r0, r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r3 = r14
        L_0x0097:
            androidx.compose.runtime.ScopeUpdateScope r6 = r12.endRestartGroup()
            if (r6 != 0) goto L_0x009e
            goto L_0x00ae
        L_0x009e:
            com.designsystem.ds_progressive_offer.DSProgressiveOfferKt$DSProgressiveOffer$1 r7 = new com.designsystem.ds_progressive_offer.DSProgressiveOfferKt$DSProgressiveOffer$1
            r0 = r7
            r1 = r15
            r2 = r16
            r4 = r19
            r5 = r20
            r0.<init>(r1, r2, r3, r4, r5)
            r6.updateScope(r7)
        L_0x00ae:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_progressive_offer.DSProgressiveOfferKt.DSProgressiveOffer(java.lang.String, float, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
    }
}
