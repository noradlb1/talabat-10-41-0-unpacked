package com.instabug.library.migration;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.NonNull;
import com.instabug.library.settings.SettingsManager;
import com.instabug.library.util.StringUtility;
import com.talabat.sidemenu.SideMenuRewardViewHolder;
import io.reactivex.Observable;

public class j extends AbstractMigration {
    public j() {
        super("sdk_forward_migration");
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
    }

    public Observable migrate() {
        return Observable.create(new i(this));
    }

    @SuppressLint({"NULL_DEREFERENCE"})
    public boolean shouldMigrate() {
        String lastSDKVersion = SettingsManager.getInstance().getLastSDKVersion();
        if (lastSDKVersion.contains(SideMenuRewardViewHolder.DEFAULT_LOGGED_IN_USER_POINTS_VALUE)) {
            if (StringUtility.compareVersion(String.valueOf("11.7.0".charAt(0)), String.valueOf(lastSDKVersion.charAt(0))) == 1 || !SettingsManager.getInstance().isSDKVersionSet()) {
                return true;
            }
            return false;
        } else if (StringUtility.compareVersion("11.7.0", lastSDKVersion) == 1 || !SettingsManager.getInstance().isSDKVersionSet()) {
            return true;
        } else {
            return false;
        }
    }
}
