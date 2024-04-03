package com.instabug.featuresrequest.ui.newfeature;

import androidx.annotation.Nullable;
import com.instabug.featuresrequest.models.d;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;

class j implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f46825a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f46826b;

    public j(k kVar, d dVar) {
        this.f46826b = kVar;
        this.f46825a = dVar;
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable Boolean bool) {
        InstabugSDKLogger.d("IBG-FR", "featureRequest synced successfully");
        PoolProvider.postMainThreadTask(new h(this));
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-FR", "Something went wrong while sending featureRequest: " + this.f46825a, th2);
        PoolProvider.postMainThreadTask(new i(this));
    }
}
