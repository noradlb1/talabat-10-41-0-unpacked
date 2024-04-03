package com.rd.animation.data.type;

import com.rd.animation.data.Value;

public class WormAnimationValue implements Value {
    private int rectEnd;
    private int rectStart;

    public int getRectEnd() {
        return this.rectEnd;
    }

    public int getRectStart() {
        return this.rectStart;
    }

    public void setRectEnd(int i11) {
        this.rectEnd = i11;
    }

    public void setRectStart(int i11) {
        this.rectStart = i11;
    }
}
