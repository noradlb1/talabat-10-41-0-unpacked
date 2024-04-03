package com.rd.animation.data.type;

import com.rd.animation.data.Value;

public class ColorAnimationValue implements Value {
    private int color;
    private int colorReverse;

    public int getColor() {
        return this.color;
    }

    public int getColorReverse() {
        return this.colorReverse;
    }

    public void setColor(int i11) {
        this.color = i11;
    }

    public void setColorReverse(int i11) {
        this.colorReverse = i11;
    }
}
