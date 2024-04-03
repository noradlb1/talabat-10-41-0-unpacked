package com.checkout.frames.view;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.runtime.Composer;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.input.VisualTransformation;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class InputFieldKt$DecorationBox$2 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ int $$changed;
    final /* synthetic */ int $$changed1;
    final /* synthetic */ Shape $borderShape;
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ float $focusedBorderThickness;
    final /* synthetic */ Function2<Composer, Integer, Unit> $innerTextField;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ boolean $isError;
    final /* synthetic */ Function2<Composer, Integer, Unit> $leadingIcon;
    final /* synthetic */ Function2<Composer, Integer, Unit> $placeholder;
    final /* synthetic */ boolean $singleLine;
    final /* synthetic */ Function2<Composer, Integer, Unit> $trailingIcon;
    final /* synthetic */ float $unfocusedBorderThickness;
    final /* synthetic */ String $value;
    final /* synthetic */ VisualTransformation $visualTransformation;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputFieldKt$DecorationBox$2(String str, VisualTransformation visualTransformation, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function22, Function2<? super Composer, ? super Integer, Unit> function23, Function2<? super Composer, ? super Integer, Unit> function24, boolean z11, boolean z12, boolean z13, MutableInteractionSource mutableInteractionSource, TextFieldColors textFieldColors, Shape shape, float f11, float f12, int i11, int i12) {
        super(2);
        this.$value = str;
        this.$visualTransformation = visualTransformation;
        this.$innerTextField = function2;
        this.$placeholder = function22;
        this.$leadingIcon = function23;
        this.$trailingIcon = function24;
        this.$singleLine = z11;
        this.$enabled = z12;
        this.$isError = z13;
        this.$interactionSource = mutableInteractionSource;
        this.$colors = textFieldColors;
        this.$borderShape = shape;
        this.$focusedBorderThickness = f11;
        this.$unfocusedBorderThickness = f12;
        this.$$changed = i11;
        this.$$changed1 = i12;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        String str = this.$value;
        String str2 = str;
        InputFieldKt.m9333DecorationBoxAsBZNLQ(str2, this.$visualTransformation, this.$innerTextField, this.$placeholder, this.$leadingIcon, this.$trailingIcon, this.$singleLine, this.$enabled, this.$isError, this.$interactionSource, this.$colors, this.$borderShape, this.$focusedBorderThickness, this.$unfocusedBorderThickness, composer2, this.$$changed | 1, this.$$changed1);
    }
}
