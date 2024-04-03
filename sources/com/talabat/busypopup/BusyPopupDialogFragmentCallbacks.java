package com.talabat.busypopup;

import datamodels.Restaurant;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u001a\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH&J\b\u0010\t\u001a\u00020\u0003H&¨\u0006\n"}, d2 = {"Lcom/talabat/busypopup/BusyPopupDialogFragmentCallbacks;", "", "onBusyPopupClosed", "", "onShopClicked", "restaurant", "Ldatamodels/Restaurant;", "position", "", "viewAllRestaurantsClicked", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface BusyPopupDialogFragmentCallbacks {
    void onBusyPopupClosed();

    void onShopClicked(@Nullable Restaurant restaurant, int i11);

    void viewAllRestaurantsClicked();
}
