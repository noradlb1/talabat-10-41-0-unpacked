package com.instabug.library.logging.disklogs;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import com.instabug.library.internal.orchestrator.Action;
import com.instabug.library.internal.storage.operation.DiskOperationCallback;
import java.io.IOException;

class i implements Action {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f51481a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DiskOperationCallback f51482b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ k f51483c;

    public i(k kVar, Context context, DiskOperationCallback diskOperationCallback) {
        this.f51483c = kVar;
        this.f51481a = context;
        this.f51482b = diskOperationCallback;
    }

    public void run() throws Exception {
        try {
            k kVar = this.f51483c;
            kVar.a(kVar.f51487b, this.f51481a);
        } catch (IOException e11) {
            Log.e("IBG-Core", "Error while writing logs to disk: ", e11);
            DiskOperationCallback diskOperationCallback = this.f51482b;
            if (diskOperationCallback != null) {
                diskOperationCallback.onFailure(e11);
            }
        }
        DiskOperationCallback diskOperationCallback2 = this.f51482b;
        if (diskOperationCallback2 != null) {
            diskOperationCallback2.onSuccess(Uri.fromFile(this.f51483c.f51486a));
        }
    }
}
