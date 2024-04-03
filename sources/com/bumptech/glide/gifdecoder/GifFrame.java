package com.bumptech.glide.gifdecoder;

import androidx.annotation.ColorInt;

class GifFrame {
    static final int DISPOSAL_BACKGROUND = 2;
    static final int DISPOSAL_NONE = 1;
    static final int DISPOSAL_PREVIOUS = 3;
    static final int DISPOSAL_UNSPECIFIED = 0;
    int bufferFrameStart;
    int delay;
    int dispose;

    /* renamed from: ih  reason: collision with root package name */
    int f44181ih;
    boolean interlace;

    /* renamed from: iw  reason: collision with root package name */
    int f44182iw;

    /* renamed from: ix  reason: collision with root package name */
    int f44183ix;

    /* renamed from: iy  reason: collision with root package name */
    int f44184iy;
    @ColorInt
    int[] lct;
    int transIndex;
    boolean transparency;
}
