package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 implements Flow<T> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function2 f25587b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Flow f25588c;

    public FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1(Function2 function2, Flow flow) {
        this.f25587b = function2;
        this.f25588c = flow;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0082 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.f25590i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25590i = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f25589h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f25590i
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0046
            if (r2 == r4) goto L_0x0034
            if (r2 != r3) goto L_0x002c
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x0083
        L_0x002c:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x0034:
            java.lang.Object r7 = r0.f25594m
            kotlinx.coroutines.flow.internal.SafeCollector r7 = (kotlinx.coroutines.flow.internal.SafeCollector) r7
            java.lang.Object r2 = r0.f25593l
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r4 = r0.f25592k
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1 r4 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1) r4
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0044 }
            goto L_0x006e
        L_0x0044:
            r8 = move-exception
            goto L_0x008a
        L_0x0046:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlinx.coroutines.flow.internal.SafeCollector r8 = new kotlinx.coroutines.flow.internal.SafeCollector
            kotlin.coroutines.CoroutineContext r2 = r0.getContext()
            r8.<init>(r7, r2)
            kotlin.jvm.functions.Function2 r2 = r6.f25587b     // Catch:{ all -> 0x0086 }
            r0.f25592k = r6     // Catch:{ all -> 0x0086 }
            r0.f25593l = r7     // Catch:{ all -> 0x0086 }
            r0.f25594m = r8     // Catch:{ all -> 0x0086 }
            r0.f25590i = r4     // Catch:{ all -> 0x0086 }
            r4 = 6
            kotlin.jvm.internal.InlineMarker.mark((int) r4)     // Catch:{ all -> 0x0086 }
            java.lang.Object r2 = r2.invoke(r8, r0)     // Catch:{ all -> 0x0086 }
            r4 = 7
            kotlin.jvm.internal.InlineMarker.mark((int) r4)     // Catch:{ all -> 0x0086 }
            if (r2 != r1) goto L_0x006b
            return r1
        L_0x006b:
            r4 = r6
            r2 = r7
            r7 = r8
        L_0x006e:
            r7.releaseIntercepted()
            kotlinx.coroutines.flow.Flow r7 = r4.f25588c
            r8 = 0
            r0.f25592k = r8
            r0.f25593l = r8
            r0.f25594m = r8
            r0.f25590i = r3
            java.lang.Object r7 = r7.collect(r2, r0)
            if (r7 != r1) goto L_0x0083
            return r1
        L_0x0083:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        L_0x0086:
            r7 = move-exception
            r5 = r8
            r8 = r7
            r7 = r5
        L_0x008a:
            r7.releaseIntercepted()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$onStart$$inlined$unsafeFlow$1.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
