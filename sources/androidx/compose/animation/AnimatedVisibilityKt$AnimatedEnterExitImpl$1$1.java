package androidx.compose.animation;

import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.animation.AnimatedVisibilityKt$AnimatedEnterExitImpl$1$1", f = "AnimatedVisibility.kt", i = {}, l = {748}, m = "invokeSuspend", n = {}, s = {})
public final class AnimatedVisibilityKt$AnimatedEnterExitImpl$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f1121h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Transition<EnterExitState> f1122i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ MutableState<Boolean> f1123j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnimatedVisibilityKt$AnimatedEnterExitImpl$1$1(Transition<EnterExitState> transition, MutableState<Boolean> mutableState, Continuation<? super AnimatedVisibilityKt$AnimatedEnterExitImpl$1$1> continuation) {
        super(2, continuation);
        this.f1122i = transition;
        this.f1123j = mutableState;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new AnimatedVisibilityKt$AnimatedEnterExitImpl$1$1(this.f1122i, this.f1123j, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((AnimatedVisibilityKt$AnimatedEnterExitImpl$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f1121h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            final Transition<EnterExitState> transition = this.f1122i;
            Flow snapshotFlow = SnapshotStateKt.snapshotFlow(new Function0<Boolean>() {
                @NotNull
                public final Boolean invoke() {
                    EnterExitState currentState = transition.getCurrentState();
                    EnterExitState enterExitState = EnterExitState.Visible;
                    return Boolean.valueOf(currentState == enterExitState || transition.getTargetState() == enterExitState);
                }
            });
            final MutableState<Boolean> mutableState = this.f1123j;
            AnonymousClass2 r12 = new FlowCollector<Boolean>() {
                public /* bridge */ /* synthetic */ Object emit(Object obj, Continuation continuation) {
                    return emit(((Boolean) obj).booleanValue(), (Continuation<? super Unit>) continuation);
                }

                @Nullable
                public final Object emit(boolean z11, @NotNull Continuation<? super Unit> continuation) {
                    mutableState.setValue(Boxing.boxBoolean(z11));
                    return Unit.INSTANCE;
                }
            };
            this.f1121h = 1;
            if (snapshotFlow.collect(r12, this) == coroutine_suspended) {
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
