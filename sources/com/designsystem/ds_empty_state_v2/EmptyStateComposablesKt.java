package com.designsystem.ds_empty_state_v2;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import com.designsystem.ds_small_button.DSSecondarySmallButtonKt;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u001aU\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00012\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0001¢\u0006\u0002\u0010\u000f\u001a'\u0010\u0010\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u00012\u000e\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\fH\u0001¢\u0006\u0002\u0010\u0011\u001a\u0017\u0010\u0012\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001H\u0001¢\u0006\u0002\u0010\u0013\u001a\u0017\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\tH\u0001¢\u0006\u0002\u0010\u0016\u001a\u0015\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0013\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"EmptyStateIconTestTag", "", "EmptyState", "", "title", "modifier", "Landroidx/compose/ui/Modifier;", "details", "emptyStateIcon", "Lcom/designsystem/ds_empty_state_v2/EmptyStateIcon;", "buttonText", "onButtonTap", "Lkotlin/Function0;", "fillMaxSize", "", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Lcom/designsystem/ds_empty_state_v2/EmptyStateIcon;Ljava/lang/String;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;II)V", "EmptyStateButton", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "EmptyStateDetails", "(Ljava/lang/String;Landroidx/compose/runtime/Composer;I)V", "EmptyStateIcon", "emptyStateImage", "(Lcom/designsystem/ds_empty_state_v2/EmptyStateIcon;Landroidx/compose/runtime/Composer;I)V", "EmptyStateTitle", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class EmptyStateComposablesKt {
    @NotNull
    public static final String EmptyStateIconTestTag = "EmptyStateIconTestTag";

    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e7  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00ec  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:90:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void EmptyState(@org.jetbrains.annotations.NotNull java.lang.String r17, @org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r18, @org.jetbrains.annotations.Nullable java.lang.String r19, @org.jetbrains.annotations.Nullable com.designsystem.ds_empty_state_v2.EmptyStateIcon r20, @org.jetbrains.annotations.Nullable java.lang.String r21, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r22, boolean r23, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r24, int r25, int r26) {
        /*
            r8 = r17
            r9 = r18
            r10 = r25
            java.lang.String r0 = "title"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = -1447557766(0xffffffffa9b8057a, float:-8.1721915E-14)
            r1 = r24
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            r0 = r26 & 1
            if (r0 == 0) goto L_0x0020
            r0 = r10 | 6
            goto L_0x0030
        L_0x0020:
            r0 = r10 & 14
            if (r0 != 0) goto L_0x002f
            boolean r0 = r11.changed((java.lang.Object) r8)
            if (r0 == 0) goto L_0x002c
            r0 = 4
            goto L_0x002d
        L_0x002c:
            r0 = 2
        L_0x002d:
            r0 = r0 | r10
            goto L_0x0030
        L_0x002f:
            r0 = r10
        L_0x0030:
            r1 = r26 & 2
            if (r1 == 0) goto L_0x0037
            r0 = r0 | 48
            goto L_0x0047
        L_0x0037:
            r1 = r10 & 112(0x70, float:1.57E-43)
            if (r1 != 0) goto L_0x0047
            boolean r1 = r11.changed((java.lang.Object) r9)
            if (r1 == 0) goto L_0x0044
            r1 = 32
            goto L_0x0046
        L_0x0044:
            r1 = 16
        L_0x0046:
            r0 = r0 | r1
        L_0x0047:
            r1 = r26 & 4
            if (r1 == 0) goto L_0x0050
            r0 = r0 | 384(0x180, float:5.38E-43)
            r12 = r19
            goto L_0x0062
        L_0x0050:
            r1 = r10 & 896(0x380, float:1.256E-42)
            r12 = r19
            if (r1 != 0) goto L_0x0062
            boolean r1 = r11.changed((java.lang.Object) r12)
            if (r1 == 0) goto L_0x005f
            r1 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r1 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r0 = r0 | r1
        L_0x0062:
            r1 = r26 & 8
            if (r1 == 0) goto L_0x006b
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            r13 = r20
            goto L_0x007d
        L_0x006b:
            r1 = r10 & 7168(0x1c00, float:1.0045E-41)
            r13 = r20
            if (r1 != 0) goto L_0x007d
            boolean r1 = r11.changed((java.lang.Object) r13)
            if (r1 == 0) goto L_0x007a
            r1 = 2048(0x800, float:2.87E-42)
            goto L_0x007c
        L_0x007a:
            r1 = 1024(0x400, float:1.435E-42)
        L_0x007c:
            r0 = r0 | r1
        L_0x007d:
            r1 = r26 & 16
            if (r1 == 0) goto L_0x0086
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            r14 = r21
            goto L_0x009a
        L_0x0086:
            r1 = 57344(0xe000, float:8.0356E-41)
            r1 = r1 & r10
            r14 = r21
            if (r1 != 0) goto L_0x009a
            boolean r1 = r11.changed((java.lang.Object) r14)
            if (r1 == 0) goto L_0x0097
            r1 = 16384(0x4000, float:2.2959E-41)
            goto L_0x0099
        L_0x0097:
            r1 = 8192(0x2000, float:1.14794E-41)
        L_0x0099:
            r0 = r0 | r1
        L_0x009a:
            r1 = r26 & 32
            if (r1 == 0) goto L_0x00a4
            r1 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r1
            r15 = r22
            goto L_0x00b7
        L_0x00a4:
            r1 = 458752(0x70000, float:6.42848E-40)
            r1 = r1 & r10
            r15 = r22
            if (r1 != 0) goto L_0x00b7
            boolean r1 = r11.changed((java.lang.Object) r15)
            if (r1 == 0) goto L_0x00b4
            r1 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b6
        L_0x00b4:
            r1 = 65536(0x10000, float:9.18355E-41)
        L_0x00b6:
            r0 = r0 | r1
        L_0x00b7:
            r1 = r26 & 64
            if (r1 == 0) goto L_0x00bf
            r2 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r2
            goto L_0x00d3
        L_0x00bf:
            r2 = 3670016(0x380000, float:5.142788E-39)
            r2 = r2 & r10
            if (r2 != 0) goto L_0x00d3
            r2 = r23
            boolean r3 = r11.changed((boolean) r2)
            if (r3 == 0) goto L_0x00cf
            r3 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00d1
        L_0x00cf:
            r3 = 524288(0x80000, float:7.34684E-40)
        L_0x00d1:
            r0 = r0 | r3
            goto L_0x00d5
        L_0x00d3:
            r2 = r23
        L_0x00d5:
            r3 = r0
            r0 = 2995931(0x2db6db, float:4.198194E-39)
            r0 = r0 & r3
            r4 = 599186(0x92492, float:8.39638E-40)
            r0 = r0 ^ r4
            if (r0 != 0) goto L_0x00ec
            boolean r0 = r11.getSkipping()
            if (r0 != 0) goto L_0x00e7
            goto L_0x00ec
        L_0x00e7:
            r11.skipToGroupEnd()
            r7 = r2
            goto L_0x0123
        L_0x00ec:
            r7 = 1
            if (r1 == 0) goto L_0x00f2
            r16 = r7
            goto L_0x00f4
        L_0x00f2:
            r16 = r2
        L_0x00f4:
            r0 = 0
            if (r16 == 0) goto L_0x00fd
            r1 = 0
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.fillMaxSize$default(r9, r1, r7, r0)
            goto L_0x0103
        L_0x00fd:
            r1 = 0
            r2 = 3
            androidx.compose.ui.Modifier r0 = androidx.compose.foundation.layout.SizeKt.wrapContentSize$default(r9, r0, r1, r2, r0)
        L_0x0103:
            r1 = r0
            com.designsystem.ds_empty_state_v2.EmptyStateComposablesKt$EmptyState$1 r6 = new com.designsystem.ds_empty_state_v2.EmptyStateComposablesKt$EmptyState$1
            r0 = r6
            r2 = r20
            r4 = r17
            r5 = r19
            r8 = r6
            r6 = r21
            r9 = r7
            r7 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r0 = -819895305(0xffffffffcf2163f7, float:-2.70768307E9)
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r0, r9, r8)
            r1 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r0, r11, r1)
            r7 = r16
        L_0x0123:
            androidx.compose.runtime.ScopeUpdateScope r11 = r11.endRestartGroup()
            if (r11 != 0) goto L_0x012a
            goto L_0x0144
        L_0x012a:
            com.designsystem.ds_empty_state_v2.EmptyStateComposablesKt$EmptyState$2 r9 = new com.designsystem.ds_empty_state_v2.EmptyStateComposablesKt$EmptyState$2
            r0 = r9
            r1 = r17
            r2 = r18
            r3 = r19
            r4 = r20
            r5 = r21
            r6 = r22
            r8 = r25
            r10 = r9
            r9 = r26
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9)
            r11.updateScope(r10)
        L_0x0144:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_empty_state_v2.EmptyStateComposablesKt.EmptyState(java.lang.String, androidx.compose.ui.Modifier, java.lang.String, com.designsystem.ds_empty_state_v2.EmptyStateIcon, java.lang.String, kotlin.jvm.functions.Function0, boolean, androidx.compose.runtime.Composer, int, int):void");
    }

    @Composable
    public static final void EmptyStateButton(@Nullable String str, @Nullable Function0<Unit> function0, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(1317197687);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) str)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i12 = i14 | i11;
        } else {
            i12 = i11;
        }
        if ((i11 & 112) == 0) {
            if (startRestartGroup.changed((Object) function0)) {
                i13 = 32;
            } else {
                i13 = 16;
            }
            i12 |= i13;
        }
        if (((i12 & 91) ^ 18) == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else if (str == null || function0 == null) {
            startRestartGroup.startReplaceableGroup(1317198145);
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(1317198013);
            SpacerKt.Spacer(SizeKt.m544height3ABfNKs(Modifier.Companion, DSTheme.INSTANCE.getDimens(startRestartGroup, 0).m8843getDsXlD9Ej5fM()), startRestartGroup, 0);
            DSSecondarySmallButtonKt.DSSecondarySmallButton(str, (Modifier) null, (Integer) null, false, false, false, function0, startRestartGroup, (i12 & 14) | ((i12 << 15) & 3670016), 62);
            startRestartGroup.endReplaceableGroup();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new EmptyStateComposablesKt$EmptyStateButton$2(str, function0, i11));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a5  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void EmptyStateDetails(@org.jetbrains.annotations.Nullable java.lang.String r25, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r26, int r27) {
        /*
            r0 = r25
            r15 = r27
            r1 = 36104332(0x226e88c, float:1.2262492E-37)
            r2 = r26
            androidx.compose.runtime.Composer r13 = r2.startRestartGroup(r1)
            r1 = r15 & 14
            r2 = 2
            if (r1 != 0) goto L_0x001f
            boolean r1 = r13.changed((java.lang.Object) r0)
            if (r1 == 0) goto L_0x001a
            r1 = 4
            goto L_0x001b
        L_0x001a:
            r1 = r2
        L_0x001b:
            r1 = r1 | r15
            r20 = r1
            goto L_0x0021
        L_0x001f:
            r20 = r15
        L_0x0021:
            r1 = r20 & 11
            r1 = r1 ^ r2
            if (r1 != 0) goto L_0x0031
            boolean r1 = r13.getSkipping()
            if (r1 != 0) goto L_0x002d
            goto L_0x0031
        L_0x002d:
            r13.skipToGroupEnd()
            goto L_0x003c
        L_0x0031:
            if (r0 != 0) goto L_0x003f
            r1 = 1119235998(0x42b62f9e, float:91.093)
            r13.startReplaceableGroup(r1)
            r13.endReplaceableGroup()
        L_0x003c:
            r24 = r13
            goto L_0x009e
        L_0x003f:
            r1 = 36104387(0x226e8c3, float:1.2262553E-37)
            r13.startReplaceableGroup(r1)
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            com.designsystem.ds_theme.DSTheme r2 = com.designsystem.ds_theme.DSTheme.INSTANCE
            r3 = 0
            com.designsystem.ds_theme.DSDimens r4 = r2.getDimens(r13, r3)
            float r4 = r4.m8846getDsXxsD9Ej5fM()
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.m544height3ABfNKs(r1, r4)
            androidx.compose.foundation.layout.SpacerKt.Spacer(r1, r13, r3)
            com.designsystem.ds_theme.DSTypography r1 = r2.getTypography(r13, r3)
            androidx.compose.ui.text.TextStyle r19 = r1.getDsBody1()
            com.designsystem.ds_theme.DSColors r1 = r2.getColors(r13, r3)
            long r2 = r1.m8760getDsNeutral1000d7_KjU()
            androidx.compose.ui.text.style.TextAlign$Companion r1 = androidx.compose.ui.text.style.TextAlign.Companion
            int r12 = r1.m5366getCentere0LSkKk()
            r1 = 0
            r4 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 0
            androidx.compose.ui.text.style.TextAlign r12 = androidx.compose.ui.text.style.TextAlign.m5359boximpl(r12)
            r16 = 0
            r24 = r13
            r13 = r16
            r16 = 0
            r15 = r16
            r17 = 0
            r18 = 0
            r21 = 1073741824(0x40000000, float:2.0)
            r20 = r20 & 14
            r21 = r20 | r21
            r22 = 64
            r23 = 32250(0x7dfa, float:4.5192E-41)
            r0 = r25
            r20 = r24
            androidx.compose.material.TextKt.m1461TextfLXpl1I(r0, r1, r2, r4, r6, r7, r8, r9, r11, r12, r13, r15, r16, r17, r18, r19, r20, r21, r22, r23)
            r24.endReplaceableGroup()
        L_0x009e:
            androidx.compose.runtime.ScopeUpdateScope r0 = r24.endRestartGroup()
            if (r0 != 0) goto L_0x00a5
            goto L_0x00b1
        L_0x00a5:
            com.designsystem.ds_empty_state_v2.EmptyStateComposablesKt$EmptyStateDetails$2 r1 = new com.designsystem.ds_empty_state_v2.EmptyStateComposablesKt$EmptyStateDetails$2
            r2 = r25
            r3 = r27
            r1.<init>(r2, r3)
            r0.updateScope(r1)
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_empty_state_v2.EmptyStateComposablesKt.EmptyStateDetails(java.lang.String, androidx.compose.runtime.Composer, int):void");
    }

    @Composable
    public static final void EmptyStateIcon(@Nullable EmptyStateIcon emptyStateIcon, @Nullable Composer composer, int i11) {
        int i12;
        int i13;
        Composer startRestartGroup = composer.startRestartGroup(601708651);
        if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) emptyStateIcon)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i11;
        } else {
            i12 = i11;
        }
        if (((i12 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            if (emptyStateIcon == null) {
                startRestartGroup.startReplaceableGroup(1473101354);
            } else {
                startRestartGroup.startReplaceableGroup(601708727);
                Painter painterResource = PainterResources_androidKt.painterResource(emptyStateIcon.getIcon(), startRestartGroup, 0);
                long r42 = emptyStateIcon.m8342getColor0d7_KjU();
                Modifier.Companion companion = Modifier.Companion;
                IconKt.m1278Iconww6aTOc(painterResource, "", SemanticsModifierKt.semantics$default(SizeKt.m563width3ABfNKs(SizeKt.m544height3ABfNKs(companion, emptyStateIcon.m8343getHeightD9Ej5fM()), emptyStateIcon.m8344getWidthD9Ej5fM()), false, EmptyStateComposablesKt$EmptyStateIcon$1$1.INSTANCE, 1, (Object) null), r42, startRestartGroup, 56, 0);
                SpacerKt.Spacer(SizeKt.m544height3ABfNKs(companion, emptyStateIcon.m8341getBottomMarginD9Ej5fM()), startRestartGroup, 0);
            }
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new EmptyStateComposablesKt$EmptyStateIcon$2(emptyStateIcon, i11));
        }
    }

    @Composable
    public static final void EmptyStateTitle(@NotNull String str, @Nullable Composer composer, int i11) {
        int i12;
        Composer composer2;
        int i13;
        String str2 = str;
        int i14 = i11;
        Intrinsics.checkNotNullParameter(str2, "title");
        Composer startRestartGroup = composer.startRestartGroup(1793652946);
        if ((i14 & 14) == 0) {
            if (startRestartGroup.changed((Object) str2)) {
                i13 = 4;
            } else {
                i13 = 2;
            }
            i12 = i13 | i14;
        } else {
            i12 = i14;
        }
        if (((i12 & 11) ^ 2) != 0 || !startRestartGroup.getSkipping()) {
            DSTheme dSTheme = DSTheme.INSTANCE;
            composer2 = startRestartGroup;
            TextKt.m1461TextfLXpl1I(str, (Modifier) null, dSTheme.getColors(startRestartGroup, 0).m8760getDsNeutral1000d7_KjU(), 0, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0, (TextDecoration) null, TextAlign.m5359boximpl(TextAlign.Companion.m5366getCentere0LSkKk()), 0, 0, false, 0, (Function1<? super TextLayoutResult, Unit>) null, dSTheme.getTypography(startRestartGroup, 0).getDsHeading1(), composer2, (i12 & 14) | 1073741824, 64, 32250);
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new EmptyStateComposablesKt$EmptyStateTitle$1(str, i11));
        }
    }
}
