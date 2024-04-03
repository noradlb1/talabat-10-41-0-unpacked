package com.instabug.library.migration;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.StringUtility;
import io.reactivex.Observable;
import java.lang.ref.WeakReference;

public class p extends AbstractMigration {
    /* access modifiers changed from: private */
    @Nullable

    /* renamed from: a  reason: collision with root package name */
    public WeakReference f51498a;

    public p() {
        super("vus_encryption_migration");
    }

    public void doAfterMigration() {
        SettingsManager.getInstance().setCurrentSDKVersion("11.7.0");
    }

    public void doPreMigration() {
    }

    public int getMigrationVersion() {
        return 4;
    }

    public void initialize(@NonNull Context context) {
        this.f51498a = new WeakReference(context);
    }

    public Observable migrate() {
        return Observable.create(new o(this));
    }

    public boolean shouldMigrate() {
        if ("11.7.0".equalsIgnoreCase(SettingsManager.getInstance().getLastSDKVersion())) {
            return false;
        }
        if (StringUtility.compareVersion("11.7.0", "8.0.0") == 1 || !SettingsManager.getInstance().isSDKVersionSet()) {
            return true;
        }
        return false;
    }
}
