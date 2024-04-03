package androidx.compose.foundation.gestures;

import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Landroidx/compose/ui/layout/LayoutCoordinates;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class ContentInViewModifier$modifier$1 extends Lambda implements Function1<LayoutCoordinates, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ContentInViewModifier f1820g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContentInViewModifier$modifier$1(ContentInViewModifier contentInViewModifier) {
        super(1);
        this.f1820g = contentInViewModifier;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((LayoutCoordinates) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable LayoutCoordinates layoutCoordinates) {
        this.f1820g.focusedChild = layoutCoordinates;
    }
}
