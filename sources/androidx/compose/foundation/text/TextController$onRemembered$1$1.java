package androidx.compose.foundation.text;

import androidx.compose.ui.layout.LayoutCoordinates;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/LayoutCoordinates;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class TextController$onRemembered$1$1 extends Lambda implements Function0<LayoutCoordinates> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TextController f3543g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextController$onRemembered$1$1(TextController textController) {
        super(0);
        this.f3543g = textController;
    }

    @Nullable
    public final LayoutCoordinates invoke() {
        return this.f3543g.getState().getLayoutCoordinates();
    }
}
