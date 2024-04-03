package com.instabug.library.migration;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.settings.SettingsManager;
import io.reactivex.Observable;
import java.io.File;

public class n extends AbstractMigration {
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public Context f51496a;

    public n() {
        super("v2_cache_files_migration");
    }

    public void doAfterMigration() {
    }

    public void doPreMigration() {
    }

    public int getMigrationVersion() {
        return 2;
    }

    public void initialize(@NonNull Context context) {
        this.f51496a = context;
    }

    public Observable migrate() {
        if (this.f51496a == null) {
            return Observable.empty();
        }
        return Observable.create(new m(this));
    }

    public boolean shouldMigrate() {
        if (getMigrationVersion() <= SettingsManager.getInstance().getLastMigrationVersion() || this.f51496a == null) {
            return false;
        }
        File file = new File(this.f51496a.getCacheDir() + "/issues.cache");
        File file2 = new File(this.f51496a.getCacheDir() + "/conversations.cache");
        if (file.exists() || file2.exists()) {
            return true;
        }
        return false;
    }
}
