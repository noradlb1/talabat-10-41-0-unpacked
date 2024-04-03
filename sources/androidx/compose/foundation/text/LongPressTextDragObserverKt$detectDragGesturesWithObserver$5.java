package androidx.compose.foundation.text;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "", "<anonymous parameter 0>", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "offset", "Landroidx/compose/ui/geometry/Offset;", "invoke-Uv8p0NA", "(Landroidx/compose/ui/input/pointer/PointerInputChange;J)V"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class LongPressTextDragObserverKt$detectDragGesturesWithObserver$5 extends Lambda implements Function2<PointerInputChange, Offset, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextDragObserver f3526g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LongPressTextDragObserverKt$detectDragGesturesWithObserver$5(TextDragObserver textDragObserver) {
        super(2);
        this.f3526g = textDragObserver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        m865invokeUv8p0NA((PointerInputChange) obj, ((Offset) obj2).m2686unboximpl());
        return Unit.INSTANCE;
    }

    /* renamed from: invoke-Uv8p0NA  reason: not valid java name */
    public final void m865invokeUv8p0NA(@NotNull PointerInputChange pointerInputChange, long j11) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "<anonymous parameter 0>");
        this.f3526g.m904onDragk4lQ0M(j11);
    }
}
