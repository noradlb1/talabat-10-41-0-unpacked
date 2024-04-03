package com.uxcam.internals;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.opengl.EGL14;
import android.opengl.EGLConfig;
import android.opengl.EGLContext;
import android.opengl.EGLDisplay;
import android.opengl.EGLExt;
import android.opengl.EGLSurface;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.SystemClock;
import android.view.Surface;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.util.ArrayList;
import java.util.Objects;

@TargetApi(19)
public class cm {

    /* renamed from: l  reason: collision with root package name */
    public static int f13132l = 1;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList f13133a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public String f13134b;

    /* renamed from: c  reason: collision with root package name */
    public int f13135c = -1;

    /* renamed from: d  reason: collision with root package name */
    public int f13136d = -1;

    /* renamed from: e  reason: collision with root package name */
    public int f13137e = -1;

    /* renamed from: f  reason: collision with root package name */
    public MediaCodec f13138f;

    /* renamed from: g  reason: collision with root package name */
    public aa f13139g;

    /* renamed from: h  reason: collision with root package name */
    public MediaMuxer f13140h;

    /* renamed from: i  reason: collision with root package name */
    public int f13141i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f13142j;

    /* renamed from: k  reason: collision with root package name */
    public MediaCodec.BufferInfo f13143k;

    public final void a(int i11, long j11) {
        a(false);
        cn cnVar = new cn(this.f13135c, this.f13136d);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.0f);
        cnVar.f13151d = new fw();
        GLES20.glViewport(0, 0, cnVar.f13149b, cnVar.f13150c);
        float f11 = ((float) cnVar.f13149b) / ((float) cnVar.f13150c);
        Matrix.frustumM(cnVar.f13148a, 0, -f11, f11, -1.0f, 1.0f, 3.0f, 7.0f);
        GLES20.glClear(16640);
        cnVar.f13151d.a();
        fw fwVar = cnVar.f13151d;
        int glGetUniformLocation = GLES20.glGetUniformLocation(fwVar.f13423b, "uScreen");
        int glGetUniformLocation2 = GLES20.glGetUniformLocation(fwVar.f13423b, "uTexture");
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer.put(new float[]{2.0f / ((float) 320), 0.0f, 0.0f, 0.0f, 0.0f, -2.0f / ((float) 480), 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f}).position(0);
        GLES20.glUniformMatrix4fv(glGetUniformLocation, asFloatBuffer.limit() / 16, false, asFloatBuffer);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(3553, fwVar.f13422a[0]);
        GLES20.glUniform1i(glGetUniformLocation2, 0);
        fw fwVar2 = cnVar.f13151d;
        int glGetAttribLocation = GLES20.glGetAttribLocation(fwVar2.f13423b, "aPosition");
        int glGetAttribLocation2 = GLES20.glGetAttribLocation(fwVar2.f13423b, "aTexPos");
        FloatBuffer asFloatBuffer2 = ByteBuffer.allocateDirect(64).order(ByteOrder.nativeOrder()).asFloatBuffer();
        asFloatBuffer2.put(new float[]{0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 480.0f, 0.0f, 1.0f, 320.0f, 0.0f, 1.0f, 0.0f, 320.0f, 480.0f, 1.0f, 1.0f});
        asFloatBuffer2.position(0);
        FloatBuffer floatBuffer = asFloatBuffer2;
        GLES20.glVertexAttribPointer(glGetAttribLocation, 2, 5126, false, 16, floatBuffer);
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        asFloatBuffer2.position(2);
        GLES20.glVertexAttribPointer(glGetAttribLocation2, 2, 5126, false, 16, floatBuffer);
        GLES20.glEnableVertexAttribArray(glGetAttribLocation2);
        GLES20.glDrawArrays(5, 0, 4);
        aa aaVar = this.f13139g;
        EGLExt.eglPresentationTimeANDROID(aaVar.f13144a, aaVar.f13146c, (SystemClock.elapsedRealtime() - j11) * 1000000);
        aaVar.a("eglPresentationTimeANDROID");
        aa aaVar2 = this.f13139g;
        EGL14.eglSwapBuffers(aaVar2.f13144a, aaVar2.f13146c);
        aaVar2.a("eglSwapBuffers");
    }

    public final void b() {
        MediaCodec mediaCodec = this.f13138f;
        if (mediaCodec != null) {
            try {
                mediaCodec.stop();
                this.f13138f.release();
                this.f13138f = null;
            } catch (Exception e11) {
                fx fxVar = new fx();
                fxVar.a("EXCEPTION");
                fxVar.a("site_of_error", "GLMediaCodecEncoder::releaseEncoder()");
                fxVar.a("reason", e11.getMessage());
                fxVar.a("crash_interest", "for mEncoder").a(2);
            }
        }
        aa aaVar = this.f13139g;
        if (aaVar != null) {
            try {
                aaVar.b();
                this.f13139g = null;
            } catch (Exception e12) {
                fx fxVar2 = new fx();
                fxVar2.a("EXCEPTION");
                fxVar2.a("site_of_error", "GLMediaCodecEncoder::releaseEncoder()");
                fxVar2.a("reason", e12.getMessage());
                fxVar2.a("crash_interest", "for mInputSurface").a(2);
            }
        }
        MediaMuxer mediaMuxer = this.f13140h;
        if (mediaMuxer != null) {
            try {
                mediaMuxer.stop();
                this.f13140h.release();
                this.f13140h = null;
            } catch (Exception e13) {
                fx fxVar3 = new fx();
                fxVar3.a("EXCEPTION");
                fxVar3.a("site_of_error", "GLMediaCodecEncoder::releaseEncoder()");
                fxVar3.a("reason", e13.getMessage());
                fxVar3.a("crash_interest", "for mMuxer").a(2);
            }
        }
    }

    public static class aa {

        /* renamed from: a  reason: collision with root package name */
        public EGLDisplay f13144a = EGL14.EGL_NO_DISPLAY;

        /* renamed from: b  reason: collision with root package name */
        public EGLContext f13145b = EGL14.EGL_NO_CONTEXT;

        /* renamed from: c  reason: collision with root package name */
        public EGLSurface f13146c = EGL14.EGL_NO_SURFACE;

        /* renamed from: d  reason: collision with root package name */
        public Surface f13147d;

        public aa(Surface surface) {
            surface.getClass();
            this.f13147d = surface;
            a();
        }

        public final void a() {
            EGLDisplay eglGetDisplay = EGL14.eglGetDisplay(0);
            this.f13144a = eglGetDisplay;
            if (eglGetDisplay != EGL14.EGL_NO_DISPLAY) {
                int[] iArr = new int[2];
                if (EGL14.eglInitialize(eglGetDisplay, iArr, 0, iArr, 1)) {
                    EGLConfig[] eGLConfigArr = new EGLConfig[1];
                    EGL14.eglChooseConfig(this.f13144a, new int[]{12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12610, 1, 12344}, 0, eGLConfigArr, 0, 1, new int[1], 0);
                    a("eglCreateContext RGB888+recordable ES2");
                    this.f13145b = EGL14.eglCreateContext(this.f13144a, eGLConfigArr[0], EGL14.EGL_NO_CONTEXT, new int[]{12440, 2, 12344}, 0);
                    a("eglCreateContext");
                    this.f13146c = EGL14.eglCreateWindowSurface(this.f13144a, eGLConfigArr[0], this.f13147d, new int[]{12344}, 0);
                    a("eglCreateWindowSurface");
                    return;
                }
                throw new RuntimeException("unable to initialize EGL14");
            }
            throw new RuntimeException("unable to get EGL14 display");
        }

        public void b() {
            EGLDisplay eGLDisplay = this.f13144a;
            if (eGLDisplay != EGL14.EGL_NO_DISPLAY) {
                EGLSurface eGLSurface = EGL14.EGL_NO_SURFACE;
                EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, EGL14.EGL_NO_CONTEXT);
                EGL14.eglDestroySurface(this.f13144a, this.f13146c);
                EGL14.eglDestroyContext(this.f13144a, this.f13145b);
                EGL14.eglReleaseThread();
                EGL14.eglTerminate(this.f13144a);
            }
            this.f13147d.release();
            this.f13144a = EGL14.EGL_NO_DISPLAY;
            this.f13145b = EGL14.EGL_NO_CONTEXT;
            this.f13146c = EGL14.EGL_NO_SURFACE;
            this.f13147d = null;
        }

        public final void a(String str) {
            int eglGetError = EGL14.eglGetError();
            if (eglGetError != 12288) {
                throw new RuntimeException(str + ": EGL error: 0x" + Integer.toHexString(eglGetError));
            }
        }
    }

    public final void a() {
        this.f13143k = new MediaCodec.BufferInfo();
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat(MimeTypes.VIDEO_H264, this.f13135c, this.f13136d);
        createVideoFormat.setInteger("color-format", 2130708361);
        createVideoFormat.setInteger("bitrate", this.f13137e);
        createVideoFormat.setInteger("frame-rate", f13132l);
        createVideoFormat.setInteger("i-frame-interval", 10);
        try {
            this.f13138f = MediaCodec.createEncoderByType(MimeTypes.VIDEO_H264);
        } catch (IOException e11) {
            e11.printStackTrace();
            fx fxVar = new fx();
            fxVar.a("EXCEPTION");
            fxVar.a("site_of_error", "GLMediaCodecEncoder::prepareEncoder()");
            fxVar.a("reason", e11.getMessage());
            fxVar.a(2);
        }
        this.f13138f.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        this.f13139g = new aa(this.f13138f.createInputSurface());
        this.f13138f.start();
        try {
            this.f13140h = new MediaMuxer(this.f13134b, 0);
            this.f13141i = -1;
            this.f13142j = false;
        } catch (IOException e12) {
            fx fxVar2 = new fx();
            fxVar2.a("EXCEPTION");
            fxVar2.a("site_of_error", "GLMediaCodecEncoder::encodeVideoToMp4()");
            fxVar2.a("reason", e12.getMessage());
            fx a11 = fxVar2.a("crash_cause", "crashed when trying to init MediaMuxer");
            a11.a("invokes_next", "RuntimeException :: app crashed at this point.");
            a11.a(2);
            throw new RuntimeException("MediaMuxer creation failed", e12);
        }
    }

    public final void a(boolean z11) {
        if (z11) {
            this.f13138f.signalEndOfInputStream();
        }
        ByteBuffer[] outputBuffers = this.f13138f.getOutputBuffers();
        while (true) {
            int dequeueOutputBuffer = this.f13138f.dequeueOutputBuffer(this.f13143k, 10000);
            if (dequeueOutputBuffer == -1) {
                if (!z11) {
                    return;
                }
            } else if (dequeueOutputBuffer == -3) {
                outputBuffers = this.f13138f.getOutputBuffers();
            } else if (dequeueOutputBuffer == -2) {
                if (!this.f13142j) {
                    MediaFormat outputFormat = this.f13138f.getOutputFormat();
                    Objects.toString(outputFormat);
                    this.f13141i = this.f13140h.addTrack(outputFormat);
                    this.f13140h.start();
                    this.f13142j = true;
                } else {
                    throw new RuntimeException("format changed twice");
                }
            } else if (dequeueOutputBuffer >= 0) {
                ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                if (byteBuffer != null) {
                    MediaCodec.BufferInfo bufferInfo = this.f13143k;
                    if ((bufferInfo.flags & 2) != 0) {
                        bufferInfo.size = 0;
                    }
                    if (bufferInfo.size != 0) {
                        if (this.f13142j) {
                            byteBuffer.position(bufferInfo.offset);
                            MediaCodec.BufferInfo bufferInfo2 = this.f13143k;
                            byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                            this.f13140h.writeSampleData(this.f13141i, byteBuffer, this.f13143k);
                        } else {
                            throw new RuntimeException("muxer hasn't started");
                        }
                    }
                    this.f13138f.releaseOutputBuffer(dequeueOutputBuffer, false);
                    if ((this.f13143k.flags & 4) != 0) {
                        return;
                    }
                } else {
                    throw new RuntimeException("encoderOutputBuffer " + dequeueOutputBuffer + " was null");
                }
            } else {
                continue;
            }
        }
    }
}
