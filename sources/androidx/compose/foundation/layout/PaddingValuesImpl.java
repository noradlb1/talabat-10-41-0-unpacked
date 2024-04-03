package androidx.compose.foundation.layout;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B0\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0018\u0010\u0013\u001a\u00020\u0003H\u0016ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u000bJ \u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019J \u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H\u0016ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001b\u0010\u0019J\u0018\u0010\u001c\u001a\u00020\u0003H\u0016ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u000bJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0002J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0016R'\u0010\u0006\u001a\u00020\u00038\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\f\u0012\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR'\u0010\u0005\u001a\u00020\u00038\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\f\u0012\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR'\u0010\u0002\u001a\u00020\u00038\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\f\u0012\u0004\b\u000f\u0010\t\u001a\u0004\b\u0010\u0010\u000bR'\u0010\u0004\u001a\u00020\u00038\u0006X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\f\u0012\u0004\b\u0011\u0010\t\u001a\u0004\b\u0012\u0010\u000b\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006&"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValuesImpl;", "Landroidx/compose/foundation/layout/PaddingValues;", "start", "Landroidx/compose/ui/unit/Dp;", "top", "end", "bottom", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottom-D9Ej5fM$annotations", "()V", "getBottom-D9Ej5fM", "()F", "F", "getEnd-D9Ej5fM$annotations", "getEnd-D9Ej5fM", "getStart-D9Ej5fM$annotations", "getStart-D9Ej5fM", "getTop-D9Ej5fM$annotations", "getTop-D9Ej5fM", "calculateBottomPadding", "calculateBottomPadding-D9Ej5fM", "calculateLeftPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PaddingValuesImpl implements PaddingValues {
    private final float bottom;
    private final float end;
    private final float start;
    private final float top;

    private PaddingValuesImpl(float f11, float f12, float f13, float f14) {
        this.start = f11;
        this.top = f12;
        this.end = f13;
        this.bottom = f14;
    }

    public /* synthetic */ PaddingValuesImpl(float f11, float f12, float f13, float f14, DefaultConstructorMarker defaultConstructorMarker) {
        this(f11, f12, f13, f14);
    }

    @Stable
    /* renamed from: getBottom-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m508getBottomD9Ej5fM$annotations() {
    }

    @Stable
    /* renamed from: getEnd-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m509getEndD9Ej5fM$annotations() {
    }

    @Stable
    /* renamed from: getStart-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m510getStartD9Ej5fM$annotations() {
    }

    @Stable
    /* renamed from: getTop-D9Ej5fM$annotations  reason: not valid java name */
    public static /* synthetic */ void m511getTopD9Ej5fM$annotations() {
    }

    /* renamed from: calculateBottomPadding-D9Ej5fM  reason: not valid java name */
    public float m512calculateBottomPaddingD9Ej5fM() {
        return this.bottom;
    }

    /* renamed from: calculateLeftPadding-u2uoSUM  reason: not valid java name */
    public float m513calculateLeftPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (layoutDirection == LayoutDirection.Ltr) {
            return this.start;
        }
        return this.end;
    }

    /* renamed from: calculateRightPadding-u2uoSUM  reason: not valid java name */
    public float m514calculateRightPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        if (layoutDirection == LayoutDirection.Ltr) {
            return this.end;
        }
        return this.start;
    }

    /* renamed from: calculateTopPadding-D9Ej5fM  reason: not valid java name */
    public float m515calculateTopPaddingD9Ej5fM() {
        return this.top;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof PaddingValuesImpl)) {
            return false;
        }
        PaddingValuesImpl paddingValuesImpl = (PaddingValuesImpl) obj;
        if (!Dp.m5483equalsimpl0(this.start, paddingValuesImpl.start) || !Dp.m5483equalsimpl0(this.top, paddingValuesImpl.top) || !Dp.m5483equalsimpl0(this.end, paddingValuesImpl.end) || !Dp.m5483equalsimpl0(this.bottom, paddingValuesImpl.bottom)) {
            return false;
        }
        return true;
    }

    /* renamed from: getBottom-D9Ej5fM  reason: not valid java name */
    public final float m516getBottomD9Ej5fM() {
        return this.bottom;
    }

    /* renamed from: getEnd-D9Ej5fM  reason: not valid java name */
    public final float m517getEndD9Ej5fM() {
        return this.end;
    }

    /* renamed from: getStart-D9Ej5fM  reason: not valid java name */
    public final float m518getStartD9Ej5fM() {
        return this.start;
    }

    /* renamed from: getTop-D9Ej5fM  reason: not valid java name */
    public final float m519getTopD9Ej5fM() {
        return this.top;
    }

    public int hashCode() {
        return (((((Dp.m5484hashCodeimpl(this.start) * 31) + Dp.m5484hashCodeimpl(this.top)) * 31) + Dp.m5484hashCodeimpl(this.end)) * 31) + Dp.m5484hashCodeimpl(this.bottom);
    }

    @NotNull
    public String toString() {
        return "PaddingValues(start=" + Dp.m5489toStringimpl(this.start) + ", top=" + Dp.m5489toStringimpl(this.top) + ", end=" + Dp.m5489toStringimpl(this.end) + ", bottom=" + Dp.m5489toStringimpl(this.bottom) + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PaddingValuesImpl(float f11, float f12, float f13, float f14, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? Dp.m5478constructorimpl((float) 0) : f11, (i11 & 2) != 0 ? Dp.m5478constructorimpl((float) 0) : f12, (i11 & 4) != 0 ? Dp.m5478constructorimpl((float) 0) : f13, (i11 & 8) != 0 ? Dp.m5478constructorimpl((float) 0) : f14, (DefaultConstructorMarker) null);
    }
}
