package com.talabat.talabatcommon.views.vouchers.applyVoucherView.model;

import com.talabat.talabatcommon.feature.vouchers.monolith.model.response.VoucherItemsResultResponse;
import com.talabat.talabatcommon.feature.vouchers.monolith.model.response.VoucherItemsRootResponse;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherItemsDisplayModelMapper;", "", "()V", "fromVoucherItemsResultResponse", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherItemsResult;", "result", "Lcom/talabat/talabatcommon/feature/vouchers/monolith/model/response/VoucherItemsResultResponse;", "fromVoucherItemsRootResponse", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherItemsDisplayModel;", "response", "Lcom/talabat/talabatcommon/feature/vouchers/monolith/model/response/VoucherItemsRootResponse;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherItemsDisplayModelMapper {
    @NotNull
    public static final VoucherItemsDisplayModelMapper INSTANCE = new VoucherItemsDisplayModelMapper();

    private VoucherItemsDisplayModelMapper() {
    }

    private final VoucherItemsResult fromVoucherItemsResultResponse(VoucherItemsResultResponse voucherItemsResultResponse) {
        VoucherItemsResult voucherItemsResult = new VoucherItemsResult(0, (String) null, (String) null, 0.0f, (String) null, 31, (DefaultConstructorMarker) null);
        voucherItemsResult.setId(voucherItemsResultResponse.getId());
        voucherItemsResult.setName(voucherItemsResultResponse.getName());
        voucherItemsResult.setImage(voucherItemsResultResponse.getImage());
        voucherItemsResult.setPrice(voucherItemsResultResponse.getPrice());
        voucherItemsResult.setDescription(voucherItemsResultResponse.getDescription());
        return voucherItemsResult;
    }

    @NotNull
    public final VoucherItemsDisplayModel fromVoucherItemsRootResponse(@NotNull VoucherItemsRootResponse voucherItemsRootResponse) {
        Intrinsics.checkNotNullParameter(voucherItemsRootResponse, "response");
        VoucherItemsDisplayModel voucherItemsDisplayModel = new VoucherItemsDisplayModel((String) null, (VoucherItemsResult) null, (String) null, 7, (DefaultConstructorMarker) null);
        voucherItemsDisplayModel.setTimestamp(voucherItemsRootResponse.getTimestamp());
        voucherItemsDisplayModel.setResult(INSTANCE.fromVoucherItemsResultResponse(voucherItemsRootResponse.getResult()));
        voucherItemsDisplayModel.setBaseUrl(voucherItemsRootResponse.getBaseUrl());
        return voucherItemsDisplayModel;
    }
}
