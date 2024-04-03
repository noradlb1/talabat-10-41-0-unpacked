package com.instabug.library.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntRange;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.instabug.library.Instabug;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.instacapture.screenshot.FieldHelper;
import com.instabug.library.instacapture.screenshot.RootViewInfo;
import com.instabug.library.instacapture.screenshot.ScreenshotTaker;
import com.instabug.library.internal.storage.DiskUtils;
import com.instabug.library.internal.storage.cache.AssetsCacheManager;
import com.instabug.library.model.AssetEntity;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.BitmapWorkerTask;
import com.instabug.library.util.memory.Action;
import com.instabug.library.util.memory.ActionExecutor;
import com.instabug.library.util.memory.MemoryGuard;
import com.instabug.library.util.memory.predicate.MemoryNotLowPredicate;
import com.instabug.library.util.threading.PoolProvider;
import com.instabug.library.util.threading.ThreadUtils;
import com.instabug.library.visualusersteps.VisualUserStepsHelper;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Collection;
import java.util.List;
import net.bytebuddy.utility.JavaConstant;

@Instrumented
public class BitmapUtils {
    private static final String ICON_FILE_PREFIX = "icon";

    @Keep
    public interface OnBitmapReady {
        void onBitmapFailedToLoad();

        void onBitmapReady(@Nullable Bitmap bitmap);
    }

    public interface OnSaveBitmapCallback {
        void onError(Throwable th2);

        void onSuccess(Uri uri);
    }

    public class a implements Action {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ File f52020a;

        public a(File file) {
            this.f52020a = file;
        }

        public void onAffirmed() throws Throwable {
            BitmapUtils.compressBitmapAndSave(this.f52020a);
        }

        public void onDenied() throws Throwable {
            InstabugSDKLogger.e("IBG-Core", "Not enough memory for compressing image");
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ File f52021b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f52022c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Bitmap f52023d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f52024e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ OnSaveBitmapCallback f52025f;

        public b(File file, String str, Bitmap bitmap, int i11, OnSaveBitmapCallback onSaveBitmapCallback) {
            this.f52021b = file;
            this.f52022c = str;
            this.f52023d = bitmap;
            this.f52024e = i11;
            this.f52025f = onSaveBitmapCallback;
        }

        public void run() {
            File file = this.f52021b;
            File file2 = new File(file, this.f52022c + JavaConstant.Dynamic.DEFAULT_NAME + System.currentTimeMillis() + ".png");
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file2));
                boolean b11 = BitmapUtils.compressQuietly(this.f52023d, Bitmap.CompressFormat.PNG, this.f52024e, bufferedOutputStream);
                bufferedOutputStream.close();
                Uri fromFile = Uri.fromFile(file2);
                if (!b11 || fromFile == null) {
                    this.f52025f.onError(new Throwable("Uri equal null"));
                } else {
                    this.f52025f.onSuccess(fromFile);
                }
            } catch (IOException e11) {
                this.f52025f.onError(e11);
            }
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Context f52026b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Bitmap f52027c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ OnSaveBitmapCallback f52028d;

        public c(Context context, Bitmap bitmap, OnSaveBitmapCallback onSaveBitmapCallback) {
            this.f52026b = context;
            this.f52027c = bitmap;
            this.f52028d = onSaveBitmapCallback;
        }

        public void run() {
            File instabugDirectory = DiskUtils.getInstabugDirectory(this.f52026b);
            File file = new File(instabugDirectory, "bug_" + System.currentTimeMillis() + "_.jpg");
            try {
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                boolean b11 = BitmapUtils.compressQuietly(this.f52027c, Bitmap.CompressFormat.JPEG, 100, bufferedOutputStream);
                bufferedOutputStream.close();
                new Handler(Looper.getMainLooper()).post(new b(this, b11, Uri.fromFile(file)));
            } catch (IOException e11) {
                this.f52028d.onError(e11);
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ long f52029b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Drawable f52030c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ OnSaveBitmapCallback f52031d;

        public d(long j11, Drawable drawable, OnSaveBitmapCallback onSaveBitmapCallback) {
            this.f52029b = j11;
            this.f52030c = drawable;
            this.f52031d = onSaveBitmapCallback;
        }

        public void run() {
            try {
                BitmapUtils.drawableToBitmap(this.f52030c, new c(this, BitmapUtils.getIconTargetDirectory(this.f52029b)));
            } catch (Exception e11) {
                this.f52031d.onError(e11);
            }
        }
    }

    public class e implements AssetsCacheManager.OnDownloadFinished {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ OnBitmapReady f52032a;

        public e(OnBitmapReady onBitmapReady) {
            this.f52032a = onBitmapReady;
        }

        public void onFailed(Throwable th2) {
            InstabugSDKLogger.e("IBG-Core", "Asset Entity downloading got error", th2);
            this.f52032a.onBitmapFailedToLoad();
        }

        public void onSuccess(AssetEntity assetEntity) {
            InstabugSDKLogger.d("IBG-Core", "Asset Entity downloaded: " + assetEntity.getFile().getPath());
            if (ThreadUtils.isCurrentThreadMain()) {
                PoolProvider.postBitmapTask(new d(this, assetEntity));
            } else {
                BitmapUtils.decodeBitmap(assetEntity, this.f52032a);
            }
        }
    }

    public class f implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Drawable f52033b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Canvas f52034c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ int f52035d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f52036e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ OnBitmapReady f52037f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ Bitmap f52038g;

        public f(Drawable drawable, Canvas canvas, int i11, int i12, OnBitmapReady onBitmapReady, Bitmap bitmap) {
            this.f52033b = drawable;
            this.f52034c = canvas;
            this.f52035d = i11;
            this.f52036e = i12;
            this.f52037f = onBitmapReady;
            this.f52038g = bitmap;
        }

        public void run() {
            this.f52033b.setBounds(0, 0, this.f52034c.getWidth(), this.f52034c.getHeight());
            this.f52033b.draw(this.f52034c);
            PoolProvider.postBitmapTask(new e(this));
        }
    }

    public class g implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Uri f52039b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Context f52040c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Bitmap f52041d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ OnSaveBitmapCallback f52042e;

        public g(Uri uri, Context context, Bitmap bitmap, OnSaveBitmapCallback onSaveBitmapCallback) {
            this.f52039b = uri;
            this.f52040c = context;
            this.f52041d = bitmap;
            this.f52042e = onSaveBitmapCallback;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
            r0 = android.net.Uri.fromFile(new java.io.File(r5.f52039b.getPath()));
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
                android.net.Uri r0 = r5.f52039b     // Catch:{ FileNotFoundException -> 0x003f }
                java.lang.String r0 = r0.getPath()     // Catch:{ FileNotFoundException -> 0x003f }
                if (r0 == 0) goto L_0x0060
                java.io.File r0 = new java.io.File     // Catch:{ FileNotFoundException -> 0x003f }
                android.net.Uri r1 = r5.f52039b     // Catch:{ FileNotFoundException -> 0x003f }
                java.lang.String r1 = r1.getPath()     // Catch:{ FileNotFoundException -> 0x003f }
                r0.<init>(r1)     // Catch:{ FileNotFoundException -> 0x003f }
                android.net.Uri r0 = android.net.Uri.fromFile(r0)     // Catch:{ FileNotFoundException -> 0x003f }
                android.content.Context r1 = r5.f52040c     // Catch:{ FileNotFoundException -> 0x003f }
                android.content.ContentResolver r1 = r1.getContentResolver()     // Catch:{ FileNotFoundException -> 0x003f }
                java.io.OutputStream r1 = r1.openOutputStream(r0)     // Catch:{ FileNotFoundException -> 0x003f }
                if (r1 == 0) goto L_0x0060
                android.graphics.Bitmap r2 = r5.f52041d     // Catch:{ FileNotFoundException -> 0x003f }
                android.graphics.Bitmap$CompressFormat r3 = android.graphics.Bitmap.CompressFormat.PNG     // Catch:{ FileNotFoundException -> 0x003f }
                r4 = 100
                boolean r1 = com.instabug.library.util.BitmapUtils.compressQuietly(r2, r3, r4, r1)     // Catch:{ FileNotFoundException -> 0x003f }
                android.os.Handler r2 = new android.os.Handler     // Catch:{ FileNotFoundException -> 0x003f }
                android.os.Looper r3 = android.os.Looper.getMainLooper()     // Catch:{ FileNotFoundException -> 0x003f }
                r2.<init>(r3)     // Catch:{ FileNotFoundException -> 0x003f }
                com.instabug.library.util.f r3 = new com.instabug.library.util.f     // Catch:{ FileNotFoundException -> 0x003f }
                r3.<init>(r5, r1, r0)     // Catch:{ FileNotFoundException -> 0x003f }
                r2.post(r3)     // Catch:{ FileNotFoundException -> 0x003f }
                goto L_0x0060
            L_0x003f:
                r0 = move-exception
                java.lang.String r1 = r0.getMessage()
                if (r1 == 0) goto L_0x0060
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Error while saving bitmap: "
                r1.append(r2)
                java.lang.String r0 = r0.getMessage()
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                java.lang.String r1 = "IBG-Core"
                com.instabug.library.util.InstabugSDKLogger.e(r1, r0)
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.instabug.library.util.BitmapUtils.g.run():void");
        }
    }

    public static int calculateInSampleSize(BitmapFactory.Options options) {
        int i11 = options.outHeight;
        int i12 = options.outWidth;
        int i13 = 1;
        if (i11 > 500 || i12 > 500) {
            int i14 = i11 / 2;
            int i15 = i12 / 2;
            while (i14 / i13 >= 500 && i15 / i13 >= 500) {
                i13 *= 2;
            }
        }
        return i13;
    }

    public static void compressBitmapAndSave(@NonNull Context context, @NonNull File file) {
        if (context != null && file != null) {
            ActionExecutor withPredicate = MemoryGuard.from(context).withPredicate(new MemoryNotLowPredicate());
            withPredicate.forOperation("compressing a bitmap with size: " + file.length()).doAction(new a(file));
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public static boolean compressQuietly(@NonNull Bitmap bitmap, @NonNull Bitmap.CompressFormat compressFormat, @IntRange(from = 0, to = 100) int i11, @NonNull OutputStream outputStream) {
        try {
            if (bitmap.isRecycled() || !bitmap.compress(compressFormat, i11, outputStream)) {
                return false;
            }
            return true;
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-Core", "Error while compressing bitmap " + e11.getMessage());
            return false;
        }
    }

    /* access modifiers changed from: private */
    @WorkerThread
    public static void decodeBitmap(AssetEntity assetEntity, OnBitmapReady onBitmapReady) {
        try {
            onBitmapReady.onBitmapReady(BitmapFactoryInstrumentation.decodeStream(new FileInputStream(assetEntity.getFile())));
        } catch (FileNotFoundException e11) {
            InstabugSDKLogger.e("IBG-Core", "Asset Entity downloading got FileNotFoundException error", e11);
            onBitmapReady.onBitmapFailedToLoad();
        }
    }

    public static Bitmap decodeSampledBitmapFromLocalPath(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactoryInstrumentation.decodeFile(str, options);
        options.inSampleSize = calculateInSampleSize(options);
        options.inJustDecodeBounds = false;
        return BitmapFactoryInstrumentation.decodeFile(str, options);
    }

    /* access modifiers changed from: private */
    public static void drawableToBitmap(Drawable drawable, OnBitmapReady onBitmapReady) {
        Bitmap bitmap;
        if (!(drawable instanceof BitmapDrawable) || (bitmap = ((BitmapDrawable) drawable).getBitmap()) == null) {
            Context applicationContext = Instabug.getApplicationContext();
            if (applicationContext != null) {
                int dpToPxIntRounded = DisplayUtils.dpToPxIntRounded(applicationContext.getResources(), 72);
                int intrinsicWidth = drawable.getIntrinsicWidth();
                int intrinsicHeight = drawable.getIntrinsicHeight();
                if (intrinsicWidth <= dpToPxIntRounded && intrinsicHeight <= dpToPxIntRounded) {
                    Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(createBitmap);
                    if (drawable.getConstantState() != null) {
                        drawable = drawable.getConstantState().newDrawable();
                    }
                    PoolProvider.postMainThreadTask(new f(drawable, canvas, intrinsicWidth, intrinsicHeight, onBitmapReady, createBitmap));
                    return;
                }
                return;
            }
            return;
        }
        onBitmapReady.onBitmapReady(resizeBitmap(bitmap, 24.0f, 24.0f));
    }

    @Nullable
    public static Bitmap getBitmapFromUri(@NonNull Uri uri) {
        try {
            if (Instabug.getApplicationContext() != null) {
                return MediaStore.Images.Media.getBitmap(Instabug.getApplicationContext().getContentResolver(), uri);
            }
        } catch (IOException e11) {
            e11.printStackTrace();
            InstabugSDKLogger.e("IBG-Core", "getBitmapFromFilePath returns null because of " + e11.getMessage());
        }
        return null;
    }

    @WorkerThread
    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    @NonNull
    public static File getIconTargetDirectory(long j11) {
        File visualUserStepsDirectory = VisualUserStepsHelper.getVisualUserStepsDirectory(Instabug.getApplicationContext());
        return new File(visualUserStepsDirectory, "icon_" + j11 + ".png");
    }

    private static Bitmap.CompressFormat getImageMimeType(File file) {
        if (file.getName().contains("png")) {
            return Bitmap.CompressFormat.PNG;
        }
        return Bitmap.CompressFormat.JPEG;
    }

    /* access modifiers changed from: private */
    public static float[] getTargetDimensions(int i11, int i12) {
        float[] fArr = {24.0f, 24.0f};
        if (i12 > i11) {
            fArr[0] = (((float) i11) / ((float) i12)) * 24.0f;
        } else if (i12 < i11) {
            fArr[1] = (((float) i12) / ((float) i11)) * 24.0f;
        }
        return fArr;
    }

    public static void loadBitmap(String str, ImageView imageView) {
        AsyncTaskInstrumentation.execute(new BitmapWorkerTask(imageView), str);
    }

    @WorkerThread
    public static void loadBitmapForAsset(@Nullable Context context, String str, AssetEntity.AssetType assetType, OnBitmapReady onBitmapReady) {
        if (context != null) {
            AssetsCacheManager.getAssetEntity(AssetsCacheManager.createEmptyEntity(context, str, assetType), new e(onBitmapReady));
        }
    }

    public static void loadBitmapWithFallback(String str, ImageView imageView, @DrawableRes int i11) {
        AsyncTaskInstrumentation.execute(new BitmapWorkerTask(imageView, i11), str);
    }

    public static void maskBitmap(@Nullable Activity activity, Bitmap bitmap, @NonNull SettingsManager settingsManager, @Nullable Canvas canvas) {
        if (activity != null) {
            if (canvas == null) {
                try {
                    canvas = new Canvas(bitmap);
                } catch (Throwable th2) {
                    InstabugSDKLogger.e("IBG-Core", "couldn't mask Bitmap for screen shot ", th2);
                    IBGDiagnostics.reportNonFatal(th2, "couldn't mask Bitmap for screen shot ");
                    return;
                }
            }
            Collection<View> privateViews = settingsManager.getPrivateViews();
            for (View next : privateViews) {
                if (!(next == null || activity.findViewById(next.getId()) == null || !ScreenshotTaker.isVisible(next))) {
                    next.getLocationOnScreen(new int[2]);
                    canvas.drawRect(ScreenshotTaker.getVisibleRect(next), new Paint());
                }
            }
            List<RootViewInfo> rootViews = FieldHelper.getRootViews(activity, (int[]) null);
            if (rootViews != null && rootViews.size() > 0) {
                for (RootViewInfo next2 : rootViews) {
                    for (View next3 : privateViews) {
                        if (!(next3 == null || next2.getView().findViewById(next3.getId()) == null || !ScreenshotTaker.isVisible(next3))) {
                            Rect visibleRect = ScreenshotTaker.getVisibleRect(next3);
                            int[] iArr = new int[2];
                            next2.getView().getLocationOnScreen(iArr);
                            int i11 = visibleRect.top;
                            int i12 = iArr[1];
                            visibleRect.top = i11 + i12;
                            visibleRect.bottom += i12;
                            int i13 = visibleRect.left;
                            int i14 = iArr[0];
                            visibleRect.left = i13 + i14;
                            visibleRect.right += i14;
                            canvas.drawRect(visibleRect, new Paint());
                        }
                    }
                }
            }
        }
    }

    @Nullable
    public static Bitmap resizeBitmap(Bitmap bitmap, float f11, float f12) {
        if (bitmap == null) {
            return null;
        }
        if (f11 == 0.0f && f12 == 0.0f) {
            return bitmap;
        }
        Bitmap createBitmap = Bitmap.createBitmap((int) f11, (int) f12, Bitmap.Config.ARGB_8888);
        if (bitmap.getWidth() < bitmap.getHeight() && f11 > f12) {
            return bitmap;
        }
        if (bitmap.getWidth() > bitmap.getHeight() && f11 < f12) {
            return bitmap;
        }
        Canvas canvas = new Canvas(createBitmap);
        Matrix matrix = new Matrix();
        if (bitmap.getWidth() < bitmap.getHeight()) {
            matrix.setScale(f11 / ((float) bitmap.getWidth()), f12 / ((float) bitmap.getHeight()));
        } else {
            matrix.setScale(f12 / ((float) bitmap.getHeight()), f11 / ((float) bitmap.getWidth()));
        }
        canvas.drawBitmap(bitmap, matrix, new Paint());
        return createBitmap;
    }

    public static void saveBitmap(Bitmap bitmap, Context context, OnSaveBitmapCallback onSaveBitmapCallback) {
        PoolProvider.postBitmapTask(new c(context, bitmap, onSaveBitmapCallback));
    }

    public static void saveBitmapAsPNG(Bitmap bitmap, int i11, File file, String str, OnSaveBitmapCallback onSaveBitmapCallback) {
        PoolProvider.postBitmapTask(new b(file, str, bitmap, i11, onSaveBitmapCallback));
    }

    public static void saveDrawableBitmap(Drawable drawable, long j11, OnSaveBitmapCallback onSaveBitmapCallback) {
        if (drawable != null) {
            PoolProvider.postBitmapTask(new d(j11, drawable, onSaveBitmapCallback));
        }
    }

    public static void saveBitmap(Bitmap bitmap, Uri uri, Context context, OnSaveBitmapCallback onSaveBitmapCallback) {
        if (uri.getPath() != null) {
            PoolProvider.postBitmapTask(new g(uri, context, bitmap, onSaveBitmapCallback));
        }
    }

    public static void loadBitmap(String str, ImageView imageView, float f11, float f12) {
        AsyncTaskInstrumentation.execute(new BitmapWorkerTask(imageView, f11, f12), str);
    }

    /* access modifiers changed from: private */
    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public static void compressBitmapAndSave(File file) {
        try {
            BitmapFactory.Options options = new BitmapFactory.Options();
            int i11 = 1;
            options.inJustDecodeBounds = true;
            FileInputStream fileInputStream = new FileInputStream(file);
            BitmapFactoryInstrumentation.decodeStream(fileInputStream, (Rect) null, options);
            fileInputStream.close();
            while ((options.outWidth / i11) / 2 >= 900 && (options.outHeight / i11) / 2 >= 900) {
                i11 *= 2;
            }
            BitmapFactory.Options options2 = new BitmapFactory.Options();
            options2.inSampleSize = i11;
            FileInputStream fileInputStream2 = new FileInputStream(file);
            Bitmap decodeStream = BitmapFactoryInstrumentation.decodeStream(fileInputStream2, (Rect) null, options2);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            if (decodeStream != null) {
                decodeStream.compress(getImageMimeType(file), 100, fileOutputStream);
                decodeStream.recycle();
            }
            fileOutputStream.close();
            fileInputStream2.close();
        } catch (Exception e11) {
            e11.printStackTrace();
            InstabugSDKLogger.e("IBG-Core", "bitmap doesn't compressed correctly " + e11.getMessage());
        }
    }

    public static void loadBitmap(@NonNull String str, ImageView imageView, BitmapWorkerTask.OnImageLoadedListener onImageLoadedListener) {
        AsyncTaskInstrumentation.execute(new BitmapWorkerTask(imageView, onImageLoadedListener), str);
    }

    public static void loadBitmap(String str, ImageView imageView, float f11, float f12, BitmapWorkerTask.OnImageLoadedListener onImageLoadedListener) {
        AsyncTaskInstrumentation.execute(new BitmapWorkerTask(imageView, f11, f12, onImageLoadedListener), str);
    }
}
