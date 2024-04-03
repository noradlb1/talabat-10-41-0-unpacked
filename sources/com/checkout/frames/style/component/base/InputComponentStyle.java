package com.checkout.frames.style.component.base;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001BU\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\nHÆ\u0003J\t\u0010\u001e\u001a\u00020\fHÆ\u0003JW\u0010\u001f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fHÆ\u0001J\u0013\u0010 \u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0015R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006&"}, d2 = {"Lcom/checkout/frames/style/component/base/InputComponentStyle;", "", "titleStyle", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "subtitleStyle", "infoStyle", "inputFieldStyle", "Lcom/checkout/frames/style/component/base/InputFieldStyle;", "errorMessageStyle", "containerStyle", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "isInputFieldOptional", "", "(Lcom/checkout/frames/style/component/base/TextLabelStyle;Lcom/checkout/frames/style/component/base/TextLabelStyle;Lcom/checkout/frames/style/component/base/TextLabelStyle;Lcom/checkout/frames/style/component/base/InputFieldStyle;Lcom/checkout/frames/style/component/base/TextLabelStyle;Lcom/checkout/frames/style/component/base/ContainerStyle;Z)V", "getContainerStyle", "()Lcom/checkout/frames/style/component/base/ContainerStyle;", "getErrorMessageStyle", "()Lcom/checkout/frames/style/component/base/TextLabelStyle;", "getInfoStyle", "getInputFieldStyle", "()Lcom/checkout/frames/style/component/base/InputFieldStyle;", "()Z", "getSubtitleStyle", "getTitleStyle", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class InputComponentStyle {
    public static final int $stable = 8;
    @NotNull
    private final ContainerStyle containerStyle;
    @Nullable
    private final TextLabelStyle errorMessageStyle;
    @Nullable
    private final TextLabelStyle infoStyle;
    @NotNull
    private final InputFieldStyle inputFieldStyle;
    private final boolean isInputFieldOptional;
    @Nullable
    private final TextLabelStyle subtitleStyle;
    @Nullable
    private final TextLabelStyle titleStyle;

    @JvmOverloads
    public InputComponentStyle() {
        this((TextLabelStyle) null, (TextLabelStyle) null, (TextLabelStyle) null, (InputFieldStyle) null, (TextLabelStyle) null, (ContainerStyle) null, false, 127, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public InputComponentStyle(@Nullable TextLabelStyle textLabelStyle) {
        this(textLabelStyle, (TextLabelStyle) null, (TextLabelStyle) null, (InputFieldStyle) null, (TextLabelStyle) null, (ContainerStyle) null, false, 126, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public InputComponentStyle(@Nullable TextLabelStyle textLabelStyle, @Nullable TextLabelStyle textLabelStyle2) {
        this(textLabelStyle, textLabelStyle2, (TextLabelStyle) null, (InputFieldStyle) null, (TextLabelStyle) null, (ContainerStyle) null, false, 124, (DefaultConstructorMarker) null);
    }

    @JvmOverloads
    public InputComponentStyle(@Nullable TextLabelStyle textLabelStyle, @Nullable TextLabelStyle textLabelStyle2, @Nullable TextLabelStyle textLabelStyle3) {
        this(textLabelStyle, textLabelStyle2, textLabelStyle3, (InputFieldStyle) null, (TextLabelStyle) null, (ContainerStyle) null, false, 120, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InputComponentStyle(@Nullable TextLabelStyle textLabelStyle, @Nullable TextLabelStyle textLabelStyle2, @Nullable TextLabelStyle textLabelStyle3, @NotNull InputFieldStyle inputFieldStyle2) {
        this(textLabelStyle, textLabelStyle2, textLabelStyle3, inputFieldStyle2, (TextLabelStyle) null, (ContainerStyle) null, false, 112, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(inputFieldStyle2, "inputFieldStyle");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public InputComponentStyle(@Nullable TextLabelStyle textLabelStyle, @Nullable TextLabelStyle textLabelStyle2, @Nullable TextLabelStyle textLabelStyle3, @NotNull InputFieldStyle inputFieldStyle2, @Nullable TextLabelStyle textLabelStyle4) {
        this(textLabelStyle, textLabelStyle2, textLabelStyle3, inputFieldStyle2, textLabelStyle4, (ContainerStyle) null, false, 96, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(inputFieldStyle2, "inputFieldStyle");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @kotlin.jvm.JvmOverloads
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public InputComponentStyle(@org.jetbrains.annotations.Nullable com.checkout.frames.style.component.base.TextLabelStyle r12, @org.jetbrains.annotations.Nullable com.checkout.frames.style.component.base.TextLabelStyle r13, @org.jetbrains.annotations.Nullable com.checkout.frames.style.component.base.TextLabelStyle r14, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.base.InputFieldStyle r15, @org.jetbrains.annotations.Nullable com.checkout.frames.style.component.base.TextLabelStyle r16, @org.jetbrains.annotations.NotNull com.checkout.frames.style.component.base.ContainerStyle r17) {
        /*
            r11 = this;
            java.lang.String r0 = "inputFieldStyle"
            r5 = r15
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            java.lang.String r0 = "containerStyle"
            r7 = r17
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            r8 = 0
            r9 = 64
            r10 = 0
            r1 = r11
            r2 = r12
            r3 = r13
            r4 = r14
            r6 = r16
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.InputComponentStyle.<init>(com.checkout.frames.style.component.base.TextLabelStyle, com.checkout.frames.style.component.base.TextLabelStyle, com.checkout.frames.style.component.base.TextLabelStyle, com.checkout.frames.style.component.base.InputFieldStyle, com.checkout.frames.style.component.base.TextLabelStyle, com.checkout.frames.style.component.base.ContainerStyle):void");
    }

    @JvmOverloads
    public InputComponentStyle(@Nullable TextLabelStyle textLabelStyle, @Nullable TextLabelStyle textLabelStyle2, @Nullable TextLabelStyle textLabelStyle3, @NotNull InputFieldStyle inputFieldStyle2, @Nullable TextLabelStyle textLabelStyle4, @NotNull ContainerStyle containerStyle2, boolean z11) {
        Intrinsics.checkNotNullParameter(inputFieldStyle2, "inputFieldStyle");
        Intrinsics.checkNotNullParameter(containerStyle2, "containerStyle");
        this.titleStyle = textLabelStyle;
        this.subtitleStyle = textLabelStyle2;
        this.infoStyle = textLabelStyle3;
        this.inputFieldStyle = inputFieldStyle2;
        this.errorMessageStyle = textLabelStyle4;
        this.containerStyle = containerStyle2;
        this.isInputFieldOptional = z11;
    }

    public static /* synthetic */ InputComponentStyle copy$default(InputComponentStyle inputComponentStyle, TextLabelStyle textLabelStyle, TextLabelStyle textLabelStyle2, TextLabelStyle textLabelStyle3, InputFieldStyle inputFieldStyle2, TextLabelStyle textLabelStyle4, ContainerStyle containerStyle2, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            textLabelStyle = inputComponentStyle.titleStyle;
        }
        if ((i11 & 2) != 0) {
            textLabelStyle2 = inputComponentStyle.subtitleStyle;
        }
        TextLabelStyle textLabelStyle5 = textLabelStyle2;
        if ((i11 & 4) != 0) {
            textLabelStyle3 = inputComponentStyle.infoStyle;
        }
        TextLabelStyle textLabelStyle6 = textLabelStyle3;
        if ((i11 & 8) != 0) {
            inputFieldStyle2 = inputComponentStyle.inputFieldStyle;
        }
        InputFieldStyle inputFieldStyle3 = inputFieldStyle2;
        if ((i11 & 16) != 0) {
            textLabelStyle4 = inputComponentStyle.errorMessageStyle;
        }
        TextLabelStyle textLabelStyle7 = textLabelStyle4;
        if ((i11 & 32) != 0) {
            containerStyle2 = inputComponentStyle.containerStyle;
        }
        ContainerStyle containerStyle3 = containerStyle2;
        if ((i11 & 64) != 0) {
            z11 = inputComponentStyle.isInputFieldOptional;
        }
        return inputComponentStyle.copy(textLabelStyle, textLabelStyle5, textLabelStyle6, inputFieldStyle3, textLabelStyle7, containerStyle3, z11);
    }

    @Nullable
    public final TextLabelStyle component1() {
        return this.titleStyle;
    }

    @Nullable
    public final TextLabelStyle component2() {
        return this.subtitleStyle;
    }

    @Nullable
    public final TextLabelStyle component3() {
        return this.infoStyle;
    }

    @NotNull
    public final InputFieldStyle component4() {
        return this.inputFieldStyle;
    }

    @Nullable
    public final TextLabelStyle component5() {
        return this.errorMessageStyle;
    }

    @NotNull
    public final ContainerStyle component6() {
        return this.containerStyle;
    }

    public final boolean component7() {
        return this.isInputFieldOptional;
    }

    @NotNull
    public final InputComponentStyle copy(@Nullable TextLabelStyle textLabelStyle, @Nullable TextLabelStyle textLabelStyle2, @Nullable TextLabelStyle textLabelStyle3, @NotNull InputFieldStyle inputFieldStyle2, @Nullable TextLabelStyle textLabelStyle4, @NotNull ContainerStyle containerStyle2, boolean z11) {
        Intrinsics.checkNotNullParameter(inputFieldStyle2, "inputFieldStyle");
        Intrinsics.checkNotNullParameter(containerStyle2, "containerStyle");
        return new InputComponentStyle(textLabelStyle, textLabelStyle2, textLabelStyle3, inputFieldStyle2, textLabelStyle4, containerStyle2, z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof InputComponentStyle)) {
            return false;
        }
        InputComponentStyle inputComponentStyle = (InputComponentStyle) obj;
        return Intrinsics.areEqual((Object) this.titleStyle, (Object) inputComponentStyle.titleStyle) && Intrinsics.areEqual((Object) this.subtitleStyle, (Object) inputComponentStyle.subtitleStyle) && Intrinsics.areEqual((Object) this.infoStyle, (Object) inputComponentStyle.infoStyle) && Intrinsics.areEqual((Object) this.inputFieldStyle, (Object) inputComponentStyle.inputFieldStyle) && Intrinsics.areEqual((Object) this.errorMessageStyle, (Object) inputComponentStyle.errorMessageStyle) && Intrinsics.areEqual((Object) this.containerStyle, (Object) inputComponentStyle.containerStyle) && this.isInputFieldOptional == inputComponentStyle.isInputFieldOptional;
    }

    @NotNull
    public final ContainerStyle getContainerStyle() {
        return this.containerStyle;
    }

    @Nullable
    public final TextLabelStyle getErrorMessageStyle() {
        return this.errorMessageStyle;
    }

    @Nullable
    public final TextLabelStyle getInfoStyle() {
        return this.infoStyle;
    }

    @NotNull
    public final InputFieldStyle getInputFieldStyle() {
        return this.inputFieldStyle;
    }

    @Nullable
    public final TextLabelStyle getSubtitleStyle() {
        return this.subtitleStyle;
    }

    @Nullable
    public final TextLabelStyle getTitleStyle() {
        return this.titleStyle;
    }

    public int hashCode() {
        TextLabelStyle textLabelStyle = this.titleStyle;
        int i11 = 0;
        int hashCode = (textLabelStyle == null ? 0 : textLabelStyle.hashCode()) * 31;
        TextLabelStyle textLabelStyle2 = this.subtitleStyle;
        int hashCode2 = (hashCode + (textLabelStyle2 == null ? 0 : textLabelStyle2.hashCode())) * 31;
        TextLabelStyle textLabelStyle3 = this.infoStyle;
        int hashCode3 = (((hashCode2 + (textLabelStyle3 == null ? 0 : textLabelStyle3.hashCode())) * 31) + this.inputFieldStyle.hashCode()) * 31;
        TextLabelStyle textLabelStyle4 = this.errorMessageStyle;
        if (textLabelStyle4 != null) {
            i11 = textLabelStyle4.hashCode();
        }
        int hashCode4 = (((hashCode3 + i11) * 31) + this.containerStyle.hashCode()) * 31;
        boolean z11 = this.isInputFieldOptional;
        if (z11) {
            z11 = true;
        }
        return hashCode4 + (z11 ? 1 : 0);
    }

    public final boolean isInputFieldOptional() {
        return this.isInputFieldOptional;
    }

    @NotNull
    public String toString() {
        TextLabelStyle textLabelStyle = this.titleStyle;
        TextLabelStyle textLabelStyle2 = this.subtitleStyle;
        TextLabelStyle textLabelStyle3 = this.infoStyle;
        InputFieldStyle inputFieldStyle2 = this.inputFieldStyle;
        TextLabelStyle textLabelStyle4 = this.errorMessageStyle;
        ContainerStyle containerStyle2 = this.containerStyle;
        boolean z11 = this.isInputFieldOptional;
        return "InputComponentStyle(titleStyle=" + textLabelStyle + ", subtitleStyle=" + textLabelStyle2 + ", infoStyle=" + textLabelStyle3 + ", inputFieldStyle=" + inputFieldStyle2 + ", errorMessageStyle=" + textLabelStyle4 + ", containerStyle=" + containerStyle2 + ", isInputFieldOptional=" + z11 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ InputComponentStyle(com.checkout.frames.style.component.base.TextLabelStyle r19, com.checkout.frames.style.component.base.TextLabelStyle r20, com.checkout.frames.style.component.base.TextLabelStyle r21, com.checkout.frames.style.component.base.InputFieldStyle r22, com.checkout.frames.style.component.base.TextLabelStyle r23, com.checkout.frames.style.component.base.ContainerStyle r24, boolean r25, int r26, kotlin.jvm.internal.DefaultConstructorMarker r27) {
        /*
            r18 = this;
            r0 = r26 & 1
            r1 = 0
            if (r0 == 0) goto L_0x0007
            r0 = r1
            goto L_0x0009
        L_0x0007:
            r0 = r19
        L_0x0009:
            r2 = r26 & 2
            if (r2 == 0) goto L_0x000f
            r2 = r1
            goto L_0x0011
        L_0x000f:
            r2 = r20
        L_0x0011:
            r3 = r26 & 4
            if (r3 == 0) goto L_0x0016
            goto L_0x0018
        L_0x0016:
            r1 = r21
        L_0x0018:
            r3 = r26 & 8
            if (r3 == 0) goto L_0x0031
            com.checkout.frames.style.component.base.InputFieldStyle r3 = new com.checkout.frames.style.component.base.InputFieldStyle
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 1023(0x3ff, float:1.434E-42)
            r16 = 0
            r4 = r3
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            goto L_0x0033
        L_0x0031:
            r3 = r22
        L_0x0033:
            r4 = r26 & 16
            if (r4 == 0) goto L_0x0048
            com.checkout.frames.style.component.default.DefaultTextLabelStyle r5 = com.checkout.frames.style.component.p003default.DefaultTextLabelStyle.INSTANCE
            r6 = 0
            r7 = 0
            r8 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 63
            r14 = 0
            com.checkout.frames.style.component.base.TextLabelStyle r4 = com.checkout.frames.style.component.p003default.DefaultTextLabelStyle.error$default(r5, r6, r7, r8, r10, r11, r12, r13, r14)
            goto L_0x004a
        L_0x0048:
            r4 = r23
        L_0x004a:
            r5 = r26 & 32
            if (r5 == 0) goto L_0x0062
            com.checkout.frames.style.component.base.ContainerStyle r5 = new com.checkout.frames.style.component.base.ContainerStyle
            r7 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
            r16 = 255(0xff, float:3.57E-43)
            r17 = 0
            r6 = r5
            r6.<init>(r7, r9, r10, r11, r12, r13, r14, r15, r16, r17)
            goto L_0x0064
        L_0x0062:
            r5 = r24
        L_0x0064:
            r6 = r26 & 64
            if (r6 == 0) goto L_0x006a
            r6 = 0
            goto L_0x006c
        L_0x006a:
            r6 = r25
        L_0x006c:
            r19 = r18
            r20 = r0
            r21 = r2
            r22 = r1
            r23 = r3
            r24 = r4
            r25 = r5
            r26 = r6
            r19.<init>(r20, r21, r22, r23, r24, r25, r26)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.base.InputComponentStyle.<init>(com.checkout.frames.style.component.base.TextLabelStyle, com.checkout.frames.style.component.base.TextLabelStyle, com.checkout.frames.style.component.base.TextLabelStyle, com.checkout.frames.style.component.base.InputFieldStyle, com.checkout.frames.style.component.base.TextLabelStyle, com.checkout.frames.style.component.base.ContainerStyle, boolean, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
