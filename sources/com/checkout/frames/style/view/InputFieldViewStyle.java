package com.checkout.frames.style.view;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.Dp;
import com.checkout.frames.model.InputFieldColors;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b@\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BÉ\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\b\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c\u0012\b\b\u0002\u0010\u001d\u001a\u00020\u001e\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u001e\u0012\b\b\u0002\u0010 \u001a\u00020\u0005ø\u0001\u0000¢\u0006\u0002\u0010!J\t\u0010E\u001a\u00020\u0003HÆ\u0003J\t\u0010F\u001a\u00020\u0015HÆ\u0003J\u000b\u0010G\u001a\u0004\u0018\u00010\u0017HÆ\u0003J\u000b\u0010H\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010I\u001a\u0004\u0018\u00010\u0019HÆ\u0003J\u000b\u0010J\u001a\u0004\u0018\u00010\u001cHÆ\u0003J\u0019\u0010K\u001a\u00020\u001eHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bL\u0010*J\u0019\u0010M\u001a\u00020\u001eHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bN\u0010*J\t\u0010O\u001a\u00020\u0005HÆ\u0003J\t\u0010P\u001a\u00020\u0005HÆ\u0003J\t\u0010Q\u001a\u00020\u0005HÆ\u0003J\u000b\u0010R\u001a\u0004\u0018\u00010\bHÆ\u0003J\u001b\u0010S\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\b\fHÆ\u0003¢\u0006\u0002\u0010<J\t\u0010T\u001a\u00020\u000eHÆ\u0003J\t\u0010U\u001a\u00020\u0010HÆ\u0003J\t\u0010V\u001a\u00020\u0012HÆ\u0003J\t\u0010W\u001a\u00020\u0005HÆ\u0003J×\u0001\u0010X\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0015\b\u0002\u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\b\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020\u001e2\b\b\u0002\u0010 \u001a\u00020\u0005HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bY\u0010ZJ\u0013\u0010[\u001a\u00020\u00052\b\u0010\\\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010]\u001a\u00020\u0015HÖ\u0001J\t\u0010^\u001a\u00020_HÖ\u0001R\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u001c¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u0019¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u001c\u0010\u001d\u001a\u00020\u001eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010+\u001a\u0004\b)\u0010*R\u001a\u0010 \u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010(\"\u0004\b-\u0010.R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u0017¢\u0006\b\n\u0000\u001a\u0004\b/\u00100R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b5\u00106R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R \u0010\t\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\b\f¢\u0006\n\n\u0002\u0010=\u001a\u0004\b;\u0010<R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b>\u0010(R\u0011\u0010\u0013\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b?\u0010(R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b@\u0010AR\u001c\u0010\u001f\u001a\u00020\u001eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010+\u001a\u0004\bB\u0010*R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\bC\u0010D\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006`"}, d2 = {"Lcom/checkout/frames/style/view/InputFieldViewStyle;", "", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "placeholder", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "containerShape", "Landroidx/compose/ui/graphics/Shape;", "borderShape", "colors", "Lcom/checkout/frames/model/InputFieldColors;", "focusedBorderThickness", "Landroidx/compose/ui/unit/Dp;", "unfocusedBorderThickness", "forceLTR", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Lcom/checkout/frames/model/InputFieldColors;FFZLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBorderShape", "()Landroidx/compose/ui/graphics/Shape;", "getColors", "()Lcom/checkout/frames/model/InputFieldColors;", "getContainerShape", "getEnabled", "()Z", "getFocusedBorderThickness-D9Ej5fM", "()F", "F", "getForceLTR", "setForceLTR", "(Z)V", "getInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getKeyboardActions", "()Landroidx/compose/foundation/text/KeyboardActions;", "getKeyboardOptions", "()Landroidx/compose/foundation/text/KeyboardOptions;", "getMaxLines", "()I", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "getPlaceholder", "()Lkotlin/jvm/functions/Function2;", "Lkotlin/jvm/functions/Function2;", "getReadOnly", "getSingleLine", "getTextStyle", "()Landroidx/compose/ui/text/TextStyle;", "getUnfocusedBorderThickness-D9Ej5fM", "getVisualTransformation", "()Landroidx/compose/ui/text/input/VisualTransformation;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component15-D9Ej5fM", "component16", "component16-D9Ej5fM", "component17", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "copy-RTRN5YQ", "(Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/ui/graphics/Shape;Lcom/checkout/frames/model/InputFieldColors;FFZ)Lcom/checkout/frames/style/view/InputFieldViewStyle;", "equals", "other", "hashCode", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InputFieldViewStyle {
    @Nullable
    private final Shape borderShape;
    @Nullable
    private final InputFieldColors colors;
    @Nullable
    private final Shape containerShape;
    private final boolean enabled;
    private final float focusedBorderThickness;
    private boolean forceLTR;
    @Nullable
    private final MutableInteractionSource interactionSource;
    @NotNull
    private final KeyboardActions keyboardActions;
    @NotNull
    private final KeyboardOptions keyboardOptions;
    private final int maxLines;
    @NotNull
    private Modifier modifier;
    @Nullable
    private final Function2<Composer, Integer, Unit> placeholder;
    private final boolean readOnly;
    private final boolean singleLine;
    @Nullable
    private final TextStyle textStyle;
    private final float unfocusedBorderThickness;
    @NotNull
    private final VisualTransformation visualTransformation;

    private InputFieldViewStyle(Modifier modifier2, boolean z11, boolean z12, TextStyle textStyle2, Function2<? super Composer, ? super Integer, Unit> function2, VisualTransformation visualTransformation2, KeyboardOptions keyboardOptions2, KeyboardActions keyboardActions2, boolean z13, int i11, MutableInteractionSource mutableInteractionSource, Shape shape, Shape shape2, InputFieldColors inputFieldColors, float f11, float f12, boolean z14) {
        this.modifier = modifier2;
        this.enabled = z11;
        this.readOnly = z12;
        this.textStyle = textStyle2;
        this.placeholder = function2;
        this.visualTransformation = visualTransformation2;
        this.keyboardOptions = keyboardOptions2;
        this.keyboardActions = keyboardActions2;
        this.singleLine = z13;
        this.maxLines = i11;
        this.interactionSource = mutableInteractionSource;
        this.containerShape = shape;
        this.borderShape = shape2;
        this.colors = inputFieldColors;
        this.focusedBorderThickness = f11;
        this.unfocusedBorderThickness = f12;
        this.forceLTR = z14;
    }

    public /* synthetic */ InputFieldViewStyle(Modifier modifier2, boolean z11, boolean z12, TextStyle textStyle2, Function2 function2, VisualTransformation visualTransformation2, KeyboardOptions keyboardOptions2, KeyboardActions keyboardActions2, boolean z13, int i11, MutableInteractionSource mutableInteractionSource, Shape shape, Shape shape2, InputFieldColors inputFieldColors, float f11, float f12, boolean z14, DefaultConstructorMarker defaultConstructorMarker) {
        this(modifier2, z11, z12, textStyle2, function2, visualTransformation2, keyboardOptions2, keyboardActions2, z13, i11, mutableInteractionSource, shape, shape2, inputFieldColors, f11, f12, z14);
    }

    /* renamed from: copy-RTRN5YQ$default  reason: not valid java name */
    public static /* synthetic */ InputFieldViewStyle m9274copyRTRN5YQ$default(InputFieldViewStyle inputFieldViewStyle, Modifier modifier2, boolean z11, boolean z12, TextStyle textStyle2, Function2 function2, VisualTransformation visualTransformation2, KeyboardOptions keyboardOptions2, KeyboardActions keyboardActions2, boolean z13, int i11, MutableInteractionSource mutableInteractionSource, Shape shape, Shape shape2, InputFieldColors inputFieldColors, float f11, float f12, boolean z14, int i12, Object obj) {
        InputFieldViewStyle inputFieldViewStyle2 = inputFieldViewStyle;
        int i13 = i12;
        return inputFieldViewStyle.m9277copyRTRN5YQ((i13 & 1) != 0 ? inputFieldViewStyle2.modifier : modifier2, (i13 & 2) != 0 ? inputFieldViewStyle2.enabled : z11, (i13 & 4) != 0 ? inputFieldViewStyle2.readOnly : z12, (i13 & 8) != 0 ? inputFieldViewStyle2.textStyle : textStyle2, (i13 & 16) != 0 ? inputFieldViewStyle2.placeholder : function2, (i13 & 32) != 0 ? inputFieldViewStyle2.visualTransformation : visualTransformation2, (i13 & 64) != 0 ? inputFieldViewStyle2.keyboardOptions : keyboardOptions2, (i13 & 128) != 0 ? inputFieldViewStyle2.keyboardActions : keyboardActions2, (i13 & 256) != 0 ? inputFieldViewStyle2.singleLine : z13, (i13 & 512) != 0 ? inputFieldViewStyle2.maxLines : i11, (i13 & 1024) != 0 ? inputFieldViewStyle2.interactionSource : mutableInteractionSource, (i13 & 2048) != 0 ? inputFieldViewStyle2.containerShape : shape, (i13 & 4096) != 0 ? inputFieldViewStyle2.borderShape : shape2, (i13 & 8192) != 0 ? inputFieldViewStyle2.colors : inputFieldColors, (i13 & 16384) != 0 ? inputFieldViewStyle2.focusedBorderThickness : f11, (i13 & 32768) != 0 ? inputFieldViewStyle2.unfocusedBorderThickness : f12, (i13 & 65536) != 0 ? inputFieldViewStyle2.forceLTR : z14);
    }

    @NotNull
    public final Modifier component1() {
        return this.modifier;
    }

    public final int component10() {
        return this.maxLines;
    }

    @Nullable
    public final MutableInteractionSource component11() {
        return this.interactionSource;
    }

    @Nullable
    public final Shape component12() {
        return this.containerShape;
    }

    @Nullable
    public final Shape component13() {
        return this.borderShape;
    }

    @Nullable
    public final InputFieldColors component14() {
        return this.colors;
    }

    /* renamed from: component15-D9Ej5fM  reason: not valid java name */
    public final float m9275component15D9Ej5fM() {
        return this.focusedBorderThickness;
    }

    /* renamed from: component16-D9Ej5fM  reason: not valid java name */
    public final float m9276component16D9Ej5fM() {
        return this.unfocusedBorderThickness;
    }

    public final boolean component17() {
        return this.forceLTR;
    }

    public final boolean component2() {
        return this.enabled;
    }

    public final boolean component3() {
        return this.readOnly;
    }

    @Nullable
    public final TextStyle component4() {
        return this.textStyle;
    }

    @Nullable
    public final Function2<Composer, Integer, Unit> component5() {
        return this.placeholder;
    }

    @NotNull
    public final VisualTransformation component6() {
        return this.visualTransformation;
    }

    @NotNull
    public final KeyboardOptions component7() {
        return this.keyboardOptions;
    }

    @NotNull
    public final KeyboardActions component8() {
        return this.keyboardActions;
    }

    public final boolean component9() {
        return this.singleLine;
    }

    @NotNull
    /* renamed from: copy-RTRN5YQ  reason: not valid java name */
    public final InputFieldViewStyle m9277copyRTRN5YQ(@NotNull Modifier modifier2, boolean z11, boolean z12, @Nullable TextStyle textStyle2, @Nullable Function2<? super Composer, ? super Integer, Unit> function2, @NotNull VisualTransformation visualTransformation2, @NotNull KeyboardOptions keyboardOptions2, @NotNull KeyboardActions keyboardActions2, boolean z13, int i11, @Nullable MutableInteractionSource mutableInteractionSource, @Nullable Shape shape, @Nullable Shape shape2, @Nullable InputFieldColors inputFieldColors, float f11, float f12, boolean z14) {
        Modifier modifier3 = modifier2;
        Intrinsics.checkNotNullParameter(modifier3, "modifier");
        Intrinsics.checkNotNullParameter(visualTransformation2, "visualTransformation");
        Intrinsics.checkNotNullParameter(keyboardOptions2, "keyboardOptions");
        Intrinsics.checkNotNullParameter(keyboardActions2, "keyboardActions");
        return new InputFieldViewStyle(modifier3, z11, z12, textStyle2, function2, visualTransformation2, keyboardOptions2, keyboardActions2, z13, i11, mutableInteractionSource, shape, shape2, inputFieldColors, f11, f12, z14, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InputFieldViewStyle)) {
            return false;
        }
        InputFieldViewStyle inputFieldViewStyle = (InputFieldViewStyle) obj;
        return Intrinsics.areEqual((Object) this.modifier, (Object) inputFieldViewStyle.modifier) && this.enabled == inputFieldViewStyle.enabled && this.readOnly == inputFieldViewStyle.readOnly && Intrinsics.areEqual((Object) this.textStyle, (Object) inputFieldViewStyle.textStyle) && Intrinsics.areEqual((Object) this.placeholder, (Object) inputFieldViewStyle.placeholder) && Intrinsics.areEqual((Object) this.visualTransformation, (Object) inputFieldViewStyle.visualTransformation) && Intrinsics.areEqual((Object) this.keyboardOptions, (Object) inputFieldViewStyle.keyboardOptions) && Intrinsics.areEqual((Object) this.keyboardActions, (Object) inputFieldViewStyle.keyboardActions) && this.singleLine == inputFieldViewStyle.singleLine && this.maxLines == inputFieldViewStyle.maxLines && Intrinsics.areEqual((Object) this.interactionSource, (Object) inputFieldViewStyle.interactionSource) && Intrinsics.areEqual((Object) this.containerShape, (Object) inputFieldViewStyle.containerShape) && Intrinsics.areEqual((Object) this.borderShape, (Object) inputFieldViewStyle.borderShape) && Intrinsics.areEqual((Object) this.colors, (Object) inputFieldViewStyle.colors) && Dp.m5483equalsimpl0(this.focusedBorderThickness, inputFieldViewStyle.focusedBorderThickness) && Dp.m5483equalsimpl0(this.unfocusedBorderThickness, inputFieldViewStyle.unfocusedBorderThickness) && this.forceLTR == inputFieldViewStyle.forceLTR;
    }

    @Nullable
    public final Shape getBorderShape() {
        return this.borderShape;
    }

    @Nullable
    public final InputFieldColors getColors() {
        return this.colors;
    }

    @Nullable
    public final Shape getContainerShape() {
        return this.containerShape;
    }

    public final boolean getEnabled() {
        return this.enabled;
    }

    /* renamed from: getFocusedBorderThickness-D9Ej5fM  reason: not valid java name */
    public final float m9278getFocusedBorderThicknessD9Ej5fM() {
        return this.focusedBorderThickness;
    }

    public final boolean getForceLTR() {
        return this.forceLTR;
    }

    @Nullable
    public final MutableInteractionSource getInteractionSource() {
        return this.interactionSource;
    }

    @NotNull
    public final KeyboardActions getKeyboardActions() {
        return this.keyboardActions;
    }

    @NotNull
    public final KeyboardOptions getKeyboardOptions() {
        return this.keyboardOptions;
    }

    public final int getMaxLines() {
        return this.maxLines;
    }

    @NotNull
    public final Modifier getModifier() {
        return this.modifier;
    }

    @Nullable
    public final Function2<Composer, Integer, Unit> getPlaceholder() {
        return this.placeholder;
    }

    public final boolean getReadOnly() {
        return this.readOnly;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    @Nullable
    public final TextStyle getTextStyle() {
        return this.textStyle;
    }

    /* renamed from: getUnfocusedBorderThickness-D9Ej5fM  reason: not valid java name */
    public final float m9279getUnfocusedBorderThicknessD9Ej5fM() {
        return this.unfocusedBorderThickness;
    }

    @NotNull
    public final VisualTransformation getVisualTransformation() {
        return this.visualTransformation;
    }

    public int hashCode() {
        int hashCode = this.modifier.hashCode() * 31;
        boolean z11 = this.enabled;
        boolean z12 = true;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        boolean z13 = this.readOnly;
        if (z13) {
            z13 = true;
        }
        int i12 = (i11 + (z13 ? 1 : 0)) * 31;
        TextStyle textStyle2 = this.textStyle;
        int i13 = 0;
        int hashCode2 = (i12 + (textStyle2 == null ? 0 : textStyle2.hashCode())) * 31;
        Function2<Composer, Integer, Unit> function2 = this.placeholder;
        int hashCode3 = (((((((hashCode2 + (function2 == null ? 0 : function2.hashCode())) * 31) + this.visualTransformation.hashCode()) * 31) + this.keyboardOptions.hashCode()) * 31) + this.keyboardActions.hashCode()) * 31;
        boolean z14 = this.singleLine;
        if (z14) {
            z14 = true;
        }
        int i14 = (((hashCode3 + (z14 ? 1 : 0)) * 31) + this.maxLines) * 31;
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        int hashCode4 = (i14 + (mutableInteractionSource == null ? 0 : mutableInteractionSource.hashCode())) * 31;
        Shape shape = this.containerShape;
        int hashCode5 = (hashCode4 + (shape == null ? 0 : shape.hashCode())) * 31;
        Shape shape2 = this.borderShape;
        int hashCode6 = (hashCode5 + (shape2 == null ? 0 : shape2.hashCode())) * 31;
        InputFieldColors inputFieldColors = this.colors;
        if (inputFieldColors != null) {
            i13 = inputFieldColors.hashCode();
        }
        int r02 = (((((hashCode6 + i13) * 31) + Dp.m5484hashCodeimpl(this.focusedBorderThickness)) * 31) + Dp.m5484hashCodeimpl(this.unfocusedBorderThickness)) * 31;
        boolean z15 = this.forceLTR;
        if (!z15) {
            z12 = z15;
        }
        return r02 + (z12 ? 1 : 0);
    }

    public final void setForceLTR(boolean z11) {
        this.forceLTR = z11;
    }

    public final void setModifier(@NotNull Modifier modifier2) {
        Intrinsics.checkNotNullParameter(modifier2, "<set-?>");
        this.modifier = modifier2;
    }

    @NotNull
    public String toString() {
        Modifier modifier2 = this.modifier;
        boolean z11 = this.enabled;
        boolean z12 = this.readOnly;
        TextStyle textStyle2 = this.textStyle;
        Function2<Composer, Integer, Unit> function2 = this.placeholder;
        VisualTransformation visualTransformation2 = this.visualTransformation;
        KeyboardOptions keyboardOptions2 = this.keyboardOptions;
        KeyboardActions keyboardActions2 = this.keyboardActions;
        boolean z13 = this.singleLine;
        int i11 = this.maxLines;
        MutableInteractionSource mutableInteractionSource = this.interactionSource;
        Shape shape = this.containerShape;
        Shape shape2 = this.borderShape;
        InputFieldColors inputFieldColors = this.colors;
        String r16 = Dp.m5489toStringimpl(this.focusedBorderThickness);
        String r17 = Dp.m5489toStringimpl(this.unfocusedBorderThickness);
        boolean z14 = this.forceLTR;
        return "InputFieldViewStyle(modifier=" + modifier2 + ", enabled=" + z11 + ", readOnly=" + z12 + ", textStyle=" + textStyle2 + ", placeholder=" + function2 + ", visualTransformation=" + visualTransformation2 + ", keyboardOptions=" + keyboardOptions2 + ", keyboardActions=" + keyboardActions2 + ", singleLine=" + z13 + ", maxLines=" + i11 + ", interactionSource=" + mutableInteractionSource + ", containerShape=" + shape + ", borderShape=" + shape2 + ", colors=" + inputFieldColors + ", focusedBorderThickness=" + r16 + ", unfocusedBorderThickness=" + r17 + ", forceLTR=" + z14 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ InputFieldViewStyle(androidx.compose.ui.Modifier r19, boolean r20, boolean r21, androidx.compose.ui.text.TextStyle r22, kotlin.jvm.functions.Function2 r23, androidx.compose.ui.text.input.VisualTransformation r24, androidx.compose.foundation.text.KeyboardOptions r25, androidx.compose.foundation.text.KeyboardActions r26, boolean r27, int r28, androidx.compose.foundation.interaction.MutableInteractionSource r29, androidx.compose.ui.graphics.Shape r30, androidx.compose.ui.graphics.Shape r31, com.checkout.frames.model.InputFieldColors r32, float r33, float r34, boolean r35, int r36, kotlin.jvm.internal.DefaultConstructorMarker r37) {
        /*
            r18 = this;
            r0 = r36
            r1 = r0 & 1
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0010
            androidx.compose.ui.Modifier$Companion r1 = androidx.compose.ui.Modifier.Companion
            r4 = 0
            androidx.compose.ui.Modifier r1 = androidx.compose.foundation.layout.SizeKt.fillMaxWidth$default(r1, r4, r3, r2)
            goto L_0x0012
        L_0x0010:
            r1 = r19
        L_0x0012:
            r4 = r0 & 2
            if (r4 == 0) goto L_0x0018
            r4 = r3
            goto L_0x001a
        L_0x0018:
            r4 = r20
        L_0x001a:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0020
            r5 = 0
            goto L_0x0022
        L_0x0020:
            r5 = r21
        L_0x0022:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x0028
            r7 = r2
            goto L_0x002a
        L_0x0028:
            r7 = r22
        L_0x002a:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x0030
            r8 = r2
            goto L_0x0032
        L_0x0030:
            r8 = r23
        L_0x0032:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x003d
            androidx.compose.ui.text.input.VisualTransformation$Companion r9 = androidx.compose.ui.text.input.VisualTransformation.Companion
            androidx.compose.ui.text.input.VisualTransformation r9 = r9.getNone()
            goto L_0x003f
        L_0x003d:
            r9 = r24
        L_0x003f:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x004a
            androidx.compose.foundation.text.KeyboardOptions$Companion r10 = androidx.compose.foundation.text.KeyboardOptions.Companion
            androidx.compose.foundation.text.KeyboardOptions r10 = r10.getDefault()
            goto L_0x004c
        L_0x004a:
            r10 = r25
        L_0x004c:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x0057
            androidx.compose.foundation.text.KeyboardActions$Companion r11 = androidx.compose.foundation.text.KeyboardActions.Companion
            androidx.compose.foundation.text.KeyboardActions r11 = r11.getDefault()
            goto L_0x0059
        L_0x0057:
            r11 = r26
        L_0x0059:
            r12 = r0 & 256(0x100, float:3.59E-43)
            if (r12 == 0) goto L_0x005e
            goto L_0x0060
        L_0x005e:
            r3 = r27
        L_0x0060:
            r12 = r0 & 512(0x200, float:7.175E-43)
            if (r12 == 0) goto L_0x0068
            r12 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x006a
        L_0x0068:
            r12 = r28
        L_0x006a:
            r13 = r0 & 1024(0x400, float:1.435E-42)
            if (r13 == 0) goto L_0x0070
            r13 = r2
            goto L_0x0072
        L_0x0070:
            r13 = r29
        L_0x0072:
            r14 = r0 & 2048(0x800, float:2.87E-42)
            if (r14 == 0) goto L_0x0078
            r14 = r2
            goto L_0x007a
        L_0x0078:
            r14 = r30
        L_0x007a:
            r15 = r0 & 4096(0x1000, float:5.74E-42)
            if (r15 == 0) goto L_0x0080
            r15 = r2
            goto L_0x0082
        L_0x0080:
            r15 = r31
        L_0x0082:
            r2 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r2 == 0) goto L_0x0088
            r2 = 0
            goto L_0x008a
        L_0x0088:
            r2 = r32
        L_0x008a:
            r6 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x0095
            androidx.compose.material3.TextFieldDefaults r6 = androidx.compose.material3.TextFieldDefaults.INSTANCE
            float r6 = r6.m1909getFocusedBorderThicknessD9Ej5fM()
            goto L_0x0097
        L_0x0095:
            r6 = r33
        L_0x0097:
            r16 = 32768(0x8000, float:4.5918E-41)
            r16 = r0 & r16
            if (r16 == 0) goto L_0x00a5
            androidx.compose.material3.TextFieldDefaults r16 = androidx.compose.material3.TextFieldDefaults.INSTANCE
            float r16 = r16.m1912getUnfocusedBorderThicknessD9Ej5fM()
            goto L_0x00a7
        L_0x00a5:
            r16 = r34
        L_0x00a7:
            r17 = 65536(0x10000, float:9.18355E-41)
            r0 = r0 & r17
            if (r0 == 0) goto L_0x00af
            r0 = 0
            goto L_0x00b1
        L_0x00af:
            r0 = r35
        L_0x00b1:
            r17 = 0
            r37 = r17
            r19 = r18
            r20 = r1
            r21 = r4
            r22 = r5
            r23 = r7
            r24 = r8
            r25 = r9
            r26 = r10
            r27 = r11
            r28 = r3
            r29 = r12
            r30 = r13
            r31 = r14
            r32 = r15
            r33 = r2
            r34 = r6
            r35 = r16
            r36 = r0
            r19.<init>(r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.view.InputFieldViewStyle.<init>(androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.ui.graphics.Shape, com.checkout.frames.model.InputFieldColors, float, float, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
