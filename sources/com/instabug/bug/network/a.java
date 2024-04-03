package com.instabug.bug.network;

import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.instabug.bug.settings.b;
import com.instabug.library.broadcast.LastContactedChangedBroadcast;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.networkv2.RateLimitedException;
import com.instabug.library.networkv2.RequestResponse;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.Calendar;
import java.util.Locale;
import org.json.JSONException;
import org.json.JSONObject;

class a implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Request.Callbacks f45687a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f45688b;

    public a(d dVar, Request.Callbacks callbacks, Context context) {
        this.f45687a = callbacks;
        this.f45688b = context;
    }

    /* renamed from: a */
    public void onSucceeded(RequestResponse requestResponse) {
        InstabugSDKLogger.d("IBG-BR", "ReportingBugRequest succeeded, Response code: " + requestResponse.getResponseCode());
        InstabugSDKLogger.v("IBG-BR", "Response body: " + requestResponse.getResponseBody());
        try {
            if (requestResponse.getResponseBody() != null) {
                this.f45687a.onSucceeded(new JSONObject((String) requestResponse.getResponseBody()).getString("id"));
            }
        } catch (JSONException e11) {
            InstabugCore.reportError(e11, "Reporting bug got an error: " + e11.getMessage());
            InstabugSDKLogger.e("IBG-BR", "reportingBugRequest got error: " + e11.getMessage(), e11);
            this.f45687a.onFailed(e11);
        }
        if (requestResponse.getResponseCode() == 200) {
            Calendar instance = Calendar.getInstance(Locale.ENGLISH);
            InstabugSDKLogger.v("IBG-BR", "Updating last_contacted_at to " + instance.getTime());
            b.f().a(instance.getTime().getTime());
            InstabugCore.setLastContactedAt(instance.getTime().getTime());
            Intent intent = new Intent();
            intent.setAction(LastContactedChangedBroadcast.LAST_CONTACTED_CHANGED);
            intent.putExtra(LastContactedChangedBroadcast.LAST_CONTACTED_AT, instance.getTime().getTime());
            LocalBroadcastManager.getInstance(this.f45688b).sendBroadcast(intent);
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        if (!(th2 instanceof RateLimitedException)) {
            InstabugCore.reportError(th2, "Reporting bug got an error: " + th2.getMessage());
            InstabugSDKLogger.e("IBG-BR", "reportingBugRequest got error: " + th2.getMessage(), th2);
        }
        this.f45687a.onFailed(th2);
    }
}
