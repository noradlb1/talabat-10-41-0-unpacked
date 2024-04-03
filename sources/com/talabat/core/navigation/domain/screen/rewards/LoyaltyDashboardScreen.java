package com.talabat.core.navigation.domain.screen.rewards;

import android.os.Parcel;
import android.os.Parcelable;
import com.talabat.core.navigation.domain.screen.Screen;
import com.talabat.helpcenter.presentation.webview.GlobalHelpCenterWebViewActivity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.parcelize.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u000b\fB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0003\u001a\u00020\u0002X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bXD¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/rewards/LoyaltyDashboardScreen;", "Lcom/talabat/core/navigation/domain/screen/Screen;", "Lcom/talabat/core/navigation/domain/screen/rewards/LoyaltyDashboardScreen$LoyaltyDashboardData;", "data", "(Lcom/talabat/core/navigation/domain/screen/rewards/LoyaltyDashboardScreen$LoyaltyDashboardData;)V", "getData", "()Lcom/talabat/core/navigation/domain/screen/rewards/LoyaltyDashboardScreen$LoyaltyDashboardData;", "link", "", "getLink", "()Ljava/lang/String;", "LoyaltyDashboardData", "RewardsCatalogueOrigin", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyDashboardScreen implements Screen<LoyaltyDashboardData> {
    @NotNull
    private final LoyaltyDashboardData data;
    @NotNull
    private final String link = "talabat.action.Growth.loyalty.dashboard";

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\t\u0010\t\u001a\u00020\nHÖ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\nHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\nHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/rewards/LoyaltyDashboardScreen$LoyaltyDashboardData;", "Landroid/os/Parcelable;", "rewardsCatalogueOrigin", "", "(Ljava/lang/String;)V", "getRewardsCatalogueOrigin", "()Ljava/lang/String;", "component1", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Parcelize
    public static final class LoyaltyDashboardData implements Parcelable {
        @NotNull
        public static final Parcelable.Creator<LoyaltyDashboardData> CREATOR = new Creator();
        @NotNull
        private final String rewardsCatalogueOrigin;

        @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
        public static final class Creator implements Parcelable.Creator<LoyaltyDashboardData> {
            @NotNull
            public final LoyaltyDashboardData createFromParcel(@NotNull Parcel parcel) {
                Intrinsics.checkNotNullParameter(parcel, "parcel");
                return new LoyaltyDashboardData(parcel.readString());
            }

            @NotNull
            public final LoyaltyDashboardData[] newArray(int i11) {
                return new LoyaltyDashboardData[i11];
            }
        }

        public LoyaltyDashboardData(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "rewardsCatalogueOrigin");
            this.rewardsCatalogueOrigin = str;
        }

        public static /* synthetic */ LoyaltyDashboardData copy$default(LoyaltyDashboardData loyaltyDashboardData, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = loyaltyDashboardData.rewardsCatalogueOrigin;
            }
            return loyaltyDashboardData.copy(str);
        }

        @NotNull
        public final String component1() {
            return this.rewardsCatalogueOrigin;
        }

        @NotNull
        public final LoyaltyDashboardData copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "rewardsCatalogueOrigin");
            return new LoyaltyDashboardData(str);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof LoyaltyDashboardData) && Intrinsics.areEqual((Object) this.rewardsCatalogueOrigin, (Object) ((LoyaltyDashboardData) obj).rewardsCatalogueOrigin);
        }

        @NotNull
        public final String getRewardsCatalogueOrigin() {
            return this.rewardsCatalogueOrigin;
        }

        public int hashCode() {
            return this.rewardsCatalogueOrigin.hashCode();
        }

        @NotNull
        public String toString() {
            String str = this.rewardsCatalogueOrigin;
            return "LoyaltyDashboardData(rewardsCatalogueOrigin=" + str + ")";
        }

        public void writeToParcel(@NotNull Parcel parcel, int i11) {
            Intrinsics.checkNotNullParameter(parcel, "out");
            parcel.writeString(this.rewardsCatalogueOrigin);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/rewards/LoyaltyDashboardScreen$RewardsCatalogueOrigin;", "", "eventOrigin", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getEventOrigin", "()Ljava/lang/String;", "CRM", "ORDER_TRACKING", "HOME", "ACCOUNT", "REDEEM_VOUCHER", "OTHER", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum RewardsCatalogueOrigin {
        CRM("crm"),
        ORDER_TRACKING(GlobalHelpCenterWebViewActivity.ORDER_TRACKING),
        HOME("home"),
        ACCOUNT("account"),
        REDEEM_VOUCHER("redeem_voucher"),
        OTHER("other");
        
        @NotNull
        private final String eventOrigin;

        private RewardsCatalogueOrigin(String str) {
            this.eventOrigin = str;
        }

        @NotNull
        public final String getEventOrigin() {
            return this.eventOrigin;
        }
    }

    public LoyaltyDashboardScreen(@NotNull LoyaltyDashboardData loyaltyDashboardData) {
        Intrinsics.checkNotNullParameter(loyaltyDashboardData, "data");
        this.data = loyaltyDashboardData;
    }

    @NotNull
    public String getLink() {
        return this.link;
    }

    @NotNull
    public LoyaltyDashboardData getData() {
        return this.data;
    }
}
