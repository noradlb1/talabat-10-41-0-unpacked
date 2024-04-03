package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"<anonymous>", "", "size", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "invoke", "(ILandroidx/compose/ui/unit/LayoutDirection;)Ljava/lang/Integer;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class Arrangement$Absolute$spacedBy$1 extends Lambda implements Function2<Integer, LayoutDirection, Integer> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Alignment.Horizontal f2439g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Arrangement$Absolute$spacedBy$1(Alignment.Horizontal horizontal) {
        super(2);
        this.f2439g = horizontal;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return invoke(((Number) obj).intValue(), (LayoutDirection) obj2);
    }

    @NotNull
    public final Integer invoke(int i11, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return Integer.valueOf(this.f2439g.align(0, i11, layoutDirection));
    }
}
