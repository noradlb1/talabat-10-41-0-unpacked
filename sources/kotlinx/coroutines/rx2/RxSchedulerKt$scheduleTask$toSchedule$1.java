package kotlinx.coroutines.rx2;

import io.reactivex.disposables.Disposable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendFunction;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class RxSchedulerKt$scheduleTask$toSchedule$1 extends FunctionReferenceImpl implements Function1<Continuation<? super Unit>, Object>, SuspendFunction {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Disposable f26338b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CoroutineContext f26339c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Runnable f26340d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxSchedulerKt$scheduleTask$toSchedule$1(Disposable disposable, CoroutineContext coroutineContext, Runnable runnable) {
        super(1, Intrinsics.Kotlin.class, "task", "scheduleTask$task(Lio/reactivex/disposables/Disposable;Lkotlin/coroutines/CoroutineContext;Ljava/lang/Runnable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", 0);
        this.f26338b = disposable;
        this.f26339c = coroutineContext;
        this.f26340d = runnable;
    }

    @Nullable
    public final Object invoke(@NotNull Continuation<? super Unit> continuation) {
        return RxSchedulerKt.scheduleTask$task(this.f26338b, this.f26339c, this.f26340d, continuation);
    }
}
