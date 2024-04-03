package com.rd.draw.drawer.type;

import android.graphics.Canvas;
import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.rd.animation.data.Value;
import com.rd.animation.data.type.ColorAnimationValue;
import com.rd.draw.data.Indicator;

public class ColorDrawer extends BaseDrawer {
    public ColorDrawer(@NonNull Paint paint, @NonNull Indicator indicator) {
        super(paint, indicator);
    }

    public void draw(@NonNull Canvas canvas, @NonNull Value value, int i11, int i12, int i13) {
        if (value instanceof ColorAnimationValue) {
            ColorAnimationValue colorAnimationValue = (ColorAnimationValue) value;
            float radius = (float) this.f52920b.getRadius();
            int selectedColor = this.f52920b.getSelectedColor();
            int selectedPosition = this.f52920b.getSelectedPosition();
            int selectingPosition = this.f52920b.getSelectingPosition();
            int lastSelectedPosition = this.f52920b.getLastSelectedPosition();
            if (this.f52920b.isInteractiveAnimation()) {
                if (i11 == selectingPosition) {
                    selectedColor = colorAnimationValue.getColor();
                } else if (i11 == selectedPosition) {
                    selectedColor = colorAnimationValue.getColorReverse();
                }
            } else if (i11 == selectedPosition) {
                selectedColor = colorAnimationValue.getColor();
            } else if (i11 == lastSelectedPosition) {
                selectedColor = colorAnimationValue.getColorReverse();
            }
            this.f52919a.setColor(selectedColor);
            canvas.drawCircle((float) i12, (float) i13, radius, this.f52919a);
        }
    }
}
