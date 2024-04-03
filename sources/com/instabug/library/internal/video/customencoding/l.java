package com.instabug.library.internal.video.customencoding;

import android.media.AudioRecord;
import android.media.MediaCodec;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.LinkedList;

class l extends Handler {

    /* renamed from: a  reason: collision with root package name */
    private LinkedList f51168a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    private LinkedList f51169b = new LinkedList();

    /* renamed from: c  reason: collision with root package name */
    private int f51170c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ m f51171d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(m mVar, Looper looper) {
        super(looper);
        this.f51171d = mVar;
        this.f51170c = 2048000 / mVar.f51176e;
    }

    private void a() {
        while (!this.f51171d.f51179h.get()) {
            MediaCodec.BufferInfo bufferInfo = (MediaCodec.BufferInfo) this.f51168a.poll();
            if (bufferInfo == null) {
                bufferInfo = new MediaCodec.BufferInfo();
            }
            int dequeueOutputBuffer = this.f51171d.f51172a.f().dequeueOutputBuffer(bufferInfo, 1);
            if (dequeueOutputBuffer == -2 && this.f51171d.f51181j != null) {
                this.f51171d.f51181j.c(this.f51171d.f51172a, this.f51171d.f51172a.f().getOutputFormat());
            }
            if (dequeueOutputBuffer < 0) {
                bufferInfo.set(0, 0, 0, 0);
                this.f51168a.offer(bufferInfo);
                return;
            }
            this.f51169b.offer(Integer.valueOf(dequeueOutputBuffer));
            if (this.f51171d.f51181j != null) {
                this.f51171d.f51181j.b(this.f51171d.f51172a, dequeueOutputBuffer, bufferInfo);
            }
        }
    }

    private int b() {
        return this.f51171d.f51172a.f().dequeueInputBuffer(0);
    }

    private void c() {
        if (this.f51169b.size() <= 1 && !this.f51171d.f51179h.get()) {
            removeMessages(1);
            sendEmptyMessageDelayed(1, 0);
        }
    }

    public void handleMessage(Message message) {
        int i11 = message.what;
        if (i11 == 0) {
            m mVar = this.f51171d;
            AudioRecord b11 = mVar.a(mVar.f51176e, this.f51171d.f51177f, this.f51171d.f51178g);
            if (b11 == null) {
                InstabugSDKLogger.e("IBG-Core", "create audio record failure");
                if (this.f51171d.f51181j != null) {
                    this.f51171d.f51181j.d(this.f51171d, new IllegalArgumentException());
                    return;
                }
                return;
            }
            b11.startRecording();
            AudioRecord unused = this.f51171d.f51175d = b11;
            try {
                this.f51171d.f51172a.c();
            } catch (Exception e11) {
                if (this.f51171d.f51181j != null) {
                    this.f51171d.f51181j.d(this.f51171d, e11);
                    return;
                }
                return;
            }
        } else if (i11 != 1) {
            if (i11 == 2) {
                a();
                c();
                return;
            } else if (i11 == 3) {
                this.f51171d.f51172a.c(message.arg1);
                this.f51169b.poll();
                c();
                return;
            } else if (i11 == 4) {
                if (this.f51171d.f51175d != null) {
                    this.f51171d.f51175d.stop();
                }
                this.f51171d.f51172a.e();
                return;
            } else if (i11 == 5) {
                if (this.f51171d.f51175d != null) {
                    this.f51171d.f51175d.release();
                    AudioRecord unused2 = this.f51171d.f51175d = null;
                }
                this.f51171d.f51172a.d();
                return;
            } else {
                return;
            }
        }
        if (!this.f51171d.f51179h.get()) {
            int b12 = b();
            if (b12 >= 0) {
                this.f51171d.b(b12);
                if (!this.f51171d.f51179h.get()) {
                    sendEmptyMessage(2);
                    return;
                }
                return;
            }
            sendEmptyMessageDelayed(1, (long) this.f51170c);
        }
    }
}
