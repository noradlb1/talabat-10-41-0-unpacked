package com.talabat.geminterfaces;

import android.app.Dialog;
import datamodels.Restaurant;

public interface OnGemAlertDialogClickListener {
    void onAddMoreItemClicked();

    void onBackToCheckoutPage(Dialog dialog);

    void onBackToRestaurantMenuPage(Dialog dialog);

    void onBackToRestaurantPage(Dialog dialog);

    void onCloseButtonClicked(Dialog dialog);

    void onContinueToCheckout();

    void onInterestClicked(Restaurant restaurant);

    void onLeaveOfferClicked(boolean z11);
}
