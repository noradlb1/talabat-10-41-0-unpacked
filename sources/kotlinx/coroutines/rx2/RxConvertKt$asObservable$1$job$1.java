package kotlinx.coroutines.rx2;

import io.reactivex.ObservableEmitter;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\u00020\u0002H@"}, d2 = {"", "T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.rx2.RxConvertKt$asObservable$1$job$1", f = "RxConvert.kt", i = {0}, l = {114}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
public final class RxConvertKt$asObservable$1$job$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f26312h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Flow f26313i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ObservableEmitter f26314j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxConvertKt$asObservable$1$job$1(Flow flow, ObservableEmitter observableEmitter, Continuation continuation) {
        super(2, continuation);
        this.f26313i = flow;
        this.f26314j = observableEmitter;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RxConvertKt$asObservable$1$job$1 rxConvertKt$asObservable$1$job$1 = new RxConvertKt$asObservable$1$job$1(this.f26313i, this.f26314j, continuation);
        rxConvertKt$asObservable$1$job$1.L$0 = obj;
        return rxConvertKt$asObservable$1$job$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RxConvertKt$asObservable$1$job$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Throwable th2;
        CoroutineScope coroutineScope;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f26312h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            CoroutineScope coroutineScope2 = (CoroutineScope) this.L$0;
            try {
                Flow flow = this.f26313i;
                final ObservableEmitter observableEmitter = this.f26314j;
                AnonymousClass1 r32 = new FlowCollector() {
                    @Nullable
                    public final Object emit(@NotNull T t11, @NotNull Continuation<? super Unit> continuation) {
                        observableEmitter.onNext(t11);
                        return Unit.INSTANCE;
                    }
                };
                this.L$0 = coroutineScope2;
                this.f26312h = 1;
                if (flow.collect(r32, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                coroutineScope = coroutineScope2;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                coroutineScope = coroutineScope2;
                th2 = th4;
                if (th2 instanceof CancellationException) {
                    this.f26314j.onComplete();
                } else if (!this.f26314j.tryOnError(th2)) {
                    RxCancellableKt.handleUndeliverableException(th2, coroutineScope.getCoroutineContext());
                }
                return Unit.INSTANCE;
            }
        } else if (i11 == 1) {
            coroutineScope = (CoroutineScope) this.L$0;
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th5) {
                th2 = th5;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        this.f26314j.onComplete();
        return Unit.INSTANCE;
    }
}
