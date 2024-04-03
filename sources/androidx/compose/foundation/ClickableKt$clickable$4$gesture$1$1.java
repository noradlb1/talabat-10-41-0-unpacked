package androidx.compose.foundation;

import androidx.compose.foundation.gestures.PressGestureScope;
import androidx.compose.foundation.gestures.TapGestureDetectorKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.pointer.PointerInputScope;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.ClickableKt$clickable$4$gesture$1$1", f = "Clickable.kt", i = {}, l = {156}, m = "invokeSuspend", n = {}, s = {})
public final class ClickableKt$clickable$4$gesture$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f1538h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableState<Offset> f1539i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f1540j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f1541k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ MutableState<PressInteraction.Press> f1542l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ State<Function0<Boolean>> f1543m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ State<Function0<Unit>> f1544n;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.ClickableKt$clickable$4$gesture$1$1$1", f = "Clickable.kt", i = {}, l = {159}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.ClickableKt$clickable$4$gesture$1$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f1545h;

        /* renamed from: i  reason: collision with root package name */
        public /* synthetic */ long f1546i;

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return m204invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).m2686unboximpl(), (Continuation) obj3);
        }

        @Nullable
        /* renamed from: invoke-d-4ec7I  reason: not valid java name */
        public final Object m204invoked4ec7I(@NotNull PressGestureScope pressGestureScope, long j11, @Nullable Continuation<? super Unit> continuation) {
            AnonymousClass1 r02 = new AnonymousClass1(z11, mutableInteractionSource, mutableState2, state, continuation);
            r02.L$0 = pressGestureScope;
            r02.f1546i = j11;
            return r02.invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f1545h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                long j11 = this.f1546i;
                if (z11) {
                    MutableInteractionSource mutableInteractionSource = mutableInteractionSource;
                    MutableState<PressInteraction.Press> mutableState = mutableState2;
                    State<Function0<Boolean>> state = state;
                    this.f1545h = 1;
                    if (ClickableKt.m203handlePressInteractionEPk0efs(pressGestureScope, j11, mutableInteractionSource, mutableState, state, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                }
            } else if (i11 == 1) {
                ResultKt.throwOnFailure(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClickableKt$clickable$4$gesture$1$1(MutableState<Offset> mutableState, boolean z11, MutableInteractionSource mutableInteractionSource, MutableState<PressInteraction.Press> mutableState2, State<? extends Function0<Boolean>> state, State<? extends Function0<Unit>> state2, Continuation<? super ClickableKt$clickable$4$gesture$1$1> continuation) {
        super(2, continuation);
        this.f1539i = mutableState;
        this.f1540j = z11;
        this.f1541k = mutableInteractionSource;
        this.f1542l = mutableState2;
        this.f1543m = state;
        this.f1544n = state2;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ClickableKt$clickable$4$gesture$1$1 clickableKt$clickable$4$gesture$1$1 = new ClickableKt$clickable$4$gesture$1$1(this.f1539i, this.f1540j, this.f1541k, this.f1542l, this.f1543m, this.f1544n, continuation);
        clickableKt$clickable$4$gesture$1$1.L$0 = obj;
        return clickableKt$clickable$4$gesture$1$1;
    }

    @Nullable
    public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ClickableKt$clickable$4$gesture$1$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f1538h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            MutableState<Offset> mutableState = this.f1539i;
            long r32 = IntSizeKt.m5644getCenterozmzZPI(pointerInputScope.m4329getSizeYbymL2g());
            mutableState.setValue(Offset.m2665boximpl(OffsetKt.Offset((float) IntOffset.m5596getXimpl(r32), (float) IntOffset.m5597getYimpl(r32))));
            final boolean z11 = this.f1540j;
            final MutableInteractionSource mutableInteractionSource = this.f1541k;
            final MutableState<PressInteraction.Press> mutableState2 = this.f1542l;
            final State<Function0<Boolean>> state = this.f1543m;
            AnonymousClass1 r42 = new AnonymousClass1((Continuation<? super AnonymousClass1>) null);
            final boolean z12 = this.f1540j;
            final State<Function0<Unit>> state2 = this.f1544n;
            AnonymousClass2 r33 = new Function1<Offset, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    m205invokek4lQ0M(((Offset) obj).m2686unboximpl());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                public final void m205invokek4lQ0M(long j11) {
                    if (z12) {
                        state2.getValue().invoke();
                    }
                }
            };
            this.f1538h = 1;
            if (TapGestureDetectorKt.detectTapAndPress(pointerInputScope, r42, r33, this) == coroutine_suspended) {
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
