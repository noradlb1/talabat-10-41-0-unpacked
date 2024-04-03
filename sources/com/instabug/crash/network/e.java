package com.instabug.crash.network;

import android.content.ContentValues;
import android.content.Context;
import androidx.annotation.Nullable;
import com.instabug.crash.models.a;
import com.instabug.crash.settings.b;
import com.instabug.library.networkv2.RateLimitedException;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;

class e implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f46433a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f46434b;

    public e(a aVar, Context context) {
        this.f46433a = aVar;
        this.f46434b = context;
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable String str) {
        if (str == null) {
            InstabugSDKLogger.v("IBG-CR", "Crash uploading response was null, aborting...");
            return;
        }
        b.a().setLastRequestStartedAt(0);
        InstabugSDKLogger.d("IBG-CR", "crash uploaded successfully");
        this.f46433a.d(str);
        a aVar = this.f46433a;
        a.C0057a aVar2 = a.C0057a.LOGS_READY_TO_BE_UPLOADED;
        aVar.a(aVar2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("temporary_server_token", str);
        contentValues.put("crash_state", aVar2.name());
        String e11 = this.f46433a.e();
        if (e11 != null) {
            com.instabug.crash.cache.b.a(e11, contentValues);
        }
        h.d(this.f46433a, this.f46434b);
        h.e();
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        if (th2 instanceof RateLimitedException) {
            h.b((RateLimitedException) th2, this.f46433a, this.f46434b);
        } else {
            InstabugSDKLogger.d("IBG-CR", "Something went wrong while uploading crash");
        }
    }
}
