package androidx.compose.foundation;

import a0.a;
import a0.b;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.OnGloballyPositionedModifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0006\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/compose/foundation/FocusedBoundsModifier;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "Landroidx/compose/ui/layout/OnGloballyPositionedModifier;", "()V", "layoutCoordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "observer", "Lkotlin/Function1;", "", "notifyObserverWhenAttached", "onGloballyPositioned", "coordinates", "onModifierLocalsUpdated", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class FocusedBoundsModifier implements ModifierLocalConsumer, OnGloballyPositionedModifier {
    @Nullable
    private LayoutCoordinates layoutCoordinates;
    @Nullable
    private Function1<? super LayoutCoordinates, Unit> observer;

    private final void notifyObserverWhenAttached() {
        Function1<? super LayoutCoordinates, Unit> function1;
        LayoutCoordinates layoutCoordinates2 = this.layoutCoordinates;
        if (layoutCoordinates2 != null) {
            Intrinsics.checkNotNull(layoutCoordinates2);
            if (layoutCoordinates2.isAttached() && (function1 = this.observer) != null) {
                function1.invoke(this.layoutCoordinates);
            }
        }
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    public /* synthetic */ Object foldIn(Object obj, Function2 function2) {
        return b.c(this, obj, function2);
    }

    public /* synthetic */ Object foldOut(Object obj, Function2 function2) {
        return b.d(this, obj, function2);
    }

    public void onGloballyPositioned(@NotNull LayoutCoordinates layoutCoordinates2) {
        Intrinsics.checkNotNullParameter(layoutCoordinates2, "coordinates");
        this.layoutCoordinates = layoutCoordinates2;
        if (layoutCoordinates2.isAttached()) {
            notifyObserverWhenAttached();
            return;
        }
        Function1<? super LayoutCoordinates, Unit> function1 = this.observer;
        if (function1 != null) {
            function1.invoke(null);
        }
    }

    public void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope modifierLocalReadScope) {
        Function1<? super LayoutCoordinates, Unit> function1;
        Intrinsics.checkNotNullParameter(modifierLocalReadScope, "scope");
        Function1<? super LayoutCoordinates, Unit> function12 = (Function1) modifierLocalReadScope.getCurrent(FocusedBoundsKt.getModifierLocalFocusedBoundsObserver());
        if (function12 == null && (function1 = this.observer) != null) {
            function1.invoke(null);
        }
        this.observer = function12;
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }
}
