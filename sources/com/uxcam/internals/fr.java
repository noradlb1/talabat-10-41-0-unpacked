package com.uxcam.internals;

import android.graphics.Bitmap;
import java.util.TimerTask;
import mz.j;

public class fr extends TimerTask {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ fn f13396a;

    public class aa implements Runnable {
        public aa(fr frVar) {
        }

        public static /* synthetic */ void a(Bitmap bitmap) {
        }

        public void run() {
            if (bi.f13066a) {
                fm.a(fn.f13388s, (eh) new j());
            }
        }
    }

    public fr(fn fnVar) {
        this.f13396a = fnVar;
    }

    public void run() {
        this.f13396a.f13389a.post(new aa(this));
    }
}
