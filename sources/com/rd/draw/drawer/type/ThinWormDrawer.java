package com.rd.draw.drawer.type;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import androidx.annotation.NonNull;
import com.rd.animation.data.Value;
import com.rd.animation.data.type.ThinWormAnimationValue;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;

public class ThinWormDrawer extends WormDrawer {
    public ThinWormDrawer(@NonNull Paint paint, @NonNull Indicator indicator) {
        super(paint, indicator);
    }

    public void draw(@NonNull Canvas canvas, @NonNull Value value, int i11, int i12) {
        if (value instanceof ThinWormAnimationValue) {
            ThinWormAnimationValue thinWormAnimationValue = (ThinWormAnimationValue) value;
            int rectStart = thinWormAnimationValue.getRectStart();
            int rectEnd = thinWormAnimationValue.getRectEnd();
            int height = thinWormAnimationValue.getHeight() / 2;
            int radius = this.f52920b.getRadius();
            int unselectedColor = this.f52920b.getUnselectedColor();
            int selectedColor = this.f52920b.getSelectedColor();
            if (this.f52920b.getOrientation() == Orientation.HORIZONTAL) {
                RectF rectF = this.rect;
                rectF.left = (float) rectStart;
                rectF.right = (float) rectEnd;
                rectF.top = (float) (i12 - height);
                rectF.bottom = (float) (height + i12);
            } else {
                RectF rectF2 = this.rect;
                rectF2.left = (float) (i11 - height);
                rectF2.right = (float) (height + i11);
                rectF2.top = (float) rectStart;
                rectF2.bottom = (float) rectEnd;
            }
            this.f52919a.setColor(unselectedColor);
            float f11 = (float) i11;
            float f12 = (float) i12;
            float f13 = (float) radius;
            canvas.drawCircle(f11, f12, f13, this.f52919a);
            this.f52919a.setColor(selectedColor);
            canvas.drawRoundRect(this.rect, f13, f13, this.f52919a);
        }
    }
}
