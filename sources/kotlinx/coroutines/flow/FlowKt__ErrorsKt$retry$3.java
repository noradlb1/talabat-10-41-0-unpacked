package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0007\u001a\u00020\u0006\"\u0004\b\u0000\u0010\u0000*\b\u0012\u0004\u0012\u00028\u00000\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H@"}, d2 = {"T", "Lkotlinx/coroutines/flow/FlowCollector;", "", "cause", "", "attempt", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
@DebugMetadata(c = "kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3", f = "Errors.kt", i = {}, l = {95}, m = "invokeSuspend", n = {}, s = {})
public final class FlowKt__ErrorsKt$retry$3 extends SuspendLambda implements Function4<FlowCollector<? super T>, Throwable, Long, Continuation<? super Boolean>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f25648h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ Object f25649i;

    /* renamed from: j  reason: collision with root package name */
    public /* synthetic */ long f25650j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ long f25651k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function2<Throwable, Continuation<? super Boolean>, Object> f25652l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FlowKt__ErrorsKt$retry$3(long j11, Function2<? super Throwable, ? super Continuation<? super Boolean>, ? extends Object> function2, Continuation<? super FlowKt__ErrorsKt$retry$3> continuation) {
        super(4, continuation);
        this.f25651k = j11;
        this.f25652l = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
        return invoke((FlowCollector) obj, (Throwable) obj2, ((Number) obj3).longValue(), (Continuation<? super Boolean>) (Continuation) obj4);
    }

    @Nullable
    public final Object invoke(@NotNull FlowCollector<? super T> flowCollector, @NotNull Throwable th2, long j11, @Nullable Continuation<? super Boolean> continuation) {
        FlowKt__ErrorsKt$retry$3 flowKt__ErrorsKt$retry$3 = new FlowKt__ErrorsKt$retry$3(this.f25651k, this.f25652l, continuation);
        flowKt__ErrorsKt$retry$3.f25649i = th2;
        flowKt__ErrorsKt$retry$3.f25650j = j11;
        return flowKt__ErrorsKt$retry$3.invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0037, code lost:
        if (((java.lang.Boolean) r8).booleanValue() != false) goto L_0x003b;
     */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r8) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.f25648h
            r2 = 1
            if (r1 == 0) goto L_0x0017
            if (r1 != r2) goto L_0x000f
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0031
        L_0x000f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0017:
            kotlin.ResultKt.throwOnFailure(r8)
            java.lang.Object r8 = r7.f25649i
            java.lang.Throwable r8 = (java.lang.Throwable) r8
            long r3 = r7.f25650j
            long r5 = r7.f25651k
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x003a
            kotlin.jvm.functions.Function2<java.lang.Throwable, kotlin.coroutines.Continuation<? super java.lang.Boolean>, java.lang.Object> r1 = r7.f25652l
            r7.f25648h = r2
            java.lang.Object r8 = r1.invoke(r8, r7)
            if (r8 != r0) goto L_0x0031
            return r0
        L_0x0031:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L_0x003a
            goto L_0x003b
        L_0x003a:
            r2 = 0
        L_0x003b:
            java.lang.Boolean r8 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__ErrorsKt$retry$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
