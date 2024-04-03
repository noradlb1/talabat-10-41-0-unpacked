package androidx.paging.multicast;

import androidx.paging.multicast.ChannelManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.channels.ClosedSendChannelException;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/CoroutineScope;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.multicast.SharedFlowProducer$collectionJob$1", f = "SharedFlowProducer.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
public final class SharedFlowProducer$collectionJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f37237h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ SharedFlowProducer f37238i;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H@¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "it", "", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 2})
    @DebugMetadata(c = "androidx.paging.multicast.SharedFlowProducer$collectionJob$1$1", f = "SharedFlowProducer.kt", i = {}, l = {50}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.paging.multicast.SharedFlowProducer$collectionJob$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<FlowCollector<? super T>, Throwable, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f37239h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ SharedFlowProducer$collectionJob$1 f37240i;

        {
            this.f37240i = r1;
        }

        @NotNull
        public final Continuation<Unit> create(@NotNull FlowCollector<? super T> flowCollector, @NotNull Throwable th2, @NotNull Continuation<? super Unit> continuation) {
            Intrinsics.checkNotNullParameter(flowCollector, "$this$create");
            Intrinsics.checkNotNullParameter(th2, "it");
            Intrinsics.checkNotNullParameter(continuation, "continuation");
            AnonymousClass1 r22 = new AnonymousClass1(this.f37240i, continuation);
            r22.L$0 = th2;
            return r22;
        }

        public final Object invoke(Object obj, Object obj2, Object obj3) {
            return ((AnonymousClass1) create((FlowCollector) obj, (Throwable) obj2, (Continuation) obj3)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f37239h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                Function2 access$getSendUpsteamMessage$p = this.f37240i.f37238i.sendUpsteamMessage;
                ChannelManager.Message.Dispatch.Error error = new ChannelManager.Message.Dispatch.Error((Throwable) this.L$0);
                this.f37239h = 1;
                if (access$getSendUpsteamMessage$p.invoke(error, this) == coroutine_suspended) {
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
    public SharedFlowProducer$collectionJob$1(SharedFlowProducer sharedFlowProducer, Continuation continuation) {
        super(2, continuation);
        this.f37238i = sharedFlowProducer;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return new SharedFlowProducer$collectionJob$1(this.f37238i, continuation);
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((SharedFlowProducer$collectionJob$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f37237h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            Flow flow = FlowKt.m7822catch(this.f37238i.src, new AnonymousClass1(this, (Continuation) null));
            SharedFlowProducer$collectionJob$1$invokeSuspend$$inlined$collect$1 sharedFlowProducer$collectionJob$1$invokeSuspend$$inlined$collect$1 = new SharedFlowProducer$collectionJob$1$invokeSuspend$$inlined$collect$1(this);
            this.f37237h = 1;
            if (flow.collect(sharedFlowProducer$collectionJob$1$invokeSuspend$$inlined$collect$1, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            try {
                ResultKt.throwOnFailure(obj);
            } catch (ClosedSendChannelException unused) {
            }
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
