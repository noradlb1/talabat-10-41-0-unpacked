package com.talabat.wallet.features.walletonboarding.repository;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000b\u001a\u00020\fHÖ\u0001J\t\u0010\r\u001a\u00020\u000eHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/talabat/wallet/features/walletonboarding/repository/UserPreferences;", "", "wasWalletOnboardingShown", "", "(Z)V", "getWasWalletOnboardingShown", "()Z", "component1", "copy", "equals", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UserPreferences {
    private final boolean wasWalletOnboardingShown;

    public UserPreferences(boolean z11) {
        this.wasWalletOnboardingShown = z11;
    }

    public static /* synthetic */ UserPreferences copy$default(UserPreferences userPreferences, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = userPreferences.wasWalletOnboardingShown;
        }
        return userPreferences.copy(z11);
    }

    public final boolean component1() {
        return this.wasWalletOnboardingShown;
    }

    @NotNull
    public final UserPreferences copy(boolean z11) {
        return new UserPreferences(z11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UserPreferences) && this.wasWalletOnboardingShown == ((UserPreferences) obj).wasWalletOnboardingShown;
    }

    public final boolean getWasWalletOnboardingShown() {
        return this.wasWalletOnboardingShown;
    }

    public int hashCode() {
        boolean z11 = this.wasWalletOnboardingShown;
        if (z11) {
            return 1;
        }
        return z11 ? 1 : 0;
    }

    @NotNull
    public String toString() {
        boolean z11 = this.wasWalletOnboardingShown;
        return "UserPreferences(wasWalletOnboardingShown=" + z11 + ")";
    }
}
