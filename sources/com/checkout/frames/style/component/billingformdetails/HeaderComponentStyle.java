package com.checkout.frames.style.component.billingformdetails;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.model.BorderStroke;
import com.checkout.frames.model.ButtonElevation;
import com.checkout.frames.model.CornerRadius;
import com.checkout.frames.model.Margin;
import com.checkout.frames.model.Padding;
import com.checkout.frames.model.Shape;
import com.checkout.frames.style.component.base.ButtonStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.ImageStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import com.checkout.frames.style.component.base.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/checkout/frames/style/component/billingformdetails/HeaderComponentStyle;", "", "headerTitleStyle", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "headerButtonStyle", "Lcom/checkout/frames/style/component/base/ButtonStyle;", "headerContainerStyle", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "(Lcom/checkout/frames/style/component/base/TextLabelStyle;Lcom/checkout/frames/style/component/base/ButtonStyle;Lcom/checkout/frames/style/component/base/ContainerStyle;)V", "getHeaderButtonStyle", "()Lcom/checkout/frames/style/component/base/ButtonStyle;", "getHeaderContainerStyle", "()Lcom/checkout/frames/style/component/base/ContainerStyle;", "getHeaderTitleStyle", "()Lcom/checkout/frames/style/component/base/TextLabelStyle;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class HeaderComponentStyle {
    public static final int $stable = 8;
    @NotNull
    private final ButtonStyle headerButtonStyle;
    @NotNull
    private final ContainerStyle headerContainerStyle;
    @NotNull
    private final TextLabelStyle headerTitleStyle;

    @JvmOverloads
    public HeaderComponentStyle() {
        this((TextLabelStyle) null, (ButtonStyle) null, (ContainerStyle) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HeaderComponentStyle(@NotNull TextLabelStyle textLabelStyle) {
        this(textLabelStyle, (ButtonStyle) null, (ContainerStyle) null, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(textLabelStyle, "headerTitleStyle");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public HeaderComponentStyle(@NotNull TextLabelStyle textLabelStyle, @NotNull ButtonStyle buttonStyle) {
        this(textLabelStyle, buttonStyle, (ContainerStyle) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(textLabelStyle, "headerTitleStyle");
        Intrinsics.checkNotNullParameter(buttonStyle, "headerButtonStyle");
    }

    @JvmOverloads
    public HeaderComponentStyle(@NotNull TextLabelStyle textLabelStyle, @NotNull ButtonStyle buttonStyle, @NotNull ContainerStyle containerStyle) {
        Intrinsics.checkNotNullParameter(textLabelStyle, "headerTitleStyle");
        Intrinsics.checkNotNullParameter(buttonStyle, "headerButtonStyle");
        Intrinsics.checkNotNullParameter(containerStyle, "headerContainerStyle");
        this.headerTitleStyle = textLabelStyle;
        this.headerButtonStyle = buttonStyle;
        this.headerContainerStyle = containerStyle;
    }

    public static /* synthetic */ HeaderComponentStyle copy$default(HeaderComponentStyle headerComponentStyle, TextLabelStyle textLabelStyle, ButtonStyle buttonStyle, ContainerStyle containerStyle, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            textLabelStyle = headerComponentStyle.headerTitleStyle;
        }
        if ((i11 & 2) != 0) {
            buttonStyle = headerComponentStyle.headerButtonStyle;
        }
        if ((i11 & 4) != 0) {
            containerStyle = headerComponentStyle.headerContainerStyle;
        }
        return headerComponentStyle.copy(textLabelStyle, buttonStyle, containerStyle);
    }

    @NotNull
    public final TextLabelStyle component1() {
        return this.headerTitleStyle;
    }

    @NotNull
    public final ButtonStyle component2() {
        return this.headerButtonStyle;
    }

    @NotNull
    public final ContainerStyle component3() {
        return this.headerContainerStyle;
    }

    @NotNull
    public final HeaderComponentStyle copy(@NotNull TextLabelStyle textLabelStyle, @NotNull ButtonStyle buttonStyle, @NotNull ContainerStyle containerStyle) {
        Intrinsics.checkNotNullParameter(textLabelStyle, "headerTitleStyle");
        Intrinsics.checkNotNullParameter(buttonStyle, "headerButtonStyle");
        Intrinsics.checkNotNullParameter(containerStyle, "headerContainerStyle");
        return new HeaderComponentStyle(textLabelStyle, buttonStyle, containerStyle);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeaderComponentStyle)) {
            return false;
        }
        HeaderComponentStyle headerComponentStyle = (HeaderComponentStyle) obj;
        return Intrinsics.areEqual((Object) this.headerTitleStyle, (Object) headerComponentStyle.headerTitleStyle) && Intrinsics.areEqual((Object) this.headerButtonStyle, (Object) headerComponentStyle.headerButtonStyle) && Intrinsics.areEqual((Object) this.headerContainerStyle, (Object) headerComponentStyle.headerContainerStyle);
    }

    @NotNull
    public final ButtonStyle getHeaderButtonStyle() {
        return this.headerButtonStyle;
    }

    @NotNull
    public final ContainerStyle getHeaderContainerStyle() {
        return this.headerContainerStyle;
    }

    @NotNull
    public final TextLabelStyle getHeaderTitleStyle() {
        return this.headerTitleStyle;
    }

    public int hashCode() {
        return (((this.headerTitleStyle.hashCode() * 31) + this.headerButtonStyle.hashCode()) * 31) + this.headerContainerStyle.hashCode();
    }

    @NotNull
    public String toString() {
        TextLabelStyle textLabelStyle = this.headerTitleStyle;
        ButtonStyle buttonStyle = this.headerButtonStyle;
        ContainerStyle containerStyle = this.headerContainerStyle;
        return "HeaderComponentStyle(headerTitleStyle=" + textLabelStyle + ", headerButtonStyle=" + buttonStyle + ", headerContainerStyle=" + containerStyle + ")";
    }

    public /* synthetic */ HeaderComponentStyle(TextLabelStyle textLabelStyle, ButtonStyle buttonStyle, ContainerStyle containerStyle, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        HeaderComponentStyle headerComponentStyle;
        ContainerStyle containerStyle2;
        TextLabelStyle textLabelStyle2 = (i11 & 1) != 0 ? new TextLabelStyle((String) null, (Integer) null, (TextStyle) null, (ImageStyle) null, (ImageStyle) null, (ContainerStyle) null, 63, (DefaultConstructorMarker) null) : textLabelStyle;
        ButtonStyle buttonStyle2 = (i11 & 2) != 0 ? new ButtonStyle(0, 0, 0, 0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (ButtonElevation) null, (Padding) null, (TextLabelStyle) null, (ContainerStyle) null, 2047, (DefaultConstructorMarker) null) : buttonStyle;
        if ((i11 & 4) != 0) {
            containerStyle2 = new ContainerStyle(0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (Integer) null, (Integer) null, (Padding) null, (Margin) null, 255, (DefaultConstructorMarker) null);
            headerComponentStyle = this;
        } else {
            headerComponentStyle = this;
            containerStyle2 = containerStyle;
        }
        new HeaderComponentStyle(textLabelStyle2, buttonStyle2, containerStyle2);
    }
}
