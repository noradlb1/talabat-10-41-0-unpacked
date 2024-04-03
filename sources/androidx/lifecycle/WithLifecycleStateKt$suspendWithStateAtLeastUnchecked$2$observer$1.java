package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"androidx/lifecycle/WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1", "Landroidx/lifecycle/LifecycleEventObserver;", "onStateChanged", "", "source", "Landroidx/lifecycle/LifecycleOwner;", "event", "Landroidx/lifecycle/Lifecycle$Event;", "lifecycle-runtime-ktx_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 implements LifecycleEventObserver {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Lifecycle.State f36129b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Lifecycle f36130c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation<R> f36131d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Function0<R> f36132e;

    public WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1(Lifecycle.State state, Lifecycle lifecycle, CancellableContinuation<? super R> cancellableContinuation, Function0<? extends R> function0) {
        this.f36129b = state;
        this.f36130c = lifecycle;
        this.f36131d = cancellableContinuation;
        this.f36132e = function0;
    }

    public void onStateChanged(@NotNull LifecycleOwner lifecycleOwner, @NotNull Lifecycle.Event event) {
        Object obj;
        Intrinsics.checkNotNullParameter(lifecycleOwner, "source");
        Intrinsics.checkNotNullParameter(event, "event");
        if (event == Lifecycle.Event.upTo(this.f36129b)) {
            this.f36130c.removeObserver(this);
            CancellableContinuation<R> cancellableContinuation = this.f36131d;
            Function0<R> function0 = this.f36132e;
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.m6329constructorimpl(function0.invoke());
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            cancellableContinuation.resumeWith(obj);
        } else if (event == Lifecycle.Event.ON_DESTROY) {
            this.f36130c.removeObserver(this);
            CancellableContinuation<R> cancellableContinuation2 = this.f36131d;
            Result.Companion companion3 = Result.Companion;
            cancellableContinuation2.resumeWith(Result.m6329constructorimpl(ResultKt.createFailure(new LifecycleDestroyedException())));
        }
    }
}
