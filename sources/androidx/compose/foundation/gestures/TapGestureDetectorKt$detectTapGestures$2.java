package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerInputScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2", f = "TapGestureDetector.kt", i = {}, l = {99}, m = "invokeSuspend", n = {}, s = {})
public final class TapGestureDetectorKt$detectTapGestures$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f2247h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PointerInputScope f2248i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> f2249j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<Offset, Unit> f2250k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Function1<Offset, Unit> f2251l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Function1<Offset, Unit> f2252m;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1", f = "TapGestureDetector.kt", i = {}, l = {100}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapGestures$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f2253h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(pressGestureScopeImpl, function3, coroutineScope, function1, function12, function13, continuation);
            r02.L$0 = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f2253h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                final PressGestureScopeImpl pressGestureScopeImpl = pressGestureScopeImpl;
                final Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = function3;
                final CoroutineScope coroutineScope = coroutineScope;
                final Function1<Offset, Unit> function1 = function1;
                final Function1<Offset, Unit> function12 = function12;
                final Function1<Offset, Unit> function13 = function13;
                AnonymousClass1 r32 = new Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    private /* synthetic */ Object L$0;

                    /* renamed from: h  reason: collision with root package name */
                    public Object f2260h;

                    /* renamed from: i  reason: collision with root package name */
                    public Object f2261i;

                    /* renamed from: j  reason: collision with root package name */
                    public Object f2262j;

                    /* renamed from: k  reason: collision with root package name */
                    public long f2263k;

                    /* renamed from: l  reason: collision with root package name */
                    public int f2264l;

                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        AnonymousClass1 r02 = 

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public TapGestureDetectorKt$detectTapGestures$2(PointerInputScope pointerInputScope, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, Function1<? super Offset, Unit> function12, Function1<? super Offset, Unit> function13, Continuation<? super TapGestureDetectorKt$detectTapGestures$2> continuation) {
                            super(2, continuation);
                            this.f2248i = pointerInputScope;
                            this.f2249j = function3;
                            this.f2250k = function1;
                            this.f2251l = function12;
                            this.f2252m = function13;
                        }

                        @NotNull
                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                            TapGestureDetectorKt$detectTapGestures$2 tapGestureDetectorKt$detectTapGestures$2 = new TapGestureDetectorKt$detectTapGestures$2(this.f2248i, this.f2249j, this.f2250k, this.f2251l, this.f2252m, continuation);
                            tapGestureDetectorKt$detectTapGestures$2.L$0 = obj;
                            return tapGestureDetectorKt$detectTapGestures$2;
                        }

                        @Nullable
                        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
                            return ((TapGestureDetectorKt$detectTapGestures$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i11 = this.f2247h;
                            if (i11 == 0) {
                                ResultKt.throwOnFailure(obj);
                                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                                final PressGestureScopeImpl pressGestureScopeImpl = new PressGestureScopeImpl(this.f2248i);
                                PointerInputScope pointerInputScope = this.f2248i;
                                final Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.f2249j;
                                final Function1<Offset, Unit> function1 = this.f2250k;
                                final Function1<Offset, Unit> function12 = this.f2251l;
                                final Function1<Offset, Unit> function13 = this.f2252m;
                                AnonymousClass1 r32 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
                                this.f2247h = 1;
                                if (ForEachGestureKt.forEachGesture(pointerInputScope, r32, this) == coroutine_suspended) {
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
