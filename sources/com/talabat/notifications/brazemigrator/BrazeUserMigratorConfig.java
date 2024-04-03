package com.talabat.notifications.brazemigrator;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/notifications/brazemigrator/BrazeUserMigratorConfig;", "", "()V", "APP_BOY_PREFS_NAME", "", "APP_BOY_USER_ID_DEFAULT_VALUE", "APP_BOY_USER_ID_KEY", "APP_IS_GUEST", "APP_ORDERS_KEY", "APP_PI_MIGRATED_KEY", "com_talabat_notifications_notifications"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BrazeUserMigratorConfig {
    @NotNull
    public static final String APP_BOY_PREFS_NAME = "talabat";
    @NotNull
    public static final String APP_BOY_USER_ID_DEFAULT_VALUE = "";
    @NotNull
    public static final String APP_BOY_USER_ID_KEY = "AppBoyUserId";
    @NotNull
    public static final String APP_IS_GUEST = "app_is_guest";
    @NotNull
    public static final String APP_ORDERS_KEY = "app_orders";
    @NotNull
    public static final String APP_PI_MIGRATED_KEY = "app_pi_migrated";
    @NotNull
    public static final BrazeUserMigratorConfig INSTANCE = new BrazeUserMigratorConfig();

    private BrazeUserMigratorConfig() {
    }
}
