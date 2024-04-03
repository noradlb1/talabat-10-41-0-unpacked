package com.uxcam.internals;

import android.os.Looper;
import com.newrelic.agent.android.harvest.AgentHealth;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import mz.b;

public class dg extends ArrayList {

    /* renamed from: a  reason: collision with root package name */
    public static final ExecutorService f13194a = Executors.newSingleThreadExecutor();

    public static void b(fk fkVar) {
        if (fn.b() != null) {
            bq bqVar = new bq(fn.f13377h);
            int i11 = fkVar.f13351a;
            if (bq.f13084d) {
                gu.f13504c.getClass();
                try {
                    bqVar.f13086b = fkVar.f13352b;
                    bqVar.f13087c = fkVar.f13353c;
                    bqVar.a(i11);
                    fn.f13375f.remove(fkVar);
                    fn b11 = fn.b();
                    if (b11 != null) {
                        b11.a(bqVar.f13085a);
                        return;
                    }
                    fx a11 = new fx().a(AgentHealth.DEFAULT_KEY);
                    a11.a("site_of_error", "EncodeVideo::processScreenBitmap()");
                    a11.a("reason", "ScreenVideoHandler is null, cannot finish encoding.");
                    a11.a(2);
                } catch (Exception e11) {
                    gu.a("bq").getClass();
                    fx fxVar = new fx();
                    fxVar.a("EXCEPTION");
                    fxVar.a("site_of_error", "EncodeVideo::processScreenBitmap()");
                    fxVar.a("reason", e11.getMessage());
                    fxVar.a(2);
                }
            }
        } else {
            fx a12 = new fx().a(AgentHealth.DEFAULT_KEY);
            a12.a("site_of_error", "JCodeArray::processImages()");
            a12.a("reason", "ScreenVideoHandler is null, cannot process bitmap");
            a12.a(2);
        }
    }

    public boolean a(fk fkVar) {
        c(fkVar);
        return super.add(fkVar);
    }

    public boolean add(Object obj) {
        fk fkVar = (fk) obj;
        c(fkVar);
        return super.add(fkVar);
    }

    public final void c(fk fkVar) {
        b bVar = new b(fkVar);
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            f13194a.submit(bVar);
        } else {
            bVar.run();
        }
    }
}
