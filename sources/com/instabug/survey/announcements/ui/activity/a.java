package com.instabug.survey.announcements.ui.activity;

import com.instabug.survey.announcements.ui.activity.AnnouncementActivity;
import com.instabug.survey.utils.j;

class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AnnouncementActivity.b f52282b;

    public a(AnnouncementActivity.b bVar) {
        this.f52282b = bVar;
    }

    public void run() {
        j.a();
        AnnouncementActivity.this.finish();
    }
}
