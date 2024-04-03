package com.instabug.library.migration;

import android.content.Context;
import androidx.annotation.NonNull;
import com.instabug.library.settings.SettingsManager;
import io.reactivex.Observable;

public class d extends AbstractMigration {
    public d() {
        super("last_contacted_at_to_last_bug_and_last_chat_time_migration");
    }

    public void doAfterMigration() {
    }

    public void doPreMigration() {
    }

    public String getMigrationId() {
        return "last_contacted_at_to_last_bug_and_last_chat_time_migration";
    }

    public int getMigrationVersion() {
        return 3;
    }

    public void initialize(@NonNull Context context) {
    }

    public Observable migrate() {
        return Observable.create(new c(this));
    }

    public boolean shouldMigrate() {
        if (getMigrationVersion() <= SettingsManager.getInstance().getLastMigrationVersion() || SettingsManager.getInstance().getLastContactedAt() == 0) {
            return false;
        }
        return true;
    }
}
