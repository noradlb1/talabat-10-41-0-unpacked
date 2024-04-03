package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.channels.ChannelResult;
import kotlinx.coroutines.flow.internal.NullSurrogateKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/channels/ChannelResult;", "", "value", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$debounceInternal$1$3$2", f = "Delay.kt", i = {0}, l = {243}, m = "invokeSuspend", n = {"$this$onFailure_u2dWpGqRn0$iv"}, s = {"L$0"})
public final class FlowKt__DelayKt$debounceInternal$1$3$2 extends SuspendLambda implements Function2<ChannelResult<? extends Object>, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public Object f25539h;

    /* renamed from: i  reason: collision with root package name */
    public int f25540i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ Object f25541j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Object> f25542k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ FlowCollector<T> f25543l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$debounceInternal$1$3$2(Ref.ObjectRef<Object> objectRef, FlowCollector<? super T> flowCollector, Continuation<? super FlowKt__DelayKt$debounceInternal$1$3$2> continuation) {
        super(2, continuation);
        this.f25542k = objectRef;
        this.f25543l = flowCollector;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__DelayKt$debounceInternal$1$3$2 flowKt__DelayKt$debounceInternal$1$3$2 = new FlowKt__DelayKt$debounceInternal$1$3$2(this.f25542k, this.f25543l, continuation);
        flowKt__DelayKt$debounceInternal$1$3$2.f25541j = obj;
        return flowKt__DelayKt$debounceInternal$1$3$2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return m7827invokeWpGqRn0(((ChannelResult) obj).m7811unboximpl(), (Continuation) obj2);
    }

    @Nullable
    /* renamed from: invoke-WpGqRn0  reason: not valid java name */
    public final Object m7827invokeWpGqRn0(@NotNull Object obj, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowKt__DelayKt$debounceInternal$1$3$2) create(ChannelResult.m7799boximpl(obj), continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Ref.ObjectRef<Object> objectRef;
        Ref.ObjectRef<Object> objectRef2;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f25540i;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            T r72 = ((ChannelResult) this.f25541j).m7811unboximpl();
            objectRef = this.f25542k;
            boolean z11 = r72 instanceof ChannelResult.Failed;
            if (!z11) {
                objectRef.element = r72;
            }
            FlowCollector<T> flowCollector = this.f25543l;
            if (z11) {
                Throwable r32 = ChannelResult.m7803exceptionOrNullimpl(r72);
                if (r32 == null) {
                    T t11 = objectRef.element;
                    if (t11 != null) {
                        if (t11 == NullSurrogateKt.NULL) {
                            t11 = null;
                        }
                        this.f25541j = r72;
                        this.f25539h = objectRef;
                        this.f25540i = 1;
                        if (flowCollector.emit(t11, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                        objectRef2 = objectRef;
                    }
                    objectRef.element = NullSurrogateKt.DONE;
                } else {
                    throw r32;
                }
            }
            return Unit.INSTANCE;
        } else if (i11 == 1) {
            objectRef2 = (Ref.ObjectRef) this.f25539h;
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        objectRef = objectRef2;
        objectRef.element = NullSurrogateKt.DONE;
        return Unit.INSTANCE;
    }
}
