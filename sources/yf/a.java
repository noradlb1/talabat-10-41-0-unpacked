package yf;

import android.view.View;
import com.talabat.collectiondetails.ui.restaurantlist.FreshRestaurantUiViewHolderExperiment;
import datamodels.Restaurant;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Restaurant f58002b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FreshRestaurantUiViewHolderExperiment f58003c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ FreshRestaurantUiViewHolderExperiment f58004d;

    public /* synthetic */ a(Restaurant restaurant, FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment, FreshRestaurantUiViewHolderExperiment freshRestaurantUiViewHolderExperiment2) {
        this.f58002b = restaurant;
        this.f58003c = freshRestaurantUiViewHolderExperiment;
        this.f58004d = freshRestaurantUiViewHolderExperiment2;
    }

    public final void onClick(View view) {
        FreshRestaurantUiViewHolderExperiment.m9572bindFavouriteButton$lambda5(this.f58002b, this.f58003c, this.f58004d, view);
    }
}
