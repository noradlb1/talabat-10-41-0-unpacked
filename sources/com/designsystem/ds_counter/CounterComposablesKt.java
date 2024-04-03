package com.designsystem.ds_counter;

import android.content.res.Configuration;
import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.material.SurfaceKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.designsystem.ds_theme.DSTheme;
import com.designsystem.extensions.ConfigurationExtensionsKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a]\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001aY\u0010\u0012\u001a\u00020\u00032\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001eH\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001f\u0010 \u001am\u0010!\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\b2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010$\u001aI\u0010%\u001a\u00020\u00032\u0006\u0010&\u001a\u00020'2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u00072\u0006\u0010)\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u001cH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010+\u001a\u0011\u0010,\u001a\b\u0012\u0004\u0012\u00020\b0-H\u0002ø\u0001\u0000\u001a%\u0010.\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u00052\u0006\u00100\u001a\u00020\bH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b1\u00102\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u00063"}, d2 = {"CounterAnimationDuration", "", "CounterAnimation", "", "counterChange", "Lcom/designsystem/ds_counter/CounterChange;", "animateOutOffset", "Landroidx/compose/animation/core/Animatable;", "Landroidx/compose/ui/unit/Dp;", "Landroidx/compose/animation/core/AnimationVector1D;", "animateInOffset", "newLabel", "", "maxHeight", "animate", "", "CounterAnimation-FJfuzF0", "(Lcom/designsystem/ds_counter/CounterChange;Landroidx/compose/animation/core/Animatable;Landroidx/compose/animation/core/Animatable;Ljava/lang/String;FZLandroidx/compose/runtime/Composer;I)V", "CounterComposables", "modifier", "Landroidx/compose/ui/Modifier;", "value", "labelColor", "Landroidx/compose/ui/graphics/Color;", "containerColor", "minWidth", "minHeight", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "shape", "Landroidx/compose/ui/graphics/Shape;", "CounterComposables-T9BRK9s", "(Landroidx/compose/ui/Modifier;IJJFFLandroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "CounterLabels", "oldLabel", "CounterLabels-QCWCmTk", "(Landroidx/compose/ui/Modifier;Lcom/designsystem/ds_counter/CounterChange;ZLjava/lang/String;Ljava/lang/String;JJFFLandroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "CounterText", "scope", "Landroidx/compose/foundation/layout/BoxWithConstraintsScope;", "offsetAnimatable", "text", "CounterText-ww6aTOc", "(Landroidx/compose/foundation/layout/BoxWithConstraintsScope;Landroidx/compose/animation/core/Animatable;Ljava/lang/String;JLandroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;I)V", "counterAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "getAnimateOutTargetValue", "change", "height", "getAnimateOutTargetValue-3ABfNKs", "(Lcom/designsystem/ds_counter/CounterChange;F)F", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class CounterComposablesKt {
    private static final int CounterAnimationDuration = 200;

    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CounterChange.values().length];
            iArr[CounterChange.INCREASE.ordinal()] = 1;
            iArr[CounterChange.DECREASE.ordinal()] = 2;
            iArr[CounterChange.INITIAL.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* access modifiers changed from: private */
    @Composable
    /* renamed from: CounterAnimation-FJfuzF0  reason: not valid java name */
    public static final void m8318CounterAnimationFJfuzF0(CounterChange counterChange, Animatable<Dp, AnimationVector1D> animatable, Animatable<Dp, AnimationVector1D> animatable2, String str, float f11, boolean z11, Composer composer, int i11) {
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        CounterChange counterChange2 = counterChange;
        Animatable<Dp, AnimationVector1D> animatable3 = animatable;
        Animatable<Dp, AnimationVector1D> animatable4 = animatable2;
        String str2 = str;
        float f12 = f11;
        boolean z12 = z11;
        int i19 = i11;
        Composer startRestartGroup = composer.startRestartGroup(-2087963529);
        if ((i19 & 14) == 0) {
            if (startRestartGroup.changed((Object) counterChange)) {
                i18 = 4;
            } else {
                i18 = 2;
            }
            i12 = i18 | i19;
        } else {
            i12 = i19;
        }
        if ((i19 & 112) == 0) {
            if (startRestartGroup.changed((Object) animatable)) {
                i17 = 32;
            } else {
                i17 = 16;
            }
            i12 |= i17;
        }
        if ((i19 & 896) == 0) {
            if (startRestartGroup.changed((Object) animatable2)) {
                i16 = 256;
            } else {
                i16 = 128;
            }
            i12 |= i16;
        }
        if ((i19 & 7168) == 0) {
            if (startRestartGroup.changed((Object) str)) {
                i15 = 2048;
            } else {
                i15 = 1024;
            }
            i12 |= i15;
        }
        if ((57344 & i19) == 0) {
            if (startRestartGroup.changed(f11)) {
                i14 = 16384;
            } else {
                i14 = 8192;
            }
            i12 |= i14;
        }
        if ((458752 & i19) == 0) {
            if (startRestartGroup.changed(z12)) {
                i13 = 131072;
            } else {
                i13 = 65536;
            }
            i12 |= i13;
        }
        if (((374491 & i12) ^ 74898) == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else if (!z12) {
            ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
            if (endRestartGroup != null) {
                endRestartGroup.updateScope(new CounterComposablesKt$CounterAnimation$1(counterChange, animatable, animatable2, str, f11, z11, i11));
                return;
            }
            return;
        } else {
            int i21 = (i12 >> 9) & 14;
            EffectsKt.LaunchedEffect((Object) str, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new CounterComposablesKt$CounterAnimation$2(animatable, counterChange, f11, (Continuation<? super CounterComposablesKt$CounterAnimation$2>) null), startRestartGroup, i21);
            EffectsKt.LaunchedEffect((Object) str, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new CounterComposablesKt$CounterAnimation$3(counterChange, f11, animatable2, (Continuation<? super CounterComposablesKt$CounterAnimation$3>) null), startRestartGroup, i21);
        }
        ScopeUpdateScope endRestartGroup2 = startRestartGroup.endRestartGroup();
        if (endRestartGroup2 != null) {
            endRestartGroup2.updateScope(new CounterComposablesKt$CounterAnimation$4(counterChange, animatable, animatable2, str, f11, z11, i11));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:135:0x025a  */
    /* JADX WARNING: Removed duplicated region for block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00c4  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00df  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x00f5  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x010a  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0112  */
    @androidx.compose.runtime.Composable
    /* renamed from: CounterComposables-T9BRK9s  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m8319CounterComposablesT9BRK9s(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r23, int r24, long r25, long r27, float r29, float r30, @org.jetbrains.annotations.NotNull androidx.compose.ui.text.TextStyle r31, @org.jetbrains.annotations.Nullable androidx.compose.ui.graphics.Shape r32, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r33, int r34, int r35) {
        /*
            r2 = r24
            r1 = r31
            r0 = r34
            r15 = r35
            java.lang.String r3 = "textStyle"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            r3 = 1849875340(0x6e42db8c, float:1.5076377E28)
            r4 = r33
            androidx.compose.runtime.Composer r14 = r4.startRestartGroup(r3)
            r3 = r15 & 1
            if (r3 == 0) goto L_0x0020
            r5 = r0 | 6
            r6 = r5
            r5 = r23
            goto L_0x0034
        L_0x0020:
            r5 = r0 & 14
            if (r5 != 0) goto L_0x0031
            r5 = r23
            boolean r6 = r14.changed((java.lang.Object) r5)
            if (r6 == 0) goto L_0x002e
            r6 = 4
            goto L_0x002f
        L_0x002e:
            r6 = 2
        L_0x002f:
            r6 = r6 | r0
            goto L_0x0034
        L_0x0031:
            r5 = r23
            r6 = r0
        L_0x0034:
            r7 = r15 & 2
            if (r7 == 0) goto L_0x003b
            r6 = r6 | 48
            goto L_0x004b
        L_0x003b:
            r7 = r0 & 112(0x70, float:1.57E-43)
            if (r7 != 0) goto L_0x004b
            boolean r7 = r14.changed((int) r2)
            if (r7 == 0) goto L_0x0048
            r7 = 32
            goto L_0x004a
        L_0x0048:
            r7 = 16
        L_0x004a:
            r6 = r6 | r7
        L_0x004b:
            r7 = r15 & 4
            if (r7 == 0) goto L_0x0054
            r6 = r6 | 384(0x180, float:5.38E-43)
            r12 = r25
            goto L_0x0066
        L_0x0054:
            r7 = r0 & 896(0x380, float:1.256E-42)
            r12 = r25
            if (r7 != 0) goto L_0x0066
            boolean r7 = r14.changed((long) r12)
            if (r7 == 0) goto L_0x0063
            r7 = 256(0x100, float:3.59E-43)
            goto L_0x0065
        L_0x0063:
            r7 = 128(0x80, float:1.794E-43)
        L_0x0065:
            r6 = r6 | r7
        L_0x0066:
            r7 = r15 & 8
            if (r7 == 0) goto L_0x006f
            r6 = r6 | 3072(0xc00, float:4.305E-42)
            r10 = r27
            goto L_0x0081
        L_0x006f:
            r7 = r0 & 7168(0x1c00, float:1.0045E-41)
            r10 = r27
            if (r7 != 0) goto L_0x0081
            boolean r7 = r14.changed((long) r10)
            if (r7 == 0) goto L_0x007e
            r7 = 2048(0x800, float:2.87E-42)
            goto L_0x0080
        L_0x007e:
            r7 = 1024(0x400, float:1.435E-42)
        L_0x0080:
            r6 = r6 | r7
        L_0x0081:
            r7 = r15 & 16
            if (r7 == 0) goto L_0x008a
            r6 = r6 | 24576(0x6000, float:3.4438E-41)
            r8 = r29
            goto L_0x009e
        L_0x008a:
            r7 = 57344(0xe000, float:8.0356E-41)
            r7 = r7 & r0
            r8 = r29
            if (r7 != 0) goto L_0x009e
            boolean r7 = r14.changed((float) r8)
            if (r7 == 0) goto L_0x009b
            r7 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009d
        L_0x009b:
            r7 = 8192(0x2000, float:1.14794E-41)
        L_0x009d:
            r6 = r6 | r7
        L_0x009e:
            r7 = r15 & 32
            r9 = 458752(0x70000, float:6.42848E-40)
            if (r7 == 0) goto L_0x00a8
            r7 = 196608(0x30000, float:2.75506E-40)
            r6 = r6 | r7
            goto L_0x00bc
        L_0x00a8:
            r7 = r0 & r9
            if (r7 != 0) goto L_0x00bc
            r7 = r30
            boolean r16 = r14.changed((float) r7)
            if (r16 == 0) goto L_0x00b7
            r16 = 131072(0x20000, float:1.83671E-40)
            goto L_0x00b9
        L_0x00b7:
            r16 = 65536(0x10000, float:9.18355E-41)
        L_0x00b9:
            r6 = r6 | r16
            goto L_0x00be
        L_0x00bc:
            r7 = r30
        L_0x00be:
            r16 = r15 & 64
            r17 = 3670016(0x380000, float:5.142788E-39)
            if (r16 == 0) goto L_0x00c9
            r16 = 1572864(0x180000, float:2.204052E-39)
        L_0x00c6:
            r6 = r6 | r16
            goto L_0x00d9
        L_0x00c9:
            r16 = r0 & r17
            if (r16 != 0) goto L_0x00d9
            boolean r16 = r14.changed((java.lang.Object) r1)
            if (r16 == 0) goto L_0x00d6
            r16 = 1048576(0x100000, float:1.469368E-39)
            goto L_0x00c6
        L_0x00d6:
            r16 = 524288(0x80000, float:7.34684E-40)
            goto L_0x00c6
        L_0x00d9:
            r16 = 29360128(0x1c00000, float:7.052966E-38)
            r18 = r0 & r16
            if (r18 != 0) goto L_0x00f5
            r9 = r15 & 128(0x80, float:1.794E-43)
            if (r9 != 0) goto L_0x00ee
            r9 = r32
            boolean r18 = r14.changed((java.lang.Object) r9)
            if (r18 == 0) goto L_0x00f0
            r18 = 8388608(0x800000, float:1.17549435E-38)
            goto L_0x00f2
        L_0x00ee:
            r9 = r32
        L_0x00f0:
            r18 = 4194304(0x400000, float:5.877472E-39)
        L_0x00f2:
            r6 = r6 | r18
            goto L_0x00f7
        L_0x00f5:
            r9 = r32
        L_0x00f7:
            r18 = 23967451(0x16db6db, float:4.3661218E-38)
            r18 = r6 & r18
            r19 = 4793490(0x492492, float:6.71711E-39)
            r18 = r18 ^ r19
            if (r18 != 0) goto L_0x0112
            boolean r18 = r14.getSkipping()
            if (r18 != 0) goto L_0x010a
            goto L_0x0112
        L_0x010a:
            r14.skipToGroupEnd()
            r1 = r5
            r10 = r9
            r0 = r14
            goto L_0x0253
        L_0x0112:
            r18 = r0 & 1
            r19 = -29360129(0xfffffffffe3fffff, float:-6.380294E37)
            r4 = 0
            if (r18 == 0) goto L_0x012f
            boolean r18 = r14.getDefaultsInvalid()
            if (r18 == 0) goto L_0x0121
            goto L_0x012f
        L_0x0121:
            r14.skipCurrentGroup()
            r3 = r15 & 128(0x80, float:1.794E-43)
            if (r3 == 0) goto L_0x012a
            r6 = r6 & r19
        L_0x012a:
            r19 = r5
            r21 = r9
            goto L_0x0155
        L_0x012f:
            r14.startDefaults()
            if (r3 == 0) goto L_0x0137
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            goto L_0x0138
        L_0x0137:
            r3 = r5
        L_0x0138:
            r5 = r15 & 128(0x80, float:1.794E-43)
            if (r5 == 0) goto L_0x014d
            com.designsystem.ds_theme.DSTheme r5 = com.designsystem.ds_theme.DSTheme.INSTANCE
            com.designsystem.ds_theme.DSDimens r5 = r5.getDimens(r14, r4)
            float r5 = r5.m8846getDsXxsD9Ej5fM()
            androidx.compose.foundation.shape.RoundedCornerShape r5 = androidx.compose.foundation.shape.RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(r5)
            r6 = r6 & r19
            goto L_0x014e
        L_0x014d:
            r5 = r9
        L_0x014e:
            r14.endDefaults()
            r19 = r3
            r21 = r5
        L_0x0155:
            r3 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r14.startReplaceableGroup(r3)
            java.lang.Object r5 = r14.rememberedValue()
            androidx.compose.runtime.Composer$Companion r9 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r4 = r9.getEmpty()
            r3 = 0
            if (r5 != r4) goto L_0x0178
            com.designsystem.ds_counter.CounterChange r4 = com.designsystem.ds_counter.CounterChange.INITIAL
            r5 = 2
            androidx.compose.runtime.MutableState r4 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r4, r3, r5, r3)
            r14.updateRememberedValue(r4)
            r22 = r5
            r5 = r4
            r4 = r22
            goto L_0x0179
        L_0x0178:
            r4 = 2
        L_0x0179:
            r14.endReplaceableGroup()
            androidx.compose.runtime.MutableState r5 = (androidx.compose.runtime.MutableState) r5
            r3 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r14.startReplaceableGroup(r3)
            java.lang.Object r3 = r14.rememberedValue()
            java.lang.Object r4 = r9.getEmpty()
            if (r3 != r4) goto L_0x019c
            java.lang.Integer r3 = java.lang.Integer.valueOf(r24)
            r0 = 0
            r4 = 2
            androidx.compose.runtime.MutableState r3 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r3, r0, r4, r0)
            r14.updateRememberedValue(r3)
            goto L_0x019e
        L_0x019c:
            r0 = 0
            r4 = 2
        L_0x019e:
            r14.endReplaceableGroup()
            androidx.compose.runtime.MutableState r3 = (androidx.compose.runtime.MutableState) r3
            r0 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r14.startReplaceableGroup(r0)
            java.lang.Object r0 = r14.rememberedValue()
            java.lang.Object r9 = r9.getEmpty()
            if (r0 != r9) goto L_0x01c0
            r9 = 0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r9)
            r9 = 0
            androidx.compose.runtime.MutableState r0 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r0, r9, r4, r9)
            r14.updateRememberedValue(r0)
        L_0x01c0:
            r14.endReplaceableGroup()
            androidx.compose.runtime.MutableState r0 = (androidx.compose.runtime.MutableState) r0
            int r4 = m8322CounterComposables_T9BRK9s$lambda4(r3)
            if (r2 == r4) goto L_0x01e3
            int r4 = m8322CounterComposables_T9BRK9s$lambda4(r3)
            if (r2 <= r4) goto L_0x01d4
            com.designsystem.ds_counter.CounterChange r4 = com.designsystem.ds_counter.CounterChange.INCREASE
            goto L_0x01d6
        L_0x01d4:
            com.designsystem.ds_counter.CounterChange r4 = com.designsystem.ds_counter.CounterChange.DECREASE
        L_0x01d6:
            m8321CounterComposables_T9BRK9s$lambda2(r5, r4)
            int r4 = m8322CounterComposables_T9BRK9s$lambda4(r3)
            m8325CounterComposables_T9BRK9s$lambda8(r0, r4)
            m8323CounterComposables_T9BRK9s$lambda5(r3, r2)
        L_0x01e3:
            com.designsystem.ds_counter.CounterChange r4 = m8320CounterComposables_T9BRK9s$lambda1(r5)
            com.designsystem.ds_counter.CounterChange r9 = com.designsystem.ds_counter.CounterChange.INCREASE
            r20 = 1
            r1 = 99
            if (r4 != r9) goto L_0x01f7
            int r4 = m8322CounterComposables_T9BRK9s$lambda4(r3)
            int r4 = r4 + -1
            if (r4 < r1) goto L_0x0208
        L_0x01f7:
            com.designsystem.ds_counter.CounterChange r4 = m8320CounterComposables_T9BRK9s$lambda1(r5)
            com.designsystem.ds_counter.CounterChange r9 = com.designsystem.ds_counter.CounterChange.DECREASE
            if (r4 != r9) goto L_0x0206
            int r4 = m8322CounterComposables_T9BRK9s$lambda4(r3)
            if (r4 >= r1) goto L_0x0206
            goto L_0x0208
        L_0x0206:
            r20 = 0
        L_0x0208:
            int r3 = m8322CounterComposables_T9BRK9s$lambda4(r3)
            java.lang.String r9 = com.designsystem.extensions.IntExtensionsKt.toCountString(r3, r1)
            int r0 = m8324CounterComposables_T9BRK9s$lambda7(r0)
            java.lang.String r0 = com.designsystem.extensions.IntExtensionsKt.toCountString(r0, r1)
            com.designsystem.ds_counter.CounterChange r4 = m8320CounterComposables_T9BRK9s$lambda1(r5)
            r1 = r6 & 14
            int r3 = r6 << 9
            r5 = 458752(0x70000, float:6.42848E-40)
            r5 = r5 & r3
            r1 = r1 | r5
            r5 = r3 & r17
            r1 = r1 | r5
            r5 = r3 & r16
            r1 = r1 | r5
            r5 = 234881024(0xe000000, float:1.5777218E-30)
            r5 = r5 & r3
            r1 = r1 | r5
            r5 = 1879048192(0x70000000, float:1.58456325E29)
            r3 = r3 & r5
            r17 = r1 | r3
            int r1 = r6 >> 21
            r18 = r1 & 14
            r3 = r19
            r5 = r20
            r6 = r9
            r7 = r0
            r8 = r25
            r10 = r27
            r12 = r29
            r13 = r30
            r0 = r14
            r14 = r31
            r15 = r21
            r16 = r0
            m8326CounterLabelsQCWCmTk(r3, r4, r5, r6, r7, r8, r10, r12, r13, r14, r15, r16, r17, r18)
            r1 = r19
            r10 = r21
        L_0x0253:
            androidx.compose.runtime.ScopeUpdateScope r13 = r0.endRestartGroup()
            if (r13 != 0) goto L_0x025a
            goto L_0x0273
        L_0x025a:
            com.designsystem.ds_counter.CounterComposablesKt$CounterComposables$1 r14 = new com.designsystem.ds_counter.CounterComposablesKt$CounterComposables$1
            r0 = r14
            r2 = r24
            r3 = r25
            r5 = r27
            r7 = r29
            r8 = r30
            r9 = r31
            r11 = r34
            r12 = r35
            r0.<init>(r1, r2, r3, r5, r7, r8, r9, r10, r11, r12)
            r13.updateScope(r14)
        L_0x0273:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_counter.CounterComposablesKt.m8319CounterComposablesT9BRK9s(androidx.compose.ui.Modifier, int, long, long, float, float, androidx.compose.ui.text.TextStyle, androidx.compose.ui.graphics.Shape, androidx.compose.runtime.Composer, int, int):void");
    }

    /* renamed from: CounterComposables_T9BRK9s$lambda-1  reason: not valid java name */
    private static final CounterChange m8320CounterComposables_T9BRK9s$lambda1(MutableState<CounterChange> mutableState) {
        return mutableState.getValue();
    }

    /* renamed from: CounterComposables_T9BRK9s$lambda-2  reason: not valid java name */
    private static final void m8321CounterComposables_T9BRK9s$lambda2(MutableState<CounterChange> mutableState, CounterChange counterChange) {
        mutableState.setValue(counterChange);
    }

    /* renamed from: CounterComposables_T9BRK9s$lambda-4  reason: not valid java name */
    private static final int m8322CounterComposables_T9BRK9s$lambda4(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* renamed from: CounterComposables_T9BRK9s$lambda-5  reason: not valid java name */
    private static final void m8323CounterComposables_T9BRK9s$lambda5(MutableState<Integer> mutableState, int i11) {
        mutableState.setValue(Integer.valueOf(i11));
    }

    /* renamed from: CounterComposables_T9BRK9s$lambda-7  reason: not valid java name */
    private static final int m8324CounterComposables_T9BRK9s$lambda7(MutableState<Integer> mutableState) {
        return mutableState.getValue().intValue();
    }

    /* renamed from: CounterComposables_T9BRK9s$lambda-8  reason: not valid java name */
    private static final void m8325CounterComposables_T9BRK9s$lambda8(MutableState<Integer> mutableState, int i11) {
        mutableState.setValue(Integer.valueOf(i11));
    }

    /* access modifiers changed from: private */
    @Composable
    /* renamed from: CounterLabels-QCWCmTk  reason: not valid java name */
    public static final void m8326CounterLabelsQCWCmTk(Modifier modifier, CounterChange counterChange, boolean z11, String str, String str2, long j11, long j12, float f11, float f12, TextStyle textStyle, Shape shape, Composer composer, int i11, int i12) {
        int i13;
        int i14;
        int i15 = i11;
        Composer startRestartGroup = composer.startRestartGroup(625565173);
        int i16 = 4;
        Modifier modifier2 = modifier;
        if ((i15 & 14) == 0) {
            i13 = (startRestartGroup.changed((Object) modifier2) ? 4 : 2) | i15;
        } else {
            i13 = i15;
        }
        CounterChange counterChange2 = counterChange;
        if ((i15 & 112) == 0) {
            i13 |= startRestartGroup.changed((Object) counterChange2) ? 32 : 16;
        }
        boolean z12 = z11;
        if ((i15 & 896) == 0) {
            i13 |= startRestartGroup.changed(z12) ? 256 : 128;
        }
        String str3 = str;
        if ((i15 & 7168) == 0) {
            i13 |= startRestartGroup.changed((Object) str3) ? 2048 : 1024;
        }
        String str4 = str2;
        if ((57344 & i15) == 0) {
            i13 |= startRestartGroup.changed((Object) str4) ? 16384 : 8192;
        }
        long j13 = j11;
        if ((458752 & i15) == 0) {
            i13 |= startRestartGroup.changed(j13) ? 131072 : 65536;
        }
        long j14 = j12;
        if ((3670016 & i15) == 0) {
            i13 |= startRestartGroup.changed(j14) ? 1048576 : 524288;
        }
        if ((29360128 & i15) == 0) {
            i13 |= startRestartGroup.changed(f11) ? 8388608 : 4194304;
        } else {
            float f13 = f11;
        }
        if ((234881024 & i15) == 0) {
            i13 |= startRestartGroup.changed(f12) ? 67108864 : 33554432;
        } else {
            float f14 = f12;
        }
        TextStyle textStyle2 = textStyle;
        if ((i15 & 1879048192) == 0) {
            i13 |= startRestartGroup.changed((Object) textStyle2) ? 536870912 : 268435456;
        }
        Shape shape2 = shape;
        if ((i12 & 14) == 0) {
            if (!startRestartGroup.changed((Object) shape2)) {
                i16 = 2;
            }
            i14 = i12 | i16;
        } else {
            i14 = i12;
        }
        if (((i13 & 1533916891) ^ 306783378) == 0 && ((i14 & 11) ^ 2) == 0 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else {
            SurfaceKt.m1384SurfaceFjzlyU(modifier, shape, j12, 0, (BorderStroke) null, 0.0f, ComposableLambdaKt.composableLambda(startRestartGroup, -819893296, true, new CounterComposablesKt$CounterLabels$1(f12, f11, counterChange, str, z11, i13, str2, j11, textStyle)), startRestartGroup, ((i14 << 3) & 112) | 1572864 | (i13 & 14) | ((i13 >> 12) & 896), 56);
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            CounterComposablesKt$CounterLabels$2 counterComposablesKt$CounterLabels$2 = r0;
            CounterComposablesKt$CounterLabels$2 counterComposablesKt$CounterLabels$22 = new CounterComposablesKt$CounterLabels$2(modifier, counterChange, z11, str, str2, j11, j12, f11, f12, textStyle, shape, i11, i12);
            endRestartGroup.updateScope(counterComposablesKt$CounterLabels$2);
        }
    }

    /* access modifiers changed from: private */
    @Composable
    /* renamed from: CounterText-ww6aTOc  reason: not valid java name */
    public static final void m8327CounterTextww6aTOc(BoxWithConstraintsScope boxWithConstraintsScope, Animatable<Dp, AnimationVector1D> animatable, String str, long j11, TextStyle textStyle, Composer composer, int i11) {
        int i12;
        float f11;
        float f12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18 = i11;
        Composer startRestartGroup = composer.startRestartGroup(57346693);
        if ((i18 & 14) == 0) {
            if (startRestartGroup.changed((Object) boxWithConstraintsScope)) {
                i17 = 4;
            } else {
                i17 = 2;
            }
            i12 = i17 | i18;
        } else {
            BoxWithConstraintsScope boxWithConstraintsScope2 = boxWithConstraintsScope;
            i12 = i18;
        }
        if ((i18 & 112) == 0) {
            if (startRestartGroup.changed((Object) animatable)) {
                i16 = 32;
            } else {
                i16 = 16;
            }
            i12 |= i16;
        } else {
            Animatable<Dp, AnimationVector1D> animatable2 = animatable;
        }
        if ((i18 & 896) == 0) {
            if (startRestartGroup.changed((Object) str)) {
                i15 = 256;
            } else {
                i15 = 128;
            }
            i12 |= i15;
        } else {
            String str2 = str;
        }
        if ((i18 & 7168) == 0) {
            if (startRestartGroup.changed(j11)) {
                i14 = 2048;
            } else {
                i14 = 1024;
            }
            i12 |= i14;
        } else {
            long j12 = j11;
        }
        TextStyle textStyle2 = textStyle;
        if ((57344 & i18) == 0) {
            if (startRestartGroup.changed((Object) textStyle2)) {
                i13 = 16384;
            } else {
                i13 = 8192;
            }
            i12 |= i13;
        }
        int i19 = i12;
        if (((i19 & 46811) ^ 9362) != 0 || !startRestartGroup.getSkipping()) {
            float f13 = (float) 0;
            boolean r22 = Dp.m5483equalsimpl0(animatable.getTargetValue().m5492unboximpl(), Dp.m5478constructorimpl(f13));
            if (str.length() <= 1 || !r22) {
                startRestartGroup.startReplaceableGroup(-778600824);
                startRestartGroup.endReplaceableGroup();
                f11 = Dp.m5478constructorimpl(f13);
            } else {
                startRestartGroup.startReplaceableGroup(-778600838);
                f11 = DSTheme.INSTANCE.getDimens(startRestartGroup, 0).m8848getDsXxxsD9Ej5fM();
                startRestartGroup.endReplaceableGroup();
            }
            float f14 = f11;
            if (ConfigurationExtensionsKt.isArabicLanguage((Configuration) startRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalConfiguration()))) {
                f12 = Dp.m5478constructorimpl((float) 1);
            } else {
                f12 = Dp.m5478constructorimpl(f13);
            }
            float f15 = f12;
            ProvidedValue[] providedValueArr = {CompositionLocalsKt.getLocalLayoutDirection().provides(LayoutDirection.Ltr)};
            CounterComposablesKt$CounterText$1$1 counterComposablesKt$CounterText$1$1 = r8;
            CounterComposablesKt$CounterText$1$1 counterComposablesKt$CounterText$1$12 = new CounterComposablesKt$CounterText$1$1(boxWithConstraintsScope, animatable, f15, f14, str, j11, textStyle, i19);
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -819891216, true, counterComposablesKt$CounterText$1$1), startRestartGroup, 56);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new CounterComposablesKt$CounterText$2(boxWithConstraintsScope, animatable, str, j11, textStyle, i11));
        }
    }

    /* access modifiers changed from: private */
    public static final TweenSpec<Dp> counterAnimationSpec() {
        return AnimationSpecKt.tween$default(200, 0, EasingKt.getLinearEasing(), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: getAnimateOutTargetValue-3ABfNKs  reason: not valid java name */
    public static final float m8332getAnimateOutTargetValue3ABfNKs(CounterChange counterChange, float f11) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[counterChange.ordinal()];
        if (i11 == 1) {
            return Dp.m5478constructorimpl(-f11);
        }
        if (i11 == 2) {
            return f11;
        }
        if (i11 == 3) {
            return Dp.m5478constructorimpl((float) 0);
        }
        throw new NoWhenBranchMatchedException();
    }
}
