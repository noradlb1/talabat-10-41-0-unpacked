package com.talabat.feature.walletcobrandedcc.data.remote;

import com.talabat.feature.walletcobrandedcc.domain.model.CobrandedCcInProgressAppNotification;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u0002¨\u0006\u0003"}, d2 = {"toEntity", "Lcom/talabat/feature/walletcobrandedcc/domain/model/CobrandedCcInProgressAppNotification;", "Lcom/talabat/feature/walletcobrandedcc/data/remote/WalletCobrandedCcNotificationResponse;", "com_talabat_feature_wallet-cobranded-cc_data_data"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class WalletCobrandedCcNotificationResponseKt {
    @NotNull
    public static final CobrandedCcInProgressAppNotification toEntity(@Nullable WalletCobrandedCcNotificationResponse walletCobrandedCcNotificationResponse) {
        boolean z11;
        WalletCobrandedCcNotificationResponseResult walletCoBrandedResult;
        if (walletCobrandedCcNotificationResponse == null || (walletCoBrandedResult = walletCobrandedCcNotificationResponse.getWalletCoBrandedResult()) == null) {
            z11 = false;
        } else {
            z11 = Intrinsics.areEqual((Object) walletCoBrandedResult.getShouldNotifyUser(), (Object) Boolean.TRUE);
        }
        return new CobrandedCcInProgressAppNotification(z11);
    }
}
