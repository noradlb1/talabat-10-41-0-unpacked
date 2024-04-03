package kotlinx.coroutines.reactive;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ProducerScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.internal.ChannelFlow;
import kotlinx.coroutines.flow.internal.SendingCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.reactivestreams.Publisher;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\b\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B3\u0012\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u0018\u0012\b\b\u0002\u0010\r\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u000e\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b!\u0010\"J!\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\t2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u000b\u0010\fJ&\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00032\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0014J!\u0010\u0013\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\bJ!\u0010\u0016\u001a\u00020\u00062\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0014H@ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00028\u00000\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0019\u0010\u001aR\u001a\u0010 \u001a\u00020\u001b8BX\u0004¢\u0006\f\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b\u001c\u0010\u001d\u0002\u0004\n\u0002\b\u0019¨\u0006#"}, d2 = {"Lkotlinx/coroutines/reactive/PublisherAsFlow;", "", "T", "Lkotlinx/coroutines/flow/internal/ChannelFlow;", "Lkotlinx/coroutines/flow/FlowCollector;", "collector", "", "collectSlowPath", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lkotlin/coroutines/CoroutineContext;", "injectContext", "collectImpl", "(Lkotlin/coroutines/CoroutineContext;Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "context", "", "capacity", "Lkotlinx/coroutines/channels/BufferOverflow;", "onBufferOverflow", "d", "collect", "Lkotlinx/coroutines/channels/ProducerScope;", "scope", "c", "(Lkotlinx/coroutines/channels/ProducerScope;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Lorg/reactivestreams/Publisher;", "publisher", "Lorg/reactivestreams/Publisher;", "", "getRequestSize", "()J", "getRequestSize$annotations", "()V", "requestSize", "<init>", "(Lorg/reactivestreams/Publisher;Lkotlin/coroutines/CoroutineContext;ILkotlinx/coroutines/channels/BufferOverflow;)V", "kotlinx-coroutines-reactive"}, k = 1, mv = {1, 6, 0})
final class PublisherAsFlow<T> extends ChannelFlow<T> {
    @NotNull
    private final Publisher<T> publisher;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PublisherAsFlow(Publisher publisher2, CoroutineContext coroutineContext, int i11, BufferOverflow bufferOverflow, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(publisher2, (i12 & 2) != 0 ? EmptyCoroutineContext.INSTANCE : coroutineContext, (i12 & 4) != 0 ? -2 : i11, (i12 & 8) != 0 ? BufferOverflow.SUSPEND : bufferOverflow);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x008f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0090  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009d A[SYNTHETIC, Splitter:B:29:0x009d] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c1 A[Catch:{ all -> 0x005c }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object collectImpl(kotlin.coroutines.CoroutineContext r18, kotlinx.coroutines.flow.FlowCollector<? super T> r19, kotlin.coroutines.Continuation<? super kotlin.Unit> r20) {
        /*
            r17 = this;
            r1 = r17
            r0 = r20
            boolean r2 = r0 instanceof kotlinx.coroutines.reactive.PublisherAsFlow$collectImpl$1
            if (r2 == 0) goto L_0x0017
            r2 = r0
            kotlinx.coroutines.reactive.PublisherAsFlow$collectImpl$1 r2 = (kotlinx.coroutines.reactive.PublisherAsFlow$collectImpl$1) r2
            int r3 = r2.f26244n
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L_0x0017
            int r3 = r3 - r4
            r2.f26244n = r3
            goto L_0x001c
        L_0x0017:
            kotlinx.coroutines.reactive.PublisherAsFlow$collectImpl$1 r2 = new kotlinx.coroutines.reactive.PublisherAsFlow$collectImpl$1
            r2.<init>(r1, r0)
        L_0x001c:
            java.lang.Object r0 = r2.f26242l
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.f26244n
            r5 = 0
            r7 = 2
            r8 = 1
            if (r4 == 0) goto L_0x005f
            if (r4 == r8) goto L_0x004a
            if (r4 != r7) goto L_0x0042
            long r9 = r2.f26241k
            java.lang.Object r4 = r2.f26240j
            kotlinx.coroutines.reactive.ReactiveSubscriber r4 = (kotlinx.coroutines.reactive.ReactiveSubscriber) r4
            java.lang.Object r11 = r2.f26239i
            kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
            java.lang.Object r12 = r2.f26238h
            kotlinx.coroutines.reactive.PublisherAsFlow r12 = (kotlinx.coroutines.reactive.PublisherAsFlow) r12
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x005c }
        L_0x003f:
            r0 = r11
            goto L_0x00b5
        L_0x0042:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x004a:
            long r9 = r2.f26241k
            java.lang.Object r4 = r2.f26240j
            kotlinx.coroutines.reactive.ReactiveSubscriber r4 = (kotlinx.coroutines.reactive.ReactiveSubscriber) r4
            java.lang.Object r11 = r2.f26239i
            kotlinx.coroutines.flow.FlowCollector r11 = (kotlinx.coroutines.flow.FlowCollector) r11
            java.lang.Object r12 = r2.f26238h
            kotlinx.coroutines.reactive.PublisherAsFlow r12 = (kotlinx.coroutines.reactive.PublisherAsFlow) r12
            kotlin.ResultKt.throwOnFailure(r0)     // Catch:{ all -> 0x005c }
            goto L_0x0095
        L_0x005c:
            r0 = move-exception
            goto L_0x00c7
        L_0x005f:
            kotlin.ResultKt.throwOnFailure(r0)
            kotlinx.coroutines.reactive.ReactiveSubscriber r0 = new kotlinx.coroutines.reactive.ReactiveSubscriber
            int r4 = r1.capacity
            kotlinx.coroutines.channels.BufferOverflow r9 = r1.onBufferOverflow
            long r10 = r17.getRequestSize()
            r0.<init>(r4, r9, r10)
            org.reactivestreams.Publisher<T> r4 = r1.publisher
            r9 = r18
            org.reactivestreams.Publisher r4 = kotlinx.coroutines.reactive.ReactiveFlowKt.injectCoroutineContext(r4, r9)
            r4.subscribe(r0)
            r4 = r0
            r9 = r1
            r10 = r5
            r0 = r19
        L_0x007f:
            r2.f26238h = r9     // Catch:{ all -> 0x005c }
            r2.f26239i = r0     // Catch:{ all -> 0x005c }
            r2.f26240j = r4     // Catch:{ all -> 0x005c }
            r2.f26241k = r10     // Catch:{ all -> 0x005c }
            r2.f26244n = r8     // Catch:{ all -> 0x005c }
            java.lang.Object r12 = r4.takeNextOrNull(r2)     // Catch:{ all -> 0x005c }
            if (r12 != r3) goto L_0x0090
            return r3
        L_0x0090:
            r15 = r10
            r11 = r0
            r0 = r12
            r12 = r9
            r9 = r15
        L_0x0095:
            if (r0 != 0) goto L_0x009d
            r4.cancel()
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x009d:
            kotlin.coroutines.CoroutineContext r13 = r2.getContext()     // Catch:{ all -> 0x005c }
            kotlinx.coroutines.JobKt.ensureActive((kotlin.coroutines.CoroutineContext) r13)     // Catch:{ all -> 0x005c }
            r2.f26238h = r12     // Catch:{ all -> 0x005c }
            r2.f26239i = r11     // Catch:{ all -> 0x005c }
            r2.f26240j = r4     // Catch:{ all -> 0x005c }
            r2.f26241k = r9     // Catch:{ all -> 0x005c }
            r2.f26244n = r7     // Catch:{ all -> 0x005c }
            java.lang.Object r0 = r11.emit(r0, r2)     // Catch:{ all -> 0x005c }
            if (r0 != r3) goto L_0x003f
            return r3
        L_0x00b5:
            r13 = 1
            long r10 = r9 + r13
            long r13 = r12.getRequestSize()     // Catch:{ all -> 0x005c }
            int r9 = (r10 > r13 ? 1 : (r10 == r13 ? 0 : -1))
            if (r9 != 0) goto L_0x00c5
            r4.makeRequest()     // Catch:{ all -> 0x005c }
            r10 = r5
        L_0x00c5:
            r9 = r12
            goto L_0x007f
        L_0x00c7:
            r4.cancel()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.reactive.PublisherAsFlow.collectImpl(kotlin.coroutines.CoroutineContext, kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final Object collectSlowPath(FlowCollector<? super T> flowCollector, Continuation<? super Unit> continuation) {
        Object coroutineScope = CoroutineScopeKt.coroutineScope(new PublisherAsFlow$collectSlowPath$2(flowCollector, this, (Continuation<? super PublisherAsFlow$collectSlowPath$2>) null), continuation);
        return coroutineScope == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? coroutineScope : Unit.INSTANCE;
    }

    private final long getRequestSize() {
        boolean z11;
        if (this.onBufferOverflow != BufferOverflow.SUSPEND) {
            return Long.MAX_VALUE;
        }
        int i11 = this.capacity;
        if (i11 == -2) {
            return (long) Channel.Factory.getCHANNEL_DEFAULT_CAPACITY$kotlinx_coroutines_core();
        }
        if (i11 == 0) {
            return 1;
        }
        if (i11 == Integer.MAX_VALUE) {
            return Long.MAX_VALUE;
        }
        long j11 = (long) i11;
        if (j11 >= 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return j11;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    private static /* synthetic */ void getRequestSize$annotations() {
    }

    @Nullable
    public Object c(@NotNull ProducerScope<? super T> producerScope, @NotNull Continuation<? super Unit> continuation) {
        Object collectImpl = collectImpl(producerScope.getCoroutineContext(), new SendingCollector(producerScope.getChannel()), continuation);
        return collectImpl == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? collectImpl : Unit.INSTANCE;
    }

    @Nullable
    public Object collect(@NotNull FlowCollector<? super T> flowCollector, @NotNull Continuation<? super Unit> continuation) {
        CoroutineContext context = continuation.getContext();
        CoroutineContext coroutineContext = this.context;
        ContinuationInterceptor.Key key = ContinuationInterceptor.Key;
        ContinuationInterceptor continuationInterceptor = (ContinuationInterceptor) coroutineContext.get(key);
        if (continuationInterceptor == null || Intrinsics.areEqual((Object) continuationInterceptor, (Object) context.get(key))) {
            Object collectImpl = collectImpl(context.plus(this.context), flowCollector, continuation);
            if (collectImpl == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                return collectImpl;
            }
            return Unit.INSTANCE;
        }
        Object collectSlowPath = collectSlowPath(flowCollector, continuation);
        if (collectSlowPath == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return collectSlowPath;
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public ChannelFlow<T> d(@NotNull CoroutineContext coroutineContext, int i11, @NotNull BufferOverflow bufferOverflow) {
        return new PublisherAsFlow(this.publisher, coroutineContext, i11, bufferOverflow);
    }

    public PublisherAsFlow(@NotNull Publisher<T> publisher2, @NotNull CoroutineContext coroutineContext, int i11, @NotNull BufferOverflow bufferOverflow) {
        super(coroutineContext, i11, bufferOverflow);
        this.publisher = publisher2;
    }
}
