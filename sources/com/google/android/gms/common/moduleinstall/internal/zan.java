package com.google.android.gms.common.moduleinstall.internal;

import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.tasks.TaskCompletionSource;

public final /* synthetic */ class zan implements RemoteCall {
    public final /* synthetic */ zay zaa;
    public final /* synthetic */ ApiFeatureRequest zab;

    public /* synthetic */ zan(zay zay, ApiFeatureRequest apiFeatureRequest) {
        this.zaa = zay;
        this.zab = apiFeatureRequest;
    }

    public final void accept(Object obj, Object obj2) {
        zay zay = this.zaa;
        ApiFeatureRequest apiFeatureRequest = this.zab;
        ((zaf) ((zaz) obj).getService()).zag(new zas(zay, (TaskCompletionSource) obj2), apiFeatureRequest, (zah) null);
    }
}
