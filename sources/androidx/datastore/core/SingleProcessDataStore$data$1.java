package androidx.datastore.core;

import androidx.datastore.core.SingleProcessDataStore;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/flow/FlowCollector;", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
@DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore$data$1", f = "SingleProcessDataStore.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
public final class SingleProcessDataStore$data$1 extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f35638h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SingleProcessDataStore<T> f35639i;

    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00028\u00000\u0001H@"}, d2 = {"T", "Landroidx/datastore/core/State;", "it", "", "<anonymous>"}, k = 3, mv = {1, 5, 1})
    @DebugMetadata(c = "androidx.datastore.core.SingleProcessDataStore$data$1$1", f = "SingleProcessDataStore.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.datastore.core.SingleProcessDataStore$data$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<State<T>, Continuation<? super Boolean>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f35640h;

        /* renamed from: i  reason: collision with root package name */
        public /* synthetic */ Object f35641i;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(state, continuation);
            r02.f35641i = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull State<T> state, @Nullable Continuation<? super Boolean> continuation) {
            return ((AnonymousClass1) create(state, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.f35640h == 0) {
                ResultKt.throwOnFailure(obj);
                State<T> state = (State) this.f35641i;
                State<T> state2 = state;
                boolean z11 = false;
                if (!(state2 instanceof Data) && !(state2 instanceof Final) && state == state2) {
                    z11 = true;
                }
                return Boxing.boxBoolean(z11);
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SingleProcessDataStore$data$1(SingleProcessDataStore<T> singleProcessDataStore, Continuation<? super SingleProcessDataStore$data$1> continuation) {
        super(2, continuation);
        this.f35639i = singleProcessDataStore;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SingleProcessDataStore$data$1 singleProcessDataStore$data$1 = new SingleProcessDataStore$data$1(this.f35639i, continuation);
        singleProcessDataStore$data$1.L$0 = obj;
        return singleProcessDataStore$data$1;
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super T> flowCollector, @Nullable Continuation<? super Unit> continuation) {
        return ((SingleProcessDataStore$data$1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f35638h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            FlowCollector flowCollector = (FlowCollector) this.L$0;
            final State state = (State) this.f35639i.downstreamFlow.getValue();
            if (!(state instanceof Data)) {
                this.f35639i.actor.offer(new SingleProcessDataStore.Message.Read(state));
            }
            SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1 singleProcessDataStore$data$1$invokeSuspend$$inlined$map$1 = new SingleProcessDataStore$data$1$invokeSuspend$$inlined$map$1(FlowKt.dropWhile(this.f35639i.downstreamFlow, new AnonymousClass1((Continuation<? super AnonymousClass1>) null)));
            this.f35638h = 1;
            if (FlowKt.emitAll(flowCollector, singleProcessDataStore$data$1$invokeSuspend$$inlined$map$1, (Continuation<? super Unit>) this) == coroutine_suspended) {
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
