package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public final class SwipeToDismissKt$rememberDismissState$2 extends Lambda implements Function0<DismissState> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DismissValue f5598g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Function1<DismissValue, Boolean> f5599h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SwipeToDismissKt$rememberDismissState$2(DismissValue dismissValue, Function1<? super DismissValue, Boolean> function1) {
        super(0);
        this.f5598g = dismissValue;
        this.f5599h = function1;
    }

    @NotNull
    public final DismissState invoke() {
        return new DismissState(this.f5598g, this.f5599h);
    }
}
