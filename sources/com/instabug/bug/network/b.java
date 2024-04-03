package com.instabug.bug.network;

import com.instabug.bug.model.d;
import com.instabug.bug.utils.c;
import com.instabug.library.internal.storage.AttachmentsUtility;
import com.instabug.library.model.Attachment;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.List;

class b implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Attachment f45689a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f45690b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f45691c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f45692d;

    public b(d dVar, Attachment attachment, d dVar2, List list, Request.Callbacks callbacks) {
        this.f45689a = attachment;
        this.f45690b = dVar2;
        this.f45691c = list;
        this.f45692d = callbacks;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        InstabugSDKLogger.d("IBG-BR", "uploadingBugAttachmentRequest succeeded, Response code: " + requestResponse.getResponseCode());
        InstabugSDKLogger.v("IBG-BR", "uploadingBugAttachmentRequest succeeded, Response body: " + requestResponse.getResponseCode() + requestResponse.getResponseBody());
        if (this.f45689a.getLocalPath() != null) {
            c.a(this.f45689a, this.f45690b.getId());
            this.f45691c.add(this.f45689a);
        }
        if (this.f45691c.size() == this.f45690b.a().size()) {
            this.f45692d.onSucceeded(Boolean.TRUE);
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-BR", "uploadingBugAttachmentRequest got error: " + th2.getMessage(), th2);
        AttachmentsUtility.encryptAttachmentsAndUpdateDb(this.f45690b.a());
        this.f45692d.onFailed(this.f45690b);
    }
}
