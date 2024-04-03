package com.checkout.frames.style.component;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.style.component.base.ContainerStyle;
import com.checkout.frames.style.component.base.ImageContainerStyle;
import com.checkout.frames.style.component.base.ImageStyle;
import com.checkout.frames.style.component.base.TextLabelStyle;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B1\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\tHÆ\u0003J3\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/checkout/frames/style/component/CardSchemeComponentStyle;", "", "titleStyle", "Lcom/checkout/frames/style/component/base/TextLabelStyle;", "imageStyle", "Lcom/checkout/frames/style/component/base/ImageStyle;", "containerStyle", "Lcom/checkout/frames/style/component/base/ContainerStyle;", "imageContainerStyle", "Lcom/checkout/frames/style/component/base/ImageContainerStyle;", "(Lcom/checkout/frames/style/component/base/TextLabelStyle;Lcom/checkout/frames/style/component/base/ImageStyle;Lcom/checkout/frames/style/component/base/ContainerStyle;Lcom/checkout/frames/style/component/base/ImageContainerStyle;)V", "getContainerStyle", "()Lcom/checkout/frames/style/component/base/ContainerStyle;", "getImageContainerStyle", "()Lcom/checkout/frames/style/component/base/ImageContainerStyle;", "getImageStyle", "()Lcom/checkout/frames/style/component/base/ImageStyle;", "getTitleStyle", "()Lcom/checkout/frames/style/component/base/TextLabelStyle;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CardSchemeComponentStyle {
    public static final int $stable = 8;
    @NotNull
    private final ContainerStyle containerStyle;
    @NotNull
    private final ImageContainerStyle imageContainerStyle;
    @Nullable
    private final ImageStyle imageStyle;
    @NotNull
    private final TextLabelStyle titleStyle;

    @JvmOverloads
    public CardSchemeComponentStyle() {
        this((TextLabelStyle) null, (ImageStyle) null, (ContainerStyle) null, (ImageContainerStyle) null, 15, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CardSchemeComponentStyle(@NotNull TextLabelStyle textLabelStyle) {
        this(textLabelStyle, (ImageStyle) null, (ContainerStyle) null, (ImageContainerStyle) null, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(textLabelStyle, "titleStyle");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CardSchemeComponentStyle(@NotNull TextLabelStyle textLabelStyle, @Nullable ImageStyle imageStyle2) {
        this(textLabelStyle, imageStyle2, (ContainerStyle) null, (ImageContainerStyle) null, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(textLabelStyle, "titleStyle");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CardSchemeComponentStyle(@NotNull TextLabelStyle textLabelStyle, @Nullable ImageStyle imageStyle2, @NotNull ContainerStyle containerStyle2) {
        this(textLabelStyle, imageStyle2, containerStyle2, (ImageContainerStyle) null, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(textLabelStyle, "titleStyle");
        Intrinsics.checkNotNullParameter(containerStyle2, "containerStyle");
    }

    @JvmOverloads
    public CardSchemeComponentStyle(@NotNull TextLabelStyle textLabelStyle, @Nullable ImageStyle imageStyle2, @NotNull ContainerStyle containerStyle2, @NotNull ImageContainerStyle imageContainerStyle2) {
        Intrinsics.checkNotNullParameter(textLabelStyle, "titleStyle");
        Intrinsics.checkNotNullParameter(containerStyle2, "containerStyle");
        Intrinsics.checkNotNullParameter(imageContainerStyle2, "imageContainerStyle");
        this.titleStyle = textLabelStyle;
        this.imageStyle = imageStyle2;
        this.containerStyle = containerStyle2;
        this.imageContainerStyle = imageContainerStyle2;
    }

    public static /* synthetic */ CardSchemeComponentStyle copy$default(CardSchemeComponentStyle cardSchemeComponentStyle, TextLabelStyle textLabelStyle, ImageStyle imageStyle2, ContainerStyle containerStyle2, ImageContainerStyle imageContainerStyle2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            textLabelStyle = cardSchemeComponentStyle.titleStyle;
        }
        if ((i11 & 2) != 0) {
            imageStyle2 = cardSchemeComponentStyle.imageStyle;
        }
        if ((i11 & 4) != 0) {
            containerStyle2 = cardSchemeComponentStyle.containerStyle;
        }
        if ((i11 & 8) != 0) {
            imageContainerStyle2 = cardSchemeComponentStyle.imageContainerStyle;
        }
        return cardSchemeComponentStyle.copy(textLabelStyle, imageStyle2, containerStyle2, imageContainerStyle2);
    }

    @NotNull
    public final TextLabelStyle component1() {
        return this.titleStyle;
    }

    @Nullable
    public final ImageStyle component2() {
        return this.imageStyle;
    }

    @NotNull
    public final ContainerStyle component3() {
        return this.containerStyle;
    }

    @NotNull
    public final ImageContainerStyle component4() {
        return this.imageContainerStyle;
    }

    @NotNull
    public final CardSchemeComponentStyle copy(@NotNull TextLabelStyle textLabelStyle, @Nullable ImageStyle imageStyle2, @NotNull ContainerStyle containerStyle2, @NotNull ImageContainerStyle imageContainerStyle2) {
        Intrinsics.checkNotNullParameter(textLabelStyle, "titleStyle");
        Intrinsics.checkNotNullParameter(containerStyle2, "containerStyle");
        Intrinsics.checkNotNullParameter(imageContainerStyle2, "imageContainerStyle");
        return new CardSchemeComponentStyle(textLabelStyle, imageStyle2, containerStyle2, imageContainerStyle2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CardSchemeComponentStyle)) {
            return false;
        }
        CardSchemeComponentStyle cardSchemeComponentStyle = (CardSchemeComponentStyle) obj;
        return Intrinsics.areEqual((Object) this.titleStyle, (Object) cardSchemeComponentStyle.titleStyle) && Intrinsics.areEqual((Object) this.imageStyle, (Object) cardSchemeComponentStyle.imageStyle) && Intrinsics.areEqual((Object) this.containerStyle, (Object) cardSchemeComponentStyle.containerStyle) && Intrinsics.areEqual((Object) this.imageContainerStyle, (Object) cardSchemeComponentStyle.imageContainerStyle);
    }

    @NotNull
    public final ContainerStyle getContainerStyle() {
        return this.containerStyle;
    }

    @NotNull
    public final ImageContainerStyle getImageContainerStyle() {
        return this.imageContainerStyle;
    }

    @Nullable
    public final ImageStyle getImageStyle() {
        return this.imageStyle;
    }

    @NotNull
    public final TextLabelStyle getTitleStyle() {
        return this.titleStyle;
    }

    public int hashCode() {
        int hashCode = this.titleStyle.hashCode() * 31;
        ImageStyle imageStyle2 = this.imageStyle;
        return ((((hashCode + (imageStyle2 == null ? 0 : imageStyle2.hashCode())) * 31) + this.containerStyle.hashCode()) * 31) + this.imageContainerStyle.hashCode();
    }

    @NotNull
    public String toString() {
        TextLabelStyle textLabelStyle = this.titleStyle;
        ImageStyle imageStyle2 = this.imageStyle;
        ContainerStyle containerStyle2 = this.containerStyle;
        ImageContainerStyle imageContainerStyle2 = this.imageContainerStyle;
        return "CardSchemeComponentStyle(titleStyle=" + textLabelStyle + ", imageStyle=" + imageStyle2 + ", containerStyle=" + containerStyle2 + ", imageContainerStyle=" + imageContainerStyle2 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CardSchemeComponentStyle(com.checkout.frames.style.component.base.TextLabelStyle r16, com.checkout.frames.style.component.base.ImageStyle r17, com.checkout.frames.style.component.base.ContainerStyle r18, com.checkout.frames.style.component.base.ImageContainerStyle r19, int r20, kotlin.jvm.internal.DefaultConstructorMarker r21) {
        /*
            r15 = this;
            r0 = r20 & 1
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
            r0 = r16
        L_0x0016:
            r1 = r20 & 2
            if (r1 == 0) goto L_0x001c
            r1 = 0
            goto L_0x001e
        L_0x001c:
            r1 = r17
        L_0x001e:
            r2 = r20 & 4
            if (r2 == 0) goto L_0x0035
            com.checkout.frames.style.component.base.ContainerStyle r2 = new com.checkout.frames.style.component.base.ContainerStyle
            r4 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 255(0xff, float:3.57E-43)
            r14 = 0
            r3 = r2
            r3.<init>(r4, r6, r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x0037
        L_0x0035:
            r2 = r18
        L_0x0037:
            r3 = r20 & 8
            if (r3 == 0) goto L_0x0053
            com.checkout.frames.style.component.base.ImageContainerStyle r3 = new com.checkout.frames.style.component.base.ImageContainerStyle
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 7
            r8 = 0
            r16 = r3
            r17 = r4
            r18 = r5
            r19 = r6
            r20 = r7
            r21 = r8
            r16.<init>(r17, r18, r19, r20, r21)
            r4 = r15
            goto L_0x0056
        L_0x0053:
            r4 = r15
            r3 = r19
        L_0x0056:
            r15.<init>(r0, r1, r2, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.checkout.frames.style.component.CardSchemeComponentStyle.<init>(com.checkout.frames.style.component.base.TextLabelStyle, com.checkout.frames.style.component.base.ImageStyle, com.checkout.frames.style.component.base.ContainerStyle, com.checkout.frames.style.component.base.ImageContainerStyle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
