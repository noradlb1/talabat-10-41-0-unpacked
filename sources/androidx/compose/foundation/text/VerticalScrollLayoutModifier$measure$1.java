package androidx.compose.foundation.text;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.input.TransformedText;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class VerticalScrollLayoutModifier$measure$1 extends Lambda implements Function1<Placeable.PlacementScope, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ MeasureScope f3621g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ VerticalScrollLayoutModifier f3622h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Placeable f3623i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ int f3624j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerticalScrollLayoutModifier$measure$1(MeasureScope measureScope, VerticalScrollLayoutModifier verticalScrollLayoutModifier, Placeable placeable, int i11) {
        super(1);
        this.f3621g = measureScope;
        this.f3622h = verticalScrollLayoutModifier;
        this.f3623i = placeable;
        this.f3624j = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Placeable.PlacementScope) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
        MeasureScope measureScope = this.f3621g;
        int cursorOffset = this.f3622h.getCursorOffset();
        TransformedText transformedText = this.f3622h.getTransformedText();
        TextLayoutResultProxy invoke = this.f3622h.getTextLayoutResultProvider().invoke();
        this.f3622h.getScrollerPosition().update(Orientation.Vertical, TextFieldScrollKt.getCursorRectInScroller(measureScope, cursorOffset, transformedText, invoke != null ? invoke.getValue() : null, false, this.f3623i.getWidth()), this.f3624j, this.f3623i.getHeight());
        Placeable.PlacementScope.placeRelative$default(placementScope, this.f3623i, 0, MathKt__MathJVMKt.roundToInt(-this.f3622h.getScrollerPosition().getOffset()), 0.0f, 4, (Object) null);
    }
}
