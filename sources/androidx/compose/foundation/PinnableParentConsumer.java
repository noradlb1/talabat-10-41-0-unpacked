package androidx.compose.foundation;

import a0.a;
import a0.b;
import androidx.compose.foundation.lazy.layout.PinnableParent;
import androidx.compose.foundation.lazy.layout.PinnableParentKt;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u001b\u0012\u0014\u0010\u0002\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\u0010\u0006J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0011H\u0016R\u001f\u0010\u0002\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Landroidx/compose/foundation/PinnableParentConsumer;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "onPinnableParentAvailable", "Lkotlin/Function1;", "Landroidx/compose/foundation/lazy/layout/PinnableParent;", "", "(Lkotlin/jvm/functions/Function1;)V", "getOnPinnableParentAvailable", "()Lkotlin/jvm/functions/Function1;", "equals", "", "other", "", "hashCode", "", "onModifierLocalsUpdated", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ExperimentalFoundationApi
@Stable
final class PinnableParentConsumer implements ModifierLocalConsumer {
    @NotNull
    private final Function1<PinnableParent, Unit> onPinnableParentAvailable;

    public PinnableParentConsumer(@NotNull Function1<? super PinnableParent, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "onPinnableParentAvailable");
        this.onPinnableParentAvailable = function1;
    }

    public /* synthetic */ boolean all(Function1 function1) {
        return b.a(this, function1);
    }

    public /* synthetic */ boolean any(Function1 function1) {
        return b.b(this, function1);
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof PinnableParentConsumer) || !Intrinsics.areEqual((Object) ((PinnableParentConsumer) obj).onPinnableParentAvailable, (Object) this.onPinnableParentAvailable)) {
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
    public final Function1<PinnableParent, Unit> getOnPinnableParentAvailable() {
        return this.onPinnableParentAvailable;
    }

    public int hashCode() {
        return this.onPinnableParentAvailable.hashCode();
    }

    public void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope modifierLocalReadScope) {
        Intrinsics.checkNotNullParameter(modifierLocalReadScope, "scope");
        this.onPinnableParentAvailable.invoke(modifierLocalReadScope.getCurrent(PinnableParentKt.getModifierLocalPinnableParent()));
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }
}
