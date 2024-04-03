package com.instabug.terminations.sync;

import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.terminations.model.b;
import org.jetbrains.annotations.Nullable;

public final class i implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k f52657a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f52658b;

    public i(k kVar, b bVar) {
        this.f52657a = kVar;
        this.f52658b = bVar;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSucceeded(@org.jetbrains.annotations.Nullable com.instabug.library.networkv2.RequestResponse r4) {
        /*
            r3 = this;
            com.instabug.terminations.sync.k r0 = r3.f52657a
            com.instabug.library.networkv2.limitation.RateLimiter r0 = r0.b()
            r0.reset()
            r0 = 0
            if (r4 != 0) goto L_0x000d
            goto L_0x003e
        L_0x000d:
            java.lang.Object r4 = r4.getResponseBody()
            if (r4 != 0) goto L_0x0014
            goto L_0x003e
        L_0x0014:
            com.instabug.terminations.sync.k r1 = r3.f52657a
            kotlin.Result$Companion r2 = kotlin.Result.Companion     // Catch:{ all -> 0x002a }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x002a }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ all -> 0x002a }
            r2.<init>((java.lang.String) r4)     // Catch:{ all -> 0x002a }
            java.lang.String r4 = "id"
            java.lang.String r4 = r2.getString(r4)     // Catch:{ all -> 0x002a }
            java.lang.Object r4 = kotlin.Result.m6329constructorimpl(r4)     // Catch:{ all -> 0x002a }
            goto L_0x0035
        L_0x002a:
            r4 = move-exception
            kotlin.Result$Companion r2 = kotlin.Result.Companion
            java.lang.Object r4 = kotlin.ResultKt.createFailure(r4)
            java.lang.Object r4 = kotlin.Result.m6329constructorimpl(r4)
        L_0x0035:
            java.lang.String r2 = "Failed to extract crash id"
            java.lang.Object r4 = r1.a(r4, r0, r2)
            r0 = r4
            java.lang.String r0 = (java.lang.String) r0
        L_0x003e:
            if (r0 != 0) goto L_0x0041
            return
        L_0x0041:
            com.instabug.terminations.model.b r4 = r3.f52658b
            r4.b(r0)
            r4.h()
            com.instabug.terminations.di.d r4 = com.instabug.terminations.di.d.f52610a
            com.instabug.terminations.cache.c r4 = r4.b()
            com.instabug.terminations.model.b r0 = r3.f52658b
            r4.a((com.instabug.terminations.model.b) r0)
            com.instabug.terminations.sync.k r4 = r3.f52657a
            com.instabug.terminations.model.b r0 = r3.f52658b
            r4.c((com.instabug.terminations.model.b) r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.instabug.terminations.sync.i.onSucceeded(com.instabug.library.networkv2.RequestResponse):void");
    }

    /* renamed from: a */
    public void onFailed(@Nullable Throwable th2) {
        if (th2 != null && !this.f52657a.b().inspect(th2, this.f52658b)) {
            InstabugSDKLogger.e("IBG-CR", "Failed to report termination", th2);
        }
    }
}
