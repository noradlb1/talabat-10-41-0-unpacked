package androidx.compose.material3;

import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.runtime.Immutable;
import com.adjust.sdk.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ8\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u0003J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u0017"}, d2 = {"Landroidx/compose/material3/Shapes;", "", "extraSmall", "Landroidx/compose/foundation/shape/CornerBasedShape;", "small", "medium", "large", "extraLarge", "(Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;Landroidx/compose/foundation/shape/CornerBasedShape;)V", "getExtraLarge", "()Landroidx/compose/foundation/shape/CornerBasedShape;", "getExtraSmall", "getLarge", "getMedium", "getSmall", "copy", "equals", "", "other", "hashCode", "", "toString", "", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class Shapes {
    @NotNull
    private final CornerBasedShape extraLarge;
    @NotNull
    private final CornerBasedShape extraSmall;
    @NotNull
    private final CornerBasedShape large;
    @NotNull
    private final CornerBasedShape medium;
    @NotNull
    private final CornerBasedShape small;

    public Shapes() {
        this((CornerBasedShape) null, (CornerBasedShape) null, (CornerBasedShape) null, (CornerBasedShape) null, (CornerBasedShape) null, 31, (DefaultConstructorMarker) null);
    }

    public Shapes(@NotNull CornerBasedShape cornerBasedShape, @NotNull CornerBasedShape cornerBasedShape2, @NotNull CornerBasedShape cornerBasedShape3, @NotNull CornerBasedShape cornerBasedShape4, @NotNull CornerBasedShape cornerBasedShape5) {
        Intrinsics.checkNotNullParameter(cornerBasedShape, "extraSmall");
        Intrinsics.checkNotNullParameter(cornerBasedShape2, Constants.SMALL);
        Intrinsics.checkNotNullParameter(cornerBasedShape3, "medium");
        Intrinsics.checkNotNullParameter(cornerBasedShape4, Constants.LARGE);
        Intrinsics.checkNotNullParameter(cornerBasedShape5, "extraLarge");
        this.extraSmall = cornerBasedShape;
        this.small = cornerBasedShape2;
        this.medium = cornerBasedShape3;
        this.large = cornerBasedShape4;
        this.extraLarge = cornerBasedShape5;
    }

    public static /* synthetic */ Shapes copy$default(Shapes shapes, CornerBasedShape cornerBasedShape, CornerBasedShape cornerBasedShape2, CornerBasedShape cornerBasedShape3, CornerBasedShape cornerBasedShape4, CornerBasedShape cornerBasedShape5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            cornerBasedShape = shapes.extraSmall;
        }
        if ((i11 & 2) != 0) {
            cornerBasedShape2 = shapes.small;
        }
        CornerBasedShape cornerBasedShape6 = cornerBasedShape2;
        if ((i11 & 4) != 0) {
            cornerBasedShape3 = shapes.medium;
        }
        CornerBasedShape cornerBasedShape7 = cornerBasedShape3;
        if ((i11 & 8) != 0) {
            cornerBasedShape4 = shapes.large;
        }
        CornerBasedShape cornerBasedShape8 = cornerBasedShape4;
        if ((i11 & 16) != 0) {
            cornerBasedShape5 = shapes.extraLarge;
        }
        return shapes.copy(cornerBasedShape, cornerBasedShape6, cornerBasedShape7, cornerBasedShape8, cornerBasedShape5);
    }

    @NotNull
    public final Shapes copy(@NotNull CornerBasedShape cornerBasedShape, @NotNull CornerBasedShape cornerBasedShape2, @NotNull CornerBasedShape cornerBasedShape3, @NotNull CornerBasedShape cornerBasedShape4, @NotNull CornerBasedShape cornerBasedShape5) {
        Intrinsics.checkNotNullParameter(cornerBasedShape, "extraSmall");
        Intrinsics.checkNotNullParameter(cornerBasedShape2, Constants.SMALL);
        Intrinsics.checkNotNullParameter(cornerBasedShape3, "medium");
        Intrinsics.checkNotNullParameter(cornerBasedShape4, Constants.LARGE);
        Intrinsics.checkNotNullParameter(cornerBasedShape5, "extraLarge");
        return new Shapes(cornerBasedShape, cornerBasedShape2, cornerBasedShape3, cornerBasedShape4, cornerBasedShape5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Shapes)) {
            return false;
        }
        Shapes shapes = (Shapes) obj;
        if (Intrinsics.areEqual((Object) this.extraSmall, (Object) shapes.extraSmall) && Intrinsics.areEqual((Object) this.small, (Object) shapes.small) && Intrinsics.areEqual((Object) this.medium, (Object) shapes.medium) && Intrinsics.areEqual((Object) this.large, (Object) shapes.large) && Intrinsics.areEqual((Object) this.extraLarge, (Object) shapes.extraLarge)) {
            return true;
        }
        return false;
    }

    @NotNull
    public final CornerBasedShape getExtraLarge() {
        return this.extraLarge;
    }

    @NotNull
    public final CornerBasedShape getExtraSmall() {
        return this.extraSmall;
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
        return (((((((this.extraSmall.hashCode() * 31) + this.small.hashCode()) * 31) + this.medium.hashCode()) * 31) + this.large.hashCode()) * 31) + this.extraLarge.hashCode();
    }

    @NotNull
    public String toString() {
        return "Shapes(extraSmall=" + this.extraSmall + ", small=" + this.small + ", medium=" + this.medium + ", large=" + this.large + ", extraLarge=" + this.extraLarge + ')';
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Shapes(androidx.compose.foundation.shape.CornerBasedShape r4, androidx.compose.foundation.shape.CornerBasedShape r5, androidx.compose.foundation.shape.CornerBasedShape r6, androidx.compose.foundation.shape.CornerBasedShape r7, androidx.compose.foundation.shape.CornerBasedShape r8, int r9, kotlin.jvm.internal.DefaultConstructorMarker r10) {
        /*
            r3 = this;
            r10 = r9 & 1
            if (r10 == 0) goto L_0x000a
            androidx.compose.material3.ShapeDefaults r4 = androidx.compose.material3.ShapeDefaults.INSTANCE
            androidx.compose.foundation.shape.CornerBasedShape r4 = r4.getExtraSmall()
        L_0x000a:
            r10 = r9 & 2
            if (r10 == 0) goto L_0x0014
            androidx.compose.material3.ShapeDefaults r5 = androidx.compose.material3.ShapeDefaults.INSTANCE
            androidx.compose.foundation.shape.CornerBasedShape r5 = r5.getSmall()
        L_0x0014:
            r10 = r5
            r5 = r9 & 4
            if (r5 == 0) goto L_0x001f
            androidx.compose.material3.ShapeDefaults r5 = androidx.compose.material3.ShapeDefaults.INSTANCE
            androidx.compose.foundation.shape.CornerBasedShape r6 = r5.getMedium()
        L_0x001f:
            r0 = r6
            r5 = r9 & 8
            if (r5 == 0) goto L_0x002a
            androidx.compose.material3.ShapeDefaults r5 = androidx.compose.material3.ShapeDefaults.INSTANCE
            androidx.compose.foundation.shape.CornerBasedShape r7 = r5.getLarge()
        L_0x002a:
            r1 = r7
            r5 = r9 & 16
            if (r5 == 0) goto L_0x0035
            androidx.compose.material3.ShapeDefaults r5 = androidx.compose.material3.ShapeDefaults.INSTANCE
            androidx.compose.foundation.shape.CornerBasedShape r8 = r5.getExtraLarge()
        L_0x0035:
            r2 = r8
            r5 = r3
            r6 = r4
            r7 = r10
            r8 = r0
            r9 = r1
            r10 = r2
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material3.Shapes.<init>(androidx.compose.foundation.shape.CornerBasedShape, androidx.compose.foundation.shape.CornerBasedShape, androidx.compose.foundation.shape.CornerBasedShape, androidx.compose.foundation.shape.CornerBasedShape, androidx.compose.foundation.shape.CornerBasedShape, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
