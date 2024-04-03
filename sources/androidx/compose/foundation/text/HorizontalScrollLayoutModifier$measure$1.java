package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class HorizontalScrollLayoutModifier$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MeasureScope f3504g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ HorizontalScrollLayoutModifier f3505h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Placeable f3506i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f3507j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HorizontalScrollLayoutModifier$measure$1(MeasureScope measureScope, HorizontalScrollLayoutModifier horizontalScrollLayoutModifier, Placeable placeable, int i11) {
        super(1);
        this.f3504g = measureScope;
        this.f3505h = horizontalScrollLayoutModifier;
        this.f3506i = placeable;
        this.f3507j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        MeasureScope measureScope = this.f3504g;
        int cursorOffset = this.f3505h.getCursorOffset();
        TransformedText transformedText = this.f3505h.getTransformedText();
        TextLayoutResultProxy invoke = this.f3505h.getTextLayoutResultProvider().invoke();
        this.f3505h.getScrollerPosition().update(Orientation.Horizontal, TextFieldScrollKt.getCursorRectInScroller(measureScope, cursorOffset, transformedText, invoke != null ? invoke.getValue() : null, this.f3504g.getLayoutDirection() == LayoutDirection.Rtl, this.f3506i.getWidth()), this.f3507j, this.f3506i.getWidth());
        Placeable.PlacementScope.placeRelative$default(placementScope, this.f3506i, MathKt__MathJVMKt.roundToInt(-this.f3505h.getScrollerPosition().getOffset()), 0, 0.0f, 4, (Object) null);
    }
}
