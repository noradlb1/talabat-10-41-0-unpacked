package kotlinx.coroutines.rx2;

import io.reactivex.Completable;
import io.reactivex.Flowable;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableSource;
import io.reactivex.Single;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.channels.ReceiveChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.reactive.ReactiveFlowKt;
import org.jetbrains.annotations.NotNull;
import t00.b;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a1\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0007\u001a1\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u0007\u001a\u0012\u0010\n\u001a\u00020\u000b*\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006\u001a \u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u000e\u001a*\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a&\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0011\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006\u001a*\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0006H\u0007\u001a*\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00020\t\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u001a(\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0016\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00122\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0017"}, d2 = {"_asFlowable", "Lio/reactivex/Flowable;", "T", "", "Lkotlinx/coroutines/flow/Flow;", "context", "Lkotlin/coroutines/CoroutineContext;", "from", "_asObservable", "Lio/reactivex/Observable;", "asCompletable", "Lio/reactivex/Completable;", "Lkotlinx/coroutines/Job;", "asFlow", "Lio/reactivex/ObservableSource;", "asFlowable", "asMaybe", "Lio/reactivex/Maybe;", "Lkotlinx/coroutines/Deferred;", "asObservable", "Lkotlinx/coroutines/channels/ReceiveChannel;", "asSingle", "Lio/reactivex/Single;", "kotlinx-coroutines-rx2"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RxConvertKt {
    @NotNull
    public static final Completable asCompletable(@NotNull Job job, @NotNull CoroutineContext coroutineContext) {
        return RxCompletableKt.rxCompletable(coroutineContext, new RxConvertKt$asCompletable$1(job, (Continuation<? super RxConvertKt$asCompletable$1>) null));
    }

    @NotNull
    public static final <T> Flow<T> asFlow(@NotNull ObservableSource<T> observableSource) {
        return FlowKt.callbackFlow(new RxConvertKt$asFlow$1(observableSource, (Continuation<? super RxConvertKt$asFlow$1>) null));
    }

    @NotNull
    public static final <T> Flowable<T> asFlowable(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        return Flowable.fromPublisher(ReactiveFlowKt.asPublisher(flow, coroutineContext));
    }

    public static /* synthetic */ Flowable asFlowable$default(Flow flow, CoroutineContext coroutineContext, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asFlowable(flow, coroutineContext);
    }

    @NotNull
    public static final <T> Maybe<T> asMaybe(@NotNull Deferred<? extends T> deferred, @NotNull CoroutineContext coroutineContext) {
        return RxMaybeKt.rxMaybe(coroutineContext, new RxConvertKt$asMaybe$1(deferred, (Continuation<? super RxConvertKt$asMaybe$1>) null));
    }

    @NotNull
    public static final <T> Observable<T> asObservable(@NotNull Flow<? extends T> flow, @NotNull CoroutineContext coroutineContext) {
        return Observable.create(new b(coroutineContext, flow));
    }

    public static /* synthetic */ Observable asObservable$default(Flow flow, CoroutineContext coroutineContext, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            coroutineContext = EmptyCoroutineContext.INSTANCE;
        }
        return asObservable(flow, coroutineContext);
    }

    /* access modifiers changed from: private */
    /* renamed from: asObservable$lambda-0  reason: not valid java name */
    public static final void m7856asObservable$lambda0(CoroutineContext coroutineContext, Flow flow, ObservableEmitter observableEmitter) {
        observableEmitter.setCancellable(new RxCancellable(BuildersKt.launch(GlobalScope.INSTANCE, Dispatchers.getUnconfined().plus(coroutineContext), CoroutineStart.ATOMIC, new RxConvertKt$asObservable$1$job$1(flow, observableEmitter, (Continuation) null))));
    }

    @NotNull
    public static final <T> Single<T> asSingle(@NotNull Deferred<? extends T> deferred, @NotNull CoroutineContext coroutineContext) {
        return RxSingleKt.rxSingle(coroutineContext, new RxConvertKt$asSingle$1(deferred, (Continuation<? super RxConvertKt$asSingle$1>) null));
    }

    @NotNull
    @Deprecated(level = DeprecationLevel.ERROR, message = "Deprecated in the favour of Flow", replaceWith = @ReplaceWith(expression = "this.consumeAsFlow().asObservable(context)", imports = {"kotlinx.coroutines.flow.consumeAsFlow"}))
    public static final <T> Observable<T> asObservable(@NotNull ReceiveChannel<? extends T> receiveChannel, @NotNull CoroutineContext coroutineContext) {
        return RxObservableKt.rxObservable(coroutineContext, new RxConvertKt$asObservable$2(receiveChannel, (Continuation<? super RxConvertKt$asObservable$2>) null));
    }
}
