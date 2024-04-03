package com.checkout.frames.style.screen;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.InputFieldStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001c\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B9\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0005HÆ\u0003J\t\u0010 \u001a\u00020\u0003HÆ\u0003J\t\u0010!\u001a\u00020\bHÆ\u0003J\t\u0010\"\u001a\u00020\nHÆ\u0003J;\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nHÆ\u0001J\u0013\u0010$\u001a\u00020\n2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020'HÖ\u0001J\t\u0010(\u001a\u00020)HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006*"}, d2 = {"Lcom/checkout/frames/style/screen/CountryPickerStyle;", "", "screenTitleStyle", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "searchFieldStyle", "Lcom/checkout/frames/style/component/base/InputFieldStyle;", "searchItemStyle", "containerStyle", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "withFlag", "", "(Lcom/checkout/frames/style/component/base/TextLabelStyle;Lcom/checkout/frames/style/component/base/InputFieldStyle;Lcom/checkout/frames/style/component/base/TextLabelStyle;Lcom/checkout/frames/style/component/base/ContainerStyle;Z)V", "getContainerStyle", "()Lcom/checkout/frames/style/component/base/ContainerStyle;", "setContainerStyle", "(Lcom/checkout/frames/style/component/base/ContainerStyle;)V", "getScreenTitleStyle", "()Lcom/checkout/frames/style/component/base/TextLabelStyle;", "setScreenTitleStyle", "(Lcom/checkout/frames/style/component/base/TextLabelStyle;)V", "getSearchFieldStyle", "()Lcom/checkout/frames/style/component/base/InputFieldStyle;", "setSearchFieldStyle", "(Lcom/checkout/frames/style/component/base/InputFieldStyle;)V", "getSearchItemStyle", "setSearchItemStyle", "getWithFlag", "()Z", "setWithFlag", "(Z)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CountryPickerStyle {
    public static final int $stable = 8;
    @NotNull
    private ContainerStyle containerStyle;
    @NotNull
    private TextLabelStyle screenTitleStyle;
    @NotNull
    private InputFieldStyle searchFieldStyle;
    @NotNull
    private TextLabelStyle searchItemStyle;
    private boolean withFlag;

    @JvmOverloads
    public CountryPickerStyle() {
        this((TextLabelStyle) null, (InputFieldStyle) null, (TextLabelStyle) null, (ContainerStyle) null, false, 31, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CountryPickerStyle(@NotNull TextLabelStyle textLabelStyle) {
        this(textLabelStyle, (InputFieldStyle) null, (TextLabelStyle) null, (ContainerStyle) null, false, 30, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(textLabelStyle, "screenTitleStyle");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CountryPickerStyle(@NotNull TextLabelStyle textLabelStyle, @NotNull InputFieldStyle inputFieldStyle) {
        this(textLabelStyle, inputFieldStyle, (TextLabelStyle) null, (ContainerStyle) null, false, 28, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(textLabelStyle, "screenTitleStyle");
        Intrinsics.checkNotNullParameter(inputFieldStyle, "searchFieldStyle");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CountryPickerStyle(@NotNull TextLabelStyle textLabelStyle, @NotNull InputFieldStyle inputFieldStyle, @NotNull TextLabelStyle textLabelStyle2) {
        this(textLabelStyle, inputFieldStyle, textLabelStyle2, (ContainerStyle) null, false, 24, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(textLabelStyle, "screenTitleStyle");
        Intrinsics.checkNotNullParameter(inputFieldStyle, "searchFieldStyle");
        Intrinsics.checkNotNullParameter(textLabelStyle2, "searchItemStyle");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CountryPickerStyle(@NotNull TextLabelStyle textLabelStyle, @NotNull InputFieldStyle inputFieldStyle, @NotNull TextLabelStyle textLabelStyle2, @NotNull ContainerStyle containerStyle2) {
        this(textLabelStyle, inputFieldStyle, textLabelStyle2, containerStyle2, false, 16, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(textLabelStyle, "screenTitleStyle");
        Intrinsics.checkNotNullParameter(inputFieldStyle, "searchFieldStyle");
        Intrinsics.checkNotNullParameter(textLabelStyle2, "searchItemStyle");
        Intrinsics.checkNotNullParameter(containerStyle2, "containerStyle");
    }

    @JvmOverloads
    public CountryPickerStyle(@NotNull TextLabelStyle textLabelStyle, @NotNull InputFieldStyle inputFieldStyle, @NotNull TextLabelStyle textLabelStyle2, @NotNull ContainerStyle containerStyle2, boolean z11) {
        Intrinsics.checkNotNullParameter(textLabelStyle, "screenTitleStyle");
        Intrinsics.checkNotNullParameter(inputFieldStyle, "searchFieldStyle");
        Intrinsics.checkNotNullParameter(textLabelStyle2, "searchItemStyle");
        Intrinsics.checkNotNullParameter(containerStyle2, "containerStyle");
        this.screenTitleStyle = textLabelStyle;
        this.searchFieldStyle = inputFieldStyle;
        this.searchItemStyle = textLabelStyle2;
        this.containerStyle = containerStyle2;
        this.withFlag = z11;
    }

    public static /* synthetic */ CountryPickerStyle copy$default(CountryPickerStyle countryPickerStyle, TextLabelStyle textLabelStyle, InputFieldStyle inputFieldStyle, TextLabelStyle textLabelStyle2, ContainerStyle containerStyle2, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            textLabelStyle = countryPickerStyle.screenTitleStyle;
        }
        if ((i11 & 2) != 0) {
            inputFieldStyle = countryPickerStyle.searchFieldStyle;
        }
        InputFieldStyle inputFieldStyle2 = inputFieldStyle;
        if ((i11 & 4) != 0) {
            textLabelStyle2 = countryPickerStyle.searchItemStyle;
        }
        TextLabelStyle textLabelStyle3 = textLabelStyle2;
        if ((i11 & 8) != 0) {
            containerStyle2 = countryPickerStyle.containerStyle;
        }
        ContainerStyle containerStyle3 = containerStyle2;
        if ((i11 & 16) != 0) {
            z11 = countryPickerStyle.withFlag;
        }
        return countryPickerStyle.copy(textLabelStyle, inputFieldStyle2, textLabelStyle3, containerStyle3, z11);
    }

    @NotNull
    public final TextLabelStyle component1() {
        return this.screenTitleStyle;
    }

    @NotNull
    public final InputFieldStyle component2() {
        return this.searchFieldStyle;
    }

    @NotNull
    public final TextLabelStyle component3() {
        return this.searchItemStyle;
    }

    @NotNull
    public final ContainerStyle component4() {
        return this.containerStyle;
    }

    public final boolean component5() {
        return this.withFlag;
    }

    @NotNull
    public final CountryPickerStyle copy(@NotNull TextLabelStyle textLabelStyle, @NotNull InputFieldStyle inputFieldStyle, @NotNull TextLabelStyle textLabelStyle2, @NotNull ContainerStyle containerStyle2, boolean z11) {
        Intrinsics.checkNotNullParameter(textLabelStyle, "screenTitleStyle");
        Intrinsics.checkNotNullParameter(inputFieldStyle, "searchFieldStyle");
        Intrinsics.checkNotNullParameter(textLabelStyle2, "searchItemStyle");
        Intrinsics.checkNotNullParameter(containerStyle2, "containerStyle");
        return new CountryPickerStyle(textLabelStyle, inputFieldStyle, textLabelStyle2, containerStyle2, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CountryPickerStyle)) {
            return false;
        }
        CountryPickerStyle countryPickerStyle = (CountryPickerStyle) obj;
        return Intrinsics.areEqual((Object) this.screenTitleStyle, (Object) countryPickerStyle.screenTitleStyle) && Intrinsics.areEqual((Object) this.searchFieldStyle, (Object) countryPickerStyle.searchFieldStyle) && Intrinsics.areEqual((Object) this.searchItemStyle, (Object) countryPickerStyle.searchItemStyle) && Intrinsics.areEqual((Object) this.containerStyle, (Object) countryPickerStyle.containerStyle) && this.withFlag == countryPickerStyle.withFlag;
    }

    @NotNull
    public final ContainerStyle getContainerStyle() {
        return this.containerStyle;
    }

    @NotNull
    public final TextLabelStyle getScreenTitleStyle() {
        return this.screenTitleStyle;
    }

    @NotNull
    public final InputFieldStyle getSearchFieldStyle() {
        return this.searchFieldStyle;
    }

    @NotNull
    public final TextLabelStyle getSearchItemStyle() {
        return this.searchItemStyle;
    }

    public final boolean getWithFlag() {
        return this.withFlag;
    }

    public int hashCode() {
        int hashCode = ((((((this.screenTitleStyle.hashCode() * 31) + this.searchFieldStyle.hashCode()) * 31) + this.searchItemStyle.hashCode()) * 31) + this.containerStyle.hashCode()) * 31;
        boolean z11 = this.withFlag;
        if (z11) {
            z11 = true;
        }
        return hashCode + (z11 ? 1 : 0);
    }

    public final void setContainerStyle(@NotNull ContainerStyle containerStyle2) {
        Intrinsics.checkNotNullParameter(containerStyle2, "<set-?>");
        this.containerStyle = containerStyle2;
    }

    public final void setScreenTitleStyle(@NotNull TextLabelStyle textLabelStyle) {
        Intrinsics.checkNotNullParameter(textLabelStyle, "<set-?>");
        this.screenTitleStyle = textLabelStyle;
    }

    public final void setSearchFieldStyle(@NotNull InputFieldStyle inputFieldStyle) {
        Intrinsics.checkNotNullParameter(inputFieldStyle, "<set-?>");
        this.searchFieldStyle = inputFieldStyle;
    }

    public final void setSearchItemStyle(@NotNull TextLabelStyle textLabelStyle) {
        Intrinsics.checkNotNullParameter(textLabelStyle, "<set-?>");
        this.searchItemStyle = textLabelStyle;
    }

    public final void setWithFlag(boolean z11) {
        this.withFlag = z11;
    }

    @NotNull
    public String toString() {
        TextLabelStyle textLabelStyle = this.screenTitleStyle;
        InputFieldStyle inputFieldStyle = this.searchFieldStyle;
        TextLabelStyle textLabelStyle2 = this.searchItemStyle;
        ContainerStyle containerStyle2 = this.containerStyle;
        boolean z11 = this.withFlag;
        return "CountryPickerStyle(screenTitleStyle=" + textLabelStyle + ", searchFieldStyle=" + inputFieldStyle + ", searchItemStyle=" + textLabelStyle2 + ", containerStyle=" + containerStyle2 + ", withFlag=" + z11 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CountryPickerStyle(com.checkout.frames.style.component.base.TextLabelStyle r17, com.checkout.frames.style.component.base.InputFieldStyle r18, com.checkout.frames.style.component.base.TextLabelStyle r19, com.checkout.frames.style.component.base.ContainerStyle r20, boolean r21, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r16 = this;
            r0 = r22 & 1
            if (r0 == 0) goto L_0x0014
            com.checkout.frames.style.component.base.TextLabelStyle r0 = new com.checkout.frames.style.component.base.TextLabelStyle
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 63
            r9 = 0
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            goto L_0x0016
        L_0x0014:
            r0 = r17
        L_0x0016:
            r1 = r22 & 2
            if (r1 == 0) goto L_0x002e
            com.checkout.frames.style.component.base.InputFieldStyle r1 = new com.checkout.frames.style.component.base.InputFieldStyle
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 1023(0x3ff, float:1.434E-42)
            r14 = 0
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x0030
        L_0x002e:
            r1 = r18
        L_0x0030:
            r2 = r22 & 4
            if (r2 == 0) goto L_0x0044
            com.checkout.frames.style.component.base.TextLabelStyle r2 = new com.checkout.frames.style.component.base.TextLabelStyle
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 63
            r11 = 0
            r3 = r2
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11)
            goto L_0x0046
        L_0x0044:
            r2 = r19
        L_0x0046:
            r3 = r22 & 8
            if (r3 == 0) goto L_0x0060
            com.checkout.frames.style.component.base.ContainerStyle r3 = new com.checkout.frames.style.component.base.ContainerStyle
            r5 = 4294967295(0xffffffff, double:2.1219957905E-314)
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 254(0xfe, float:3.56E-43)
            r15 = 0
            r4 = r3
            r4.<init>(r5, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            goto L_0x0062
        L_0x0060:
            r3 = r20
        L_0x0062:
            r4 = r22 & 16
            if (r4 == 0) goto L_0x0068
            r4 = 1
            goto L_0x006a
        L_0x0068:
            r4 = r21
        L_0x006a:
            r17 = r16
            r18 = r0
            r19 = r1
            r20 = r2
            r21 = r3
            r22 = r4
            r17.<init>(r18, r19, r20, r21, r22)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.screen.CountryPickerStyle.<init>(com.checkout.frames.style.component.base.TextLabelStyle, com.checkout.frames.style.component.base.InputFieldStyle, com.checkout.frames.style.component.base.TextLabelStyle, com.checkout.frames.style.component.base.ContainerStyle, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
