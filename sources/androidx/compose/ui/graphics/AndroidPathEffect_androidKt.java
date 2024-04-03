package androidx.compose.ui.graphics;

import android.graphics.ComposePathEffect;
import android.graphics.CornerPathEffect;
import android.graphics.DashPathEffect;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import androidx.compose.ui.graphics.StampedPathEffectStyle;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0018\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000\u001a\u0010\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0000\u001a\u0018\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006H\u0000\u001a5\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0010H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\u0012\u001a\n\u0010\u0013\u001a\u00020\u0014*\u00020\u0001\u001a\u0019\u0010\u0015\u001a\u00020\u0016*\u00020\u0010H\u0000ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0017\u0010\u0018\u001a\n\u0010\u0019\u001a\u00020\u0001*\u00020\u0014\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"actualChainPathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "outer", "inner", "actualCornerPathEffect", "radius", "", "actualDashPathEffect", "intervals", "", "phase", "actualStampedPathEffect", "shape", "Landroidx/compose/ui/graphics/Path;", "advance", "style", "Landroidx/compose/ui/graphics/StampedPathEffectStyle;", "actualStampedPathEffect-7aD1DOk", "(Landroidx/compose/ui/graphics/Path;FFI)Landroidx/compose/ui/graphics/PathEffect;", "asAndroidPathEffect", "Landroid/graphics/PathEffect;", "toAndroidPathDashPathEffectStyle", "Landroid/graphics/PathDashPathEffect$Style;", "toAndroidPathDashPathEffectStyle-oQv6xUo", "(I)Landroid/graphics/PathDashPathEffect$Style;", "toComposePathEffect", "ui-graphics_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class AndroidPathEffect_androidKt {
    @NotNull
    public static final PathEffect actualChainPathEffect(@NotNull PathEffect pathEffect, @NotNull PathEffect pathEffect2) {
        Intrinsics.checkNotNullParameter(pathEffect, "outer");
        Intrinsics.checkNotNullParameter(pathEffect2, "inner");
        return new AndroidPathEffect(new ComposePathEffect(((AndroidPathEffect) pathEffect).getNativePathEffect(), ((AndroidPathEffect) pathEffect2).getNativePathEffect()));
    }

    @NotNull
    public static final PathEffect actualCornerPathEffect(float f11) {
        return new AndroidPathEffect(new CornerPathEffect(f11));
    }

    @NotNull
    public static final PathEffect actualDashPathEffect(@NotNull float[] fArr, float f11) {
        Intrinsics.checkNotNullParameter(fArr, "intervals");
        return new AndroidPathEffect(new DashPathEffect(fArr, f11));
    }

    @NotNull
    /* renamed from: actualStampedPathEffect-7aD1DOk  reason: not valid java name */
    public static final PathEffect m2813actualStampedPathEffect7aD1DOk(@NotNull Path path, float f11, float f12, int i11) {
        Intrinsics.checkNotNullParameter(path, "shape");
        if (path instanceof AndroidPath) {
            return new AndroidPathEffect(new PathDashPathEffect(((AndroidPath) path).getInternalPath(), f11, f12, m2814toAndroidPathDashPathEffectStyleoQv6xUo(i11)));
        }
        throw new UnsupportedOperationException("Unable to obtain android.graphics.Path");
    }

    @NotNull
    public static final PathEffect asAndroidPathEffect(@NotNull PathEffect pathEffect) {
        Intrinsics.checkNotNullParameter(pathEffect, "<this>");
        return ((AndroidPathEffect) pathEffect).getNativePathEffect();
    }

    @NotNull
    /* renamed from: toAndroidPathDashPathEffectStyle-oQv6xUo  reason: not valid java name */
    public static final PathDashPathEffect.Style m2814toAndroidPathDashPathEffectStyleoQv6xUo(int i11) {
        StampedPathEffectStyle.Companion companion = StampedPathEffectStyle.Companion;
        if (StampedPathEffectStyle.m3239equalsimpl0(i11, companion.m3243getMorphYpspkwk())) {
            return PathDashPathEffect.Style.MORPH;
        }
        if (StampedPathEffectStyle.m3239equalsimpl0(i11, companion.m3244getRotateYpspkwk())) {
            return PathDashPathEffect.Style.ROTATE;
        }
        if (StampedPathEffectStyle.m3239equalsimpl0(i11, companion.m3245getTranslateYpspkwk())) {
            return PathDashPathEffect.Style.TRANSLATE;
        }
        return PathDashPathEffect.Style.TRANSLATE;
    }

    @NotNull
    public static final PathEffect toComposePathEffect(@NotNull PathEffect pathEffect) {
        Intrinsics.checkNotNullParameter(pathEffect, "<this>");
        return new AndroidPathEffect(pathEffect);
    }
}
