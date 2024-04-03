package com.talabat.talabatcommon.feature.ridersTip.repository;

import com.talabat.talabatcommon.extentions.network.RequestKt;
import com.talabat.talabatcommon.feature.ridersTip.model.RiderPaymentRequestModel;
import com.talabat.talabatcommon.feature.ridersTip.model.RiderTipPaymentResponse;
import com.talabat.talabatcommon.feature.ridersTip.model.RiderTipPaymentResponseResult;
import com.talabat.talabatcommon.feature.ridersTip.model.RiderTipSuggestedAmountResponse;
import com.talabat.talabatcommon.feature.ridersTip.network.RiderTipApi;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import com.talabat.talabatcore.platform.NetworkHandler;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u001c\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001c\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/repository/RiderTipRepositoryImpl;", "Lcom/talabat/talabatcommon/feature/ridersTip/repository/RiderTipRepository;", "networkHandler", "Lcom/talabat/talabatcore/platform/NetworkHandler;", "riderTipService", "Lcom/talabat/talabatcommon/feature/ridersTip/network/RiderTipApi;", "(Lcom/talabat/talabatcore/platform/NetworkHandler;Lcom/talabat/talabatcommon/feature/ridersTip/network/RiderTipApi;)V", "getRiderTipSuggestedAmount", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/talabatcommon/feature/ridersTip/model/RiderTipSuggestedAmountResponse;", "country", "", "payRiderTip", "Lcom/talabat/talabatcommon/feature/ridersTip/model/RiderTipPaymentResponse;", "riderPaymentRequestModel", "Lcom/talabat/talabatcommon/feature/ridersTip/model/RiderPaymentRequestModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderTipRepositoryImpl implements RiderTipRepository {
    @NotNull
    private final NetworkHandler networkHandler;
    @NotNull
    private final RiderTipApi riderTipService;

    public RiderTipRepositoryImpl(@NotNull NetworkHandler networkHandler2, @NotNull RiderTipApi riderTipApi) {
        Intrinsics.checkNotNullParameter(networkHandler2, "networkHandler");
        Intrinsics.checkNotNullParameter(riderTipApi, "riderTipService");
        this.networkHandler = networkHandler2;
        this.riderTipService = riderTipApi;
    }

    @NotNull
    public Either<Failure, RiderTipSuggestedAmountResponse> getRiderTipSuggestedAmount(int i11) {
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(RiderTipApi.DefaultImpls.getRiderTipSuggestedAmount$default(this.riderTipService, i11, 0, 0, 6, (Object) null), RiderTipRepositoryImpl$getRiderTipSuggestedAmount$1.INSTANCE, new RiderTipSuggestedAmountResponse((List) null, 1, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }

    @NotNull
    public Either<Failure, RiderTipPaymentResponse> payRiderTip(@NotNull RiderPaymentRequestModel riderPaymentRequestModel) {
        Intrinsics.checkNotNullParameter(riderPaymentRequestModel, "riderPaymentRequestModel");
        boolean isConnected = this.networkHandler.isConnected();
        if (isConnected) {
            return RequestKt.request(RiderTipApi.DefaultImpls.payRiderTip$default(this.riderTipService, riderPaymentRequestModel, 0, 2, (Object) null), RiderTipRepositoryImpl$payRiderTip$1.INSTANCE, new RiderTipPaymentResponse((RiderTipPaymentResponseResult) null, 1, (DefaultConstructorMarker) null));
        }
        if (!isConnected) {
            return new Either.Left(Failure.NetworkConnection.INSTANCE);
        }
        throw new NoWhenBranchMatchedException();
    }
}
