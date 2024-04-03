package com.instabug.library.instacapture.screenshot.pixelcopy;

import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Pair;
import com.instabug.library.diagnostics.IBGDiagnostics;
import io.reactivex.functions.Function;
import java.util.HashMap;

class e implements Function {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f34402b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int[] f34403c;

    public e(Activity activity, int[] iArr) {
        this.f34402b = activity;
        this.f34403c = iArr;
    }

    /* renamed from: a */
    public Pair apply(Bitmap bitmap) throws Exception {
        String str;
        try {
            return new Pair(bitmap, h.b(this.f34402b, this.f34403c));
        } catch (Exception | OutOfMemoryError e11) {
            if (e11.getMessage() != null) {
                str = "Something went wrong while hide Ignored Views ";
            } else {
                str = "";
            }
            IBGDiagnostics.reportNonFatal(e11, str);
            return new Pair(bitmap, new HashMap());
        }
    }
}
