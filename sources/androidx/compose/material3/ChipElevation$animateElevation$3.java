package androidx.compose.material3;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.foundation.interaction.DragInteraction;
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

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
@DebugMetadata(c = "androidx.compose.material3.ChipElevation$animateElevation$3", f = "Chip.kt", i = {}, l = {1569}, m = "invokeSuspend", n = {}, s = {})
public final class ChipElevation$animateElevation$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f6763h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Animatable<Dp, AnimationVector1D> f6764i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ChipElevation f6765j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f6766k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Interaction f6767l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChipElevation$animateElevation$3(Animatable<Dp, AnimationVector1D> animatable, ChipElevation chipElevation, float f11, Interaction interaction, Continuation<? super ChipElevation$animateElevation$3> continuation) {
        super(2, continuation);
        this.f6764i = animatable;
        this.f6765j = chipElevation;
        this.f6766k = f11;
        this.f6767l = interaction;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new ChipElevation$animateElevation$3(this.f6764i, this.f6765j, this.f6766k, this.f6767l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((ChipElevation$animateElevation$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f6763h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            float r72 = this.f6764i.getTargetValue().m5492unboximpl();
            Interaction interaction = null;
            if (Dp.m5483equalsimpl0(r72, this.f6765j.pressedElevation)) {
                interaction = new PressInteraction.Press(Offset.Companion.m2692getZeroF1C5BW0(), (DefaultConstructorMarker) null);
            } else if (Dp.m5483equalsimpl0(r72, this.f6765j.hoveredElevation)) {
                interaction = new HoverInteraction.Enter();
            } else if (Dp.m5483equalsimpl0(r72, this.f6765j.focusedElevation)) {
                interaction = new FocusInteraction.Focus();
            } else if (Dp.m5483equalsimpl0(r72, this.f6765j.draggedElevation)) {
                interaction = new DragInteraction.Start();
            }
            Animatable<Dp, AnimationVector1D> animatable = this.f6764i;
            float f11 = this.f6766k;
            Interaction interaction2 = this.f6767l;
            this.f6763h = 1;
            if (ElevationKt.m1659animateElevationrAjV9yQ(animatable, f11, interaction, interaction2, this) == coroutine_suspended) {
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
