package com.instabug.library.internal.video.customencoding;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Message;
import com.instabug.library.util.InstabugSDKLogger;

class p extends d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ q f51186a;

    public p(q qVar) {
        this.f51186a = qVar;
    }

    public void a(e eVar, int i11, MediaCodec.BufferInfo bufferInfo) {
        try {
            this.f51186a.a(i11, bufferInfo);
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Muxer encountered an error! ", e11);
            Message.obtain(this.f51186a.f51205s, 2, e11).sendToTarget();
        }
    }

    public void a(e eVar, MediaFormat mediaFormat) {
        this.f51186a.a(mediaFormat);
        this.f51186a.h();
    }

    public void a(g gVar, Exception exc) {
        InstabugSDKLogger.e("IBG-Core", "MicRecorder ran into an error! ", exc);
        if (this.f51186a.f51205s != null) {
            Message.obtain(this.f51186a.f51205s, 2, exc).sendToTarget();
        }
    }
}
