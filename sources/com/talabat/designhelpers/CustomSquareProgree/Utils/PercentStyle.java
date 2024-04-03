package com.talabat.designhelpers.CustomSquareProgree.Utils;

import android.graphics.Paint;
import androidx.core.view.ViewCompat;

public class PercentStyle {
    private Paint.Align align;
    private String customText = "%";
    private boolean percentSign;
    private int textColor = ViewCompat.MEASURED_STATE_MASK;
    private float textSize;

    public PercentStyle() {
    }

    public Paint.Align getAlign() {
        return this.align;
    }

    public String getCustomText() {
        return this.customText;
    }

    public int getTextColor() {
        return this.textColor;
    }

    public float getTextSize() {
        return this.textSize;
    }

    public boolean isPercentSign() {
        return this.percentSign;
    }

    public void setAlign(Paint.Align align2) {
        this.align = align2;
    }

    public void setCustomText(String str) {
        this.customText = str;
    }

    public void setPercentSign(boolean z11) {
        this.percentSign = z11;
    }

    public void setTextColor(int i11) {
        this.textColor = i11;
    }

    public void setTextSize(float f11) {
        this.textSize = f11;
    }

    public PercentStyle(Paint.Align align2, float f11, boolean z11) {
        this.align = align2;
        this.textSize = f11;
        this.percentSign = z11;
    }
}
