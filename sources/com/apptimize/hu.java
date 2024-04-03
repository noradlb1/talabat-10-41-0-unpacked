package com.apptimize;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;

public class hu {
    public static void a(hl hlVar, ii iiVar) {
        Class<ImageView> cls = ImageView.class;
        hlVar.b(hj.a("cropToPadding", hm.f42957f, ji.a(Boolean.class), iu.a(cls, Boolean.TYPE, "cropToPadding", "getCropToPadding", "setCropToPadding")));
        Class<Drawable> cls2 = Drawable.class;
        hlVar.a((hj<?, ?, ?>) hj.a("image", Cif.f43020b, Cif.a(iiVar.f()), new ie(iiVar.f(), iu.a(cls, cls2, "image", "getDrawable", "setImageDrawable")))).a(hlVar, "updateDrawable", (Class<?>[]) new Class[]{cls2});
    }
}
