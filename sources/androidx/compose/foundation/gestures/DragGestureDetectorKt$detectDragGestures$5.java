package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5", f = "DragGestureDetector.kt", i = {}, l = {176}, m = "invokeSuspend", n = {}, s = {})
public final class DragGestureDetectorKt$detectDragGestures$5 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f1944h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Function1<Offset, Unit> f1945i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function2<PointerInputChange, Offset, Unit> f1946j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f1947k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function0<Unit> f1948l;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/ui/input/pointer/AwaitPointerEventScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$1", f = "DragGestureDetector.kt", i = {0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {177, 898, 948, 194}, m = "invokeSuspend", n = {"$this$awaitPointerEventScope", "$this$awaitPointerEventScope", "down", "overSlop", "$this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv", "pointerDirectionConfig$iv", "pointer$iv", "triggerOnMainAxisSlop$iv", "touchSlop$iv", "totalMainPositionChange$iv", "totalCrossPositionChange$iv", "$this$awaitPointerEventScope", "down", "overSlop", "$this$awaitPointerSlopOrCancellation_u2dwtdNQyU_u24default$iv", "pointerDirectionConfig$iv", "pointer$iv", "dragEvent$iv", "triggerOnMainAxisSlop$iv", "touchSlop$iv", "totalMainPositionChange$iv", "totalCrossPositionChange$iv"}, s = {"L$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "F$0", "F$1", "F$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0", "F$0", "F$1", "F$2"})
    /* renamed from: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$1  reason: invalid class name */
    public static final class AnonymousClass1 extends RestrictedSuspendLambda implements Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public Object f1949h;

        /* renamed from: i  reason: collision with root package name */
        public Object f1950i;

        /* renamed from: j  reason: collision with root package name */
        public Object f1951j;

        /* renamed from: k  reason: collision with root package name */
        public Object f1952k;

        /* renamed from: l  reason: collision with root package name */
        public Object f1953l;

        /* renamed from: m  reason: collision with root package name */
        public Object f1954m;

        /* renamed from: n  reason: collision with root package name */
        public int f1955n;

        /* renamed from: o  reason: collision with root package name */
        public float f1956o;

        /* renamed from: p  reason: collision with root package name */
        public float f1957p;

        /* renamed from: q  reason: collision with root package name */
        public float f1958q;

        /* renamed from: r  reason: collision with root package name */
        public int f1959r;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(function1, function2, function0, function02, continuation);
            r02.L$0 = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(awaitPointerEventScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v2, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v7, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v9, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v10, resolved type: androidx.compose.ui.input.pointer.PointerInputChange} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v11, resolved type: androidx.compose.ui.input.pointer.PointerEventPass} */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x0113 A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x0121  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x016a  */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x019d  */
        /* JADX WARNING: Removed duplicated region for block: B:71:0x0256  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x025d  */
        /* JADX WARNING: Removed duplicated region for block: B:78:0x02a3  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x02a9  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x0149 A[SYNTHETIC] */
        @org.jetbrains.annotations.Nullable
        public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r23) {
            /*
                r22 = this;
                r0 = r22
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.f1959r
                r3 = 4
                r4 = 3
                r5 = 2
                r7 = 0
                r8 = 1
                r9 = 0
                if (r2 == 0) goto L_0x00a0
                if (r2 == r8) goto L_0x0096
                if (r2 == r5) goto L_0x0061
                if (r2 == r4) goto L_0x0028
                if (r2 != r3) goto L_0x0020
                kotlin.ResultKt.throwOnFailure(r23)
                r5 = r0
                r0 = r23
                goto L_0x029b
            L_0x0020:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0028:
                float r2 = r0.f1958q
                float r10 = r0.f1957p
                float r11 = r0.f1956o
                int r12 = r0.f1955n
                java.lang.Object r13 = r0.f1954m
                androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                java.lang.Object r14 = r0.f1953l
                kotlin.jvm.internal.Ref$LongRef r14 = (kotlin.jvm.internal.Ref.LongRef) r14
                java.lang.Object r15 = r0.f1952k
                androidx.compose.foundation.gestures.PointerDirectionConfig r15 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r15
                java.lang.Object r6 = r0.f1951j
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r6 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r6
                java.lang.Object r3 = r0.f1950i
                kotlin.jvm.internal.Ref$LongRef r3 = (kotlin.jvm.internal.Ref.LongRef) r3
                java.lang.Object r4 = r0.f1949h
                androidx.compose.ui.input.pointer.PointerInputChange r4 = (androidx.compose.ui.input.pointer.PointerInputChange) r4
                java.lang.Object r5 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r5 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r5
                kotlin.ResultKt.throwOnFailure(r23)
                r7 = 3
                r20 = r11
                r11 = r0
                r0 = r12
                r12 = r20
                r21 = r4
                r4 = r2
                r2 = r6
                r6 = r10
                r10 = r3
                r3 = r5
                r5 = r21
                goto L_0x0201
            L_0x0061:
                float r2 = r0.f1958q
                float r3 = r0.f1957p
                float r4 = r0.f1956o
                int r5 = r0.f1955n
                java.lang.Object r6 = r0.f1953l
                kotlin.jvm.internal.Ref$LongRef r6 = (kotlin.jvm.internal.Ref.LongRef) r6
                java.lang.Object r10 = r0.f1952k
                androidx.compose.foundation.gestures.PointerDirectionConfig r10 = (androidx.compose.foundation.gestures.PointerDirectionConfig) r10
                java.lang.Object r11 = r0.f1951j
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r11 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r11
                java.lang.Object r12 = r0.f1950i
                kotlin.jvm.internal.Ref$LongRef r12 = (kotlin.jvm.internal.Ref.LongRef) r12
                java.lang.Object r13 = r0.f1949h
                androidx.compose.ui.input.pointer.PointerInputChange r13 = (androidx.compose.ui.input.pointer.PointerInputChange) r13
                java.lang.Object r14 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r14 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r14
                kotlin.ResultKt.throwOnFailure(r23)
                r7 = r23
                r15 = r5
                r5 = r13
                r13 = r10
                r10 = r12
                r12 = r4
                r4 = r2
                r2 = r11
                r11 = r0
                r20 = r6
                r6 = r3
                r3 = r14
                r14 = r20
                goto L_0x0114
            L_0x0096:
                java.lang.Object r2 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                kotlin.ResultKt.throwOnFailure(r23)
                r3 = r23
                goto L_0x00b2
            L_0x00a0:
                kotlin.ResultKt.throwOnFailure(r23)
                java.lang.Object r2 = r0.L$0
                androidx.compose.ui.input.pointer.AwaitPointerEventScope r2 = (androidx.compose.ui.input.pointer.AwaitPointerEventScope) r2
                r0.L$0 = r2
                r0.f1959r = r8
                java.lang.Object r3 = androidx.compose.foundation.gestures.TapGestureDetectorKt.awaitFirstDown(r2, r7, r0)
                if (r3 != r1) goto L_0x00b2
                return r1
            L_0x00b2:
                androidx.compose.ui.input.pointer.PointerInputChange r3 = (androidx.compose.ui.input.pointer.PointerInputChange) r3
                kotlin.jvm.internal.Ref$LongRef r4 = new kotlin.jvm.internal.Ref$LongRef
                r4.<init>()
                androidx.compose.ui.geometry.Offset$Companion r5 = androidx.compose.ui.geometry.Offset.Companion
                long r5 = r5.m2692getZeroF1C5BW0()
                r4.element = r5
                r5 = r0
            L_0x00c2:
                long r10 = r3.m4305getIdJ3iCeTQ()
                int r6 = r3.m4309getTypeT8wyACA()
                androidx.compose.foundation.gestures.PointerDirectionConfig r12 = androidx.compose.foundation.gestures.DragGestureDetectorKt.getHorizontalPointerDirectionConfig()
                androidx.compose.ui.input.pointer.PointerEvent r13 = r2.getCurrentEvent()
                boolean r13 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m286isPointerUpDmW0f2w(r13, r10)
                if (r13 == 0) goto L_0x00db
                r0 = r9
                goto L_0x024d
            L_0x00db:
                androidx.compose.ui.platform.ViewConfiguration r13 = r2.getViewConfiguration()
                float r6 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m287pointerSlopE8SPZFQ(r13, r6)
                kotlin.jvm.internal.Ref$LongRef r13 = new kotlin.jvm.internal.Ref$LongRef
                r13.<init>()
                r13.element = r10
                r10 = r4
                r11 = r5
                r15 = r7
                r14 = r13
                r4 = 0
                r5 = r3
                r13 = r12
                r3 = r2
                r12 = r6
                r6 = 0
            L_0x00f4:
                r11.L$0 = r3
                r11.f1949h = r5
                r11.f1950i = r10
                r11.f1951j = r2
                r11.f1952k = r13
                r11.f1953l = r14
                r11.f1954m = r9
                r11.f1955n = r15
                r11.f1956o = r12
                r11.f1957p = r6
                r11.f1958q = r4
                r7 = 2
                r11.f1959r = r7
                java.lang.Object r7 = i0.b.t(r2, r9, r11, r8, r9)
                if (r7 != r1) goto L_0x0114
                return r1
            L_0x0114:
                androidx.compose.ui.input.pointer.PointerEvent r7 = (androidx.compose.ui.input.pointer.PointerEvent) r7
                java.util.List r8 = r7.getChanges()
                int r9 = r8.size()
                r0 = 0
            L_0x011f:
                if (r0 >= r9) goto L_0x0149
                java.lang.Object r16 = r8.get(r0)
                r17 = r16
                androidx.compose.ui.input.pointer.PointerInputChange r17 = (androidx.compose.ui.input.pointer.PointerInputChange) r17
                r23 = r8
                r18 = r9
                long r8 = r17.m4305getIdJ3iCeTQ()
                r17 = r1
                r19 = r2
                long r1 = r14.element
                boolean r1 = androidx.compose.ui.input.pointer.PointerId.m4291equalsimpl0(r8, r1)
                if (r1 == 0) goto L_0x013e
                goto L_0x014f
            L_0x013e:
                int r0 = r0 + 1
                r8 = r23
                r1 = r17
                r9 = r18
                r2 = r19
                goto L_0x011f
            L_0x0149:
                r17 = r1
                r19 = r2
                r16 = 0
            L_0x014f:
                r0 = r16
                androidx.compose.ui.input.pointer.PointerInputChange r0 = (androidx.compose.ui.input.pointer.PointerInputChange) r0
                if (r0 != 0) goto L_0x015d
            L_0x0155:
                r2 = r3
                r3 = r5
                r4 = r10
                r5 = r11
                r1 = r17
                goto L_0x020b
            L_0x015d:
                boolean r1 = r0.isConsumed()
                if (r1 == 0) goto L_0x0164
                goto L_0x0155
            L_0x0164:
                boolean r1 = androidx.compose.ui.input.pointer.PointerEventKt.changedToUpIgnoreConsumed(r0)
                if (r1 == 0) goto L_0x019d
                java.util.List r0 = r7.getChanges()
                int r1 = r0.size()
                r2 = 0
            L_0x0173:
                if (r2 >= r1) goto L_0x0186
                java.lang.Object r7 = r0.get(r2)
                r8 = r7
                androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
                boolean r8 = r8.getPressed()
                if (r8 == 0) goto L_0x0183
                goto L_0x0187
            L_0x0183:
                int r2 = r2 + 1
                goto L_0x0173
            L_0x0186:
                r7 = 0
            L_0x0187:
                androidx.compose.ui.input.pointer.PointerInputChange r7 = (androidx.compose.ui.input.pointer.PointerInputChange) r7
                if (r7 != 0) goto L_0x018c
                goto L_0x0155
            L_0x018c:
                long r0 = r7.m4305getIdJ3iCeTQ()
                r14.element = r0
                r0 = r22
                r1 = r17
                r2 = r19
            L_0x0198:
                r7 = 0
                r8 = 1
                r9 = 0
                goto L_0x00f4
            L_0x019d:
                long r1 = r0.m4306getPositionF1C5BW0()
                long r7 = r0.m4307getPreviousPositionF1C5BW0()
                float r9 = r13.m313mainAxisDeltak4lQ0M(r1)
                float r16 = r13.m313mainAxisDeltak4lQ0M(r7)
                float r9 = r9 - r16
                float r1 = r13.m312crossAxisDeltak4lQ0M(r1)
                float r2 = r13.m312crossAxisDeltak4lQ0M(r7)
                float r1 = r1 - r2
                float r2 = r6 + r9
                float r1 = r1 + r4
                if (r15 == 0) goto L_0x01c2
                float r4 = java.lang.Math.abs(r2)
                goto L_0x01ca
            L_0x01c2:
                long r6 = r13.m314offsetFromChangesdBAh8RU(r2, r1)
                float r4 = androidx.compose.ui.geometry.Offset.m2674getDistanceimpl(r6)
            L_0x01ca:
                int r6 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
                if (r6 >= 0) goto L_0x0216
                androidx.compose.ui.input.pointer.PointerEventPass r4 = androidx.compose.ui.input.pointer.PointerEventPass.Final
                r11.L$0 = r3
                r11.f1949h = r5
                r11.f1950i = r10
                r6 = r19
                r11.f1951j = r6
                r11.f1952k = r13
                r11.f1953l = r14
                r11.f1954m = r0
                r11.f1955n = r15
                r11.f1956o = r12
                r11.f1957p = r2
                r11.f1958q = r1
                r7 = 3
                r11.f1959r = r7
                java.lang.Object r4 = r6.awaitPointerEvent(r4, r11)
                r8 = r17
                if (r4 != r8) goto L_0x01f4
                return r8
            L_0x01f4:
                r4 = r1
                r1 = r8
                r20 = r13
                r13 = r0
                r0 = r15
                r15 = r20
                r21 = r6
                r6 = r2
                r2 = r21
            L_0x0201:
                boolean r8 = r13.isConsumed()
                if (r8 == 0) goto L_0x020d
                r2 = r3
                r3 = r5
                r4 = r10
                r5 = r11
            L_0x020b:
                r0 = 0
                goto L_0x024d
            L_0x020d:
                r13 = r15
                r7 = 0
                r8 = 1
                r9 = 0
                r15 = r0
                r0 = r22
                goto L_0x00f4
            L_0x0216:
                r8 = r17
                r6 = r19
                r7 = 3
                if (r15 == 0) goto L_0x022a
                float r4 = java.lang.Math.signum(r2)
                float r4 = r4 * r12
                float r2 = r2 - r4
                long r1 = r13.m314offsetFromChangesdBAh8RU(r2, r1)
                r17 = r8
                goto L_0x023c
            L_0x022a:
                long r1 = r13.m314offsetFromChangesdBAh8RU(r2, r1)
                r17 = r8
                long r7 = androidx.compose.ui.geometry.Offset.m2671divtuRUvjQ(r1, r4)
                long r7 = androidx.compose.ui.geometry.Offset.m2683timestuRUvjQ(r7, r12)
                long r1 = androidx.compose.ui.geometry.Offset.m2680minusMKHz9U(r1, r7)
            L_0x023c:
                r0.consume()
                r10.element = r1
                boolean r1 = r0.isConsumed()
                if (r1 == 0) goto L_0x02b1
                r2 = r3
                r3 = r5
                r4 = r10
                r5 = r11
                r1 = r17
            L_0x024d:
                if (r0 == 0) goto L_0x025d
                boolean r6 = r0.isConsumed()
                if (r6 == 0) goto L_0x0256
                goto L_0x025d
            L_0x0256:
                r0 = r22
                r7 = 0
                r8 = 1
                r9 = 0
                goto L_0x00c2
            L_0x025d:
                if (r0 == 0) goto L_0x02ae
                kotlin.jvm.functions.Function1<androidx.compose.ui.geometry.Offset, kotlin.Unit> r3 = r4
                long r6 = r0.m4306getPositionF1C5BW0()
                androidx.compose.ui.geometry.Offset r6 = androidx.compose.ui.geometry.Offset.m2665boximpl(r6)
                r3.invoke(r6)
                kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r3 = r5
                long r6 = r4.element
                androidx.compose.ui.geometry.Offset r4 = androidx.compose.ui.geometry.Offset.m2665boximpl(r6)
                r3.invoke(r0, r4)
                long r3 = r0.m4305getIdJ3iCeTQ()
                androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$1$2 r0 = new androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5$1$2
                kotlin.jvm.functions.Function2<androidx.compose.ui.input.pointer.PointerInputChange, androidx.compose.ui.geometry.Offset, kotlin.Unit> r6 = r5
                r0.<init>(r6)
                r7 = 0
                r5.L$0 = r7
                r5.f1949h = r7
                r5.f1950i = r7
                r5.f1951j = r7
                r5.f1952k = r7
                r5.f1953l = r7
                r5.f1954m = r7
                r8 = 4
                r5.f1959r = r8
                java.lang.Object r0 = androidx.compose.foundation.gestures.DragGestureDetectorKt.m284dragjO51t88(r2, r3, r0, r5)
                if (r0 != r1) goto L_0x029b
                return r1
            L_0x029b:
                java.lang.Boolean r0 = (java.lang.Boolean) r0
                boolean r0 = r0.booleanValue()
                if (r0 != 0) goto L_0x02a9
                kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r6
                r0.invoke()
                goto L_0x02ae
            L_0x02a9:
                kotlin.jvm.functions.Function0<kotlin.Unit> r0 = r7
                r0.invoke()
            L_0x02ae:
                kotlin.Unit r0 = kotlin.Unit.INSTANCE
                return r0
            L_0x02b1:
                r0 = r22
                r2 = r6
                r1 = r17
                r4 = 0
                r6 = 0
                goto L_0x0198
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.DragGestureDetectorKt$detectDragGestures$5.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DragGestureDetectorKt$detectDragGestures$5(Function1<? super Offset, Unit> function1, Function2<? super PointerInputChange, ? super Offset, Unit> function2, Function0<Unit> function0, Function0<Unit> function02, Continuation<? super DragGestureDetectorKt$detectDragGestures$5> continuation) {
        super(2, continuation);
        this.f1945i = function1;
        this.f1946j = function2;
        this.f1947k = function0;
        this.f1948l = function02;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        DragGestureDetectorKt$detectDragGestures$5 dragGestureDetectorKt$detectDragGestures$5 = new DragGestureDetectorKt$detectDragGestures$5(this.f1945i, this.f1946j, this.f1947k, this.f1948l, continuation);
        dragGestureDetectorKt$detectDragGestures$5.L$0 = obj;
        return dragGestureDetectorKt$detectDragGestures$5;
    }

    @Nullable
    public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DragGestureDetectorKt$detectDragGestures$5) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f1944h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final Function1<Offset, Unit> function1 = this.f1945i;
            final Function2<PointerInputChange, Offset, Unit> function2 = this.f1946j;
            final Function0<Unit> function0 = this.f1947k;
            final Function0<Unit> function02 = this.f1948l;
            AnonymousClass1 r32 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            this.f1944h = 1;
            if (((PointerInputScope) this.L$0).awaitPointerEventScope(r32, this) == coroutine_suspended) {
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
