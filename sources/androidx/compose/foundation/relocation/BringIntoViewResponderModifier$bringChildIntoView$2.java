package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.relocation.BringIntoViewResponderModifier$bringChildIntoView$2", f = "BringIntoViewResponder.kt", i = {0, 1, 1, 1, 2}, l = {224, 233, 240}, m = "invokeSuspend", n = {"thisRequest", "layoutCoordinates", "thisRequest", "previousRequest", "thisRequest"}, s = {"L$0", "L$0", "L$1", "L$2", "L$0"})
public final class BringIntoViewResponderModifier$bringChildIntoView$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f3196h;

    /* renamed from: i  reason: collision with root package name */
    public Object f3197i;

    /* renamed from: j  reason: collision with root package name */
    public int f3198j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ BringIntoViewResponderModifier f3199k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ LayoutCoordinates f3200l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function0<Rect> f3201m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BringIntoViewResponderModifier$bringChildIntoView$2(BringIntoViewResponderModifier bringIntoViewResponderModifier, LayoutCoordinates layoutCoordinates, Function0<Rect> function0, Continuation<? super BringIntoViewResponderModifier$bringChildIntoView$2> continuation) {
        super(2, continuation);
        this.f3199k = bringIntoViewResponderModifier;
        this.f3200l = layoutCoordinates;
        this.f3201m = function0;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        BringIntoViewResponderModifier$bringChildIntoView$2 bringIntoViewResponderModifier$bringChildIntoView$2 = new BringIntoViewResponderModifier$bringChildIntoView$2(this.f3199k, this.f3200l, this.f3201m, continuation);
        bringIntoViewResponderModifier$bringChildIntoView$2.L$0 = obj;
        return bringIntoViewResponderModifier$bringChildIntoView$2;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((BringIntoViewResponderModifier$bringChildIntoView$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARNING: Removed duplicated region for block: B:51:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00e9  */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x010f  */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x011c  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r10) {
        /*
            r9 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r9.f3198j
            r2 = 3
            r3 = 2
            r4 = 1
            r5 = 0
            if (r1 == 0) goto L_0x0044
            if (r1 == r4) goto L_0x0038
            if (r1 == r3) goto L_0x0023
            if (r1 != r2) goto L_0x001b
            java.lang.Object r0 = r9.L$0
            kotlin.Pair r0 = (kotlin.Pair) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0041 }
            goto L_0x00cd
        L_0x001b:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r10.<init>(r0)
            throw r10
        L_0x0023:
            java.lang.Object r1 = r9.f3197i
            kotlin.Pair r1 = (kotlin.Pair) r1
            java.lang.Object r3 = r9.f3196h
            kotlin.Pair r3 = (kotlin.Pair) r3
            java.lang.Object r4 = r9.L$0
            androidx.compose.ui.layout.LayoutCoordinates r4 = (androidx.compose.ui.layout.LayoutCoordinates) r4
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0034 }
            goto L_0x00b3
        L_0x0034:
            r10 = move-exception
            r0 = r3
            goto L_0x0124
        L_0x0038:
            java.lang.Object r0 = r9.L$0
            kotlin.Pair r0 = (kotlin.Pair) r0
            kotlin.ResultKt.throwOnFailure(r10)     // Catch:{ all -> 0x0041 }
            goto L_0x00ff
        L_0x0041:
            r10 = move-exception
            goto L_0x0124
        L_0x0044:
            kotlin.ResultKt.throwOnFailure(r10)
            java.lang.Object r10 = r9.L$0
            kotlinx.coroutines.CoroutineScope r10 = (kotlinx.coroutines.CoroutineScope) r10
            androidx.compose.foundation.relocation.BringIntoViewResponderModifier r1 = r9.f3199k
            androidx.compose.ui.layout.LayoutCoordinates r1 = r1.a()
            if (r1 != 0) goto L_0x0056
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0056:
            androidx.compose.ui.layout.LayoutCoordinates r6 = r9.f3200l
            boolean r6 = r6.isAttached()
            if (r6 != 0) goto L_0x0061
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0061:
            androidx.compose.ui.layout.LayoutCoordinates r6 = r9.f3200l
            kotlin.jvm.functions.Function0<androidx.compose.ui.geometry.Rect> r7 = r9.f3201m
            java.lang.Object r7 = r7.invoke()
            androidx.compose.ui.geometry.Rect r7 = (androidx.compose.ui.geometry.Rect) r7
            if (r7 != 0) goto L_0x0070
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x0070:
            androidx.compose.ui.geometry.Rect r6 = androidx.compose.foundation.relocation.BringIntoViewResponderKt.localRectOf(r1, r6, r7)
            kotlin.coroutines.CoroutineContext r10 = r10.getCoroutineContext()
            kotlinx.coroutines.Job r10 = kotlinx.coroutines.JobKt.getJob(r10)
            kotlin.Pair r7 = new kotlin.Pair
            r7.<init>(r6, r10)
            androidx.compose.foundation.relocation.BringIntoViewResponderModifier r10 = r9.f3199k
            kotlin.Pair r10 = r10.newestReceivedRequest
            androidx.compose.foundation.relocation.BringIntoViewResponderModifier r8 = r9.f3199k
            r8.newestReceivedRequest = r7
            if (r10 == 0) goto L_0x00f1
            java.lang.Object r8 = r10.getFirst()     // Catch:{ all -> 0x0122 }
            androidx.compose.ui.geometry.Rect r8 = (androidx.compose.ui.geometry.Rect) r8     // Catch:{ all -> 0x0122 }
            boolean r6 = androidx.compose.foundation.relocation.BringIntoViewResponderKt.completelyOverlaps(r8, r6)     // Catch:{ all -> 0x0122 }
            if (r6 != 0) goto L_0x009b
            goto L_0x00f1
        L_0x009b:
            java.lang.Object r4 = r10.getSecond()     // Catch:{ all -> 0x0122 }
            kotlinx.coroutines.Job r4 = (kotlinx.coroutines.Job) r4     // Catch:{ all -> 0x0122 }
            r9.L$0 = r1     // Catch:{ all -> 0x0122 }
            r9.f3196h = r7     // Catch:{ all -> 0x0122 }
            r9.f3197i = r10     // Catch:{ all -> 0x0122 }
            r9.f3198j = r3     // Catch:{ all -> 0x0122 }
            java.lang.Object r3 = r4.join(r9)     // Catch:{ all -> 0x0122 }
            if (r3 != r0) goto L_0x00b0
            return r0
        L_0x00b0:
            r4 = r1
            r3 = r7
            r1 = r10
        L_0x00b3:
            androidx.compose.foundation.relocation.BringIntoViewResponderModifier r10 = r9.f3199k     // Catch:{ all -> 0x0034 }
            kotlin.Pair r10 = r10.newestDispatchedRequest     // Catch:{ all -> 0x0034 }
            if (r10 != r1) goto L_0x00ce
            androidx.compose.foundation.relocation.BringIntoViewResponderModifier r10 = r9.f3199k     // Catch:{ all -> 0x0034 }
            r9.L$0 = r3     // Catch:{ all -> 0x0034 }
            r9.f3196h = r5     // Catch:{ all -> 0x0034 }
            r9.f3197i = r5     // Catch:{ all -> 0x0034 }
            r9.f3198j = r2     // Catch:{ all -> 0x0034 }
            java.lang.Object r10 = r10.dispatchRequest(r3, r4, r9)     // Catch:{ all -> 0x0034 }
            if (r10 != r0) goto L_0x00cc
            return r0
        L_0x00cc:
            r0 = r3
        L_0x00cd:
            r3 = r0
        L_0x00ce:
            androidx.compose.foundation.relocation.BringIntoViewResponderModifier r10 = r9.f3199k
            kotlin.Pair r10 = r10.newestDispatchedRequest
            androidx.compose.foundation.relocation.BringIntoViewResponderModifier r0 = r9.f3199k
            kotlin.Pair r0 = r0.newestReceivedRequest
            if (r10 != r0) goto L_0x00e1
            androidx.compose.foundation.relocation.BringIntoViewResponderModifier r10 = r9.f3199k
            r10.newestDispatchedRequest = r5
        L_0x00e1:
            androidx.compose.foundation.relocation.BringIntoViewResponderModifier r10 = r9.f3199k
            kotlin.Pair r10 = r10.newestReceivedRequest
            if (r10 != r3) goto L_0x00ee
            androidx.compose.foundation.relocation.BringIntoViewResponderModifier r10 = r9.f3199k
            r10.newestReceivedRequest = r5
        L_0x00ee:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE
            return r10
        L_0x00f1:
            androidx.compose.foundation.relocation.BringIntoViewResponderModifier r10 = r9.f3199k     // Catch:{ all -> 0x0122 }
            r9.L$0 = r7     // Catch:{ all -> 0x0122 }
            r9.f3198j = r4     // Catch:{ all -> 0x0122 }
            java.lang.Object r10 = r10.dispatchRequest(r7, r1, r9)     // Catch:{ all -> 0x0122 }
            if (r10 != r0) goto L_0x00fe
            return r0
        L_0x00fe:
            r0 = r7
        L_0x00ff:
            kotlin.Unit r10 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0041 }
            androidx.compose.foundation.relocation.BringIntoViewResponderModifier r1 = r9.f3199k
            kotlin.Pair r1 = r1.newestDispatchedRequest
            androidx.compose.foundation.relocation.BringIntoViewResponderModifier r2 = r9.f3199k
            kotlin.Pair r2 = r2.newestReceivedRequest
            if (r1 != r2) goto L_0x0114
            androidx.compose.foundation.relocation.BringIntoViewResponderModifier r1 = r9.f3199k
            r1.newestDispatchedRequest = r5
        L_0x0114:
            androidx.compose.foundation.relocation.BringIntoViewResponderModifier r1 = r9.f3199k
            kotlin.Pair r1 = r1.newestReceivedRequest
            if (r1 != r0) goto L_0x0121
            androidx.compose.foundation.relocation.BringIntoViewResponderModifier r0 = r9.f3199k
            r0.newestReceivedRequest = r5
        L_0x0121:
            return r10
        L_0x0122:
            r10 = move-exception
            r0 = r7
        L_0x0124:
            androidx.compose.foundation.relocation.BringIntoViewResponderModifier r1 = r9.f3199k
            kotlin.Pair r1 = r1.newestDispatchedRequest
            androidx.compose.foundation.relocation.BringIntoViewResponderModifier r2 = r9.f3199k
            kotlin.Pair r2 = r2.newestReceivedRequest
            if (r1 != r2) goto L_0x0137
            androidx.compose.foundation.relocation.BringIntoViewResponderModifier r1 = r9.f3199k
            r1.newestDispatchedRequest = r5
        L_0x0137:
            androidx.compose.foundation.relocation.BringIntoViewResponderModifier r1 = r9.f3199k
            kotlin.Pair r1 = r1.newestReceivedRequest
            if (r1 != r0) goto L_0x0144
            androidx.compose.foundation.relocation.BringIntoViewResponderModifier r0 = r9.f3199k
            r0.newestReceivedRequest = r5
        L_0x0144:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.relocation.BringIntoViewResponderModifier$bringChildIntoView$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
