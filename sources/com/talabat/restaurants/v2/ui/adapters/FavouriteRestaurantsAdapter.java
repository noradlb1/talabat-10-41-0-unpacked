package com.talabat.restaurants.v2.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;
import com.talabat.collectiondetails.ui.restaurantlist.FreshRestaurantUiViewHolderExperiment;
import com.talabat.darkstores.data.tracking.StoreInfoTrackingProvider;
import datamodels.Restaurant;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B7\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u001a\u0010\b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t¢\u0006\u0002\u0010\fJ\b\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\nH\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\"\u0010\b\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\tX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/restaurants/v2/ui/adapters/FavouriteRestaurantsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "restaurants", "", "Ldatamodels/Restaurant;", "isCardView", "", "onVendorClickListener", "Lkotlin/Function2;", "", "", "(Ljava/util/List;ZLkotlin/jvm/functions/Function2;)V", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FavouriteRestaurantsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private final boolean isCardView;
    @NotNull
    private final Function2<Restaurant, Integer, Unit> onVendorClickListener;
    @NotNull
    private final List<Restaurant> restaurants;

    public FavouriteRestaurantsAdapter(@NotNull List<? extends Restaurant> list, boolean z11, @NotNull Function2<? super Restaurant, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(list, StoreInfoTrackingProvider.SHOP_TYPE_RESTAURANT);
        Intrinsics.checkNotNullParameter(function2, "onVendorClickListener");
        this.restaurants = list;
        this.isCardView = z11;
        this.onVendorClickListener = function2;
    }

    public int getItemCount() {
        return this.restaurants.size();
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        FreshRestaurantUiViewHolderExperiment.bind$default((FreshRestaurantUiViewHolderExperiment) viewHolder, this.restaurants.get(i11), i11, this.onVendorClickListener, (String) null, 8, (Object) null);
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        int i12;
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (this.isCardView) {
            i12 = R.layout.vendor_card_view_experiment;
        } else {
            i12 = R.layout.item_fresh_restaurant_ui_experiment;
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i12, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "itemView");
        return new FreshRestaurantUiViewHolderExperiment(inflate, this.isCardView);
    }
}
