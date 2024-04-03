package kotlinx.coroutines.sync;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.sync.MutexImpl;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "R", "it", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class MutexImpl$LockSelect$completeResumeLockWaiter$1 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MutexImpl f26370g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ MutexImpl.LockSelect<R> f26371h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MutexImpl$LockSelect$completeResumeLockWaiter$1(MutexImpl mutexImpl, MutexImpl.LockSelect<R> lockSelect) {
        super(1);
        this.f26370g = mutexImpl;
        this.f26371h = lockSelect;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Throwable th2) {
        this.f26370g.unlock(this.f26371h.owner);
    }
}
