package com.instabug.library.migration;

import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.InstabugSDKLogger;
import io.reactivex.observers.DisposableObserver;

class e extends DisposableObserver {
    /* renamed from: a */
    public void onNext(AbstractMigration abstractMigration) {
        InstabugSDKLogger.d("IBG-Core", "Migration " + abstractMigration.getMigrationId() + " done");
        abstractMigration.doAfterMigration();
    }

    public void onComplete() {
        InstabugSDKLogger.d("IBG-Core", "All Migrations completed, setting lastMigrationVersion to 4");
        SettingsManager.getInstance().setLastMigrationVersion(4);
    }

    public void onError(Throwable th2) {
        InstabugSDKLogger.e("IBG-Core", "Migration failed" + th2.getMessage());
    }
}
