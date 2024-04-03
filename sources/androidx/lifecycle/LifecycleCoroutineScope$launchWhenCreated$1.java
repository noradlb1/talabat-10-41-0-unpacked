package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "androidx.lifecycle.LifecycleCoroutineScope$launchWhenCreated$1", f = "Lifecycle.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
public final class LifecycleCoroutineScope$launchWhenCreated$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f36035h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ LifecycleCoroutineScope f36036i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<CoroutineScope, Continuation<? super Unit>, Object> f36037j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LifecycleCoroutineScope$launchWhenCreated$1(LifecycleCoroutineScope lifecycleCoroutineScope, Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object> function2, Continuation<? super LifecycleCoroutineScope$launchWhenCreated$1> continuation) {
        super(2, continuation);
        this.f36036i = lifecycleCoroutineScope;
        this.f36037j = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new LifecycleCoroutineScope$launchWhenCreated$1(this.f36036i, this.f36037j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LifecycleCoroutineScope$launchWhenCreated$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f36035h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Lifecycle lifecycle$lifecycle_runtime_ktx_release = this.f36036i.getLifecycle$lifecycle_runtime_ktx_release();
            Function2<CoroutineScope, Continuation<? super Unit>, Object> function2 = this.f36037j;
            this.f36035h = 1;
            if (PausingDispatcherKt.whenCreated(lifecycle$lifecycle_runtime_ktx_release, function2, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
