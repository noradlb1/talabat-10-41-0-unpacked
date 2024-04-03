package com.uxcam.video.screen.codec.codecs.h264.io.model;

public class RefPicMarkingIDR {
    public boolean discardDecodedPics;
    public boolean useForlongTerm;

    public RefPicMarkingIDR(boolean z11, boolean z12) {
        this.discardDecodedPics = z11;
        this.useForlongTerm = z12;
    }

    public boolean isDiscardDecodedPics() {
        return this.discardDecodedPics;
    }

    public boolean isUseForlongTerm() {
        return this.useForlongTerm;
    }
}
