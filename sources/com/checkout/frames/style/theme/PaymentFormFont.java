package com.checkout.frames.style.theme;

import androidx.compose.runtime.internal.StabilityInferred;
import com.checkout.frames.model.font.Font;
import com.checkout.frames.model.font.FontStyle;
import com.checkout.frames.model.font.FontWeight;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/checkout/frames/style/theme/PaymentFormFont;", "", "font", "Lcom/checkout/frames/model/font/Font;", "fontStyle", "Lcom/checkout/frames/model/font/FontStyle;", "fontWeight", "Lcom/checkout/frames/model/font/FontWeight;", "(Lcom/checkout/frames/model/font/Font;Lcom/checkout/frames/model/font/FontStyle;Lcom/checkout/frames/model/font/FontWeight;)V", "getFont", "()Lcom/checkout/frames/model/font/Font;", "getFontStyle", "()Lcom/checkout/frames/model/font/FontStyle;", "getFontWeight", "()Lcom/checkout/frames/model/font/FontWeight;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PaymentFormFont {
    public static final int $stable = 0;
    @NotNull
    private final Font font;
    @NotNull
    private final FontStyle fontStyle;
    @NotNull
    private final FontWeight fontWeight;

    @JvmOverloads
    public PaymentFormFont() {
        this((Font) null, (FontStyle) null, (FontWeight) null, 7, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaymentFormFont(@NotNull Font font2) {
        this(font2, (FontStyle) null, (FontWeight) null, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(font2, "font");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public PaymentFormFont(@NotNull Font font2, @NotNull FontStyle fontStyle2) {
        this(font2, fontStyle2, (FontWeight) null, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(font2, "font");
        Intrinsics.checkNotNullParameter(fontStyle2, TtmlNode.ATTR_TTS_FONT_STYLE);
    }

    @JvmOverloads
    public PaymentFormFont(@NotNull Font font2, @NotNull FontStyle fontStyle2, @NotNull FontWeight fontWeight2) {
        Intrinsics.checkNotNullParameter(font2, "font");
        Intrinsics.checkNotNullParameter(fontStyle2, TtmlNode.ATTR_TTS_FONT_STYLE);
        Intrinsics.checkNotNullParameter(fontWeight2, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        this.font = font2;
        this.fontStyle = fontStyle2;
        this.fontWeight = fontWeight2;
    }

    public static /* synthetic */ PaymentFormFont copy$default(PaymentFormFont paymentFormFont, Font font2, FontStyle fontStyle2, FontWeight fontWeight2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            font2 = paymentFormFont.font;
        }
        if ((i11 & 2) != 0) {
            fontStyle2 = paymentFormFont.fontStyle;
        }
        if ((i11 & 4) != 0) {
            fontWeight2 = paymentFormFont.fontWeight;
        }
        return paymentFormFont.copy(font2, fontStyle2, fontWeight2);
    }

    @NotNull
    public final Font component1() {
        return this.font;
    }

    @NotNull
    public final FontStyle component2() {
        return this.fontStyle;
    }

    @NotNull
    public final FontWeight component3() {
        return this.fontWeight;
    }

    @NotNull
    public final PaymentFormFont copy(@NotNull Font font2, @NotNull FontStyle fontStyle2, @NotNull FontWeight fontWeight2) {
        Intrinsics.checkNotNullParameter(font2, "font");
        Intrinsics.checkNotNullParameter(fontStyle2, TtmlNode.ATTR_TTS_FONT_STYLE);
        Intrinsics.checkNotNullParameter(fontWeight2, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        return new PaymentFormFont(font2, fontStyle2, fontWeight2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PaymentFormFont)) {
            return false;
        }
        PaymentFormFont paymentFormFont = (PaymentFormFont) obj;
        return Intrinsics.areEqual((Object) this.font, (Object) paymentFormFont.font) && this.fontStyle == paymentFormFont.fontStyle && this.fontWeight == paymentFormFont.fontWeight;
    }

    @NotNull
    public final Font getFont() {
        return this.font;
    }

    @NotNull
    public final FontStyle getFontStyle() {
        return this.fontStyle;
    }

    @NotNull
    public final FontWeight getFontWeight() {
        return this.fontWeight;
    }

    public int hashCode() {
        return (((this.font.hashCode() * 31) + this.fontStyle.hashCode()) * 31) + this.fontWeight.hashCode();
    }

    @NotNull
    public String toString() {
        Font font2 = this.font;
        FontStyle fontStyle2 = this.fontStyle;
        FontWeight fontWeight2 = this.fontWeight;
        return "PaymentFormFont(font=" + font2 + ", fontStyle=" + fontStyle2 + ", fontWeight=" + fontWeight2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaymentFormFont(Font font2, FontStyle fontStyle2, FontWeight fontWeight2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? Font.Default.INSTANCE : font2, (i11 & 2) != 0 ? FontStyle.Normal : fontStyle2, (i11 & 4) != 0 ? FontWeight.Normal : fontWeight2);
    }
}
