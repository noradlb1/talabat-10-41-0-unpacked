package com.talabat.notifications.brazemigrator.guestuser.domain;

import android.content.SharedPreferences;
import com.talabat.notifications.brazemigrator.BrazeUserMigratorConfig;
import com.talabat.notifications.brazewrapper.BrazeSdkWrapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bJ\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/talabat/notifications/brazemigrator/guestuser/domain/GuestUserMigrator;", "", "prefs", "Landroid/content/SharedPreferences;", "brazeSdkWrapper", "Lcom/talabat/notifications/brazewrapper/BrazeSdkWrapper;", "(Landroid/content/SharedPreferences;Lcom/talabat/notifications/brazewrapper/BrazeSdkWrapper;)V", "migrateGuestUser", "", "hash", "", "migrateGuestUser$com_talabat_notifications_notifications", "setCustomerIdToPref", "com_talabat_notifications_notifications"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GuestUserMigrator {
    @NotNull
    private final BrazeSdkWrapper brazeSdkWrapper;
    @NotNull
    private final SharedPreferences prefs;

    public GuestUserMigrator(@NotNull SharedPreferences sharedPreferences, @NotNull BrazeSdkWrapper brazeSdkWrapper2) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "prefs");
        Intrinsics.checkNotNullParameter(brazeSdkWrapper2, "brazeSdkWrapper");
        this.prefs = sharedPreferences;
        this.brazeSdkWrapper = brazeSdkWrapper2;
    }

    private final void setCustomerIdToPref(String str) {
        SharedPreferences.Editor edit = this.prefs.edit();
        edit.putString(BrazeUserMigratorConfig.APP_BOY_USER_ID_KEY, str);
        edit.apply();
    }

    public final void migrateGuestUser$com_talabat_notifications_notifications(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "hash");
        String str2 = "";
        String string = this.prefs.getString(BrazeUserMigratorConfig.APP_BOY_USER_ID_KEY, str2);
        if (string != null) {
            str2 = string;
        }
        if (!Intrinsics.areEqual((Object) str2, (Object) str)) {
            this.brazeSdkWrapper.changeUser(str);
            setCustomerIdToPref(str);
            this.brazeSdkWrapper.setBooleanCustomUserAttribute(BrazeUserMigratorConfig.APP_PI_MIGRATED_KEY, true);
            this.brazeSdkWrapper.setBooleanCustomUserAttribute(BrazeUserMigratorConfig.APP_IS_GUEST, true);
        }
    }
}
