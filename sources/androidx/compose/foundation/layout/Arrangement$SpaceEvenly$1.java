package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0007\u001a\u00020\bH\u0016J,\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J$\u0010\t\u001a\u00020\n*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0016R\u001f\u0010\u0002\u001a\u00020\u0003X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0013"}, d2 = {"androidx/compose/foundation/layout/Arrangement$SpaceEvenly$1", "Landroidx/compose/foundation/layout/Arrangement$HorizontalOrVertical;", "spacing", "Landroidx/compose/ui/unit/Dp;", "getSpacing-D9Ej5fM", "()F", "F", "toString", "", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "outPositions", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Arrangement$SpaceEvenly$1 implements Arrangement.HorizontalOrVertical {
    private final float spacing = Dp.m5478constructorimpl((float) 0);

    public void arrange(@NotNull Density density, int i11, @NotNull int[] iArr, @NotNull LayoutDirection layoutDirection, @NotNull int[] iArr2) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        Intrinsics.checkNotNullParameter(iArr, "sizes");
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(iArr2, "outPositions");
        if (layoutDirection == LayoutDirection.Ltr) {
            Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i11, iArr, iArr2, false);
        } else {
            Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i11, iArr, iArr2, true);
        }
    }

    /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
    public float m415getSpacingD9Ej5fM() {
        return this.spacing;
    }

    @NotNull
    public String toString() {
        return "Arrangement#SpaceEvenly";
    }

    public void arrange(@NotNull Density density, int i11, @NotNull int[] iArr, @NotNull int[] iArr2) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        Intrinsics.checkNotNullParameter(iArr, "sizes");
        Intrinsics.checkNotNullParameter(iArr2, "outPositions");
        Arrangement.INSTANCE.placeSpaceEvenly$foundation_layout_release(i11, iArr, iArr2, false);
    }
}
