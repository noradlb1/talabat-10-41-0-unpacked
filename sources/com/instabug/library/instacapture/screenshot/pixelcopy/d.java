package com.instabug.library.instacapture.screenshot.pixelcopy;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Pair;
import android.view.PixelCopy;
import com.instabug.library.diagnostics.IBGDiagnostics;
import io.reactivex.functions.Function;
import java.util.HashMap;

class d implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f34401b;

    public d(Activity activity) {
        this.f34401b = activity;
    }

    /* renamed from: a */
    public Bitmap apply(Pair pair) throws Exception {
        String str;
        Bitmap bitmap = (Bitmap) pair.first;
        try {
            PixelCopy.request(this.f34401b.getWindow(), bitmap, new c(this, bitmap, (HashMap) pair.second), k.a());
        } catch (Exception | OutOfMemoryError e11) {
            if (e11.getMessage() != null) {
                str = "Something went wrong while capturing ";
            } else {
                str = "";
            }
            IBGDiagnostics.reportNonFatal(e11, str);
        }
        return bitmap;
    }
}
