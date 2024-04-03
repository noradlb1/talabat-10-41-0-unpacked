package com.checkout.frames.style.component.addresssummary;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.style.component.base.ButtonStyle;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BG\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\t\u0010\u001c\u001a\u00020\nHÆ\u0003J\t\u0010\u001d\u001a\u00020\fHÆ\u0003JI\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0012R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014¨\u0006%"}, d2 = {"Lcom/checkout/frames/style/component/addresssummary/AddressSummaryComponentStyle;", "", "titleStyle", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "subTitleStyle", "addAddressButtonStyle", "Lcom/checkout/frames/style/component/base/ButtonStyle;", "summarySectionStyle", "Lcom/checkout/frames/style/component/addresssummary/AddressSummarySectionStyle;", "containerStyle", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "isOptional", "", "(Lcom/checkout/frames/style/component/base/TextLabelStyle;Lcom/checkout/frames/style/component/base/TextLabelStyle;Lcom/checkout/frames/style/component/base/ButtonStyle;Lcom/checkout/frames/style/component/addresssummary/AddressSummarySectionStyle;Lcom/checkout/frames/style/component/base/ContainerStyle;Z)V", "getAddAddressButtonStyle", "()Lcom/checkout/frames/style/component/base/ButtonStyle;", "getContainerStyle", "()Lcom/checkout/frames/style/component/base/ContainerStyle;", "()Z", "getSubTitleStyle", "()Lcom/checkout/frames/style/component/base/TextLabelStyle;", "getSummarySectionStyle", "()Lcom/checkout/frames/style/component/addresssummary/AddressSummarySectionStyle;", "getTitleStyle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AddressSummaryComponentStyle {
    public static final int $stable = 8;
    @NotNull
    private final ButtonStyle addAddressButtonStyle;
    @NotNull
    private final ContainerStyle containerStyle;
    private final boolean isOptional;
    @Nullable
    private final TextLabelStyle subTitleStyle;
    @NotNull
    private final AddressSummarySectionStyle summarySectionStyle;
    @Nullable
    private final TextLabelStyle titleStyle;

    @JvmOverloads
    public AddressSummaryComponentStyle() {
        this((TextLabelStyle) null, (TextLabelStyle) null, (ButtonStyle) null, (AddressSummarySectionStyle) null, (ContainerStyle) null, false, 63, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public AddressSummaryComponentStyle(@Nullable TextLabelStyle textLabelStyle) {
        this(textLabelStyle, (TextLabelStyle) null, (ButtonStyle) null, (AddressSummarySectionStyle) null, (ContainerStyle) null, false, 62, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public AddressSummaryComponentStyle(@Nullable TextLabelStyle textLabelStyle, @Nullable TextLabelStyle textLabelStyle2) {
        this(textLabelStyle, textLabelStyle2, (ButtonStyle) null, (AddressSummarySectionStyle) null, (ContainerStyle) null, false, 60, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AddressSummaryComponentStyle(@Nullable TextLabelStyle textLabelStyle, @Nullable TextLabelStyle textLabelStyle2, @NotNull ButtonStyle buttonStyle) {
        this(textLabelStyle, textLabelStyle2, buttonStyle, (AddressSummarySectionStyle) null, (ContainerStyle) null, false, 56, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(buttonStyle, "addAddressButtonStyle");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AddressSummaryComponentStyle(@Nullable TextLabelStyle textLabelStyle, @Nullable TextLabelStyle textLabelStyle2, @NotNull ButtonStyle buttonStyle, @NotNull AddressSummarySectionStyle addressSummarySectionStyle) {
        this(textLabelStyle, textLabelStyle2, buttonStyle, addressSummarySectionStyle, (ContainerStyle) null, false, 48, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(buttonStyle, "addAddressButtonStyle");
        Intrinsics.checkNotNullParameter(addressSummarySectionStyle, "summarySectionStyle");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public AddressSummaryComponentStyle(@Nullable TextLabelStyle textLabelStyle, @Nullable TextLabelStyle textLabelStyle2, @NotNull ButtonStyle buttonStyle, @NotNull AddressSummarySectionStyle addressSummarySectionStyle, @NotNull ContainerStyle containerStyle2) {
        this(textLabelStyle, textLabelStyle2, buttonStyle, addressSummarySectionStyle, containerStyle2, false, 32, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(buttonStyle, "addAddressButtonStyle");
        Intrinsics.checkNotNullParameter(addressSummarySectionStyle, "summarySectionStyle");
        Intrinsics.checkNotNullParameter(containerStyle2, "containerStyle");
    }

    @JvmOverloads
    public AddressSummaryComponentStyle(@Nullable TextLabelStyle textLabelStyle, @Nullable TextLabelStyle textLabelStyle2, @NotNull ButtonStyle buttonStyle, @NotNull AddressSummarySectionStyle addressSummarySectionStyle, @NotNull ContainerStyle containerStyle2, boolean z11) {
        Intrinsics.checkNotNullParameter(buttonStyle, "addAddressButtonStyle");
        Intrinsics.checkNotNullParameter(addressSummarySectionStyle, "summarySectionStyle");
        Intrinsics.checkNotNullParameter(containerStyle2, "containerStyle");
        this.titleStyle = textLabelStyle;
        this.subTitleStyle = textLabelStyle2;
        this.addAddressButtonStyle = buttonStyle;
        this.summarySectionStyle = addressSummarySectionStyle;
        this.containerStyle = containerStyle2;
        this.isOptional = z11;
    }

    public static /* synthetic */ AddressSummaryComponentStyle copy$default(AddressSummaryComponentStyle addressSummaryComponentStyle, TextLabelStyle textLabelStyle, TextLabelStyle textLabelStyle2, ButtonStyle buttonStyle, AddressSummarySectionStyle addressSummarySectionStyle, ContainerStyle containerStyle2, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            textLabelStyle = addressSummaryComponentStyle.titleStyle;
        }
        if ((i11 & 2) != 0) {
            textLabelStyle2 = addressSummaryComponentStyle.subTitleStyle;
        }
        TextLabelStyle textLabelStyle3 = textLabelStyle2;
        if ((i11 & 4) != 0) {
            buttonStyle = addressSummaryComponentStyle.addAddressButtonStyle;
        }
        ButtonStyle buttonStyle2 = buttonStyle;
        if ((i11 & 8) != 0) {
            addressSummarySectionStyle = addressSummaryComponentStyle.summarySectionStyle;
        }
        AddressSummarySectionStyle addressSummarySectionStyle2 = addressSummarySectionStyle;
        if ((i11 & 16) != 0) {
            containerStyle2 = addressSummaryComponentStyle.containerStyle;
        }
        ContainerStyle containerStyle3 = containerStyle2;
        if ((i11 & 32) != 0) {
            z11 = addressSummaryComponentStyle.isOptional;
        }
        return addressSummaryComponentStyle.copy(textLabelStyle, textLabelStyle3, buttonStyle2, addressSummarySectionStyle2, containerStyle3, z11);
    }

    @Nullable
    public final TextLabelStyle component1() {
        return this.titleStyle;
    }

    @Nullable
    public final TextLabelStyle component2() {
        return this.subTitleStyle;
    }

    @NotNull
    public final ButtonStyle component3() {
        return this.addAddressButtonStyle;
    }

    @NotNull
    public final AddressSummarySectionStyle component4() {
        return this.summarySectionStyle;
    }

    @NotNull
    public final ContainerStyle component5() {
        return this.containerStyle;
    }

    public final boolean component6() {
        return this.isOptional;
    }

    @NotNull
    public final AddressSummaryComponentStyle copy(@Nullable TextLabelStyle textLabelStyle, @Nullable TextLabelStyle textLabelStyle2, @NotNull ButtonStyle buttonStyle, @NotNull AddressSummarySectionStyle addressSummarySectionStyle, @NotNull ContainerStyle containerStyle2, boolean z11) {
        Intrinsics.checkNotNullParameter(buttonStyle, "addAddressButtonStyle");
        Intrinsics.checkNotNullParameter(addressSummarySectionStyle, "summarySectionStyle");
        Intrinsics.checkNotNullParameter(containerStyle2, "containerStyle");
        return new AddressSummaryComponentStyle(textLabelStyle, textLabelStyle2, buttonStyle, addressSummarySectionStyle, containerStyle2, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AddressSummaryComponentStyle)) {
            return false;
        }
        AddressSummaryComponentStyle addressSummaryComponentStyle = (AddressSummaryComponentStyle) obj;
        return Intrinsics.areEqual((Object) this.titleStyle, (Object) addressSummaryComponentStyle.titleStyle) && Intrinsics.areEqual((Object) this.subTitleStyle, (Object) addressSummaryComponentStyle.subTitleStyle) && Intrinsics.areEqual((Object) this.addAddressButtonStyle, (Object) addressSummaryComponentStyle.addAddressButtonStyle) && Intrinsics.areEqual((Object) this.summarySectionStyle, (Object) addressSummaryComponentStyle.summarySectionStyle) && Intrinsics.areEqual((Object) this.containerStyle, (Object) addressSummaryComponentStyle.containerStyle) && this.isOptional == addressSummaryComponentStyle.isOptional;
    }

    @NotNull
    public final ButtonStyle getAddAddressButtonStyle() {
        return this.addAddressButtonStyle;
    }

    @NotNull
    public final ContainerStyle getContainerStyle() {
        return this.containerStyle;
    }

    @Nullable
    public final TextLabelStyle getSubTitleStyle() {
        return this.subTitleStyle;
    }

    @NotNull
    public final AddressSummarySectionStyle getSummarySectionStyle() {
        return this.summarySectionStyle;
    }

    @Nullable
    public final TextLabelStyle getTitleStyle() {
        return this.titleStyle;
    }

    public int hashCode() {
        TextLabelStyle textLabelStyle = this.titleStyle;
        int i11 = 0;
        int hashCode = (textLabelStyle == null ? 0 : textLabelStyle.hashCode()) * 31;
        TextLabelStyle textLabelStyle2 = this.subTitleStyle;
        if (textLabelStyle2 != null) {
            i11 = textLabelStyle2.hashCode();
        }
        int hashCode2 = (((((((hashCode + i11) * 31) + this.addAddressButtonStyle.hashCode()) * 31) + this.summarySectionStyle.hashCode()) * 31) + this.containerStyle.hashCode()) * 31;
        boolean z11 = this.isOptional;
        if (z11) {
            z11 = true;
        }
        return hashCode2 + (z11 ? 1 : 0);
    }

    public final boolean isOptional() {
        return this.isOptional;
    }

    @NotNull
    public String toString() {
        TextLabelStyle textLabelStyle = this.titleStyle;
        TextLabelStyle textLabelStyle2 = this.subTitleStyle;
        ButtonStyle buttonStyle = this.addAddressButtonStyle;
        AddressSummarySectionStyle addressSummarySectionStyle = this.summarySectionStyle;
        ContainerStyle containerStyle2 = this.containerStyle;
        boolean z11 = this.isOptional;
        return "AddressSummaryComponentStyle(titleStyle=" + textLabelStyle + ", subTitleStyle=" + textLabelStyle2 + ", addAddressButtonStyle=" + buttonStyle + ", summarySectionStyle=" + addressSummarySectionStyle + ", containerStyle=" + containerStyle2 + ", isOptional=" + z11 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ AddressSummaryComponentStyle(com.checkout.frames.style.component.base.TextLabelStyle r46, com.checkout.frames.style.component.base.TextLabelStyle r47, com.checkout.frames.style.component.base.ButtonStyle r48, com.checkout.frames.style.component.addresssummary.AddressSummarySectionStyle r49, com.checkout.frames.style.component.base.ContainerStyle r50, boolean r51, int r52, kotlin.jvm.internal.DefaultConstructorMarker r53) {
        /*
            r45 = this;
            r0 = r52 & 1
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = r1
            goto L_0x0009
        L_0x0007:
            r0 = r46
        L_0x0009:
            r2 = r52 & 2
            if (r2 == 0) goto L_0x000f
            r2 = r1
            goto L_0x0011
        L_0x000f:
            r2 = r47
        L_0x0011:
            r3 = r52 & 4
            if (r3 == 0) goto L_0x0033
            com.checkout.frames.style.component.base.ButtonStyle r3 = new com.checkout.frames.style.component.base.ButtonStyle
            r4 = r3
            r5 = 0
            r7 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 0
            r20 = 2047(0x7ff, float:2.868E-42)
            r21 = 0
            r4.<init>(r5, r7, r9, r11, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            goto L_0x0035
        L_0x0033:
            r3 = r48
        L_0x0035:
            r4 = r52 & 8
            if (r4 == 0) goto L_0x0089
            com.checkout.frames.style.component.addresssummary.AddressSummarySectionStyle r4 = new com.checkout.frames.style.component.addresssummary.AddressSummarySectionStyle
            com.checkout.frames.style.component.base.TextLabelStyle r14 = new com.checkout.frames.style.component.base.TextLabelStyle
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 63
            r13 = 0
            r5 = r14
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13)
            com.checkout.frames.style.component.base.ButtonStyle r5 = new com.checkout.frames.style.component.base.ButtonStyle
            r15 = r5
            r16 = 0
            r18 = 0
            r20 = 0
            r22 = 0
            r24 = 0
            r25 = 0
            r26 = 0
            r27 = 0
            r28 = 0
            r29 = 0
            r30 = 0
            r31 = 2047(0x7ff, float:2.868E-42)
            r32 = 0
            r15.<init>(r16, r18, r20, r22, r24, r25, r26, r27, r28, r29, r30, r31, r32)
            com.checkout.frames.style.component.base.ContainerStyle r6 = new com.checkout.frames.style.component.base.ContainerStyle
            r34 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r39 = 0
            r40 = 0
            r41 = 0
            r42 = 0
            r43 = 255(0xff, float:3.57E-43)
            r44 = 0
            r33 = r6
            r33.<init>(r34, r36, r37, r38, r39, r40, r41, r42, r43, r44)
            r4.<init>(r14, r1, r5, r6)
            goto L_0x008b
        L_0x0089:
            r4 = r49
        L_0x008b:
            r1 = r52 & 16
            if (r1 == 0) goto L_0x00a3
            com.checkout.frames.style.component.base.ContainerStyle r1 = new com.checkout.frames.style.component.base.ContainerStyle
            r6 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 255(0xff, float:3.57E-43)
            r16 = 0
            r5 = r1
            r5.<init>(r6, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            goto L_0x00a5
        L_0x00a3:
            r1 = r50
        L_0x00a5:
            r5 = r52 & 32
            if (r5 == 0) goto L_0x00ab
            r5 = 0
            goto L_0x00ad
        L_0x00ab:
            r5 = r51
        L_0x00ad:
            r46 = r45
            r47 = r0
            r48 = r2
            r49 = r3
            r50 = r4
            r51 = r1
            r52 = r5
            r46.<init>(r47, r48, r49, r50, r51, r52)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.addresssummary.AddressSummaryComponentStyle.<init>(com.checkout.frames.style.component.base.TextLabelStyle, com.checkout.frames.style.component.base.TextLabelStyle, com.checkout.frames.style.component.base.ButtonStyle, com.checkout.frames.style.component.addresssummary.AddressSummarySectionStyle, com.checkout.frames.style.component.base.ContainerStyle, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
