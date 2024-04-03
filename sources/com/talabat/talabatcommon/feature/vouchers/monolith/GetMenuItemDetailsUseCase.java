package com.talabat.talabatcommon.feature.vouchers.monolith;

import com.facebook.internal.NativeProtocol;
import com.talabat.talabatcommon.feature.vouchers.monolith.model.requestModel.GetGroceryItemDetailsRequestModel;
import com.talabat.talabatcommon.feature.vouchers.monolith.model.requestModel.GetVoucherItemsRequestModel;
import com.talabat.talabatcommon.feature.vouchers.monolith.model.response.GroceryItemDetails;
import com.talabat.talabatcommon.feature.vouchers.monolith.repository.MenuRepository;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherItemsDisplayModel;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.viewModel.VoucherFailures;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0004J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u000bH\u0004R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/monolith/GetMenuItemDetailsUseCase;", "", "menuRepository", "Lcom/talabat/talabatcommon/feature/vouchers/monolith/repository/MenuRepository;", "(Lcom/talabat/talabatcommon/feature/vouchers/monolith/repository/MenuRepository;)V", "ofFoodItem", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherItemsDisplayModel;", "params", "Lcom/talabat/talabatcommon/feature/vouchers/monolith/model/requestModel/GetVoucherItemsRequestModel;", "ofGroceryItem", "Lcom/talabat/talabatcommon/feature/vouchers/monolith/model/response/GroceryItemDetails;", "Lcom/talabat/talabatcommon/feature/vouchers/monolith/model/requestModel/GetGroceryItemDetailsRequestModel;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetMenuItemDetailsUseCase {
    @NotNull
    private final MenuRepository menuRepository;

    public GetMenuItemDetailsUseCase(@NotNull MenuRepository menuRepository2) {
        Intrinsics.checkNotNullParameter(menuRepository2, "menuRepository");
        this.menuRepository = menuRepository2;
    }

    @NotNull
    public final VoucherItemsDisplayModel ofFoodItem(@NotNull GetVoucherItemsRequestModel getVoucherItemsRequestModel) {
        Intrinsics.checkNotNullParameter(getVoucherItemsRequestModel, NativeProtocol.WEB_DIALOG_PARAMS);
        Either<Failure, VoucherItemsDisplayModel> foodMenuItemDetails = this.menuRepository.getFoodMenuItemDetails(getVoucherItemsRequestModel.getId(), getVoucherItemsRequestModel.getBranchId());
        if (foodMenuItemDetails instanceof Either.Left) {
            throw new VoucherFailures.FailToLoadFreeVoucherItems((Failure) ((Either.Left) foodMenuItemDetails).getA());
        } else if (foodMenuItemDetails instanceof Either.Right) {
            return (VoucherItemsDisplayModel) ((Either.Right) foodMenuItemDetails).getB();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public final GroceryItemDetails ofGroceryItem(@NotNull GetGroceryItemDetailsRequestModel getGroceryItemDetailsRequestModel) {
        Intrinsics.checkNotNullParameter(getGroceryItemDetailsRequestModel, NativeProtocol.WEB_DIALOG_PARAMS);
        Either<Failure, GroceryItemDetails> groceryItemDetails = this.menuRepository.getGroceryItemDetails(getGroceryItemDetailsRequestModel.getGroceryVendorId(), getGroceryItemDetailsRequestModel.getSku());
        if (groceryItemDetails instanceof Either.Left) {
            throw new VoucherFailures.FailToLoadFreeVoucherItems((Failure) ((Either.Left) groceryItemDetails).getA());
        } else if (groceryItemDetails instanceof Either.Right) {
            return (GroceryItemDetails) ((Either.Right) groceryItemDetails).getB();
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
