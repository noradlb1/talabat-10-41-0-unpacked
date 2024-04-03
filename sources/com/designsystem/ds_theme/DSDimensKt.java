package com.designsystem.ds_theme;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0014\u0010\u0005\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"LocalDSDimens", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lcom/designsystem/ds_theme/DSDimens;", "getLocalDSDimens", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "defaultDSDimens", "getDefaultDSDimens", "()Lcom/designsystem/ds_theme/DSDimens;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSDimensKt {
    @NotNull
    private static final ProvidableCompositionLocal<DSDimens> LocalDSDimens = CompositionLocalKt.staticCompositionLocalOf(DSDimensKt$LocalDSDimens$1.INSTANCE);
    @NotNull
    private static final DSDimens defaultDSDimens = new DSDimens(Dp.m5478constructorimpl((float) 0), Dp.m5478constructorimpl((float) 4), Dp.m5478constructorimpl((float) 8), Dp.m5478constructorimpl((float) 12), Dp.m5478constructorimpl((float) 16), Dp.m5478constructorimpl((float) 20), Dp.m5478constructorimpl((float) 24), Dp.m5478constructorimpl((float) 32), Dp.m5478constructorimpl((float) 40), Dp.m5478constructorimpl((float) 44), (DefaultConstructorMarker) null);

    @NotNull
    public static final DSDimens getDefaultDSDimens() {
        return defaultDSDimens;
    }

    @NotNull
    public static final ProvidableCompositionLocal<DSDimens> getLocalDSDimens() {
        return LocalDSDimens;
    }
}
