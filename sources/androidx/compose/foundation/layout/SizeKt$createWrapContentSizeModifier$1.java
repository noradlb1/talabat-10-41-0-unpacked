package androidx.compose.foundation.layout;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0004\b\u0006\u0010\u0007"}, d2 = {"<anonymous>", "Landroidx/compose/ui/unit/IntOffset;", "size", "Landroidx/compose/ui/unit/IntSize;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "invoke-5SAbXVA", "(JLandroidx/compose/ui/unit/LayoutDirection;)J"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SizeKt$createWrapContentSizeModifier$1 extends Lambda implements Function2<IntSize, LayoutDirection, IntOffset> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Alignment f2580g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SizeKt$createWrapContentSizeModifier$1(Alignment alignment) {
        super(2);
        this.f2580g = alignment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        return IntOffset.m5587boximpl(m567invoke5SAbXVA(((IntSize) obj).m5642unboximpl(), (LayoutDirection) obj2));
    }

    /* renamed from: invoke-5SAbXVA  reason: not valid java name */
    public final long m567invoke5SAbXVA(long j11, @NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        return this.f2580g.m2554alignKFBX0sM(IntSize.Companion.m5643getZeroYbymL2g(), j11, layoutDirection);
    }
}
