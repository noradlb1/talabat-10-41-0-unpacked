package androidx.compose.foundation.lazy.layout;

import androidx.compose.foundation.gestures.ScrollScope;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/foundation/gestures/ScrollScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2", f = "LazyAnimateScroll.kt", i = {0, 0, 0, 0, 0, 0, 0, 1}, l = {134, 230}, m = "invokeSuspend", n = {"$this$scroll", "loop", "anim", "loops", "targetDistancePx", "boundDistancePx", "forward", "$this$scroll"}, s = {"L$0", "L$1", "L$2", "L$3", "F$0", "F$1", "I$0", "L$0"})
public final class LazyAnimateScrollKt$animateScrollToItem$2 extends SuspendLambda implements Function2<ScrollScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public Object f2985h;

    /* renamed from: i  reason: collision with root package name */
    public Object f2986i;

    /* renamed from: j  reason: collision with root package name */
    public Object f2987j;

    /* renamed from: k  reason: collision with root package name */
    public float f2988k;

    /* renamed from: l  reason: collision with root package name */
    public float f2989l;

    /* renamed from: m  reason: collision with root package name */
    public int f2990m;

    /* renamed from: n  reason: collision with root package name */
    public int f2991n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ int f2992o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ LazyAnimateScrollScope f2993p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ int f2994q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LazyAnimateScrollKt$animateScrollToItem$2(int i11, LazyAnimateScrollScope lazyAnimateScrollScope, int i12, Continuation<? super LazyAnimateScrollKt$animateScrollToItem$2> continuation) {
        super(2, continuation);
        this.f2992o = i11;
        this.f2993p = lazyAnimateScrollScope;
        this.f2994q = i12;
    }

    /* access modifiers changed from: private */
    public static final boolean invokeSuspend$isOvershot(boolean z11, LazyAnimateScrollScope lazyAnimateScrollScope, int i11, int i12) {
        if (z11) {
            if (lazyAnimateScrollScope.getFirstVisibleItemIndex() <= i11 && (lazyAnimateScrollScope.getFirstVisibleItemIndex() != i11 || lazyAnimateScrollScope.getFirstVisibleItemScrollOffset() <= i12)) {
                return false;
            }
        } else if (lazyAnimateScrollScope.getFirstVisibleItemIndex() >= i11 && (lazyAnimateScrollScope.getFirstVisibleItemIndex() != i11 || lazyAnimateScrollScope.getFirstVisibleItemScrollOffset() >= i12)) {
            return false;
        }
        return true;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        LazyAnimateScrollKt$animateScrollToItem$2 lazyAnimateScrollKt$animateScrollToItem$2 = new LazyAnimateScrollKt$animateScrollToItem$2(this.f2992o, this.f2993p, this.f2994q, continuation);
        lazyAnimateScrollKt$animateScrollToItem$2.L$0 = obj;
        return lazyAnimateScrollKt$animateScrollToItem$2;
    }

    @Nullable
    public final Object invoke(@NotNull ScrollScope scrollScope, @Nullable Continuation<? super Unit> continuation) {
        return ((LazyAnimateScrollKt$animateScrollToItem$2) create(scrollScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v23, resolved type: androidx.compose.foundation.gestures.ScrollScope} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00df A[Catch:{ ItemFoundInScroll -> 0x01ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e0 A[Catch:{ ItemFoundInScroll -> 0x01ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0122 A[Catch:{ ItemFoundInScroll -> 0x01ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0124 A[Catch:{ ItemFoundInScroll -> 0x01ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0127 A[Catch:{ ItemFoundInScroll -> 0x01ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x012a A[Catch:{ ItemFoundInScroll -> 0x01ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0134 A[Catch:{ ItemFoundInScroll -> 0x01ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0137 A[Catch:{ ItemFoundInScroll -> 0x01ae }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0191  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x01fc  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x01ff  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x0225 A[RETURN] */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r37) {
        /*
            r36 = this;
            r1 = r36
            java.lang.Object r2 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r0 = r1.f2991n
            r3 = 2
            r4 = 0
            r6 = 1
            if (r0 == 0) goto L_0x004d
            if (r0 == r6) goto L_0x0023
            if (r0 != r3) goto L_0x001b
            java.lang.Object r0 = r1.L$0
            androidx.compose.foundation.gestures.ScrollScope r0 = (androidx.compose.foundation.gestures.ScrollScope) r0
            kotlin.ResultKt.throwOnFailure(r37)
            r11 = r1
            goto L_0x0226
        L_0x001b:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r2)
            throw r0
        L_0x0023:
            int r0 = r1.f2990m
            float r7 = r1.f2989l
            float r8 = r1.f2988k
            java.lang.Object r9 = r1.f2987j
            kotlin.jvm.internal.Ref$IntRef r9 = (kotlin.jvm.internal.Ref.IntRef) r9
            java.lang.Object r10 = r1.f2986i
            kotlin.jvm.internal.Ref$ObjectRef r10 = (kotlin.jvm.internal.Ref.ObjectRef) r10
            java.lang.Object r11 = r1.f2985h
            kotlin.jvm.internal.Ref$BooleanRef r11 = (kotlin.jvm.internal.Ref.BooleanRef) r11
            java.lang.Object r12 = r1.L$0
            androidx.compose.foundation.gestures.ScrollScope r12 = (androidx.compose.foundation.gestures.ScrollScope) r12
            kotlin.ResultKt.throwOnFailure(r37)     // Catch:{ ItemFoundInScroll -> 0x0047 }
            r14 = r7
            r15 = r8
            r13 = r9
            r9 = r1
            r35 = r12
            r12 = r10
            r10 = r35
            goto L_0x0198
        L_0x0047:
            r0 = move-exception
            r3 = r0
            r11 = r1
            r0 = r12
            goto L_0x01c7
        L_0x004d:
            kotlin.ResultKt.throwOnFailure(r37)
            java.lang.Object r0 = r1.L$0
            r7 = r0
            androidx.compose.foundation.gestures.ScrollScope r7 = (androidx.compose.foundation.gestures.ScrollScope) r7
            int r0 = r1.f2992o
            float r8 = (float) r0
            int r8 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
            if (r8 < 0) goto L_0x005e
            r8 = r6
            goto L_0x005f
        L_0x005e:
            r8 = 0
        L_0x005f:
            if (r8 == 0) goto L_0x0232
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r0 = r1.f2993p     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            androidx.compose.ui.unit.Density r0 = r0.getDensity()     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            float r8 = androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.TargetDistance     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            float r0 = r0.m5447toPx0680j_4(r8)     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r8 = r1.f2993p     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            androidx.compose.ui.unit.Density r8 = r8.getDensity()     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            float r9 = androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt.BoundDistance     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            float r8 = r8.m5447toPx0680j_4(r9)     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            kotlin.jvm.internal.Ref$BooleanRef r9 = new kotlin.jvm.internal.Ref$BooleanRef     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            r9.<init>()     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            r9.element = r6     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            kotlin.jvm.internal.Ref$ObjectRef r10 = new kotlin.jvm.internal.Ref$ObjectRef     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            r10.<init>()     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            r11 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r17 = 0
            r18 = 30
            r19 = 0
            androidx.compose.animation.core.AnimationState r11 = androidx.compose.animation.core.AnimationStateKt.AnimationState$default(r11, r12, r13, r15, r17, r18, r19)     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            r10.element = r11     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r11 = r1.f2993p     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            int r12 = r1.f2992o     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            java.lang.Integer r11 = r11.getTargetItemOffset(r12)     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            if (r11 != 0) goto L_0x01b5
            int r11 = r1.f2992o     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r12 = r1.f2993p     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            int r12 = r12.getFirstVisibleItemIndex()     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            if (r11 <= r12) goto L_0x00b1
            r11 = r6
            goto L_0x00b2
        L_0x00b1:
            r11 = 0
        L_0x00b2:
            kotlin.jvm.internal.Ref$IntRef r12 = new kotlin.jvm.internal.Ref$IntRef     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            r12.<init>()     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            r12.element = r6     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            r15 = r0
            r14 = r8
            r0 = r11
            r13 = r12
            r11 = r9
            r12 = r10
            r9 = r1
            r10 = r7
        L_0x00c1:
            boolean r7 = r11.element     // Catch:{ ItemFoundInScroll -> 0x01ae }
            if (r7 == 0) goto L_0x022f
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r7 = r9.f2993p     // Catch:{ ItemFoundInScroll -> 0x01ae }
            int r7 = r7.getItemCount()     // Catch:{ ItemFoundInScroll -> 0x01ae }
            if (r7 <= 0) goto L_0x022f
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r7 = r9.f2993p     // Catch:{ ItemFoundInScroll -> 0x01ae }
            int r8 = r9.f2992o     // Catch:{ ItemFoundInScroll -> 0x01ae }
            int r5 = r9.f2994q     // Catch:{ ItemFoundInScroll -> 0x01ae }
            float r5 = r7.expectedDistanceTo(r8, r5)     // Catch:{ ItemFoundInScroll -> 0x01ae }
            float r7 = java.lang.Math.abs(r5)     // Catch:{ ItemFoundInScroll -> 0x01ae }
            int r7 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
            if (r7 >= 0) goto L_0x00e0
            goto L_0x00e5
        L_0x00e0:
            if (r0 == 0) goto L_0x00e4
            r5 = r15
            goto L_0x00e5
        L_0x00e4:
            float r5 = -r15
        L_0x00e5:
            T r7 = r12.element     // Catch:{ ItemFoundInScroll -> 0x01ae }
            r25 = r7
            androidx.compose.animation.core.AnimationState r25 = (androidx.compose.animation.core.AnimationState) r25     // Catch:{ ItemFoundInScroll -> 0x01ae }
            r26 = 0
            r27 = 0
            r28 = 0
            r30 = 0
            r32 = 0
            r33 = 30
            r34 = 0
            androidx.compose.animation.core.AnimationState r7 = androidx.compose.animation.core.AnimationStateKt.copy$default((androidx.compose.animation.core.AnimationState) r25, (float) r26, (float) r27, (long) r28, (long) r30, (boolean) r32, (int) r33, (java.lang.Object) r34)     // Catch:{ ItemFoundInScroll -> 0x01ae }
            r12.element = r7     // Catch:{ ItemFoundInScroll -> 0x01ae }
            kotlin.jvm.internal.Ref$FloatRef r16 = new kotlin.jvm.internal.Ref$FloatRef     // Catch:{ ItemFoundInScroll -> 0x01ae }
            r16.<init>()     // Catch:{ ItemFoundInScroll -> 0x01ae }
            T r7 = r12.element     // Catch:{ ItemFoundInScroll -> 0x01ae }
            r19 = r7
            androidx.compose.animation.core.AnimationState r19 = (androidx.compose.animation.core.AnimationState) r19     // Catch:{ ItemFoundInScroll -> 0x01ae }
            java.lang.Float r20 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)     // Catch:{ ItemFoundInScroll -> 0x01ae }
            r21 = 0
            T r7 = r12.element     // Catch:{ ItemFoundInScroll -> 0x01ae }
            androidx.compose.animation.core.AnimationState r7 = (androidx.compose.animation.core.AnimationState) r7     // Catch:{ ItemFoundInScroll -> 0x01ae }
            java.lang.Object r7 = r7.getVelocity()     // Catch:{ ItemFoundInScroll -> 0x01ae }
            java.lang.Number r7 = (java.lang.Number) r7     // Catch:{ ItemFoundInScroll -> 0x01ae }
            float r7 = r7.floatValue()     // Catch:{ ItemFoundInScroll -> 0x01ae }
            int r7 = (r7 > r4 ? 1 : (r7 == r4 ? 0 : -1))
            if (r7 != 0) goto L_0x0124
            r7 = r6
            goto L_0x0125
        L_0x0124:
            r7 = 0
        L_0x0125:
            if (r7 != 0) goto L_0x012a
            r22 = r6
            goto L_0x012c
        L_0x012a:
            r22 = 0
        L_0x012c:
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$3 r23 = new androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$3     // Catch:{ ItemFoundInScroll -> 0x01ae }
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r8 = r9.f2993p     // Catch:{ ItemFoundInScroll -> 0x01ae }
            int r7 = r9.f2992o     // Catch:{ ItemFoundInScroll -> 0x01ae }
            if (r0 == 0) goto L_0x0137
            r17 = r6
            goto L_0x0139
        L_0x0137:
            r17 = 0
        L_0x0139:
            int r3 = r9.f2994q     // Catch:{ ItemFoundInScroll -> 0x01ae }
            r18 = r7
            r7 = r23
            r4 = r9
            r9 = r18
            r37 = r10
            r10 = r5
            r5 = r11
            r11 = r16
            r27 = r12
            r12 = r37
            r28 = r13
            r13 = r5
            r29 = r14
            r14 = r17
            r6 = r15
            r15 = r29
            r16 = r28
            r17 = r3
            r18 = r27
            r7.<init>(r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)     // Catch:{ ItemFoundInScroll -> 0x01aa }
            r3 = 2
            r7 = 0
            r8 = r37
            r4.L$0 = r8     // Catch:{ ItemFoundInScroll -> 0x01a8 }
            r4.f2985h = r5     // Catch:{ ItemFoundInScroll -> 0x01a8 }
            r10 = r27
            r4.f2986i = r10     // Catch:{ ItemFoundInScroll -> 0x01a8 }
            r12 = r28
            r4.f2987j = r12     // Catch:{ ItemFoundInScroll -> 0x01a8 }
            r4.f2988k = r6     // Catch:{ ItemFoundInScroll -> 0x01a8 }
            r9 = r29
            r4.f2989l = r9     // Catch:{ ItemFoundInScroll -> 0x01a8 }
            r4.f2990m = r0     // Catch:{ ItemFoundInScroll -> 0x01a8 }
            r11 = 1
            r4.f2991n = r11     // Catch:{ ItemFoundInScroll -> 0x01a8 }
            r16 = r19
            r17 = r20
            r18 = r21
            r19 = r22
            r20 = r23
            r21 = r4
            r22 = r3
            r23 = r7
            java.lang.Object r3 = androidx.compose.animation.core.SuspendAnimationKt.animateTo$default(r16, r17, r18, r19, r20, r21, r22, r23)     // Catch:{ ItemFoundInScroll -> 0x01a8 }
            if (r3 != r2) goto L_0x0191
            return r2
        L_0x0191:
            r11 = r5
            r15 = r6
            r14 = r9
            r13 = r12
            r9 = r4
            r12 = r10
            r10 = r8
        L_0x0198:
            int r3 = r13.element     // Catch:{ ItemFoundInScroll -> 0x01a3 }
            r4 = 1
            int r3 = r3 + r4
            r13.element = r3     // Catch:{ ItemFoundInScroll -> 0x01a3 }
            r3 = 2
            r4 = 0
            r6 = 1
            goto L_0x00c1
        L_0x01a3:
            r0 = move-exception
            r3 = r0
            r11 = r9
            r0 = r10
            goto L_0x01c7
        L_0x01a8:
            r0 = move-exception
            goto L_0x01b1
        L_0x01aa:
            r0 = move-exception
            r8 = r37
            goto L_0x01b1
        L_0x01ae:
            r0 = move-exception
            r4 = r9
            r8 = r10
        L_0x01b1:
            r3 = r0
            r11 = r4
            r0 = r8
            goto L_0x01c7
        L_0x01b5:
            androidx.compose.foundation.lazy.layout.ItemFoundInScroll r0 = new androidx.compose.foundation.lazy.layout.ItemFoundInScroll     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            int r3 = r11.intValue()     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            T r4 = r10.element     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            androidx.compose.animation.core.AnimationState r4 = (androidx.compose.animation.core.AnimationState) r4     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            r0.<init>(r3, r4)     // Catch:{ ItemFoundInScroll -> 0x01c3 }
            throw r0     // Catch:{ ItemFoundInScroll -> 0x01c3 }
        L_0x01c3:
            r0 = move-exception
            r3 = r0
            r11 = r1
            r0 = r7
        L_0x01c7:
            androidx.compose.animation.core.AnimationState r12 = r3.getPreviousAnimation()
            r13 = 0
            r14 = 0
            r15 = 0
            r17 = 0
            r19 = 0
            r20 = 30
            r21 = 0
            androidx.compose.animation.core.AnimationState r4 = androidx.compose.animation.core.AnimationStateKt.copy$default((androidx.compose.animation.core.AnimationState) r12, (float) r13, (float) r14, (long) r15, (long) r17, (boolean) r19, (int) r20, (java.lang.Object) r21)
            int r3 = r3.getItemOffset()
            int r5 = r11.f2994q
            int r3 = r3 + r5
            float r3 = (float) r3
            kotlin.jvm.internal.Ref$FloatRef r5 = new kotlin.jvm.internal.Ref$FloatRef
            r5.<init>()
            java.lang.Float r6 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r3)
            r7 = 0
            java.lang.Object r8 = r4.getVelocity()
            java.lang.Number r8 = (java.lang.Number) r8
            float r8 = r8.floatValue()
            r9 = 0
            int r8 = (r8 > r9 ? 1 : (r8 == r9 ? 0 : -1))
            if (r8 != 0) goto L_0x01ff
            r24 = 1
            goto L_0x0201
        L_0x01ff:
            r24 = 0
        L_0x0201:
            r8 = 1
            r8 = r24 ^ 1
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$5 r9 = new androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2$5
            r9.<init>(r3, r5, r0)
            r10 = 2
            r12 = 0
            r11.L$0 = r0
            r3 = 0
            r11.f2985h = r3
            r11.f2986i = r3
            r11.f2987j = r3
            r3 = 2
            r11.f2991n = r3
            r3 = r4
            r4 = r6
            r5 = r7
            r6 = r8
            r7 = r9
            r8 = r11
            r9 = r10
            r10 = r12
            java.lang.Object r3 = androidx.compose.animation.core.SuspendAnimationKt.animateTo$default(r3, r4, r5, r6, r7, r8, r9, r10)
            if (r3 != r2) goto L_0x0226
            return r2
        L_0x0226:
            androidx.compose.foundation.lazy.layout.LazyAnimateScrollScope r2 = r11.f2993p
            int r3 = r11.f2992o
            int r4 = r11.f2994q
            r2.snapToItem(r0, r3, r4)
        L_0x022f:
            kotlin.Unit r0 = kotlin.Unit.INSTANCE
            return r0
        L_0x0232:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Index should be non-negative ("
            r2.append(r3)
            r2.append(r0)
            r0 = 41
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.IllegalArgumentException r2 = new java.lang.IllegalArgumentException
            java.lang.String r0 = r0.toString()
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.layout.LazyAnimateScrollKt$animateScrollToItem$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
