package com.rd.animation.data.type;

import com.rd.animation.data.Value;

public class DropAnimationValue implements Value {
    private int height;
    private int radius;
    private int width;

    public int getHeight() {
        return this.height;
    }

    public int getRadius() {
        return this.radius;
    }

    public int getWidth() {
        return this.width;
    }

    public void setHeight(int i11) {
        this.height = i11;
    }

    public void setRadius(int i11) {
        this.radius = i11;
    }

    public void setWidth(int i11) {
        this.width = i11;
    }
}
