package com.designsystem.ds_theme;

import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.unit.Dp;
import com.designsystem.ds_box_shadow.Shadow;
import com.designsystem.ds_box_shadow.ShadowOffset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0014\u0010\u0005\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"LocalDSElevation", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Lcom/designsystem/ds_theme/DSElevation;", "getLocalDSElevation", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "defaultDSElevation", "getDefaultDSElevation", "()Lcom/designsystem/ds_theme/DSElevation;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class DSElevationKt {
    @NotNull
    private static final ProvidableCompositionLocal<DSElevation> LocalDSElevation = CompositionLocalKt.staticCompositionLocalOf(DSElevationKt$LocalDSElevation$1.INSTANCE);
    @NotNull
    private static final DSElevation defaultDSElevation;

    static {
        float f11 = (float) 2;
        float f12 = (float) 0;
        float f13 = (float) 1;
        float f14 = (float) 8;
        defaultDSElevation = new DSElevation(CollectionsKt__CollectionsKt.listOf(new Shadow(ColorKt.Color(335544320), new ShadowOffset(Dp.m5478constructorimpl(f12), Dp.m5478constructorimpl(f11), (DefaultConstructorMarker) null), Dp.m5478constructorimpl(f11), (DefaultConstructorMarker) null), new Shadow(ColorKt.Color(436207616), (ShadowOffset) null, Dp.m5478constructorimpl(f11), 2, (DefaultConstructorMarker) null), new Shadow(ColorKt.Color(335544320), (ShadowOffset) null, Dp.m5478constructorimpl(f13), 2, (DefaultConstructorMarker) null)), CollectionsKt__CollectionsKt.listOf(new Shadow(ColorKt.Color(335544320), new ShadowOffset(Dp.m5478constructorimpl(f12), Dp.m5478constructorimpl((float) 3), (DefaultConstructorMarker) null), Dp.m5478constructorimpl(f14), (DefaultConstructorMarker) null), new Shadow(ColorKt.Color(436207616), (ShadowOffset) null, Dp.m5478constructorimpl((float) 6), 2, (DefaultConstructorMarker) null), new Shadow(ColorKt.Color(83886080), (ShadowOffset) null, Dp.m5478constructorimpl(f13), 2, (DefaultConstructorMarker) null)), CollectionsKt__CollectionsKt.listOf(new Shadow(ColorKt.Color(335544320), new ShadowOffset(Dp.m5478constructorimpl(f12), Dp.m5478constructorimpl(f14), (DefaultConstructorMarker) null), Dp.m5478constructorimpl((float) 10), (DefaultConstructorMarker) null), new Shadow(ColorKt.Color(436207616), (ShadowOffset) null, Dp.m5478constructorimpl(f14), 2, (DefaultConstructorMarker) null), new Shadow(ColorKt.Color(83886080), (ShadowOffset) null, Dp.m5478constructorimpl(f13), 2, (DefaultConstructorMarker) null)));
    }

    @NotNull
    public static final DSElevation getDefaultDSElevation() {
        return defaultDSElevation;
    }

    @NotNull
    public static final ProvidableCompositionLocal<DSElevation> getLocalDSElevation() {
        return LocalDSElevation;
    }
}
