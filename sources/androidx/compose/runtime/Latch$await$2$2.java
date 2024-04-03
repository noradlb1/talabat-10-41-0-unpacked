package androidx.compose.runtime;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class Latch$await$2$2 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Latch f9120g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation<Unit> f9121h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Latch$await$2$2(Latch latch, CancellableContinuation<? super Unit> cancellableContinuation) {
        super(1);
        this.f9120g = latch;
        this.f9121h = cancellableContinuation;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th2) {
        Object access$getLock$p = this.f9120g.lock;
        Latch latch = this.f9120g;
        CancellableContinuation<Unit> cancellableContinuation = this.f9121h;
        synchronized (access$getLock$p) {
            latch.awaiters.remove(cancellableContinuation);
            Unit unit = Unit.INSTANCE;
        }
    }
}
