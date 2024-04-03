package com.instabug.library.instacapture.screenshot;

import android.app.Activity;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.reactivex.Observable;

public abstract class b {
    @Nullable
    public static Observable a(@NonNull Activity activity, @IdRes @Nullable int[] iArr) {
        return ScreenshotTaker.getScreenshotBitmap(activity, iArr);
    }
}
