package kotlinx.coroutines.flow;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u001f\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/internal/SafeCollector_commonKt$unsafeFlow$1", "Lkotlinx/coroutines/flow/Flow;", "collect", "", "collector", "Lkotlinx/coroutines/flow/FlowCollector;", "(Lkotlinx/coroutines/flow/FlowCollector;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 implements Flow<T> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Flow f25579b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Function2 f25580c;

    public FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1(Flow flow, Function2 function2) {
        this.f25579b = flow;
        this.f25580c = function2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object collect(@org.jetbrains.annotations.NotNull kotlinx.coroutines.flow.FlowCollector<? super T> r7, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r8) {
        /*
            r6 = this;
            boolean r0 = r8 instanceof kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1.AnonymousClass1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1$1 r0 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1.AnonymousClass1) r0
            int r1 = r0.f25582i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f25582i = r1
            goto L_0x0018
        L_0x0013:
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1$1 r0 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1$1
            r0.<init>(r6, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f25581h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f25582i
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x004a
            if (r2 == r4) goto L_0x003a
            if (r2 != r3) goto L_0x0032
            java.lang.Object r7 = r0.f25584k
            kotlinx.coroutines.flow.internal.SafeCollector r7 = (kotlinx.coroutines.flow.internal.SafeCollector) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch:{ all -> 0x0030 }
            goto L_0x0094
        L_0x0030:
            r8 = move-exception
            goto L_0x0098
        L_0x0032:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003a:
            java.lang.Object r7 = r0.f25586m
            kotlin.jvm.internal.Ref$BooleanRef r7 = (kotlin.jvm.internal.Ref.BooleanRef) r7
            java.lang.Object r2 = r0.f25585l
            kotlinx.coroutines.flow.FlowCollector r2 = (kotlinx.coroutines.flow.FlowCollector) r2
            java.lang.Object r4 = r0.f25584k
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1 r4 = (kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1) r4
            kotlin.ResultKt.throwOnFailure(r8)
            goto L_0x006d
        L_0x004a:
            kotlin.ResultKt.throwOnFailure(r8)
            kotlin.jvm.internal.Ref$BooleanRef r8 = new kotlin.jvm.internal.Ref$BooleanRef
            r8.<init>()
            r8.element = r4
            kotlinx.coroutines.flow.Flow r2 = r6.f25579b
            kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$1$1 r5 = new kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$1$1
            r5.<init>(r8, r7)
            r0.f25584k = r6
            r0.f25585l = r7
            r0.f25586m = r8
            r0.f25582i = r4
            java.lang.Object r2 = r2.collect(r5, r0)
            if (r2 != r1) goto L_0x006a
            return r1
        L_0x006a:
            r4 = r6
            r2 = r7
            r7 = r8
        L_0x006d:
            boolean r7 = r7.element
            if (r7 == 0) goto L_0x009c
            kotlinx.coroutines.flow.internal.SafeCollector r7 = new kotlinx.coroutines.flow.internal.SafeCollector
            kotlin.coroutines.CoroutineContext r8 = r0.getContext()
            r7.<init>(r2, r8)
            kotlin.jvm.functions.Function2 r8 = r4.f25580c     // Catch:{ all -> 0x0030 }
            r0.f25584k = r7     // Catch:{ all -> 0x0030 }
            r2 = 0
            r0.f25585l = r2     // Catch:{ all -> 0x0030 }
            r0.f25586m = r2     // Catch:{ all -> 0x0030 }
            r0.f25582i = r3     // Catch:{ all -> 0x0030 }
            r2 = 6
            kotlin.jvm.internal.InlineMarker.mark((int) r2)     // Catch:{ all -> 0x0030 }
            java.lang.Object r8 = r8.invoke(r7, r0)     // Catch:{ all -> 0x0030 }
            r0 = 7
            kotlin.jvm.internal.InlineMarker.mark((int) r0)     // Catch:{ all -> 0x0030 }
            if (r8 != r1) goto L_0x0094
            return r1
        L_0x0094:
            r7.releaseIntercepted()
            goto L_0x009c
        L_0x0098:
            r7.releaseIntercepted()
            throw r8
        L_0x009c:
            kotlin.Unit r7 = kotlin.Unit.INSTANCE
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.FlowKt__EmittersKt$onEmpty$$inlined$unsafeFlow$1.collect(kotlinx.coroutines.flow.FlowCollector, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
