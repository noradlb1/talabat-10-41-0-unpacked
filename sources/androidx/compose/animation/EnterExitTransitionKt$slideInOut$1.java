package androidx.compose.animation;

import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.Transition;
import androidx.compose.animation.core.TransitionKt;
import androidx.compose.animation.core.TwoWayConverter;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0001H\u000b¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/ui/Modifier;", "invoke", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class EnterExitTransitionKt$slideInOut$1 extends Lambda implements Function3<Modifier, Composer, Integer, Modifier> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Transition<EnterExitState> f1253g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ State<Slide> f1254h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ State<Slide> f1255i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ String f1256j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EnterExitTransitionKt$slideInOut$1(Transition<EnterExitState> transition, State<Slide> state, State<Slide> state2, String str) {
        super(3);
        this.f1253g = transition;
        this.f1254h = state;
        this.f1255i = state2;
        this.f1256j = str;
    }

    /* renamed from: invoke$lambda-1  reason: not valid java name */
    private static final boolean m71invoke$lambda1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* renamed from: invoke$lambda-2  reason: not valid java name */
    private static final void m72invoke$lambda2(MutableState<Boolean> mutableState, boolean z11) {
        mutableState.setValue(Boolean.valueOf(z11));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((Modifier) obj, (Composer) obj2, ((Number) obj3).intValue());
    }

    @NotNull
    @Composable
    public final Modifier invoke(@NotNull Modifier modifier, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(modifier, "$this$composed");
        composer.startReplaceableGroup(158379472);
        Transition<EnterExitState> transition = this.f1253g;
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed((Object) transition);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, (SnapshotMutationPolicy) null, 2, (Object) null);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        MutableState mutableState = (MutableState) rememberedValue;
        if (this.f1253g.getCurrentState() == this.f1253g.getTargetState() && !this.f1253g.isSeeking()) {
            m72invoke$lambda2(mutableState, false);
        } else if (!(this.f1254h.getValue() == null && this.f1255i.getValue() == null)) {
            m72invoke$lambda2(mutableState, true);
        }
        if (m71invoke$lambda1(mutableState)) {
            Transition<EnterExitState> transition2 = this.f1253g;
            TwoWayConverter<IntOffset, AnimationVector2D> vectorConverter = VectorConvertersKt.getVectorConverter(IntOffset.Companion);
            String str = this.f1256j;
            composer.startReplaceableGroup(-492369756);
            Object rememberedValue2 = composer.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (rememberedValue2 == companion.getEmpty()) {
                rememberedValue2 = str + " slide";
                composer.updateRememberedValue(rememberedValue2);
            }
            composer.endReplaceableGroup();
            Transition.DeferredAnimation<IntOffset, AnimationVector2D> createDeferredAnimation = TransitionKt.createDeferredAnimation(transition2, vectorConverter, (String) rememberedValue2, composer, 448, 0);
            Transition<EnterExitState> transition3 = this.f1253g;
            State<Slide> state = this.f1254h;
            State<Slide> state2 = this.f1255i;
            composer.startReplaceableGroup(1157296644);
            boolean changed2 = composer.changed((Object) transition3);
            Object rememberedValue3 = composer.rememberedValue();
            if (changed2 || rememberedValue3 == companion.getEmpty()) {
                rememberedValue3 = new SlideModifier(createDeferredAnimation, state, state2);
                composer.updateRememberedValue(rememberedValue3);
            }
            composer.endReplaceableGroup();
            modifier = modifier.then((SlideModifier) rememberedValue3);
        }
        composer.endReplaceableGroup();
        return modifier;
    }
}
