package com.appboy.enums;

import com.deliveryhero.customerchat.eventTracking.constants.UserPropertyKeys;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/appboy/enums/DeviceKey;", "", "key", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getKey", "()Ljava/lang/String;", "ANDROID_VERSION", "CARRIER", "MODEL", "RESOLUTION", "LOCALE", "TIMEZONE", "NOTIFICATIONS_ENABLED", "IS_BACKGROUND_RESTRICTED", "GOOGLE_ADVERTISING_ID", "AD_TRACKING_ENABLED", "android-sdk-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum DeviceKey {
    ANDROID_VERSION(UserPropertyKeys.OS_VERSION),
    CARRIER("carrier"),
    MODEL(DeviceRequestsHelper.DEVICE_INFO_MODEL),
    RESOLUTION("resolution"),
    LOCALE("locale"),
    TIMEZONE("time_zone"),
    NOTIFICATIONS_ENABLED("remote_notification_enabled"),
    IS_BACKGROUND_RESTRICTED("android_is_background_restricted"),
    GOOGLE_ADVERTISING_ID("google_ad_id"),
    AD_TRACKING_ENABLED("ad_tracking_enabled");
    
    private final String key;

    private DeviceKey(String str) {
        this.key = str;
    }

    public final String getKey() {
        return this.key;
    }
}
