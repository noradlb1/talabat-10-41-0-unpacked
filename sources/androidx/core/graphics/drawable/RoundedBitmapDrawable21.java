package androidx.core.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Outline;
import android.graphics.Rect;
import android.view.Gravity;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

@RequiresApi(21)
class RoundedBitmapDrawable21 extends RoundedBitmapDrawable {
    public RoundedBitmapDrawable21(Resources resources, Bitmap bitmap) {
        super(resources, bitmap);
    }

    public void a(int i11, int i12, int i13, Rect rect, Rect rect2) {
        Gravity.apply(i11, i12, i13, rect, rect2, 0);
    }

    public void getOutline(@NonNull Outline outline) {
        b();
        outline.setRoundRect(this.f11298b, getCornerRadius());
    }

    public boolean hasMipMap() {
        Bitmap bitmap = this.f11297a;
        return bitmap != null && bitmap.hasMipMap();
    }

    public void setMipMap(boolean z11) {
        Bitmap bitmap = this.f11297a;
        if (bitmap != null) {
            bitmap.setHasMipMap(z11);
            invalidateSelf();
        }
    }
}
