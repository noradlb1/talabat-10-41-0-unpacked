package com.instabug.crash.network;

import android.content.ContentValues;
import android.content.Context;
import androidx.annotation.Nullable;
import com.instabug.crash.cache.b;
import com.instabug.crash.models.a;
import com.instabug.library.networkv2.request.Request;
import org.json.JSONException;

class f implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f46435a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f46436b;

    public f(a aVar, Context context) {
        this.f46435a = aVar;
        this.f46436b = context;
    }

    /* renamed from: a */
    public void onFailed(a aVar) {
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable Boolean bool) {
        a aVar = this.f46435a;
        a.C0057a aVar2 = a.C0057a.ATTACHMENTS_READY_TO_BE_UPLOADED;
        aVar.a(aVar2);
        ContentValues contentValues = new ContentValues();
        contentValues.put("crash_state", aVar2.name());
        String e11 = this.f46435a.e();
        if (e11 != null) {
            b.a(e11, contentValues);
        }
        try {
            h.c(this.f46435a, this.f46436b);
        } catch (JSONException unused) {
        }
    }
}
