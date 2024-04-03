package com.talabat.growth.ui.vouchers.list.model;

import androidx.annotation.VisibleForTesting;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.extentions.StringUtils;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.request.VouchersStatusFilter;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.VoucherItemResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.VoucherListRootResponse;
import com.talabat.talabatcommon.feature.vouchers.loyalty.model.response.VouchersListResponse;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherOptionType;
import com.talabat.talabatcommon.views.vouchers.bottomSheetButton.model.VoucherItemDisplayModel;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007J\u001e\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u000e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\bH\u0007J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000bH\u0007J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\r\u001a\u00020\u0010¨\u0006\u0011"}, d2 = {"Lcom/talabat/growth/ui/vouchers/list/model/VoucherListDisplayModelMapper;", "", "()V", "getVoucherItemStatus", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/request/VouchersStatusFilter;", "status", "", "mapVoucherItemResponseList", "", "Lcom/talabat/talabatcommon/views/vouchers/bottomSheetButton/model/VoucherItemDisplayModel;", "list", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/VoucherItemResponse;", "mapVoucherListItemResponse", "it", "mapVoucherListRootResponse", "Lcom/talabat/growth/ui/vouchers/list/model/VoucherListDisplayModel;", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/model/response/VoucherListRootResponse;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VoucherListDisplayModelMapper {
    @NotNull
    public static final VoucherListDisplayModelMapper INSTANCE = new VoucherListDisplayModelMapper();

    private VoucherListDisplayModelMapper() {
    }

    @NotNull
    @VisibleForTesting
    public final VouchersStatusFilter getVoucherItemStatus(@Nullable String str) {
        VouchersStatusFilter vouchersStatusFilter = VouchersStatusFilter.ACTIVE;
        if (Intrinsics.areEqual((Object) str, (Object) vouchersStatusFilter.getValue())) {
            return vouchersStatusFilter;
        }
        VouchersStatusFilter vouchersStatusFilter2 = VouchersStatusFilter.EXPIRED;
        if (Intrinsics.areEqual((Object) str, (Object) vouchersStatusFilter2.getValue())) {
            return vouchersStatusFilter2;
        }
        VouchersStatusFilter vouchersStatusFilter3 = VouchersStatusFilter.USED;
        if (Intrinsics.areEqual((Object) str, (Object) vouchersStatusFilter3.getValue())) {
            return vouchersStatusFilter3;
        }
        return VouchersStatusFilter.ALL;
    }

    @NotNull
    @VisibleForTesting
    public final List<VoucherItemDisplayModel> mapVoucherItemResponseList(@NotNull List<VoucherItemResponse> list) {
        VoucherItemDisplayModel voucherItemDisplayModel;
        Intrinsics.checkNotNullParameter(list, DefaultCardView.CARD_LIST);
        ArrayList arrayList = new ArrayList();
        for (VoucherItemResponse voucherItemResponse : list) {
            if (voucherItemResponse != null) {
                voucherItemDisplayModel = INSTANCE.mapVoucherListItemResponse(voucherItemResponse);
            } else {
                voucherItemDisplayModel = null;
            }
            if (voucherItemDisplayModel != null) {
                arrayList.add(voucherItemDisplayModel);
            }
        }
        return arrayList;
    }

    @NotNull
    @VisibleForTesting
    public final VoucherItemDisplayModel mapVoucherListItemResponse(@NotNull VoucherItemResponse voucherItemResponse) {
        Intrinsics.checkNotNullParameter(voucherItemResponse, "it");
        VoucherItemDisplayModel voucherItemDisplayModel = new VoucherItemDisplayModel((String) null, (String) null, (VouchersStatusFilter) null, (String) null, (VoucherOptionType) null, (String) null, false, 127, (DefaultConstructorMarker) null);
        String title = voucherItemResponse.getTitle();
        String str = "";
        if (title == null) {
            title = str;
        }
        voucherItemDisplayModel.setTitle(title);
        String subtitle = voucherItemResponse.getSubtitle();
        if (subtitle == null) {
            subtitle = str;
        }
        voucherItemDisplayModel.setSubtitle(subtitle);
        String customerVoucherId = voucherItemResponse.getCustomerVoucherId();
        if (customerVoucherId != null) {
            str = customerVoucherId;
        }
        voucherItemDisplayModel.setCustomerVoucherId(str);
        VoucherOptionType voucherOptionType = voucherItemResponse.getVoucherOptionType();
        if (voucherOptionType == null) {
            voucherOptionType = VoucherOptionType.NONE;
        }
        voucherItemDisplayModel.setVoucherOptionType(voucherOptionType);
        String deeplink = voucherItemResponse.getDeeplink();
        if (deeplink == null) {
            deeplink = StringUtils.empty(StringCompanionObject.INSTANCE);
        }
        voucherItemDisplayModel.setVoucherDeepLink(deeplink);
        voucherItemDisplayModel.setStatus(INSTANCE.getVoucherItemStatus(voucherItemResponse.getStatus()));
        return voucherItemDisplayModel;
    }

    @NotNull
    public final VoucherListDisplayModel mapVoucherListRootResponse(@NotNull VoucherListRootResponse voucherListRootResponse) {
        Intrinsics.checkNotNullParameter(voucherListRootResponse, "it");
        VoucherListDisplayModel voucherListDisplayModel = new VoucherListDisplayModel(0, 0, 0, (List) null, 15, (DefaultConstructorMarker) null);
        VouchersListResponse vouchersListResponse = (VouchersListResponse) voucherListRootResponse.getResult();
        if (vouchersListResponse != null) {
            voucherListDisplayModel.setTotalCount(IntKt.orZero(vouchersListResponse.getTotalCount()));
            voucherListDisplayModel.setPageNumber(IntKt.orZero(vouchersListResponse.getPageNumber()));
            voucherListDisplayModel.setPageSize(IntKt.orZero(vouchersListResponse.getPageSize()));
            List<VoucherItemResponse> data = vouchersListResponse.getData();
            if (data != null) {
                voucherListDisplayModel.setRecords(INSTANCE.mapVoucherItemResponseList(data));
            }
        }
        return voucherListDisplayModel;
    }
}
