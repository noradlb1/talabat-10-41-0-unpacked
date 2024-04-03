package androidx.compose.ui.graphics;

import android.graphics.Shader;
import androidx.compose.runtime.Immutable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0004J-\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u001c\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001a"}, d2 = {"Landroidx/compose/ui/graphics/SolidColor;", "Landroidx/compose/ui/graphics/Brush;", "value", "Landroidx/compose/ui/graphics/Color;", "(JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue-0d7_KjU", "()J", "J", "applyTo", "", "size", "Landroidx/compose/ui/geometry/Size;", "p", "Landroidx/compose/ui/graphics/Paint;", "alpha", "", "applyTo-Pq9zytI", "(JLandroidx/compose/ui/graphics/Paint;F)V", "equals", "", "other", "", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SolidColor extends Brush {
    private final long value;

    private SolidColor(long j11) {
        super((DefaultConstructorMarker) null);
        this.value = j11;
    }

    public /* synthetic */ SolidColor(long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11);
    }

    /* renamed from: applyTo-Pq9zytI  reason: not valid java name */
    public void m3234applyToPq9zytI(long j11, @NotNull Paint paint, float f11) {
        boolean z11;
        long j12;
        Intrinsics.checkNotNullParameter(paint, "p");
        paint.setAlpha(1.0f);
        if (f11 == 1.0f) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            long j13 = this.value;
            j12 = Color.m2918copywmQWz5c$default(j13, Color.m2921getAlphaimpl(j13) * f11, 0.0f, 0.0f, 0.0f, 14, (Object) null);
        } else {
            j12 = this.value;
        }
        paint.m3136setColor8_81llA(j12);
        if (paint.getShader() != null) {
            paint.setShader((Shader) null);
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof SolidColor) && Color.m2920equalsimpl0(this.value, ((SolidColor) obj).value)) {
            return true;
        }
        return false;
    }

    /* renamed from: getValue-0d7_KjU  reason: not valid java name */
    public final long m3235getValue0d7_KjU() {
        return this.value;
    }

    public int hashCode() {
        return Color.m2926hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return "SolidColor(value=" + Color.m2927toStringimpl(this.value) + ')';
    }
}
