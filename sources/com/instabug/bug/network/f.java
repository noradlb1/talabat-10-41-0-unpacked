package com.instabug.bug.network;

import android.content.Context;
import androidx.annotation.Nullable;
import com.instabug.bug.model.d;
import com.instabug.bug.testingreport.a;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.dbv2.IBGContentValues;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;

class f implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d f45700a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f45701b;

    public f(d dVar, Context context) {
        this.f45700a = dVar;
        this.f45701b = context;
    }

    /* renamed from: a */
    public void onFailed(d dVar) {
        InstabugSDKLogger.d("IBG-BR", "Something went wrong while uploading bug logs");
        a.f45789a.postError(new Exception("Something went wrong while uploading bug logs"));
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable Boolean bool) {
        InstabugSDKLogger.v("IBG-BR", "Bug logs uploaded successfully, change its state");
        if (this.f45700a.getId() == null) {
            InstabugSDKLogger.e("IBG-BR", "Couldn't update the bug's state because its ID is null");
            return;
        }
        d dVar = this.f45700a;
        com.instabug.bug.model.a aVar = com.instabug.bug.model.a.ATTACHMENTS_READY_TO_BE_UPLOADED;
        dVar.a(aVar);
        IBGContentValues iBGContentValues = new IBGContentValues();
        iBGContentValues.put(InstabugDbContract.BugEntry.COLUMN_BUG_STATE, aVar.name(), false);
        com.instabug.bug.di.a.a().a(this.f45700a.getId(), iBGContentValues);
        try {
            i.c(this.f45700a, this.f45701b);
        } catch (Exception e11) {
            InstabugSDKLogger.e("IBG-BR", "Something went wrong while uploading bug attachments e: " + e11.getMessage());
        }
    }
}
