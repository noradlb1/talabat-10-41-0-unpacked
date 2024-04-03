package com.instabug.library.migration;

import android.content.Context;
import androidx.annotation.NonNull;
import com.instabug.library.settings.SettingsManager;
import io.reactivex.Observable;

public class b extends AbstractMigration {

    /* renamed from: a  reason: collision with root package name */
    private static String f51488a = "last_contacted_at_migration";

    public b() {
        super(f51488a);
    }

    public void doAfterMigration() {
    }

    public void doPreMigration() {
    }

    public String getMigrationId() {
        return f51488a;
    }

    public int getMigrationVersion() {
        return 1;
    }

    public void initialize(@NonNull Context context) {
    }

    public Observable migrate() {
        return Observable.create(new a(this));
    }

    public boolean shouldMigrate() {
        if (getMigrationVersion() <= SettingsManager.getInstance().getLastMigrationVersion() || !SettingsManager.getInstance().isDeviceRegistered() || SettingsManager.getInstance().getLastContactedAt() != 0) {
            return false;
        }
        return true;
    }
}
