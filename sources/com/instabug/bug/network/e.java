package com.instabug.bug.network;

import android.content.Context;
import androidx.annotation.Nullable;
import com.instabug.bug.model.a;
import com.instabug.bug.model.d;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.dbv2.IBGContentValues;
import com.instabug.library.networkv2.RateLimitedException;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;

class e implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f45698a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f45699b;

    public e(d dVar, Context context) {
        this.f45698a = dVar;
        this.f45699b = context;
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable String str) {
        InstabugSDKLogger.d("IBG-BR", "Bug uploaded successfully, setting bug TemporaryServerToken equal " + str);
        this.f45698a.e(str);
        d dVar = this.f45698a;
        a aVar = a.LOGS_READY_TO_BE_UPLOADED;
        dVar.a(aVar);
        IBGContentValues iBGContentValues = new IBGContentValues();
        if (str != null) {
            iBGContentValues.put("temporary_server_token", str, false);
        }
        iBGContentValues.put(InstabugDbContract.BugEntry.COLUMN_BUG_STATE, aVar.name(), false);
        if (this.f45698a.getId() != null) {
            com.instabug.bug.di.a.a().a(this.f45698a.getId(), iBGContentValues);
        }
        i.f45705b.a(0);
        i.d(this.f45698a, this.f45699b);
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        if (th2 instanceof RateLimitedException) {
            i.b((RateLimitedException) th2, this.f45698a, this.f45699b);
        } else {
            InstabugSDKLogger.e("IBG-BR", "Something went wrong while uploading bug");
        }
        com.instabug.bug.testingreport.a.f45789a.postError(th2);
    }
}
