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
@DebugMetadata(c = "androidx.compose.material.DefaultButtonElevation$elevation$3", f = "Button.kt", i = {}, l = {561}, m = "invokeSuspend", n = {}, s = {})
public final class DefaultButtonElevation$elevation$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f4374h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Animatable<Dp, AnimationVector1D> f4375i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ DefaultButtonElevation f4376j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ float f4377k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ Interaction f4378l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultButtonElevation$elevation$3(Animatable<Dp, AnimationVector1D> animatable, DefaultButtonElevation defaultButtonElevation, float f11, Interaction interaction, Continuation<? super DefaultButtonElevation$elevation$3> continuation) {
        super(2, continuation);
        this.f4375i = animatable;
        this.f4376j = defaultButtonElevation;
        this.f4377k = f11;
        this.f4378l = interaction;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new DefaultButtonElevation$elevation$3(this.f4375i, this.f4376j, this.f4377k, this.f4378l, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((DefaultButtonElevation$elevation$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f4374h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            float r72 = this.f4375i.getTargetValue().m5492unboximpl();
            Interaction interaction = null;
            if (Dp.m5483equalsimpl0(r72, this.f4376j.pressedElevation)) {
                interaction = new PressInteraction.Press(Offset.Companion.m2692getZeroF1C5BW0(), (DefaultConstructorMarker) null);
            } else if (Dp.m5483equalsimpl0(r72, this.f4376j.hoveredElevation)) {
                interaction = new HoverInteraction.Enter();
            } else if (Dp.m5483equalsimpl0(r72, this.f4376j.focusedElevation)) {
                interaction = new FocusInteraction.Focus();
            }
            Animatable<Dp, AnimationVector1D> animatable = this.f4375i;
            float f11 = this.f4377k;
            Interaction interaction2 = this.f4378l;
            this.f4374h = 1;
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
