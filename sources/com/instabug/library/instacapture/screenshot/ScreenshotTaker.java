package com.instabug.library.instacapture.screenshot;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.Pair;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import androidx.annotation.IdRes;
import androidx.annotation.Nullable;
import com.instabug.library.Instabug;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.instacapture.screenshot.pixelcopy.h;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.BitmapUtils;
import com.instabug.library.util.DisplayUtils;
import com.instabug.library.util.InstabugSDKLogger;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.opengles.GL10;

public final class ScreenshotTaker {

    public class a implements Function {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Bitmap f34381b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int[] f34382c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Activity f34383d;

        public a(Bitmap bitmap, int[] iArr, Activity activity) {
            this.f34381b = bitmap;
            this.f34382c = iArr;
            this.f34383d = activity;
        }

        /* renamed from: a */
        public ObservableSource apply(RootViewInfo rootViewInfo) throws Exception {
            return ScreenshotTaker.drawRootToBitmap(rootViewInfo, this.f34381b, this.f34382c, this.f34383d);
        }
    }

    public class b implements Function {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Bitmap f34384b;

        public b(Bitmap bitmap) {
            this.f34384b = bitmap;
        }

        /* renamed from: a */
        public Bitmap apply(HashMap hashMap) throws Exception {
            for (Map.Entry entry : hashMap.entrySet()) {
                ((View) entry.getKey()).setVisibility(((Integer) entry.getValue()).intValue());
            }
            return this.f34384b;
        }
    }

    public class c implements Function {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RootViewInfo f34385b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Activity f34386c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Bitmap f34387d;

        public c(RootViewInfo rootViewInfo, Activity activity, Bitmap bitmap) {
            this.f34385b = rootViewInfo;
            this.f34386c = activity;
            this.f34387d = bitmap;
        }

        /* renamed from: a */
        public HashMap apply(Pair pair) throws Exception {
            ArrayList unused = ScreenshotTaker.drawUnDrawableViews(this.f34385b.getView(), (Canvas) pair.first);
            com.instabug.library.instacapture.screenshot.pixelcopy.a.a(this.f34386c, this.f34387d);
            BitmapUtils.maskBitmap(this.f34386c, this.f34387d, SettingsManager.getInstance(), (Canvas) pair.first);
            return (HashMap) pair.second;
        }
    }

    public class d implements Function {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RootViewInfo f34388b;

        public d(RootViewInfo rootViewInfo) {
            this.f34388b = rootViewInfo;
        }

        /* renamed from: a */
        public Pair apply(Pair pair) throws Exception {
            for (View visibility : ((HashMap) pair.second).keySet()) {
                visibility.setVisibility(4);
            }
            this.f34388b.getView().draw((Canvas) pair.first);
            return pair;
        }
    }

    public class e implements ObservableOnSubscribe {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RootViewInfo f34389a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Bitmap f34390b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int[] f34391c;

        public e(RootViewInfo rootViewInfo, Bitmap bitmap, int[] iArr) {
            this.f34389a = rootViewInfo;
            this.f34390b = bitmap;
            this.f34391c = iArr;
        }

        public void subscribe(ObservableEmitter observableEmitter) throws Exception {
            if ((this.f34389a.getLayoutParams().flags & 2) == 2) {
                new Canvas(this.f34390b).drawARGB((int) (this.f34389a.getLayoutParams().dimAmount * 255.0f), 0, 0, 0);
            }
            Canvas canvas = new Canvas(this.f34390b);
            canvas.translate((float) this.f34389a.getLeft(), (float) this.f34389a.getTop());
            HashMap hashMap = new HashMap();
            if (this.f34391c != null) {
                for (int findViewById : this.f34391c) {
                    View findViewById2 = this.f34389a.getView().findViewById(findViewById);
                    if (findViewById2 != null) {
                        hashMap.put(findViewById2, Integer.valueOf(findViewById2.getVisibility()));
                    }
                }
            }
            observableEmitter.onNext(new Pair(canvas, hashMap));
        }
    }

    public class f implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f34392b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f34393c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ IntBuffer f34394d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CountDownLatch f34395e;

        public f(int i11, int i12, IntBuffer intBuffer, CountDownLatch countDownLatch) {
            this.f34392b = i11;
            this.f34393c = i12;
            this.f34394d = intBuffer;
            this.f34395e = countDownLatch;
        }

        public void run() {
            EGL10 egl10 = (EGL10) EGLContext.getEGL();
            egl10.eglWaitGL();
            GL10 gl10 = (GL10) egl10.eglGetCurrentContext().getGL();
            gl10.glFinish();
            try {
                Thread.sleep(200);
            } catch (InterruptedException unused) {
            }
            gl10.glReadPixels(0, 0, this.f34392b, this.f34393c + 0, 6408, 5121, this.f34394d);
            this.f34395e.countDown();
        }
    }

    private ScreenshotTaker() {
    }

    public static void drawGLSurfaceView(GLSurfaceView gLSurfaceView, int[] iArr, Canvas canvas) {
        InstabugSDKLogger.v("IBG-Core", "Drawing GLSurfaceView");
        if (gLSurfaceView.getWindowToken() != null) {
            int width = gLSurfaceView.getWidth();
            int height = gLSurfaceView.getHeight();
            int[] iArr2 = new int[((height + 0) * width)];
            IntBuffer wrap = IntBuffer.wrap(iArr2);
            wrap.position(0);
            CountDownLatch countDownLatch = new CountDownLatch(1);
            gLSurfaceView.queueEvent(new f(width, height, wrap, countDownLatch));
            try {
                countDownLatch.await();
            } catch (InterruptedException unused) {
            }
            int[] iArr3 = new int[(width * height)];
            int i11 = 0;
            int i12 = 0;
            while (i11 < height) {
                for (int i13 = 0; i13 < width; i13++) {
                    int i14 = iArr2[(i11 * width) + i13];
                    iArr3[(((height - i12) - 1) * width) + i13] = (i14 & -16711936) | ((i14 << 16) & 16711680) | ((i14 >> 16) & 255);
                }
                i11++;
                i12++;
            }
            Bitmap createBitmap = Bitmap.createBitmap(iArr3, width, height, Bitmap.Config.ARGB_8888);
            Paint paint = new Paint();
            paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
            canvas.drawBitmap(createBitmap, (float) iArr[0], (float) iArr[1], paint);
            createBitmap.recycle();
        }
    }

    /* access modifiers changed from: private */
    public static Observable<Bitmap> drawRootToBitmap(RootViewInfo rootViewInfo, Bitmap bitmap, @IdRes @Nullable int[] iArr, Activity activity) {
        return Observable.create(new e(rootViewInfo, bitmap, iArr)).observeOn(AndroidSchedulers.mainThread()).map(new d(rootViewInfo)).observeOn(Schedulers.io()).map(new c(rootViewInfo, activity, bitmap)).observeOn(AndroidSchedulers.mainThread()).map(new b(bitmap)).subscribeOn(Schedulers.io());
    }

    private static Observable<Bitmap> drawRootsToBitmap(List<RootViewInfo> list, Bitmap bitmap, @IdRes @Nullable int[] iArr, Activity activity) {
        if (list != null && list.size() > 1) {
            while (list.size() > 1) {
                list.remove(list.size() - 1);
            }
        }
        return Observable.fromIterable(list).flatMap(new a(bitmap, iArr, activity));
    }

    @TargetApi(14)
    public static void drawTextureView(TextureView textureView, int[] iArr, Canvas canvas) {
        InstabugSDKLogger.v("IBG-Core", "Drawing TextureView");
        try {
            Bitmap bitmap = textureView.getBitmap();
            if (bitmap != null) {
                Paint paint = new Paint();
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
                canvas.drawBitmap(bitmap, (float) iArr[0], (float) iArr[1], paint);
                bitmap.recycle();
            }
        } catch (OutOfMemoryError e11) {
            InstabugCore.reportError(e11, "Drawing textureView failed due to an OOM: " + e11.getMessage());
            InstabugSDKLogger.e("IBG-Core", "OOM while taking screenshot", e11);
        }
    }

    /* access modifiers changed from: private */
    public static ArrayList<View> drawUnDrawableViews(View view, Canvas canvas) {
        if (!(view instanceof ViewGroup)) {
            ArrayList<View> arrayList = new ArrayList<>();
            arrayList.add(view);
            return arrayList;
        }
        ArrayList<View> arrayList2 = new ArrayList<>();
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            View childAt = viewGroup.getChildAt(i11);
            ArrayList arrayList3 = new ArrayList();
            arrayList3.add(view);
            arrayList3.addAll(drawUnDrawableViews(childAt, canvas));
            int[] iArr = new int[2];
            childAt.getLocationOnScreen(iArr);
            if (childAt instanceof TextureView) {
                drawTextureView((TextureView) childAt, iArr, canvas);
            }
            if (childAt instanceof GLSurfaceView) {
                drawGLSurfaceView((GLSurfaceView) childAt, iArr, canvas);
            }
            if (childAt instanceof WebView) {
                drawWebView((WebView) childAt, canvas);
            }
            arrayList2.addAll(arrayList3);
        }
        return arrayList2;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    @TargetApi(11)
    public static void drawWebView(WebView webView, Canvas canvas) {
        int layerType = webView.getLayerType();
        if (layerType == 2) {
            webView.setLayerType(0, (Paint) null);
            webView.setDrawingCacheEnabled(true);
            webView.buildDrawingCache(true);
            Bitmap drawingCache = webView.getDrawingCache();
            if (drawingCache != null) {
                Paint paint = new Paint();
                paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
                int[] iArr = new int[2];
                webView.getLocationOnScreen(iArr);
                canvas.drawBitmap(drawingCache, (float) iArr[0], (float) iArr[1], paint);
                drawingCache.recycle();
            }
            webView.setDrawingCacheEnabled(false);
            webView.setLayerType(layerType, (Paint) null);
        }
    }

    public static Observable<Bitmap> getScreenshotBitmap(Activity activity, @IdRes @Nullable int[] iArr) {
        boolean z11;
        String str;
        Bitmap bitmap;
        if (activity != null) {
            if ((activity.getWindow().getAttributes().flags & 8192) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11 && !SettingsManager.getInstance().shouldIgnoreFlagSecure()) {
                throw new com.instabug.library.instacapture.exception.c("FLAG_SECURE is enabled for activity " + activity.getClass().getName() + " . Not capturing screenshot.");
            } else if (Build.VERSION.SDK_INT >= 26) {
                return h.c(activity, iArr);
            } else {
                View decorView = activity.getWindow().getDecorView();
                List<RootViewInfo> rootViews = FieldHelper.getRootViews(activity, iArr);
                try {
                    if (((long) (decorView.getWidth() * decorView.getHeight() * 4)) < com.instabug.library.instacapture.utility.a.a(activity)) {
                        bitmap = Bitmap.createBitmap(decorView.getWidth(), decorView.getHeight(), Bitmap.Config.ARGB_8888);
                    } else {
                        bitmap = Bitmap.createBitmap(decorView.getWidth(), decorView.getHeight(), Bitmap.Config.RGB_565);
                    }
                    return drawRootsToBitmap(rootViews, bitmap, iArr, activity);
                } catch (IllegalArgumentException | OutOfMemoryError e11) {
                    if (e11.getMessage() == null) {
                        str = "error while capturing screenshot";
                    } else {
                        str = e11.getMessage();
                    }
                    InstabugSDKLogger.e("IBG-Core", str, e11);
                    return null;
                }
            }
        } else {
            throw new IllegalArgumentException("Parameter activity cannot be null.");
        }
    }

    public static Rect getVisibleRect(@Nullable View view) {
        Rect rect = new Rect();
        if (view == null || view.getVisibility() != 0 || view.getRootView().getParent() == null) {
            return new Rect(0, 0, 0, 0);
        }
        return !view.getGlobalVisibleRect(rect) ? new Rect(0, 0, 0, 0) : rect;
    }

    public static boolean isVisible(View view) {
        int i11;
        int i12;
        if (view.getVisibility() != 0) {
            return false;
        }
        Rect rect = new Rect();
        view.getGlobalVisibleRect(rect);
        Context applicationContext = Instabug.getApplicationContext();
        if (applicationContext == null) {
            i11 = 0;
        } else {
            i11 = DisplayUtils.getDisplayWidthInPx(applicationContext);
        }
        if (applicationContext == null) {
            i12 = 0;
        } else {
            i12 = DisplayUtils.getDisplayHeightInPx(applicationContext);
        }
        return rect.intersect(new Rect(0, 0, i11, i12));
    }

    public static Rect getVisibleRect(@Nullable View view, Rect rect) {
        Rect rect2 = new Rect();
        if (view == null || view.getVisibility() != 0 || view.getRootView().getParent() == null) {
            return new Rect(0, 0, 0, 0);
        }
        return !view.getGlobalVisibleRect(rect2) ? new Rect(0, 0, 0, 0) : rect2;
    }
}
