package com.apptimize;

import android.widget.RatingBar;
import buisnessmodels.FilterEngine;

public class hy {
    public static void a(hl hlVar) {
        hm<Number> hmVar = hm.f42954c;
        jg jgVar = new jg();
        Class cls = Integer.TYPE;
        Class<RatingBar> cls2 = RatingBar.class;
        hlVar.b(hj.a("numStars", hmVar, jgVar, iu.a(cls2, cls, "numStars")));
        jf jfVar = new jf();
        Class cls3 = Float.TYPE;
        hlVar.a((hj<?, ?, ?>) hj.a(FilterEngine.DEEPLINKSORT.RATING, hmVar, jfVar, iu.a(cls2, cls3, FilterEngine.DEEPLINKSORT.RATING))).a(hlVar, "setProgress", (Class<?>[]) new Class[]{cls});
        hlVar.a((hj<?, ?, ?>) hj.a("stepSize", hmVar, new jf(), iu.a(cls2, cls3, "stepSize"))).a(hlVar, "setProgress", (Class<?>[]) new Class[]{cls});
        hlVar.b(hj.a("indicator", hm.f42957f, ji.a(Boolean.class), iu.a(cls2, Boolean.TYPE, "indicator", "isIndicator", "setIsIndicator")));
    }
}
