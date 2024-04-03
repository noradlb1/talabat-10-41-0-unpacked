package kotlinx.coroutines.rx2;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlinx.coroutines.rx2.DispatcherScheduler;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002¨\u0006\u0003"}, d2 = {"<anonymous>", "", "run", "kotlinx/coroutines/RunnableKt$Runnable$1"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DispatcherScheduler$DispatcherWorker$schedule$1$invoke$$inlined$Runnable$1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DispatcherScheduler.DispatcherWorker f26264b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function1 f26265c;

    public DispatcherScheduler$DispatcherWorker$schedule$1$invoke$$inlined$Runnable$1(DispatcherScheduler.DispatcherWorker dispatcherWorker, Function1 function1) {
        this.f26264b = dispatcherWorker;
        this.f26265c = function1;
    }

    public final void run() {
        this.f26264b.blockChannel.m7820trySendJP2dKIU(this.f26265c);
    }
}
