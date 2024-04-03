package com.deliveryhero.customerchat.telephonyImpl.domain;

import com.deliveryhero.customerchat.telephony.domain.TokuService;
import com.deliveryhero.customerchat.telephony.domain.TokuUserStatus;
import com.talabat.card_tokenization.CardTokenizationPlugin;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J \u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J\u001c\u0010\u000e\u001a\u00020\r2\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\u00042\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0004H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015H\u0016¨\u0006\u0016"}, d2 = {"Lcom/deliveryhero/customerchat/telephonyImpl/domain/FakeTokuServiceImpl;", "Lcom/deliveryhero/customerchat/telephony/domain/TokuService;", "()V", "call", "", "number", "", "getSoftphoneLogs", "", "init", "licenseKey", "userId", "enableVoipLogging", "", "isVoIPPushMessage", "messageData", "", "onPushNotificationReceived", "stop", "updateUserStatus", "userStatus", "Lcom/deliveryhero/customerchat/telephony/domain/TokuUserStatus;", "telephony-no-op_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FakeTokuServiceImpl implements TokuService {
    public void call(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, CardTokenizationPlugin.ARG_NUMBER_KEY);
    }

    @Nullable
    public CharSequence getSoftphoneLogs() {
        return null;
    }

    public void init(@NotNull String str, @NotNull String str2, boolean z11) {
        Intrinsics.checkNotNullParameter(str, "licenseKey");
        Intrinsics.checkNotNullParameter(str2, "userId");
    }

    public boolean isVoIPPushMessage(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "messageData");
        return false;
    }

    public void onPushNotificationReceived(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "messageData");
    }

    public void stop() {
    }

    public void updateUserStatus(@NotNull String str, @NotNull TokuUserStatus tokuUserStatus) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(tokuUserStatus, "userStatus");
    }
}
