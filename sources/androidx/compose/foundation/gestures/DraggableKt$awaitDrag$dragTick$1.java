package androidx.compose.foundation.gestures;

import androidx.compose.foundation.gestures.DragEvent;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerEventKt;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.util.VelocityTracker;
import androidx.compose.ui.input.pointer.util.VelocityTrackerKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.channels.SendChannel;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "event", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class DraggableKt$awaitDrag$dragTick$1 extends Lambda implements Function1<PointerInputChange, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ VelocityTracker f2061g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ SendChannel<DragEvent> f2062h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ boolean f2063i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DraggableKt$awaitDrag$dragTick$1(VelocityTracker velocityTracker, SendChannel<? super DragEvent> sendChannel, boolean z11) {
        super(1);
        this.f2061g = velocityTracker;
        this.f2062h = sendChannel;
        this.f2063i = z11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PointerInputChange) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull PointerInputChange pointerInputChange) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "event");
        VelocityTrackerKt.addPointerInputChange(this.f2061g, pointerInputChange);
        long positionChange = PointerEventKt.positionChange(pointerInputChange);
        pointerInputChange.consume();
        SendChannel<DragEvent> sendChannel = this.f2062h;
        if (this.f2063i) {
            positionChange = Offset.m2683timestuRUvjQ(positionChange, -1.0f);
        }
        sendChannel.m7820trySendJP2dKIU(new DragEvent.DragDelta(positionChange, (DefaultConstructorMarker) null));
    }
}
