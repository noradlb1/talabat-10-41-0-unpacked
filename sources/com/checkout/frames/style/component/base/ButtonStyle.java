package com.checkout.frames.style.component.base;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.model.BorderStroke;
import com.checkout.frames.model.ButtonElevation;
import com.checkout.frames.model.CornerRadius;
import com.checkout.frames.model.Padding;
import com.checkout.frames.model.Shape;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001Bw\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014¢\u0006\u0002\u0010\u0015J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0012HÆ\u0003J\t\u0010+\u001a\u00020\u0014HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\bHÆ\u0003J\t\u00100\u001a\u00020\nHÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\fHÆ\u0003J\t\u00102\u001a\u00020\u000eHÆ\u0003J\t\u00103\u001a\u00020\u0010HÆ\u0003Jy\u00104\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u0014HÆ\u0001J\u0013\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00108\u001a\u000209HÖ\u0001J\t\u0010:\u001a\u00020;HÖ\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u0013\u001a\u00020\u0014¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001bR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0011\u001a\u00020\u0012¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u0006<"}, d2 = {"Lcom/checkout/frames/style/component/base/ButtonStyle;", "", "containerColor", "", "disabledContainerColor", "contentColor", "disabledContentColor", "shape", "Lcom/checkout/frames/model/Shape;", "cornerRadius", "Lcom/checkout/frames/model/CornerRadius;", "borderStroke", "Lcom/checkout/frames/model/BorderStroke;", "buttonElevation", "Lcom/checkout/frames/model/ButtonElevation;", "contentPadding", "Lcom/checkout/frames/model/Padding;", "textStyle", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "containerStyle", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "(JJJJLcom/checkout/frames/model/Shape;Lcom/checkout/frames/model/CornerRadius;Lcom/checkout/frames/model/BorderStroke;Lcom/checkout/frames/model/ButtonElevation;Lcom/checkout/frames/model/Padding;Lcom/checkout/frames/style/component/base/TextLabelStyle;Lcom/checkout/frames/style/component/base/ContainerStyle;)V", "getBorderStroke", "()Lcom/checkout/frames/model/BorderStroke;", "getButtonElevation", "()Lcom/checkout/frames/model/ButtonElevation;", "getContainerColor", "()J", "getContainerStyle", "()Lcom/checkout/frames/style/component/base/ContainerStyle;", "getContentColor", "getContentPadding", "()Lcom/checkout/frames/model/Padding;", "getCornerRadius", "()Lcom/checkout/frames/model/CornerRadius;", "getDisabledContainerColor", "getDisabledContentColor", "getShape", "()Lcom/checkout/frames/model/Shape;", "getTextStyle", "()Lcom/checkout/frames/style/component/base/TextLabelStyle;", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class ButtonStyle {
    public static final int $stable = 8;
    @Nullable
    private final BorderStroke borderStroke;
    @NotNull
    private final ButtonElevation buttonElevation;
    private final long containerColor;
    @NotNull
    private final ContainerStyle containerStyle;
    private final long contentColor;
    @NotNull
    private final Padding contentPadding;
    @NotNull
    private final CornerRadius cornerRadius;
    private final long disabledContainerColor;
    private final long disabledContentColor;
    @NotNull
    private final Shape shape;
    @NotNull
    private final TextLabelStyle textStyle;

    @JvmOverloads
    public ButtonStyle() {
        this(0, 0, 0, 0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (ButtonElevation) null, (Padding) null, (TextLabelStyle) null, (ContainerStyle) null, 2047, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public ButtonStyle(long j11) {
        this(j11, 0, 0, 0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (ButtonElevation) null, (Padding) null, (TextLabelStyle) null, (ContainerStyle) null, 2046, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public ButtonStyle(long j11, long j12) {
        this(j11, j12, 0, 0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (ButtonElevation) null, (Padding) null, (TextLabelStyle) null, (ContainerStyle) null, 2044, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public ButtonStyle(long j11, long j12, long j13) {
        this(j11, j12, j13, 0, (Shape) null, (CornerRadius) null, (BorderStroke) null, (ButtonElevation) null, (Padding) null, (TextLabelStyle) null, (ContainerStyle) null, 2040, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public ButtonStyle(long j11, long j12, long j13, long j14) {
        this(j11, j12, j13, j14, (Shape) null, (CornerRadius) null, (BorderStroke) null, (ButtonElevation) null, (Padding) null, (TextLabelStyle) null, (ContainerStyle) null, 2032, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ButtonStyle(long j11, long j12, long j13, long j14, @NotNull Shape shape2) {
        this(j11, j12, j13, j14, shape2, (CornerRadius) null, (BorderStroke) null, (ButtonElevation) null, (Padding) null, (TextLabelStyle) null, (ContainerStyle) null, 2016, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(shape2, "shape");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ButtonStyle(long j11, long j12, long j13, long j14, @NotNull Shape shape2, @NotNull CornerRadius cornerRadius2) {
        this(j11, j12, j13, j14, shape2, cornerRadius2, (BorderStroke) null, (ButtonElevation) null, (Padding) null, (TextLabelStyle) null, (ContainerStyle) null, 1984, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(shape2, "shape");
        Intrinsics.checkNotNullParameter(cornerRadius2, "cornerRadius");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ButtonStyle(long j11, long j12, long j13, long j14, @NotNull Shape shape2, @NotNull CornerRadius cornerRadius2, @Nullable BorderStroke borderStroke2) {
        this(j11, j12, j13, j14, shape2, cornerRadius2, borderStroke2, (ButtonElevation) null, (Padding) null, (TextLabelStyle) null, (ContainerStyle) null, 1920, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(shape2, "shape");
        Intrinsics.checkNotNullParameter(cornerRadius2, "cornerRadius");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ButtonStyle(long j11, long j12, long j13, long j14, @NotNull Shape shape2, @NotNull CornerRadius cornerRadius2, @Nullable BorderStroke borderStroke2, @NotNull ButtonElevation buttonElevation2) {
        this(j11, j12, j13, j14, shape2, cornerRadius2, borderStroke2, buttonElevation2, (Padding) null, (TextLabelStyle) null, (ContainerStyle) null, 1792, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(shape2, "shape");
        Intrinsics.checkNotNullParameter(cornerRadius2, "cornerRadius");
        Intrinsics.checkNotNullParameter(buttonElevation2, "buttonElevation");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ButtonStyle(long j11, long j12, long j13, long j14, @NotNull Shape shape2, @NotNull CornerRadius cornerRadius2, @Nullable BorderStroke borderStroke2, @NotNull ButtonElevation buttonElevation2, @NotNull Padding padding) {
        this(j11, j12, j13, j14, shape2, cornerRadius2, borderStroke2, buttonElevation2, padding, (TextLabelStyle) null, (ContainerStyle) null, 1536, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(shape2, "shape");
        Intrinsics.checkNotNullParameter(cornerRadius2, "cornerRadius");
        Intrinsics.checkNotNullParameter(buttonElevation2, "buttonElevation");
        Intrinsics.checkNotNullParameter(padding, "contentPadding");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ButtonStyle(long j11, long j12, long j13, long j14, @NotNull Shape shape2, @NotNull CornerRadius cornerRadius2, @Nullable BorderStroke borderStroke2, @NotNull ButtonElevation buttonElevation2, @NotNull Padding padding, @NotNull TextLabelStyle textLabelStyle) {
        this(j11, j12, j13, j14, shape2, cornerRadius2, borderStroke2, buttonElevation2, padding, textLabelStyle, (ContainerStyle) null, 1024, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(shape2, "shape");
        Intrinsics.checkNotNullParameter(cornerRadius2, "cornerRadius");
        Intrinsics.checkNotNullParameter(buttonElevation2, "buttonElevation");
        Intrinsics.checkNotNullParameter(padding, "contentPadding");
        Intrinsics.checkNotNullParameter(textLabelStyle, "textStyle");
    }

    @JvmOverloads
    public ButtonStyle(long j11, long j12, long j13, long j14, @NotNull Shape shape2, @NotNull CornerRadius cornerRadius2, @Nullable BorderStroke borderStroke2, @NotNull ButtonElevation buttonElevation2, @NotNull Padding padding, @NotNull TextLabelStyle textLabelStyle, @NotNull ContainerStyle containerStyle2) {
        Shape shape3 = shape2;
        CornerRadius cornerRadius3 = cornerRadius2;
        ButtonElevation buttonElevation3 = buttonElevation2;
        Padding padding2 = padding;
        TextLabelStyle textLabelStyle2 = textLabelStyle;
        ContainerStyle containerStyle3 = containerStyle2;
        Intrinsics.checkNotNullParameter(shape3, "shape");
        Intrinsics.checkNotNullParameter(cornerRadius3, "cornerRadius");
        Intrinsics.checkNotNullParameter(buttonElevation3, "buttonElevation");
        Intrinsics.checkNotNullParameter(padding2, "contentPadding");
        Intrinsics.checkNotNullParameter(textLabelStyle2, "textStyle");
        Intrinsics.checkNotNullParameter(containerStyle3, "containerStyle");
        this.containerColor = j11;
        this.disabledContainerColor = j12;
        this.contentColor = j13;
        this.disabledContentColor = j14;
        this.shape = shape3;
        this.cornerRadius = cornerRadius3;
        this.borderStroke = borderStroke2;
        this.buttonElevation = buttonElevation3;
        this.contentPadding = padding2;
        this.textStyle = textLabelStyle2;
        this.containerStyle = containerStyle3;
    }

    public static /* synthetic */ ButtonStyle copy$default(ButtonStyle buttonStyle, long j11, long j12, long j13, long j14, Shape shape2, CornerRadius cornerRadius2, BorderStroke borderStroke2, ButtonElevation buttonElevation2, Padding padding, TextLabelStyle textLabelStyle, ContainerStyle containerStyle2, int i11, Object obj) {
        ButtonStyle buttonStyle2 = buttonStyle;
        int i12 = i11;
        return buttonStyle.copy((i12 & 1) != 0 ? buttonStyle2.containerColor : j11, (i12 & 2) != 0 ? buttonStyle2.disabledContainerColor : j12, (i12 & 4) != 0 ? buttonStyle2.contentColor : j13, (i12 & 8) != 0 ? buttonStyle2.disabledContentColor : j14, (i12 & 16) != 0 ? buttonStyle2.shape : shape2, (i12 & 32) != 0 ? buttonStyle2.cornerRadius : cornerRadius2, (i12 & 64) != 0 ? buttonStyle2.borderStroke : borderStroke2, (i12 & 128) != 0 ? buttonStyle2.buttonElevation : buttonElevation2, (i12 & 256) != 0 ? buttonStyle2.contentPadding : padding, (i12 & 512) != 0 ? buttonStyle2.textStyle : textLabelStyle, (i12 & 1024) != 0 ? buttonStyle2.containerStyle : containerStyle2);
    }

    public final long component1() {
        return this.containerColor;
    }

    @NotNull
    public final TextLabelStyle component10() {
        return this.textStyle;
    }

    @NotNull
    public final ContainerStyle component11() {
        return this.containerStyle;
    }

    public final long component2() {
        return this.disabledContainerColor;
    }

    public final long component3() {
        return this.contentColor;
    }

    public final long component4() {
        return this.disabledContentColor;
    }

    @NotNull
    public final Shape component5() {
        return this.shape;
    }

    @NotNull
    public final CornerRadius component6() {
        return this.cornerRadius;
    }

    @Nullable
    public final BorderStroke component7() {
        return this.borderStroke;
    }

    @NotNull
    public final ButtonElevation component8() {
        return this.buttonElevation;
    }

    @NotNull
    public final Padding component9() {
        return this.contentPadding;
    }

    @NotNull
    public final ButtonStyle copy(long j11, long j12, long j13, long j14, @NotNull Shape shape2, @NotNull CornerRadius cornerRadius2, @Nullable BorderStroke borderStroke2, @NotNull ButtonElevation buttonElevation2, @NotNull Padding padding, @NotNull TextLabelStyle textLabelStyle, @NotNull ContainerStyle containerStyle2) {
        Shape shape3 = shape2;
        Intrinsics.checkNotNullParameter(shape3, "shape");
        CornerRadius cornerRadius3 = cornerRadius2;
        Intrinsics.checkNotNullParameter(cornerRadius3, "cornerRadius");
        ButtonElevation buttonElevation3 = buttonElevation2;
        Intrinsics.checkNotNullParameter(buttonElevation3, "buttonElevation");
        Padding padding2 = padding;
        Intrinsics.checkNotNullParameter(padding2, "contentPadding");
        TextLabelStyle textLabelStyle2 = textLabelStyle;
        Intrinsics.checkNotNullParameter(textLabelStyle2, "textStyle");
        Intrinsics.checkNotNullParameter(containerStyle2, "containerStyle");
        return new ButtonStyle(j11, j12, j13, j14, shape3, cornerRadius3, borderStroke2, buttonElevation3, padding2, textLabelStyle2, containerStyle2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ButtonStyle)) {
            return false;
        }
        ButtonStyle buttonStyle = (ButtonStyle) obj;
        return this.containerColor == buttonStyle.containerColor && this.disabledContainerColor == buttonStyle.disabledContainerColor && this.contentColor == buttonStyle.contentColor && this.disabledContentColor == buttonStyle.disabledContentColor && this.shape == buttonStyle.shape && Intrinsics.areEqual((Object) this.cornerRadius, (Object) buttonStyle.cornerRadius) && Intrinsics.areEqual((Object) this.borderStroke, (Object) buttonStyle.borderStroke) && Intrinsics.areEqual((Object) this.buttonElevation, (Object) buttonStyle.buttonElevation) && Intrinsics.areEqual((Object) this.contentPadding, (Object) buttonStyle.contentPadding) && Intrinsics.areEqual((Object) this.textStyle, (Object) buttonStyle.textStyle) && Intrinsics.areEqual((Object) this.containerStyle, (Object) buttonStyle.containerStyle);
    }

    @Nullable
    public final BorderStroke getBorderStroke() {
        return this.borderStroke;
    }

    @NotNull
    public final ButtonElevation getButtonElevation() {
        return this.buttonElevation;
    }

    public final long getContainerColor() {
        return this.containerColor;
    }

    @NotNull
    public final ContainerStyle getContainerStyle() {
        return this.containerStyle;
    }

    public final long getContentColor() {
        return this.contentColor;
    }

    @NotNull
    public final Padding getContentPadding() {
        return this.contentPadding;
    }

    @NotNull
    public final CornerRadius getCornerRadius() {
        return this.cornerRadius;
    }

    public final long getDisabledContainerColor() {
        return this.disabledContainerColor;
    }

    public final long getDisabledContentColor() {
        return this.disabledContentColor;
    }

    @NotNull
    public final Shape getShape() {
        return this.shape;
    }

    @NotNull
    public final TextLabelStyle getTextStyle() {
        return this.textStyle;
    }

    public int hashCode() {
        int a11 = ((((((((((a.a(this.containerColor) * 31) + a.a(this.disabledContainerColor)) * 31) + a.a(this.contentColor)) * 31) + a.a(this.disabledContentColor)) * 31) + this.shape.hashCode()) * 31) + this.cornerRadius.hashCode()) * 31;
        BorderStroke borderStroke2 = this.borderStroke;
        return ((((((((a11 + (borderStroke2 == null ? 0 : borderStroke2.hashCode())) * 31) + this.buttonElevation.hashCode()) * 31) + this.contentPadding.hashCode()) * 31) + this.textStyle.hashCode()) * 31) + this.containerStyle.hashCode();
    }

    @NotNull
    public String toString() {
        long j11 = this.containerColor;
        long j12 = this.disabledContainerColor;
        long j13 = this.contentColor;
        long j14 = this.disabledContentColor;
        Shape shape2 = this.shape;
        CornerRadius cornerRadius2 = this.cornerRadius;
        BorderStroke borderStroke2 = this.borderStroke;
        ButtonElevation buttonElevation2 = this.buttonElevation;
        Padding padding = this.contentPadding;
        TextLabelStyle textLabelStyle = this.textStyle;
        ContainerStyle containerStyle2 = this.containerStyle;
        return "ButtonStyle(containerColor=" + j11 + ", disabledContainerColor=" + j12 + ", contentColor=" + j13 + ", disabledContentColor=" + j14 + ", shape=" + shape2 + ", cornerRadius=" + cornerRadius2 + ", borderStroke=" + borderStroke2 + ", buttonElevation=" + buttonElevation2 + ", contentPadding=" + padding + ", textStyle=" + textLabelStyle + ", containerStyle=" + containerStyle2 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ButtonStyle(long r27, long r29, long r31, long r33, com.checkout.frames.model.Shape r35, com.checkout.frames.model.CornerRadius r36, com.checkout.frames.model.BorderStroke r37, com.checkout.frames.model.ButtonElevation r38, com.checkout.frames.model.Padding r39, com.checkout.frames.style.component.base.TextLabelStyle r40, com.checkout.frames.style.component.base.ContainerStyle r41, int r42, kotlin.jvm.internal.DefaultConstructorMarker r43) {
        /*
            r26 = this;
            r0 = r42
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x000a
            r4 = r2
            goto L_0x000c
        L_0x000a:
            r4 = r27
        L_0x000c:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0011
            goto L_0x0013
        L_0x0011:
            r2 = r29
        L_0x0013:
            r1 = r0 & 4
            r6 = 4278190080(0xff000000, double:2.113706745E-314)
            if (r1 == 0) goto L_0x001e
            r8 = r6
            goto L_0x0020
        L_0x001e:
            r8 = r31
        L_0x0020:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0025
            goto L_0x0027
        L_0x0025:
            r6 = r33
        L_0x0027:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x002e
            com.checkout.frames.model.Shape r1 = com.checkout.frames.model.Shape.Rectangle
            goto L_0x0030
        L_0x002e:
            r1 = r35
        L_0x0030:
            r10 = r0 & 32
            if (r10 == 0) goto L_0x0050
            com.checkout.frames.model.CornerRadius r10 = new com.checkout.frames.model.CornerRadius
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 15
            r16 = 0
            r27 = r10
            r28 = r11
            r29 = r12
            r30 = r13
            r31 = r14
            r32 = r15
            r33 = r16
            r27.<init>(r28, r29, r30, r31, r32, r33)
            goto L_0x0052
        L_0x0050:
            r10 = r36
        L_0x0052:
            r11 = r0 & 64
            if (r11 == 0) goto L_0x0058
            r11 = 0
            goto L_0x005a
        L_0x0058:
            r11 = r37
        L_0x005a:
            r12 = r0 & 128(0x80, float:1.794E-43)
            if (r12 == 0) goto L_0x007f
            com.checkout.frames.model.ButtonElevation r12 = new com.checkout.frames.model.ButtonElevation
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 31
            r19 = 0
            r27 = r12
            r28 = r13
            r29 = r14
            r30 = r15
            r31 = r16
            r32 = r17
            r33 = r18
            r34 = r19
            r27.<init>(r28, r29, r30, r31, r32, r33, r34)
            goto L_0x0081
        L_0x007f:
            r12 = r38
        L_0x0081:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x00a3
            com.checkout.frames.model.Padding r13 = new com.checkout.frames.model.Padding
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 15
            r19 = 0
            r27 = r13
            r28 = r14
            r29 = r15
            r30 = r16
            r31 = r17
            r32 = r18
            r33 = r19
            r27.<init>(r28, r29, r30, r31, r32, r33)
            goto L_0x00a5
        L_0x00a3:
            r13 = r39
        L_0x00a5:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x00d0
            com.checkout.frames.style.component.base.TextLabelStyle r14 = new com.checkout.frames.style.component.base.TextLabelStyle
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 63
            r22 = 0
            r27 = r14
            r28 = r15
            r29 = r16
            r30 = r17
            r31 = r18
            r32 = r19
            r33 = r20
            r34 = r21
            r35 = r22
            r27.<init>(r28, r29, r30, r31, r32, r33, r34, r35)
            goto L_0x00d2
        L_0x00d0:
            r14 = r40
        L_0x00d2:
            r0 = r0 & 1024(0x400, float:1.435E-42)
            if (r0 == 0) goto L_0x0106
            com.checkout.frames.style.component.base.ContainerStyle r0 = new com.checkout.frames.style.component.base.ContainerStyle
            r15 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 255(0xff, float:3.57E-43)
            r25 = 0
            r27 = r0
            r28 = r15
            r30 = r17
            r31 = r18
            r32 = r19
            r33 = r20
            r34 = r21
            r35 = r22
            r36 = r23
            r37 = r24
            r38 = r25
            r27.<init>(r28, r30, r31, r32, r33, r34, r35, r36, r37, r38)
            goto L_0x0108
        L_0x0106:
            r0 = r41
        L_0x0108:
            r27 = r26
            r28 = r4
            r30 = r2
            r32 = r8
            r34 = r6
            r36 = r1
            r37 = r10
            r38 = r11
            r39 = r12
            r40 = r13
            r41 = r14
            r42 = r0
            r27.<init>(r28, r30, r32, r34, r36, r37, r38, r39, r40, r41, r42)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.ButtonStyle.<init>(long, long, long, long, com.checkout.frames.model.Shape, com.checkout.frames.model.CornerRadius, com.checkout.frames.model.BorderStroke, com.checkout.frames.model.ButtonElevation, com.checkout.frames.model.Padding, com.checkout.frames.style.component.base.TextLabelStyle, com.checkout.frames.style.component.base.ContainerStyle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
