package androidx.core.splashscreen;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.huawei.hms.flutter.map.constants.Param;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u0010H\u0014J\u0010\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0012\u001a\u00020\rH\u0016J\u0012\u0010\u0013\u001a\u00020\t2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Landroidx/core/splashscreen/MaskedDrawable;", "Landroid/graphics/drawable/Drawable;", "drawable", "maskDiameter", "", "(Landroid/graphics/drawable/Drawable;F)V", "mask", "Landroid/graphics/Path;", "draw", "", "canvas", "Landroid/graphics/Canvas;", "getOpacity", "", "onBoundsChange", "bounds", "Landroid/graphics/Rect;", "setAlpha", "alpha", "setColorFilter", "colorFilter", "Landroid/graphics/ColorFilter;", "core-splashscreen_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MaskedDrawable extends Drawable {
    @NotNull
    private final Drawable drawable;
    @NotNull
    private final Path mask;
    private final float maskDiameter;

    public MaskedDrawable(@NotNull Drawable drawable2, float f11) {
        Intrinsics.checkNotNullParameter(drawable2, "drawable");
        this.drawable = drawable2;
        this.maskDiameter = f11;
        Path path = new Path();
        path.addCircle(0.0f, 0.0f, f11 / 2.0f, Path.Direction.CW);
        this.mask = path;
    }

    public void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        canvas.clipPath(this.mask);
        this.drawable.draw(canvas);
    }

    public int getOpacity() {
        return this.drawable.getOpacity();
    }

    public void onBoundsChange(@NotNull Rect rect) {
        Intrinsics.checkNotNullParameter(rect, Param.BOUNDS);
        super.onBoundsChange(rect);
        this.drawable.setBounds(rect);
        this.mask.offset(rect.exactCenterX(), rect.exactCenterY());
    }

    public void setAlpha(int i11) {
        this.drawable.setAlpha(i11);
    }

    public void setColorFilter(@Nullable ColorFilter colorFilter) {
        this.drawable.setColorFilter(colorFilter);
    }
}
