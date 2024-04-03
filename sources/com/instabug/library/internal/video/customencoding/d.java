package com.instabug.library.internal.video.customencoding;

import android.media.MediaCodec;
import android.media.MediaFormat;

abstract class d implements f {
    public void a(e eVar, int i11) {
    }

    public abstract void a(e eVar, int i11, MediaCodec.BufferInfo bufferInfo);

    public abstract void a(e eVar, MediaFormat mediaFormat);
}
