package com.instabug.library.networkv2.service.userattributes;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.IBGNetworkWorker;
import com.instabug.library.internal.utils.PreferencesUtils;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.TaskDebouncer;
import com.instabug.library.util.TimeUtils;
import java.util.concurrent.TimeUnit;

class e {

    /* renamed from: a  reason: collision with root package name */
    private final PreferencesUtils f51701a;

    /* renamed from: b  reason: collision with root package name */
    private final NetworkManager f51702b;

    /* renamed from: c  reason: collision with root package name */
    private final TaskDebouncer f51703c = new TaskDebouncer(TimeUnit.SECONDS.toMillis(2));

    public e(NetworkManager networkManager, PreferencesUtils preferencesUtils) {
        this.f51701a = preferencesUtils;
        this.f51702b = networkManager;
    }

    public Request a(String str) {
        return a.a(str, b());
    }

    public void b(Request request, Request.Callbacks callbacks) {
        this.f51703c.debounce((Runnable) new c(this, request, callbacks));
    }

    public void c(Request request, Request.Callbacks callbacks) {
        if (d(TimeUtils.currentTimeMillis()) && request != null) {
            this.f51702b.doRequest(IBGNetworkWorker.CORE, 1, request, (Request.Callbacks<RequestResponse, Throwable>) new d(this, callbacks));
        }
    }

    @VisibleForTesting
    public boolean d(long j11) {
        if (j11 - e() > h()) {
            return true;
        }
        return false;
    }

    @VisibleForTesting
    public long e() {
        return this.f51701a.getLong("key_user_attrs_last_sync");
    }

    @VisibleForTesting
    public void f(long j11) {
        this.f51701a.saveOrUpdateLong("key_user_attrs_last_sync", j11);
    }

    @VisibleForTesting
    public void g(@Nullable String str) {
        this.f51701a.saveOrUpdateString("key_user_attrs_hash", str);
    }

    @VisibleForTesting
    public long h() {
        return this.f51701a.getLong("key_user_attrs_ttl");
    }

    @VisibleForTesting
    public void i(long j11) {
        this.f51701a.saveOrUpdateLong("key_user_attrs_ttl", j11);
    }

    @VisibleForTesting
    @Nullable
    public String b() {
        return this.f51701a.getString("key_user_attrs_hash");
    }
}
