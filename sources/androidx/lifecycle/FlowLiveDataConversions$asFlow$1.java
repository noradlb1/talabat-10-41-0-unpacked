package androidx.lifecycle;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;"}, k = 3, mv = {1, 4, 1})
@DebugMetadata(c = "androidx.lifecycle.FlowLiveDataConversions$asFlow$1", f = "FlowLiveData.kt", i = {0, 0, 0, 1, 1, 2, 2}, l = {96, 100, 101}, m = "invokeSuspend", n = {"$this$flow", "channel", "observer", "$this$flow", "observer", "$this$flow", "observer"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$0", "L$1"})
public final class FlowLiveDataConversions$asFlow$1 extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f36016h;

    /* renamed from: i  reason: collision with root package name */
    public Object f36017i;

    /* renamed from: j  reason: collision with root package name */
    public int f36018j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ LiveData f36019k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowLiveDataConversions$asFlow$1(LiveData liveData, Continuation continuation) {
        super(2, continuation);
        this.f36019k = liveData;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Intrinsics.checkNotNullParameter(continuation, "completion");
        FlowLiveDataConversions$asFlow$1 flowLiveDataConversions$asFlow$1 = new FlowLiveDataConversions$asFlow$1(this.f36019k, continuation);
        flowLiveDataConversions$asFlow$1.L$0 = obj;
        return flowLiveDataConversions$asFlow$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((FlowLiveDataConversions$asFlow$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v17, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: kotlinx.coroutines.flow.FlowCollector} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0097 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a5 A[Catch:{ all -> 0x00d4 }] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r15) {
        /*
            r14 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r14.f36018j
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0053
            if (r1 == r4) goto L_0x0043
            if (r1 == r3) goto L_0x002b
            if (r1 != r2) goto L_0x0023
            java.lang.Object r1 = r14.f36017i
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r14.f36016h
            androidx.lifecycle.Observer r4 = (androidx.lifecycle.Observer) r4
            java.lang.Object r6 = r14.L$0
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x003f }
            r15 = r1
            goto L_0x0088
        L_0x0023:
            java.lang.IllegalStateException r15 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r15.<init>(r0)
            throw r15
        L_0x002b:
            java.lang.Object r1 = r14.f36017i
            kotlinx.coroutines.channels.ChannelIterator r1 = (kotlinx.coroutines.channels.ChannelIterator) r1
            java.lang.Object r4 = r14.f36016h
            androidx.lifecycle.Observer r4 = (androidx.lifecycle.Observer) r4
            java.lang.Object r6 = r14.L$0
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            kotlin.ResultKt.throwOnFailure(r15)     // Catch:{ all -> 0x003f }
            r7 = r6
            r6 = r4
            r4 = r1
            r1 = r14
            goto L_0x009d
        L_0x003f:
            r15 = move-exception
        L_0x0040:
            r1 = r14
            goto L_0x00dd
        L_0x0043:
            java.lang.Object r1 = r14.f36017i
            androidx.lifecycle.Observer r1 = (androidx.lifecycle.Observer) r1
            java.lang.Object r4 = r14.f36016h
            kotlinx.coroutines.channels.Channel r4 = (kotlinx.coroutines.channels.Channel) r4
            java.lang.Object r6 = r14.L$0
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            kotlin.ResultKt.throwOnFailure(r15)
            goto L_0x0083
        L_0x0053:
            kotlin.ResultKt.throwOnFailure(r15)
            java.lang.Object r15 = r14.L$0
            r6 = r15
            kotlinx.coroutines.flow.FlowCollector r6 = (kotlinx.coroutines.flow.FlowCollector) r6
            r15 = -1
            r1 = 6
            kotlinx.coroutines.channels.Channel r15 = kotlinx.coroutines.channels.ChannelKt.Channel$default(r15, r5, r5, r1, r5)
            androidx.lifecycle.FlowLiveDataConversions$asFlow$1$observer$1 r1 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$observer$1
            r1.<init>(r15)
            kotlinx.coroutines.MainCoroutineDispatcher r7 = kotlinx.coroutines.Dispatchers.getMain()
            kotlinx.coroutines.MainCoroutineDispatcher r7 = r7.getImmediate()
            androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1 r8 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$1
            r8.<init>(r14, r1, r5)
            r14.L$0 = r6
            r14.f36016h = r15
            r14.f36017i = r1
            r14.f36018j = r4
            java.lang.Object r4 = kotlinx.coroutines.BuildersKt.withContext(r7, r8, r14)
            if (r4 != r0) goto L_0x0082
            return r0
        L_0x0082:
            r4 = r15
        L_0x0083:
            kotlinx.coroutines.channels.ChannelIterator r15 = r4.iterator()     // Catch:{ all -> 0x00d9 }
            r4 = r1
        L_0x0088:
            r1 = r14
        L_0x0089:
            r1.L$0 = r6     // Catch:{ all -> 0x00d7 }
            r1.f36016h = r4     // Catch:{ all -> 0x00d7 }
            r1.f36017i = r15     // Catch:{ all -> 0x00d7 }
            r1.f36018j = r3     // Catch:{ all -> 0x00d7 }
            java.lang.Object r7 = r15.hasNext(r1)     // Catch:{ all -> 0x00d7 }
            if (r7 != r0) goto L_0x0098
            return r0
        L_0x0098:
            r13 = r4
            r4 = r15
            r15 = r7
            r7 = r6
            r6 = r13
        L_0x009d:
            java.lang.Boolean r15 = (java.lang.Boolean) r15     // Catch:{ all -> 0x00d4 }
            boolean r15 = r15.booleanValue()     // Catch:{ all -> 0x00d4 }
            if (r15 == 0) goto L_0x00bc
            java.lang.Object r15 = r4.next()     // Catch:{ all -> 0x00d4 }
            r1.L$0 = r7     // Catch:{ all -> 0x00d4 }
            r1.f36016h = r6     // Catch:{ all -> 0x00d4 }
            r1.f36017i = r4     // Catch:{ all -> 0x00d4 }
            r1.f36018j = r2     // Catch:{ all -> 0x00d4 }
            java.lang.Object r15 = r7.emit(r15, r1)     // Catch:{ all -> 0x00d4 }
            if (r15 != r0) goto L_0x00b8
            return r0
        L_0x00b8:
            r15 = r4
            r4 = r6
            r6 = r7
            goto L_0x0089
        L_0x00bc:
            kotlinx.coroutines.GlobalScope r7 = kotlinx.coroutines.GlobalScope.INSTANCE
            kotlinx.coroutines.MainCoroutineDispatcher r15 = kotlinx.coroutines.Dispatchers.getMain()
            kotlinx.coroutines.MainCoroutineDispatcher r8 = r15.getImmediate()
            r9 = 0
            androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2 r10 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2
            r10.<init>(r1, r6, r5)
            r11 = 2
            r12 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r7, r8, r9, r10, r11, r12)
            kotlin.Unit r15 = kotlin.Unit.INSTANCE
            return r15
        L_0x00d4:
            r15 = move-exception
            r4 = r6
            goto L_0x00dd
        L_0x00d7:
            r15 = move-exception
            goto L_0x00dd
        L_0x00d9:
            r15 = move-exception
            r4 = r1
            goto L_0x0040
        L_0x00dd:
            kotlinx.coroutines.GlobalScope r6 = kotlinx.coroutines.GlobalScope.INSTANCE
            kotlinx.coroutines.MainCoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getMain()
            kotlinx.coroutines.MainCoroutineDispatcher r7 = r0.getImmediate()
            r8 = 0
            androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2 r9 = new androidx.lifecycle.FlowLiveDataConversions$asFlow$1$2
            r9.<init>(r1, r4, r5)
            r10 = 2
            r11 = 0
            kotlinx.coroutines.Job unused = kotlinx.coroutines.BuildersKt__Builders_commonKt.launch$default(r6, r7, r8, r9, r10, r11)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.lifecycle.FlowLiveDataConversions$asFlow$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
