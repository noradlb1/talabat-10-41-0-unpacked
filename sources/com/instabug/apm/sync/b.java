package com.instabug.apm.sync;

import com.instabug.apm.configuration.g;
import com.instabug.apm.di.a;
import com.instabug.library.networkv2.RateLimitedException;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;

class b implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ c f45568a;

    public b(c cVar) {
        this.f45568a = cVar;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        this.f45568a.f45571c.a(0);
        this.f45568a.f45570b.e(0);
        g h11 = a.h();
        if (h11 != null) {
            h11.M();
        }
        this.f45568a.g();
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        if (th2 instanceof RateLimitedException) {
            this.f45568a.a((RateLimitedException) th2);
        } else if (th2 != null && th2.getMessage() != null) {
            this.f45568a.f45569a.b(th2.getMessage());
        }
    }
}
