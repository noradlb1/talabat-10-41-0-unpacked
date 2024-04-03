package com.instabug.anr.network;

import android.content.ContentValues;
import androidx.annotation.Nullable;
import com.instabug.anr.cache.a;
import com.instabug.anr.model.b;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;

class f implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f45088a;

    public f(b bVar) {
        this.f45088a = bVar;
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable Boolean bool) {
        try {
            InstabugSDKLogger.d("IBG-CR", "ANR logs uploaded successfully");
            this.f45088a.a(3);
            ContentValues contentValues = new ContentValues();
            contentValues.put(InstabugDbContract.AnrEntry.COLUMN_ANR_UPLOAD_STATE, 3);
            a.a(this.f45088a.c(), contentValues);
            i.c(this.f45088a);
        } catch (Exception unused) {
            InstabugSDKLogger.e("IBG-CR", "Error happened while uploading ANR: " + this.f45088a.c() + "attachments.");
        }
    }

    /* renamed from: a */
    public void onFailed(b bVar) {
        InstabugSDKLogger.e("IBG-CR", "Something went wrong while uploading ANR logs");
    }
}
