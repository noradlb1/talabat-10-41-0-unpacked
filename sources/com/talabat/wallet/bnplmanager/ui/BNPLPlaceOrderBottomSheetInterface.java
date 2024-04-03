package com.talabat.wallet.bnplmanager.ui;

import JsonModels.PlaceOrderResponse;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0012\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H&J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\b\u0010\n\u001a\u00020\u0003H&J\b\u0010\u000b\u001a\u00020\u0003H&¨\u0006\f"}, d2 = {"Lcom/talabat/wallet/bnplmanager/ui/BNPLPlaceOrderBottomSheetInterface;", "", "cancelLoader", "", "navigateToOrderSuccessScreen", "orderResponse", "LJsonModels/PlaceOrderResponse;", "onGetBinVoucher", "binNumber", "", "placeOrderWithBNPL", "showLoader", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface BNPLPlaceOrderBottomSheetInterface {
    void cancelLoader();

    void navigateToOrderSuccessScreen(@Nullable PlaceOrderResponse placeOrderResponse);

    void onGetBinVoucher(@Nullable String str);

    void placeOrderWithBNPL();

    void showLoader();
}
