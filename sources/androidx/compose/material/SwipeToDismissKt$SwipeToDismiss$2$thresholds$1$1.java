package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1 extends Lambda implements Function2<DismissValue, DismissValue, ThresholdConfig> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Function1<DismissDirection, ThresholdConfig> f5589g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeToDismissKt$SwipeToDismiss$2$thresholds$1$1(Function1<? super DismissDirection, ? extends ThresholdConfig> function1) {
        super(2);
        this.f5589g = function1;
    }

    @NotNull
    public final ThresholdConfig invoke(@NotNull DismissValue dismissValue, @NotNull DismissValue dismissValue2) {
        Intrinsics.checkNotNullParameter(dismissValue, "from");
        Intrinsics.checkNotNullParameter(dismissValue2, "to");
        Function1<DismissDirection, ThresholdConfig> function1 = this.f5589g;
        DismissDirection access$getDismissDirection = SwipeToDismissKt.getDismissDirection(dismissValue, dismissValue2);
        Intrinsics.checkNotNull(access$getDismissDirection);
        return function1.invoke(access$getDismissDirection);
    }
}
