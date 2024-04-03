package com.talabat.wallet.knetStatusManager.presentation.viewmodel.mapper;

import com.talabat.wallet.knetStatusManager.domain.entity.KNetStatusResult;
import com.talabat.wallet.knetStatusManager.presentation.displaymodel.KNetStatusDisplayModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/knetStatusManager/presentation/viewmodel/mapper/KNetStatusDisplayModelMapper;", "", "()V", "mapToKNetStatusDisplayModel", "Lcom/talabat/wallet/knetStatusManager/presentation/displaymodel/KNetStatusDisplayModel;", "kNetStatusResult", "Lcom/talabat/wallet/knetStatusManager/domain/entity/KNetStatusResult;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class KNetStatusDisplayModelMapper {
    @NotNull
    public static final KNetStatusDisplayModelMapper INSTANCE = new KNetStatusDisplayModelMapper();

    private KNetStatusDisplayModelMapper() {
    }

    @NotNull
    public final KNetStatusDisplayModel mapToKNetStatusDisplayModel(@Nullable KNetStatusResult kNetStatusResult) {
        if (kNetStatusResult instanceof KNetStatusResult.UnAvailableKNetCheck) {
            return KNetStatusDisplayModel.ShowDefaultPaymentScreen.INSTANCE;
        }
        if (kNetStatusResult instanceof KNetStatusResult.KNetIsAvailable) {
            return KNetStatusDisplayModel.ShowKNetPaymentOption.INSTANCE;
        }
        if (kNetStatusResult instanceof KNetStatusResult.KNetIsUnAvailable) {
            return KNetStatusDisplayModel.ShowKNetUnAvailableView.INSTANCE;
        }
        return KNetStatusDisplayModel.Loading.INSTANCE;
    }
}
