package com.rd.draw.drawer.type;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.rd.animation.data.Value;
import com.rd.animation.data.type.ScaleAnimationValue;
import com.rd.draw.data.Indicator;

public class ScaleDownDrawer extends BaseDrawer {
    public ScaleDownDrawer(@NonNull Paint paint, @NonNull Indicator indicator) {
        super(paint, indicator);
    }

    public void draw(@NonNull Canvas canvas, @NonNull Value value, int i11, int i12, int i13) {
        if (value instanceof ScaleAnimationValue) {
            ScaleAnimationValue scaleAnimationValue = (ScaleAnimationValue) value;
            float radius = (float) this.f52920b.getRadius();
            int selectedColor = this.f52920b.getSelectedColor();
            int selectedPosition = this.f52920b.getSelectedPosition();
            int selectingPosition = this.f52920b.getSelectingPosition();
            int lastSelectedPosition = this.f52920b.getLastSelectedPosition();
            if (this.f52920b.isInteractiveAnimation()) {
                if (i11 == selectingPosition) {
                    radius = (float) scaleAnimationValue.getRadius();
                    selectedColor = scaleAnimationValue.getColor();
                } else if (i11 == selectedPosition) {
                    radius = (float) scaleAnimationValue.getRadiusReverse();
                    selectedColor = scaleAnimationValue.getColorReverse();
                }
            } else if (i11 == selectedPosition) {
                radius = (float) scaleAnimationValue.getRadius();
                selectedColor = scaleAnimationValue.getColor();
            } else if (i11 == lastSelectedPosition) {
                radius = (float) scaleAnimationValue.getRadiusReverse();
                selectedColor = scaleAnimationValue.getColorReverse();
            }
            this.f52919a.setColor(selectedColor);
            canvas.drawCircle((float) i12, (float) i13, radius, this.f52919a);
        }
    }
}
