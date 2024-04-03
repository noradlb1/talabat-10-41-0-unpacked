package com.instabug.library.model.v3Session;

import com.instabug.library.model.common.Session;
import com.instabug.library.model.common.SessionVersion;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class k implements Session {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ g f51615a;

    public k(g gVar) {
        this.f51615a = gVar;
    }

    @Nullable
    public String getAppVersion() {
        return this.f51615a.a().b();
    }

    @NotNull
    public String getId() {
        return this.f51615a.c();
    }

    @NotNull
    public String getOs() {
        return this.f51615a.a().d();
    }

    public long getStartNanoTime() {
        return this.f51615a.f().c();
    }

    public long getStartTimestampMicros() {
        return this.f51615a.f().d();
    }

    @NotNull
    public String getUuid() {
        return this.f51615a.i().f();
    }

    @NotNull
    public String getVersion() {
        return SessionVersion.V3;
    }
}
