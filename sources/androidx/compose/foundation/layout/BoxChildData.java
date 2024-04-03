package androidx.compose.foundation.layout;

import a0.a;
import a0.b;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.ParentDataModifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import n.e;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B2\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\u0019\b\u0002\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b¢\u0006\u0002\u0010\fJ\u0013\u0010\u0015\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\u0016\u0010\u001c\u001a\u00020\u0000*\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0017H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Landroidx/compose/foundation/layout/BoxChildData;", "Landroidx/compose/ui/layout/ParentDataModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "alignment", "Landroidx/compose/ui/Alignment;", "matchParentSize", "", "inspectorInfo", "Lkotlin/Function1;", "Landroidx/compose/ui/platform/InspectorInfo;", "", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Alignment;ZLkotlin/jvm/functions/Function1;)V", "getAlignment", "()Landroidx/compose/ui/Alignment;", "setAlignment", "(Landroidx/compose/ui/Alignment;)V", "getMatchParentSize", "()Z", "setMatchParentSize", "(Z)V", "equals", "other", "", "hashCode", "", "toString", "", "modifyParentData", "Landroidx/compose/ui/unit/Density;", "parentData", "foundation-layout_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class BoxChildData extends InspectorValueInfo implements ParentDataModifier {
    @NotNull
    private Alignment alignment;
    private boolean matchParentSize;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BoxChildData(Alignment alignment2, boolean z11, Function1<InspectorInfo, Unit> function1, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(alignment2, (i11 & 2) != 0 ? false : z11, (i11 & 4) != 0 ? InspectableValueKt.getNoInspectorInfo() : function1);
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        BoxChildData boxChildData;
        if (this == obj) {
            return true;
        }
        if (obj instanceof BoxChildData) {
            boxChildData = (BoxChildData) obj;
        } else {
            boxChildData = null;
        }
        if (boxChildData == null) {
            return false;
        }
        if (!Intrinsics.areEqual((Object) this.alignment, (Object) boxChildData.alignment) || this.matchParentSize != boxChildData.matchParentSize) {
            return false;
        }
        return true;
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return b.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return b.d(this, obj, function2);
    }

    @NotNull
    public final Alignment getAlignment() {
        return this.alignment;
    }

    public final boolean getMatchParentSize() {
        return this.matchParentSize;
    }

    public int hashCode() {
        return (this.alignment.hashCode() * 31) + e.a(this.matchParentSize);
    }

    @NotNull
    public BoxChildData modifyParentData(@NotNull Density density, @Nullable Object obj) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        return this;
    }

    public final void setAlignment(@NotNull Alignment alignment2) {
        Intrinsics.checkNotNullParameter(alignment2, "<set-?>");
        this.alignment = alignment2;
    }

    public final void setMatchParentSize(boolean z11) {
        this.matchParentSize = z11;
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }

    @NotNull
    public String toString() {
        return "BoxChildData(alignment=" + this.alignment + ", matchParentSize=" + this.matchParentSize + ')';
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BoxChildData(@NotNull Alignment alignment2, boolean z11, @NotNull Function1<? super InspectorInfo, Unit> function1) {
        super(function1);
        Intrinsics.checkNotNullParameter(alignment2, "alignment");
        Intrinsics.checkNotNullParameter(function1, "inspectorInfo");
        this.alignment = alignment2;
        this.matchParentSize = z11;
    }
}
