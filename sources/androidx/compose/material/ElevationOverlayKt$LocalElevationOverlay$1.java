package androidx.compose.material;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/compose/material/ElevationOverlay;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ElevationOverlayKt$LocalElevationOverlay$1 extends Lambda implements Function0<ElevationOverlay> {
    public static final ElevationOverlayKt$LocalElevationOverlay$1 INSTANCE = new ElevationOverlayKt$LocalElevationOverlay$1();

    public ElevationOverlayKt$LocalElevationOverlay$1() {
        super(0);
    }

    @Nullable
    public final ElevationOverlay invoke() {
        return DefaultElevationOverlay.INSTANCE;
    }
}
