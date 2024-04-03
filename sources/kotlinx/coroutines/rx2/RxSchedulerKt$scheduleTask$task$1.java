package kotlinx.coroutines.rx2;

import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "kotlinx.coroutines.rx2.RxSchedulerKt", f = "RxScheduler.kt", i = {0}, l = {126}, m = "scheduleTask$task", n = {"ctx"}, s = {"L$0"})
public final class RxSchedulerKt$scheduleTask$task$1 extends ContinuationImpl {

    /* renamed from: h  reason: collision with root package name */
    public Object f26334h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f26335i;

    /* renamed from: j  reason: collision with root package name */
    public int f26336j;

    public RxSchedulerKt$scheduleTask$task$1(Continuation<? super RxSchedulerKt$scheduleTask$task$1> continuation) {
        super(continuation);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        this.f26335i = obj;
        this.f26336j |= Integer.MIN_VALUE;
        return RxSchedulerKt.scheduleTask$task((Disposable) null, (CoroutineContext) null, (Runnable) null, this);
    }
}
