package com.checkout.frames.style.view;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.VisualTransformation;
import com.checkout.frames.model.InputFieldColors;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\fHÆ\u0003JO\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010 \u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006&"}, d2 = {"Lcom/checkout/frames/style/view/InputComponentViewStyle;", "", "titleStyle", "Lcom/checkout/frames/style/view/TextLabelViewStyle;", "subtitleStyle", "infoStyle", "inputFieldStyle", "Lcom/checkout/frames/style/view/InputFieldViewStyle;", "errorMessageStyle", "containerModifier", "Landroidx/compose/ui/Modifier;", "isInputFieldOptional", "", "(Lcom/checkout/frames/style/view/TextLabelViewStyle;Lcom/checkout/frames/style/view/TextLabelViewStyle;Lcom/checkout/frames/style/view/TextLabelViewStyle;Lcom/checkout/frames/style/view/InputFieldViewStyle;Lcom/checkout/frames/style/view/TextLabelViewStyle;Landroidx/compose/ui/Modifier;Z)V", "getContainerModifier", "()Landroidx/compose/ui/Modifier;", "getErrorMessageStyle", "()Lcom/checkout/frames/style/view/TextLabelViewStyle;", "getInfoStyle", "getInputFieldStyle", "()Lcom/checkout/frames/style/view/InputFieldViewStyle;", "()Z", "getSubtitleStyle", "getTitleStyle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InputComponentViewStyle {
    @NotNull
    private final Modifier containerModifier;
    @NotNull
    private final TextLabelViewStyle errorMessageStyle;
    @NotNull
    private final TextLabelViewStyle infoStyle;
    @NotNull
    private final InputFieldViewStyle inputFieldStyle;
    private final boolean isInputFieldOptional;
    @NotNull
    private final TextLabelViewStyle subtitleStyle;
    @NotNull
    private final TextLabelViewStyle titleStyle;

    public InputComponentViewStyle(@NotNull TextLabelViewStyle textLabelViewStyle, @NotNull TextLabelViewStyle textLabelViewStyle2, @NotNull TextLabelViewStyle textLabelViewStyle3, @NotNull InputFieldViewStyle inputFieldViewStyle, @NotNull TextLabelViewStyle textLabelViewStyle4, @NotNull Modifier modifier, boolean z11) {
        Intrinsics.checkNotNullParameter(textLabelViewStyle, "titleStyle");
        Intrinsics.checkNotNullParameter(textLabelViewStyle2, "subtitleStyle");
        Intrinsics.checkNotNullParameter(textLabelViewStyle3, "infoStyle");
        Intrinsics.checkNotNullParameter(inputFieldViewStyle, "inputFieldStyle");
        Intrinsics.checkNotNullParameter(textLabelViewStyle4, "errorMessageStyle");
        Intrinsics.checkNotNullParameter(modifier, "containerModifier");
        this.titleStyle = textLabelViewStyle;
        this.subtitleStyle = textLabelViewStyle2;
        this.infoStyle = textLabelViewStyle3;
        this.inputFieldStyle = inputFieldViewStyle;
        this.errorMessageStyle = textLabelViewStyle4;
        this.containerModifier = modifier;
        this.isInputFieldOptional = z11;
    }

    public static /* synthetic */ InputComponentViewStyle copy$default(InputComponentViewStyle inputComponentViewStyle, TextLabelViewStyle textLabelViewStyle, TextLabelViewStyle textLabelViewStyle2, TextLabelViewStyle textLabelViewStyle3, InputFieldViewStyle inputFieldViewStyle, TextLabelViewStyle textLabelViewStyle4, Modifier modifier, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            textLabelViewStyle = inputComponentViewStyle.titleStyle;
        }
        if ((i11 & 2) != 0) {
            textLabelViewStyle2 = inputComponentViewStyle.subtitleStyle;
        }
        TextLabelViewStyle textLabelViewStyle5 = textLabelViewStyle2;
        if ((i11 & 4) != 0) {
            textLabelViewStyle3 = inputComponentViewStyle.infoStyle;
        }
        TextLabelViewStyle textLabelViewStyle6 = textLabelViewStyle3;
        if ((i11 & 8) != 0) {
            inputFieldViewStyle = inputComponentViewStyle.inputFieldStyle;
        }
        InputFieldViewStyle inputFieldViewStyle2 = inputFieldViewStyle;
        if ((i11 & 16) != 0) {
            textLabelViewStyle4 = inputComponentViewStyle.errorMessageStyle;
        }
        TextLabelViewStyle textLabelViewStyle7 = textLabelViewStyle4;
        if ((i11 & 32) != 0) {
            modifier = inputComponentViewStyle.containerModifier;
        }
        Modifier modifier2 = modifier;
        if ((i11 & 64) != 0) {
            z11 = inputComponentViewStyle.isInputFieldOptional;
        }
        return inputComponentViewStyle.copy(textLabelViewStyle, textLabelViewStyle5, textLabelViewStyle6, inputFieldViewStyle2, textLabelViewStyle7, modifier2, z11);
    }

    @NotNull
    public final TextLabelViewStyle component1() {
        return this.titleStyle;
    }

    @NotNull
    public final TextLabelViewStyle component2() {
        return this.subtitleStyle;
    }

    @NotNull
    public final TextLabelViewStyle component3() {
        return this.infoStyle;
    }

    @NotNull
    public final InputFieldViewStyle component4() {
        return this.inputFieldStyle;
    }

    @NotNull
    public final TextLabelViewStyle component5() {
        return this.errorMessageStyle;
    }

    @NotNull
    public final Modifier component6() {
        return this.containerModifier;
    }

    public final boolean component7() {
        return this.isInputFieldOptional;
    }

    @NotNull
    public final InputComponentViewStyle copy(@NotNull TextLabelViewStyle textLabelViewStyle, @NotNull TextLabelViewStyle textLabelViewStyle2, @NotNull TextLabelViewStyle textLabelViewStyle3, @NotNull InputFieldViewStyle inputFieldViewStyle, @NotNull TextLabelViewStyle textLabelViewStyle4, @NotNull Modifier modifier, boolean z11) {
        Intrinsics.checkNotNullParameter(textLabelViewStyle, "titleStyle");
        Intrinsics.checkNotNullParameter(textLabelViewStyle2, "subtitleStyle");
        Intrinsics.checkNotNullParameter(textLabelViewStyle3, "infoStyle");
        Intrinsics.checkNotNullParameter(inputFieldViewStyle, "inputFieldStyle");
        Intrinsics.checkNotNullParameter(textLabelViewStyle4, "errorMessageStyle");
        Intrinsics.checkNotNullParameter(modifier, "containerModifier");
        return new InputComponentViewStyle(textLabelViewStyle, textLabelViewStyle2, textLabelViewStyle3, inputFieldViewStyle, textLabelViewStyle4, modifier, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InputComponentViewStyle)) {
            return false;
        }
        InputComponentViewStyle inputComponentViewStyle = (InputComponentViewStyle) obj;
        return Intrinsics.areEqual((Object) this.titleStyle, (Object) inputComponentViewStyle.titleStyle) && Intrinsics.areEqual((Object) this.subtitleStyle, (Object) inputComponentViewStyle.subtitleStyle) && Intrinsics.areEqual((Object) this.infoStyle, (Object) inputComponentViewStyle.infoStyle) && Intrinsics.areEqual((Object) this.inputFieldStyle, (Object) inputComponentViewStyle.inputFieldStyle) && Intrinsics.areEqual((Object) this.errorMessageStyle, (Object) inputComponentViewStyle.errorMessageStyle) && Intrinsics.areEqual((Object) this.containerModifier, (Object) inputComponentViewStyle.containerModifier) && this.isInputFieldOptional == inputComponentViewStyle.isInputFieldOptional;
    }

    @NotNull
    public final Modifier getContainerModifier() {
        return this.containerModifier;
    }

    @NotNull
    public final TextLabelViewStyle getErrorMessageStyle() {
        return this.errorMessageStyle;
    }

    @NotNull
    public final TextLabelViewStyle getInfoStyle() {
        return this.infoStyle;
    }

    @NotNull
    public final InputFieldViewStyle getInputFieldStyle() {
        return this.inputFieldStyle;
    }

    @NotNull
    public final TextLabelViewStyle getSubtitleStyle() {
        return this.subtitleStyle;
    }

    @NotNull
    public final TextLabelViewStyle getTitleStyle() {
        return this.titleStyle;
    }

    public int hashCode() {
        int hashCode = ((((((((((this.titleStyle.hashCode() * 31) + this.subtitleStyle.hashCode()) * 31) + this.infoStyle.hashCode()) * 31) + this.inputFieldStyle.hashCode()) * 31) + this.errorMessageStyle.hashCode()) * 31) + this.containerModifier.hashCode()) * 31;
        boolean z11 = this.isInputFieldOptional;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    public final boolean isInputFieldOptional() {
        return this.isInputFieldOptional;
    }

    @NotNull
    public String toString() {
        TextLabelViewStyle textLabelViewStyle = this.titleStyle;
        TextLabelViewStyle textLabelViewStyle2 = this.subtitleStyle;
        TextLabelViewStyle textLabelViewStyle3 = this.infoStyle;
        InputFieldViewStyle inputFieldViewStyle = this.inputFieldStyle;
        TextLabelViewStyle textLabelViewStyle4 = this.errorMessageStyle;
        Modifier modifier = this.containerModifier;
        boolean z11 = this.isInputFieldOptional;
        return "InputComponentViewStyle(titleStyle=" + textLabelViewStyle + ", subtitleStyle=" + textLabelViewStyle2 + ", infoStyle=" + textLabelViewStyle3 + ", inputFieldStyle=" + inputFieldViewStyle + ", errorMessageStyle=" + textLabelViewStyle4 + ", containerModifier=" + modifier + ", isInputFieldOptional=" + z11 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ InputComponentViewStyle(TextLabelViewStyle textLabelViewStyle, TextLabelViewStyle textLabelViewStyle2, TextLabelViewStyle textLabelViewStyle3, InputFieldViewStyle inputFieldViewStyle, TextLabelViewStyle textLabelViewStyle4, Modifier modifier, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(textLabelViewStyle, textLabelViewStyle2, textLabelViewStyle3, (i11 & 8) != 0 ? new InputFieldViewStyle((Modifier) null, false, false, (TextStyle) null, (Function2) null, (VisualTransformation) null, (KeyboardOptions) null, (KeyboardActions) null, false, 0, (MutableInteractionSource) null, (Shape) null, (Shape) null, (InputFieldColors) null, 0.0f, 0.0f, false, 131071, (DefaultConstructorMarker) null) : inputFieldViewStyle, textLabelViewStyle4, (i11 & 32) != 0 ? Modifier.Companion : modifier, (i11 & 64) != 0 ? false : z11);
    }
}
