package com.instabug.survey.announcements.cache;

import com.instabug.survey.announcements.models.a;

class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f52225b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f52226c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f52227d;

    public b(a aVar, boolean z11, boolean z12) {
        this.f52225b = aVar;
        this.f52226c = z11;
        this.f52227d = z12;
    }

    public void run() {
        f.a(this.f52225b, this.f52226c, this.f52227d);
    }
}
