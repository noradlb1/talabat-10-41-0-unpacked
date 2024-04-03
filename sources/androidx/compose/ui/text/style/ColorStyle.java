package androidx.compose.ui.text.style;

import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.text.style.TextForegroundStyle;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0012\u001a\u00020\u0003HÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u000fJ \u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0015\u0010\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aHÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001R\u0014\u0010\u0005\u001a\u00020\u00068VX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u0004\u0018\u00010\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001d\u0010\r\u001a\u00020\u00038VX\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0010\u0010\u000f\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"Landroidx/compose/ui/text/style/ColorStyle;", "Landroidx/compose/ui/text/style/TextForegroundStyle;", "value", "Landroidx/compose/ui/graphics/Color;", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "alpha", "", "getAlpha", "()F", "brush", "Landroidx/compose/ui/graphics/Brush;", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "color", "getColor-0d7_KjU", "()J", "getValue-0d7_KjU", "J", "component1", "component1-0d7_KjU", "copy", "copy-8_81llA", "(J)Landroidx/compose/ui/text/style/ColorStyle;", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class ColorStyle implements TextForegroundStyle {
    private final long value;

    private ColorStyle(long j11) {
        boolean z11;
        this.value = j11;
        if (j11 != Color.Companion.m2955getUnspecified0d7_KjU()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            throw new IllegalArgumentException("ColorStyle value must be specified, use TextForegroundStyle.Unspecified instead.".toString());
        }
    }

    public /* synthetic */ ColorStyle(long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11);
    }

    /* renamed from: copy-8_81llA$default  reason: not valid java name */
    public static /* synthetic */ ColorStyle m5289copy8_81llA$default(ColorStyle colorStyle, long j11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j11 = colorStyle.value;
        }
        return colorStyle.m5291copy8_81llA(j11);
    }

    /* renamed from: component1-0d7_KjU  reason: not valid java name */
    public final long m5290component10d7_KjU() {
        return this.value;
    }

    @NotNull
    /* renamed from: copy-8_81llA  reason: not valid java name */
    public final ColorStyle m5291copy8_81llA(long j11) {
        return new ColorStyle(j11, (DefaultConstructorMarker) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ColorStyle) && Color.m2920equalsimpl0(this.value, ((ColorStyle) obj).value);
    }

    public float getAlpha() {
        return Color.m2921getAlphaimpl(m5292getColor0d7_KjU());
    }

    @Nullable
    public Brush getBrush() {
        return null;
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public long m5292getColor0d7_KjU() {
        return this.value;
    }

    /* renamed from: getValue-0d7_KjU  reason: not valid java name */
    public final long m5293getValue0d7_KjU() {
        return this.value;
    }

    public int hashCode() {
        return Color.m2926hashCodeimpl(this.value);
    }

    public /* synthetic */ TextForegroundStyle merge(TextForegroundStyle textForegroundStyle) {
        return TextForegroundStyle.CC.a(this, textForegroundStyle);
    }

    public /* synthetic */ TextForegroundStyle takeOrElse(Function0 function0) {
        return TextForegroundStyle.CC.b(this, function0);
    }

    @NotNull
    public String toString() {
        return "ColorStyle(value=" + Color.m2927toStringimpl(this.value) + ')';
    }
}
