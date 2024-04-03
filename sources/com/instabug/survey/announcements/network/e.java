package com.instabug.survey.announcements.network;

import androidx.annotation.Nullable;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.survey.announcements.models.a;
import com.instabug.survey.common.models.f;

class e implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f52266a;

    public e(a aVar) {
        this.f52266a = aVar;
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable Boolean bool) {
        this.f52266a.a(f.SYNCED);
        this.f52266a.b().clear();
        com.instabug.survey.announcements.cache.e.b(this.f52266a);
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-Surveys", "Submitting announcement got error: " + th2.getMessage());
    }
}
