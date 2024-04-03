package com.uxcam.video.screen.codec.codecs.h264.io.model;

public class AspectRatio {
    public static final AspectRatio Extended_SAR = new AspectRatio(255);
    private final int value;

    private AspectRatio(int i11) {
        this.value = i11;
    }

    public static AspectRatio fromValue(int i11) {
        AspectRatio aspectRatio = Extended_SAR;
        if (i11 == aspectRatio.value) {
            return aspectRatio;
        }
        return new AspectRatio(i11);
    }

    public int getValue() {
        return this.value;
    }
}
