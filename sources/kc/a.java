package kc;

import com.instabug.featuresrequest.models.d;
import com.instabug.featuresrequest.network.service.b;
import com.instabug.library.networkv2.request.Request;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f47131b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ d f47132c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f47133d;

    public /* synthetic */ a(b bVar, d dVar, Request.Callbacks callbacks) {
        this.f47131b = bVar;
        this.f47132c = dVar;
        this.f47133d = callbacks;
    }

    public final void run() {
        this.f47131b.a(this.f47132c, this.f47133d);
    }
}
