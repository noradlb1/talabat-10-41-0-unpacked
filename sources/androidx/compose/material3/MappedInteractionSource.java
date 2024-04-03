package androidx.compose.material3;

import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.ui.geometry.Offset;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u0018\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u0005J\u0010\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002R\u0019\u0010\u0003\u001a\u00020\u0004X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u0006R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\rX\u0004¢\u0006\u0002\n\u0000\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0011"}, d2 = {"Landroidx/compose/material3/MappedInteractionSource;", "Landroidx/compose/foundation/interaction/InteractionSource;", "underlyingInteractionSource", "delta", "Landroidx/compose/ui/geometry/Offset;", "(Landroidx/compose/foundation/interaction/InteractionSource;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "interactions", "Lkotlinx/coroutines/flow/Flow;", "Landroidx/compose/foundation/interaction/Interaction;", "getInteractions", "()Lkotlinx/coroutines/flow/Flow;", "mappedPresses", "", "Landroidx/compose/foundation/interaction/PressInteraction$Press;", "mapPress", "press", "material3_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class MappedInteractionSource implements InteractionSource {
    private final long delta;
    @NotNull
    private final Flow<Interaction> interactions;
    /* access modifiers changed from: private */
    @NotNull
    public final Map<PressInteraction.Press, PressInteraction.Press> mappedPresses;

    private MappedInteractionSource(InteractionSource interactionSource, long j11) {
        this.delta = j11;
        this.mappedPresses = new LinkedHashMap();
        this.interactions = new MappedInteractionSource$special$$inlined$map$1(interactionSource.getInteractions(), this);
    }

    public /* synthetic */ MappedInteractionSource(InteractionSource interactionSource, long j11, DefaultConstructorMarker defaultConstructorMarker) {
        this(interactionSource, j11);
    }

    /* access modifiers changed from: private */
    public final PressInteraction.Press mapPress(PressInteraction.Press press) {
        return new PressInteraction.Press(Offset.m2680minusMKHz9U(press.m367getPressPositionF1C5BW0(), this.delta), (DefaultConstructorMarker) null);
    }

    @NotNull
    public Flow<Interaction> getInteractions() {
        return this.interactions;
    }
}
