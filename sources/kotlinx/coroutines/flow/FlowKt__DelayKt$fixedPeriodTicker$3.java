package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.channels.ProducerScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00010\u0000H@"}, d2 = {"Lkotlinx/coroutines/channels/ProducerScope;", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$3", f = "Delay.kt", i = {0, 1, 2}, l = {314, 316, 317}, m = "invokeSuspend", n = {"$this$produce", "$this$produce", "$this$produce"}, s = {"L$0", "L$0", "L$0"})
public final class FlowKt__DelayKt$fixedPeriodTicker$3 extends SuspendLambda implements Function2<ProducerScope<? super Unit>, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f25550h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ long f25551i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ long f25552j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__DelayKt$fixedPeriodTicker$3(long j11, long j12, Continuation<? super FlowKt__DelayKt$fixedPeriodTicker$3> continuation) {
        super(2, continuation);
        this.f25551i = j11;
        this.f25552j = j12;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        FlowKt__DelayKt$fixedPeriodTicker$3 flowKt__DelayKt$fixedPeriodTicker$3 = new FlowKt__DelayKt$fixedPeriodTicker$3(this.f25551i, this.f25552j, continuation);
        flowKt__DelayKt$fixedPeriodTicker$3.L$0 = obj;
        return flowKt__DelayKt$fixedPeriodTicker$3;
    }

    @Nullable
    public final Object invoke(@NotNull ProducerScope<? super Unit> producerScope, @Nullable Continuation<? super Unit> continuation) {
        return ((FlowKt__DelayKt$fixedPeriodTicker$3) create(producerScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: kotlinx.coroutines.channels.ProducerScope} */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0050 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005d A[RETURN] */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.f25550h
            r2 = 3
            r3 = 2
            r4 = 1
            if (r1 == 0) goto L_0x002a
            if (r1 == r4) goto L_0x0011
            if (r1 == r3) goto L_0x0021
            if (r1 != r2) goto L_0x0019
        L_0x0011:
            java.lang.Object r1 = r7.L$0
            kotlinx.coroutines.channels.ProducerScope r1 = (kotlinx.coroutines.channels.ProducerScope) r1
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x003f
        L_0x0019:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0021:
            java.lang.Object r1 = r7.L$0
            kotlinx.coroutines.channels.ProducerScope r1 = (kotlinx.coroutines.channels.ProducerScope) r1
            kotlin.ResultKt.throwOnFailure(r8)
            r8 = r7
            goto L_0x0051
        L_0x002a:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.L$0
            r1 = r8
            kotlinx.coroutines.channels.ProducerScope r1 = (kotlinx.coroutines.channels.ProducerScope) r1
            long r5 = r7.f25551i
            r7.L$0 = r1
            r7.f25550h = r4
            java.lang.Object r8 = kotlinx.coroutines.DelayKt.delay(r5, r7)
            if (r8 != r0) goto L_0x003f
            return r0
        L_0x003f:
            r8 = r7
        L_0x0040:
            kotlinx.coroutines.channels.SendChannel r4 = r1.getChannel()
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            r8.L$0 = r1
            r8.f25550h = r3
            java.lang.Object r4 = r4.send(r5, r8)
            if (r4 != r0) goto L_0x0051
            return r0
        L_0x0051:
            long r4 = r8.f25552j
            r8.L$0 = r1
            r8.f25550h = r2
            java.lang.Object r4 = kotlinx.coroutines.DelayKt.delay(r4, r8)
            if (r4 != r0) goto L_0x0040
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__DelayKt$fixedPeriodTicker$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
