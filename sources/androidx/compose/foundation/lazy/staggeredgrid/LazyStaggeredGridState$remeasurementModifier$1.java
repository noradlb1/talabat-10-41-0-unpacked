package androidx.compose.foundation.lazy.staggeredgrid;

import a0.a;
import a0.b;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"androidx/compose/foundation/lazy/staggeredgrid/LazyStaggeredGridState$remeasurementModifier$1", "Landroidx/compose/ui/layout/RemeasurementModifier;", "onRemeasurementAvailable", "", "remeasurement", "Landroidx/compose/ui/layout/Remeasurement;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LazyStaggeredGridState$remeasurementModifier$1 implements RemeasurementModifier {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LazyStaggeredGridState f3171b;

    public LazyStaggeredGridState$remeasurementModifier$1(LazyStaggeredGridState lazyStaggeredGridState) {
        this.f3171b = lazyStaggeredGridState;
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

    public void onRemeasurementAvailable(@NotNull Remeasurement remeasurement) {
        Intrinsics.checkNotNullParameter(remeasurement, "remeasurement");
        this.f3171b.remeasurement = remeasurement;
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }
}
