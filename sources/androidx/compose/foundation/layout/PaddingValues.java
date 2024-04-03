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

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\bg\u0018\u00002\u00020\u0001:\u0001\u000fJ\u0018\u0010\u0002\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u0004\u0010\u0005J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\t\u0010\nJ \u0010\u000b\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\f\u0010\nJ\u0018\u0010\r\u001a\u00020\u0003H&ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\b\u000e\u0010\u0005ø\u0001\u0003\u0002\u0015\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Landroidx/compose/foundation/layout/PaddingValues;", "", "calculateBottomPadding", "Landroidx/compose/ui/unit/Dp;", "calculateBottomPadding-D9Ej5fM", "()F", "calculateLeftPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "Absolute", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Stable
public interface PaddingValues {
    /* renamed from: calculateBottomPadding-D9Ej5fM  reason: not valid java name */
    float m496calculateBottomPaddingD9Ej5fM();

    /* renamed from: calculateLeftPadding-u2uoSUM  reason: not valid java name */
    float m497calculateLeftPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection);

    /* renamed from: calculateRightPadding-u2uoSUM  reason: not valid java name */
    float m498calculateRightPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection);

    /* renamed from: calculateTopPadding-D9Ej5fM  reason: not valid java name */
    float m499calculateTopPaddingD9Ej5fM();

    @Immutable
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B0\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\u0018\u0010\u000e\u001a\u00020\u0003H\u0016ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0014\u0010\u0015J \u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0017\u0010\u0015J\u0018\u0010\u0018\u001a\u00020\u0003H\u0016ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\u0019\u0010\u0010J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020!H\u0016R!\u0010\u0006\u001a\u00020\u00038\u0002X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u0012\u0004\b\b\u0010\tR!\u0010\u0002\u001a\u00020\u00038\u0002X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u0012\u0004\b\u000b\u0010\tR!\u0010\u0005\u001a\u00020\u00038\u0002X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u0012\u0004\b\f\u0010\tR!\u0010\u0004\u001a\u00020\u00038\u0002X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\n\u0012\u0004\b\r\u0010\t\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\""}, d2 = {"Landroidx/compose/foundation/layout/PaddingValues$Absolute;", "Landroidx/compose/foundation/layout/PaddingValues;", "left", "Landroidx/compose/ui/unit/Dp;", "top", "right", "bottom", "(FFFFLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getBottom-D9Ej5fM$annotations", "()V", "F", "getLeft-D9Ej5fM$annotations", "getRight-D9Ej5fM$annotations", "getTop-D9Ej5fM$annotations", "calculateBottomPadding", "calculateBottomPadding-D9Ej5fM", "()F", "calculateLeftPadding", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "calculateLeftPadding-u2uoSUM", "(Landroidx/compose/ui/unit/LayoutDirection;)F", "calculateRightPadding", "calculateRightPadding-u2uoSUM", "calculateTopPadding", "calculateTopPadding-D9Ej5fM", "equals", "", "other", "", "hashCode", "", "toString", "", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Absolute implements PaddingValues {
        private final float bottom;
        private final float left;
        private final float right;
        private final float top;

        private Absolute(float f11, float f12, float f13, float f14) {
            this.left = f11;
            this.top = f12;
            this.right = f13;
            this.bottom = f14;
        }

        public /* synthetic */ Absolute(float f11, float f12, float f13, float f14, DefaultConstructorMarker defaultConstructorMarker) {
            this(f11, f12, f13, f14);
        }

        @Stable
        /* renamed from: getBottom-D9Ej5fM$annotations  reason: not valid java name */
        private static /* synthetic */ void m500getBottomD9Ej5fM$annotations() {
        }

        @Stable
        /* renamed from: getLeft-D9Ej5fM$annotations  reason: not valid java name */
        private static /* synthetic */ void m501getLeftD9Ej5fM$annotations() {
        }

        @Stable
        /* renamed from: getRight-D9Ej5fM$annotations  reason: not valid java name */
        private static /* synthetic */ void m502getRightD9Ej5fM$annotations() {
        }

        @Stable
        /* renamed from: getTop-D9Ej5fM$annotations  reason: not valid java name */
        private static /* synthetic */ void m503getTopD9Ej5fM$annotations() {
        }

        /* renamed from: calculateBottomPadding-D9Ej5fM  reason: not valid java name */
        public float m504calculateBottomPaddingD9Ej5fM() {
            return this.bottom;
        }

        /* renamed from: calculateLeftPadding-u2uoSUM  reason: not valid java name */
        public float m505calculateLeftPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection) {
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            return this.left;
        }

        /* renamed from: calculateRightPadding-u2uoSUM  reason: not valid java name */
        public float m506calculateRightPaddingu2uoSUM(@NotNull LayoutDirection layoutDirection) {
            Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
            return this.right;
        }

        /* renamed from: calculateTopPadding-D9Ej5fM  reason: not valid java name */
        public float m507calculateTopPaddingD9Ej5fM() {
            return this.top;
        }

        public boolean equals(@Nullable Object obj) {
            if (!(obj instanceof Absolute)) {
                return false;
            }
            Absolute absolute = (Absolute) obj;
            if (!Dp.m5483equalsimpl0(this.left, absolute.left) || !Dp.m5483equalsimpl0(this.top, absolute.top) || !Dp.m5483equalsimpl0(this.right, absolute.right) || !Dp.m5483equalsimpl0(this.bottom, absolute.bottom)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((((Dp.m5484hashCodeimpl(this.left) * 31) + Dp.m5484hashCodeimpl(this.top)) * 31) + Dp.m5484hashCodeimpl(this.right)) * 31) + Dp.m5484hashCodeimpl(this.bottom);
        }

        @NotNull
        public String toString() {
            return "PaddingValues.Absolute(left=" + Dp.m5489toStringimpl(this.left) + ", top=" + Dp.m5489toStringimpl(this.top) + ", right=" + Dp.m5489toStringimpl(this.right) + ", bottom=" + Dp.m5489toStringimpl(this.bottom) + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Absolute(float f11, float f12, float f13, float f14, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? Dp.m5478constructorimpl((float) 0) : f11, (i11 & 2) != 0 ? Dp.m5478constructorimpl((float) 0) : f12, (i11 & 4) != 0 ? Dp.m5478constructorimpl((float) 0) : f13, (i11 & 8) != 0 ? Dp.m5478constructorimpl((float) 0) : f14, (DefaultConstructorMarker) null);
        }
    }
}
