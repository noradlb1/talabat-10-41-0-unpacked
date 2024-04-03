package com.instabug.library.internal.video.customencoding;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.hardware.display.VirtualDisplay;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import android.media.projection.MediaProjection;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import androidx.annotation.Nullable;
import com.instabug.library.instacapture.exception.c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(21)
public class q {

    /* renamed from: a  reason: collision with root package name */
    private int f51187a;

    /* renamed from: b  reason: collision with root package name */
    private int f51188b;

    /* renamed from: c  reason: collision with root package name */
    private int f51189c;

    /* renamed from: d  reason: collision with root package name */
    private String f51190d;
    @Nullable

    /* renamed from: e  reason: collision with root package name */
    private MediaProjection f51191e;
    @Nullable

    /* renamed from: f  reason: collision with root package name */
    private t f51192f;
    @Nullable

    /* renamed from: g  reason: collision with root package name */
    private m f51193g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private MediaFormat f51194h = null;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private MediaFormat f51195i = null;

    /* renamed from: j  reason: collision with root package name */
    private int f51196j = -1;

    /* renamed from: k  reason: collision with root package name */
    private int f51197k = -1;
    @Nullable

    /* renamed from: l  reason: collision with root package name */
    private MediaMuxer f51198l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f51199m = false;

    /* renamed from: n  reason: collision with root package name */
    private AtomicBoolean f51200n = new AtomicBoolean(false);

    /* renamed from: o  reason: collision with root package name */
    private AtomicBoolean f51201o = new AtomicBoolean(false);
    @Nullable

    /* renamed from: p  reason: collision with root package name */
    private VirtualDisplay f51202p;

    /* renamed from: q  reason: collision with root package name */
    private MediaProjection.Callback f51203q = new n(this);
    @Nullable

    /* renamed from: r  reason: collision with root package name */
    private HandlerThread f51204r;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: s  reason: collision with root package name */
    public r f51205s;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: t  reason: collision with root package name */
    public a f51206t;

    /* renamed from: u  reason: collision with root package name */
    private LinkedList f51207u = new LinkedList();

    /* renamed from: v  reason: collision with root package name */
    private LinkedList f51208v = new LinkedList();

    /* renamed from: w  reason: collision with root package name */
    private LinkedList f51209w = new LinkedList();

    /* renamed from: x  reason: collision with root package name */
    private LinkedList f51210x = new LinkedList();

    /* renamed from: y  reason: collision with root package name */
    private long f51211y;

    /* renamed from: z  reason: collision with root package name */
    private long f51212z;

    public interface a {
        void a(long j11);

        void a(Throwable th2);

        void onStart();
    }

    public q(s sVar, @Nullable a aVar, @Nullable MediaProjection mediaProjection, String str) {
        m mVar = null;
        this.f51187a = sVar.d();
        this.f51188b = sVar.c();
        this.f51189c = sVar.b();
        this.f51191e = mediaProjection;
        this.f51190d = str;
        this.f51192f = new t(sVar);
        this.f51193g = aVar != null ? new m(aVar) : mVar;
    }

    /* access modifiers changed from: private */
    public synchronized void f() {
        MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
        ByteBuffer allocate = ByteBuffer.allocate(0);
        bufferInfo.set(0, 0, 0, 4);
        int i11 = this.f51196j;
        if (i11 != -1) {
            a(i11, bufferInfo, allocate);
        }
        int i12 = this.f51197k;
        if (i12 != -1) {
            a(i12, bufferInfo, allocate);
        }
        this.f51196j = -1;
        this.f51197k = -1;
    }

    public final synchronized void c() {
        this.f51200n.set(true);
        if (!this.f51201o.get()) {
            e();
        } else {
            a(false);
        }
    }

    public synchronized void finalize() throws Throwable {
        if (this.f51191e != null) {
            e();
        }
        super.finalize();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b(int r5, android.media.MediaCodec.BufferInfo r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            java.util.concurrent.atomic.AtomicBoolean r0 = r4.f51201o     // Catch:{ all -> 0x0043 }
            boolean r0 = r0.get()     // Catch:{ all -> 0x0043 }
            if (r0 != 0) goto L_0x000b
            monitor-exit(r4)
            return
        L_0x000b:
            boolean r0 = r4.f51199m     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x0033
            int r0 = r4.f51196j     // Catch:{ all -> 0x0043 }
            r1 = -1
            if (r0 != r1) goto L_0x0015
            goto L_0x0033
        L_0x0015:
            com.instabug.library.internal.video.customencoding.t r0 = r4.f51192f     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x0025
            java.nio.ByteBuffer r2 = r0.b(r5)     // Catch:{ all -> 0x0043 }
            int r3 = r4.f51196j     // Catch:{ all -> 0x0043 }
            r4.a(r3, r6, r2)     // Catch:{ all -> 0x0043 }
            r0.c((int) r5)     // Catch:{ all -> 0x0043 }
        L_0x0025:
            int r5 = r6.flags     // Catch:{ all -> 0x0043 }
            r5 = r5 & 4
            if (r5 == 0) goto L_0x0031
            r4.f51196j = r1     // Catch:{ all -> 0x0043 }
            r5 = 1
            r4.a((boolean) r5)     // Catch:{ all -> 0x0043 }
        L_0x0031:
            monitor-exit(r4)
            return
        L_0x0033:
            java.util.LinkedList r0 = r4.f51207u     // Catch:{ all -> 0x0043 }
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)     // Catch:{ all -> 0x0043 }
            r0.add(r5)     // Catch:{ all -> 0x0043 }
            java.util.LinkedList r5 = r4.f51210x     // Catch:{ all -> 0x0043 }
            r5.add(r6)     // Catch:{ all -> 0x0043 }
            monitor-exit(r4)
            return
        L_0x0043:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.video.customencoding.q.b(int, android.media.MediaCodec$BufferInfo):void");
    }

    /* access modifiers changed from: private */
    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public synchronized void d() {
        MediaProjection mediaProjection;
        MediaProjection mediaProjection2;
        if (this.f51201o.get() || this.f51200n.get()) {
            throw new IllegalStateException();
        } else if (this.f51191e != null) {
            this.f51201o.set(true);
            r rVar = this.f51205s;
            if (!(rVar == null || (mediaProjection2 = this.f51191e) == null)) {
                mediaProjection2.registerCallback(this.f51203q, rVar);
            }
            try {
                this.f51198l = new MediaMuxer(this.f51190d, 0);
                b();
                a();
                if (!(this.f51192f == null || (mediaProjection = this.f51191e) == null)) {
                    this.f51202p = mediaProjection.createVirtualDisplay(this + "-display", this.f51187a, this.f51188b, this.f51189c, 1, this.f51192f.g(), (VirtualDisplay.Callback) null, (Handler) null);
                }
            } catch (IOException e11) {
                throw new c((Exception) e11);
            }
        } else {
            throw new IllegalStateException("maybe release");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't wrap try/catch for region: R(4:22|23|24|25) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x0050 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void e() {
        /*
            r2 = this;
            monitor-enter(r2)
            android.media.projection.MediaProjection r0 = r2.f51191e     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x000a
            android.media.projection.MediaProjection$Callback r1 = r2.f51203q     // Catch:{ all -> 0x0056 }
            r0.unregisterCallback(r1)     // Catch:{ all -> 0x0056 }
        L_0x000a:
            android.hardware.display.VirtualDisplay r0 = r2.f51202p     // Catch:{ all -> 0x0056 }
            r1 = 0
            if (r0 == 0) goto L_0x0014
            r0.release()     // Catch:{ all -> 0x0056 }
            r2.f51202p = r1     // Catch:{ all -> 0x0056 }
        L_0x0014:
            r2.f51195i = r1     // Catch:{ all -> 0x0056 }
            r2.f51194h = r1     // Catch:{ all -> 0x0056 }
            r0 = -1
            r2.f51197k = r0     // Catch:{ all -> 0x0056 }
            r2.f51196j = r0     // Catch:{ all -> 0x0056 }
            r0 = 0
            r2.f51199m = r0     // Catch:{ all -> 0x0056 }
            android.os.HandlerThread r0 = r2.f51204r     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x0029
            r0.quitSafely()     // Catch:{ all -> 0x0056 }
            r2.f51204r = r1     // Catch:{ all -> 0x0056 }
        L_0x0029:
            com.instabug.library.internal.video.customencoding.t r0 = r2.f51192f     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x0032
            r0.d()     // Catch:{ all -> 0x0056 }
            r2.f51192f = r1     // Catch:{ all -> 0x0056 }
        L_0x0032:
            com.instabug.library.internal.video.customencoding.m r0 = r2.f51193g     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x003b
            r0.b()     // Catch:{ all -> 0x0056 }
            r2.f51193g = r1     // Catch:{ all -> 0x0056 }
        L_0x003b:
            android.media.projection.MediaProjection r0 = r2.f51191e     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x0044
            r0.stop()     // Catch:{ all -> 0x0056 }
            r2.f51191e = r1     // Catch:{ all -> 0x0056 }
        L_0x0044:
            android.media.MediaMuxer r0 = r2.f51198l     // Catch:{ all -> 0x0056 }
            if (r0 == 0) goto L_0x0052
            r0.stop()     // Catch:{ Exception -> 0x0050 }
            android.media.MediaMuxer r0 = r2.f51198l     // Catch:{ Exception -> 0x0050 }
            r0.release()     // Catch:{ Exception -> 0x0050 }
        L_0x0050:
            r2.f51198l = r1     // Catch:{ all -> 0x0056 }
        L_0x0052:
            r2.f51205s = r1     // Catch:{ all -> 0x0056 }
            monitor-exit(r2)
            return
        L_0x0056:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.video.customencoding.q.e():void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0096, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0098, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void h() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.f51199m     // Catch:{ all -> 0x0099 }
            if (r0 != 0) goto L_0x0097
            android.media.MediaFormat r0 = r2.f51194h     // Catch:{ all -> 0x0099 }
            if (r0 == 0) goto L_0x0097
            com.instabug.library.internal.video.customencoding.m r1 = r2.f51193g     // Catch:{ all -> 0x0099 }
            if (r1 == 0) goto L_0x0013
            android.media.MediaFormat r1 = r2.f51195i     // Catch:{ all -> 0x0099 }
            if (r1 != 0) goto L_0x0013
            goto L_0x0097
        L_0x0013:
            android.media.MediaMuxer r1 = r2.f51198l     // Catch:{ all -> 0x0099 }
            if (r1 == 0) goto L_0x0037
            int r0 = r1.addTrack(r0)     // Catch:{ all -> 0x0099 }
            r2.f51196j = r0     // Catch:{ all -> 0x0099 }
            android.media.MediaFormat r0 = r2.f51195i     // Catch:{ all -> 0x0099 }
            if (r0 == 0) goto L_0x002f
            com.instabug.library.internal.video.customencoding.m r1 = r2.f51193g     // Catch:{ all -> 0x0099 }
            if (r1 != 0) goto L_0x0027
            r0 = -1
            goto L_0x002d
        L_0x0027:
            android.media.MediaMuxer r1 = r2.f51198l     // Catch:{ all -> 0x0099 }
            int r0 = r1.addTrack(r0)     // Catch:{ all -> 0x0099 }
        L_0x002d:
            r2.f51197k = r0     // Catch:{ all -> 0x0099 }
        L_0x002f:
            android.media.MediaMuxer r0 = r2.f51198l     // Catch:{ all -> 0x0099 }
            r0.start()     // Catch:{ all -> 0x0099 }
            r0 = 1
            r2.f51199m = r0     // Catch:{ all -> 0x0099 }
        L_0x0037:
            java.util.LinkedList r0 = r2.f51207u     // Catch:{ all -> 0x0099 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0099 }
            if (r0 == 0) goto L_0x0049
            java.util.LinkedList r0 = r2.f51208v     // Catch:{ all -> 0x0099 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0099 }
            if (r0 == 0) goto L_0x0049
            monitor-exit(r2)
            return
        L_0x0049:
            java.util.LinkedList r0 = r2.f51210x     // Catch:{ all -> 0x0099 }
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x0099 }
            android.media.MediaCodec$BufferInfo r0 = (android.media.MediaCodec.BufferInfo) r0     // Catch:{ all -> 0x0099 }
            if (r0 == 0) goto L_0x006d
            java.util.LinkedList r1 = r2.f51207u     // Catch:{ all -> 0x0099 }
            java.lang.Object r1 = r1.peek()     // Catch:{ all -> 0x0099 }
            if (r1 == 0) goto L_0x0049
            java.util.LinkedList r1 = r2.f51207u     // Catch:{ all -> 0x0099 }
            java.lang.Object r1 = r1.poll()     // Catch:{ all -> 0x0099 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x0099 }
            if (r1 == 0) goto L_0x0049
            int r1 = r1.intValue()     // Catch:{ all -> 0x0099 }
            r2.b(r1, r0)     // Catch:{ all -> 0x0099 }
            goto L_0x0049
        L_0x006d:
            com.instabug.library.internal.video.customencoding.m r0 = r2.f51193g     // Catch:{ all -> 0x0099 }
            if (r0 == 0) goto L_0x0095
        L_0x0071:
            java.util.LinkedList r0 = r2.f51209w     // Catch:{ all -> 0x0099 }
            java.lang.Object r0 = r0.poll()     // Catch:{ all -> 0x0099 }
            android.media.MediaCodec$BufferInfo r0 = (android.media.MediaCodec.BufferInfo) r0     // Catch:{ all -> 0x0099 }
            if (r0 == 0) goto L_0x0095
            java.util.LinkedList r1 = r2.f51208v     // Catch:{ all -> 0x0099 }
            java.lang.Object r1 = r1.peek()     // Catch:{ all -> 0x0099 }
            if (r1 == 0) goto L_0x0071
            java.util.LinkedList r1 = r2.f51208v     // Catch:{ all -> 0x0099 }
            java.lang.Object r1 = r1.poll()     // Catch:{ all -> 0x0099 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ all -> 0x0099 }
            if (r1 == 0) goto L_0x0071
            int r1 = r1.intValue()     // Catch:{ all -> 0x0099 }
            r2.a((int) r1, (android.media.MediaCodec.BufferInfo) r0)     // Catch:{ all -> 0x0099 }
            goto L_0x0071
        L_0x0095:
            monitor-exit(r2)
            return
        L_0x0097:
            monitor-exit(r2)
            return
        L_0x0099:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.video.customencoding.q.h():void");
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0026 A[Catch:{ IllegalStateException -> 0x0029 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void i() {
        /*
            r2 = this;
            monitor-enter(r2)
            java.util.concurrent.atomic.AtomicBoolean r0 = r2.f51201o     // Catch:{ all -> 0x002b }
            r1 = 0
            r0.set(r1)     // Catch:{ all -> 0x002b }
            java.util.LinkedList r0 = r2.f51209w     // Catch:{ all -> 0x002b }
            r0.clear()     // Catch:{ all -> 0x002b }
            java.util.LinkedList r0 = r2.f51208v     // Catch:{ all -> 0x002b }
            r0.clear()     // Catch:{ all -> 0x002b }
            java.util.LinkedList r0 = r2.f51210x     // Catch:{ all -> 0x002b }
            r0.clear()     // Catch:{ all -> 0x002b }
            java.util.LinkedList r0 = r2.f51207u     // Catch:{ all -> 0x002b }
            r0.clear()     // Catch:{ all -> 0x002b }
            com.instabug.library.internal.video.customencoding.t r0 = r2.f51192f     // Catch:{ IllegalStateException -> 0x0022 }
            if (r0 == 0) goto L_0x0022
            r0.e()     // Catch:{ IllegalStateException -> 0x0022 }
        L_0x0022:
            com.instabug.library.internal.video.customencoding.m r0 = r2.f51193g     // Catch:{ IllegalStateException -> 0x0029 }
            if (r0 == 0) goto L_0x0029
            r0.c()     // Catch:{ IllegalStateException -> 0x0029 }
        L_0x0029:
            monitor-exit(r2)
            return
        L_0x002b:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.video.customencoding.q.i():void");
    }

    public synchronized void a(a aVar) {
        this.f51206t = aVar;
    }

    public synchronized void g() {
        if (this.f51204r == null) {
            HandlerThread handlerThread = new HandlerThread("ScreenRecorder");
            this.f51204r = handlerThread;
            handlerThread.start();
            r rVar = new r(this, this.f51204r.getLooper());
            this.f51205s = rVar;
            rVar.sendEmptyMessage(0);
        } else {
            throw new IllegalStateException();
        }
    }

    /* access modifiers changed from: private */
    public void a(int i11, MediaCodec.BufferInfo bufferInfo) {
        if (this.f51201o.get()) {
            if (!this.f51199m || this.f51197k == -1) {
                this.f51208v.add(Integer.valueOf(i11));
                this.f51209w.add(bufferInfo);
                return;
            }
            m mVar = this.f51193g;
            if (mVar != null) {
                a(this.f51197k, bufferInfo, mVar.g(i11));
                mVar.i(i11);
            }
            if ((bufferInfo.flags & 4) != 0) {
                this.f51197k = -1;
                a(true);
            }
        }
    }

    private synchronized void b(MediaCodec.BufferInfo bufferInfo) {
        long j11 = this.f51211y;
        if (j11 == 0) {
            this.f51211y = bufferInfo.presentationTimeUs;
            bufferInfo.presentationTimeUs = 0;
        } else {
            bufferInfo.presentationTimeUs -= j11;
        }
    }

    private void a(int i11, MediaCodec.BufferInfo bufferInfo, @Nullable ByteBuffer byteBuffer) {
        a aVar;
        int i12 = bufferInfo.flags;
        boolean z11 = false;
        if ((i12 & 2) != 0) {
            bufferInfo.size = 0;
        }
        if ((i12 & 4) != 0) {
            z11 = true;
        }
        if (bufferInfo.size != 0 || z11) {
            if (bufferInfo.presentationTimeUs != 0) {
                if (i11 == this.f51196j) {
                    b(bufferInfo);
                } else if (i11 == this.f51197k) {
                    a(bufferInfo);
                }
            }
            if (!z11 && (aVar = this.f51206t) != null) {
                aVar.a(bufferInfo.presentationTimeUs);
            }
        } else {
            byteBuffer = null;
        }
        if (byteBuffer != null) {
            byteBuffer.position(bufferInfo.offset);
            byteBuffer.limit(bufferInfo.offset + bufferInfo.size);
            MediaMuxer mediaMuxer = this.f51198l;
            if (mediaMuxer != null) {
                mediaMuxer.writeSampleData(i11, byteBuffer, bufferInfo);
            }
        }
    }

    /* access modifiers changed from: private */
    public synchronized void b(MediaFormat mediaFormat) {
        if (this.f51196j >= 0 || this.f51199m) {
            throw new IllegalStateException("output format already changed!");
        }
        this.f51194h = mediaFormat;
    }

    private synchronized void b() throws IOException {
        o oVar = new o(this);
        t tVar = this.f51192f;
        if (tVar != null) {
            tVar.e(oVar);
            this.f51192f.c();
        }
    }

    private synchronized void a(MediaCodec.BufferInfo bufferInfo) {
        long j11 = this.f51212z;
        if (j11 == 0) {
            this.f51212z = bufferInfo.presentationTimeUs;
            bufferInfo.presentationTimeUs = 0;
        } else {
            bufferInfo.presentationTimeUs -= j11;
        }
    }

    /* access modifiers changed from: private */
    public synchronized void a(MediaFormat mediaFormat) {
        if (this.f51197k >= 0 || this.f51199m) {
            throw new IllegalStateException("output format already changed!");
        }
        this.f51195i = mediaFormat;
    }

    private synchronized void a() throws IOException {
        m mVar = this.f51193g;
        if (mVar != null) {
            mVar.a((d) new p(this));
            mVar.a();
        }
    }

    private synchronized void a(boolean z11) {
        r rVar = this.f51205s;
        if (rVar != null) {
            this.f51205s.sendMessageAtFrontOfQueue(Message.obtain(rVar, 1, z11 ? 1 : 0, 0));
        }
    }
}
