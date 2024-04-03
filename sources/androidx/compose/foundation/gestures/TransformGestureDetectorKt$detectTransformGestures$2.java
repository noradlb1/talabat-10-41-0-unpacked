package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2", f = "TransformGestureDetector.kt", i = {}, l = {52}, m = "invokeSuspend", n = {}, s = {})
public final class TransformGestureDetectorKt$detectTransformGestures$2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f2288h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f2289i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function4<Offset, Offset, Float, Float, Unit> f2290j;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2$1", f = "TransformGestureDetector.kt", i = {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {60, 62}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom", "$this$awaitPointerEventScope", "rotation", "zoom", "pan", "pastTouchSlop", "touchSlop", "lockedToPanZoom"}, s = {"L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1", "L$0", "F$0", "F$1", "J$0", "I$0", "F$2", "I$1"})
    /* renamed from: androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public float f2291h;

        /* renamed from: i  reason: collision with root package name */
        public float f2292i;

        /* renamed from: j  reason: collision with root package name */
        public float f2293j;

        /* renamed from: k  reason: collision with root package name */
        public long f2294k;

        /* renamed from: l  reason: collision with root package name */
        public int f2295l;

        /* renamed from: m  reason: collision with root package name */
        public int f2296m;

        /* renamed from: n  reason: collision with root package name */
        public int f2297n;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(z11, function4, continuation);
            r02.L$0 = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v3, resolved type: androidx.compose.ui.input.pointer.AwaitPointerEventScope} */
        /* JADX WARNING: Code restructure failed: missing block: B:57:0x013a, code lost:
            if (androidx.compose.ui.geometry.Offset.m2673equalsimpl0(r6, androidx.compose.ui.geometry.Offset.Companion.m2692getZeroF1C5BW0()) != false) goto L_0x0151;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0090 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x009e  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00b2  */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x016e  */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x0176  */
        /* JADX WARNING: Removed duplicated region for block: B:80:0x00af A[SYNTHETIC] */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r24) {
            /*
                r23 = this;
                r0 = r23
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.f2297n
                r3 = 1065353216(0x3f800000, float:1.0)
                r4 = 2
                r5 = 0
                r6 = 0
                r7 = 1
                if (r2 == 0) goto L_0x0047
                if (r2 == r7) goto L_0x0033
                if (r2 != r4) goto L_0x002b
                int r2 = r0.f2296m
                float r8 = r0.f2293j
                int r9 = r0.f2295l
                long r10 = r0.f2294k
                float r12 = r0.f2292i
                float r13 = r0.f2291h
                java.lang.Object r14 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r14 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r14
                kotlin.ResultKt.throwOnFailure(r24)
                r4 = r24
                r15 = r0
                goto L_0x0091
            L_0x002b:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0033:
                int r2 = r0.f2296m
                float r8 = r0.f2293j
                int r9 = r0.f2295l
                long r10 = r0.f2294k
                float r12 = r0.f2292i
                float r13 = r0.f2291h
                java.lang.Object r14 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r14 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r14
                kotlin.ResultKt.throwOnFailure(r24)
                goto L_0x0078
            L_0x0047:
                kotlin.ResultKt.throwOnFailure(r24)
                java.lang.Object r2 = r0.L$0
                r14 = r2
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r14 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r14
                androidx.compose.ui.geometry.Offset$Companion r2 = androidx.compose.ui.geometry.Offset.Companion
                long r10 = r2.m2692getZeroF1C5BW0()
                androidx.compose.ui.platform.ViewConfiguration r2 = r14.getViewConfiguration()
                float r8 = r2.getTouchSlop()
                r0.L$0 = r14
                r0.f2291h = r5
                r0.f2292i = r3
                r0.f2294k = r10
                r0.f2295l = r6
                r0.f2293j = r8
                r0.f2296m = r6
                r0.f2297n = r7
                java.lang.Object r2 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(r14, r6, r0)
                if (r2 != r1) goto L_0x0074
                return r1
            L_0x0074:
                r12 = r3
                r13 = r5
                r2 = r6
                r9 = r2
            L_0x0078:
                r15 = r0
            L_0x0079:
                r15.L$0 = r14
                r15.f2291h = r13
                r15.f2292i = r12
                r15.f2294k = r10
                r15.f2295l = r9
                r15.f2293j = r8
                r15.f2296m = r2
                r15.f2297n = r4
                r4 = 0
                java.lang.Object r4 = i0.b.t(r14, r4, r15, r7, r4)
                if (r4 != r1) goto L_0x0091
                return r1
            L_0x0091:
                androidx.compose.ui.input.pointer.PointerEvent r4 = (androidx.compose.ui.input.pointer.PointerEvent) r4
                java.util.List r3 = r4.getChanges()
                int r5 = r3.size()
                r7 = r6
            L_0x009c:
                if (r7 >= r5) goto L_0x00af
                java.lang.Object r19 = r3.get(r7)
                androidx.compose.ui.input.pointer.PointerInputChange r19 = (androidx.compose.ui.input.pointer.PointerInputChange) r19
                boolean r19 = r19.isConsumed()
                if (r19 == 0) goto L_0x00ac
                r3 = 1
                goto L_0x00b0
            L_0x00ac:
                int r7 = r7 + 1
                goto L_0x009c
            L_0x00af:
                r3 = r6
            L_0x00b0:
                if (r3 != 0) goto L_0x016e
                float r5 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateZoom(r4)
                float r7 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateRotation(r4)
                r24 = r7
                long r6 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculatePan(r4)
                if (r9 != 0) goto L_0x0105
                float r12 = r12 * r5
                float r13 = r13 + r24
                long r10 = androidx.compose.ui.geometry.Offset.m2681plusMKHz9U(r10, r6)
                r0 = 0
                float r20 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateCentroidSize(r4, r0)
                r18 = r1
                r0 = 1
                float r1 = (float) r0
                float r1 = r1 - r12
                float r1 = java.lang.Math.abs(r1)
                float r1 = r1 * r20
                r21 = 1078530011(0x40490fdb, float:3.1415927)
                float r21 = r21 * r13
                float r21 = r21 * r20
                r20 = 1127481344(0x43340000, float:180.0)
                float r21 = r21 / r20
                float r20 = java.lang.Math.abs(r21)
                float r21 = androidx.compose.ui.geometry.Offset.m2674getDistanceimpl(r10)
                int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
                if (r1 > 0) goto L_0x00f8
                int r1 = (r20 > r8 ? 1 : (r20 == r8 ? 0 : -1))
                if (r1 > 0) goto L_0x00f8
                int r1 = (r21 > r8 ? 1 : (r21 == r8 ? 0 : -1))
                if (r1 <= 0) goto L_0x0108
            L_0x00f8:
                boolean r1 = r3
                if (r1 == 0) goto L_0x0102
                int r1 = (r20 > r8 ? 1 : (r20 == r8 ? 0 : -1))
                if (r1 >= 0) goto L_0x0102
                r2 = r0
                goto L_0x0103
            L_0x0102:
                r2 = 0
            L_0x0103:
                r9 = r0
                goto L_0x0108
            L_0x0105:
                r18 = r1
                r0 = 1
            L_0x0108:
                if (r9 == 0) goto L_0x0170
                r1 = 0
                long r19 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateCentroid(r4, r1)
                if (r2 == 0) goto L_0x0114
                r17 = 0
                goto L_0x0116
            L_0x0114:
                r17 = r24
            L_0x0116:
                r21 = 0
                int r22 = (r17 > r21 ? 1 : (r17 == r21 ? 0 : -1))
                if (r22 != 0) goto L_0x011f
                r22 = r0
                goto L_0x0121
            L_0x011f:
                r22 = r1
            L_0x0121:
                r16 = 1065353216(0x3f800000, float:1.0)
                if (r22 == 0) goto L_0x013c
                int r22 = (r5 > r16 ? 1 : (r5 == r16 ? 0 : -1))
                if (r22 != 0) goto L_0x012c
                r22 = r0
                goto L_0x012e
            L_0x012c:
                r22 = r1
            L_0x012e:
                if (r22 == 0) goto L_0x013c
                androidx.compose.ui.geometry.Offset$Companion r22 = androidx.compose.ui.geometry.Offset.Companion
                long r0 = r22.m2692getZeroF1C5BW0()
                boolean r0 = androidx.compose.ui.geometry.Offset.m2673equalsimpl0(r6, r0)
                if (r0 != 0) goto L_0x0151
            L_0x013c:
                kotlin.jvm.functions.Function4<androidx.compose.ui.geometry.Offset, androidx.compose.ui.geometry.Offset, java.lang.Float, java.lang.Float, kotlin.Unit> r0 = r4
                androidx.compose.ui.geometry.Offset r1 = androidx.compose.ui.geometry.Offset.m2665boximpl(r19)
                androidx.compose.ui.geometry.Offset r6 = androidx.compose.ui.geometry.Offset.m2665boximpl(r6)
                java.lang.Float r5 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r5)
                java.lang.Float r7 = kotlin.coroutines.jvm.internal.Boxing.boxFloat(r17)
                r0.invoke(r1, r6, r5, r7)
            L_0x0151:
                java.util.List r0 = r4.getChanges()
                int r1 = r0.size()
                r5 = 0
            L_0x015a:
                if (r5 >= r1) goto L_0x0174
                java.lang.Object r6 = r0.get(r5)
                androidx.compose.ui.input.pointer.PointerInputChange r6 = (androidx.compose.ui.input.pointer.PointerInputChange) r6
                boolean r7 = androidx.compose.ui.input.pointer.PointerEventKt.positionChanged(r6)
                if (r7 == 0) goto L_0x016b
                r6.consume()
            L_0x016b:
                int r5 = r5 + 1
                goto L_0x015a
            L_0x016e:
                r18 = r1
            L_0x0170:
                r16 = 1065353216(0x3f800000, float:1.0)
                r21 = 0
            L_0x0174:
                if (r3 != 0) goto L_0x01a3
                java.util.List r0 = r4.getChanges()
                int r1 = r0.size()
                r3 = 0
            L_0x017f:
                if (r3 >= r1) goto L_0x0192
                java.lang.Object r4 = r0.get(r3)
                androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
                boolean r4 = r4.getPressed()
                if (r4 == 0) goto L_0x018f
                r0 = 1
                goto L_0x0193
            L_0x018f:
                int r3 = r3 + 1
                goto L_0x017f
            L_0x0192:
                r0 = 0
            L_0x0193:
                if (r0 != 0) goto L_0x0196
                goto L_0x01a3
            L_0x0196:
                r0 = r23
                r3 = r16
                r1 = r18
                r5 = r21
                r4 = 2
                r6 = 0
                r7 = 1
                goto L_0x0079
            L_0x01a3:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransformGestureDetectorKt$detectTransformGestures$2(boolean z11, Function4<? super Offset, ? super Offset, ? super Float, ? super Float, Unit> function4, Continuation<? super TransformGestureDetectorKt$detectTransformGestures$2> continuation) {
        super(2, continuation);
        this.f2289i = z11;
        this.f2290j = function4;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TransformGestureDetectorKt$detectTransformGestures$2 transformGestureDetectorKt$detectTransformGestures$2 = new TransformGestureDetectorKt$detectTransformGestures$2(this.f2289i, this.f2290j, continuation);
        transformGestureDetectorKt$detectTransformGestures$2.L$0 = obj;
        return transformGestureDetectorKt$detectTransformGestures$2;
    }

    @Nullable
    public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TransformGestureDetectorKt$detectTransformGestures$2) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f2288h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final boolean z11 = this.f2289i;
            final Function4<Offset, Offset, Float, Float, Unit> function4 = this.f2290j;
            AnonymousClass1 r12 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.f2288h = 1;
            if (((PointerInputScope) this.L$0).awaitPointerEventScope(r12, this) == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else if (i11 == 1) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
