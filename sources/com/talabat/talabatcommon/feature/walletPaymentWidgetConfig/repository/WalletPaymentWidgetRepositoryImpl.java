package com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.repository;

import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.model.WalletPaymentWidgetConfigResponse;
import com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.model.WalletPaymentWidgetConfigResult;
import com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.network.WalletPaymentWidgetConfigApi;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.platform.NetworkHandler;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J,\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/repository/WalletPaymentWidgetRepositoryImpl;", "Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/repository/WalletPaymentWidgetRepository;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "walletPaymentWidgetConfigApi", "Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/network/WalletPaymentWidgetConfigApi;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/network/WalletPaymentWidgetConfigApi;)V", "getWalletPaymentWidgetConfig", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/model/WalletPaymentWidgetConfigResponse;", "country", "", "componentId", "featureId", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WalletPaymentWidgetRepositoryImpl implements WalletPaymentWidgetRepository {
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull
    private final WalletPaymentWidgetConfigApi walletPaymentWidgetConfigApi;

    public WalletPaymentWidgetRepositoryImpl(@NotNull NetworkHandler networkHandler2, @NotNull WalletPaymentWidgetConfigApi walletPaymentWidgetConfigApi2) {
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(walletPaymentWidgetConfigApi2, "walletPaymentWidgetConfigApi");
        this.networkHandler = networkHandler2;
        this.walletPaymentWidgetConfigApi = walletPaymentWidgetConfigApi2;
    }

    @NotNull
    public Either<Failure, WalletPaymentWidgetConfigResponse> getWalletPaymentWidgetConfig(int i11, int i12, int i13) {
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(this.walletPaymentWidgetConfigApi.getWalletPaymentWidgetConfig(i11, i12, i13), WalletPaymentWidgetRepositoryImpl$getWalletPaymentWidgetConfig$1.INSTANCE, new WalletPaymentWidgetConfigResponse((WalletPaymentWidgetConfigResult) null, (List) null, 3, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
