package androidx.compose.foundation.layout;

import a0.a;
import a0.b;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B&\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0017\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006¢\u0006\u0002\b\t¢\u0006\u0002\u0010\nJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\u0016\u0010\u0015\u001a\u00020\u0016*\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0010H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, d2 = {"Landroidx/compose/foundation/layout/HorizontalAlignModifier;", "Landroidx/compose/ui/layout/ParentDataModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "horizontal", "Landroidx/compose/ui/Alignment$Horizontal;", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Alignment$Horizontal;Lkotlin/jvm/functions/Function1;)V", "getHorizontal", "()Landroidx/compose/ui/Alignment$Horizontal;", "equals", "", "other", "", "hashCode", "", "toString", "", "modifyParentData", "Landroidx/compose/foundation/layout/RowColumnParentData;", "Landroidx/compose/ui/unit/Density;", "parentData", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class HorizontalAlignModifier extends InspectorValueInfo implements ParentDataModifier {
    @NotNull
    private final Alignment.Horizontal horizontal;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HorizontalAlignModifier(@NotNull Alignment.Horizontal horizontal2, @NotNull Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(horizontal2, "horizontal");
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        this.horizontal = horizontal2;
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        HorizontalAlignModifier horizontalAlignModifier;
        if (this == obj) {
            return true;
        }
        if (obj instanceof HorizontalAlignModifier) {
            horizontalAlignModifier = (HorizontalAlignModifier) obj;
        } else {
            horizontalAlignModifier = null;
        }
        if (horizontalAlignModifier == null) {
            return false;
        }
        return Intrinsics.areEqual((Object) this.horizontal, (Object) horizontalAlignModifier.horizontal);
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return b.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return b.d(this, obj, function2);
    }

    @NotNull
    public final Alignment.Horizontal getHorizontal() {
        return this.horizontal;
    }

    public int hashCode() {
        return this.horizontal.hashCode();
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "HorizontalAlignModifier(horizontal=" + this.horizontal + ')';
    }

    @NotNull
    public RowColumnParentData modifyParentData(@NotNull Density density, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        RowColumnParentData rowColumnParentData = obj instanceof RowColumnParentData ? (RowColumnParentData) obj : null;
        if (rowColumnParentData == null) {
            rowColumnParentData = new RowColumnParentData(0.0f, false, (CrossAxisAlignment) null, 7, (DefaultConstructorMarker) null);
        }
        rowColumnParentData.setCrossAxisAlignment(CrossAxisAlignment.Companion.horizontal$foundation_layout_release(this.horizontal));
        return rowColumnParentData;
    }
}
