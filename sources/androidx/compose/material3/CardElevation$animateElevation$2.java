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
@DebugMetadata(c = "androidx.compose.material3.CardElevation$animateElevation$2", f = "Card.kt", i = {}, l = {681, 688}, m = "invokeSuspend", n = {}, s = {})
public final class CardElevation$animateElevation$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* renamed from: h  reason: collision with root package name */
    public int f6662h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f6663i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Animatable<Dp, AnimationVector1D> f6664j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ CardElevation f6665k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ float f6666l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ Interaction f6667m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardElevation$animateElevation$2(boolean z11, Animatable<Dp, AnimationVector1D> animatable, CardElevation cardElevation, float f11, Interaction interaction, Continuation<? super CardElevation$animateElevation$2> continuation) {
        super(2, continuation);
        this.f6663i = z11;
        this.f6664j = animatable;
        this.f6665k = cardElevation;
        this.f6666l = f11;
        this.f6667m = interaction;
    }

    @NotNull
    public final Continuation<Unit> create(@Nullable Object obj, @NotNull Continuation<?> continuation) {
        return new CardElevation$animateElevation$2(this.f6663i, this.f6664j, this.f6665k, this.f6666l, this.f6667m, continuation);
    }

    @Nullable
    public final Object invoke(@NotNull CoroutineScope coroutineScope, @Nullable Continuation<? super Unit> continuation) {
        return ((CardElevation$animateElevation$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object coroutine_suspended = IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i11 = this.f6662h;
        if (i11 == 0) {
            ResultKt.throwOnFailure(obj);
            if (this.f6663i) {
                float r72 = this.f6664j.getTargetValue().m5492unboximpl();
                Interaction interaction = null;
                if (Dp.m5483equalsimpl0(r72, this.f6665k.pressedElevation)) {
                    interaction = new PressInteraction.Press(Offset.Companion.m2692getZeroF1C5BW0(), (DefaultConstructorMarker) null);
                } else if (Dp.m5483equalsimpl0(r72, this.f6665k.hoveredElevation)) {
                    interaction = new HoverInteraction.Enter();
                } else if (Dp.m5483equalsimpl0(r72, this.f6665k.focusedElevation)) {
                    interaction = new FocusInteraction.Focus();
                } else if (Dp.m5483equalsimpl0(r72, this.f6665k.draggedElevation)) {
                    interaction = new DragInteraction.Start();
                }
                Animatable<Dp, AnimationVector1D> animatable = this.f6664j;
                float f11 = this.f6666l;
                Interaction interaction2 = this.f6667m;
                this.f6662h = 1;
                if (ElevationKt.m1659animateElevationrAjV9yQ(animatable, f11, interaction, interaction2, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                Animatable<Dp, AnimationVector1D> animatable2 = this.f6664j;
                Dp r12 = Dp.m5476boximpl(this.f6666l);
                this.f6662h = 2;
                if (animatable2.snapTo(r12, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (i11 == 1 || i11 == 2) {
            ResultKt.throwOnFailure(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return Unit.INSTANCE;
    }
}
