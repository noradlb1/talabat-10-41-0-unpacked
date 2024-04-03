package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FlowKt__LimitKt$take$2$1<T> implements FlowCollector {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref.IntRef f25707b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f25708c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FlowCollector<T> f25709d;

    public FlowKt__LimitKt$take$2$1(Ref.IntRef intRef, int i11, FlowCollector<? super T> flowCollector) {
        this.f25707b = intRef;
        this.f25708c = i11;
        this.f25709d = flowCollector;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emit(T r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1$emit$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1$emit$1) r0
            int r1 = r0.f25712j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25712j = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1$emit$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f25710h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f25712j
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0038
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x005f
        L_0x002c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0034:
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0051
        L_0x0038:
            kotlin.ResultKt.throwOnFailure(r7)
            kotlin.jvm.internal.Ref$IntRef r7 = r5.f25707b
            int r2 = r7.element
            int r2 = r2 + r4
            r7.element = r2
            int r7 = r5.f25708c
            if (r2 >= r7) goto L_0x0054
            kotlinx.coroutines.flow.FlowCollector<T> r7 = r5.f25709d
            r0.f25712j = r4
            java.lang.Object r6 = r7.emit(r6, r0)
            if (r6 != r1) goto L_0x0051
            return r1
        L_0x0051:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0054:
            kotlinx.coroutines.flow.FlowCollector<T> r7 = r5.f25709d
            r0.f25712j = r3
            java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt__LimitKt.emitAbort$FlowKt__LimitKt(r7, r6, r0)
            if (r6 != r1) goto L_0x005f
            return r1
        L_0x005f:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__LimitKt$take$2$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
