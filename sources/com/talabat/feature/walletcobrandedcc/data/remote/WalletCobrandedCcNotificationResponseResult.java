package com.talabat.feature.walletcobrandedcc.data.remote;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001a\u0010\t\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/walletcobrandedcc/data/remote/WalletCobrandedCcNotificationResponseResult;", "", "shouldNotifyUser", "", "(Ljava/lang/Boolean;)V", "getShouldNotifyUser", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "copy", "(Ljava/lang/Boolean;)Lcom/talabat/feature/walletcobrandedcc/data/remote/WalletCobrandedCcNotificationResponseResult;", "equals", "other", "hashCode", "", "toString", "", "com_talabat_feature_wallet-cobranded-cc_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletCobrandedCcNotificationResponseResult {
    @SerializedName("shouldShowRedDot")
    @Nullable
    private final Boolean shouldNotifyUser;

    public WalletCobrandedCcNotificationResponseResult(@Nullable Boolean bool) {
        this.shouldNotifyUser = bool;
    }

    public static /* synthetic */ WalletCobrandedCcNotificationResponseResult copy$default(WalletCobrandedCcNotificationResponseResult walletCobrandedCcNotificationResponseResult, Boolean bool, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            bool = walletCobrandedCcNotificationResponseResult.shouldNotifyUser;
        }
        return walletCobrandedCcNotificationResponseResult.copy(bool);
    }

    @Nullable
    public final Boolean component1() {
        return this.shouldNotifyUser;
    }

    @NotNull
    public final WalletCobrandedCcNotificationResponseResult copy(@Nullable Boolean bool) {
        return new WalletCobrandedCcNotificationResponseResult(bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof WalletCobrandedCcNotificationResponseResult) && Intrinsics.areEqual((Object) this.shouldNotifyUser, (Object) ((WalletCobrandedCcNotificationResponseResult) obj).shouldNotifyUser);
    }

    @Nullable
    public final Boolean getShouldNotifyUser() {
        return this.shouldNotifyUser;
    }

    public int hashCode() {
        Boolean bool = this.shouldNotifyUser;
        if (bool == null) {
            return 0;
        }
        return bool.hashCode();
    }

    @NotNull
    public String toString() {
        Boolean bool = this.shouldNotifyUser;
        return "WalletCobrandedCcNotificationResponseResult(shouldNotifyUser=" + bool + ")";
    }
}
