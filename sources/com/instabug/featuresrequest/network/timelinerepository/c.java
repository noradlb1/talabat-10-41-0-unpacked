package com.instabug.featuresrequest.network.timelinerepository;

import com.instabug.featuresrequest.models.f;
import com.instabug.featuresrequest.network.service.g;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private static c f46587a;

    public static c a() {
        c cVar = f46587a;
        if (cVar != null) {
            return cVar;
        }
        c cVar2 = new c();
        f46587a = cVar2;
        return cVar2;
    }

    public void a(long j11, d dVar) {
        try {
            g.a().a(j11, (Request.Callbacks) new a(this, j11, dVar));
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-FR", e11.getMessage() != null ? e11.getMessage() : "something went wrong while getting feature timeline", e11);
        }
    }

    public void a(f fVar, d dVar) {
        try {
            g.a().a(fVar, (Request.Callbacks) new b(this, dVar));
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-FR", e11.getMessage() != null ? e11.getMessage() : "something went wrong while trying to add new comment", e11);
        }
    }
}
