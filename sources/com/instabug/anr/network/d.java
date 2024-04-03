package com.instabug.anr.network;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.instabug.anr.model.b;
import com.instabug.library.Instabug;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.model.Attachment;
import com.instabug.library.model.State;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Endpoints;
import com.instabug.library.networkv2.request.FileToUpload;
import com.instabug.library.networkv2.request.Header;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.networkv2.request.RequestParameter;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONException;

public class d {

    /* renamed from: b  reason: collision with root package name */
    private static d f45084b;

    /* renamed from: a  reason: collision with root package name */
    private NetworkManager f45085a = new NetworkManager();

    public static synchronized d a() {
        d dVar;
        synchronized (d.class) {
            if (f45084b == null) {
                f45084b = new d();
            }
            dVar = f45084b;
        }
        return dVar;
    }

    @VisibleForTesting
    @NonNull
    public Request b(b bVar) {
        String appToken = Instabug.getAppToken();
        Request.Builder method = new Request.Builder().endpoint(Endpoints.REPORT_ANR).method("POST");
        if (appToken == null) {
            appToken = "";
        }
        Request.Builder addHeader = method.addHeader(new RequestParameter(Header.APP_TOKEN, appToken));
        if (bVar.getMetadata().getUuid() != null) {
            addHeader.addHeader(new RequestParameter("id", bVar.getMetadata().getUuid()));
        }
        if (bVar.g() != null) {
            ArrayList<State.StateItem> stateItems = bVar.g().getStateItems();
            Arrays.asList(State.getUserDataKeys());
            if (stateItems != null && stateItems.size() > 0) {
                for (int i11 = 0; i11 < stateItems.size(); i11++) {
                    String key = stateItems.get(i11).getKey();
                    Object value = stateItems.get(i11).getValue();
                    if (!(key == null || value == null)) {
                        addHeader.addParameter(new RequestParameter(key, value));
                    }
                }
            }
        }
        a(addHeader, bVar);
        addHeader.addParameter(new RequestParameter("title", bVar.e()));
        addHeader.addParameter(new RequestParameter(InstabugDbContract.CrashEntry.COLUMN_THREADS_DETAILS, bVar.f()));
        addHeader.addParameter(new RequestParameter("ANR_message", bVar.d()));
        if (bVar.getMetadata().getUuid() != null) {
            addHeader.addParameter(new RequestParameter("id", bVar.getMetadata().getUuid()));
        }
        if (bVar.b() != null && bVar.b().size() > 0) {
            addHeader.addParameter(new RequestParameter("attachments_count", Integer.valueOf(bVar.b().size())));
        }
        return addHeader.build();
    }

    public void c(b bVar, Request.Callbacks callbacks) {
        this.f45085a.doRequestOnSameThread(1, a(bVar), (Request.Callbacks<RequestResponse, Throwable>) new b(this, callbacks, bVar));
    }

    public void a(b bVar, Request.Callbacks callbacks) throws JSONException {
        this.f45085a.doRequestOnSameThread(1, b(bVar), (Request.Callbacks<RequestResponse, Throwable>) new a(this, callbacks, bVar));
    }

    @VisibleForTesting
    @NonNull
    public Request a(b bVar) {
        ArrayList<State.StateItem> logsItems;
        Request.Builder method = new Request.Builder().endpoint(Endpoints.CRASH_LOGS.replaceAll(":crash_token", bVar.h())).method("POST");
        if (!(bVar.g() == null || (logsItems = bVar.g().getLogsItems()) == null || logsItems.size() <= 0)) {
            Iterator<State.StateItem> it = logsItems.iterator();
            while (it.hasNext()) {
                State.StateItem next = it.next();
                if (next.getKey() != null) {
                    method.addParameter(new RequestParameter(next.getKey(), next.getValue() != null ? next.getValue() : ""));
                }
            }
        }
        return method.build();
    }

    private void a(Request.Builder builder, b bVar) {
        State g11 = bVar.g();
        if (g11 == null || g11.isMinimalState() || g11.getReportedAt() == 0) {
            try {
                long parseLong = bVar.c() != null ? Long.parseLong(bVar.c()) / 1000 : 0;
                if (parseLong != 0) {
                    builder.addParameter(new RequestParameter(State.KEY_REPORTED_AT, Long.valueOf(parseLong)));
                }
            } catch (Exception e11) {
                IBGDiagnostics.reportNonFatal(e11, "Failed to update reported_at in anr reporting request.");
            }
        }
    }

    @VisibleForTesting
    @NonNull
    public Request a(b bVar, Attachment attachment) throws JSONException {
        Request.Builder type = new Request.Builder().endpoint(Endpoints.ADD_CRASH_ATTACHMENT.replaceAll(":crash_token", bVar.h())).method("POST").type(2);
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

    public void b(b bVar, Request.Callbacks callbacks) throws JSONException {
        InstabugSDKLogger.d("IBG-CR", "Uploading Anr attachments, size: " + bVar.b().size());
        if (bVar.b().size() == 0) {
            callbacks.onSucceeded(Boolean.TRUE);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < bVar.b().size(); i11++) {
            Attachment attachment = (Attachment) bVar.b().get(i11);
            if (AttachmentsUtility.decryptAttachmentAndUpdateDb(attachment)) {
                Request a11 = a(bVar, attachment);
                if (attachment.getLocalPath() != null) {
                    File file = new File(attachment.getLocalPath());
                    if (!file.exists() || file.length() <= 0) {
                        InstabugSDKLogger.e("IBG-CR", "Skipping attachment file of type " + attachment.getType() + " because it's either not found or empty file");
                    } else {
                        attachment.setAttachmentState(Attachment.AttachmentState.SYNCED);
                        this.f45085a.doRequestOnSameThread(2, a11, (Request.Callbacks<RequestResponse, Throwable>) new c(this, attachment, bVar, arrayList, callbacks));
                    }
                } else {
                    InstabugSDKLogger.e("IBG-CR", "Skipping attachment file of type " + attachment.getType() + " because it's either not found or empty file");
                }
            } else {
                InstabugSDKLogger.e("IBG-CR", "Skipping attachment file of type " + attachment.getType() + " because it was not decrypted successfully");
            }
        }
    }
}
