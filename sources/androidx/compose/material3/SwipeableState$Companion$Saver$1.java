package androidx.compose.material3;

import androidx.compose.runtime.saveable.SaverScope;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\u0004\b\u0001\u0010\u0001*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "T", "", "Landroidx/compose/runtime/saveable/SaverScope;", "it", "Landroidx/compose/material3/SwipeableState;", "invoke", "(Landroidx/compose/runtime/saveable/SaverScope;Landroidx/compose/material3/SwipeableState;)Ljava/lang/Object;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SwipeableState$Companion$Saver$1 extends Lambda implements Function2<SaverScope, SwipeableState<T>, T> {
    public static final SwipeableState$Companion$Saver$1 INSTANCE = new SwipeableState$Companion$Saver$1();

    public SwipeableState$Companion$Saver$1() {
        super(2);
    }

    @Nullable
    public final T invoke(@NotNull SaverScope saverScope, @NotNull SwipeableState<T> swipeableState) {
        Intrinsics.checkNotNullParameter(saverScope, "$this$Saver");
        Intrinsics.checkNotNullParameter(swipeableState, "it");
        return swipeableState.getCurrentValue();
    }
}
