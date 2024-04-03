package com.designsystem.ds_button_v2;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import com.designsystem.ds_spinner.DSSpinnerSize;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001ak\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0001\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011H\u0001¢\u0006\u0002\u0010\u0012\u001a\r\u0010\u0013\u001a\u00020\u0014H\u0003¢\u0006\u0002\u0010\u0015\u001a\u0015\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u000f\u001a\u00020\fH\u0003¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"DSBaseButton", "", "theme", "Lcom/designsystem/ds_button_v2/DSButtonTheme;", "title", "", "modifier", "Landroidx/compose/ui/Modifier;", "caption", "leadingIcon", "", "isEnabled", "", "isLoading", "isMM2", "hasHapticFeedback", "onTap", "Lkotlin/Function0;", "(Lcom/designsystem/ds_button_v2/DSButtonTheme;Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Integer;ZZZZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "buttonMM1Style", "Lcom/designsystem/ds_button_v2/DSButtonStyle;", "(Landroidx/compose/runtime/Composer;I)Lcom/designsystem/ds_button_v2/DSButtonStyle;", "buttonMM2Style", "(ZLandroidx/compose/runtime/Composer;I)Lcom/designsystem/ds_button_v2/DSButtonStyle;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSBaseButtonKt {
    /* JADX WARNING: Removed duplicated region for block: B:106:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x014e  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0189  */
    /* JADX WARNING: Removed duplicated region for block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x011f  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0123  */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DSBaseButton(@org.jetbrains.annotations.NotNull com.designsystem.ds_button_v2.DSButtonTheme r18, @org.jetbrains.annotations.NotNull java.lang.String r19, @org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r20, @org.jetbrains.annotations.Nullable java.lang.String r21, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r22, boolean r23, boolean r24, boolean r25, boolean r26, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function0<kotlin.Unit> r27, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r28, int r29, int r30) {
        /*
            r12 = r18
            r13 = r19
            r14 = r20
            r15 = r27
            r11 = r29
            r10 = r30
            java.lang.String r0 = "theme"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            java.lang.String r0 = "onTap"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            r0 = -530850394(0xffffffffe05bdda6, float:-6.3372006E19)
            r1 = r28
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            r0 = r10 & 1
            if (r0 == 0) goto L_0x0030
            r0 = r11 | 6
            goto L_0x0040
        L_0x0030:
            r0 = r11 & 14
            if (r0 != 0) goto L_0x003f
            boolean r0 = r9.changed((java.lang.Object) r12)
            if (r0 == 0) goto L_0x003c
            r0 = 4
            goto L_0x003d
        L_0x003c:
            r0 = 2
        L_0x003d:
            r0 = r0 | r11
            goto L_0x0040
        L_0x003f:
            r0 = r11
        L_0x0040:
            r1 = r10 & 2
            if (r1 == 0) goto L_0x0047
            r0 = r0 | 48
            goto L_0x0057
        L_0x0047:
            r1 = r11 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x0057
            boolean r1 = r9.changed((java.lang.Object) r13)
            if (r1 == 0) goto L_0x0054
            r1 = 32
            goto L_0x0056
        L_0x0054:
            r1 = 16
        L_0x0056:
            r0 = r0 | r1
        L_0x0057:
            r1 = r10 & 4
            if (r1 == 0) goto L_0x005e
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x006e
        L_0x005e:
            r1 = r11 & 896(0x380, float:1.256E-42)
            if (r1 != 0) goto L_0x006e
            boolean r1 = r9.changed((java.lang.Object) r14)
            if (r1 == 0) goto L_0x006b
            r1 = 256(0x100, float:3.59E-43)
            goto L_0x006d
        L_0x006b:
            r1 = 128(0x80, float:1.794E-43)
        L_0x006d:
            r0 = r0 | r1
        L_0x006e:
            r1 = r10 & 8
            if (r1 == 0) goto L_0x0077
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r8 = r21
            goto L_0x0089
        L_0x0077:
            r1 = r11 & 7168(0x1c00, float:1.0045E-41)
            r8 = r21
            if (r1 != 0) goto L_0x0089
            boolean r1 = r9.changed((java.lang.Object) r8)
            if (r1 == 0) goto L_0x0086
            r1 = 2048(0x800, float:2.87E-42)
            goto L_0x0088
        L_0x0086:
            r1 = 1024(0x400, float:1.435E-42)
        L_0x0088:
            r0 = r0 | r1
        L_0x0089:
            r1 = r10 & 16
            if (r1 == 0) goto L_0x0092
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r7 = r22
            goto L_0x00a6
        L_0x0092:
            r1 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r11
            r7 = r22
            if (r1 != 0) goto L_0x00a6
            boolean r1 = r9.changed((java.lang.Object) r7)
            if (r1 == 0) goto L_0x00a3
            r1 = 16384(0x4000, float:2.2959E-41)
            goto L_0x00a5
        L_0x00a3:
            r1 = 8192(0x2000, float:1.14794E-41)
        L_0x00a5:
            r0 = r0 | r1
        L_0x00a6:
            r1 = r10 & 32
            if (r1 == 0) goto L_0x00b0
            r1 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r1
            r6 = r23
            goto L_0x00c3
        L_0x00b0:
            r1 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r11
            r6 = r23
            if (r1 != 0) goto L_0x00c3
            boolean r1 = r9.changed((boolean) r6)
            if (r1 == 0) goto L_0x00c0
            r1 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00c2
        L_0x00c0:
            r1 = 65536(0x10000, float:9.18355E-41)
        L_0x00c2:
            r0 = r0 | r1
        L_0x00c3:
            r1 = r10 & 64
            if (r1 == 0) goto L_0x00cd
            r1 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r1
            r5 = r24
            goto L_0x00e0
        L_0x00cd:
            r1 = 3670016(0x380000, float:5.142788E-39)
            r1 = r1 & r11
            r5 = r24
            if (r1 != 0) goto L_0x00e0
            boolean r1 = r9.changed((boolean) r5)
            if (r1 == 0) goto L_0x00dd
            r1 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00df
        L_0x00dd:
            r1 = 524288(0x80000, float:7.34684E-40)
        L_0x00df:
            r0 = r0 | r1
        L_0x00e0:
            r1 = r10 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x00ea
            r1 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r1
            r4 = r25
            goto L_0x00fd
        L_0x00ea:
            r1 = 29360128(0x1c00000, float:7.052966E-38)
            r1 = r1 & r11
            r4 = r25
            if (r1 != 0) goto L_0x00fd
            boolean r1 = r9.changed((boolean) r4)
            if (r1 == 0) goto L_0x00fa
            r1 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fc
        L_0x00fa:
            r1 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fc:
            r0 = r0 | r1
        L_0x00fd:
            r1 = r10 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0105
            r2 = 100663296(0x6000000, float:2.4074124E-35)
            r0 = r0 | r2
            goto L_0x0119
        L_0x0105:
            r2 = 234881024(0xe000000, float:1.5777218E-30)
            r2 = r2 & r11
            if (r2 != 0) goto L_0x0119
            r2 = r26
            boolean r3 = r9.changed((boolean) r2)
            if (r3 == 0) goto L_0x0115
            r3 = 67108864(0x4000000, float:1.5046328E-36)
            goto L_0x0117
        L_0x0115:
            r3 = 33554432(0x2000000, float:9.403955E-38)
        L_0x0117:
            r0 = r0 | r3
            goto L_0x011b
        L_0x0119:
            r2 = r26
        L_0x011b:
            r3 = r10 & 512(0x200, float:7.175E-43)
            if (r3 == 0) goto L_0x0123
            r3 = 805306368(0x30000000, float:4.656613E-10)
        L_0x0121:
            r0 = r0 | r3
            goto L_0x0134
        L_0x0123:
            r3 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r11
            if (r3 != 0) goto L_0x0134
            boolean r3 = r9.changed((java.lang.Object) r15)
            if (r3 == 0) goto L_0x0131
            r3 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x0121
        L_0x0131:
            r3 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x0121
        L_0x0134:
            r16 = r0
            r0 = 1533916891(0x5b6db6db, float:6.6910621E16)
            r0 = r16 & r0
            r3 = 306783378(0x12492492, float:6.3469493E-28)
            r0 = r0 ^ r3
            if (r0 != 0) goto L_0x014e
            boolean r0 = r9.getSkipping()
            if (r0 != 0) goto L_0x0148
            goto L_0x014e
        L_0x0148:
            r9.skipToGroupEnd()
            r14 = r9
            r9 = r2
            goto L_0x0182
        L_0x014e:
            r3 = 1
            if (r1 == 0) goto L_0x0154
            r17 = r3
            goto L_0x0156
        L_0x0154:
            r17 = r2
        L_0x0156:
            com.designsystem.ds_button_v2.DSBaseButtonKt$DSBaseButton$1 r2 = new com.designsystem.ds_button_v2.DSBaseButtonKt$DSBaseButton$1
            r0 = r2
            r1 = r18
            r12 = r2
            r2 = r23
            r13 = r3
            r3 = r24
            r4 = r16
            r5 = r25
            r6 = r17
            r7 = r19
            r8 = r20
            r14 = r9
            r9 = r21
            r10 = r22
            r11 = r27
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            r0 = -819895591(0xffffffffcf2162d9, float:-2.70760986E9)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r14, r0, r13, r12)
            r1 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r0, r14, r1)
            r9 = r17
        L_0x0182:
            androidx.compose.runtime.ScopeUpdateScope r13 = r14.endRestartGroup()
            if (r13 != 0) goto L_0x0189
            goto L_0x01a8
        L_0x0189:
            com.designsystem.ds_button_v2.DSBaseButtonKt$DSBaseButton$2 r14 = new com.designsystem.ds_button_v2.DSBaseButtonKt$DSBaseButton$2
            r0 = r14
            r1 = r18
            r2 = r19
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r25
            r10 = r27
            r11 = r29
            r12 = r30
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12)
            r13.updateScope(r14)
        L_0x01a8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_button_v2.DSBaseButtonKt.DSBaseButton(com.designsystem.ds_button_v2.DSButtonTheme, java.lang.String, androidx.compose.ui.Modifier, java.lang.String, java.lang.Integer, boolean, boolean, boolean, boolean, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    @Composable
    public static final DSButtonStyle buttonMM1Style(Composer composer, int i11) {
        composer.startReplaceableGroup(1044404809);
        DSSpinnerSize dSSpinnerSize = DSSpinnerSize.Small;
        DSTheme dSTheme = DSTheme.INSTANCE;
        DSButtonStyle dSButtonStyle = new DSButtonStyle(true, dSSpinnerSize, dSTheme.getTypography(composer, 0).getDsButton(), dSTheme.getTypography(composer, 0).getDsCaption(), dSTheme.getDimens(composer, 0).m8846getDsXxsD9Ej5fM(), (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return dSButtonStyle;
    }

    /* access modifiers changed from: private */
    @Composable
    public static final DSButtonStyle buttonMM2Style(boolean z11, Composer composer, int i11) {
        composer.startReplaceableGroup(1931908754);
        DSSpinnerSize dSSpinnerSize = DSSpinnerSize.VerySmall;
        DSTheme dSTheme = DSTheme.INSTANCE;
        DSButtonStyle dSButtonStyle = new DSButtonStyle(z11, dSSpinnerSize, dSTheme.getTypography(composer, 0).getDsSubheadingMedium(), dSTheme.getTypography(composer, 0).getDsBodyXSmall(), dSTheme.getDimens(composer, 0).m8848getDsXxxsD9Ej5fM(), (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return dSButtonStyle;
    }
}
