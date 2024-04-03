package com.designsystem.ds_button_v2.composables;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.material.SurfaceKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ScaleKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import com.designsystem.ds_button_v2.DSButtonTheme;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000>\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aH\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\b2\u0011\u0010\f\u001a\r\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0002\b\u000eH\u0003¢\u0006\u0002\u0010\u000f\u001aN\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\u001d\u0010\f\u001a\u0019\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00040\u0011¢\u0006\u0002\b\u000eH\u0001¢\u0006\u0002\u0010\u0013\u001a\u001b\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00010\u00152\u0006\u0010\n\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\u0016\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"ButtonMaxScale", "", "ButtonPressedScale", "ButtonAnimatedShrinkSurface", "", "theme", "Lcom/designsystem/ds_button_v2/DSButtonTheme;", "isEnabled", "", "isLoading", "isPressed", "isShrinkable", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lcom/designsystem/ds_button_v2/DSButtonTheme;ZZZZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "DSAnimatedShrinkButton", "Lkotlin/Function2;", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lcom/designsystem/ds_button_v2/DSButtonTheme;ZZZLkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;II)V", "scale", "Landroidx/compose/runtime/State;", "(ZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSAnimatedShrinkButtonKt {
    private static final float ButtonMaxScale = 1.0f;
    private static final float ButtonPressedScale = 0.96f;

    /* access modifiers changed from: private */
    @Composable
    public static final void ButtonAnimatedShrinkSurface(DSButtonTheme dSButtonTheme, boolean z11, boolean z12, boolean z13, boolean z14, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i11) {
        int i12;
        Composer composer2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        DSButtonTheme dSButtonTheme2 = dSButtonTheme;
        boolean z15 = z11;
        boolean z16 = z13;
        boolean z17 = z14;
        int i19 = i11;
        Composer startRestartGroup = composer.startRestartGroup(82633378);
        if ((i19 & 14) == 0) {
            if (startRestartGroup.changed((Object) dSButtonTheme2)) {
                i18 = 4;
            } else {
                i18 = 2;
            }
            i12 = i18 | i19;
        } else {
            i12 = i19;
        }
        if ((i19 & 112) == 0) {
            if (startRestartGroup.changed(z15)) {
                i17 = 32;
            } else {
                i17 = 16;
            }
            i12 |= i17;
        }
        boolean z18 = z12;
        if ((i19 & 896) == 0) {
            if (startRestartGroup.changed(z18)) {
                i16 = 256;
            } else {
                i16 = 128;
            }
            i12 |= i16;
        }
        if ((i19 & 7168) == 0) {
            if (startRestartGroup.changed(z16)) {
                i15 = 2048;
            } else {
                i15 = 1024;
            }
            i12 |= i15;
        }
        if ((57344 & i19) == 0) {
            if (startRestartGroup.changed(z17)) {
                i14 = 16384;
            } else {
                i14 = 8192;
            }
            i12 |= i14;
        }
        Function2<? super Composer, ? super Integer, Unit> function22 = function2;
        if ((458752 & i19) == 0) {
            if (startRestartGroup.changed((Object) function22)) {
                i13 = 131072;
            } else {
                i13 = 65536;
            }
            i12 |= i13;
        }
        int i21 = i12;
        if (((i21 & 374491) ^ 74898) != 0 || !startRestartGroup.getSkipping()) {
            int i22 = (i21 >> 9) & 14;
            Composer composer3 = startRestartGroup;
            State<Float> animateFloatAsState = AnimateAsStateKt.animateFloatAsState(scale(z16, startRestartGroup, i22).getValue().floatValue(), ButtonComposablesKt.buttonAnimationSpec(ButtonComposablesKt.buttonAnimationEasing(z16, startRestartGroup, i22).getValue(), startRestartGroup, 0), 0.0f, (Function1<? super Float, Unit>) null, composer3, 0, 12);
            int i23 = i21 >> 3;
            int i24 = i23 & 14;
            long r11 = dSButtonTheme.backgroundColor(z11, z12, z13, startRestartGroup, ((i21 << 9) & 7168) | (i23 & 896) | i24 | (i23 & 112)).getValue().m2929unboximpl();
            composer2 = composer3;
            State<Color> r12 = SingleValueAnimationKt.m86animateColorAsStateKTwxG1Y(r11, ButtonComposablesKt.buttonAnimationSpec(ButtonComposablesKt.buttonAnimationEasing(z16, composer3, i22).getValue(), composer3, 0), (Function1<? super Color, Unit>) null, composer3, 0, 4);
            Shape shape = dSButtonTheme2.shape(composer2, i21 & 14);
            long r13 = m8299ButtonAnimatedShrinkSurface$lambda6(r12);
            int i25 = i21 << 3;
            BorderStroke value = dSButtonTheme2.borderStroke(z15, composer2, i24 | (i25 & 112)).getValue();
            Modifier modifier = Modifier.Companion;
            if (z17) {
                modifier = ScaleKt.scale(modifier, m8298ButtonAnimatedShrinkSurface$lambda5(animateFloatAsState));
            }
            SurfaceKt.m1384SurfaceFjzlyU(modifier, shape, r13, 0, value, 0.0f, function2, composer2, i25 & 3670016, 40);
        } else {
            startRestartGroup.skipToGroupEnd();
            composer2 = startRestartGroup;
        }
        ScopeUpdateScope endRestartGroup = composer2.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new DSAnimatedShrinkButtonKt$ButtonAnimatedShrinkSurface$1(dSButtonTheme, z11, z12, z13, z14, function2, i11));
        }
    }

    /* renamed from: ButtonAnimatedShrinkSurface$lambda-5  reason: not valid java name */
    private static final float m8298ButtonAnimatedShrinkSurface$lambda5(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* renamed from: ButtonAnimatedShrinkSurface$lambda-6  reason: not valid java name */
    private static final long m8299ButtonAnimatedShrinkSurface$lambda6(State<Color> state) {
        return state.getValue().m2929unboximpl();
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008d  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00b2  */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0153  */
    /* JADX WARNING: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void DSAnimatedShrinkButton(@org.jetbrains.annotations.NotNull com.designsystem.ds_button_v2.DSButtonTheme r16, boolean r17, boolean r18, boolean r19, @org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function4<? super java.lang.Boolean, ? super androidx.compose.foundation.interaction.MutableInteractionSource, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r20, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r21, int r22, int r23) {
        /*
            r8 = r16
            r9 = r20
            r10 = r22
            java.lang.String r0 = "theme"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r0 = "content"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r0)
            r0 = -2048686124(0xffffffff85e387d4, float:-2.1396873E-35)
            r1 = r21
            androidx.compose.runtime.Composer r11 = r1.startRestartGroup(r0)
            r0 = r23 & 1
            r1 = 2
            if (r0 == 0) goto L_0x0021
            r0 = r10 | 6
            goto L_0x0031
        L_0x0021:
            r0 = r10 & 14
            if (r0 != 0) goto L_0x0030
            boolean r0 = r11.changed((java.lang.Object) r8)
            if (r0 == 0) goto L_0x002d
            r0 = 4
            goto L_0x002e
        L_0x002d:
            r0 = r1
        L_0x002e:
            r0 = r0 | r10
            goto L_0x0031
        L_0x0030:
            r0 = r10
        L_0x0031:
            r2 = r23 & 2
            if (r2 == 0) goto L_0x003a
            r0 = r0 | 48
            r12 = r17
            goto L_0x004c
        L_0x003a:
            r2 = r10 & 112(0x70, float:1.57E-43)
            r12 = r17
            if (r2 != 0) goto L_0x004c
            boolean r2 = r11.changed((boolean) r12)
            if (r2 == 0) goto L_0x0049
            r2 = 32
            goto L_0x004b
        L_0x0049:
            r2 = 16
        L_0x004b:
            r0 = r0 | r2
        L_0x004c:
            r2 = r23 & 4
            if (r2 == 0) goto L_0x0055
            r0 = r0 | 384(0x180, float:5.38E-43)
            r13 = r18
            goto L_0x0067
        L_0x0055:
            r2 = r10 & 896(0x380, float:1.256E-42)
            r13 = r18
            if (r2 != 0) goto L_0x0067
            boolean r2 = r11.changed((boolean) r13)
            if (r2 == 0) goto L_0x0064
            r2 = 256(0x100, float:3.59E-43)
            goto L_0x0066
        L_0x0064:
            r2 = 128(0x80, float:1.794E-43)
        L_0x0066:
            r0 = r0 | r2
        L_0x0067:
            r2 = r23 & 8
            if (r2 == 0) goto L_0x006e
            r0 = r0 | 3072(0xc00, float:4.305E-42)
            goto L_0x0081
        L_0x006e:
            r3 = r10 & 7168(0x1c00, float:1.0045E-41)
            if (r3 != 0) goto L_0x0081
            r3 = r19
            boolean r4 = r11.changed((boolean) r3)
            if (r4 == 0) goto L_0x007d
            r4 = 2048(0x800, float:2.87E-42)
            goto L_0x007f
        L_0x007d:
            r4 = 1024(0x400, float:1.435E-42)
        L_0x007f:
            r0 = r0 | r4
            goto L_0x0083
        L_0x0081:
            r3 = r19
        L_0x0083:
            r4 = r23 & 16
            r5 = 57344(0xe000, float:8.0356E-41)
            if (r4 == 0) goto L_0x008d
            r0 = r0 | 24576(0x6000, float:3.4438E-41)
            goto L_0x009d
        L_0x008d:
            r4 = r10 & r5
            if (r4 != 0) goto L_0x009d
            boolean r4 = r11.changed((java.lang.Object) r9)
            if (r4 == 0) goto L_0x009a
            r4 = 16384(0x4000, float:2.2959E-41)
            goto L_0x009c
        L_0x009a:
            r4 = 8192(0x2000, float:1.14794E-41)
        L_0x009c:
            r0 = r0 | r4
        L_0x009d:
            r4 = 46811(0xb6db, float:6.5596E-41)
            r4 = r4 & r0
            r4 = r4 ^ 9362(0x2492, float:1.3119E-41)
            if (r4 != 0) goto L_0x00b2
            boolean r4 = r11.getSkipping()
            if (r4 != 0) goto L_0x00ac
            goto L_0x00b2
        L_0x00ac:
            r11.skipToGroupEnd()
            r4 = r3
            goto L_0x014c
        L_0x00b2:
            r4 = 1
            if (r2 == 0) goto L_0x00b7
            r14 = r4
            goto L_0x00b8
        L_0x00b7:
            r14 = r3
        L_0x00b8:
            r2 = -3687241(0xffffffffffc7bcb7, float:NaN)
            r11.startReplaceableGroup(r2)
            java.lang.Object r3 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r6 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r7 = r6.getEmpty()
            if (r3 != r7) goto L_0x00d1
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = androidx.compose.foundation.interaction.InteractionSourceKt.MutableInteractionSource()
            r11.updateRememberedValue(r3)
        L_0x00d1:
            r11.endReplaceableGroup()
            androidx.compose.foundation.interaction.MutableInteractionSource r3 = (androidx.compose.foundation.interaction.MutableInteractionSource) r3
            r11.startReplaceableGroup(r2)
            java.lang.Object r2 = r11.rememberedValue()
            java.lang.Object r7 = r6.getEmpty()
            r15 = 0
            if (r2 != r7) goto L_0x00ed
            java.lang.Boolean r2 = java.lang.Boolean.FALSE
            androidx.compose.runtime.MutableState r2 = androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(r2, r15, r1, r15)
            r11.updateRememberedValue(r2)
        L_0x00ed:
            r11.endReplaceableGroup()
            androidx.compose.runtime.MutableState r2 = (androidx.compose.runtime.MutableState) r2
            r1 = -3686552(0xffffffffffc7bf68, float:NaN)
            r11.startReplaceableGroup(r1)
            boolean r1 = r11.changed((java.lang.Object) r3)
            boolean r7 = r11.changed((java.lang.Object) r2)
            r1 = r1 | r7
            java.lang.Object r7 = r11.rememberedValue()
            if (r1 != 0) goto L_0x010d
            java.lang.Object r1 = r6.getEmpty()
            if (r7 != r1) goto L_0x0115
        L_0x010d:
            com.designsystem.ds_button_v2.composables.DSAnimatedShrinkButtonKt$DSAnimatedShrinkButton$1$1 r7 = new com.designsystem.ds_button_v2.composables.DSAnimatedShrinkButtonKt$DSAnimatedShrinkButton$1$1
            r7.<init>(r3, r2, r15)
            r11.updateRememberedValue(r7)
        L_0x0115:
            r11.endReplaceableGroup()
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            r1 = 6
            androidx.compose.runtime.EffectsKt.LaunchedEffect((java.lang.Object) r3, (kotlin.jvm.functions.Function2<? super kotlinx.coroutines.CoroutineScope, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object>) r7, (androidx.compose.runtime.Composer) r11, (int) r1)
            boolean r6 = m8300DSAnimatedShrinkButton$lambda2(r2)
            com.designsystem.ds_button_v2.composables.DSAnimatedShrinkButtonKt$DSAnimatedShrinkButton$2 r1 = new com.designsystem.ds_button_v2.composables.DSAnimatedShrinkButtonKt$DSAnimatedShrinkButton$2
            r1.<init>(r9, r3, r0, r2)
            r2 = -819892678(0xffffffffcf216e3a, float:-2.70835558E9)
            androidx.compose.runtime.internal.ComposableLambda r7 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r11, r2, r4, r1)
            r1 = 196608(0x30000, float:2.75506E-40)
            r2 = r0 & 14
            r1 = r1 | r2
            r2 = r0 & 112(0x70, float:1.57E-43)
            r1 = r1 | r2
            r2 = r0 & 896(0x380, float:1.256E-42)
            r1 = r1 | r2
            int r0 = r0 << 3
            r0 = r0 & r5
            r15 = r1 | r0
            r0 = r16
            r1 = r17
            r2 = r18
            r3 = r6
            r4 = r14
            r5 = r7
            r6 = r11
            r7 = r15
            ButtonAnimatedShrinkSurface(r0, r1, r2, r3, r4, r5, r6, r7)
        L_0x014c:
            androidx.compose.runtime.ScopeUpdateScope r11 = r11.endRestartGroup()
            if (r11 != 0) goto L_0x0153
            goto L_0x0168
        L_0x0153:
            com.designsystem.ds_button_v2.composables.DSAnimatedShrinkButtonKt$DSAnimatedShrinkButton$3 r14 = new com.designsystem.ds_button_v2.composables.DSAnimatedShrinkButtonKt$DSAnimatedShrinkButton$3
            r0 = r14
            r1 = r16
            r2 = r17
            r3 = r18
            r5 = r20
            r6 = r22
            r7 = r23
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r11.updateScope(r14)
        L_0x0168:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.designsystem.ds_button_v2.composables.DSAnimatedShrinkButtonKt.DSAnimatedShrinkButton(com.designsystem.ds_button_v2.DSButtonTheme, boolean, boolean, boolean, kotlin.jvm.functions.Function4, androidx.compose.runtime.Composer, int, int):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: DSAnimatedShrinkButton$lambda-2  reason: not valid java name */
    public static final boolean m8300DSAnimatedShrinkButton$lambda2(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: DSAnimatedShrinkButton$lambda-3  reason: not valid java name */
    public static final void m8301DSAnimatedShrinkButton$lambda3(MutableState<Boolean> mutableState, boolean z11) {
        mutableState.setValue(Boolean.valueOf(z11));
    }

    @Composable
    private static final State<Float> scale(boolean z11, Composer composer, int i11) {
        float f11;
        composer.startReplaceableGroup(-447101396);
        if (z11) {
            f11 = ButtonPressedScale;
        } else {
            f11 = 1.0f;
        }
        State<Float> rememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Float.valueOf(f11), composer, 0);
        composer.endReplaceableGroup();
        return rememberUpdatedState;
    }
}
