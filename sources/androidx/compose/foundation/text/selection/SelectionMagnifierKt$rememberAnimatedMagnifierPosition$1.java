package androidx.compose.foundation.text.selection;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.foundation.text.selection.SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1", f = "SelectionMagnifier.kt", i = {}, l = {88}, m = "invokeSuspend", n = {}, s = {})
public final class SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    private /* synthetic */ Object L$0;

    /* renamed from: h  reason: collision with root package name */
    public int f3695h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ State<Offset> f3696i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Animatable<Offset, AnimationVector2D> f3697j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1(State<Offset> state, Animatable<Offset, AnimationVector2D> animatable, Continuation<? super SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1> continuation) {
        super(2, continuation);
        this.f3696i = state;
        this.f3697j = animatable;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1 selectionMagnifierKt$rememberAnimatedMagnifierPosition$1 = new SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1(this.f3696i, this.f3697j, continuation);
        selectionMagnifierKt$rememberAnimatedMagnifierPosition$1.L$0 = obj;
        return selectionMagnifierKt$rememberAnimatedMagnifierPosition$1;
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f3695h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            final State<Offset> state = this.f3696i;
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<Offset>() {
                public /* bridge */ /* synthetic */ Object invoke() {
                    return Offset.m2665boximpl(m990invokeF1C5BW0());
                }

                /* renamed from: invoke-F1C5BW0  reason: not valid java name */
                public final long m990invokeF1C5BW0() {
                    return SelectionMagnifierKt.m984rememberAnimatedMagnifierPosition$lambda1(state);
                }
            });
            final Animatable<Offset, AnimationVector2D> animatable = this.f3697j;
            AnonymousClass2 r32 = new FlowCollector<Offset>() {
                public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                    return m991emit3MmeM6k(((Offset) obj).m2686unboximpl(), continuation);
                }

                @Nullable
                /* renamed from: emit-3MmeM6k  reason: not valid java name */
                public final Object m991emit3MmeM6k(long j11, @NotNull Continuation<? super Unit> continuation) {
                    boolean z11;
                    if (OffsetKt.m2695isSpecifiedk4lQ0M(animatable.getValue().m2686unboximpl()) && OffsetKt.m2695isSpecifiedk4lQ0M(j11)) {
                        if (Offset.m2677getYimpl(animatable.getValue().m2686unboximpl()) == Offset.m2677getYimpl(j11)) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        if (!z11) {
                            Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$2$emit$2(animatable, j11, (Continuation<? super SelectionMagnifierKt$rememberAnimatedMagnifierPosition$1$2$emit$2>) null), 3, (Object) null);
                            return Unit.INSTANCE;
                        }
                    }
                    Object snapTo = animatable.snapTo(Offset.m2665boximpl(j11), continuation);
                    if (snapTo == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                        return snapTo;
                    }
                    return Unit.INSTANCE;
                }
            };
            this.f3695h = 1;
            if (snapshotFlow.collect(r32, this) == coroutine_suspended) {
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
