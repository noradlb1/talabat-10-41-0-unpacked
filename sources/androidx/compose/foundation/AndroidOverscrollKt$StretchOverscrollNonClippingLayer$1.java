package androidx.compose.foundation;

import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\n¢\u0006\u0004\b\u0007\u0010\b"}, d2 = {"<anonymous>", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "measurable", "Landroidx/compose/ui/layout/Measurable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "invoke-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1 extends Lambda implements Function3<MeasureScope, Measurable, Constraints, MeasureResult> {
    public static final AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1 INSTANCE = new AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1();

    public AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1() {
        super(3);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return m174invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).m5428unboximpl());
    }

    @NotNull
    /* renamed from: invoke-3p2s80s  reason: not valid java name */
    public final MeasureResult m174invoke3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j11) {
        Intrinsics.checkNotNullParameter(measureScope, "$this$layout");
        Intrinsics.checkNotNullParameter(measurable, "measurable");
        final Placeable r92 = measurable.m4508measureBRTryo0(j11);
        final int r102 = measureScope.m5441roundToPx0680j_4(Dp.m5478constructorimpl(ClipScrollableContainerKt.getMaxSupportedElevation() * ((float) 2)));
        return MeasureScope.CC.p(measureScope, r92.getMeasuredWidth() - r102, r92.getMeasuredHeight() - r102, (Map) null, new Function1<Placeable.PlacementScope, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((Placeable.PlacementScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                Placeable placeable = r92;
                Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, ((-r102) / 2) - ((placeable.getWidth() - r92.getMeasuredWidth()) / 2), ((-r102) / 2) - ((r92.getHeight() - r92.getMeasuredHeight()) / 2), 0.0f, (Function1) null, 12, (Object) null);
            }
        }, 4, (Object) null);
    }
}
