package androidx.paging.multicast;

import androidx.paging.multicast.ChannelManager;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0003*\b\u0012\u0004\u0012\u0002H\u00030\u0004H@¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"<anonymous>", "", "T", "R", "Lkotlinx/coroutines/flow/FlowCollector;", "invoke", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "kotlinx/coroutines/flow/FlowKt__EmittersKt$transform$1"}, k = 3, mv = {1, 4, 2})
@DebugMetadata(c = "androidx.paging.multicast.Multicaster$flow$1$invokeSuspend$$inlined$transform$1", f = "Multicaster.kt", i = {}, l = {215}, m = "invokeSuspend", n = {}, s = {})
public final class Multicaster$flow$1$invokeSuspend$$inlined$transform$1 extends SuspendLambda implements Function2<FlowCollector<? super T>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f37214h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Flow f37215i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Multicaster$flow$1$invokeSuspend$$inlined$transform$1(Flow flow, Continuation continuation) {
        super(2, continuation);
        this.f37215i = flow;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        Multicaster$flow$1$invokeSuspend$$inlined$transform$1 multicaster$flow$1$invokeSuspend$$inlined$transform$1 = new Multicaster$flow$1$invokeSuspend$$inlined$transform$1(this.f37215i, continuation);
        multicaster$flow$1$invokeSuspend$$inlined$transform$1.L$0 = obj;
        return multicaster$flow$1$invokeSuspend$$inlined$transform$1;
    }

    public final Object invoke(Object obj, Object obj2) {
        return ((Multicaster$flow$1$invokeSuspend$$inlined$transform$1) create(obj, (Continuation) obj2)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f37214h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final FlowCollector flowCollector = (FlowCollector) this.L$0;
            Flow flow = this.f37215i;
            AnonymousClass1 r32 = new FlowCollector<ChannelManager.Message.Dispatch.Value<T>>(this) {

                /* renamed from: b  reason: collision with root package name */
                public final /* synthetic */ Multicaster$flow$1$invokeSuspend$$inlined$transform$1 f37216b;

                {
                    this.f37216b = r1;
                }

                /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
                /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
                @org.jetbrains.annotations.Nullable
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public java.lang.Object emit(java.lang.Object r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation r6) {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof androidx.paging.multicast.Multicaster$flow$1$invokeSuspend$$inlined$transform$1.AnonymousClass1.AnonymousClass1
                        if (r0 == 0) goto L_0x0013
                        r0 = r6
                        androidx.paging.multicast.Multicaster$flow$1$invokeSuspend$$inlined$transform$1$1$1 r0 = (androidx.paging.multicast.Multicaster$flow$1$invokeSuspend$$inlined$transform$1.AnonymousClass1.AnonymousClass1) r0
                        int r1 = r0.f37219i
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L_0x0013
                        int r1 = r1 - r2
                        r0.f37219i = r1
                        goto L_0x0018
                    L_0x0013:
                        androidx.paging.multicast.Multicaster$flow$1$invokeSuspend$$inlined$transform$1$1$1 r0 = new androidx.paging.multicast.Multicaster$flow$1$invokeSuspend$$inlined$transform$1$1$1
                        r0.<init>(r4, r6)
                    L_0x0018:
                        java.lang.Object r6 = r0.f37218h
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                        int r2 = r0.f37219i
                        r3 = 1
                        if (r2 == 0) goto L_0x0035
                        if (r2 != r3) goto L_0x002d
                        java.lang.Object r5 = r0.f37221k
                        androidx.paging.multicast.ChannelManager$Message$Dispatch$Value r5 = (androidx.paging.multicast.ChannelManager.Message.Dispatch.Value) r5
                        kotlin.ResultKt.throwOnFailure(r6)
                        goto L_0x004b
                    L_0x002d:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L_0x0035:
                        kotlin.ResultKt.throwOnFailure(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r5
                        androidx.paging.multicast.ChannelManager$Message$Dispatch$Value r5 = (androidx.paging.multicast.ChannelManager.Message.Dispatch.Value) r5
                        java.lang.Object r2 = r5.getValue()
                        r0.f37221k = r5
                        r0.f37219i = r3
                        java.lang.Object r6 = r6.emit(r2, r0)
                        if (r6 != r1) goto L_0x004b
                        return r1
                    L_0x004b:
                        kotlinx.coroutines.CompletableDeferred r5 = r5.getDelivered()
                        kotlin.Unit r6 = kotlin.Unit.INSTANCE
                        r5.complete(r6)
                        return r6
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.paging.multicast.Multicaster$flow$1$invokeSuspend$$inlined$transform$1.AnonymousClass1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            };
            this.f37214h = 1;
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
