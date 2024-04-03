package com.uxcam.internals;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.os.Handler;
import android.os.Message;
import android.view.Surface;
import com.google.android.exoplayer2.util.MimeTypes;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import mz.c0;

@TargetApi(18)
public class gs {

    /* renamed from: k  reason: collision with root package name */
    public static int f13488k = 1;

    /* renamed from: a  reason: collision with root package name */
    public String f13489a;

    /* renamed from: b  reason: collision with root package name */
    public ac f13490b;

    /* renamed from: c  reason: collision with root package name */
    public ad f13491c;

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f13492d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    public MediaCodec f13493e;

    /* renamed from: f  reason: collision with root package name */
    public Surface f13494f;

    /* renamed from: g  reason: collision with root package name */
    public MediaMuxer f13495g;

    /* renamed from: h  reason: collision with root package name */
    public int f13496h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13497i;

    /* renamed from: j  reason: collision with root package name */
    public MediaCodec.BufferInfo f13498j;

    public static class ab extends Handler {

        /* renamed from: a  reason: collision with root package name */
        public gs f13499a;

        public ab(gs gsVar) {
            this.f13499a = gsVar;
        }

        public void handleMessage(Message message) {
            if (message.what == 100) {
                int i11 = message.arg1;
                if (i11 == 101) {
                    Iterator it = this.f13499a.f13492d.iterator();
                    while (it.hasNext()) {
                        ((bs) it.next()).b();
                    }
                } else if (i11 == 102) {
                    Iterator it2 = this.f13499a.f13492d.iterator();
                    while (it2.hasNext()) {
                        ((bs) it2.next()).a();
                    }
                }
            }
        }
    }

    public interface ac {
    }

    public gs() {
        new ab(this);
        ad adVar = new ad();
        this.f13491c = adVar;
        adVar.setName("uxSurfaceEncode");
    }

    public class ad extends Thread {
        public ad() {
        }

        public final void a(long j11) {
            if (fn.f13378i) {
                fm.a(true, (eh) new c0(this, j11));
                return;
            }
            Canvas a11 = a();
            if (a11 != null) {
                ac acVar = gs.this.f13490b;
                ((go) acVar).a(a11, j11, (long) (1000 / gs.f13488k));
                gs.this.f13494f.unlockCanvasAndPost(a11);
            }
        }

        public final void b() {
            gs.this.f13498j = new MediaCodec.BufferInfo();
            ((go) gs.this.f13490b).getClass();
            int a11 = ia.a(fl.a().f13358c);
            ((go) gs.this.f13490b).getClass();
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(MimeTypes.VIDEO_H264, a11, ia.a(fl.a().f13359d));
            createVideoFormat.setInteger("color-format", 2130708361);
            gs.this.getClass();
            createVideoFormat.setInteger("bitrate", 150000);
            createVideoFormat.setInteger("frame-rate", gs.f13488k);
            createVideoFormat.setInteger("i-frame-interval", 100);
            ((go) gs.this.f13490b).getClass();
            createVideoFormat.setInteger("stride", ia.a(fl.a().f13358c));
            ((go) gs.this.f13490b).getClass();
            createVideoFormat.setInteger("slice-height", ia.a(fl.a().f13359d));
            try {
                gs.this.f13493e = MediaCodec.createEncoderByType(MimeTypes.VIDEO_H264);
            } catch (IOException e11) {
                fx fxVar = new fx();
                fxVar.a("EXCEPTION");
                fxVar.a("site_of_error", "EncoderThread::prepareEncoder()");
                fxVar.a("reason", e11.getMessage());
                fxVar.a(2);
            }
            gs.this.f13493e.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            gs gsVar = gs.this;
            gsVar.f13494f = gsVar.f13493e.createInputSurface();
            gs.this.f13493e.start();
            try {
                gs.this.f13495g = new MediaMuxer(gs.this.f13489a, 0);
                gs gsVar2 = gs.this;
                gsVar2.f13496h = -1;
                boolean unused = gsVar2.f13497i = false;
            } catch (IOException e12) {
                fx fxVar2 = new fx();
                fxVar2.a("EXCEPTION");
                fxVar2.a("site_of_error", "EncoderThread::prepareEncoder()");
                fxVar2.a("reason", e12.getMessage());
                fxVar2.a("invokes_next", "throws RuntimeException() :: application has crashed!! ");
                fxVar2.a(2);
                throw new RuntimeException("MediaMuxer creation failed", e12);
            }
        }

        public final void c() {
            MediaCodec mediaCodec = gs.this.f13493e;
            if (mediaCodec != null) {
                try {
                    mediaCodec.stop();
                    gs.this.f13493e.release();
                    gs.this.f13493e = null;
                } catch (Exception e11) {
                    gu.a("SurfaceEncoder").getClass();
                    fx fxVar = new fx();
                    fxVar.a("EXCEPTION");
                    fxVar.a("site_of_error", "EncoderThread::releaseEncoder()");
                    fxVar.a("reason", e11.getMessage());
                    fxVar.a("crash_cause", "for mEncoder ...").a(2);
                }
            }
            Surface surface = gs.this.f13494f;
            if (surface != null) {
                try {
                    surface.release();
                    gs.this.f13494f = null;
                } catch (Exception e12) {
                    gu.a("SurfaceEncoder").getClass();
                    fx fxVar2 = new fx();
                    fxVar2.a("EXCEPTION");
                    fxVar2.a("site_of_error", "EncoderThread::releaseEncoder()");
                    fxVar2.a("reason", e12.getMessage());
                    fxVar2.a("crash_cause", "for mSurface ...").a(2);
                }
            }
            MediaMuxer mediaMuxer = gs.this.f13495g;
            if (mediaMuxer != null) {
                try {
                    mediaMuxer.stop();
                    gs.this.f13495g.release();
                    gs.this.f13495g = null;
                } catch (Exception e13) {
                    gu.a("SurfaceEncoder").getClass();
                    fx fxVar3 = new fx();
                    fxVar3.a("EXCEPTION");
                    fxVar3.a("site_of_error", "EncoderThread::releaseEncoder()");
                    fxVar3.a("reason", e13.getMessage());
                    fxVar3.a("crash_cause", "for mMuxer ...").a(2);
                }
            }
        }

        public void run() {
            boolean z11;
            boolean z12;
            if (gs.this.f13490b != null) {
                boolean z13 = false;
                try {
                    b();
                    int i11 = 0;
                    while (!fn.f13376g) {
                        a(false);
                        a((long) ((i11 * 1000) / gs.f13488k));
                        i11++;
                        if (i11 == 1) {
                            hb.f13525h = ia.d();
                            ia.d();
                        }
                        int i12 = 0;
                        while (true) {
                            if (i12 >= 100) {
                                z12 = false;
                                continue;
                                break;
                            }
                            Thread.sleep((long) (10 / gs.f13488k));
                            if (fn.f13376g) {
                                z12 = true;
                                continue;
                                break;
                            }
                            i12++;
                        }
                        if (z12) {
                            break;
                        }
                    }
                    a(true);
                    c();
                    z13 = true;
                } catch (Exception e11) {
                    gu.a("SurfaceEncoder").getClass();
                    fx fxVar = new fx();
                    fxVar.a("EXCEPTION");
                    fxVar.a("site_of_error", "EncoderThread::run()");
                    fxVar.a("reason", e11.getMessage());
                    fxVar.a(2);
                    c();
                } catch (Throwable th2) {
                    c();
                    throw th2;
                }
                if (z13) {
                    z11 = true;
                } else {
                    z11 = true;
                }
                if (z11) {
                    Iterator it = gs.this.f13492d.iterator();
                    while (it.hasNext()) {
                        ((bs) it.next()).b();
                    }
                } else if (z11) {
                    Iterator it2 = gs.this.f13492d.iterator();
                    while (it2.hasNext()) {
                        ((bs) it2.next()).a();
                    }
                }
            } else {
                throw new NullPointerException("Need to set an encoder source on the surfaceEncoder");
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void a(long j11, Bitmap bitmap) {
            Canvas a11;
            if (gs.this.f13494f != null && (a11 = a()) != null) {
                ac acVar = gs.this.f13490b;
                ((go) acVar).a(a11, j11, (long) (1000 / gs.f13488k));
                gs.this.f13494f.unlockCanvasAndPost(a11);
            }
        }

        public final Canvas a() {
            try {
                return gs.this.f13494f.lockCanvas((Rect) null);
            } catch (IllegalArgumentException e11) {
                fx fxVar = new fx();
                fxVar.a("EXCEPTION");
                fxVar.a("site_of_error", "EncoderThread::renderFromSource()");
                fxVar.a("reason", e11.getMessage());
                fx a11 = fxVar.a("crash_cause", "IllegalArgumentException to be raised at lockCanvas");
                a11.a("invokes_next", "throws RuntimeException() :: application has crashed!! ");
                a11.a(2);
                return null;
            } catch (Surface.OutOfResourcesException e12) {
                gu.a("SurfaceEncoder").getClass();
                fx fxVar2 = new fx();
                fxVar2.a("EXCEPTION");
                fxVar2.a("site_of_error", "EncoderThread::renderFromSource()");
                fxVar2.a("reason", e12.getMessage());
                fxVar2.a("crash_cause", "There are no more resources to continue ...").a(2);
                return null;
            } catch (Exception e13) {
                e13.printStackTrace();
                return null;
            }
        }

        public final void a(boolean z11) {
            if (z11) {
                gs.this.f13493e.signalEndOfInputStream();
            }
            ByteBuffer[] outputBuffers = gs.this.f13493e.getOutputBuffers();
            while (true) {
                gs gsVar = gs.this;
                int dequeueOutputBuffer = gsVar.f13493e.dequeueOutputBuffer(gsVar.f13498j, 10000);
                if (dequeueOutputBuffer == -1) {
                    if (!z11) {
                        return;
                    }
                } else if (dequeueOutputBuffer == -3) {
                    outputBuffers = gs.this.f13493e.getOutputBuffers();
                } else if (dequeueOutputBuffer == -2) {
                    gs gsVar2 = gs.this;
                    if (!gsVar2.f13497i) {
                        MediaFormat outputFormat = gsVar2.f13493e.getOutputFormat();
                        Objects.toString(outputFormat);
                        gs gsVar3 = gs.this;
                        gsVar3.f13496h = gsVar3.f13495g.addTrack(outputFormat);
                        gs.this.f13495g.start();
                        boolean unused = gs.this.f13497i = true;
                    } else {
                        throw new RuntimeException("format changed twice");
                    }
                } else if (dequeueOutputBuffer >= 0) {
                    ByteBuffer byteBuffer = outputBuffers[dequeueOutputBuffer];
                    if (byteBuffer != null) {
                        gs gsVar4 = gs.this;
                        MediaCodec.BufferInfo bufferInfo = gsVar4.f13498j;
                        if ((bufferInfo.flags & 2) != 0) {
                            bufferInfo.size = 0;
                        }
                        if (bufferInfo.size != 0) {
                            if (gsVar4.f13497i) {
                                byteBuffer.position(bufferInfo.offset);
                                MediaCodec.BufferInfo bufferInfo2 = gs.this.f13498j;
                                byteBuffer.limit(bufferInfo2.offset + bufferInfo2.size);
                                gs gsVar5 = gs.this;
                                gsVar5.f13495g.writeSampleData(gsVar5.f13496h, byteBuffer, gsVar5.f13498j);
                            } else {
                                throw new RuntimeException("muxer hasn't started");
                            }
                        }
                        gs.this.f13493e.releaseOutputBuffer(dequeueOutputBuffer, false);
                        if ((gs.this.f13498j.flags & 4) != 0) {
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
}
