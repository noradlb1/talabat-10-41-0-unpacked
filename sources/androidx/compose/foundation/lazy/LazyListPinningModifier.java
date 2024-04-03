package androidx.compose.foundation.lazy;

import a0.a;
import a0.b;
import androidx.compose.foundation.lazy.layout.PinnableParent;
import androidx.compose.foundation.lazy.layout.PinnableParentKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000 \u001a2\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00012\u00020\u00032\u00020\u0002:\u0001\u001aB\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\n8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00028VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u000f¨\u0006\u001b"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListPinningModifier;", "Landroidx/compose/ui/modifier/ModifierLocalProvider;", "Landroidx/compose/foundation/lazy/layout/PinnableParent;", "Landroidx/compose/ui/modifier/ModifierLocalConsumer;", "state", "Landroidx/compose/foundation/lazy/LazyListState;", "beyondBoundsInfo", "Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;", "(Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/foundation/lazy/LazyListBeyondBoundsInfo;)V", "key", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "getKey", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "pinnableGrandParent", "getPinnableGrandParent", "()Landroidx/compose/foundation/lazy/layout/PinnableParent;", "setPinnableGrandParent", "(Landroidx/compose/foundation/lazy/layout/PinnableParent;)V", "value", "getValue", "onModifierLocalsUpdated", "", "scope", "Landroidx/compose/ui/modifier/ModifierLocalReadScope;", "pinItems", "Landroidx/compose/foundation/lazy/layout/PinnableParent$PinnedItemsHandle;", "Companion", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
final class LazyListPinningModifier implements ModifierLocalProvider<PinnableParent>, ModifierLocalConsumer, PinnableParent {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final LazyListPinningModifier$Companion$EmptyPinnedItemsHandle$1 EmptyPinnedItemsHandle = new LazyListPinningModifier$Companion$EmptyPinnedItemsHandle$1();
    @NotNull
    private final LazyListBeyondBoundsInfo beyondBoundsInfo;
    @Nullable
    private PinnableParent pinnableGrandParent;
    /* access modifiers changed from: private */
    @NotNull
    public final LazyListState state;

    @Metadata(d1 = {"\u0000\u0013\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\b\u0003*\u0001\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0004\n\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListPinningModifier$Companion;", "", "()V", "EmptyPinnedItemsHandle", "androidx/compose/foundation/lazy/LazyListPinningModifier$Companion$EmptyPinnedItemsHandle$1", "Landroidx/compose/foundation/lazy/LazyListPinningModifier$Companion$EmptyPinnedItemsHandle$1;", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public LazyListPinningModifier(@NotNull LazyListState lazyListState, @NotNull LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo) {
        Intrinsics.checkNotNullParameter(lazyListState, "state");
        Intrinsics.checkNotNullParameter(lazyListBeyondBoundsInfo, "beyondBoundsInfo");
        this.state = lazyListState;
        this.beyondBoundsInfo = lazyListBeyondBoundsInfo;
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
    public ProvidableModifierLocal<PinnableParent> getKey() {
        return PinnableParentKt.getModifierLocalPinnableParent();
    }

    @Nullable
    public final PinnableParent getPinnableGrandParent() {
        return this.pinnableGrandParent;
    }

    @NotNull
    public PinnableParent getValue() {
        return this;
    }

    public void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope modifierLocalReadScope) {
        Intrinsics.checkNotNullParameter(modifierLocalReadScope, "scope");
        this.pinnableGrandParent = (PinnableParent) modifierLocalReadScope.getCurrent(PinnableParentKt.getModifierLocalPinnableParent());
    }

    @NotNull
    public PinnableParent.PinnedItemsHandle pinItems() {
        PinnableParent.PinnedItemsHandle pinItems;
        LazyListBeyondBoundsInfo lazyListBeyondBoundsInfo = this.beyondBoundsInfo;
        if (lazyListBeyondBoundsInfo.hasIntervals()) {
            return new LazyListPinningModifier$pinItems$1$1(this, lazyListBeyondBoundsInfo);
        }
        PinnableParent pinnableParent = this.pinnableGrandParent;
        if (pinnableParent == null || (pinItems = pinnableParent.pinItems()) == null) {
            return EmptyPinnedItemsHandle;
        }
        return pinItems;
    }

    public final void setPinnableGrandParent(@Nullable PinnableParent pinnableParent) {
        this.pinnableGrandParent = pinnableParent;
    }

    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }
}
