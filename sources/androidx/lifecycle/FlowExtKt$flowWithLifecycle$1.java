package androidx.lifecycle;

import androidx.lifecycle.Lifecycle;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.channels.SendChannel;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1", f = "FlowExt.kt", i = {0}, l = {91}, m = "invokeSuspend", n = {"$this$callbackFlow"}, s = {"L$0"})
public final class FlowExtKt$flowWithLifecycle$1 extends SuspendLambda implements Function2<ProducerScope<? super T>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f36007h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Lifecycle f36008i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Lifecycle.State f36009j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Flow<T> f36010k;

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
    @DebugMetadata(c = "androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1", f = "FlowExt.kt", i = {}, l = {92}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.lifecycle.FlowExtKt$flowWithLifecycle$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f36011h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(flow, producerScope2, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f36011h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                Flow<T> flow = flow;
                final ProducerScope<T> producerScope = producerScope2;
                AnonymousClass1 r12 = new FlowCollector() {
                    @Nullable
                    public final Object emit(T t11, @NotNull Continuation<? super Unit> continuation) {
                        Object send = producerScope.send(t11, continuation);
                        return send == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? send : Unit.INSTANCE;
                    }
                };
                this.f36011h = 1;
                if (flow.collect(r12, this) == coroutine_suspended) {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowExtKt$flowWithLifecycle$1(Lifecycle lifecycle, Lifecycle.State state, Flow<? extends T> flow, Continuation<? super FlowExtKt$flowWithLifecycle$1> continuation) {
        super(2, continuation);
        this.f36008i = lifecycle;
        this.f36009j = state;
        this.f36010k = flow;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowExtKt$flowWithLifecycle$1 flowExtKt$flowWithLifecycle$1 = new FlowExtKt$flowWithLifecycle$1(this.f36008i, this.f36009j, this.f36010k, continuation);
        flowExtKt$flowWithLifecycle$1.L$0 = obj;
        return flowExtKt$flowWithLifecycle$1;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super T> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowExtKt$flowWithLifecycle$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ProducerScope producerScope;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f36007h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope2 = (ProducerScope) this.L$0;
            Lifecycle lifecycle = this.f36008i;
            Lifecycle.State state = this.f36009j;
            final Flow<T> flow = this.f36010k;
            AnonymousClass1 r52 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.L$0 = producerScope2;
            this.f36007h = 1;
            if (RepeatOnLifecycleKt.repeatOnLifecycle(lifecycle, state, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) r52, (Continuation<? super Unit>) this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            producerScope = producerScope2;
        } else if (i11 == 1) {
            producerScope = (ProducerScope) this.L$0;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        SendChannel.DefaultImpls.close$default(producerScope, (Throwable) null, 1, (Object) null);
        return Unit.INSTANCE;
    }
}
