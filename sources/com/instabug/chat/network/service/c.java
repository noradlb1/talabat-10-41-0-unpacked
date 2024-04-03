package com.instabug.chat.network.service;

import com.instabug.chat.model.a;
import com.instabug.chat.model.k;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.List;

class c implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ List f46095a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f46096b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k f46097c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f46098d;

    public c(g gVar, List list, a aVar, k kVar, Request.Callbacks callbacks) {
        this.f46095a = list;
        this.f46096b = aVar;
        this.f46097c = kVar;
        this.f46098d = callbacks;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        InstabugSDKLogger.d("IBG-BR", "uploadingMessageAttachmentRequest succeeded, Response code: " + requestResponse.getResponseCode());
        InstabugSDKLogger.v("IBG-BR", "uploadingMessageAttachmentRequest succeeded, Response body: " + requestResponse.getResponseBody());
        this.f46095a.add(this.f46096b);
        if (this.f46095a.size() == this.f46097c.b().size()) {
            this.f46098d.onSucceeded(Boolean.TRUE);
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.v("IBG-BR", "uploadingMessageAttachmentRequest got error: " + th2.getMessage());
        this.f46095a.add(this.f46096b);
        if (this.f46095a.size() == this.f46097c.b().size()) {
            this.f46098d.onFailed(this.f46097c);
        }
    }
}
