package com.huawei.hms.dtm.core;

import android.graphics.Bitmap;
import android.view.PixelCopy;
import com.huawei.hms.dtm.core.Rd;
import com.huawei.hms.dtm.core.util.Logger;
import com.huawei.hms.dtm.core.util.g;

public class Sd implements PixelCopy.OnPixelCopyFinishedListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Bitmap f48410a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Kd f48411b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ Rd.b f48412c;

    public Sd(Rd.b bVar, Bitmap bitmap, Kd kd2) {
        this.f48412c = bVar;
        this.f48410a = bitmap;
        this.f48411b = kd2;
    }

    public void onPixelCopyFinished(int i11) {
        if (i11 == 0) {
            Logger.debug("DTM-AutoTrace", "handleHardwareScreenShotInfo");
            this.f48412c.a(g.a(Rd.b(this.f48410a)), this.f48411b);
        }
    }
}
