package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.FocusInteraction;
import androidx.compose.foundation.interaction.HoverInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
@DebugMetadata(c = "androidx.compose.material.DefaultFloatingActionButtonElevation$elevation$2", f = "FloatingActionButton.kt", i = {}, l = {318}, m = "invokeSuspend", n = {}, s = {})
public final class DefaultFloatingActionButtonElevation$elevation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f4383h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Animatable<Dp, AnimationVector1D> f4384i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DefaultFloatingActionButtonElevation f4385j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f4386k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Interaction f4387l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultFloatingActionButtonElevation$elevation$2(Animatable<Dp, AnimationVector1D> animatable, DefaultFloatingActionButtonElevation defaultFloatingActionButtonElevation, float f11, Interaction interaction, Continuation<? super DefaultFloatingActionButtonElevation$elevation$2> continuation) {
        super(2, continuation);
        this.f4384i = animatable;
        this.f4385j = defaultFloatingActionButtonElevation;
        this.f4386k = f11;
        this.f4387l = interaction;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DefaultFloatingActionButtonElevation$elevation$2(this.f4384i, this.f4385j, this.f4386k, this.f4387l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DefaultFloatingActionButtonElevation$elevation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f4383h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            float r72 = this.f4384i.getTargetValue().m5492unboximpl();
            Interaction interaction = null;
            if (Dp.m5483equalsimpl0(r72, this.f4385j.pressedElevation)) {
                interaction = new PressInteraction.Press(Offset.Companion.m2692getZeroF1C5BW0(), (DefaultConstructorMarker) null);
            } else if (Dp.m5483equalsimpl0(r72, this.f4385j.hoveredElevation)) {
                interaction = new HoverInteraction.Enter();
            } else if (Dp.m5483equalsimpl0(r72, this.f4385j.focusedElevation)) {
                interaction = new FocusInteraction.Focus();
            }
            Animatable<Dp, AnimationVector1D> animatable = this.f4384i;
            float f11 = this.f4386k;
            Interaction interaction2 = this.f4387l;
            this.f4383h = 1;
            if (ElevationKt.m1245animateElevationrAjV9yQ(animatable, f11, interaction, interaction2, this) == coroutine_suspended) {
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
