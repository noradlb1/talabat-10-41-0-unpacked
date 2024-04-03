package com.instabug.bug.network;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.model.Attachment;
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

@SuppressLint({"ERADICATE_FIELD_NOT_INITIALIZED"})
public class d {

    /* renamed from: c  reason: collision with root package name */
    private static d f45695c;
    @VisibleForTesting

    /* renamed from: a  reason: collision with root package name */
    public Request f45696a;

    /* renamed from: b  reason: collision with root package name */
    private final NetworkManager f45697b = new NetworkManager();

    private d() {
    }

    public static d a() {
        d dVar;
        synchronized (d.class.getName()) {
            if (f45695c == null) {
                f45695c = new d();
            }
            dVar = f45695c;
        }
        return dVar;
    }

    private void b(Request.Builder builder, com.instabug.bug.model.d dVar) {
        State state = dVar.getState();
        if (state == null || state.isMinimalState() || state.getReportedAt() == 0) {
            try {
                long parseLong = dVar.getId() != null ? Long.parseLong(dVar.getId()) / 1000 : 0;
                if (parseLong != 0) {
                    builder.addParameter(new RequestParameter(State.KEY_REPORTED_AT, Long.valueOf(parseLong)));
                }
            } catch (Exception e11) {
                IBGDiagnostics.reportNonFatal(e11, "Failed to update reported_at in bug reporting request.");
            }
        }
    }

    public void a(Context context, com.instabug.bug.model.d dVar, Request.Callbacks callbacks) {
        InstabugSDKLogger.d("IBG-BR", "Reporting bug request started");
        Request d11 = d(dVar);
        this.f45696a = d11;
        this.f45697b.doRequestOnSameThread(1, d11, (Request.Callbacks<RequestResponse, Throwable>) new a(this, callbacks, context));
    }

    public void a(com.instabug.bug.model.d dVar, Request.Callbacks callbacks) {
        StringBuilder sb2;
        String str;
        InstabugSDKLogger.d("IBG-BR", "Uploading Bug attachments");
        if (dVar.a().isEmpty()) {
            callbacks.onSucceeded(Boolean.TRUE);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < dVar.a().size(); i11++) {
            Attachment attachment = (Attachment) dVar.a().get(i11);
            boolean decryptAttachmentAndUpdateDb = AttachmentsUtility.decryptAttachmentAndUpdateDb(attachment);
            if (!(attachment.getLocalPath() == null || attachment.getName() == null)) {
                File file = new File(attachment.getLocalPath());
                if (!decryptAttachmentAndUpdateDb || !file.exists() || file.length() <= 0) {
                    if (!decryptAttachmentAndUpdateDb) {
                        sb2 = new StringBuilder();
                        sb2.append("Skipping attachment file of type ");
                        sb2.append(attachment.getType());
                        str = " because it was not decrypted successfully";
                    } else if (!file.exists() || file.length() <= 0) {
                        sb2 = new StringBuilder();
                        sb2.append("Skipping attachment file of type ");
                        sb2.append(attachment.getType());
                        str = " because it's either not found or empty file";
                    }
                    sb2.append(str);
                    InstabugSDKLogger.e("IBG-BR", sb2.toString());
                } else {
                    Request.Builder type = new Request.Builder().endpoint(Endpoints.ADD_BUG_ATTACHMENT).method("POST").type(2);
                    if (dVar.h() != null) {
                        type.endpoint(Endpoints.ADD_BUG_ATTACHMENT.replaceAll(":bug_token", dVar.h()));
                    }
                    if (attachment.getType() != null) {
                        type.addParameter(new RequestParameter("metadata[file_type]", attachment.getType()));
                        if (attachment.getType() == Attachment.Type.AUDIO && attachment.getDuration() != null) {
                            type.addParameter(new RequestParameter("metadata[duration]", attachment.getDuration()));
                        }
                    }
                    attachment.setAttachmentState(Attachment.AttachmentState.SYNCED);
                    type.fileToUpload(new FileToUpload("file", attachment.getName(), attachment.getLocalPath(), attachment.getFileType()));
                    this.f45697b.doRequestOnSameThread(2, type.build(), (Request.Callbacks<RequestResponse, Throwable>) new b(this, attachment, dVar, arrayList, callbacks));
                }
            }
        }
    }

    @VisibleForTesting
    public Request b(com.instabug.bug.model.d dVar) {
        Request.Builder method = new Request.Builder().endpoint(Endpoints.BUG_LOGS).method("POST");
        if (dVar.h() != null) {
            method.endpoint(Endpoints.BUG_LOGS.replaceAll(":bug_token", dVar.h()));
        }
        ArrayList<State.StateItem> logsItems = dVar.getState() != null ? dVar.getState().getLogsItems() : null;
        if (logsItems != null) {
            Iterator<State.StateItem> it = logsItems.iterator();
            while (it.hasNext()) {
                State.StateItem next = it.next();
                if (!(next.getKey() == null || next.getValue() == null)) {
                    method.addParameter(new RequestParameter(next.getKey(), next.getValue()));
                }
            }
        }
        if (dVar.j() != null) {
            method.addParameter(new RequestParameter(InstabugDbContract.BugEntry.COLUMN_VIEW_HIERARCHY, dVar.j()));
        }
        return method.build();
    }

    public void b(com.instabug.bug.model.d dVar, Request.Callbacks callbacks) {
        InstabugSDKLogger.v("IBG-BR", "Uploading bug logs request started");
        try {
            this.f45697b.doRequestOnSameThread(1, b(dVar), (Request.Callbacks<RequestResponse, Throwable>) new c(this, callbacks, dVar));
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-BR", "uploading bug logs got Json error ", e11);
            callbacks.onFailed(dVar);
        }
    }

    @VisibleForTesting
    public Request c(Request.Builder builder, com.instabug.bug.model.d dVar) {
        if (dVar.getState() != null) {
            ArrayList<State.StateItem> stateItems = dVar.getState().getStateItems();
            Arrays.asList(State.getUserDataKeys());
            for (int i11 = 0; i11 < stateItems.size(); i11++) {
                String key = stateItems.get(i11).getKey();
                Object value = stateItems.get(i11).getValue();
                if (!(key == null || value == null)) {
                    builder.addParameter(new RequestParameter(key, value));
                }
            }
        }
        b(builder, dVar);
        return builder.build();
    }

    @VisibleForTesting
    public Request d(com.instabug.bug.model.d dVar) {
        Request.Builder method = new Request.Builder().endpoint(Endpoints.REPORT_BUG).method("POST");
        method.addParameter(new RequestParameter("title", dVar.g()));
        method.addParameter(new RequestParameter("attachments_count", Integer.valueOf(dVar.a().size())));
        method.addParameter(new RequestParameter("categories", dVar.d()));
        Request c11 = c(method, dVar);
        this.f45696a = c11;
        return c11;
    }
}
