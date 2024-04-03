package kotlinx.coroutines.rx2;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.intrinsics.CancellableKt;
import kotlinx.coroutines.selects.SelectInstance;
import kotlinx.coroutines.sync.Mutex;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u0000\"\b\b\u0001\u0010\u0002*\u00020\u0001*\u00020\u0003H@"}, d2 = {"R", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.rx2.RxObservableCoroutine$registerSelectClause2$1", f = "RxObservable.kt", i = {}, l = {106}, m = "invokeSuspend", n = {}, s = {})
public final class RxObservableCoroutine$registerSelectClause2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f26321h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ RxObservableCoroutine<T> f26322i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ SelectInstance<R> f26323j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<Continuation<? super R>, Object> f26324k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxObservableCoroutine$registerSelectClause2$1(RxObservableCoroutine<T> rxObservableCoroutine, SelectInstance<? super R> selectInstance, Function1<? super Continuation<? super R>, ? extends Object> function1, Continuation<? super RxObservableCoroutine$registerSelectClause2$1> continuation) {
        super(2, continuation);
        this.f26322i = rxObservableCoroutine;
        this.f26323j = selectInstance;
        this.f26324k = function1;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new RxObservableCoroutine$registerSelectClause2$1(this.f26322i, this.f26323j, this.f26324k, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RxObservableCoroutine$registerSelectClause2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f26321h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Mutex access$getMutex$p = this.f26322i.mutex;
            this.f26321h = 1;
            if (Mutex.DefaultImpls.lock$default(access$getMutex$p, (Object) null, this, 1, (Object) null) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (!this.f26323j.trySelect()) {
            Mutex.DefaultImpls.unlock$default(this.f26322i.mutex, (Object) null, 1, (Object) null);
            return Unit.INSTANCE;
        }
        CancellableKt.startCoroutineCancellable(this.f26324k, this.f26323j.getCompletion());
        return Unit.INSTANCE;
    }
}
