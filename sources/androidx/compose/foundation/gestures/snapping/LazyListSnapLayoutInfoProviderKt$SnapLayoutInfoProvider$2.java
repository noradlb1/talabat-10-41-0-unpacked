package androidx.compose.foundation.gestures.snapping;

import androidx.compose.foundation.lazy.LazyListItemInfo;
import androidx.compose.foundation.lazy.LazyListLayoutInfo;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0014\u0010\u0006\u001a\u00020\u0007*\u00020\b2\u0006\u0010\t\u001a\u00020\u0007H\u0016J\u0012\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00070\u000b*\u00020\bH\u0016J\f\u0010\f\u001a\u00020\u0007*\u00020\bH\u0016R\u0014\u0010\u0002\u001a\u00020\u00038BX\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\r"}, d2 = {"androidx/compose/foundation/gestures/snapping/LazyListSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$2", "Landroidx/compose/foundation/gestures/snapping/SnapLayoutInfoProvider;", "layoutInfo", "Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "getLayoutInfo", "()Landroidx/compose/foundation/lazy/LazyListLayoutInfo;", "calculateApproachOffset", "", "Landroidx/compose/ui/unit/Density;", "initialVelocity", "calculateSnappingOffsetBounds", "Lkotlin/ranges/ClosedFloatingPointRange;", "snapStepSize", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LazyListSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$2 implements SnapLayoutInfoProvider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LazyListState f2373a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Function3<Density, Float, Float, Float> f2374b;

    public LazyListSnapLayoutInfoProviderKt$SnapLayoutInfoProvider$2(LazyListState lazyListState, Function3<? super Density, ? super Float, ? super Float, Float> function3) {
        this.f2373a = lazyListState;
        this.f2374b = function3;
    }

    private final LazyListLayoutInfo getLayoutInfo() {
        return this.f2373a.getLayoutInfo();
    }

    public float calculateApproachOffset(@NotNull Density density, float f11) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        return 0.0f;
    }

    @NotNull
    public ClosedFloatingPointRange<Float> calculateSnappingOffsetBounds(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        List<LazyListItemInfo> visibleItemsInfo = getLayoutInfo().getVisibleItemsInfo();
        Function3<Density, Float, Float, Float> function3 = this.f2374b;
        int size = visibleItemsInfo.size();
        float f11 = Float.NEGATIVE_INFINITY;
        float f12 = Float.POSITIVE_INFINITY;
        for (int i11 = 0; i11 < size; i11++) {
            float calculateDistanceToDesiredSnapPosition = LazyListSnapLayoutInfoProviderKt.calculateDistanceToDesiredSnapPosition(density, getLayoutInfo(), visibleItemsInfo.get(i11), function3);
            if (calculateDistanceToDesiredSnapPosition <= 0.0f && calculateDistanceToDesiredSnapPosition > f11) {
                f11 = calculateDistanceToDesiredSnapPosition;
            }
            if (calculateDistanceToDesiredSnapPosition >= 0.0f && calculateDistanceToDesiredSnapPosition < f12) {
                f12 = calculateDistanceToDesiredSnapPosition;
            }
        }
        return RangesKt__RangesKt.rangeTo(f11, f12);
    }

    public float snapStepSize(@NotNull Density density) {
        Intrinsics.checkNotNullParameter(density, "<this>");
        LazyListLayoutInfo layoutInfo = getLayoutInfo();
        if (!(!layoutInfo.getVisibleItemsInfo().isEmpty())) {
            return 0.0f;
        }
        List<LazyListItemInfo> visibleItemsInfo = layoutInfo.getVisibleItemsInfo();
        int size = visibleItemsInfo.size();
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            i11 += visibleItemsInfo.get(i12).getSize();
        }
        return ((float) i11) / ((float) layoutInfo.getVisibleItemsInfo().size());
    }
}
