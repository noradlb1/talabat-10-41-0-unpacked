package com.talabat.collectiondetails.ui.restaurantlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.collectiondetails.R;
import com.talabat.collectiondetails.ui.restaurantlist.RestaurantsCollectionsAdapter;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import datamodels.Restaurant;
import datamodels.RestaurantListModel;
import kotlin.Unit;
import yf.e;

public class RestaurantsListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private RestaurantsCollectionsAdapter.OnRestaurantCLickListener mListiner;
    private RestaurantListModel mRestaurantListModel;
    private int mVerticalId = 0;
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public RestaurantsListAdapter(Context context, ITalabatFeatureFlag iTalabatFeatureFlag) {
        this.mContext = context;
        this.talabatFeatureFlag = iTalabatFeatureFlag;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit lambda$onBindViewHolder$0(int i11, Restaurant restaurant, Integer num) {
        this.mListiner.onRestaurantClick(restaurant, i11);
        return Unit.INSTANCE;
    }

    public int getItemCount() {
        RestaurantListModel restaurantListModel = this.mRestaurantListModel;
        if (restaurantListModel == null) {
            return 0;
        }
        return restaurantListModel.getRestaurantListCount();
    }

    public int getItemViewType(int i11) {
        return this.mRestaurantListModel.getRestaurantListItemAtIndex(i11).type;
    }

    public RestaurantListModel getRestaurantListModel() {
        return this.mRestaurantListModel;
    }

    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i11) {
        ((FreshRestaurantUiViewHolderExperiment) viewHolder).bind(this.mRestaurantListModel.getAllRestaurants().get(i11), i11, new e(this, i11), "");
    }

    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i11) {
        return new FreshRestaurantUiViewHolderExperiment(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_fresh_restaurant_ui_experiment, viewGroup, false), false);
    }

    public void setOnRestaurantClickListener(RestaurantsCollectionsAdapter.OnRestaurantCLickListener onRestaurantCLickListener) {
        this.mListiner = onRestaurantCLickListener;
    }

    public void setRestaurantListModel(RestaurantListModel restaurantListModel, int i11) {
        this.mRestaurantListModel = restaurantListModel;
        this.mVerticalId = i11;
        notifyDataSetChanged();
    }
}
