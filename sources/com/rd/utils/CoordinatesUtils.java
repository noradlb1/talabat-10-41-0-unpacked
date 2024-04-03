package com.rd.utils;

import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.rd.animation.type.AnimationType;
import com.rd.draw.data.Indicator;
import com.rd.draw.data.Orientation;

public class CoordinatesUtils {
    public static int getCoordinate(@Nullable Indicator indicator, int i11) {
        if (indicator == null) {
            return 0;
        }
        if (indicator.getOrientation() == Orientation.HORIZONTAL) {
            return getXCoordinate(indicator, i11);
        }
        return getYCoordinate(indicator, i11);
    }

    private static int getFitPosition(@NonNull Indicator indicator, float f11, float f12) {
        int i11;
        int i12;
        boolean z11;
        int count = indicator.getCount();
        int radius = indicator.getRadius();
        int stroke = indicator.getStroke();
        int padding = indicator.getPadding();
        if (indicator.getOrientation() == Orientation.HORIZONTAL) {
            i11 = indicator.getHeight();
        } else {
            i11 = indicator.getWidth();
        }
        int i13 = 0;
        int i14 = 0;
        while (i13 < count) {
            if (i13 > 0) {
                i12 = padding;
            } else {
                i12 = padding / 2;
            }
            int i15 = (radius * 2) + (stroke / 2) + i12 + i14;
            boolean z12 = true;
            if (f11 < ((float) i14) || f11 > ((float) i15)) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (f12 < 0.0f || f12 > ((float) i11)) {
                z12 = false;
            }
            if (z11 && z12) {
                return i13;
            }
            i13++;
            i14 = i15;
        }
        return -1;
    }

    private static int getHorizontalCoordinate(@NonNull Indicator indicator, int i11) {
        int count = indicator.getCount();
        int radius = indicator.getRadius();
        int stroke = indicator.getStroke();
        int padding = indicator.getPadding();
        int i12 = 0;
        for (int i13 = 0; i13 < count; i13++) {
            int i14 = stroke / 2;
            int i15 = i12 + radius + i14;
            if (i11 == i13) {
                return i15;
            }
            i12 = i15 + radius + padding + i14;
        }
        if (indicator.getAnimationType() == AnimationType.DROP) {
            return i12 + (radius * 2);
        }
        return i12;
    }

    public static int getPosition(@Nullable Indicator indicator, float f11, float f12) {
        if (indicator == null) {
            return -1;
        }
        if (indicator.getOrientation() != Orientation.HORIZONTAL) {
            float f13 = f12;
            f12 = f11;
            f11 = f13;
        }
        return getFitPosition(indicator, f11, f12);
    }

    public static Pair<Integer, Float> getProgress(@NonNull Indicator indicator, int i11, float f11, boolean z11) {
        boolean z12;
        boolean z13;
        int count = indicator.getCount();
        int selectedPosition = indicator.getSelectedPosition();
        if (z11) {
            i11 = (count - 1) - i11;
        }
        boolean z14 = false;
        if (i11 < 0) {
            i11 = 0;
        } else {
            int i12 = count - 1;
            if (i11 > i12) {
                i11 = i12;
            }
        }
        if (i11 > selectedPosition) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z11 ? i11 + 1 >= selectedPosition : i11 - 1 >= selectedPosition) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (z12 || z13) {
            indicator.setSelectedPosition(i11);
            selectedPosition = i11;
        }
        float f12 = 0.0f;
        if (selectedPosition == i11 && f11 != 0.0f) {
            z14 = true;
        }
        if (!z14) {
            f11 = 1.0f - f11;
        } else if (z11) {
            i11--;
        } else {
            i11++;
        }
        if (f11 > 1.0f) {
            f12 = 1.0f;
        } else if (f11 >= 0.0f) {
            f12 = f11;
        }
        return new Pair<>(Integer.valueOf(i11), Float.valueOf(f12));
    }

    private static int getVerticalCoordinate(@NonNull Indicator indicator) {
        int radius = indicator.getRadius();
        if (indicator.getAnimationType() == AnimationType.DROP) {
            return radius * 3;
        }
        return radius;
    }

    public static int getXCoordinate(@Nullable Indicator indicator, int i11) {
        int i12;
        if (indicator == null) {
            return 0;
        }
        if (indicator.getOrientation() == Orientation.HORIZONTAL) {
            i12 = getHorizontalCoordinate(indicator, i11);
        } else {
            i12 = getVerticalCoordinate(indicator);
        }
        return i12 + indicator.getPaddingLeft();
    }

    public static int getYCoordinate(@Nullable Indicator indicator, int i11) {
        int i12;
        if (indicator == null) {
            return 0;
        }
        if (indicator.getOrientation() == Orientation.HORIZONTAL) {
            i12 = getVerticalCoordinate(indicator);
        } else {
            i12 = getHorizontalCoordinate(indicator, i11);
        }
        return i12 + indicator.getPaddingTop();
    }
}
