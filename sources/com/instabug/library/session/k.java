package com.instabug.library.session;

import android.content.Context;
import androidx.annotation.NonNull;
import com.instabug.library.internal.data.a;
import com.instabug.library.model.session.SessionMapper;
import com.instabug.library.model.session.SessionsBatchDTO;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.m;

public class k extends a {

    /* renamed from: b  reason: collision with root package name */
    private static k f51751b;

    /* renamed from: a  reason: collision with root package name */
    private final NetworkManager f51752a = new NetworkManager();

    private k(@NonNull Context context) {
        new m(context);
    }

    public static synchronized k a(@NonNull Context context) {
        k kVar;
        synchronized (k.class) {
            if (f51751b == null) {
                f51751b = new k(context);
            }
            kVar = f51751b;
        }
        return kVar;
    }

    public void a(SessionsBatchDTO sessionsBatchDTO, Request.Callbacks callbacks) {
        this.f51752a.doRequestOnSameThread(1, SessionMapper.toRequest(SessionMapper.toJson(sessionsBatchDTO)), (Request.Callbacks<RequestResponse, Throwable>) new j(this, callbacks));
    }
}
