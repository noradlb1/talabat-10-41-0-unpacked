package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function3;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 implements Flow<T> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Flow f25572b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function3 f25573c;

    public FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1(Flow flow, Function3 function3) {
        this.f25572b = flow;
        this.f25573c = function3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0086 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0026  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> r9, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r10) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.f25575i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25575i = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1$1
            r0.<init>(r8, r10)
        L_0x0018:
            java.lang.Object r10 = r0.f25574h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f25575i
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            if (r2 == 0) goto L_0x0054
            if (r2 == r5) goto L_0x0046
            if (r2 == r4) goto L_0x003e
            if (r2 != r3) goto L_0x0036
            java.lang.Object r9 = r0.f25577k
            kotlinx.coroutines.flow.internal.SafeCollector r9 = (kotlinx.coroutines.flow.internal.SafeCollector) r9
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0034 }
            goto L_0x0088
        L_0x0034:
            r10 = move-exception
            goto L_0x0092
        L_0x0036:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r10)
            throw r9
        L_0x003e:
            java.lang.Object r9 = r0.f25577k
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            kotlin.ResultKt.throwOnFailure(r10)
            goto L_0x00ac
        L_0x0046:
            java.lang.Object r9 = r0.f25578l
            kotlinx.coroutines.flow.FlowCollector r9 = (kotlinx.coroutines.flow.FlowCollector) r9
            java.lang.Object r2 = r0.f25577k
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1 r2 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1) r2
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0052 }
            goto L_0x0067
        L_0x0052:
            r9 = move-exception
            goto L_0x0098
        L_0x0054:
            kotlin.ResultKt.throwOnFailure(r10)
            kotlinx.coroutines.flow.Flow r10 = r8.f25572b     // Catch:{ all -> 0x0096 }
            r0.f25577k = r8     // Catch:{ all -> 0x0096 }
            r0.f25578l = r9     // Catch:{ all -> 0x0096 }
            r0.f25575i = r5     // Catch:{ all -> 0x0096 }
            java.lang.Object r10 = r10.collect(r9, r0)     // Catch:{ all -> 0x0096 }
            if (r10 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r2 = r8
        L_0x0067:
            kotlinx.coroutines.flow.internal.SafeCollector r10 = new kotlinx.coroutines.flow.internal.SafeCollector
            kotlin.coroutines.CoroutineContext r4 = r0.getContext()
            r10.<init>(r9, r4)
            kotlin.jvm.functions.Function3 r9 = r2.f25573c     // Catch:{ all -> 0x008e }
            r0.f25577k = r10     // Catch:{ all -> 0x008e }
            r0.f25578l = r6     // Catch:{ all -> 0x008e }
            r0.f25575i = r3     // Catch:{ all -> 0x008e }
            r2 = 6
            kotlin.jvm.internal.InlineMarker.mark((int) r2)     // Catch:{ all -> 0x008e }
            java.lang.Object r9 = r9.invoke(r10, r6, r0)     // Catch:{ all -> 0x008e }
            r0 = 7
            kotlin.jvm.internal.InlineMarker.mark((int) r0)     // Catch:{ all -> 0x008e }
            if (r9 != r1) goto L_0x0087
            return r1
        L_0x0087:
            r9 = r10
        L_0x0088:
            r9.releaseIntercepted()
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        L_0x008e:
            r9 = move-exception
            r7 = r10
            r10 = r9
            r9 = r7
        L_0x0092:
            r9.releaseIntercepted()
            throw r10
        L_0x0096:
            r9 = move-exception
            r2 = r8
        L_0x0098:
            kotlinx.coroutines.flow.ThrowingCollector r10 = new kotlinx.coroutines.flow.ThrowingCollector
            r10.<init>(r9)
            kotlin.jvm.functions.Function3 r2 = r2.f25573c
            r0.f25577k = r9
            r0.f25578l = r6
            r0.f25575i = r4
            java.lang.Object r10 = kotlinx.coroutines.flow.FlowKt__EmittersKt.invokeSafely$FlowKt__EmittersKt(r10, r2, r9, r0)
            if (r10 != r1) goto L_0x00ac
            return r1
        L_0x00ac:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$onCompletion$$inlined$unsafeFlow$1.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
