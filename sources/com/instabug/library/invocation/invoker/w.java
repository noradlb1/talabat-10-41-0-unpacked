package com.instabug.library.invocation.invoker;

import android.content.Context;
import android.os.Build;
import androidx.core.view.GestureDetectorCompat;
import com.instabug.library.invocation.invoker.x;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.InstabugSDKLogger;

class w implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ x f51406b;

    public w(x xVar) {
        this.f51406b = xVar;
    }

    public void run() {
        Context context;
        String str;
        if (Build.VERSION.SDK_INT <= 29) {
            context = this.f51406b.f51409c;
        } else {
            context = InstabugInternalTrackingDelegate.getInstance().getCurrentActivity();
        }
        if (context != null) {
            try {
                x.a unused = this.f51406b.f51408b = new x.a();
                x xVar = this.f51406b;
                GestureDetectorCompat unused2 = xVar.f51407a = new GestureDetectorCompat(context, xVar.f51408b);
                boolean unused3 = this.f51406b.f51412f = true;
            } catch (Exception e11) {
                if (e11.getMessage() != null) {
                    str = e11.getMessage();
                } else {
                    str = "Couldn't initialize GestureDetector";
                }
                InstabugSDKLogger.e("IBG-Core", str, e11);
            }
        }
    }
}
