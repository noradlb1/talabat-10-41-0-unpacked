package androidx.compose.ui.graphics;

import android.graphics.BlendMode;
import android.graphics.PorterDuff;
import android.os.Build;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.graphics.BlendMode;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0017\u0010\u0000\u001a\u00020\u0001*\u00020\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0003\u0010\u0004\u001a\u0019\u0010\u0005\u001a\u00020\u0006*\u00020\u0002H\u0001ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a\u0019\u0010\t\u001a\u00020\n*\u00020\u0002H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000b\u0010\f\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\r"}, d2 = {"isSupported", "", "Landroidx/compose/ui/graphics/BlendMode;", "isSupported-s9anfk8", "(I)Z", "toAndroidBlendMode", "Landroid/graphics/BlendMode;", "toAndroidBlendMode-s9anfk8", "(I)Landroid/graphics/BlendMode;", "toPorterDuffMode", "Landroid/graphics/PorterDuff$Mode;", "toPorterDuffMode-s9anfk8", "(I)Landroid/graphics/PorterDuff$Mode;", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AndroidBlendMode_androidKt {
    /* renamed from: isSupported-s9anfk8  reason: not valid java name */
    public static final boolean m2767isSupporteds9anfk8(int i11) {
        if (Build.VERSION.SDK_INT >= 29 || BlendMode.m2826equalsimpl0(i11, BlendMode.Companion.m2857getSrcOver0nO6VwU()) || m2769toPorterDuffModes9anfk8(i11) != PorterDuff.Mode.SRC_OVER) {
            return true;
        }
        return false;
    }

    @RequiresApi(29)
    @NotNull
    /* renamed from: toAndroidBlendMode-s9anfk8  reason: not valid java name */
    public static final BlendMode m2768toAndroidBlendModes9anfk8(int i11) {
        BlendMode.Companion companion = BlendMode.Companion;
        if (BlendMode.m2826equalsimpl0(i11, companion.m2830getClear0nO6VwU())) {
            return android.graphics.BlendMode.CLEAR;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2853getSrc0nO6VwU())) {
            return android.graphics.BlendMode.SRC;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2836getDst0nO6VwU())) {
            return android.graphics.BlendMode.DST;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2857getSrcOver0nO6VwU())) {
            return android.graphics.BlendMode.SRC_OVER;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2840getDstOver0nO6VwU())) {
            return android.graphics.BlendMode.DST_OVER;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2855getSrcIn0nO6VwU())) {
            return android.graphics.BlendMode.SRC_IN;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2838getDstIn0nO6VwU())) {
            return android.graphics.BlendMode.DST_IN;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2856getSrcOut0nO6VwU())) {
            return android.graphics.BlendMode.SRC_OUT;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2839getDstOut0nO6VwU())) {
            return android.graphics.BlendMode.DST_OUT;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2854getSrcAtop0nO6VwU())) {
            return android.graphics.BlendMode.SRC_ATOP;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2837getDstAtop0nO6VwU())) {
            return android.graphics.BlendMode.DST_ATOP;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2858getXor0nO6VwU())) {
            return android.graphics.BlendMode.XOR;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2849getPlus0nO6VwU())) {
            return android.graphics.BlendMode.PLUS;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2846getModulate0nO6VwU())) {
            return android.graphics.BlendMode.MODULATE;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2851getScreen0nO6VwU())) {
            return android.graphics.BlendMode.SCREEN;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2848getOverlay0nO6VwU())) {
            return android.graphics.BlendMode.OVERLAY;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2834getDarken0nO6VwU())) {
            return android.graphics.BlendMode.DARKEN;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2844getLighten0nO6VwU())) {
            return android.graphics.BlendMode.LIGHTEN;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2833getColorDodge0nO6VwU())) {
            return android.graphics.BlendMode.COLOR_DODGE;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2832getColorBurn0nO6VwU())) {
            return android.graphics.BlendMode.COLOR_BURN;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2842getHardlight0nO6VwU())) {
            return android.graphics.BlendMode.HARD_LIGHT;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2852getSoftlight0nO6VwU())) {
            return android.graphics.BlendMode.SOFT_LIGHT;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2835getDifference0nO6VwU())) {
            return android.graphics.BlendMode.DIFFERENCE;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2841getExclusion0nO6VwU())) {
            return android.graphics.BlendMode.EXCLUSION;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2847getMultiply0nO6VwU())) {
            return android.graphics.BlendMode.MULTIPLY;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2843getHue0nO6VwU())) {
            return android.graphics.BlendMode.HUE;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2850getSaturation0nO6VwU())) {
            return android.graphics.BlendMode.SATURATION;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2831getColor0nO6VwU())) {
            return android.graphics.BlendMode.COLOR;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2845getLuminosity0nO6VwU())) {
            return android.graphics.BlendMode.LUMINOSITY;
        }
        return android.graphics.BlendMode.SRC_OVER;
    }

    @NotNull
    /* renamed from: toPorterDuffMode-s9anfk8  reason: not valid java name */
    public static final PorterDuff.Mode m2769toPorterDuffModes9anfk8(int i11) {
        BlendMode.Companion companion = BlendMode.Companion;
        if (BlendMode.m2826equalsimpl0(i11, companion.m2830getClear0nO6VwU())) {
            return PorterDuff.Mode.CLEAR;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2853getSrc0nO6VwU())) {
            return PorterDuff.Mode.SRC;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2836getDst0nO6VwU())) {
            return PorterDuff.Mode.DST;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2857getSrcOver0nO6VwU())) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2840getDstOver0nO6VwU())) {
            return PorterDuff.Mode.DST_OVER;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2855getSrcIn0nO6VwU())) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2838getDstIn0nO6VwU())) {
            return PorterDuff.Mode.DST_IN;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2856getSrcOut0nO6VwU())) {
            return PorterDuff.Mode.SRC_OUT;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2839getDstOut0nO6VwU())) {
            return PorterDuff.Mode.DST_OUT;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2854getSrcAtop0nO6VwU())) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2837getDstAtop0nO6VwU())) {
            return PorterDuff.Mode.DST_ATOP;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2858getXor0nO6VwU())) {
            return PorterDuff.Mode.XOR;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2849getPlus0nO6VwU())) {
            return PorterDuff.Mode.ADD;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2851getScreen0nO6VwU())) {
            return PorterDuff.Mode.SCREEN;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2848getOverlay0nO6VwU())) {
            return PorterDuff.Mode.OVERLAY;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2834getDarken0nO6VwU())) {
            return PorterDuff.Mode.DARKEN;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2844getLighten0nO6VwU())) {
            return PorterDuff.Mode.LIGHTEN;
        }
        if (BlendMode.m2826equalsimpl0(i11, companion.m2846getModulate0nO6VwU())) {
            return PorterDuff.Mode.MULTIPLY;
        }
        return PorterDuff.Mode.SRC_OVER;
    }
}
