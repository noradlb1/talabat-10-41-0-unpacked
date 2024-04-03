package androidx.compose.foundation.layout;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.instabug.library.model.State;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a;\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a.\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\t2\b\b\u0002\u0010\u0004\u001a\u00020\t2\b\b\u0002\u0010\u0005\u001a\u00020\t2\b\b\u0002\u0010\u0006\u001a\u00020\t\u001a\u0012\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001\u001a\f\u0010\f\u001a\u00020\u0001*\u00020\rH\u0000\u001a\u0011\u0010\u000e\u001a\u00020\r*\u00020\u0001H\u0007¢\u0006\u0002\u0010\u000f\u001a\u0012\u0010\u000e\u001a\u00020\r*\u00020\u00012\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0012\u0010\u0012\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001\u001a\u001f\u0010\u0013\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a\u0012\u0010\u0018\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"WindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "left", "Landroidx/compose/ui/unit/Dp;", "top", "right", "bottom", "WindowInsets-a9UjIt4", "(FFFF)Landroidx/compose/foundation/layout/WindowInsets;", "", "add", "insets", "asInsets", "Landroidx/compose/foundation/layout/PaddingValues;", "asPaddingValues", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/layout/PaddingValues;", "density", "Landroidx/compose/ui/unit/Density;", "exclude", "only", "sides", "Landroidx/compose/foundation/layout/WindowInsetsSides;", "only-bOOhFvg", "(Landroidx/compose/foundation/layout/WindowInsets;I)Landroidx/compose/foundation/layout/WindowInsets;", "union", "foundation-layout_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class WindowInsetsKt {
    @NotNull
    public static final WindowInsets WindowInsets(int i11, int i12, int i13, int i14) {
        return new FixedIntInsets(i11, i12, i13, i14);
    }

    public static /* synthetic */ WindowInsets WindowInsets$default(int i11, int i12, int i13, int i14, int i15, Object obj) {
        if ((i15 & 1) != 0) {
            i11 = 0;
        }
        if ((i15 & 2) != 0) {
            i12 = 0;
        }
        if ((i15 & 4) != 0) {
            i13 = 0;
        }
        if ((i15 & 8) != 0) {
            i14 = 0;
        }
        return WindowInsets(i11, i12, i13, i14);
    }

    @NotNull
    /* renamed from: WindowInsets-a9UjIt4  reason: not valid java name */
    public static final WindowInsets m576WindowInsetsa9UjIt4(float f11, float f12, float f13, float f14) {
        return new FixedDpInsets(f11, f12, f13, f14, (DefaultConstructorMarker) null);
    }

    /* renamed from: WindowInsets-a9UjIt4$default  reason: not valid java name */
    public static /* synthetic */ WindowInsets m577WindowInsetsa9UjIt4$default(float f11, float f12, float f13, float f14, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            f11 = Dp.m5478constructorimpl((float) 0);
        }
        if ((i11 & 2) != 0) {
            f12 = Dp.m5478constructorimpl((float) 0);
        }
        if ((i11 & 4) != 0) {
            f13 = Dp.m5478constructorimpl((float) 0);
        }
        if ((i11 & 8) != 0) {
            f14 = Dp.m5478constructorimpl((float) 0);
        }
        return m576WindowInsetsa9UjIt4(f11, f12, f13, f14);
    }

    @NotNull
    public static final WindowInsets add(@NotNull WindowInsets windowInsets, @NotNull WindowInsets windowInsets2) {
        Intrinsics.checkNotNullParameter(windowInsets, "<this>");
        Intrinsics.checkNotNullParameter(windowInsets2, "insets");
        return new AddedInsets(windowInsets, windowInsets2);
    }

    @NotNull
    public static final WindowInsets asInsets(@NotNull PaddingValues paddingValues) {
        Intrinsics.checkNotNullParameter(paddingValues, "<this>");
        return new PaddingValuesInsets(paddingValues);
    }

    @NotNull
    @ReadOnlyComposable
    @Composable
    public static final PaddingValues asPaddingValues(@NotNull WindowInsets windowInsets, @Nullable Composer composer, int i11) {
        Intrinsics.checkNotNullParameter(windowInsets, "<this>");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1485016250, i11, -1, "androidx.compose.foundation.layout.asPaddingValues (WindowInsets.kt:242)");
        }
        InsetsPaddingValues insetsPaddingValues = new InsetsPaddingValues(windowInsets, (Density) composer.consume(CompositionLocalsKt.getLocalDensity()));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return insetsPaddingValues;
    }

    @NotNull
    public static final WindowInsets exclude(@NotNull WindowInsets windowInsets, @NotNull WindowInsets windowInsets2) {
        Intrinsics.checkNotNullParameter(windowInsets, "<this>");
        Intrinsics.checkNotNullParameter(windowInsets2, "insets");
        return new ExcludeInsets(windowInsets, windowInsets2);
    }

    @NotNull
    /* renamed from: only-bOOhFvg  reason: not valid java name */
    public static final WindowInsets m578onlybOOhFvg(@NotNull WindowInsets windowInsets, int i11) {
        Intrinsics.checkNotNullParameter(windowInsets, "$this$only");
        return new LimitInsets(windowInsets, i11, (DefaultConstructorMarker) null);
    }

    @NotNull
    public static final WindowInsets union(@NotNull WindowInsets windowInsets, @NotNull WindowInsets windowInsets2) {
        Intrinsics.checkNotNullParameter(windowInsets, "<this>");
        Intrinsics.checkNotNullParameter(windowInsets2, "insets");
        return new UnionInsets(windowInsets, windowInsets2);
    }

    @NotNull
    public static final PaddingValues asPaddingValues(@NotNull WindowInsets windowInsets, @NotNull Density density) {
        Intrinsics.checkNotNullParameter(windowInsets, "<this>");
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        return new InsetsPaddingValues(windowInsets, density);
    }
}
