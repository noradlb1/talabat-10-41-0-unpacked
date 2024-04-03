package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0004\u001a\u00020\u0003\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00020\u00020\u0001H@"}, d2 = {"T", "Lkotlinx/coroutines/channels/ProducerScope;", "", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1", f = "Delay.kt", i = {}, l = {280}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__DelayKt$sample$2$values$1 extends SuspendLambda implements Function2<ProducerScope<? super Object>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f25566h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Flow<T> f25567i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$sample$2$values$1(Flow<? extends T> flow, Continuation<? super FlowKt__DelayKt$sample$2$values$1> continuation) {
        super(2, continuation);
        this.f25567i = flow;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__DelayKt$sample$2$values$1 flowKt__DelayKt$sample$2$values$1 = new FlowKt__DelayKt$sample$2$values$1(this.f25567i, continuation);
        flowKt__DelayKt$sample$2$values$1.L$0 = obj;
        return flowKt__DelayKt$sample$2$values$1;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<Object> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowKt__DelayKt$sample$2$values$1) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f25566h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final ProducerScope producerScope = (ProducerScope) this.L$0;
            Flow<T> flow = this.f25567i;
            AnonymousClass1 r32 = new FlowCollector() {
                /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
                @org.jetbrains.annotations.Nullable
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public final java.lang.Object emit(T r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1$1$emit$1
                        if (r0 == 0) goto L_0x0013
                        r0 = r6
                        kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1$1$emit$1) r0
                        int r1 = r0.f25571j
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L_0x0013
                        int r1 = r1 - r2
                        r0.f25571j = r1
                        goto L_0x0018
                    L_0x0013:
                        kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1$1$emit$1
                        r0.<init>(r4, r6)
                    L_0x0018:
                        java.lang.Object r6 = r0.f25569h
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.f25571j
                        r3 = 1
                        if (r2 == 0) goto L_0x0031
                        if (r2 != r3) goto L_0x0029
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L_0x0043
                    L_0x0029:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L_0x0031:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.channels.ProducerScope<java.lang.Object> r6 = r5
                        if (r5 != 0) goto L_0x003a
                        kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL
                    L_0x003a:
                        r0.f25571j = r3
                        java.lang.Object r5 = r6.send(r5, r0)
                        if (r5 != r1) goto L_0x0043
                        return r1
                    L_0x0043:
                        kotlin.Unit r5 = kotlin.Unit.INSTANCE
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$sample$2$values$1.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            };
            this.f25566h = 1;
            if (flow.collect(r32, this) == coroutine_suspended) {
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
