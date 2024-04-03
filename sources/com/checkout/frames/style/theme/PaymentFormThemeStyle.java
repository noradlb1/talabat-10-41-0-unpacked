package com.checkout.frames.style.theme;

import com.checkout.frames.style.component.base.ButtonStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.InputFieldIndicatorStyle;
import com.checkout.frames.style.component.base.TextStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0002\u0010\u0012J\u000b\u0010#\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010$\u001a\u00020\fHÆ\u0003J\t\u0010%\u001a\u00020\u0010HÆ\u0003J\t\u0010&\u001a\u00020\u0010HÆ\u0003J\u000b\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010(\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010,\u001a\u00020\nHÆ\u0003J\t\u0010-\u001a\u00020\fHÆ\u0003J\t\u0010.\u001a\u00020\fHÆ\u0003J\u0001\u0010/\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010HÆ\u0001J\u0013\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00103\u001a\u000204HÖ\u0001J\t\u00105\u001a\u000206HÖ\u0001R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0011\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0014R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0018R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0016R\u0011\u0010\u000e\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016¨\u00067"}, d2 = {"Lcom/checkout/frames/style/theme/PaymentFormThemeStyle;", "", "titleTextStyle", "Lcom/checkout/frames/style/component/base/TextStyle;", "subTitleTextStyle", "infoTextStyle", "inputFieldTextStyle", "errorMessageTextStyle", "addressTextStyle", "inputFieldIndicatorStyle", "Lcom/checkout/frames/style/component/base/InputFieldIndicatorStyle;", "addAddressButtonStyle", "Lcom/checkout/frames/style/component/base/ButtonStyle;", "editAddressButtonStyle", "paymentDetailsButtonStyle", "inputFieldContainerStyle", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "containerStyle", "(Lcom/checkout/frames/style/component/base/TextStyle;Lcom/checkout/frames/style/component/base/TextStyle;Lcom/checkout/frames/style/component/base/TextStyle;Lcom/checkout/frames/style/component/base/TextStyle;Lcom/checkout/frames/style/component/base/TextStyle;Lcom/checkout/frames/style/component/base/TextStyle;Lcom/checkout/frames/style/component/base/InputFieldIndicatorStyle;Lcom/checkout/frames/style/component/base/ButtonStyle;Lcom/checkout/frames/style/component/base/ButtonStyle;Lcom/checkout/frames/style/component/base/ButtonStyle;Lcom/checkout/frames/style/component/base/ContainerStyle;Lcom/checkout/frames/style/component/base/ContainerStyle;)V", "getAddAddressButtonStyle", "()Lcom/checkout/frames/style/component/base/ButtonStyle;", "getAddressTextStyle", "()Lcom/checkout/frames/style/component/base/TextStyle;", "getContainerStyle", "()Lcom/checkout/frames/style/component/base/ContainerStyle;", "getEditAddressButtonStyle", "getErrorMessageTextStyle", "getInfoTextStyle", "getInputFieldContainerStyle", "getInputFieldIndicatorStyle", "()Lcom/checkout/frames/style/component/base/InputFieldIndicatorStyle;", "getInputFieldTextStyle", "getPaymentDetailsButtonStyle", "getSubTitleTextStyle", "getTitleTextStyle", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PaymentFormThemeStyle {
    @NotNull
    private final ButtonStyle addAddressButtonStyle;
    @Nullable
    private final TextStyle addressTextStyle;
    @NotNull
    private final ContainerStyle containerStyle;
    @NotNull
    private final ButtonStyle editAddressButtonStyle;
    @Nullable
    private final TextStyle errorMessageTextStyle;
    @Nullable
    private final TextStyle infoTextStyle;
    @NotNull
    private final ContainerStyle inputFieldContainerStyle;
    @NotNull
    private final InputFieldIndicatorStyle inputFieldIndicatorStyle;
    @NotNull
    private final TextStyle inputFieldTextStyle;
    @NotNull
    private final ButtonStyle paymentDetailsButtonStyle;
    @Nullable
    private final TextStyle subTitleTextStyle;
    @Nullable
    private final TextStyle titleTextStyle;

    public PaymentFormThemeStyle(@Nullable TextStyle textStyle, @Nullable TextStyle textStyle2, @Nullable TextStyle textStyle3, @NotNull TextStyle textStyle4, @Nullable TextStyle textStyle5, @Nullable TextStyle textStyle6, @NotNull InputFieldIndicatorStyle inputFieldIndicatorStyle2, @NotNull ButtonStyle buttonStyle, @NotNull ButtonStyle buttonStyle2, @NotNull ButtonStyle buttonStyle3, @NotNull ContainerStyle containerStyle2, @NotNull ContainerStyle containerStyle3) {
        Intrinsics.checkNotNullParameter(textStyle4, "inputFieldTextStyle");
        Intrinsics.checkNotNullParameter(inputFieldIndicatorStyle2, "inputFieldIndicatorStyle");
        Intrinsics.checkNotNullParameter(buttonStyle, "addAddressButtonStyle");
        Intrinsics.checkNotNullParameter(buttonStyle2, "editAddressButtonStyle");
        Intrinsics.checkNotNullParameter(buttonStyle3, "paymentDetailsButtonStyle");
        Intrinsics.checkNotNullParameter(containerStyle2, "inputFieldContainerStyle");
        Intrinsics.checkNotNullParameter(containerStyle3, "containerStyle");
        this.titleTextStyle = textStyle;
        this.subTitleTextStyle = textStyle2;
        this.infoTextStyle = textStyle3;
        this.inputFieldTextStyle = textStyle4;
        this.errorMessageTextStyle = textStyle5;
        this.addressTextStyle = textStyle6;
        this.inputFieldIndicatorStyle = inputFieldIndicatorStyle2;
        this.addAddressButtonStyle = buttonStyle;
        this.editAddressButtonStyle = buttonStyle2;
        this.paymentDetailsButtonStyle = buttonStyle3;
        this.inputFieldContainerStyle = containerStyle2;
        this.containerStyle = containerStyle3;
    }

    public static /* synthetic */ PaymentFormThemeStyle copy$default(PaymentFormThemeStyle paymentFormThemeStyle, TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, InputFieldIndicatorStyle inputFieldIndicatorStyle2, ButtonStyle buttonStyle, ButtonStyle buttonStyle2, ButtonStyle buttonStyle3, ContainerStyle containerStyle2, ContainerStyle containerStyle3, int i11, Object obj) {
        PaymentFormThemeStyle paymentFormThemeStyle2 = paymentFormThemeStyle;
        int i12 = i11;
        return paymentFormThemeStyle.copy((i12 & 1) != 0 ? paymentFormThemeStyle2.titleTextStyle : textStyle, (i12 & 2) != 0 ? paymentFormThemeStyle2.subTitleTextStyle : textStyle2, (i12 & 4) != 0 ? paymentFormThemeStyle2.infoTextStyle : textStyle3, (i12 & 8) != 0 ? paymentFormThemeStyle2.inputFieldTextStyle : textStyle4, (i12 & 16) != 0 ? paymentFormThemeStyle2.errorMessageTextStyle : textStyle5, (i12 & 32) != 0 ? paymentFormThemeStyle2.addressTextStyle : textStyle6, (i12 & 64) != 0 ? paymentFormThemeStyle2.inputFieldIndicatorStyle : inputFieldIndicatorStyle2, (i12 & 128) != 0 ? paymentFormThemeStyle2.addAddressButtonStyle : buttonStyle, (i12 & 256) != 0 ? paymentFormThemeStyle2.editAddressButtonStyle : buttonStyle2, (i12 & 512) != 0 ? paymentFormThemeStyle2.paymentDetailsButtonStyle : buttonStyle3, (i12 & 1024) != 0 ? paymentFormThemeStyle2.inputFieldContainerStyle : containerStyle2, (i12 & 2048) != 0 ? paymentFormThemeStyle2.containerStyle : containerStyle3);
    }

    @Nullable
    public final TextStyle component1() {
        return this.titleTextStyle;
    }

    @NotNull
    public final ButtonStyle component10() {
        return this.paymentDetailsButtonStyle;
    }

    @NotNull
    public final ContainerStyle component11() {
        return this.inputFieldContainerStyle;
    }

    @NotNull
    public final ContainerStyle component12() {
        return this.containerStyle;
    }

    @Nullable
    public final TextStyle component2() {
        return this.subTitleTextStyle;
    }

    @Nullable
    public final TextStyle component3() {
        return this.infoTextStyle;
    }

    @NotNull
    public final TextStyle component4() {
        return this.inputFieldTextStyle;
    }

    @Nullable
    public final TextStyle component5() {
        return this.errorMessageTextStyle;
    }

    @Nullable
    public final TextStyle component6() {
        return this.addressTextStyle;
    }

    @NotNull
    public final InputFieldIndicatorStyle component7() {
        return this.inputFieldIndicatorStyle;
    }

    @NotNull
    public final ButtonStyle component8() {
        return this.addAddressButtonStyle;
    }

    @NotNull
    public final ButtonStyle component9() {
        return this.editAddressButtonStyle;
    }

    @NotNull
    public final PaymentFormThemeStyle copy(@Nullable TextStyle textStyle, @Nullable TextStyle textStyle2, @Nullable TextStyle textStyle3, @NotNull TextStyle textStyle4, @Nullable TextStyle textStyle5, @Nullable TextStyle textStyle6, @NotNull InputFieldIndicatorStyle inputFieldIndicatorStyle2, @NotNull ButtonStyle buttonStyle, @NotNull ButtonStyle buttonStyle2, @NotNull ButtonStyle buttonStyle3, @NotNull ContainerStyle containerStyle2, @NotNull ContainerStyle containerStyle3) {
        TextStyle textStyle7 = textStyle4;
        Intrinsics.checkNotNullParameter(textStyle7, "inputFieldTextStyle");
        InputFieldIndicatorStyle inputFieldIndicatorStyle3 = inputFieldIndicatorStyle2;
        Intrinsics.checkNotNullParameter(inputFieldIndicatorStyle3, "inputFieldIndicatorStyle");
        ButtonStyle buttonStyle4 = buttonStyle;
        Intrinsics.checkNotNullParameter(buttonStyle4, "addAddressButtonStyle");
        ButtonStyle buttonStyle5 = buttonStyle2;
        Intrinsics.checkNotNullParameter(buttonStyle5, "editAddressButtonStyle");
        ButtonStyle buttonStyle6 = buttonStyle3;
        Intrinsics.checkNotNullParameter(buttonStyle6, "paymentDetailsButtonStyle");
        ContainerStyle containerStyle4 = containerStyle2;
        Intrinsics.checkNotNullParameter(containerStyle4, "inputFieldContainerStyle");
        ContainerStyle containerStyle5 = containerStyle3;
        Intrinsics.checkNotNullParameter(containerStyle5, "containerStyle");
        return new PaymentFormThemeStyle(textStyle, textStyle2, textStyle3, textStyle7, textStyle5, textStyle6, inputFieldIndicatorStyle3, buttonStyle4, buttonStyle5, buttonStyle6, containerStyle4, containerStyle5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentFormThemeStyle)) {
            return false;
        }
        PaymentFormThemeStyle paymentFormThemeStyle = (PaymentFormThemeStyle) obj;
        return Intrinsics.areEqual((Object) this.titleTextStyle, (Object) paymentFormThemeStyle.titleTextStyle) && Intrinsics.areEqual((Object) this.subTitleTextStyle, (Object) paymentFormThemeStyle.subTitleTextStyle) && Intrinsics.areEqual((Object) this.infoTextStyle, (Object) paymentFormThemeStyle.infoTextStyle) && Intrinsics.areEqual((Object) this.inputFieldTextStyle, (Object) paymentFormThemeStyle.inputFieldTextStyle) && Intrinsics.areEqual((Object) this.errorMessageTextStyle, (Object) paymentFormThemeStyle.errorMessageTextStyle) && Intrinsics.areEqual((Object) this.addressTextStyle, (Object) paymentFormThemeStyle.addressTextStyle) && Intrinsics.areEqual((Object) this.inputFieldIndicatorStyle, (Object) paymentFormThemeStyle.inputFieldIndicatorStyle) && Intrinsics.areEqual((Object) this.addAddressButtonStyle, (Object) paymentFormThemeStyle.addAddressButtonStyle) && Intrinsics.areEqual((Object) this.editAddressButtonStyle, (Object) paymentFormThemeStyle.editAddressButtonStyle) && Intrinsics.areEqual((Object) this.paymentDetailsButtonStyle, (Object) paymentFormThemeStyle.paymentDetailsButtonStyle) && Intrinsics.areEqual((Object) this.inputFieldContainerStyle, (Object) paymentFormThemeStyle.inputFieldContainerStyle) && Intrinsics.areEqual((Object) this.containerStyle, (Object) paymentFormThemeStyle.containerStyle);
    }

    @NotNull
    public final ButtonStyle getAddAddressButtonStyle() {
        return this.addAddressButtonStyle;
    }

    @Nullable
    public final TextStyle getAddressTextStyle() {
        return this.addressTextStyle;
    }

    @NotNull
    public final ContainerStyle getContainerStyle() {
        return this.containerStyle;
    }

    @NotNull
    public final ButtonStyle getEditAddressButtonStyle() {
        return this.editAddressButtonStyle;
    }

    @Nullable
    public final TextStyle getErrorMessageTextStyle() {
        return this.errorMessageTextStyle;
    }

    @Nullable
    public final TextStyle getInfoTextStyle() {
        return this.infoTextStyle;
    }

    @NotNull
    public final ContainerStyle getInputFieldContainerStyle() {
        return this.inputFieldContainerStyle;
    }

    @NotNull
    public final InputFieldIndicatorStyle getInputFieldIndicatorStyle() {
        return this.inputFieldIndicatorStyle;
    }

    @NotNull
    public final TextStyle getInputFieldTextStyle() {
        return this.inputFieldTextStyle;
    }

    @NotNull
    public final ButtonStyle getPaymentDetailsButtonStyle() {
        return this.paymentDetailsButtonStyle;
    }

    @Nullable
    public final TextStyle getSubTitleTextStyle() {
        return this.subTitleTextStyle;
    }

    @Nullable
    public final TextStyle getTitleTextStyle() {
        return this.titleTextStyle;
    }

    public int hashCode() {
        TextStyle textStyle = this.titleTextStyle;
        int i11 = 0;
        int hashCode = (textStyle == null ? 0 : textStyle.hashCode()) * 31;
        TextStyle textStyle2 = this.subTitleTextStyle;
        int hashCode2 = (hashCode + (textStyle2 == null ? 0 : textStyle2.hashCode())) * 31;
        TextStyle textStyle3 = this.infoTextStyle;
        int hashCode3 = (((hashCode2 + (textStyle3 == null ? 0 : textStyle3.hashCode())) * 31) + this.inputFieldTextStyle.hashCode()) * 31;
        TextStyle textStyle4 = this.errorMessageTextStyle;
        int hashCode4 = (hashCode3 + (textStyle4 == null ? 0 : textStyle4.hashCode())) * 31;
        TextStyle textStyle5 = this.addressTextStyle;
        if (textStyle5 != null) {
            i11 = textStyle5.hashCode();
        }
        return ((((((((((((hashCode4 + i11) * 31) + this.inputFieldIndicatorStyle.hashCode()) * 31) + this.addAddressButtonStyle.hashCode()) * 31) + this.editAddressButtonStyle.hashCode()) * 31) + this.paymentDetailsButtonStyle.hashCode()) * 31) + this.inputFieldContainerStyle.hashCode()) * 31) + this.containerStyle.hashCode();
    }

    @NotNull
    public String toString() {
        TextStyle textStyle = this.titleTextStyle;
        TextStyle textStyle2 = this.subTitleTextStyle;
        TextStyle textStyle3 = this.infoTextStyle;
        TextStyle textStyle4 = this.inputFieldTextStyle;
        TextStyle textStyle5 = this.errorMessageTextStyle;
        TextStyle textStyle6 = this.addressTextStyle;
        InputFieldIndicatorStyle inputFieldIndicatorStyle2 = this.inputFieldIndicatorStyle;
        ButtonStyle buttonStyle = this.addAddressButtonStyle;
        ButtonStyle buttonStyle2 = this.editAddressButtonStyle;
        ButtonStyle buttonStyle3 = this.paymentDetailsButtonStyle;
        ContainerStyle containerStyle2 = this.inputFieldContainerStyle;
        ContainerStyle containerStyle3 = this.containerStyle;
        return "PaymentFormThemeStyle(titleTextStyle=" + textStyle + ", subTitleTextStyle=" + textStyle2 + ", infoTextStyle=" + textStyle3 + ", inputFieldTextStyle=" + textStyle4 + ", errorMessageTextStyle=" + textStyle5 + ", addressTextStyle=" + textStyle6 + ", inputFieldIndicatorStyle=" + inputFieldIndicatorStyle2 + ", addAddressButtonStyle=" + buttonStyle + ", editAddressButtonStyle=" + buttonStyle2 + ", paymentDetailsButtonStyle=" + buttonStyle3 + ", inputFieldContainerStyle=" + containerStyle2 + ", containerStyle=" + containerStyle3 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ PaymentFormThemeStyle(com.checkout.frames.style.component.base.TextStyle r32, com.checkout.frames.style.component.base.TextStyle r33, com.checkout.frames.style.component.base.TextStyle r34, com.checkout.frames.style.component.base.TextStyle r35, com.checkout.frames.style.component.base.TextStyle r36, com.checkout.frames.style.component.base.TextStyle r37, com.checkout.frames.style.component.base.InputFieldIndicatorStyle r38, com.checkout.frames.style.component.base.ButtonStyle r39, com.checkout.frames.style.component.base.ButtonStyle r40, com.checkout.frames.style.component.base.ButtonStyle r41, com.checkout.frames.style.component.base.ContainerStyle r42, com.checkout.frames.style.component.base.ContainerStyle r43, int r44, kotlin.jvm.internal.DefaultConstructorMarker r45) {
        /*
            r31 = this;
            r0 = r44
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r4 = r2
            goto L_0x000b
        L_0x0009:
            r4 = r32
        L_0x000b:
            r1 = r0 & 2
            if (r1 == 0) goto L_0x0011
            r5 = r2
            goto L_0x0013
        L_0x0011:
            r5 = r33
        L_0x0013:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0019
            r6 = r2
            goto L_0x001b
        L_0x0019:
            r6 = r34
        L_0x001b:
            r1 = r0 & 8
            if (r1 == 0) goto L_0x0036
            com.checkout.frames.style.component.base.TextStyle r1 = new com.checkout.frames.style.component.base.TextStyle
            r8 = 0
            r9 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 511(0x1ff, float:7.16E-43)
            r19 = 0
            r7 = r1
            r7.<init>(r8, r9, r11, r12, r13, r14, r15, r16, r17, r18, r19)
            goto L_0x0038
        L_0x0036:
            r7 = r35
        L_0x0038:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x003e
            r8 = r2
            goto L_0x0040
        L_0x003e:
            r8 = r36
        L_0x0040:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0046
            r9 = r2
            goto L_0x0048
        L_0x0046:
            r9 = r37
        L_0x0048:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x006e
            com.checkout.frames.style.component.base.ButtonStyle r1 = new com.checkout.frames.style.component.base.ButtonStyle
            r10 = r1
            r11 = 0
            r13 = 0
            r15 = 0
            r17 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 2047(0x7ff, float:2.868E-42)
            r27 = 0
            r10.<init>(r11, r13, r15, r17, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            r11 = r1
            goto L_0x0070
        L_0x006e:
            r11 = r39
        L_0x0070:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x0095
            com.checkout.frames.style.component.base.ButtonStyle r1 = new com.checkout.frames.style.component.base.ButtonStyle
            r12 = r1
            r13 = 0
            r15 = 0
            r17 = 0
            r19 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 2047(0x7ff, float:2.868E-42)
            r29 = 0
            r12.<init>(r13, r15, r17, r19, r21, r22, r23, r24, r25, r26, r27, r28, r29)
            goto L_0x0097
        L_0x0095:
            r12 = r40
        L_0x0097:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x00bc
            com.checkout.frames.style.component.base.ButtonStyle r1 = new com.checkout.frames.style.component.base.ButtonStyle
            r13 = r1
            r14 = 0
            r16 = 0
            r18 = 0
            r20 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 2047(0x7ff, float:2.868E-42)
            r30 = 0
            r13.<init>(r14, r16, r18, r20, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            goto L_0x00be
        L_0x00bc:
            r13 = r41
        L_0x00be:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x00dd
            com.checkout.frames.style.component.base.ContainerStyle r1 = new com.checkout.frames.style.component.base.ContainerStyle
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
            r14 = r1
            r14.<init>(r15, r17, r18, r19, r20, r21, r22, r23, r24, r25)
            goto L_0x00df
        L_0x00dd:
            r14 = r42
        L_0x00df:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x00fe
            com.checkout.frames.style.component.base.ContainerStyle r0 = new com.checkout.frames.style.component.base.ContainerStyle
            r16 = 0
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 255(0xff, float:3.57E-43)
            r26 = 0
            r15 = r0
            r15.<init>(r16, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            goto L_0x0100
        L_0x00fe:
            r15 = r43
        L_0x0100:
            r3 = r31
            r10 = r38
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.theme.PaymentFormThemeStyle.<init>(com.checkout.frames.style.component.base.TextStyle, com.checkout.frames.style.component.base.TextStyle, com.checkout.frames.style.component.base.TextStyle, com.checkout.frames.style.component.base.TextStyle, com.checkout.frames.style.component.base.TextStyle, com.checkout.frames.style.component.base.TextStyle, com.checkout.frames.style.component.base.InputFieldIndicatorStyle, com.checkout.frames.style.component.base.ButtonStyle, com.checkout.frames.style.component.base.ButtonStyle, com.checkout.frames.style.component.base.ButtonStyle, com.checkout.frames.style.component.base.ContainerStyle, com.checkout.frames.style.component.base.ContainerStyle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
