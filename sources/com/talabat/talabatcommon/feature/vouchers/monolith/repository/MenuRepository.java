package com.talabat.talabatcommon.feature.vouchers.monolith.repository;

import com.talabat.talabatcommon.feature.vouchers.monolith.model.response.GroceryItemDetails;
import com.talabat.talabatcommon.views.vouchers.applyVoucherView.model.VoucherItemsDisplayModel;
import com.talabat.talabatcore.exception.Failure;
import com.talabat.talabatcore.functional.Either;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H&J$\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H&¨\u0006\r"}, d2 = {"Lcom/talabat/talabatcommon/feature/vouchers/monolith/repository/MenuRepository;", "", "getFoodMenuItemDetails", "Lcom/talabat/talabatcore/functional/Either;", "Lcom/talabat/talabatcore/exception/Failure;", "Lcom/talabat/talabatcommon/views/vouchers/applyVoucherView/model/VoucherItemsDisplayModel;", "itemId", "", "branchId", "getGroceryItemDetails", "Lcom/talabat/talabatcommon/feature/vouchers/monolith/model/response/GroceryItemDetails;", "groceryVendorId", "sku", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface MenuRepository {
    @NotNull
    Either<Failure, VoucherItemsDisplayModel> getFoodMenuItemDetails(@NotNull String str, @NotNull String str2);

    @NotNull
    Either<Failure, GroceryItemDetails> getGroceryItemDetails(@NotNull String str, @NotNull String str2);
}
