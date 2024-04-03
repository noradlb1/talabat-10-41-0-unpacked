package kotlinx.coroutines.rx2;

import io.reactivex.ObservableSource;
import io.reactivex.disposables.Disposable;
import io.reactivex.disposables.Disposables;
import java.util.concurrent.atomic.AtomicReference;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProduceKt;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\b\b\u0000\u0010\u0001*\u00020\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0002H@"}, d2 = {"", "T", "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.rx2.RxConvertKt$asFlow$1", f = "RxConvert.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
public final class RxConvertKt$asFlow$1 extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f26305h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ObservableSource<T> f26306i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RxConvertKt$asFlow$1(ObservableSource<T> observableSource, Continuation<? super RxConvertKt$asFlow$1> continuation) {
        super(2, continuation);
        this.f26306i = observableSource;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        RxConvertKt$asFlow$1 rxConvertKt$asFlow$1 = new RxConvertKt$asFlow$1(this.f26306i, continuation);
        rxConvertKt$asFlow$1.L$0 = obj;
        return rxConvertKt$asFlow$1;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super T> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((RxConvertKt$asFlow$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f26305h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            ProducerScope producerScope = (ProducerScope) this.L$0;
            final AtomicReference atomicReference = new AtomicReference();
            this.f26306i.subscribe(new RxConvertKt$asFlow$1$observer$1(producerScope, atomicReference));
            AnonymousClass1 r32 = new Function0<Unit>() {
                public final void invoke() {
                    Disposable andSet = atomicReference.getAndSet(Disposables.disposed());
                    if (andSet != null) {
                        andSet.dispose();
                    }
                }
            };
            this.f26305h = 1;
            if (ProduceKt.awaitClose(producerScope, r32, this) == coroutine_suspended) {
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
