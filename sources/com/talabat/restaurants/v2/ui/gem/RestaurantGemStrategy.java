package com.talabat.restaurants.v2.ui.gem;

import JsonModels.MenuItemsResponseModel;
import android.app.Dialog;
import datamodels.Restaurant;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\b\u0010\b\u001a\u00020\u0003H\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0012\u0010\u0010\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0003H\u0016J\b\u0010\u0012\u001a\u00020\u0003H\u0016J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0016\u001a\u00020\u0003H\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016J\u001a\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0015H\u0016J\u0010\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u0003H\u0016¨\u0006\u001f"}, d2 = {"Lcom/talabat/restaurants/v2/ui/gem/RestaurantGemStrategy;", "", "hideGemDialog", "", "response", "LJsonModels/MenuItemsResponseModel;", "hideGemDialogAndFloatingButton", "initializeViews", "leaveGemIfGemFlow", "onBackToRestaurantPage", "dialog", "Landroid/app/Dialog;", "onCloseButtonClicked", "onInterestClicked", "restaurant", "Ldatamodels/Restaurant;", "onMinimizeButtonClicked", "openGemOffer", "refreshFloatingButtonVisibility", "setFloatingGemTimer", "timer", "", "showGemDialog", "showTimeOutDialog", "showTimerView", "showTimer", "", "time", "startGemFlow", "isGemAvailable", "timeOut", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface RestaurantGemStrategy {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        public static void hideGemDialog(@NotNull RestaurantGemStrategy restaurantGemStrategy, @Nullable MenuItemsResponseModel menuItemsResponseModel) {
        }

        public static void hideGemDialogAndFloatingButton(@NotNull RestaurantGemStrategy restaurantGemStrategy) {
        }

        public static void initializeViews(@NotNull RestaurantGemStrategy restaurantGemStrategy) {
        }

        public static void leaveGemIfGemFlow(@NotNull RestaurantGemStrategy restaurantGemStrategy) {
        }

        public static void onBackToRestaurantPage(@NotNull RestaurantGemStrategy restaurantGemStrategy, @Nullable Dialog dialog) {
        }

        public static void onCloseButtonClicked(@NotNull RestaurantGemStrategy restaurantGemStrategy, @Nullable Dialog dialog) {
        }

        public static void onInterestClicked(@NotNull RestaurantGemStrategy restaurantGemStrategy, @Nullable Restaurant restaurant) {
        }

        public static void onMinimizeButtonClicked(@NotNull RestaurantGemStrategy restaurantGemStrategy, @Nullable Dialog dialog) {
        }

        public static void openGemOffer(@NotNull RestaurantGemStrategy restaurantGemStrategy) {
        }

        public static void refreshFloatingButtonVisibility(@NotNull RestaurantGemStrategy restaurantGemStrategy) {
        }

        public static void setFloatingGemTimer(@NotNull RestaurantGemStrategy restaurantGemStrategy, @Nullable String str) {
        }

        public static void showGemDialog(@NotNull RestaurantGemStrategy restaurantGemStrategy) {
        }

        public static void showTimeOutDialog(@NotNull RestaurantGemStrategy restaurantGemStrategy) {
        }

        public static void showTimerView(@NotNull RestaurantGemStrategy restaurantGemStrategy, boolean z11, @Nullable String str) {
        }

        public static void startGemFlow(@NotNull RestaurantGemStrategy restaurantGemStrategy, boolean z11) {
        }

        public static void timeOut(@NotNull RestaurantGemStrategy restaurantGemStrategy) {
        }
    }

    void hideGemDialog(@Nullable MenuItemsResponseModel menuItemsResponseModel);

    void hideGemDialogAndFloatingButton();

    void initializeViews();

    void leaveGemIfGemFlow();

    void onBackToRestaurantPage(@Nullable Dialog dialog);

    void onCloseButtonClicked(@Nullable Dialog dialog);

    void onInterestClicked(@Nullable Restaurant restaurant);

    void onMinimizeButtonClicked(@Nullable Dialog dialog);

    void openGemOffer();

    void refreshFloatingButtonVisibility();

    void setFloatingGemTimer(@Nullable String str);

    void showGemDialog();

    void showTimeOutDialog();

    void showTimerView(boolean z11, @Nullable String str);

    void startGemFlow(boolean z11);

    void timeOut();
}
