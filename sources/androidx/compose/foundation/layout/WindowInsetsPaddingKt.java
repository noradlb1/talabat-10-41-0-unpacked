package androidx.compose.foundation.layout;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.modifier.ModifierLocalKt;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import androidx.compose.ui.platform.InspectableValueKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007\u001a\u0014\u0010\u0005\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0007\u001a\u0014\u0010\n\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\t\u001a\u00020\u0002H\u0007\u001a/\u0010\u000b\u001a\u00020\u0006*\u00020\u00062!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0005\u0012\u0004\u0012\u00020\u00100\rH\u0007\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0011"}, d2 = {"ModifierLocalConsumedWindowInsets", "Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "Landroidx/compose/foundation/layout/WindowInsets;", "getModifierLocalConsumedWindowInsets", "()Landroidx/compose/ui/modifier/ProvidableModifierLocal;", "consumedWindowInsets", "Landroidx/compose/ui/Modifier;", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "insets", "windowInsetsPadding", "withConsumedWindowInsets", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "foundation-layout_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class WindowInsetsPaddingKt {
    @NotNull
    private static final ProvidableModifierLocal<WindowInsets> ModifierLocalConsumedWindowInsets = ModifierLocalKt.modifierLocalOf(WindowInsetsPaddingKt$ModifierLocalConsumedWindowInsets$1.INSTANCE);

    @NotNull
    @Stable
    @ExperimentalLayoutApi
    public static final Modifier consumedWindowInsets(@NotNull Modifier modifier, @NotNull WindowInsets windowInsets) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(windowInsets, "insets");
        return modifier.then(new UnionInsetsConsumingModifier(windowInsets, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPaddingKt$consumedWindowInsets$$inlined$debugInspectorInfo$1(windowInsets) : InspectableValueKt.getNoInspectorInfo()));
    }

    @NotNull
    public static final ProvidableModifierLocal<WindowInsets> getModifierLocalConsumedWindowInsets() {
        return ModifierLocalConsumedWindowInsets;
    }

    @NotNull
    @Stable
    public static final Modifier windowInsetsPadding(@NotNull Modifier modifier, @NotNull WindowInsets windowInsets) {
        Function1 function1;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(windowInsets, "insets");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function1 = new WindowInsetsPaddingKt$windowInsetsPadding$$inlined$debugInspectorInfo$1(windowInsets);
        } else {
            function1 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new InsetsPaddingModifier(windowInsets, function1));
    }

    @Stable
    @ExperimentalLayoutApi
    @NotNull
    public static final Modifier withConsumedWindowInsets(@NotNull Modifier modifier, @NotNull Function1<? super WindowInsets, Unit> function1) {
        Function1 function12;
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            function12 = new WindowInsetsPaddingKt$withConsumedWindowInsets$$inlined$debugInspectorInfo$1(function1);
        } else {
            function12 = InspectableValueKt.getNoInspectorInfo();
        }
        return modifier.then(new ConsumedInsetsModifier(function1, function12));
    }

    @NotNull
    @Stable
    @ExperimentalLayoutApi
    public static final Modifier consumedWindowInsets(@NotNull Modifier modifier, @NotNull PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(modifier, "<this>");
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        return modifier.then(new PaddingValuesConsumingModifier(paddingValues, InspectableValueKt.isDebugInspectorInfoEnabled() ? new WindowInsetsPaddingKt$consumedWindowInsets$$inlined$debugInspectorInfo$2(paddingValues) : InspectableValueKt.getNoInspectorInfo()));
    }
}
