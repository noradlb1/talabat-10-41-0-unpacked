package androidx.compose.ui.layout;

import androidx.compose.ui.ExperimentalComposeUiApi;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0001¨\u0006\u0004"}, d2 = {"createMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "measurePolicy", "Landroidx/compose/ui/layout/MultiContentMeasurePolicy;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class MultiContentMeasurePolicyKt {
    @ExperimentalComposeUiApi
    @NotNull
    @PublishedApi
    public static final MeasurePolicy createMeasurePolicy(@NotNull MultiContentMeasurePolicy multiContentMeasurePolicy) {
        Intrinsics.checkNotNullParameter(multiContentMeasurePolicy, "measurePolicy");
        return new MultiContentMeasurePolicyKt$createMeasurePolicy$1$1(multiContentMeasurePolicy);
    }
}
