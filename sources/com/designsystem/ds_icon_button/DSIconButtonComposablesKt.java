package com.designsystem.ds_icon_button;

import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001aY\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\"\u0013\u0010\u0000\u001a\u00020\u0001X\u0004ø\u0001\u0000¢\u0006\u0004\n\u0002\u0010\u0002\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0013"}, d2 = {"Size", "Landroidx/compose/ui/unit/Dp;", "F", "IconButtonSurface", "", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "", "onTap", "Lkotlin/Function0;", "iconColor", "Landroidx/compose/ui/graphics/Color;", "size", "Lcom/designsystem/ds_icon_button/DSIconButtonSize;", "showRoundedBackground", "", "IconButtonSurface-_trzp-w", "(Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/Color;Lcom/designsystem/ds_icon_button/DSIconButtonSize;Ljava/lang/Boolean;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSIconButtonComposablesKt {
    /* access modifiers changed from: private */
    public static final float Size = Dp.m5478constructorimpl((float) 48);

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00a0  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d4  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01dc  */
    /* JADX WARNING: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* renamed from: IconButtonSurface-_trzp-w  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8354IconButtonSurface_trzpw(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r35, @androidx.annotation.DrawableRes int r36, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r37, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Color r38, @org.jetbrains.annotations.NotNull com.designsystem.ds_icon_button.DSIconButtonSize r39, @org.jetbrains.annotations.Nullable java.lang.Boolean r40, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r41, int r42, int r43) {
        /*
            r1 = r35
            r10 = r39
            r11 = r42
            java.lang.String r0 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "size"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r10, r0)
            r0 = 1391205748(0x52ec1d74, float:5.07053212E11)
            r2 = r41
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            r2 = r43 & 1
            if (r2 == 0) goto L_0x0020
            r2 = r11 | 6
            goto L_0x0030
        L_0x0020:
            r2 = r11 & 14
            if (r2 != 0) goto L_0x002f
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x002c
            r2 = 4
            goto L_0x002d
        L_0x002c:
            r2 = 2
        L_0x002d:
            r2 = r2 | r11
            goto L_0x0030
        L_0x002f:
            r2 = r11
        L_0x0030:
            r3 = r43 & 2
            if (r3 == 0) goto L_0x0039
            r2 = r2 | 48
            r14 = r36
            goto L_0x004b
        L_0x0039:
            r3 = r11 & 112(0x70, float:1.57E-43)
            r14 = r36
            if (r3 != 0) goto L_0x004b
            boolean r3 = r0.changed((int) r14)
            if (r3 == 0) goto L_0x0048
            r3 = 32
            goto L_0x004a
        L_0x0048:
            r3 = 16
        L_0x004a:
            r2 = r2 | r3
        L_0x004b:
            r3 = r43 & 4
            if (r3 == 0) goto L_0x0052
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0065
        L_0x0052:
            r4 = r11 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0065
            r4 = r37
            boolean r5 = r0.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0061
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r2 = r2 | r5
            goto L_0x0067
        L_0x0065:
            r4 = r37
        L_0x0067:
            r5 = r43 & 8
            if (r5 == 0) goto L_0x006e
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x006e:
            r6 = r11 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0081
            r6 = r38
            boolean r7 = r0.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x007d
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r2 = r2 | r7
            goto L_0x0083
        L_0x0081:
            r6 = r38
        L_0x0083:
            r7 = r43 & 16
            if (r7 == 0) goto L_0x008a
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009c
        L_0x008a:
            r7 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r11
            if (r7 != 0) goto L_0x009c
            boolean r7 = r0.changed((java.lang.Object) r10)
            if (r7 == 0) goto L_0x0099
            r7 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009b
        L_0x0099:
            r7 = 8192(0x2000, float:1.14794E-41)
        L_0x009b:
            r2 = r2 | r7
        L_0x009c:
            r7 = r43 & 32
            if (r7 == 0) goto L_0x00a4
            r8 = 196608(0x30000, float:2.75506E-40)
            r2 = r2 | r8
            goto L_0x00b8
        L_0x00a4:
            r8 = 458752(0x70000, float:6.42848E-40)
            r8 = r8 & r11
            if (r8 != 0) goto L_0x00b8
            r8 = r40
            boolean r9 = r0.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x00b4
            r9 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b6
        L_0x00b4:
            r9 = 65536(0x10000, float:9.18355E-41)
        L_0x00b6:
            r2 = r2 | r9
            goto L_0x00ba
        L_0x00b8:
            r8 = r40
        L_0x00ba:
            r9 = r2
            r2 = 374491(0x5b6db, float:5.24774E-40)
            r2 = r2 & r9
            r12 = 74898(0x12492, float:1.04954E-40)
            r2 = r2 ^ r12
            if (r2 != 0) goto L_0x00d4
            boolean r2 = r0.getSkipping()
            if (r2 != 0) goto L_0x00cc
            goto L_0x00d4
        L_0x00cc:
            r0.skipToGroupEnd()
            r3 = r4
            r4 = r6
            r6 = r8
            goto L_0x01d5
        L_0x00d4:
            r2 = 0
            if (r3 == 0) goto L_0x00da
            r24 = r2
            goto L_0x00dc
        L_0x00da:
            r24 = r4
        L_0x00dc:
            if (r5 == 0) goto L_0x00e1
            r25 = r2
            goto L_0x00e3
        L_0x00e1:
            r25 = r6
        L_0x00e3:
            if (r7 == 0) goto L_0x00e9
            java.lang.Boolean r3 = java.lang.Boolean.FALSE
            r15 = r3
            goto L_0x00ea
        L_0x00e9:
            r15 = r8
        L_0x00ea:
            java.lang.Boolean r3 = java.lang.Boolean.TRUE
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r3)
            r5 = 0
            if (r4 == 0) goto L_0x0107
            r4 = 1391206030(0x52ec1e8e, float:5.07062452E11)
            r0.startReplaceableGroup(r4)
            com.designsystem.ds_theme.DSTheme r4 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSColors r4 = r4.getColors(r0, r5)
            long r6 = r4.m8774getDsNeutralWhite0d7_KjU()
            r0.endReplaceableGroup()
            goto L_0x011a
        L_0x0107:
            r4 = 1391206081(0x52ec1ec1, float:5.07064123E11)
            r0.startReplaceableGroup(r4)
            com.designsystem.ds_theme.DSTheme r4 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSColors r4 = r4.getColors(r0, r5)
            long r6 = r4.m8817getDsTransparentFill0d7_KjU()
            r0.endReplaceableGroup()
        L_0x011a:
            if (r25 != 0) goto L_0x0153
            r4 = 1391206171(0x52ec1f1b, float:5.07067073E11)
            r0.startReplaceableGroup(r4)
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x013c
            r3 = 1391206206(0x52ec1f3e, float:5.07068219E11)
            r0.startReplaceableGroup(r3)
            com.designsystem.ds_theme.DSTheme r3 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSColors r3 = r3.getColors(r0, r5)
            long r3 = r3.m8760getDsNeutral1000d7_KjU()
            r0.endReplaceableGroup()
            goto L_0x014f
        L_0x013c:
            r3 = 1391206263(0x52ec1f77, float:5.07070087E11)
            r0.startReplaceableGroup(r3)
            com.designsystem.ds_theme.DSTheme r3 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSColors r3 = r3.getColors(r0, r5)
            long r3 = r3.m8771getDsNeutral700d7_KjU()
            r0.endReplaceableGroup()
        L_0x014f:
            r0.endReplaceableGroup()
            goto L_0x0160
        L_0x0153:
            r3 = 1391206150(0x52ec1f06, float:5.07066384E11)
            r0.startReplaceableGroup(r3)
            r0.endReplaceableGroup()
            long r3 = r25.m2929unboximpl()
        L_0x0160:
            r12 = r3
            float r3 = Size
            androidx.compose.ui.Modifier r26 = androidx.compose.foundation.layout.SizeKt.m558size3ABfNKs(r1, r3)
            if (r24 != 0) goto L_0x016e
            com.designsystem.ds_icon_button.DSIconButtonComposablesKt$IconButtonSurface$1 r3 = com.designsystem.ds_icon_button.DSIconButtonComposablesKt$IconButtonSurface$1.INSTANCE
            r32 = r3
            goto L_0x0170
        L_0x016e:
            r32 = r24
        L_0x0170:
            androidx.compose.foundation.interaction.MutableInteractionSource r27 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 0
            r33 = 28
            r34 = 0
            androidx.compose.ui.Modifier r3 = androidx.compose.foundation.ClickableKt.m194clickableO2vRcR0$default(r26, r27, r28, r29, r30, r31, r32, r33, r34)
            com.designsystem.ds_icon_button.DSIconButtonComposablesKt$IconButtonSurface$2 r4 = com.designsystem.ds_icon_button.DSIconButtonComposablesKt$IconButtonSurface$2.INSTANCE
            r8 = 1
            androidx.compose.ui.Modifier r16 = androidx.compose.ui.semantics.SemanticsModifierKt.semantics$default(r3, r5, r4, r8, r2)
            r17 = 0
            com.designsystem.ds_theme.DSTheme r2 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSColors r2 = r2.getColors(r0, r5)
            long r18 = r2.m8817getDsTransparentFill0d7_KjU()
            r20 = 0
            r22 = 0
            r23 = 0
            com.designsystem.ds_icon_button.DSIconButtonComposablesKt$IconButtonSurface$3 r5 = new com.designsystem.ds_icon_button.DSIconButtonComposablesKt$IconButtonSurface$3
            r2 = r5
            r3 = r6
            r7 = r5
            r5 = r39
            r6 = r36
            r1 = r7
            r7 = r9
            r10 = r8
            r8 = r12
            r2.<init>(r3, r5, r6, r7, r8)
            r2 = -819892485(0xffffffffcf216efb, float:-2.70840499E9)
            androidx.compose.runtime.internal.ComposableLambda r1 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r2, r10, r1)
            r2 = 1572864(0x180000, float:2.204052E-39)
            r3 = 58
            r12 = r16
            r13 = r17
            r8 = r15
            r14 = r18
            r16 = r20
            r18 = r22
            r19 = r23
            r20 = r1
            r21 = r0
            r22 = r2
            r23 = r3
            androidx.compose.material.SurfaceKt.m1384SurfaceFjzlyU(r12, r13, r14, r16, r18, r19, r20, r21, r22, r23)
            r6 = r8
            r3 = r24
            r4 = r25
        L_0x01d5:
            androidx.compose.runtime.ScopeUpdateScope r9 = r0.endRestartGroup()
            if (r9 != 0) goto L_0x01dc
            goto L_0x01ef
        L_0x01dc:
            com.designsystem.ds_icon_button.DSIconButtonComposablesKt$IconButtonSurface$4 r10 = new com.designsystem.ds_icon_button.DSIconButtonComposablesKt$IconButtonSurface$4
            r0 = r10
            r1 = r35
            r2 = r36
            r5 = r39
            r7 = r42
            r8 = r43
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r9.updateScope(r10)
        L_0x01ef:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_icon_button.DSIconButtonComposablesKt.m8354IconButtonSurface_trzpw(androidx.compose.ui.Modifier, int, kotlin.jvm.functions.Function0, androidx.compose.ui.graphics.Color, com.designsystem.ds_icon_button.DSIconButtonSize, java.lang.Boolean, androidx.compose.runtime.Composer, int, int):void");
    }
}
