package com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.application.usecase;

import com.talabat.talabatcommon.feature.ridersTip.orderconfirmation.domain.repository.TipRiderStateRepository;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/application/usecase/SetTipRiderStatusUseCase;", "", "tipRiderStateRepository", "Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/repository/TipRiderStateRepository;", "(Lcom/talabat/talabatcommon/feature/ridersTip/orderconfirmation/domain/repository/TipRiderStateRepository;)V", "invoke", "", "encryptedOrderId", "", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SetTipRiderStatusUseCase {
    @NotNull
    private final TipRiderStateRepository tipRiderStateRepository;

    public SetTipRiderStatusUseCase(@NotNull TipRiderStateRepository tipRiderStateRepository2) {
        Intrinsics.checkNotNullParameter(tipRiderStateRepository2, "tipRiderStateRepository");
        this.tipRiderStateRepository = tipRiderStateRepository2;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "encryptedOrderId");
        this.tipRiderStateRepository.setTipRiderStatus(str);
    }
}
