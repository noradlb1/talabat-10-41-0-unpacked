package com.checkout.frames.style.view;

import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/checkout/frames/style/view/CardSchemeComponentViewStyle;", "", "titleStyle", "Lcom/checkout/frames/style/view/TextLabelViewStyle;", "containerModifier", "Landroidx/compose/ui/Modifier;", "flowRowViewStyle", "Lcom/checkout/frames/style/view/FlowRowViewStyle;", "(Lcom/checkout/frames/style/view/TextLabelViewStyle;Landroidx/compose/ui/Modifier;Lcom/checkout/frames/style/view/FlowRowViewStyle;)V", "getContainerModifier", "()Landroidx/compose/ui/Modifier;", "getFlowRowViewStyle", "()Lcom/checkout/frames/style/view/FlowRowViewStyle;", "getTitleStyle", "()Lcom/checkout/frames/style/view/TextLabelViewStyle;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CardSchemeComponentViewStyle {
    @NotNull
    private final Modifier containerModifier;
    @NotNull
    private final FlowRowViewStyle flowRowViewStyle;
    @NotNull
    private final TextLabelViewStyle titleStyle;

    public CardSchemeComponentViewStyle(@NotNull TextLabelViewStyle textLabelViewStyle, @NotNull Modifier modifier, @NotNull FlowRowViewStyle flowRowViewStyle2) {
        Intrinsics.checkNotNullParameter(textLabelViewStyle, "titleStyle");
        Intrinsics.checkNotNullParameter(modifier, "containerModifier");
        Intrinsics.checkNotNullParameter(flowRowViewStyle2, "flowRowViewStyle");
        this.titleStyle = textLabelViewStyle;
        this.containerModifier = modifier;
        this.flowRowViewStyle = flowRowViewStyle2;
    }

    public static /* synthetic */ CardSchemeComponentViewStyle copy$default(CardSchemeComponentViewStyle cardSchemeComponentViewStyle, TextLabelViewStyle textLabelViewStyle, Modifier modifier, FlowRowViewStyle flowRowViewStyle2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            textLabelViewStyle = cardSchemeComponentViewStyle.titleStyle;
        }
        if ((i11 & 2) != 0) {
            modifier = cardSchemeComponentViewStyle.containerModifier;
        }
        if ((i11 & 4) != 0) {
            flowRowViewStyle2 = cardSchemeComponentViewStyle.flowRowViewStyle;
        }
        return cardSchemeComponentViewStyle.copy(textLabelViewStyle, modifier, flowRowViewStyle2);
    }

    @NotNull
    public final TextLabelViewStyle component1() {
        return this.titleStyle;
    }

    @NotNull
    public final Modifier component2() {
        return this.containerModifier;
    }

    @NotNull
    public final FlowRowViewStyle component3() {
        return this.flowRowViewStyle;
    }

    @NotNull
    public final CardSchemeComponentViewStyle copy(@NotNull TextLabelViewStyle textLabelViewStyle, @NotNull Modifier modifier, @NotNull FlowRowViewStyle flowRowViewStyle2) {
        Intrinsics.checkNotNullParameter(textLabelViewStyle, "titleStyle");
        Intrinsics.checkNotNullParameter(modifier, "containerModifier");
        Intrinsics.checkNotNullParameter(flowRowViewStyle2, "flowRowViewStyle");
        return new CardSchemeComponentViewStyle(textLabelViewStyle, modifier, flowRowViewStyle2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardSchemeComponentViewStyle)) {
            return false;
        }
        CardSchemeComponentViewStyle cardSchemeComponentViewStyle = (CardSchemeComponentViewStyle) obj;
        return Intrinsics.areEqual((Object) this.titleStyle, (Object) cardSchemeComponentViewStyle.titleStyle) && Intrinsics.areEqual((Object) this.containerModifier, (Object) cardSchemeComponentViewStyle.containerModifier) && Intrinsics.areEqual((Object) this.flowRowViewStyle, (Object) cardSchemeComponentViewStyle.flowRowViewStyle);
    }

    @NotNull
    public final Modifier getContainerModifier() {
        return this.containerModifier;
    }

    @NotNull
    public final FlowRowViewStyle getFlowRowViewStyle() {
        return this.flowRowViewStyle;
    }

    @NotNull
    public final TextLabelViewStyle getTitleStyle() {
        return this.titleStyle;
    }

    public int hashCode() {
        return (((this.titleStyle.hashCode() * 31) + this.containerModifier.hashCode()) * 31) + this.flowRowViewStyle.hashCode();
    }

    @NotNull
    public String toString() {
        TextLabelViewStyle textLabelViewStyle = this.titleStyle;
        Modifier modifier = this.containerModifier;
        FlowRowViewStyle flowRowViewStyle2 = this.flowRowViewStyle;
        return "CardSchemeComponentViewStyle(titleStyle=" + textLabelViewStyle + ", containerModifier=" + modifier + ", flowRowViewStyle=" + flowRowViewStyle2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CardSchemeComponentViewStyle(TextLabelViewStyle textLabelViewStyle, Modifier modifier, FlowRowViewStyle flowRowViewStyle2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(textLabelViewStyle, (i11 & 2) != 0 ? Modifier.Companion : modifier, flowRowViewStyle2);
    }
}
