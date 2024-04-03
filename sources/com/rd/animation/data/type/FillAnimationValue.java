package com.rd.animation.data.type;

public class FillAnimationValue extends ColorAnimationValue {
    private int radius;
    private int radiusReverse;
    private int stroke;
    private int strokeReverse;

    public int getRadius() {
        return this.radius;
    }

    public int getRadiusReverse() {
        return this.radiusReverse;
    }

    public int getStroke() {
        return this.stroke;
    }

    public int getStrokeReverse() {
        return this.strokeReverse;
    }

    public void setRadius(int i11) {
        this.radius = i11;
    }

    public void setRadiusReverse(int i11) {
        this.radiusReverse = i11;
    }

    public void setStroke(int i11) {
        this.stroke = i11;
    }

    public void setStrokeReverse(int i11) {
        this.strokeReverse = i11;
    }
}
