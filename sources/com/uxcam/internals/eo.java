package com.uxcam.internals;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.view.PixelCopy;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mz.d;

public class eo implements em {
    @RequiresApi(api = 26)
    public void a(en enVar) {
        String.format("is flutter : %s and build is above 26 : %s", new Object[]{Boolean.valueOf(gm.I), Boolean.TRUE});
        PixelCopy.request(((Activity) ia.c()).getWindow(), enVar.f13285a, new d(this, new cd(cc.f13111d), enVar), new Handler(Looper.getMainLooper()));
    }

    /* access modifiers changed from: private */
    public void a(cd cdVar, en enVar, int i11) {
        List list;
        if (i11 == 0) {
            Activity activity = (Activity) ia.c();
            Bitmap bitmap = enVar.f13285a;
            Canvas canvas = enVar.f13286b;
            cc ccVar = cdVar.f13115a;
            ccVar.getClass();
            try {
                list = ccVar.a(activity);
            } catch (Exception e11) {
                e11.getMessage();
                list = new ArrayList();
            }
            if (!list.isEmpty()) {
                try {
                    Iterator it = list.iterator();
                    cb cbVar = null;
                    while (true) {
                        boolean z11 = false;
                        if (!it.hasNext()) {
                            break;
                        }
                        cb cbVar2 = (cb) it.next();
                        if (cbVar2.f13110c.type == 2) {
                            z11 = true;
                        }
                        if (z11) {
                            cdVar.a(canvas, cbVar2);
                            cbVar = cbVar2;
                        }
                    }
                    if (cbVar != null) {
                        canvas.drawColor(Color.argb((int) (cbVar.f13110c.dimAmount * 255.0f), 0, 0, 0));
                        cdVar.a(canvas, cbVar);
                    }
                } catch (Exception e12) {
                    e12.getMessage();
                }
            }
            ArrayList arrayList = enVar.f13288d;
            Canvas canvas2 = enVar.f13286b;
            if (!arrayList.isEmpty()) {
                Paint paint = new Paint();
                paint.setColor(-65536);
                paint.setStrokeWidth(3.0f);
                paint.setStyle(Paint.Style.FILL);
                Iterator it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    canvas2.drawRect((RectF) it2.next(), paint);
                }
            }
            ((Activity) ia.c()).getLocalClassName();
        } else {
            new fx().a("actual_reason", "PixelCopy could not create a snapshot for this activity.").a(2);
        }
        enVar.f13287c.a(enVar.f13285a);
    }
}
