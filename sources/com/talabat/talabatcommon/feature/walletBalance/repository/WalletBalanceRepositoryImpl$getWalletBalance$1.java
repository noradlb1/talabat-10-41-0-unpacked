package com.talabat.talabatcommon.feature.walletBalance.repository;

import com.talabat.talabatcommon.feature.walletBalance.model.response.WalletCreditBalanceResponse;
import com.talabat.talabatcommon.model.wallet.WalletBalanceDisplayModel;
import com.talabat.talabatcommon.model.wallet.WalletBalanceMapper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/talabatcommon/model/wallet/WalletBalanceDisplayModel;", "it", "Lcom/talabat/talabatcommon/feature/walletBalance/model/response/WalletCreditBalanceResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class WalletBalanceRepositoryImpl$getWalletBalance$1 extends Lambda implements Function1<WalletCreditBalanceResponse, WalletBalanceDisplayModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ WalletBalanceRepositoryImpl f61695g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletBalanceRepositoryImpl$getWalletBalance$1(WalletBalanceRepositoryImpl walletBalanceRepositoryImpl) {
        super(1);
        this.f61695g = walletBalanceRepositoryImpl;
    }

    @NotNull
    public final WalletBalanceDisplayModel invoke(@NotNull WalletCreditBalanceResponse walletCreditBalanceResponse) {
        Intrinsics.checkNotNullParameter(walletCreditBalanceResponse, "it");
        return WalletBalanceMapper.Companion.mapWalletBalanceResponse(walletCreditBalanceResponse, this.f61695g.locationConfigurationRepository);
    }
}
