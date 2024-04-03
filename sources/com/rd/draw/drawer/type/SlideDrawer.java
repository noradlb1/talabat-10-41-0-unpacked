package com.rd.draw.drawer.type;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.rd.animation.data.Value;
import com.rd.animation.data.type.SlideAnimationValue;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;

public class SlideDrawer extends BaseDrawer {
    public SlideDrawer(@NonNull Paint paint, @NonNull Indicator indicator) {
        super(paint, indicator);
    }

    public void draw(@NonNull Canvas canvas, @NonNull Value value, int i11, int i12) {
        if (value instanceof SlideAnimationValue) {
            int coordinate = ((SlideAnimationValue) value).getCoordinate();
            int unselectedColor = this.f52920b.getUnselectedColor();
            int selectedColor = this.f52920b.getSelectedColor();
            int radius = this.f52920b.getRadius();
            this.f52919a.setColor(unselectedColor);
            float f11 = (float) i11;
            float f12 = (float) i12;
            float f13 = (float) radius;
            canvas.drawCircle(f11, f12, f13, this.f52919a);
            this.f52919a.setColor(selectedColor);
            if (this.f52920b.getOrientation() == Orientation.HORIZONTAL) {
                canvas.drawCircle((float) coordinate, f12, f13, this.f52919a);
            } else {
                canvas.drawCircle(f11, (float) coordinate, f13, this.f52919a);
            }
        }
    }
}
