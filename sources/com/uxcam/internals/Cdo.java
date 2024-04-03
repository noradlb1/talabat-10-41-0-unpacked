package com.uxcam.internals;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;
import com.google.android.gms.maps.GoogleMap;
import java.lang.ref.WeakReference;
import java.util.Objects;
import mz.c;

/* renamed from: com.uxcam.internals.do  reason: invalid class name */
public class Cdo implements dm {

    /* renamed from: com.uxcam.internals.do$aa */
    public interface aa {
        void a(Bitmap bitmap);
    }

    public final void a(dn dnVar, aa aaVar) {
        boolean z11;
        Canvas canvas = dnVar.f13219b;
        GoogleMap googleMap = dnVar.f13221d;
        try {
            WeakReference weakReference = dnVar.f13225h;
            if (weakReference == null || weakReference.get() == null || !((View) dnVar.f13225h.get()).isShown() || ((View) dnVar.f13225h.get()).getMeasuredWidth() <= 0 || ((View) dnVar.f13225h.get()).getMeasuredHeight() <= 0) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (dnVar.f13226i != null && z11) {
                int[] iArr = {0, 0};
                ((View) dnVar.f13225h.get()).getLocationOnScreen(iArr);
                canvas.drawBitmap(dnVar.f13226i, (float) iArr[0], (float) iArr[1], (Paint) null);
            }
            if (googleMap != null && z11) {
                Objects.requireNonNull(aaVar);
                googleMap.snapshot(new c(aaVar));
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            fx fxVar = new fx();
            fxVar.a("EXCEPTION");
            fxVar.a("site_of_error", "ScreenshotTaker::drawViewOnCanvas()");
            fxVar.a("reason", e11.getMessage());
            fxVar.a("context", "Asynchronous capture of GoogleMap's view has failed for some reason.").a(2);
        }
    }
}
