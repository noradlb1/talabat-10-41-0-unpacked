package com.talabat.talabatcommon.model.wallet;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00032\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/talabat/talabatcommon/model/wallet/WalletBannerDisplayModel;", "", "shouldShowBanner", "", "bannerName", "", "bannerImageUrl", "deepLink", "(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBannerImageUrl", "()Ljava/lang/String;", "getBannerName", "getDeepLink", "getShouldShowBanner", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletBannerDisplayModel {
    @NotNull
    private final String bannerImageUrl;
    @NotNull
    private final String bannerName;
    @NotNull
    private final String deepLink;
    private final boolean shouldShowBanner;

    public WalletBannerDisplayModel(boolean z11, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "bannerName");
        Intrinsics.checkNotNullParameter(str2, "bannerImageUrl");
        Intrinsics.checkNotNullParameter(str3, "deepLink");
        this.shouldShowBanner = z11;
        this.bannerName = str;
        this.bannerImageUrl = str2;
        this.deepLink = str3;
    }

    public static /* synthetic */ WalletBannerDisplayModel copy$default(WalletBannerDisplayModel walletBannerDisplayModel, boolean z11, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = walletBannerDisplayModel.shouldShowBanner;
        }
        if ((i11 & 2) != 0) {
            str = walletBannerDisplayModel.bannerName;
        }
        if ((i11 & 4) != 0) {
            str2 = walletBannerDisplayModel.bannerImageUrl;
        }
        if ((i11 & 8) != 0) {
            str3 = walletBannerDisplayModel.deepLink;
        }
        return walletBannerDisplayModel.copy(z11, str, str2, str3);
    }

    public final boolean component1() {
        return this.shouldShowBanner;
    }

    @NotNull
    public final String component2() {
        return this.bannerName;
    }

    @NotNull
    public final String component3() {
        return this.bannerImageUrl;
    }

    @NotNull
    public final String component4() {
        return this.deepLink;
    }

    @NotNull
    public final WalletBannerDisplayModel copy(boolean z11, @NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "bannerName");
        Intrinsics.checkNotNullParameter(str2, "bannerImageUrl");
        Intrinsics.checkNotNullParameter(str3, "deepLink");
        return new WalletBannerDisplayModel(z11, str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WalletBannerDisplayModel)) {
            return false;
        }
        WalletBannerDisplayModel walletBannerDisplayModel = (WalletBannerDisplayModel) obj;
        return this.shouldShowBanner == walletBannerDisplayModel.shouldShowBanner && Intrinsics.areEqual((Object) this.bannerName, (Object) walletBannerDisplayModel.bannerName) && Intrinsics.areEqual((Object) this.bannerImageUrl, (Object) walletBannerDisplayModel.bannerImageUrl) && Intrinsics.areEqual((Object) this.deepLink, (Object) walletBannerDisplayModel.deepLink);
    }

    @NotNull
    public final String getBannerImageUrl() {
        return this.bannerImageUrl;
    }

    @NotNull
    public final String getBannerName() {
        return this.bannerName;
    }

    @NotNull
    public final String getDeepLink() {
        return this.deepLink;
    }

    public final boolean getShouldShowBanner() {
        return this.shouldShowBanner;
    }

    public int hashCode() {
        boolean z11 = this.shouldShowBanner;
        if (z11) {
            z11 = true;
        }
        return ((((((z11 ? 1 : 0) * true) + this.bannerName.hashCode()) * 31) + this.bannerImageUrl.hashCode()) * 31) + this.deepLink.hashCode();
    }

    @NotNull
    public String toString() {
        boolean z11 = this.shouldShowBanner;
        String str = this.bannerName;
        String str2 = this.bannerImageUrl;
        String str3 = this.deepLink;
        return "WalletBannerDisplayModel(shouldShowBanner=" + z11 + ", bannerName=" + str + ", bannerImageUrl=" + str2 + ", deepLink=" + str3 + ")";
    }
}
