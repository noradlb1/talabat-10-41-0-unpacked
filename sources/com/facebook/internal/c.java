package com.facebook.internal;

import com.facebook.GraphRequest;
import com.facebook.GraphResponse;
import com.facebook.internal.WebDialog;
import java.util.concurrent.CountDownLatch;

public final /* synthetic */ class c implements GraphRequest.Callback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String[] f33593a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f33594b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WebDialog.UploadStagingResourcesTask f33595c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ CountDownLatch f33596d;

    public /* synthetic */ c(String[] strArr, int i11, WebDialog.UploadStagingResourcesTask uploadStagingResourcesTask, CountDownLatch countDownLatch) {
        this.f33593a = strArr;
        this.f33594b = i11;
        this.f33595c = uploadStagingResourcesTask;
        this.f33596d = countDownLatch;
    }

    public final void onCompleted(GraphResponse graphResponse) {
        WebDialog.UploadStagingResourcesTask.m8967doInBackground$lambda0(this.f33593a, this.f33594b, this.f33595c, this.f33596d, graphResponse);
    }
}
