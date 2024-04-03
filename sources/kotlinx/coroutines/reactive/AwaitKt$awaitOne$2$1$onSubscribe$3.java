package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.reactivestreams.Subscription;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "T", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AwaitKt$awaitOne$2$1$onSubscribe$3 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Subscription f26215g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Mode f26216h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AwaitKt$awaitOne$2$1$onSubscribe$3(Subscription subscription, Mode mode) {
        super(0);
        this.f26215g = subscription;
        this.f26216h = mode;
    }

    public final void invoke() {
        Subscription subscription = this.f26215g;
        Mode mode = this.f26216h;
        subscription.request((mode == Mode.FIRST || mode == Mode.FIRST_OR_DEFAULT) ? 1 : Long.MAX_VALUE);
    }
}
