package com.talabat.talabatcommon.feature.ridersTip.network;

import com.talabat.core.network.network.TalabatAPIBuilder;
import com.talabat.talabatcommon.feature.ridersTip.model.RiderPaymentRequestModel;
import com.talabat.talabatcommon.feature.ridersTip.model.RiderTipPaymentResponse;
import com.talabat.talabatcommon.feature.ridersTip.model.RiderTipSuggestedAmountResponse;
import com.talabat.talabatcommon.feature.ridersTip.network.RiderTipApi;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import retrofit2.Call;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0016J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u000e2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0013\u001a\u00020\u0011H\u0016R\u001b\u0010\u0005\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u00018BX\u0002¢\u0006\f\n\u0004\b\f\u0010\t\u001a\u0004\b\u000b\u0010\u0007¨\u0006\u0018"}, d2 = {"Lcom/talabat/talabatcommon/feature/ridersTip/network/RiderTipService;", "Lcom/talabat/talabatcommon/feature/ridersTip/network/RiderTipApi;", "talabatAPIBuilder", "Lcom/talabat/core/network/network/TalabatAPIBuilder;", "(Lcom/talabat/core/network/network/TalabatAPIBuilder;)V", "riderTipPaymentApi", "getRiderTipPaymentApi", "()Lcom/talabat/talabatcommon/feature/ridersTip/network/RiderTipApi;", "riderTipPaymentApi$delegate", "Lkotlin/Lazy;", "riderTipSuggestedAmountApi", "getRiderTipSuggestedAmountApi", "riderTipSuggestedAmountApi$delegate", "getRiderTipSuggestedAmount", "Lretrofit2/Call;", "Lcom/talabat/talabatcommon/feature/ridersTip/model/RiderTipSuggestedAmountResponse;", "country", "", "version", "countryQueryId", "payRiderTip", "Lcom/talabat/talabatcommon/feature/ridersTip/model/RiderTipPaymentResponse;", "riderPaymentRequestModel", "Lcom/talabat/talabatcommon/feature/ridersTip/model/RiderPaymentRequestModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class RiderTipService implements RiderTipApi {
    @NotNull
    private final Lazy riderTipPaymentApi$delegate;
    @NotNull
    private final Lazy riderTipSuggestedAmountApi$delegate;

    public RiderTipService(@NotNull TalabatAPIBuilder talabatAPIBuilder) {
        Intrinsics.checkNotNullParameter(talabatAPIBuilder, "talabatAPIBuilder");
        LazyThreadSafetyMode lazyThreadSafetyMode = LazyThreadSafetyMode.NONE;
        this.riderTipSuggestedAmountApi$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new RiderTipService$riderTipSuggestedAmountApi$2(talabatAPIBuilder));
        this.riderTipPaymentApi$delegate = LazyKt__LazyJVMKt.lazy(lazyThreadSafetyMode, new RiderTipService$riderTipPaymentApi$2(talabatAPIBuilder));
    }

    private final RiderTipApi getRiderTipPaymentApi() {
        return (RiderTipApi) this.riderTipPaymentApi$delegate.getValue();
    }

    private final RiderTipApi getRiderTipSuggestedAmountApi() {
        return (RiderTipApi) this.riderTipSuggestedAmountApi$delegate.getValue();
    }

    @NotNull
    public Call<RiderTipSuggestedAmountResponse> getRiderTipSuggestedAmount(int i11, int i12, int i13) {
        return RiderTipApi.DefaultImpls.getRiderTipSuggestedAmount$default(getRiderTipSuggestedAmountApi(), i11, 0, 0, 6, (Object) null);
    }

    @NotNull
    public Call<RiderTipPaymentResponse> payRiderTip(@NotNull RiderPaymentRequestModel riderPaymentRequestModel, int i11) {
        Intrinsics.checkNotNullParameter(riderPaymentRequestModel, "riderPaymentRequestModel");
        return RiderTipApi.DefaultImpls.payRiderTip$default(getRiderTipPaymentApi(), riderPaymentRequestModel, 0, 2, (Object) null);
    }
}
