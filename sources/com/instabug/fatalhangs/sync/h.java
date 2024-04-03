package com.instabug.fatalhangs.sync;

import com.instabug.crash.utils.e;
import com.instabug.fatalhangs.model.c;
import com.instabug.library.model.Attachment;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

public final class h implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Attachment f46503a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ List f46504b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f46505c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f46506d;

    public h(Attachment attachment, List list, c cVar, Request.Callbacks callbacks) {
        this.f46503a = attachment;
        this.f46504b = list;
        this.f46505c = cVar;
        this.f46506d = callbacks;
    }

    /* renamed from: a */
    public void onSucceeded(@NotNull RequestResponse requestResponse) {
        Intrinsics.checkNotNullParameter(requestResponse, "requestResponse");
        InstabugSDKLogger.v("IBG-CR", "uploadingFatalHangAttachmentRequest Succeeded, Response code: " + requestResponse.getResponseCode() + ", Response body: " + requestResponse.getResponseBody());
        if (this.f46503a.getLocalPath() != null) {
            Attachment attachment = this.f46503a;
            c cVar = this.f46505c;
            List list = this.f46504b;
            e.a(attachment, cVar.c());
            list.add(attachment);
        }
        if (this.f46504b.size() == this.f46505c.a().size()) {
            this.f46506d.onSucceeded(Boolean.TRUE);
        }
    }

    /* renamed from: a */
    public void onFailed(@NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(th2, "error");
        InstabugSDKLogger.d("IBG-CR", Intrinsics.stringPlus("uploadingFatalHangAttachmentRequest got error: ", th2.getMessage()));
        this.f46506d.onFailed(th2);
    }
}
