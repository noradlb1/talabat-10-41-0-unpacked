package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0004\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007\u001a\u0014\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¨\u0006\u0007"}, d2 = {"windowInsetsBottomHeight", "Landroidx/compose/ui/Modifier;", "insets", "Landroidx/compose/foundation/layout/WindowInsets;", "windowInsetsEndWidth", "windowInsetsStartWidth", "windowInsetsTopHeight", "foundation-layout_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class WindowInsetsSizeKt {
    @NotNull
    @Stable
    public static final Modifier windowInsetsBottomHeight(@NotNull Modifier modifier, @NotNull WindowInsets windowInsets) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(windowInsets, "insets");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new WindowInsetsSizeKt$windowInsetsBottomHeight$$inlined$debugInspectorInfo$1(windowInsets);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new DerivedHeightModifier(windowInsets, function1, WindowInsetsSizeKt$windowInsetsBottomHeight$2.INSTANCE));
    }

    @NotNull
    @Stable
    public static final Modifier windowInsetsEndWidth(@NotNull Modifier modifier, @NotNull WindowInsets windowInsets) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(windowInsets, "insets");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new WindowInsetsSizeKt$windowInsetsEndWidth$$inlined$debugInspectorInfo$1(windowInsets);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new DerivedWidthModifier(windowInsets, function1, WindowInsetsSizeKt$windowInsetsEndWidth$2.INSTANCE));
    }

    @NotNull
    @Stable
    public static final Modifier windowInsetsStartWidth(@NotNull Modifier modifier, @NotNull WindowInsets windowInsets) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(windowInsets, "insets");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new WindowInsetsSizeKt$windowInsetsStartWidth$$inlined$debugInspectorInfo$1(windowInsets);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new DerivedWidthModifier(windowInsets, function1, WindowInsetsSizeKt$windowInsetsStartWidth$2.INSTANCE));
    }

    @NotNull
    @Stable
    public static final Modifier windowInsetsTopHeight(@NotNull Modifier modifier, @NotNull WindowInsets windowInsets) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(windowInsets, "insets");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new WindowInsetsSizeKt$windowInsetsTopHeight$$inlined$debugInspectorInfo$1(windowInsets);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new DerivedHeightModifier(windowInsets, function1, WindowInsetsSizeKt$windowInsetsTopHeight$2.INSTANCE));
    }
}
