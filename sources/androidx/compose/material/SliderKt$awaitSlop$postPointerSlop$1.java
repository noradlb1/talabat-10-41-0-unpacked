package androidx.compose.material;

import androidx.compose.ui.input.pointer.PointerInputChange;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "pointerInput", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "offset", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class SliderKt$awaitSlop$postPointerSlop$1 extends Lambda implements Function2<PointerInputChange, Float, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Ref.FloatRef f5268g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SliderKt$awaitSlop$postPointerSlop$1(Ref.FloatRef floatRef) {
        super(2);
        this.f5268g = floatRef;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((PointerInputChange) obj, ((Number) obj2).floatValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull PointerInputChange pointerInputChange, float f11) {
        Intrinsics.checkNotNullParameter(pointerInputChange, "pointerInput");
        pointerInputChange.consume();
        this.f5268g.element = f11;
    }
}
