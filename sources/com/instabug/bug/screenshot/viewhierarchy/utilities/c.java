package com.instabug.bug.screenshot.viewhierarchy.utilities;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.opengl.GLSurfaceView;
import android.text.method.TransformationMethod;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import com.instabug.bug.screenshot.viewhierarchy.b;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.instacapture.screenshot.ScreenshotTaker;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;

public abstract class c {
    @Nullable
    private static Bitmap a(Bitmap bitmap, int i11) {
        if (bitmap == null || bitmap.getWidth() <= i11 || bitmap.getHeight() <= i11) {
            return null;
        }
        return Bitmap.createScaledBitmap(bitmap, bitmap.getWidth() / i11, bitmap.getHeight() / i11, false);
    }

    @Nullable
    private static Bitmap a(Bitmap bitmap, Rect rect, Rect rect2) {
        if (bitmap == null || rect == null || rect.width() <= 0 || rect.height() <= 0) {
            return null;
        }
        int i11 = rect.left - rect2.left;
        int i12 = rect.top - rect2.top;
        if (i11 < 0 || i12 < 0 || rect.width() > bitmap.getWidth() || rect.height() > bitmap.getHeight()) {
            return null;
        }
        try {
            return Bitmap.createBitmap(bitmap, i11, i12, rect.width(), rect.height());
        } catch (OutOfMemoryError e11) {
            InstabugCore.reportError(e11, "Cropping bitmap throws an OOM");
            return null;
        }
    }

    @Nullable
    private static Bitmap a(@Nullable View view) {
        if (view == null) {
            return null;
        }
        try {
            if (view instanceof EditText) {
                TransformationMethod transformationMethod = ((EditText) view).getTransformationMethod();
                int inputType = ((EditText) view).getInputType();
                ((EditText) view).setInputType(1);
                ((EditText) view).setTransformationMethod(new b());
                view.buildDrawingCache();
                Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache());
                ((EditText) view).setInputType(inputType);
                ((EditText) view).setTransformationMethod(transformationMethod);
                return createBitmap;
            }
            Bitmap createBitmap2 = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(createBitmap2);
            view.setDrawingCacheEnabled(true);
            view.buildDrawingCache(true);
            view.draw(canvas);
            view.setDrawingCacheEnabled(false);
            int[] iArr = new int[2];
            if (view instanceof TextureView) {
                ScreenshotTaker.drawTextureView((TextureView) view, iArr, canvas);
            }
            if (view instanceof GLSurfaceView) {
                ScreenshotTaker.drawGLSurfaceView((GLSurfaceView) view, iArr, canvas);
            }
            if (view instanceof WebView) {
                ScreenshotTaker.drawWebView((WebView) view, canvas);
            }
            for (View next : SettingsManager.getInstance().getPrivateViews()) {
                if (next != null && ScreenshotTaker.isVisible(next) && next.getId() == view.getId()) {
                    canvas.drawColor(ViewCompat.MEASURED_STATE_MASK);
                }
            }
            return createBitmap2;
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-BR", "Error: " + e11.getMessage() + " occurred while capturing view");
            return null;
        }
    }

    @Nullable
    private static Bitmap a(b bVar) {
        Bitmap a11;
        Bitmap a12;
        View l11 = bVar.l();
        if (l11 == null || bVar.m() == null || l11.getHeight() <= 0 || l11.getWidth() <= 0 || bVar.m().height() <= 0 || bVar.m().width() <= 0 || (a11 = a(l11)) == null || bVar.g() == null || (a12 = a(a11, bVar.m(), bVar.g())) == null) {
            return null;
        }
        return a(a12, bVar.j());
    }

    private static void a(ViewGroup viewGroup, boolean[] zArr) {
        for (int i11 = 0; i11 < zArr.length; i11++) {
            if (zArr[i11]) {
                viewGroup.getChildAt(i11).setVisibility(0);
            }
        }
    }

    private static boolean[] a(ViewGroup viewGroup) {
        boolean[] zArr = new boolean[viewGroup.getChildCount()];
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            if (viewGroup.getChildAt(i11).getVisibility() == 0) {
                zArr[i11] = true;
                viewGroup.getChildAt(i11).setVisibility(4);
            } else {
                zArr[i11] = false;
            }
        }
        return zArr;
    }

    public static b b(b bVar) {
        return c(bVar);
    }

    private static b c(b bVar) {
        Bitmap bitmap;
        InstabugSDKLogger.v("IBG-BR", "staring capture viewHierarchy: " + bVar.c());
        if (bVar.l() instanceof ViewGroup) {
            boolean[] a11 = a((ViewGroup) bVar.l());
            bitmap = a(bVar);
            a((ViewGroup) bVar.l(), a11);
        } else {
            bitmap = a(bVar);
        }
        bVar.a(bitmap);
        InstabugSDKLogger.v("IBG-BR", "capture viewHierarchy done successfully: " + bVar.c());
        return bVar;
    }
}
