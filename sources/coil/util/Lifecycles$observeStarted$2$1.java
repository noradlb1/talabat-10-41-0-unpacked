package coil.util;

import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import d2.a;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CancellableContinuation;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"coil/util/-Lifecycles$observeStarted$2$1", "Landroidx/lifecycle/DefaultLifecycleObserver;", "onStart", "", "owner", "Landroidx/lifecycle/LifecycleOwner;", "coil-base_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* renamed from: coil.util.-Lifecycles$observeStarted$2$1  reason: invalid class name */
public final class Lifecycles$observeStarted$2$1 implements DefaultLifecycleObserver {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CancellableContinuation<Unit> f39823b;

    public Lifecycles$observeStarted$2$1(CancellableContinuation<? super Unit> cancellableContinuation) {
        this.f39823b = cancellableContinuation;
    }

    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        a.a(this, lifecycleOwner);
    }

    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        a.b(this, lifecycleOwner);
    }

    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        a.c(this, lifecycleOwner);
    }

    public /* synthetic */ void onResume(LifecycleOwner lifecycleOwner) {
        a.d(this, lifecycleOwner);
    }

    public void onStart(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        this.f39823b.resumeWith(Result.m6329constructorimpl(Unit.INSTANCE));
    }

    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        a.f(this, lifecycleOwner);
    }
}
