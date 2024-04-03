package com.instabug.survey.ui.custom;

import android.content.Context;
import android.util.AttributeSet;

public class RatingView extends j {
    public RatingView(Context context) {
        super(context);
    }

    public RatingView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RatingView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    public boolean d() {
        return false;
    }

    public float getLowerInnerPointsYUpperDeviation() {
        return 1.0f;
    }

    public float getPointsLowerDeviation() {
        return 1.0f;
    }

    public float getPointsUpperDeviation() {
        return 1.0f;
    }

    public float getStarBorderWidth() {
        return 5.0f;
    }

    public float getStarCornerRadius() {
        return 1.0f;
    }
}
