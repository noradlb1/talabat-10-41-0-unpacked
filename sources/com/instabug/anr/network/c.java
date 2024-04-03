package com.instabug.anr.network;

import com.instabug.anr.model.b;
import com.instabug.crash.utils.e;
import com.instabug.library.model.Attachment;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.List;

class c implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Attachment f45080a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f45081b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f45082c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f45083d;

    public c(d dVar, Attachment attachment, b bVar, List list, Request.Callbacks callbacks) {
        this.f45080a = attachment;
        this.f45081b = bVar;
        this.f45082c = list;
        this.f45083d = callbacks;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        InstabugSDKLogger.d("IBG-CR", "uploadingAnrAttachmentRequest Succeeded, Response code:" + requestResponse.getResponseCode());
        InstabugSDKLogger.v("IBG-CR", "uploadingAnrAttachmentRequest Succeeded, Response body: " + requestResponse.getResponseBody());
        if (this.f45080a.getLocalPath() != null) {
            e.a(this.f45080a, this.f45081b.c());
            this.f45082c.add(this.f45080a);
        }
        if (this.f45082c.size() == this.f45081b.b().size()) {
            this.f45083d.onSucceeded(Boolean.TRUE);
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.d("IBG-CR", "uploading AnrAttachment Request got error: " + th2.getMessage());
        this.f45083d.onFailed(this.f45081b);
    }
}
