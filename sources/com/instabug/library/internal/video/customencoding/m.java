package com.instabug.library.internal.video.customencoding;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.AudioRecord;
import android.os.Build;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(16)
class m implements g {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final b f51172a;

    /* renamed from: b  reason: collision with root package name */
    private final HandlerThread f51173b;
    @Nullable

    /* renamed from: c  reason: collision with root package name */
    private l f51174c;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    public AudioRecord f51175d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public int f51176e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public int f51177f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f51178g = 2;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public AtomicBoolean f51179h = new AtomicBoolean(false);
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private d f51180i;
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: j  reason: collision with root package name */
    public k f51181j;

    /* renamed from: k  reason: collision with root package name */
    private int f51182k;

    /* renamed from: l  reason: collision with root package name */
    private LinkedHashMap f51183l = new LinkedHashMap(2);

    public m(a aVar) {
        int i11;
        this.f51172a = new b(aVar);
        int b11 = aVar.b();
        this.f51176e = b11;
        this.f51182k = b11 * aVar.a();
        if (aVar.a() == 2) {
            i11 = 12;
        } else {
            i11 = 16;
        }
        this.f51177f = i11;
        this.f51173b = new HandlerThread("MicRecorder");
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void c() {
        k kVar = this.f51181j;
        if (kVar != null) {
            kVar.removeCallbacksAndMessages((Object) null);
        }
        this.f51179h.set(true);
        l lVar = this.f51174c;
        if (lVar != null) {
            lVar.sendEmptyMessage(4);
        }
    }

    @Nullable
    public ByteBuffer g(int i11) {
        return this.f51172a.b(i11);
    }

    public void i(int i11) {
        l lVar = this.f51174c;
        if (lVar != null) {
            Message.obtain(lVar, 3, i11, 0).sendToTarget();
        }
    }

    /* access modifiers changed from: private */
    @Nullable
    public AudioRecord a(int i11, int i12, int i13) {
        int minBufferSize = AudioRecord.getMinBufferSize(i11, i12, i13);
        if (minBufferSize <= 0) {
            InstabugSDKLogger.e("IBG-Core", String.format(Locale.US, "Bad arguments: getMinBufferSize(%d, %d, %d)", new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13)}));
            return null;
        }
        try {
            AudioRecord audioRecord = new AudioRecord(1, i11, i12, i13, minBufferSize * 2);
            if (audioRecord.getState() == 0) {
                InstabugSDKLogger.e("IBG-Core", String.format(Locale.US, "Bad arguments to new AudioRecord %d, %d, %d", new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), Integer.valueOf(i13)}));
                return null;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                InstabugSDKLogger.d("IBG-Core", " size in frame " + audioRecord.getBufferSizeInFrames());
            }
            return audioRecord;
        } catch (SecurityException unused) {
            return null;
        }
    }

    public void b() {
        l lVar = this.f51174c;
        if (lVar != null) {
            lVar.sendEmptyMessage(5);
        }
        this.f51173b.quit();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(int r13) {
        /*
            r12 = this;
            if (r13 < 0) goto L_0x004f
            java.util.concurrent.atomic.AtomicBoolean r0 = r12.f51179h
            boolean r0 = r0.get()
            if (r0 == 0) goto L_0x000b
            goto L_0x004f
        L_0x000b:
            android.media.AudioRecord r0 = r12.f51175d
            if (r0 == 0) goto L_0x0047
            int r1 = r0.getRecordingState()
            r2 = 0
            r3 = 1
            if (r1 != r3) goto L_0x0019
            r1 = r3
            goto L_0x001a
        L_0x0019:
            r1 = r2
        L_0x001a:
            com.instabug.library.internal.video.customencoding.b r4 = r12.f51172a
            java.nio.ByteBuffer r4 = r4.a((int) r13)
            r7 = 0
            if (r4 == 0) goto L_0x0035
            r4.position()
            int r5 = r4.limit()
            if (r1 != 0) goto L_0x0035
            int r0 = r0.read(r4, r5)
            if (r0 >= 0) goto L_0x0033
            goto L_0x0035
        L_0x0033:
            r8 = r0
            goto L_0x0036
        L_0x0035:
            r8 = r2
        L_0x0036:
            int r0 = r8 << 3
            long r9 = r12.a((int) r0)
            if (r1 == 0) goto L_0x003f
            r3 = 4
        L_0x003f:
            r11 = r3
            com.instabug.library.internal.video.customencoding.b r5 = r12.f51172a
            r6 = r13
            r5.a(r6, r7, r8, r9, r11)
            return
        L_0x0047:
            java.lang.NullPointerException r13 = new java.lang.NullPointerException
            java.lang.String r0 = "maybe release"
            r13.<init>(r0)
            throw r13
        L_0x004f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.internal.video.customencoding.m.b(int):void");
    }

    public void a(d dVar) {
        this.f51180i = dVar;
    }

    public void a() throws IOException {
        Looper myLooper = Looper.myLooper();
        if (myLooper != null) {
            this.f51181j = new k(myLooper, this.f51180i);
            this.f51173b.start();
            l lVar = new l(this, this.f51173b.getLooper());
            this.f51174c = lVar;
            lVar.sendEmptyMessage(0);
            return;
        }
        throw new NullPointerException("Should prepare in HandlerThread");
    }

    private long a(int i11) {
        if (this.f51183l == null) {
            this.f51183l = new LinkedHashMap(2);
        }
        int i12 = i11 >> 4;
        long longValue = this.f51183l.get(Integer.valueOf(i12)) != null ? ((Long) this.f51183l.get(Integer.valueOf(i12))).longValue() : -1;
        if (longValue == -1) {
            longValue = (long) ((1000000 * i12) / this.f51182k);
            this.f51183l.put(Integer.valueOf(i12), Long.valueOf(longValue));
        }
        long elapsedRealtime = (SystemClock.elapsedRealtime() / 1000000) - longValue;
        long longValue2 = this.f51183l.get(-1) != null ? ((Long) this.f51183l.get(-1)).longValue() : -1;
        if (longValue2 == -1) {
            longValue2 = elapsedRealtime;
        }
        if (elapsedRealtime - longValue2 < (longValue << 1)) {
            elapsedRealtime = longValue2;
        }
        this.f51183l.put(-1, Long.valueOf(longValue + elapsedRealtime));
        return elapsedRealtime;
    }
}
