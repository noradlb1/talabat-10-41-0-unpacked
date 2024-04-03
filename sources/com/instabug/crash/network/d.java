package com.instabug.crash.network;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.instabug.crash.models.IBGNonFatalException;
import com.instabug.crash.models.a;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.model.Attachment;
import com.instabug.library.model.State;
import com.instabug.library.model.session.SessionParameter;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Endpoints;
import com.instabug.library.networkv2.request.FileToUpload;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.networkv2.request.RequestParameter;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public class d {

    /* renamed from: b  reason: collision with root package name */
    private static d f46431b;

    /* renamed from: a  reason: collision with root package name */
    private final NetworkManager f46432a = new NetworkManager();

    private d() {
    }

    public static d a() {
        if (f46431b == null) {
            f46431b = new d();
        }
        return f46431b;
    }

    @VisibleForTesting
    @NonNull
    public Request b(a aVar) throws JSONException {
        ArrayList<State.StateItem> stateItems;
        Request.Builder method = new Request.Builder().endpoint(Endpoints.REPORT_CRASH).method("POST");
        if (aVar.getMetadata().getUuid() != null) {
            method.addHeader(new RequestParameter("id", aVar.getMetadata().getUuid()));
        }
        if (aVar.b() != null && aVar.b().contains("InstabugSDK-v: ")) {
            method.addParameter(new RequestParameter(SessionParameter.APP_TOKEN, "b1a9630002b2cbdfbfecd942744b9018"));
        }
        State h11 = aVar.h();
        if (!(h11 == null || (stateItems = h11.getStateItems()) == null || stateItems.size() <= 0)) {
            for (int i11 = 0; i11 < stateItems.size(); i11++) {
                if (!(stateItems.get(i11).getKey() == null || stateItems.get(i11).getValue() == null)) {
                    method.addParameter(new RequestParameter(stateItems.get(i11).getKey(), stateItems.get(i11).getValue()));
                }
            }
        }
        a(method, aVar);
        String b11 = aVar.b();
        if (b11 != null) {
            method.addParameter(new RequestParameter("title", b11));
        }
        method.addParameter(new RequestParameter(InstabugDbContract.CrashEntry.COLUMN_HANDLED, Boolean.valueOf(aVar.k())));
        String j11 = aVar.j();
        if (j11 != null) {
            method.addParameter(new RequestParameter(InstabugDbContract.CrashEntry.COLUMN_THREADS_DETAILS, j11));
        }
        String d11 = aVar.d();
        if (d11 != null) {
            method.addParameter(new RequestParameter("grouping_string", new JSONObject(d11)));
        }
        IBGNonFatalException.Level f11 = aVar.f();
        if (f11 != null) {
            method.addParameter(new RequestParameter("level", Integer.valueOf(f11.getSeverity())));
        }
        String uuid = aVar.getMetadata().getUuid();
        if (uuid != null) {
            method.addParameter(new RequestParameter("id", uuid));
        }
        if (aVar.a() != null && aVar.a().size() > 0) {
            method.addParameter(new RequestParameter("attachments_count", Integer.valueOf(aVar.a().size())));
        }
        return method.build();
    }

    public void c(a aVar, Request.Callbacks callbacks) {
        InstabugSDKLogger.d("IBG-CR", "START uploading all logs related to this crash id = " + aVar.e());
        try {
            this.f46432a.doRequestOnSameThread(1, a(aVar), (Request.Callbacks<RequestResponse, Throwable>) new c(this, callbacks, aVar));
        } catch (JSONException e11) {
            InstabugSDKLogger.e("IBG-CR", "uploading crash logs got Json error: " + e11.getMessage());
            callbacks.onFailed(aVar);
        }
    }

    public void a(a aVar, Request.Callbacks callbacks) throws JSONException {
        InstabugSDKLogger.d("IBG-CR", "Reporting crash with crash message: " + aVar.b());
        this.f46432a.doRequestOnSameThread(1, b(aVar), (Request.Callbacks<RequestResponse, Throwable>) new a(this, callbacks, aVar));
    }

    private void a(Request.Builder builder, a aVar) {
        State h11 = aVar.h();
        if (h11 == null || h11.isMinimalState() || h11.getReportedAt() == 0) {
            try {
                long parseLong = aVar.e() != null ? Long.parseLong(aVar.e()) / 1000 : 0;
                if (parseLong != 0) {
                    builder.addParameter(new RequestParameter(State.KEY_REPORTED_AT, Long.valueOf(parseLong)));
                }
            } catch (Exception e11) {
                IBGDiagnostics.reportNonFatal(e11, "Failed to update reported_at in crash reporting request.");
            }
        }
    }

    @VisibleForTesting
    @NonNull
    public Request a(a aVar, Attachment attachment) throws JSONException {
        Request.Builder type = new Request.Builder().method("POST").type(2);
        if (aVar.i() != null) {
            type.endpoint(Endpoints.ADD_CRASH_ATTACHMENT.replaceAll(":crash_token", aVar.i()));
        }
        if (attachment.getType() != null) {
            type.addParameter(new RequestParameter("metadata[file_type]", attachment.getType()));
        }
        if (attachment.getType() == Attachment.Type.AUDIO && attachment.getDuration() != null) {
            type.addParameter(new RequestParameter("metadata[duration]", attachment.getDuration()));
        }
        if (!(attachment.getName() == null || attachment.getLocalPath() == null)) {
            type.fileToUpload(new FileToUpload("file", attachment.getName(), attachment.getLocalPath(), attachment.getFileType()));
        }
        return type.build();
    }

    @VisibleForTesting
    @NonNull
    public Request a(a aVar) throws JSONException {
        ArrayList<State.StateItem> logsItems;
        Object obj;
        Request.Builder method = new Request.Builder().endpoint(Endpoints.CRASH_LOGS.replaceAll(":crash_token", aVar.i() != null ? aVar.i() : "")).method("POST");
        State h11 = aVar.h();
        if (!(h11 == null || (logsItems = h11.getLogsItems()) == null || logsItems.size() <= 0)) {
            Iterator<State.StateItem> it = logsItems.iterator();
            while (it.hasNext()) {
                State.StateItem next = it.next();
                if (next.getKey() != null) {
                    String key = next.getKey();
                    if (next.getValue() != null) {
                        obj = next.getValue();
                    } else {
                        obj = "";
                    }
                    method.addParameter(new RequestParameter(key, obj));
                }
            }
        }
        return method.build();
    }

    public void b(a aVar, Request.Callbacks callbacks) throws JSONException {
        ArrayList arrayList = new ArrayList();
        if (aVar.a().size() == 0) {
            callbacks.onSucceeded(Boolean.TRUE);
            return;
        }
        for (int i11 = 0; i11 < aVar.a().size(); i11++) {
            Attachment attachment = (Attachment) aVar.a().get(i11);
            if (AttachmentsUtility.decryptAttachmentAndUpdateDb(attachment)) {
                Request a11 = a(aVar, attachment);
                if (attachment.getLocalPath() != null) {
                    File file = new File(attachment.getLocalPath());
                    if (!file.exists() || file.length() <= 0) {
                        InstabugSDKLogger.w("IBG-CR", "Skipping attachment file of type " + attachment.getType() + " because it's either not found or empty file");
                    } else {
                        attachment.setAttachmentState(Attachment.AttachmentState.SYNCED);
                        this.f46432a.doRequestOnSameThread(2, a11, (Request.Callbacks<RequestResponse, Throwable>) new b(this, attachment, aVar, arrayList, callbacks));
                    }
                } else {
                    InstabugSDKLogger.w("IBG-CR", "Skipping attachment file of type " + attachment.getType() + " because it's either not found or empty file");
                }
            } else {
                InstabugSDKLogger.w("IBG-CR", "Skipping attachment file of type " + attachment.getType() + " because it was not decrypted successfully");
            }
        }
    }
}
