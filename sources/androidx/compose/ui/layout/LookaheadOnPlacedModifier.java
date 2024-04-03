package androidx.compose.ui.layout;

import a0.a;
import a0.b;
import androidx.compose.ui.Modifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001BK\u00126\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\u0002\u0010\fJ\u000e\u0010\u0011\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0004RA\u0010\u0002\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0012"}, d2 = {"Landroidx/compose/ui/layout/LookaheadOnPlacedModifier;", "Landroidx/compose/ui/Modifier$Element;", "callback", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/LookaheadLayoutCoordinates;", "Lkotlin/ParameterName;", "name", "lookaheadScopeRootCoordinates", "coordinates", "", "rootCoordinates", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;)V", "getCallback", "()Lkotlin/jvm/functions/Function2;", "getRootCoordinates", "()Lkotlin/jvm/functions/Function0;", "onPlaced", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LookaheadOnPlacedModifier implements Modifier.Element {
    @NotNull
    private final Function2<LookaheadLayoutCoordinates, LookaheadLayoutCoordinates, Unit> callback;
    @NotNull
    private final Function0<LookaheadLayoutCoordinates> rootCoordinates;

    public LookaheadOnPlacedModifier(@NotNull Function2<? super LookaheadLayoutCoordinates, ? super LookaheadLayoutCoordinates, Unit> function2, @NotNull Function0<? extends LookaheadLayoutCoordinates> function0) {
        Intrinsics.checkNotNullParameter(function2, "callback");
        Intrinsics.checkNotNullParameter(function0, "rootCoordinates");
        this.callback = function2;
        this.rootCoordinates = function0;
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

    @NotNull
    public final Function2<LookaheadLayoutCoordinates, LookaheadLayoutCoordinates, Unit> getCallback() {
        return this.callback;
    }

    @NotNull
    public final Function0<LookaheadLayoutCoordinates> getRootCoordinates() {
        return this.rootCoordinates;
    }

    public final void onPlaced(@NotNull LookaheadLayoutCoordinates lookaheadLayoutCoordinates) {
        Intrinsics.checkNotNullParameter(lookaheadLayoutCoordinates, "coordinates");
        this.callback.invoke(this.rootCoordinates.invoke(), lookaheadLayoutCoordinates);
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }
}
