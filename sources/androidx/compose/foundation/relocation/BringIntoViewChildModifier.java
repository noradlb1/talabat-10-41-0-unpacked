package androidx.compose.foundation.relocation;

import a0.a;
import a0.b;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnPlacedModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b \u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0003H\u0016J\u0010\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0007H\u0016R\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\fR\u0018\u0010\r\u001a\u0004\u0018\u00010\n8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\r\u0010\fR(\u0010\u000f\u001a\u0004\u0018\u00010\u00072\b\u0010\u000e\u001a\u0004\u0018\u00010\u00078D@BX\u000e¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0015\u001a\u00020\n8DX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0018"}, d2 = {"Landroidx/compose/foundation/relocation/BringIntoViewChildModifier;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/layout/OnPlacedModifier;", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "scope", "", "onModifierLocalsUpdated", "Landroidx/compose/ui/layout/LayoutCoordinates;", "coordinates", "onPlaced", "Landroidx/compose/foundation/relocation/BringIntoViewParent;", "defaultParent", "Landroidx/compose/foundation/relocation/BringIntoViewParent;", "localParent", "<set-?>", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "a", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "b", "()Landroidx/compose/foundation/relocation/BringIntoViewParent;", "parent", "<init>", "(Landroidx/compose/foundation/relocation/BringIntoViewParent;)V", "foundation_release"}, k = 1, mv = {1, 7, 1})
public abstract class BringIntoViewChildModifier implements ModifierLocalConsumer, OnPlacedModifier {
    @NotNull
    private final BringIntoViewParent defaultParent;
    @Nullable
    private LayoutCoordinates layoutCoordinates;
    @Nullable
    private BringIntoViewParent localParent;

    public BringIntoViewChildModifier(@NotNull BringIntoViewParent bringIntoViewParent) {
        Intrinsics.checkNotNullParameter(bringIntoViewParent, "defaultParent");
        this.defaultParent = bringIntoViewParent;
    }

    @Nullable
    public final LayoutCoordinates a() {
        LayoutCoordinates layoutCoordinates2 = this.layoutCoordinates;
        if (layoutCoordinates2 == null || !layoutCoordinates2.isAttached()) {
            return null;
        }
        return layoutCoordinates2;
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    @NotNull
    public final BringIntoViewParent b() {
        BringIntoViewParent bringIntoViewParent = this.localParent;
        return bringIntoViewParent == null ? this.defaultParent : bringIntoViewParent;
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return b.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return b.d(this, obj, function2);
    }

    public void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope modifierLocalReadScope) {
        Intrinsics.checkNotNullParameter(modifierLocalReadScope, "scope");
        this.localParent = (BringIntoViewParent) modifierLocalReadScope.getCurrent(BringIntoViewKt.getModifierLocalBringIntoViewParent());
    }

    public void onPlaced(@NotNull LayoutCoordinates layoutCoordinates2) {
        Intrinsics.checkNotNullParameter(layoutCoordinates2, "coordinates");
        this.layoutCoordinates = layoutCoordinates2;
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }
}
