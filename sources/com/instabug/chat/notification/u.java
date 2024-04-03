package com.instabug.chat.notification;

import com.instabug.chat.cache.m;
import com.instabug.chat.model.k;
import com.instabug.chat.synchronization.SynchronizationManager;
import com.instabug.library.Feature;
import com.instabug.library.PresentationManager;
import com.instabug.library.core.InstabugCore;

class u implements q {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k f46138a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ v f46139b;

    public u(v vVar, k kVar) {
        this.f46139b = vVar;
        this.f46138a = kVar;
    }

    public void a() {
        m.b().b(this.f46138a);
        if (SynchronizationManager.getInstance() != null) {
            SynchronizationManager.getInstance().sync();
        }
        this.f46139b.d();
    }

    public void b() {
        if (InstabugCore.isFeatureEnabled(Feature.REPLIES)) {
            this.f46139b.b();
            PresentationManager.getInstance().setNotificationShowing(false);
        }
    }
}
