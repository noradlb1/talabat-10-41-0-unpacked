package androidx.compose.ui.layout;

import a0.a;
import a0.b;
import androidx.compose.runtime.Immutable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B&\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0017\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\n¢\u0006\u0002\u0010\u000bJ\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0005H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u0005*\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0005H\u0016R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Landroidx/compose/ui/layout/LayoutId;", "Landroidx/compose/ui/layout/ParentDataModifier;", "Landroidx/compose/ui/layout/LayoutIdParentData;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "layoutId", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "getLayoutId", "()Ljava/lang/Object;", "equals", "", "other", "hashCode", "", "toString", "", "modifyParentData", "Landroidx/compose/ui/unit/Density;", "parentData", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class LayoutId extends InspectorValueInfo implements ParentDataModifier, LayoutIdParentData {
    @NotNull
    private final Object layoutId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LayoutId(@NotNull Object obj, @NotNull Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(obj, "layoutId");
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        this.layoutId = obj;
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        LayoutId layoutId2;
        if (this == obj) {
            return true;
        }
        if (obj instanceof LayoutId) {
            layoutId2 = (LayoutId) obj;
        } else {
            layoutId2 = null;
        }
        if (layoutId2 == null) {
            return false;
        }
        return Intrinsics.areEqual(getLayoutId(), layoutId2.getLayoutId());
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return b.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return b.d(this, obj, function2);
    }

    @NotNull
    public Object getLayoutId() {
        return this.layoutId;
    }

    public int hashCode() {
        return getLayoutId().hashCode();
    }

    @Nullable
    public Object modifyParentData(@NotNull Density density, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        return this;
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "LayoutId(id=" + getLayoutId() + ')';
    }
}
