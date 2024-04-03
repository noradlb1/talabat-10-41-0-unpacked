package androidx.compose.foundation.gestures;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.State;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.unit.Velocity;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$3$1", f = "Scrollable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
public final class ScrollableKt$pointerScrollable$3$1 extends SuspendLambda implements Function3<CoroutineScope, Velocity, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f2175h;

    /* renamed from: i  reason: collision with root package name */
    public /* synthetic */ long f2176i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableState<NestedScrollDispatcher> f2177j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ State<ScrollingLogic> f2178k;

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    @DebugMetadata(c = "androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$3$1$1", f = "Scrollable.kt", i = {}, l = {276}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: androidx.compose.foundation.gestures.ScrollableKt$pointerScrollable$3$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* renamed from: h  reason: collision with root package name */
        public int f2179h;

        @NotNull
        public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
            return new AnonymousClass1(state, j11, continuation);
        }

        @Nullable
        public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i11 = this.f2179h;
            if (i11 == 0) {
                ResultKt.throwOnFailure(obj);
                long j11 = j11;
                this.f2179h = 1;
                if (state.getValue().m348onDragStoppedsFctU(j11, this) == coroutine_suspended) {
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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ScrollableKt$pointerScrollable$3$1(MutableState<NestedScrollDispatcher> mutableState, State<ScrollingLogic> state, Continuation<? super ScrollableKt$pointerScrollable$3$1> continuation) {
        super(3, continuation);
        this.f2177j = mutableState;
        this.f2178k = state;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m340invokeLuvzFrg((CoroutineScope) obj, ((Velocity) obj2).m5712unboximpl(), (Continuation) obj3);
    }

    @Nullable
    /* renamed from: invoke-LuvzFrg  reason: not valid java name */
    public final Object m340invokeLuvzFrg(@NotNull CoroutineScope coroutineScope, long j11, @Nullable Continuation<? super Unit> continuation) {
        ScrollableKt$pointerScrollable$3$1 scrollableKt$pointerScrollable$3$1 = new ScrollableKt$pointerScrollable$3$1(this.f2177j, this.f2178k, continuation);
        scrollableKt$pointerScrollable$3$1.f2176i = j11;
        return scrollableKt$pointerScrollable$3$1.invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.f2175h == 0) {
            ResultKt.throwOnFailure(obj);
            final long j11 = this.f2176i;
            CoroutineScope coroutineScope = this.f2177j.getValue().getCoroutineScope();
            final State<ScrollingLogic> state = this.f2178k;
            Job unused2 = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((Continuation<? super AnonymousClass1>) null), 3, (Object) null);
            return Unit.INSTANCE;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
