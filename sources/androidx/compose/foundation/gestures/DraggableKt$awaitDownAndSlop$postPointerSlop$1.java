package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "event", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "offset", "Landroidx/compose/ui/geometry/Offset;", "invoke-Uv8p0NA", "(Landroidx/compose/ui/input/pointer/PointerInputChange;J)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class DraggableKt$awaitDownAndSlop$postPointerSlop$1 extends Lambda implements Function2<PointerInputChange, Offset, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ VelocityTracker f2059g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Ref.LongRef f2060h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DraggableKt$awaitDownAndSlop$postPointerSlop$1(VelocityTracker velocityTracker, Ref.LongRef longRef) {
        super(2);
        this.f2059g = velocityTracker;
        this.f2060h = longRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        m305invokeUv8p0NA((PointerInputChange) obj, ((Offset) obj2).m2686unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-Uv8p0NA  reason: not valid java name */
    public final void m305invokeUv8p0NA(@NotNull PointerInputChange pointerInputChange, long j11) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "event");
        VelocityTrackerKt.addPointerInputChange(this.f2059g, pointerInputChange);
        pointerInputChange.consume();
        this.f2060h.element = j11;
    }
}
