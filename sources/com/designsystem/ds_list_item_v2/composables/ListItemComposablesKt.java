package com.designsystem.ds_list_item_v2.composables;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.Indication;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.SurfaceKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.designsystem.ds_theme.DSTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001aß\u0001\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\n\b\u0003\u0010\f\u001a\u0004\u0018\u00010\t2\n\b\u0003\u0010\r\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2*\b\u0002\u0010\u0010\u001a$\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011¢\u0006\u0002\b\u00162*\b\u0002\u0010\u0017\u001a$\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0019\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0011¢\u0006\u0002\b\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u0018H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001a\u0010\u001b\u001a5\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u001eH\u0001¢\u0006\u0002\u0010\u001f\u001aU\u0010 \u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u00182\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00010\u0011¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u001eH\u0001¢\u0006\u0002\u0010#\u001a$\u0010$\u001a\u00020\u00012\u0015\b\u0002\u0010%\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\u0016H\u0001¢\u0006\u0002\u0010&\u001a4\u0010'\u001a\u00020\u0005*\u00020\u00052\u0006\u0010!\u001a\u00020\"2\u0006\u0010(\u001a\u00020)2\u000e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b2\u0006\u0010\u0019\u001a\u00020\u0018H\u0001\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006*"}, d2 = {"ListItem", "", "label", "", "modifier", "Landroidx/compose/ui/Modifier;", "secondaryLabel", "descriptor", "descriptorColor", "", "onTap", "Lkotlin/Function0;", "leadingIcon", "leadingImage", "imageCornerRadius", "Landroidx/compose/ui/unit/Dp;", "leadingView", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ParameterName;", "name", "scope", "Landroidx/compose/runtime/Composable;", "trailingView", "", "isEnabled", "ListItem-wn8IZOc", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lkotlin/jvm/functions/Function0;Ljava/lang/Integer;Ljava/lang/Integer;FLkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;ZLandroidx/compose/runtime/Composer;III)V", "ListItemInteractiveSurface", "content", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ListItemSurface", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/MutableInteractionSource;ZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ListItemTrailingContainer", "trailingComposable", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "tappable", "indication", "Landroidx/compose/foundation/Indication;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class ListItemComposablesKt {
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0143  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0148  */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0174  */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x018b  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0285  */
    /* JADX WARNING: Removed duplicated region for block: B:167:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0129  */
    @androidx.compose.runtime.Composable
    /* renamed from: ListItem-wn8IZOc  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8490ListItemwn8IZOc(@org.jetbrains.annotations.NotNull java.lang.String r30, @org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r31, @org.jetbrains.annotations.Nullable java.lang.String r32, @org.jetbrains.annotations.Nullable java.lang.String r33, @org.jetbrains.annotations.Nullable @androidx.annotation.ColorRes java.lang.Integer r34, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r35, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r36, @org.jetbrains.annotations.Nullable @androidx.annotation.DrawableRes java.lang.Integer r37, float r38, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function3<? super java.lang.Boolean, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r40, boolean r41, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r42, int r43, int r44, int r45) {
        /*
            r15 = r30
            r14 = r31
            r13 = r43
            r12 = r45
            java.lang.String r0 = "label"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            r0 = -692015771(0xffffffffd6c0ad65, float:-1.05925478E14)
            r1 = r42
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            r0 = r12 & 1
            if (r0 == 0) goto L_0x0022
            r0 = r13 | 6
            goto L_0x0032
        L_0x0022:
            r0 = r13 & 14
            if (r0 != 0) goto L_0x0031
            boolean r0 = r11.changed((java.lang.Object) r15)
            if (r0 == 0) goto L_0x002e
            r0 = 4
            goto L_0x002f
        L_0x002e:
            r0 = 2
        L_0x002f:
            r0 = r0 | r13
            goto L_0x0032
        L_0x0031:
            r0 = r13
        L_0x0032:
            r3 = r12 & 2
            if (r3 == 0) goto L_0x0039
            r0 = r0 | 48
            goto L_0x0049
        L_0x0039:
            r3 = r13 & 112(0x70, float:1.57E-43)
            if (r3 != 0) goto L_0x0049
            boolean r3 = r11.changed((java.lang.Object) r14)
            if (r3 == 0) goto L_0x0046
            r3 = 32
            goto L_0x0048
        L_0x0046:
            r3 = 16
        L_0x0048:
            r0 = r0 | r3
        L_0x0049:
            r3 = r12 & 4
            if (r3 == 0) goto L_0x0050
            r0 = r0 | 384(0x180, float:5.38E-43)
            goto L_0x0063
        L_0x0050:
            r6 = r13 & 896(0x380, float:1.256E-42)
            if (r6 != 0) goto L_0x0063
            r6 = r32
            boolean r7 = r11.changed((java.lang.Object) r6)
            if (r7 == 0) goto L_0x005f
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0061
        L_0x005f:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0061:
            r0 = r0 | r7
            goto L_0x0065
        L_0x0063:
            r6 = r32
        L_0x0065:
            r7 = r12 & 8
            if (r7 == 0) goto L_0x006c
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x007f
        L_0x006c:
            r8 = r13 & 7168(0x1c00, float:1.0045E-41)
            if (r8 != 0) goto L_0x007f
            r8 = r33
            boolean r9 = r11.changed((java.lang.Object) r8)
            if (r9 == 0) goto L_0x007b
            r9 = 2048(0x800, float:2.87E-42)
            goto L_0x007d
        L_0x007b:
            r9 = 1024(0x400, float:1.435E-42)
        L_0x007d:
            r0 = r0 | r9
            goto L_0x0081
        L_0x007f:
            r8 = r33
        L_0x0081:
            r9 = r12 & 16
            if (r9 == 0) goto L_0x0088
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009e
        L_0x0088:
            r10 = 57344(0xe000, float:8.0356E-41)
            r10 = r10 & r13
            if (r10 != 0) goto L_0x009e
            r10 = r34
            boolean r16 = r11.changed((java.lang.Object) r10)
            if (r16 == 0) goto L_0x0099
            r16 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009b
        L_0x0099:
            r16 = 8192(0x2000, float:1.14794E-41)
        L_0x009b:
            r0 = r0 | r16
            goto L_0x00a0
        L_0x009e:
            r10 = r34
        L_0x00a0:
            r16 = r12 & 32
            if (r16 == 0) goto L_0x00ab
            r17 = 196608(0x30000, float:2.75506E-40)
            r0 = r0 | r17
            r1 = r35
            goto L_0x00c0
        L_0x00ab:
            r17 = 458752(0x70000, float:6.42848E-40)
            r17 = r13 & r17
            r1 = r35
            if (r17 != 0) goto L_0x00c0
            boolean r17 = r11.changed((java.lang.Object) r1)
            if (r17 == 0) goto L_0x00bc
            r17 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00be
        L_0x00bc:
            r17 = 65536(0x10000, float:9.18355E-41)
        L_0x00be:
            r0 = r0 | r17
        L_0x00c0:
            r17 = r12 & 64
            if (r17 == 0) goto L_0x00cb
            r18 = 1572864(0x180000, float:2.204052E-39)
            r0 = r0 | r18
            r2 = r36
            goto L_0x00e0
        L_0x00cb:
            r18 = 3670016(0x380000, float:5.142788E-39)
            r18 = r13 & r18
            r2 = r36
            if (r18 != 0) goto L_0x00e0
            boolean r19 = r11.changed((java.lang.Object) r2)
            if (r19 == 0) goto L_0x00dc
            r19 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00de
        L_0x00dc:
            r19 = 524288(0x80000, float:7.34684E-40)
        L_0x00de:
            r0 = r0 | r19
        L_0x00e0:
            r4 = r12 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x00eb
            r20 = 12582912(0xc00000, float:1.7632415E-38)
            r0 = r0 | r20
            r5 = r37
            goto L_0x0100
        L_0x00eb:
            r20 = 29360128(0x1c00000, float:7.052966E-38)
            r20 = r13 & r20
            r5 = r37
            if (r20 != 0) goto L_0x0100
            boolean r21 = r11.changed((java.lang.Object) r5)
            if (r21 == 0) goto L_0x00fc
            r21 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00fe
        L_0x00fc:
            r21 = 4194304(0x400000, float:5.877472E-39)
        L_0x00fe:
            r0 = r0 | r21
        L_0x0100:
            r1 = r12 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x010b
            r21 = 805306368(0x30000000, float:4.656613E-10)
            r0 = r0 | r21
            r2 = r39
            goto L_0x0120
        L_0x010b:
            r21 = 1879048192(0x70000000, float:1.58456325E29)
            r21 = r13 & r21
            r2 = r39
            if (r21 != 0) goto L_0x0120
            boolean r21 = r11.changed((java.lang.Object) r2)
            if (r21 == 0) goto L_0x011c
            r21 = 536870912(0x20000000, float:1.0842022E-19)
            goto L_0x011e
        L_0x011c:
            r21 = 268435456(0x10000000, float:2.5243549E-29)
        L_0x011e:
            r0 = r0 | r21
        L_0x0120:
            r2 = r12 & 1024(0x400, float:1.435E-42)
            if (r2 == 0) goto L_0x0129
            r18 = r44 | 6
            r5 = r40
            goto L_0x013f
        L_0x0129:
            r21 = r44 & 14
            r5 = r40
            if (r21 != 0) goto L_0x013d
            boolean r21 = r11.changed((java.lang.Object) r5)
            if (r21 == 0) goto L_0x0138
            r18 = 4
            goto L_0x013a
        L_0x0138:
            r18 = 2
        L_0x013a:
            r18 = r44 | r18
            goto L_0x013f
        L_0x013d:
            r18 = r44
        L_0x013f:
            r5 = r12 & 2048(0x800, float:2.87E-42)
            if (r5 == 0) goto L_0x0148
            r18 = r18 | 48
            r6 = r41
            goto L_0x015b
        L_0x0148:
            r21 = r44 & 112(0x70, float:1.57E-43)
            r6 = r41
            if (r21 != 0) goto L_0x015b
            boolean r21 = r11.changed((boolean) r6)
            if (r21 == 0) goto L_0x0157
            r19 = 32
            goto L_0x0159
        L_0x0157:
            r19 = 16
        L_0x0159:
            r18 = r18 | r19
        L_0x015b:
            r19 = 1366144731(0x516db6db, float:6.3810941E10)
            r19 = r0 & r19
            r20 = 273228946(0x10492492, float:3.9668433E-29)
            r19 = r19 ^ r20
            if (r19 != 0) goto L_0x018b
            r19 = r18 & 91
            r19 = r19 ^ 18
            if (r19 != 0) goto L_0x018b
            boolean r19 = r11.getSkipping()
            if (r19 != 0) goto L_0x0174
            goto L_0x018b
        L_0x0174:
            r11.skipToGroupEnd()
            r3 = r32
            r7 = r36
            r9 = r38
            r12 = r6
            r4 = r8
            r5 = r10
            r1 = r11
            r6 = r35
            r8 = r37
            r10 = r39
            r11 = r40
            goto L_0x027e
        L_0x018b:
            r19 = r13 & 1
            r20 = -234881025(0xfffffffff1ffffff, float:-2.535301E30)
            if (r19 == 0) goto L_0x01b9
            boolean r19 = r11.getDefaultsInvalid()
            if (r19 == 0) goto L_0x0199
            goto L_0x01b9
        L_0x0199:
            r11.skipCurrentGroup()
            r1 = r12 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x01a2
            r0 = r0 & r20
        L_0x01a2:
            r15 = r32
            r19 = r35
            r20 = r36
            r21 = r37
            r22 = r38
            r23 = r39
            r24 = r40
            r5 = r0
            r25 = r6
            r16 = r8
            r17 = r10
            goto L_0x0221
        L_0x01b9:
            r11.startDefaults()
            r19 = 0
            if (r3 == 0) goto L_0x01c3
            r3 = r19
            goto L_0x01c5
        L_0x01c3:
            r3 = r32
        L_0x01c5:
            if (r7 == 0) goto L_0x01c9
            r8 = r19
        L_0x01c9:
            if (r9 == 0) goto L_0x01cd
            r10 = r19
        L_0x01cd:
            if (r16 == 0) goto L_0x01d2
            r7 = r19
            goto L_0x01d4
        L_0x01d2:
            r7 = r35
        L_0x01d4:
            if (r17 == 0) goto L_0x01d9
            r9 = r19
            goto L_0x01db
        L_0x01d9:
            r9 = r36
        L_0x01db:
            if (r4 == 0) goto L_0x01e0
            r4 = r19
            goto L_0x01e2
        L_0x01e0:
            r4 = r37
        L_0x01e2:
            r15 = r12 & 256(0x100, float:3.59E-43)
            if (r15 == 0) goto L_0x01f6
            com.designsystem.ds_theme.DSTheme r15 = com.designsystem.ds_theme.DSTheme.INSTANCE
            r32 = r3
            r3 = 0
            com.designsystem.ds_theme.DSDimens r3 = r15.getDimens(r11, r3)
            float r3 = r3.m8841getDsMD9Ej5fM()
            r0 = r0 & r20
            goto L_0x01fa
        L_0x01f6:
            r32 = r3
            r3 = r38
        L_0x01fa:
            if (r1 == 0) goto L_0x01ff
            r1 = r19
            goto L_0x0201
        L_0x01ff:
            r1 = r39
        L_0x0201:
            if (r2 == 0) goto L_0x0204
            goto L_0x0206
        L_0x0204:
            r19 = r40
        L_0x0206:
            if (r5 == 0) goto L_0x0209
            r6 = 1
        L_0x0209:
            r11.endDefaults()
            r15 = r32
            r5 = r0
            r23 = r1
            r22 = r3
            r21 = r4
            r25 = r6
            r16 = r8
            r20 = r9
            r17 = r10
            r24 = r19
            r19 = r7
        L_0x0221:
            r0 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r11.startReplaceableGroup(r0)
            java.lang.Object r0 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r1 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r1 = r1.getEmpty()
            if (r0 != r1) goto L_0x023a
            androidx.compose.foundation.interaction.MutableInteractionSource r0 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r0)
        L_0x023a:
            r11.endReplaceableGroup()
            r3 = r0
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = (androidx.compose.foundation.interaction.MutableInteractionSource) r3
            com.designsystem.ds_list_item_v2.composables.ListItemComposablesKt$ListItem$1 r10 = new com.designsystem.ds_list_item_v2.composables.ListItemComposablesKt$ListItem$1
            r0 = r10
            r1 = r31
            r2 = r19
            r4 = r25
            r6 = r18
            r7 = r20
            r8 = r21
            r9 = r24
            r26 = r10
            r10 = r23
            r27 = r11
            r11 = r30
            r12 = r15
            r13 = r16
            r14 = r17
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            r0 = -819892581(0xffffffffcf216e9b, float:-2.70838042E9)
            r2 = r26
            r1 = r27
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r0 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r1, r0, r3, r2)
            r2 = 6
            com.designsystem.ds_theme.DSThemeKt.DSTheme(r0, r1, r2)
            r3 = r15
            r4 = r16
            r5 = r17
            r6 = r19
            r9 = r22
            r11 = r24
            r12 = r25
        L_0x027e:
            androidx.compose.runtime.ScopeUpdateScope r15 = r1.endRestartGroup()
            if (r15 != 0) goto L_0x0285
            goto L_0x02a0
        L_0x0285:
            com.designsystem.ds_list_item_v2.composables.ListItemComposablesKt$ListItem$2 r14 = new com.designsystem.ds_list_item_v2.composables.ListItemComposablesKt$ListItem$2
            r0 = r14
            r1 = r30
            r2 = r31
            r13 = r43
            r28 = r14
            r14 = r44
            r29 = r15
            r15 = r45
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            r1 = r28
            r0 = r29
            r0.updateScope(r1)
        L_0x02a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_list_item_v2.composables.ListItemComposablesKt.m8490ListItemwn8IZOc(java.lang.String, androidx.compose.ui.Modifier, java.lang.String, java.lang.String, java.lang.Integer, kotlin.jvm.functions.Function0, java.lang.Integer, java.lang.Integer, float, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, boolean, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @Composable
    public static final void ListItemInteractiveSurface(@Nullable Modifier modifier, @NotNull Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, @Nullable Composer composer, int i11, int i12) {
        int i13;
        Modifier modifier2;
        Modifier.Companion companion;
        int i14;
        int i15;
        Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function32 = function3;
        int i16 = i11;
        int i17 = i12;
        Intrinsics.checkNotNullParameter(function32, "content");
        Composer startRestartGroup = composer.startRestartGroup(-398381997);
        int i18 = i17 & 1;
        if (i18 != 0) {
            i13 = i16 | 6;
            modifier2 = modifier;
        } else if ((i16 & 14) == 0) {
            modifier2 = modifier;
            if (startRestartGroup.changed((Object) modifier2)) {
                i15 = 4;
            } else {
                i15 = 2;
            }
            i13 = i15 | i16;
        } else {
            modifier2 = modifier;
            i13 = i16;
        }
        if ((i17 & 2) != 0) {
            i13 |= 48;
        } else if ((i16 & 112) == 0) {
            if (startRestartGroup.changed((Object) function32)) {
                i14 = 32;
            } else {
                i14 = 16;
            }
            i13 |= i14;
        }
        if (((i13 & 91) ^ 18) != 0 || !startRestartGroup.getSkipping()) {
            if (i18 != 0) {
                companion = Modifier.Companion;
            } else {
                companion = modifier2;
            }
            SurfaceKt.m1384SurfaceFjzlyU(SizeKt.fillMaxWidth$default(SizeKt.wrapContentHeight$default(companion, (Alignment.Vertical) null, false, 3, (Object) null), 0.0f, 1, (Object) null), (Shape) null, DSTheme.INSTANCE.getColors(startRestartGroup, 0).m8774getDsNeutralWhite0d7_KjU(), 0, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, -819891076, true, new ListItemComposablesKt$ListItemInteractiveSurface$1(function32, i13)), startRestartGroup, 1572864, 58);
            modifier2 = companion;
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ListItemComposablesKt$ListItemInteractiveSurface$2(modifier2, function32, i16, i17));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0056  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0072  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:65:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void ListItemSurface(@org.jetbrains.annotations.NotNull androidx.compose.ui.Modifier r15, @org.jetbrains.annotations.Nullable kotlin.jvm.functions.Function0<kotlin.Unit> r16, @org.jetbrains.annotations.NotNull androidx.compose.foundation.interaction.MutableInteractionSource r17, boolean r18, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r19, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r20, int r21, int r22) {
        /*
            r1 = r15
            r8 = r17
            r9 = r19
            r10 = r21
            java.lang.String r0 = "modifier"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "interactionSource"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = -431297193(0xffffffffe64aed57, float:-2.3957404E23)
            r2 = r20
            androidx.compose.runtime.Composer r0 = r2.startRestartGroup(r0)
            r2 = r22 & 1
            if (r2 == 0) goto L_0x0026
            r2 = r10 | 6
            goto L_0x0036
        L_0x0026:
            r2 = r10 & 14
            if (r2 != 0) goto L_0x0035
            boolean r2 = r0.changed((java.lang.Object) r15)
            if (r2 == 0) goto L_0x0032
            r2 = 4
            goto L_0x0033
        L_0x0032:
            r2 = 2
        L_0x0033:
            r2 = r2 | r10
            goto L_0x0036
        L_0x0035:
            r2 = r10
        L_0x0036:
            r3 = r22 & 2
            if (r3 == 0) goto L_0x003d
            r2 = r2 | 48
            goto L_0x0050
        L_0x003d:
            r4 = r10 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L_0x0050
            r4 = r16
            boolean r5 = r0.changed((java.lang.Object) r4)
            if (r5 == 0) goto L_0x004c
            r5 = 32
            goto L_0x004e
        L_0x004c:
            r5 = 16
        L_0x004e:
            r2 = r2 | r5
            goto L_0x0052
        L_0x0050:
            r4 = r16
        L_0x0052:
            r5 = r22 & 4
            if (r5 == 0) goto L_0x0059
            r2 = r2 | 384(0x180, float:5.38E-43)
            goto L_0x0069
        L_0x0059:
            r5 = r10 & 896(0x380, float:1.256E-42)
            if (r5 != 0) goto L_0x0069
            boolean r5 = r0.changed((java.lang.Object) r8)
            if (r5 == 0) goto L_0x0066
            r5 = 256(0x100, float:3.59E-43)
            goto L_0x0068
        L_0x0066:
            r5 = 128(0x80, float:1.794E-43)
        L_0x0068:
            r2 = r2 | r5
        L_0x0069:
            r5 = r22 & 8
            if (r5 == 0) goto L_0x0072
            r2 = r2 | 3072(0xc00, float:4.305E-42)
            r11 = r18
            goto L_0x0084
        L_0x0072:
            r5 = r10 & 7168(0x1c00, float:1.0045E-41)
            r11 = r18
            if (r5 != 0) goto L_0x0084
            boolean r5 = r0.changed((boolean) r11)
            if (r5 == 0) goto L_0x0081
            r5 = 2048(0x800, float:2.87E-42)
            goto L_0x0083
        L_0x0081:
            r5 = 1024(0x400, float:1.435E-42)
        L_0x0083:
            r2 = r2 | r5
        L_0x0084:
            r5 = r22 & 16
            if (r5 == 0) goto L_0x008b
            r2 = r2 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009d
        L_0x008b:
            r5 = 57344(0xe000, float:8.0356E-41)
            r5 = r5 & r10
            if (r5 != 0) goto L_0x009d
            boolean r5 = r0.changed((java.lang.Object) r9)
            if (r5 == 0) goto L_0x009a
            r5 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x009a:
            r5 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r2 = r2 | r5
        L_0x009d:
            r12 = r2
            r2 = 46811(0xb6db, float:6.5596E-41)
            r2 = r2 & r12
            r2 = r2 ^ 9362(0x2492, float:1.3119E-41)
            if (r2 != 0) goto L_0x00b2
            boolean r2 = r0.getSkipping()
            if (r2 != 0) goto L_0x00ad
            goto L_0x00b2
        L_0x00ad:
            r0.skipToGroupEnd()
            r2 = r4
            goto L_0x00d6
        L_0x00b2:
            if (r3 == 0) goto L_0x00b7
            r2 = 0
            r13 = r2
            goto L_0x00b8
        L_0x00b7:
            r13 = r4
        L_0x00b8:
            com.designsystem.ds_list_item_v2.composables.ListItemComposablesKt$ListItemSurface$1 r14 = new com.designsystem.ds_list_item_v2.composables.ListItemComposablesKt$ListItemSurface$1
            r2 = r14
            r3 = r17
            r4 = r13
            r5 = r18
            r6 = r19
            r7 = r12
            r2.<init>(r3, r4, r5, r6, r7)
            r2 = -819890492(0xffffffffcf2176c4, float:-2.7089152E9)
            r3 = 1
            androidx.compose.runtime.internal.ComposableLambda r2 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r2, r3, r14)
            r3 = r12 & 14
            r3 = r3 | 48
            com.designsystem.ds_list_item_v2.composables.CommonListItemComposablesKt.ListItemBackground(r15, r2, r0, r3)
            r2 = r13
        L_0x00d6:
            androidx.compose.runtime.ScopeUpdateScope r12 = r0.endRestartGroup()
            if (r12 != 0) goto L_0x00dd
            goto L_0x00f1
        L_0x00dd:
            com.designsystem.ds_list_item_v2.composables.ListItemComposablesKt$ListItemSurface$2 r13 = new com.designsystem.ds_list_item_v2.composables.ListItemComposablesKt$ListItemSurface$2
            r0 = r13
            r1 = r15
            r3 = r17
            r4 = r18
            r5 = r19
            r6 = r21
            r7 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r12.updateScope(r13)
        L_0x00f1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_list_item_v2.composables.ListItemComposablesKt.ListItemSurface(androidx.compose.ui.Modifier, kotlin.jvm.functions.Function0, androidx.compose.foundation.interaction.MutableInteractionSource, boolean, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    @Composable
    public static final void ListItemTrailingContainer(@Nullable Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11, int i12) {
        int i13;
        int i14;
        Composer startRestartGroup = composer.startRestartGroup(110140086);
        int i15 = i12 & 1;
        if (i15 != 0) {
            i13 = i11 | 6;
        } else if ((i11 & 14) == 0) {
            if (startRestartGroup.changed((Object) function2)) {
                i14 = 4;
            } else {
                i14 = 2;
            }
            i13 = i14 | i11;
        } else {
            i13 = i11;
        }
        if ((2 ^ (i13 & 11)) != 0 || !startRestartGroup.getSkipping()) {
            if (i15 != 0) {
                function2 = null;
            }
            if (function2 == null) {
                startRestartGroup.startReplaceableGroup(-880621033);
            } else {
                startRestartGroup.startReplaceableGroup(110140202);
                Modifier.Companion companion = Modifier.Companion;
                Modifier semantics$default = SemanticsModifierKt.semantics$default(companion, false, ListItemComposablesKt$ListItemTrailingContainer$1$1.INSTANCE, 1, (Object) null);
                startRestartGroup.startReplaceableGroup(-1989997546);
                MeasurePolicy rowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.Companion.getTop(), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(1376089335);
                Density density = (Density) startRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
                LayoutDirection layoutDirection = (LayoutDirection) startRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
                ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
                Function0<ComposeUiNode> constructor = companion2.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> materializerOf = LayoutKt.materializerOf(semantics$default);
                if (!(startRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                startRestartGroup.startReusableNode();
                if (startRestartGroup.getInserting()) {
                    startRestartGroup.createNode(constructor);
                } else {
                    startRestartGroup.useNode();
                }
                startRestartGroup.disableReusing();
                Composer r82 = Updater.m2536constructorimpl(startRestartGroup);
                Updater.m2543setimpl(r82, rowMeasurePolicy, companion2.getSetMeasurePolicy());
                Updater.m2543setimpl(r82, density, companion2.getSetDensity());
                Updater.m2543setimpl(r82, layoutDirection, companion2.getSetLayoutDirection());
                startRestartGroup.enableReusing();
                materializerOf.invoke(SkippableUpdater.m2526boximpl(SkippableUpdater.m2527constructorimpl(startRestartGroup)), startRestartGroup, 0);
                startRestartGroup.startReplaceableGroup(2058660585);
                startRestartGroup.startReplaceableGroup(-326682743);
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                SpacerKt.Spacer(SizeKt.m563width3ABfNKs(companion, DSTheme.INSTANCE.getDimens(startRestartGroup, 0).m8844getDsXsD9Ej5fM()), startRestartGroup, 0);
                function2.invoke(startRestartGroup, Integer.valueOf(i13 & 14));
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endNode();
                startRestartGroup.endReplaceableGroup();
                startRestartGroup.endReplaceableGroup();
            }
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ListItemComposablesKt$ListItemTrailingContainer$2(function2, i11, i12));
        }
    }

    @NotNull
    @Stable
    public static final Modifier tappable(@NotNull Modifier modifier, @NotNull MutableInteractionSource mutableInteractionSource, @NotNull Indication indication, @Nullable Function0<Unit> function0, boolean z11) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "interactionSource");
        Intrinsics.checkNotNullParameter(indication, "indication");
        if (function0 == null || !z11) {
            return modifier;
        }
        return modifier.then(ClickableKt.m194clickableO2vRcR0$default(modifier, mutableInteractionSource, indication, false, (String) null, Role.m4904boximpl(Role.Companion.m4911getButtono7Vup1c()), new ListItemComposablesKt$tappable$1(function0), 12, (Object) null));
    }
}
