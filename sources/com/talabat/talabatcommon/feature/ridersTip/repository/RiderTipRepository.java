package com.talabat.talabatcommon.feature.ridersTip.repository;

import com.talabat.talabatcommon.feature.ridersTip.model.RiderPaymentRequestModel;
import com.talabat.talabatcommon.feature.ridersTip.model.RiderTipPaymentResponse;
import com.talabat.talabatcommon.feature.ridersTip.model.RiderTipSuggestedAmountResponse;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\t0\u00032\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/repository/RiderTipRepository;", "", "getRiderTipSuggestedAmount", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/talabatcommon/feature/ridersTip/model/RiderTipSuggestedAmountResponse;", "country", "", "payRiderTip", "Lcom/talabat/talabatcommon/feature/ridersTip/model/RiderTipPaymentResponse;", "riderPaymentRequestModel", "Lcom/talabat/talabatcommon/feature/ridersTip/model/RiderPaymentRequestModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RiderTipRepository {
    @NotNull
    Either<Failure, RiderTipSuggestedAmountResponse> getRiderTipSuggestedAmount(int i11);

    @NotNull
    Either<Failure, RiderTipPaymentResponse> payRiderTip(@NotNull RiderPaymentRequestModel riderPaymentRequestModel);
}
