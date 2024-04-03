package androidx.compose.ui.text.font;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q0.c;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0005\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u0006\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nHÖ\u0003J\t\u0010\u000b\u001a\u00020\u0003HÖ\u0001J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/font/AndroidFontResolveInterceptor;", "Landroidx/compose/ui/text/font/PlatformResolveInterceptor;", "fontWeightAdjustment", "", "(I)V", "component1", "copy", "equals", "", "other", "", "hashCode", "interceptFontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontWeight", "toString", "", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AndroidFontResolveInterceptor implements PlatformResolveInterceptor {
    private final int fontWeightAdjustment;

    public AndroidFontResolveInterceptor(int i11) {
        this.fontWeightAdjustment = i11;
    }

    private final int component1() {
        return this.fontWeightAdjustment;
    }

    public static /* synthetic */ AndroidFontResolveInterceptor copy$default(AndroidFontResolveInterceptor androidFontResolveInterceptor, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = androidFontResolveInterceptor.fontWeightAdjustment;
        }
        return androidFontResolveInterceptor.copy(i11);
    }

    @NotNull
    public final AndroidFontResolveInterceptor copy(int i11) {
        return new AndroidFontResolveInterceptor(i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof AndroidFontResolveInterceptor) && this.fontWeightAdjustment == ((AndroidFontResolveInterceptor) obj).fontWeightAdjustment;
    }

    public int hashCode() {
        return this.fontWeightAdjustment;
    }

    public /* synthetic */ FontFamily interceptFontFamily(FontFamily fontFamily) {
        return c.a(this, fontFamily);
    }

    /* renamed from: interceptFontStyle-T2F_aPo  reason: not valid java name */
    public /* synthetic */ int m5075interceptFontStyleT2F_aPo(int i11) {
        return c.b(this, i11);
    }

    /* renamed from: interceptFontSynthesis-Mscr08Y  reason: not valid java name */
    public /* synthetic */ int m5076interceptFontSynthesisMscr08Y(int i11) {
        return c.c(this, i11);
    }

    @NotNull
    public FontWeight interceptFontWeight(@NotNull FontWeight fontWeight) {
        Intrinsics.checkNotNullParameter(fontWeight, TtmlNode.ATTR_TTS_FONT_WEIGHT);
        int i11 = this.fontWeightAdjustment;
        if (i11 == 0 || i11 == Integer.MAX_VALUE) {
            return fontWeight;
        }
        return new FontWeight(RangesKt___RangesKt.coerceIn(fontWeight.getWeight() + this.fontWeightAdjustment, 1, 1000));
    }

    @NotNull
    public String toString() {
        return "AndroidFontResolveInterceptor(fontWeightAdjustment=" + this.fontWeightAdjustment + ')';
    }
}
