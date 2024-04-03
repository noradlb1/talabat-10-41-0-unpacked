package com.talabat.wallet.qPayManager.presentation.viewmodel.mapper;

import com.talabat.wallet.qPayManager.domain.entity.QPayStatus;
import com.talabat.wallet.qPayManager.presentation.displaymodel.QPayMixedPaymentDisplayModel;
import com.talabat.wallet.qPayManager.presentation.displaymodel.QPayStatusDisplayModel;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/wallet/qPayManager/presentation/viewmodel/mapper/QPayManagerDisplayModelMapper;", "", "()V", "mapToQPayMixedPaymentDisplayModel", "Lcom/talabat/wallet/qPayManager/presentation/displaymodel/QPayMixedPaymentDisplayModel;", "isQPayMixedPayment", "", "mapToQPayStatusDisplayModel", "Lcom/talabat/wallet/qPayManager/presentation/displaymodel/QPayStatusDisplayModel;", "qPayStatus", "Lcom/talabat/wallet/qPayManager/domain/entity/QPayStatus;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QPayManagerDisplayModelMapper {
    @NotNull
    public static final QPayManagerDisplayModelMapper INSTANCE = new QPayManagerDisplayModelMapper();

    private QPayManagerDisplayModelMapper() {
    }

    @NotNull
    public final QPayMixedPaymentDisplayModel mapToQPayMixedPaymentDisplayModel(boolean z11) {
        if (z11) {
            return QPayMixedPaymentDisplayModel.ProceedWithQPayMixedPayment.INSTANCE;
        }
        return QPayMixedPaymentDisplayModel.ProceedWithDefaultMixedPayment.INSTANCE;
    }

    @NotNull
    public final QPayStatusDisplayModel mapToQPayStatusDisplayModel(@Nullable QPayStatus qPayStatus) {
        if (qPayStatus instanceof QPayStatus.QPayIsAvailable) {
            return QPayStatusDisplayModel.ShowQPayPaymentOption.INSTANCE;
        }
        return QPayStatusDisplayModel.HideQPayPaymentOption.INSTANCE;
    }
}
