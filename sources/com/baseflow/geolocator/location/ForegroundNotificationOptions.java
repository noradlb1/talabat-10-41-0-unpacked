package com.baseflow.geolocator.location;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Map;

public class ForegroundNotificationOptions {
    @NonNull
    private final boolean enableWakeLock;
    @NonNull
    private final boolean enableWifiLock;
    @NonNull
    private final AndroidIconResource notificationIcon;
    @NonNull
    private final String notificationText;
    @NonNull
    private final String notificationTitle;
    @NonNull
    private final boolean setOngoing;

    private ForegroundNotificationOptions(String str, String str2, AndroidIconResource androidIconResource, boolean z11, boolean z12, boolean z13) {
        this.notificationTitle = str;
        this.notificationText = str2;
        this.notificationIcon = androidIconResource;
        this.enableWifiLock = z11;
        this.enableWakeLock = z12;
        this.setOngoing = z13;
    }

    public static ForegroundNotificationOptions parseArguments(@Nullable Map<String, Object> map) {
        if (map == null) {
            return null;
        }
        return new ForegroundNotificationOptions((String) map.get("notificationTitle"), (String) map.get("notificationText"), AndroidIconResource.parseArguments((Map) map.get("notificationIcon")), ((Boolean) map.get("enableWifiLock")).booleanValue(), ((Boolean) map.get("enableWakeLock")).booleanValue(), ((Boolean) map.get("setOngoing")).booleanValue());
    }

    public AndroidIconResource getNotificationIcon() {
        return this.notificationIcon;
    }

    public String getNotificationText() {
        return this.notificationText;
    }

    public String getNotificationTitle() {
        return this.notificationTitle;
    }

    public boolean isEnableWakeLock() {
        return this.enableWakeLock;
    }

    public boolean isEnableWifiLock() {
        return this.enableWifiLock;
    }

    public boolean isSetOngoing() {
        return this.setOngoing;
    }
}
