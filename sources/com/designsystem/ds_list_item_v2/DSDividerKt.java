package com.designsystem.ds_list_item_v2;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a3\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\t"}, d2 = {"DSDivider", "", "modifier", "Landroidx/compose/ui/Modifier;", "paddingStart", "Landroidx/compose/ui/unit/Dp;", "paddingEnd", "DSDivider-WMci_g0", "(Landroidx/compose/ui/Modifier;FFLandroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSDividerKt {
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0075  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d7  */
    /* JADX WARNING: Removed duplicated region for block: B:53:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* renamed from: DSDivider-WMci_g0  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8478DSDividerWMci_g0(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r18, float r19, float r20, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            r4 = r22
            r0 = -1153096506(0xffffffffbb4524c6, float:-0.0030081733)
            r1 = r21
            androidx.compose.runtime.Composer r0 = r1.startRestartGroup(r0)
            r1 = r23 & 1
            if (r1 == 0) goto L_0x0015
            r2 = r4 | 6
            r3 = r2
            r2 = r18
            goto L_0x0029
        L_0x0015:
            r2 = r4 & 14
            if (r2 != 0) goto L_0x0026
            r2 = r18
            boolean r3 = r0.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0023
            r3 = 4
            goto L_0x0024
        L_0x0023:
            r3 = 2
        L_0x0024:
            r3 = r3 | r4
            goto L_0x0029
        L_0x0026:
            r2 = r18
            r3 = r4
        L_0x0029:
            r5 = r23 & 2
            if (r5 == 0) goto L_0x0030
            r3 = r3 | 48
            goto L_0x0043
        L_0x0030:
            r6 = r4 & 112(0x70, float:1.57E-43)
            if (r6 != 0) goto L_0x0043
            r6 = r19
            boolean r7 = r0.changed((float) r6)
            if (r7 == 0) goto L_0x003f
            r7 = 32
            goto L_0x0041
        L_0x003f:
            r7 = 16
        L_0x0041:
            r3 = r3 | r7
            goto L_0x0045
        L_0x0043:
            r6 = r19
        L_0x0045:
            r7 = r23 & 4
            if (r7 == 0) goto L_0x004c
            r3 = r3 | 384(0x180, float:5.38E-43)
            goto L_0x005f
        L_0x004c:
            r8 = r4 & 896(0x380, float:1.256E-42)
            if (r8 != 0) goto L_0x005f
            r8 = r20
            boolean r9 = r0.changed((float) r8)
            if (r9 == 0) goto L_0x005b
            r9 = 256(0x100, float:3.59E-43)
            goto L_0x005d
        L_0x005b:
            r9 = 128(0x80, float:1.794E-43)
        L_0x005d:
            r3 = r3 | r9
            goto L_0x0061
        L_0x005f:
            r8 = r20
        L_0x0061:
            r3 = r3 & 731(0x2db, float:1.024E-42)
            r3 = r3 ^ 146(0x92, float:2.05E-43)
            if (r3 != 0) goto L_0x0075
            boolean r3 = r0.getSkipping()
            if (r3 != 0) goto L_0x006e
            goto L_0x0075
        L_0x006e:
            r0.skipToGroupEnd()
            r1 = r2
            r2 = r6
            r3 = r8
            goto L_0x00d0
        L_0x0075:
            if (r1 == 0) goto L_0x007a
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            goto L_0x007b
        L_0x007a:
            r1 = r2
        L_0x007b:
            r2 = 0
            if (r5 == 0) goto L_0x0084
            float r3 = (float) r2
            float r3 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r3)
            goto L_0x0085
        L_0x0084:
            r3 = r6
        L_0x0085:
            if (r7 == 0) goto L_0x008e
            float r5 = (float) r2
            float r5 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r5)
            r15 = r5
            goto L_0x008f
        L_0x008e:
            r15 = r8
        L_0x008f:
            r5 = 1
            float r6 = (float) r5
            float r6 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r6)
            androidx.compose.ui.Modifier r6 = androidx.compose.foundation.layout.SizeKt.m544height3ABfNKs(r1, r6)
            r7 = 0
            r8 = 0
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r6, r7, r5, r8)
            float r6 = (float) r2
            float r7 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r6)
            float r6 = androidx.compose.ui.unit.Dp.m5478constructorimpl(r6)
            androidx.compose.ui.Modifier r5 = androidx.compose.foundation.layout.PaddingKt.m489paddingqDBjuR0(r5, r3, r7, r15, r6)
            java.lang.String r6 = "DSDividerTestTag"
            androidx.compose.ui.Modifier r5 = androidx.compose.ui.platform.TestTagKt.testTag(r5, r6)
            r6 = 0
            int r7 = com.designsystem.marshmallow.R.color.ds_neutral_10
            long r7 = androidx.compose.ui.res.ColorResources_androidKt.colorResource(r7, r0, r2)
            r9 = 0
            r11 = 0
            r12 = 0
            com.designsystem.ds_list_item_v2.ComposableSingletons$DSDividerKt r2 = com.designsystem.ds_list_item_v2.ComposableSingletons$DSDividerKt.INSTANCE
            kotlin.jvm.functions.Function2 r13 = r2.m8472getLambda1$marshmallow_release()
            r2 = 0
            r16 = 58
            r14 = r0
            r17 = r15
            r15 = r2
            androidx.compose.material.SurfaceKt.m1384SurfaceFjzlyU(r5, r6, r7, r9, r11, r12, r13, r14, r15, r16)
            r2 = r3
            r3 = r17
        L_0x00d0:
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L_0x00d7
            goto L_0x00e4
        L_0x00d7:
            com.designsystem.ds_list_item_v2.DSDividerKt$DSDivider$1 r7 = new com.designsystem.ds_list_item_v2.DSDividerKt$DSDivider$1
            r0 = r7
            r4 = r22
            r5 = r23
            r0.<init>(r1, r2, r3, r4, r5)
            r6.updateScope(r7)
        L_0x00e4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_list_item_v2.DSDividerKt.m8478DSDividerWMci_g0(androidx.compose.ui.Modifier, float, float, androidx.compose.runtime.Composer, int, int):void");
    }
}
