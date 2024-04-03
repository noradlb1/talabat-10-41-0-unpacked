package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "it", "invoke", "(Ljava/lang/Object;)Ljava/lang/Long;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FlowKt__DelayKt$debounce$2 extends Lambda implements Function1<T, Long> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ long f25528g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounce$2(long j11) {
        super(1);
        this.f25528g = j11;
    }

    @NotNull
    public final Long invoke(T t11) {
        return Long.valueOf(this.f25528g);
    }
}
