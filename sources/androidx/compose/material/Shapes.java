package androidx.compose.material;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.unit.Dp;
import com.adjust.sdk.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J$\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0013"}, d2 = {"Landroidx/compose/material/Shapes;", "", "small", "Landroidx/compose/foundation/shape/CornerBasedShape;", "medium", "large", "(Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;)V", "getLarge", "()Landroidx/compose/foundation/shape/CornerBasedShape;", "getMedium", "getSmall", "copy", "equals", "", "other", "hashCode", "", "toString", "", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Shapes {
    @NotNull
    private final CornerBasedShape large;
    @NotNull
    private final CornerBasedShape medium;
    @NotNull
    private final CornerBasedShape small;

    public Shapes() {
        this((CornerBasedShape) null, (CornerBasedShape) null, (CornerBasedShape) null, 7, (DefaultConstructorMarker) null);
    }

    public Shapes(@NotNull CornerBasedShape cornerBasedShape, @NotNull CornerBasedShape cornerBasedShape2, @NotNull CornerBasedShape cornerBasedShape3) {
        Intrinsics.checkNotNullParameter(cornerBasedShape, Constants.SMALL);
        Intrinsics.checkNotNullParameter(cornerBasedShape2, "medium");
        Intrinsics.checkNotNullParameter(cornerBasedShape3, Constants.LARGE);
        this.small = cornerBasedShape;
        this.medium = cornerBasedShape2;
        this.large = cornerBasedShape3;
    }

    public static /* synthetic */ Shapes copy$default(Shapes shapes, CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cornerBasedShape = shapes.small;
        }
        if ((i11 & 2) != 0) {
            cornerBasedShape2 = shapes.medium;
        }
        if ((i11 & 4) != 0) {
            cornerBasedShape3 = shapes.large;
        }
        return shapes.copy(cornerBasedShape, cornerBasedShape2, cornerBasedShape3);
    }

    @NotNull
    public final Shapes copy(@NotNull CornerBasedShape cornerBasedShape, @NotNull CornerBasedShape cornerBasedShape2, @NotNull CornerBasedShape cornerBasedShape3) {
        Intrinsics.checkNotNullParameter(cornerBasedShape, Constants.SMALL);
        Intrinsics.checkNotNullParameter(cornerBasedShape2, "medium");
        Intrinsics.checkNotNullParameter(cornerBasedShape3, Constants.LARGE);
        return new Shapes(cornerBasedShape, cornerBasedShape2, cornerBasedShape3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Shapes)) {
            return false;
        }
        Shapes shapes = (Shapes) obj;
        if (Intrinsics.areEqual((Object) this.small, (Object) shapes.small) && Intrinsics.areEqual((Object) this.medium, (Object) shapes.medium) && Intrinsics.areEqual((Object) this.large, (Object) shapes.large)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final CornerBasedShape getLarge() {
        return this.large;
    }

    @NotNull
    public final CornerBasedShape getMedium() {
        return this.medium;
    }

    @NotNull
    public final CornerBasedShape getSmall() {
        return this.small;
    }

    public int hashCode() {
        return (((this.small.hashCode() * 31) + this.medium.hashCode()) * 31) + this.large.hashCode();
    }

    @NotNull
    public String toString() {
        return "Shapes(small=" + this.small + ", medium=" + this.medium + ", large=" + this.large + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Shapes(CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(Dp.m5478constructorimpl((float) 4)) : cornerBasedShape, (i11 & 2) != 0 ? RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(Dp.m5478constructorimpl((float) 4)) : cornerBasedShape2, (i11 & 4) != 0 ? RoundedCornerShapeKt.m821RoundedCornerShape0680j_4(Dp.m5478constructorimpl((float) 0)) : cornerBasedShape3);
    }
}
