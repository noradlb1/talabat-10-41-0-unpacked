package com.rd.draw.drawer.type;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.rd.animation.data.Value;
import com.rd.animation.data.type.DropAnimationValue;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;

public class DropDrawer extends BaseDrawer {
    public DropDrawer(@NonNull Paint paint, @NonNull Indicator indicator) {
        super(paint, indicator);
    }

    public void draw(@NonNull Canvas canvas, @NonNull Value value, int i11, int i12) {
        if (value instanceof DropAnimationValue) {
            DropAnimationValue dropAnimationValue = (DropAnimationValue) value;
            int unselectedColor = this.f52920b.getUnselectedColor();
            int selectedColor = this.f52920b.getSelectedColor();
            this.f52919a.setColor(unselectedColor);
            canvas.drawCircle((float) i11, (float) i12, (float) this.f52920b.getRadius(), this.f52919a);
            this.f52919a.setColor(selectedColor);
            if (this.f52920b.getOrientation() == Orientation.HORIZONTAL) {
                canvas.drawCircle((float) dropAnimationValue.getWidth(), (float) dropAnimationValue.getHeight(), (float) dropAnimationValue.getRadius(), this.f52919a);
            } else {
                canvas.drawCircle((float) dropAnimationValue.getHeight(), (float) dropAnimationValue.getWidth(), (float) dropAnimationValue.getRadius(), this.f52919a);
            }
        }
    }
}
