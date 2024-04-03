package com.talabat.userandlocation.compliance.verification.domain.tracker;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\b\u0010\u0005\u001a\u00020\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\bH&¨\u0006\t"}, d2 = {"Lcom/talabat/userandlocation/compliance/verification/domain/tracker/ComplianceVerificationTracker;", "", "trackContinueToCheckout", "", "trackExistingAccountVerificationScreenOpened", "trackNewAccountVerificationScreenOpened", "trackUserBlocked", "message", "", "com_talabat_NewArchi_UserAndLocation_Compliance_Compliance"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ComplianceVerificationTracker {
    void trackContinueToCheckout();

    void trackExistingAccountVerificationScreenOpened();

    void trackNewAccountVerificationScreenOpened();

    void trackUserBlocked(@NotNull String str);
}
