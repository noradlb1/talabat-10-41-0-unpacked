package com.talabat.offering.domain.usecases.business;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\bf\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&J(\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005H&J0\u0010\n\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H&J0\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H&J8\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H&J8\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u0005H&J0\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H&J0\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H&¨\u0006\u0013"}, d2 = {"Lcom/talabat/offering/domain/usecases/business/TrackSubscriptionVerificationUseCase;", "", "trackMobileVerificationCancelled", "", "channel", "", "eventOrigin", "screenName", "screenType", "trackMobileVerificationClicked", "trackMobileVerificationCodeExpired", "subscriptionType", "trackMobileVerificationCodeResend", "trackMobileVerificationContinued", "mobileVerificationStatus", "trackMobileVerificationErrorShown", "failReason", "trackMobileVerificationStarted", "trackMobileVerificationValidated", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TrackSubscriptionVerificationUseCase {
    void trackMobileVerificationCancelled(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4);

    void trackMobileVerificationClicked(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4);

    void trackMobileVerificationCodeExpired(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5);

    void trackMobileVerificationCodeResend(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5);

    void trackMobileVerificationContinued(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6);

    void trackMobileVerificationErrorShown(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5, @NotNull String str6);

    void trackMobileVerificationStarted(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5);

    void trackMobileVerificationValidated(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, @NotNull String str5);
}
