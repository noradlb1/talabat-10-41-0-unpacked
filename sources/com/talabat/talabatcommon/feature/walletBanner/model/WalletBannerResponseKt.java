package com.talabat.talabatcommon.feature.walletBanner.model;

import com.talabat.talabatcommon.model.wallet.WalletBannerDisplayModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0003"}, d2 = {"toDisplayModel", "Lcom/talabat/talabatcommon/model/wallet/WalletBannerDisplayModel;", "Lcom/talabat/talabatcommon/feature/walletBanner/model/WalletBannerResponse;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class WalletBannerResponseKt {
    @NotNull
    public static final WalletBannerDisplayModel toDisplayModel(@Nullable WalletBannerResponse walletBannerResponse) {
        boolean z11;
        String str;
        String str2;
        WalletBannerResult result;
        String deepLink;
        WalletBannerResult result2;
        WalletBannerResult result3;
        WalletBannerResult result4;
        if (walletBannerResponse == null || (result4 = walletBannerResponse.getResult()) == null) {
            z11 = false;
        } else {
            z11 = result4.getShouldShowBanner();
        }
        if (walletBannerResponse == null || (result3 = walletBannerResponse.getResult()) == null || (str = result3.getBannerName()) == null) {
            str = "no_banner";
        }
        String str3 = "";
        if (walletBannerResponse == null || (result2 = walletBannerResponse.getResult()) == null || (str2 = result2.getBannerUrl()) == null) {
            str2 = str3;
        }
        if (!(walletBannerResponse == null || (result = walletBannerResponse.getResult()) == null || (deepLink = result.getDeepLink()) == null)) {
            str3 = deepLink;
        }
        return new WalletBannerDisplayModel(z11, str, str2, str3);
    }
}
