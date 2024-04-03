package com.instabug.library.user;

import com.instabug.library.networkv2.service.g;
import com.instabug.library.session.h;
import com.instabug.library.sessionV3.di.c;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import io.reactivex.CompletableObserver;
import org.json.JSONException;

class d implements Runnable {
    public void run() {
        InstabugSDKLogger.d("IBG-Core", "migrate UUID");
        String mD5Uuid = SettingsManager.getInstance().getMD5Uuid();
        if (f.q()) {
            SettingsManager.getInstance().setShouldMakeUUIDMigrationRequest(true);
            try {
                String uuid = SettingsManager.getInstance().getUuid();
                if (uuid == null) {
                    InstabugSDKLogger.v("IBG-Core", "old uuid is null");
                } else if (mD5Uuid == null) {
                    InstabugSDKLogger.v("IBG-Core", "New UUID is null");
                } else {
                    new h().a(uuid, mD5Uuid).subscribe((CompletableObserver) new b(this));
                    c.k().migrateUUID(uuid, mD5Uuid);
                    g.a().a(uuid, mD5Uuid, new c(this, uuid, mD5Uuid));
                }
            } catch (JSONException e11) {
                InstabugSDKLogger.e("IBG-Core", "Something went wrong while do UUID migration request", e11);
            }
        } else {
            f.c();
            if (mD5Uuid == null) {
                InstabugSDKLogger.v("IBG-Core", "New UUID is null");
            }
        }
    }
}
