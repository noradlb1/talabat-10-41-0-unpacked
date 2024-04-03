package com.talabat.collectiondetails.ui.quickfilter;

import datamodels.RestaurantListModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "restaurantModel", "Ldatamodels/RestaurantListModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class QuickFilterRestaurantsPresenter$handleFilterSelection$1 extends Lambda implements Function1<RestaurantListModel, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ QuickFilterRestaurantsPresenter f55672g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public QuickFilterRestaurantsPresenter$handleFilterSelection$1(QuickFilterRestaurantsPresenter quickFilterRestaurantsPresenter) {
        super(1);
        this.f55672g = quickFilterRestaurantsPresenter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((RestaurantListModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable RestaurantListModel restaurantListModel) {
        IQuickFilterRestaurantsView view = this.f55672g.getView();
        if (view != null) {
            view.updateRestaurantList(restaurantListModel);
        }
        this.f55672g.updateViewOnRestaurantsAmount(restaurantListModel);
        IQuickFilterRestaurantsView view2 = this.f55672g.getView();
        if (view2 != null) {
            view2.hideVendorsLoading();
        }
    }
}
