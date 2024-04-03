package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
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
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/foundation/gestures/TransformScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt$detectZoom$3", f = "Transformable.kt", i = {}, l = {103}, m = "invokeSuspend", n = {}, s = {})
public final class TransformableKt$detectZoom$3 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f2320h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PointerInputScope f2321i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f2322j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f2323k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f2324l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f2325m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ float f2326n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Ref.BooleanRef f2327o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ State<Boolean> f2328p;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableKt$detectZoom$3$1", f = "Transformable.kt", i = {0}, l = {105}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope"}, s = {"L$0"})
    /* renamed from: androidx.compose.foundation.gestures.TransformableKt$detectZoom$3$1  reason: invalid class name */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f2329h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(booleanRef, floatRef, floatRef2, longRef, f11, booleanRef2, state, transformScope, continuation);
            r02.L$0 = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:49:0x0100, code lost:
            if (androidx.compose.ui.geometry.Offset.m2673equalsimpl0(r10, androidx.compose.ui.geometry.Offset.Companion.m2692getZeroF1C5BW0()) != false) goto L_0x0107;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:64:0x0142, code lost:
            if (r8 == false) goto L_0x0144;
         */
        /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x0056  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x0126  */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x0053 A[SYNTHETIC] */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r17) {
            /*
                r16 = this;
                r0 = r16
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.f2329h
                r3 = 1
                if (r2 == 0) goto L_0x0020
                if (r2 != r3) goto L_0x0018
                java.lang.Object r2 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                kotlin.ResultKt.throwOnFailure(r17)
                r5 = r17
                r4 = r0
                goto L_0x0034
            L_0x0018:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0020:
                kotlin.ResultKt.throwOnFailure(r17)
                java.lang.Object r2 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                r4 = r0
            L_0x0028:
                r4.L$0 = r2
                r4.f2329h = r3
                r5 = 0
                java.lang.Object r5 = i0.b.t(r2, r5, r4, r3, r5)
                if (r5 != r1) goto L_0x0034
                return r1
            L_0x0034:
                androidx.compose.ui.input.pointer.PointerEvent r5 = (androidx.compose.ui.input.pointer.PointerEvent) r5
                java.util.List r6 = r5.getChanges()
                int r7 = r6.size()
                r8 = 0
                r9 = r8
            L_0x0040:
                if (r9 >= r7) goto L_0x0053
                java.lang.Object r10 = r6.get(r9)
                androidx.compose.ui.input.pointer.PointerInputChange r10 = (androidx.compose.ui.input.pointer.PointerInputChange) r10
                boolean r10 = r10.isConsumed()
                if (r10 == 0) goto L_0x0050
                r6 = r3
                goto L_0x0054
            L_0x0050:
                int r9 = r9 + 1
                goto L_0x0040
            L_0x0053:
                r6 = r8
            L_0x0054:
                if (r6 != 0) goto L_0x0124
                float r7 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateZoom(r5)
                float r9 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateRotation(r5)
                long r10 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculatePan(r5)
                kotlin.jvm.internal.Ref$BooleanRef r12 = r4
                boolean r12 = r12.element
                if (r12 != 0) goto L_0x00d4
                kotlin.jvm.internal.Ref$FloatRef r12 = r5
                float r13 = r12.element
                float r13 = r13 * r7
                r12.element = r13
                kotlin.jvm.internal.Ref$FloatRef r12 = r6
                float r13 = r12.element
                float r13 = r13 + r9
                r12.element = r13
                kotlin.jvm.internal.Ref$LongRef r12 = r7
                long r13 = r12.element
                long r13 = androidx.compose.ui.geometry.Offset.m2681plusMKHz9U(r13, r10)
                r12.element = r13
                float r12 = androidx.compose.foundation.gestures.TransformGestureDetectorKt.calculateCentroidSize(r5, r8)
                float r13 = (float) r3
                kotlin.jvm.internal.Ref$FloatRef r14 = r5
                float r14 = r14.element
                float r13 = r13 - r14
                float r13 = java.lang.Math.abs(r13)
                float r13 = r13 * r12
                kotlin.jvm.internal.Ref$FloatRef r14 = r6
                float r14 = r14.element
                r15 = 1078530011(0x40490fdb, float:3.1415927)
                float r14 = r14 * r15
                float r14 = r14 * r12
                r12 = 1127481344(0x43340000, float:180.0)
                float r14 = r14 / r12
                float r12 = java.lang.Math.abs(r14)
                kotlin.jvm.internal.Ref$LongRef r14 = r7
                long r14 = r14.element
                float r14 = androidx.compose.ui.geometry.Offset.m2674getDistanceimpl(r14)
                float r15 = r8
                int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
                if (r13 > 0) goto L_0x00b5
                int r13 = (r12 > r15 ? 1 : (r12 == r15 ? 0 : -1))
                if (r13 > 0) goto L_0x00b5
                int r13 = (r14 > r15 ? 1 : (r14 == r15 ? 0 : -1))
                if (r13 <= 0) goto L_0x00d4
            L_0x00b5:
                kotlin.jvm.internal.Ref$BooleanRef r13 = r4
                r13.element = r3
                kotlin.jvm.internal.Ref$BooleanRef r13 = r9
                androidx.compose.runtime.State<java.lang.Boolean> r14 = r10
                java.lang.Object r14 = r14.getValue()
                java.lang.Boolean r14 = (java.lang.Boolean) r14
                boolean r14 = r14.booleanValue()
                if (r14 == 0) goto L_0x00d1
                float r14 = r8
                int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                if (r12 >= 0) goto L_0x00d1
                r12 = r3
                goto L_0x00d2
            L_0x00d1:
                r12 = r8
            L_0x00d2:
                r13.element = r12
            L_0x00d4:
                kotlin.jvm.internal.Ref$BooleanRef r12 = r4
                boolean r12 = r12.element
                if (r12 == 0) goto L_0x0124
                kotlin.jvm.internal.Ref$BooleanRef r12 = r9
                boolean r12 = r12.element
                r13 = 0
                if (r12 == 0) goto L_0x00e2
                r9 = r13
            L_0x00e2:
                int r12 = (r9 > r13 ? 1 : (r9 == r13 ? 0 : -1))
                if (r12 != 0) goto L_0x00e8
                r12 = r3
                goto L_0x00e9
            L_0x00e8:
                r12 = r8
            L_0x00e9:
                if (r12 == 0) goto L_0x0102
                r12 = 1065353216(0x3f800000, float:1.0)
                int r12 = (r7 > r12 ? 1 : (r7 == r12 ? 0 : -1))
                if (r12 != 0) goto L_0x00f3
                r12 = r3
                goto L_0x00f4
            L_0x00f3:
                r12 = r8
            L_0x00f4:
                if (r12 == 0) goto L_0x0102
                androidx.compose.ui.geometry.Offset$Companion r12 = androidx.compose.ui.geometry.Offset.Companion
                long r12 = r12.m2692getZeroF1C5BW0()
                boolean r12 = androidx.compose.ui.geometry.Offset.m2673equalsimpl0(r10, r12)
                if (r12 != 0) goto L_0x0107
            L_0x0102:
                androidx.compose.foundation.gestures.TransformScope r12 = r11
                r12.m361transformByd4ec7I(r7, r10, r9)
            L_0x0107:
                java.util.List r7 = r5.getChanges()
                int r9 = r7.size()
                r10 = r8
            L_0x0110:
                if (r10 >= r9) goto L_0x0124
                java.lang.Object r11 = r7.get(r10)
                androidx.compose.ui.input.pointer.PointerInputChange r11 = (androidx.compose.ui.input.pointer.PointerInputChange) r11
                boolean r12 = androidx.compose.ui.input.pointer.PointerEventKt.positionChanged(r11)
                if (r12 == 0) goto L_0x0121
                r11.consume()
            L_0x0121:
                int r10 = r10 + 1
                goto L_0x0110
            L_0x0124:
                if (r6 != 0) goto L_0x0144
                java.util.List r5 = r5.getChanges()
                int r6 = r5.size()
                r7 = r8
            L_0x012f:
                if (r7 >= r6) goto L_0x0142
                java.lang.Object r9 = r5.get(r7)
                androidx.compose.ui.input.pointer.PointerInputChange r9 = (androidx.compose.ui.input.pointer.PointerInputChange) r9
                boolean r9 = r9.getPressed()
                if (r9 == 0) goto L_0x013f
                r8 = r3
                goto L_0x0142
            L_0x013f:
                int r7 = r7 + 1
                goto L_0x012f
            L_0x0142:
                if (r8 != 0) goto L_0x0028
            L_0x0144:
                kotlin.Unit r1 = kotlin.Unit.INSTANCE
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformableKt$detectZoom$3.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TransformableKt$detectZoom$3(PointerInputScope pointerInputScope, Ref.BooleanRef booleanRef, Ref.FloatRef floatRef, Ref.FloatRef floatRef2, Ref.LongRef longRef, float f11, Ref.BooleanRef booleanRef2, State<Boolean> state, Continuation<? super TransformableKt$detectZoom$3> continuation) {
        super(2, continuation);
        this.f2321i = pointerInputScope;
        this.f2322j = booleanRef;
        this.f2323k = floatRef;
        this.f2324l = floatRef2;
        this.f2325m = longRef;
        this.f2326n = f11;
        this.f2327o = booleanRef2;
        this.f2328p = state;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        TransformableKt$detectZoom$3 transformableKt$detectZoom$3 = new TransformableKt$detectZoom$3(this.f2321i, this.f2322j, this.f2323k, this.f2324l, this.f2325m, this.f2326n, this.f2327o, this.f2328p, continuation);
        transformableKt$detectZoom$3.L$0 = obj;
        return transformableKt$detectZoom$3;
    }

    @Nullable
    public final Object invoke(@NotNull TransformScope transformScope, @Nullable Continuation<? super Unit> continuation) {
        return ((TransformableKt$detectZoom$3) create(transformScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f2320h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final TransformScope transformScope = (TransformScope) this.L$0;
            PointerInputScope pointerInputScope = this.f2321i;
            final Ref.BooleanRef booleanRef = this.f2322j;
            final Ref.FloatRef floatRef = this.f2323k;
            final Ref.FloatRef floatRef2 = this.f2324l;
            final Ref.LongRef longRef = this.f2325m;
            final float f11 = this.f2326n;
            final Ref.BooleanRef booleanRef2 = this.f2327o;
            final State<Boolean> state = this.f2328p;
            AnonymousClass1 r32 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.f2320h = 1;
            if (pointerInputScope.awaitPointerEventScope(r32, this) == coroutine_suspended) {
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
