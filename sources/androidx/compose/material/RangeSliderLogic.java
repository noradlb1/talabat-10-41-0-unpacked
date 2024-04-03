package androidx.compose.material;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.runtime.State;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u001e\u0010\t\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\n0\u0006¢\u0006\u0002\u0010\rJ\u000e\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u000bJ&\u0010\u0017\u001a\u00020\f2\u0006\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u00072\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cJ\u000e\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR)\u0010\t\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\f0\n0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006 "}, d2 = {"Landroidx/compose/material/RangeSliderLogic;", "", "startInteractionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "endInteractionSource", "rawOffsetStart", "Landroidx/compose/runtime/State;", "", "rawOffsetEnd", "onDrag", "Lkotlin/Function2;", "", "", "(Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;Landroidx/compose/runtime/State;)V", "getEndInteractionSource", "()Landroidx/compose/foundation/interaction/MutableInteractionSource;", "getOnDrag", "()Landroidx/compose/runtime/State;", "getRawOffsetEnd", "getRawOffsetStart", "getStartInteractionSource", "activeInteraction", "draggingStart", "captureThumb", "posX", "interaction", "Landroidx/compose/foundation/interaction/Interaction;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "compareOffsets", "", "eventX", "material_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
final class RangeSliderLogic {
    @NotNull
    private final MutableInteractionSource endInteractionSource;
    @NotNull
    private final State<Function2<Boolean, Float, Unit>> onDrag;
    @NotNull
    private final State<Float> rawOffsetEnd;
    @NotNull
    private final State<Float> rawOffsetStart;
    @NotNull
    private final MutableInteractionSource startInteractionSource;

    public RangeSliderLogic(@NotNull MutableInteractionSource mutableInteractionSource, @NotNull MutableInteractionSource mutableInteractionSource2, @NotNull State<Float> state, @NotNull State<Float> state2, @NotNull State<? extends Function2<? super Boolean, ? super Float, Unit>> state3) {
        Intrinsics.checkNotNullParameter(mutableInteractionSource, "startInteractionSource");
        Intrinsics.checkNotNullParameter(mutableInteractionSource2, "endInteractionSource");
        Intrinsics.checkNotNullParameter(state, "rawOffsetStart");
        Intrinsics.checkNotNullParameter(state2, "rawOffsetEnd");
        Intrinsics.checkNotNullParameter(state3, "onDrag");
        this.startInteractionSource = mutableInteractionSource;
        this.endInteractionSource = mutableInteractionSource2;
        this.rawOffsetStart = state;
        this.rawOffsetEnd = state2;
        this.onDrag = state3;
    }

    @NotNull
    public final MutableInteractionSource activeInteraction(boolean z11) {
        return z11 ? this.startInteractionSource : this.endInteractionSource;
    }

    public final void captureThumb(boolean z11, float f11, @NotNull Interaction interaction, @NotNull CoroutineScope coroutineScope) {
        State<Float> state;
        Intrinsics.checkNotNullParameter(interaction, "interaction");
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        Function2 value = this.onDrag.getValue();
        Boolean valueOf = Boolean.valueOf(z11);
        if (z11) {
            state = this.rawOffsetStart;
        } else {
            state = this.rawOffsetEnd;
        }
        value.invoke(valueOf, Float.valueOf(f11 - state.getValue().floatValue()));
        Job unused = BuildersKt__Builders_commonKt.launch$default(coroutineScope, (CoroutineContext) null, (CoroutineStart) null, new RangeSliderLogic$captureThumb$1(this, z11, interaction, (Continuation<? super RangeSliderLogic$captureThumb$1>) null), 3, (Object) null);
    }

    public final int compareOffsets(float f11) {
        return Float.compare(Math.abs(this.rawOffsetStart.getValue().floatValue() - f11), Math.abs(this.rawOffsetEnd.getValue().floatValue() - f11));
    }

    @NotNull
    public final MutableInteractionSource getEndInteractionSource() {
        return this.endInteractionSource;
    }

    @NotNull
    public final State<Function2<Boolean, Float, Unit>> getOnDrag() {
        return this.onDrag;
    }

    @NotNull
    public final State<Float> getRawOffsetEnd() {
        return this.rawOffsetEnd;
    }

    @NotNull
    public final State<Float> getRawOffsetStart() {
        return this.rawOffsetStart;
    }

    @NotNull
    public final MutableInteractionSource getStartInteractionSource() {
        return this.startInteractionSource;
    }
}
