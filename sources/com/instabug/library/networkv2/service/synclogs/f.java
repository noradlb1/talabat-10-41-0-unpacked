package com.instabug.library.networkv2.service.synclogs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.IBGNetworkWorker;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.networkv2.service.base.a;
import com.instabug.library.networkv2.service.base.b;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

public class f extends b {
    @Nullable

    /* renamed from: d  reason: collision with root package name */
    private static f f51694d;

    /* renamed from: c  reason: collision with root package name */
    private d f51695c;

    private f(@NonNull NetworkManager networkManager, @NonNull d dVar, @Nullable Request.Callbacks callbacks, @NonNull a aVar) {
        super(networkManager, aVar, callbacks);
        this.f51695c = dVar;
    }

    public static synchronized f a(@NonNull NetworkManager networkManager, @NonNull d dVar, @Nullable Request.Callbacks callbacks, @NonNull a aVar) {
        f fVar;
        synchronized (f.class) {
            if (f51694d == null) {
                f51694d = new f(networkManager, dVar, callbacks, aVar);
            }
            fVar = f51694d;
        }
        return fVar;
    }

    public void a(List list, @Nullable String str, @Nullable String str2, String str3) throws UnsupportedEncodingException {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Request a11 = this.f51695c.a((File) it.next(), str, str2, str3);
            b().doRequest(IBGNetworkWorker.CORE, 2, a11, (Request.Callbacks<RequestResponse, Throwable>) new e(this, a11));
        }
    }
}
