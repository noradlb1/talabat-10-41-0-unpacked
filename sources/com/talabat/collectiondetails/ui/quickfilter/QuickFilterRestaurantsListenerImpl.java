package com.talabat.collectiondetails.ui.quickfilter;

import com.talabat.talabatcore.logger.LogManager;
import datamodels.Restaurant;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH\u0016J\u0012\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\r\u001a\u00020\tH\u0016J\u0012\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\u0011"}, d2 = {"Lcom/talabat/collectiondetails/ui/quickfilter/QuickFilterRestaurantsListenerImpl;", "Lcom/talabat/collectiondetails/ui/quickfilter/QuickFilterRestaurantsListener;", "quickFilterRestaurantView", "Lcom/talabat/collectiondetails/ui/quickfilter/IQuickFilterRestaurantsView;", "(Lcom/talabat/collectiondetails/ui/quickfilter/IQuickFilterRestaurantsView;)V", "getQuickFilterRestaurantView", "()Lcom/talabat/collectiondetails/ui/quickfilter/IQuickFilterRestaurantsView;", "setQuickFilterRestaurantView", "onDarkStoresEntryFailure", "", "onDarkStoresEntrySuccess", "result", "Ldatamodels/Restaurant;", "onResponseError", "onResponseSuccess", "terms", "", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class QuickFilterRestaurantsListenerImpl implements QuickFilterRestaurantsListener {
    @Nullable
    private IQuickFilterRestaurantsView quickFilterRestaurantView;

    public QuickFilterRestaurantsListenerImpl(@Nullable IQuickFilterRestaurantsView iQuickFilterRestaurantsView) {
        this.quickFilterRestaurantView = iQuickFilterRestaurantsView;
    }

    @Nullable
    public final IQuickFilterRestaurantsView getQuickFilterRestaurantView() {
        return this.quickFilterRestaurantView;
    }

    public void onDarkStoresEntryFailure() {
        IQuickFilterRestaurantsView iQuickFilterRestaurantsView = this.quickFilterRestaurantView;
        if (iQuickFilterRestaurantsView != null) {
            iQuickFilterRestaurantsView.hideDailyTalabatLoading();
        }
        IQuickFilterRestaurantsView iQuickFilterRestaurantsView2 = this.quickFilterRestaurantView;
        if (iQuickFilterRestaurantsView2 != null) {
            iQuickFilterRestaurantsView2.darkstoreFailure();
        }
    }

    public void onDarkStoresEntrySuccess(@Nullable Restaurant restaurant) {
        IQuickFilterRestaurantsView iQuickFilterRestaurantsView = this.quickFilterRestaurantView;
        if (iQuickFilterRestaurantsView != null) {
            iQuickFilterRestaurantsView.hideDailyTalabatLoading();
        }
        IQuickFilterRestaurantsView iQuickFilterRestaurantsView2 = this.quickFilterRestaurantView;
        if (iQuickFilterRestaurantsView2 != null) {
            iQuickFilterRestaurantsView2.darkstoreSuccess(restaurant);
        }
    }

    public void onResponseError() {
        LogManager.debug("Collections response error");
    }

    public void onResponseSuccess(@Nullable String str) {
        IQuickFilterRestaurantsView iQuickFilterRestaurantsView = this.quickFilterRestaurantView;
        if (iQuickFilterRestaurantsView != null) {
            iQuickFilterRestaurantsView.termsResponseSuccess(str);
        }
    }

    public final void setQuickFilterRestaurantView(@Nullable IQuickFilterRestaurantsView iQuickFilterRestaurantsView) {
        this.quickFilterRestaurantView = iQuickFilterRestaurantsView;
    }
}
