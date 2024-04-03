package com.instabug.library.screenshot;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.hardware.display.VirtualDisplay;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.util.DisplayMetrics;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import com.instabug.library.R;
import com.instabug.library.core.eventbus.ScreenCaptureEventBus;
import com.instabug.library.model.i;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.n;
import com.instabug.library.util.threading.PoolProvider;
import io.reactivex.functions.Consumer;
import java.security.SecureRandom;

@RequiresApi(21)
public class ScreenshotCaptureService extends Service {

    /* renamed from: c  reason: collision with root package name */
    private static final int f51718c = new SecureRandom().nextInt();
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public MediaProjection f51719a;

    /* renamed from: b  reason: collision with root package name */
    public ImageReader.OnImageAvailableListener f51720b = new b(this);

    public class a implements Consumer {
        public a() {
        }

        /* renamed from: a */
        public void accept(i iVar) {
            ScreenshotCaptureService.this.stopForeground(true);
        }
    }

    public class b implements ImageReader.OnImageAvailableListener {
        public b(ScreenshotCaptureService screenshotCaptureService) {
        }

        public void onImageAvailable(ImageReader imageReader) {
        }
    }

    public class c implements ImageReader.OnImageAvailableListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ImageReader f51722a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f51723b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f51724c;

        public c(ImageReader imageReader, int i11, int i12) {
            this.f51722a = imageReader;
            this.f51723b = i11;
            this.f51724c = i12;
        }

        @SuppressLint({"infer"})
        public void onImageAvailable(ImageReader imageReader) {
            ImageReader imageReader2 = this.f51722a;
            if (imageReader2 != null) {
                imageReader2.setOnImageAvailableListener(ScreenshotCaptureService.this.f51720b, new Handler());
            }
            if (ScreenshotCaptureService.this.f51719a != null) {
                ScreenshotCaptureService.this.f51719a.stop();
            }
            PoolProvider.postBitmapTask(new a(this.f51723b, this.f51724c, imageReader));
        }
    }

    public class d extends MediaProjection.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VirtualDisplay f51726a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ImageReader f51727b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ MediaProjection f51728c;

        public d(VirtualDisplay virtualDisplay, ImageReader imageReader, MediaProjection mediaProjection) {
            this.f51726a = virtualDisplay;
            this.f51727b = imageReader;
            this.f51728c = mediaProjection;
        }

        @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
        public void onStop() {
            super.onStop();
            VirtualDisplay virtualDisplay = this.f51726a;
            if (virtualDisplay != null) {
                virtualDisplay.release();
            }
            this.f51727b.setOnImageAvailableListener(ScreenshotCaptureService.this.f51720b, new Handler());
            this.f51728c.unregisterCallback(this);
        }
    }

    public static Intent a(Context context, Intent intent) {
        Intent intent2 = new Intent(context, ScreenshotCaptureService.class);
        intent2.putExtra("instabug.intent.extra.MEDIA_PROJ_INTENT", intent);
        return intent2;
    }

    @Nullable
    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        ScreenCaptureEventBus.getInstance().subscribe(new a());
    }

    @SuppressLint({"infer"})
    public int onStartCommand(Intent intent, int i11, int i12) {
        if (intent != null) {
            if (Build.VERSION.SDK_INT >= 29) {
                n.a((Service) this, R.string.ibg_screen_recording_notification_title, f51718c);
            }
            Intent intent2 = (Intent) intent.getParcelableExtra("instabug.intent.extra.MEDIA_PROJ_INTENT");
            if (intent2 == null) {
                stopForeground(true);
                InstabugSDKLogger.e("IBG-Core", "Passed Media projection intent is null");
            }
            MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) getSystemService("media_projection");
            MediaProjection mediaProjection = this.f51719a;
            if (mediaProjection != null) {
                mediaProjection.stop();
                this.f51719a = null;
            }
            if (intent2 != null) {
                this.f51719a = mediaProjectionManager.getMediaProjection(-1, intent2);
            }
            if (this.f51719a == null) {
                stopForeground(true);
            }
            DisplayMetrics displayMetrics = new DisplayMetrics();
            Activity currentActivity = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
            if (currentActivity != null) {
                currentActivity.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
                int i13 = displayMetrics.densityDpi;
                int i14 = displayMetrics.widthPixels;
                int i15 = displayMetrics.heightPixels;
                ImageReader newInstance = ImageReader.newInstance(i14, i15, 1, 1);
                MediaProjection mediaProjection2 = this.f51719a;
                if (mediaProjection2 != null) {
                    VirtualDisplay createVirtualDisplay = mediaProjection2.createVirtualDisplay("screencap", i14, i15, i13, 9, newInstance.getSurface(), (VirtualDisplay.Callback) null, (Handler) null);
                    newInstance.setOnImageAvailableListener(new c(newInstance, i14, i15), new Handler());
                    a(createVirtualDisplay, newInstance, this.f51719a);
                }
            } else {
                stopForeground(true);
            }
        } else {
            stopForeground(true);
        }
        return super.onStartCommand(intent, i11, i12);
    }

    private void a(VirtualDisplay virtualDisplay, ImageReader imageReader, @Nullable MediaProjection mediaProjection) {
        if (mediaProjection != null) {
            mediaProjection.unregisterCallback(new d(virtualDisplay, imageReader, mediaProjection));
        }
    }
}
