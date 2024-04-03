package com.talabat.wallet.features.walletCardList.repository;

import com.talabat.talabatcommon.feature.walletCardList.model.response.WalletCreditCardGetListResponse;
import com.talabat.talabatcommon.model.wallet.WalletCardListDisplayModel;
import com.talabat.talabatcommon.model.wallet.WalletCardListMapper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/talabatcommon/model/wallet/WalletCardListDisplayModel;", "it", "Lcom/talabat/talabatcommon/feature/walletCardList/model/response/WalletCreditCardGetListResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class WalletCardListRepositoryImpl$getWalletCardList$1 extends Lambda implements Function1<WalletCreditCardGetListResponse, WalletCardListDisplayModel> {
    public static final WalletCardListRepositoryImpl$getWalletCardList$1 INSTANCE = new WalletCardListRepositoryImpl$getWalletCardList$1();

    public WalletCardListRepositoryImpl$getWalletCardList$1() {
        super(1);
    }

    @NotNull
    public final WalletCardListDisplayModel invoke(@NotNull WalletCreditCardGetListResponse walletCreditCardGetListResponse) {
        Intrinsics.checkNotNullParameter(walletCreditCardGetListResponse, "it");
        return WalletCardListMapper.Companion.mapWalletCardListResponse(walletCreditCardGetListResponse);
    }
}
