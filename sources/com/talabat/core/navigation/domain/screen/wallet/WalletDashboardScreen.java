package com.talabat.core.navigation.domain.screen.wallet;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.core.navigation.domain.screen.Screen;
import com.talabat.talabatnavigation.walletSquad.WalletNavigatorActions;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\f"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/wallet/WalletDashboardScreen;", "Lcom/talabat/core/navigation/domain/screen/Screen;", "Lcom/talabat/core/navigation/domain/screen/wallet/WalletDashboardScreen$WalletDashboardData;", "data", "(Lcom/talabat/core/navigation/domain/screen/wallet/WalletDashboardScreen$WalletDashboardData;)V", "getData", "()Lcom/talabat/core/navigation/domain/screen/wallet/WalletDashboardScreen$WalletDashboardData;", "link", "", "getLink", "()Ljava/lang/String;", "WalletDashboardData", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletDashboardScreen implements Screen<WalletDashboardData> {
    @NotNull
    private final WalletDashboardData data;
    @NotNull
    private final String link = WalletNavigatorActions.OPEN_WALLET_DASHBOARD_ACTIVITY;

    public WalletDashboardScreen(@NotNull WalletDashboardData walletDashboardData) {
        Intrinsics.checkNotNullParameter(walletDashboardData, "data");
        this.data = walletDashboardData;
    }

    @NotNull
    public String getLink() {
        return this.link;
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\nHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/wallet/WalletDashboardScreen$WalletDashboardData;", "Landroid/os/Parcelable;", "disableOpeningHomeForBackPressed", "", "(Z)V", "getDisableOpeningHomeForBackPressed", "()Z", "component1", "copy", "describeContents", "", "equals", "other", "", "hashCode", "toString", "", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Parcelize
    public static final class WalletDashboardData implements Parcelable {
        @NotNull
        public static final Parcelable.Creator<WalletDashboardData> CREATOR = new Creator();
        private final boolean disableOpeningHomeForBackPressed;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<WalletDashboardData> {
            @NotNull
            public final WalletDashboardData createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new WalletDashboardData(parcel.readInt() != 0);
            }

            @NotNull
            public final WalletDashboardData[] newArray(int i11) {
                return new WalletDashboardData[i11];
            }
        }

        public WalletDashboardData() {
            this(false, 1, (DefaultConstructorMarker) null);
        }

        public WalletDashboardData(boolean z11) {
            this.disableOpeningHomeForBackPressed = z11;
        }

        public static /* synthetic */ WalletDashboardData copy$default(WalletDashboardData walletDashboardData, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                z11 = walletDashboardData.disableOpeningHomeForBackPressed;
            }
            return walletDashboardData.copy(z11);
        }

        public final boolean component1() {
            return this.disableOpeningHomeForBackPressed;
        }

        @NotNull
        public final WalletDashboardData copy(boolean z11) {
            return new WalletDashboardData(z11);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof WalletDashboardData) && this.disableOpeningHomeForBackPressed == ((WalletDashboardData) obj).disableOpeningHomeForBackPressed;
        }

        public final boolean getDisableOpeningHomeForBackPressed() {
            return this.disableOpeningHomeForBackPressed;
        }

        public int hashCode() {
            boolean z11 = this.disableOpeningHomeForBackPressed;
            if (z11) {
                return 1;
            }
            return z11 ? 1 : 0;
        }

        @NotNull
        public String toString() {
            boolean z11 = this.disableOpeningHomeForBackPressed;
            return "WalletDashboardData(disableOpeningHomeForBackPressed=" + z11 + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeInt(this.disableOpeningHomeForBackPressed ? 1 : 0);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ WalletDashboardData(boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? true : z11);
        }
    }

    @NotNull
    public WalletDashboardData getData() {
        return this.data;
    }
}
