package com.instabug.crash.network;

import com.instabug.crash.models.a;
import com.instabug.crash.utils.e;
import com.instabug.library.model.Attachment;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.List;

class b implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Attachment f46425a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f46426b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f46427c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f46428d;

    public b(d dVar, Attachment attachment, a aVar, List list, Request.Callbacks callbacks) {
        this.f46425a = attachment;
        this.f46426b = aVar;
        this.f46427c = list;
        this.f46428d = callbacks;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        InstabugSDKLogger.d("IBG-CR", "uploadingCrashAttachmentRequest succeeded, Response code:" + requestResponse.getResponseCode());
        InstabugSDKLogger.v("IBG-CR", "uploadingCrashAttachmentRequest succeeded, Response body:" + requestResponse.getResponseBody());
        if (this.f46425a.getLocalPath() != null) {
            e.a(this.f46425a, this.f46426b.e());
            this.f46427c.add(this.f46425a);
        }
        if (this.f46427c.size() == this.f46426b.a().size()) {
            this.f46428d.onSucceeded(Boolean.TRUE);
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-CR", "uploadingCrashAttachmentRequest got error: " + th2.getMessage());
        this.f46428d.onFailed(this.f46426b);
    }
}
