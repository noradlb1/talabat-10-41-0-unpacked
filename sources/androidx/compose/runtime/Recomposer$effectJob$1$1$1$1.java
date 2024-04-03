package androidx.compose.runtime;

import androidx.compose.runtime.Recomposer;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "runnerJobCause", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class Recomposer$effectJob$1$1$1$1 extends Lambda implements Function1<Throwable, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Recomposer f9159g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Throwable f9160h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Recomposer$effectJob$1$1$1$1(Recomposer recomposer, Throwable th2) {
        super(1);
        this.f9159g = recomposer;
        this.f9160h = th2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Throwable) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Throwable th2) {
        Object access$getStateLock$p = this.f9159g.stateLock;
        Recomposer recomposer = this.f9159g;
        Throwable th3 = this.f9160h;
        synchronized (access$getStateLock$p) {
            if (th3 == null) {
                th3 = null;
            } else if (th2 != null) {
                if (!(!(th2 instanceof CancellationException))) {
                    th2 = null;
                }
                if (th2 != null) {
                    ExceptionsKt__ExceptionsKt.addSuppressed(th3, th2);
                }
            }
            recomposer.closeCause = th3;
            recomposer._state.setValue(Recomposer.State.ShutDown);
            Unit unit = Unit.INSTANCE;
        }
    }
}
