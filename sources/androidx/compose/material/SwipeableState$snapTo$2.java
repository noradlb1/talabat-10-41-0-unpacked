package androidx.compose.material;

import java.util.Map;
import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowCollector;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0005\u001a\u00020\u0004\"\u0004\b\u0000\u0010\u00002\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00028\u00000\u0001H@"}, d2 = {"T", "", "", "anchors", "", "<anonymous>"}, k = 3, mv = {1, 6, 0})
public final class SwipeableState$snapTo$2 implements FlowCollector<Map<Float, ? extends T>> {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ T f5687b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SwipeableState<T> f5688c;

    public SwipeableState$snapTo$2(T t11, SwipeableState<T> swipeableState) {
        this.f5687b = t11;
        this.f5688c = swipeableState;
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object emit(@org.jetbrains.annotations.NotNull java.util.Map<java.lang.Float, ? extends T> r5, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.compose.material.SwipeableState$snapTo$2$emit$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.compose.material.SwipeableState$snapTo$2$emit$1 r0 = (androidx.compose.material.SwipeableState$snapTo$2$emit$1) r0
            int r1 = r0.f5692k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f5692k = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.material.SwipeableState$snapTo$2$emit$1 r0 = new androidx.compose.material.SwipeableState$snapTo$2$emit$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.f5690i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f5692k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r5 = r0.f5689h
            androidx.compose.material.SwipeableState$snapTo$2 r5 = (androidx.compose.material.SwipeableState$snapTo$2) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x0052
        L_0x002d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            T r6 = r4.f5687b
            java.lang.Float r5 = androidx.compose.material.SwipeableKt.getOffset(r5, r6)
            if (r5 == 0) goto L_0x005c
            androidx.compose.material.SwipeableState<T> r6 = r4.f5688c
            float r5 = r5.floatValue()
            r0.f5689h = r4
            r0.f5692k = r3
            java.lang.Object r5 = r6.snapInternalToOffset(r5, r0)
            if (r5 != r1) goto L_0x0051
            return r1
        L_0x0051:
            r5 = r4
        L_0x0052:
            androidx.compose.material.SwipeableState<T> r6 = r5.f5688c
            T r5 = r5.f5687b
            r6.setCurrentValue(r5)
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        L_0x005c:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "The target value must have an associated anchor."
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableState$snapTo$2.emit(java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
