package com.rd.draw.controller;

import android.util.Pair;
import android.view.View;
import androidx.annotation.NonNull;
import com.rd.animation.type.AnimationType;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;

public class MeasureController {
    public Pair<Integer, Integer> measureViewSize(@NonNull Indicator indicator, int i11, int i12) {
        int i13;
        int i14;
        Indicator indicator2 = indicator;
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        int mode2 = View.MeasureSpec.getMode(i12);
        int size2 = View.MeasureSpec.getSize(i12);
        int count = indicator.getCount();
        int radius = indicator.getRadius();
        int stroke = indicator.getStroke();
        int padding = indicator.getPadding();
        int paddingLeft = indicator.getPaddingLeft();
        int paddingTop = indicator.getPaddingTop();
        int paddingRight = indicator.getPaddingRight();
        int paddingBottom = indicator.getPaddingBottom();
        int i15 = radius * 2;
        Orientation orientation = indicator.getOrientation();
        int i16 = 0;
        if (count != 0) {
            i13 = (i15 * count) + (stroke * 2 * count) + (padding * (count - 1));
            i14 = i15 + stroke;
            if (orientation != Orientation.HORIZONTAL) {
                int i17 = i13;
                i13 = i14;
                i14 = i17;
            }
        } else {
            i14 = 0;
            i13 = 0;
        }
        if (indicator.getAnimationType() == AnimationType.DROP) {
            if (orientation == Orientation.HORIZONTAL) {
                i14 *= 2;
            } else {
                i13 *= 2;
            }
        }
        Orientation orientation2 = Orientation.HORIZONTAL;
        int i18 = i13 + paddingLeft + paddingRight;
        int i19 = i14 + paddingTop + paddingBottom;
        if (mode != 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(i18, size);
            } else {
                size = i18;
            }
        }
        if (mode2 != 1073741824) {
            if (mode2 == Integer.MIN_VALUE) {
                size2 = Math.min(i19, size2);
            } else {
                size2 = i19;
            }
        }
        if (size < 0) {
            size = 0;
        }
        if (size2 >= 0) {
            i16 = size2;
        }
        indicator2.setWidth(size);
        indicator2.setHeight(i16);
        return new Pair<>(Integer.valueOf(size), Integer.valueOf(i16));
    }
}
