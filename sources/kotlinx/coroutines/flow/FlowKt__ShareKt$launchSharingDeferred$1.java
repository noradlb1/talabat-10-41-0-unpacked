package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.JobKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0003\u001a\u00020\u0002\"\u0004\b\u0000\u0010\u0000*\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ShareKt$launchSharingDeferred$1", f = "Share.kt", i = {}, l = {340}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__ShareKt$launchSharingDeferred$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f25834h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Flow<T> f25835i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ CompletableDeferred<StateFlow<T>> f25836j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__ShareKt$launchSharingDeferred$1(Flow<? extends T> flow, CompletableDeferred<StateFlow<T>> completableDeferred, Continuation<? super FlowKt__ShareKt$launchSharingDeferred$1> continuation) {
        super(2, continuation);
        this.f25835i = flow;
        this.f25836j = completableDeferred;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__ShareKt$launchSharingDeferred$1 flowKt__ShareKt$launchSharingDeferred$1 = new FlowKt__ShareKt$launchSharingDeferred$1(this.f25835i, this.f25836j, continuation);
        flowKt__ShareKt$launchSharingDeferred$1.L$0 = obj;
        return flowKt__ShareKt$launchSharingDeferred$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowKt__ShareKt$launchSharingDeferred$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f25834h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            final Ref.ObjectRef objectRef = new Ref.ObjectRef();
            Flow<T> flow = this.f25835i;
            final CompletableDeferred<StateFlow<T>> completableDeferred = this.f25836j;
            AnonymousClass1 r42 = new FlowCollector() {
                @Nullable
                public final Object emit(T t11, @NotNull Continuation<? super Unit> continuation) {
                    Unit unit;
                    MutableStateFlow mutableStateFlow = (MutableStateFlow) objectRef.element;
                    if (mutableStateFlow != null) {
                        mutableStateFlow.setValue(t11);
                        unit = Unit.INSTANCE;
                    } else {
                        unit = null;
                    }
                    if (unit == null) {
                        CoroutineScope coroutineScope = coroutineScope;
                        Ref.ObjectRef<MutableStateFlow<T>> objectRef = objectRef;
                        CompletableDeferred<StateFlow<T>> completableDeferred = completableDeferred;
                        T MutableStateFlow = StateFlowKt.MutableStateFlow(t11);
                        completableDeferred.complete(new ReadonlyStateFlow(MutableStateFlow, JobKt.getJob(coroutineScope.getCoroutineContext())));
                        objectRef.element = MutableStateFlow;
                    }
                    return Unit.INSTANCE;
                }
            };
            this.f25834h = 1;
            if (flow.collect(r42, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (Throwable th2) {
                this.f25836j.completeExceptionally(th2);
                throw th2;
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
