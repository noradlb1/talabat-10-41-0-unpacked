package com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.repository;

import com.talabat.talabatcommon.feature.walletPaymentWidgetConfig.model.WalletPaymentWidgetConfigResponse;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J,\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H&¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/repository/WalletPaymentWidgetRepository;", "", "getWalletPaymentWidgetConfig", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/talabatcommon/feature/walletPaymentWidgetConfig/model/WalletPaymentWidgetConfigResponse;", "country", "", "componentId", "featureId", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface WalletPaymentWidgetRepository {
    @NotNull
    Either<Failure, WalletPaymentWidgetConfigResponse> getWalletPaymentWidgetConfig(int i11, int i12, int i13);
}
