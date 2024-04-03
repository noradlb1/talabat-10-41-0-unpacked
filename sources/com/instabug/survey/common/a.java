package com.instabug.survey.common;

import android.app.Activity;
import android.content.Intent;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.tracking.InstabugInternalTrackingDelegate;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.announcements.ui.activity.AnnouncementActivity;
import com.instabug.survey.h;
import com.instabug.survey.utils.j;

class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ com.instabug.survey.announcements.models.a f52315b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f52316c;

    public a(d dVar, com.instabug.survey.announcements.models.a aVar) {
        this.f52316c = dVar;
        this.f52315b = aVar;
    }

    public void run() {
        if (!this.f52315b.z()) {
            InstabugSDKLogger.w("IBG-Surveys", "this announcement " + this.f52315b.i() + " is answered and outdated");
            return;
        }
        Activity targetActivity = InstabugInternalTrackingDelegate.getInstance().getTargetActivity();
        if (targetActivity != null && h.e() != null) {
            h.e().m();
            j.b();
            this.f52315b.a();
            this.f52316c.a(true);
            Intent intent = new Intent(targetActivity, AnnouncementActivity.class);
            intent.putExtra(InstabugDbContract.AnnouncementEntry.COLUMN_ANNOUNCEMENT, this.f52315b);
            targetActivity.startActivity(intent);
        }
    }
}
