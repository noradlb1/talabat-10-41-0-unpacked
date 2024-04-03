package com.designsystem.ds_small_button;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.text.TextStyle;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ao\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000b2\b\b\u0002\u0010\u000f\u001a\u00020\u000b2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011H\u0001¢\u0006\u0002\u0010\u0012\u001a\u0015\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\u0015\u001a\u001d\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"DSBaseSmallButton", "", "theme", "Lcom/designsystem/ds_button_v2/DSButtonTheme;", "title", "", "modifier", "Landroidx/compose/ui/Modifier;", "leadingIcon", "", "isEnabled", "", "isLoading", "isMM2", "hasHapticFeedback", "hasUnderline", "onTap", "Lkotlin/Function0;", "(Lcom/designsystem/ds_button_v2/DSButtonTheme;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/Integer;ZZZZZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "buttonMM1Style", "Lcom/designsystem/ds_small_button/DSSmallButtonStyle;", "(ZLandroidx/compose/runtime/Composer;I)Lcom/designsystem/ds_small_button/DSSmallButtonStyle;", "buttonMM2Style", "(ZZLandroidx/compose/runtime/Composer;I)Lcom/designsystem/ds_small_button/DSSmallButtonStyle;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSBaseSmallButtonKt {
    /* JADX WARNING: Removed duplicated region for block: B:101:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x014f  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x015d  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:134:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x008f  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00aa  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ae  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00c8  */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x00cc  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0106  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x010d  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0126  */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DSBaseSmallButton(@org.jetbrains.annotations.NotNull com.designsystem.ds_button_v2.DSButtonTheme r22, @org.jetbrains.annotations.NotNull java.lang.String r23, @org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r24, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r25, boolean r26, boolean r27, boolean r28, boolean r29, boolean r30, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r31, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r32, int r33, int r34) {
        /*
            r12 = r22
            r13 = r23
            r14 = r31
            r15 = r33
            r11 = r34
            java.lang.String r0 = "theme"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "onTap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -439304110(0xffffffffe5d0c052, float:-1.2322499E23)
            r1 = r32
            androidx.compose.runtime.Composer r10 = r1.startRestartGroup(r0)
            r0 = r11 & 1
            if (r0 == 0) goto L_0x0029
            r0 = r15 | 6
            goto L_0x0039
        L_0x0029:
            r0 = r15 & 14
            if (r0 != 0) goto L_0x0038
            boolean r0 = r10.changed((java.lang.Object) r12)
            if (r0 == 0) goto L_0x0035
            r0 = 4
            goto L_0x0036
        L_0x0035:
            r0 = 2
        L_0x0036:
            r0 = r0 | r15
            goto L_0x0039
        L_0x0038:
            r0 = r15
        L_0x0039:
            r1 = r11 & 2
            if (r1 == 0) goto L_0x0040
            r0 = r0 | 48
            goto L_0x0050
        L_0x0040:
            r1 = r15 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x0050
            boolean r1 = r10.changed((java.lang.Object) r13)
            if (r1 == 0) goto L_0x004d
            r1 = 32
            goto L_0x004f
        L_0x004d:
            r1 = 16
        L_0x004f:
            r0 = r0 | r1
        L_0x0050:
            r1 = r11 & 4
            if (r1 == 0) goto L_0x0057
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x006a
        L_0x0057:
            r2 = r15 & 896(0x380, float:1.256E-42)
            if (r2 != 0) goto L_0x006a
            r2 = r24
            boolean r3 = r10.changed((java.lang.Object) r2)
            if (r3 == 0) goto L_0x0066
            r3 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0066:
            r3 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r0 = r0 | r3
            goto L_0x006c
        L_0x006a:
            r2 = r24
        L_0x006c:
            r3 = r11 & 8
            if (r3 == 0) goto L_0x0073
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0086
        L_0x0073:
            r4 = r15 & 7168(0x1c00, float:1.0045E-41)
            if (r4 != 0) goto L_0x0086
            r4 = r25
            boolean r5 = r10.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x0082
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x0084
        L_0x0082:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x0084:
            r0 = r0 | r5
            goto L_0x0088
        L_0x0086:
            r4 = r25
        L_0x0088:
            r5 = r11 & 16
            if (r5 == 0) goto L_0x008f
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x00a4
        L_0x008f:
            r6 = 57344(0xe000, float:8.0356E-41)
            r6 = r6 & r15
            if (r6 != 0) goto L_0x00a4
            r6 = r26
            boolean r7 = r10.changed((boolean) r6)
            if (r7 == 0) goto L_0x00a0
            r7 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a2
        L_0x00a0:
            r7 = 8192(0x2000, float:1.14794E-41)
        L_0x00a2:
            r0 = r0 | r7
            goto L_0x00a6
        L_0x00a4:
            r6 = r26
        L_0x00a6:
            r7 = r11 & 32
            if (r7 == 0) goto L_0x00ae
            r8 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r8
            goto L_0x00c2
        L_0x00ae:
            r8 = 458752(0x70000, float:6.42848E-40)
            r8 = r8 & r15
            if (r8 != 0) goto L_0x00c2
            r8 = r27
            boolean r9 = r10.changed((boolean) r8)
            if (r9 == 0) goto L_0x00be
            r9 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c0
        L_0x00be:
            r9 = 65536(0x10000, float:9.18355E-41)
        L_0x00c0:
            r0 = r0 | r9
            goto L_0x00c4
        L_0x00c2:
            r8 = r27
        L_0x00c4:
            r9 = r11 & 64
            if (r9 == 0) goto L_0x00cc
            r9 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r9
            goto L_0x00e1
        L_0x00cc:
            r9 = 3670016(0x380000, float:5.142788E-39)
            r9 = r9 & r15
            if (r9 != 0) goto L_0x00e1
            r9 = r28
            boolean r16 = r10.changed((boolean) r9)
            if (r16 == 0) goto L_0x00dc
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00de
        L_0x00dc:
            r16 = 524288(0x80000, float:7.34684E-40)
        L_0x00de:
            r0 = r0 | r16
            goto L_0x00e3
        L_0x00e1:
            r9 = r28
        L_0x00e3:
            r2 = r11 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x00eb
            r2 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r2
            goto L_0x0100
        L_0x00eb:
            r2 = 29360128(0x1c00000, float:7.052966E-38)
            r2 = r2 & r15
            if (r2 != 0) goto L_0x0100
            r2 = r29
            boolean r16 = r10.changed((boolean) r2)
            if (r16 == 0) goto L_0x00fb
            r16 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fd
        L_0x00fb:
            r16 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fd:
            r0 = r0 | r16
            goto L_0x0102
        L_0x0100:
            r2 = r29
        L_0x0102:
            r2 = r11 & 256(0x100, float:3.59E-43)
            if (r2 == 0) goto L_0x010d
            r16 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r16
            r4 = r30
            goto L_0x0122
        L_0x010d:
            r16 = 234881024(0xe000000, float:1.5777218E-30)
            r16 = r15 & r16
            r4 = r30
            if (r16 != 0) goto L_0x0122
            boolean r16 = r10.changed((boolean) r4)
            if (r16 == 0) goto L_0x011e
            r16 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0120
        L_0x011e:
            r16 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0120:
            r0 = r0 | r16
        L_0x0122:
            r4 = r11 & 512(0x200, float:7.175E-43)
            if (r4 == 0) goto L_0x012a
            r4 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0128:
            r0 = r0 | r4
            goto L_0x013b
        L_0x012a:
            r4 = 1879048192(0x70000000, float:1.58456325E29)
            r4 = r4 & r15
            if (r4 != 0) goto L_0x013b
            boolean r4 = r10.changed((java.lang.Object) r14)
            if (r4 == 0) goto L_0x0138
            r4 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0128
        L_0x0138:
            r4 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0128
        L_0x013b:
            r16 = r0
            r0 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r0 = r16 & r0
            r4 = 306783378(0x12492492, float:6.3469493E-28)
            r0 = r0 ^ r4
            if (r0 != 0) goto L_0x015d
            boolean r0 = r10.getSkipping()
            if (r0 != 0) goto L_0x014f
            goto L_0x015d
        L_0x014f:
            r10.skipToGroupEnd()
            r3 = r24
            r4 = r25
            r9 = r30
            r5 = r6
            r6 = r8
            r14 = r10
            goto L_0x01ba
        L_0x015d:
            if (r1 == 0) goto L_0x0164
            androidx.compose.ui.Modifier$Companion r0 = androidx.compose.ui.Modifier.Companion
            r17 = r0
            goto L_0x0166
        L_0x0164:
            r17 = r24
        L_0x0166:
            if (r3 == 0) goto L_0x016c
            r0 = 0
            r18 = r0
            goto L_0x016e
        L_0x016c:
            r18 = r25
        L_0x016e:
            r4 = 1
            if (r5 == 0) goto L_0x0174
            r19 = r4
            goto L_0x0176
        L_0x0174:
            r19 = r6
        L_0x0176:
            r0 = 0
            if (r7 == 0) goto L_0x017c
            r20 = r0
            goto L_0x017e
        L_0x017c:
            r20 = r8
        L_0x017e:
            if (r2 == 0) goto L_0x0183
            r21 = r0
            goto L_0x0185
        L_0x0183:
            r21 = r30
        L_0x0185:
            com.designsystem.ds_small_button.DSBaseSmallButtonKt$DSBaseSmallButton$1 r8 = new com.designsystem.ds_small_button.DSBaseSmallButtonKt$DSBaseSmallButton$1
            r0 = r8
            r1 = r22
            r2 = r19
            r3 = r20
            r7 = r4
            r4 = r28
            r5 = r16
            r6 = r23
            r12 = r7
            r7 = r17
            r13 = r8
            r8 = r18
            r9 = r29
            r14 = r10
            r10 = r21
            r11 = r31
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = -819895581(0xffffffffcf2162e3, float:-2.70761242E9)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r0, r12, r13)
            r1 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r0, r14, r1)
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r20
            r9 = r21
        L_0x01ba:
            androidx.compose.runtime.ScopeUpdateScope r13 = r14.endRestartGroup()
            if (r13 != 0) goto L_0x01c1
            goto L_0x01d8
        L_0x01c1:
            com.designsystem.ds_small_button.DSBaseSmallButtonKt$DSBaseSmallButton$2 r14 = new com.designsystem.ds_small_button.DSBaseSmallButtonKt$DSBaseSmallButton$2
            r0 = r14
            r1 = r22
            r2 = r23
            r7 = r28
            r8 = r29
            r10 = r31
            r11 = r33
            r12 = r34
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r13.updateScope(r14)
        L_0x01d8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_small_button.DSBaseSmallButtonKt.DSBaseSmallButton(com.designsystem.ds_button_v2.DSButtonTheme, java.lang.String, androidx.compose.ui.Modifier, java.lang.Integer, boolean, boolean, boolean, boolean, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    @Composable
    public static final DSSmallButtonStyle buttonMM1Style(boolean z11, Composer composer, int i11) {
        composer.startReplaceableGroup(-687732037);
        DSSmallButtonStyle dSSmallButtonStyle = new DSSmallButtonStyle(z11, DSTheme.INSTANCE.getTypography(composer, 0).getDsLink());
        composer.endReplaceableGroup();
        return dSSmallButtonStyle;
    }

    /* access modifiers changed from: private */
    @Composable
    public static final DSSmallButtonStyle buttonMM2Style(boolean z11, boolean z12, Composer composer, int i11) {
        TextStyle textStyle;
        composer.startReplaceableGroup(199771828);
        if (z12) {
            composer.startReplaceableGroup(199772008);
            textStyle = DSTheme.INSTANCE.getTypography(composer, 0).getDsLinkMediumCompact();
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(199772068);
            textStyle = DSTheme.INSTANCE.getTypography(composer, 0).getDsSubheadingMedium();
            composer.endReplaceableGroup();
        }
        DSSmallButtonStyle dSSmallButtonStyle = new DSSmallButtonStyle(z11, textStyle);
        composer.endReplaceableGroup();
        return dSSmallButtonStyle;
    }
}
