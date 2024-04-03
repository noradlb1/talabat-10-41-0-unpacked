package kotlinx.coroutines.rx2;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DispatcherScheduler$scheduleDirect$1$invoke$$inlined$Runnable$1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DispatcherScheduler f26266b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f26267c;

    public DispatcherScheduler$scheduleDirect$1$invoke$$inlined$Runnable$1(DispatcherScheduler dispatcherScheduler, Function1 function1) {
        this.f26266b = dispatcherScheduler;
        this.f26267c = function1;
    }

    public final void run() {
        Job unused = BuildersKt__Builders_commonKt.launch$default(this.f26266b.scope, (CoroutineContext) null, (CoroutineStart) null, new DispatcherScheduler$scheduleDirect$1$1$1(this.f26267c, (Continuation<? super DispatcherScheduler$scheduleDirect$1$1$1>) null), 3, (Object) null);
    }
}
