package com.instabug.library.usersteps;

import android.view.View;

class d {

    /* renamed from: a  reason: collision with root package name */
    public View f52002a;

    /* renamed from: b  reason: collision with root package name */
    public c f52003b;

    public d(c cVar, View view) {
        this.f52002a = view;
        this.f52003b = cVar;
    }

    public static d a(View view) {
        return new d(c.SCROLLABLE, view);
    }

    public static d b(View view) {
        return new d(c.SWIPEABLE, view);
    }
}
