package com.talabat.restaurants.v2.ui.viewmodels;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductDisplayModel;
import com.talabat.restaurants.v2.ui.displaymodels.FeatureProductListDisplayModel;
import com.talabat.wrapper.EventWrapper;
import datamodels.RestaurantListItemModel;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import library.talabat.inlineadsengine.AdsWrapper;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020$H&J\u0010\u0010%\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u0006H&J\b\u0010&\u001a\u00020\u0015H&J0\u0010'\u001a\u00020\u00152\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\u0006\u0010,\u001a\u00020\r2\u0006\u0010-\u001a\u00020.H&J \u0010/\u001a\u00020\u00152\u0006\u0010*\u001a\u00020\u00062\u0006\u0010+\u001a\u00020\u00062\u0006\u00100\u001a\u00020.H&J\u0010\u00101\u001a\u00020\u00152\u0006\u00102\u001a\u000203H&R$\u0010\u0002\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\bR0\u0010\f\u001a \u0012\u001c\u0012\u001a\u0012\u0004\u0012\u00020\r\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\r0\u000e0\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\bR\u0018\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\n0\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010\bR\u001e\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00150\u00140\u0013X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001e\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00190\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\bR$\u0010\u001b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\bR\u0018\u0010\u001d\u001a\u00020\u0006X¦\u000e¢\u0006\f\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u00064"}, d2 = {"Lcom/talabat/restaurants/v2/ui/viewmodels/IVendorsListFragmentViewModel;", "", "inlineAds", "Landroidx/lifecycle/MutableLiveData;", "Lkotlin/Pair;", "Ldatamodels/RestaurantListItemModel;", "", "getInlineAds", "()Landroidx/lifecycle/MutableLiveData;", "loading", "", "getLoading", "sendEvent", "", "", "getSendEvent", "showNoResult", "getShowNoResult", "showPharmacyPrescription", "Landroidx/lifecycle/LiveData;", "Lcom/talabat/wrapper/EventWrapper;", "", "getShowPharmacyPrescription", "()Landroidx/lifecycle/LiveData;", "vendorList", "", "getVendorList", "vendorsSwimlanes", "getVendorsSwimlanes", "verticalId", "getVerticalId", "()I", "setVerticalId", "(I)V", "insertInlineAds", "adsWrapper", "Llibrary/talabat/inlineadsengine/AdsWrapper;", "loadVendorList", "onCleared", "sendFeatureProductClickEvent", "context", "Landroid/content/Context;", "position", "listSize", "shopClickOrigin", "featureProduct", "Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductDisplayModel;", "sendFeatureProductImpressionEvent", "featuredProduct", "sendFeatureProductsAppearedEvent", "featuredProducts", "Lcom/talabat/restaurants/v2/ui/displaymodels/FeatureProductListDisplayModel;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IVendorsListFragmentViewModel {
    @NotNull
    MutableLiveData<Pair<RestaurantListItemModel, Integer>> getInlineAds();

    @NotNull
    MutableLiveData<Boolean> getLoading();

    @NotNull
    MutableLiveData<Pair<String, Map<String, String>>> getSendEvent();

    @NotNull
    MutableLiveData<Boolean> getShowNoResult();

    @NotNull
    LiveData<EventWrapper<Unit>> getShowPharmacyPrescription();

    @NotNull
    MutableLiveData<List<RestaurantListItemModel>> getVendorList();

    @NotNull
    MutableLiveData<Pair<RestaurantListItemModel, Integer>> getVendorsSwimlanes();

    int getVerticalId();

    void insertInlineAds(@NotNull AdsWrapper adsWrapper);

    void loadVendorList(int i11);

    void onCleared();

    void sendFeatureProductClickEvent(@NotNull Context context, int i11, int i12, @NotNull String str, @NotNull FeatureProductDisplayModel featureProductDisplayModel);

    void sendFeatureProductImpressionEvent(int i11, int i12, @NotNull FeatureProductDisplayModel featureProductDisplayModel);

    void sendFeatureProductsAppearedEvent(@NotNull FeatureProductListDisplayModel featureProductListDisplayModel);

    void setVerticalId(int i11);
}
