package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0002\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "androidx.lifecycle.PausingDispatcherKt$whenStateAtLeast$2", f = "PausingDispatcher.kt", i = {0}, l = {162}, m = "invokeSuspend", n = {"controller"}, s = {"L$0"})
public final class PausingDispatcherKt$whenStateAtLeast$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super T>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f36071h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Lifecycle f36072i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Lifecycle.State f36073j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function2<CoroutineScope, Continuation<? super T>, Object> f36074k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PausingDispatcherKt$whenStateAtLeast$2(Lifecycle lifecycle, Lifecycle.State state, Function2<? super CoroutineScope, ? super Continuation<? super T>, ? extends Object> function2, Continuation<? super PausingDispatcherKt$whenStateAtLeast$2> continuation) {
        super(2, continuation);
        this.f36072i = lifecycle;
        this.f36073j = state;
        this.f36074k = function2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        PausingDispatcherKt$whenStateAtLeast$2 pausingDispatcherKt$whenStateAtLeast$2 = new PausingDispatcherKt$whenStateAtLeast$2(this.f36072i, this.f36073j, this.f36074k, continuation);
        pausingDispatcherKt$whenStateAtLeast$2.L$0 = obj;
        return pausingDispatcherKt$whenStateAtLeast$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super T> continuation) {
        return ((PausingDispatcherKt$whenStateAtLeast$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        LifecycleController lifecycleController;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f36071h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Job job = (Job) ((CoroutineScope) this.L$0).getCoroutineContext().get(Job.Key);
            if (job != null) {
                PausingDispatcher pausingDispatcher = new PausingDispatcher();
                LifecycleController lifecycleController2 = new LifecycleController(this.f36072i, this.f36073j, pausingDispatcher.dispatchQueue, job);
                try {
                    Function2<CoroutineScope, Continuation<? super T>, Object> function2 = this.f36074k;
                    this.L$0 = lifecycleController2;
                    this.f36071h = 1;
                    obj = BuildersKt.withContext(pausingDispatcher, function2, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                    lifecycleController = lifecycleController2;
                } catch (Throwable th2) {
                    th = th2;
                    lifecycleController = lifecycleController2;
                    lifecycleController.finish();
                    throw th;
                }
            } else {
                throw new IllegalStateException("when[State] methods should have a parent job".toString());
            }
        } else if (i11 == 1) {
            lifecycleController = (LifecycleController) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th3) {
                th = th3;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        lifecycleController.finish();
        return obj;
    }
}
