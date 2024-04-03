package com.talabat.feature.walletcobrandedcc.data.remote;

import com.talabat.feature.walletcobrandedcc.data.remote.WalletStatusResponse;
import com.talabat.feature.walletcobrandedcc.domain.model.WalletStatus;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0003"}, d2 = {"toEntity", "Lcom/talabat/feature/walletcobrandedcc/domain/model/WalletStatus;", "Lcom/talabat/feature/walletcobrandedcc/data/remote/WalletStatusResponse;", "com_talabat_feature_wallet-cobranded-cc_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class WalletStatusResponseKt {
    @NotNull
    public static final WalletStatus toEntity(@Nullable WalletStatusResponse walletStatusResponse) {
        boolean z11;
        String str;
        String str2;
        WalletStatusResponse.Result result;
        WalletStatusResponse.Result result2;
        WalletStatusResponse.Result result3;
        if (walletStatusResponse == null || (result3 = walletStatusResponse.getResult()) == null) {
            z11 = false;
        } else {
            z11 = result3.getShouldShowNotification();
        }
        if (walletStatusResponse == null || (result2 = walletStatusResponse.getResult()) == null || (str = result2.getText()) == null) {
            str = "";
        }
        if (walletStatusResponse == null || (result = walletStatusResponse.getResult()) == null || (str2 = result.getStyle()) == null) {
            str2 = "normal";
        }
        return new WalletStatus(z11, str, str2);
    }
}
