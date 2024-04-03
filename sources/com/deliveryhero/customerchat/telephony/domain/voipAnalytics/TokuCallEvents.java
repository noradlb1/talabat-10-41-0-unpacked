package com.deliveryhero.customerchat.telephony.domain.voipAnalytics;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J(\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005H&J(\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H&J(\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u0005H&J(\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H&J(\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0005H&J \u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J(\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0005H&J \u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H&J\u0010\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u0016\u001a\u00020\u0017H&¨\u0006\u0018"}, d2 = {"Lcom/deliveryhero/customerchat/telephony/domain/voipAnalytics/TokuCallEvents;", "", "inAppCallCancelled", "", "callID", "", "duration", "remoteUsername", "inAppCallEnded", "endCallReason", "inAppCallErrorCaused", "errorMessage", "inAppCallMuteButtonClicked", "buttonState", "inAppCallPickedUp", "source", "inAppCallRejected", "inAppCallRingStarted", "inAppCallSpeakerButtonClicked", "buttonToggleState", "inAppCallTimedOut", "inAppCallUserRegistered", "result", "Lcom/deliveryhero/customerchat/telephony/domain/voipAnalytics/CallRegistrationStatus;", "telephony_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TokuCallEvents {
    void inAppCallCancelled(@NotNull String str, @NotNull String str2, @NotNull String str3);

    void inAppCallEnded(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4);

    void inAppCallErrorCaused(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4);

    void inAppCallMuteButtonClicked(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4);

    void inAppCallPickedUp(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4);

    void inAppCallRejected(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4);

    void inAppCallRingStarted(@NotNull String str, @NotNull String str2, @NotNull String str3);

    void inAppCallSpeakerButtonClicked(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4);

    void inAppCallTimedOut(@NotNull String str, @NotNull String str2, @NotNull String str3);

    void inAppCallUserRegistered(@NotNull CallRegistrationStatus callRegistrationStatus);
}
