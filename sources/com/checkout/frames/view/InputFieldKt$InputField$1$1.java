package com.checkout.frames.view;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.TextFieldColors;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.VisualTransformation;
import com.checkout.frames.style.view.InputFieldViewStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.apache.commons.compress.archivers.cpio.CpioConstants;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
public final class InputFieldKt$InputField$1$1 extends Lambda implements Function2<Composer, Integer, Unit> {
    final /* synthetic */ TextFieldColors $colors;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ TextStyle $mergedTextStyle;
    final /* synthetic */ Ref.ObjectRef<Modifier> $modifier;
    final /* synthetic */ Function1<String, Unit> $onValueChange;
    final /* synthetic */ InputFieldState $state;
    final /* synthetic */ InputFieldViewStyle $style;
    final /* synthetic */ InputFieldViewStyle $this_with;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InputFieldKt$InputField$1$1(InputFieldState inputFieldState, Ref.ObjectRef<Modifier> objectRef, Function1<? super String, Unit> function1, InputFieldViewStyle inputFieldViewStyle, InputFieldViewStyle inputFieldViewStyle2, TextStyle textStyle, MutableInteractionSource mutableInteractionSource, TextFieldColors textFieldColors) {
        super(2);
        this.$state = inputFieldState;
        this.$modifier = objectRef;
        this.$onValueChange = function1;
        this.$this_with = inputFieldViewStyle;
        this.$style = inputFieldViewStyle2;
        this.$mergedTextStyle = textStyle;
        this.$interactionSource = mutableInteractionSource;
        this.$colors = textFieldColors;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((Composer) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public final void invoke(@Nullable Composer composer, int i11) {
        Composer composer2 = composer;
        if ((i11 & 11) != 2 || !composer.getSkipping()) {
            Function1 access$withMaxLength = InputFieldKt.withMaxLength(this.$onValueChange, this.$state.getMaxLength().getValue());
            boolean enabled = this.$this_with.getEnabled();
            boolean readOnly = this.$this_with.getReadOnly();
            SolidColor solidColor = r6;
            SolidColor solidColor2 = new SolidColor(InputFieldKt.provideCursorColor(this.$style.getColors(), composer2, 0), (DefaultConstructorMarker) null);
            VisualTransformation visualTransformation = this.$this_with.getVisualTransformation();
            KeyboardOptions keyboardOptions = this.$this_with.getKeyboardOptions();
            KeyboardActions keyboardActions = this.$this_with.getKeyboardActions();
            boolean singleLine = this.$this_with.getSingleLine();
            int maxLines = this.$this_with.getMaxLines();
            TextStyle textStyle = this.$mergedTextStyle;
            MutableInteractionSource mutableInteractionSource = this.$interactionSource;
            String value = this.$state.getText().getValue();
            final InputFieldState inputFieldState = this.$state;
            Function1 function1 = access$withMaxLength;
            final InputFieldViewStyle inputFieldViewStyle = this.$this_with;
            Modifier modifier = (Modifier) this.$modifier.element;
            final TextFieldColors textFieldColors = this.$colors;
            final MutableInteractionSource mutableInteractionSource2 = mutableInteractionSource;
            String str = value;
            Function1 function12 = function1;
            Modifier modifier2 = modifier;
            BasicTextFieldKt.BasicTextField(str, (Function1<? super String, Unit>) function12, modifier2, enabled, readOnly, textStyle, keyboardOptions, keyboardActions, singleLine, maxLines, visualTransformation, (Function1<? super TextLayoutResult, Unit>) null, mutableInteractionSource, (Brush) solidColor, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer2, 1668584026, true, new Function3<Function2<? super Composer, ? super Integer, ? extends Unit>, Composer, Integer, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                    invoke((Function2<? super Composer, ? super Integer, Unit>) (Function2) obj, (Composer) obj2, ((Number) obj3).intValue());
                    return Unit.INSTANCE;
                }

                @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
                @Composable
                public final void invoke(@NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i11) {
                    int i12;
                    Function2<? super Composer, ? super Integer, Unit> function22 = function2;
                    Intrinsics.checkNotNullParameter(function22, "innerTextField");
                    Composer composer2 = composer;
                    if ((i11 & 14) == 0) {
                        i12 = i11 | (composer2.changed((Object) function22) ? 4 : 2);
                    } else {
                        i12 = i11;
                    }
                    if ((i12 & 91) != 18 || !composer.getSkipping()) {
                        InputFieldKt.m9333DecorationBoxAsBZNLQ(inputFieldState.getText().getValue(), inputFieldViewStyle.getVisualTransformation(), function2, inputFieldViewStyle.getPlaceholder(), inputFieldState.getLeadingIcon().getValue(), inputFieldState.getTrailingIcon().getValue(), inputFieldViewStyle.getSingleLine(), inputFieldViewStyle.getEnabled(), inputFieldState.isError().getValue().booleanValue(), mutableInteractionSource2, textFieldColors, inputFieldViewStyle.getBorderShape(), inputFieldViewStyle.m9278getFocusedBorderThicknessD9Ej5fM(), inputFieldViewStyle.m9279getUnfocusedBorderThicknessD9Ej5fM(), composer, (i12 << 6) & 896, 0);
                    } else {
                        composer.skipToGroupEnd();
                    }
                }
            }), composer, KeyboardActions.$stable << 21, (int) CpioConstants.C_ISBLK, 2048);
            return;
        }
        composer.skipToGroupEnd();
    }
}
