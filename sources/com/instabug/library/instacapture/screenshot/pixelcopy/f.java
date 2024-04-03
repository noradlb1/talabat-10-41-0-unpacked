package com.instabug.library.instacapture.screenshot.pixelcopy;

import android.app.Activity;
import android.graphics.Bitmap;
import com.instabug.library.instacapture.utility.a;
import com.instabug.library.util.InstabugSDKLogger;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;

class f implements ObservableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f34404a;

    public f(Activity activity) {
        this.f34404a = activity;
    }

    public void subscribe(ObservableEmitter observableEmitter) throws Exception {
        Bitmap bitmap;
        b bVar = new b(this.f34404a);
        try {
            if (((long) (bVar.f34396a * bVar.f34397b * 4)) < a.a(this.f34404a)) {
                bitmap = Bitmap.createBitmap(bVar.f34396a, bVar.f34397b, Bitmap.Config.ARGB_8888);
            } else {
                bitmap = Bitmap.createBitmap(bVar.f34396a, bVar.f34397b, Bitmap.Config.RGB_565);
            }
            observableEmitter.onNext(bitmap);
        } catch (IllegalArgumentException | OutOfMemoryError e11) {
            InstabugSDKLogger.e("IBG-Core", "Something went wrong while capturing " + e11.getMessage(), e11);
            observableEmitter.onError(e11);
        }
    }
}
