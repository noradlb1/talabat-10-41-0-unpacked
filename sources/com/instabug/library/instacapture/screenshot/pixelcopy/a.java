package com.instabug.library.instacapture.screenshot.pixelcopy;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.view.View;
import androidx.annotation.CheckResult;
import androidx.annotation.NonNull;
import com.instabug.library.instacapture.screenshot.FieldHelper;
import com.instabug.library.instacapture.screenshot.RootViewInfo;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.List;

public abstract class a {
    @CheckResult
    public static Bitmap a(@NonNull Activity activity, @NonNull Bitmap bitmap) {
        List<RootViewInfo> rootViews;
        if (!(activity == null || (rootViews = FieldHelper.getRootViews(activity, (int[]) null)) == null || rootViews.isEmpty())) {
            try {
                Canvas canvas = new Canvas(bitmap);
                for (RootViewInfo next : rootViews) {
                    if (next.isDialog()) {
                        a(canvas, next);
                    }
                }
                for (RootViewInfo next2 : rootViews) {
                    if (next2.isDialog()) {
                        canvas.drawColor(Color.argb((int) (next2.getLayoutParams().dimAmount * 255.0f), 0, 0, 0));
                        a(canvas, next2);
                    }
                }
                return bitmap;
            } catch (Exception e11) {
                InstabugSDKLogger.e("IBG-Core", "Something went wrong while getting root views", e11);
            }
        }
        return bitmap;
    }

    private static void a(@NonNull Canvas canvas, @NonNull RootViewInfo rootViewInfo) {
        if (canvas != null && rootViewInfo != null) {
            View view = rootViewInfo.getView();
            if (view.getWidth() != 0 && view.getHeight() != 0) {
                canvas.save();
                canvas.translate((float) rootViewInfo.getRect().left, (float) rootViewInfo.getRect().top);
                rootViewInfo.getView().draw(canvas);
                canvas.restore();
            }
        }
    }
}
