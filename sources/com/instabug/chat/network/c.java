package com.instabug.chat.network;

import androidx.annotation.Nullable;
import com.instabug.chat.model.d;
import com.instabug.chat.model.j;
import com.instabug.chat.model.k;
import com.instabug.chat.settings.a;
import com.instabug.library.internal.storage.cache.InMemoryCache;
import com.instabug.library.networkv2.request.Request;
import com.instabug.library.util.InstabugDateFormatter;
import com.instabug.library.util.InstabugSDKLogger;
import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.Locale;
import org.json.JSONException;

class c implements Request.Callbacks {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ k f46087a;

    public c(k kVar) {
        this.f46087a = kVar;
    }

    /* renamed from: a */
    public void onSucceeded(@Nullable String str) {
        String str2;
        k kVar;
        j jVar;
        if (str != null && !str.equals("") && !str.equals("null")) {
            InstabugSDKLogger.d("IBG-BR", "Send message Request succeeded");
            d a11 = com.instabug.chat.cache.k.a(this.f46087a.d());
            if (a11 != null) {
                a11.f().remove(this.f46087a);
                this.f46087a.c(str);
                if (this.f46087a.b().size() == 0) {
                    kVar = this.f46087a;
                    jVar = j.READY_TO_BE_SYNCED;
                } else {
                    kVar = this.f46087a;
                    jVar = j.SENT;
                }
                kVar.a(jVar);
                InstabugSDKLogger.v("IBG-BR", "Caching sent message:" + this.f46087a.toString());
                a11.f().add(this.f46087a);
                InMemoryCache b11 = com.instabug.chat.cache.k.b();
                if (b11 != null) {
                    b11.put(a11.getId(), a11);
                }
                com.instabug.chat.cache.k.k();
                if (this.f46087a.b().size() == 0) {
                    a.a(Calendar.getInstance(Locale.ENGLISH).getTime().getTime());
                    com.instabug.chat.eventbus.a.a().post(Long.valueOf(InstabugDateFormatter.getCurrentUTCTimeStampInMiliSeconds()));
                    return;
                }
                try {
                    f.b(this.f46087a);
                } catch (FileNotFoundException | JSONException e11) {
                    str2 = "Something went wrong while uploading messageattach attachments " + e11.getMessage();
                }
            } else {
                str2 = "Chat is null so can't remove message from it";
                InstabugSDKLogger.e("IBG-BR", str2);
            }
        }
    }

    /* renamed from: a */
    public void onFailed(Throwable th2) {
        InstabugSDKLogger.e("IBG-BR", "Something went wrong while uploading cached message", th2);
    }
}
