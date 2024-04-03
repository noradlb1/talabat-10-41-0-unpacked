package androidx.compose.foundation.relocation;

import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/ui/geometry/Rect;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class BringIntoViewRequesterModifier$bringIntoView$2 extends Lambda implements Function0<Rect> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Rect f3192g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ BringIntoViewRequesterModifier f3193h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BringIntoViewRequesterModifier$bringIntoView$2(Rect rect, BringIntoViewRequesterModifier bringIntoViewRequesterModifier) {
        super(0);
        this.f3192g = rect;
        this.f3193h = bringIntoViewRequesterModifier;
    }

    @Nullable
    public final Rect invoke() {
        Rect rect = this.f3192g;
        if (rect != null) {
            return rect;
        }
        LayoutCoordinates a11 = this.f3193h.a();
        if (a11 != null) {
            return SizeKt.m2766toRectuvyYCjk(IntSizeKt.m5648toSizeozmzZPI(a11.m4473getSizeYbymL2g()));
        }
        return null;
    }
}
