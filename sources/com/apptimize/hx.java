package com.apptimize;

import android.widget.ProgressBar;
import com.deliveryhero.performance.core.screenmetric.performance.RichContentLoadTimeTracer;

public class hx {
    public static void a(hl hlVar) {
        hm<Number> hmVar = hm.f42954c;
        jg jgVar = new jg();
        Class cls = Integer.TYPE;
        Class<ProgressBar> cls2 = ProgressBar.class;
        hlVar.b(hj.a(RichContentLoadTimeTracer.MAX, hmVar, jgVar, iu.a(cls2, cls, RichContentLoadTimeTracer.MAX)));
        hlVar.b(hj.a("progress", hmVar, new jg(), iu.a(cls2, cls, "progress")));
        hlVar.b(hj.a("indeterminate", hm.f42957f, ji.a(Boolean.class), iu.a(cls2, Boolean.TYPE, "indeterminate")));
    }
}
