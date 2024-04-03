package com.checkout.frames.view;

import android.annotation.SuppressLint;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.text.selection.TextSelectionColors;
import androidx.compose.foundation.text.selection.TextSelectionColorsKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.material3.TextFieldDefaults;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.checkout.frames.model.InputFieldColors;
import com.checkout.frames.style.view.InputFieldViewStyle;
import com.checkout.frames.utils.extensions.ModifierExtensionsKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import net.bytebuddy.jar.asm.Opcodes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0003\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010\u0004\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a¹\u0001\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010\r\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010\u000e\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0013\u0010\u000f\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000b¢\u0006\u0002\b\f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001d\u0010\u001e\u001aI\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0016\b\u0002\u0010$\u001a\u0010\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u0001\u0018\u00010%2\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010%H\u0001¢\u0006\u0002\u0010'\u001a\r\u0010(\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\r\u0010)\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001a\u001a\u0010*\u001a\u00020+2\b\u0010\u0016\u001a\u0004\u0018\u00010,H\u0003ø\u0001\u0001¢\u0006\u0002\u0010-\u001a'\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u00020\u00112\u0006\u00100\u001a\u00020\u00112\b\u0010\u0016\u001a\u0004\u0018\u00010,H\u0003¢\u0006\u0002\u00101\u001a'\u00102\u001a\u0002032\b\u00104\u001a\u0004\u0018\u00010,2\u0006\u00105\u001a\u00020+H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u00107\u001a\u0015\u00108\u001a\u0002092\u0006\u0010 \u001a\u00020!H\u0003¢\u0006\u0002\u0010:\u001a \u0010;\u001a\u00020<*\u00020<2\b\u0010\u0016\u001a\u0004\u0018\u00010,2\b\u0010=\u001a\u0004\u0018\u00010\u0019H\u0002\u001a3\u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010%*\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010%2\b\u0010?\u001a\u0004\u0018\u00010@H\u0002¢\u0006\u0002\u0010A\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006B"}, d2 = {"CircleOutlineInputFieldPreview", "", "(Landroidx/compose/runtime/Composer;I)V", "CustomOutlineInputFieldPreview", "CutCornerOutlineInputFieldPreview", "DecorationBox", "value", "", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material3/TextFieldColors;", "borderShape", "Landroidx/compose/ui/graphics/Shape;", "focusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "unfocusedBorderThickness", "DecorationBox-AsBZNLQ", "(Ljava/lang/String;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material3/TextFieldColors;Landroidx/compose/ui/graphics/Shape;FFLandroidx/compose/runtime/Composer;II)V", "InputField", "style", "Lcom/checkout/frames/style/view/InputFieldViewStyle;", "state", "Lcom/checkout/frames/view/InputFieldState;", "onFocusChanged", "Lkotlin/Function1;", "onValueChange", "(Lcom/checkout/frames/style/view/InputFieldViewStyle;Lcom/checkout/frames/view/InputFieldState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "InputFieldPreview", "RoundInputFieldPreview", "provideCursorColor", "Landroidx/compose/ui/graphics/Color;", "Lcom/checkout/frames/model/InputFieldColors;", "(Lcom/checkout/frames/model/InputFieldColors;Landroidx/compose/runtime/Composer;I)J", "provideInputFieldColors", "withBorder", "withContainerShape", "(ZZLcom/checkout/frames/model/InputFieldColors;Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/TextFieldColors;", "provideTextSelectionColors", "Landroidx/compose/foundation/text/selection/TextSelectionColors;", "inputColors", "cursorColor", "provideTextSelectionColors-RPmYEkk", "(Lcom/checkout/frames/model/InputFieldColors;JLandroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/text/selection/TextSelectionColors;", "provideTextStyle", "Landroidx/compose/ui/text/TextStyle;", "(Lcom/checkout/frames/style/view/InputFieldViewStyle;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/text/TextStyle;", "withBackground", "Landroidx/compose/ui/Modifier;", "containerShape", "withMaxLength", "maxLength", "", "(Lkotlin/jvm/functions/Function1;Ljava/lang/Integer;)Lkotlin/jvm/functions/Function1;", "frames_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class InputFieldKt {
    /* access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @SuppressLint({"UnrememberedMutableState"})
    @Composable
    public static final void CircleOutlineInputFieldPreview(Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(305995420);
        if (i11 != 0 || !startRestartGroup.getSkipping()) {
            MutableState mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
            SurfaceKt.m1857SurfaceT9BRK9s(SizeKt.fillMaxWidth$default(PaddingKt.m486padding3ABfNKs(Modifier.Companion, Dp.m5478constructorimpl((float) 12)), 0.0f, 1, (Object) null), (Shape) null, MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 8).m1549getBackground0d7_KjU(), 0, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.composableLambda(startRestartGroup, 684344865, true, new InputFieldKt$CircleOutlineInputFieldPreview$1(mutableStateOf$default)), startRestartGroup, 12582918, 122);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InputFieldKt$CircleOutlineInputFieldPreview$2(i11));
        }
    }

    /* access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @SuppressLint({"UnrememberedMutableState"})
    @Composable
    public static final void CustomOutlineInputFieldPreview(Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(-705906819);
        if (i11 != 0 || !startRestartGroup.getSkipping()) {
            MutableState mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
            SurfaceKt.m1857SurfaceT9BRK9s(SizeKt.fillMaxWidth$default(PaddingKt.m486padding3ABfNKs(Modifier.Companion, Dp.m5478constructorimpl((float) 12)), 0.0f, 1, (Object) null), (Shape) null, MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 8).m1549getBackground0d7_KjU(), 0, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.composableLambda(startRestartGroup, -327557374, true, new InputFieldKt$CustomOutlineInputFieldPreview$1(mutableStateOf$default)), startRestartGroup, 12582918, 122);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InputFieldKt$CustomOutlineInputFieldPreview$2(i11));
        }
    }

    /* access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @SuppressLint({"UnrememberedMutableState"})
    @Composable
    public static final void CutCornerOutlineInputFieldPreview(Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(74818215);
        if (i11 != 0 || !startRestartGroup.getSkipping()) {
            MutableState mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
            SurfaceKt.m1857SurfaceT9BRK9s(SizeKt.fillMaxWidth$default(PaddingKt.m486padding3ABfNKs(Modifier.Companion, Dp.m5478constructorimpl((float) 12)), 0.0f, 1, (Object) null), (Shape) null, MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 8).m1549getBackground0d7_KjU(), 0, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.composableLambda(startRestartGroup, 1488949506, true, new InputFieldKt$CutCornerOutlineInputFieldPreview$1(mutableStateOf$default)), startRestartGroup, 12582918, 122);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InputFieldKt$CutCornerOutlineInputFieldPreview$2(i11));
        }
    }

    /* access modifiers changed from: private */
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][_][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    @Composable
    /* renamed from: DecorationBox-AsBZNLQ  reason: not valid java name */
    public static final void m9333DecorationBoxAsBZNLQ(String str, VisualTransformation visualTransformation, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z11, boolean z12, boolean z13, MutableInteractionSource mutableInteractionSource, TextFieldColors textFieldColors, Shape shape, float f11, float f12, Composer composer, int i11, int i12) {
        int i13;
        int i14;
        Shape shape2 = shape;
        int i15 = i11;
        int i16 = i12;
        Composer startRestartGroup = composer.startRestartGroup(-778076892);
        int i17 = 4;
        String str2 = str;
        if ((i15 & 14) == 0) {
            i13 = (startRestartGroup.changed((Object) str2) ? 4 : 2) | i15;
        } else {
            i13 = i15;
        }
        int i18 = 32;
        VisualTransformation visualTransformation2 = visualTransformation;
        if ((i15 & 112) == 0) {
            i13 |= startRestartGroup.changed((Object) visualTransformation2) ? 32 : 16;
        }
        int i19 = 256;
        Function2<? super Composer, ? super Integer, Unit> function25 = function2;
        if ((i15 & 896) == 0) {
            i13 |= startRestartGroup.changed((Object) function25) ? 256 : 128;
        }
        int i21 = 2048;
        if ((i15 & 7168) == 0) {
            i13 |= startRestartGroup.changed((Object) function22) ? 2048 : 1024;
        } else {
            Function2<? super Composer, ? super Integer, Unit> function26 = function22;
        }
        Function2<? super Composer, ? super Integer, Unit> function27 = function23;
        if ((i15 & 57344) == 0) {
            i13 |= startRestartGroup.changed((Object) function27) ? 16384 : 8192;
        }
        Function2<? super Composer, ? super Integer, Unit> function28 = function24;
        if ((i15 & Opcodes.ASM7) == 0) {
            i13 |= startRestartGroup.changed((Object) function28) ? 131072 : 65536;
        }
        boolean z14 = z11;
        if ((i15 & 3670016) == 0) {
            i13 |= startRestartGroup.changed(z14) ? 1048576 : 524288;
        }
        boolean z15 = z12;
        if ((i15 & 29360128) == 0) {
            i13 |= startRestartGroup.changed(z15) ? 8388608 : 4194304;
        }
        boolean z16 = z13;
        if ((i15 & 234881024) == 0) {
            i13 |= startRestartGroup.changed(z16) ? 67108864 : 33554432;
        }
        MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
        if ((i15 & 1879048192) == 0) {
            i13 |= startRestartGroup.changed((Object) mutableInteractionSource2) ? 536870912 : 268435456;
        }
        int i22 = i13;
        if ((i16 & 14) == 0) {
            if (!startRestartGroup.changed((Object) textFieldColors)) {
                i17 = 2;
            }
            i14 = i17 | i16;
        } else {
            TextFieldColors textFieldColors2 = textFieldColors;
            i14 = i16;
        }
        if ((i16 & 112) == 0) {
            if (!startRestartGroup.changed((Object) shape2)) {
                i18 = 16;
            }
            i14 |= i18;
        }
        float f13 = f11;
        if ((i16 & 896) == 0) {
            if (!startRestartGroup.changed(f13)) {
                i19 = 128;
            }
            i14 |= i19;
        }
        float f14 = f12;
        if ((i16 & 7168) == 0) {
            if (!startRestartGroup.changed(f14)) {
                i21 = 1024;
            }
            i14 |= i21;
        }
        int i23 = i14;
        if ((i22 & 1533916891) == 306783378 && (i23 & 5851) == 1170 && startRestartGroup.getSkipping()) {
            startRestartGroup.skipToGroupEnd();
        } else if (shape2 == null) {
            startRestartGroup.startReplaceableGroup(-660890282);
            int i24 = i22 >> 15;
            int i25 = i22 << 15;
            TextFieldDefaults.INSTANCE.TextFieldDecorationBox(str, function2, z12, z11, visualTransformation, mutableInteractionSource, z13, (Function2<? super Composer, ? super Integer, Unit>) null, function22, function23, function24, (Function2<? super Composer, ? super Integer, Unit>) null, (Shape) null, textFieldColors, (PaddingValues) null, (Function2<? super Composer, ? super Integer, Unit>) null, startRestartGroup, (i22 & 14) | 12582912 | ((i22 >> 3) & 112) | (i24 & 896) | ((i22 >> 9) & 7168) | ((i22 << 9) & 57344) | ((i22 >> 12) & Opcodes.ASM7) | ((i22 >> 6) & 3670016) | (i25 & 234881024) | (i25 & 1879048192), 1572864 | (i24 & 14) | ((i23 << 9) & 7168), 55296);
            startRestartGroup.endReplaceableGroup();
        } else {
            startRestartGroup.startReplaceableGroup(-660889821);
            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
            InputFieldKt$DecorationBox$1 inputFieldKt$DecorationBox$1 = r0;
            int i26 = i23;
            InputFieldKt$DecorationBox$1 inputFieldKt$DecorationBox$12 = new InputFieldKt$DecorationBox$1(z12, z13, mutableInteractionSource, textFieldColors, shape, f11, f12, i22, i26);
            int i27 = i22 >> 15;
            int i28 = i22 << 15;
            textFieldDefaults.OutlinedTextFieldDecorationBox(str, function2, z12, z11, visualTransformation, mutableInteractionSource, z13, (Function2<? super Composer, ? super Integer, Unit>) null, function22, function23, function24, (Function2<? super Composer, ? super Integer, Unit>) null, textFieldColors, (PaddingValues) null, ComposableLambdaKt.composableLambda(startRestartGroup, 294674784, true, inputFieldKt$DecorationBox$1), startRestartGroup, (i22 & 14) | 12582912 | ((i22 >> 3) & 112) | (i27 & 896) | ((i22 >> 9) & 7168) | ((i22 << 9) & 57344) | ((i22 >> 12) & Opcodes.ASM7) | ((i22 >> 6) & 3670016) | (i28 & 234881024) | (i28 & 1879048192), 221184 | (i27 & 14) | ((i26 << 6) & 896), 10240);
            startRestartGroup.endReplaceableGroup();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            InputFieldKt$DecorationBox$2 inputFieldKt$DecorationBox$2 = r0;
            InputFieldKt$DecorationBox$2 inputFieldKt$DecorationBox$22 = new InputFieldKt$DecorationBox$2(str, visualTransformation, function2, function22, function23, function24, z11, z12, z13, mutableInteractionSource, textFieldColors, shape, f11, f12, i11, i12);
            endRestartGroup.updateScope(inputFieldKt$DecorationBox$2);
        }
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void InputField(@NotNull InputFieldViewStyle inputFieldViewStyle, @NotNull InputFieldState inputFieldState, @Nullable Function1<? super Boolean, Unit> function1, @NotNull Function1<? super String, Unit> function12, @Nullable Composer composer, int i11, int i12) {
        Function1<? super Boolean, Unit> function13;
        boolean z11;
        boolean z12;
        boolean z13;
        char c11;
        Ref.ObjectRef objectRef;
        InputFieldViewStyle inputFieldViewStyle2 = inputFieldViewStyle;
        Intrinsics.checkNotNullParameter(inputFieldViewStyle2, "style");
        Intrinsics.checkNotNullParameter(inputFieldState, "state");
        Intrinsics.checkNotNullParameter(function12, "onValueChange");
        Composer startRestartGroup = composer.startRestartGroup(1705618575);
        if ((i12 & 4) != 0) {
            function13 = null;
        } else {
            function13 = function1;
        }
        MutableInteractionSource interactionSource = inputFieldViewStyle.getInteractionSource();
        startRestartGroup.startReplaceableGroup(1482283512);
        if (interactionSource == null) {
            startRestartGroup.startReplaceableGroup(-492369756);
            Object rememberedValue = startRestartGroup.rememberedValue();
            if (rememberedValue == Composer.Companion.getEmpty()) {
                rememberedValue = InteractionSourceKt.MutableInteractionSource();
                startRestartGroup.updateRememberedValue(rememberedValue);
            }
            startRestartGroup.endReplaceableGroup();
            interactionSource = (MutableInteractionSource) rememberedValue;
        }
        MutableInteractionSource mutableInteractionSource = interactionSource;
        startRestartGroup.endReplaceableGroup();
        TextStyle provideTextStyle = provideTextStyle(inputFieldViewStyle2, startRestartGroup, 8);
        if (inputFieldViewStyle.getBorderShape() != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (inputFieldViewStyle.getContainerShape() != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        TextFieldColors provideInputFieldColors = provideInputFieldColors(z11, z12, inputFieldViewStyle.getColors(), startRestartGroup, 0);
        long r12 = provideTextStyle.m5056getColor0d7_KjU();
        Color.Companion companion = Color.Companion;
        if (r12 != companion.m2955getUnspecified0d7_KjU()) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (!z13) {
            r12 = companion.m2945getBlack0d7_KjU();
        }
        TextStyle merge = provideTextStyle.merge(new TextStyle(r12, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262142, (DefaultConstructorMarker) null));
        TextSelectionColors r02 = m9335provideTextSelectionColorsRPmYEkk(inputFieldViewStyle.getColors(), provideCursorColor(inputFieldViewStyle.getColors(), startRestartGroup, 0), startRestartGroup, 0);
        Ref.ObjectRef objectRef2 = new Ref.ObjectRef();
        Modifier withBackground = withBackground(ModifierExtensionsKt.clearFocusOnKeyboardDismiss(inputFieldViewStyle.getModifier()), inputFieldViewStyle.getColors(), inputFieldViewStyle.getContainerShape());
        startRestartGroup.startReplaceableGroup(1157296644);
        boolean changed = startRestartGroup.changed((Object) function13);
        Object rememberedValue2 = startRestartGroup.rememberedValue();
        if (changed || rememberedValue2 == Composer.Companion.getEmpty()) {
            rememberedValue2 = new InputFieldKt$InputField$1$modifier$1$1(function13);
            startRestartGroup.updateRememberedValue(rememberedValue2);
        }
        startRestartGroup.endReplaceableGroup();
        Modifier onFocusChanged = FocusChangedModifierKt.onFocusChanged(withBackground, (Function1) rememberedValue2);
        TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
        objectRef2.element = SizeKt.m542defaultMinSizeVpY3zN4(onFocusChanged, textFieldDefaults.m1911getMinWidthD9Ej5fM(), textFieldDefaults.m1910getMinHeightD9Ej5fM());
        if (inputFieldViewStyle.getBorderShape() == null) {
            objectRef = objectRef2;
            c11 = 0;
            objectRef.element = textFieldDefaults.m1913indicatorLinegv0btCI((Modifier) objectRef2.element, inputFieldViewStyle.getEnabled(), inputFieldState.isError().getValue().booleanValue(), mutableInteractionSource, provideInputFieldColors, inputFieldViewStyle.m9278getFocusedBorderThicknessD9Ej5fM(), inputFieldViewStyle.m9279getUnfocusedBorderThicknessD9Ej5fM());
        } else {
            objectRef = objectRef2;
            c11 = 0;
        }
        ProvidedValue[] providedValueArr = new ProvidedValue[1];
        providedValueArr[c11] = TextSelectionColorsKt.getLocalTextSelectionColors().provides(r02);
        InputFieldKt$InputField$1$1 inputFieldKt$InputField$1$1 = r0;
        InputFieldKt$InputField$1$1 inputFieldKt$InputField$1$12 = new InputFieldKt$InputField$1$1(inputFieldState, objectRef, function12, inputFieldViewStyle, inputFieldViewStyle, merge, mutableInteractionSource, provideInputFieldColors);
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) providedValueArr, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -1577801391, true, inputFieldKt$InputField$1$1), startRestartGroup, 56);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InputFieldKt$InputField$2(inputFieldViewStyle, inputFieldState, function13, function12, i11, i12));
        }
    }

    /* access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @SuppressLint({"UnrememberedMutableState"})
    @Composable
    public static final void InputFieldPreview(Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(60032562);
        if (i11 != 0 || !startRestartGroup.getSkipping()) {
            MutableState mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
            SurfaceKt.m1857SurfaceT9BRK9s(SizeKt.fillMaxWidth$default(PaddingKt.m486padding3ABfNKs(Modifier.Companion, Dp.m5478constructorimpl((float) 12)), 0.0f, 1, (Object) null), (Shape) null, MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 8).m1549getBackground0d7_KjU(), 0, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.composableLambda(startRestartGroup, -469497203, true, new InputFieldKt$InputFieldPreview$1(mutableStateOf$default)), startRestartGroup, 12582918, 122);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InputFieldKt$InputFieldPreview$2(i11));
        }
    }

    /* access modifiers changed from: private */
    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @SuppressLint({"UnrememberedMutableState"})
    @Composable
    public static final void RoundInputFieldPreview(Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(-1783351072);
        if (i11 != 0 || !startRestartGroup.getSkipping()) {
            MutableState mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", (SnapshotMutationPolicy) null, 2, (Object) null);
            SurfaceKt.m1857SurfaceT9BRK9s(SizeKt.fillMaxWidth$default(PaddingKt.m486padding3ABfNKs(Modifier.Companion, Dp.m5478constructorimpl((float) 12)), 0.0f, 1, (Object) null), (Shape) null, MaterialTheme.INSTANCE.getColorScheme(startRestartGroup, 8).m1549getBackground0d7_KjU(), 0, 0.0f, 0.0f, (BorderStroke) null, ComposableLambdaKt.composableLambda(startRestartGroup, -370166427, true, new InputFieldKt$RoundInputFieldPreview$1(mutableStateOf$default)), startRestartGroup, 12582918, 122);
        } else {
            startRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new InputFieldKt$RoundInputFieldPreview$2(i11));
        }
    }

    /* access modifiers changed from: private */
    @Composable
    public static final long provideCursorColor(InputFieldColors inputFieldColors, Composer composer, int i11) {
        long j11;
        Color color;
        Color color2;
        composer.startReplaceableGroup(-1576310933);
        if (inputFieldColors == null || (color = inputFieldColors.m9253getCursorHandleColorQN2ZGVo()) == null) {
            color = null;
            if (inputFieldColors != null) {
                color2 = inputFieldColors.m9252getCursorColorQN2ZGVo();
            } else {
                color2 = null;
            }
            if (color2 != null) {
                j11 = color2.m2929unboximpl();
            } else {
                if (inputFieldColors != null) {
                    color = inputFieldColors.m9258getFocusedIndicatorColorQN2ZGVo();
                }
                if (color == null) {
                    j11 = Color.Companion.m2945getBlack0d7_KjU();
                }
            }
            composer.endReplaceableGroup();
            return j11;
        }
        j11 = color.m2929unboximpl();
        composer.endReplaceableGroup();
        return j11;
    }

    @Composable
    private static final TextFieldColors provideInputFieldColors(boolean z11, boolean z12, InputFieldColors inputFieldColors, Composer composer, int i11) {
        long j11;
        long j12;
        long j13;
        long j14;
        long j15;
        long j16;
        long j17;
        Color color;
        long Color;
        TextFieldColors textFieldColors;
        Color r92;
        Color r52;
        Color r53;
        Color r54;
        Color r32;
        Color r33;
        Color r12;
        InputFieldColors inputFieldColors2 = inputFieldColors;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-393529644);
        if (inputFieldColors2 == null || (r12 = inputFieldColors.m9260getTextColorQN2ZGVo()) == null) {
            j11 = Color.Companion.m2945getBlack0d7_KjU();
        } else {
            j11 = r12.m2929unboximpl();
        }
        if (inputFieldColors2 == null || (r33 = inputFieldColors.m9259getPlaceholderColorQN2ZGVo()) == null) {
            j12 = Color.Companion.m2949getGray0d7_KjU();
        } else {
            j12 = r33.m2929unboximpl();
        }
        long j18 = j12;
        if (inputFieldColors2 == null || (r32 = inputFieldColors.m9258getFocusedIndicatorColorQN2ZGVo()) == null) {
            j13 = ColorKt.Color(4287269514L);
        } else {
            j13 = r32.m2929unboximpl();
        }
        long j19 = j13;
        if (inputFieldColors2 == null || (r54 = inputFieldColors.m9261getUnfocusedIndicatorColorQN2ZGVo()) == null) {
            j14 = ColorKt.Color(4291611852L);
        } else {
            j14 = r54.m2929unboximpl();
        }
        long j21 = j14;
        if (inputFieldColors2 == null || (r53 = inputFieldColors.m9255getDisabledIndicatorColorQN2ZGVo()) == null) {
            j15 = ColorKt.Color(4291611852L);
        } else {
            j15 = r53.m2929unboximpl();
        }
        long j22 = j15;
        if (inputFieldColors2 == null || (r52 = inputFieldColors.m9257getErrorIndicatorColorQN2ZGVo()) == null) {
            j16 = ColorKt.Color(4289538110L);
        } else {
            j16 = r52.m2929unboximpl();
        }
        long j23 = j16;
        if (inputFieldColors2 != null) {
            j17 = inputFieldColors.m9251getContainerColor0d7_KjU();
        } else {
            j17 = Color.Companion.m2954getTransparent0d7_KjU();
        }
        long provideCursorColor = provideCursorColor(inputFieldColors2, composer2, (i11 >> 6) & 14);
        if (inputFieldColors2 == null || (r92 = inputFieldColors.m9256getErrorCursorColorQN2ZGVo()) == null) {
            if (inputFieldColors2 != null) {
                color = inputFieldColors.m9257getErrorIndicatorColorQN2ZGVo();
            } else {
                color = null;
            }
            if (color != null) {
                Color = color.m2929unboximpl();
            } else {
                Color = ColorKt.Color(4289538110L);
            }
        } else {
            Color = r92.m2929unboximpl();
        }
        long j24 = Color;
        if (z11) {
            composer2.startReplaceableGroup(-591243908);
            textFieldColors = TextFieldDefaults.INSTANCE.m1914outlinedTextFieldColorsl59Burw(j11, 0, j17, provideCursorColor, j24, (TextSelectionColors) null, j19, j21, j22, j23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, j18, 0, 0, 0, 0, 0, composer, 0, 0, 100663296, 264240162);
            composer.endReplaceableGroup();
        } else {
            composer.startReplaceableGroup(-591243466);
            TextFieldDefaults textFieldDefaults = TextFieldDefaults.INSTANCE;
            if (z12) {
                j19 = Color.Companion.m2954getTransparent0d7_KjU();
            }
            if (z12) {
                j21 = Color.Companion.m2954getTransparent0d7_KjU();
            }
            if (z12) {
                j22 = Color.Companion.m2954getTransparent0d7_KjU();
            }
            if (z12) {
                j23 = Color.Companion.m2954getTransparent0d7_KjU();
            }
            if (z12) {
                j17 = Color.Companion.m2954getTransparent0d7_KjU();
            }
            textFieldColors = textFieldDefaults.m1917textFieldColorsl59Burw(j11, 0, j17, provideCursorColor, j24, (TextSelectionColors) null, j19, j21, j22, j23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, j18, 0, 0, 0, 0, 0, composer, 0, 0, 100663296, 264240162);
            composer.endReplaceableGroup();
        }
        composer.endReplaceableGroup();
        return textFieldColors;
    }

    @Composable
    /* renamed from: provideTextSelectionColors-RPmYEkk  reason: not valid java name */
    private static final TextSelectionColors m9335provideTextSelectionColorsRPmYEkk(InputFieldColors inputFieldColors, long j11, Composer composer, int i11) {
        long j12;
        long j13;
        Color r11;
        Color r02;
        composer.startReplaceableGroup(116585804);
        if (inputFieldColors == null || (r02 = inputFieldColors.m9253getCursorHandleColorQN2ZGVo()) == null) {
            j12 = j11;
        } else {
            j12 = r02.m2929unboximpl();
        }
        if (inputFieldColors == null || (r11 = inputFieldColors.m9254getCursorHighlightColorQN2ZGVo()) == null) {
            j13 = Color.m2918copywmQWz5c$default(j11, 0.4f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j13 = r11.m2929unboximpl();
        }
        TextSelectionColors textSelectionColors = new TextSelectionColors(j12, j13, (DefaultConstructorMarker) null);
        composer.endReplaceableGroup();
        return textSelectionColors;
    }

    @Composable
    private static final TextStyle provideTextStyle(InputFieldViewStyle inputFieldViewStyle, Composer composer, int i11) {
        boolean z11;
        Composer composer2 = composer;
        composer2.startReplaceableGroup(-59534717);
        TextStyle textStyle = inputFieldViewStyle.getTextStyle();
        composer2.startReplaceableGroup(-378074541);
        if (textStyle == null) {
            textStyle = (TextStyle) composer2.consume(TextKt.getLocalTextStyle());
        }
        TextStyle textStyle2 = textStyle;
        composer.endReplaceableGroup();
        if (!inputFieldViewStyle.getForceLTR() || composer2.consume(CompositionLocalsKt.getLocalLayoutDirection()) != LayoutDirection.Rtl) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            textStyle2 = TextStyle.m5046copyHL5avdY$default(textStyle2, 0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, TextAlign.m5359boximpl(TextAlign.Companion.m5367getEnde0LSkKk()), TextDirection.m5372boximpl(TextDirection.Companion.m5382getLtrs_7Xco()), 0, (TextIndent) null, 212991, (Object) null);
        }
        composer.endReplaceableGroup();
        return textStyle2;
    }

    private static final Modifier withBackground(Modifier modifier, InputFieldColors inputFieldColors, Shape shape) {
        if (shape == null) {
            return modifier;
        }
        Modifier r32 = BackgroundKt.m176backgroundbw27NRU(modifier, inputFieldColors != null ? inputFieldColors.m9251getContainerColor0d7_KjU() : Color.Companion.m2955getUnspecified0d7_KjU(), shape);
        return r32 == null ? modifier : r32;
    }

    /* access modifiers changed from: private */
    public static final Function1<String, Unit> withMaxLength(Function1<? super String, Unit> function1, Integer num) {
        return new InputFieldKt$withMaxLength$1(num, function1);
    }
}
