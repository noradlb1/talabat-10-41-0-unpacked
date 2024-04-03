package androidx.lifecycle;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "R", "run"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Lifecycle f36122b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 f36123c;

    public WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$1(Lifecycle lifecycle, WithLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1 withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1) {
        this.f36122b = lifecycle;
        this.f36123c = withLifecycleStateKt$suspendWithStateAtLeastUnchecked$2$observer$1;
    }

    public final void run() {
        this.f36122b.addObserver(this.f36123c);
    }
}
