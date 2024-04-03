package com.designsystem.ds_icon_button;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aY\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u0010"}, d2 = {"DSIconButton", "", "modifier", "Landroidx/compose/ui/Modifier;", "icon", "", "onTap", "Lkotlin/Function0;", "iconColor", "Landroidx/compose/ui/graphics/Color;", "showRoundedBackground", "", "size", "Lcom/designsystem/ds_icon_button/DSIconButtonSize;", "DSIconButton-_trzp-w", "(Landroidx/compose/ui/Modifier;ILkotlin/jvm/functions/Function0;Landroidx/compose/ui/graphics/Color;ZLcom/designsystem/ds_icon_button/DSIconButtonSize;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSIconButtonKt {
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006e  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0111  */
    /* JADX WARNING: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* renamed from: DSIconButton-_trzp-w  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8355DSIconButton_trzpw(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r17, @androidx.annotation.DrawableRes int r18, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r19, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Color r20, boolean r21, @org.jetbrains.annotations.NotNull com.designsystem.ds_icon_button.DSIconButtonSize r22, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r23, int r24, int r25) {
        /*
            r8 = r22
            r9 = r24
            java.lang.String r0 = "size"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            r0 = 774504282(0x2e29ff5a, float:3.865295E-11)
            r1 = r23
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            r0 = r25 & 1
            if (r0 == 0) goto L_0x001c
            r1 = r9 | 6
            r2 = r1
            r1 = r17
            goto L_0x0030
        L_0x001c:
            r1 = r9 & 14
            if (r1 != 0) goto L_0x002d
            r1 = r17
            boolean r2 = r10.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x002a
            r2 = 4
            goto L_0x002b
        L_0x002a:
            r2 = 2
        L_0x002b:
            r2 = r2 | r9
            goto L_0x0030
        L_0x002d:
            r1 = r17
            r2 = r9
        L_0x0030:
            r3 = r25 & 2
            if (r3 == 0) goto L_0x0039
            r2 = r2 | 48
            r11 = r18
            goto L_0x004b
        L_0x0039:
            r3 = r9 & 112(0x70, float:1.57E-43)
            r11 = r18
            if (r3 != 0) goto L_0x004b
            boolean r3 = r10.changed((int) r11)
            if (r3 == 0) goto L_0x0048
            r3 = 32
            goto L_0x004a
        L_0x0048:
            r3 = 16
        L_0x004a:
            r2 = r2 | r3
        L_0x004b:
            r3 = r25 & 4
            if (r3 == 0) goto L_0x0052
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0065
        L_0x0052:
            r4 = r9 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x0065
            r4 = r19
            boolean r5 = r10.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0061
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0063
        L_0x0061:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0063:
            r2 = r2 | r5
            goto L_0x0067
        L_0x0065:
            r4 = r19
        L_0x0067:
            r5 = r25 & 8
            if (r5 == 0) goto L_0x006e
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x006e:
            r6 = r9 & 7168(0x1c00, float:1.0045E-41)
            if (r6 != 0) goto L_0x0081
            r6 = r20
            boolean r7 = r10.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x007d
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r2 = r2 | r7
            goto L_0x0083
        L_0x0081:
            r6 = r20
        L_0x0083:
            r7 = r25 & 16
            if (r7 == 0) goto L_0x008a
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009f
        L_0x008a:
            r12 = 57344(0xe000, float:8.0356E-41)
            r12 = r12 & r9
            if (r12 != 0) goto L_0x009f
            r12 = r21
            boolean r13 = r10.changed((boolean) r12)
            if (r13 == 0) goto L_0x009b
            r13 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009d
        L_0x009b:
            r13 = 8192(0x2000, float:1.14794E-41)
        L_0x009d:
            r2 = r2 | r13
            goto L_0x00a1
        L_0x009f:
            r12 = r21
        L_0x00a1:
            r13 = r25 & 32
            if (r13 == 0) goto L_0x00a9
            r13 = 196608(0x30000, float:2.75506E-40)
        L_0x00a7:
            r2 = r2 | r13
            goto L_0x00ba
        L_0x00a9:
            r13 = 458752(0x70000, float:6.42848E-40)
            r13 = r13 & r9
            if (r13 != 0) goto L_0x00ba
            boolean r13 = r10.changed((java.lang.Object) r8)
            if (r13 == 0) goto L_0x00b7
            r13 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00a7
        L_0x00b7:
            r13 = 65536(0x10000, float:9.18355E-41)
            goto L_0x00a7
        L_0x00ba:
            r13 = r2
            r2 = 374491(0x5b6db, float:5.24774E-40)
            r2 = r2 & r13
            r14 = 74898(0x12492, float:1.04954E-40)
            r2 = r2 ^ r14
            if (r2 != 0) goto L_0x00d3
            boolean r2 = r10.getSkipping()
            if (r2 != 0) goto L_0x00cc
            goto L_0x00d3
        L_0x00cc:
            r10.skipToGroupEnd()
            r3 = r4
            r4 = r6
            r5 = r12
            goto L_0x010a
        L_0x00d3:
            if (r0 == 0) goto L_0x00d9
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            r14 = r0
            goto L_0x00da
        L_0x00d9:
            r14 = r1
        L_0x00da:
            r0 = 0
            if (r3 == 0) goto L_0x00df
            r15 = r0
            goto L_0x00e0
        L_0x00df:
            r15 = r4
        L_0x00e0:
            if (r5 == 0) goto L_0x00e5
            r16 = r0
            goto L_0x00e7
        L_0x00e5:
            r16 = r6
        L_0x00e7:
            if (r7 == 0) goto L_0x00eb
            r0 = 0
            r12 = r0
        L_0x00eb:
            com.designsystem.ds_icon_button.DSIconButtonKt$DSIconButton$1 r7 = new com.designsystem.ds_icon_button.DSIconButtonKt$DSIconButton$1
            r0 = r7
            r1 = r14
            r2 = r18
            r3 = r15
            r4 = r16
            r5 = r22
            r6 = r12
            r8 = r7
            r7 = r13
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = -819892701(0xffffffffcf216e23, float:-2.7083497E9)
            r1 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r10, r0, r1, r8)
            r1 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r0, r10, r1)
            r5 = r12
            r1 = r14
        L_0x010a:
            androidx.compose.runtime.ScopeUpdateScope r10 = r10.endRestartGroup()
            if (r10 != 0) goto L_0x0111
            goto L_0x0122
        L_0x0111:
            com.designsystem.ds_icon_button.DSIconButtonKt$DSIconButton$2 r12 = new com.designsystem.ds_icon_button.DSIconButtonKt$DSIconButton$2
            r0 = r12
            r2 = r18
            r6 = r22
            r7 = r24
            r8 = r25
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r10.updateScope(r12)
        L_0x0122:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_icon_button.DSIconButtonKt.m8355DSIconButton_trzpw(androidx.compose.ui.Modifier, int, kotlin.jvm.functions.Function0, androidx.compose.ui.graphics.Color, boolean, com.designsystem.ds_icon_button.DSIconButtonSize, androidx.compose.runtime.Composer, int, int):void");
    }
}
