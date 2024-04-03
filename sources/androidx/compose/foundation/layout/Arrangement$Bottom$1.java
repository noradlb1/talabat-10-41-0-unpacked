package androidx.compose.foundation.layout;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p.c;

@Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J$\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"androidx/compose/foundation/layout/Arrangement$Bottom$1", "Landroidx/compose/foundation/layout/Arrangement$Vertical;", "toString", "", "arrange", "", "Landroidx/compose/ui/unit/Density;", "totalSize", "", "sizes", "", "outPositions", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Arrangement$Bottom$1 implements Arrangement.Vertical {
    public void arrange(@NotNull Density density, int i11, @NotNull int[] iArr, @NotNull int[] iArr2) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        Intrinsics.checkNotNullParameter(iArr, "sizes");
        Intrinsics.checkNotNullParameter(iArr2, "outPositions");
        Arrangement.INSTANCE.placeRightOrBottom$foundation_layout_release(i11, iArr, iArr2, false);
    }

    /* renamed from: getSpacing-D9Ej5fM  reason: not valid java name */
    public /* synthetic */ float m406getSpacingD9Ej5fM() {
        return c.a(this);
    }

    @NotNull
    public String toString() {
        return "Arrangement#Bottom";
    }
}
