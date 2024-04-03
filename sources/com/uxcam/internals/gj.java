package com.uxcam.internals;

import android.app.Activity;
import java.util.TimerTask;

public class gj extends TimerTask {
    public gj(gk gkVar) {
    }

    public void run() {
        int i11;
        try {
            Activity activity = (Activity) ia.c();
            if (!gm.f13457f && activity != null && fm.f13364c != (i11 = activity.getResources().getConfiguration().orientation) && !fm.f13365d) {
                fm.f13364c = i11;
                gu.a("ServiceHandler").getClass();
                hb.c().f13531b.a(10, 0.0f, 0.0f);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }
}
