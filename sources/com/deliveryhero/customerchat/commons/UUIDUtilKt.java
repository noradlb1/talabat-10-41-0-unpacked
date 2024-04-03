package com.deliveryhero.customerchat.commons;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"getDeviceUUID", "", "chatPreferences", "Lcom/deliveryhero/customerchat/commons/ChatPreferences;", "customerchat_basicRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class UUIDUtilKt {
    @NotNull
    public static final String getDeviceUUID(@NotNull ChatPreferences chatPreferences) {
        Intrinsics.checkNotNullParameter(chatPreferences, "chatPreferences");
        String deviceUUID = chatPreferences.getDeviceUUID();
        if (deviceUUID != null) {
            return deviceUUID;
        }
        String uuid = UUID.randomUUID().toString();
        chatPreferences.saveDeviceUUID(uuid);
        return uuid;
    }
}
