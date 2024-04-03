package com.designsystem.ds_tag_v2;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001aC\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"DSTag2", "", "modifier", "Landroidx/compose/ui/Modifier;", "label", "", "priority", "Lcom/designsystem/ds_tag_v2/DSTagPriority;", "size", "Lcom/designsystem/ds_tag_v2/DSTagSize;", "color", "Lcom/designsystem/ds_tag_v2/DSTagColor;", "icon", "", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Lcom/designsystem/ds_tag_v2/DSTagPriority;Lcom/designsystem/ds_tag_v2/DSTagSize;Lcom/designsystem/ds_tag_v2/DSTagColor;Ljava/lang/Integer;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSTag2Kt {
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00d8  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DSTag2(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r16, @org.jetbrains.annotations.NotNull java.lang.String r17, @org.jetbrains.annotations.NotNull com.designsystem.ds_tag_v2.DSTagPriority r18, @org.jetbrains.annotations.NotNull com.designsystem.ds_tag_v2.DSTagSize r19, @org.jetbrains.annotations.NotNull com.designsystem.ds_tag_v2.DSTagColor r20, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r21, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            r8 = r17
            r9 = r18
            r10 = r19
            r11 = r20
            r12 = r23
            java.lang.String r0 = "label"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "priority"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            java.lang.String r0 = "size"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            java.lang.String r0 = "color"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            r0 = -2018200748(0xffffffff87b4b354, float:-2.718879E-34)
            r1 = r22
            androidx.compose.runtime.Composer r13 = r1.startRestartGroup(r0)
            r0 = r24 & 1
            if (r0 == 0) goto L_0x0031
            r1 = r12 | 6
            r2 = r1
            r1 = r16
            goto L_0x0045
        L_0x0031:
            r1 = r12 & 14
            if (r1 != 0) goto L_0x0042
            r1 = r16
            boolean r2 = r13.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x003f
            r2 = 4
            goto L_0x0040
        L_0x003f:
            r2 = 2
        L_0x0040:
            r2 = r2 | r12
            goto L_0x0045
        L_0x0042:
            r1 = r16
            r2 = r12
        L_0x0045:
            r3 = r24 & 2
            if (r3 == 0) goto L_0x004c
            r2 = r2 | 48
            goto L_0x005c
        L_0x004c:
            r3 = r12 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x005c
            boolean r3 = r13.changed((java.lang.Object) r8)
            if (r3 == 0) goto L_0x0059
            r3 = 32
            goto L_0x005b
        L_0x0059:
            r3 = 16
        L_0x005b:
            r2 = r2 | r3
        L_0x005c:
            r3 = r24 & 4
            if (r3 == 0) goto L_0x0063
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0073
        L_0x0063:
            r3 = r12 & 896(0x380, float:1.256E-42)
            if (r3 != 0) goto L_0x0073
            boolean r3 = r13.changed((java.lang.Object) r9)
            if (r3 == 0) goto L_0x0070
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0072
        L_0x0070:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0072:
            r2 = r2 | r3
        L_0x0073:
            r3 = r24 & 8
            if (r3 == 0) goto L_0x007a
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x008a
        L_0x007a:
            r3 = r12 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x008a
            boolean r3 = r13.changed((java.lang.Object) r10)
            if (r3 == 0) goto L_0x0087
            r3 = 2048(0x800, float:2.87E-42)
            goto L_0x0089
        L_0x0087:
            r3 = 1024(0x400, float:1.435E-42)
        L_0x0089:
            r2 = r2 | r3
        L_0x008a:
            r3 = r24 & 16
            if (r3 == 0) goto L_0x0091
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a3
        L_0x0091:
            r3 = 57344(0xe000, float:8.0356E-41)
            r3 = r3 & r12
            if (r3 != 0) goto L_0x00a3
            boolean r3 = r13.changed((java.lang.Object) r11)
            if (r3 == 0) goto L_0x00a0
            r3 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a2
        L_0x00a0:
            r3 = 8192(0x2000, float:1.14794E-41)
        L_0x00a2:
            r2 = r2 | r3
        L_0x00a3:
            r3 = r24 & 32
            if (r3 == 0) goto L_0x00ab
            r4 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r4
            goto L_0x00bf
        L_0x00ab:
            r4 = 458752(0x70000, float:6.42848E-40)
            r4 = r4 & r12
            if (r4 != 0) goto L_0x00bf
            r4 = r21
            boolean r5 = r13.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x00bb
            r5 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00bd
        L_0x00bb:
            r5 = 65536(0x10000, float:9.18355E-41)
        L_0x00bd:
            r2 = r2 | r5
            goto L_0x00c1
        L_0x00bf:
            r4 = r21
        L_0x00c1:
            r7 = r2
            r2 = 374491(0x5b6db, float:5.24774E-40)
            r2 = r2 & r7
            r5 = 74898(0x12492, float:1.04954E-40)
            r2 = r2 ^ r5
            if (r2 != 0) goto L_0x00d8
            boolean r2 = r13.getSkipping()
            if (r2 != 0) goto L_0x00d3
            goto L_0x00d8
        L_0x00d3:
            r13.skipToGroupEnd()
            r6 = r4
            goto L_0x0103
        L_0x00d8:
            if (r0 == 0) goto L_0x00de
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            r14 = r0
            goto L_0x00df
        L_0x00de:
            r14 = r1
        L_0x00df:
            if (r3 == 0) goto L_0x00e4
            r0 = 0
            r15 = r0
            goto L_0x00e5
        L_0x00e4:
            r15 = r4
        L_0x00e5:
            com.designsystem.ds_tag_v2.DSTag2Kt$DSTag2$1 r6 = new com.designsystem.ds_tag_v2.DSTag2Kt$DSTag2$1
            r0 = r6
            r1 = r14
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r8 = r6
            r6 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = -819896091(0xffffffffcf2160e5, float:-2.70748186E9)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r13, r0, r1, r8)
            r1 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r0, r13, r1)
            r1 = r14
        L_0x0103:
            androidx.compose.runtime.ScopeUpdateScope r13 = r13.endRestartGroup()
            if (r13 != 0) goto L_0x010a
            goto L_0x011f
        L_0x010a:
            com.designsystem.ds_tag_v2.DSTag2Kt$DSTag2$2 r14 = new com.designsystem.ds_tag_v2.DSTag2Kt$DSTag2$2
            r0 = r14
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r20
            r7 = r23
            r8 = r24
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r13.updateScope(r14)
        L_0x011f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_tag_v2.DSTag2Kt.DSTag2(androidx.compose.ui.Modifier, java.lang.String, com.designsystem.ds_tag_v2.DSTagPriority, com.designsystem.ds_tag_v2.DSTagSize, com.designsystem.ds_tag_v2.DSTagColor, java.lang.Integer, androidx.compose.runtime.Composer, int, int):void");
    }
}
