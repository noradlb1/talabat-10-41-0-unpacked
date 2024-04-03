package com.talabat.components.gem;

import JsonModels.MenuItemsResponseModel;
import android.app.Dialog;
import com.talabat.R;
import com.talabat.gem.adapters.presentation.restaurants.GemFloatingView;
import com.talabat.gem.domain.entities.GemRestaurant;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.restaurants.RestaurantsListScreenRefactor;
import com.talabat.restaurants.v2.ui.gem.RestaurantGemStrategy;
import datamodels.Restaurant;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import library.talabat.SharedPreferencesManager;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u000e*\u00060\u0003j\u0002`\u0004H\u0002R\u0012\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/talabat/components/gem/GemComponentRestaurantsListStrategy;", "Lcom/talabat/restaurants/v2/ui/gem/RestaurantGemStrategy;", "activity", "Lcom/talabat/restaurants/RestaurantsListScreenRefactor;", "Lcom/talabat/components/gem/Activity;", "(Lcom/talabat/restaurants/RestaurantsListScreenRefactor;)V", "initializeViews", "", "openRestaurant", "Ldatamodels/Restaurant;", "restaurant", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "startGemFlow", "isGemAvailable", "", "isFoodVertical", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemComponentRestaurantsListStrategy implements RestaurantGemStrategy {
    @NotNull
    private final RestaurantsListScreenRefactor activity;

    public GemComponentRestaurantsListStrategy(@NotNull RestaurantsListScreenRefactor restaurantsListScreenRefactor) {
        Intrinsics.checkNotNullParameter(restaurantsListScreenRefactor, "activity");
        this.activity = restaurantsListScreenRefactor;
    }

    /* access modifiers changed from: private */
    public final boolean isFoodVertical(RestaurantsListScreenRefactor restaurantsListScreenRefactor) {
        return SharedPreferencesManager.getInstance(restaurantsListScreenRefactor).getLastFavVerticalId() == 0;
    }

    /* access modifiers changed from: private */
    public final Restaurant openRestaurant(GemRestaurant gemRestaurant) {
        boolean z11;
        RestaurantsListScreenRefactor restaurantsListScreenRefactor = this.activity;
        Restaurant data = gemRestaurant.getData();
        if (data == null) {
            return null;
        }
        if (restaurantsListScreenRefactor.mPresenter == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            data = null;
        }
        if (data == null) {
            return null;
        }
        GlobalDataModel.ShopClickOrigin = "Gem";
        restaurantsListScreenRefactor.selectRestaurant(data);
        return data;
    }

    public void hideGemDialog(@Nullable MenuItemsResponseModel menuItemsResponseModel) {
        RestaurantGemStrategy.DefaultImpls.hideGemDialog(this, menuItemsResponseModel);
    }

    public void hideGemDialogAndFloatingButton() {
        RestaurantGemStrategy.DefaultImpls.hideGemDialogAndFloatingButton(this);
    }

    public void initializeViews() {
        RestaurantsListScreenRefactor restaurantsListScreenRefactor = this.activity;
        ((GemFloatingView) restaurantsListScreenRefactor.findViewById(R.id.gemFloatingView)).invoke(new GemComponentRestaurantsListStrategy$initializeViews$1$1(this, restaurantsListScreenRefactor));
    }

    public void leaveGemIfGemFlow() {
        RestaurantGemStrategy.DefaultImpls.leaveGemIfGemFlow(this);
    }

    public void onBackToRestaurantPage(@Nullable Dialog dialog) {
        RestaurantGemStrategy.DefaultImpls.onBackToRestaurantPage(this, dialog);
    }

    public void onCloseButtonClicked(@Nullable Dialog dialog) {
        RestaurantGemStrategy.DefaultImpls.onCloseButtonClicked(this, dialog);
    }

    public void onInterestClicked(@Nullable Restaurant restaurant) {
        RestaurantGemStrategy.DefaultImpls.onInterestClicked(this, restaurant);
    }

    public void onMinimizeButtonClicked(@Nullable Dialog dialog) {
        RestaurantGemStrategy.DefaultImpls.onMinimizeButtonClicked(this, dialog);
    }

    public void openGemOffer() {
        RestaurantGemStrategy.DefaultImpls.openGemOffer(this);
    }

    public void refreshFloatingButtonVisibility() {
        RestaurantGemStrategy.DefaultImpls.refreshFloatingButtonVisibility(this);
    }

    public void setFloatingGemTimer(@Nullable String str) {
        RestaurantGemStrategy.DefaultImpls.setFloatingGemTimer(this, str);
    }

    public void showGemDialog() {
        RestaurantGemStrategy.DefaultImpls.showGemDialog(this);
    }

    public void showTimeOutDialog() {
        RestaurantGemStrategy.DefaultImpls.showTimeOutDialog(this);
    }

    public void showTimerView(boolean z11, @Nullable String str) {
        RestaurantGemStrategy.DefaultImpls.showTimerView(this, z11, str);
    }

    public void startGemFlow(boolean z11) {
        RestaurantsListScreenRefactor restaurantsListScreenRefactor = this.activity;
        ((GemFloatingView) restaurantsListScreenRefactor.findViewById(R.id.gemFloatingView)).invoke(new GemComponentRestaurantsListStrategy$startGemFlow$1$1(z11, this, restaurantsListScreenRefactor));
    }

    public void timeOut() {
        RestaurantGemStrategy.DefaultImpls.timeOut(this);
    }
}
