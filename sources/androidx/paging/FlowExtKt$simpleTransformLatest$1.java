package androidx.paging;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "R", "Landroidx/paging/SimpleProducerScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.FlowExtKt$simpleTransformLatest$1", f = "FlowExt.kt", i = {}, l = {76}, m = "invokeSuspend", n = {}, s = {})
public final class FlowExtKt$simpleTransformLatest$1 extends SuspendLambda implements Function2<SimpleProducerScope<R>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f36597h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Flow f36598i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3 f36599j;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H@¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "T", "R", "value", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
    @DebugMetadata(c = "androidx.paging.FlowExtKt$simpleTransformLatest$1$1", f = "FlowExt.kt", i = {}, l = {77}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.paging.FlowExtKt$simpleTransformLatest$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<T, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f36600h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ FlowExtKt$simpleTransformLatest$1 f36601i;

        {
            this.f36601i = r1;
        }

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            Intrinsics.checkNotNullParameter(continuation, "completion");
            AnonymousClass1 r02 = new AnonymousClass1(this.f36601i, channelFlowCollector, continuation);
            r02.L$0 = obj;
            return r02;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f36600h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                Object obj2 = this.L$0;
                Function3 function3 = this.f36601i.f36599j;
                ChannelFlowCollector channelFlowCollector = channelFlowCollector;
                this.f36600h = 1;
                if (function3.invoke(channelFlowCollector, obj2, this) == coroutine_suspended) {
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
    public FlowExtKt$simpleTransformLatest$1(Flow flow, Function3 function3, Continuation continuation) {
        super(2, continuation);
        this.f36598i = flow;
        this.f36599j = function3;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        FlowExtKt$simpleTransformLatest$1 flowExtKt$simpleTransformLatest$1 = new FlowExtKt$simpleTransformLatest$1(this.f36598i, this.f36599j, continuation);
        flowExtKt$simpleTransformLatest$1.L$0 = obj;
        return flowExtKt$simpleTransformLatest$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FlowExtKt$simpleTransformLatest$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f36597h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Flow flow = this.f36598i;
            final ChannelFlowCollector channelFlowCollector = new ChannelFlowCollector((SimpleProducerScope) this.L$0);
            AnonymousClass1 r62 = new AnonymousClass1(this, (Continuation) null);
            this.f36597h = 1;
            if (FlowKt.collectLatest(flow, r62, this) == coroutine_suspended) {
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
