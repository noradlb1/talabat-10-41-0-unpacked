package com.instabug.library.migration;

import android.content.Context;
import androidx.annotation.NonNull;
import io.reactivex.Observable;

public abstract class AbstractMigration {
    private String migrationId;

    public AbstractMigration(String str) {
        this.migrationId = str;
    }

    public abstract void doAfterMigration();

    public abstract void doPreMigration();

    public String getMigrationId() {
        return this.migrationId;
    }

    public abstract int getMigrationVersion();

    public abstract void initialize(@NonNull Context context);

    public abstract Observable<AbstractMigration> migrate();

    public abstract boolean shouldMigrate();
}
