package com.instabug.library.instacapture.screenshot.pixelcopy;

import ad.a;
import android.app.Activity;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import androidx.annotation.IdRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import java.util.HashMap;

public abstract class h {
    /* access modifiers changed from: private */
    public static /* synthetic */ boolean a(Bitmap bitmap) throws Exception {
        return !bitmap.isRecycled();
    }

    /* access modifiers changed from: private */
    public static HashMap b(@NonNull Activity activity, int[] iArr) {
        HashMap hashMap = new HashMap();
        if (!(activity == null || iArr == null)) {
            for (int findViewById : iArr) {
                View findViewById2 = activity.findViewById(findViewById);
                if (findViewById2 != null) {
                    hashMap.put(findViewById2, Integer.valueOf(findViewById2.getVisibility()));
                    findViewById2.setVisibility(8);
                }
            }
        }
        return hashMap;
    }

    @RequiresApi(api = 26)
    public static Observable c(@NonNull Activity activity, @IdRes @Nullable int[] iArr) {
        return Observable.create(new f(activity)).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).map(new e(activity, iArr)).observeOn(Schedulers.io()).map(new d(activity)).filter(new a());
    }

    /* access modifiers changed from: private */
    public static void b(HashMap hashMap) {
        new Handler(Looper.getMainLooper()).post(new g(hashMap));
    }

    /* access modifiers changed from: private */
    public static void b(Activity activity, int i11, Bitmap bitmap) {
        if (i11 == 0) {
            a.a(activity, bitmap);
        } else {
            bitmap.recycle();
        }
    }
}
