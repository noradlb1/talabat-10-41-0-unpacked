package com.uxcam.internals;

import android.opengl.EGL14;
import android.opengl.EGLDisplay;
import android.opengl.EGLSurface;
import com.uxcam.internals.cm;
import java.util.Iterator;

public class fp implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ cm f13394a;

    public fp(fn fnVar, cm cmVar) {
        this.f13394a = cmVar;
    }

    public void run() {
        boolean z11;
        cm cmVar = this.f13394a;
        cmVar.getClass();
        cmVar.f13135c = ia.a(fl.a().f13358c);
        cmVar.f13136d = ia.a(fl.a().f13359d);
        cmVar.f13137e = 150000;
        boolean z12 = false;
        try {
            cmVar.a();
            cm.aa aaVar = cmVar.f13139g;
            EGLDisplay eGLDisplay = aaVar.f13144a;
            EGLSurface eGLSurface = aaVar.f13146c;
            EGL14.eglMakeCurrent(eGLDisplay, eGLSurface, eGLSurface, aaVar.f13145b);
            aaVar.a("eglMakeCurrent");
            long j11 = gk.f13444f;
            while (!fn.f13376g) {
                cmVar.a(0, j11);
                if (hb.f13525h <= 0.0f) {
                    hb.f13525h = ia.d();
                }
                int i11 = 0;
                while (true) {
                    if (i11 >= 100) {
                        z11 = false;
                        continue;
                        break;
                    }
                    Thread.sleep((long) (10 / cm.f13132l));
                    if (fn.f13376g) {
                        z11 = true;
                        continue;
                        break;
                    }
                    i11++;
                }
                if (z11) {
                    break;
                }
            }
            cmVar.a(true);
            cmVar.b();
            z12 = true;
        } catch (Exception e11) {
            fx fxVar = new fx();
            fxVar.a("EXCEPTION");
            fxVar.a("site_of_error", "GLMediaCodecEncoder::encodeVideoToMp4()");
            fxVar.a("reason", e11.getMessage());
            fxVar.a(2);
            cmVar.b();
        } catch (Throwable th2) {
            cmVar.b();
            throw th2;
        }
        if (z12) {
            Iterator it = cmVar.f13133a.iterator();
            while (it.hasNext()) {
                ((bs) it.next()).b();
            }
            return;
        }
        Iterator it2 = cmVar.f13133a.iterator();
        while (it2.hasNext()) {
            ((bs) it2.next()).a();
        }
    }
}
