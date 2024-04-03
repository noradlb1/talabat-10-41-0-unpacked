package com.instabug.chat.network.service;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.MimeTypes;
import com.instabug.chat.model.d;
import com.instabug.chat.model.k;
import com.instabug.chat.network.util.a;
import com.instabug.commons.diagnostics.event.CalibrationDiagnosticEvent;
import com.instabug.library.IBGNetworkWorker;
import com.instabug.library.model.State;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Endpoints;
import com.instabug.library.networkv2.request.FileToUpload;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.networkv2.request.RequestParameter;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class g {

    /* renamed from: b  reason: collision with root package name */
    private static g f46103b;

    /* renamed from: a  reason: collision with root package name */
    private NetworkManager f46104a = new NetworkManager();

    private g() {
    }

    public static g a() {
        g gVar;
        synchronized (g.class.getName()) {
            if (f46103b == null) {
                f46103b = new g();
            }
            gVar = f46103b;
        }
        return gVar;
    }

    public void a(long j11, int i11, JSONArray jSONArray, Request.Callbacks callbacks) {
        if (jSONArray != null && callbacks != null) {
            InstabugSDKLogger.d("IBG-BR", "Syncing messages with server");
            this.f46104a.doRequest(IBGNetworkWorker.CHATS, 1, a.a(j11, i11, jSONArray), (Request.Callbacks<RequestResponse, Throwable>) new d(this, callbacks));
        }
    }

    public void a(d dVar, Request.Callbacks callbacks) {
        if (dVar != null && callbacks != null) {
            Request.Builder endpoint = new Request.Builder().method("POST").endpoint(Endpoints.CHAT_LOGS.replaceAll(":chat_token", dVar.getId()));
            if (dVar.getState() != null) {
                Iterator<State.StateItem> it = dVar.getState().getLogsItems().iterator();
                while (it.hasNext()) {
                    State.StateItem next = it.next();
                    if (next.getKey() != null && !next.getKey().equals(State.KEY_VISUAL_USER_STEPS) && !next.getKey().equals(State.KEY_SESSIONS_PROFILER) && next.getValue() != null) {
                        endpoint.addParameter(new RequestParameter(next.getKey(), next.getValue()));
                    }
                }
            }
            this.f46104a.doRequest(IBGNetworkWorker.CHATS, 1, endpoint.build(), (Request.Callbacks<RequestResponse, Throwable>) new e(this, callbacks, dVar));
        }
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void a(k kVar, Request.Callbacks callbacks) {
        if (kVar != null && callbacks != null) {
            InstabugSDKLogger.d("IBG-BR", "Sending message");
            Request.Builder method = new Request.Builder().endpoint(Endpoints.SEND_MESSAGE.replaceAll(":chat_number", kVar.d())).method("POST");
            method.addParameter(new RequestParameter("message", new JSONObject().put("body", (Object) kVar.c()).put("messaged_at", kVar.i()).put("email", (Object) kVar.k()).put("name", (Object) kVar.l()).put(State.KEY_PUSH_TOKEN, (Object) kVar.e())));
            this.f46104a.doRequest(IBGNetworkWorker.CHATS, 1, method.build(), (Request.Callbacks<RequestResponse, Throwable>) new b(this, callbacks));
        }
    }

    public void a(@Nullable State state, Request.Callbacks callbacks) {
        if (state != null && callbacks != null) {
            Request.Builder method = new Request.Builder().endpoint(Endpoints.TRIGGER_CHAT).method("POST");
            ArrayList<State.StateItem> stateItems = state.getStateItems();
            Arrays.asList(State.getUserDataKeys());
            for (int i11 = 0; i11 < state.getStateItems().size(); i11++) {
                String key = stateItems.get(i11).getKey();
                Object value = stateItems.get(i11).getValue();
                if (!(key == null || value == null)) {
                    method.addParameter(new RequestParameter(key, value));
                }
            }
            this.f46104a.doRequest(IBGNetworkWorker.CHATS, 1, method.build(), (Request.Callbacks<RequestResponse, Throwable>) new a(this, callbacks));
        }
    }

    public synchronized void a(String str, Request.Callbacks callbacks) {
        if (!(str == null || callbacks == null)) {
            this.f46104a.doRequestOnSameThread(1, new Request.Builder().endpoint(Endpoints.PUSH_TOKEN).method("POST").addParameter(new RequestParameter(State.KEY_PUSH_TOKEN, str)).build(), (Request.Callbacks<RequestResponse, Throwable>) new f(this, callbacks));
        }
    }

    public synchronized void b(k kVar, Request.Callbacks callbacks) {
        if (!(kVar == null || callbacks == null)) {
            InstabugSDKLogger.v("IBG-BR", "Uploading message attachments");
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < kVar.b().size(); i11++) {
                com.instabug.chat.model.a aVar = (com.instabug.chat.model.a) kVar.b().get(i11);
                InstabugSDKLogger.v("IBG-BR", "Uploading attachment with type: " + aVar.f());
                if (!(aVar.f() == null || aVar.d() == null || aVar.c() == null || aVar.b() == null || kVar.d() == null)) {
                    Request.Builder endpoint = new Request.Builder().method("POST").type(2).endpoint(Endpoints.ADD_MESSAGE_ATTACHMENT.replaceAll(":chat_number", kVar.d()).replaceAll(":message_id", String.valueOf(kVar.f())));
                    endpoint.addParameter(new RequestParameter("metadata[file_type]", aVar.f()));
                    if (aVar.f().equals(MimeTypes.BASE_TYPE_AUDIO) && aVar.a() != null) {
                        endpoint.addParameter(new RequestParameter("metadata[duration]", aVar.a()));
                    }
                    endpoint.fileToUpload(new FileToUpload("file", aVar.d(), aVar.c(), aVar.b()));
                    InstabugSDKLogger.v("IBG-BR", "Uploading attachment with name: " + aVar.d() + " path: " + aVar.c() + " file type: " + aVar.b());
                    File file = new File(aVar.c());
                    if (!file.exists() || file.length() <= 0) {
                        InstabugSDKLogger.e("IBG-BR", "Skipping attachment file of type " + aVar.f() + " because it's either not found or empty file");
                    } else {
                        aVar.d(CalibrationDiagnosticEvent.Action.Synced);
                        this.f46104a.doRequest(IBGNetworkWorker.CHATS, 2, endpoint.build(), (Request.Callbacks<RequestResponse, Throwable>) new c(this, arrayList, aVar, kVar, callbacks));
                    }
                }
            }
        }
    }
}
