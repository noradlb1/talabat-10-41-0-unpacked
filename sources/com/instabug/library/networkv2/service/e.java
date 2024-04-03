package com.instabug.library.networkv2.service;

import android.annotation.SuppressLint;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.IBGNetworkWorker;
import com.instabug.library.model.AssetEntity;
import com.instabug.library.networkv2.NetworkManager;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;

public class e {

    /* renamed from: b  reason: collision with root package name */
    private static e f51672b;

    /* renamed from: a  reason: collision with root package name */
    private NetworkManager f51673a = new NetworkManager();

    private e() {
    }

    public static e a() {
        if (f51672b == null) {
            f51672b = new e();
        }
        return f51672b;
    }

    @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE"})
    public void a(AssetEntity assetEntity, Request.Callbacks callbacks) {
        if (assetEntity != null && callbacks != null) {
            InstabugSDKLogger.d("IBG-Core", "Downloading file request");
            this.f51673a.doRequest(IBGNetworkWorker.CORE, 3, a(assetEntity), (Request.Callbacks<RequestResponse, Throwable>) new d(this, callbacks, assetEntity));
        }
    }

    @VisibleForTesting
    @SuppressLint({"ERADICATE_RETURN_NOT_NULLABLE"})
    public Request a(AssetEntity assetEntity) {
        String url = assetEntity.getUrl();
        return new Request.Builder().url(url).method("GET").fileToDownload(assetEntity.getFile()).hasUuid(false).disableDefaultParameters(true).build();
    }
}
