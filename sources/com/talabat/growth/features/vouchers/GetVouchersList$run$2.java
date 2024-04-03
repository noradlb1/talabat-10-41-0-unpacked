package com.talabat.growth.features.vouchers;

import com.talabat.growth.ui.vouchers.list.model.VoucherListDisplayModel;
import com.talabat.growth.ui.vouchers.list.model.VoucherListDisplayModelMapper;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.VoucherListRootResponse;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Lcom/talabat/growth/ui/vouchers/list/model/VoucherListDisplayModel;", "it", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/VoucherListRootResponse;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GetVouchersList$run$2 extends Lambda implements Function1<VoucherListRootResponse, VoucherListDisplayModel> {
    public static final GetVouchersList$run$2 INSTANCE = new GetVouchersList$run$2();

    public GetVouchersList$run$2() {
        super(1);
    }

    @NotNull
    public final VoucherListDisplayModel invoke(@NotNull VoucherListRootResponse voucherListRootResponse) {
        Intrinsics.checkNotNullParameter(voucherListRootResponse, "it");
        return VoucherListDisplayModelMapper.INSTANCE.mapVoucherListRootResponse(voucherListRootResponse);
    }
}
