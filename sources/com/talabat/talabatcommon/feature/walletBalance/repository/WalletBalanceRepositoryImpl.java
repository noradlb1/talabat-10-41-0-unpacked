package com.talabat.talabatcommon.feature.walletBalance.repository;

import com.talabat.configuration.location.LocationConfigurationRepository;
import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcommon.feature.walletBalance.model.response.WalletCreditBalanceResponse;
import com.talabat.talabatcommon.feature.walletBalance.model.response.WalletCreditBalanceResultModel;
import com.talabat.talabatcommon.feature.walletBalance.network.WalletBalanceService;
import com.talabat.talabatcommon.model.wallet.WalletBalanceDisplayModel;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.platform.NetworkHandler;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001c\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletBalance/repository/WalletBalanceRepositoryImpl;", "Lcom/talabat/talabatcommon/feature/walletBalance/repository/WalletBalanceRepository;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "walletBalanceService", "Lcom/talabat/talabatcommon/feature/walletBalance/network/WalletBalanceService;", "locationConfigurationRepository", "Lcom/talabat/configuration/location/LocationConfigurationRepository;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/talabatcommon/feature/walletBalance/network/WalletBalanceService;Lcom/talabat/configuration/location/LocationConfigurationRepository;)V", "getWalletBalance", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/talabatcommon/model/wallet/WalletBalanceDisplayModel;", "country", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletBalanceRepositoryImpl implements WalletBalanceRepository {
    /* access modifiers changed from: private */
    @NotNull
    public final LocationConfigurationRepository locationConfigurationRepository;
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull
    private final WalletBalanceService walletBalanceService;

    public WalletBalanceRepositoryImpl(@NotNull NetworkHandler networkHandler2, @NotNull WalletBalanceService walletBalanceService2, @NotNull LocationConfigurationRepository locationConfigurationRepository2) {
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(walletBalanceService2, "walletBalanceService");
        Intrinsics.checkNotNullParameter(locationConfigurationRepository2, "locationConfigurationRepository");
        this.networkHandler = networkHandler2;
        this.walletBalanceService = walletBalanceService2;
        this.locationConfigurationRepository = locationConfigurationRepository2;
    }

    @NotNull
    public Either<Failure, WalletBalanceDisplayModel> getWalletBalance(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "country");
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(this.walletBalanceService.getWalletBalance(str), new WalletBalanceRepositoryImpl$getWalletBalance$1(this), new WalletCreditBalanceResponse((WalletCreditBalanceResultModel) null, (ArrayList) null, 3, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
