package androidx.compose.foundation.layout;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import com.instabug.library.model.State;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0018\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u001e\u001a\u00020\u0016H\u0016J\b\u0010\u001f\u001a\u00020\u0005H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR+\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00038@@@X\u0002¢\u0006\u0012\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006 "}, d2 = {"Landroidx/compose/foundation/layout/ValueInsets;", "Landroidx/compose/foundation/layout/WindowInsets;", "insets", "Landroidx/compose/foundation/layout/InsetsValues;", "name", "", "(Landroidx/compose/foundation/layout/InsetsValues;Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "<set-?>", "value", "getValue$foundation_layout_release", "()Landroidx/compose/foundation/layout/InsetsValues;", "setValue$foundation_layout_release", "(Landroidx/compose/foundation/layout/InsetsValues;)V", "value$delegate", "Landroidx/compose/runtime/MutableState;", "equals", "", "other", "", "getBottom", "", "density", "Landroidx/compose/ui/unit/Density;", "getLeft", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getRight", "getTop", "hashCode", "toString", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Stable
public final class ValueInsets implements WindowInsets {
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f2588name;
    @NotNull
    private final MutableState value$delegate;

    public ValueInsets(@NotNull InsetsValues insetsValues, @NotNull String str) {
        Intrinsics.checkNotNullParameter(insetsValues, "insets");
        Intrinsics.checkNotNullParameter(str, "name");
        this.f2588name = str;
        this.value$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(insetsValues, (SnapshotMutationPolicy) null, 2, (Object) null);
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ValueInsets)) {
            return false;
        }
        return Intrinsics.areEqual((Object) getValue$foundation_layout_release(), (Object) ((ValueInsets) obj).getValue$foundation_layout_release());
    }

    public int getBottom(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        return getValue$foundation_layout_release().getBottom();
    }

    public int getLeft(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return getValue$foundation_layout_release().getLeft();
    }

    @NotNull
    public final String getName() {
        return this.f2588name;
    }

    public int getRight(@NotNull Density density, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return getValue$foundation_layout_release().getRight();
    }

    public int getTop(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        return getValue$foundation_layout_release().getTop();
    }

    @NotNull
    public final InsetsValues getValue$foundation_layout_release() {
        return (InsetsValues) this.value$delegate.getValue();
    }

    public int hashCode() {
        return this.f2588name.hashCode();
    }

    public final void setValue$foundation_layout_release(@NotNull InsetsValues insetsValues) {
        Intrinsics.checkNotNullParameter(insetsValues, "<set-?>");
        this.value$delegate.setValue(insetsValues);
    }

    @NotNull
    public String toString() {
        return this.f2588name + "(left=" + getValue$foundation_layout_release().getLeft() + ", top=" + getValue$foundation_layout_release().getTop() + ", right=" + getValue$foundation_layout_release().getRight() + ", bottom=" + getValue$foundation_layout_release().getBottom() + ')';
    }
}
