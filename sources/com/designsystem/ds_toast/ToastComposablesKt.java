package com.designsystem.ds_toast;

import androidx.annotation.DrawableRes;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.IconKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\u001a!\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0001¢\u0006\u0002\u0010\u0006\u001a@\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\fH\u0003¢\u0006\u0002\u0010\r\u001a\u0019\u0010\u000e\u001a\u00020\u00012\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0001¢\u0006\u0002\u0010\u000f\u001a8\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0015\b\u0002\u0010\n\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\fH\u0003¢\u0006\u0002\u0010\u0011\u001a=\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0003H\u0001¢\u0006\u0002\u0010\u0015\u001a?\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\n\b\u0001\u0010\u0018\u001a\u0004\u0018\u00010\u0005H\u0001¢\u0006\u0002\u0010\u0019¨\u0006\u001a"}, d2 = {"BaseToast", "", "label", "", "leadingIcon", "", "(Ljava/lang/String;Ljava/lang/Integer;Landroidx/compose/runtime/Composer;II)V", "ToastLabel", "modifier", "Landroidx/compose/ui/Modifier;", "trailingComposable", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ToastLeadingIcon", "(Ljava/lang/Integer;Landroidx/compose/runtime/Composer;II)V", "ToastSurface", "(Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "ToastWithActionButton", "onActionTap", "onActionLabel", "(Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "ToastWithIconButton", "onTrailingIconTap", "trailingIcon", "(Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Ljava/lang/Integer;Landroidx/compose/runtime/Composer;II)V", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ToastComposablesKt {
    @Composable
    public static final void BaseToast(@NotNull String str, @Nullable @DrawableRes Integer num, @Nullable Composer composer, int i11, int i12) {
        int i13;
        int i14;
        int i15;
        Intrinsics.checkNotNullParameter(str, "label");
        Composer startRestartGroup = composer.startRestartGroup(-1768344024);
        if ((i12 & 1) != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) str)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i13 = i15 | i11;
        } else {
            i13 = i11;
        }
        int i16 = i12 & 2;
        if (i16 != 0) {
            i13 |= 48;
        } else if ((i11 & 112) == 0) {
            if (startRestartGroup.changed((Object) num)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i13 |= i14;
        }
        if (((i13 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            if (i16 != 0) {
                num = null;
            }
            ToastSurface(str, num, (Function2<? super Composer, ? super Integer, Unit>) null, startRestartGroup, (i13 & 14) | (i13 & 112), 4);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ToastComposablesKt$BaseToast$1(str, num, i11, i12));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0045  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0048  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ToastLabel(androidx.compose.ui.Modifier r32, java.lang.String r33, @androidx.annotation.DrawableRes java.lang.Integer r34, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, androidx.compose.runtime.Composer r36, int r37, int r38) {
        /*
            r1 = r32
            r5 = r37
            r0 = -1288937547(0xffffffffb32c5fb5, float:-4.0133916E-8)
            r2 = r36
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            r2 = r38 & 1
            r3 = 2
            if (r2 == 0) goto L_0x0015
            r2 = r5 | 6
            goto L_0x0025
        L_0x0015:
            r2 = r5 & 14
            if (r2 != 0) goto L_0x0024
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0021
            r2 = 4
            goto L_0x0022
        L_0x0021:
            r2 = r3
        L_0x0022:
            r2 = r2 | r5
            goto L_0x0025
        L_0x0024:
            r2 = r5
        L_0x0025:
            r4 = r38 & 2
            if (r4 == 0) goto L_0x002c
            r2 = r2 | 48
            goto L_0x003f
        L_0x002c:
            r4 = r5 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x003f
            r4 = r33
            boolean r6 = r0.changed((java.lang.Object) r4)
            if (r6 == 0) goto L_0x003b
            r6 = 32
            goto L_0x003d
        L_0x003b:
            r6 = 16
        L_0x003d:
            r2 = r2 | r6
            goto L_0x0041
        L_0x003f:
            r4 = r33
        L_0x0041:
            r6 = r38 & 4
            if (r6 == 0) goto L_0x0048
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x005b
        L_0x0048:
            r7 = r5 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x005b
            r7 = r34
            boolean r8 = r0.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0057
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0059
        L_0x0057:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0059:
            r2 = r2 | r8
            goto L_0x005d
        L_0x005b:
            r7 = r34
        L_0x005d:
            r8 = r38 & 8
            if (r8 == 0) goto L_0x0064
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            goto L_0x0077
        L_0x0064:
            r9 = r5 & 7168(0x1c00, float:1.0045E-41)
            if (r9 != 0) goto L_0x0077
            r9 = r35
            boolean r10 = r0.changed((java.lang.Object) r9)
            if (r10 == 0) goto L_0x0073
            r10 = 2048(0x800, float:2.87E-42)
            goto L_0x0075
        L_0x0073:
            r10 = 1024(0x400, float:1.435E-42)
        L_0x0075:
            r2 = r2 | r10
            goto L_0x0079
        L_0x0077:
            r9 = r35
        L_0x0079:
            r10 = r2 & 5851(0x16db, float:8.199E-42)
            r10 = r10 ^ 1170(0x492, float:1.64E-42)
            if (r10 != 0) goto L_0x008c
            boolean r10 = r0.getSkipping()
            if (r10 != 0) goto L_0x0086
            goto L_0x008c
        L_0x0086:
            r0.skipToGroupEnd()
            r3 = r7
            goto L_0x020a
        L_0x008c:
            r10 = 0
            if (r6 == 0) goto L_0x0092
            r30 = r10
            goto L_0x0094
        L_0x0092:
            r30 = r7
        L_0x0094:
            if (r8 == 0) goto L_0x0099
            r31 = r10
            goto L_0x009b
        L_0x0099:
            r31 = r9
        L_0x009b:
            androidx.compose.runtime.ProvidableCompositionLocal r6 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            java.lang.Object r6 = r0.consume(r6)
            android.content.Context r6 = (android.content.Context) r6
            android.content.res.Resources r6 = r6.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            float r6 = r6.fontScale
            r7 = 1065353216(0x3f800000, float:1.0)
            int r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            r23 = 3
            if (r6 > 0) goto L_0x00b8
            goto L_0x00ba
        L_0x00b8:
            r3 = r23
        L_0x00ba:
            r6 = 0
            if (r30 != 0) goto L_0x00d1
            r7 = -1288937175(0xffffffffb32c6129, float:-4.0135237E-8)
            r0.startReplaceableGroup(r7)
            com.designsystem.ds_theme.DSTheme r7 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSDimens r7 = r7.getDimens(r0, r6)
            float r7 = r7.m8842getDsSD9Ej5fM()
            r0.endReplaceableGroup()
            goto L_0x00e4
        L_0x00d1:
            r7 = -1288937135(0xffffffffb32c6151, float:-4.013538E-8)
            r0.startReplaceableGroup(r7)
            com.designsystem.ds_theme.DSTheme r7 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSDimens r7 = r7.getDimens(r0, r6)
            float r7 = r7.m8849getDsZeroD9Ej5fM()
            r0.endReplaceableGroup()
        L_0x00e4:
            if (r31 != 0) goto L_0x00fa
            r8 = -1288937038(0xffffffffb32c61b2, float:-4.0135724E-8)
            r0.startReplaceableGroup(r8)
            com.designsystem.ds_theme.DSTheme r8 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSDimens r8 = r8.getDimens(r0, r6)
            float r8 = r8.m8842getDsSD9Ej5fM()
            r0.endReplaceableGroup()
            goto L_0x010d
        L_0x00fa:
            r8 = -1288936998(0xffffffffb32c61da, float:-4.0135866E-8)
            r0.startReplaceableGroup(r8)
            com.designsystem.ds_theme.DSTheme r8 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSDimens r8 = r8.getDimens(r0, r6)
            float r8 = r8.m8849getDsZeroD9Ej5fM()
            r0.endReplaceableGroup()
        L_0x010d:
            androidx.compose.ui.Alignment$Companion r9 = androidx.compose.ui.Alignment.Companion
            androidx.compose.ui.Alignment$Vertical r9 = r9.getCenterVertically()
            com.designsystem.ds_theme.DSTheme r11 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSDimens r12 = r11.getDimens(r0, r6)
            float r12 = r12.m8842getDsSD9Ej5fM()
            com.designsystem.ds_theme.DSDimens r13 = r11.getDimens(r0, r6)
            float r13 = r13.m8842getDsSD9Ej5fM()
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.PaddingKt.m489paddingqDBjuR0(r1, r7, r12, r8, r13)
            com.designsystem.ds_theme.DSDimens r8 = r11.getDimens(r0, r6)
            float r8 = r8.m8840getDsLD9Ej5fM()
            r12 = 0
            r13 = 1
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.SizeKt.m543defaultMinSizeVpY3zN4$default(r7, r12, r8, r13, r10)
            r8 = -1989997546(0xffffffff89630c16, float:-2.7329814E-33)
            r0.startReplaceableGroup(r8)
            androidx.compose.foundation.layout.Arrangement r8 = androidx.compose.foundation.layout.Arrangement.INSTANCE
            androidx.compose.foundation.layout.Arrangement$Horizontal r8 = r8.getStart()
            androidx.compose.ui.layout.MeasurePolicy r8 = androidx.compose.foundation.layout.RowKt.rowMeasurePolicy(r8, r9, r0, r6)
            r9 = 1376089335(0x520574f7, float:1.43298249E11)
            r0.startReplaceableGroup(r9)
            androidx.compose.runtime.ProvidableCompositionLocal r9 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalDensity()
            java.lang.Object r9 = r0.consume(r9)
            androidx.compose.ui.unit.Density r9 = (androidx.compose.ui.unit.Density) r9
            androidx.compose.runtime.ProvidableCompositionLocal r10 = androidx.compose.ui.platform.CompositionLocalsKt.getLocalLayoutDirection()
            java.lang.Object r10 = r0.consume(r10)
            androidx.compose.ui.unit.LayoutDirection r10 = (androidx.compose.ui.unit.LayoutDirection) r10
            androidx.compose.ui.node.ComposeUiNode$Companion r12 = androidx.compose.ui.node.ComposeUiNode.Companion
            kotlin.jvm.functions.Function0 r13 = r12.getConstructor()
            kotlin.jvm.functions.Function3 r7 = androidx.compose.ui.layout.LayoutKt.materializerOf(r7)
            androidx.compose.runtime.Applier r14 = r0.getApplier()
            boolean r14 = r14 instanceof androidx.compose.runtime.Applier
            if (r14 != 0) goto L_0x0176
            androidx.compose.runtime.ComposablesKt.invalidApplier()
        L_0x0176:
            r0.startReusableNode()
            boolean r14 = r0.getInserting()
            if (r14 == 0) goto L_0x0183
            r0.createNode(r13)
            goto L_0x0186
        L_0x0183:
            r0.useNode()
        L_0x0186:
            r0.disableReusing()
            androidx.compose.runtime.Composer r13 = androidx.compose.runtime.Updater.m2536constructorimpl(r0)
            kotlin.jvm.functions.Function2 r14 = r12.getSetMeasurePolicy()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r13, r8, r14)
            kotlin.jvm.functions.Function2 r8 = r12.getSetDensity()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r13, r9, r8)
            kotlin.jvm.functions.Function2 r8 = r12.getSetLayoutDirection()
            androidx.compose.runtime.Updater.m2543setimpl((androidx.compose.runtime.Composer) r13, r10, r8)
            r0.enableReusing()
            androidx.compose.runtime.Composer r8 = androidx.compose.runtime.SkippableUpdater.m2527constructorimpl(r0)
            androidx.compose.runtime.SkippableUpdater r8 = androidx.compose.runtime.SkippableUpdater.m2526boximpl(r8)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r6)
            r7.invoke(r8, r0, r9)
            r7 = 2058660585(0x7ab4aae9, float:4.6903995E35)
            r0.startReplaceableGroup(r7)
            r7 = -326682743(0xffffffffec873789, float:-1.307738E27)
            r0.startReplaceableGroup(r7)
            androidx.compose.foundation.layout.RowScopeInstance r7 = androidx.compose.foundation.layout.RowScopeInstance.INSTANCE
            com.designsystem.ds_theme.DSColors r7 = r11.getColors(r0, r6)
            long r8 = r7.m8774getDsNeutralWhite0d7_KjU()
            com.designsystem.ds_theme.DSTypography r6 = r11.getTypography(r0, r6)
            androidx.compose.ui.text.TextStyle r25 = r6.getDsBody1Compact()
            r7 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            r24 = 0
            int r2 = r2 >> 3
            r27 = r2 & 14
            r28 = 64
            r29 = 24570(0x5ffa, float:3.443E-41)
            r6 = r33
            r23 = r3
            r26 = r0
            androidx.compose.material.TextKt.m1461TextfLXpl1I(r6, r7, r8, r10, r12, r13, r14, r15, r17, r18, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r0.endNode()
            r0.endReplaceableGroup()
            r0.endReplaceableGroup()
            r3 = r30
            r9 = r31
        L_0x020a:
            androidx.compose.runtime.ScopeUpdateScope r7 = r0.endRestartGroup()
            if (r7 != 0) goto L_0x0211
            goto L_0x0223
        L_0x0211:
            com.designsystem.ds_toast.ToastComposablesKt$ToastLabel$2 r8 = new com.designsystem.ds_toast.ToastComposablesKt$ToastLabel$2
            r0 = r8
            r1 = r32
            r2 = r33
            r4 = r9
            r5 = r37
            r6 = r38
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r7.updateScope(r8)
        L_0x0223:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_toast.ToastComposablesKt.ToastLabel(androidx.compose.ui.Modifier, java.lang.String, java.lang.Integer, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    @Composable
    public static final void ToastLeadingIcon(@Nullable @DrawableRes Integer num, @Nullable Composer composer, int i11, int i12) {
        int i13;
        Integer num2;
        Integer num3;
        int i14;
        int i15 = i11;
        int i16 = i12;
        Composer startRestartGroup = composer.startRestartGroup(-2111773442);
        int i17 = i16 & 1;
        if (i17 != 0) {
            i13 = i15 | 6;
            num2 = num;
        } else if ((i15 & 14) == 0) {
            num2 = num;
            if (startRestartGroup.changed((Object) num2)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i13 = i14 | i15;
        } else {
            num2 = num;
            i13 = i15;
        }
        if ((2 ^ (i13 & 11)) != 0 || !startRestartGroup.getSkipping()) {
            if (i17 != 0) {
                num3 = null;
            } else {
                num3 = num2;
            }
            if (num3 == null) {
                startRestartGroup.startReplaceableGroup(-1040464595);
            } else {
                startRestartGroup.startReplaceableGroup(-2111773356);
                num3.intValue();
                Painter painterResource = PainterResources_androidKt.painterResource(num3.intValue(), startRestartGroup, i13 & 14);
                DSTheme dSTheme = DSTheme.INSTANCE;
                IconKt.m1278Iconww6aTOc(painterResource, (String) null, TestTagKt.testTag(SizeKt.m558size3ABfNKs(PaddingKt.m490paddingqDBjuR0$default(Modifier.Companion, dSTheme.getDimens(startRestartGroup, 0).m8842getDsSD9Ej5fM(), 0.0f, dSTheme.getDimens(startRestartGroup, 0).m8844getDsXsD9Ej5fM(), 0.0f, 10, (Object) null), dSTheme.getDimens(startRestartGroup, 0).m8840getDsLD9Ej5fM()), Toast.ToastLeadingIconTestTag), dSTheme.getColors(startRestartGroup, 0).m8774getDsNeutralWhite0d7_KjU(), startRestartGroup, 56, 0);
            }
            startRestartGroup.endReplaceableGroup();
            num2 = num3;
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ToastComposablesKt$ToastLeadingIcon$2(num2, i15, i16));
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d2  */
    /* JADX WARNING: Removed duplicated region for block: B:50:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ToastSurface(java.lang.String r20, @androidx.annotation.DrawableRes java.lang.Integer r21, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, androidx.compose.runtime.Composer r23, int r24, int r25) {
        /*
            r1 = r20
            r4 = r24
            r0 = -1378480972(0xffffffffadd60cb4, float:-2.4334625E-11)
            r2 = r23
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            r2 = r25 & 1
            if (r2 == 0) goto L_0x0014
            r2 = r4 | 6
            goto L_0x0024
        L_0x0014:
            r2 = r4 & 14
            if (r2 != 0) goto L_0x0023
            boolean r2 = r0.changed((java.lang.Object) r1)
            if (r2 == 0) goto L_0x0020
            r2 = 4
            goto L_0x0021
        L_0x0020:
            r2 = 2
        L_0x0021:
            r2 = r2 | r4
            goto L_0x0024
        L_0x0023:
            r2 = r4
        L_0x0024:
            r3 = r25 & 2
            if (r3 == 0) goto L_0x002b
            r2 = r2 | 48
            goto L_0x003e
        L_0x002b:
            r5 = r4 & 112(0x70, float:1.57E-43)
            if (r5 != 0) goto L_0x003e
            r5 = r21
            boolean r6 = r0.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x003a
            r6 = 32
            goto L_0x003c
        L_0x003a:
            r6 = 16
        L_0x003c:
            r2 = r2 | r6
            goto L_0x0040
        L_0x003e:
            r5 = r21
        L_0x0040:
            r6 = r25 & 4
            if (r6 == 0) goto L_0x0047
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x005a
        L_0x0047:
            r7 = r4 & 896(0x380, float:1.256E-42)
            if (r7 != 0) goto L_0x005a
            r7 = r22
            boolean r8 = r0.changed((java.lang.Object) r7)
            if (r8 == 0) goto L_0x0056
            r8 = 256(0x100, float:3.59E-43)
            goto L_0x0058
        L_0x0056:
            r8 = 128(0x80, float:1.794E-43)
        L_0x0058:
            r2 = r2 | r8
            goto L_0x005c
        L_0x005a:
            r7 = r22
        L_0x005c:
            r8 = r2 & 731(0x2db, float:1.024E-42)
            r8 = r8 ^ 146(0x92, float:2.05E-43)
            if (r8 != 0) goto L_0x006f
            boolean r8 = r0.getSkipping()
            if (r8 != 0) goto L_0x0069
            goto L_0x006f
        L_0x0069:
            r0.skipToGroupEnd()
            r2 = r5
            r3 = r7
            goto L_0x00cb
        L_0x006f:
            r8 = 0
            if (r3 == 0) goto L_0x0074
            r3 = r8
            goto L_0x0075
        L_0x0074:
            r3 = r5
        L_0x0075:
            if (r6 == 0) goto L_0x0079
            r15 = r8
            goto L_0x007a
        L_0x0079:
            r15 = r7
        L_0x007a:
            com.designsystem.ds_theme.DSTheme r5 = com.designsystem.ds_theme.DSTheme.INSTANCE
            r6 = 0
            com.designsystem.ds_theme.DSColors r7 = r5.getColors(r0, r6)
            long r9 = r7.m8760getDsNeutral1000d7_KjU()
            androidx.compose.ui.Modifier$Companion r7 = androidx.compose.ui.Modifier.Companion
            r11 = 3
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.SizeKt.wrapContentHeight$default(r7, r8, r6, r11, r8)
            r11 = 0
            r12 = 1
            androidx.compose.ui.Modifier r7 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r7, r11, r12, r8)
            com.designsystem.ds_theme.DSDimens r5 = r5.getDimens(r0, r6)
            float r5 = r5.m8846getDsXxsD9Ej5fM()
            androidx.compose.foundation.shape.RoundedCornerShape r5 = androidx.compose.foundation.shape.RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(r5)
            androidx.compose.ui.Modifier r5 = androidx.compose.ui.draw.ClipKt.clip(r7, r5)
            r6 = 0
            r13 = 0
            r11 = 0
            r16 = 0
            com.designsystem.ds_toast.ToastComposablesKt$ToastSurface$1 r7 = new com.designsystem.ds_toast.ToastComposablesKt$ToastSurface$1
            r7.<init>(r3, r2, r1, r15)
            r2 = -819893263(0xffffffffcf216bf1, float:-2.70820582E9)
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r2, r12, r7)
            r17 = 1572864(0x180000, float:2.204052E-39)
            r18 = 58
            r7 = r9
            r9 = r13
            r12 = r16
            r13 = r2
            r14 = r0
            r2 = r15
            r15 = r17
            r16 = r18
            androidx.compose.material.SurfaceKt.m1384SurfaceFjzlyU(r5, r6, r7, r9, r11, r12, r13, r14, r15, r16)
            r19 = r3
            r3 = r2
            r2 = r19
        L_0x00cb:
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L_0x00d2
            goto L_0x00e1
        L_0x00d2:
            com.designsystem.ds_toast.ToastComposablesKt$ToastSurface$2 r7 = new com.designsystem.ds_toast.ToastComposablesKt$ToastSurface$2
            r0 = r7
            r1 = r20
            r4 = r24
            r5 = r25
            r0.<init>(r1, r2, r3, r4, r5)
            r6.updateScope(r7)
        L_0x00e1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_toast.ToastComposablesKt.ToastSurface(java.lang.String, java.lang.Integer, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ToastWithActionButton(@org.jetbrains.annotations.NotNull java.lang.String r12, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r13, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r14, @org.jetbrains.annotations.Nullable java.lang.String r15, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r16, int r17, int r18) {
        /*
            r6 = r12
            r7 = r15
            r8 = r17
            java.lang.String r0 = "label"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 984418761(0x3aad09c9, float:0.0013201769)
            r1 = r16
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            r0 = r18 & 1
            if (r0 == 0) goto L_0x0019
            r0 = r8 | 6
            goto L_0x0029
        L_0x0019:
            r0 = r8 & 14
            if (r0 != 0) goto L_0x0028
            boolean r0 = r9.changed((java.lang.Object) r12)
            if (r0 == 0) goto L_0x0025
            r0 = 4
            goto L_0x0026
        L_0x0025:
            r0 = 2
        L_0x0026:
            r0 = r0 | r8
            goto L_0x0029
        L_0x0028:
            r0 = r8
        L_0x0029:
            r1 = r18 & 2
            if (r1 == 0) goto L_0x0030
            r0 = r0 | 48
            goto L_0x0042
        L_0x0030:
            r2 = r8 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0042
            r2 = r13
            boolean r3 = r9.changed((java.lang.Object) r13)
            if (r3 == 0) goto L_0x003e
            r3 = 32
            goto L_0x0040
        L_0x003e:
            r3 = 16
        L_0x0040:
            r0 = r0 | r3
            goto L_0x0043
        L_0x0042:
            r2 = r13
        L_0x0043:
            r3 = r18 & 4
            if (r3 == 0) goto L_0x004a
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x005c
        L_0x004a:
            r4 = r8 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x005c
            r4 = r14
            boolean r5 = r9.changed((java.lang.Object) r14)
            if (r5 == 0) goto L_0x0058
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x005a
        L_0x0058:
            r5 = 128(0x80, float:1.794E-43)
        L_0x005a:
            r0 = r0 | r5
            goto L_0x005d
        L_0x005c:
            r4 = r14
        L_0x005d:
            r5 = r18 & 8
            if (r5 == 0) goto L_0x0064
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0074
        L_0x0064:
            r5 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0074
            boolean r5 = r9.changed((java.lang.Object) r15)
            if (r5 == 0) goto L_0x0071
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x0073
        L_0x0071:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x0073:
            r0 = r0 | r5
        L_0x0074:
            r5 = r0 & 5851(0x16db, float:8.199E-42)
            r5 = r5 ^ 1170(0x492, float:1.64E-42)
            if (r5 != 0) goto L_0x0086
            boolean r5 = r9.getSkipping()
            if (r5 != 0) goto L_0x0081
            goto L_0x0086
        L_0x0081:
            r9.skipToGroupEnd()
            r3 = r4
            goto L_0x00af
        L_0x0086:
            r5 = 0
            if (r1 == 0) goto L_0x008b
            r10 = r5
            goto L_0x008c
        L_0x008b:
            r10 = r2
        L_0x008c:
            if (r3 == 0) goto L_0x0090
            r11 = r5
            goto L_0x0091
        L_0x0090:
            r11 = r4
        L_0x0091:
            com.designsystem.ds_toast.ToastComposablesKt$ToastWithActionButton$1 r1 = new com.designsystem.ds_toast.ToastComposablesKt$ToastWithActionButton$1
            r1.<init>(r11, r0, r15)
            r2 = -819892310(0xffffffffcf216faa, float:-2.70844979E9)
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r9, r2, r3, r1)
            r1 = r0 & 14
            r1 = r1 | 384(0x180, float:5.38E-43)
            r0 = r0 & 112(0x70, float:1.57E-43)
            r4 = r1 | r0
            r5 = 0
            r0 = r12
            r1 = r10
            r3 = r9
            ToastSurface(r0, r1, r2, r3, r4, r5)
            r2 = r10
            r3 = r11
        L_0x00af:
            androidx.compose.runtime.ScopeUpdateScope r9 = r9.endRestartGroup()
            if (r9 != 0) goto L_0x00b6
            goto L_0x00c5
        L_0x00b6:
            com.designsystem.ds_toast.ToastComposablesKt$ToastWithActionButton$2 r10 = new com.designsystem.ds_toast.ToastComposablesKt$ToastWithActionButton$2
            r0 = r10
            r1 = r12
            r4 = r15
            r5 = r17
            r6 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r9.updateScope(r10)
        L_0x00c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_toast.ToastComposablesKt.ToastWithActionButton(java.lang.String, java.lang.Integer, kotlin.jvm.functions.Function0, java.lang.String, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0086  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ToastWithIconButton(@org.jetbrains.annotations.NotNull java.lang.String r12, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r13, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r14, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r15, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r16, int r17, int r18) {
        /*
            r6 = r12
            r7 = r15
            r8 = r17
            java.lang.String r0 = "label"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            r0 = 574962880(0x22453cc0, float:2.673064E-18)
            r1 = r16
            androidx.compose.runtime.Composer r9 = r1.startRestartGroup(r0)
            r0 = r18 & 1
            if (r0 == 0) goto L_0x0019
            r0 = r8 | 6
            goto L_0x0029
        L_0x0019:
            r0 = r8 & 14
            if (r0 != 0) goto L_0x0028
            boolean r0 = r9.changed((java.lang.Object) r12)
            if (r0 == 0) goto L_0x0025
            r0 = 4
            goto L_0x0026
        L_0x0025:
            r0 = 2
        L_0x0026:
            r0 = r0 | r8
            goto L_0x0029
        L_0x0028:
            r0 = r8
        L_0x0029:
            r1 = r18 & 2
            if (r1 == 0) goto L_0x0030
            r0 = r0 | 48
            goto L_0x0042
        L_0x0030:
            r2 = r8 & 112(0x70, float:1.57E-43)
            if (r2 != 0) goto L_0x0042
            r2 = r13
            boolean r3 = r9.changed((java.lang.Object) r13)
            if (r3 == 0) goto L_0x003e
            r3 = 32
            goto L_0x0040
        L_0x003e:
            r3 = 16
        L_0x0040:
            r0 = r0 | r3
            goto L_0x0043
        L_0x0042:
            r2 = r13
        L_0x0043:
            r3 = r18 & 4
            if (r3 == 0) goto L_0x004a
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x005c
        L_0x004a:
            r4 = r8 & 896(0x380, float:1.256E-42)
            if (r4 != 0) goto L_0x005c
            r4 = r14
            boolean r5 = r9.changed((java.lang.Object) r14)
            if (r5 == 0) goto L_0x0058
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x005a
        L_0x0058:
            r5 = 128(0x80, float:1.794E-43)
        L_0x005a:
            r0 = r0 | r5
            goto L_0x005d
        L_0x005c:
            r4 = r14
        L_0x005d:
            r5 = r18 & 8
            if (r5 == 0) goto L_0x0064
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0074
        L_0x0064:
            r5 = r8 & 7168(0x1c00, float:1.0045E-41)
            if (r5 != 0) goto L_0x0074
            boolean r5 = r9.changed((java.lang.Object) r15)
            if (r5 == 0) goto L_0x0071
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x0073
        L_0x0071:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x0073:
            r0 = r0 | r5
        L_0x0074:
            r5 = r0 & 5851(0x16db, float:8.199E-42)
            r5 = r5 ^ 1170(0x492, float:1.64E-42)
            if (r5 != 0) goto L_0x0086
            boolean r5 = r9.getSkipping()
            if (r5 != 0) goto L_0x0081
            goto L_0x0086
        L_0x0081:
            r9.skipToGroupEnd()
            r3 = r4
            goto L_0x00af
        L_0x0086:
            r5 = 0
            if (r1 == 0) goto L_0x008b
            r10 = r5
            goto L_0x008c
        L_0x008b:
            r10 = r2
        L_0x008c:
            if (r3 == 0) goto L_0x0090
            r11 = r5
            goto L_0x0091
        L_0x0090:
            r11 = r4
        L_0x0091:
            com.designsystem.ds_toast.ToastComposablesKt$ToastWithIconButton$1 r1 = new com.designsystem.ds_toast.ToastComposablesKt$ToastWithIconButton$1
            r1.<init>(r15, r11, r0)
            r2 = -819896124(0xffffffffcf2160c4, float:-2.70747341E9)
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r9, r2, r3, r1)
            r1 = r0 & 14
            r1 = r1 | 384(0x180, float:5.38E-43)
            r0 = r0 & 112(0x70, float:1.57E-43)
            r4 = r1 | r0
            r5 = 0
            r0 = r12
            r1 = r10
            r3 = r9
            ToastSurface(r0, r1, r2, r3, r4, r5)
            r2 = r10
            r3 = r11
        L_0x00af:
            androidx.compose.runtime.ScopeUpdateScope r9 = r9.endRestartGroup()
            if (r9 != 0) goto L_0x00b6
            goto L_0x00c5
        L_0x00b6:
            com.designsystem.ds_toast.ToastComposablesKt$ToastWithIconButton$2 r10 = new com.designsystem.ds_toast.ToastComposablesKt$ToastWithIconButton$2
            r0 = r10
            r1 = r12
            r4 = r15
            r5 = r17
            r6 = r18
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r9.updateScope(r10)
        L_0x00c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_toast.ToastComposablesKt.ToastWithIconButton(java.lang.String, java.lang.Integer, kotlin.jvm.functions.Function0, java.lang.Integer, androidx.compose.runtime.Composer, int, int):void");
    }
}
