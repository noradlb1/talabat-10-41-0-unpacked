package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u0002H@¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "T", "value", "emit", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FlowKt__TransformKt$runningReduce$1$1<T> implements FlowCollector {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Ref.ObjectRef<Object> f25928b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function3<T, T, Continuation<? super T>, Object> f25929c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FlowCollector<T> f25930d;

    public FlowKt__TransformKt$runningReduce$1$1(Ref.ObjectRef<Object> objectRef, Function3<? super T, ? super T, ? super Continuation<? super T>, ? extends Object> function3, FlowCollector<? super T> flowCollector) {
        this.f25928b = objectRef;
        this.f25929c = function3;
        this.f25930d = flowCollector;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0078 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emit(T r8, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1$emit$1
            if (r0 == 0) goto L_0x0013
            r0 = r9
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1$emit$1 r0 = (kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1$emit$1) r0
            int r1 = r0.f25935l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25935l = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1$emit$1 r0 = new kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1$emit$1
            r0.<init>(r7, r9)
        L_0x0018:
            java.lang.Object r9 = r0.f25933j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f25935l
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0079
        L_0x002c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L_0x0034:
            java.lang.Object r8 = r0.f25932i
            kotlin.jvm.internal.Ref$ObjectRef r8 = (kotlin.jvm.internal.Ref.ObjectRef) r8
            java.lang.Object r2 = r0.f25931h
            kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1 r2 = (kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L_0x0060
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r9 = r7.f25928b
            T r2 = r9.element
            kotlinx.coroutines.internal.Symbol r5 = kotlinx.coroutines.flow.internal.NullSurrogateKt.NULL
            if (r2 != r5) goto L_0x004d
            r2 = r7
            goto L_0x0063
        L_0x004d:
            kotlin.jvm.functions.Function3<T, T, kotlin.coroutines.Continuation<? super T>, java.lang.Object> r5 = r7.f25929c
            r0.f25931h = r7
            r0.f25932i = r9
            r0.f25935l = r4
            java.lang.Object r8 = r5.invoke(r2, r8, r0)
            if (r8 != r1) goto L_0x005c
            return r1
        L_0x005c:
            r2 = r7
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x0060:
            r6 = r9
            r9 = r8
            r8 = r6
        L_0x0063:
            r9.element = r8
            kotlinx.coroutines.flow.FlowCollector<T> r8 = r2.f25930d
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.Object> r9 = r2.f25928b
            T r9 = r9.element
            r2 = 0
            r0.f25931h = r2
            r0.f25932i = r2
            r0.f25935l = r3
            java.lang.Object r8 = r8.emit(r9, r0)
            if (r8 != r1) goto L_0x0079
            return r1
        L_0x0079:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__TransformKt$runningReduce$1$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
