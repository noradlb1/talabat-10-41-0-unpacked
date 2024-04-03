package dev.flutter.plugins.integration_test;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.view.Choreographer;
import android.view.PixelCopy;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.android.FlutterView;
import io.flutter.plugin.common.MethodChannel;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@TargetApi(19)
class FlutterDeviceScreenshot {
    private static Handler backgroundHandler = null;
    /* access modifiers changed from: private */
    public static boolean flutterSurfaceConvertedToImage = false;
    private static Handler mainHandler;

    private static void convertViewToBitmap(@NonNull FlutterView flutterView, @NonNull MethodChannel.Result result, @NonNull Handler handler) {
        if (Build.VERSION.SDK_INT < 26) {
            Bitmap createBitmap = Bitmap.createBitmap(flutterView.getWidth(), flutterView.getHeight(), Bitmap.Config.RGB_565);
            flutterView.draw(new Canvas(createBitmap));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            createBitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            result.success(byteArrayOutputStream.toByteArray());
            return;
        }
        Bitmap createBitmap2 = Bitmap.createBitmap(flutterView.getWidth(), flutterView.getHeight(), Bitmap.Config.ARGB_8888);
        int[] iArr = new int[2];
        flutterView.getLocationInWindow(iArr);
        int i11 = iArr[0];
        int i12 = iArr[1];
        PixelCopy.request(((Activity) flutterView.getContext()).getWindow(), new Rect(i11, i12, flutterView.getWidth() + i11, flutterView.getHeight() + i12), createBitmap2, new f(createBitmap2, result), handler);
    }

    public static void g(@NonNull Activity activity, @NonNull MethodChannel methodChannel, @NonNull MethodChannel.Result result) {
        FlutterView flutterView = getFlutterView(activity);
        if (flutterView == null) {
            result.error("Could not copy the pixels", "FlutterView is null", (Object) null);
        } else if (!flutterSurfaceConvertedToImage) {
            result.error("Could not copy the pixels", "Flutter surface must be converted to image first", (Object) null);
        } else {
            methodChannel.invokeMethod("scheduleFrame", (Object) null);
            if (backgroundHandler == null) {
                HandlerThread handlerThread = new HandlerThread("screenshot");
                handlerThread.start();
                backgroundHandler = new Handler(handlerThread.getLooper());
            }
            if (mainHandler == null) {
                mainHandler = new Handler(Looper.getMainLooper());
            }
            takeScreenshot(backgroundHandler, mainHandler, flutterView, result);
        }
    }

    @Nullable
    private static FlutterView getFlutterView(@NonNull Activity activity) {
        return (FlutterView) activity.findViewById(FlutterActivity.FLUTTER_VIEW_ID);
    }

    public static byte[] h() throws IOException {
        return new byte[0];
    }

    public static void i(@NonNull Activity activity) {
        FlutterView flutterView = getFlutterView(activity);
        if (flutterView != null && !flutterSurfaceConvertedToImage) {
            flutterView.convertToImageView();
            flutterSurfaceConvertedToImage = true;
        }
    }

    public static boolean j() {
        return false;
    }

    public static void k(@NonNull Activity activity) {
        FlutterView flutterView = getFlutterView(activity);
        if (flutterView != null && flutterSurfaceConvertedToImage) {
            flutterView.revertImageView(new e());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$convertViewToBitmap$5(Bitmap bitmap, MethodChannel.Result result, int i11) {
        Handler handler = new Handler(Looper.getMainLooper());
        if (i11 == 0) {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
            handler.post(new a(result, byteArrayOutputStream));
            return;
        }
        handler.post(new b(result, i11));
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$takeScreenshot$1(boolean z11, FlutterView flutterView, MethodChannel.Result result, Handler handler, Handler handler2) {
        if (z11) {
            convertViewToBitmap(flutterView, result, handler);
        } else {
            takeScreenshot(handler, handler2, flutterView, result);
        }
    }

    private static void takeScreenshot(@NonNull Handler handler, @NonNull Handler handler2, @NonNull FlutterView flutterView, @NonNull MethodChannel.Result result) {
        waitForAndroidFrame(new d(flutterView.acquireLatestImageViewFrame(), flutterView, result, handler, handler2));
    }

    /* access modifiers changed from: private */
    public static void waitForAndroidFrame(final Runnable runnable) {
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() {
            public void doFrame(long j11) {
                runnable.run();
            }
        });
    }
}
