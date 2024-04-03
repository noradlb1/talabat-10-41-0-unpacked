package com.talabat.talabatcommon.feature.ridersTip;

import com.talabat.talabatcommon.feature.ridersTip.model.RiderTipPaymentResponse;
import com.talabat.talabatcommon.views.ridersTip.model.RiderTipPaymentDisplayModel;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/talabatcommon/views/ridersTip/model/RiderTipPaymentDisplayModel;", "it", "Lcom/talabat/talabatcommon/feature/ridersTip/model/RiderTipPaymentResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GetRiderTipPaymentUseCase$run$2 extends Lambda implements Function1<RiderTipPaymentResponse, RiderTipPaymentDisplayModel> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ GetRiderTipPaymentUseCase f61561g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GetRiderTipPaymentUseCase$run$2(GetRiderTipPaymentUseCase getRiderTipPaymentUseCase) {
        super(1);
        this.f61561g = getRiderTipPaymentUseCase;
    }

    @NotNull
    public final RiderTipPaymentDisplayModel invoke(@NotNull RiderTipPaymentResponse riderTipPaymentResponse) {
        Intrinsics.checkNotNullParameter(riderTipPaymentResponse, "it");
        return (RiderTipPaymentDisplayModel) this.f61561g.mapper.invoke(riderTipPaymentResponse);
    }
}
