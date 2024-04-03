package com.instabug.bug.view.visualusersteps.steppreview;

import android.graphics.Bitmap;
import com.instabug.library.visualusersteps.VisualUserStepsHelper;
import java.util.concurrent.Callable;

class g implements Callable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f45957b;

    public g(h hVar, String str) {
        this.f45957b = str;
    }

    /* renamed from: a */
    public Bitmap call() {
        return VisualUserStepsHelper.decryptBitmap(this.f45957b);
    }
}
