package com.rd.animation.data.type;

import com.rd.animation.data.Value;

public class SwapAnimationValue implements Value {
    private int coordinate;
    private int coordinateReverse;

    public int getCoordinate() {
        return this.coordinate;
    }

    public int getCoordinateReverse() {
        return this.coordinateReverse;
    }

    public void setCoordinate(int i11) {
        this.coordinate = i11;
    }

    public void setCoordinateReverse(int i11) {
        this.coordinateReverse = i11;
    }
}
