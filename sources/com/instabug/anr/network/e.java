package com.instabug.anr.network;

import android.content.ContentValues;
import android.content.Context;
import androidx.annotation.Nullable;
import com.instabug.anr.cache.a;
import com.instabug.anr.model.b;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.networkv2.RateLimitedException;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;

class e implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f45086a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f45087b;

    public e(b bVar, Context context) {
        this.f45086a = bVar;
        this.f45087b = context;
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable String str) {
        if (str == null) {
            InstabugSDKLogger.e("IBG-CR", "null response, aborting...");
            return;
        }
        com.instabug.crash.settings.b.a().setLastRequestStartedAt(0);
        InstabugSDKLogger.d("IBG-CR", "ANR uploaded successfully");
        this.f45086a.e(str);
        this.f45086a.a(2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("temporary_server_token", str);
        contentValues.put(InstabugDbContract.AnrEntry.COLUMN_ANR_UPLOAD_STATE, 2);
        a.a(this.f45086a.c(), contentValues);
        i.d(this.f45086a);
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        if (th2 instanceof RateLimitedException) {
            i.b((RateLimitedException) th2, this.f45086a, this.f45087b);
            return;
        }
        InstabugSDKLogger.d("IBG-CR", "Something went wrong while uploading ANR, " + th2.getMessage());
    }
}
