package com.apptimize;

import android.view.View;

public class gz extends gu {

    /* renamed from: b  reason: collision with root package name */
    private Integer f42872b;

    public gz(View view, he heVar, Integer num, hg hgVar) {
        super(view, heVar, (Integer) null, hgVar);
        this.f42872b = num;
        d();
    }

    public void a(Integer num) {
        this.f42872b = num;
        d();
    }

    public db b(View view) {
        return dd.a(view.getClass(), "row", this.f42872b);
    }
}
