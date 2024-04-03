package com.deliveryhero.customerchat.telephony.domain;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\"\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\fH&J\u001c\u0010\r\u001a\u00020\f2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000fH&J\u001c\u0010\u0010\u001a\u00020\u00032\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u000fH&J\b\u0010\u0011\u001a\u00020\u0003H&J\u0018\u0010\u0012\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H&¨\u0006\u0015"}, d2 = {"Lcom/deliveryhero/customerchat/telephony/domain/TokuService;", "", "call", "", "number", "", "getSoftphoneLogs", "", "init", "licenseKey", "userId", "enableVoipLogging", "", "isVoIPPushMessage", "messageData", "", "onPushNotificationReceived", "stop", "updateUserStatus", "userStatus", "Lcom/deliveryhero/customerchat/telephony/domain/TokuUserStatus;", "telephony_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TokuService {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void init$default(TokuService tokuService, String str, String str2, boolean z11, int i11, Object obj) {
            if (obj == null) {
                if ((i11 & 4) != 0) {
                    z11 = false;
                }
                tokuService.init(str, str2, z11);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: init");
        }
    }

    void call(@NotNull String str);

    @Nullable
    CharSequence getSoftphoneLogs();

    void init(@NotNull String str, @NotNull String str2, boolean z11);

    boolean isVoIPPushMessage(@NotNull Map<String, String> map);

    void onPushNotificationReceived(@NotNull Map<String, String> map);

    void stop();

    void updateUserStatus(@NotNull String str, @NotNull TokuUserStatus tokuUserStatus);
}
