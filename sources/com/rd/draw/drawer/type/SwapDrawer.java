package com.rd.draw.drawer.type;

import android.graphics.Paint;
import androidx.annotation.NonNull;
import com.rd.draw.data.Indicator;

public class SwapDrawer extends BaseDrawer {
    public SwapDrawer(@NonNull Paint paint, @NonNull Indicator indicator) {
        super(paint, indicator);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x006b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(@androidx.annotation.NonNull android.graphics.Canvas r9, @androidx.annotation.NonNull com.rd.animation.data.Value r10, int r11, int r12, int r13) {
        /*
            r8 = this;
            boolean r0 = r10 instanceof com.rd.animation.data.type.SwapAnimationValue
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            com.rd.animation.data.type.SwapAnimationValue r10 = (com.rd.animation.data.type.SwapAnimationValue) r10
            com.rd.draw.data.Indicator r0 = r8.f52920b
            int r0 = r0.getSelectedColor()
            com.rd.draw.data.Indicator r1 = r8.f52920b
            int r1 = r1.getUnselectedColor()
            com.rd.draw.data.Indicator r2 = r8.f52920b
            int r2 = r2.getRadius()
            com.rd.draw.data.Indicator r3 = r8.f52920b
            int r3 = r3.getSelectedPosition()
            com.rd.draw.data.Indicator r4 = r8.f52920b
            int r4 = r4.getSelectingPosition()
            com.rd.draw.data.Indicator r5 = r8.f52920b
            int r5 = r5.getLastSelectedPosition()
            int r6 = r10.getCoordinate()
            com.rd.draw.data.Indicator r7 = r8.f52920b
            boolean r7 = r7.isInteractiveAnimation()
            if (r7 == 0) goto L_0x0045
            if (r11 != r4) goto L_0x003e
            int r6 = r10.getCoordinate()
            goto L_0x0053
        L_0x003e:
            if (r11 != r3) goto L_0x0052
            int r6 = r10.getCoordinateReverse()
            goto L_0x0052
        L_0x0045:
            if (r11 != r5) goto L_0x004c
            int r6 = r10.getCoordinate()
            goto L_0x0053
        L_0x004c:
            if (r11 != r3) goto L_0x0052
            int r6 = r10.getCoordinateReverse()
        L_0x0052:
            r0 = r1
        L_0x0053:
            android.graphics.Paint r10 = r8.f52919a
            r10.setColor(r0)
            com.rd.draw.data.Indicator r10 = r8.f52920b
            com.rd.draw.data.Orientation r10 = r10.getOrientation()
            com.rd.draw.data.Orientation r11 = com.rd.draw.data.Orientation.HORIZONTAL
            if (r10 != r11) goto L_0x006b
            float r10 = (float) r6
            float r11 = (float) r13
            float r12 = (float) r2
            android.graphics.Paint r13 = r8.f52919a
            r9.drawCircle(r10, r11, r12, r13)
            goto L_0x0073
        L_0x006b:
            float r10 = (float) r12
            float r11 = (float) r6
            float r12 = (float) r2
            android.graphics.Paint r13 = r8.f52919a
            r9.drawCircle(r10, r11, r12, r13)
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.rd.draw.drawer.type.SwapDrawer.draw(android.graphics.Canvas, com.rd.animation.data.Value, int, int, int):void");
    }
}
