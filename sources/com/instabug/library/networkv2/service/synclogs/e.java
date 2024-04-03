package com.instabug.library.networkv2.service.synclogs;

import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;

class e implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request f51692a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ f f51693b;

    public e(f fVar, Request request) {
        this.f51693b = fVar;
        this.f51692a = request;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        if (this.f51692a.getFileToUpload() != null) {
            String filePath = this.f51692a.getFileToUpload().getFilePath();
            if (this.f51693b.a() != null) {
                this.f51693b.a().onSucceeded(filePath);
            }
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        if (this.f51693b.a() != null) {
            this.f51693b.a().onFailed(th2);
        }
    }
}
