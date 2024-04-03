package androidx.compose.material;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ReadOnlyComposable;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a%\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0003ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\f\u0010\r\"\u001a\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001ø\u0001\u0000¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0004\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, d2 = {"LocalAbsoluteElevation", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/unit/Dp;", "getLocalAbsoluteElevation", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "LocalElevationOverlay", "Landroidx/compose/material/ElevationOverlay;", "getLocalElevationOverlay", "calculateForegroundColor", "Landroidx/compose/ui/graphics/Color;", "backgroundColor", "elevation", "calculateForegroundColor-CLU3JFs", "(JFLandroidx/compose/runtime/Composer;I)J", "material_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ElevationOverlayKt {
    @NotNull
    private static final ProvidableCompositionLocal<Dp> LocalAbsoluteElevation = CompositionLocalKt.compositionLocalOf$default((SnapshotMutationPolicy) null, ElevationOverlayKt$LocalAbsoluteElevation$1.INSTANCE, 1, (Object) null);
    @NotNull
    private static final ProvidableCompositionLocal<ElevationOverlay> LocalElevationOverlay = CompositionLocalKt.staticCompositionLocalOf(ElevationOverlayKt$LocalElevationOverlay$1.INSTANCE);

    /* access modifiers changed from: private */
    @ReadOnlyComposable
    @Composable
    /* renamed from: calculateForegroundColor-CLU3JFs  reason: not valid java name */
    public static final long m1249calculateForegroundColorCLU3JFs(long j11, float f11, Composer composer, int i11) {
        return Color.m2918copywmQWz5c$default(ColorsKt.m1197contentColorForek8zF_U(j11, composer, i11 & 14), ((((float) Math.log((double) (f11 + ((float) 1)))) * 4.5f) + 2.0f) / 100.0f, 0.0f, 0.0f, 0.0f, 14, (Object) null);
    }

    @NotNull
    public static final ProvidableCompositionLocal<Dp> getLocalAbsoluteElevation() {
        return LocalAbsoluteElevation;
    }

    @NotNull
    public static final ProvidableCompositionLocal<ElevationOverlay> getLocalElevationOverlay() {
        return LocalElevationOverlay;
    }
}
