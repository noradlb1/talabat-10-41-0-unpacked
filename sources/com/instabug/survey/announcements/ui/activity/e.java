package com.instabug.survey.announcements.ui.activity;

import com.instabug.survey.announcements.models.a;
import com.instabug.survey.announcements.network.g;

class e implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f52283b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f52284c;

    public e(f fVar, a aVar, c cVar) {
        this.f52283b = aVar;
        this.f52284c = cVar;
    }

    public void run() {
        if (this.f52283b.p() == 100) {
            com.instabug.survey.announcements.cache.e.a();
        }
        g.a().start();
        this.f52284c.a(false);
    }
}
