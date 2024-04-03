package com.instabug.chat.network;

import androidx.annotation.Nullable;
import com.instabug.chat.model.a;
import com.instabug.chat.model.j;
import com.instabug.chat.model.k;
import com.instabug.commons.diagnostics.event.CalibrationDiagnosticEvent;
import com.instabug.library.internal.storage.cache.InMemoryCache;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugDateFormatter;
import com.instabug.library.util.InstabugSDKLogger;
import java.util.Calendar;
import java.util.Locale;

class d implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k f46088a;

    public d(k kVar) {
        this.f46088a = kVar;
    }

    /* renamed from: a */
    public void onFailed(k kVar) {
        InstabugSDKLogger.e("IBG-BR", "Something went wrong while uploading message attachments");
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable Boolean bool) {
        InstabugSDKLogger.d("IBG-BR", "Message attachments uploaded successfully");
        com.instabug.chat.model.d a11 = com.instabug.chat.cache.k.a(this.f46088a.d());
        if (a11 != null) {
            a11.f().remove(this.f46088a);
            this.f46088a.a(j.READY_TO_BE_SYNCED);
            for (int i11 = 0; i11 < this.f46088a.b().size(); i11++) {
                ((a) this.f46088a.b().get(i11)).d(CalibrationDiagnosticEvent.Action.Synced);
            }
            InstabugSDKLogger.v("IBG-BR", "Caching sent message:" + this.f46088a.toString());
            a11.f().add(this.f46088a);
            InMemoryCache b11 = com.instabug.chat.cache.k.b();
            if (b11 != null) {
                b11.put(a11.getId(), a11);
            }
            com.instabug.chat.cache.k.k();
            com.instabug.chat.settings.a.a(Calendar.getInstance(Locale.ENGLISH).getTime().getTime());
            com.instabug.chat.eventbus.a.a().post(Long.valueOf(InstabugDateFormatter.getCurrentUTCTimeStampInMiliSeconds()));
            return;
        }
        InstabugSDKLogger.e("IBG-BR", "Chat is null so can't remove message from it");
    }
}
