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
@DebugMetadata(c = "androidx.compose.foundation.ClickableKt$combinedClickable$4$gesture$1$1", f = "Clickable.kt", i = {}, l = {343}, m = "invokeSuspend", n = {}, s = {})
public final class ClickableKt$combinedClickable$4$gesture$1$1 extends SuspendLambda implements Function2<PointerInputScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f1574h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ MutableState<Offset> f1575i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ boolean f1576j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ boolean f1577k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f1578l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ State<Function0<Unit>> f1579m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ State<Function0<Unit>> f1580n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ MutableInteractionSource f1581o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ MutableState<PressInteraction.Press> f1582p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ State<Function0<Boolean>> f1583q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ State<Function0<Unit>> f1584r;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.ClickableKt$combinedClickable$4$gesture$1$1$3", f = "Clickable.kt", i = {}, l = {356}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.ClickableKt$combinedClickable$4$gesture$1$1$3  reason: invalid class name */
    public static final class AnonymousClass3 extends SuspendLambda implements Function3<PressGestureScope, Offset, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;

        /* renamed from: h  reason: collision with root package name */
        public int f1587h;

        /* renamed from: i  reason: collision with root package name */
        public /* synthetic */ long f1588i;

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
            return m208invoked4ec7I((PressGestureScope) obj, ((Offset) obj2).m2686unboximpl(), (Continuation) obj3);
        }

        @Nullable
        /* renamed from: invoke-d-4ec7I  reason: not valid java name */
        public final Object m208invoked4ec7I(@NotNull PressGestureScope pressGestureScope, long j11, @Nullable Continuation<? super Unit> continuation) {
            AnonymousClass3 r02 = new AnonymousClass3(z11, mutableInteractionSource, mutableState2, state3, continuation);
            r02.L$0 = pressGestureScope;
            r02.f1588i = j11;
            return r02.invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f1587h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                PressGestureScope pressGestureScope = (PressGestureScope) this.L$0;
                long j11 = this.f1588i;
                if (z11) {
                    MutableInteractionSource mutableInteractionSource = mutableInteractionSource;
                    MutableState<PressInteraction.Press> mutableState = mutableState2;
                    State<Function0<Boolean>> state = state3;
                    this.f1587h = 1;
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
    public ClickableKt$combinedClickable$4$gesture$1$1(MutableState<Offset> mutableState, boolean z11, boolean z12, boolean z13, State<? extends Function0<Unit>> state, State<? extends Function0<Unit>> state2, MutableInteractionSource mutableInteractionSource, MutableState<PressInteraction.Press> mutableState2, State<? extends Function0<Boolean>> state3, State<? extends Function0<Unit>> state4, Continuation<? super ClickableKt$combinedClickable$4$gesture$1$1> continuation) {
        super(2, continuation);
        this.f1575i = mutableState;
        this.f1576j = z11;
        this.f1577k = z12;
        this.f1578l = z13;
        this.f1579m = state;
        this.f1580n = state2;
        this.f1581o = mutableInteractionSource;
        this.f1582p = mutableState2;
        this.f1583q = state3;
        this.f1584r = state4;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        ClickableKt$combinedClickable$4$gesture$1$1 clickableKt$combinedClickable$4$gesture$1$1 = new ClickableKt$combinedClickable$4$gesture$1$1(this.f1575i, this.f1576j, this.f1577k, this.f1578l, this.f1579m, this.f1580n, this.f1581o, this.f1582p, this.f1583q, this.f1584r, continuation);
        clickableKt$combinedClickable$4$gesture$1$1.L$0 = obj;
        return clickableKt$combinedClickable$4$gesture$1$1;
    }

    @Nullable
    public final Object invoke(@NotNull PointerInputScope pointerInputScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ClickableKt$combinedClickable$4$gesture$1$1) create(pointerInputScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        AnonymousClass1 r42;
        AnonymousClass2 r52;
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f1574h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            MutableState<Offset> mutableState = this.f1575i;
            long r43 = IntSizeKt.m5644getCenterozmzZPI(pointerInputScope.m4329getSizeYbymL2g());
            mutableState.setValue(Offset.m2665boximpl(OffsetKt.Offset((float) IntOffset.m5596getXimpl(r43), (float) IntOffset.m5597getYimpl(r43))));
            if (!this.f1576j || !this.f1577k) {
                r42 = null;
            } else {
                final State<Function0<Unit>> state = this.f1579m;
                r42 = new Function1<Offset, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        m206invokek4lQ0M(((Offset) obj).m2686unboximpl());
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                    public final void m206invokek4lQ0M(long j11) {
                        Function0 value = state.getValue();
                        if (value != null) {
                            value.invoke();
                        }
                    }
                };
            }
            if (!this.f1578l || !this.f1577k) {
                r52 = null;
            } else {
                final State<Function0<Unit>> state2 = this.f1580n;
                r52 = new Function1<Offset, Unit>() {
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        m207invokek4lQ0M(((Offset) obj).m2686unboximpl());
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                    public final void m207invokek4lQ0M(long j11) {
                        Function0 value = state2.getValue();
                        if (value != null) {
                            value.invoke();
                        }
                    }
                };
            }
            final boolean z11 = this.f1577k;
            final MutableInteractionSource mutableInteractionSource = this.f1581o;
            final MutableState<PressInteraction.Press> mutableState2 = this.f1582p;
            final State<Function0<Boolean>> state3 = this.f1583q;
            AnonymousClass3 r62 = new AnonymousClass3((Continuation<? super AnonymousClass3>) null);
            final boolean z12 = this.f1577k;
            final State<Function0<Unit>> state4 = this.f1584r;
            AnonymousClass4 r72 = new Function1<Offset, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    m209invokek4lQ0M(((Offset) obj).m2686unboximpl());
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke-k-4lQ0M  reason: not valid java name */
                public final void m209invokek4lQ0M(long j11) {
                    if (z12) {
                        state4.getValue().invoke();
                    }
                }
            };
            this.f1574h = 1;
            if (TapGestureDetectorKt.detectTapGestures(pointerInputScope, r42, r52, r62, r72, this) == coroutine_suspended) {
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
