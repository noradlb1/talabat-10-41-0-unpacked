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
import kotlinx.coroutines.CoroutineScopeKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerInputScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
@DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2", f = "TapGestureDetector.kt", i = {}, l = {218}, m = "invokeSuspend", n = {}, s = {})
public final class TapGestureDetectorKt$detectTapAndPress$2 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f2229h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ PressGestureScopeImpl f2230i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> f2231j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Function1<Offset, Unit> f2232k;

    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H@"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "", "<anonymous>"}, k = 3, mv = {1, 7, 1})
    @DebugMetadata(c = "androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1", f = "TapGestureDetector.kt", i = {}, l = {220}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.TapGestureDetectorKt$detectTapAndPress$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f2233h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(pressGestureScopeImpl, pointerInputScope, function3, function1, continuation);
            r02.L$0 = obj;
            return r02;
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f2233h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                pressGestureScopeImpl.reset();
                PointerInputScope pointerInputScope = pointerInputScope;
                final Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = function3;
                final PressGestureScopeImpl pressGestureScopeImpl = pressGestureScopeImpl;
                final Function1<Offset, Unit> function1 = function1;
                AnonymousClass1 r32 = new Function2<AwaitPointerEventScope, Continuation<? super Unit>, Object>((Continuation<? super AnonymousClass1>) null) {
                    private /* synthetic */ Object L$0;

                    /* renamed from: h  reason: collision with root package name */
                    public int f2238h;

                    @NotNull
                    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                        AnonymousClass1 r02 = 

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public TapGestureDetectorKt$detectTapAndPress$2(PressGestureScopeImpl pressGestureScopeImpl, Function3<? super PressGestureScope, ? super Offset, ? super Continuation<? super Unit>, ? extends Object> function3, Function1<? super Offset, Unit> function1, Continuation<? super TapGestureDetectorKt$detectTapAndPress$2> continuation) {
                            super(2, continuation);
                            this.f2230i = pressGestureScopeImpl;
                            this.f2231j = function3;
                            this.f2232k = function1;
                        }

                        @NotNull
                        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
                            TapGestureDetectorKt$detectTapAndPress$2 tapGestureDetectorKt$detectTapAndPress$2 = new TapGestureDetectorKt$detectTapAndPress$2(this.f2230i, this.f2231j, this.f2232k, continuation);
                            tapGestureDetectorKt$detectTapAndPress$2.L$0 = obj;
                            return tapGestureDetectorKt$detectTapAndPress$2;
                        }

                        @Nullable
                        public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
                            return ((TapGestureDetectorKt$detectTapAndPress$2) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Nullable
                        public final Object invokeSuspend(@NotNull Object obj) {
                            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i11 = this.f2229h;
                            if (i11 == 0) {
                                ResultKt.throwOnFailure(obj);
                                final PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                                final PressGestureScopeImpl pressGestureScopeImpl = this.f2230i;
                                final Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> function3 = this.f2231j;
                                final Function1<Offset, Unit> function1 = this.f2232k;
                                AnonymousClass1 r32 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
                                this.f2229h = 1;
                                if (CoroutineScopeKt.coroutineScope(r32, this) == coroutine_suspended) {
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
