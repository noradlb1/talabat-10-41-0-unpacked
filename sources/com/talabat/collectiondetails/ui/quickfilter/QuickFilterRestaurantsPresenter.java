package com.talabat.collectiondetails.ui.quickfilter;

import com.facebook.internal.security.CertificateUtil;
import datamodels.QuickFilter;
import datamodels.Restaurant;
import datamodels.RestaurantListModel;
import datamodels.filters.SelectablePopularFilter;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\u0015\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u0016j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u0001`\u0018H\u0016J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\n\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020 H\u0016J\u0010\u0010!\u001a\u00020 2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020 H\u0016J\b\u0010%\u001a\u00020 H\u0016J\u001a\u0010&\u001a\u00020 2\u0010\u0010'\u001a\f\u0012\u0004\u0012\u00020)0(j\u0002`*H\u0016J\b\u0010+\u001a\u00020,H\u0016J\b\u0010-\u001a\u00020 H\u0016J\b\u0010.\u001a\u00020 H\u0016J\u0012\u0010/\u001a\u00020 2\b\u00100\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u00101\u001a\u00020 H\u0016J\u0012\u00102\u001a\u00020 2\b\u00103\u001a\u0004\u0018\u00010\u0017H\u0016J\u0012\u00104\u001a\u00020 2\b\u00105\u001a\u0004\u0018\u00010\u001eH\u0002R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u00066"}, d2 = {"Lcom/talabat/collectiondetails/ui/quickfilter/QuickFilterRestaurantsPresenter;", "Lcom/talabat/collectiondetails/ui/quickfilter/IQuickFilterRestaurantsPresenter;", "interactor", "Lcom/talabat/collectiondetails/ui/quickfilter/IQuickFilterRestaurantsInteractor;", "view", "Lcom/talabat/collectiondetails/ui/quickfilter/IQuickFilterRestaurantsView;", "quickFilterRestaurantsListenerImpl", "Lcom/talabat/collectiondetails/ui/quickfilter/QuickFilterRestaurantsListenerImpl;", "(Lcom/talabat/collectiondetails/ui/quickfilter/IQuickFilterRestaurantsInteractor;Lcom/talabat/collectiondetails/ui/quickfilter/IQuickFilterRestaurantsView;Lcom/talabat/collectiondetails/ui/quickfilter/QuickFilterRestaurantsListenerImpl;)V", "getInteractor", "()Lcom/talabat/collectiondetails/ui/quickfilter/IQuickFilterRestaurantsInteractor;", "setInteractor", "(Lcom/talabat/collectiondetails/ui/quickfilter/IQuickFilterRestaurantsInteractor;)V", "getQuickFilterRestaurantsListenerImpl", "()Lcom/talabat/collectiondetails/ui/quickfilter/QuickFilterRestaurantsListenerImpl;", "setQuickFilterRestaurantsListenerImpl", "(Lcom/talabat/collectiondetails/ui/quickfilter/QuickFilterRestaurantsListenerImpl;)V", "getView", "()Lcom/talabat/collectiondetails/ui/quickfilter/IQuickFilterRestaurantsView;", "setView", "(Lcom/talabat/collectiondetails/ui/quickfilter/IQuickFilterRestaurantsView;)V", "getAllCollectionRestaurants", "Ljava/util/ArrayList;", "Ldatamodels/Restaurant;", "Lkotlin/collections/ArrayList;", "getChannelIndex", "", "quickFilter", "Ldatamodels/QuickFilter;", "getCurrentCollectionRestaurants", "Ldatamodels/RestaurantListModel;", "getDarkStoresInfo", "", "getTerms", "collectionId", "", "handleCuisineSelection", "handleFilterCancel", "handleFilterSelection", "selectablePopularFilters", "", "Ldatamodels/filters/SelectablePopularFilter;", "Ldatamodels/SelectablePopularFilters;", "isComingFromMenu", "", "onDestroy", "onSearchClick", "onStart", "filter", "updateCuisines", "updateSelectedRestaurant", "restaurant", "updateViewOnRestaurantsAmount", "restaurantListModel", "com_talabat_Components_collectiondetails_collectiondetails"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QuickFilterRestaurantsPresenter implements IQuickFilterRestaurantsPresenter {
    @NotNull
    private IQuickFilterRestaurantsInteractor interactor;
    @NotNull
    private QuickFilterRestaurantsListenerImpl quickFilterRestaurantsListenerImpl;
    @Nullable
    private IQuickFilterRestaurantsView view;

    public QuickFilterRestaurantsPresenter(@NotNull IQuickFilterRestaurantsInteractor iQuickFilterRestaurantsInteractor, @Nullable IQuickFilterRestaurantsView iQuickFilterRestaurantsView, @NotNull QuickFilterRestaurantsListenerImpl quickFilterRestaurantsListenerImpl2) {
        Intrinsics.checkNotNullParameter(iQuickFilterRestaurantsInteractor, "interactor");
        Intrinsics.checkNotNullParameter(quickFilterRestaurantsListenerImpl2, "quickFilterRestaurantsListenerImpl");
        this.interactor = iQuickFilterRestaurantsInteractor;
        this.view = iQuickFilterRestaurantsView;
        this.quickFilterRestaurantsListenerImpl = quickFilterRestaurantsListenerImpl2;
    }

    /* access modifiers changed from: private */
    public final void updateViewOnRestaurantsAmount(RestaurantListModel restaurantListModel) {
        if (restaurantListModel == null || restaurantListModel.getRestaurantListCount() <= 0) {
            IQuickFilterRestaurantsView iQuickFilterRestaurantsView = this.view;
            if (iQuickFilterRestaurantsView != null) {
                iQuickFilterRestaurantsView.showNoRestaurantsFound();
            }
            IQuickFilterRestaurantsView iQuickFilterRestaurantsView2 = this.view;
            if (iQuickFilterRestaurantsView2 != null) {
                iQuickFilterRestaurantsView2.setIsSearchEnabled(false);
                return;
            }
            return;
        }
        IQuickFilterRestaurantsView iQuickFilterRestaurantsView3 = this.view;
        if (iQuickFilterRestaurantsView3 != null) {
            iQuickFilterRestaurantsView3.showRestaurantsFound();
        }
        IQuickFilterRestaurantsView iQuickFilterRestaurantsView4 = this.view;
        if (iQuickFilterRestaurantsView4 != null) {
            iQuickFilterRestaurantsView4.setIsSearchEnabled(true);
        }
    }

    @Nullable
    public ArrayList<Restaurant> getAllCollectionRestaurants() {
        return (ArrayList) this.interactor.getAllCollectionRestaurants();
    }

    @NotNull
    public String getChannelIndex(@Nullable QuickFilter quickFilter) {
        if (quickFilter == null) {
            return "";
        }
        String slug = quickFilter.getSlug();
        Integer id2 = quickFilter.getId();
        return slug + CertificateUtil.DELIMITER + id2;
    }

    @Nullable
    public RestaurantListModel getCurrentCollectionRestaurants() {
        return this.interactor.getRestaurantsModel();
    }

    public void getDarkStoresInfo() {
        IQuickFilterRestaurantsView iQuickFilterRestaurantsView = this.view;
        if (iQuickFilterRestaurantsView != null) {
            iQuickFilterRestaurantsView.showDailyTalabatLoading();
        }
        this.interactor.getDarkStoresInfo(this.quickFilterRestaurantsListenerImpl);
    }

    @NotNull
    public final IQuickFilterRestaurantsInteractor getInteractor() {
        return this.interactor;
    }

    @NotNull
    public final QuickFilterRestaurantsListenerImpl getQuickFilterRestaurantsListenerImpl() {
        return this.quickFilterRestaurantsListenerImpl;
    }

    public void getTerms(int i11) {
        if (this.view != null) {
            this.interactor.getTerms(i11, this.quickFilterRestaurantsListenerImpl);
        }
    }

    @Nullable
    public final IQuickFilterRestaurantsView getView() {
        return this.view;
    }

    public void handleCuisineSelection() {
        IQuickFilterRestaurantsView iQuickFilterRestaurantsView = this.view;
        if (iQuickFilterRestaurantsView != null) {
            iQuickFilterRestaurantsView.showVendorsLoading();
        }
        this.interactor.handleCuisineSelection(new QuickFilterRestaurantsPresenter$handleCuisineSelection$1(this));
    }

    public void handleFilterCancel() {
        this.interactor.handleFilterCancel(new QuickFilterRestaurantsPresenter$handleFilterCancel$1(this));
    }

    public void handleFilterSelection(@NotNull List<SelectablePopularFilter> list) {
        Intrinsics.checkNotNullParameter(list, "selectablePopularFilters");
        IQuickFilterRestaurantsView iQuickFilterRestaurantsView = this.view;
        if (iQuickFilterRestaurantsView != null) {
            iQuickFilterRestaurantsView.showVendorsLoading();
        }
        this.interactor.handleFilterSelection(list, new QuickFilterRestaurantsPresenter$handleFilterSelection$1(this));
    }

    public boolean isComingFromMenu() {
        return this.interactor.isComingFromMenu();
    }

    public void onDestroy() {
        this.interactor.unregister();
    }

    public void onSearchClick() {
        this.interactor.handleSearchClick();
        if (this.interactor.isNewListingSearch()) {
            IQuickFilterRestaurantsView iQuickFilterRestaurantsView = this.view;
            if (iQuickFilterRestaurantsView != null) {
                iQuickFilterRestaurantsView.navigateToVendorSeachActivity(this.interactor.getSelectedCuisineId());
                return;
            }
            return;
        }
        IQuickFilterRestaurantsView iQuickFilterRestaurantsView2 = this.view;
        if (iQuickFilterRestaurantsView2 != null) {
            iQuickFilterRestaurantsView2.navigateToRestaurantsSearchActivity();
        }
    }

    public void onStart(@Nullable QuickFilter quickFilter) {
        this.interactor.clearEngineData();
        IQuickFilterRestaurantsView iQuickFilterRestaurantsView = this.view;
        if (iQuickFilterRestaurantsView != null) {
            iQuickFilterRestaurantsView.showVendorsLoading();
        }
        this.interactor.getRestaurantsForCollection(quickFilter, new QuickFilterRestaurantsPresenter$onStart$1(this));
    }

    public final void setInteractor(@NotNull IQuickFilterRestaurantsInteractor iQuickFilterRestaurantsInteractor) {
        Intrinsics.checkNotNullParameter(iQuickFilterRestaurantsInteractor, "<set-?>");
        this.interactor = iQuickFilterRestaurantsInteractor;
    }

    public final void setQuickFilterRestaurantsListenerImpl(@NotNull QuickFilterRestaurantsListenerImpl quickFilterRestaurantsListenerImpl2) {
        Intrinsics.checkNotNullParameter(quickFilterRestaurantsListenerImpl2, "<set-?>");
        this.quickFilterRestaurantsListenerImpl = quickFilterRestaurantsListenerImpl2;
    }

    public final void setView(@Nullable IQuickFilterRestaurantsView iQuickFilterRestaurantsView) {
        this.view = iQuickFilterRestaurantsView;
    }

    public void updateCuisines() {
        this.interactor.updateCuisines();
    }

    public void updateSelectedRestaurant(@Nullable Restaurant restaurant) {
        this.interactor.updateSelectedRestaurant(restaurant);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ QuickFilterRestaurantsPresenter(IQuickFilterRestaurantsInteractor iQuickFilterRestaurantsInteractor, IQuickFilterRestaurantsView iQuickFilterRestaurantsView, QuickFilterRestaurantsListenerImpl quickFilterRestaurantsListenerImpl2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(iQuickFilterRestaurantsInteractor, iQuickFilterRestaurantsView, (i11 & 4) != 0 ? new QuickFilterRestaurantsListenerImpl(iQuickFilterRestaurantsView) : quickFilterRestaurantsListenerImpl2);
    }
}
