package androidx.compose.runtime;

import androidx.compose.runtime.Recomposer;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.ExceptionsKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class Recomposer$broadcastFrameClock$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Recomposer f9157g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Recomposer$broadcastFrameClock$1(Recomposer recomposer) {
        super(0);
        this.f9157g = recomposer;
    }

    public final void invoke() {
        CancellableContinuation access$deriveStateLocked;
        Object access$getStateLock$p = this.f9157g.stateLock;
        Recomposer recomposer = this.f9157g;
        synchronized (access$getStateLock$p) {
            access$deriveStateLocked = recomposer.deriveStateLocked();
            if (((Recomposer.State) recomposer._state.getValue()).compareTo(Recomposer.State.ShuttingDown) <= 0) {
                throw ExceptionsKt.CancellationException("Recomposer shutdown; frame clock awaiter will never resume", recomposer.closeCause);
            }
        }
        if (access$deriveStateLocked != null) {
            Result.Companion companion = Result.Companion;
            access$deriveStateLocked.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
        }
    }
}
