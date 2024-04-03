package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SwipeToDismissKt$rememberDismissState$1 extends Lambda implements Function1<DismissValue, Boolean> {
    public static final SwipeToDismissKt$rememberDismissState$1 INSTANCE = new SwipeToDismissKt$rememberDismissState$1();

    public SwipeToDismissKt$rememberDismissState$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull DismissValue dismissValue) {
        Intrinsics.checkNotNullParameter(dismissValue, "it");
        return Boolean.TRUE;
    }
}
