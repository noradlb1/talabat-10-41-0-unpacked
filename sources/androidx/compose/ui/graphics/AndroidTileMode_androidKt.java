package androidx.compose.ui.graphics;

import android.graphics.Shader;
import android.os.Build;
import androidx.compose.ui.graphics.TileMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0017\u0010\u0005\u001a\u00020\u0006*\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u0012\u0010\t\u001a\u00020\u0002*\u00020\u0006ø\u0001\u0001¢\u0006\u0002\u0010\n\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"isSupported", "", "Landroidx/compose/ui/graphics/TileMode;", "isSupported-0vamqd0", "(I)Z", "toAndroidTileMode", "Landroid/graphics/Shader$TileMode;", "toAndroidTileMode-0vamqd0", "(I)Landroid/graphics/Shader$TileMode;", "toComposeTileMode", "(Landroid/graphics/Shader$TileMode;)I", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AndroidTileMode_androidKt {

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Shader.TileMode.values().length];
            iArr[Shader.TileMode.CLAMP.ordinal()] = 1;
            iArr[Shader.TileMode.MIRROR.ordinal()] = 2;
            iArr[Shader.TileMode.REPEAT.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* renamed from: isSupported-0vamqd0  reason: not valid java name */
    public static final boolean m2819isSupported0vamqd0(int i11) {
        return Build.VERSION.SDK_INT >= 31 || !TileMode.m3270equalsimpl0(i11, TileMode.Companion.m3275getDecal3opZhB0());
    }

    @NotNull
    /* renamed from: toAndroidTileMode-0vamqd0  reason: not valid java name */
    public static final Shader.TileMode m2820toAndroidTileMode0vamqd0(int i11) {
        TileMode.Companion companion = TileMode.Companion;
        if (TileMode.m3270equalsimpl0(i11, companion.m3274getClamp3opZhB0())) {
            return Shader.TileMode.CLAMP;
        }
        if (TileMode.m3270equalsimpl0(i11, companion.m3277getRepeated3opZhB0())) {
            return Shader.TileMode.REPEAT;
        }
        if (TileMode.m3270equalsimpl0(i11, companion.m3276getMirror3opZhB0())) {
            return Shader.TileMode.MIRROR;
        }
        if (!TileMode.m3270equalsimpl0(i11, companion.m3275getDecal3opZhB0())) {
            return Shader.TileMode.CLAMP;
        }
        if (Build.VERSION.SDK_INT >= 31) {
            return TileModeVerificationHelper.INSTANCE.getFrameworkTileModeDecal();
        }
        return Shader.TileMode.CLAMP;
    }

    public static final int toComposeTileMode(@NotNull Shader.TileMode tileMode) {
        Intrinsics.checkNotNullParameter(tileMode, "<this>");
        int i11 = WhenMappings.$EnumSwitchMapping$0[tileMode.ordinal()];
        if (i11 == 1) {
            return TileMode.Companion.m3274getClamp3opZhB0();
        }
        if (i11 == 2) {
            return TileMode.Companion.m3276getMirror3opZhB0();
        }
        if (i11 == 3) {
            return TileMode.Companion.m3277getRepeated3opZhB0();
        }
        if (Build.VERSION.SDK_INT < 31 || tileMode != Shader.TileMode.DECAL) {
            return TileMode.Companion.m3274getClamp3opZhB0();
        }
        return TileModeVerificationHelper.INSTANCE.m3278getComposeTileModeDecal3opZhB0();
    }
}
