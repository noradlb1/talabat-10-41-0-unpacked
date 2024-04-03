package com.instabug.chat.network;

import androidx.annotation.Nullable;
import com.instabug.chat.model.b;
import com.instabug.chat.model.d;
import com.instabug.chat.model.j;
import com.instabug.chat.model.k;
import com.instabug.chat.network.service.g;
import com.instabug.library.IBGNetworkWorker;
import com.instabug.library.InstabugNetworkJob;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.FileNotFoundException;
import java.util.List;
import org.json.JSONException;

public class f extends InstabugNetworkJob {
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    private static f f46090a;

    private f() {
    }

    public static synchronized f b() {
        f fVar;
        synchronized (f.class) {
            if (f46090a == null) {
                f46090a = new f();
            }
            fVar = f46090a;
        }
        return fVar;
    }

    /* access modifiers changed from: private */
    public static void b(d dVar) {
        InstabugSDKLogger.d("IBG-BR", "START uploading all logs related to this chat id = " + dVar.getId());
        g.a().a(dVar, (Request.Callbacks) new e(dVar));
    }

    /* access modifiers changed from: private */
    public static void b(k kVar) {
        InstabugSDKLogger.d("IBG-BR", "Found " + kVar.b().size() + " attachments related to message: " + kVar.c());
        g.a().b(kVar, new d(kVar));
    }

    /* access modifiers changed from: private */
    public static void b(List list) {
        InstabugSDKLogger.v("IBG-BR", "Found " + list.size() + " offline messages in cache");
        for (int i11 = 0; i11 < list.size(); i11++) {
            k kVar = (k) list.get(i11);
            if (kVar.h() == j.READY_TO_BE_SENT) {
                InstabugSDKLogger.d("IBG-BR", "Uploading message: " + list.get(i11));
                g.a().a(kVar, (Request.Callbacks) new c(kVar));
            } else if (kVar.h() == j.SENT) {
                InstabugSDKLogger.d("IBG-BR", "Uploading message's attachments : " + list.get(i11));
                try {
                    b(kVar);
                } catch (FileNotFoundException | JSONException e11) {
                    InstabugSDKLogger.e("IBG-BR", "Something went wrong while uploading message attachments " + e11.getMessage());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static void c() {
        List e11 = com.instabug.chat.cache.k.e();
        InstabugSDKLogger.v("IBG-BR", "Found " + e11.size() + " offline chats in cache");
        for (d dVar : com.instabug.chat.cache.k.e()) {
            if (dVar.a() != null && dVar.a().equals(b.READY_TO_BE_SENT) && dVar.f().size() > 0) {
                InstabugSDKLogger.d("IBG-BR", "Uploading offline Chat: " + dVar);
                g.a().a(dVar.getState(), (Request.Callbacks) new b(dVar));
            } else if (dVar.a() != null && dVar.a().equals(b.LOGS_READY_TO_BE_UPLOADED)) {
                InstabugSDKLogger.d("IBG-BR", "chat: " + dVar.toString() + " already uploaded but has unsent logs, uploading now");
                b(dVar);
            }
        }
    }

    public void start() {
        b(IBGNetworkWorker.CHATS, new a(this));
    }
}
