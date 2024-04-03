package com.instabug.library.internal.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.util.DisplayMetrics;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.instabug.library.Feature;
import com.instabug.library.internal.storage.AttachmentManager;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.internal.video.customencoding.q;
import com.instabug.library.internal.video.customencoding.s;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.DeviceStateProvider;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.l;
import com.instabug.library.util.threading.PoolProvider;
import java.io.File;

@TargetApi(21)
final class h {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Context f51227a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final a f51228b;

    /* renamed from: c  reason: collision with root package name */
    private final File f51229c;

    /* renamed from: d  reason: collision with root package name */
    private final Feature.State f51230d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final String f51231e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f51232f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f51233g;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    private MediaProjection f51234h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    private q f51235i;

    public interface a {
        void a();

        void b();

        void c();

        void onStart();
    }

    @RequiresApi(api = 21)
    public h(Context context, a aVar, q.a aVar2, int i11, Intent intent) {
        this.f51227a = context;
        this.f51228b = aVar;
        boolean isRecording = InternalScreenRecordHelper.getInstance().isRecording();
        this.f51233g = isRecording;
        Feature.State autoScreenRecordingAudioCapturingState = SettingsManager.getInstance().getAutoScreenRecordingAudioCapturingState();
        this.f51230d = autoScreenRecordingAudioCapturingState;
        if (isRecording) {
            this.f51229c = AttachmentsUtility.getVideoRecordingFramesDirectory(context);
            this.f51231e = AttachmentsUtility.getVideoFile(context).getAbsolutePath();
        } else {
            this.f51229c = AttachmentManager.getAutoScreenRecordingVideosDirectory(context);
            this.f51231e = AttachmentManager.getAutoScreenRecordingFile(context).getAbsolutePath();
        }
        MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) context.getSystemService("media_projection");
        if (mediaProjectionManager != null) {
            this.f51234h = mediaProjectionManager.getMediaProjection(i11, intent);
        }
        s b11 = b();
        if (isRecording || autoScreenRecordingAudioCapturingState == Feature.State.ENABLED) {
            this.f51235i = new q(b11, a(), this.f51234h, this.f51231e);
        } else {
            this.f51235i = new q(b11, (com.instabug.library.internal.video.customencoding.a) null, this.f51234h, this.f51231e);
        }
        b(aVar2);
    }

    @Nullable
    private com.instabug.library.internal.video.customencoding.a a() {
        if (!l.a()) {
            return null;
        }
        return new com.instabug.library.internal.video.customencoding.a();
    }

    private void c(q.a aVar) {
        a aVar2;
        if (this.f51232f) {
            a(false);
            try {
                MediaProjection mediaProjection = this.f51234h;
                if (mediaProjection != null) {
                    mediaProjection.stop();
                }
                q qVar = this.f51235i;
                if (qVar != null) {
                    qVar.a(aVar);
                }
                q qVar2 = this.f51235i;
                if (qVar2 != null) {
                    qVar2.c();
                }
                this.f51235i = null;
                try {
                    aVar2 = this.f51228b;
                    aVar2.a();
                } catch (RuntimeException unused) {
                }
            } catch (RuntimeException e11) {
                if (e11.getMessage() != null) {
                    InstabugSDKLogger.e("IBG-Core", "Error while stopping screen recording");
                }
                q qVar3 = this.f51235i;
                if (qVar3 != null) {
                    qVar3.c();
                }
                aVar2 = this.f51228b;
            } catch (Throwable th2) {
                try {
                    this.f51228b.a();
                } catch (RuntimeException unused2) {
                }
                throw th2;
            }
        }
    }

    private int[] d() {
        DisplayMetrics displayMetrics = DeviceStateProvider.getDisplayMetrics(this.f51227a);
        return new int[]{displayMetrics.widthPixels, displayMetrics.heightPixels, displayMetrics.densityDpi};
    }

    public void g() {
        PoolProvider.postIOTask(new f(this));
    }

    private s b() {
        int[] d11 = d();
        return new s(d11[0], d11[1], d11[2]);
    }

    public synchronized void e() {
        File file = new File(this.f51231e);
        InstabugSDKLogger.v("IBG-Core", "Recorded video file size: " + (file.length() / 1024) + " KB");
        if (this.f51233g) {
            InternalScreenRecordHelper.getInstance().e(file);
            InternalScreenRecordHelper.getInstance().d();
        } else {
            InternalAutoScreenRecorderHelper.getInstance().setAutoScreenRecordingFile(file);
        }
        this.f51228b.b();
    }

    public synchronized void a(boolean z11) {
        this.f51232f = z11;
    }

    public synchronized void d(q.a aVar) {
        if (this.f51232f) {
            c(aVar);
        } else {
            this.f51228b.c();
            this.f51228b.b();
        }
    }

    private void b(q.a aVar) {
        if (this.f51229c.exists() || this.f51229c.mkdirs()) {
            q qVar = this.f51235i;
            if (qVar != null) {
                qVar.a(aVar);
                this.f51235i.g();
            }
            a(true);
            this.f51228b.onStart();
            if (this.f51233g) {
                InternalScreenRecordHelper.getInstance().f();
            }
            if (this.f51230d == Feature.State.DISABLED) {
                l.a(this.f51227a);
            } else {
                l.b(this.f51227a);
            }
            InstabugSDKLogger.d("IBG-Core", "Screen recording started");
            return;
        }
        InstabugSDKLogger.e("IBG-Core", "Unable to create output directory. Cannot record screen.");
    }

    public synchronized void c(int i11) {
        PoolProvider.postBitmapTask(new g(this, i11));
    }
}
