package com.instabug.bug.network;

import android.content.Context;
import androidx.annotation.Nullable;
import com.instabug.bug.model.d;
import com.instabug.bug.testingreport.a;
import com.instabug.bug.utils.c;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;

class g implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f45702a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ d f45703b;

    public g(Context context, d dVar) {
        this.f45702a = context;
        this.f45703b = dVar;
    }

    /* renamed from: a */
    public void onFailed(d dVar) {
        InstabugSDKLogger.d("IBG-BR", "Something went wrong while uploading bug attachments");
        a.f45789a.postError(new Exception("Something went wrong while uploading bug attachments"));
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable Boolean bool) {
        InstabugSDKLogger.d("IBG-BR", "Bug attachments uploaded successfully");
        Context context = this.f45702a;
        if (context != null) {
            c.b(this.f45703b, context);
            return;
        }
        InstabugSDKLogger.e("IBG-BR", "unable to delete state file for Bug with id: " + this.f45703b.getId() + "due to null context reference");
    }
}
